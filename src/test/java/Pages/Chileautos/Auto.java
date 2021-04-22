package Pages.Chileautos;

import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import Utils.Validaciones;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Auto {
    public List<String> recuperarDetalles() {
        ArrayList<String> detalles = new ArrayList<String>();
        Validaciones.validarObjeto(DriverContext.getDriver().findElements(By.className("view-more")).get(0), "seguimos");
        PdfQaNovaReports.addReport("Se carga pagina de detalles del auto", "se pudo cargar la pagina de detalles del auto", EstadoPrueba.DONE, false);
        WebElement bewmora = DriverContext.getDriver().findElements(By.className("view-more")).get(0);
        bewmora.click();
        WebElement bewmoratg = DriverContext.getDriver().findElements(By.className("view-more-target")).get(0);
        String Comentario = bewmoratg.getAttribute("innerHTML");
        ;
        WebElement Detalles = DriverContext.getDriver().findElement(By.id("details"));
        List<WebElement> listadetalles = Detalles.findElements(By.className("features-item"));
        //int cuenta = 0;
        for (int i = 0; i < listadetalles.size(); i++) {
            String tit = listadetalles.get(i).findElements(By.tagName("span")).get(0).getAttribute("innerHTML");
            String cont = listadetalles.get(i).findElements(By.className("features-item-value")).get(0).getAttribute("innerHTML");
            detalles.add(tit);
            //     cuenta++;
            detalles.add(cont);
            //    cuenta++;
        }
        detalles.add("Comentario");
        // cuenta++;
        detalles.add(Comentario);
        return detalles;
    }

    public void recuperarfotos(String cantfotosbase) {
        int cantfotos = Integer.parseInt(cantfotosbase);
        DriverContext.getDriver().findElements(By.className("thumb-wrapper-hero-overlay")).get(0).click();
        for (int i = 0; i < cantfotos; i++) {
            WebElement Foto = DriverContext.getDriver().findElement(By.xpath("/html/body/div[5]/div/div[1]/div[2]/div/div[1]/div[2]/div/div[2]/div/img"));
            String ruta = Foto.getAttribute("src");
            URL imageURL = null;
            try {
                imageURL = new URL(ruta);
                BufferedImage saveImage = ImageIO.read(imageURL);
                ImageIO.write(saveImage, "png", new File("C:\\Users\\qanova\\Documents\\GitHub\\SCP_003\\tmp\\ImagenRecuperada" + i + ".png"));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            DriverContext.getDriver().findElement(By.xpath("/html/body/div[5]/div/div[1]/div[2]/div/div[1]/div[2]/div/div[3]/span")).click();
        }
    }
}
