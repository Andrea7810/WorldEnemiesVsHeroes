package it.softwareInside.nemici;

import it.softwareInside.eroi.Eroe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dragone extends Nemico{

	
	private int energia;
	
	
	public Dragone (int puntiVita ,
					int puntiAttacco ,
					int energia) {
		
		setPuntiAttacco(puntiAttacco);
		setPuntiVita(puntiVita);
		setEnergia(energia);
		setAlive(true);
	}
	
	
	
	@Override
	public String toString () {
		
		
		return "DRAGONE --> " + "Punti Vita: " + super.getPuntiVita() +
			   " Punti Attacco: " + super.getPuntiAttacco() + 
			   " E' vivo? " + super.isAlive() + 
			   " Energia rimasta: " + this.getEnergia();   
	}
	
	
	
	
	public boolean recuperaEnergia (int energia) {
		
		try {
			setEnergia(this.energia + energia);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
	
	public int attaccoDiFuoco (Eroe eroe) {
		
		int n = generaNumero(5, 11);
		
		if (getEnergia() > 20) {
			eroe.setPuntiVita( eroe.getPuntiVita()  - (getPuntiAttacco()  + n) );
			if (eroe.getPuntiVita() <= 0)
				eroe.setAlive(false);
			return getPuntiAttacco() + n;
		}
		return 0;
	}
	
	
	
	public boolean curaAlleato (Nemico nemico) {
		
		try {
			if (getEnergia() > 10) {
				
				nemico.setPuntiVita( nemico.getPuntiVita()  + 10);
				return true;
			}
			
		} catch (Exception e) {
			return false;
		}
		
		return false;
	}
	
	
}
