package cliente.es.deusto.spq.gui;

import java.awt.CardLayout;
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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cliente.es.deusto.spq.controller.AnadirPeliculaController;


public class AnadirPelicula extends JPanel {
	private static final long serialVersionUID = 674330126384087764L;
	private JLabel lblPelicula;
	private JTextField textFieldPelicula;
	private JLabel lblGenero;
	private JTextField textFieldGenero;
	private JLabel lblfEstreno;
	private JTextField textFieldfEstreno;
	private JLabel lbltrailer;
	private JTextField textFieldtrailer;
	private JLabel lblSinopsis;
	private JTextField textFieldSinopsis;
	private JLabel lblFichaTecnica;
	private JTextField textFieldFichaTecnica;
	private JCheckBox chckbxSaga;
	private JPanel panel;
	private JLabel lblSaga;
	private JTextField textFieldSaga;
	private JButton btnAnadirPelicula;
	private JButton btnAtras;
	String titulo = null;
	String genero = null;
	String fEstreno = null;
	String trailer = null;
	String sinopsis = null;
	String fichaTecnica = null;
	String saga = null;

	public AnadirPelicula(AnadirPeliculaController anadirPeliculaController, CardLayout cardLayout) {
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 , 1.0, 1.0};
		setLayout(gbl_contentPane);

		lblPelicula = new JLabel("Introducir titulo de pelicula: ");
		GridBagConstraints gbc_lblPelicula = new GridBagConstraints();
		gbc_lblPelicula.insets = new Insets(0, 0, 5, 5);
		gbc_lblPelicula.gridx = 0;
		gbc_lblPelicula.gridy = 0;
		add(lblPelicula, gbc_lblPelicula);

		textFieldPelicula = new JTextField();
		GridBagConstraints gbc_textFieldPelicula = new GridBagConstraints();
		gbc_textFieldPelicula.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPelicula.gridx = 1;
		gbc_textFieldPelicula.gridy = 0;
		add(textFieldPelicula, gbc_textFieldPelicula);
		textFieldPelicula.setColumns(20);

