package logico;

public class Jurado extends Persona {

	private String especialidad;
	
	public Jurado(String cedula, String nombre, String numero, String especialidad) {
		super(cedula, nombre, numero);
		
		this.especialidad = especialidad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

}
