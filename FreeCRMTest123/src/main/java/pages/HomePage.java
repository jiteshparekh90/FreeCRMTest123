package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase{

	
	
	@FindBy(xpath = "//span[@class='user-display']")
	public WebElement userNameLabel;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	public WebElement contactsLink;
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	public WebElement createContactsLink;

	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	public WebElement dealsLink;
	
	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	public WebElement tasksLink;
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() throws IOException {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() throws IOException {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() throws IOException {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		createContactsLink.click();
		
	}
}
