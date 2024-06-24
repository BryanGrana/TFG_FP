package tfg.bryan;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

import models.Project;

public class BajaProyecto extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable jtGestion;
	private DefaultTableModel tModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BajaProyecto dialog = new BajaProyecto(new JFrame(), true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BajaProyecto(JFrame parent, boolean modal) {

		super(parent, modal);
		setTitle("Eliminar proyecto");
		setBounds(100, 100, 790, 303);
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
				scrollPane.setViewportView(jtGestion);
			}
		}
		tModel = new DefaultTableModel();

		tModel = (DefaultTableModel) jtGestion.getModel();

		jtGestion.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nombre", "Descripción", "Presupuesto", "Fecha inicio", "Fecha fin" }) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		llenarTabla();

		popupMenu = new JPopupMenu();
		JMenuItem deleteItem = new JMenuItem("Eliminar");
		deleteItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jtGestion.getSelectedRow();
				if (selectedRow != -1) {
					int opcion = opcionEliminar();
					if (opcion == JOptionPane.YES_OPTION) {
						Project p = (Project) jtGestion.getValueAt(selectedRow, 0);
						eliminarProyecto(p.getId());
						llenarTabla();
					}
				}
			}
		});
		popupMenu.add(deleteItem);

		jtGestion.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				menuPopUpTable(e);
			}

		});
	}

	private JPopupMenu popupMenu;

	private void menuPopUpTable(MouseEvent e) {
		int row = jtGestion.rowAtPoint(e.getPoint());
		jtGestion.setRowSelectionInterval(row, row);
		popupMenu.show(e.getComponent(), e.getX(), e.getY());

	}

	private void llenarTabla() {
		try {
			tModel.setRowCount(0);
			tModel = (DefaultTableModel) jtGestion.getModel();

			Statement stmt = Conexion.getConexion().createStatement();
			String consulta = "select * from Projects order by Start_Date";
			ResultSet rs = stmt.executeQuery(consulta);
			Project p;
			while (rs.next()) {
				p = new Project(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"),
						rs.getDouble("Budget"), rs.getDate("Start_Date"), rs.getDate("End_Date"));

				int rows = tModel.getRowCount();
				tModel.setRowCount(rows + 1);

				tModel.setValueAt(p, rows, 0);
				tModel.setValueAt(p.getDescription(), rows, 1);
				tModel.setValueAt(p.getBudget(), rows, 2);
				tModel.setValueAt(p.getEndDate() == null ? "No asignada" : p.getEndDate(), rows, 3);
			}
		} catch (SQLException ex) {
			Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private int opcionEliminar() {
		Object[] options = { "Sí", "No", "Cancelar" };
		return JOptionPane.showOptionDialog(this, "¿Estás seguro de que deseas eliminar al trabajador?",
				"Confirmación de eliminación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				options, options[0]);
	}

	private void eliminarProyecto(int projectId) {
		String sqlDeleteProjectWorker = "DELETE FROM project_worker WHERE Project_ID = ?";
		String sqlDeleteProject = "DELETE FROM Projects WHERE ID = ?";

		try {
			Connection conexion = Conexion.getConexion();
			PreparedStatement pstmt1 = conexion.prepareStatement(sqlDeleteProjectWorker);
			PreparedStatement pstmt2 = conexion.prepareStatement(sqlDeleteProject);
			
			// Empieza la transacción.
			conexion.setAutoCommit(false);

			pstmt1.setInt(1, projectId);
			pstmt1.executeUpdate();

			pstmt2.setInt(1, projectId);
			pstmt2.executeUpdate();

			conexion.commit();
			

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
