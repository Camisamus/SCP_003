package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Espera {
    public static boolean esperar(String element){
        boolean cargo = false;
        long limite = System.currentTimeMillis() + 60000;
        while(System.currentTimeMillis()<limite){
            WebElement exist = (WebElement) DriverContext.getDriver().findElement(By.xpath(element));
            if (exist.isDisplayed()){
                cargo = true;
                break;
            }
        }
        return cargo;
    }
    public static boolean esperar(WebElement element){
        boolean cargo = false;
        long limite = System.currentTimeMillis() + 60000;
        while(System.currentTimeMillis()<limite){
            if (element.isDisplayed()){
                cargo = true;
                break;
            }
        }
        return cargo;
    }
}
