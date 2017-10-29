package com.softwaretestingboard.examples.testng;

import org.testng.annotations.Test;

public class MultipleTestExample {

	@Test(priority = 5)

	public void One() {

		System.out.println("This is the Test Case number One");

	}

	@Test(priority = 4)

	public void Two() {

		System.out.println("This is the Test Case number Two");

	}

	@Test(priority = 3)

	public void Three() {

		System.out.println("This is the Test Case number Three");

	}

	@Test(priority = 2)

	public void Four() {

		System.out.println("This is the Test Case number Four");

	}

	@Test(priority = 1, enabled = false)

	public void Five() {

		System.out.println("This is the Test Case number Five");

	}

	@Test(priority = 0)

	public void Six() {

		System.out.println("This is the Test Case number Six");

	}
}