		textFieldPelicula.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					titulo = textFieldPelicula.getText();
					boolean anadida = false;
					// TODO: comprobar en la BD si el titulo de la pelicula esta añadido
					if (anadida == true) {
						JOptionPane.showMessageDialog(null, "Esta pelicula ya est\u00E1  añadida");
					} else {
						lblGenero.setEnabled(true);
						textFieldGenero.setEnabled(true);
						textFieldPelicula.setEditable(false);
						textFieldGenero.requestFocus();
					}
				}
			}
		});

		lblGenero = new JLabel("Introducir genero de la pelicula:");
		lblGenero.setEnabled(false);
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 0;
		gbc_lblGenero.gridy = 1;
		add(lblGenero, gbc_lblGenero);

		textFieldGenero = new JTextField();
		textFieldGenero.setEnabled(false);
		textFieldGenero.setColumns(20);
		GridBagConstraints gbc_textFieldGenero = new GridBagConstraints();
		gbc_textFieldGenero.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldGenero.gridx = 1;
		gbc_textFieldGenero.gridy = 1;
		add(textFieldGenero, gbc_textFieldGenero);

		textFieldGenero.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					genero = new String(textFieldGenero.getText());
					lblfEstreno.setEnabled(true);
					textFieldfEstreno.setEnabled(true);
					textFieldGenero.setEditable(false);
					textFieldfEstreno.requestFocus();
				}
			}
		});

		lblfEstreno = new JLabel("Introducir fecha de estreno: ");
		lblfEstreno.setEnabled(false);
		GridBagConstraints gbc_lblfEstreno = new GridBagConstraints();
		gbc_lblfEstreno.insets = new Insets(0, 0, 5, 5);
		gbc_lblfEstreno.gridx = 0;
		gbc_lblfEstreno.gridy = 2;
		add(lblfEstreno, gbc_lblfEstreno);

		textFieldfEstreno = new JTextField();
		textFieldfEstreno.setEnabled(false);
		textFieldfEstreno.setColumns(20);
		GridBagConstraints gbc_textFieldfEstreno = new GridBagConstraints();
		gbc_textFieldfEstreno.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldfEstreno.gridx = 1;
		gbc_textFieldfEstreno.gridy = 2;
		add(textFieldfEstreno, gbc_textFieldfEstreno);

		textFieldfEstreno.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					fEstreno = new String(textFieldfEstreno.getText());
					lbltrailer.setEnabled(true);
					textFieldtrailer.setEnabled(true);
					textFieldfEstreno.setEditable(false);
					textFieldtrailer.requestFocus();
				}
			}
		});

		lbltrailer = new JLabel("Introducir direcci\u00F3n del trailer:");
		lbltrailer.setEnabled(false);
		GridBagConstraints gbc_lbltrailer = new GridBagConstraints();
		gbc_lbltrailer.insets = new Insets(0, 0, 5, 5);
		gbc_lbltrailer.gridx = 0;
		gbc_lbltrailer.gridy = 3;
		add(lbltrailer, gbc_lbltrailer);

		textFieldtrailer = new JTextField();
		textFieldtrailer.setEnabled(false);
		GridBagConstraints gbc_textFieldtrailer = new GridBagConstraints();
		gbc_textFieldtrailer.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldtrailer.gridx = 1;
		gbc_textFieldtrailer.gridy = 3;
		add(textFieldtrailer, gbc_textFieldtrailer);
		textFieldtrailer.setColumns(20);

		textFieldtrailer.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					trailer = textFieldtrailer.getText();
					lblSinopsis.setEnabled(true);
					textFieldSinopsis.setEnabled(true);
					textFieldtrailer.setEditable(false);
					textFieldSinopsis.requestFocus();
				}
			}
		});
		
		lblSinopsis = new JLabel("Introducir sinopsis de la pelicula:");
		lblSinopsis.setEnabled(false);
		GridBagConstraints gbc_lblSinopsis = new GridBagConstraints();
		gbc_lblSinopsis.insets = new Insets(0, 0, 5, 5);
		gbc_lblSinopsis.gridx = 0;
		gbc_lblSinopsis.gridy = 4;
		add(lblSinopsis, gbc_lblSinopsis);

		textFieldSinopsis = new JTextField();
		textFieldSinopsis.setEnabled(false);
		GridBagConstraints gbc_textFieldSinopsis = new GridBagConstraints();
		gbc_textFieldSinopsis.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldSinopsis.gridx = 1;
		gbc_textFieldSinopsis.gridy = 4;
		add(textFieldSinopsis, gbc_textFieldSinopsis);
		textFieldSinopsis.setColumns(20);

		textFieldSinopsis.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					sinopsis = textFieldSinopsis.getText();
					lblFichaTecnica.setEnabled(true);
					textFieldFichaTecnica.setEnabled(true);
					textFieldSinopsis.setEditable(false);
					textFieldFichaTecnica.requestFocus();
				}
			}
		});


		lblFichaTecnica = new JLabel("Introducir ficha tecnica:");
		lblFichaTecnica.setEnabled(false);
		GridBagConstraints gbc_lblFichaTecnica = new GridBagConstraints();
		gbc_lblFichaTecnica.insets = new Insets(0, 0, 5, 5);
		gbc_lblFichaTecnica.gridx = 0;
		gbc_lblFichaTecnica.gridy = 5;
		add(lblFichaTecnica, gbc_lblFichaTecnica);

		textFieldFichaTecnica = new JTextField();
		textFieldFichaTecnica.setEnabled(false);
		GridBagConstraints gbc_textFieldFichaTecnica = new GridBagConstraints();
		gbc_textFieldFichaTecnica.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldFichaTecnica.gridx = 1;
		gbc_textFieldFichaTecnica.gridy = 5;
		add(textFieldFichaTecnica, gbc_textFieldFichaTecnica);
		textFieldFichaTecnica.setColumns(20);

		textFieldFichaTecnica.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					fichaTecnica = textFieldFichaTecnica.getText();
					chckbxSaga.setEnabled(true);
					btnAnadirPelicula.setEnabled(true);
					textFieldFichaTecnica.setEditable(false);
				}
			}
		});

		chckbxSaga = new JCheckBox("Pertenece a Saga");
		chckbxSaga.setEnabled(false);
		GridBagConstraints gbc_chckbxSaga = new GridBagConstraints();
		gbc_chckbxSaga.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSaga.gridx = 0;
		gbc_chckbxSaga.gridy = 6;
		add(chckbxSaga, gbc_chckbxSaga);
		chckbxSaga.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (chckbxSaga.isSelected()) {
					btnAnadirPelicula.setEnabled(false);
					lblSaga.setEnabled(true);
					textFieldSaga.setEnabled(true);
					textFieldSaga.requestFocus();
				} else {
					lblSaga.setEnabled(false);
					textFieldSaga.setEnabled(false);
					btnAnadirPelicula.setEnabled(true);
				}
			}
		});

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 6;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblSaga = new JLabel("Introducir saga a la que pertenece la pelicula:");
		lblSaga.setEnabled(false);
		GridBagConstraints gbc_lblSaga = new GridBagConstraints();
		gbc_lblSaga.insets = new Insets(0, 0, 0, 5);
		gbc_lblSaga.gridx = 0;
		gbc_lblSaga.gridy = 0;
		panel.add(lblSaga, gbc_lblSaga);

		textFieldSaga = new JTextField();
		textFieldSaga.setEnabled(false);
		GridBagConstraints gbc_textFieldSaga = new GridBagConstraints();
		gbc_textFieldSaga.gridx = 1;
		gbc_textFieldSaga.gridy = 0;
		panel.add(textFieldSaga, gbc_textFieldSaga);
		textFieldSaga.setColumns(15);

		textFieldSaga.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					saga = textFieldSaga.getText();
					btnAnadirPelicula.setEnabled(true);
					textFieldSaga.setEditable(false);
				}
			}
		});

		btnAnadirPelicula = new JButton("A\u00F1adir");
		btnAnadirPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: guardar pelicula en la BD
				reinicio();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
