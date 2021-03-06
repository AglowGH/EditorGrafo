import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import javax.swing.*;

public class MyPanel extends JPanel
{
	public static ListaLigada lista = new ListaLigada();
	public static ListaArista aristas = new ListaArista();
	public static Point2D coordenadas = null;
	public static Point2D coordenadas2 = null;
	private String name = null;
	private int contadorNodos = 0;
	private static final long serialVersionUID = 1L;

	
	public static boolean reImprimir = false;
	
	MyPanel()
	{
		this.setPreferredSize(new Dimension(500,500));
		this.addMouseListener(new MouseAdapter()
		{
			
			public void mouseClicked(MouseEvent evento)
			{
				if(MyFrame.activarMouse == true) 
				{
					if(!reImprimir)
					{
						coordenadas = evento.getPoint();
					}
					repaint();
				}
			}
			
		});
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		if(coordenadas != null)
		{
			if(!lista.buscarEntreRangos(coordenadas, 60, 15, 15))
			{
				g2.setPaint(Color.black);
				contadorNodos +=1;
				name = String.valueOf(contadorNodos);
				lista.insertar(coordenadas,name);
				g2.fillOval((int)coordenadas.getX(),(int)coordenadas.getY(),15,15);
				g2.setFont(new Font("Ink Free",Font.BOLD,10));
				g2.drawString(name,(int)coordenadas.getX(),(int)coordenadas.getY()-10);
				coordenadas2 = null;
				MyFrame.verticeSeleccionado = null;
			
			}else if(lista.buscarEntreRangos(coordenadas, 0, 15, 15))
			{
				if(coordenadas2 == null)
				{
					MyFrame.verticeSeleccionado = lista.buscarNodo(coordenadas, 15, 15);
					coordenadas2 = coordenadas;
				}else
				{
					Nodo n1 = lista.buscarNodo(coordenadas,15,15);
					Nodo n2 = lista.buscarNodo(coordenadas2,15, 15);
					Arista arista = aristas.buscarArista(n1, n2);
					if(arista == null && n1 != n2)
					{
						g2.drawLine((int)coordenadas2.getX(),(int)coordenadas2.getY(),(int)coordenadas.getX(),(int)coordenadas.getY());
						
						Point puntoMedio = calcularPuntoMedio(coordenadas2,coordenadas);
						g2.setFont(new Font("Ink Free",Font.BOLD,10));
						g2.drawString("0",(int)puntoMedio.getX() + 5,(int)puntoMedio.getY());
						
						aristas.insertar(new Arista(n2,n1,0));
					}else if(n1 != n2)
					{
						MyFrame.aristaSeleccionada = arista;
					}else
					{
						MyFrame.aristaSeleccionada = null;
					}
					
					coordenadas2 = null;
				}
			}
		}
		
		if(reImprimir)
		{
			Nodo auxN = lista.peek();
			Arista auxA = aristas.peek();
			g2.setPaint(Color.black);
			while(auxN != null) 
			{
				g2.fillOval((int)auxN.getCoordenadas().getX(),(int)auxN.getCoordenadas().getY(),15,15);
				g2.setFont(new Font("Ink Free",Font.BOLD,10));
				g2.drawString(auxN.getNombre(),(int)auxN.getCoordenadas().getX(),(int)auxN.getCoordenadas().getY()-10);
				auxN = auxN.getNext();
			}
			
			while(auxA != null)
			{
				g2.drawLine((int)auxA.getPrimerNodo().getCoordenadas().getX() + 7,(int)auxA.getPrimerNodo().getCoordenadas().getY() + 7 ,(int)auxA.getSegundoNodo().getCoordenadas().getX() +7,(int)auxA.getSegundoNodo().getCoordenadas().getY() + 7);
				
				Point puntoMedio = calcularPuntoMedio(auxA.getPrimerNodo().getCoordenadas(),auxA.getSegundoNodo().getCoordenadas());
				g2.drawString(String.valueOf(auxA.getPeso()),(int)puntoMedio.getX() + 5,(int)puntoMedio.getY());
				auxA = auxA.getNext();
			}
			reImprimir = false;
		}
	}
	
	public static void actualizaInfo()
	{
		lista.mostrarLista();
		aristas.mostrarAristas();
	}
	
	public Point calcularPuntoMedio(Point2D p1, Point2D p2)
	{
		
		int x = (int)(p1.getX() + p2.getX())/2;
		int y = (int)(p1.getY() + p2.getY())/2;
		
		return new Point(x,y);
	}
	
	public static boolean mismosNombres(String nuevoNombre)
	{
		Nodo auxN = lista.peek();
		
		while(auxN != null)
		{
			if(auxN.getNombre().equals(nuevoNombre))return true;
			auxN = auxN.getNext();
		}
		
		return false;
	}
}
