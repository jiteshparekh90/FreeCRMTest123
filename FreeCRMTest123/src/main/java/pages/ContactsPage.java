package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//span[contains(@class,'selectable')]")
	public WebElement contactsLabel;
	
	@FindBy(name = "first_name")
	public WebElement firstName;
	
	@FindBy(name = "last_name")
	public WebElement lastName;
	
	@FindBy(xpath = "//input[@placeholder='Email address']")
	public WebElement email;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	public WebElement saveBtn;
	
		
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).click();
	}
	
	public void clickOnContactsLink() {
		driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
		
	}

	public void createNewContact(String ftName, String ltName, String email1) {
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		email.sendKeys(email1);
		
		
		
		
		saveBtn.click();
		
	}
}
