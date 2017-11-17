package juego.acciones;

import juego.FactoryAliado;

public class ComprarSupport extends AccionComprarAliado{
	
	public ComprarSupport(){
		aliado= FactoryAliado.crearSupport();	
	}
}
