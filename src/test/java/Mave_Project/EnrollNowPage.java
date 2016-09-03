package Mave_Project;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
public class EnrollNowPage {

	WebDriver driver;
	String beforeSelection;
	String	Parent;
	
	By becomeAConsultant=By.xpath(".//a[@id='corp-opp']");
	By enrollNow=By.xpath("//nav[@class='row navbar navbar-inverse hidden-xs']//li[@id='BusinessSystemBar']//li[2]//a");
	By procedures=By.xpath("//div[@id='disclaimer']/div/p/a[1]");
	By enterTest=By.xpath("//input[@id='sponserparam']");
	By clickSearch=By.xpath("//button[@id='search-sponsor-button']");
	By clickProduct=By.xpath("//div[@class='the-search-results']/div[1]//div[@class='sponsorDataDiv']");
	By selectProduct=By.xpath("//div[@class='the-search-results']/div[1]//div[@class='sponsorDataDiv']//input[@class]");
	By beforeSelectionName=By.xpath("//div[@id='search-results']/div/div[1]/form//li[1]");
	By afterSelectionName=By.xpath("//div[@id='sponsorInfo']/div[1]/a");


	public  EnrollNowPage (WebDriver driver){
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void enroll() throws InterruptedException
	{
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(becomeAConsultant)).build().perform();
		Thread.sleep(5000);
		driver.findElement(enrollNow).click();
		Thread.sleep(5000);
		driver.findElement(procedures).click();
		Thread.sleep(5000);}

	public void switchToProcedure()
	{

		Parent=driver.getWindowHandle();
		Set<String>All=driver.getWindowHandles();
		for(String s:All){
			if (s.equals(Parent)==false)
			{
				driver.switchTo().window(s);
				break;
			}

		}}

	public void closeProcedure(){
		driver.close();

	}
	public void switchAndSearch() throws InterruptedException{

		driver.switchTo().window(Parent);
		Thread.sleep(5000);
		//{driver.close();}
		driver.findElement(enterTest).sendKeys("test");

		driver.findElement(clickSearch).click();
		Thread.sleep(5000);
		beforeSelection = driver.findElement(beforeSelectionName).getText();
		System.out.println("BEFORE "+beforeSelection);
		driver.findElement(clickProduct).click();

	}
	public String verifyProcedureURL()
	{
		System.out.println(driver.getCurrentUrl());
		return driver.getCurrentUrl();


	}
	public String beforeSelection(){

		return beforeSelection;}

	public String AfterSelection(){
		System.out.println("AFTER "+driver.findElement(afterSelectionName).getText());
		return driver.findElement(afterSelectionName).getText();}

	public void quitBrowser2(){
		driver.close();

	}


}
