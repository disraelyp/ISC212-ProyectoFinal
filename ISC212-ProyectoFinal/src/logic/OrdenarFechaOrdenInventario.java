package logic;

import java.util.Comparator;

public class OrdenarFechaOrdenInventario implements Comparator<OrdenInventario> {
    @Override
    public int compare(OrdenInventario o1, OrdenInventario o2) {
        return (o2.getFecha()).compareTo(o1.getFecha());
    }
}
