package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BaseClass;

public class TitleAndLoginValidation extends BaseClass {

	@BeforeMethod
	public void openAndNavigate() throws InterruptedException {

		setUp()

	}

	@Test
	public void titleValidation() throws Exception {

		String exp_title = "OrangeHRM";

		String actual_title = driver.getTitle();

		if (exp_title.equals(actual_title)) {

			System.out.println("Title Validation passed!..");
		}

		else {

			System.out.println("Title Validation failed!");

			throw new Exception();
		}

	}

	@Test
	public void logoValidation() {

		WebElement logo = driver.findElement(By.xpath("//*[@id='divLogo']/img"));

		boolean isDisplayed = logo.isDisplayed();

		System.out.println(isDisplayed);

		if (isDisplayed) {

			System.out.println("Logo Validation passed!..");
		}

		else {

			System.out.println("Logo Validation failed!..");
		}
	}

	@Test
	public void loginValidation() {

		WebElement username = driver.findElement(By.id("txtUsername"));
		sendText(username, "Admin");

		WebElement password = driver.findElement(By.id("txtPassword"));
		sendText(password, "admin123");

		WebElement login = driver.findElement(By.id("btnLogin"));
		click(login);

	}

	@AfterMethod
	public void quitBrowser() throws InterruptedException {

		tearDown();
	}

}
