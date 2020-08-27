package br.com.testseleniumeasy.jussara.core;

import br.com.testseleniumeasy.jussara.util.Browser;
import br.com.testseleniumeasy.jussara.util.Log;
import br.com.testseleniumeasy.jussara.util.Property;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

/**
 * @author jussaragranja
 * Class Base for Execution
 */

public class BaseTest {
	
	public static WebDriver driver;

	//Get operating system
	public static String OS = System.getProperty("os.name").toLowerCase();

	/*
	 * Instance of a new driver
	 * Before Test
	 */
	@Before
	public void before(){
		driver = getDriver();
		driver.navigate().to(Property.URL);

	}

	/*
	 * Close driver
	 * After Test
	 */
	@After
	public void after(){
		if(driver != null){
			driver.quit();
		}
		driver = null;
	}

	/*
	 * Driver execution method
	 */
	public static WebDriver getDriver(){
		if(driver == null){
			try {
				if(Browser.CHROME.equals(Property.BROWSER_NAME)){
					System.setProperty("webdriver.chrome.driver", getFileDriverPathChrome().getAbsolutePath());
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
			} catch (Exception e){
				Log.info(e.getMessage());
			}
		}
		return driver;
	}

	//detect OS
	public static boolean isWindows(){
		return (OS.indexOf("win") >= 0);
	}

	//detect OS
	public static boolean isUnix(){
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS
				.indexOf("aix") > 0);
	}

	//Get driver file
	private static File getFileDriverPathChrome() throws Exception{
		File file = null;
		if(isWindows()){
			file = new File(Property.CHROME_DRIVE_PATH);
		}else if(isUnix()){
			file = new File(Property.CHROME_DRIVE_LINUX_PATH);
		}else
			throw new Exception("Sistema operacional nao compativel");
		return file;
	}

}
