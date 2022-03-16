package orange.ny.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import orange.ny.basepage.BasePage;

public class Hooks extends BasePage {
	@Before
	public void setUp() {
		logger.info("****** Start Automation ******");		
		initializations();	
	}
	@After
	public void tearDown() {
		logger.info("****** End Automation ******");
		driver.quit();
		//driver.close();
	}
}
