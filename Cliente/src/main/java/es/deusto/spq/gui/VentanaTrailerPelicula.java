package es.deusto.spq.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaTrailerPelicula extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTrailerPelicula frame = new VentanaTrailerPelicula();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaTrailerPelicula() {
		setTitle("Trailer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		//mediaPlayer Prueba 1
		setLayout(new BorderLayout());

        URL mediaURL = https://www.youtube.com/watch?v=Q4_ex7a9ZcY
        //reproductor 
        Player VentanaTrailerPelicula = Manager.createRealizedPlayer(mediaURL);
        //componentes para botones playback
        Component video = VentanaTrailerPelicula.getVisualComponent();
        Component controls = VentanaTrailerPelicula.getControlPanelComponent();
        add(video,BorderLayout.CENTER);
        add(controls,BorderLayout.SOUTH);
	}

}
