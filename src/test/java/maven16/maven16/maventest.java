package maven16.maven16;


import java.io.File;




import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

 

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

 


public class maventest {
	
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlreporter;
    public static ExtentReports reporter;
    public static ExtentTest test;
	
    @BeforeClass
    public static void startTest() {
        try

 

        {
            htmlreporter = new ExtentHtmlReporter(
            System.getProperty("user.dir") + "\\OrangeHRM\\ExtentReporter" + "\\extentReports.html");
            htmlreporter.config().setDocumentTitle("OrangeHRM");
            htmlreporter.config().setTheme(Theme.DARK);
            htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
            reporter = new ExtentReports();
            reporter.attachReporter(htmlreporter);
            test = reporter.createTest("TestReport");

 

            // HostName
            reporter.setSystemInfo("Host_Name", InetAddress.getLocalHost().getHostName());
            // HostAdDress
            reporter.setSystemInfo("Host_Address", InetAddress.getLocalHost().getHostAddress());
            // UserName
            reporter.setSystemInfo("Username", System.getProperty("user.name"));

 

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    
	@Test
	public void testdata() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Drivers\\Drivers\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 
		 
		 driver.manage().window().maximize();
		 maven lg = new maven(driver);
		 String url = "https://opensource-demo.orangehrmlive.com/";
	     driver.get(url);
	     lg.loginoperation();
	     lg.date_validate();
	     lg.checkbox_multiselect();
	     lg.dropdown();
	     lg.mouseover();
	     lg.enable_disable();
	     lg.window_handling();
	     lg.parallel_excecution();
	     lg.while_loop();
	     lg.folder_file();
	}
	
	public void failed() {
 

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    
        try {
            FileHandler.copy(scrFile, new File("C:\\Users\\Vinay\\eclipse-workspace\\maven16\\Listeners\\Screenshot.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
	
	@AfterClass
    public static void endTest() {
        reporter.flush();
    }
		
	}
	
	
	
	
	