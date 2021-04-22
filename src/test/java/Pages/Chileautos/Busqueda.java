package Pages.Chileautos;

import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import Utils.Validaciones;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Busqueda {
    public String obtenervalores(){
        Validaciones.validarObjeto(DriverContext.getDriver().findElements(By.className("media-count__images")).get(0),"se accede a la pagina de coches buscados");
        PdfQaNovaReports.addReport("Se carga pagina de autos encontrados","se pudo cargar la pagina de autos encontrados", EstadoPrueba.DONE,false);
        List<WebElement> fotos = DriverContext.getDriver().findElements(By.className("media-count__images"));
        return fotos.get(0).getAttribute("innerHTML");
    }
    public void ingresar(){
        List<WebElement> fotos = DriverContext.getDriver().findElements(By.className("media-count__images"));
        fotos.get(0).click();
    }

}
