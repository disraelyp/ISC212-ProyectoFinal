package logic;

import java.util.Comparator;

public class OrdenarMontoOrdenVenta implements Comparator<OrdenVenta> {
    @Override
    public int compare(OrdenVenta o1, OrdenVenta o2) {
        return (""+o2.getMontoTotal()).compareToIgnoreCase((""+o1.getMontoTotal()));
    }
}
