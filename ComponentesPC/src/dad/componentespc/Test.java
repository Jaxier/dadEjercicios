package dad.componentespc;

import java.time.LocalDate;

import dad.componentespc.model.DiscoDuro;
import dad.componentespc.model.Equipo;
import dad.componentespc.model.PlacaBase;
import dad.componentespc.model.Presupuesto;

public class Test {

	public static void main(String[] args) {
		
		DiscoDuro d1 = new DiscoDuro();
		d1.setCapacidad(500.0);
		d1.setMarca("WD");
		d1.setModelo("Caviar Blue");
		d1.setSdd(false);

		DiscoDuro d2 = new DiscoDuro();
		d2.setCapacidad(128.0);
		d2.setMarca("Maxtor");
		d2.setModelo("xx-ddd-asda");
		d2.setSdd(true);
		
		PlacaBase placa = new PlacaBase();
		placa.setSocket("LGA1155");
		placa.setMarca("MSI");
		placa.setModelo("Bazokka 3000");
		
		
		Equipo e1 = new Equipo();
		e1.setId("equipo1");
		e1.setFechaEnsamblado(LocalDate.now());
		
		Presupuesto miPresupuesto = new Presupuesto();
		miPresupuesto.setCliente("Bruce Lee");
		miPresupuesto.getEquipos().add(e1);
			

	}

}
