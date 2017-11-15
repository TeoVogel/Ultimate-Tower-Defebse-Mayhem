package juego.ente.powerup;

import juego.ente.Personaje;

public class Escudo extends PowerUp{
<<<<<<< HEAD
	 protected int original;
		public Escudo(){
			super(30);
			precio = 75;
		}
=======
	 protected int vidaOriginal;
	 protected int rangoOriginal;
	 protected int ataqueOriginal;
	 
	 protected final static int ataqueEscudo = 200;
	 protected final static int rangoEscudo = 1;
	 protected final static int vidaEscudo = Integer.MAX_VALUE;
		
	 public Escudo(Personaje p){
		super(p,30);
	}
>>>>>>> f6f2d355f69c12985340b09f2c3cbe4713290c17
		
	public void actualizar(){
		boolean ataco = false;
			
<<<<<<< HEAD
			if(duracion==0) {
				afectado.setVida(original);
				afectado.setPowerUp(new PowerUp());
			}
			else duracion--;
=======
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
>>>>>>> f6f2d355f69c12985340b09f2c3cbe4713290c17
		}
			duracion--;
	}
			
}