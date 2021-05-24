package TestSuite;

import TestClases.*;
import TestClases.Model.Producto;
import Utils.Constants.Navegador;
import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Reporte.PdfQaNovaReports;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RecuperarInformacion {


    @BeforeTest
    public void setUp(){
        DriverContext.setUp(Navegador.Chrome,(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Ruta")));
        PdfQaNovaReports.createPDF();
    }

    @AfterTest
    public void end(){
        DriverContext.closeDriver();
        PdfQaNovaReports.closePDF();
    }

    @Test
    public void prueba001(){
        Ingresar inicio = new Ingresar();
        inicio.LoginNoValido();
    }
     @Test
    public void prueba002(){
        Ingresar inicio = new Ingresar();
        inicio.LoginValido();
        inicio.LlenarValido();
    }
    @Test
    public void prueba003(){
        Ingresar inicio = new Ingresar();
        inicio.LoginValido();
        inicio.Buscarregistrosfiltrados();
    }
    @Test
    public void prueba004(){
        Ingresar inicio = new Ingresar();
        inicio.LoginValido();
        inicio.Subearchivo();
    }
    @Test
    public void prueba005(){
        DriverContext.closeDriver();
        DriverContext.setUp( Navegador.Chrome2, (ReadProperties.readFromConfig("Propiedades.properties").getProperty("RutaDescarga")));
        pagedescarga DCG = new pagedescarga();
        DCG.confirmarPreviaDescarga();
        DCG.descargarsomefile();
        DCG.confirmarDescarga();
    }
    @Test
    public void prueba006(){
        Ingresar inicio = new Ingresar();
        inicio.LoginValido();
        inicio.LlenarDate();
    }
    @Test
    public void prueba007(){
        Ingresar inicio = new Ingresar();
        inicio.LoginValido();
        inicio.LlenarValido();
        inicio.LlenarDate();
        inicio.enviaform();
        inicio.Buscarregistrosfiltra2();
    }
    @Test
    public void prueba008() throws SQLException {
        bdd base = new bdd();
        base.consultar();
        base.insertar();
        base.modificar();
    }
    @Test
    public void prueba009() throws SQLException {
        Ingresar inicio = new Ingresar();
        inicio.cambiarColor();
    }
    @Test
    public void prueba010(){
        DriverContext.closeDriver();
        DriverContext.setUp( Navegador.Chrome2, (ReadProperties.readFromConfig("Propiedades.properties").getProperty("RutaSodimac")));
        Sodimac sod = new Sodimac();
        List<Producto> productos = sod.obtenerProductos();
    }
    @Test
    public void prueba011(){
        Ingresar masing = new Ingresar();
        masing.IngresoMultiple();
    }
    @Test
    public void prueba012(){
        DriverContext.getDriver().navigate().to(ReadProperties.readFromConfig("Propiedades.properties").getProperty("RutaChileautos"));
        chileautos cla = new chileautos();
        cla.Buscar();
    }
    @Test
    public void prueba013(){
        api ap = new api();
        try {
            ap.aptTesting();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void prueba014(){
        api ap = new api();
        try {
            ap.consultarfarmacias();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void prueba015(){
        compararImagenes ci = new compararImagenes();
        try {
            System.out.println(ci.compararColores());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
