package Pages;

import Utils.DriverContext;
import Utils.DriverManager;
import Utils.Espera;
import Utils.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class Descarga {
    public Descarga() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }
    @FindBy(xpath = "//*[@id=\"content\"]/div/a[4]")
    WebElement BtnDescarga;
    public void descargar(){
        BtnDescarga.click();
        try {
            Espera.esperar(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
