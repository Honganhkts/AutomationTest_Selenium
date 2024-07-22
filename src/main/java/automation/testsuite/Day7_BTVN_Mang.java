package automation.testsuite;

import java.util.Scanner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;


public class Day7_BTVN_Mang extends CommonBase {
	@BeforeMethod
	public void openBrowser() {
		System.out.println("This method to open chrome browser");
	}
	@Test
	public void testCase_1() {
		String[] mang = {"Hong Anh", "Thanh Tung", "Thu Ha", "Bao Yen"};
		for (int i = 0; i < mang.length; i++) {
            String a = mang[i];
            System.out.print(a + ", ");
        }
        System.out.println();
	}
	@Test
	public void testCase_2() {
		String[] mang = {"123", "  ", "@@@", "%"};
		for (int i = 0; i < mang.length; i++) {
            String a = mang[i];
            System.out.print(a + ", ");
        }
        System.out.println();
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("This method to close chrome browser");
	}
}

	