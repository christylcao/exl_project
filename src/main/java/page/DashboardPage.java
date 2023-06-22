package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {

	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	@FindBy(how = How.XPATH, using = "//h2[text()=' Dashboard ']") WebElement DASHBOARD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Customers')]") WebElement CUSTOMER_MENU_FIELD;
	@FindBy(how = How.XPATH, using = "/html/body/section/div/nav/div/ul/li[3]/ul/li[1]/a") WebElement ADD_CUSTOMER_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a") WebElement LIST_CUSTOMER_ELEMENT;
	
	public void validateDashboardPage() {
		Assert.assertEquals(DASHBOARD_ELEMENT.getText(), "Dashboard", "Dashboard page not page!");
	}

	public void clickOnCustomerMenu () {
		CUSTOMER_MENU_FIELD.click();
		
	}
	public void clickOnAddCustomer () {
		ADD_CUSTOMER_FIELD.click();
}
	public void clickonListCustMenu() throws InterruptedException {
 		Thread.sleep(2000);
 		LIST_CUSTOMER_ELEMENT.click();
	}
}