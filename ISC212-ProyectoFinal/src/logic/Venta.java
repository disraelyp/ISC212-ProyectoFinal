package logic;

import java.util.ArrayList;

public class Venta {
	private String codigo;
	private Cliente cliente;
	private Empleado empleado;
	private ArrayList<Componente> productos;
	private ArrayList<PaqueteComponentes> paqueteProductos;
	
	public Venta(String codigo, Cliente cliente, Empleado empleado, ArrayList<Componente> productos,
			ArrayList<PaqueteComponentes> paqueteProductos) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.empleado = empleado;
		this.productos = productos;
		this.paqueteProductos = paqueteProductos;
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
	public Empleado getVendedor() {
		return empleado;
	}
	public void setVendedor(Empleado empleado) {
		this.empleado = empleado;
	}
	public ArrayList<Componente> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Componente> productos) {
		this.productos = productos;
	}
	public ArrayList<PaqueteComponentes> getPaqueteProductos() {
		return paqueteProductos;
	}
	public void setPaqueteProductos(ArrayList<PaqueteComponentes> paqueteProductos) {
		this.paqueteProductos = paqueteProductos;
	}
	
	public float getMontoTotal() {
		float montoTotal=0;
		for(Componente x: productos) {
			montoTotal+=x.getPrecio();
		}
		for(PaqueteComponentes x: paqueteProductos) {
			montoTotal+=x.getPrecio();
		}
		return montoTotal;
	}
	
	
}
