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

        driver.manage().window().maximize();

        sleep(2000);

        var baseUrl = "https://czechitas-shopizer.azurewebsites.net/shop/";

        driver.navigate().to(baseUrl);
        //https://czchitasshopizer.azurewebsites.net/admin/
        //username:admin@shopizer.com password:password
        sleep(2000);

        var a = driver.findElement(By.id("searchField"));
        a.sendKeys("aaa");
        var b = a.getText();

        sleep(2000);

        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        System.out.println(srcFile.getAbsolutePath());

        var title = driver.getTitle();
        System.out.println(title + " " + title.length());

        var url = driver.getCurrentUrl();
        System.out.println(url);

        System.out.println(url.equals(baseUrl));

        System.out.println(driver.getPageSource().length());

        driver.quit();
    }
}
