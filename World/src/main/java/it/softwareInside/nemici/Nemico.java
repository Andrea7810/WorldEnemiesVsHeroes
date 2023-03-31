package it.softwareInside.nemici;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Nemico {

	
	private int puntiVita;
	private int puntiAttacco;
	private boolean isAlive;
	
	
	
	public void setAlive (boolean isAlive) {
				
		if (getPuntiVita() <= 0)
			this.isAlive = false;
		else
			this.isAlive = true;
		
	}
	
	
	
	public int generaNumero (int low , int upper) {
		
		Random r = new Random();
	
		int n = r.nextInt(low , upper);
		
		return n;
	}
	
	
	
	
	
	
	
	
	
	
}
