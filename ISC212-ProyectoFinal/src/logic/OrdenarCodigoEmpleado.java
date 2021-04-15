package logic;

import java.util.Comparator;

public class OrdenarCodigoEmpleado implements Comparator<Empleado> {
    @Override
    public int compare(Empleado o1, Empleado o2) {
        return o2.getCodigo().compareToIgnoreCase(o1.getCodigo());
    }
}

