package pilas;

public class PilaLD implements PilaTDA{
	
	class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo primero;

	public void InicializarPila() {
		// TODO Auto-generated method stub
		primero = null;
	}

	public void Apilar(int x) {
		// TODO Auto-generated method stub
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		nuevo.sig = primero;
		primero = nuevo;
	}

	public void Desapilar() {
		// TODO Auto-generated method stub
		primero = primero.sig;
	}

	public boolean PilaVacia() {
		// TODO Auto-generated method stub
		return (primero == null);
	}

	public int Tope() {
		// TODO Auto-generated method stub
		return primero.info;
	}

}
