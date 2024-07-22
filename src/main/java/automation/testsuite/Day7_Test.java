package automation.testsuite;
import org.testng.annotations.*;
import automation.common.CommonBase;
public class Day7_Test extends CommonBase{
	@BeforeMethod
	public void openBrowser() {
		System.out.println("This method to open chrome browser");
	}
	@Test
	public void testCase_1() {
		System.out.println("This method to implement for testcas1");
	}
	@AfterMethod
	public void closeBrowser() {
		System.out.println("This method to close chrome browser");
	}
	
}
