package tfg.bryan;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import models.Worker;

public class BajaTrabajador extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable jtGestion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BajaTrabajador dialog = new BajaTrabajador(new JFrame(), true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BajaTrabajador(JFrame parent, boolean modal) {
		super(parent, modal);

		setTitle("Eliminar trabajador");
		setBounds(100, 100, 587, 362);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 0;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				jtGestion = new JTable();
				jtGestion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				jtGestion.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "Nombre", "Fecha de nacimiento", "Tel\u00E9fono", "Direcci\u00F3n" }) {
					private static final long serialVersionUID = 1L;
					boolean[] columnEditables = new boolean[] { false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				scrollPane.setViewportView(jtGestion);
			}
		}
		tModel = new DefaultTableModel();

		tModel = (DefaultTableModel) jtGestion.getModel();

		jtGestion.setModel(tModel);
		cargarTrabajadores();

		popupMenu = new JPopupMenu();
		JMenuItem deleteItem = new JMenuItem("Eliminar");
		popupMenu.add(deleteItem);

		jtGestion.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showPopup(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showPopup(e);
				}
			}

			private void showPopup(MouseEvent e) {
				menuPopUpTable(e);
			}
		});

		deleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jtGestion.getSelectedRow();
				if (selectedRow != -1) {
					int opcion = opcionEliminar();
					if (opcion == JOptionPane.YES_OPTION) {
						Worker worker = (Worker) tModel.getValueAt(selectedRow, 0);
						eliminarTrabajador(worker.getId());
						tModel.removeRow(selectedRow);
					}
				}
			}
		});
	}

	private int opcionEliminar() {
		Object[] options = { "Sí", "No", "Cancelar" };
		return JOptionPane.showOptionDialog(this, "¿Estás seguro de que deseas eliminar al trabajador?",
				"Confirmación de eliminación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				options, options[0]);
	}

	JPopupMenu popupMenu;

	private void menuPopUpTable(MouseEvent e) {
		int row = jtGestion.rowAtPoint(e.getPoint());
		jtGestion.setRowSelectionInterval(row, row);
		popupMenu.show(e.getComponent(), e.getX(), e.getY());
	}

	private DefaultTableModel tModel;

	private void cargarTrabajadores() {
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

				Date dateOfBirth = w.getDateOfBirth();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				String formattedDate = formatter.format(dateOfBirth);
				int rows = tModel.getRowCount();
				tModel.setRowCount(rows + 1);

				tModel.setValueAt(w, rows, 0);
				tModel.setValueAt(formattedDate, rows, 1);
				tModel.setValueAt(w.getPhone(), rows, 2);
				tModel.setValueAt(w.getAddress(), rows, 3);
			}
		} catch (SQLException ex) {
			Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void eliminarTrabajador(int id) {
		try {
			Connection conexion = Conexion.getConexion();

			// Empieza la transacción.
			conexion.setAutoCommit(false);

			Statement stmt = conexion.createStatement();

			String consultaProjectWorker = "DELETE FROM project_worker WHERE Worker_ID = " + id;
			stmt.executeUpdate(consultaProjectWorker);

			String consultaWorkers = "DELETE FROM Workers WHERE ID = " + id;
			stmt.executeUpdate(consultaWorkers);

			conexion.commit();
			((Consola) this.getParent()).actualizar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			try {
				// Hace rollback la transacción en caso de error.
				Conexion.getConexion().rollback();
			} catch (SQLException rollbackEx) {
				rollbackEx.printStackTrace();
			}
		} finally {
			try {
				Conexion.getConexion().setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
