package com.qait.training.tests;

import org.testng.annotations.Test;

import com.qait.training.init.TestSessionInitiator;

public class LoginPageTest {
	TestSessionInitiator test;

	public LoginPageTest() {
		test = new TestSessionInitiator();
	}

	@Test
	public void Test01_verifyUserCanSuccessfullyLogin() throws InterruptedException {

		test.loginPageAction.submitLoginDetails();

	}
}
