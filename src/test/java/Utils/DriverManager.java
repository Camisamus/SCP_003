package Utils;

import Utils.Navegador;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class DriverManager {
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private WebDriver webDriver;
    private File root = new File("driverNavegador");
    private String extensionDriver = "";

    public void resolveDriver(Navegador nav, String ambURL) {
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("\nSistema operativo ->"+System.getProperty("os.name").toLowerCase()+"\n");
        File driverPath;
        //windows o mac
        if(!os.contains("mac")){
            extensionDriver = ".exe";
        }
        switch(nav) {
            case Chrome:
                System.out.println("Se selecciona Chrome");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                driverPath = new File(root, "chromedriver"+extensionDriver);
                System.setProperty("webdriver.chrome.driver", driverPath.getAbsolutePath());
                webDriver = new ChromeDriver(options);
                capabilities.setBrowserName("Chrome");
                webDriver.manage().window().maximize();
                break;
            default:
                System.out.println("No es posible lanzar el navegador, no se reconoce el navegador: "+nav);
        }
        webDriver.get(ambURL);
    }

    public WebDriver getDriver() {
        return webDriver;
    }

    public void closeDriver(){
        webDriver.close();
    }
}