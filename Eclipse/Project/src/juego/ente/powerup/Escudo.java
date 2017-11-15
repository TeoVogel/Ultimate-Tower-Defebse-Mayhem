package juego.ente.powerup;

import juego.ente.Personaje;

public class Escudo extends PowerUp{
	 protected int vidaOriginal;
	 protected int rangoOriginal;
	 protected int ataqueOriginal;
	 
	 protected final static int ataqueEscudo = 200;
	 protected final static int rangoEscudo = 1;
	 protected final static int vidaEscudo = Integer.MAX_VALUE;
		
	 public Escudo(Personaje p){
		super(p,30);
	}
		
	public void actualizar(){
		boolean ataco = false;
			
		if(duracion==duracionMax) { 
			vidaOriginal=afectado.getVida();
			afectado.setVida(vidaEscudo);
		}
		
		rangoOriginal= afectado.getRango();
		ataqueOriginal= afectado.getAtaque();
		afectado.setRango(rangoEscudo);
		afectado.setAtaque(ataqueEscudo);
		
		ataco = afectado.enviarVisitor();
		
		afectado.setAtaque(ataqueOriginal);
		afectado.setRango(rangoOriginal);
		
		if(duracion==0 || ataco) {
			afectado.setVida(vidaOriginal);
			afectado.setPowerUp(new PowerUp(afectado));
			afectado = null;
		}
			duracion--;
	}
			
}