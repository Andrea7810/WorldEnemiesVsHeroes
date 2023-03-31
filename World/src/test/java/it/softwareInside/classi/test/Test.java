package it.softwareInside.classi.test;

import it.softwareInside.eroi.Cavaliere;
import it.softwareInside.eroi.Cavallo;
import it.softwareInside.eroi.Freccia;
import it.softwareInside.eroi.Mago;
import it.softwareInside.eroi.Pozione;
import it.softwareInside.nemici.Dragone;
import it.softwareInside.nemici.Orco;
import it.softwareInside.world.World;

public class Test {

	@org.junit.Test
	public void testEroi() {

		
		
		Mago mago1 = new Mago(30, 100,"Mago Horz", 100);
		
		
		mago1.addPozione(new Pozione(20));
		mago1.addPozione(new Pozione(20));
		mago1.addPozione(new Pozione(20));
		mago1.addPozione(new Pozione(20));
		mago1.addPozione(new Pozione(20));
		mago1.addPozione(new Pozione(20));
		mago1.addPozione(new Pozione(20));
		mago1.addPozione(new Pozione(20));
		mago1.addPozione(new Pozione(20));
		mago1.addPozione(new Pozione(20));

		mago1.recuperaMana(50);
		
	//	System.out.println(mago1.toString());
		
		mago1.recuperaSalute();
		mago1.recuperaSalute();

		
		mago1.addPozione(new Pozione(20));
		mago1.addPozione(new Pozione(20));

		
		System.out.println(mago1.toString());
	//	mago1.showPozioni();
	
	
		Mago mago2 = new Mago(20, 30, "Mago Loris", 100);
		
		System.out.println(mago2.toString());
		
		mago1.curaAlleato(mago2);
		
		System.out.println(mago2.toString());
		
	}

	
	@org.junit.Test
	public void testNemici() {
		
		
		Dragone dragone = new Dragone(100, 20, 100);
		
		System.out.println(dragone);
		
		
		
	}
	
	
	
	
	@org.junit.Test
	public void testWorld() {
		
		World world = new World();
		
		Orco orco = new Orco(100, 20);
		orco.inserisciCorazza(30);
		Cavaliere cavaliere = new Cavaliere(25, 100, "Carl", new Cavallo("Mac", "Bianco"));
				
		cavaliere.addFreccia(new Freccia("Freccia infuocata", 26));
		
		Mago mago = new Mago(25, 100, "Mago horz", 100);
		Dragone dragone = new Dragone(100, 25, 100);
		
		
		try {
			world.combattimento(mago, dragone);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
