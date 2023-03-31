package it.softwareInside.eroi;

import java.util.Random;

import it.softwareInside.nemici.Nemico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mago extends Eroe implements MagoInterface{

	
	private Pozione [] pozioni;
	private int mana;
	
	
	
	public Mago (int puntiAttacco , int puntiVita , 
			  String nome , int mana) {
		
		
		setPuntiAttacco(puntiAttacco);
		setMana(mana);
		setPuntiVita(puntiVita);
		setNome(nome);
		setAlive(true);
		setPozioni(new Pozione [10]);
	}
	
	
	
	@Override
	public String toString() {
		
		String ris = "";
		
		for (int i = 0; i < pozioni.length; i++) {
			ris += "\n" + pozioni[i] + " ";
		}
		
		
		return  "MAGO --> " + "Nome: " + super.getNome() + " Punti vita: " + super.getPuntiVita() +
				" Punti Attacco: " + super.getPuntiAttacco() + " E' vivo? " + super.isAlive() +
				" Mana: " + this.mana + "\nPozioni: " + ris;
	}
	
	
	
	
	public boolean recuperaSalute() {
		
		for (int j = 0; j < pozioni.length; j++) {
			if (pozioni[j] != null) {
				setPuntiVita(pozioni[j].getQuantitaVitaRecuperata() + getPuntiVita());
				pozioni[j] = null;
				return true;
			}
		}
		
		
		return false;
	}

	
	
	public int folataMagica(Nemico nemico) {
		
		int n = generaNumero(1, 9);

		if (mana >= 15) {
			setMana(getMana() - 15);
			nemico.setPuntiVita(nemico.getPuntiVita() - (  this.getPuntiAttacco() + n) ); 
			if (nemico.getPuntiVita() <= 0)
				nemico.setAlive(false);
			return this.getPuntiAttacco() + n;
		}
		
		return 0;
	}

	
	
	public int attaccoMagico(Nemico nemico) {

		int n = generaNumero(4, 17);
		
		if (mana >= 25) {
			setMana(getMana() - 25); 
			nemico.setPuntiVita(nemico.getPuntiVita() - ( this.getPuntiAttacco() + n) ); 
			if (nemico.getPuntiVita() <= 0)
				nemico.setAlive(false);
			return this.getPuntiAttacco() + n;
		}
		
		return 0;
	}

	
	
	
	public int curaAlleato(Eroe eroe) {
		
		try {
			int n = super.generaNumero(10, 40);
			eroe.setPuntiVita(n + this.getPuntiVita()) ;
			return n;
		} catch (Exception e) {
			return 0;
		}
	}

	public void showPozioni() {

		for (int i = 0; i < pozioni.length; i++) {
			System.out.println(pozioni[i]);
		}
	}

	
	public void recuperaMana(int manaTrovato) {

		try {
			setMana(manaTrovato);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public boolean addPozione(Pozione pozione) {

		
		try {
			for (int i = 0; i < this.pozioni.length; i++) {
				if ( pozioni[i] == null && mana >= 10) {
					setMana(getMana() - 10);
					pozioni[i] = pozione;
					return true;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		return false;
	}



	
	
	
	public int chooseRandomAttack (Nemico nemico) {
		
		Random r = new Random();
		
		int n = r.nextInt(1 , 3);
		
		switch (n) {
		case 1:
			return attaccoMagico(nemico);
		default: return folataMagica(nemico);
		}
		
		
	}
	
	
	
	
	
	
		
		
	
	
	
	
}
