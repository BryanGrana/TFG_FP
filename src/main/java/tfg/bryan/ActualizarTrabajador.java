package tfg.bryan;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import com.toedter.calendar.JDateChooser;

import models.ProjectWorker;
import models.Worker;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ActualizarTrabajador extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField apellidos;
	private JTextField email;
	private JTextField phone;
	private JTextField address;
	private JTable jtGestion;
	private JComboBox<ProjectWorker> proyectos;
	private JComboBox<String> puesto;
	private JButton btnImagen;
	private static HelpBroker browser;
	private static HelpSet helpset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ActualizarTrabajador dialog = new ActualizarTrabajador(new JFrame(), true, browser, helpset);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ActualizarTrabajador(JFrame parent, boolean modal, HelpBroker browser, HelpSet helpset) {
		super(parent, modal);
		setTitle("Actualizar trabajador");
		setBounds(100, 100, 1182, 833);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.gridheight = 3;
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 2;
		gbc_panel_6.gridy = 1;
		getContentPane().add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[] { 0, 0 };
		gbl_panel_6.rowHeights = new int[] { 0, 0 };
		gbl_panel_6.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_6.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_6.setLayout(gbl_panel_6);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_6.add(scrollPane, gbc_scrollPane);

		jtGestion = new JTable();
		scrollPane.setViewportView(jtGestion);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 5;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 37, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 25, 0, 0, 240, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridwidth = 3;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0 };
		gbl_panel_2.rowHeights = new int[] { 0 };
		gbl_panel_2.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridheight = 7;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.gridx = 3;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 27, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		puesto = new JComboBox<>();
		GridBagConstraints gbc_puesto = new GridBagConstraints();
		gbc_puesto.gridwidth = 10;
		gbc_puesto.insets = new Insets(15, 0, 15, 15);
		gbc_puesto.fill = GridBagConstraints.HORIZONTAL;
		gbc_puesto.gridx = 3;
		gbc_puesto.gridy = 2;
		panel_3.add(puesto, gbc_puesto);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		GridBagConstraints gbc_lblFechaDeNacimiento = new GridBagConstraints();
		gbc_lblFechaDeNacimiento.anchor = GridBagConstraints.WEST;
		gbc_lblFechaDeNacimiento.gridwidth = 7;
		gbc_lblFechaDeNacimiento.insets = new Insets(0, 5, 5, 5);
		gbc_lblFechaDeNacimiento.gridx = 14;
		gbc_lblFechaDeNacimiento.gridy = 2;
		panel_3.add(lblFechaDeNacimiento, gbc_lblFechaDeNacimiento);

		JLabel lblNewLabel_5 = new JLabel("Puesto");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 2;
		panel_3.add(lblNewLabel_5, gbc_lblNewLabel_5);

		nacimiento = new JDateChooser();
		GridBagConstraints gbc_nacimiento = new GridBagConstraints();
		gbc_nacimiento.fill = GridBagConstraints.BOTH;
		gbc_nacimiento.gridwidth = 7;
		gbc_nacimiento.insets = new Insets(15, 5, 15, 5);
		gbc_nacimiento.gridx = 14;
		gbc_nacimiento.gridy = 3;
		panel_3.add(nacimiento, gbc_nacimiento);

		JLabel lblNewLabel_6 = new JLabel("Horas");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 4;
		panel_3.add(lblNewLabel_6, gbc_lblNewLabel_6);

		horas = new JTextField();
		GridBagConstraints gbc_horas = new GridBagConstraints();
		gbc_horas.gridwidth = 10;
		gbc_horas.insets = new Insets(15, 0, 15, 15);
		gbc_horas.fill = GridBagConstraints.HORIZONTAL;
		gbc_horas.gridx = 3;
		gbc_horas.gridy = 4;
		panel_3.add(horas, gbc_horas);
		horas.setColumns(10);

		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridheight = 9;
		gbc_panel_5.gridwidth = 9;
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.gridx = 15;
		gbc_panel_5.gridy = 5;
		panel_3.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 0 };
		gbl_panel_5.rowHeights = new int[] { 0 };
		gbl_panel_5.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { Double.MIN_VALUE };
		panel_5.setLayout(gbl_panel_5);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 6;
		panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);

		nombre = new JTextField();
		nombre.setColumns(10);
		GridBagConstraints gbc_nombre = new GridBagConstraints();
		gbc_nombre.fill = GridBagConstraints.BOTH;
		gbc_nombre.gridwidth = 10;
		gbc_nombre.insets = new Insets(15, 0, 15, 15);
		gbc_nombre.gridx = 3;
		gbc_nombre.gridy = 6;
		panel_3.add(nombre, gbc_nombre);
		nombre.setEnabled(false);

		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 8;
		panel_3.add(lblNewLabel_2, gbc_lblNewLabel_2);

		apellidos = new JTextField();
		apellidos.setColumns(10);
		GridBagConstraints gbc_apellidos = new GridBagConstraints();
		gbc_apellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_apellidos.gridwidth = 10;
		gbc_apellidos.insets = new Insets(15, 0, 15, 15);
		gbc_apellidos.gridx = 3;
		gbc_apellidos.gridy = 8;
		panel_3.add(apellidos, gbc_apellidos);
		apellidos.setEnabled(false);

		JLabel lblCorreo = new JLabel("Email");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.anchor = GridBagConstraints.WEST;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 1;
		gbc_lblCorreo.gridy = 10;
		panel_3.add(lblCorreo, gbc_lblCorreo);

		email = new JTextField();
		email.setColumns(10);
		GridBagConstraints gbc_email = new GridBagConstraints();
		gbc_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_email.gridwidth = 10;
		gbc_email.insets = new Insets(15, 0, 15, 15);
		gbc_email.gridx = 3;
		gbc_email.gridy = 10;
		panel_3.add(email, gbc_email);
		email.setEnabled(false);

		JLabel lblNewLabel_3 = new JLabel("Teléfono");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 12;
		panel_3.add(lblNewLabel_3, gbc_lblNewLabel_3);

		phone = new JTextField();
		phone.setColumns(10);
		GridBagConstraints gbc_phone = new GridBagConstraints();
		gbc_phone.fill = GridBagConstraints.HORIZONTAL;
		gbc_phone.gridwidth = 10;
		gbc_phone.insets = new Insets(15, 0, 15, 15);
		gbc_phone.gridx = 3;
		gbc_phone.gridy = 12;
		panel_3.add(phone, gbc_phone);
		phone.setEnabled(false);

		JLabel lblNewLabel_4 = new JLabel("Dirección");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 14;
		panel_3.add(lblNewLabel_4, gbc_lblNewLabel_4);

		address = new JTextField();
		address.setColumns(10);
		GridBagConstraints gbc_address = new GridBagConstraints();
		gbc_address.fill = GridBagConstraints.HORIZONTAL;
		gbc_address.gridwidth = 10;
		gbc_address.insets = new Insets(15, 0, 15, 15);
		gbc_address.gridx = 3;
		gbc_address.gridy = 14;
		panel_3.add(address, gbc_address);

		JButton btnNewButton_1 = new JButton("Aceptar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean fallos = false;

				String errores = "";
				String text = horas.getText();
				if (horas.isEnabled()) {
					try {
						int number = Integer.parseInt(text);
						if (number < 1 || number > 40) {
							fallos = true;
							errores += "Número de horas inválidas.";
						} else {
						}
					} catch (NumberFormatException e1) {
						fallos = true;
						errores += "Número de horas inválidas.";

					}
				}
				if (nombre.getText().isBlank()) {
					errores += "No has añadido el nombre.\n";
					fallos = true;
				}

				if (apellidos.getText().isBlank()) {
					errores += "No has añadido apellidos.\n";
					fallos = true;
				}

				String regexTelefono = "^(\\+?34)?[6789]\\d{8}$";
				if (!(phone.getText().matches(regexTelefono))) {
					errores += "Número de teléfono inválido.\n";
					fallos = true;
				}

				if (phone.getText().isBlank()) {
					errores += "No has añadido el nombre.\n";
					fallos = true;
				}

				if (address.getText().isBlank()) {
					errores += "No has añadido dirección.\n";
					fallos = true;
				}

				if (nacimiento.getDate() == null) {
					errores += "No has añadido fecha de nacimiento.\n";
					fallos = true;
				}

				if (fallos) {
					mostrarFallos(errores);
				} else {
					actualizarTrabajador();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 21;
		gbc_btnNewButton_1.gridy = 15;
		panel_3.add(btnNewButton_1, gbc_btnNewButton_1);

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 23;
		gbc_btnNewButton.gridy = 15;
		panel_3.add(btnNewButton, gbc_btnNewButton);

		btnImagen = new JButton("Seleccionar imagen");
		btnImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectImage();
			}
		});

		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.gridheight = 6;
		gbc_panel_7.insets = new Insets(0, 0, 0, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 1;
		panel.add(panel_7, gbc_panel_7);
		GridBagConstraints gbc_btnImagen = new GridBagConstraints();
		gbc_btnImagen.insets = new Insets(0, 0, 5, 5);
		gbc_btnImagen.gridx = 1;
		gbc_btnImagen.gridy = 1;
		panel.add(btnImagen, gbc_btnImagen);

		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridheight = 5;
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.gridx = 2;
		gbc_panel_4.gridy = 1;
		panel.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0 };
		gbl_panel_4.rowHeights = new int[] { 0 };
		gbl_panel_4.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 3;
		panel.add(panel_1, gbc_panel_1);

		lblImagen = new JLabel("");
		ImageIcon originalIcon = new ImageIcon(AltaTrabajador.class.getResource("/images/no_image.jpg"));
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		lblImagen.setIcon(scaledIcon);

		panel_1.add(lblImagen);

		JLabel lblNewLabel = new JLabel("Proyectos");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 4;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		proyectos = new JComboBox<ProjectWorker>();
		proyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarSeleccion();
			}

		});
		GridBagConstraints gbc_proyectos = new GridBagConstraints();
		gbc_proyectos.insets = new Insets(0, 0, 5, 5);
		gbc_proyectos.fill = GridBagConstraints.HORIZONTAL;
		gbc_proyectos.gridx = 1;
		gbc_proyectos.gridy = 5;
		panel.add(proyectos, gbc_proyectos);

		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.gridwidth = 2;
		gbc_panel_8.insets = new Insets(0, 0, 0, 5);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 1;
		gbc_panel_8.gridy = 6;
		panel.add(panel_8, gbc_panel_8);

		tModel = new DefaultTableModel();

		tModel = (DefaultTableModel) jtGestion.getModel();

		jtGestion.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Tel\u00E9fono", "Direcci\u00F3n" }) {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					boolean[] columnEditables = new boolean[] { false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});

		llenarTabla();

		jtGestion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = jtGestion.getSelectedRow();
				if (row != -1) {
					horas.setEnabled(false);
					proyectos.setEnabled(false);
					puesto.setEnabled(false);
					
					btnImagen.setEnabled(true);
					nombre.setEnabled(true);
					apellidos.setEnabled(true);
					email.setEnabled(true);
					phone.setEnabled(true);
					nacimiento.setEnabled(true);
					address.setEnabled(true);
					Worker w = (Worker) jtGestion.getValueAt(row, 0);

					int id = w.getId();
					cargarDatosCombo(id);

					if (modeloCombo.getSize() > 0) {

						proyectos.setEnabled(true);
						puesto.setEnabled(true);
						horas.setEnabled(true);

						proyectos.setSelectedIndex(1);
					}

					cargarDatos(w);
				}
			}

		});
		modeloCombo = new DefaultComboBoxModel<>();
		modeloPuesto = new DefaultComboBoxModel<>();
		modeloPuesto.addElement("Leader");
		modeloPuesto.addElement("Member");
		modeloPuesto.addElement("Collaborator");
		proyectos.setModel(modeloCombo);
		puesto.setModel(modeloPuesto);

		proyectos.setEnabled(false);
		puesto.setEnabled(false);
		btnImagen.setEnabled(false);
		nacimiento.setEnabled(false);
		address.setEnabled(false);
		horas.setEnabled(false);
		browser.enableHelpKey(this.nombre, "actuTrabajador", helpset);
		browser.enableHelpKey(this.horas, "actuTrabajador", helpset);
		browser.enableHelpKey(this.apellidos, "actuTrabajador", helpset);
		browser.enableHelpKey(this.email, "actuTrabajador", helpset);
		browser.enableHelpKey(this.phone, "actuTrabajador", helpset);
		browser.enableHelpKey(this.address, "actuTrabajador", helpset);
	}

	private DefaultComboBoxModel<ProjectWorker> modeloCombo;
	private DefaultComboBoxModel<String> modeloPuesto;

	private void cargarDatosCombo(int id) {

		modeloCombo = new DefaultComboBoxModel<ProjectWorker>();

		String consulta = "SELECT * FROM project_worker inner join Projects on Projects.ID = project_worker.Project_ID WHERE Worker_ID = ?";
		try (PreparedStatement pstmt = Conexion.getConexion().prepareStatement(consulta);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				modeloCombo.addElement(new ProjectWorker(rs.getInt("Worker_ID"), rs.getInt("Project_ID"),
						rs.getString("Name"), rs.getString("Role"), rs.getInt("Assigned_Hours_Per_Week")));
			}
			proyectos.setModel(modeloCombo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void cargarSeleccion() {

		if (proyectos.getSelectedIndex() != -1) {
			ProjectWorker pw = (ProjectWorker) proyectos.getSelectedItem();
			puesto.setSelectedItem(pw.getRole());
			horas.setText(pw.getWeeklyAssignedHours() + "");
		}

	}

	private void mostrarFallos(String cadena) {
		JOptionPane.showMessageDialog(this, cadena);
	}

	private JDateChooser nacimiento;

	private void cargarDatos(Worker w) {
		String consulta = "SELECT * FROM Workers WHERE id = ?";
		try (PreparedStatement pstmt = Conexion.getConexion().prepareStatement(consulta);) {

			pstmt.setInt(1, w.getId());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {

				w = new Worker();

				w.setId(rs.getInt("ID"));
				w.setImagePath(rs.getString("Image_Path"));
				w.setName(rs.getString("First_Name"));
				w.setLastname(rs.getString("Last_Name"));
				w.setEmail(rs.getString("Email"));
				w.setDateOfBirth(rs.getDate("Date_of_Birth"));
				w.setPhone(Long.parseLong(rs.getString("Phone")));
				w.setAddress(rs.getString("Address"));
				workerUpdate = w;

				ImageIcon originalIcon = new ImageIcon(ImageUploader.downloadImage(Conexion.getIp(), w.getImagePath()));
				Image originalImage = originalIcon.getImage();
				Image scaledImage = originalImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
				ImageIcon scaledIcon = new ImageIcon(scaledImage);
				lblImagen.setIcon(scaledIcon);
				nombre.setText(w.getName());
				apellidos.setText(w.getLastname());
				email.setText(w.getEmail());
				phone.setText(String.valueOf(w.getPhone()));
				address.setText(w.getAddress());
				nacimiento.setDate(w.getDateOfBirth());

			}
		} catch (SQLException ex) {
			Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private File selectedFile;
	private JLabel lblImagen;

	private void selectImage() {
		JFileChooser fileChooser = new JFileChooser();

		fileChooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "Archivos de imagen (*.jpg, *.jpeg, *.png, *.gif)";
			}

			@Override
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				} else {
					String filename = f.getName().toLowerCase();
					return filename.endsWith(".jpg") || filename.endsWith(".jpeg") || filename.endsWith(".png")
							|| filename.endsWith(".gif");
				}
			}
		});

		fileChooser.setDialogTitle("Seleccionar imagen");
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {

			selectedFile = fileChooser.getSelectedFile();
			ImageIcon originalIcon = new ImageIcon(selectedFile.getAbsolutePath());
			Image originalImage = originalIcon.getImage();
			Image scaledImage = originalImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			ImageIcon scaledIcon = new ImageIcon(scaledImage);
			lblImagen.setIcon(scaledIcon);
		} else {

			ImageIcon originalIcon = new ImageIcon(AltaTrabajador.class.getResource("/images/no_image.jpg"));
			Image originalImage = originalIcon.getImage();
			Image scaledImage = originalImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			ImageIcon scaledIcon = new ImageIcon(scaledImage);
			lblImagen.setIcon(scaledIcon);
		}
	}

	private DefaultTableModel tModel;
	Worker workerUpdate;
	private JTextField horas;

	private void llenarTabla() {
		try {
			tModel.setRowCount(0);
			tModel = (DefaultTableModel) jtGestion.getModel();

			Statement stmt = Conexion.getConexion().createStatement();
			String consulta = "select * from Workers order by Last_Name, First_Name desc";
			ResultSet rs = stmt.executeQuery(consulta);

			while (rs.next()) {
				Worker w = new Worker();
				w.setId(rs.getInt("ID"));
				w.setImagePath(rs.getString("Image_Path"));
				w.setName(rs.getString("First_Name"));
				w.setLastname(rs.getString("Last_Name"));
				w.setEmail(rs.getString("Email"));
				w.setDateOfBirth(rs.getDate("Date_of_Birth"));
				w.setPhone(Long.parseLong(rs.getString("Phone")));
				w.setAddress(rs.getString("Address"));

				int rows = tModel.getRowCount();
				tModel.setRowCount(rows + 1);

				tModel.setValueAt(w, rows, 0);
				tModel.setValueAt(rs.getString("Phone"), rows, 1);
				tModel.setValueAt(rs.getString("Address"), rows, 2);

			}
		} catch (SQLException ex) {
			Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void actualizarTrabajador() {

		if (selectedFile == null) {
			java.util.Date date = nacimiento.getDate();
			long d = date.getTime();
			Date fecha = new java.sql.Date(d);
			workerUpdate.setName(nombre.getText().toString());
			workerUpdate.setLastname(apellidos.getText().toString());
			workerUpdate.setEmail(email.getText().toString());
			workerUpdate.setDateOfBirth(fecha);
			workerUpdate.setPhone(Long.parseLong(phone.getText().toString()));
			workerUpdate.setAddress(address.getText().toString());
			update();
		} else {

			String fileName = selectedFile.getName();
			String directoryPath = selectedFile.getParent();

			int i = fileName.lastIndexOf('.');
			String fileExtension = "";
			if (i > 0) {
				fileExtension = fileName.substring(i);
			}

			int j = workerUpdate.getImagePath().lastIndexOf('.');
			String nombreArchivo = "";
			if (j > 0) {
				nombreArchivo = workerUpdate.getImagePath().substring(0, j);
			}

			String nombreCompleto = nombreArchivo + fileExtension;

			File newFile = new File(directoryPath, nombreCompleto);
			try {
				Files.copy(selectedFile.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}

			try {

				ImageUploader.uploadImage(newFile, Conexion.getIp());
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}

			java.util.Date date = nacimiento.getDate();
			long d = date.getTime();
			Date fecha = new java.sql.Date(d);
			workerUpdate.setImagePath(nombreCompleto);
			workerUpdate.setName(nombre.getText().toString());
			workerUpdate.setLastname(apellidos.getText().toString());
			workerUpdate.setEmail(email.getText().toString());
			workerUpdate.setDateOfBirth(fecha);
			workerUpdate.setPhone(Long.parseLong(phone.getText().toString()));
			workerUpdate.setAddress(address.getText().toString());
			update();
		}
		((Consola) this.getParent()).actualizar();
	}

	private void update() {

		try {
			String consulta = "UPDATE Workers "
					+ "SET Image_Path = ?, First_Name = ?, Last_Name = ?, Email = ?, Date_of_Birth = ?, Phone = ?, Address = ? "
					+ "WHERE ID = ?";
			PreparedStatement pstmt = Conexion.getConexion().prepareStatement(consulta);
			pstmt.setString(1, workerUpdate.getImagePath());
			pstmt.setString(2, workerUpdate.getName());
			pstmt.setString(3, workerUpdate.getLastname());
			pstmt.setString(4, workerUpdate.getEmail());
			pstmt.setDate(5, workerUpdate.getDateOfBirth());
			pstmt.setString(6, String.valueOf(workerUpdate.getPhone()));
			pstmt.setString(7, workerUpdate.getAddress());
			pstmt.setInt(8, workerUpdate.getId());

			pstmt.executeUpdate();

			if (horas.isEnabled()) {
				consulta = "UPDATE project_worker " + "SET Role = ?, Assigned_Hours_Per_Week = ? "
						+ "where Worker_ID = ? and Project_ID = ?";
				ProjectWorker pw = (ProjectWorker) proyectos.getSelectedItem();
				pstmt = Conexion.getConexion().prepareStatement(consulta);

				if (modeloPuesto.getSize() > 0) {
					String puestoSeleccionado = puesto.getSelectedItem().toString();
					int horasSemanales = Integer.parseInt(horas.getText().toString());
					pstmt.setString(1, puestoSeleccionado);
					pstmt.setInt(2, horasSemanales);
					pstmt.setInt(3, pw.getIdWorker());
					pstmt.setInt(4, pw.getIdProject());

					pstmt.executeUpdate();
				}
			}
			JOptionPane.showMessageDialog(this, "Trabajador actualizado correctamente.");
			llenarTabla();
		} catch (SQLException ex) {
			Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
		}
		this.dispose();
	}
}
