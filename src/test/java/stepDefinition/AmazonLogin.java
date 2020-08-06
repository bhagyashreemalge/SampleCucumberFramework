package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import ResuseComponents.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonLogin{

	WebDriver driver;
	Actions actions;
	
	@Given("the user have browser")
	public void the_user_have_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("user has the browser");
	}

	@When("user clicks on browser")
	public void user_clicks_on_browser() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@Then("browser should be opened")
	public void browser_should_be_opened() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}

	@Given("the user is on Amazon home page")
	public void the_user_is_on_amazon_home_page() {
	   if(driver.getTitle().contains("amazon"))
	   {
		   System.out.println("amazon homepage is displayed");
	   }
		
	}

	@When("user clicks on signin link")
	public void user_clicks_on_signin_link() {
		actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
	   // actions.doubleClick(driver.findElement(By.xpath("/a[@id='nav-link-accountList']")));
		actions.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).click().build().perform();
		//actions.doubleClick(driver.findElement(By.xpath("//span[text()='Hello, Sign in']"))) ;
	}
	@And("enters valid user credentials")
	public void enters_valid_user_credentials() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("9945483538");
	    driver.findElement(By.xpath("//input[@id='continue']")).click();
	    driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("9945483538");
	    driver.findElement(By.cssSelector("input[id='signInSubmit']")).click();
	}
	
	@Then("Amazon homepage should be displayed")
	public void amazon_homepage_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@And("logged in profile should be displayed")
	public void logged_in_profile_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	



}
