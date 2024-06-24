package tfg.bryan;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.ListSelectionModel;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;

public class Consola extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DrawerController drawer;
	private JButton help;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consola frame = new Consola();
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

	private HelpBroker browser;
	private HelpSet helpset;

	public Consola() {
		setTitle("Workflow Hub");
		initComponents();
		drawerElement();
		try {
			URL helpURL = this.getClass().getResource("/ayudas/ayuda.hs");
			helpset = new HelpSet(null, helpURL);
			browser = helpset.createHelpBroker();
			browser.enableHelpOnButton(help, "consola", helpset);
		} catch (HelpSetException ex) {
			ex.printStackTrace();
		}
	}

	private DefaultTableModel tModel;

	private void showMessage(String cadena) {
		JOptionPane.showMessageDialog(this, cadena);
	}

	private boolean connected = false;
	private JTextField jtfIP;
	private JTextField jtfUser;
	private JTextField jtfTable;
	private JPasswordField jtfPassword;
	private JTable jtGestion;

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 47, 833, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 23, 54, 0, 0, 0, 0, 0, 248, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JButton menu = new JButton(new ImageIcon(Consola.class.getResource("/images/menu24px.png")));
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (drawer.isShow()) {
					drawer.hide();
				} else {
					drawer.show();
				}
			}
		});
		GridBagConstraints gbc_menu = new GridBagConstraints();
		gbc_menu.anchor = GridBagConstraints.WEST;
		gbc_menu.fill = GridBagConstraints.VERTICAL;
		gbc_menu.insets = new Insets(0, 0, 5, 5);
		gbc_menu.gridx = 0;
		gbc_menu.gridy = 0;
		contentPane.add(menu, gbc_menu);

		help = new JButton("");
		help.setIcon(new ImageIcon(Consola.class.getResource("/images/help.png")));
		GridBagConstraints gbc_help = new GridBagConstraints();
		gbc_help.fill = GridBagConstraints.BOTH;
		gbc_help.insets = new Insets(0, 0, 5, 0);
		gbc_help.gridx = 2;
		gbc_help.gridy = 0;
		contentPane.add(help, gbc_help);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"Trabajadores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 5;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		jtGestion = new JTable();
		jtGestion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtGestion
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Teléfono", "Dirección" }) {
					private static final long serialVersionUID = 1L;
					boolean[] columnEditables = new boolean[] { false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		JScrollPane scrollPane = new JScrollPane(jtGestion);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);

		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				"Credenciales MySQL", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 7;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 660, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 4;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);

		JLabel lblNewLabel = new JLabel("IP");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		jtfIP = new JTextField();
		GridBagConstraints gbc_jtfIP = new GridBagConstraints();
		gbc_jtfIP.fill = GridBagConstraints.BOTH;
		gbc_jtfIP.insets = new Insets(0, 0, 5, 5);
		gbc_jtfIP.gridx = 2;
		gbc_jtfIP.gridy = 1;
		panel.add(jtfIP, gbc_jtfIP);
		jtfIP.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Usuario");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfUser = new JTextField();
		GridBagConstraints gbc_jtfUser = new GridBagConstraints();
		gbc_jtfUser.fill = GridBagConstraints.BOTH;
		gbc_jtfUser.insets = new Insets(0, 0, 5, 5);
		gbc_jtfUser.gridx = 2;
		gbc_jtfUser.gridy = 2;
		panel.add(jtfUser, gbc_jtfUser);
		jtfUser.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Base de datos");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfTable = new JTextField();
		GridBagConstraints gbc_jtfTable = new GridBagConstraints();
		gbc_jtfTable.fill = GridBagConstraints.BOTH;
		gbc_jtfTable.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTable.gridx = 2;
		gbc_jtfTable.gridy = 3;
		panel.add(jtfTable, gbc_jtfTable);
		jtfTable.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Contraseña");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfPassword = new JPasswordField();
		GridBagConstraints gbc_jtfPassword = new GridBagConstraints();
		gbc_jtfPassword.insets = new Insets(0, 0, 5, 5);
		gbc_jtfPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPassword.gridx = 2;
		gbc_jtfPassword.gridy = 4;
		panel.add(jtfPassword, gbc_jtfPassword);

		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridheight = 6;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 3;
		gbc_panel_4.gridy = 1;
		panel.add(panel_4, gbc_panel_4);

		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridheight = 6;
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		panel.add(panel_5, gbc_panel_5);

		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.gridwidth = 2;
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 5;
		panel.add(panel_6, gbc_panel_6);

		JButton connect = new JButton("Conectar");
		GridBagConstraints gbc_connect = new GridBagConstraints();
		gbc_connect.fill = GridBagConstraints.HORIZONTAL;
		gbc_connect.insets = new Insets(0, 0, 5, 5);
		gbc_connect.gridx = 1;
		gbc_connect.gridy = 6;
		panel.add(connect, gbc_connect);

		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 2;
		gbc_panel_7.gridy = 6;
		panel.add(panel_7, gbc_panel_7);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 4;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 7;
		panel.add(panel_2, gbc_panel_2);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { jtfIP, jtfUser, jtfTable, connect,
				jtfPassword, panel_2, panel_3, panel_4, panel_5, panel_6, panel_7 }));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { jtfIP, jtfUser, jtfTable, jtfPassword,
				connect, jtGestion, panel_2, panel_3, panel_4, panel_5, panel_6, panel_7, help }));
		connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				char[] arrayPass = jtfPassword.getPassword();

				String password = "";

				for (char c : arrayPass) {
					password += c;
				}

				int resultado = Conexion.conectar(jtfIP.getText().toString(), "3306", jtfUser.getText().toString(),
						jtfTable.getText().toString(), password);
