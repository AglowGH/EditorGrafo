import java.awt.geom.Point2D;

public class ListaLigada 
{
	private Nodo first = null;
	private int contador;
	
	public ListaLigada()
	{
		first = null;
		contador = 0;
	}
	
	public void insertar(Point2D coordenadas, String nombre)
	{
		Nodo nodo =  new Nodo(nombre,coordenadas);
		nodo.setNext(first);
		first = nodo;
		contador++;
	}
	
	public Nodo peek()
	{
		return first;
	}
	
	public boolean eliminar(Point2D c)
	{
		if(contador == 0 )return false;
		//Todo eliminar coordenadas que se indican en el argumento de esta funcion
		//Igual puedes hacerlo entre rangos
		contador--;
		return true;
	}
	
	public boolean buscarEntreRangos(Point2D punto,int distancia,int base, int altura)
	{
		//Todo buscar si es posible no insertar un vertice entre determinado espacio
	
		Nodo aux = first;
		while(aux != null)
		{
			
			if(intervalo(punto,aux.getCoordenadas(),distancia,base,altura))
			{
				return true;
			}
			
			aux = aux.getNext();
		}
		
		return false;
	}
	
	private boolean intervalo(Point2D punto,Point2D p2,int distancia,int base, int altura)
	{
		int xInicio = (int)p2.getX() - distancia;
		int xFinal =(int)p2.getX() + base + distancia;
		
		int yInicio = (int)p2.getY() - distancia;
		int yFinal = (int)p2.getY() + altura + distancia;
		
		int x = (int)punto.getX();
		int y = (int)punto.getY();
		
		if((x >= xInicio) && (x <= xFinal) && (y >= yInicio) && (y <= yFinal))return true;
		
		return false;
	}
	
	public Nodo buscarNodo(Point2D punto,int base, int altura)
	{
		Nodo aux = first;
		while(aux != null)
		{
			
			if(intervalo(punto,aux.getCoordenadas(),0,base,altura))
			{
				return aux;
			}
			
			aux = aux.getNext();
		}
		
		return null;
	}
	
	public void mostrarLista()
	{
		System.out.println("//////////////////////////////////////////////////////////////////");
		Nodo aux = first;
		while(aux != null)
		{
			System.out.println("("+aux.getNombre()+","+aux.getCoordenadas().getX()+","+aux.getCoordenadas().getY()+")");

			aux = aux.getNext();
		}
		System.out.println("//////////////////////////////////////////////////////////////////");
	}
}
