package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlaceOrderPage {
	WebDriver driver;
	
	By placeorderButton=By.xpath("//button[text()='Place Order']");
	public PlaceOrderPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getplaceOrderButton()
	{
		return driver.findElement(placeorderButton);
	}

}
