package ActionInterface;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ActionMethod.ActionMethod_Body;
import base.BaseClass;

public class ActionInterface_definition extends BaseClass implements ActionMethod_Body{


	@Override
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}

	@Override
	public void type_click(WebDriver driver, WebElement ele) {
		Actions act = new Actions (driver);
		act.moveToElement(ele).build().perform();
	}
	
	@Override
	public void clickByJavaScriptMethod(WebDriver driver, WebElement ele) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementByID('"+ ele +"').click()");
	}

	@Override
	public void type_send(WebDriver driver, WebElement ele) {
		
		
	}

	@Override
	public boolean isDisplayed(WebDriver driver, WebElement ele) {
		
		return false;
	}

	@Override
	public boolean isSelected(WebDriver driver, WebElement ele) {
		
		return false;
	}



	@Override
	public void scrollByBottomPage(WebDriver drvier) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	@Override
	public String getTitle(WebDriver driver) {

		return driver.getTitle();
	}

	@Override
	public String getCurrentURL(WebDriver driver) {

      return driver.getCurrentUrl();	
	}

	@Override
	public String getCurrentTime() {
		
		String currentTime = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentTime;
	}

	@Override
	public String screenShots(WebDriver driver, String fileName) {

		String dateName = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		TakesScreenshot scn = (TakesScreenshot) driver;
		File source = scn.getScreenshotAs(OutputType.FILE);
		String screenshot_path = System.getProperty("C:\\Selenium\\Famplanr\\Screenshot"+ fileName + "_"+ dateName+".png");
		return dateName;
	}
}
