package logic;

public class Empleado extends Persona{
	// Padre: Persona
	// Hijos: Vendedor y Administrador
	protected String codigo;
	protected float sueldoBase;
	protected int horasExtra;
	
	
	public Empleado(String cedula, String nombre, String telefono, String direccion, String codigo, float sueldoBase, int horasExtra) {
		super(cedula, nombre, telefono, direccion);
		this.codigo = codigo;
		this.sueldoBase = sueldoBase;
		this.horasExtra = horasExtra;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public float getSueldoBase() {
		return sueldoBase;
	}


	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}


	public int getHorasExtra() {
		return horasExtra;
	}


	public void setHorasExtra(int horasExtra) {
		this.horasExtra = horasExtra;
	}
	
}
