package es.deusto.spq.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class VentanaTrailerPelicula extends JFrame {
	public VentanaTrailerPelicula() {
	}

	private JPanel contentPane;


	public static void main(String[] args) {
		NativeInterface.open();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				JFrame frame = new JFrame("Trailer de la pelicula");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(VentanaTrailerPelicula(), BorderLayout.CENTER);
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

	//Método que devuelve el panel con tráiler
	public static JPanel VentanaTrailerPelicula() {
		JPanel PanelReproductor = new JPanel(new BorderLayout());
		JWebBrowser panel = new JWebBrowser();
		PanelReproductor.add(panel, BorderLayout.CENTER);
		panel.setBarsVisible(false);
		panel.navigate("https://www.youtube.com/watch_popup?v=Q4_ex7a9ZcY");
		//Utilizo watch_popup para poder ver el trailer en pantalla completa, IMPORTANTE!! hay que añadirlo a mano para cada url
		return PanelReproductor;
		
	}

}
