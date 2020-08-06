package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MaphomePage {
	WebDriver driver;
	login lgin=new login();

	@Given("^the user is on TT Maphome page$")
	public void the_user_is_on_TT_Maphome_page()
	{
		lgin.the_user_is_on_TT_Login_page();
		lgin.user_enters_user_credentials("samuel.mathi@internationalsos.com", "Texas@123456");
		lgin.TT_homepage_should_be_displayed();
	}
	
	@When("^user clicks on alerts tab$")
	public void user_clicks_on_alerts_tab()
	{
		driver.findElement(By.cssSelector("div[id='alertsTab']")).click();
	}
	@Then("^Alert panel should be displayed$")
	public void Alert_panel_should_be_displayed()
	{
		if(driver.findElement(By.cssSelector("div[class='panelHeader']")).isDisplayed())
		{
			Assert.assertTrue(true);
		}
	}
}
