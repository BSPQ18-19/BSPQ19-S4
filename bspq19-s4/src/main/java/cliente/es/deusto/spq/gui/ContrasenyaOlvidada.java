package cliente.es.deusto.spq.gui;

import java.awt.EventQueue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ContrasenyaOlvidada extends JFrame {

	private static final long serialVersionUID = 8892233185250939659L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblCorreo;
	private JTextField textFieldCorreo;
	private JButton btnAtras;
	private static ImageIcon imagen = new ImageIcon("Icono//icono.jpg");

	public ContrasenyaOlvidada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 86, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblCorreo = new JLabel("Introducir correo electr\u00F3nico: ");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.insets = new Insets(0, 0, 0, 5);
		gbc_lblCorreo.gridx = 0;
		gbc_lblCorreo.gridy = 0;
		panel.add(lblCorreo, gbc_lblCorreo);

		textFieldCorreo = new JTextField();
		GridBagConstraints gbc_textFieldCorreo = new GridBagConstraints();
		gbc_textFieldCorreo.gridx = 1;
		gbc_textFieldCorreo.gridy = 0;
		panel.add(textFieldCorreo, gbc_textFieldCorreo);
		textFieldCorreo.setColumns(20);

		textFieldCorreo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					String correo = textFieldCorreo.getText();
//					String nombre = VentanaPrincipal.nombre;
					// TODO: Buscar correo del usuario con dicho nombre y si es correcto devolver
					// contraseña
//					if(Correo es correcto para ese usuario){
//						String contrasenya = lo que sea;
//						JOptionPane.showMessageDialog(null, "La contrase\u00F1a del usuario "+nombre+" es "+contrasenya);
//					}
					VentanaPrincipal.administrador = false;
					VentanaPrincipal.usuario = false;
					setVisible(false);
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								//TODO ARREGLAR
								VentanaPrincipal frame = new VentanaPrincipal(null, null, null);
								frame.setVisible(true);
								frame.setTitle("Login");
								frame.setIconImage(imagen.getImage());
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});

		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal.administrador = false;
				VentanaPrincipal.usuario = false;
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//TODO ARREGLAR
							VentanaPrincipal frame = new VentanaPrincipal(null, null, null);
							frame.setVisible(true);
							frame.setTitle("Login");
							frame.setIconImage(imagen.getImage());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 1;
		contentPane.add(btnAtras, gbc_btnAtras);
	}

}
