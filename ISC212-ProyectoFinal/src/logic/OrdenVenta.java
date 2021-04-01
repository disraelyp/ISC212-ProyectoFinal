package logic;

import java.util.ArrayList;

public class OrdenVenta {
	private static int idFactura=1;
	private String codigo;
	private Cliente cliente;
	private Empleado empleado;
	private ArrayList<Producto> productos;
	
	public OrdenVenta(Cliente cliente, Empleado empleado, ArrayList<Producto> productos) {
		super();
		this.codigo = "F-"+idFactura;
		this.cliente = cliente;
		this.empleado = empleado;
		this.productos = productos;
		idFactura++;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	public float getMontoTotal() {
		float montoTotal=0;
		for(Producto x: productos) {
			montoTotal+=x.getPrecio();
		}
		return montoTotal;
	}
	
	
}
