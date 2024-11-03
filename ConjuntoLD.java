package conjuntos;

public class ConjuntoLD implements ConjuntoTDA{
	
	public class Nodo {
		int info;
		Nodo sig;
	}

	private Nodo c;
	
	public void InicializarConjunto() {
		// TODO Auto-generated method stub
		c = null;
	}

	public void Agregar(int x) {
		// TODO Auto-generated method stub
		if (!this.Pertenece(x)) {
			Nodo nuevo = new Nodo();
			nuevo.info = x;
			nuevo.sig = c;
			c = nuevo;
		}
	}

	public int Elegir() {
		// TODO Auto-generated method stub
		return c.info;
	}

	public boolean ConjuntoVacio() {
		// TODO Auto-generated method stub
		return (c == null);
	}

	public void Sacar(int x) {
		// TODO Auto-generated method stub
		if(c != null) {
			if(c.info == x) {
				c = c.sig;
			}else {
				Nodo aux = c;
				while(aux.sig != null && aux.sig.info != x)
					aux = aux.sig;
				if(aux.sig != null)
					aux.sig = aux.sig.sig;
			}
		}
	}

	public boolean Pertenece(int x) {
		// TODO Auto-generated method stub
		Nodo aux = c;
		while(aux != null && aux.info != x)
			aux = aux.sig;
		return (aux != null);
	}

}
