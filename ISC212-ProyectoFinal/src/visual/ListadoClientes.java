package visual;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logic.Cliente;
import logic.Tienda;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ListadoClientes extends JDialog {

	private static String codigo=null;
	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelClientes;
	private static Object[] rowsClientes;
	private JTextField txtCodigo;
	private JButton btnSalir;
	private JButton btnSeleccionar;
	private JTable tableClientes;
	private JButton btnMostrarTodos;

	String showDialog() {
	    setVisible(true);
	    return codigo;
	}
	
	public ListadoClientes() {
		setResizable(false);
		setModal(true);
		setTitle("Listado de Clientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/resources/logo.png")));
		setBounds(100, 100, 360, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 11, 210, 23);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Tienda.getInstance().verificarProducto(txtCodigo.getText())) {
					cargarTabla(true);
					btnMostrarTodos.setEnabled(true);
				} else {
					btnMostrarTodos.setEnabled(false);
					btnSeleccionar.setEnabled(false);
					JOptionPane.showConfirmDialog(null, "ERROR: EL codigo '"+txtCodigo.getText()+"' no fue encontrado.", "ERROR", JOptionPane.ERROR_MESSAGE);
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
				codigo=null;
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
		
		tableClientes = new JTable();
		tableClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = -1;
				seleccion = tableClientes.getSelectedRow();
				codigo = tableClientes.getValueAt(seleccion,  0).toString();
				btnSeleccionar.setEnabled(true);
			}
		});
		tableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelClientes = new DefaultTableModel();
		tableClientes.setModel(modelClientes);
		tableClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableClientes.getTableHeader().setReorderingAllowed(false);
		
		String[] headers= {"Codigo", "Nombre"};
		modelClientes.setColumnIdentifiers(headers);
		TableColumnModel columModel = tableClientes.getColumnModel();
		columModel.getColumn(0).setPreferredWidth(90);
		columModel.getColumn(1).setPreferredWidth(229);
		scrollPane.setViewportView(tableClientes);
		
		cargarTabla(false);
	}

	private void cargarTabla(boolean busqueda) {
		rowsClientes = new Object[modelClientes.getColumnCount()];
		modelClientes.setRowCount(0);
		if(busqueda) {
			for(Cliente x: Tienda.getInstance().getClientes()) {
				if(x.getCedula().equalsIgnoreCase(txtCodigo.getText())) {
					rowsClientes[0]= x.getCedula();
					rowsClientes[1]= x.getNombre();
					modelClientes.addRow(rowsClientes);
				}
			}
		} else {
			for(Cliente x: Tienda.getInstance().getClientes()) {
				rowsClientes[0]= x.getCedula();
				rowsClientes[1]= x.getNombre();
				modelClientes.addRow(rowsClientes);
			}
		}
		
	}
}
