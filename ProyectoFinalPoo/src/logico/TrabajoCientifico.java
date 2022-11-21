package logico;

import java.util.Date;

public class TrabajoCientifico {

	private String codigo;
	private String nombre;
	private Date fecha;
	
	public TrabajoCientifico(String codigo, String nombre, Date fecha) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fecha = fecha;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
