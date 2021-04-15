package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import logic.Administrador;
import logic.Componente;
import logic.OrdenInventario;
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

	private static ArrayList<Componente> carrito = null;
	private static Proveedor proveedor=null;
	private static Producto productoSeleccionado=null;
	
	private static OrdenInventario ordenInventario=null;
	private static int funcion;
	private static int tipo;
	
	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelProductos;
	private static Object[] rowsProductos;
	private JTextField txtRnc;
	private JTextField txtNombreP;
	private JTextField txtTelefonoP;
	private JTextField txtMontoTotal;
	private JTable tableProductos;
	private JSpinner spnFecha;
	private JButton btnAgregarProducto;
	private JButton btnEliminarProducto;
	private JButton btnAccion;
	private JButton btnAbrirProducto;
	private JButton btnCuentasPorCobrar;
	private JButton btnBuscar;
	private JComboBox<String> cbxPlazoPago;
	
	public RegistroCompra(OrdenInventario aux, int auxA, int auxB) {
		// 0: MODIFICAR, 1: ABRIR, 2: ELIMINAR, 3: CONVERTIR
		// 0: Orden, 1: Devolucion, 2: cotizacion
		
		ordenInventario=aux;
		funcion=auxA;
		tipo=auxB;
		carrito= new ArrayList<Componente>();
		
		if(ordenInventario == null) {
			switch(tipo) {
			case 0:
				setTitle("CECOMSA - Registro de orden de compra.");
				break;
			case 1:
				setTitle("CECOMSA - Registro de devolucion de inventario");
				break;
			case 2:
				setTitle("CECOMSA - Registro de cotizacion de inventario");
				break;
			}
		} else {
			switch (tipo) {
			case 0:
				// ORDEN DE INVENTARIO
				switch (funcion) {
				case 0:
					// MODIFICAR
					setTitle("CECOMSA - Modificar orden de compra (Codigo:"+ordenInventario.getCodigo()+").");
					break;
				case 1:
					// ABRIR
					setTitle("CECOMSA - Abrir orden de compra (Codigo:"+ordenInventario.getCodigo()+").");
					break;
				case 2:
					// ELIMINAR
					setTitle("CECOMSA - Eliminar orden de compra (Codigo:"+ordenInventario.getCodigo()+").");
					break;
				case 3:
					// CONVERTIR
					setTitle("CECOMSA - Generar devolucion de inventario (Codigo:"+ordenInventario.getCodigo()+").");
					break;
				}
				break;
			case 1:
				// DEVOLUCION
				switch (funcion) {
				case 0:
					// MODIFICAR
					setTitle("CECOMSA - Modificar devolucion de inventario (Codigo:"+ordenInventario.getCodigo()+").");
					break;
				case 1:
					// ABRIR
					setTitle("CECOMSA - Abrir devolucion de inventario (Codigo:"+ordenInventario.getCodigo()+").");
					break;
				case 2:
					// ELIMINAR
					setTitle("CECOMSA - Eliminar evolucion de inventario (Codigo:"+ordenInventario.getCodigo()+").");
					break;
				}
				break;
			case 2:	
				// COTIZACION
				switch (funcion) {
				case 0:
					// MODIFICAR
					setTitle("Modificar cotizacion de inventario (Codigo:"+ordenInventario.getCodigo()+").");
					break;
				case 1:
					// ABRIR
					setTitle("Abrir cotizacion de inventario (Codigo:"+ordenInventario.getCodigo()+").");
					break;
				case 2:
					// ELIMINAR
					setTitle("Eliminar cotizacion de inventario (Codigo:"+ordenInventario.getCodigo()+").");
					break;
				case 3:
					// CONVERTIR
					setTitle("Generar orden de compra (Codigo:"+ordenInventario.getCodigo()+").");
					break;
				}
				break;
			}
		}
		
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/resources/logo.png")));
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
			
			btnBuscar = new JButton("Buscar");
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
			lblNewLabel.setBounds(10, 51, 98, 14);
			panel.add(lblNewLabel);
			
			txtNombreP = new JTextField();
			txtNombreP.setEditable(false);
			txtNombreP.setBounds(66, 48, 228, 20);
			panel.add(txtNombreP);
			txtNombreP.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Telefono:");
			lblNewLabel_1.setBounds(10, 82, 98, 14);
			panel.add(lblNewLabel_1);
			
			txtTelefonoP = new JTextField();
			txtTelefonoP.setEditable(false);
			txtTelefonoP.setBounds(66, 79, 228, 20);
			panel.add(txtTelefonoP);
			txtTelefonoP.setColumns(10);
		}
		{
			btnAbrirProducto = new JButton("");
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
			btnAbrirProducto.setBounds(614, 92, 70, 70);
			contentPanel.add(btnAbrirProducto);
		}
		{
			btnAgregarProducto = new JButton("");
			btnAgregarProducto.setIcon(new ImageIcon(RegistroCompra.class.getResource("/resources/agregarproducto.png")));
			btnAgregarProducto.setEnabled(false);
			btnAgregarProducto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListadoProductos listadoProductos=null;
					switch(tipo) {
					case 0:
						listadoProductos = new ListadoProductos(false, true);
						break;
					case 1:
						listadoProductos = new ListadoProductos(true, true);
						break;
					case 2:
						listadoProductos = new ListadoProductos(false, true);
						break;
					}				
					Producto producto = listadoProductos.showDialog();
					if(producto!=null) {
						carrito.add((Componente) producto);
						cargarCarrito();
					}
				}
			});
			btnAgregarProducto.setBounds(614, 170, 70, 70);
			contentPanel.add(btnAgregarProducto);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Adicional", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(329, 11, 275, 110);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Metodo de pago:");
		label.setBounds(10, 51, 194, 14);
		panel.add(label);
		
		cbxPlazoPago = new JComboBox<String>();
		cbxPlazoPago.setModel(new DefaultComboBoxModel<String>(new String[] {"EFECTIVO", "CREDITO A 15 DIAS", "CREDITO A 30 DIAS", "CREDITO A 45 DIAS"}));
		cbxPlazoPago.setSelectedIndex(0);
		cbxPlazoPago.setBounds(110, 48, 155, 20);
		panel.add(cbxPlazoPago);
		
		spnFecha = new JSpinner();
		spnFecha.setModel(new SpinnerDateModel(Calendar.getInstance().getTime(), new Date(-2201282844000L), new Date(4110148800000L), Calendar.HOUR));
		spnFecha.setBounds(110, 20, 155, 20);
		panel.add(spnFecha);
		
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
				if(tableProductos.isEnabled()) {
					seleccion = tableProductos.getSelectedRow();
					productoSeleccionado = Tienda.getInstance().buscarProducto(tableProductos.getValueAt(seleccion,  0).toString());
					btnEliminarProducto.setEnabled(true);
					btnAbrirProducto.setEnabled(true);
				}
			}
		});
		tableProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelProductos = new DefaultTableModel() {
			@Override 
			public boolean isCellEditable(int row, int column) {
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
		
		btnEliminarProducto = new JButton("");
		btnEliminarProducto.setIcon(new ImageIcon(RegistroCompra.class.getResource("/resources/eliminarproducto.png")));
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto a=null;
				if(productoSeleccionado!=null) {
					for(Producto x: carrito) {
						if(x.getCodigo().equals(productoSeleccionado.getCodigo())) {
							a=x;
						}
					}
					carrito.remove(a);
					cargarCarrito();
				}
			}
		});
		btnEliminarProducto.setEnabled(false);
		btnEliminarProducto.setBounds(614, 251, 70, 70);
		contentPanel.add(btnEliminarProducto);
		
		btnCuentasPorCobrar = new JButton("");
		btnCuentasPorCobrar.setIcon(new ImageIcon(RegistroCompra.class.getResource("/resources/cuentasporpagar.png")));
		btnCuentasPorCobrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CuentasPagar cuentasPagar = new CuentasPagar();
				cuentasPagar.setVisible(true);
			}
		});
		btnCuentasPorCobrar.setEnabled(false);
		btnCuentasPorCobrar.setBounds(614, 11, 70, 70);
		contentPanel.add(btnCuentasPorCobrar);
		
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
		
	
		if(ordenInventario == null) {
			btnAccion = new JButton("");
			switch (tipo) {
			case 0:
				btnAccion.setIcon(new ImageIcon(RegistroCompra.class.getResource("/resources/comprar.png")));
				break;
			case 1:
				btnAccion.setIcon(new ImageIcon(RegistroCompra.class.getResource("/resources/devolver.png")));
				break;
			case 2:	
				btnAccion.setIcon(new ImageIcon(RegistroCompra.class.getResource("/resources/cotizar.png")));
				break;
			}
		} else {
			switch (funcion) {
			case 0:
				btnAccion = new JButton("");
				btnAccion.setIcon(new ImageIcon(RegistroCompra.class.getResource("/resources/modificar.png")));
				break;
			case 1:
				btnAccion = new JButton("Abrir");
				btnAccion.setVisible(false);
				break;
			case 2:
				btnAccion = new JButton("");
				btnAccion.setIcon(new ImageIcon(RegistroCompra.class.getResource("/resources/eliminar.png")));
				break;
			case 3:
				btnAccion = new JButton("");
				btnAccion.setIcon(new ImageIcon(RegistroCompra.class.getResource("/resources/generar.png")));
				break;
			}
		}
		
		
		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ordenInventario == null) {
					if(!carrito.isEmpty()) {
						switch(tipo) {
						case 0:
							Tienda.getInstance().generarCompraInventario(proveedor, (Administrador) Tienda.getLoginUser(), cbxPlazoPago.getSelectedIndex(), (Date) spnFecha.getValue(), carrito);
							break;
						case 1:
							Tienda.getInstance().generarDevolucionInventario(proveedor, (Administrador) Tienda.getLoginUser(), cbxPlazoPago.getSelectedIndex(), (Date) spnFecha.getValue(), carrito);
							break;
						case 2:
							Tienda.getInstance().generarCotizacionInventario(proveedor, (Administrador) Tienda.getLoginUser(), cbxPlazoPago.getSelectedIndex(), (Date) spnFecha.getValue(), carrito);
							break;
						}
						clear();
					} else {
						JOptionPane.showMessageDialog(null, "No hay productos ingresado ingresados en el carrito, ingrese alguno e intentelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
					
				} else {
					switch (tipo) {
					case 0:
						// ORDEN DE INVENTARIO
						switch (funcion) {
						case 0:
							if(!carrito.isEmpty()) {
								Tienda.getInstance().modificarCompraInventario(ordenInventario.getCodigo(), proveedor, (Administrador) Tienda.getLoginUser(), cbxPlazoPago.getSelectedIndex(), (Date) spnFecha.getValue(), carrito);
								dispose();
							} else {
								JOptionPane.showMessageDialog(null, "No hay productos ingresado ingresados en el carrito, ingrese alguno e intentelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
							}
							break;
						case 2:
							Tienda.getInstance().eliminarCompraInventario(ordenInventario.getCodigo());
							dispose();
							break;
						case 3:
							Tienda.getInstance().compraInventarioToDevolucionInventario(ordenInventario.getCodigo());
							dispose();
							break;
						}
						break;
					case 1:
						// DEVOLUCION
						switch (funcion) {
						case 0:
							if(!carrito.isEmpty()) {
								Tienda.getInstance().modificarDevolucionInventario(ordenInventario.getCodigo(), proveedor, (Administrador) Tienda.getLoginUser(), cbxPlazoPago.getSelectedIndex(), (Date) spnFecha.getValue(), carrito);
								dispose();
							} else {
								JOptionPane.showMessageDialog(null, "No hay productos ingresado ingresados en el carrito, ingrese alguno e intentelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
							}
							break;
						case 2:
							Tienda.getInstance().eliminarDevolucionInventario(ordenInventario.getCodigo());
							dispose();
							break;
						}
						break;
					case 2:	
						// COTIZACION
						switch (funcion) {
						case 0:
							if(!carrito.isEmpty()) {
								Tienda.getInstance().modificarCotizacionInventario(ordenInventario.getCodigo(), proveedor, (Administrador) Tienda.getLoginUser(), cbxPlazoPago.getSelectedIndex(), (Date) spnFecha.getValue(), carrito);
								dispose();
							} else {
								JOptionPane.showMessageDialog(null, "No hay productos ingresado ingresados en el carrito, ingrese alguno e intentelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
							}
							break;
						case 2:
							Tienda.getInstance().eliminarCotizacionInventario(ordenInventario.getCodigo());
							dispose();
							break;
						case 3:
							Tienda.getInstance().cotizacionInventarioToCompraInventario(ordenInventario.getCodigo());
							dispose();
							break;
						}
						break;
					}
				}
			}
		});
		btnAccion.setEnabled(false);
		btnAccion.setBounds(98, 413, 78, 78);
		contentPanel.add(btnAccion);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(RegistroVenta.class.getResource("/resources/salir.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(10, 413, 78, 78);
		contentPanel.add(btnSalir);
		
		if(ordenInventario != null) {
			cargarOrden();
			if(funcion!=0) {
				bloquearCampos();
			}
		}				
	}
	
	
	private void clear() {
		carrito= new ArrayList<Componente>();
		proveedor=null;
		productoSeleccionado=null;
		txtNombreP.setText("");
		txtTelefonoP.setText("");
		btnAbrirProducto.setEnabled(false);
		btnAgregarProducto.setEnabled(false);
		btnEliminarProducto.setEnabled(false);
		btnAccion.setEnabled(false);
		cargarCarrito();
	}
	
	private void cargarOrden() {
		proveedor=ordenInventario.getProveedor();
		txtNombreP.setText(proveedor.getNombre());
		txtTelefonoP.setText(proveedor.getTelefono());
		txtRnc.setText(proveedor.getRnc());
		txtRnc.setEnabled(false);
		carrito=new ArrayList<Componente>();
		carrito.addAll(ordenInventario.getComponentes());
		btnBuscar.setEnabled(false);
		btnAgregarProducto.setEnabled(true);
		spnFecha.setValue(ordenInventario.getFecha());
		cbxPlazoPago.setSelectedIndex(ordenInventario.getPlazoPago());
		btnAccion.setEnabled(true);
		cargarCarrito();
	}
	
	private void bloquearCampos() {
		btnAgregarProducto.setEnabled(false);
		btnBuscar.setEnabled(false);
		btnEliminarProducto.setEnabled(false);
		tableProductos.setEnabled(false);
		spnFecha.setEnabled(false);
		cbxPlazoPago.setEnabled(false);
		txtRnc.setEnabled(false);
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
					rowsProductos[1]="Paquete #(Codigo: "+((PaqueteComponentes) x).getCodigo()+")";
				}		
				rowsProductos[2]=x.getCantidad();
				rowsProductos[3]="$ "+x.getCosto();
				rowsProductos[4]="$ "+x.getCantidad()*x.getCosto();
				montoTotal+=x.getCantidad()*x.getCosto();
				modelProductos.addRow(rowsProductos);
			}
		}
		txtMontoTotal.setText("$ "+montoTotal);
	}
}
