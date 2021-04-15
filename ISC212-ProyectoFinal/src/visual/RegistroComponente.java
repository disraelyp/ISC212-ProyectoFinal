package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logic.Componente;
import logic.DiscoDuro;
import logic.MemoriaRAM;
import logic.Microprocesador;
import logic.TarjetaMadre;
import logic.Tienda;

public class RegistroComponente extends JDialog {

	private static Componente componente=null;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JRadioButton rdbtnTarjetaMadre;
	private JRadioButton rdbtnMicro;
	private JRadioButton rdbtnDiscoDuro;
	private JRadioButton rdbtnMemoriaRAM;
	private JPanel panelTarjetaMadre;
	private JPanel panelMicro;
	private JPanel panelMemoriaRAM;
	private JPanel panelDiscoDuro;
	private JButton btnAccion;
	private JSpinner spnCantidad;
	private JSpinner spnCantMin;
	private JSpinner spnCosto;
	private JSpinner spnPrecio;
	private JComboBox<String> cbxTipoMicroprocesadorTM;
	private JComboBox<String> cbxTipoMemoriaRamTM;
	private JComboBox<String> cbxConexionMP;
	private JSpinner spnVelocidadMP;
	private JSpinner spnNucleosMP;
	private JSpinner spnCapacidadRAM;
	private JSpinner spnFrecuenciaRM;
	private JComboBox<String> cbxTipoMemoriaRamRM;
	private JSpinner spnCapacidadDD;
	private JSpinner spnVelocidadDD;
	private JComboBox<String> cbxConexionDD;
	private JSpinner spnCantRpm;
	private JButton btnSalir;
	private JLabel lblMHz;
	private JRadioButton rdbtnIDE;
	private JRadioButton rdbtnSATA3;
	private JRadioButton rdbtnSATA;
	private JRadioButton rdbtnSATA2;

