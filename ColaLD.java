package colas;

public class ColaLD implements ColaTDA{
	
	public class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo primero;
	Nodo ultimo;

	public void InicializarCola() {
		// TODO Auto-generated method stub
		primero = null;
		ultimo = null;
	}

	public void Acolar(int x) {
		// TODO Auto-generated method stub
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		nuevo.sig = null;
		if(ultimo != null) {
			ultimo.sig = nuevo;
		}
		ultimo = nuevo;
		if(primero == null)
			primero = ultimo;
	}

	public void Desacolar() {
		// TODO Auto-generated method stub
		primero = primero.sig;
		if(primero == null)
			ultimo = null;
	}

	public boolean ColaVacia() {
		// TODO Auto-generated method stub
		return (ultimo == null);
	}

	public int Primero() {
		// TODO Auto-generated method stub
		return primero.info;
	}

}
