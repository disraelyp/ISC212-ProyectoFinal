package logic;

import java.util.ArrayList;

public class TarjetaMadre extends Componente{
	
	private String conexion;
	private int tipoRAM;
	private ArrayList<Integer> tipoDisco;
	
	public TarjetaMadre(String serie, String modelo, String marca, int cantidad, float precio, float costo,
			String conexion, int tipoRAM, ArrayList<Integer> tipoDisco) {
		super(serie, modelo, marca, cantidad, precio, costo);
		this.conexion = conexion;
		this.tipoRAM = tipoRAM;
		this.tipoDisco = tipoDisco;
	}

	public String getConexion() {
		return conexion;
	}
	public void setConexion(String conexion) {
		this.conexion = conexion;
	}
	public int getTipoRAM() {
		return tipoRAM;
	}
	public void setTipoRAM(int tipoRAM) {
		this.tipoRAM = tipoRAM;
	}
	public ArrayList<Integer> getTipoDisco() {
		return tipoDisco;
	}
	public void setTipoDisco(ArrayList<Integer> tipoDisco) {
		this.tipoDisco = tipoDisco;
	}
	
}
