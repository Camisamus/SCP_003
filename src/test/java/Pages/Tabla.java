package Pages;

import Utils.DriverContext;
import Utils.ReadProperties;
import com.google.common.collect.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Tabla {
    public Tabla(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_filter_field\"]")
    WebElement Filtro;
    @FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_filter_button\"]")
    WebElement BotonFiltrar;
    @FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table/tbody")
    WebElement Tabla;

        public void Filtrar() {
            Filtro.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Filtro"));
            BotonFiltrar.click();
        }
        public void Obtener(){
            System.out.println(Tabla.getText());
        }
        public void recorrer(){
            List rows = DriverContext.getDriver().findElements(By.xpath("//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table/tbody/tr"));
            List cols = DriverContext.getDriver().findElements(By.xpath("//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table/tbody/tr[1]/td"));
            System.out.println(rows.size());
            System.out.println(cols.size());
            System.out.println(rows);
            System.out.println(cols);
            ArrayList<ArrayList<String>> tabla = new ArrayList(rows.size());
            List<WebElement> filas = Tabla.findElements(By.tagName("tr"));
            for (int i=0; i< rows.size(); i++){
                ArrayList<String> datosfila = new ArrayList(cols.size());
                List<WebElement> fila = filas.get(i).findElements(By.tagName("td"));
                for (int j=1; j< (cols.size()); j++){
                    datosfila.add(fila.get(j).getText());
                }
                tabla.add(datosfila);
            }
            System.out.println("aqui");
        }

}