//							Class.forName("com.mysql.jdbc.Driver");
//							
//							java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bspq19-s4", "spq", "spq");
//							
//							//int pelicula_id = Integer.parseInt(textFieldPelicula_id.getText());
//							
//							String titulo = textFieldPelicula.getText();
//							String genero = textFieldGenero.getText();
//							String festreno = textFieldfEstreno.getText();
//							String trailer = textFieldtrailer.getText();
//							String fichatecnica = textFieldFichaTecnica.getText();
//							String sinopsis = textFieldSinopsis.getText();
//							int puntuacion = 8;
//							
//							String query = "INSERT INTO pelicula (FESTRENO, FICHATECNICA, GENERO, SINOPSIS, TITULO, TRAILER) values ('"+festreno+"', '"+fichatecnica+"','"+genero+"','"+sinopsis+"', '"+titulo+"', '"+trailer+"')";
//							
//							Statement stmt = conexion.createStatement();
//							stmt.executeUpdate(query);
//							
							cardLayout.show(getParent(), VentanaPrincipal.PELICULAS);
							JOptionPane.showMessageDialog(null, "Nueva pelicula a\u00F1adida a la BD");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnAnadirPelicula.setEnabled(false);
		GridBagConstraints gbc_btnAnadirPelicula = new GridBagConstraints();
		gbc_btnAnadirPelicula.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnadirPelicula.gridx = 1;
		gbc_btnAnadirPelicula.gridy = 7;
		add(btnAnadirPelicula, gbc_btnAnadirPelicula);

		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reinicio();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cardLayout.show(getParent(), VentanaPrincipal.PELICULAS);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 7;
		add(btnAtras, gbc_btnAtras);
	}
	
	public void reinicio() {
		textFieldPelicula.setText(null);
		textFieldPelicula.setEnabled(true);
		textFieldPelicula.setEditable(true);
		lblPelicula.setEnabled(true);
		textFieldGenero.setText(null);
		textFieldGenero.setEnabled(false);
		textFieldGenero.setEditable(true);
		lblGenero.setEnabled(false);
		textFieldfEstreno.setText(null);
		textFieldfEstreno.setEnabled(false);
		textFieldfEstreno.setEditable(true);
		lblfEstreno.setEnabled(false);
		textFieldtrailer.setText(null);
		textFieldtrailer.setEnabled(false);
		textFieldtrailer.setEditable(true);
		lbltrailer.setEnabled(false);
		textFieldSinopsis.setText(null);
		textFieldSinopsis.setEnabled(false);
		textFieldSinopsis.setEditable(true);
		lblSinopsis.setEnabled(false);
		textFieldFichaTecnica.setText(null);
		textFieldFichaTecnica.setEnabled(false);
		textFieldFichaTecnica.setEditable(true);
		lblFichaTecnica.setEnabled(false);
		chckbxSaga.setEnabled(false);
		chckbxSaga.setSelected(false);
		lblSaga.setEnabled(false);
		textFieldSaga.setText(null);
		textFieldSaga.setEnabled(false);
		textFieldSaga.setEditable(true);
		btnAnadirPelicula.setEnabled(false);
	}
}
