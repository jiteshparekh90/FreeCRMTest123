package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String SheetName = "contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority =1)
	public void verifyContactsLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page" );
	}
	
	@Test(priority = 2)
	public void selectContactsTest() {
		contactsPage.selectContactsByName("jitesh parekhdsd");
	}
	
	@Test(priority = 3)
	public void selectMulitipleContactsTest() {
		contactsPage.selectContactsByName("jitesh parekhdsd");
		contactsPage.selectContactsByName("sasasa dsfdfdf");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(SheetName);
		return data;
	}
	
	@Test(priority  = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String firstName, String lastName, String email) throws IOException {
		contactsPage.clickOnContactsLink();
		//contactsPage.createNewContact("Tom", "Peter", "xyz@123");
		contactsPage.createNewContact(firstName, lastName, email);
		
	}
	
	@AfterMethod
	public void tearDown() {
		loginPage.closeBrowser();
	}
}
