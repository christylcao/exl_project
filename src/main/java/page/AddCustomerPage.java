package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;
	
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]") WebElement ADD_FULL_NAME;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]") WebElement COMPANY_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='email']") WebElement EMAIL_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']") WebElement PHONE_NUMBER_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id='country']") WebElement COUNTRY_FIELD;
	@FindBy(how = How.XPATH, using = "//h5[contains(text(), 'Add Contact')]") WebElement ADD_CUSTOMER_HEADER_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='city']") WebElement CITY_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='address']") WebElement ADDRESS_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]") WebElement ZIP_CODE_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]") WebElement STATE_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]") WebElement SUBMIT_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]") WebElement SUCCESSFUL_DELETION;

	
 	public void validateAddCustomerPage() {
 		Assert.assertEquals(ADD_CUSTOMER_HEADER_FIELD.getText(), "Add Contact", "ADD CUSTOMER PAGE NOT FOUND!");
 	}
 	
 	String insertName;
 	public void insertFullName(String fullName) {
 		insertName = fullName + generateRandomNum(999);
 		ADD_FULL_NAME.sendKeys(insertName);
 	}
 	public void selectCompanyName(String company) {
 		selectField(COMPANY_FIELD, company);
	}
 	public void insertEmail(String email) {
 		EMAIL_FIELD.sendKeys(generateRandomNum(999)+ email);
 	}
 	public void insertPhoneNum(String phone) {
 		PHONE_NUMBER_FIELD.sendKeys(phone);
 	}
 	public void selectCountryName(String country) {
 		selectField(COUNTRY_FIELD, country);
 	}
 	public void insertCity(String city) {
 		CITY_FIELD.sendKeys(city);
 	}
 	public void insertAddress(String address) {
 		ADDRESS_FIELD.sendKeys(address);
 	}
 	public void insertState(String state) {
 		STATE_FIELD.sendKeys(state);
 	}
 	public void insertZip (String zip) {
 		ZIP_CODE_FIELD.sendKeys(zip);
 	}
 	public void clickonSubmit() {
 		SUBMIT_BUTTON.click();
 	
 	}
 	
 	//tbody/tr[1]/td[3]/a
 	//tbody/tr[1]/td[7]/a[2]
 	
 	String before_xpath = "//tbody/tr[";
 	String after_xpath = "]/td[3]/a";
 	String delete_xpath = "]/td[7]/a[2]";
 	
 	public void validateInsertAndDelete() {
 		for(int i=1; i<=5; i++) {
 			String nameFromList = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
 			if(nameFromList.contains(insertName)) {
 				System.out.println("inserted name exist...");
 				driver.findElement(By.xpath(before_xpath + i + delete_xpath)).click();
 			}
 		}
	}
 	
	public void clickOnDeleteAlert() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button[2]")).click();
		Thread.sleep(2000);
	
	}
}