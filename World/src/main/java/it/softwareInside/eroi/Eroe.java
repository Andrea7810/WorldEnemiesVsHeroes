package it.softwareInside.eroi;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Eroe {

	private int puntiAttacco;
	private int puntiVita;
	private boolean isAlive;
	private String nome;
	
	
	
	
	public int generaNumero (int low , int upper) {
		
		Random r = new Random();
	
		int n = r.nextInt(low , upper);
		
		return n;
	}
	
	
	public void setAlive (boolean isAlive) {
		
		if (getPuntiVita() <= 0)
			this.isAlive = false;
		else
			this.isAlive = true;
	}
	
	
	
	
}
