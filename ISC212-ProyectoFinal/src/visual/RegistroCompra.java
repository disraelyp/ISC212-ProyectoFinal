package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logic.Componente;
import logic.PaqueteComponentes;
import logic.Producto;
import logic.Proveedor;
import logic.Tienda;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistroCompra extends JDialog {

	
	
	private static ArrayList<Producto> carrito = new ArrayList<Producto>();
	private static Proveedor proveedor=null;
	private static Producto productoSeleccionado=null;
	
	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelProductos;
	private static Object[] rowsProductos;
	private JTextField txtRnc;
	private JTextField txtNombreP;
	private JTextField txtTelefonoP;
	private JTextField txtMontoTotal;
	private JTable tableProductos;
	private JSpinner spinner;
	private JButton btnAgregarProducto;
	private JButton btnEliminarProducto;
	private JButton btnAccion;
	
	public RegistroCompra() {
		
		
		setResizable(false);
		setTitle("Modulo de Compras");
		setModal(true);
		setBounds(100, 100, 710, 534);	
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion del Proveedor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 309, 110);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblCodigo = new JLabel("RNC:");
				lblCodigo.setBounds(10, 23, 80, 14);
				panel.add(lblCodigo);
			}
			
			txtRnc = new JTextField();
			txtRnc.setBounds(66, 20, 129, 20);
			panel.add(txtRnc);
			txtRnc.setColumns(10);
			
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(Tienda.getInstance().verificarRnc(txtRnc.getText())) {
						proveedor=Tienda.getInstance().buscarProveedor(txtRnc.getText());
						txtNombreP.setText(proveedor.getNombre());
						txtTelefonoP.setText(proveedor.getTelefono());
						btnAgregarProducto.setEnabled(true);
					} else {
						ListadoProveedores listadoProveedores = new ListadoProveedores();
						String rnc = listadoProveedores.showDialog();
						if(rnc!=null) {
							proveedor=Tienda.getInstance().buscarProveedor(rnc);
							txtNombreP.setText(proveedor.getNombre());
							txtTelefonoP.setText(proveedor.getTelefono());
							btnAgregarProducto.setEnabled(true);
						}
					}					
				}
			});
			btnBuscar.setBounds(205, 19, 89, 23);
			panel.add(btnBuscar);
			
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(10, 51, 46, 14);
			panel.add(lblNewLabel);
			
			txtNombreP = new JTextField();
			txtNombreP.setEditable(false);
			txtNombreP.setBounds(66, 48, 228, 20);
			panel.add(txtNombreP);
			txtNombreP.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Telefono:");
			lblNewLabel_1.setBounds(10, 82, 67, 14);
			panel.add(lblNewLabel_1);
			// HOLAA
			txtTelefonoP = new JTextField();
			txtTelefonoP.setEditable(false);
			txtTelefonoP.setBounds(66, 79, 228, 20);
			panel.add(txtTelefonoP);
			txtTelefonoP.setColumns(10);
		}
		{
			JButton btnAbrirProducto = new JButton("");
			btnAbrirProducto.setEnabled(false);
			btnAbrirProducto.setIcon(new ImageIcon(RegistroVenta.class.getResource("/resources/abrir.png")));
			btnAbrirProducto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(productoSeleccionado instanceof Componente) {
						RegistroComponente registroComponente = new RegistroComponente((Componente) productoSeleccionado, 1);
						registroComponente.setVisible(true);
					}
					
				}
			});
			btnAbrirProducto.setVerticalAlignment(SwingConstants.TOP);
			btnAbrirProducto.setBounds(614, 173, 70, 70);
			contentPanel.add(btnAbrirProducto);
		}
		{
			btnAgregarProducto = new JButton("Agregar Producto");
			btnAgregarProducto.setEnabled(false);
			btnAgregarProducto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListadoProductos listadoProductos = new ListadoProductos();
					String codigo = listadoProductos.showDialog();
					if(codigo!=null) {
						Producto producto = Tienda.getInstance().buscarProducto(codigo);
						producto.setCantidad(1);
						carrito.add(producto);
						cargarCarrito();
					}
				}
			});
			btnAgregarProducto.setVerticalAlignment(SwingConstants.BOTTOM);
			btnAgregarProducto.setHorizontalAlignment(SwingConstants.LEFT);
			btnAgregarProducto.setBounds(614, 251, 70, 70);
			contentPanel.add(btnAgregarProducto);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Adicional", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(329, 11, 275, 110);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Metodo de pago:");
		label.setBounds(10, 51, 90, 14);
		panel.add(label);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"EFECTIVO", "CREDITO A 15 DIAS", "CREDITO A 30 DIAS", "CREDITO A 45 DIAS"}));
		comboBox.setBounds(110, 48, 155, 20);
		panel.add(comboBox);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(Calendar.getInstance().getTime(), new Date(-2201282844000L), new Date(4110148800000L), Calendar.HOUR));
		spinner.setBounds(110, 20, 155, 20);
		panel.add(spinner);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 24, 90, 14);
		panel.add(lblFecha);	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 132, 594, 270);
		contentPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		tableProductos = new JTable();
		tableProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = -1;
				seleccion = tableProductos.getSelectedRow();
				productoSeleccionado = Tienda.getInstance().buscarProducto(tableProductos.getValueAt(seleccion,  0).toString());
				btnEliminarProducto.setEnabled(true);
				btnAgregarProducto.setEnabled(true);
			}
		});
		
		tableProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelProductos = new DefaultTableModel() {
			@Override 
			public boolean isCellEditable(int row, int column) {
				if(column==2) {
					return true;
				}
				return false;
			}
		};
		
		tableProductos.setModel(modelProductos);
		tableProductos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableProductos.getTableHeader().setReorderingAllowed(false);
		String[] headers= {"Codigo", "Descripcion", "Cantidad", "Costo Unit.", "Monto Total"};
		modelProductos.setColumnIdentifiers(headers);
		TableColumnModel columModel = tableProductos.getColumnModel();
		columModel.getColumn(0).setPreferredWidth(100);
		columModel.getColumn(1).setPreferredWidth(200);
		columModel.getColumn(2).setPreferredWidth(90);
		columModel.getColumn(3).setPreferredWidth(100);
		columModel.getColumn(4).setPreferredWidth(100);
		scrollPane.setViewportView(tableProductos);
		
		btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.setEnabled(false);
		btnEliminarProducto.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEliminarProducto.setHorizontalAlignment(SwingConstants.LEFT);
		btnEliminarProducto.setBounds(614, 332, 70, 70);
		contentPanel.add(btnEliminarProducto);
		
		JButton btnCuentasPorCobrar = new JButton("Cuentas por Pagar");
		btnCuentasPorCobrar.setEnabled(false);
		btnCuentasPorCobrar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCuentasPorCobrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCuentasPorCobrar.setBounds(614, 11, 70, 70);
		contentPanel.add(btnCuentasPorCobrar);
		
		JButton btnCrearProducto = new JButton("Crear Producto");
		btnCrearProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroComponente registroComponente = new RegistroComponente(null, 0);
				registroComponente.setVisible(true);
			}
		});
		btnCrearProducto.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCrearProducto.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearProducto.setBounds(614, 92, 70, 70);
		contentPanel.add(btnCrearProducto);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(362, 413, 322, 78);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		txtMontoTotal = new JTextField();
		txtMontoTotal.setEditable(false);
		txtMontoTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMontoTotal.setForeground(Color.RED);
		txtMontoTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtMontoTotal.setText("$ 0.00     ");
		txtMontoTotal.setBounds(10, 36, 302, 31);
		panel_2.add(txtMontoTotal);
		txtMontoTotal.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Monto a Pagar:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(10, 11, 240, 25);
		panel_2.add(lblNewLabel_4);
		
		btnAccion = new JButton("");
		btnAccion.setEnabled(false);
		btnAccion.setIcon(new ImageIcon(RegistroCompra.class.getResource("/resources/comprar.png")));
		btnAccion.setBounds(10, 413, 78, 78);
		contentPanel.add(btnAccion);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(RegistroVenta.class.getResource("/resources/salir.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(98, 413, 78, 78);
		contentPanel.add(btnSalir);
	}
	private void cargarCarrito() {
		rowsProductos = new Object[modelProductos.getColumnCount()];
		float montoTotal=(float) 0.00;
		modelProductos.setRowCount(0);
		if(carrito.size()!=0) {
			btnAccion.setEnabled(true);
			for(Producto x: carrito) {
				rowsProductos[0]= x.getCodigo();
				if(x instanceof Componente) {
					rowsProductos[1]= ((Componente) x).getMarca()+"-"+((Componente) x).getModelo();
				} else {
					rowsProductos[1]="Paquete #"+((PaqueteComponentes) x).getContador();
				}		
				rowsProductos[2]=x.getCantidad();
				rowsProductos[3]=x.getCosto();
				rowsProductos[4]=x.getCantidad()*x.getCosto();
				montoTotal+=x.getCantidad()*x.getCosto();
				modelProductos.addRow(rowsProductos);
			}
		}
		
		txtMontoTotal.setText("$ "+montoTotal);
	}
}
