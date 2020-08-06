package stepDefinition;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import PageClasses.GreenkartOrderLandingpage;
import PageClasses.PlaceOrderPage;
import ResuseComponents.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenkartOrderDefinitions {

	WebDriver driver;
	GreenkartOrderLandingpage gklp;
	PlaceOrderPage popage;
	String itemname;
	

	    @Given("^user is on greenkart landin page$")
	    public void user_is_on_greenkart_landin_page() throws Throwable {
	    	BaseClass bc=new BaseClass();
	     driver=bc.initializeDriverWithURL();
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }

	    @When("^user searches for (.+) in search textbox$")
	    public void user_searches_for_in_search_textbox(String item) throws Throwable {
	    	itemname=item;
	    	gklp=new GreenkartOrderLandingpage(driver);
	    	gklp.getSearchTextbox().sendKeys(item);
	    	//driver.findElement(By.xpath("//input[@type='search']")).sendKeys(item);
	        gklp.getSearchicon().click();
	        Thread.sleep(5000);
	    }

	    @Then("^user should be able to place order for selected items$")
	    public void user_should_be_able_to_place_order_for_selected_items() throws Throwable {
	    	gklp.getCart().click();
	    	gklp.getcheckoutButton().click();
	    	popage=new PlaceOrderPage(driver);
	    	popage.getplaceOrderButton().click();
	    	Select select=new Select(driver.findElement(By.tagName("select")));
	    	select.selectByValue("India");
	    	driver.findElement(By.cssSelector("input.chkAgree")).click();
	    	driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	    }

	    @And("^places the item in the cart$")
	    public void places_the_item_in_the_cart() throws Throwable {
	    	if(gklp.getProductText().contains(itemname))
	    	{
	    		System.out.println(gklp.getProductText());
	          gklp.addTocartButton().click();
	    	}
	    	else
		      {
	    		System.out.println(gklp.getProductText());
		    	  System.out.println("product does not exist");
		    	  Assert.assertTrue(gklp.getProductText().contains(itemname));
		    	  
		      }
	    }
}
