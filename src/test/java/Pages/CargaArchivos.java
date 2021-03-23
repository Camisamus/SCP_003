package Pages;

import Utils.DriverContext;
import Utils.ReadProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CargaArchivos {
    public CargaArchivos() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_2\"]")
    WebElement FileInput;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_submit\"]")
    WebElement Submit;

    public void SubirArchivo() {
        FileInput.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Filetoup"));
        Submit.click();
    }
}
