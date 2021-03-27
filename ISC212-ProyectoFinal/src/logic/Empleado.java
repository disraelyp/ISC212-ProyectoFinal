package logic;

public class Empleado extends Persona{
	protected String codigo;
	protected float sueldo;
	protected int horasExtra;
		
	public Empleado(String cedula, String nombre, String telefono, String direccion, String codigo, float sueldo, int horasExtra) {
		super(cedula, nombre, telefono, direccion);
		this.codigo = codigo;
		this.sueldo = sueldo;
		this.horasExtra = horasExtra;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldoBase) {
		this.sueldo = sueldoBase;
	}
	public int getHorasExtra() {
		return horasExtra;
	}
	public void setHorasExtra(int horasExtra) {
		this.horasExtra = horasExtra;
	}
	
}
