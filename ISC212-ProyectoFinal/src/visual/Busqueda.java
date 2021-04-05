package visual;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Tienda;

import javax.swing.JTextField;
import javax.swing.JLabel;
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
			nombreDocumento="Orden de Compra";
			break;
		case 1:
			nombreDocumento="Cotizacion de inventario";
			break;
		case 2:
			nombreDocumento="Devolucion de inventario";
			break;
		case 3:
			nombreDocumento="Componente";
			break;
		case 4:
			nombreDocumento="Paquete de componentes";
			break;
		case 5:
			nombreDocumento="Factura";
			break;
		case 6:
			nombreDocumento="Cotizacion de venta";
			break;
		case 7:
			nombreDocumento="Devolucion de venta";
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
		
		
		
		setTitle(nombreDocumento+"-"+Funcion);
		setBounds(100, 100, 340, 250);
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
					}
				}
			});
			btnAceptar.setBounds(234, 121, 70, 70);
			panel.add(btnAceptar);
		}
	}
}
