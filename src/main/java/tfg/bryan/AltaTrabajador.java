package tfg.bryan;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;

import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaTrabajador extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nombre;
	private JTextField apellidos;
	private JTextField email;
	private JTextField phone;
	private JTextField direction;
	private JDateChooser nacimiento;
	private static HelpBroker browser;
	private static HelpSet helpset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AltaTrabajador dialog = new AltaTrabajador(new JFrame(), true, browser, helpset);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */

	public AltaTrabajador(JFrame parent, boolean modal, HelpBroker browser, HelpSet helpset) {

		super(parent, modal);
		setTitle("Añadir trabajador");

		setBounds(100, 100, 1077, 453);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPanel.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 37, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 25, 0, 0, 240, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel panel_2 = new JPanel();

		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 3;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);

		JButton btnImagen = new JButton("Seleccionar imagen");
		btnImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectImage();
			}
		});
		GridBagConstraints gbc_btnImagen = new GridBagConstraints();
		gbc_btnImagen.insets = new Insets(0, 0, 5, 5);
		gbc_btnImagen.gridx = 1;
		gbc_btnImagen.gridy = 1;
		panel.add(btnImagen, gbc_btnImagen);

		JPanel panel_1 = new JPanel();
		panel_1.setSize(200, 200);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 3;
		panel.add(panel_1, gbc_panel_1);

		lblImagen = new JLabel("");
		panel_1.add(lblImagen);

		ImageIcon originalIcon = new ImageIcon(AltaTrabajador.class.getResource("/images/no_image.jpg"));
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		lblImagen.setIcon(scaledIcon);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridheight = 7;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 3;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 27, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		GridBagConstraints gbc_lblFechaDeNacimiento = new GridBagConstraints();
		gbc_lblFechaDeNacimiento.anchor = GridBagConstraints.WEST;
		gbc_lblFechaDeNacimiento.gridwidth = 7;
		gbc_lblFechaDeNacimiento.insets = new Insets(0, 5, 5, 5);
		gbc_lblFechaDeNacimiento.gridx = 14;
		gbc_lblFechaDeNacimiento.gridy = 1;
		panel_3.add(lblFechaDeNacimiento, gbc_lblFechaDeNacimiento);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);

		nombre = new JTextField();
		GridBagConstraints gbc_nombre = new GridBagConstraints();
		gbc_nombre.fill = GridBagConstraints.BOTH;
		gbc_nombre.gridwidth = 10;
		gbc_nombre.insets = new Insets(15, 0, 15, 15);
		gbc_nombre.gridx = 3;
		gbc_nombre.gridy = 3;
		panel_3.add(nombre, gbc_nombre);
		nombre.setColumns(10);

		nacimiento = new JDateChooser();
		GridBagConstraints gbc_nacimiento = new GridBagConstraints();
		gbc_nacimiento.gridwidth = 7;
		gbc_nacimiento.insets = new Insets(15, 5, 15, 5);
		gbc_nacimiento.fill = GridBagConstraints.BOTH;
		gbc_nacimiento.gridx = 14;
		gbc_nacimiento.gridy = 3;
		panel_3.add(nacimiento, gbc_nacimiento);

		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 5;
		panel_3.add(lblNewLabel_2, gbc_lblNewLabel_2);

		apellidos = new JTextField();
		GridBagConstraints gbc_apellidos = new GridBagConstraints();
		gbc_apellidos.gridwidth = 10;
		gbc_apellidos.insets = new Insets(15, 0, 15, 15);
		gbc_apellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_apellidos.gridx = 3;
		gbc_apellidos.gridy = 5;
		panel_3.add(apellidos, gbc_apellidos);
		apellidos.setColumns(10);

		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridheight = 7;
		gbc_panel_5.gridwidth = 9;
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 15;
		gbc_panel_5.gridy = 4;
		panel_3.add(panel_5, gbc_panel_5);

		JLabel lblCorreo = new JLabel("Email");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.anchor = GridBagConstraints.WEST;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 1;
		gbc_lblCorreo.gridy = 7;
		panel_3.add(lblCorreo, gbc_lblCorreo);

		email = new JTextField();
		GridBagConstraints gbc_email = new GridBagConstraints();
		gbc_email.gridwidth = 10;
		gbc_email.insets = new Insets(15, 0, 15, 15);
		gbc_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_email.gridx = 3;
		gbc_email.gridy = 7;
		panel_3.add(email, gbc_email);
		email.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Teléfono");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 9;
		panel_3.add(lblNewLabel_3, gbc_lblNewLabel_3);

		phone = new JTextField();
		GridBagConstraints gbc_phone = new GridBagConstraints();
		gbc_phone.gridwidth = 10;
		gbc_phone.fill = GridBagConstraints.HORIZONTAL;
		gbc_phone.insets = new Insets(15, 0, 15, 15);
		gbc_phone.gridx = 3;
		gbc_phone.gridy = 9;
		panel_3.add(phone, gbc_phone);
		phone.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Dirección");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 11;
		panel_3.add(lblNewLabel_4, gbc_lblNewLabel_4);

		direction = new JTextField();
		GridBagConstraints gbc_direction = new GridBagConstraints();
		gbc_direction.gridwidth = 10;
		gbc_direction.insets = new Insets(15, 0, 15, 15);
		gbc_direction.fill = GridBagConstraints.HORIZONTAL;
		gbc_direction.gridx = 3;
		gbc_direction.gridy = 11;
		panel_3.add(direction, gbc_direction);
		direction.setColumns(10);

		JButton btnNewButton_1 = new JButton("Aceptar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaCliente();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 21;
		gbc_btnNewButton_1.gridy = 12;
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
		gbc_btnNewButton.gridy = 12;
		panel_3.add(btnNewButton, gbc_btnNewButton);

		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridheight = 6;
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 2;
		gbc_panel_4.gridy = 1;
		panel.add(panel_4, gbc_panel_4);
		browser.enableHelpKey(this.nombre, "altaTrabajador", helpset);
		browser.enableHelpKey(this.apellidos, "altaTrabajador", helpset);
		browser.enableHelpKey(this.email, "altaTrabajador", helpset);
		browser.enableHelpKey(this.phone, "altaTrabajador", helpset);
		browser.enableHelpKey(this.direction, "altaTrabajador", helpset);

		Calendar hoy = Calendar.getInstance();
		hoy.add(Calendar.YEAR, -18);

		  Date fechaMin = hoy.getTime();
		
		nacimiento.setMaxSelectableDate(fechaMin);

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

	private void altaCliente() {

		boolean fallos = false;

		String errores = "";

		if (selectedFile == null) {
			errores += "No has añadido una imagen.\n";
			fallos = true;
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

		if (direction.getText().isBlank()) {
			errores += "No has añadido dirección.\n";
			fallos = true;
		}

		if (nacimiento.getDate() == null) {
			errores += "No has añadido fecha de nacimiento.\n";
			fallos = true;
		}

		if (fallos) {
			JOptionPane.showMessageDialog(this, errores);
		} else {

			Date date = nacimiento.getDate();
			long d = date.getTime();
			java.sql.Date fecha = new java.sql.Date(d);

			String fileName = selectedFile.getName();
			String directoryPath = selectedFile.getParent();
			int i = fileName.lastIndexOf('.');
			String fileExtension = "";
			if (i > 0) {
				fileExtension = fileName.substring(i);
			}

			insertarCliente(fileExtension, directoryPath, fecha);
			((Consola) this.getParent()).actualizar();
			this.dispose();

		}

	}

	private void insertarCliente(String fileExtension, String directoryPath, java.sql.Date fecha) {
		try {
			String consulta = "insert into Workers(Image_Path, First_Name, Last_Name, Email, Date_of_Birth, Phone, Address)"
					+ " values(? ,? ,? ,?, ?, ?, ?)";
			try (PreparedStatement ps = Conexion.getConexion().prepareStatement(consulta,
					PreparedStatement.RETURN_GENERATED_KEYS)) {
				String file = "cargando.png";

				ps.setString(1, file);
				ps.setString(2, nombre.getText().toString());
				ps.setString(3, apellidos.getText().toString());
				ps.setString(4, email.getText().toString());
				ps.setDate(5, fecha);
				ps.setString(6, phone.getText().toString());
				ps.setString(7, direction.getText().toString());

				int affectedRows = ps.executeUpdate();

				if (affectedRows > 0) {
					try (ResultSet rs = ps.getGeneratedKeys()) {
						if (rs.next()) {
							int clienteID = rs.getInt(1);

							String fileChanged = "/" + clienteID + fileExtension;
							File newFile = new File(directoryPath, fileChanged);
							selectedFile.renameTo(newFile);

							String updateQuery = "UPDATE Workers SET Image_Path = ? WHERE ID = ?";
							try (PreparedStatement updateStatement = Conexion.getConexion()
									.prepareStatement(updateQuery)) {
								updateStatement.setString(1, fileChanged);
								updateStatement.setInt(2, clienteID);
								updateStatement.executeUpdate();
							}

							ImageUploader.uploadImage(newFile, Conexion.getIp());
							JOptionPane.showMessageDialog(this, "Trabajador dado de alta correctamente.");
							newFile.delete();
						}
					}
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
