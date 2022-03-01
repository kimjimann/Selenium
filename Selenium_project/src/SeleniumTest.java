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
         
            //�������� �ٷΰ��� ��ư Ŭ��
            element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/section/div/article/div/table[1]/tbody/tr[8]/td[4]/a"));  
            element.click();
            
            //�� ��° ������ ��Ŀ�� �̵�
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());           
            driver.switchTo().window(tabs.get(1));       
            
            //�����ϱ� ��ư Ŭ��
            element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div/div/div[2]/a"));Thread.sleep(1000);
            element.click();
           
            //���̵� �Է�
            element = driver.findElement(By.className("login_input__2g0sb"));Thread.sleep(1000);
            element.sendKeys("���̵�");
            
            //��й�ȣ �Է�
            element = driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div/div[2]/div[2]/div[2]/form/div[2]/input"));Thread.sleep(1000);
            element.sendKeys("��й�ȣ");
            
            //�α��� ��ư Ŭ��
            element = driver.findElement(By.className("login_btnLogin__2Pl0Q"));Thread.sleep(1000);
            element.submit();Thread.sleep(1000);
                            
            //�α��� �� �����ϱ� ��ư Ŭ��
            element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/main/div/div/div[2]/div[1]/div/div[2]/a"));Thread.sleep(1000);
            element.click();Thread.sleep(1000);
            
            //���ݴ� �ѷ����Կ� Ŭ��
            element = driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div/div/a[1]"));Thread.sleep(1000);
            element.click();
            
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
        	// ����Ʈ ����
            //driver.close();
        }
 
    }
 
}
