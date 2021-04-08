package visual;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logic.Proveedor;
import logic.Tienda;

public class ListadoProveedores extends JDialog {


	private static String rnc=null;
	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelProveedor;
	private static Object[] rowsProveedor;
	private JTextField txtRnc;
	private JButton btnSalir;
	private JButton btnSeleccionar;
	private JTable tableProveedor;
	private JButton btnMostrarTodos;

	String showDialog() {
	    setVisible(true);
	    return rnc;
	}
	
	public ListadoProveedores() {
		setResizable(false);
		setModal(true);
		setTitle("Listado de Proveedor");
		setBounds(100, 100, 360, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		txtRnc = new JTextField();
		txtRnc.setBounds(10, 11, 210, 23);
		panel.add(txtRnc);
		txtRnc.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Tienda.getInstance().verificarRnc(txtRnc.getText())) {
					cargarTabla(true);
					btnMostrarTodos.setEnabled(true);
				} else {
					btnMostrarTodos.setEnabled(false);
					btnSeleccionar.setEnabled(false);
					JOptionPane.showConfirmDialog(null, "ERROR: EL RNC '"+txtRnc.getText()+"' no fue encontrado.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(230, 11, 104, 23);
		panel.add(btnNewButton_1);
		
		btnMostrarTodos = new JButton("Mostrar todos");
		btnMostrarTodos.setEnabled(false);
		btnMostrarTodos.setBounds(10, 45, 324, 23);
		panel.add(btnMostrarTodos);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSeleccionar.setEnabled(false);
		btnSeleccionar.setBounds(181, 428, 153, 23);
		panel.add(btnSeleccionar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rnc=null;
				dispose();
			}
		});
		btnSalir.setBounds(10, 428, 153, 23);
		panel.add(btnSalir);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 79, 324, 338);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		tableProveedor = new JTable();
		tableProveedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = -1;
				seleccion = tableProveedor.getSelectedRow();
				rnc = tableProveedor.getValueAt(seleccion,  0).toString();
				btnSeleccionar.setEnabled(true);
			}
		});
		tableProveedor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelProveedor = new DefaultTableModel();
		tableProveedor.setModel(modelProveedor);
		tableProveedor.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableProveedor.getTableHeader().setReorderingAllowed(false);
		
		String[] headers= {"Codigo", "Nombre"};
		modelProveedor.setColumnIdentifiers(headers);
		TableColumnModel columModel = tableProveedor.getColumnModel();
		columModel.getColumn(0).setPreferredWidth(90);
		columModel.getColumn(1).setPreferredWidth(229);
		scrollPane.setViewportView(tableProveedor);
		
		cargarTabla(false);
	}

	private void cargarTabla(boolean busqueda) {
		rowsProveedor = new Object[modelProveedor.getColumnCount()];
		modelProveedor.setRowCount(0);
		if(busqueda) {
			for(Proveedor x: Tienda.getInstance().getProveedores()) {
				if(x.getRnc().equalsIgnoreCase(txtRnc.getText())) {
					rowsProveedor[0]= x.getRnc();
					rowsProveedor[1]= x.getNombre();
					modelProveedor.addRow(rowsProveedor);
				}
			}
		} else {
			for(Proveedor x: Tienda.getInstance().getProveedores()) {
				rowsProveedor[0]= x.getRnc();
				rowsProveedor[1]= x.getNombre();		
				modelProveedor.addRow(rowsProveedor);
			}
		}
		
	}
}