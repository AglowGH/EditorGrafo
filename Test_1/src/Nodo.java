
import java.awt.geom.*;

public class Nodo 
{
	private String nombre;
	private Point2D coordenadas;
	private Nodo next = null;
	
	public Nodo(String n,Point2D c)
	{
		nombre = n;
		coordenadas = c;
	}
	
	public void setNombre(String n)
	{
		nombre = n;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setCoordenadas(Point2D c)
	{
		coordenadas = c;
	}
	
	public Point2D getCoordenadas()
	{
		return coordenadas;
	}
	
	public void setNext(Nodo c)
	{
		next = c;
	}
	
	public Nodo getNext()
	{
		return next;
	}
}
