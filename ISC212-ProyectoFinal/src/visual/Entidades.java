package visual;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logic.Administrador;
import logic.Cliente;
import logic.Empleado;
import logic.Proveedor;
import logic.Tienda;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Entidades extends JDialog {

	private static int tipoFuncion;
	private static int filtros=0;
	
	
	private static String clienteSeleccionado=null;
	private static String proveedorSeleccionado=null;
	private static String empleadoSeleccionado=null;
	
	private static DefaultTableModel modelEntidades;
	private static Object[] rowsEntidades;
	private final JPanel contentPanel = new JPanel();
	private JTable tablaEntidades;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnAbrir;
	private JButton btnCrear;
	private JComboBox<String> cbxOrdenar;
	private JButton btnNewButton;

	public Entidades(int aux) {
		tipoFuncion=aux;
		switch (tipoFuncion) {
		case 0:
			setTitle("CECOMSA - Listado de Clientes");
			break;
		case 1:
			setTitle("CECOMSA - Listado de Empleados");
			break;
		case 2:
			setTitle("CECOMSA - Listado de proveedores");
			break;
		}
		
		setBounds(100, 100, 600, 450);
		setLocationRelativeTo(null);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(Entidades.class.getResource("/resources/salir.png")));
		btnNewButton.setBounds(494, 321, 70, 70);
		panel.add(btnNewButton);
		
		btnCrear = new JButton("crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (tipoFuncion) {
				case 0:
					RegistroCliente registroCliente = new RegistroCliente(null, 0);
					registroCliente.setVisible(true);
					cargarTablas();
					break;
				case 1:
					RegistroEmpleado registroEmpleado = new RegistroEmpleado(null, 0);
					registroEmpleado.setVisible(true);
					cargarTablas();
					break;
				case 2:
					RegistroProveedor registroProveedor = new RegistroProveedor(null, 0);
					registroProveedor.setVisible(true);
					cargarTablas();
					break;
				}
				cargarTablas();
			}
		});
		
		btnCrear.setBounds(10, 321, 70, 70);
		panel.add(btnCrear);
		
		btnAbrir = new JButton("");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				switch (tipoFuncion) {
				case 0:
					Busqueda busqueda0 = new Busqueda(8, 2, clienteSeleccionado);
					busqueda0.setVisible(true);
					cargarTablas();
					break;
				case 1:
					Busqueda busqueda1 = new Busqueda(10, 2, empleadoSeleccionado);
					busqueda1.setVisible(true);
					cargarTablas();
					break;
				case 2:
					Busqueda busqueda2 = new Busqueda(9, 2, proveedorSeleccionado);
					busqueda2.setVisible(true);
					cargarTablas();
					break;
				}
				cargarTablas();
			}
		});
		btnAbrir.setEnabled(false);
		btnAbrir.setIcon(new ImageIcon(Entidades.class.getResource("/resources/abrir.png")));
		btnAbrir.setBounds(90, 321, 70, 70);
		panel.add(btnAbrir);
		
		btnModificar = new JButton("");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (tipoFuncion) {
				case 0:
					Busqueda busqueda0 = new Busqueda(8, 0, clienteSeleccionado);
					busqueda0.setVisible(true);
					cargarTablas();
					break;
				case 1:
					Busqueda busqueda1 = new Busqueda(10, 0, empleadoSeleccionado);
					busqueda1.setVisible(true);
					cargarTablas();
					break;
				case 2:
					Busqueda busqueda2 = new Busqueda(9, 0, proveedorSeleccionado);
					busqueda2.setVisible(true);
					cargarTablas();
					break;
				}
				cargarTablas();
			}
		});
		btnModificar.setEnabled(false);
		btnModificar.setIcon(new ImageIcon(Entidades.class.getResource("/resources/modificar.png")));
		btnModificar.setBounds(170, 321, 70, 70);
		panel.add(btnModificar);
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (tipoFuncion) {
				case 0:
					Busqueda busqueda0 = new Busqueda(8, 3, clienteSeleccionado);
					busqueda0.setVisible(true);
					cargarTablas();
					break;
				case 1:
					Busqueda busqueda1 = new Busqueda(10, 3, empleadoSeleccionado);
					busqueda1.setVisible(true);
					cargarTablas();
					break;
				case 2:
					Busqueda busqueda2 = new Busqueda(9, 3, proveedorSeleccionado);
					busqueda2.setVisible(true);
					cargarTablas();
					break;
				}
				cargarTablas();
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setIcon(new ImageIcon(Entidades.class.getResource("/resources/eliminar.png")));
		btnEliminar.setBounds(250, 321, 70, 70);
		panel.add(btnEliminar);
		
		JPanel panelTablaEntidades = new JPanel();
		panelTablaEntidades.setBounds(10, 39, 554, 271);
		panel.add(panelTablaEntidades);
		panelTablaEntidades.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneTablaEntidades = new JScrollPane();
		panelTablaEntidades.add(scrollPaneTablaEntidades, BorderLayout.CENTER);
		
		tablaEntidades = new JTable();
		tablaEntidades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = -1;
				seleccion = tablaEntidades.getSelectedRow();
				switch (tipoFuncion) {
				case 0:
					clienteSeleccionado = tablaEntidades.getValueAt(seleccion,  0).toString();
					break;
				case 1:
					empleadoSeleccionado = tablaEntidades.getValueAt(seleccion,  0).toString();
					break;
				case 2:
					proveedorSeleccionado = tablaEntidades.getValueAt(seleccion,  0).toString();
					break;
				}
				btnModificar.setEnabled(true);
				btnEliminar.setEnabled(true);
				btnAbrir.setEnabled(true);
			}
		});
		
		tablaEntidades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelEntidades = new DefaultTableModel();
		tablaEntidades.setModel(modelEntidades);
		tablaEntidades.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablaEntidades.getTableHeader().setReorderingAllowed(false);
		
		switch (tipoFuncion) {
		case 0:
			String[] headers0= {"Cedula", "Nombre", "Telefono", "Direccion"};
			modelEntidades.setColumnIdentifiers(headers0);
			break;
		case 1:
			String[] headers1= {"Codigo", "Nombre", "Telefono", "Direccion"};
			modelEntidades.setColumnIdentifiers(headers1);
			break;
		case 2:
			String[] headers2= {"RNC", "Nombre", "Telefono", "Direccion"};
			modelEntidades.setColumnIdentifiers(headers2);
			break;
		}
		
		TableColumnModel columModel = tablaEntidades.getColumnModel();
		columModel.getColumn(0).setPreferredWidth(100);
		columModel.getColumn(1).setPreferredWidth(160);
		columModel.getColumn(2).setPreferredWidth(145);
		columModel.getColumn(3).setPreferredWidth(145);
		
		scrollPaneTablaEntidades.setViewportView(tablaEntidades);
		
		JLabel lblOrdenar = new JLabel("Ordenar por:");
		lblOrdenar.setBounds(10, 11, 85, 14);
		panel.add(lblOrdenar);
		
		cbxOrdenar = new JComboBox<String>();
		switch (tipoFuncion) {
		case 0:
			cbxOrdenar.setModel(new DefaultComboBoxModel<String>(new String[] {"CEDULA", "NOMBRE"}));
			break;
		case 1:
			cbxOrdenar.setModel(new DefaultComboBoxModel<String>(new String[] {"CODIGO", "NOMBRE"}));
			break;
		case 2:
			cbxOrdenar.setModel(new DefaultComboBoxModel<String>(new String[] {"RNC", "NOMBRE"}));
			break;
		}
		cbxOrdenar.setBounds(90, 8, 150, 20);
		panel.add(cbxOrdenar);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setBounds(280, 11, 85, 14);
		panel.add(lblFiltrarPor);
		
		JComboBox<String> cbxEmpleados = new JComboBox<String>();
		cbxEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbxEmpleados.getSelectedIndex()!=-1) {
					filtros=cbxEmpleados.getSelectedIndex();
					cargarTablas();
				}
			}
		});
		cbxEmpleados.setModel(new DefaultComboBoxModel<String>(new String[] {"TODOS", "EMPLEADOS", "ADMINISTRADORES"}));
		cbxEmpleados.setBounds(360, 8, 150, 20);
		panel.add(cbxEmpleados);
		if(tipoFuncion!=1) {
			cbxEmpleados.setVisible(false);
			lblFiltrarPor.setVisible(false);
		}
		
		cargarTablas();
	}

	private void cargarTablas() {
		rowsEntidades = new Object[modelEntidades.getColumnCount()];
		modelEntidades.setRowCount(0);
		switch (tipoFuncion) {
		case 0:
			for(Cliente x: Tienda.getInstance().getClientes()) {
				rowsEntidades[0]= x.getCedula();
				rowsEntidades[1]=x.getNombre();
				rowsEntidades[2]=x.getTelefono();
				rowsEntidades[3]=x.getDireccion();
				modelEntidades.addRow(rowsEntidades);
			}
			break;
		case 1:
			for(Empleado x: Tienda.getInstance().getEmpleados()) {
				rowsEntidades[0]= x.getCodigo();
				rowsEntidades[1]=x.getNombre();
				rowsEntidades[2]=x.getTelefono();
				rowsEntidades[3]=x.getDireccion();
				
				switch(filtros){
				case 0:
					modelEntidades.addRow(rowsEntidades);
					break;
				case 1:
					if(!(x instanceof Administrador)) {
						modelEntidades.addRow(rowsEntidades);
					}
					break;
				case 2:
					if(x instanceof Administrador) {
						modelEntidades.addRow(rowsEntidades);
					}
					break;
				}
				
			}
			break;
		case 2:
			for(Proveedor x: Tienda.getInstance().getProveedores()) {
				rowsEntidades[0]= x.getRnc();
				rowsEntidades[1]=x.getNombre();
				rowsEntidades[2]=x.getTelefono();
				rowsEntidades[3]=x.getDireccion();
				modelEntidades.addRow(rowsEntidades);
			}
			break;
		}
	}
}
