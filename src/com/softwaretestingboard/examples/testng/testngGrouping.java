package com.softwaretestingboard.examples.testng;

import org.testng.annotations.Test;

public class testngGrouping {

	@Test(groups = { "Doctor" })

	public void doctor1() {

		System.out.println("Batch test - Test in a my city accross all categories accross physician & Gynecologist");

	}

	@Test(groups = { "physician" })

	public void physician1() {

		System.out.println("Batch test for - physician  in the city");

	}

	@Test(groups = { "Gynecologist" })

	public void Gynecologist1() {

		System.out.println("Batch test for - Gynecologist doctor's in the city");

	}

	@Test(groups = { "Doctor", "M G road Mumbai" })

	public void MGRoad() {

		System.out.println("Batch test to validate all the doctor listed in M.G.Road Mumbai");

	}

}
