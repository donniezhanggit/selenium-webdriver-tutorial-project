package com.softwaretestingboard.examples.execution;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import com.softwaretestingboard.config.ActionKeywords;
import com.softwaretestingboard.config.Constants;
import com.softwaretestingboard.utility.ExcelUtilsKey;
import com.softwaretestingboard.utility.Log;

public class DriverScript {

	public static Properties OR;
	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static String sPageObject;
	public static Method method[];

	public static int iTestStep;
	public static int iTestLastStep;
	public static String sTestCaseID;
	public static String sRunMode;
	public static String sData;
	public static boolean bResult;

	public DriverScript() throws NoSuchMethodException, SecurityException {
		actionKeywords = new ActionKeywords();
		method = actionKeywords.getClass().getMethods();
	}

	public static void main(String[] args) throws Exception {
		ExcelUtilsKey.setExcelFile(Constants.Path_TestData);
		// DOMConfigurator.configure("log4j.xml");
		String Path_OR = Constants.Path_OR;
		FileInputStream fs = new FileInputStream(Path_OR);
		OR = new Properties(System.getProperties());
		OR.load(fs);

		DriverScript startEngine = new DriverScript();
		startEngine.execute_TestCase();

	}

	private void execute_TestCase() throws Exception {
		// This will return the total number of test cases mentioned in the Test
		// cases sheet of DataEngine.xlsx
		int iTotalTestCases = ExcelUtilsKey.getRowCount(Constants.Sheet_TestCases);
		// This loop will execute number of times equal to Total number of test
		// cases sheet of DataEngine.xlsx
		for (int iTestcase = 1; iTestcase < iTotalTestCases; iTestcase++) {
			bResult = true;
			// This is to get the Test case name from the Test Cases sheet
			sTestCaseID = ExcelUtilsKey.getCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases);
			// This is to get the value of the Run Mode column for the current
			// test case
			sRunMode = ExcelUtilsKey.getCellData(iTestcase, Constants.Col_RunMode, Constants.Sheet_TestCases);
			if (sRunMode.equals("Yes")) {
				// This is the condition statement on RunMode value
				Log.startTestCase(sTestCaseID);
				// Only if the value of Run Mode is 'Yes', this part of code
				// will execute
				iTestStep = ExcelUtilsKey.getRowContains(sTestCaseID, Constants.Col_TestCaseID,
						Constants.Sheet_TestSteps);

				iTestLastStep = ExcelUtilsKey.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStep);
				bResult = true;
				// This loop will execute number of times equal to Total number
				// of test steps
				for (; iTestStep < iTestLastStep; iTestStep++) {
					sActionKeyword = ExcelUtilsKey.getCellData(iTestStep, Constants.Col_ActionKeyword,
							Constants.Sheet_TestSteps);
					sPageObject = ExcelUtilsKey.getCellData(iTestStep, Constants.Col_PageObject,
							Constants.Sheet_TestSteps);
					sData = ExcelUtilsKey.getCellData(iTestStep, Constants.Col_DataSet, Constants.Sheet_TestSteps);
					execute_Actions();
					if (bResult == false) {
						ExcelUtilsKey.setCellData(Constants.KEYWORD_FAIL, iTestcase, Constants.Col_Result,
								Constants.Sheet_TestCases);
						Log.endTestCase(sTestCaseID);
						break;
					}
				}
				if (bResult == true) {
					ExcelUtilsKey.setCellData(Constants.KEYWORD_PASS, iTestcase, Constants.Col_Result,
							Constants.Sheet_TestCases);
					Log.endTestCase(sTestCaseID);
				}
			}
		}
	}

	private static void execute_Actions() throws Exception {

		for (int i = 0; i < method.length; i++) {

			if (method[i].getName().equals(sActionKeyword)) {
				method[i].invoke(actionKeywords, sPageObject, sData);
				if (bResult == true) {
					ExcelUtilsKey.setCellData(Constants.KEYWORD_PASS, iTestStep, Constants.Col_TestStepResult,
							Constants.Sheet_TestSteps);
					break;
				} else {
					ExcelUtilsKey.setCellData(Constants.KEYWORD_FAIL, iTestStep, Constants.Col_TestStepResult,
							Constants.Sheet_TestSteps);
					ActionKeywords.closeBrowser("", "");
					break;
				}
			}
		}
	}

}