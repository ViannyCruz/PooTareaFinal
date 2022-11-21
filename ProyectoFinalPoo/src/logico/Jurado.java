package logico;

public class Jurado extends Persona {

	private String tipo;
	private String especialidad;
	
	public Jurado(String cedula, String nombre, String numero, String tipo, String especialidad) {
		super(cedula, nombre, numero);
		
		this.tipo = tipo;
		this.especialidad = especialidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

}
