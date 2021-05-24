package TestClases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class compararImagenes {
    public int compararColores() throws IOException {
        int coincidencia =0;
        BufferedImage buff1 =  ImageIO.read(new File("C:\\Users\\qanova\\Documents\\GitHub\\SCP_003\\tmp\\vector-side-of-the-red-car.jpg"));
        int w1 = buff1.getWidth();
        int h1 = buff1.getHeight();
        int[] rgbs1 = new int[w1 * h1];
        buff1.getRGB(0, 0, w1, h1, rgbs1, 0, w1);
        BufferedImage buff2 =  ImageIO.read(new File("C:\\Users\\qanova\\Documents\\GitHub\\SCP_003\\tmp\\vector-side-of-the-red-carb.jpg"));
        int w2 = buff2.getWidth();
        int h2 = buff2.getHeight();
        int[] rgbs2 = new int[w2 * h2];
        buff2.getRGB(0, 0, w2, h2, rgbs2, 0, w2);
        if (rgbs1.equals(rgbs2)){ return 100;}
            if (rgbs1.length == rgbs2.length) {
            for (int i = 0; i < rgbs1.length; i++) {
                if (rgbs1[i] == rgbs2[i]) {
                    coincidencia = coincidencia + 100;
                }else {
                    int k = 0;
                    int a = (100 * rgbs2[i])/rgbs1[i];
                    int b = (rgbs1[i] * 100)/rgbs2[i];
                    k = a-b;
                    if (k<0){k = k*(-1);}
                    k = k/17000000;
                    coincidencia = coincidencia+ k;
                }
            }
        }
        coincidencia = coincidencia/rgbs1.length;
        return coincidencia;
    }
}
