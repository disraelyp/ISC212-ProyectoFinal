package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logic.Proveedor;
import logic.Tienda;

public class RegistroProveedor extends JDialog {

	private static Proveedor proveedor=null;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtRNC;
	private JTextField txtNombreE;
	private JTextField txtTelefonoE;
	private JTextField txtDireccionE;
	private JTextField txtNombreR;
	private JTextField txtTelefonoR;
	private JButton btnAccion;

	public RegistroProveedor(Proveedor aux, int funcion) {
		
		proveedor=aux;
		if(proveedor == null) {
			setTitle("Registro de Clientes");
		} else {
			if(funcion==0) {
				setTitle("Modificador de Clientes (Cedula:"+proveedor.getRnc()+")");
			}  else {
				if(funcion==1) {
					setTitle("Ver cliente (Cedula:"+proveedor.getRnc()+")");
				} else {
					setTitle("Eliminar cliente (Cedula:"+proveedor.getRnc()+")");
				}
			}
		}
		
		setBounds(100, 100, 400, 360);
		setModal(true);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panelEmpresa = new JPanel();
			panelEmpresa.setBorder(new TitledBorder(null, "Datos de la Empresa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelEmpresa.setBounds(10, 11, 364, 155);
			contentPanel.add(panelEmpresa);
			panelEmpresa.setLayout(null);
			{
				JLabel label = new JLabel("RNC:");
				label.setBounds(10, 30, 68, 14);
				panelEmpresa.add(label);
			}
			{
				txtRNC = new JTextField();			
				txtRNC.setColumns(10);
				txtRNC.setBounds(73, 27, 132, 20);
				if(aux!=null){
					txtRNC.setEnabled(false);
				}	
				panelEmpresa.add(txtRNC);
			}
			{
				JLabel label = new JLabel("Nombre:");
				label.setBounds(10, 58, 108, 14);
				panelEmpresa.add(label);
			}
			{
				txtNombreE = new JTextField();
				txtNombreE.setColumns(10);
				txtNombreE.setBounds(73, 55, 262, 20);
				panelEmpresa.add(txtNombreE);
			}
			{
				JLabel label = new JLabel("Tel\u00E9fono:");
				label.setBounds(10, 89, 108, 14);
				panelEmpresa.add(label);
			}
			{
				txtTelefonoE = new JTextField();
				txtTelefonoE.setColumns(10);
				txtTelefonoE.setBounds(73, 86, 262, 20);
				panelEmpresa.add(txtTelefonoE);
			}
			{
				JLabel label = new JLabel("Direcci\u00F3n:");
				label.setBounds(10, 117, 108, 14);
				panelEmpresa.add(label);
			}
			{
				txtDireccionE = new JTextField();
				txtDireccionE.setText("");
				txtDireccionE.setColumns(10);
				txtDireccionE.setBounds(73, 114, 262, 20);
				panelEmpresa.add(txtDireccionE);
			}
			{
				JPanel panelRepresentante = new JPanel();
				panelRepresentante.setBorder(new TitledBorder(null, "Informacion del representante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelRepresentante.setBounds(10, 177, 364, 100);
				contentPanel.add(panelRepresentante);
				panelRepresentante.setLayout(null);
				
				JLabel lblNombreR = new JLabel("Nombre:");
				lblNombreR.setBounds(10, 27, 74, 14);
				panelRepresentante.add(lblNombreR);
				
				txtNombreR = new JTextField();
				txtNombreR.setBounds(73, 24, 262, 20);
				panelRepresentante.add(txtNombreR);
				txtNombreR.setColumns(10);
				
				txtTelefonoR = new JTextField();
				txtTelefonoR.setColumns(10);
				txtTelefonoR.setBounds(73, 52, 262, 20);
				panelRepresentante.add(txtTelefonoR);
				
				JLabel lblTelefonoR = new JLabel("Tel\u00E9fono:");
				lblTelefonoR.setBounds(10, 55, 74, 14);
				panelRepresentante.add(lblTelefonoR);
			}
			
			JPanel panelBotones = new JPanel();
			panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(panelBotones, BorderLayout.SOUTH);
			{
				if(proveedor == null) {
					btnAccion = new JButton("Registrar");
				} else {
					if(funcion==0) {
						btnAccion = new JButton("Modificar");
						txtRNC.setEnabled(false);
					}  else {
						if(funcion==2) {
							btnAccion = new JButton("Eliminar");
						} else {
							btnAccion = new JButton("Abrir");
							btnAccion.setVisible(false);
						}
					}
				}
				btnAccion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(aux == null) { 
							if(!(Tienda.getInstance().verificarRnc(txtRNC.getText()))) {
								Tienda.getInstance().generarProveedor(txtRNC.getText(), txtNombreE.getText(), txtTelefonoE.getText(), txtDireccionE.getText(), txtNombreR.getText(), txtTelefonoR.getText());
							} else {
								JOptionPane.showMessageDialog(null, "Este RNC ya pertenece a un proveedor registrado");
							}
							clean();
						} else {
							if(funcion==0) {
								Tienda.getInstance().modificarProveedor(txtRNC.getText(), txtNombreE.getText(), txtTelefonoE.getText(), txtDireccionE.getText(), txtNombreR.getText(), txtTelefonoR.getText() );
								dispose();
							}  else {
								if(funcion==2) {
									Tienda.getInstance().eliminarProveedor(proveedor.getRnc());
									dispose();
								}
							}
						}
					}
				});
				panelBotones.add(btnAccion);
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				panelBotones.add(btnSalir);
			}
		}
		if(proveedor != null) {
			if(funcion!=0) {
				bloquearCampos();
			}
			cargarProveedor();
		}
	}
	
	private void bloquearCampos() {
		txtRNC.setEnabled(false);
		txtNombreE.setEnabled(false);
		txtTelefonoE.setEnabled(false);
		txtDireccionE.setEnabled(false);
		txtNombreR.setEnabled(false);
		txtTelefonoR.setEnabled(false);
	}
	private void cargarProveedor() {
		txtRNC.setText(proveedor.getRnc());
		txtNombreE.setText(proveedor.getNombre());
		txtTelefonoE.setText(proveedor.getTelefono());
		txtDireccionE.setText(proveedor.getDireccion());
		txtNombreR.setText(proveedor.getNombreRepre());
		txtTelefonoR.setText(proveedor.getTelefonoRepre());
	}
	private void clean() {
		txtRNC.setText("");
		txtNombreE.setText("");
		txtTelefonoE.setText("");
		txtDireccionE.setText("");
		txtNombreR.setText("");
		txtTelefonoR.setText("");
	}
}

