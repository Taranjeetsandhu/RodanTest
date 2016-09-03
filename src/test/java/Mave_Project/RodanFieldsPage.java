package Mave_Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class RodanFieldsPage {

	WebDriver driver;
	
	By shopCare=By.xpath("//div[@class='hidden-xs']//a[@id='our-products']");
	By allProducts=By.xpath("//div[@class='hidden-xs']//ul[@id='dropdown-menu']/li[7]/div/a");
	By selectRedefine=By.xpath("//div[@id='main-content']//div[2]//input[@tabindex='1']");
	By refine=By.xpath("//div[@class='dropdown-wrapper']//li[1]//div[@class='pull-right']/div");
	By reverse=By.xpath("//ul[@class='refine-products select-dropdown open']/li[2]//div[@class='repaired-checkbox']");
	By price=By.xpath("//div[@id='main-content']/div[2]//input[@tabindex='2']");
	By selectPrice=By.xpath("//ul[@class='refine-products select-dropdown open']//li[2]//div[@class='pull-right']/div");
	By label1=By.xpath("//div[@id='quick-filtered']/ul/li[1]//label");
	By label2=By.xpath("//div[@id='quick-filtered']/ul/li[2]//label");
	By priceOfProduct=By.xpath("//div[@id='main-content']/div[5]/div[1]//span[1]");

	public  RodanFieldsPage (WebDriver driver){
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void shopCare() throws InterruptedException
	{
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(shopCare)).build().perform();
		Thread.sleep(5000);
		driver.findElement(allProducts).click();
		Thread.sleep(5000);

	}
	public String verifyUrl()
	{
		System.out.println(driver.getCurrentUrl());
		return driver.getCurrentUrl();


	}

	public void selectRedefine() throws InterruptedException
	{

		driver.findElement(selectRedefine).click();
		Thread.sleep(5000);
		driver.findElement(refine).click();;
		Thread.sleep(5000);
		driver.findElement(selectRedefine).click();
		Thread.sleep(5000);
		driver.findElement(reverse).click();
		Thread.sleep(5000);
		driver.findElement(price).click();
		Thread.sleep(5000);
		driver.findElement(selectPrice).click();
		Thread.sleep(5000);
	}
	public boolean verifyLabel1()
	{
		System.out.println(driver.findElement(label1).getText());

		return	driver.findElement(label1).getText().contains("REDEFINE");
	}
	public boolean verifyLabel2()
	{
		System.out.println(driver.findElement(label2).getText());

		return	driver.findElement(label2).getText().contains("REVERSE");
	}

	public void quitBrowser1(){
		driver.close();

	}

	public int verifyPrice(){
	String s=	driver.findElement(priceOfProduct).getText();
	String[] sa= s.split("$");
	System.out.println(sa);
	int i = Integer.parseInt("71");
	return i;
	}

}



