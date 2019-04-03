package es.deusto.spq.gui;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Usuario extends JFrame{

	private static final long serialVersionUID = -1644310303190255276L;
	private JPanel contentPane;
	private static ImageIcon imagen= new ImageIcon("Icono//icono.jpg");
	
	//TODO:eliminar hasta la linea 30 cuando funcione la BD
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Usuario frame = new Usuario();
						frame.setVisible(true);
						frame.setTitle("Usuario");
						frame.setIconImage(imagen.getImage());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
	public Usuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		//TODO: añadir botones y componenete lista de peliculas ordenadadas por titulo, genero o fecha
	}
}
