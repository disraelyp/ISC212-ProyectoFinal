package visual;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logic.Cliente;
import logic.Componente;
import logic.OrdenVenta;
import logic.PaqueteComponentes;
import logic.Producto;
import logic.Tienda;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class RegistroVenta extends JDialog {

	private static ArrayList<Producto> carrito = null;
	private static Cliente cliente=null;
	private static Producto productoSeleccionado=null;
	
	private static OrdenVenta ordenVenta=null;
	private static int funcion;
	private static int tipo;
	
	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelProductos;
	private static Object[] rowsProductos;
	private JTextField txtCedula;
	private JTextField txtNombreC;
	private JTextField txtTelefonoC;
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

	public RegistroVenta(OrdenVenta aux, int auxA, int auxB) {
		// 0: MODIFICAR, 1: ABRIR, 2: ELIMINAR, 3: CONVERTIR
		// 0: Orden, 1: Devolucion, 2: cotizacion
		
		ordenVenta=aux;
		funcion=auxA;
		tipo=auxB;
		carrito= new ArrayList<Producto>();
		
		if(ordenVenta == null) {
			switch(tipo) {
			case 0:
				setTitle("CECOMSA - Registro de factura de venta.");
				break;
			case 1:
				setTitle("CECOMSA - Registro de devolucion de venta.");
				break;
			case 2:
				setTitle("CECOMSA - Registro de cotizacion de venta.");
				break;
			}
		} else {
			switch (tipo) {
			case 0:
				// ORDEN DE VENTA
				switch (funcion) {
				case 1:
					// ABRIR
					setTitle("CECOMSA - Abrir factura de venta (Codigo:"+ordenVenta.getCodigo()+").");
					break;
				case 3:
					// CONVERTIR
					setTitle("CECOMSA - Generar devolucion de venta (Codigo:"+ordenVenta.getCodigo()+").");
					break;
				}
				break;
			case 1:
				// DEVOLUCION
				switch (funcion) {
				case 0:
					// MODIFICAR
					setTitle("CECOMSA - Modificar devolucion de venta (Codigo:"+ordenVenta.getCodigo()+").");
					break;
				case 1:
					// ABRIR
					setTitle("CECOMSA - Abrir devolucion de venta (Codigo:"+ordenVenta.getCodigo()+").");
					break;
				case 2:
					// ELIMINAR
					setTitle("CECOMSA - Eliminar evolucion de venta (Codigo:"+ordenVenta.getCodigo()+").");
					break;
				}
				break;
			case 2:	
				// COTIZACION
				switch (funcion) {
				case 0:
					// MODIFICAR
					setTitle("Modificar cotizacion de venta (Codigo:"+ordenVenta.getCodigo()+").");
					break;
				case 1:
					// ABRIR
					setTitle("Abrir cotizacion de venta (Codigo:"+ordenVenta.getCodigo()+").");
					break;
				case 2:
					// ELIMINAR
					setTitle("Eliminar cotizacion de venta (Codigo:"+ordenVenta.getCodigo()+").");
					break;
				case 3:
					// CONVERTIR
					setTitle("Generar factura de venta (Codigo:"+ordenVenta.getCodigo()+").");
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
				JLabel lblCodigo = new JLabel("ID:");
				lblCodigo.setBounds(10, 23, 80, 14);
				panel.add(lblCodigo);
			}
			
			txtCedula = new JTextField();
			txtCedula.setBounds(66, 20, 129, 20);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(Tienda.getInstance().verificarCliente(txtCedula.getText())) {
						cliente=Tienda.getInstance().buscarCliente(txtCedula.getText());
						txtNombreC.setText(cliente.getNombre());
						txtTelefonoC.setText(cliente.getTelefono());
						btnAgregarProducto.setEnabled(true);
					} else {
						ListadoClientes listadoClientes = new ListadoClientes();
						String cedula = listadoClientes.showDialog();
						if(cedula!=null) {
							cliente=Tienda.getInstance().buscarCliente(cedula);
							txtNombreC.setText(cliente.getNombre());
							txtTelefonoC.setText(cliente.getTelefono());
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
			
			txtNombreC = new JTextField();
			txtNombreC.setEditable(false);
			txtNombreC.setBounds(66, 48, 228, 20);
			panel.add(txtNombreC);
			txtNombreC.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Telefono:");
			lblNewLabel_1.setBounds(10, 82, 98, 14);
			panel.add(lblNewLabel_1);
			
			txtTelefonoC = new JTextField();
			txtTelefonoC.setEditable(false);
			txtTelefonoC.setBounds(66, 79, 228, 20);
			panel.add(txtTelefonoC);
			txtTelefonoC.setColumns(10);
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
			btnAgregarProducto.setIcon(new ImageIcon(RegistroVenta.class.getResource("/resources/agregarproducto.png")));
			btnAgregarProducto.setEnabled(false);
			btnAgregarProducto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListadoProductos listadoProductos=null;
					switch(tipo) {
					case 0:
						listadoProductos = new ListadoProductos(true, false);
						break;
					case 1:
						listadoProductos = new ListadoProductos(true, false);
						break;
					case 2:
						listadoProductos = new ListadoProductos(false, false);
						break;
					}				
					Producto producto = listadoProductos.showDialog();
					if(producto!=null) {
						carrito.add(producto);
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
		label.setBounds(10, 51, 167, 14);
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
		String[] headers= {"Codigo", "Descripcion", "Cantidad", "Precio Unit.", "Monto Total"};
		modelProductos.setColumnIdentifiers(headers);
		TableColumnModel columModel = tableProductos.getColumnModel();
		columModel.getColumn(0).setPreferredWidth(100);
		columModel.getColumn(1).setPreferredWidth(200);
		columModel.getColumn(2).setPreferredWidth(90);
		columModel.getColumn(3).setPreferredWidth(100);
		columModel.getColumn(4).setPreferredWidth(100);
		scrollPane.setViewportView(tableProductos);
		
		btnEliminarProducto = new JButton("");
		btnEliminarProducto.setIcon(new ImageIcon(RegistroVenta.class.getResource("/resources/eliminarproducto.png")));
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
		btnCuentasPorCobrar.setIcon(new ImageIcon(RegistroVenta.class.getResource("/resources/cuentasporcobrar.png")));
		btnCuentasPorCobrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CuentasCobrar cuentasCobrar = new CuentasCobrar();
				cuentasCobrar.setVisible(true);
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
		
	
		if(ordenVenta == null) {
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
				if(ordenVenta == null) {
					if(!carrito.isEmpty()) {
						switch(tipo) {
						case 0:
							float montoTotal=0;
							for(Producto x: carrito) {
								montoTotal+=x.getPrecio()*x.getCantidad();
							}
							if(Tienda.getInstance().puedeComprar(montoTotal, cliente.getCedula())){
								System.out.printf("a");
								Tienda.getInstance().generarFacturaVenta(cliente,  Tienda.getLoginUser(), (Date) spnFecha.getValue(), cbxPlazoPago.getSelectedIndex(), carrito);
								clear();
							} else {
								JOptionPane.showMessageDialog(null, "El cliente debe saldar su cuenta antes de realizar una compra de esta magnitud.admij", "Error: Limite de credito", JOptionPane.ERROR_MESSAGE);
							}
							break;
						case 1:
							Tienda.getInstance().generarDevolucionVenta(cliente,  Tienda.getLoginUser(), (Date) spnFecha.getValue(), cbxPlazoPago.getSelectedIndex(), carrito);
							clear();
							break;
						case 2:
							Tienda.getInstance().generarCotizacionVenta(cliente,  Tienda.getLoginUser(), (Date) spnFecha.getValue(), cbxPlazoPago.getSelectedIndex(), carrito);
							clear();
							break;
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "No hay productos ingresado ingresados en el carrito, ingrese alguno e intentelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
					
				} else {
					switch (tipo) {
					case 0:
						// ORDEN DE INVENTARIO
						switch (funcion) {
						case 3:
							Tienda.getInstance().facturaVentaToDevolucionVenta(ordenVenta.getCodigo());
							dispose();
							break;
						}
						break;
					case 1:
						// DEVOLUCION
						switch (funcion) {
						case 0:
							if(!carrito.isEmpty()) {
								Tienda.getInstance().modificarDevolucionVenta(ordenVenta.getCodigo(), cliente,  Tienda.getLoginUser(), (Date) spnFecha.getValue(), cbxPlazoPago.getSelectedIndex(), carrito);
								dispose();
							} else {
								JOptionPane.showMessageDialog(null, "No hay productos ingresado ingresados en el carrito, ingrese alguno e intentelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
							}
							break;
						case 2:
							Tienda.getInstance().eliminarDevolucionVenta(ordenVenta.getCodigo());
							dispose();
							break;
						}
						break;
					case 2:	
						// COTIZACION
						switch (funcion) {
						case 0:
							if(!carrito.isEmpty()) {
								Tienda.getInstance().modificarCotizacionVenta(ordenVenta.getCodigo(), cliente,  Tienda.getLoginUser(), (Date) spnFecha.getValue(), cbxPlazoPago.getSelectedIndex(), carrito);
								dispose();
							} else {
								JOptionPane.showMessageDialog(null, "No hay productos ingresados en el carrito, ingrese alguno e intentelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
							}
							break;
						case 2:
							Tienda.getInstance().eliminarCotizacionVenta(ordenVenta.getCodigo());
							dispose();
							break;
						case 3:
							if(!Tienda.getInstance().isCotizacioVentaToCompraVenta(ordenVenta.getCodigo())) {
								JOptionPane.showMessageDialog(null, "No hay suficientes productos para realizar esta factura.", "Error", JOptionPane.ERROR_MESSAGE);
							} else {
								Tienda.getInstance().cotizacioVentaToCompraVenta(ordenVenta.getCodigo());
								dispose();
							}
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
		
		if(ordenVenta != null) {
			cargarOrden();
			if(funcion!=0) {
				bloquearCampos();
			}
		}				
	}
	
	private void clear() {
		carrito= new ArrayList<Producto>();
		cliente=null;
		productoSeleccionado=null;
		txtNombreC.setText("");
		txtTelefonoC.setText("");
		btnAbrirProducto.setEnabled(false);
		btnAgregarProducto.setEnabled(false);
		btnEliminarProducto.setEnabled(false);
		btnAccion.setEnabled(false);
		cargarCarrito();
	}	
	private void cargarOrden() {
		cliente=ordenVenta.getCliente();
		txtNombreC.setText(cliente.getNombre());
		txtTelefonoC.setText(cliente.getTelefono());
		txtCedula.setText(cliente.getCedula());
		txtCedula.setEnabled(false);
		carrito=new ArrayList<Producto>();
		carrito.addAll(ordenVenta.getProductos());
		btnBuscar.setEnabled(false);
		btnAgregarProducto.setEnabled(true);
		spnFecha.setValue(ordenVenta.getFecha());
		cbxPlazoPago.setSelectedIndex(ordenVenta.getPlazoPago());
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
		txtCedula.setEnabled(false);
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
				rowsProductos[3]=x.getPrecio();
				rowsProductos[4]="$ "+x.getCantidad()*x.getPrecio();
				montoTotal+=x.getCantidad()*x.getPrecio();
				modelProductos.addRow(rowsProductos);
			}
		}
		txtMontoTotal.setText("$ "+montoTotal);
	}
}
