package logic;

import java.util.Comparator;

public class OrdenFechaOrdenVenta implements Comparator<OrdenVenta> {
    @Override
    public int compare(OrdenVenta o1, OrdenVenta o2) {
        return o2.getFecha().compareTo(o1.getFecha());
    }
}
