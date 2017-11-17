package juego.acciones;

import juego.FactoryAliado;

public class ComprarCommando extends AccionComprarAliado{
	
	public ComprarCommando(){
		aliado= FactoryAliado.crearCommando();
	}
}
