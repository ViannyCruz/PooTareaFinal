package logico;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
/*
		Recurso recursi1 = new Recurso("1", "Papo", "Bocina");
		CoordinacionEvento.getInstance().getRecursos().add(recursi1);
		Recurso recursi2 = new Recurso("2", "Mario", "Bocina");
		CoordinacionEvento.getInstance().getRecursos().add(recursi2);


		//CoordinacionEvento.getInstance().juanCarajo();
		CoordinacionEvento.getInstance().getRecursos().remove(recursi1);
		CoordinacionEvento.getInstance().getRecursos().remove(recursi2);

		
		//CoordinacionEvento.getInstance().take();
		
	    System.out.println(CoordinacionEvento.getInstance().getRecursos().get(0).getNombre());
	    System.out.println(CoordinacionEvento.getInstance().getRecursos().get(1).getNombre());

		*/
		// Escribir
		
		
		
		
		
		
		
		//Participante parti01 = new Participante("1", "Juan", "11");
		//Participante parti02 = new Participante("2", "Tutu", "22");

		//CoordinacionEvento.getInstance().getPersonas().add(parti01);
		//CoordinacionEvento.getInstance().getPersonas().add(parti02);

		//CoordinacionEvento.getInstance().saveRecurso();
		//CoordinacionEvento.getInstance().loadRecurso();

		
		/*
		FileOutputStream fos = new FileOutputStream("fgh.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(CoordinacionEvento.getInstance().getPersonas());
		oos.close();
		
		*/
		
		/*
		CoordinacionEvento.getInstance().setPersonas(new ArrayList<>());		
		FileInputStream fis = new FileInputStream("azul.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);		
		CoordinacionEvento.getInstance().setPersonas((ArrayList<Persona>) ois.readObject());
*/
		
		//ois.close();
		
		
		//System.out.println(CoordinacionEvento.getInstance().getPersonas().get(0).getNombre());
		//System.out.println(CoordinacionEvento.getInstance().getPersonas().get(1).getNombre());

		
	}

}
