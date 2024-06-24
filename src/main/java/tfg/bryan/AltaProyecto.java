package tfg.bryan;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class AltaProyecto extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nombre;
	private JTextField description;
	private JDateChooser inicio;
	private JDateChooser fin;
	private JFormattedTextField presupuesto;
	private static HelpBroker browser;
	private static HelpSet helpset;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AltaProyecto dialog = new AltaProyecto(new JFrame(), true, browser, helpset);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaProyecto(JFrame parent, boolean modal, HelpBroker browser, HelpSet helpset) {

		super(parent, modal);
		setTitle("Añadir proyecto");

		setBounds(100, 100, 820, 440);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		contentPanel.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0,
				0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridheight = 3;
		gbc_panel_3.gridwidth = 4;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);

		JLabel lblNewLabel = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(5, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		nombre = new JTextField();
		GridBagConstraints gbc_nombre = new GridBagConstraints();
		gbc_nombre.gridwidth = 16;
		gbc_nombre.insets = new Insets(5, 15, 5, 5);
		gbc_nombre.fill = GridBagConstraints.BOTH;
		gbc_nombre.gridx = 6;
		gbc_nombre.gridy = 0;
		panel.add(nombre, gbc_nombre);
		nombre.setColumns(10);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 3;
		gbc_panel_2.gridwidth = 3;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 22;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0 };
		gbl_panel_2.rowHeights = new int[] { 0 };
		gbl_panel_2.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblNewLabel_1 = new JLabel("Descripción");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(5, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		description = new JTextField();
		GridBagConstraints gbc_description = new GridBagConstraints();
		gbc_description.fill = GridBagConstraints.BOTH;
		gbc_description.gridwidth = 16;
		gbc_description.insets = new Insets(5, 15, 5, 5);
		gbc_description.gridx = 6;
		gbc_description.gridy = 1;
		panel.add(description, gbc_description);
		description.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Presupuesto");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(5, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		presupuesto = new JFormattedTextField();

		GridBagConstraints gbc_presupuesto = new GridBagConstraints();
		gbc_presupuesto.gridwidth = 16;
		gbc_presupuesto.insets = new Insets(5, 15, 5, 5);
		gbc_presupuesto.fill = GridBagConstraints.HORIZONTAL;
		gbc_presupuesto.gridx = 6;
		gbc_presupuesto.gridy = 2;
		panel.add(presupuesto, gbc_presupuesto);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 11;
		gbc_panel_1.gridwidth = 23;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 3;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.gridwidth = 20;
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 0;
		panel_1.add(panel_6, gbc_panel_6);

		JLabel lblNewLabel_3 = new JLabel("Fecha de inicio");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 1;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.gridwidth = 11;
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 3;
		gbc_panel_8.gridy = 1;
		panel_1.add(panel_8, gbc_panel_8);

		JLabel lblNewLabel_4 = new JLabel("Fecha de finalización");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 14;
		gbc_lblNewLabel_4.gridy = 1;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);

		JPanel panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.gridwidth = 5;
		gbc_panel_9.insets = new Insets(0, 0, 5, 0);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 15;
		gbc_panel_9.gridy = 1;
		panel_1.add(panel_9, gbc_panel_9);

		inicio = new JDateChooser();
		GridBagConstraints gbc_inicio = new GridBagConstraints();
		gbc_inicio.gridwidth = 5;
		gbc_inicio.insets = new Insets(0, 0, 5, 5);
		gbc_inicio.fill = GridBagConstraints.BOTH;
		gbc_inicio.gridx = 2;
		gbc_inicio.gridy = 2;
		panel_1.add(inicio, gbc_inicio);

		fin = new JDateChooser();
		GridBagConstraints gbc_fin = new GridBagConstraints();
		gbc_fin.insets = new Insets(0, 0, 5, 5);
		gbc_fin.gridwidth = 5;
		gbc_fin.fill = GridBagConstraints.BOTH;
		gbc_fin.gridx = 14;
		gbc_fin.gridy = 2;
		panel_1.add(fin, gbc_fin);

		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 7;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 7;
		gbc_panel_4.gridy = 2;
		panel_1.add(panel_4, gbc_panel_4);

		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.gridheight = 4;
		gbc_panel_7.gridwidth = 20;
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 3;
		panel_1.add(panel_7, gbc_panel_7);

		JButton alta = new JButton("Aceptar");
		alta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaProyecto();
			}
		});
		GridBagConstraints gbc_alta = new GridBagConstraints();
		gbc_alta.fill = GridBagConstraints.HORIZONTAL;
		gbc_alta.gridwidth = 3;
		gbc_alta.insets = new Insets(0, 0, 0, 5);
		gbc_alta.gridx = 19;
		gbc_alta.gridy = 14;
		panel.add(alta, gbc_alta);

		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_cancelar = new GridBagConstraints();
		gbc_cancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_cancelar.gridwidth = 3;
		gbc_cancelar.gridx = 22;
		gbc_cancelar.gridy = 14;
		panel.add(cancelar, gbc_cancelar);
		
		browser.enableHelpKey(this.nombre, "altaProyecto", helpset);
		browser.enableHelpKey(this.description, "altaProyecto", helpset);
		browser.enableHelpKey(this.presupuesto, "altaProyecto", helpset);

	}

	private void altaProyecto() {

		boolean fallos = false;
		String errores = "";

		BigDecimal presupuestoProyecto = null;

		if (nombre.getText().isEmpty()) {
			fallos = true;
			errores += "Nombre inválido.\n";
		}

		if (description.getText().isBlank()) {
			fallos = true;
			errores += "Descripción inválida.\n";
		}

		if (presupuesto.getText().isBlank()) {
			fallos = true;
			errores += "Presupuesto inválido.\n";
		} else {

			try {
				presupuestoProyecto = new BigDecimal(presupuesto.getText());

				if (presupuestoProyecto.compareTo(BigDecimal.ZERO) <= 0) {
					fallos = true;
					errores += "Presupuesto inválido.\n";
				}
			} catch (NumberFormatException e) {
				fallos = true;
				errores += "Presupuesto inválido.\n";
			}
		}

		if (inicio.getDate() == null || fin.getDate() == null) {
			fallos = true;
			if (inicio == null && fin == null) {
				errores += "Fechas de inicio y fin inválidas.\n";
			} else if (inicio == null) {
				errores += "Fecha de inicio inválida.\n";
			} else {
				errores += "Fecha de fin inválida.\n";
			}
		}

		if (fallos == false) {
			Date dateInicio = inicio.getDate();
			long inicioMillis = dateInicio.getTime();
			java.sql.Date fechaInicio = new java.sql.Date(inicioMillis);
			Date dateFin = fin.getDate();
			long finMillis = dateFin.getTime();
			java.sql.Date fechaFin = new java.sql.Date(finMillis);
			if (fechaFin.before(fechaInicio) || fechaFin.equals(fechaInicio)) {
				fallos = true;
				errores += "Fecha de fin inválida.\n";
			}

			if (fallos == true) {
				JOptionPane.showMessageDialog(this, errores);
			} else {
				presupuestoProyecto = presupuestoProyecto.setScale(2, RoundingMode.DOWN);

				String query = "INSERT INTO Projects(Name, Description, Budget, Start_Date, End_Date) "
						+ "VALUES (?, ?, ?, ?, ?)";

				try (PreparedStatement ps = Conexion.getConexion().prepareStatement(query)) {

					ps.setString(1, nombre.getText().toString());
					ps.setString(2, description.getText().toString());
					ps.setBigDecimal(3, presupuestoProyecto);
					ps.setDate(4, fechaInicio);
					ps.setDate(5, fechaFin);

					ps.executeUpdate();

					JOptionPane.showMessageDialog(this, "Proyecto dado de alta correctamente.");
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, errores);
		}
	}

}
