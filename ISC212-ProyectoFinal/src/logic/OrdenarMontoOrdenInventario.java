package logic;

import java.util.Comparator;

public class OrdenarMontoOrdenInventario implements Comparator<OrdenInventario> {
    @Override
    public int compare(OrdenInventario o1, OrdenInventario o2) {
        return (""+o2.getCostoTotal()).compareToIgnoreCase(""+o1.getCostoTotal());
    }
}
