package TestClases;

import Pages.CargaArchivos;
import Pages.Formulario1;
import Pages.Login1;
import Pages.Tabla;
import TestClases.Model.Usuario;
import Utils.Constants.Navegador;
import Utils.DriverContext;
import Utils.Espera;
import Utils.ReadProperties;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import Utils.SendMail;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
    public void Buscarregistrosfiltra2(){
        Espera.esperar("//*[@id=\"imMnMnNode4\"]/a/span/span/span[2]");
        DriverContext.getDriver().findElement(By.xpath("//*[@id=\"imMnMnNode4\"]/a/span/span/span[2]")).click();
        Espera.esperar("//*[@id=\"imMnMnNode4\"]/a/span/span/span[2]");
        Tabla tb = new Tabla();
        tb.Filtra2();
        Espera.esperar("//*[@id=\"imMnMnNode4\"]/a/span/span/span[2]");
        boolean continuar = false;
        while(!continuar){
            if(DriverContext.getDriver().findElement(By.xpath("//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table/tbody/tr[1]/td[2]")).getText().equals(ReadProperties.readFromConfig("Propiedades.properties").getProperty("TXTcampo1"))){
                continuar = true;
            }
        }
        String[] mensaje = tb.recorrer2();
        SendMail.enviar(mensaje,ReadProperties.readFromConfig("Propiedades.properties").getProperty("DestinMail"));
    }
    public void Subearchivo(){
        Espera.esperar("//*[@id=\"imMnMnNode6\"]/a/span/span/span[2]");
        DriverContext.getDriver().findElement(By.xpath("//*[@id=\"imMnMnNode6\"]/a/span/span/span[2]")).click();
        Espera.esperar("//*[@id=\"imMnMnNode6\"]/a/span/span/span[2]");
        CargaArchivos CA = new CargaArchivos();
        CA.SubirArchivo();
    }
    public void LlenarDate(){
        Espera.esperar("//*[@id=\"imObjectForm_1_2\"]");
        Formulario1 fr = new Formulario1();
        fr.LlenarDate();
    }
    public void enviaform(){
        Espera.esperar("//*[@id=\"imObjectForm_1_submit\"]");
        Formulario1 fr = new Formulario1();
        fr.enviar();
    }

    public void cambiarColor(){

        JavascriptExecutor js = (JavascriptExecutor) DriverContext.getDriver();
        js.executeScript("document.getElementById(\"imUname\").setAttribute('style','background: #ff0000');");
        js.executeScript("document.getElementById(\"imPwd\").setAttribute('style','color: #00ff00');");

        try {
            Espera.esperar(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void IngresoMultiple(){

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Rutafolder")+"\\usuarios.json"))
        {
            //PdfQaNovaReports.addReport("Se lee el json","se pudo encontrar y leer el archivo.json de usuarios", EstadoPrueba.DONE,false);
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray listaUsuario = (JSONArray) obj;
            System.out.println(listaUsuario);
            ArrayList<Usuario> usus = new ArrayList<Usuario>();
            //Iterate over employee array
            listaUsuario.forEach( emp -> usus.add(parseUsuarioObject( (JSONObject) emp) ) );
            Login1 ing = new Login1();
            for (Usuario usuario : usus) {
                ing.LoggearBien2(usuario);
                ing.DELoggear();
            }
        } catch (FileNotFoundException e) {
            PdfQaNovaReports.addReport("Se lee el json fallo","NO se pudo encontrar y leer el archivo.json de usuarios por : "+ e, EstadoPrueba.FAILED,false);
            e.printStackTrace();
        } catch (IOException e) {
            PdfQaNovaReports.addReport("Se lee el json fallo","NO se pudo encontrar y leer el archivo.json de usuarios por : "+ e, EstadoPrueba.FAILED,false);
            e.printStackTrace();
        } catch (ParseException e) {
            PdfQaNovaReports.addReport("Se lee el json fallo","NO se pudo encontrar y leer el archivo.json de usuarios por : "+ e, EstadoPrueba.FAILED,false);
            e.printStackTrace();
        }
    }


    private static Usuario parseUsuarioObject(JSONObject Usuario)
    {
        Usuario usu =new Usuario();
        //Get employee object within list
        JSONObject UsuarioObject = (JSONObject) Usuario.get("usuario");

        //Get employee first name
        String Cuenta = (String) UsuarioObject.get("nombre");
        usu.setCuenta(Cuenta);

        //Get employee last name
        String Clave = (String) UsuarioObject.get("clave");
        usu.setClave(Clave);
        return usu;
    }
}
