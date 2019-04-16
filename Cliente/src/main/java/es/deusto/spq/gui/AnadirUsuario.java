package es.deusto.spq.gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AnadirUsuario extends JFrame {
	private static final long serialVersionUID = 674330126384087764L;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JLabel lblContrasea1;
	private JPasswordField passwordFieldContrasea1;
	private JLabel lblContrasea2;
	private JPasswordField passwordFieldContrasea2;
	private JLabel lblCorreo1;
	private JTextField textFieldCorreo1;
	private JLabel lblCorreo2;
	private JTextField textFieldCorreo2;
	private JLabel lblPaypal1;
	private JTextField textFieldPaypal1;
	private JLabel lblPaypal2;
	private JTextField textFieldPaypal2;
	private JCheckBox chckbxAdministrador;
	private JPanel panel;
	private JLabel lblAdminSiONo;
	private JTextField textFieldAdminSiONo;
	private JButton btnAnadirUsuario;
	private JButton btnAtras;
	String usuario = null;
	String contrasenya1 = null;
	String correo1 = null;
	String paypal1 = null;
	boolean administrador = false;
	private static ImageIcon imagen = new ImageIcon("Icono//icono.jpg");

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirUsuario frame = new AnadirUsuario();
					frame.setVisible(true);
					frame.setTitle("Añadir Usuario");
					frame.setIconImage(imagen.getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AnadirUsuario() {
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblUsuario = new JLabel("Introducir nombre de usuario: ");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.fill = GridBagConstraints.VERTICAL;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 0;
		contentPane.add(lblUsuario, gbc_lblUsuario);

		textFieldUsuario = new JTextField();
		GridBagConstraints gbc_textFieldUsuario = new GridBagConstraints();
		gbc_textFieldUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldUsuario.gridx = 1;
		gbc_textFieldUsuario.gridy = 0;
		contentPane.add(textFieldUsuario, gbc_textFieldUsuario);
		textFieldUsuario.setColumns(20);

		textFieldUsuario.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					usuario = textFieldUsuario.getText();
					boolean disponible = true;
					// TODO: comprobar en la BD si el nombre de usuario estï¿½ disponible
					if (disponible == false) {
						JOptionPane.showMessageDialog(null, "Este nombre de usuario no est\u00E1 disponible");
					} else {
						lblContrasea1.setEnabled(true);
						passwordFieldContrasea1.setEnabled(true);
						textFieldUsuario.setEditable(false);
						passwordFieldContrasea1.requestFocus();
					}
				}
			}
		});

		lblContrasea1 = new JLabel("Introducir contrase\u00F1a:");
		lblContrasea1.setEnabled(false);
		GridBagConstraints gbc_lblContrasea1 = new GridBagConstraints();
		gbc_lblContrasea1.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea1.gridx = 0;
		gbc_lblContrasea1.gridy = 1;
		contentPane.add(lblContrasea1, gbc_lblContrasea1);

		passwordFieldContrasea1 = new JPasswordField();
		passwordFieldContrasea1.setEnabled(false);
		passwordFieldContrasea1.setColumns(20);
		GridBagConstraints gbc_passwordFieldContrasea1 = new GridBagConstraints();
		gbc_passwordFieldContrasea1.insets = new Insets(0, 0, 5, 0);
		gbc_passwordFieldContrasea1.gridx = 1;
		gbc_passwordFieldContrasea1.gridy = 1;
		contentPane.add(passwordFieldContrasea1, gbc_passwordFieldContrasea1);

		passwordFieldContrasea1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					contrasenya1 = new String(passwordFieldContrasea1.getPassword());
					lblContrasea2.setEnabled(true);
					passwordFieldContrasea2.setEnabled(true);
					passwordFieldContrasea1.setEditable(false);
					passwordFieldContrasea2.requestFocus();
				}
			}
		});

		lblContrasea2 = new JLabel("Repetir contrase\u00F1a: ");
		lblContrasea2.setEnabled(false);
		GridBagConstraints gbc_lblContrasea2 = new GridBagConstraints();
		gbc_lblContrasea2.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea2.gridx = 0;
		gbc_lblContrasea2.gridy = 2;
		contentPane.add(lblContrasea2, gbc_lblContrasea2);

		passwordFieldContrasea2 = new JPasswordField();
		passwordFieldContrasea2.setEnabled(false);
		passwordFieldContrasea2.setColumns(20);
		GridBagConstraints gbc_passwordFieldContrasea2 = new GridBagConstraints();
		gbc_passwordFieldContrasea2.insets = new Insets(0, 0, 5, 0);
		gbc_passwordFieldContrasea2.gridx = 1;
		gbc_passwordFieldContrasea2.gridy = 2;
		contentPane.add(passwordFieldContrasea2, gbc_passwordFieldContrasea2);

		passwordFieldContrasea2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String contrasenya2 = new String(passwordFieldContrasea2.getPassword());
					if (!contrasenya2.equals(contrasenya1)) {
						JOptionPane.showMessageDialog(null,
								"La contrase\u00F1a repetida no es igual a la contrase\u00F1a introducida");
					} else {
						lblCorreo1.setEnabled(true);
						textFieldCorreo1.setEnabled(true);
						passwordFieldContrasea2.setEditable(false);
						textFieldCorreo1.requestFocus();
					}
				}
			}
		});

		lblCorreo1 = new JLabel("Introducir correo electr\u00F3nico:");
		lblCorreo1.setEnabled(false);
		GridBagConstraints gbc_lblCorreo1 = new GridBagConstraints();
		gbc_lblCorreo1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo1.gridx = 0;
		gbc_lblCorreo1.gridy = 3;
		contentPane.add(lblCorreo1, gbc_lblCorreo1);

		textFieldCorreo1 = new JTextField();
		textFieldCorreo1.setEnabled(false);
		GridBagConstraints gbc_textFieldCorreo1 = new GridBagConstraints();
		gbc_textFieldCorreo1.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCorreo1.gridx = 1;
		gbc_textFieldCorreo1.gridy = 3;
		contentPane.add(textFieldCorreo1, gbc_textFieldCorreo1);
		textFieldCorreo1.setColumns(20);

		textFieldCorreo1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					correo1 = textFieldCorreo1.getText();
					lblCorreo2.setEnabled(true);
					textFieldCorreo2.setEnabled(true);
					textFieldCorreo1.setEditable(false);
					textFieldCorreo2.requestFocus();
				}
			}
		});

		lblCorreo2 = new JLabel("Repetir correo electr\u00F3nico:");
		lblCorreo2.setEnabled(false);
		GridBagConstraints gbc_lblCorreo2 = new GridBagConstraints();
		gbc_lblCorreo2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo2.gridx = 0;
		gbc_lblCorreo2.gridy = 4;
		contentPane.add(lblCorreo2, gbc_lblCorreo2);

		textFieldCorreo2 = new JTextField();
		textFieldCorreo2.setEnabled(false);
		GridBagConstraints gbc_textFieldCorreo2 = new GridBagConstraints();
		gbc_textFieldCorreo2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCorreo2.gridx = 1;
		gbc_textFieldCorreo2.gridy = 4;
		contentPane.add(textFieldCorreo2, gbc_textFieldCorreo2);
		textFieldCorreo2.setColumns(20);

		textFieldCorreo2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String correo2 = textFieldCorreo2.getText();
					if (!correo2.equals(correo1)) {
						JOptionPane.showMessageDialog(null, "El correo repetido no es igual al correo introducido");
					} else {
						lblPaypal1.setEnabled(true);
						textFieldPaypal1.setEnabled(true);
						textFieldCorreo2.setEditable(false);
						textFieldPaypal1.requestFocus();
					}
				}
			}
		});

		lblPaypal1 = new JLabel("Introducir cuenta de Paypal:");
		lblPaypal1.setEnabled(false);
		GridBagConstraints gbc_lblPaypal1 = new GridBagConstraints();
		gbc_lblPaypal1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaypal1.gridx = 0;
		gbc_lblPaypal1.gridy = 5;
		contentPane.add(lblPaypal1, gbc_lblPaypal1);

		textFieldPaypal1 = new JTextField();
		textFieldPaypal1.setEnabled(false);
		GridBagConstraints gbc_textFieldPaypal1 = new GridBagConstraints();
		gbc_textFieldPaypal1.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPaypal1.gridx = 1;
		gbc_textFieldPaypal1.gridy = 5;
		contentPane.add(textFieldPaypal1, gbc_textFieldPaypal1);
		textFieldPaypal1.setColumns(20);

		textFieldPaypal1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					paypal1 = textFieldPaypal1.getText();
					lblPaypal2.setEnabled(true);
					textFieldPaypal2.setEnabled(true);
					textFieldPaypal1.setEditable(false);
					textFieldPaypal2.requestFocus();
				}
			}
		});

		lblPaypal2 = new JLabel("Repetir cuenta de Paypal:");
		lblPaypal2.setEnabled(false);
		GridBagConstraints gbc_lblPaypal2 = new GridBagConstraints();
		gbc_lblPaypal2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaypal2.gridx = 0;
		gbc_lblPaypal2.gridy = 6;
		contentPane.add(lblPaypal2, gbc_lblPaypal2);

		textFieldPaypal2 = new JTextField();
		textFieldPaypal2.setEnabled(false);
		GridBagConstraints gbc_textFieldPaypal2 = new GridBagConstraints();
		gbc_textFieldPaypal2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPaypal2.gridx = 1;
		gbc_textFieldPaypal2.gridy = 6;
		contentPane.add(textFieldPaypal2, gbc_textFieldPaypal2);
		textFieldPaypal2.setColumns(20);

		textFieldPaypal2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String paypal2 = textFieldPaypal2.getText();
					if (!paypal2.equals(paypal1)) {
						JOptionPane.showMessageDialog(null, "La cuenta repetida no es igual a la cuenta introducida");
					} else {
						chckbxAdministrador.setEnabled(true);
						btnAnadirUsuario.setEnabled(true);
						textFieldPaypal2.setEditable(false);
					}
				}
			}
		});

		chckbxAdministrador = new JCheckBox("Administrador");
		chckbxAdministrador.setEnabled(false);
		GridBagConstraints gbc_chckbxAdministrador = new GridBagConstraints();
		gbc_chckbxAdministrador.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAdministrador.gridx = 0;
		gbc_chckbxAdministrador.gridy = 7;
		contentPane.add(chckbxAdministrador, gbc_chckbxAdministrador);
		chckbxAdministrador.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (chckbxAdministrador.isSelected()) {
					btnAnadirUsuario.setEnabled(false);
					lblAdminSiONo.setEnabled(true);
					textFieldAdminSiONo.setEnabled(true);
					textFieldAdminSiONo.requestFocus();
				} else {
					lblAdminSiONo.setEnabled(false);
					textFieldAdminSiONo.setEnabled(false);
					btnAnadirUsuario.setEnabled(true);
				}
			}
		});

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 7;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblAdminSiONo = new JLabel("Introducir c\u00F3digo de administrador:");
		lblAdminSiONo.setEnabled(false);
		GridBagConstraints gbc_lblAdminSiONo = new GridBagConstraints();
		gbc_lblAdminSiONo.insets = new Insets(0, 0, 0, 5);
		gbc_lblAdminSiONo.gridx = 0;
		gbc_lblAdminSiONo.gridy = 0;
		panel.add(lblAdminSiONo, gbc_lblAdminSiONo);

		textFieldAdminSiONo = new JTextField();
		textFieldAdminSiONo.setEnabled(false);
		GridBagConstraints gbc_textFieldAdminSiONo = new GridBagConstraints();
		gbc_textFieldAdminSiONo.gridx = 1;
		gbc_textFieldAdminSiONo.gridy = 0;
		panel.add(textFieldAdminSiONo, gbc_textFieldAdminSiONo);
		textFieldAdminSiONo.setColumns(15);

		textFieldAdminSiONo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String codigo = textFieldAdminSiONo.getText();
					if (codigo.equals("123456789")) {
						administrador = true;
						btnAnadirUsuario.setEnabled(true);
						textFieldAdminSiONo.setEditable(false);
					} else {
						JOptionPane.showMessageDialog(null, "El c\u00F3digo introducido no es correcto");
						btnAnadirUsuario.setEnabled(false);
					}
				}
			}
		});

		btnAnadirUsuario = new JButton("A\u00F1adir");
		btnAnadirUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (administrador == true) {
					// TODO: guardar usuario en la BD como administrador	
				} else {
					// TODO: guardar usuario en la BD como usuario
						
				}
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							
							java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bspq19-s4", "spq", "spq");
							
							String nombre = textFieldUsuario.getText();
							String contrasenna = passwordFieldContrasea1.getText();
							String correo = textFieldCorreo1.getText();
							String paypal = textFieldPaypal1.getText();
							
							String query = "INSERT INTO usuario (Nombre, Contraseña, Correo, Paypal) values ('"+nombre+"', '"+contrasenna+"', '"+correo+"', '"+paypal+"')";
							
							Statement stmt = conexion.createStatement();
							stmt.executeUpdate(query);
							
						
							Usuarios frame = new Usuarios();
							frame.setVisible(true);
							frame.setTitle("Base de datos de usuarios");
							frame.setIconImage(imagen.getImage());
							JOptionPane.showMessageDialog(null, "Nuevo usuario a\u00F1adido correctamente a la BD");
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnAnadirUsuario.setEnabled(false);
		GridBagConstraints gbc_btnAnadirUsuario = new GridBagConstraints();
		gbc_btnAnadirUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnadirUsuario.gridx = 0;
		gbc_btnAnadirUsuario.gridy = 8;
		contentPane.add(btnAnadirUsuario, gbc_btnAnadirUsuario);

		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Usuarios frame = new Usuarios();
							frame.setVisible(true);
							frame.setTitle("Base de datos de usuarios");
							frame.setIconImage(imagen.getImage());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.gridx = 1;
		gbc_btnAtras.gridy = 8;
		contentPane.add(btnAtras, gbc_btnAtras);
	}

}
