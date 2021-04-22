package TestClases;

import Pages.Chileautos.Auto;
import Pages.Chileautos.Busqueda;
import Pages.Chileautos.Inicio;

import java.util.List;

public class chileautos {
    public void Buscar(){
        Inicio ini = new Inicio();
        ini.buscarCasaRodante();
        Busqueda bus = new Busqueda();
        String cantFotos = bus.obtenervalores();
        bus.ingresar();
        Auto auto = new Auto();
        List<String> detalles = auto.recuperarDetalles();
        auto.recuperarfotos(cantFotos);
    }
}
