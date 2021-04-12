package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logic.Tienda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class IniciarSesion extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream tienda;
				FileOutputStream tienda2;
				ObjectInputStream read;
				ObjectOutputStream write;
				try {
					tienda=new FileInputStream("data.dat");
					read=new ObjectInputStream(tienda);
					Tienda temp = (Tienda)read.readObject();
					Tienda.setTienda(temp);
					tienda.close();
					read.close();
				} catch (FileNotFoundException e) {
					try {
						tienda2 = new FileOutputStream("data.dat");
						write = new ObjectOutputStream(tienda2);
						Tienda.getInstance().generarAdministrador("0000", "Administrador", "0000", "0000", 0, 0, "admin", "1234");
						Tienda.getInstance().generarVendedor("0000", "Vendedor", "0000", "0000", 0, 0, "vendedor", "1234");						
						write.writeObject(Tienda.getInstance());
						tienda2.close();
						write.close();
					} catch (FileNotFoundException e1){
					} catch (IOException e1) {
					}
				} catch (IOException e) {
				} catch (ClassNotFoundException e) {
				} 
				
				try {
					IniciarSesion iniciarSesion = new IniciarSesion();
					iniciarSesion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IniciarSesion() {
		setTitle("Cecomsa - Iniciar Sesion");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/resources/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(21, 36, 46, 14);
		panel.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(21, 63, 86, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setBounds(21, 119, 86, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(18, 218, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Entrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Tienda.getInstance().iniciarSesion(txtUsuario.getText(), txtContraseña.getText())) {
					dispose();
					Principal principal = new Principal();
					principal.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,"Error: Usuario o Contraseña invalidos","Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton_1.setBounds(117, 218, 89, 23);
		panel.add(btnNewButton_1);
		
		txtContraseña = new JTextField();
		txtContraseña.setBounds(21, 187, 86, 20);
		panel.add(txtContraseña);
		txtContraseña.setColumns(10);
	}

}
