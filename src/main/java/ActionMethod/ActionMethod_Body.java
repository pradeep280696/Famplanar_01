package ActionMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionMethod_Body {
	
	
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele);
	public void scrollByBottomPage(WebDriver drvier);
	public void clickByJavaScriptMethod(WebDriver driver, WebElement ele);
	public void type_click(WebDriver driver, WebElement ele);
	public void type_send(WebDriver driver, WebElement ele);
	public boolean isDisplayed(WebDriver driver, WebElement ele);
	public boolean isSelected(WebDriver driver, WebElement ele);
	public String getTitle(WebDriver driver);
	public String getCurrentURL(WebDriver driver);
	public String getCurrentTime();
	public String screenShots(WebDriver driver, String fileName);
	
}
