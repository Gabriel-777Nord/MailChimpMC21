package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		//tjolahopp
		
		@Given("I want to enter my {string}")
		public void i_want_to_enter_my_(String mail) {
			int numuse1 = numgen();
		    WebElement emailBox = driver.findElement(By.id("email"));
		    emailBox.sendKeys(numuse1 + mail);
		    System.out.println(numuse1 + mail);
		}

		@And("I then need to enter my {string}")
		public void i_then_need_to_enter_my_(String user) {
			WebElement userBox = driver.findElement(By.id("new_username"));
			int numuse2 = numgen();
		    userBox.sendKeys(numuse2 + user);
		    System.out.println(numuse2 + user);
		}
		@Given("I also want to enter my {string}")
		public void i_also_want_to_enter_my_(String pass) {
			System.out.println("Hejsan");
			WebElement passBox = driver.findElement(By.id("new_password"));
		    passBox.sendKeys(pass);
		}
		@Then("Lastly I verify with {string}")
		public void lastly_i_verify_with_(String check) {
			clack(driver, By.id("create-account"));
			WebElement doable = driver.findElement(By.cssSelector("a[href$='" + check +"']"));
			doable.isDisplayed();
			
			System.out.println("Ne hejdå");
		}
		public static int numgen() {
			double num = (Math.random()*10000);
			int number = (int) num;
			return number;
		}
		public static void clack(WebDriver driver, By by) {
			(new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).click();
		}
}
