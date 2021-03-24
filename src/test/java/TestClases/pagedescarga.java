package TestClases;

import Pages.Descarga;
import Utils.Espera;
import Utils.ReadProperties;

import java.io.File;

public class pagedescarga {
    public void confirmarPreviaDescarga(){
        File carpeta = new File(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Rutafolder"));
        String[] archivos = carpeta.list();
        for(int i=0; i< archivos.length;i++){
            if(archivos[i].equals(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Nombrearchivo"))){
                File archivo = new File(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Rutafolder")+"/"+archivos[i]);
                archivo.delete();
            }
        }
    }
    public void descargarsomefile(){
            Espera.esperar("//*[@id=\"dwrecbox\"]/div");
            Descarga DC = new Descarga();
            DC.descargar();
    }
    public void confirmarDescarga(){
        File carpeta = new File(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Rutafolder"));
        String[] archivos = carpeta.list();
        for(int i=0; i< archivos.length;i++){
            if(archivos[i].equals(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Nombrearchivo"))){
                System.out.println("el archivo se descargo correctamente");
            }
        }

    }
}
