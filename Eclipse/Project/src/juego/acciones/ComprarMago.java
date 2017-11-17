package juego.acciones;

import juego.FactoryAliado;

public class ComprarMago extends AccionComprarAliado{
	
	public ComprarMago(){
		aliado= FactoryAliado.crearMago();
	}
}
