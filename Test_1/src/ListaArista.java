
public class ListaArista 
{
	private Arista first;
	private int contador;
	
	public ListaArista()
	{
		contador = 0;
	}
	
	public void insertar(Arista arista)
	{
		arista.setNext(first);
		first = arista;
		contador++;
	}
	
	public Arista peek() {
		return first;
	}
	
	public int getContador()
	{
		return contador;
	}
	
	//Buscar si arista existe en dos punto seleccionados, si es asi retornala
	public Arista buscarArista(Nodo n1, Nodo n2)
	{
		Arista aux = first;
		boolean primera = false;
		boolean segunda = false;
		
		while(aux != null)
		{
			
			if(aux.getPrimerNodo().getNombre().equals(n1.getNombre())) primera = true;
			
			if(aux.getSegundoNodo().getNombre().equals(n2.getNombre())) segunda = true;
			
			if(aux.getSegundoNodo().getNombre().equals(n1.getNombre())) primera = true;
			
			if(aux.getPrimerNodo().getNombre().equals(n2.getNombre())) segunda = true;
			
			if(primera && segunda)
				return aux;
			
			primera = false;
			segunda = false;
			aux = aux.getNext();
		}
		
		return null;
	}
	
	public void mostrarAristas()
	{
		System.out.println("//////////////////////////////////////////////////////////////////");
		Arista aux = first;
		while(aux != null)
		{
			System.out.println("(" + aux.getPrimerNodo().getNombre() + "," + aux.getSegundoNodo().getNombre() + "," + aux.getPeso() + ")");
			aux = aux.getNext();
		}
		System.out.println("//////////////////////////////////////////////////////////////////");
	}
	
}
