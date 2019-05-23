package cliente.es.deusto.spq.gui;


import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class VentanaTrailerPelicula extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static ImageIcon imagen = new ImageIcon("Icono//icono.jpg");

	public static void main(String[] args) {
		NativeInterface.open();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				JFrame frame = new JFrame("Trailer de la pelicula");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(VentanaTrailerPelicula(), BorderLayout.CENTER);
				frame.setIconImage(imagen.getImage());
				frame.setSize(1366, 768);
				frame.setVisible(true);
			}
		});
		
		NativeInterface.runEventPump();
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

			public void run() {
				NativeInterface.close();
			}
			
		}));
	}

	//M�todo que devuelve el panel con tr�iler
	public static JPanel VentanaTrailerPelicula() {
		JPanel PanelReproductor = new JPanel(new BorderLayout());
		JWebBrowser panel = new JWebBrowser();
		PanelReproductor.add(panel, BorderLayout.CENTER);
		panel.setBarsVisible(false);
		
		
		panel.navigate("https://www.youtube.com/watch_popup?v=Q4_ex7a9ZcY");
		//Utilizo watch_popup para poder ver el trailer en pantalla completa, IMPORTANTE!! hay que a�adirlo a mano para cada url
		return PanelReproductor;
		
	}

}
