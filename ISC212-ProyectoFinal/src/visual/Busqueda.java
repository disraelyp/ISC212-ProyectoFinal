package visual;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Cliente;
import logic.Componente;
import logic.Empleado;
import logic.PaqueteComponentes;
import logic.Proveedor;
import logic.Tienda;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Busqueda extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;

	public Busqueda(int tipoDocumento, int tipoFuncion, String codigo) {
		/*
		 * Tipos de Documentos:
		 * 	0: Orden de compra
		 * 	1: Cotizaciones de inventario
		 * 	2: Devoluciones de inventario
		 * 	3: Productos
		 * 	4: Paquete de productos
		 * 	5: Factura
		 * 	6: Cotizacion de una factura
		 * 	7: Devolucion de una factura
		 *  8: Clientes
		 *  9: Proveedores
		 *  10:Empleados
		 * 
		 * Tipos de Funciones:
		 * 	0: Modificar
		 * 	1: Duplicar
		 * 	2: Abrir
		 * 	3: Eliminar
		 * 	4: Convertir
		 * 	5: Procesar
		 * 	6: Pagar o cobrar
		 */
		
		String nombreDocumento="";
		String Funcion="";
		
		switch(tipoDocumento) {
		case 0:
			nombreDocumento="ordenes de Compra.";
			break;
		case 1:
			nombreDocumento="cotizaciones de inventario.";
			break;
		case 2:
			nombreDocumento="devoluciones de inventario.";
			break;
		case 3:
			nombreDocumento="componentes.";
			break;
		case 4:
			nombreDocumento="paquete de componentes.";
			break;
		case 5:
			nombreDocumento="facturas.";
			break;
		case 6:
			nombreDocumento="cotizacion de ventas.";
			break;
		case 7:
			nombreDocumento="devolucion de ventas.";
			break;
		case 8:
			nombreDocumento="clientes.";
			break;
		case 9:
			nombreDocumento="proveedores.";
			break;
		case 10:
			nombreDocumento="empleados.";
			break;
		}
		
		switch(tipoFuncion) {
		case 0:
			Funcion="Modificar";
			break;
		case 1:
			Funcion="Duplicar";
			break;
		case 2:
			Funcion="Abrir";
			break;
		case 3:
			Funcion="Eliminar";
			break;
		case 4:
			Funcion="Convertir";
			break;
		case 5:
			Funcion="Procesar";
			break;
		}
		
		setTitle("Busqueda para "+Funcion+" "+nombreDocumento);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/resources/logo.png")));
		setBounds(100, 100, 340, 250);
		setLocationRelativeTo(null);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Codigo:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel.setBounds(20, 31, 95, 19);
			panel.add(lblNewLabel);
			
			txtCodigo = new JTextField();
			txtCodigo.setText(codigo);
			txtCodigo.setBounds(20, 61, 275, 25);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon(Busqueda.class.getResource("/resources/cancelar.png")));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton.setBounds(154, 121, 70, 70);
			panel.add(btnNewButton);
			
			JButton btnAceptar = new JButton("");
			btnAceptar.setIcon(new ImageIcon(Busqueda.class.getResource("/resources/aceptar.png")));
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch(tipoDocumento) {
					case 0:
						//nombreDocumento="Orden de Compra";
						if(Tienda.getInstance().verificarOrdenInventario(txtCodigo.getText())) {
							switch(tipoFuncion) {
							case 0:
								//MODIFICAR
								if(Tienda.getInstance().buscarCompraInventario(txtCodigo.getText()).isRecibida()){
									JOptionPane.showMessageDialog(null, "La orden ("+txtCodigo.getText()+") ya fue recibida, para hacer cambios realiza una devolucion.", "Error", JOptionPane.ERROR_MESSAGE);
									dispose();
								} else {
									RegistroCompra registroCompra = new RegistroCompra(Tienda.getInstance().buscarCompraInventario(txtCodigo.getText()), 0, 0);
									dispose();
									registroCompra.setVisible(true);
								}
								break;
							case 2:
								// ABRIR
								RegistroCompra registroCompra = new RegistroCompra(Tienda.getInstance().buscarCompraInventario(txtCodigo.getText()), 1, 0);
								dispose();
								registroCompra.setVisible(true);
								break;
							case 3:
								// ELIMINAR
								if(Tienda.getInstance().buscarCompraInventario(txtCodigo.getText()).isRecibida()) {
									JOptionPane.showMessageDialog(null, "La orden ("+txtCodigo.getText()+") ya fue recibida, para hacer cambios realiza una devolucion.", "Error", JOptionPane.ERROR_MESSAGE);
									dispose();
								} else {
									RegistroCompra registroCompra1 = new RegistroCompra(Tienda.getInstance().buscarCompraInventario(txtCodigo.getText()), 2, 0);
									dispose();
									registroCompra1.setVisible(true);
								}
								break;
							case 4:
								// CONVERTIR
								if(Tienda.getInstance().buscarCompraInventario(txtCodigo.getText()).isRecibida()) {
									RegistroCompra registroCompra1 = new RegistroCompra(Tienda.getInstance().buscarCompraInventario(txtCodigo.getText()), 3, 0);
									dispose();
									registroCompra1.setVisible(true);
								} else {
									JOptionPane.showMessageDialog(null, "La orden ("+txtCodigo.getText()+") no esta recibida, no es necesario emitir una devolucion.", "Error", JOptionPane.ERROR_MESSAGE);
									dispose();
								}
								break;
							case 5:
								// PROCESAR
								if(Tienda.getInstance().buscarCompraInventario(txtCodigo.getText()).isRecibida()){
									JOptionPane.showMessageDialog(null, "La orden ("+txtCodigo.getText()+") no se puede recibir multiples veces.", "Error", JOptionPane.ERROR_MESSAGE);
								} else {
									dispose();
									if (JOptionPane.showConfirmDialog(null, "¿Quieres recibir esta orden en tu inventario?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
										Tienda.getInstance().recibirCompraInventario(txtCodigo.getText());
									}
								}
								dispose();
								break;
							case 6:
								// PAGAR
								if(!Tienda.getInstance().buscarCompraInventario(txtCodigo.getText()).isRecibida()) {
									JOptionPane.showMessageDialog(null, "La orden (Codigo: "+txtCodigo.getText()+") no se puede pagar sin antes recibirla al inventario.", "Error", JOptionPane.ERROR_MESSAGE);
								} else {
									if(Tienda.getInstance().buscarCompraInventario(txtCodigo.getText()).getPlazoPago()==0){
										JOptionPane.showMessageDialog(null, "La orden (Codigo: "+txtCodigo.getText()+") no se puede pagar multiple veces.", "Error", JOptionPane.ERROR_MESSAGE);
										Tienda.getInstance().buscarCompraInventario(txtCodigo.getText()).setPagada(true);
									} else {
										dispose();
										if (JOptionPane.showConfirmDialog(null, "¿Quieres pagar esta orden de compra?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
											Tienda.getInstance().buscarCompraInventario(txtCodigo.getText()).setPagada(true);
										}
										JOptionPane.showMessageDialog(null, "Se realizo el pago de la orden (Codigo: "+txtCodigo.getText()+") exitosamente.", "Error", JOptionPane.ERROR_MESSAGE);
									}
								}
								dispose();
								break;
							}
						} else {
							JOptionPane.showMessageDialog(null, "El codigo ("+txtCodigo.getText()+") ingresado no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						break;
					case 1:
						//nombreDocumento="Cotizacion de inventario";
						if(Tienda.getInstance().verificarCotizacionInventario(txtCodigo.getText())) {
							switch(tipoFuncion) {
							case 0:
								// MODIFICAR
								RegistroCompra registroCompra = new RegistroCompra(Tienda.getInstance().buscarCotizacionInventario(txtCodigo.getText()), 0, 2);
								dispose();
								registroCompra.setVisible(true);
								break;
							case 2:
								// ABRIR
								RegistroCompra registroCompra1 = new RegistroCompra(Tienda.getInstance().buscarCotizacionInventario(txtCodigo.getText()), 1, 2);
								dispose();
								registroCompra1.setVisible(true);
								break;
							case 3:
								// ELIMINAR
								RegistroCompra registroCompra2 = new RegistroCompra(Tienda.getInstance().buscarCotizacionInventario(txtCodigo.getText()), 2, 2);
								dispose();
								registroCompra2.setVisible(true);
								break;
							case 4:
								// CONVERTIR
								RegistroCompra registroCompra3 = new RegistroCompra(Tienda.getInstance().buscarCotizacionInventario(txtCodigo.getText()), 3, 2);
								dispose();
								registroCompra3.setVisible(true);
								break;
							}
						} else {
							JOptionPane.showMessageDialog(null, "El codigo ("+txtCodigo.getText()+") ingresado no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						break;
					case 2:
						//nombreDocumento="Devolucion de inventario";
						if(Tienda.getInstance().verificarDevolucionInventario(txtCodigo.getText())) {
							switch(tipoFuncion) {
							case 0:
								// MODIFICAR
								if(Tienda.getInstance().buscarDevolucionInventario(txtCodigo.getText()).isRetirada()) {
									JOptionPane.showMessageDialog(null, "La devolucion (Codigo: "+txtCodigo.getText()+") no puede ser modificada debido a que ya a sido retirada.", "Error", JOptionPane.ERROR_MESSAGE);
								} else {
									RegistroCompra registroCompra = new RegistroCompra(Tienda.getInstance().buscarDevolucionInventario(txtCodigo.getText()), 0, 1);
									dispose();
									registroCompra.setVisible(true);
								}
								break;
							case 2:
								// ABRIR
								RegistroCompra registroCompra1 = new RegistroCompra(Tienda.getInstance().buscarDevolucionInventario(txtCodigo.getText()), 1, 1);
								dispose();
								registroCompra1.setVisible(true);
								break;
							case 3:
								// ELIMINAR
								if(Tienda.getInstance().buscarDevolucionInventario(txtCodigo.getText()).isRetirada()) {
									JOptionPane.showMessageDialog(null, "La devolucion (Codigo: "+txtCodigo.getText()+") no puede ser eliminada debido a que ya a sido retirada.", "Error", JOptionPane.ERROR_MESSAGE);
								} else {
									RegistroCompra registroCompra2 = new RegistroCompra(Tienda.getInstance().buscarDevolucionInventario(txtCodigo.getText()), 2, 1);
									dispose();
									registroCompra2.setVisible(true);
								}
								break;
							case 5:
								// PROCESAR
								if(Tienda.getInstance().buscarDevolucionInventario(txtCodigo.getText()).isRetirada()){
									JOptionPane.showMessageDialog(null, "La devolucion (Codigo: "+txtCodigo.getText()+") no se puede retirada multiples veces.", "Error", JOptionPane.ERROR_MESSAGE);
								} else {
									dispose();
									if (JOptionPane.showConfirmDialog(null, "¿Quieres retirar esta devolucion en tu inventario?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
										if(Tienda.getInstance().isRetirableDevolucionInventario(txtCodigo.getText())) {
											Tienda.getInstance().retirarDevolucionInventario(txtCodigo.getText());
										} else {
											JOptionPane.showMessageDialog(null, "No tienes inventario suficiente para retirar la devolucion (Codigo: "+txtCodigo.getText()+").", "Error", JOptionPane.ERROR_MESSAGE);
										}
									}
								}
								dispose();
								break;
							}
						} else {
							JOptionPane.showMessageDialog(null, "El codigo ("+txtCodigo.getText()+") ingresado no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						break;
					case 3:
						// COMPONENTES
						if(Tienda.getInstance().verificarProducto(txtCodigo.getText())) {
							Componente producto = Tienda.getInstance().buscarComponente(txtCodigo.getText());
							switch(tipoFuncion) {
							case 0:
								// Modificar
								RegistroComponente registroComponente = new RegistroComponente(producto, 0);
								dispose();
								registroComponente.setVisible(true);
								break;
							case 2:
								// Abrir
								RegistroComponente registroComponente1 = new RegistroComponente(producto, 1);
								dispose();
								registroComponente1.setVisible(true);
								break;
							case 3:
								// Eliminar
								RegistroComponente registroComponente2 = new RegistroComponente(producto, 2);
								dispose();
								registroComponente2.setVisible(true);
								break;
							}
						} else {
							JOptionPane.showMessageDialog(null, "El codigo ("+txtCodigo.getText()+") ingresado no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						break;
					case 4:
						// PAQUETES DE COMPONENTES
						if(Tienda.getInstance().verificarProducto(txtCodigo.getText())) {
							PaqueteComponentes producto = Tienda.getInstance().buscarPaqueteComponentes(txtCodigo.getText());
							switch(tipoFuncion) {
							case 0:
								// Modificar
								RegistroPaqueteComponentes registroPaqueteComponentes = new RegistroPaqueteComponentes(producto, 0);
								dispose();
								registroPaqueteComponentes.setVisible(true);
								break;
							case 2:
								// Abrir
								RegistroPaqueteComponentes registroPaqueteComponentes1 = new RegistroPaqueteComponentes(producto, 1);
								dispose();
								registroPaqueteComponentes1.setVisible(true);
								break;
							case 3:
								// Eliminar
								RegistroPaqueteComponentes registroPaqueteComponentes2 = new RegistroPaqueteComponentes(producto, 2);
								dispose();
								registroPaqueteComponentes2.setVisible(true);
								break;
							}
						} else {
							JOptionPane.showMessageDialog(null, "El codigo ("+txtCodigo.getText()+") ingresado no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						break;	
					case 5:
						if(Tienda.getInstance().verificarFacturaVenta(txtCodigo.getText())) {
							switch(tipoFuncion) {
							case 2:
								// ABRIR
								RegistroVenta registroVenta = new RegistroVenta(Tienda.getInstance().buscarFacturaVenta(txtCodigo.getText()), 1, 0);
								dispose();
								registroVenta.setVisible(true);
								break;
							case 4:
								// CONVERTIR
								RegistroVenta registroVenta1 = new RegistroVenta(Tienda.getInstance().buscarFacturaVenta(txtCodigo.getText()), 3, 0);
								dispose();
								registroVenta1.setVisible(true);
								break;
							case 6:
								// PAGAR
								if(Tienda.getInstance().buscarFacturaVenta(txtCodigo.getText()).getPlazoPago()==0 || Tienda.getInstance().buscarFacturaVenta(txtCodigo.getText()).isPagada()){
									JOptionPane.showMessageDialog(null, "La orden (Codigo: "+txtCodigo.getText()+") no se puede pagar multiple veces.", "Error", JOptionPane.ERROR_MESSAGE);
									Tienda.getInstance().buscarFacturaVenta(txtCodigo.getText()).setPagada(true);
								} else {
									dispose();
									if (JOptionPane.showConfirmDialog(null, "¿Quieres pagar esta factura de venta?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
										Tienda.getInstance().buscarFacturaVenta(txtCodigo.getText()).setPagada(true);
									}
									JOptionPane.showMessageDialog(null, "Se realizo el pago de la factura (Codigo: "+txtCodigo.getText()+") exitosamente.", "Error", JOptionPane.ERROR_MESSAGE);
								}
								dispose();
								break;
							}
						} else {
							JOptionPane.showMessageDialog(null, "El codigo ("+txtCodigo.getText()+") ingresado no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						break;
					case 6:
						//nombreDocumento="Cotizacion de una factura";
						if(Tienda.getInstance().verificarCotizacionVenta(txtCodigo.getText())) {
							switch(tipoFuncion) {
							case 0:
								// MODIFICAR
								RegistroVenta registroVenta = new RegistroVenta(Tienda.getInstance().buscarCotizacionVenta(txtCodigo.getText()), 0, 2);
								dispose();
								registroVenta.setVisible(true);
								break;
							case 2:
								// ABRIR
								RegistroVenta registroVenta1 = new RegistroVenta(Tienda.getInstance().buscarCotizacionVenta(txtCodigo.getText()), 1, 2);
								dispose();
								registroVenta1.setVisible(true);
								break;
							case 3:
								// ELIMINAR
								RegistroVenta registroVenta2 = new RegistroVenta(Tienda.getInstance().buscarCotizacionVenta(txtCodigo.getText()), 2, 2);
								dispose();
								registroVenta2.setVisible(true);
								break;
							case 4:
								// CONVERTIR
								RegistroVenta registroVenta3 = new RegistroVenta(Tienda.getInstance().buscarCotizacionVenta(txtCodigo.getText()), 3, 2);
								dispose();
								registroVenta3.setVisible(true);
								break;
							}
						} else {
							JOptionPane.showMessageDialog(null, "El codigo ("+txtCodigo.getText()+") ingresado no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						break;
					case 7:
						if(Tienda.getInstance().verificarDevolucionVenta(txtCodigo.getText())) {
							switch(tipoFuncion) {
							case 0:
								// MODIFICAR
								if(Tienda.getInstance().buscarDevolucionVenta(txtCodigo.getText()).isRecibida()) {
									JOptionPane.showMessageDialog(null, "La devolucion (Codigo: "+txtCodigo.getText()+") no puede ser modificada debido a que ya a sido recibida.", "Error", JOptionPane.ERROR_MESSAGE);
								} else {
									RegistroVenta registroVenta = new RegistroVenta(Tienda.getInstance().buscarDevolucionVenta(txtCodigo.getText()), 0, 1);
									dispose();
									registroVenta.setVisible(true);
								}
								break;
							case 2:
								// ABRIR
								RegistroVenta registroVenta = new RegistroVenta(Tienda.getInstance().buscarDevolucionVenta(txtCodigo.getText()), 1, 1);
								dispose();
								registroVenta.setVisible(true);
								break;
							case 3:
								// ELIMINAR
								if(Tienda.getInstance().buscarDevolucionVenta(txtCodigo.getText()).isRecibida()) {
									JOptionPane.showMessageDialog(null, "La devolucion (Codigo: "+txtCodigo.getText()+") no puede ser eliminada debido a que ya a sido recibida.", "Error", JOptionPane.ERROR_MESSAGE);
								} else {
									RegistroVenta registroVenta2 = new RegistroVenta(Tienda.getInstance().buscarDevolucionVenta(txtCodigo.getText()), 2, 1);
									dispose();
									registroVenta2.setVisible(true);
								}
								break;
							case 5:
								// PROCESAR
								if(Tienda.getInstance().buscarDevolucionVenta(txtCodigo.getText()).isRecibida()) {
									JOptionPane.showMessageDialog(null, "La devolucion (Codigo: "+txtCodigo.getText()+") no se puede recibir multiples veces.", "Error", JOptionPane.ERROR_MESSAGE);
								} else {
									dispose();
									if (JOptionPane.showConfirmDialog(null, "¿Quieres recibir esta devolucion a tu inventario?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
										Tienda.getInstance().recibirDevolucionVenta(txtCodigo.getText());
									}
								}
								dispose();
								break;
							}
						} else {
							JOptionPane.showMessageDialog(null, "El codigo ("+txtCodigo.getText()+") ingresado no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						break;						
					case 8:
						// CLIENTES
						if(Tienda.getInstance().verificarCliente(txtCodigo.getText())) {
							Cliente cliente = Tienda.getInstance().buscarCliente(txtCodigo.getText());
							switch(tipoFuncion) {
							case 0:
								// Modificar
								RegistroCliente registroCliente0 = new RegistroCliente(cliente, 0);
								dispose();
								registroCliente0.setVisible(true);
								break;
							case 2:
								// Abrir
								RegistroCliente registroCliente1 = new RegistroCliente(cliente, 1);
								dispose();
								registroCliente1.setVisible(true);
								break;
							case 3:
								// Eliminar
								RegistroCliente registroCliente2 = new RegistroCliente(cliente, 2);
								dispose();
								registroCliente2.setVisible(true);
								break;
							}
						} else {
							JOptionPane.showMessageDialog(null, "La cedula ("+txtCodigo.getText()+") ingresada no fue encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						break;
					case 9:
						// PROVEEDOR
						if(Tienda.getInstance().verificarRnc(txtCodigo.getText())) {
							Proveedor proveedor = Tienda.getInstance().buscarProveedor(txtCodigo.getText());
							switch(tipoFuncion) {
							case 0:
								// Modificar
								RegistroProveedor registroProveedor0 = new RegistroProveedor(proveedor, 0);
								dispose();
								registroProveedor0.setVisible(true);
								break;
							case 2:
								// Abrir
								RegistroProveedor registroProveedor1 = new RegistroProveedor(proveedor, 1);
								dispose();
								registroProveedor1.setVisible(true);
								break;
							case 3:
								// Eliminar
								RegistroProveedor registroProveedor2 = new RegistroProveedor(proveedor, 2);
								dispose();
								registroProveedor2.setVisible(true);
								break;
							}
						} else {
							JOptionPane.showMessageDialog(null, "El RNC ("+txtCodigo.getText()+") ingresado no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						break;
					case 10:
						// EMPLEADO
						if(Tienda.getInstance().verificarEmpleado(txtCodigo.getText())) {
							Empleado empleado = Tienda.getInstance().buscarEmpleado(txtCodigo.getText());
							switch(tipoFuncion) {
							case 0:
								// Modificar
								RegistroEmpleado registroEmpleado0 = new RegistroEmpleado(empleado, 0);
								dispose();
								registroEmpleado0.setVisible(true);
								break;
							case 2:
								// Abrir
								RegistroEmpleado registroEmpleado1 = new RegistroEmpleado(empleado, 1);
								dispose();
								registroEmpleado1.setVisible(true);
								break;
							case 3:
								// Eliminar
								RegistroEmpleado registroEmpleado2 = new RegistroEmpleado(empleado, 2);
								dispose();
								registroEmpleado2.setVisible(true);
								break;
							}
						} else {
							JOptionPane.showMessageDialog(null, "El codigo ("+txtCodigo.getText()+") ingresado no fue encontrado,", "Error", JOptionPane.ERROR_MESSAGE);
						}
						break;
					}	
				}
			});
			btnAceptar.setBounds(234, 121, 70, 70);
			panel.add(btnAceptar);
		}
	}
}
