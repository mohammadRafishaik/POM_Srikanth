package com.TestRunner;

import org.testng.annotations.Test;

import com.Commanmethods.Baseclass;
import com.Testcases.HRM_TestCases;

public class Test1 extends Baseclass {
	@Test
	public static void executionwindow() throws Exception {
		logger=report.createTest("HRM Test Case");
		HRM_TestCases.testcase1();
	}

}
