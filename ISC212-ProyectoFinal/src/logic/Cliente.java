package logic;

public class Cliente extends Persona{
	private float creditoLimite;
	
	public Cliente(String cedula, String nombre, String telefono, String direccion,	float creditoLimite) {
		super(cedula, nombre, telefono, direccion);
		this.creditoLimite = creditoLimite;
	}


	public float getCreditoLimite() {
		return creditoLimite;
	}
	public void setCreditoLimite(float creditoLimite) {
		this.creditoLimite = creditoLimite;
	}
		
}
