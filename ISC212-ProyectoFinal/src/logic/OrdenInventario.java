package logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class OrdenInventario {
	protected Proveedor proveedor;
	protected Date fecha;
	protected Administrador administrador;
	protected int plazoPago;
	protected ArrayList<Componente> componentes;
	
	public OrdenInventario(Proveedor proveedor, Date fecha, Administrador administrador, int plazoPago,
			ArrayList<Componente> componentes) {
		super();
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.administrador = administrador;
		this.plazoPago = plazoPago;
		this.componentes = componentes;
	}
	
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Administrador getAdministrador() {
		return administrador;
	}
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	public ArrayList<Componente> getComponentes() {
		return componentes;
	}
	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}
	public int getPlazoPago() {
		return plazoPago;
	}
	public void setPlazoPago(int plazoPago) {
		this.plazoPago = plazoPago;
	}
	
	
	public String getFechaTexto() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		String fechat = formato.format(fecha);
		return fechat;
	}
	public String getFechaPago() {
		if (plazoPago==0) return getFechaTexto();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); 
		calendar.add(Calendar.DAY_OF_YEAR, plazoPago);  
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		String fechat = formato.format(calendar.getTime());
		return fechat;
	}
	public float getCostoTotal() {
		float costoTotal=0;
		for(Componente x: componentes) {
			costoTotal+=x.getCosto();
		}
		return costoTotal;
	}

}
