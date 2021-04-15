package logic;

import java.util.Comparator;

public class OrdenarCantidadProducto implements Comparator<Producto> {
    @Override
    public int compare(Producto o1, Producto o2) {
        return (""+o2.getCantidad()).compareToIgnoreCase((""+o1.getCantidad()));
    }
}
