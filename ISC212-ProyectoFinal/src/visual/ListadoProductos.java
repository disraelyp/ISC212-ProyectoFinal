package visual;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import logic.Componente;
import logic.PaqueteComponentes;
import logic.Producto;
import logic.Tienda;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoProductos extends JDialog {

	private static String codigo=null;
	
	
	
	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelProductos;
	private static Object[] rowsProductos;
	private JTextField txtCodigo;
	private JButton btnSalir;
	private JButton btnSeleccionar;
	private JTable tableProductos;
	private JButton btnMostrarTodos;

	String showDialog() {
	    setVisible(true);
	    return codigo;
	}
	
	public ListadoProductos() {
		setResizable(false);
		setModal(true);
		setTitle("Listado de Productos");
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
		
		tableProductos = new JTable();
		tableProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = -1;
				seleccion = tableProductos.getSelectedRow();
				codigo = tableProductos.getValueAt(seleccion,  0).toString();
				btnSeleccionar.setEnabled(true);
			}
		});
		tableProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelProductos = new DefaultTableModel();
		tableProductos.setModel(modelProductos);
		tableProductos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableProductos.getTableHeader().setReorderingAllowed(false);
		
		String[] headers= {"Codigo", "Descripcion"};
		modelProductos.setColumnIdentifiers(headers);
		TableColumnModel columModel = tableProductos.getColumnModel();
		columModel.getColumn(0).setPreferredWidth(90);
		columModel.getColumn(1).setPreferredWidth(229);
		scrollPane.setViewportView(tableProductos);
		
		cargarTabla(false);
	}

	private void cargarTabla(boolean busqueda) {
		rowsProductos = new Object[modelProductos.getColumnCount()];
		modelProductos.setRowCount(0);
		if(busqueda) {
			for(Producto x: Tienda.getInstance().getProductos()) {
				if(x.getCodigo().equalsIgnoreCase(txtCodigo.getText())) {
					rowsProductos[0]= x.getCodigo();
					if(x instanceof Componente) {
						rowsProductos[1]= ((Componente) x).getMarca()+"-"+((Componente) x).getModelo();
					} else {
						rowsProductos[1]="Paquete #"+((PaqueteComponentes) x).getContador();
					}		
					modelProductos.addRow(rowsProductos);
				}
			}
		} else {
			for(Producto x: Tienda.getInstance().getProductos()) {
				rowsProductos[0]= x.getCodigo();
				if(x instanceof Componente) {
					rowsProductos[1]= ((Componente) x).getMarca()+"-"+((Componente) x).getModelo();
				} else {
					rowsProductos[1]="Paquete #"+((PaqueteComponentes) x).getContador();
				}		
				modelProductos.addRow(rowsProductos);
			}
		}
		
	}
}
