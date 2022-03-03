import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
 
public class SeleniumTest2 {
 
	//WebDriver
	private WebDriver driver;
	private WebElement element;
	private String url;
	
	//Properties
	public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static String WEB_DRIVER_PATH = "C:/Users/USER/Desktop/chromedriver.exe";
	
	public static void main(String[] args) {
 
		SeleniumTest2 test = new SeleniumTest2();
		test.oper();
	}
	
	public SeleniumTest2() {
		//System Property SetUp
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		//Driver SetUp
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		driver = new ChromeDriver(options);
		
		url = "https://www.naver.com";
	}
 
	public void oper() {
		try {
			//get������� url ��û
			driver.get(url);
			
			//�α��� ��ư Ŭ��
			element = driver.findElement(By.className("link_login"));
			element.click();
			
			//���̵� �Է�
			element = driver.findElement(By.id("id"));Thread.sleep(500);
			element.sendKeys("���̵� �Է� ex)test1234");
			
			//�н����� �Է�
			element = driver.findElement(By.id("pw"));
			element.sendKeys("��й�ȣ �Է�");
			
			//����
			element = driver.findElement(By.className("btn_login"));
			element.submit();
			
			Thread.sleep(10000);
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
 
	}
 
}