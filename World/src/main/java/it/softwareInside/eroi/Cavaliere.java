package it.softwareInside.eroi;

import java.util.Random;

import it.softwareInside.nemici.Nemico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cavaliere extends Eroe{

	
	private Cavallo cavallo;
	private Freccia [] faretra;
	
	
	
	
	public Cavaliere (int puntiAttacco , int puntiVita , String nome , Cavallo cavallo) {
		
		setPuntiVita(puntiVita);
		setPuntiAttacco(puntiAttacco);
		setAlive(true);
		setNome(nome);
		setCavallo(cavallo);
		setFaretra(new Freccia [10]);
		
	}
	

	
	
	@Override
	public String toString () {
		
		String ris = "";
		
		for (int ù = 0; ù < faretra.length; ù++) {
			ris += "\n" + faretra[ù] + " ";
		}
		
		return  "CAVALIERE --> " + "Nome: " + super.getNome() 
		        + " Punti Vita: " + super.getPuntiVita()
				+ " Punti Attacco: " + super.getPuntiAttacco()
				+ " E' vivo? " + super.isAlive()
				+ " Cavallo: " + this.cavallo
				+ "\nFaretra: " + ris;
	}
	
	
	
	
	
	public void rimuoviCavallo () {
		
		setCavallo(null);
	}
	
	
	
	public boolean aggiungiCavallo (Cavallo cavallo) {
		
		try {
			setCavallo(cavallo);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public int attaccoConSpada (Nemico nemico) {
		
		int n = generaNumero(5, 13);
		nemico.setPuntiVita(nemico.getPuntiVita() - (this.getPuntiAttacco() + n ));
		if (nemico.getPuntiVita() <= 0)
			nemico.setAlive(false);
		return n + this.getPuntiAttacco();
		
	}
	
	
	public int attaccoConArco (Nemico nemico) {
		
		
		for (int i = 0; i < faretra.length; i++) {
			if (faretra[i] != null) {
				nemico.setPuntiVita(nemico.getPuntiVita() - faretra[i].getDannoFreccia());
				if (nemico.getPuntiVita() <= 0)
					nemico.setAlive(false);
				return faretra[i].getDannoFreccia();
			}
		}
		
		return 0;
	}
	
	
	
	public int attaccoConCavallo (Nemico nemico) {
		
		if (getCavallo() != null) {
			
			int n = generaNumero(30, 40);
			nemico.setPuntiVita(nemico.getPuntiVita() - n);
			
			if (nemico.getPuntiVita() <= 0)
				nemico.setAlive(false);
			
			return n;
		}
		
		return 0;
	}
	
	
	
	public boolean addFreccia (Freccia freccia) {
		
		
		try {
			for (int i = 0; i < faretra.length; i++) {
				if (faretra[i] == null) {
					faretra[i] = freccia;
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		
		
		return false;
	}
	
	
	
	
	public void controllaFaretra () {
		
		for (int i = 0; i < faretra.length; i++) {
			System.out.println(faretra[i]);
		}
	}
	
	
	
	
	
	
	
	public int chooseRandomAttack (Nemico nemico) {
		
		Random r = new Random();
		
		int n = r.nextInt(1 , 4);
		
		switch (n) {
		case 1:
			return attaccoConSpada(nemico);
		case 2:
			return attaccoConArco(nemico);
		default: return attaccoConCavallo(nemico);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
