package TestClases;

import Pages.Login1;
import Utils.DriverContext;
import Utils.Espera;
import Utils.ReadProperties;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Scanner;

public class api {


    //Get http://localhost:2024/carga-masiva/de/profesionales
    //http://192.168.1.100:2024/carga-masiva/de/profesionales

    public void aptTesting() throws Exception {
        try {
            URL url = new URL("http://192.168.1.100:2024/carga-masiva/de/profesionales");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code :" + conn.getResponseCode());
            }
            Scanner scan = new Scanner(url.openStream());
            String entireResponse = new String();
            while (scan.hasNext())
                entireResponse += scan.nextLine();
            System.out.println("Response : "+entireResponse);
            scan.close();
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(entireResponse);
            JSONArray listaUsuario = (JSONArray) obj;
            listaUsuario.forEach( emp -> System.out.println( (JSONObject) emp) );

            //JSONObject obj2 = new JSONObject((JSONObject) obj);


            //String Cuenta = (String) obj2.get("");


            System.out.println("status : " + obj);
//            JSONArray arr = obj.getJSONArray("results");
            //          for (int i = 0; i < arr.length(); i++) {
            //            String placeid = arr.getJSONObject(i).getString("place_id");
            //          System.out.println("Place id : " + placeid);
            //        String formatAddress = arr.getJSONObject(i).getString(
            //              "formatted_address");
            //    System.out.println("Address : " + formatAddress);
//validating Address as per the requirement
            //  if(formatAddress.equalsIgnoreCase("Chicago, IL, USA"))
            //{
            //  System.out.println("Address is as Expected");
//                }
            //              else
            //            {
            //              System.out.println("Address is not as Expected");
            //        }
            //  }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void consultarfarmacias() throws Exception {
        try {
            URL url = new URL("https://farmanet.minsal.cl/maps/index.php/ws/getLocalesTurnos");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code :" + conn.getResponseCode());
            }
            Scanner scan = new Scanner(url.openStream());
            String entireResponse = new String();
            while (scan.hasNext())
                entireResponse += scan.nextLine();
            System.out.println("Response : "+entireResponse);
            scan.close();
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(entireResponse);
            JSONArray listaUsuario = (JSONArray) obj;
            listaUsuario.forEach( emp -> {
                System.out.println(emp);
                JSONObject obj2 = new JSONObject((JSONObject) emp);
                String Nombre = CapitalizeFirstLetter(String.valueOf(obj2.get("local_nombre")));
                String Localidad = CapitalizeFirstLetter(String.valueOf(obj2.get("comuna_nombre")));
                DriverContext.getDriver().navigate().to("https://maps.google.com/?q="+(String) obj2.get("local_lat")+","+(String) obj2.get("local_lng"));
                try {
                    Espera.esperar(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                PdfQaNovaReports.addWebReportImage("Farmacia en turno: "+Nombre, "La farmacia en turno "+Nombre +" de la localidad de: "+Localidad+" se encuentra en : ", EstadoPrueba.DONE, false);

            });
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String CapitalizeFirstLetter(String value)
    {
        String v = value.toLowerCase();
        String[] b = v.split(" ");
        String t = "";

        for(String n :b){
            String k = n.toUpperCase();
            n = n.replaceFirst(n.substring(0,1),k.substring(0,1));
            t = t+" "+n;
        }
        return t;
    }
}
