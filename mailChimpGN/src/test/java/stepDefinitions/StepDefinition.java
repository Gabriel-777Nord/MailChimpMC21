package stepDefinitions;

import static org.junit.Assert.assertEquals;

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
		
		//Använder sig av både mailen och en nummerslumpare för att få dynamiska email och skriver sedan in på mailchimp.
		@Given("I want to enter my {string}")
		public void i_want_to_enter_my_(String mail) {
			int numuse1 = numgen();
		    WebElement emailBox = driver.findElement(By.id("email"));
		    emailBox.sendKeys(numuse1 + mail);
		    System.out.println(numuse1 + mail);
		}
		//Använder sig av både användarnamn och en nummerslumpare för att få dynamiska användarnamn och skriver sedan in på mailchimp.
		@And("I then need to enter my {string}")
		public void i_then_need_to_enter_my_(String user) {
			WebElement userBox = driver.findElement(By.id("new_username"));
			int numuse2 = numgen();
		    userBox.sendKeys(numuse2 + user);
		    System.out.println(numuse2 + user);
		}
		
		//Skriver in ett giltigt lösenord
		@Given("I also want to enter my {string}")
		public void i_also_want_to_enter_my_(String pass) {
			WebElement passBox = driver.findElement(By.id("new_password"));
		    passBox.sendKeys(pass);
		}
		
		//klickar på Sign Up
		@When("I am done entering my info i click Sign Up")
			public void i_am_dont_entering_my_info_i_click_sign_up() {
			click(By.id("onetrust-accept-btn-handler"));
			click(By.id("create-account"));
			}

		//verifierar att man kommer till rätt sida om testfallet går igenom
		@Then("I get succes Lastly I verify with {string}")
		public void lastly_i_verify_with_(String check) {
			WebElement doable = driver.findElement(By.xpath("//*[text()='" + check + "']"));
			assertEquals(check,doable.getText());
		}
	
		//verifierar att man får rätt felmeddelande
		@Then("I get fail Lastly I verify with {string}")
		public void i_get_fail_lastly_i_verify_with(String check) {
			WebElement doable = driver.findElement(By.xpath("//*[text()='" + check + "']"));
			assertEquals(check,doable.getText());
		}


		//Slumpar fram ett tal som används fr att få lösenord och email dynamiska.
		private int numgen() {
			double num = (Math.random()*1000000);
			int number = (int) num;
			return number;
		}
		
		//Väntar max 10 sekunder eller tills elementet går att klicka på, och klickar sedan.
		private void click(By by) {
			(new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).click();
		}
}

//given conext when actions then assertion/consequenses and repeat