package dad.codegen;

import java.io.File;

import dad.codegen.model.javafx.Bean;
import dad.codegen.model.javafx.FXModel;
import dad.codegen.model.javafx.Property;
import dad.codegen.model.javafx.Type;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// -------------------------------------------
		// crea el bean FX "Identificable" con la
		// propiedad: id
		
		Property id = new Property();
		id.setName("id");
		id.setType(Type.LONG);

		Bean identificable = new Bean();
		identificable.setName("Identificable");
		identificable.getProperties().add(id);
		
		// -------------------------------------------
		// crea el bean FX "Telefono" que hereda de
		// el bean "Ientificable" y que tiene la
		// propiedad: numero
		
		Property numero = new Property();
		numero.setName("numero");
		numero.setType(Type.STRING);
		
		Bean telefono = new Bean();
		telefono.setName("Telefono");
		telefono.setParent(identificable);
		telefono.getProperties().add(numero);

		// -------------------------------------------
		// crea el bean FX "Contacto" con las 
		// propiedades: nombre, apellidos y telefonos
		
		Property nombre = new Property();
		nombre.setName("nombre");
		nombre.setType(Type.STRING);
		
		Property apellidos = new Property();
		apellidos.setName("apellidos");
		apellidos.setType(Type.STRING);
		
		Property fechaNacimiento = new Property();
		fechaNacimiento.setName("fechaNacimiento");
		fechaNacimiento.setType(Type.DATE);
		
		Property edad = new Property();
		edad.setName("edad");
		edad.setType(Type.INTEGER);
		edad.setReadOnly(true);

		Property telefonos = new Property();
		telefonos.setName("telefonos");
		telefonos.setType(Type.LIST);
		telefonos.setGeneric(telefono);		// indica que la lista es de beans de tipo "Telefono"
	
		Bean persona = new Bean();
		persona.setName("Persona");
		persona.setParent(identificable);
		persona.getProperties().addAll(nombre, apellidos, fechaNacimiento, edad, telefonos);
		
		// -------------------------------------------
		// crea el modelo FX y le añade los beans: Telefono 
		// y Persona
		
		FXModel model = new FXModel();
		model.setPackageName("dad.agenda.model");	// paquete donde se genera código 
		model.getBeans().addAll(identificable, telefono, persona);
		
		// -------------------------------------------
		// genera el código de los beans FX en el directorio "gen"
		// - crea los paquetes necesarios y dentro los ficheros ".java" 
		// de cada bean FX (Identificable, Telefono y Persona)
		model.generateCode(new File("gen"));

		// -------------------------------------------
		// guarda el modelo en un fichero en formato XML
		model.save(new File("agenda.fx"));
		
		// -------------------------------------------
		// guarda el modelo en un fichero en formato XML
		model = FXModel.load(new File("agenda.fx"));
		
	}

}
