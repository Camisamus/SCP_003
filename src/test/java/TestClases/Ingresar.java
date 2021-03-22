package TestClases;

import Pages.Formulario1;
import Pages.Login1;
import Pages.Tabla;
import Utils.DriverContext;
import Utils.Espera;
import Utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Ingresar {

    public void LoginNoValido(){
        Espera.esperar("//*[@id=\"imLogin\"]/form/div[3]/input");
        Login1 lg = new Login1();
        lg.LoggearMAL();
        WebElement mensajeerror = lg.getERRMSG();
        System.out.println(mensajeerror.getCssValue("color"));
        System.out.println(mensajeerror.getText());
    }
    public void LoginValido(){
        Espera.esperar("//*[@id=\"imLogin\"]/form/div[3]/input");
        Login1 lg = new Login1();
        lg.LoggearBien();
    }
    public void LlenarValido(){
        Espera.esperar("//*[@id=\"imObjectForm_1_2\"]");
        Formulario1 fr = new Formulario1();
        fr.LlenarFormulario();
    }
    public void Buscarregistrosfiltrados(){
        Espera.esperar("//*[@id=\"imMnMnNode4\"]/a/span/span/span[2]");
        DriverContext.getDriver().findElement(By.xpath("//*[@id=\"imMnMnNode4\"]/a/span/span/span[2]")).click();
        Espera.esperar("//*[@id=\"imMnMnNode4\"]/a/span/span/span[2]");
        Tabla tb = new Tabla();
        tb.Filtrar();
        Espera.esperar("//*[@id=\"imMnMnNode4\"]/a/span/span/span[2]");
        boolean continuar = false;
        while(!continuar){
            if(DriverContext.getDriver().findElement(By.xpath("//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table/tbody/tr[1]/td[2]")).getText().equals(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Filtro"))){
             continuar = true;
            }
        }
        tb.recorrer();
    }
}
