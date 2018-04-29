package testngsfdcpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import java.net.MalformedURLException;
import java.net.URL;
 
 
public class TLDriverFactory {
 
    private static OptionsManager optionsManager = new OptionsManager();
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
 
    public static synchronized void setDriver(String browser) {
        if (browser.equals("firefox")) {
            //For Local Usage
            //tlDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(optionsManager.getFirefoxOptions()));
 
            //For Grid Usage
            try {
                tlDriver.set(new RemoteWebDriver(new URL("http://parantap_samajdar:5379f538-519b-43e1-bb68-176a4b8e96fa@ondemand.saucelabs.com:80/wd/hub"), optionsManager.getFirefoxOptions()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if (browser.equals("chrome")) {
            //For Local Usage
            //tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
 
            //For Grid Usage
            try {
                tlDriver.set(new RemoteWebDriver(new URL("http://parantap_samajdar:5379f538-519b-43e1-bb68-176a4b8e96fa@ondemand.saucelabs.com:80/wd/hub"), optionsManager.getChromeOptions()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }
 
    public static synchronized WebDriverWait getWait (WebDriver driver) {
        return new WebDriverWait(driver,20);
    }
 
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}