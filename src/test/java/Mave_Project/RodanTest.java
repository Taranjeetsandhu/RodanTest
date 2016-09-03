package Mave_Project;




import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@Listeners(MyListeners.class)
public class RodanTest {


	static WebDriver driver=new FirefoxDriver();
	RodanFieldsPage rodanFields=new RodanFieldsPage(driver);
	EnrollNowPage enrollNow=new EnrollNowPage(driver);

	@BeforeMethod
	@BeforeClass
	public void setUp() throws InterruptedException{

		driver.manage().window().maximize();
		driver.get("https://www.rodanandfields.com/ca/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}
	@Test
	public void rodanFieldsTest1() throws InterruptedException{
		rodanFields.shopCare();
		Assert.assertTrue(rodanFields.verifyUrl().contains("quickShop"), "incorrect");
		rodanFields.selectRedefine();
		Assert.assertTrue(rodanFields.verifyLabel1(), "Labels not matching");
		Assert.assertTrue(rodanFields.verifyLabel2(), "Labels not matching");
		//rodanFields.quitBrowser1();
		
	}


	@Test
	public void rodanFieldsTest2() throws InterruptedException{	
		
		enrollNow.enroll();
		enrollNow.switchToProcedure();
		Assert.assertTrue(enrollNow.verifyProcedureURL().contains("Policies_Procedures_CANADA."), "incorrect");
		enrollNow.closeProcedure();
		enrollNow.switchAndSearch();
		AssertJUnit.assertEquals(enrollNow.AfterSelection(), enrollNow.beforeSelection(), "Names do not match");
		enrollNow.quitBrowser2();
	}
}






