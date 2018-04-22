import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginToFacebook {
    @Test
    public void test() throws InterruptedException {
        String pathToDriver = "C:\\Users\\irina\\Downloads\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        System.out.println("web");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        WebElement login = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("pass"));
        WebElement logButtom = driver.findElement(By.cssSelector("#loginbutton input"));
        login.sendKeys("iryna.30");
        password.sendKeys("password");
        logButtom.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginbutton")));

       String s = driver.getPageSource();
       if(s.contains("Ви ввели неправильний пароль.")){
           System.out.println("ok");
       }
    }
}
