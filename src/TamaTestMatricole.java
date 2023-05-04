import static org.junit.Assert.*;

import org.junit.Test;

public class TamaTestMatricole
{
    	// Attenzione, costruttore utilizzato:
	// public Tamagotchi (String nome, int gradoSazieta, int gradoAffettivo)
	
	@Test
	public void dieForZeroSatisfaction() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 0);
		tama.controllo_condizioni();
		assertTrue(!tama.isVita());
	}
	
	@Test
	public void dieForZeroHunger() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 0, 50);
		tama.controllo_condizioni();
		assertTrue(!tama.isVita());
	}
	
	@Test
	public void aliveWhenSatisfactionAndHungerAreGood() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		tama.controllo_condizioni();
		assertTrue(tama.isVita());
	}
/****	
	@Test(expected=IllegalArgumentException.class)
	public void cantInstantiatePetWithNegativeSatisfaction() throws Exception 
	{
		new Tamagotchi("Kira", -10, 50);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cantInstantiatePetWithNegativeHunger() throws Exception 
	{
		new Tamagotchi("Kira", 50, -10);
	}
	
	*****/
	@Test
	public void petCanReceivePets() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		tama.ricevi_carezze(1);
		tama.controllo_condizioni();
		assertFalse(tama.sonoTriste());
	}
	
	@Test
	public void petCanReceiveCookies() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		tama.ricevi_biscotti(1);
		tama.controllo_condizioni();
		assertFalse(tama.sonoTriste());
	}
	
	@Test
	public void petIsUnhappyDueToHunger() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 10, 50);
		tama.controllo_condizioni();
		assertTrue(tama.sonoTriste());
	}
	
	@Test
	public void petIsUnhappyDueToExtremeRepletion() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 95, 50);
		tama.controllo_condizioni();
		assertTrue(tama.sonoTriste());
	}
	
	@Test
	public void petIsHappyInTheMidlleOfTheRange() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		tama.controllo_condizioni();
		assertFalse(tama.sonoTriste());
	}
	
	@Test
	public void petAugmentsItsRepletionAndDiesDueToCookies() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 99, 50);
		tama.ricevi_biscotti(10);
		tama.controllo_condizioni();
		boolean res=!tama.isVita();
		assertTrue(res);
	}
	
	@Test
	public void petAugmentsItsSatisfactionDueToCaresses() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 29);
		tama.ricevi_carezze(10);
		tama.controllo_condizioni();
		assertFalse(tama.sonoTriste());
	}
}