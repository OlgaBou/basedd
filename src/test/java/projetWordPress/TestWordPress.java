package projetWordPress;

import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestWordPress {

	WebDriver driver;
	WebDriverWait wait;

	@Before

	public void setup() {
		/*
		 * String browser = System.getProperty("Navigateur"); // String browser = ""; if
		 * (browser.equalsIgnoreCase("firefox")) {
		 * System.setProperty("webdriver.gecko.driver",
		 * "src/main/resources/driver/geckodriver.exe"); driver = new FirefoxDriver(); }
		 * 
		 * else if (browser.equalsIgnoreCase("chrome")) {
		 * System.setProperty("webdriver.chrome.driver",
		 * "src/main/resources/driver/chromedriver.exe"); driver = new ChromeDriver(); }
		 * 
		 * else if(browser.equalsIgnoreCase("edge")){
		 * System.setProperty("webdriver.edge.driver",
		 * "src/main/resources/driver/msedgedriver.exe"); driver = new EdgeDriver();
		 * 
		 * } else { System.setProperty("webdriver.chrome.driver",
		 * "src/main/resources/driver/chromedriver.exe"); driver = new ChromeDriver(); }
		 */

		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After

	public void shutdown() {
		driver.quit();
	}

	@Test

	public void testCreationArticle() throws Exception, ClassNotFoundException, SQLException {

		wait = new WebDriverWait(driver, 15);
		driver.get("http://localhost/wordpress-5.9.2/wordpress/wp-admin/index.php");

		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);

		PageAccueil page_accueil = page_login.logIn(driver, "wordpress", "wordpress");

		PageArticle page_article = page_accueil.createArticle(driver);

		page_article.addArticle();
		
		Thread.sleep(1000);

		String dbUrl = "jdbc:mysql://localhost:3306/wordpress";

		// Database Username
		String username = "wordpress";

		// Database Password
		String password = "wordpress";

		// Query to Execute
		String query = "DELETE FROM wp_posts WHERE post_title = 'new title';";

		// Load mysql jdbc driver
		Class.forName("com.mysql.jdbc.Driver");

		// Create Connection to DB
		java.sql.Connection con = DriverManager.getConnection(dbUrl, username, password);

		// Create Statement Object
		java.sql.Statement stmt = con.createStatement();

		// Execute the SQL Query. Store results in ResultSet
		int rs = stmt.executeUpdate(query);
		System.out.println(rs+" rows updated");
		// While Loop to iterate through all data and print results
		/*
		 * while (rs.next()){ String myName = rs.getString(1); String myAge =
		 * rs.getString(2); System. out.println(rs); }
		 */
		// closing DB Connection
		con.close();
	}

}
