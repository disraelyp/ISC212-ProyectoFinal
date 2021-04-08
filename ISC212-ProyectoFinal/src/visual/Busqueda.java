package visual;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Cliente;
import logic.Empleado;
import logic.Proveedor;
import logic.Tienda;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		 * 	6: Procesar
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
			
			JButton btnNewButton = new JButton("Cancelar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton.setBounds(154, 121, 70, 70);
			panel.add(btnNewButton);
			
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch(tipoDocumento) {
					case 0:
						//nombreDocumento="Orden de Compra";
						if(Tienda.getInstance().verificarOrdenInventario(txtCodigo.getText())) {
							switch(tipoFuncion) {
							case 0:
								//MODIFICAR
								break;
							case 1:
								Tienda.getInstance().duplicarCompraInventario(txtCodigo.getText());
								break;
							case 2:
								//ABRIR
								break;
							case 3:
								Tienda.getInstance().eliminarCompraInventario(txtCodigo.getText());
								break;
							case 4:
								Tienda.getInstance().compraInventarioToDevolucionInventario(txtCodigo.getText());
								break;
							case 5:
								Tienda.getInstance().recibirCompraInventario(txtCodigo.getText());
								break;
							}
						} else {
							//CODIGO NO ENCONTRADO
						}
						break;
					case 1:
						//nombreDocumento="Cotizacion de inventario";
						if(Tienda.getInstance().verificarCotizacionInventario(txtCodigo.getText())) {

						} else {

						}
						break;
					case 2:
						//nombreDocumento="Devolucion de inventario";
						if(Tienda.getInstance().verificarDevolucionInventario(txtCodigo.getText())) {

						} else {

						}
						break;
					case 3:
						//nombreDocumento="Componente";
						break;
					case 4:
						//nombreDocumento="Paquete de componentes";
						break;
					case 5:
						//nombreDocumento="Factura";
						break;
					case 6:
						//nombreDocumento="Cotizacion de venta";
						break;
					case 7:
						//nombreDocumento="Devolucion de venta";
						break;
					case 8:
						// CLIENTES
						if(!Tienda.getInstance().verificarCliente(codigo)) {
							Cliente cliente = Tienda.getInstance().buscarCliente(codigo);
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
							JOptionPane.showMessageDialog(null, "La cedula ("+codigo+") ingresada no fue encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						break;
					case 9:
						// PROVEEDOR
						if(!(Tienda.getInstance().verificarRnc(codigo))) {
							Proveedor proveedor = Tienda.getInstance().buscarProveedor(codigo);
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
							JOptionPane.showMessageDialog(null, "El RNC ("+codigo+") ingresado no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						break;
					case 10:
						if(!(Tienda.getInstance().verificarEmpleado(codigo))) {
							Empleado empleado = Tienda.getInstance().buscarEmpleado(codigo);
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
							JOptionPane.showMessageDialog(null, "El codigo ("+codigo+") ingresado no fue encontrado,", "Error", JOptionPane.ERROR_MESSAGE);
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
