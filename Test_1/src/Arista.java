
//import java.awt.geom.Point2D;

public class Arista 
{
	private Nodo n1;
	private Nodo n2;
	private double peso;
	private Arista next = null;
	
	public Arista(Nodo primerNodo, Nodo segundoNodo,int peso)
	{
		n1 = primerNodo;
		n2 = segundoNodo;
		this.peso = peso;
	}
	
	public void setPrimerNodo(Nodo nodo)
	{
		n1 = nodo;
	}
	
	public Nodo getPrimerNodo()
	{
		return n1;
	}
	
	public void setSegundoNodo(Nodo nodo)
	{
		n2 = nodo; 
	}
	
	public Nodo getSegundoNodo()
	{
		return n2;
	}
	
	public void setPeso(double peso)
	{
		this.peso = peso;
	}
	
	public double getPeso()
	{
		return peso;
	}
	
	public void setNext(Arista arista)
	{
		next = arista;
	}
	
	public Arista getNext()
	{
		return next;
	}
	
}
