package it.softwareInside.nemici;

import it.softwareInside.eroi.Eroe;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)

@NoArgsConstructor
@Data
public class Orco extends Nemico{

	
	
	
	
	public Orco (int puntiVita , 
				 int puntiAttacco) {
		
		setPuntiAttacco(puntiAttacco);
		setPuntiVita(puntiVita);
		setAlive(true);
	}
	
	
	
	@Override
	public String toString () {
		
		
		return "ORCO --> " + "Punti Vita: " + super.getPuntiVita() +
			   " Punti Attacco: " + super.getPuntiAttacco() + 
			   " E' vivo? " + super.isAlive();
		       
	}
	
	
	
	
	public int attaccoConPugno (Eroe eroe) {
		
		int n = generaNumero(5, 14);
		eroe.setPuntiVita( eroe.getPuntiVita() - (this.getPuntiAttacco() + n) );
		if (eroe.getPuntiVita() <= 0)
			eroe.setAlive(false);
		return n + this.getPuntiAttacco();

	}
	
	
	
	public void inserisciCorazza (int saluteScudoCorazzato) {
		
		setPuntiVita(getPuntiVita() + saluteScudoCorazzato);
	}
	
	

	
	
	
	
	
}
