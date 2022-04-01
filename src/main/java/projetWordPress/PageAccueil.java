package projetWordPress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageAccueil extends BandeauMenu {

	public PageAccueil(WebDriver driver) {
		super(driver);
	
	}
	
	
	@FindBy(xpath = "//h1[text() = 'Tableau de bord']")
	public WebElement titre;

}
