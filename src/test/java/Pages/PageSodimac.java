package Pages;

import TestClases.Model.Producto;
import Utils.DriverContext;
import Utils.Espera;
import Utils.Validaciones;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PageSodimac{
        public PageSodimac() {
            PageFactory.initElements(DriverContext.getDriver(), this);
        }
    @FindBy(xpath = "//*[@id=\"testId-input-typeahead-desktop\"]")
    WebElement TxtBusqueda;
    @FindBy(xpath = "//*[@id=\"testId-btn-testId-btn-search-typeahead-desktop\"]/i/i")
    WebElement BtnBusqueda;
    @FindBy(xpath = "//*[@id=\"checkbox-product.attribute.Voltaje_2\"]")
    WebElement CheckboxFiltro;
    @FindBy(xpath = "//*[@id=\"testId-btn-grid-view\"]/span/span")
    WebElement BtnLista;
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]")
    WebElement Lista;
    @FindBy(xpath = "//*[@id=\"testId-Link-scat933729\"]/span")
    WebElement etiketaDeTaladros;
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]/div[1]")
    WebElement Primeritem;


    public ArrayList<Producto> obtenerProductos1(){
        ArrayList<Producto> obj = new ArrayList<Producto>();
        Validaciones.validarObjeto(TxtBusqueda,"TxtBusqueda");
        //TxtBusqueda.sendKeys("Taladro");
        //JavascriptExecutor js = (JavascriptExecutor) DriverContext.getDriver();
        //js.executeScript("document.getElementById(\"testId-input-typeahead-desktop\").value = \"Taladro\";");
        //Validaciones.validarObjeto(BtnBusqueda,"Btn Busqueda");
        //BtnBusqueda.click();
        Validaciones.validarObjeto(etiketaDeTaladros,"Check box Filtro");
        CheckboxFiltro.click();
        Validaciones.validarObjeto(Primeritem,"Btn Lista");

        Validaciones.validarObjeto(Lista,"lista");
        List<WebElement> Productos = Lista.findElements(By.className("product-container"));
        for (int i=0; i< Productos.size() ; i++){
            Producto prod = new Producto();
            prod.setNombre(obtenerNombre(Productos.get(i)));
            prod.setPrecio(obtenerPrecio(Productos.get(i)));
            prod.setDescipcion(obtenerDescripcion(Productos.get(i)));
            prod.setCalificacion(obtenerCalificacion(Productos.get(i)));
            obj.add(prod);
        }
        return obj;
    }
    public String obtenerNombre(WebElement elemento){
        return elemento.findElement(By.className("title-name")).getText();
    }
    public int obtenerPrecio(WebElement elemento){
        String precio = elemento.findElement(By.className("price")).findElements(By.tagName("span")).get(0).getAttribute("innerHTML");
        String strNew = precio.replace("$", "");
        String strNew2 = strNew.replace(".", "");
        int price = Integer.parseInt(strNew2);
        return price;

    }
    public String[] obtenerDescripcion(WebElement elemento){
        WebElement list = elemento.findElements(By.className("product-highlights")).get(0);
        List<WebElement> k = list.findElements(By.className("highlight-item"));
        String[] resp = new String[k.size()];
        for(int i=0; i<k.size();i++){
            resp[i] =k.get(i).getAttribute("innerHTML");
        }
        return resp;

    }
    public int obtenerCalificacion(WebElement elemento){
        WebElement calif = elemento.findElement(By.className("ratings--container"));
        int k = contarestrellas(calif);
        return k;

    }
    public int contarestrellas(WebElement Estrellas){
        int calif = 0;
        List<WebElement> estrellas = Estrellas.findElements(By.className("cs-icon-star-filled"));
        for(int i=0; i<estrellas.size();i++){
            calif++;
            calif++;
        }
        estrellas = Estrellas.findElements(By.className("cs-icon-star-half_filled"));
        for(int i=0; i<estrellas.size();i++){
            calif++;
        }
        return calif;
    }
}
