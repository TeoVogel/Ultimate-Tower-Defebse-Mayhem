package juego.ente.powerup;

public class FactoryPowerUps {

	public static final int POWERUP_TIPO_AUMENTO_ATAQUE = 0;
	public static final int POWERUP_TIPO_CURA_GRADUAL = 1;
	public static final int POWERUP_TIPO_CURA_INSTANTANEA = 2;
	public static final int POWERUP_TIPO_ESCUDO = 3;
	public static final int POWERUP_TIPO_TIRO_RAPIDO = 4;
	
	public static PowerUp getPowerUp (int tipo) {
		PowerUp powerUp;
		switch(tipo) {
			case (POWERUP_TIPO_AUMENTO_ATAQUE):   powerUp = new AumentoAtaque(); break;
			case (POWERUP_TIPO_CURA_GRADUAL):     powerUp = new CuraGradual(); break;
			case (POWERUP_TIPO_CURA_INSTANTANEA): powerUp = new CuraInstantanea(); break;
			case (POWERUP_TIPO_ESCUDO):           powerUp = new Escudo(); break;
			case (POWERUP_TIPO_TIRO_RAPIDO):      powerUp = new TiroRapido(); break;
			default:                              powerUp = new PowerUp();
		}
		return powerUp;
	}
	
}
