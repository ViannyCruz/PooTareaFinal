package logico;

import java.util.ArrayList;
import java.util.Date;

public class Evento {

	private String codigo;
	private String nombre;
	private Date fecha;
	private String hora;
	private String ubicacion;
	private String tipo;
	private String tema;
	private ArrayList<Comision> comisiones;
	private ArrayList<Persona> participantes;
	private ArrayList<Recurso> recursos;
	
	public Evento(String codigo, String nombre, Date fecha, String hora, String ubicacion, String tipo, String tema) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fecha = fecha;
		this.hora = hora;
		this.ubicacion = ubicacion;
		this.tipo = tipo;
		this.tema = tema;
		this.comisiones = new ArrayList<>();
		this.participantes = new ArrayList<>();
		this.recursos = new ArrayList<>();
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

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}

	public void setComisiones(ArrayList<Comision> comisiones) {
		this.comisiones = comisiones;
	}

	public ArrayList<Persona> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Persona> participantes) {
		this.participantes = participantes;
	}

	public ArrayList<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(ArrayList<Recurso> recursos) {
		this.recursos = recursos;
	}
	
	
}
