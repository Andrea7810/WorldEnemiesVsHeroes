package it.softwareInside.world;

import java.util.ArrayList;
import java.util.Random;

import it.softwareInside.eroi.Cavaliere;
import it.softwareInside.eroi.Eroe;
import it.softwareInside.eroi.Mago;
import it.softwareInside.nemici.Dragone;
import it.softwareInside.nemici.Nemico;
import it.softwareInside.nemici.Orco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class World {

	private ArrayList<Eroe> eroi;
	private ArrayList<Nemico> nemici;
	
	
	
	public boolean addEroe (Eroe eroe) {
		
		try {
			eroi.add(eroe);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
	
	public boolean rimuoviEroe (int id) {
		
		try {
			eroi.remove(id);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
	
	public boolean addNemico (Nemico nemico) {
		
		try {
			nemici.add(nemico);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
	
	public boolean rimuoviNemico (int id) {
		
		try {
			nemici.remove(id);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
	
	public Object whoStart (Nemico nemico , Eroe eroe) {
		
		Random r = new Random();
		return r.nextInt(1 , 11) <= 5 ? nemico : eroe;
	}
	
	
	
	public void combattimento (Eroe eroe, Nemico nemico) throws InterruptedException {
		
		System.out.println("####INIZIO GIOCO####");
		
		Thread.sleep(3 * 1000);
		
		System.out.println("nota: E' POSSIBILE FAR BATTERE SOLO MAGO VS DRAGONE O ORCO VS CAVALIERE");
		
		
		
		if (whoStart(nemico, eroe) instanceof Dragone) {
			Thread.sleep(3 * 1000);

			System.out.println("####DRAGONE VS MAGO####");
			System.out.println("INIZIA IL DRAGONE!");

			Dragone dragone = (Dragone) nemico;
			Mago mago = (Mago) eroe;
			
			while (dragone.isAlive() && mago.isAlive()) {
				Thread.sleep(3 * 1000);

				System.out.println("DRAGONE ATTACCA!!" + " DANNO INFLITTO: " + dragone.attaccoDiFuoco(mago) );
				Thread.sleep(3 * 1000);

				if (eroe.isAlive() == false || nemico.isAlive() == false)
					break;
				
				System.out.println("MAGO ATTACCA!" + " DANNO INFLITTO: " + mago.chooseRandomAttack(dragone));
				
				if (mago.getPuntiVita() <= 15) {
					
					System.out.println("IL MAGO HA POCA VITA , USA POZIONE CURA!");
					mago.curaAlleato(mago);
				}
			}
			
			
		} else if (whoStart(nemico, eroe) instanceof Orco) {
			Thread.sleep(3 * 1000);

			System.out.println("####ORCO VS CAVALIERE####");
			System.out.println("INIZIA L'ORCO!");

			Orco orco = (Orco) nemico;
			Cavaliere cavaliere = (Cavaliere) eroe;
			
			while (orco.isAlive() && cavaliere.isAlive()) {
				Thread.sleep(3 * 1000);

				System.out.println("ORCO ATTACCA!!" + " DANNO INFLITTO: " + orco.attaccoConPugno(eroe));
				Thread.sleep(3 * 1000);

				if (eroe.isAlive() == false || nemico.isAlive() == false)
					break;
				
				System.out.println("CAVALIERE ATTACCA!" + " DANNO INFLITTO: " + cavaliere.chooseRandomAttack(orco));
				
				if (orco.getPuntiVita() <= 10) {
					
					System.out.println("L'ORCO HA POCA VITA, INSERISCE LA CORAZZA DI 20 PUNTI VITA!!");
					orco.inserisciCorazza(20);
					
					System.out.println("CAVALIERE ATTACCA MENTRE ORCO E' DISTRATTO!!" + " DANNO INFLITTO: " + cavaliere.chooseRandomAttack(orco));
					
					if (eroe.isAlive() == false || nemico.isAlive() == false)
						break;
					
				}
			}

			
		} else if (whoStart(nemico, eroe) instanceof Cavaliere) {
			Thread.sleep(3 * 1000);

			System.out.println("####CAVALIERE VS ORCO####");
			System.out.println("INIZIA IL CAVALIERE!");
			
			
			Cavaliere cavaliere = (Cavaliere) eroe;
			Orco orco = (Orco) nemico;
			
			while (cavaliere.isAlive() && orco.isAlive()) {
				
				Thread.sleep(3 * 1000);

				System.out.println("CAVALIERE ATTACCA!!" + " DANNO INFLITTO: " + cavaliere.chooseRandomAttack(orco));
				Thread.sleep(3 * 1000);

				if (eroe.isAlive() == false || nemico.isAlive() == false)
					break;
				
				System.out.println("L'ORCO ATTACCA!" + " DANNO INFLITTO: " + orco.attaccoConPugno(cavaliere));
				
				if (orco.getPuntiVita() <= 10) {
					
					System.out.println("L'ORCO HA POCA VITA E INSERISCE LA CORAZZA DI 20 PUNTI VITA!!");
					orco.inserisciCorazza(20);
					System.out.println("CAVALIERE ATTACCA!!" + " DANNO INFLITTO: " + cavaliere.chooseRandomAttack(orco));
					
					if (eroe.isAlive() == false || nemico.isAlive() == false)
						break;
					
				}
			}

		} else if (whoStart(nemico, eroe) instanceof Mago) {
			Thread.sleep(3 * 1000);

			System.out.println("####MAGO VS DRAGONE####");
			System.out.println("INIZIA IL MAGO!!");

			Mago mago = (Mago) eroe;
			Dragone dragone = (Dragone) nemico;
			
			while (mago.isAlive() && dragone.isAlive()) {
				
				Thread.sleep(3 * 1000);

				System.out.println("MAGO ATTACCA!!" + " DANNO INFLITTO: " + mago.chooseRandomAttack(dragone));
				Thread.sleep(3 * 1000);

				if (eroe.isAlive() == false || nemico.isAlive() == false)
					break;
				
				System.out.println("DRAGONE ATTACCA!!" + " DANNO INFLITTO: " + dragone.attaccoDiFuoco(mago));
				
			}

		}
		
		
		

		System.out.println("###COMBATTIMENTO FINITO###");
		
		Thread.sleep(3 * 1000);
		System.out.println("IL VINCITORE E'...");

		if (eroe.isAlive())
			System.out.println(eroe);
		else if (nemico.isAlive())
			System.out.println(nemico);
	}
	
	
	
}
