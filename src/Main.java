import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\lferda\\Documents\\Homeworks\\geckodriver.exe");

        FirefoxOptions opts = new FirefoxOptions();
        opts.addArguments("-private");
        //opts.addArguments("-headless");

        WebDriver driver = new FirefoxDriver(opts);

        sleep(2000);

        driver.navigate().to("http://aws-demo.shopizer.com/shop/");
        sleep(2000);

        var a = driver.findElement(By.id("searchField"));
        a.sendKeys("aaa");
        var b = a.getText();


        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        System.out.println(srcFile.getAbsolutePath());

        driver.quit();
    }
}
