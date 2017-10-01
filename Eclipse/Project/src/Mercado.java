
public class Mercado {

	private Accion accionPlaceHolder;

	public void addToPlaceHolder(Accion a) {
		accionPlaceHolder = a;
	}
	
	public boolean isPlaceHolderFull () {
		return accionPlaceHolder != null;
	}
	
	public Accion getPlaceHolderContent () {
		Accion a = accionPlaceHolder;
		accionPlaceHolder = null;
		return a;
	}
	
}
