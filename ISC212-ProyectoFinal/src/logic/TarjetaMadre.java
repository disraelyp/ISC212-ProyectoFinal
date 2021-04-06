package logic;

import java.util.ArrayList;

public class TarjetaMadre extends Componente{
	
	private int tipoMicro; 
	private int tipoRAM;
	private ArrayList<Integer> tipoDisco;
	
	public TarjetaMadre(String codigo, String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo,
			int tipoMicro, int tipoRAM, ArrayList<Integer> tipoDisco) {
		super(codigo, modelo, marca, cantidad, cantidadMinima, precio, costo);
		this.tipoMicro = tipoMicro;
		this.tipoRAM = tipoRAM;
		this.tipoDisco = tipoDisco;
	}
	
	public int getTipoMicro() {
		return tipoMicro;
	}
	public void setTipoMicro(int tipoMicro) {
		this.tipoMicro = tipoMicro;
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
