package skeleton;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Cucumber_FirstDemo {
	WebDriver driver;
	
	@Given("online testme is open")
	public void online_testme_is_open() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Renuka Sabe\\Desktop\\gft training\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm ");
		Thread.sleep(1000);
	}

	@When("Lalitha gives valid username password")
	public void lalitha_gives_valid_username_password() throws Throwable {
		driver.findElement(By.linkText("SignIn")).click();
		driver.findElement(By.name("userName")).sendKeys("Lalitha");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();
		Thread.sleep(2000);
		
	}

	@Then("he is able to see the hpome page")
	public void he_is_able_to_see_the_hpome_page() {
	   String LoginName=driver.findElement(By.cssSelector("ul.nav")).getText();
	   Assert.assertTrue(LoginName.contains("Lalitha"));
	   System.out.println("test is passed");
	   driver.findElement(By.linkText("SignOut")).click();
	}



}
