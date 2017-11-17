package juego.acciones;

import juego.FactoryAliado;

public class ComprarSharpshooter extends AccionComprarAliado{
	
	public ComprarSharpshooter(){
		aliado= FactoryAliado.crearSharpshooter();
	}
}
