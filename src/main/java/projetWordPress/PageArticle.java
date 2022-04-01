package projetWordPress;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageArticle extends BandeauMenu {

	public PageArticle(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//h1[@contenteditable='true']")
	public WebElement titreCreationArticle;
	@FindBy(xpath = "//p[@role='document']")
	public WebElement textCreationArticle;
	@FindBy(xpath = "//button[@aria-label='Fermez la boite de dialogue']")
	public WebElement closePopup;
	@FindBy(xpath = "//button[text() ='Publier']")
	public WebElement buttonPublish;
	@FindBy(xpath = "//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary']")
	public WebElement buttonPublish2;

	
	public void addArticle() throws Exception {
		
		closePopup.click();
		titreCreationArticle.sendKeys("new title");
		titreCreationArticle.sendKeys(Keys.ENTER);
		textCreationArticle.sendKeys("Lorem ipsum dolor sit amet.");
		textCreationArticle.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		buttonPublish.click();
		
		Thread.sleep(2000);
		buttonPublish2.click();
		
		
	}

}
