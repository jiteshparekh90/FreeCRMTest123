package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {
	
	//page Factory  - OR:
		@FindBy(name = "email")
	    public WebElement username;
		
		@FindBy(name = "password")
		public WebElement password;
		
		@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
		public WebElement loginBtn;
		
		@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
		public WebElement signUpBtn;

		//Initializing the page Objects:
		public LoginPage() throws IOException {
		
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
	}
		
		public void openBrowserPage() throws IOException {
			initialization();
			PageFactory.initElements(driver, this);
		}
		
		public void closeBrowser() {
			driver.close();
		}
		
		//Actions:
		public String validationLoginPageTitle() {
			return driver.getTitle();
		}
		
		public HomePage login(String un, String pwd) throws InterruptedException, IOException {
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			Thread.sleep(3000);
			return new HomePage();
			
			
			
			
		}
	
	

	
}
