package Pages.Chileautos;


import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import Utils.Validaciones;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Inicio {

    public void buscarCasaRodante(){

        Validaciones.validarObjeto(DriverContext.getDriver().findElement(By.xpath("//*[@id=\"search-form-container\"]/div/div[1]/a/span")),"se carga la pagina");
        PdfQaNovaReports.addReport("Se carga pagina de inicio","se pudo cargar la pagina de inicio", EstadoPrueba.DONE,false);
        DriverContext.getDriver().findElement(By.xpath("//*[@id=\"search-form-container\"]/div/div[1]/a/span")).click();
    }
}
