package logic;

import java.util.Comparator;

public class OrdenarNombreEmpleado implements Comparator<Empleado> {
    @Override
    public int compare(Empleado o1, Empleado o2) {
        return o2.getNombre().compareToIgnoreCase(o1.getNombre());
    }
}

