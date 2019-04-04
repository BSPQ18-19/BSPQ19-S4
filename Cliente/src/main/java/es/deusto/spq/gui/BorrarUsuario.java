package es.deusto.spq.gui;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class BorrarUsuario extends JFrame{
	private static final long serialVersionUID = -2878465684552734783L;
	private JPanel contentPane;
	private JButton btnBorrar;
	private JList<String> listMostarUsuarios;
	private String[]usuarios;
	private static ImageIcon imagen= new ImageIcon("Icono//icono.jpg"); 

	public BorrarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblMostrarUsuarios = new JLabel("Seleccione el usuario que desea borrar:");
		GridBagConstraints gbc_lblMostrarUsuarios = new GridBagConstraints();
		gbc_lblMostrarUsuarios.gridwidth = 2;
		gbc_lblMostrarUsuarios.insets = new Insets(0, 0, 5, 0);
		gbc_lblMostrarUsuarios.gridx = 0;
		gbc_lblMostrarUsuarios.gridy = 0;
		contentPane.add(lblMostrarUsuarios, gbc_lblMostrarUsuarios);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		//TODO: Cargar String[]usuarios con los nombres de todos los usuarios de la BD
		usuarios = null;
		Arrays.sort(usuarios);
		
//		listMostarUsuarios = new JList<String>(usuarios);
//		listMostarUsuarios.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
//		listMostarUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		scrollPane.setViewportView(listMostarUsuarios);
		
		listMostarUsuarios.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(listMostarUsuarios.getSelectedIndex()!=-1){
					btnBorrar.setEnabled(true);
				}
			}
		});
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = listMostarUsuarios.getSelectedIndex();
				String n=usuarios[i];
				//TODO: eliminar el usuarios con nombre n de la BD
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Usuarios frame = new Usuarios();
							frame.setVisible(true);
							frame.setTitle("Base de datos de usuarios");
							frame.setIconImage(imagen.getImage());
							JOptionPane.showMessageDialog(null, "Usuario eliminado");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnBorrar.setEnabled(false);
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.gridwidth = 2;
		gbc_btnBorrar.gridx = 0;
		gbc_btnBorrar.gridy = 2;
		contentPane.add(btnBorrar, gbc_btnBorrar);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		gbc_btnAtras.gridwidth = 2;
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 3;
		contentPane.add(btnAtras, gbc_btnAtras);
	}

}
