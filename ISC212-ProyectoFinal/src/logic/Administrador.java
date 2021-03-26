package logic;

public class Administrador extends Empleado{
	//Padre: Empleado
	private int añosExperiencia;
	private float extraSueldo;
	
	public Administrador(String cedula, String nombre, String telefono, String direccion, String codigo, float sueldoBase,
			int horasExtra, int añosExperiencia, float extraSueldo) {
		super(cedula, nombre, telefono, direccion, codigo, sueldoBase, horasExtra);
		this.añosExperiencia = añosExperiencia;
		this.extraSueldo = extraSueldo;
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
	
	
	
}
