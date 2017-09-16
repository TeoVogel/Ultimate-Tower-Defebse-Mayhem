
public class ContadorTiempo extends Thread {

	private _Juego elJuego;

	ContadorTiempo(_Juego j) {
		this.elJuego = j;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			elJuego.mover();
		}
	}
}