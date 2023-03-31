package it.softwareInside.eroi;

import it.softwareInside.nemici.Nemico;

public interface MagoInterface {

	
	
	public boolean recuperaSalute ();
	
	public int folataMagica (Nemico nemico);
	
	public int attaccoMagico (Nemico nemico);
		
	public void showPozioni();
	
	public int curaAlleato (Eroe eroe);
	
	public void recuperaMana (int manaTrovato);
	
	public boolean addPozione (Pozione pozione);
}
