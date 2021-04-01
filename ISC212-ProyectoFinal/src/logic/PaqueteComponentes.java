package logic;

import java.util.ArrayList;

public class PaqueteComponentes extends Producto{
	
	private static int idPaqueteComponentes =1;
	
	private Administrador administrador;
	private ArrayList<Componente> productos;
	private float descuento;
	
	public PaqueteComponentes(Administrador administrador, ArrayList<Componente> productos, float descuento, int cantidad) {
		super("P-"+idPaqueteComponentes, cantidad);
		this.administrador = administrador;
		this.productos = productos;
		this.descuento = descuento;
		idPaqueteComponentes++;
	}

	public static int getIdPaqueteComponentes() {
		return idPaqueteComponentes;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Administrador getAdministrador() {
		return administrador;
	}
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	public ArrayList<Componente> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Componente> productos) {
		this.productos = productos;
	}
	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	
	@Override
	public float getPrecio() {
		float precio=0;
		for(Componente x: productos) {
			precio+=(x.getPrecio()*(descuento/100));
		}
		return precio;
	}
	@Override
	public float getCosto() {
		float costo=0;
		for(Componente x: productos) {
			costo+=(x.getCosto());
		}
		return costo;
	}


}
