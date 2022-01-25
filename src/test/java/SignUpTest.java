import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {

    @Test
    public void sendFiveDigitsToZopCodeFieldTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue' button
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Check that 'Register' button is show
//        if (driver.findElement(By.cssSelector("[value=Register]")).isDisplayed()) {
//            System.out.println("Register button isn't show");
//        } else {
//            System.out.println("Register not displayed");
//        }

        Assert.assertTrue(driver.findElement(By.cssSelector("[value=Register]")).isDisplayed(), "Register button isn't show");
        driver.quit();

    }

    @Test
    public void sendFourDigitalToZipCodeTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 4 digits
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        //Click the 'Continue' button
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Check error message is show
        boolean isErrorMessageShow = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorMessageShow, "Error message isn't show");

    }

    @Test
    public void sendSixDigitalToZipCodeTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 6 digits
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        //Click the 'Continue' button
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Check error message is show

        try {
            boolean isMessageShow =   driver.findElement(By.className("error_message")).isDisplayed();
            Assert.assertTrue(isMessageShow, "Error message isn't show");
        } catch (NoSuchElementException e) {
            Assert.fail();


        } finally {
            driver.quit();
        }

    }

    @Test
    public void registerForm() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue' button
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Ilya");
        driver.findElement(By.name("last_name")).sendKeys("Ilya");
        driver.findElement(By.name("email")).sendKeys("someemails@fds.dewf");
        driver.findElement(By.name("password1")).sendKeys("password");
        driver.findElement(By.name("password2")).sendKeys("password");
        //Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Check massage 'Account is created'
        boolean isMessageShow = driver.findElement(By.className("confirmation_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isMessageShow, "Success message isn't show");
    }

    @Test
    public void verificationThatLastNameNotRequirement() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue' button
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Ilya");
        driver.findElement(By.name("email")).sendKeys("someemails@fds.dewf");
        driver.findElement(By.name("password1")).sendKeys("password");
        driver.findElement(By.name("password2")).sendKeys("password");
        //Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Check massage 'Account is created'

        boolean isMessageShow = driver.findElement(By.className("confirmation_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isMessageShow, "Success message isn't show");
    }
}

