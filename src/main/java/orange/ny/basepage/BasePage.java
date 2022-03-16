package orange.ny.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	
	public BasePage() {
		logger = Logger.getLogger("Test Lead Alam"); // Added logger
		PropertyConfigurator.configure("Log4j.properties");// Added logger
	

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream( //Serilization - read the data from config properties file
					System.getProperty("user.dir") + "/src/main/java/orange/ny/config/Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());

		} finally { // Must executed
			System.out.println("The finally statement is executed file not found");
		}

	}
	
	public static void initializations() { // setUP();
		String browserName = prop.getProperty("browserName");
		logger.info("****** Starting Chrome Browser ******");
		if (browserName.equals("chrome")) {
		
			System.setProperty("webdriver.chrome.driver", prop.getProperty("mac"));
			WebDriverManager.chromedriver().setup(); //Run without path
			driver = new ChromeDriver();

		} else if (browserName.equals("chrome")) {
		
			System.setProperty("webdriver.chrome.driver", prop.getProperty("windows"));
			driver = new ChromeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
	}


}
