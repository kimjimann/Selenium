import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.ArrayList;
import java.util.List;

public class SeleniumTest {
	 
 
    //WebDriver
    private WebDriver driver;
    private WebElement element;
    private String base_url;
    
    //Properties
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/Users/USER/Desktop/chromedriver.exe";
    

    public static void main(String[] args) {
 
        SeleniumTest selTest = new SeleniumTest();
        
        selTest.operate();
        
    }

    
    public SeleniumTest() {
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
                
        //Driver SetUp
         ChromeOptions options = new ChromeOptions();
         options.setCapability("ignoreProtectedModeSettings", true);
         driver = new ChromeDriver(options);
        
         base_url = "https://www.jobda.im/getjob/299";
             
    }
 
    public void operate() {
 
        try {
            //get page 
            driver.get(base_url);
         
            //픔질관리 바로가기 버튼 클릭
            element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/section/div/article/div/table[1]/tbody/tr[8]/td[4]/a"));  
            element.click();
            
            //두 번째 탭으로 포커스 이동
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());           
            driver.switchTo().window(tabs.get(1));       
            
            //지원하기 버튼 클릭
            element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div/div/div[2]/a"));Thread.sleep(1000);
            element.click();
           
            //아이디 입력
            element = driver.findElement(By.className("login_input__2g0sb"));Thread.sleep(1000);
            element.sendKeys("아이디");
            
            //비밀번호 입력
            element = driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div/div[2]/div[2]/div[2]/form/div[2]/input"));Thread.sleep(1000);
            element.sendKeys("비밀번호");
            
            //로그인 버튼 클릭
            element = driver.findElement(By.className("login_btnLogin__2Pl0Q"));Thread.sleep(1000);
            element.submit();Thread.sleep(1000);
                            
            //로그인 후 지원하기 버튼 클릭
            element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div[1]/div/div[2]/a"));Thread.sleep(1000);
            element.click();Thread.sleep(1000);
            
            //조금더 둘러볼게요 클릭
            element = driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div/div/a[1]"));Thread.sleep(1000);
            element.click();
            
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
        	// 사이트 종료
            //driver.close();
        }
 
    }
 
}
