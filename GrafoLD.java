package grafos;

import conjuntos.ConjuntoLD;
import conjuntos.ConjuntoTDA;

public class GrafoLD implements GrafoTDA{
	
	class NodoGrafo{
		int Nodo;
		NodoArista arista;
		NodoGrafo sigNodo;
	}
	
	class NodoArista{
		int etiqueta;
		NodoGrafo nodoDestino;
		NodoArista sigArista;
	}
	
	NodoGrafo origen;

	public void InicializarGrafo() {
		// TODO Auto-generated method stub
		origen = null;
	}

	public void AgregarVertice(int v) {
		// TODO Auto-generated method stub
		NodoGrafo aux = new NodoGrafo();
		aux.Nodo = v;
		aux.arista = null;
		aux.sigNodo = origen;
		origen = aux;
	}
	
	private NodoGrafo Vert2Nodo(int v) {
		NodoGrafo aux = origen;
		while (aux != null && aux.Nodo != v)
			aux = aux.sigNodo;
		return aux;
	}

	public void AgregarArista(int v1, int v2, int p) {
		// TODO Auto-generated method stub
		NodoGrafo n1 = Vert2Nodo(v1);
		NodoGrafo n2 = Vert2Nodo(v2);
		NodoArista aux = new NodoArista();
		aux.etiqueta = p;
		aux.nodoDestino = n2;
		aux.sigArista = n1.arista;
		n1.arista = aux;
	}
	
	private void EliminarAristaNodo(NodoGrafo  nodo, int v) {
		NodoArista aux = nodo.arista;
		if (aux != null) {
			if(aux.nodoDestino.Nodo == v) {
				nodo.arista = aux.sigArista;
			} else {
				while (aux.sigArista != null && aux.sigArista.nodoDestino.Nodo != v)
					aux = aux.sigArista;
				if (aux.sigArista != null) {
					aux.sigArista = aux.sigArista.sigArista;
				}
			}
		}
	}

	public void EliminarVertice(int v) {
		// TODO Auto-generated method stub
		if (origen.Nodo == v)
			origen = origen.sigNodo;
		NodoGrafo aux = origen;
		while (aux != null) {
			this.EliminarAristaNodo(aux, v);
			if (aux.sigNodo != null && aux.sigNodo.Nodo == v)
				aux.sigNodo = aux.sigNodo.sigNodo;
			aux = aux.sigNodo;
		}
	}

	public void EliminarArista(int v1, int v2) {
		// TODO Auto-generated method stub
		NodoGrafo n1 = Vert2Nodo(v1);
		EliminarAristaNodo(n1, v2);
	}

	public int PesoArista(int v1, int v2) {
		// TODO Auto-generated method stub
		NodoGrafo n1 = Vert2Nodo(v1);
		NodoArista aux = n1.arista;
		while (aux.nodoDestino.Nodo != v2)
			aux = aux.sigArista;
		return aux.etiqueta;
	}

	public ConjuntoTDA Vertices() {
		// TODO Auto-generated method stub
		ConjuntoTDA c = new ConjuntoLD();
		c.InicializarConjunto();
		NodoGrafo aux = origen;
		while (aux != null) {
			c.Agregar(aux.Nodo);
			aux = aux.sigNodo;
		}
		return c;
	}

	public boolean ExisteArista(int v1, int v2) {
		// TODO Auto-generated method stub
		NodoGrafo n1 = Vert2Nodo(v1);
		NodoArista aux = n1.arista;
		while (aux != null && aux.nodoDestino.Nodo != v2)
			aux = aux.sigArista;
		return (aux != null);
	}

}
