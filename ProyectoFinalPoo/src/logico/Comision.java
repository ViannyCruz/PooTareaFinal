package logico;

import java.util.ArrayList;

public class Comision {

	private String codigo;
	private String area;
	private Persona moderador;
	private ArrayList<Jurado> jurados;
	
	public Comision(String area, Persona moderador) {
		super();
		this.codigo = " ";
		this.area = area;
		this.moderador = moderador;
		this.jurados = new ArrayList<>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Persona getModerador() {
		return moderador;
	}

	public void setModerador(Persona moderador) {
		this.moderador = moderador;
	}

	public ArrayList<Jurado> getJurados() {
		return jurados;
	}

	public void setJurados(ArrayList<Jurado> jurados) {
		this.jurados = jurados;
	}
	
}
