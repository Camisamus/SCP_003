package Pages;

import TestClases.Model.Usuario;
import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import Utils.Validaciones;
import Utils.Espera;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.internal.Utils;

public class Login1 {
    public Login1(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"imUname\"]")
    WebElement TXTUsuario;

    @FindBy(xpath = "//*[@id=\"imPwd\"]")
    WebElement TXTContrasena;

    @FindBy(xpath = "//*[@id=\"imLogin\"]/form/div[3]/input")
    WebElement BTNLogin;

    @FindBy(xpath = "//*[@id=\"imLoginPage\"]/div[3]/div")
    WebElement ERRMSG;

    @FindBy(xpath = "//*[@id=\"imHeader_pluginAppObj_02\"]/a")
    WebElement BtnSalir;



    public void LoggearMAL(){
        TXTUsuario.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Usuario"));
        BTNLogin.click();
    }
    public void LoggearBien(){
        TXTUsuario.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Usuario"));
        TXTContrasena.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Clave"));
        BTNLogin.click();
    }
    public void LoggearBien2(Usuario usu){
        Validaciones.validarObjeto(TXTUsuario,"Esta Txt Usuario");
        TXTUsuario.sendKeys(usu.getCuenta());
        TXTContrasena.sendKeys(usu.getClave());
        PdfQaNovaReports.addWebReportImage("Se inicio Sesion","se uso un usuario de la lista para tratar de iniciar sesion \""+usu.getCuenta()+"\"", EstadoPrueba.DONE,false);
        BTNLogin.click();
    }
    public void DELoggear(){
        Validaciones.validarObjeto(BtnSalir,"Esta BtnSalir");
        BtnSalir.click();
    }

    public WebElement getERRMSG() {
        return ERRMSG;
    }
}