//				int resultado = Conexion.conectar("192.168.0.24", "3306", "java", "Projects", "abc123.");
				if (resultado != 0) {
					showMessage("Error al conectar a la base de datos. Compruebe los datos insertados.");
					connected = false;
				} else {

					tModel = new DefaultTableModel();

					tModel = (DefaultTableModel) jtGestion.getModel();

					jtGestion.setModel(tModel);

					llenarTabla();

					showMessage("Conexión realizada con éxito.");
					connected = true;
				}

			}
		});
	}

	private void drawerElement() {
		drawer = Drawer.newDrawer(this).header(new Header()).enableScroll(true).background(new Color(240, 240, 240))
				.backgroundTransparent(0.8f).drawerBackground(new Color(240, 240, 240)).separator(3, new Color(0, 0, 0))
				.addChild(new DrawerItem("Trabajadores")
						.icon(new ImageIcon(getClass().getResource("/images/worker.png"))).build())
				.separator(3, new Color(0, 0, 0))
				.addChild(new DrawerItem("Añadir trabajador")
						.icon(new ImageIcon(getClass().getResource("/images/add.png"))).build())
				.addChild(new DrawerItem("Eliminar trabajador")
						.icon(new ImageIcon(getClass().getResource("/images/minus.png"))).build())
				.addChild(new DrawerItem("Actualizar trabajador")
						.icon(new ImageIcon(getClass().getResource("/images/update.png"))).build())
				.separator(3, new Color(0, 0, 0))
				.addChild(new DrawerItem("Proyectos")
						.icon(new ImageIcon(getClass().getResource("/images/project.png"))).build())
				.separator(3, new Color(0, 0, 0))
				.addChild(new DrawerItem("Añadir proyecto")
						.icon(new ImageIcon(getClass().getResource("/images/add.png"))).build())
				.addChild(new DrawerItem("Eliminar proyecto")
						.icon(new ImageIcon(getClass().getResource("/images/minus.png"))).build())
				.addChild(new DrawerItem("Actualizar proyecto")
						.icon(new ImageIcon(getClass().getResource("/images/update.png"))).build())
				.separator(3, new Color(0, 0, 0))
				.addChild(new DrawerItem("Asignar Proyecto")
						.icon(new ImageIcon(getClass().getResource("/images/assignment.png"))).build())
				.addFooter(new DrawerItem("").icon(new ImageIcon(getClass().getResource("/images/power.png"))).build())
				.event(new EventDrawer() {
					@Override
					public void selected(int index, DrawerItem arg1) {
						if (connected) {
							if (index == 1) {
								altaClientes();
							}
							if (index == 2) {
								bajaClientes();
							}
							if (index == 3) {
								actualizarClientes();
							}
							if (index == 5) {
								altaProyecto();
							}
							if (index == 6) {
								bajaProyecto();
							}
							if (index == 7) {
								actualizarProyecto();
							}
							if (index == 8) {
								asignarProyecto();
							}
							if (index == 9) {
								try {
									Conexion.getConexion().close();
								} catch (SQLException e) {
									e.printStackTrace();
								}
								System.exit(0);
							}
						} else if (index == 9) {
							System.exit(0);
						} else {
							showMessage("Conéctate a una base de datos primero.");
						}

					}
				}).build();
	}

	AsignarProyecto asignarP;

	private void asignarProyecto() {
		asignarP = new AsignarProyecto(this, true, browser, helpset);
		asignarP.setVisible(true);
	}

	BajaProyecto bp;

	private void bajaProyecto() {
		bp = new BajaProyecto(this, true);
		bp.setVisible(true);
	}

	ActualizarProyecto actuP;

	private void actualizarProyecto() {
		actuP = new ActualizarProyecto(this, true, browser, helpset);
		actuP.setVisible(true);
	}

	AltaProyecto ap;

	private void altaProyecto() {
		ap = new AltaProyecto(this, true, browser, helpset);
		ap.setVisible(true);
	}

	ActualizarTrabajador actuC;

	private void actualizarClientes() {
		actuC = new ActualizarTrabajador(this, true, browser, helpset);
		actuC.setVisible(true);
	}

	BajaTrabajador bc;

	private void bajaClientes() {
		bc = new BajaTrabajador(this, true);
		bc.setVisible(true);
	}

	AltaTrabajador ac;

	private void altaClientes() {
		ac = new AltaTrabajador(this, true, browser, helpset);
		ac.setVisible(true);
	}

	public void actualizar() {

		llenarTabla();
	}

	private void llenarTabla() {
		try {
			tModel.setRowCount(0);
			tModel = (DefaultTableModel) jtGestion.getModel();

			Statement stmt = Conexion.getConexion().createStatement();
			String consulta = "select * from Workers order by Last_Name, First_Name desc";
			ResultSet rs = stmt.executeQuery(consulta);
			while (rs.next()) {
				int rows = tModel.getRowCount();
				tModel.setRowCount(rows + 1);

				tModel.setValueAt(rs.getString("Last_Name") + ", " + rs.getString("First_Name"), rows, 0);
				tModel.setValueAt(rs.getString("Phone"), rows, 1);
				tModel.setValueAt(rs.getString("Address"), rows, 2);
			}
		} catch (SQLException ex) {
			Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
