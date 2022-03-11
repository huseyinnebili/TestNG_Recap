package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BaseClass;

public class ImplicitAndExpilicitWait_herokuapp extends BaseClass {

	@BeforeMethod
	public void loginPage() throws InterruptedException {

		setUp();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test
	public void handleExample1() {

		WebElement example_button=driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[1]"));
		click(example_button);

		WebElement start_button=driver.findElement(By.xpath("//*[@id='start']/button"));
		click(start_button);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='finish']/h4"))));

		WebElement text=driver.findElement(By.xpath("//*[@id='finish']/h4"));
		getText(text);
		
	}

	@Test
	public void handleExample2() {

		WebElement example_button = driver.findElement(By.xpath("//*[@id='content']/div/a[2]"));
		click(example_button);

		WebElement start_button = driver.findElement(By.xpath("//*[@id='start']/button"));
		click(start_button);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='finish']/h4"))));

		WebElement text = driver.findElement(By.xpath("//*[@id='finish']/h4"));
		getText(text);
	}

	@AfterMethod
	public void quitPage() throws InterruptedException {

		tearDown();

	}

}
