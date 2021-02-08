package org.assignment.assignment1;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert; 

import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AmazonPage {
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	public WebElement searchBar;
	
	@FindBy(xpath = "//img[@alt='Brief History of Everyone Who Ever Lived: The Human Story Retold Through Our Genes /]cadam Rutherford; Foreword by Siddhar...']")
	public WebElement bookImg;
	
	@FindBy(xpath = "(//span[text()='Paperback'])[1]")
	public WebElement paperBack;
	
	@FindBy(xpath = "//input[@id='SearchBtn']")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//input[@id='buy-now-button']")
	public WebElement buyNowBtn;
	
	@FindBy(xpath = "//a[@id='buybox-see-all-buying-choices-announce']")
	public WebElement allBuyOptions;
	
	@FindBy(xpath = "(//input[@name='submit.addToCart'])[1]")
	public WebElement addToCart;
	
	@FindBy(xpath = "//a[@id='hlb-ptc-btn-native']")
	public WebElement proceedToBuyBtn;
	
	
	
	
	public void AmazonShopping(WebDriver driver) throws InterruptedException  {
		//this.driver=driver;
		
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe"); 
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
		System.out.println("Searching for the Book in Amazon");
		//WebElement roundTripRadiobtn = driver.findElement(By.id("RoundTrip"));
		WebDriverWait wait = new WebDriverWait(driver,30); 
		wait.until(ExpectedConditions.visibilityOf(searchBar)); 
		searchBar.sendKeys("a brief history of everyone who ever lived");
		searchBar.sendKeys(Keys.RETURN);
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		bookImg.click();
		wait.until(ExpectedConditions.visibilityOf(paperBack));
		paperBack.click();
		System.out.println("PaperBack selected");
		driver.close();
		
	}
	
	public void BudgetEstimation() throws IOException  {
		
		
		 FileInputStream fis = new FileInputStream("C:\\Users\\irout\\git_sc\\assignment1\\src\\test\\java\\org\\assignment\\assignment1\\BudgetEstimation.xlsx");
	        FileOutputStream fos = null;
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        XSSFSheet sheet = workbook.getSheet("Expenses");
	        XSSFRow row = null;
	        XSSFCell cell = null;
	   
	        for(int i=1;i<=sheet.getLastRowNum();i++) {
	        	
	        	//System.out.println(sheet.getRow(i).getCell(0).getStringCellValue().equals(""));
	           if(sheet.getRow(i).getCell(0).getStringCellValue().equals("Trip to Delhi")){
	        	   sheet.getRow(i).createCell(1).setCellValue(15000);;
	        	   System.out.println("working");
	        	}
	        	else if(sheet.getRow(i).getCell(0).getStringCellValue().equals("Cab fares for the trip")) {
	        		sheet.getRow(i).createCell(1).setCellValue(4000);
	        	}
	        	else if(sheet.getRow(i).getCell(0).getStringCellValue().equals("Gift for Sandhya")) {
	        		sheet.getRow(i).createCell(1).setCellValue(500);
	        	}
	        	else if(sheet.getRow(i).getCell(0).getStringCellValue().equals("Food expenses in Delhi")) {
	        		sheet.getRow(i).createCell(1).setCellValue(5000);
	        	}
	        	else if(sheet.getRow(i).getCell(0).getStringCellValue().equals("Buffer")) {
	        		sheet.getRow(i).createCell(1).setCellValue(4000);
	        	}
	        	
	        }
	       
	 
	        fos = new FileOutputStream("C:\\Users\\irout\\git_sc\\assignment1\\src\\test\\java\\org\\assignment\\assignment1\\BudgetEstimation.xlsx");
            workbook.write(fos);
            fos.close();
		
		
	}
	

}
