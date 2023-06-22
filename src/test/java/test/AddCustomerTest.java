package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.BasePage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelRead;

public class AddCustomerTest extends BasePage {

	WebDriver driver;
	ExcelRead exlRead = new ExcelRead("testData\\myPrac.xlsx");
	String username = exlRead.getCellData("New Students", "UserName", 2);
	String password = exlRead.getCellData("New Students", "Password", 2);
	String name = exlRead.getCellData("Back UP Data", "Name", 2);
	String company = exlRead.getCellData("Back UP Data", "Company", 2);
	String email = exlRead.getCellData("Back UP Data", "Email", 2);
	String country = exlRead.getCellData("Back UP Data", "Country", 2);
	String phone = exlRead.getCellData("Back UP Data", "Phone", 2);	
	String address = exlRead.getCellData("Back UP Data", "Address", 2);
	String city = exlRead.getCellData("Back UP Data", "City", 2);
	String state = exlRead.getCellData("Back UP Data", "State", 2);
	String zip = exlRead.getCellData("Back UP Data", "Zip", 2);
	
	@Test
	public void userShouldBeAbleAddCustomer() throws InterruptedException {
		
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUsername(username);
		loginPage.insertPassword(password);
		loginPage.clickSubmit();
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();
		Thread.sleep(2000);
		dashboardPage.clickOnCustomerMenu();
		dashboardPage.clickOnAddCustomer();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddCustomerPage();
		Thread.sleep(2000);
		addCustomerPage.insertFullName(name);
		addCustomerPage.selectCompanyName(company);
		addCustomerPage.insertEmail(generateRandomNum(9) + email);
		addCustomerPage.insertPhoneNum(phone + generateRandomNum(99));
		addCustomerPage.selectCountryName(country);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.clickonSubmit();
		
		dashboardPage.clickonListCustMenu();
		
		Thread.sleep(2000);
		addCustomerPage.validateInsertAndDelete();
		
		addCustomerPage.clickOnDeleteAlert();
		
	}
	
}
