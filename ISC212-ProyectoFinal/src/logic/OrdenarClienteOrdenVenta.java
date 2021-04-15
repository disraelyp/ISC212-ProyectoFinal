package logic;

import java.util.Comparator;

public class OrdenarClienteOrdenVenta implements Comparator<OrdenVenta> {
    @Override
    public int compare(OrdenVenta o1, OrdenVenta o2) {
        return o2.getCliente().getNombre().compareToIgnoreCase(o1.getCliente().getNombre());
    }
}
