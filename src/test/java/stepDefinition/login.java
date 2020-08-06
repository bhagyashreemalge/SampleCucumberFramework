package stepDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ResuseComponents.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login
{

WebDriver driver;
@Given("^the user is on TT Login page$")
public void the_user_is_on_TT_Login_page()
{
	BaseClass bc=new BaseClass();
	driver=bc.initializeBrowser();
	//Hooks hks=new Hooks();
	//driver=hks.initializeBrowser();
	driver.get("https://mobileqa.internationalsos.com/Mobile/MapUI/Login.aspx");
}

@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
public void user_enters_username_and_password(String strArg1, String strArg2) throws Throwable {
  driver.findElement(By.xpath("//input[@id='ctl00_MainContent_LoginUser_txtUserName']")).sendKeys(strArg1);
  driver.findElement(By.xpath("//input[@value='Continue']")).click();
  driver.findElement(By.xpath("//input[@id='ctl00_MainContent_LoginUser_txtPassword']")).sendKeys(strArg2);
  driver.findElement(By.xpath("//input[@value='Sign in']")).click();
}

@When("^user enters following details$")
public void user_enters_following_details(DataTable dt)
{
	List<String> list=dt.asList();
	driver.findElement(By.xpath("//input[@id='ctl00_MainContent_LoginUser_txtUserName']")).sendKeys(list.get(0));
	driver.findElement(By.xpath("//input[@value='Continue']")).click();
    driver.findElement(By.xpath("//input[@id='ctl00_MainContent_LoginUser_txtPassword']")).sendKeys(list.get(1));
	driver.findElement(By.xpath("//input[@value='Sign in']")).click();
}

@When("^user enters user credentials (.+) and (.+)$")
public void user_enters_user_credentials(String username,String password)
{
	driver.findElement(By.xpath("//input[@id='ctl00_MainContent_LoginUser_txtUserName']")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@value='Continue']")).click();
	  driver.findElement(By.xpath("//input[@id='ctl00_MainContent_LoginUser_txtPassword']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@value='Sign in']")).click();
}

@Then("^TT homepage should be displayed$")
public void TT_homepage_should_be_displayed()
{
	if(driver.findElement(By.xpath("//a[@id='ctl00_AdminHeaderControl_lnkMapHome']")).isDisplayed())
{
	Assert.assertTrue(true);
}
}

}
