package org.assignment.assignment1;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

@SuppressWarnings("deprecation")
public class ClearTripPage {
	WebDriver driver;
	//System.setProperty("webdriver.chrome.driver","C:\\Users\\ghs6kor\\Desktop\\Java\\chromedriver.exe");
	
	//public WebElement roundTripRadiobtn = driver.findElement(By.id("RoundTrip"));
	
	/*public ClearTripPage() {
		PageFactory.initElements(driver, this);
	}*/
	@FindBy(how=How.XPATH, using = "//*[@id='RoundTrip']")
	public WebElement roundTripRadiobtn;
	
	@FindBy(how=How.XPATH, using = "//input[@id='FromTag']")
	public WebElement fromTxtField;
	
	@FindBy(xpath = "//input[@id='DepartDate']")
	public WebElement departDate;
	
	@FindBy(xpath = "//input[@id='ReturnDate']")
	public WebElement retutnDate;
	
	@FindBy(xpath = "//select[@id='Childrens']")
	public WebElement childrenDropdown;
	
	@FindBy(xpath = "//input[@id='SearchBtn']")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//input[@id='ToTag']")
	public WebElement toTextField1;
	
	@FindBy(xpath = "//input[@id='ToTag']")
	public WebElement toTextField;
	
	@FindBy(xpath = "(//span[@class='checkbox__mark bs-border bc-neutral-500 bw-1 ba'])[1]")
	public WebElement nonStopCheckbox;
	
	@FindBy(xpath = "//button[@class='bg-primary-500 hover:bg-primary-600 c-white bc-transparent c-pointer py-1 px-3 h-8 fs-3 fw-600 t-all button bs-solid tp-color td-500 bw-1 br-4 lh-solid box-border']")
	public WebElement bookBTN;
	
	@FindBy(xpath = "(//h3[@class='fs-4 c-neutral-900 fw-500'])[1]")
	public WebElement itnryTO;
					
	@FindBy(xpath = "(//h3[@class='fs-4 c-neutral-900 fw-500'])[2]")
	public WebElement itnryFRO;
	
	@FindBy(xpath = "//div[@class='px-4 py-3 flex flex-between flex-middle bb btr-4 btl-4 bc-neutral-100 fareBlock__title bg-secondary-100']")
	public WebElement stdFare;
	
	@FindBy(xpath = "//input[@placeholder='Mobile number']")
	public WebElement mobileNBR;
	
	@FindBy(xpath = "//input[@placeholder='Email address']")
	public WebElement emailID;
	
	@FindBy(xpath = "//button[text()='Continue']")
	public WebElement contBtn;
	
	@FindBy(xpath = "(//button[text()='Continue'])[2]")
	public WebElement contBtn1;
	@FindBy(xpath = "(//input[@placeholder='First name'])[1]")
	public WebElement adultFstName;
	
	@FindBy(xpath = "(//input[@placeholder='First name'])[2]")
	public WebElement childFstName;
	
	@FindBy(xpath = "(//input[@placeholder='Last name'])[1]")
	public WebElement adultLastname;
	
	@FindBy(xpath = "(//input[@placeholder='Last name'])[2]")
	public WebElement childLastname;
	
	@FindBy(xpath = "(//button[@class='flex flex-middle flex-between t-all fs-2 focus:bc-secondary-500 bg-transparent bc-neutral-100 c-pointer pr-2 pl-3 pt-2 pb-2 ba br-4 h-8 fs-3 h-9'])[1]")
	public WebElement adultGender;
			
	@FindBy(xpath = "(//button[@class='flex flex-middle flex-between t-all fs-2 focus:bc-secondary-500 bg-transparent bc-neutral-100 c-pointer pr-2 pl-3 pt-2 pb-2 ba br-4 h-8 fs-3 h-9'])[2]")
	public WebElement childGender;
	
	@FindBy(xpath = "(//input[@placeholder='Nationality (e.g. India)'])[1]")
	public WebElement adultNationlty;
			
	@FindBy(xpath = "(//input[@placeholder='Nationality (e.g. India)'])[2]")
	public WebElement childNationlty;
	
	@FindBy(xpath = "//input[@placeholder='DD / MM / YYYY']")
	public WebElement childDOB;
	
	@FindBy(xpath = "//button[text()='Continue to payment']")
	public WebElement paymtBtn;
	
	@FindBy(xpath = "//h1[text()='Pay to complete your booking']")
	public WebElement paytoBook;
	
	public void flightBooking(WebDriver driver) throws InterruptedException  {
		//this.driver=driver;
		
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe"); 
		driver=new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
		System.out.println("clicking roundtrip");
		//WebElement roundTripRadiobtn = driver.findElement(By.id("RoundTrip"));
		WebDriverWait wait = new WebDriverWait(driver,50); 
		wait.until(ExpectedConditions.visibilityOf(roundTripRadiobtn)); 
		if(roundTripRadiobtn.isDisplayed()) {
			System.out.println("ELEMENT PRESENT");
		}
		else {
			System.out.println("NOT PRESENT");
		}
		roundTripRadiobtn.click();
		fromTxtField.click();
		fromTxtField.sendKeys("Bangalore, IN - Kempegowda International Airport (BLR)");
		toTextField.click();
		toTextField.sendKeys("New Delhi, IN - Indira Gandhi Airport (DEL)");
		departDate.sendKeys("15/02/2021");
		retutnDate.clear();
		retutnDate.sendKeys("16/02/2021");
		Select select=new Select(childrenDropdown);
		select.selectByValue("1");
		searchBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(nonStopCheckbox)); 
		nonStopCheckbox.click();
		String winow1=driver.getWindowHandle();
		wait.until(ExpectedConditions.elementToBeClickable(bookBTN)); 
		bookBTN.click();
		 Thread.sleep(7000);
		Set<String>Windows=driver.getWindowHandles();
		 for (String temp : Windows) {
			 if(temp!=winow1) {
				 driver.switchTo().window(temp);
			 }
		 }
		 Thread.sleep(7000);
		
		 wait.until(ExpectedConditions.elementToBeClickable(itnryTO)); 
		 if(itnryTO.isDisplayed()) {
			 System.out.println("Element is present="+itnryTO.getText());
		 }
		if(itnryTO.getText().contains("Bangalore") && itnryFRO.getText().contains("New Delhi")) {
			System.out.println("itinerary verified successfully");
		}
		stdFare.click();
		contBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(mobileNBR)); 
		mobileNBR.sendKeys("1287453243");
		emailID.sendKeys("test@gmail.com");
		wait.until(ExpectedConditions.elementToBeClickable(contBtn1)); 
		contBtn1.click();
		wait.until(ExpectedConditions.elementToBeClickable(adultFstName)); 
		adultFstName.sendKeys("Dad");
		adultLastname.sendKeys("cool");
		//adultNationlty.sendKeys("India");
		childFstName.sendKeys("BabyGirl");
		childLastname.sendKeys("cute");
		//childNationlty.sendKeys("India");
		childDOB.sendKeys("05/05/2011");
		wait.until(ExpectedConditions.elementToBeClickable(paymtBtn)); 
		//wait.until(ExpectedConditions.elementToBeClickable(paytoBook)); 
		if(paymtBtn.isDisplayed()) {
			System.out.println("We are going to Payment Page");
		}
		driver.close();
		
	}
	

}
