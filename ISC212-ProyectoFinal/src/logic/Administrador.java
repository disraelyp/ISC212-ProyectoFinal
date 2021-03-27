package logic;

public class Administrador extends Empleado{
	
	private int añosExperiencia;
	private float extraSueldo;
	private float comision;
	
	public Administrador(String cedula, String nombre, String telefono, String direccion, String codigo, float sueldoBase,
			int horasExtra, int añosExperiencia, float extraSueldo, float comision) {
		super(cedula, nombre, telefono, direccion, codigo, sueldoBase, horasExtra);
		this.añosExperiencia = añosExperiencia;
		this.extraSueldo = extraSueldo;
		this.comision = comision;
	}

	public int getAñosExperiencia() {
		return añosExperiencia;
	}
	public void setAñosExperiencia(int añosExperiencia) {
		this.añosExperiencia = añosExperiencia;
	}
	public float getExtraSueldo() {
		return extraSueldo;
	}
	public void setExtraSueldo(float extraSueldo) {
		this.extraSueldo = extraSueldo;
	}
	public float getComision() {
		return comision;
	}
	public void setComision(float comision) {
		this.comision = comision;
	}
	
}
