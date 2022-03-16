package orange.ny.elementpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orange.ny.basepage.BasePage;

public class ElementPageFactory extends BasePage {
	//Difference between super and this. Super is parent class property, this is current class
	public ElementPageFactory() {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "txtUsername")
	@CacheLookup //use computer cache memory
	private WebElement enterUserName;
	
	@FindBy(id = "txtPassword")
	@CacheLookup
	private WebElement enterPassword;

	@FindBy(id = "btnLogin")
	@CacheLookup
	private WebElement clickOnLogin;

	public WebElement getEnterUserName() {
		return enterUserName;
	}

	public WebElement getEnterPassword() {
		return enterPassword;
	}

	public WebElement getClickOnLogin() {
		return clickOnLogin;
	}


}
