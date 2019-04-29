package cliente.es.deusto.spq.gui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cliente.es.deusto.spq.controller.BorrarUsuarioController;

public class BorrarUsuario extends JPanel {
	private static final long serialVersionUID = -2878465684552734783L;
	private JButton btnBorrar;
	private JList<String> listMostarUsuarios;
	//TODO: eliminar la siguiente linea
	private String[] usuarios = { "a", "b" };
	private BorrarUsuarioController controller = null;

	public BorrarUsuario(BorrarUsuarioController borrarUsuarioController, CardLayout cardLayout) {

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gbl_contentPane);

		JLabel lblMostrarUsuarios = new JLabel("Seleccione el usuario que desea borrar:");
		GridBagConstraints gbc_lblMostrarUsuarios = new GridBagConstraints();
		gbc_lblMostrarUsuarios.insets = new Insets(0, 0, 5, 0);
		gbc_lblMostrarUsuarios.gridx = 0;
		gbc_lblMostrarUsuarios.gridy = 0;
		add(lblMostrarUsuarios, gbc_lblMostrarUsuarios);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);

		// TODO: Cargar String[]usuarios con los correos de todos los usuarios de la BD
		Arrays.sort(usuarios);

		listMostarUsuarios = new JList<String>(usuarios);
		listMostarUsuarios.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listMostarUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listMostarUsuarios);

		listMostarUsuarios.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (listMostarUsuarios.getSelectedIndex() != -1) {
					btnBorrar.setEnabled(true);
				}
			}
		});

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = listMostarUsuarios.getSelectedIndex();
				String n = usuarios[i];
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							controller.borrarUsuario(n);
							cardLayout.show(getParent(), VentanaPrincipal.USUARIOS);
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
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBorrar.gridx = 0;
		gbc_btnBorrar.gridy = 2;
		add(btnBorrar, gbc_btnBorrar);

		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cardLayout.show(getParent(), VentanaPrincipal.USUARIOS);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 3;
		add(btnAtras, gbc_btnAtras);
	}

}