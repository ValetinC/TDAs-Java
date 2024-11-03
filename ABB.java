package arboles;

public class ABB implements ABBTDA{
	
	public class NodoABB{
		int dato;
		ABBTDA hijoIzq;
		ABBTDA hijoDer;
	}
	
	NodoABB raiz;

	public int Raiz() {
		// TODO Auto-generated method stub
		return raiz.dato;
	}

	public ABBTDA HijoIzq() {
		// TODO Auto-generated method stub
		return raiz.hijoIzq;
	}

	public ABBTDA HijoDer() {
		// TODO Auto-generated method stub
		return raiz.hijoDer;
	}

	public boolean ArbolVacio() {
		// TODO Auto-generated method stub
		return raiz == null;
	}

	public void InicializarArbol() {
		// TODO Auto-generated method stub
		raiz = null;
	}

	public void AgregarElem(int x) {
		// TODO Auto-generated method stub
		if(raiz == null) {
			raiz = new NodoABB();
			raiz.dato = x;
			raiz.hijoIzq = new ABB();
			raiz.hijoIzq.InicializarArbol();
			raiz.hijoDer = new ABB();
			raiz.hijoDer.InicializarArbol();
		} else if(raiz.dato > x)
			raiz.hijoIzq.AgregarElem(x);
		else if (raiz.dato < x)
			raiz.hijoDer.AgregarElem(x);
	}

	public void EliminarElem(int x) {
		// TODO Auto-generated method stub
		if (raiz != null) {
			if(raiz.dato == x && raiz.hijoIzq.ArbolVacio() && raiz.hijoDer.ArbolVacio()) {
				raiz = null;
			} else if (raiz.dato == x && !raiz.hijoIzq.ArbolVacio()) {
				raiz.dato = this.mayor(raiz.hijoIzq);
				raiz.hijoIzq.EliminarElem(raiz.dato);
			} else if (raiz.dato == x && raiz.hijoIzq.ArbolVacio()) {
				raiz.dato = this.menor(raiz.hijoDer);
				raiz.hijoDer.EliminarElem(raiz.dato);
			} else if (raiz.dato < x) {
				raiz.hijoDer.EliminarElem(x);
			} else {
				raiz.hijoIzq.EliminarElem(x);
			}
		}
	}
	
	private int mayor(ABBTDA a) {
		if(a.HijoDer().ArbolVacio())
			return a.Raiz();
		else
			return mayor(a.HijoDer());
	}
	
	private int menor(ABBTDA a) {
		if(a.HijoIzq().ArbolVacio())
			return a.Raiz();
		else
			return menor(a.HijoIzq());
	}

}
