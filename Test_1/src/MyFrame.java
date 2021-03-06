import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public MyPanel panel;
	public JButton cambiarNombre;
	public JButton cambiarPeso;
	public JPanel botones;

	public static String nombre = null;
	public static int peso = 0;
	public static Nodo verticeSeleccionado = null;
	public static Arista aristaSeleccionada = null;
	public static boolean activarMouse = true;
	
	MyFrame()
	{
		
	}
	
	public void mostrarFrame()
	{
		
		setLayout(new FlowLayout(FlowLayout.LEFT,50,50));
		
		panel = new MyPanel();
		add(panel);
		
		botones = new JPanel();
		botones.setLayout(new BoxLayout(botones,BoxLayout.Y_AXIS));
		botones.setBorder(new CompoundBorder(
                BorderFactory.createEmptyBorder(0,10,10,10),
                BorderFactory.createLineBorder(Color.RED)
				));
		add(botones);
		
		cambiarNombre = new JButton("Cambiar Nombre");
		cambiarNombre.setSize(100,50);
		cambiarNombre.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						activarMouse = false;
						obtenerNombre();
						MyPanel.coordenadas2 = null;
						MyPanel.coordenadas = null;
						MyPanel.actualizaInfo();
						activarMouse = true;
						panel.setVisible(false);
						panel.setVisible(true);
						MyPanel.reImprimir = true;
					}
					
				});
		botones.add(cambiarNombre);
		
		cambiarPeso = new JButton("Cambiar Peso");
		cambiarPeso.setSize(100,50);
		cambiarPeso.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						activarMouse = false;
						obtenerPeso();
						verticeSeleccionado = null;
						MyPanel.actualizaInfo();
						activarMouse =true;
						MyPanel.coordenadas = null;
						panel.setVisible(false);
						panel.setVisible(true);
						MyPanel.reImprimir = true;
					}
				});
		botones.add(cambiarPeso);
		
		pack();
		
		this.addWindowListener( new WindowListener()
				{

					@Override
					public void windowActivated(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowClosed(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowClosing(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowDeactivated(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowDeiconified(WindowEvent arg0) {
						// TODO Auto-generated method stub
						MyPanel.reImprimir = true;
					}

					@Override
					public void windowIconified(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowOpened(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
		setLocationRelativeTo(null);
		setVisible(true);
		this.setResizable(false);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Test1");
		
	}
	
	public void obtenerNombre()
	{
		if(verticeSeleccionado != null) 
		{
			nombre = (String)JOptionPane.showInputDialog("Escribe Nombre: ");
			
			if(nombre == null || nombre.equals(""))
			{
				nombre = null;
				verticeSeleccionado = null;
				JOptionPane.showMessageDialog(botones,"Nombre no valido!!!!");
				return;
			}
			
			if(MyPanel.mismosNombres(nombre))
			{
				nombre = null;
				verticeSeleccionado = null;
				JOptionPane.showMessageDialog(botones,"Este nombre ya fue ocupado!!!!");
				return;
			}
			
			verticeSeleccionado.setNombre(nombre.replace(" ",""));
			verticeSeleccionado = null;
			nombre = null;
		}else
		{
			JOptionPane.showMessageDialog(botones,"Selecciona un vertice!!!!");
		}
	}
	
	public void obtenerPeso()
	{
		if(aristaSeleccionada != null)
		{
			String aux = (String) JOptionPane.showInputDialog("Escribe peso: ");
			
			if(aux == null || aux.equals(""))
			{
				return;
			}
			
			double auxN;
			try {
				auxN = Double.parseDouble(aux);
			}catch(Exception e) {
				JOptionPane.showMessageDialog(botones, "Solo escribe numeros.");
				auxN = 0;
			}
			
			if(auxN < 0)
			{
				JOptionPane.showMessageDialog(botones,"Solo pesos positivos");
				return;
			}
			
			//peso = auxN;
			aristaSeleccionada.setPeso(auxN);
			aristaSeleccionada = null;
			peso = 0;
		}else
		{
			JOptionPane.showMessageDialog(botones,"Escoje una arista!!!");
		}
		
	}
}