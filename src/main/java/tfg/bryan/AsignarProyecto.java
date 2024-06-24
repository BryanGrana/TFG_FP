package tfg.bryan;

import java.awt.BorderLayout;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatter;

import models.Project;
import models.Worker;

import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AsignarProyecto extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private static HelpBroker browser;
	private static HelpSet helpset;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AsignarProyecto dialog = new AsignarProyecto(new JFrame(), true, browser, helpset);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AsignarProyecto(JFrame parent, boolean modal, HelpBroker browser, HelpSet helpset) {

		super(parent, modal);
		setTitle("Asignar proyecto");
		setBounds(100, 100, 498, 337);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0,
				1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 14;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		contentPanel.add(panel_2, gbc_panel_2);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 8;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPanel.add(panel, gbc_panel);

		JLabel lblNewLabel_1 = new JLabel("Trabajadores");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridwidth = 4;
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 3;
		gbc_panel_5.gridy = 1;
		contentPanel.add(panel_5, gbc_panel_5);

		JLabel lblNewLabel_2 = new JLabel("Proyectos");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 8;
		gbc_lblNewLabel_2.gridy = 1;
		contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.gridwidth = 3;
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 10;
		gbc_panel_6.gridy = 1;
		contentPanel.add(panel_6, gbc_panel_6);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridheight = 8;
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 13;
		gbc_panel_3.gridy = 1;
		contentPanel.add(panel_3, gbc_panel_3);

		workers = new JComboBox<Worker>();
		GridBagConstraints gbc_workers = new GridBagConstraints();
		gbc_workers.gridwidth = 6;
		gbc_workers.insets = new Insets(0, 0, 5, 5);
		gbc_workers.fill = GridBagConstraints.HORIZONTAL;
		gbc_workers.gridx = 1;
		gbc_workers.gridy = 2;
		contentPanel.add(workers, gbc_workers);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 7;
		gbc_panel_1.gridy = 1;
		contentPanel.add(panel_1, gbc_panel_1);

		projects = new JComboBox<>();
		GridBagConstraints gbc_projects = new GridBagConstraints();
		gbc_projects.gridwidth = 5;
		gbc_projects.insets = new Insets(0, 0, 5, 5);
		gbc_projects.fill = GridBagConstraints.HORIZONTAL;
		gbc_projects.gridx = 8;
		gbc_projects.gridy = 2;
		contentPanel.add(projects, gbc_projects);

		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.gridwidth = 3;
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 1;
		gbc_panel_8.gridy = 3;
		contentPanel.add(panel_8, gbc_panel_8);

		JLabel lblNewLabel_3 = new JLabel("Puesto");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 3;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 3;
		contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.gridwidth = 6;
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 7;
		gbc_panel_7.gridy = 3;
		contentPanel.add(panel_7, gbc_panel_7);

		JPanel panel_10 = new JPanel();
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.gridwidth = 3;
		gbc_panel_10.insets = new Insets(0, 0, 5, 5);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 1;
		gbc_panel_10.gridy = 4;
		contentPanel.add(panel_10, gbc_panel_10);

		puesto = new JComboBox<>();
		GridBagConstraints gbc_puesto = new GridBagConstraints();
		gbc_puesto.gridwidth = 6;
		gbc_puesto.insets = new Insets(0, 0, 5, 5);
		gbc_puesto.fill = GridBagConstraints.HORIZONTAL;
		gbc_puesto.gridx = 4;
		gbc_puesto.gridy = 4;
		contentPanel.add(puesto, gbc_puesto);

		JPanel panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.gridwidth = 3;
		gbc_panel_9.insets = new Insets(0, 0, 5, 5);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 10;
		gbc_panel_9.gridy = 4;
		contentPanel.add(panel_9, gbc_panel_9);

		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 12;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 5;
		contentPanel.add(panel_4, gbc_panel_4);

		JLabel lblNewLabel = new JLabel("Horas asignadas");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 6;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);

		horas = new JSpinner();
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, 40, 1);
		horas.setModel(spinnerModel);
		JFormattedTextField textField = ((JSpinner.NumberEditor) horas.getEditor()).getTextField();
		DefaultFormatter formatter = (DefaultFormatter) textField.getFormatter();
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(true);
		GridBagConstraints gbc_horas = new GridBagConstraints();
		gbc_horas.gridwidth = 3;
		gbc_horas.fill = GridBagConstraints.HORIZONTAL;
		gbc_horas.insets = new Insets(0, 0, 5, 5);
		gbc_horas.gridx = 5;
		gbc_horas.gridy = 6;
		contentPanel.add(horas, gbc_horas);

		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.gridwidth = 12;
		gbc_panel_11.insets = new Insets(0, 0, 5, 5);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 1;
		gbc_panel_11.gridy = 7;
		contentPanel.add(panel_11, gbc_panel_11);

		JButton aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				altaWorkProject();

			}
		});
		GridBagConstraints gbc_aceptar = new GridBagConstraints();
		gbc_aceptar.gridwidth = 2;
		gbc_aceptar.insets = new Insets(0, 0, 0, 5);
		gbc_aceptar.gridx = 8;
		gbc_aceptar.gridy = 8;
		contentPanel.add(aceptar, gbc_aceptar);

		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_cancelar = new GridBagConstraints();
		gbc_cancelar.gridwidth = 2;
		gbc_cancelar.insets = new Insets(0, 0, 0, 5);
		gbc_cancelar.gridx = 11;
		gbc_cancelar.gridy = 8;
		contentPanel.add(cancelar, gbc_cancelar);

		workers.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					cargarDatosProject();
				}

			}
		});

		modeloWorker = new DefaultComboBoxModel<>();
		workers.setModel(modeloWorker);

		modeloProject = new DefaultComboBoxModel<>();
		projects.setModel(modeloProject);

		modeloPuesto = new DefaultComboBoxModel<>();
		modeloPuesto.addElement("Leader");
		modeloPuesto.addElement("Member");
		modeloPuesto.addElement("Collaborator");
		puesto.setModel(modeloPuesto);

		cargarDatosWorker();
		cargarDatosProject();
		browser.enableHelpKey(this.horas, "altaTrabajador", helpset);
	}

	private JSpinner horas;
	private JComboBox<Worker> workers;
	private JComboBox<Project> projects;
	private JComboBox<String> puesto;
	private DefaultComboBoxModel<Worker> modeloWorker;
	private DefaultComboBoxModel<String> modeloPuesto;
	private DefaultComboBoxModel<Project> modeloProject;

	private void altaWorkProject() {
		Worker w = (Worker) workers.getSelectedItem();
		int idW = w.getId();
		Project p = (Project) projects.getSelectedItem();
		int idP = p.getId();

		String rol = (String) puesto.getSelectedItem();

		int horasAsignadas = (int) horas.getValue();

		String insert = "INSERT INTO project_worker (Worker_ID, Project_ID, Role, Assigned_Hours_Per_Week) "
				+ "VALUES (?, ?, ?, ?)";
		try {
			Connection connection = Conexion.getConexion();
			PreparedStatement pstmt = connection.prepareStatement(insert);
			pstmt.setInt(1, idW);
			pstmt.setInt(2, idP);
			pstmt.setString(3, rol);
			pstmt.setInt(4, horasAsignadas);

			int rowsInserted = pstmt.executeUpdate();

			if (rowsInserted > 0) {
				JOptionPane.showMessageDialog(this, "Proyecto asignado correctamente.");
				this.dispose();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void cargarDatosWorker() {

		modeloWorker = new DefaultComboBoxModel<Worker>();

		String consulta = "SELECT * FROM Workers";
		try (PreparedStatement pstmt = Conexion.getConexion().prepareStatement(consulta);) {

			ResultSet rs = pstmt.executeQuery();
			Worker w;
			while (rs.next()) {
				w = new Worker();

				w.setId(rs.getInt("ID"));
				w.setImagePath(rs.getString("Image_Path"));
				w.setName(rs.getString("First_Name"));
				w.setLastname(rs.getString("Last_Name"));
				w.setEmail(rs.getString("Email"));
				w.setDateOfBirth(rs.getDate("Date_of_Birth"));
				w.setPhone(Long.parseLong(rs.getString("Phone")));
				w.setAddress(rs.getString("Address"));
				modeloWorker.addElement(w);
			}
			workers.setModel(modeloWorker);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void cargarDatosProject() {
		modeloProject = new DefaultComboBoxModel<Project>();
		Worker w = (Worker) workers.getSelectedItem();
		int id = w.getId();

		String consulta = "SELECT * FROM Projects "
				+ "WHERE ID NOT IN (SELECT Project_ID FROM project_worker WHERE Worker_ID = ?)";
		try (PreparedStatement pstmt = Conexion.getConexion().prepareStatement(consulta);) {

			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			Project p;
			while (rs.next()) {
				p = new Project();
				p.setId(rs.getInt("ID"));
				p.setName(rs.getString("Name"));
				p.setDescription(rs.getString("Description"));
				p.setBudget(rs.getDouble("Budget"));
				p.setStartDate(rs.getDate("Start_Date"));
				p.setEndDate(rs.getDate("End_Date"));
				modeloProject.addElement(p);
			}

			projects.setModel(modeloProject);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
