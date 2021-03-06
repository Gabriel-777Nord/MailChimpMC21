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
	
		//@Before hittar Chromedriver, startar chrome, f?rstorar f?nster och g?r in p? mailchimp.
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
		
		//Anv?nder sig av b?de mailen och en nummerslumpare f?r att f? dynamiska email och skriver sedan in p? mailchimp.
		@Given("I want to enter my {string}")
		public void i_want_to_enter_my_(String mail) {
		    if(mail.equals("blank")) {
		    	
		    }
		    else {
		    	WebElement emailBox = driver.findElement(By.id("email"));
		    	int numuse1 = numgen();
			    emailBox.sendKeys(numuse1 + mail);
			    System.out.println(numuse1 + mail);
		    }
		}
		//Anv?nder sig av b?de anv?ndarnamn och en nummerslumpare f?r att f? dynamiska anv?ndarnamn och skriver sedan in p? mailchimp.
		@And("I then enter my {string}")
		public void i_then_enter_my_(String user) {
			WebElement userBox = driver.findElement(By.id("new_username"));
			if (user.equals("generiskanvandare")) {
				userBox.sendKeys(user);
				System.out.println(user);
			}
			else {
				int numuse2 = numgen();
			    userBox.sendKeys(numuse2 + user);
			    System.out.println(numuse2 + user);
			}
		}
		
		//Skriver in ett giltigt l?senord
		@And("I also enter my {string}")
		public void i_also_enter_my_(String pass) {
			WebElement passBox = driver.findElement(By.id("new_password"));
		    passBox.sendKeys(pass);
		}
		
		//klickar p? Sign Up
		@When("I am done entering my info I click Sign Up")
			public void i_am_dont_entering_my_info_i_click_sign_up() {
			click(By.id("onetrust-accept-btn-handler"));
			click(By.id("create-account"));
			}

		//verifierar att man kommer till r?tt sida om testfallet g?r igenom
		@Then("I decide if test should give error or not with succes and lastly I verify with {string}")
		public void verify1(String check) {
			WebElement doable = driver.findElement(By.xpath("//*[text()='" + check + "']"));
			assertEquals(check,doable.getText());
		}
	
		//verifierar att man f?r r?tt felmeddelande
		@Then("I decide if test should give error or not with fail and lastly I verify with {string}")
		public void verify2(String check) {
			WebElement doable = driver.findElement(By.xpath("//*[contains(text(),'" + check + "')]"));
			assertEquals(true,doable.isDisplayed());
		}


		//Slumpar fram ett tal som anv?nds fr att f? l?senord och email dynamiska.
		private int numgen() {
			double num = (Math.random()*1000000);
			int number = (int) num;
			return number;
		}
		
		//V?ntar max 10 sekunder eller tills elementet g?r att klicka p?, och klickar sedan.
		private void click(By by) {
			(new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).click();
		}
}