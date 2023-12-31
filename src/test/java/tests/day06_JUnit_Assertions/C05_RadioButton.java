package tests.day06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButton {
    // a. Verilen web sayfasına gidin.
    // https://facebook.com
    // b. Cookies’i kabul edin
    // c. Create an account buton’una basin
    // d. Radio button elementlerini locate edin ve size uygun olani secin
    // e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
   WebDriver driver;

   @Before
    public void setup(){
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

   }
   @After
    public void teardown(){
       driver.close();
   }

   @Test
    public void test01(){
       // a. Verilen web sayfasına gidin.
       // https://facebook.com
       driver.get("https://facebook.com");
       // b. Cookies’i kabul edin
       driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _al65 _4jy3 _4jy1 selected _51sy']")).click();
       // c. Create an account buton’una basin
       driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
       // d. Radio button elementlerini locate edin ve size uygun olani secin
       WebElement kadinRadioButton= driver.findElement(By.xpath("(//input[@name='sex'])[1]"));
       WebElement erkekRadioButton= driver.findElement(By.xpath("(//input[@name='sex'])[2]"));
       WebElement ozelRadioButton= driver.findElement(By.xpath("(//input[@name='sex'])[3]"));
       erkekRadioButton.click();
       // e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
       Assert.assertTrue(erkekRadioButton.isSelected());

       Assert.assertFalse(kadinRadioButton.isSelected());

       Assert.assertFalse(ozelRadioButton.isSelected());
   }
}
