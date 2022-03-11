package utils;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;

	/**
	 * This method will create the driver and return it
	 * 
	 * @return WebDriver driver;
	 * @throws InterruptedException
	 */

	public static WebDriver setUp() throws InterruptedException {

		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		switch (ConfigsReader.getProperty("browser").toLowerCase()) {

		case "chrome":

			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);

			driver = new ChromeDriver();

			break;

		case "firefox":

			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);

			driver = new FirefoxDriver();

			break;

		default:

			throw new RuntimeException("Browser is not supported!..");

		}

		driver.get(ConfigsReader.getProperty("url"));

		driver.manage().window().maximize();

		Thread.sleep(2000);

		return driver;
	}

	public static void brokenlinks() throws IOException {

		List<WebElement> list_of_links = driver.findElements(By.tagName("a"));

		for (WebElement list_of_link : list_of_links) {

			String url = list_of_link.getAttribute("href");

			try {

				URL link = new URL(url);

				HttpURLConnection connect = (HttpURLConnection) link.openConnection();

				connect.connect();

				int status_code = connect.getResponseCode();

				if (status_code >= 400) {

					System.out.println(url + " is broken link!.");

				} else {

					System.out.println(url + " is valid link!.");
				}

			} catch (MalformedURLException e) {

				e.printStackTrace();
			}

		}

	}

	/**
	 * 
	 * This method will quit the browser
	 * 
	 * @throws IOException
	 *
	 */

	public static void takescreenshot(String folder_name, String file_name) throws IOException {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("C:\\Users\\husey\\eclipse-workspace\\Selenium_Recap\\Screenshots\\"
				+ folder_name + "/" + file_name + ".png"));

	}

	public static void tearDown() throws InterruptedException {

		if (driver != null) {

			Thread.sleep(2000);

			driver.quit();

		}

	}

	public static void sendText(WebElement element, String value) {

		element.clear();

		element.sendKeys(value);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}
}
