package TestClases;

import Pages.PageSodimac;
import TestClases.Model.Producto;
import Utils.ReadProperties;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.File;

public class Sodimac {
    public ArrayList<Producto> obtenerProductos(){
        PageSodimac pag = new PageSodimac();
        ArrayList<Producto> contenido = pag.obtenerProductos1();
        try {
            creartxt(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido;
    }
    public void creartxt(ArrayList<Producto> contenido) throws IOException {

        String ruta = ReadProperties.readFromConfig("Propiedades.properties").getProperty("Rutafolder")+"\\archivo.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()) {
            archivo.delete();
        }
        bw = new BufferedWriter(new FileWriter(archivo));
        for(int i=0; i<contenido.size();i++) {
            bw.write(contenido.get(i).getNombre());
            bw.newLine();
            bw.newLine();
            bw.write(String.valueOf(contenido.get(i).getPrecio()));
            bw.newLine();
            bw.newLine();
            bw.write(String.valueOf(contenido.get(i).getCalificacion())+"/10");
            bw.newLine();
            bw.newLine();
            for(int j=0; j<contenido.get(i).getDescipcion().length ; j++){
                bw.write(contenido.get(i).getDescipcion()[j]);
                bw.newLine();
            }
            bw.newLine();
            bw.newLine();
            bw.newLine();
        }
        bw.close();
    }
}

