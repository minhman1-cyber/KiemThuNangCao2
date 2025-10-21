import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void testSignUp() throws InterruptedException {
        driver.get("https://vitimex.com.vn/account/register");
        Thread.sleep(3000);
        driver.findElement(By.id("last_name")).sendKeys("Nguyen");
        driver.findElement(By.id("first_name")).sendKeys("Van A");
        driver.findElement(By.id("radio2")).click();
        driver.findElement(By.id("birthday")).sendKeys("10/10/1998");
        driver.findElement(By.id("email")).sendKeys("blabla1@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Đăng ký']")).click();
        Thread.sleep(10000);
//        Assert.assertTrue(driver.getPageSource().contains("Logged In Successfully"));
//        System.out.println("Sign up Successfully");
    }

    @Test(dependsOnMethods = {"testSignUp"})
    public void testLogin() throws InterruptedException {
        driver.get("https://vitimex.com.vn/account/login");
        Thread.sleep(3000);
        driver.findElement(By.id("customer_email")).sendKeys("blabla1@gmail.com");
        driver.findElement(By.id("customer_password")).sendKeys("Password123");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Đăng nhập']")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getPageSource().contains("blabla1@gmail.com"));
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
