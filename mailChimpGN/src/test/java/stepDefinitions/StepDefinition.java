package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	private WebDriver driver;
	
		//@Before hittar Chromedriver, startar chrome, förstorar fönster och går in på mailchimp.
		@Before
		public void initiate() {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://login.mailchimp.com/signup/");
			}
		//Avslutar chrome efter testfallet.
		@After
		public void teardown() {
			driver.quit();
		}
		
		@Given("I want to enter my {string}")
		public void i_want_to_enter_my_(String mail) {
		    System.out.println("Tjena");
		    WebElement emailBox = driver.findElement(By.id("email"));
		    emailBox.sendKeys(mail);
		}

		@And("I then need to enter my {string}")
		public void i_then_need_to_enter_my_(String user) {
			System.out.println("Tjoho");
			WebElement userBox = driver.findElement(By.id("new_username"));
		    userBox.sendKeys(user);
		}
		@Given("I also want to enter my {string}")
		public void i_also_want_to_enter_my_(String pass) {
			System.out.println("Hejsan");
			WebElement passBox = driver.findElement(By.id("new_password"));
		    passBox.sendKeys(pass);
		}
		@Then("Lastly I verify")
		public void lastly_i_verify() {
			System.out.println("Ne hejdå");
		}



}
