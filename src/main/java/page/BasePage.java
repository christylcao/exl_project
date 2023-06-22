package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public int generateRandomNum(int bounderyNum) {
		Random rnd = new Random();
		return rnd.nextInt(bounderyNum);
		
	}
	public void selectField(WebElement element, String visibleText ) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
}
	public void waitforElement(WebDriver driver, int timeInSeconds, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