	public RegistroComponente(Componente aux, int funcion) {
		
		componente=aux;
		if(componente == null) {
			setTitle("Registro de Componentes");
		} else {
			if(funcion==0) {
				setTitle("Modificador de Componentes (Codigo:"+componente.getCodigo()+")");
			}  else {
				if(funcion==1) {
					setTitle("Ver Componente (Codigo:"+componente.getCodigo()+")");
				} else {
					setTitle("Eliminar Componente (Codigo:"+componente.getCodigo()+")");
				}
			}
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/resources/logo.png")));
		setBounds(100, 100, 580, 390);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 554, 307);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JPanel panelGeneral = new JPanel();
				panelGeneral.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panelGeneral.setBounds(10, 11, 534, 96);
				panel.add(panelGeneral);
				panelGeneral.setLayout(null);
				
				JLabel lblModelo = new JLabel("Modelo:");
				lblModelo.setBounds(10, 14, 46, 14);
				panelGeneral.add(lblModelo);
				
				txtModelo = new JTextField();
				txtModelo.setBounds(58, 11, 185, 20);
				panelGeneral.add(txtModelo);
				txtModelo.setColumns(10);
				
				JLabel lblMarca = new JLabel("Marca:");
				lblMarca.setBounds(10, 42, 46, 14);
				panelGeneral.add(lblMarca);
				
				txtMarca = new JTextField();
				txtMarca.setBounds(58, 39, 185, 20);
				panelGeneral.add(txtMarca);
				txtMarca.setColumns(10);
				
				JLabel lblCantidad = new JLabel("Cantidad:");
				lblCantidad.setBounds(10, 70, 65, 14);
				panelGeneral.add(lblCantidad);
				
				spnCantidad = new JSpinner();
				spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
				spnCantidad.setBounds(68, 67, 175, 20);
				panelGeneral.add(spnCantidad);
				
				JLabel lblMinima = new JLabel("Cant. M\u00EDnima:");
				lblMinima.setBounds(278, 70, 101, 14);
				panelGeneral.add(lblMinima);
				
				spnCantMin = new JSpinner();
				spnCantMin.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
				spnCantMin.setBounds(374, 67, 150, 20);
				panelGeneral.add(spnCantMin);
				
				JLabel lblCosto = new JLabel("Costo:");
				lblCosto.setBounds(278, 14, 101, 14);
				panelGeneral.add(lblCosto);
				
				JLabel lblPrecio = new JLabel("Precio:");
				lblPrecio.setBounds(278, 42, 78, 14);
				panelGeneral.add(lblPrecio);
				
				spnCosto = new JSpinner();
				spnCosto.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(0.5)));
				spnCosto.setBounds(339, 11, 185, 20);
				panelGeneral.add(spnCosto);
				
				spnPrecio = new JSpinner();
				spnPrecio.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(0.5)));
				spnPrecio.setBounds(339, 39, 185, 20);
				panelGeneral.add(spnPrecio);
			}
			
			JPanel panelTipo = new JPanel();
			panelTipo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelTipo.setBounds(10, 112, 534, 58);
			panel.add(panelTipo);
			panelTipo.setLayout(null);
			
			rdbtnTarjetaMadre = new JRadioButton("Tarjeta Madre");
			rdbtnTarjetaMadre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarTarjetaMadre();
				}
			});
			rdbtnTarjetaMadre.setSelected(true);
			rdbtnTarjetaMadre.setBounds(11, 17, 110, 23);
			panelTipo.add(rdbtnTarjetaMadre);
			
			rdbtnDiscoDuro = new JRadioButton("Disco Duro");
			rdbtnDiscoDuro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarDiscoDuro();
				}
			});
			rdbtnDiscoDuro.setBounds(288, 17, 110, 23);
			panelTipo.add(rdbtnDiscoDuro);
			
			rdbtnMicro = new JRadioButton("Microprocesador");
			rdbtnMicro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarMicroprocesador();
				}
			});
			rdbtnMicro.setBounds(132, 17, 145, 23);
			panelTipo.add(rdbtnMicro);
			
			rdbtnMemoriaRAM = new JRadioButton("Memoria RAM");
			rdbtnMemoriaRAM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarMemoriaRam();
				}
			});
			rdbtnMemoriaRAM.setBounds(409, 17, 110, 23);
			panelTipo.add(rdbtnMemoriaRAM);
			
			panelTarjetaMadre = new JPanel();
			panelTarjetaMadre.setBorder(new TitledBorder(null, "Tarjeta Madre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelTarjetaMadre.setBounds(10, 181, 534, 115);
			panel.add(panelTarjetaMadre);
			panelTarjetaMadre.setLayout(null);
			
			JLabel lblTipoMicro = new JLabel("Tipo de conexi\u00F3n del socket:");
			lblTipoMicro.setBounds(23, 26, 236, 14);
			panelTarjetaMadre.add(lblTipoMicro);
			
			JLabel lblTipoDiscoDuro = new JLabel("Tipo de conexi\u00F3n del disco duro:");
			lblTipoDiscoDuro.setBounds(300, 26, 193, 14);
			panelTarjetaMadre.add(lblTipoDiscoDuro);
			
			JLabel lblTipoDeMemoria = new JLabel("Tipo de memoria RAM:");
			lblTipoDeMemoria.setBounds(23, 56, 236, 14);
			panelTarjetaMadre.add(lblTipoDeMemoria);
			
			cbxTipoMicroprocesadorTM = new JComboBox<String>();
			cbxTipoMicroprocesadorTM.setModel(new DefaultComboBoxModel<String>(new String[] {"PGA", "BGA", "LGA"}));
			cbxTipoMicroprocesadorTM.setSelectedIndex(0);
			cbxTipoMicroprocesadorTM.setBounds(189, 25, 80, 20);
			panelTarjetaMadre.add(cbxTipoMicroprocesadorTM);
			
			cbxTipoMemoriaRamTM = new JComboBox<String>();
			cbxTipoMemoriaRamTM.setModel(new DefaultComboBoxModel<String>(new String[] {"DDR", "DDR-2", "DDR-3", "DDR-4"}));
			cbxTipoMemoriaRamTM.setSelectedIndex(0);
			cbxTipoMemoriaRamTM.setBounds(189, 53, 80, 20);
			panelTarjetaMadre.add(cbxTipoMemoriaRamTM);
			
			rdbtnIDE = new JRadioButton("IDE");
			rdbtnIDE.setBounds(330, 50, 80, 23);
			panelTarjetaMadre.add(rdbtnIDE);
			
			rdbtnSATA = new JRadioButton("SATA");
			rdbtnSATA.setBounds(330, 76, 80, 23);
			panelTarjetaMadre.add(rdbtnSATA);
			
			rdbtnSATA2 = new JRadioButton("SATA-2");
			rdbtnSATA2.setBounds(412, 50, 80, 23);
			panelTarjetaMadre.add(rdbtnSATA2);
			
			rdbtnSATA3 = new JRadioButton("SATA-3");
			rdbtnSATA3.setBounds(412, 76, 80, 23);
			panelTarjetaMadre.add(rdbtnSATA3);
			
			panelMicro = new JPanel();
			panelMicro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Microprocesador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelMicro.setBounds(10, 181, 534, 115);
			panel.add(panelMicro);
			panelMicro.setLayout(null);
			
			JLabel lblConexion = new JLabel("Tipo de conexi\u00F3n del microprocesador:");
			lblConexion.setBounds(50, 27, 226, 14);
			panelMicro.add(lblConexion);
			
			cbxConexionMP = new JComboBox<String>();
			cbxConexionMP.setModel(new DefaultComboBoxModel<String>(new String[] {"PGA", "BGA", "LGA"}));
			cbxConexionMP.setSelectedIndex(0);
			cbxConexionMP.setBounds(286, 21, 139, 20);
			panelMicro.add(cbxConexionMP);
			
			JLabel lblVelocidad = new JLabel("Velocidad:");
			lblVelocidad.setBounds(50, 52, 226, 14);
			panelMicro.add(lblVelocidad);
			
			spnVelocidadMP = new JSpinner();
			spnVelocidadMP.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(0.5)));
			spnVelocidadMP.setBounds(286, 46, 108, 20);
			panelMicro.add(spnVelocidadMP);
			
			JLabel lblNucleos = new JLabel("Cantidad de n\u00FAcleos:");
			lblNucleos.setBounds(50, 77, 226, 14);
			panelMicro.add(lblNucleos);
			
			spnNucleosMP = new JSpinner();
			spnNucleosMP.setModel(new SpinnerNumberModel(new Integer(2), new Integer(2), null, new Integer(1)));
			spnNucleosMP.setBounds(286, 71, 139, 20);
			panelMicro.add(spnNucleosMP);
			
			JLabel lblGHz = new JLabel("GHz");
			lblGHz.setBounds(404, 49, 106, 14);
			panelMicro.add(lblGHz);
			
			panelMemoriaRAM = new JPanel();
			panelMemoriaRAM.setBorder(new TitledBorder(null, "Memoria RAM", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelMemoriaRAM.setLayout(null);
			panelMemoriaRAM.setBounds(10, 181, 534, 115);
			panel.add(panelMemoriaRAM);
			
			JLabel label = new JLabel("Capacidad de almacenamiento:");
			label.setBounds(50, 27, 226, 14);
			panelMemoriaRAM.add(label);
			
			spnCapacidadRAM = new JSpinner();
			spnCapacidadRAM.setModel(new SpinnerNumberModel(1, 1, 64, 1));
			spnCapacidadRAM.setBounds(273, 21, 121, 20);
			panelMemoriaRAM.add(spnCapacidadRAM);
			
			JLabel lblGb1 = new JLabel("Gb");
			lblGb1.setBounds(404, 24, 90, 14);
			panelMemoriaRAM.add(lblGb1);
			
			JLabel lblFrecuencia = new JLabel("Frecuencia:");
			lblFrecuencia.setBounds(50, 77, 226, 14);
			panelMemoriaRAM.add(lblFrecuencia);
			
			spnFrecuenciaRM = new JSpinner();
			spnFrecuenciaRM.setModel(new SpinnerNumberModel(new Integer(200), new Integer(200), null, new Integer(1)));
			spnFrecuenciaRM.setBounds(273, 74, 119, 20);
			panelMemoriaRAM.add(spnFrecuenciaRM);
			
			lblMHz = new JLabel("MHz");
			lblMHz.setBounds(404, 77, 83, 14);
			panelMemoriaRAM.add(lblMHz);
			
			JLabel lblMemoriaRAM = new JLabel("Tipo de memoria RAM:");
			lblMemoriaRAM.setBounds(50, 52, 226, 14);
			panelMemoriaRAM.add(lblMemoriaRAM);
			
			cbxTipoMemoriaRamRM = new JComboBox<String>();
			cbxTipoMemoriaRamRM.setModel(new DefaultComboBoxModel<String>(new String[] {"DDR", "DDR-2", "DDR-3", "DDR-4"}));
			cbxTipoMemoriaRamRM.setSelectedIndex(0);
			cbxTipoMemoriaRamRM.setBounds(273, 46, 152, 20);
			panelMemoriaRAM.add(cbxTipoMemoriaRamRM);
			
			panelDiscoDuro = new JPanel();
			panelDiscoDuro.setBorder(new TitledBorder(null, "Disco Duro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelDiscoDuro.setBounds(10, 181, 534, 115);
			panel.add(panelDiscoDuro);
			panelDiscoDuro.setLayout(null);
			
			
			
			JLabel lblCapacidad = new JLabel("Capacidad de almacenamiento:");
			lblCapacidad.setBounds(50, 27, 226, 14);
			panelDiscoDuro.add(lblCapacidad);
			
			spnCapacidadDD = new JSpinner();
			spnCapacidadDD.setModel(new SpinnerNumberModel(64, 64, 4096, 64));
			spnCapacidadDD.setBounds(304, 21, 90, 20);
			panelDiscoDuro.add(spnCapacidadDD);
			
			JLabel lblGb = new JLabel("Gb");
			lblGb.setBounds(404, 24, 90, 14);
			panelDiscoDuro.add(lblGb);
			
			JLabel lblRPM = new JLabel("Cantidad de revoluciones por minuto:");
			lblRPM.setBounds(50, 77, 226, 14);
			panelDiscoDuro.add(lblRPM);
			
			spnVelocidadDD = new JSpinner();
			spnVelocidadDD.setModel(new SpinnerNumberModel(new Integer(5000), new Integer(5000), null, new Integer(100)));
			spnVelocidadDD.setBounds(304, 46, 121, 20);
			panelDiscoDuro.add(spnVelocidadDD);
			
			JLabel lblTipoDeConexion = new JLabel("Tipo de conexi\u00F3n:");
			lblTipoDeConexion.setBounds(50, 52, 226, 14);
			panelDiscoDuro.add(lblTipoDeConexion);
			
			cbxConexionDD = new JComboBox<String>();
			cbxConexionDD.setModel(new DefaultComboBoxModel<String>(new String[] {"IDE", "SATA", "SATA-2", "SATA-3"}));
			cbxConexionDD.setSelectedIndex(0);
			cbxConexionDD.setBounds(304, 46, 121, 20);
			panelDiscoDuro.add(cbxConexionDD);
			
			spnCantRpm = new JSpinner();
			spnCantRpm.setModel(new SpinnerNumberModel(new Float(1500), new Float(1500), null, new Float(1)));
			spnCantRpm.setBounds(304, 74, 119, 20);
			panelDiscoDuro.add(spnCantRpm);
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				if(componente == null) {
					btnAccion = new JButton("Registrar");
				} else {
					if(funcion==0) {
						btnAccion = new JButton("Modificar");
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
							if(rdbtnDiscoDuro.isSelected()) {
								Tienda.getInstance().generarDiscoDuro(txtModelo.getText(), txtMarca.getText(), (int) spnCantidad.getValue(), (int) spnCantMin.getValue(), (float) spnPrecio.getValue(), (float) spnCosto.getValue(), (int) spnCapacidadDD.getValue(), cbxConexionDD.getSelectedIndex(), (int) spnVelocidadDD.getValue());
								clean();
							} else {
								if(rdbtnMemoriaRAM.isSelected()) {
									Tienda.getInstance().generarMemoriaRAM(txtModelo.getText(), txtMarca.getText(), (int) spnCantidad.getValue(), (int) spnCantMin.getValue(), (float) spnPrecio.getValue(), (float) spnCosto.getValue(), (int) spnCapacidadRAM.getValue(), cbxTipoMemoriaRamRM.getSelectedIndex(), (int) spnFrecuenciaRM.getValue());
									clean();
								} else {
									if(rdbtnMicro.isSelected()) {
										Tienda.getInstance().generarMicro(txtModelo.getText(), txtMarca.getText(), (int) spnCantidad.getValue(), (int) spnCantMin.getValue(), (float) spnPrecio.getValue(), (float) spnCosto.getValue(), cbxConexionMP.getSelectedIndex(), (float) spnVelocidadMP.getValue(), (int) spnNucleosMP.getValue());
										clean();
									} else {
										if(rdbtnTarjetaMadre.isSelected()) {
											ArrayList<Integer> conexiones  = new ArrayList<Integer>();
											if(rdbtnIDE.isSelected()) {
												conexiones.add(0);
											}
											if(rdbtnSATA.isSelected()) {
												conexiones.add(1);
											}
											if(rdbtnSATA2.isSelected()) {
												conexiones.add(2);
											}
											if(rdbtnSATA3.isSelected()) {
												conexiones.add(3);
											}
											if(conexiones.isEmpty()) {
												JOptionPane.showMessageDialog(null, "Se necesita selccionar almenos un tipo de conexion de disco duro.", "Error", JOptionPane.WARNING_MESSAGE);
											} else {
												Tienda.getInstance().generarTarjetaMadre(txtModelo.getText(), txtMarca.getText(), (int) spnCantidad.getValue(), (int) spnCantMin.getValue(), (float) spnPrecio.getValue(), (float) spnCosto.getValue(), cbxTipoMicroprocesadorTM.getSelectedIndex(), cbxTipoMemoriaRamTM.getSelectedIndex(), conexiones);
												clean();
											}
										}
									}
								}
							}
						} else {
							if(funcion==0) {
								if(rdbtnDiscoDuro.isSelected()) {
									Tienda.getInstance().modificarDiscoDuro(componente.getCodigo(), txtModelo.getText(), txtMarca.getText(), (int) spnCantidad.getValue(), (int) spnCantMin.getValue(), (float) spnPrecio.getValue(), (float) spnCosto.getValue(), (float) spnCapacidadDD.getValue(), cbxConexionDD.getSelectedIndex(), (int) spnVelocidadDD.getValue());
								} else {
									if(rdbtnMemoriaRAM.isSelected()) {
										Tienda.getInstance().modificarMemoriaRAM(componente.getCodigo(), txtModelo.getText(), txtMarca.getText(), (int) spnCantidad.getValue(), (int) spnCantMin.getValue(), (float) spnPrecio.getValue(), (float) spnCosto.getValue(), (float) spnCapacidadRAM.getValue(), cbxTipoMemoriaRamRM.getSelectedIndex(), (int) spnFrecuenciaRM.getValue());
									} else {
										if(rdbtnMicro.isSelected()) {
											Tienda.getInstance().modificarMicro(componente.getCodigo(), txtModelo.getText(), txtMarca.getText(), (int) spnCantidad.getValue(), (int) spnCantMin.getValue(), (float) spnPrecio.getValue(), (float) spnCosto.getValue(), cbxConexionMP.getSelectedIndex(), (float) spnVelocidadMP.getValue(), (int) spnNucleosMP.getValue());
										} else {
											if(rdbtnTarjetaMadre.isSelected()) {
												ArrayList<Integer> conexiones  = new ArrayList<Integer>();
												if(rdbtnIDE.isSelected()) {
													conexiones.add(0);
												}
												if(rdbtnSATA.isSelected()) {
													conexiones.add(1);
												}
												if(rdbtnSATA2.isSelected()) {
													conexiones.add(2);
												}
												if(rdbtnSATA3.isSelected()) {
													conexiones.add(3);
												}
												if(conexiones.isEmpty()) {
													JOptionPane.showMessageDialog(null, "Se necesita selccionar almenos un tipo de conexion de disco duro.", "Error", JOptionPane.WARNING_MESSAGE);
												} else {
													Tienda.getInstance().modificarTarjetaMadre(componente.getCodigo(), txtModelo.getText(), txtMarca.getText(), (int) spnCantidad.getValue(), (int) spnCantMin.getValue(), (float) spnPrecio.getValue(), (float) spnCosto.getValue(), cbxTipoMicroprocesadorTM.getSelectedIndex(), cbxTipoMemoriaRamTM.getSelectedIndex(), conexiones);
												}

											}
										}
									}
								}
								dispose();
							}  else {
								if(funcion==2) {
									Tienda.getInstance().eliminarProducto(componente.getCodigo());
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
		if(componente != null) {
			if(funcion!=0) {
				bloquearCampos();
			}
			cargarComponente();
		} else {
			cargarTarjetaMadre();
		}
		
	}
	private void bloquearCampos() {
		txtMarca.setEnabled(false);
		txtModelo.setEnabled(false);
		spnCantidad.setEnabled(false);
		spnCantMin.setEnabled(false);
		spnPrecio.setEnabled(false);
		spnCosto.setEnabled(false);
		rdbtnTarjetaMadre.setEnabled(false);
		rdbtnDiscoDuro.setEnabled(false);
		rdbtnMemoriaRAM.setEnabled(false);
		rdbtnMicro.setEnabled(false);
		panelTarjetaMadre.setEnabled(false);
		panelMicro.setEnabled(false);
		panelMemoriaRAM.setEnabled(false);
		panelDiscoDuro.setEnabled(false);
		cbxTipoMicroprocesadorTM.setEnabled(false);

		rdbtnIDE.setEnabled(false);
		rdbtnSATA.setEnabled(false);
		rdbtnSATA2.setEnabled(false);
		rdbtnSATA3.setEnabled(false);
		
		spnCantRpm.setEnabled(false);
		cbxTipoMemoriaRamTM.setEnabled(false);
		cbxConexionMP.setEnabled(false);
		spnVelocidadMP.setEnabled(false);
		spnNucleosMP.setEnabled(false);
		cbxConexionDD.setEnabled(false);
		spnCapacidadDD.setEnabled(false);
		spnVelocidadDD.setEnabled(false);
		spnCapacidadRAM.setEnabled(false);
		cbxTipoMemoriaRamRM.setEnabled(false);
		spnFrecuenciaRM.setEnabled(false);
	}
	
	private boolean confirmarCompatibilidad(ArrayList<Integer> conexiones, int conexion) {
		for(int x: conexiones) {
			if(x==conexion) {
				return true;
			}
		}
		return false;
	}
	
	private void cargarComponente() {
		txtMarca.setText(componente.getMarca());
		txtModelo.setText(componente.getModelo());
		spnCantidad.setValue(componente.getCantidad());
		spnCantMin.setValue(componente.getCantidadMinima());
		spnPrecio.setValue(componente.getPrecio());
		spnCosto.setValue(componente.getCosto());
		
		
		
		if (componente instanceof TarjetaMadre) {
			cargarTarjetaMadre();
			cbxTipoMicroprocesadorTM.setSelectedIndex(((TarjetaMadre) componente).getTipoMicro());
			if(confirmarCompatibilidad(((TarjetaMadre) componente).getTipoDisco(), 0)) {
				rdbtnIDE.setSelected(true);
			} else {
				rdbtnIDE.setSelected(false);
			}
			if(confirmarCompatibilidad(((TarjetaMadre) componente).getTipoDisco(), 1)) {
				rdbtnSATA.setSelected(true);
			} else {
				rdbtnSATA.setSelected(false);
			}
			if(confirmarCompatibilidad(((TarjetaMadre) componente).getTipoDisco(), 2)) {
				rdbtnSATA2.setSelected(true);
			} else {
				rdbtnSATA2.setSelected(false);
			}
			if(confirmarCompatibilidad(((TarjetaMadre) componente).getTipoDisco(), 3)) {
				rdbtnSATA3.setSelected(true);
			} else {
				rdbtnSATA3.setSelected(false);
			}
			cbxTipoMemoriaRamTM.setSelectedIndex(((TarjetaMadre) componente).getTipoRAM());
			
		} else {
			if (componente instanceof Microprocesador) {
				cargarMicroprocesador();
				cbxConexionMP.setSelectedIndex(((Microprocesador) componente).getConexion());;
				spnVelocidadMP.setValue(((Microprocesador) componente).getVelocidad());
				spnNucleosMP.setValue(((Microprocesador) componente).getNucleos());
			} else {
				if (componente instanceof DiscoDuro) {
					cargarDiscoDuro();					
					cbxConexionDD.setSelectedIndex(((DiscoDuro) componente).getTipo());
					spnCapacidadDD.setValue(((DiscoDuro) componente).getCapacidad());
					spnVelocidadDD.setValue(((DiscoDuro) componente).getRpm());
				} else {
					if (componente instanceof MemoriaRAM) {
						cargarMemoriaRam();
						spnCapacidadRAM.setValue(((MemoriaRAM) componente).getCapacidad());
						cbxTipoMemoriaRamRM.setSelectedItem(((MemoriaRAM) componente).getTipo());
						spnFrecuenciaRM.setValue(((MemoriaRAM) componente).getFrecuencia());
					}
				}
			}
		}
		bloquearTipos();
	}
	
	
	private void cargarTarjetaMadre() {
		rdbtnTarjetaMadre.setSelected(true);
		rdbtnDiscoDuro.setSelected(false);
		rdbtnMemoriaRAM.setSelected(false);
		rdbtnMicro.setSelected(false);
		panelTarjetaMadre.setVisible(true);
		panelMicro.setVisible(false);
		panelMemoriaRAM.setVisible(false);
		panelDiscoDuro.setVisible(false);
	}
	
	private void bloquearTipos() {
		rdbtnTarjetaMadre.setEnabled(false);
		rdbtnDiscoDuro.setEnabled(false);
		rdbtnMemoriaRAM.setEnabled(false);
		rdbtnMicro.setEnabled(false);
	}
	
	private void cargarMicroprocesador() {
		panelTarjetaMadre.setVisible(false);
		panelMicro.setVisible(true);
		panelMemoriaRAM.setVisible(false);
		panelDiscoDuro.setVisible(false);
		rdbtnTarjetaMadre.setSelected(false);
		rdbtnDiscoDuro.setSelected(false);
		rdbtnMemoriaRAM.setSelected(false);
		rdbtnMicro.setSelected(true);
	}
	private void cargarDiscoDuro() {
		rdbtnTarjetaMadre.setSelected(false);
		rdbtnDiscoDuro.setSelected(true);
		rdbtnMemoriaRAM.setSelected(false);
		rdbtnMicro.setSelected(false);
		panelTarjetaMadre.setVisible(false);
		panelMicro.setVisible(false);
		panelMemoriaRAM.setVisible(false);
		panelDiscoDuro.setVisible(true);
	}
	private void cargarMemoriaRam() {
		rdbtnTarjetaMadre.setSelected(false);
		rdbtnDiscoDuro.setSelected(false);
		rdbtnMemoriaRAM.setSelected(true);
		rdbtnMicro.setSelected(false);
		panelTarjetaMadre.setVisible(false);
		panelMicro.setVisible(false);
		panelMemoriaRAM.setVisible(true);
		panelDiscoDuro.setVisible(false);
	}
	private void clean () {
		txtMarca.setText("");
		txtModelo.setText("");
		spnCantidad.setValue(1);
		spnCantMin.setValue(1);
		spnPrecio.setValue(Float.parseFloat("1"));
		spnCosto.setValue(Float.parseFloat("1"));
		cargarTarjetaMadre();
		cbxTipoMicroprocesadorTM.setSelectedIndex(0);
		rdbtnIDE.setSelected(false);
		rdbtnSATA.setSelected(false);
		rdbtnSATA2.setSelected(false);
		rdbtnSATA3.setSelected(false);
		cbxTipoMemoriaRamTM.setSelectedIndex(0);
		cbxConexionMP.setSelectedIndex(0);
		spnVelocidadMP.setValue(1);
		spnNucleosMP.setValue(2);
		cbxConexionDD.setSelectedIndex(0);
		spnCapacidadDD.setValue(64);
		spnVelocidadDD.setValue(5400);
		spnCapacidadRAM.setValue(4);
		cbxTipoMemoriaRamRM.setSelectedIndex(0);
		spnFrecuenciaRM.setValue(200);
	}
}
