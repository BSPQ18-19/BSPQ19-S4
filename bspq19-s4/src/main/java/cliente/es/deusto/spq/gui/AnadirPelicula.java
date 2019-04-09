package cliente.es.deusto.spq.gui;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AnadirPelicula extends JFrame {
	private static final long serialVersionUID = 674330126384087764L;
	private JPanel contentPane;
	private JTextField textFieldPelicula;
	private JLabel lblGenero;
	private JTextField textFieldGenero;
	private JLabel lblfEstreno;
	private JTextField textFieldfEstreno;
	private JLabel lbltrailer;
	private JTextField textFieldtrailer;
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
	String fichaTecnica = null;
	String saga = null;
	private static ImageIcon imagen = new ImageIcon("Icono//icono.jpg");

	public AnadirPelicula() {
		setBounds(100, 100, 643, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblPelicula = new JLabel("Introducir titulo de pelicula: ");
		GridBagConstraints gbc_lblPelicula = new GridBagConstraints();
		gbc_lblPelicula.fill = GridBagConstraints.VERTICAL;
		gbc_lblPelicula.insets = new Insets(0, 0, 5, 5);
		gbc_lblPelicula.gridx = 0;
		gbc_lblPelicula.gridy = 0;
		contentPane.add(lblPelicula, gbc_lblPelicula);

		textFieldPelicula = new JTextField();
		GridBagConstraints gbc_textFieldPelicula = new GridBagConstraints();
		gbc_textFieldPelicula.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPelicula.gridx = 1;
		gbc_textFieldPelicula.gridy = 0;
		contentPane.add(textFieldPelicula, gbc_textFieldPelicula);
		textFieldPelicula.setColumns(20);

		textFieldPelicula.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					titulo = textFieldPelicula.getText();
					boolean anadida = false;
					// TODO: comprobar en la BD si el titulo de la pelicula esta añadido
					if (anadida == true) {
						JOptionPane.showMessageDialog(null, "Esta pelicula ya est\u00E1 a�adida");
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
		contentPane.add(lblGenero, gbc_lblGenero);

		textFieldGenero = new JTextField();
		textFieldGenero.setEnabled(false);
		textFieldGenero.setColumns(20);
		GridBagConstraints gbc_textFieldGenero = new GridBagConstraints();
		gbc_textFieldGenero.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldGenero.gridx = 1;
		gbc_textFieldGenero.gridy = 1;
		contentPane.add(textFieldGenero, gbc_textFieldGenero);

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
		contentPane.add(lblfEstreno, gbc_lblfEstreno);

		textFieldfEstreno = new JTextField();
		textFieldfEstreno.setEnabled(false);
		textFieldfEstreno.setColumns(20);
		GridBagConstraints gbc_textFieldfEstreno = new GridBagConstraints();
		gbc_textFieldfEstreno.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldfEstreno.gridx = 1;
		gbc_textFieldfEstreno.gridy = 2;
		contentPane.add(textFieldfEstreno, gbc_textFieldfEstreno);

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
		contentPane.add(lbltrailer, gbc_lbltrailer);

		textFieldtrailer = new JTextField();
		textFieldtrailer.setEnabled(false);
		GridBagConstraints gbc_textFieldtrailer = new GridBagConstraints();
		gbc_textFieldtrailer.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldtrailer.gridx = 1;
		gbc_textFieldtrailer.gridy = 3;
		contentPane.add(textFieldtrailer, gbc_textFieldtrailer);
		textFieldtrailer.setColumns(20);

		textFieldtrailer.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					trailer = textFieldtrailer.getText();
					lblFichaTecnica.setEnabled(true);
					textFieldFichaTecnica.setEnabled(true);
					textFieldtrailer.setEditable(false);
					textFieldFichaTecnica.requestFocus();
				}
			}
		});

		lblFichaTecnica = new JLabel("Introducir ficha tecnica:");
		lblFichaTecnica.setEnabled(false);
		GridBagConstraints gbc_lblFichaTecnica = new GridBagConstraints();
		gbc_lblFichaTecnica.insets = new Insets(0, 0, 5, 5);
		gbc_lblFichaTecnica.gridx = 0;
		gbc_lblFichaTecnica.gridy = 4;
		contentPane.add(lblFichaTecnica, gbc_lblFichaTecnica);

		textFieldFichaTecnica = new JTextField();
		textFieldFichaTecnica.setEnabled(false);
		GridBagConstraints gbc_textFieldFichaTecnica = new GridBagConstraints();
		gbc_textFieldFichaTecnica.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldFichaTecnica.gridx = 1;
		gbc_textFieldFichaTecnica.gridy = 4;
		contentPane.add(textFieldFichaTecnica, gbc_textFieldFichaTecnica);
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
		gbc_chckbxSaga.gridy = 5;
		contentPane.add(chckbxSaga, gbc_chckbxSaga);
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
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 5;
		contentPane.add(panel, gbc_panel);
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
				// TODO: guardar pelicula en la BD como administrador
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Peliculas frame = new Peliculas();
							frame.setVisible(true);
							frame.setTitle("Base de datos de peliculas");
							frame.setIconImage(imagen.getImage());
							JOptionPane.showMessageDialog(null, "Nueva pelicula a\u00F1adido");
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
		gbc_btnAnadirPelicula.gridx = 0;
		gbc_btnAnadirPelicula.gridy = 6;
		contentPane.add(btnAnadirPelicula, gbc_btnAnadirPelicula);

		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Peliculas frame = new Peliculas();
							frame.setVisible(true);
							frame.setTitle("Base de datos de peliculas");
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
		gbc_btnAtras.gridy = 6;
		contentPane.add(btnAtras, gbc_btnAtras);
	}

}
