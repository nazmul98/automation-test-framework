package orange.ny.stepdef;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import cucumber.api.java.en.*;
import orange.ny.basepage.BasePage;
import orange.ny.elementpage.ElementPageFactory;
import orange.ny.utility.CommonUtility;

public class LoginStepDefTest extends BasePage {
	ElementPageFactory pf;

	// I am writing the Stepdefinition by my self using regular expression
	@Given("^User enter the userName and password$")
	public void user_enter_the_userName_and_password() {
		// BasePage.initializations();
		pf = PageFactory.initElements(driver, ElementPageFactory.class);
		// pf = new ZooplaElementsPage(driver);
		logger.info("****** Entered Username ******");
		CommonUtility.waitForElement(pf.getEnterUserName(), 30);
		pf.getEnterUserName().sendKeys(prop.getProperty("userName"));
		logger.info("****** Entered Password ******");
		CommonUtility.waitForElement(pf.getEnterPassword(), 30);
		pf.getEnterPassword().sendKeys(prop.getProperty("password"));

	}

	@When("^User click on the login button$")
	public void user_click_on_the_login_button() {
		CommonUtility.waitForElement(pf.getClickOnLogin(), 30);
		logger.info("****** Sign In Application ******");
		pf.getClickOnLogin().click();

	}

	@Then("^User able to verify successfully login & verify the homepage title$")
	public void user_able_to_verify_successfully_login_verify_the_homepage_title() {
		logger.info("****** Verify the page title ******");
		String expected = "OrangeHRM";
		String actual = driver.getTitle();
		
		Assert.assertEquals(actual, expected);
		System.out.println("The title of the page is :" + actual);

	}

}
