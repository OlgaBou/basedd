package projetWordPress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BandeauMenu {
public WebDriver driver;
	
	public BandeauMenu(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath = "//span[text() = 'Créer']")
	public WebElement buttonCreer;
	
	
	public PageArticle createArticle(WebDriver webdriver) throws Exception {
		
		//buttonCreer.click();
		
		Actions action = new Actions(webdriver);
		WebElement menuCreation = webdriver.findElement(By.xpath("//span[text() = 'Créer']"));
		action.moveToElement(menuCreation).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@id = 'wp-admin-bar-new-content']")).click();
		return PageFactory.initElements(driver, PageArticle.class);
}
	
}


