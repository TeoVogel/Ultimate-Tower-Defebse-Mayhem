package juego.ente.powerup;

import juego.ente.Personaje;
import javax.swing.ImageIcon;

import juego.Constantes;

public class Escudo extends PowerUp{
	protected int vidaOriginal;
	protected int rangoOriginal;
	protected int ataqueOriginal;
	 
	protected final static int ataqueEscudo = 200;
	protected final static int rangoEscudo = 1;
	protected final static int vidaEscudo = Integer.MAX_VALUE;
	
	
	public Escudo(){
		super(30, 75);
		img = new ImageIcon(Constantes.path + "powerup_shield_aliado" + ".png");
	}
		
	public void actualizar(){
		boolean ataco = false;
		
		rangoOriginal= afectado.getRango();
		ataqueOriginal= afectado.getAtaque();
		afectado.setRango(rangoEscudo);
		afectado.setAtaque(ataqueEscudo);
		
		ataco = afectado.enviarVisitor();
		
		afectado.setAtaque(ataqueOriginal);
		afectado.setRango(rangoOriginal);
		
		if(duracion==0 || ataco) {
			afectado.setVida(vidaOriginal);
			afectado.setPowerUp(new PowerUp());
			afectado = null;
		}
			duracion--;
	}
	
	public void setPersonaje(Personaje p){
		super.setPersonaje(p);
		vidaOriginal=afectado.getVida();
		afectado.setVida(vidaEscudo);
	}
	
}