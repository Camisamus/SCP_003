package Pages;

import Utils.DriverContext;
import Utils.Espera;
import Utils.ReadProperties;
import Utils.Validaciones;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.xml.crypto.dsig.Transform;
import java.util.ArrayList;
import java.util.List;

public class Formulario1 {
    public Formulario1(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_2\"]")
    WebElement TXTcampo1;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_3\"]")
    WebElement TXTmail;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_4\"]")
    WebElement TXTcampo3;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_5\"]")
    WebElement DATEELEMENTfecha;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_6\"]")
    WebElement SELECTcampolista;



    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_0\"]")
    WebElement opcion1CHECKcampoopcionmultiple;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_1\"]")
    WebElement opcion2CHECKcampoopcionmultiple;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_2\"]")
    WebElement opcion3CHECKcampoopcionmultiple;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_0\"]")
    WebElement Opcion1RADIOBTN;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_1\"]")
    WebElement Opcion2RADIOBTN;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_2\"]")
    WebElement Opcion3RADIOBTN;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_5_icon\"]")
    WebElement BtnDespliegue;
    @FindBy(xpath = "//*[@id=\"imDPcal\"]/table/tbody")
    WebElement TablaDespliegue;
    @FindBy(xpath = "//*[@id=\"imDPMonth\"]")
    WebElement mesDespliegue;
    @FindBy(xpath = "//*[@id=\"imDPright\"]")
    WebElement AvanzarMes;
    @FindBy(xpath = "//*[@id=\"imDPleft\"]")
    WebElement RetrocederMes;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_submit\"]")
    WebElement BtnSubmit;




    public void LlenarFormulario(){
        TXTcampo1.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("TXTcampo1"));
        TXTmail.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("TXTmail"));
        TXTcampo3.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("TXTcampo3"));
        DATEELEMENTfecha.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("DATEELEMENTfecha"));
        Select campolista = new Select(SELECTcampolista);
        switch (ReadProperties.readFromConfig("Propiedades.properties").getProperty("SELECTcampolista")){
            case "1":
                campolista.selectByIndex(1);
                break;
            case "2":
                campolista.selectByIndex(2);
                break;
            case "3":
                campolista.selectByIndex(3);
                break;
            default:
                campolista.selectByIndex(0);
                break;
        }
        if(ReadProperties.readFromConfig("Propiedades.properties").getProperty("opcion1CHECKcampoopcionmultiple").equals("True")){
            opcion1CHECKcampoopcionmultiple.click();
        }
        if(ReadProperties.readFromConfig("Propiedades.properties").getProperty("opcion2CHECKcampoopcionmultiple").equals("True")){
            opcion2CHECKcampoopcionmultiple.click();
        }
        if(ReadProperties.readFromConfig("Propiedades.properties").getProperty("opcion3CHECKcampoopcionmultiple").equals("True")){
            opcion3CHECKcampoopcionmultiple.click();
        }
        switch (ReadProperties.readFromConfig("Propiedades.properties").getProperty("OpcionRADIOBTN")){
            case "1":
                Opcion1RADIOBTN.click();
                break;
            case "2":
                Opcion2RADIOBTN.click();
                break;
            case "3":
                Opcion3RADIOBTN.click();
                break;
        }
        System.out.println("se lleno el formulario");

    }

    public void LlenarDate(){
        System.out.println("se inicia el llenado");
        Espera.esperar("//*[@id=\"imObjectForm_1_5_icon\"]");
        Validaciones.validarObjeto(BtnDespliegue,"tablaDesplegada");
        BtnDespliegue.click();
        Validaciones.validarObjeto(AvanzarMes,"tablaDesplegada");
        String[] fechaPedida = ReadProperties.readFromConfig("Propiedades.properties").getProperty("DATEELEMENTfecha").split("/");
        boolean Anocorrrecto = false;
        while(!Anocorrrecto){
            Espera.esperar("//*[@id=\"imDPMonth\"]");
            String[] Fechaactual = mesDespliegue.getText().split(" ");
            int anopedido = Integer.parseInt(fechaPedida[2]);
            int posano = 1;
            if(Fechaactual[0].equals("")){
                posano = 2;
            }
            int anoseleccionado = Integer.parseInt(Fechaactual[posano]);
            if(anopedido > anoseleccionado){
                 AvanzarMes.click();
            }
            if(anopedido < anoseleccionado){
                RetrocederMes.click();
            }
            if(anopedido == anoseleccionado){
                Anocorrrecto = true;
            }
            try {
                Espera.esperar(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        boolean Mescorrecto = false;
        while(!Mescorrecto){
            String[] Fechaactual = mesDespliegue.getText().split(" ");
            int mespedido = Integer.parseInt(fechaPedida[1]);
            int posmes = 0;
            if(Fechaactual[0].equals("")){
                posmes = 1;
            }
            int messeleccionado = Integer.parseInt(transformmes2(Fechaactual[posmes]));
            if(mespedido > messeleccionado){
                AvanzarMes.click();
            }
            if(mespedido < messeleccionado){
                RetrocederMes.click();
            }
            if(mespedido == messeleccionado){
                Mescorrecto = true;
            }
            try {
                Espera.esperar(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("se selecciono el año y mes correcto");

        WebElement tT = DriverContext.getDriver().findElement(By.xpath("//*[@id=\"imDPcal\"]/table"));
        List rows = DriverContext.getDriver().findElements(By.xpath("//*[@id=\"imDPcal\"]/table/tbody/tr"));
        List cols = DriverContext.getDriver().findElements(By.xpath("//*[@id=\"imDPcal\"]/table/tbody/tr[3]/td"));
        System.out.println(rows.size());
        System.out.println(cols.size());
        System.out.println(rows);
        System.out.println(cols);
        ArrayList<ArrayList<String>> tabla = new ArrayList(rows.size());
        ArrayList<List<WebElement>> tTabla = new ArrayList(rows.size());
        List<WebElement> filas = tT.findElements(By.tagName("tr"));
        for (int i=0; i< rows.size(); i++){
            ArrayList<String> datosfila = new ArrayList(cols.size());
            List<WebElement> fila = filas.get(i).findElements(By.tagName("td"));
            for (int j=1; j< (cols.size()); j++){
                datosfila.add(fila.get(j).getText());
            }
            tabla.add(datosfila);
            tTabla.add(fila);
        }
        for (int i=0; i<tTabla.size(); i++){
            List<WebElement> fila = tTabla.get(i);
            for (int j=0; j<fila.size(); j++){
                WebElement c = fila.get(j);
                if (c.getText().equals(fechaPedida[0])) {
                    c.click();
                    i=100;
                    j=100;
                }
            }
        }
    }
    public void enviar(){
        BtnSubmit.click();
    }
    public String transformmes(String mes){
        switch (mes){
            case "1":
                return "Enero";
            case "01":
                return "Enero";
            case "2":
                return "Febrero";
            case "02":
                return "Febrero";
            case "3":
                return "Marzo";
            case "03":
                return "Marzo";
            case "4":
                return "Abril";
            case "04":
                return "Abril";
            case "5":
                return "Mayo";
            case "05":
                return "Mayo";
            case "6":
                return "Junio";
            case "06":
                return "Junio";
            case "7":
                return "Julio";
            case "07":
                return "Julio";
            case "8":
                return "Agosto";
            case "08":
                return "Agosto";
            case "9":
                return "Septiembre";
            case "09":
                return "Septiembre";
            case "10":
                return "Octubre";
            case "11":
                return "Noviembre";
            case "12":
                return "Diciembre";
            default:
                return "";
        }
    }

    public String transformmes2(String mes){
        switch (mes){
            case "Enero":
                return "1";
            case "Febrero":
                return "2";
            case "Marzo":
                return "3";
            case "Abril":
                return "4";
            case "Mayo":
                return "5";
            case "Junio":
                return "6";
            case "Julio":
                return "7";
            case "Agosto":
                return "8";
            case "Septiembre":
                return "9";
            case "Octubre":
                return "10";
            case "Noviembre":
                return "11";
            case "Diciembre":
                return "12";
            default:
                return "";
        }
    }
}
