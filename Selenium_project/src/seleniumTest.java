import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class seleniumTest {

	public static WebDriver driver;
	public static WebElement element;
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/Users/USER/Desktop/chromedriver.exe";

	@BeforeClass
    public static void setup() throws Exception{

        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        //Driver setup
         ChromeOptions options = new ChromeOptions();
         options.setCapability("ignoreProtectedModeSettings", true);
         driver = new ChromeDriver();   
         driver.get("https://www.jobda.im/getjob/299");

    }

	@Test
	public void t01_품질관리직무지원() throws Exception{	
	//품질관리직무 지원하기 클릭
	element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/section/div/article/div/table[1]/tbody/tr[8]/td[4]/a")); 
        element.click();
        //탭 전환
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //지원하기 클릭
        element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div/div/div[2]/a"));Thread.sleep(1000);
        element.click();
        //id 입력
	element = driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div/div[2]/div[2]/div[2]/form/div[1]/input"));Thread.sleep(1000);
        element.sendKeys("아이디");
        //pw 입력
        element = driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div/div[2]/div[2]/div[2]/form/div[2]/input"));Thread.sleep(1000);
        element.sendKeys("패스워드");
        //로그인
        element.submit();Thread.sleep(1000);      
        //탭 전환
        driver.switchTo().window(tabs.get(1));
        //지원하기 클릭
        element = driver.findElement(By.className("jd_text__xx2TV"));Thread.sleep(1000);
        element.click();Thread.sleep(1000);
        //조금더 둘러볼게요 클릭
        element = driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div/div/a[1]"));Thread.sleep(1000);
        element.click();
        }

	@AfterClass
	public static void tearDown() throws Exception{
		//driver quit
		driver.quit();
	}
}
