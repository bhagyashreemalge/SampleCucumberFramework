package PageClasses;

import java.lang.module.FindException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GreenkartOrderLandingpage {

	WebDriver driver;
	public GreenkartOrderLandingpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By searchtextbox=By.xpath("//input[@type='search']");
	By carticon=By.xpath("//a[@class='cart-icon']/img");
	By searchicon=By.cssSelector("button[type='submit']");
	By productimage=By.xpath("//div[@class='product-image']");
	By addToCartButton=By.xpath("//button[text()='ADD TO CART']");
	//By addToCartButton=By.xpath("//div[class='product-action']/button");
	By productText=By.xpath("//h4[@class='product-name']");
	By checkoutButton=By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	
	public WebElement getSearchTextbox()
	{
		return driver.findElement(searchtextbox);
	}
	public WebElement getCart()
	{
		return driver.findElement(carticon);
	}
	public WebElement getSearchicon()
	{
		return driver.findElement(searchicon);
	}
	public WebElement getproductImage()
	{
		return driver.findElement(productimage);
	}
	public String getProductText()
	{
		return driver.findElement(productText).getText();
	}
	
	public WebElement addTocartButton()
	{
		return driver.findElement(addToCartButton);
	}
	public WebElement getcheckoutButton()
	{
		return driver.findElement(checkoutButton);
	}
	
	
}
