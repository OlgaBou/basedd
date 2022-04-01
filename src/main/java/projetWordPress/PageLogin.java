package projetWordPress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin extends BandeauMenu {

	public PageLogin(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(xpath = "//form[@id='loginform']")
	public WebElement loginform;
	@FindBy(xpath = "//input[@id='user_login']")
	public WebElement username_field;
	@FindBy(xpath = "//input[@id='user_pass']")
	public WebElement password_field;
	@FindBy(xpath = "//input[@id='wp-submit']")
	public WebElement submit_button;

	public PageAccueil logIn(WebDriver driver, String username, String password) {
		username_field.clear();
		username_field.sendKeys(username);
		password_field.clear();
		password_field.sendKeys(password);
		submit_button.click();
		return PageFactory.initElements(driver, PageAccueil.class);

	}

}
