package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelRead;

public class LoginTest {

	WebDriver driver;
	ExcelRead exlRead = new ExcelRead("testData\\myPrac.xlsx");

	String username = exlRead.getCellData("New Students", "UserName", 2);
	String password = exlRead.getCellData("New Students", "Password", 2);
	
	@Test
	public void userShouldBeAbleToLogin() {
		
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUsername(username);
		loginPage.insertPassword(password);
		loginPage.clickSubmit();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();
		
	}
	
}
