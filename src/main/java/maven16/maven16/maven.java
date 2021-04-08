package maven16.maven16;

import java.io.File;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
//import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class maven {
	
	String lg = null; 
	
	WebDriver driver;
	
	//variables declaration
	
	By uname = By.xpath("//*[@id=\"txtUsername\"]");
    By pwd = By.xpath("//*[@id=\"txtPassword\"]");
	

	
	
	public maven(WebDriver driver)
	{
		this.driver= driver;
		
	}
	 public void loginoperation() throws IOException
	 
	 {
		 
		 
		 File src = new File("C:\\Users\\Vinay\\Desktop\\maven\\Mavendemo.xlsx");
	        FileInputStream fls = new FileInputStream(src);
	        XSSFWorkbook xsf = new XSSFWorkbook(fls);
	        XSSFSheet sheet = xsf.getSheetAt(0);
	        String userName = sheet.getRow(1).getCell(0).getStringCellValue();
	        String password = sheet.getRow(1).getCell(1).getStringCellValue();
	       // String url = sheet.getRow(2).getCell(0).getStringCellValue();
	       // driver.get(url);
	        driver.findElement(uname).clear();// clear the input field before entering any value
	        driver.findElement(uname).sendKeys(userName);// enter the value of username
	        driver.findElement(pwd).clear();
	        driver.findElement(pwd).sendKeys(password);// enter the value of password
	        driver.findElement(By.id("btnLogin")).click();
		 }
	 
	 public void date_validate()
	 
	 {
		 		
          driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]/b")).click();
          driver.findElement(By.xpath("//*[@id=\"candidateSearch_fromDate\"]")).clear();
          WebElement dateBox = driver.findElement(By.name("candidateSearch[dateApplication][from]"));
          dateBox.sendKeys("2021-02-11");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          driver.findElement(By.xpath(" //*[@id=\"btnSrch\"]")).click();
     }
	 
	 public void checkbox_multiselect() 
		{
			
	     List<WebElement> props = driver.findElements(By.xpath("//input[@type='checkbox']")); 
	          
	          for(WebElement prop : props) 
	          { 
	              if (!prop.isSelected()) { 
	                  props.get(0).click();
	          break; } 
	              }
	 
		}
	 
	 public void dropdown()
	
	 {
		  Select Vacancy = new Select(driver.findElement(By.xpath("//*[@id=\"candidateSearch_jobVacancy\"]")));
	      Vacancy.selectByIndex(2);
          try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}          
          driver.findElement(By.xpath("//*[@id=\"btnSrch\"]")).click(); 
		
	 }
	 
	 public void mouseover() 
	 
	 {
		  Actions action = new Actions(driver);
          
          WebElement btn = driver.findElement(By.id("menu_pim_viewPimModule"));
          
          action.moveToElement(btn).perform();
	 }
	 
	 public void enable_disable() 
	 {
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
         WebElement element = driver.findElement(By.xpath("//*[@id=\"btnSrch\"]"));
         
         if (element.isEnabled()) {
          System.out.println("enabled");
         } else {
          System.out.println("disabled");
         
         }
	 }
	 
	 public void window_handling() {
		 
		  try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                    
          driver.findElement(By.xpath("//*[@id=\"branding\"]/a[1]/img")).click(); 
		 
	 }
	 
	 public void parallel_excecution() 
	 
	 {
		 System.setProperty("webdriver.chrome.driver", "D:\\Selenium Drivers\\Drivers\\chromedriver.exe");
		 WebDriver driver2 = new ChromeDriver();
		 driver2.get("http://demo.guru99.com/V4/");
	 }
	 
	 public void while_loop() 
	 {
		 
		 int counter = 0;
	        boolean foundElement = false;
	        while(!foundElement) {
	            counter++;
	            try {
	               driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b"));
	                foundElement = true;
	            } catch (NoSuchElementException e) {
	               //assuming you want to log exception. Otherwise you can leave the catch block empty.
	               System.out.println(e);    
	            }
	        }
	 }
	 
		
		  public void folder_file() {
		  
		  Path path = Paths.get("C:\\Users\\Vinay\\Desktop\\maven\\vinay.xlsx");
		    if(Files.exists(path) && !Files.isDirectory(path)) {
	              System.out.println("File exists!");
	          }
	            
	              else {
	                  
	                  System.out.println("File not exists!");
	              }
	          }
		  
		
}
	 
	 
	 

