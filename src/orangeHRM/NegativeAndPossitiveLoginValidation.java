package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ConfigsReader;

public class NegativeAndPossitiveLoginValidation extends BaseClass {

	@BeforeMethod

	public void navigateURL() throws InterruptedException {

		setUp();

	}

	@Test
	public void negativeLogin() {

		WebElement username = driver.findElement(By.id("txtUsername"));
		sendText(username, ConfigsReader.getProperty("username"));

		WebElement login_button = driver.findElement(By.id("btnLogin"));
		click(login_button);

		String actual_message = driver.findElement(By.id("spanMessage")).getText();
		String expected_message = "Password cannot be empty";

		if (actual_message.equalsIgnoreCase(expected_message)) {

			System.out.println("Test passed!..");
		}

		else {

			System.out.println("Test failed!..");
		}

	}

	@Test()
	public void positiveLogin() throws InterruptedException {

		WebElement username = driver.findElement(By.id("txtUsername"));
		sendText(username, "Admin");

		WebElement password = driver.findElement(By.id("txtPassword"));
		sendText(password, "admin123");

		WebElement login_button = driver.findElement(By.id("btnLogin"));
		click(login_button);

		String actual_text = driver.findElement(By.cssSelector("div#branding>a>img")).getText();
		String expected_text = "OrongeHRM";

		if (expected_text.equalsIgnoreCase(actual_text)) {

			System.out.println("Test passed!..");
		}

		else {

			System.out.println("Test failed!..");
		}
	}

	@AfterMethod
	public void quitPage() throws InterruptedException {

		tearDown();

	}

}
