package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import logic.Administrador;
import logic.Empleado;
import logic.Tienda;

import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistroEmpleado extends JDialog {

	private static Empleado empleado;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtUsuario;
	private JButton btnAccion;
	private JButton btnSalir;
	private JPasswordField txtContraseña;
	private JRadioButton rdbtnAdministrador;
	private JLabel lblSueldoBase;
	private JLabel lblComision;
	private JSpinner spnSueldoBase;
	private JSpinner spnComision;
	private JTextField txtContraseñaM;

	public RegistroEmpleado(Empleado aux, int funcion) {
		
		empleado=aux;
		if(empleado == null) {
			setTitle("Registro de Emokeadis");
		} else {
			if(funcion==0) {
				setTitle("Modificador de empleado (Codigo:"+empleado.getCodigo()+")");
			}  else {
				if(funcion==1) {
					setTitle("Ver Empleado (Codigo:"+empleado.getCodigo()+")");
				} else {
					setTitle("Eliminar empleado (Codigo:"+empleado.getCodigo()+")");
				}
			}
		}
		
		setBounds(100, 100, 400, 375);
		setModal(true);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel label = new JLabel("Direcci\u00F3n:");
				label.setBounds(11, 117, 108, 14);
				panel.add(label);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setText("");
				txtDireccion.setColumns(10);
				txtDireccion.setBounds(90, 114, 262, 20);
				panel.add(txtDireccion);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setColumns(10);
				txtTelefono.setBounds(90, 83, 262, 20);
				panel.add(txtTelefono);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setColumns(10);
				txtNombre.setBounds(90, 52, 262, 20);
				panel.add(txtNombre);
			}
			{
				txtCedula = new JTextField();
				txtCedula.setColumns(10);
				txtCedula.setBounds(90, 21, 262, 20);
				panel.add(txtCedula);
			}
			{
				JLabel label = new JLabel("C\u00E9dula:");
				label.setBounds(11, 24, 108, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Nombre:");
				label.setBounds(11, 55, 108, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Tel\u00E9fono:");
				label.setBounds(11, 86, 108, 14);
				panel.add(label);
			}
			{
				lblSueldoBase = new JLabel("Sueldo base:");
				lblSueldoBase.setBounds(11, 148, 108, 14);
				panel.add(lblSueldoBase);
			}
			{
				spnSueldoBase = new JSpinner();
				spnSueldoBase.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
				spnSueldoBase.setBounds(90, 145, 91, 20);
				panel.add(spnSueldoBase);
			}
			{
				JLabel lblUsuario = new JLabel("Usuario:");
				lblUsuario.setBounds(11, 203, 108, 14);
				panel.add(lblUsuario);
			}
			{
				txtUsuario = new JTextField();
				txtUsuario.setBounds(90, 200, 262, 20);
				panel.add(txtUsuario);
				txtUsuario.setColumns(10);
			}
			{
				JLabel lblContraseña = new JLabel("Contrase\u00F1a:");
				lblContraseña.setBounds(11, 234, 108, 14);
				panel.add(lblContraseña);
			}
			{
				lblComision = new JLabel("Comisi\u00F3n:");
				lblComision.setBounds(196, 148, 101, 14);
				panel.add(lblComision);
			}
			{
				spnComision = new JSpinner();
				spnComision.setModel(new SpinnerNumberModel(new Float(1), new Float(0), new Float(10), new Float(1)));
				spnComision.setBounds(258, 145, 91, 20);
				panel.add(spnComision);
			}
			
			rdbtnAdministrador = new JRadioButton("El Empleado es un Administrador");
			rdbtnAdministrador.setBounds(11, 255, 250, 23);
			panel.add(rdbtnAdministrador);
			
			txtContraseñaM = new JTextField();
			txtContraseñaM.setEditable(false);
			txtContraseñaM.setBounds(90, 231, 197, 20);
			panel.add(txtContraseñaM);
			txtContraseñaM.setColumns(10);
			txtContraseñaM.setVisible(false);
			
			txtContraseña = new JPasswordField();
			txtContraseña.setBounds(90, 231, 197, 20);
			panel.add(txtContraseña);
			
			JButton btnNewButton = new JButton("Ver");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					txtContraseñaM.setText(String.valueOf(txtContraseña.getPassword()));
					txtContraseñaM.setVisible(true);
					txtContraseña.setVisible(false);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					txtContraseñaM.setText("");
					txtContraseñaM.setVisible(false);
					txtContraseña.setVisible(true);
				}
			});
			btnNewButton.setBounds(297, 230, 55, 23);
			panel.add(btnNewButton);
			
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				if(empleado == null) {
					btnAccion = new JButton("Registrar");
				} else {
					if(funcion==0) {
						btnAccion = new JButton("Modificar");
						txtCedula.setEnabled(false);
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
						if(empleado == null) { 
							if(rdbtnAdministrador.isSelected()) {
								Tienda.getInstance().generarAdministrador(txtCedula.getText(), txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText(), (float) spnSueldoBase.getValue(), (float )spnComision.getValue(), txtUsuario.getText(), String.valueOf(txtContraseña.getPassword()));
							} else {
								Tienda.getInstance().generarVendedor(txtCedula.getText(), txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText(), (float) spnSueldoBase.getValue(), (float )spnComision.getValue(), txtUsuario.getText(), String.valueOf(txtContraseña.getPassword()));
							}
							clean();
						} else {
							if(funcion==0) {
								if(rdbtnAdministrador.isSelected()) {
									Tienda.getInstance().modificarEmpleado(empleado.getCodigo(), txtCedula.getText(), txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText(), (float) spnSueldoBase.getValue(), (float )spnComision.getValue(), txtUsuario.getText(), String.valueOf(txtContraseña.getPassword()));
								}
								dispose();
							}  else {
								if(funcion==2) {
									Tienda.getInstance().eliminarEmpleado(empleado.getCodigo());
									dispose();
								}
							}
						}
					}
				});
				buttonPane.add(btnAccion);
			}
			{
				btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btnSalir);
			}
		}
		if(empleado!=null) {
			if(funcion!=0) {
				bloquearCampos();
			}
			cargarEmpleado();
		}
	}

	private void clean() {
		txtCedula.setText(""); 
		txtNombre.setText(""); 
		txtTelefono.setText(""); 
		txtDireccion.setText(""); 
		spnSueldoBase.setValue(1);
		spnComision.setValue(1);
		txtUsuario.setText(""); 
		txtContraseña.setText("");
		rdbtnAdministrador.setSelected(false);
	}
	
	private void bloquearCampos() {
		txtCedula.setEnabled(false); 
		txtNombre.setEnabled(false);  
		txtTelefono.setEnabled(false); 
		txtDireccion.setEnabled(false); 
		spnSueldoBase.setEnabled(false); 
		spnComision.setEnabled(false); 
		txtUsuario.setEnabled(false); 
		txtContraseña.setEnabled(false);
		rdbtnAdministrador.setEnabled(false);
		
	}
	private void cargarEmpleado() {
		txtCedula.setText(empleado.getCedula()); 
		txtNombre.setText(empleado.getNombre()); 
		txtTelefono.setText(empleado.getTelefono()); 
		txtDireccion.setText(empleado.getDireccion()); 
		spnSueldoBase.setValue(empleado.getSueldo());
		spnComision.setValue(empleado.getComision());
		txtUsuario.setText(empleado.getUsuario()); 
		txtContraseña.setText(empleado.getContraseña());
		
		if(empleado instanceof Administrador) {
			rdbtnAdministrador.setSelected(true);
		} else {
			rdbtnAdministrador.setSelected(false);
		}
		rdbtnAdministrador.setEnabled(false);
	}
}



