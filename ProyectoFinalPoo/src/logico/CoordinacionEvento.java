package logico;

import java.io.DataOutput;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class CoordinacionEvento {
	

	
	private ArrayList<Evento> eventos;
	private ArrayList<Persona> personas;
	private ArrayList<TrabajoCientifico> trabajosCientificos;
	
	private ArrayList<Recurso> recursos;
	
	private static CoordinacionEvento coordinacionEventos = null;
	
	public static int genCodeEvento = 1;
	public static int genCodePersona = 1;
	public static int genCodeTrabajo = 1;
	public static int genCodeRecurso = 1;



	
	

	public CoordinacionEvento() {
		super();
		this.eventos = new ArrayList<>();
		this.personas = new ArrayList<>();
		this.trabajosCientificos =new ArrayList<>();
		this.recursos = new ArrayList<>();
	}

	public static CoordinacionEvento getInstance(){
		if(coordinacionEventos == null){
			coordinacionEventos = new CoordinacionEvento();  
		} 	   
		return coordinacionEventos;
	}
	
	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}

	public ArrayList<TrabajoCientifico> getTrabajosCientificos() {
		return trabajosCientificos;
	}

	public void setTrabajosCientificos(ArrayList<TrabajoCientifico> trabajosCientificos) {
		this.trabajosCientificos = trabajosCientificos;
	}

	public ArrayList<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(ArrayList<Recurso> recursos) {
		this.recursos = recursos;
	}
	
	public void insertarEvento(Evento evento) {
		eventos.add(evento);	
		genCodeEvento++;
	}
	public void insertarPersona(Persona persona) {
		personas.add(persona);
		genCodePersona++;
	}
	public void insertarTrabajo(TrabajoCientifico trabajo) {
		trabajosCientificos.add(trabajo);
		genCodeTrabajo++;
	}
	public void insertarRecurso(Recurso recurso) {
		recursos.add(recurso);
		genCodeRecurso++;
	}
	
	
	public Evento getEventoByCode(String codigo)
	{
		Evento eventoAux =  null;
		for (Evento evento : eventos) {
			if(evento.getCodigo().equalsIgnoreCase(codigo))
				eventoAux =  evento;
		}

		return eventoAux;
	}
	
	public Persona getPersonaByCedula(String cedula)
	{
		Persona personaAux =  null;
		for (Persona persona : personas) {
			if(persona.getCedula().equalsIgnoreCase(cedula))
				personaAux =  persona;
		}

		return personaAux;
	}
	
	public Persona getJuradoByCedula(String cedula)
	{
		Persona juradoAux =  null;
		for (Persona persona : personas) {
			if(persona.getCedula().equalsIgnoreCase(cedula))
				if(persona instanceof Jurado)
					juradoAux =  persona;
		}

		return juradoAux;
	}
	
	public Persona getParticipanteByCedula(String cedula)
	{
		Persona participanteAux =  null;
		for (Persona persona : personas) {
			if(persona.getCedula().equalsIgnoreCase(cedula))
				if(persona instanceof Participante)
					participanteAux =  persona;
		}

		return participanteAux;
	}
	
	
	public TrabajoCientifico getTrabajoCientificoByCode(String codigo)
	{
		TrabajoCientifico trabajoAux =  null;
		for (TrabajoCientifico trabajo : trabajosCientificos) {
			if(trabajo.getCodigo().equalsIgnoreCase(codigo))
				trabajoAux =  trabajo;
		}

		return trabajoAux;
	}
	
	public Recurso getRecursoByCode(String codigo)
	{
		Recurso recursoAux =  null;
		for (Recurso recurso : recursos) {
			if(recurso.getCodigo().equalsIgnoreCase(codigo))
				recursoAux =  recurso;
		}

		return recursoAux;
	}
	
	
	/*
	public void save()
	{
		Recurso tutiRecurso = new Recurso("1234", "tuti", "Bocina");

		try{
		    FileOutputStream writeData = new FileOutputStream("juan.dat");
		    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

		    int size = recursos.size();
		    for(int i = 0; i < size; i++)
		    {
			    writeStream.writeObject(recursos.get(i));

		    	//Recurso recursoAux = (Recurso) readStream.readObject();
		    	//tusRealesRecursos.add(recursoAux);
		    	
		    }
		    
		    //writeStream.writeObject(tutiRecurso);
		    writeStream.flush();
		    writeStream.close();

		}catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	public void take()
	{
		try{
		    FileInputStream f = new FileInputStream("juan.dat");
		    ObjectInputStream oos = new ObjectInputStream(f);

		    
		}catch (Exception e)
		{
		    e.printStackTrace();
		}
	}
	
	
	
	public void juan() throws IOException, ClassNotFoundException
	{
		FileInputStream f = new FileInputStream("juan.dat");
	    ObjectInputStream oos = new ObjectInputStream(f);
		
	
		int size = oos.readInt();
		for (int i = 0; i < size; i++)
		{		
			Recurso a = (Recurso)oos.readObject();
		}
					
	}
	
	public void juanCarajo() throws IOException, ClassNotFoundException
	{
		FileInputStream f = new FileInputStream("juan.dat");
	    ObjectInputStream oos = new ObjectInputStream(f);
		
	    ((DataOutput) oos).writeInt(recursos.size());
		for (Recurso recurso : recursos) {
			((ObjectOutput) oos).writeObject(recurso);
		}
	
		
					
	}
	*/
}
