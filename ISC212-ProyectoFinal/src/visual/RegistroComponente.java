package visual;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logic.Componente;
import logic.DiscoDuro;
import logic.MemoriaRAM;
import logic.Microprocesador;
import logic.TarjetaMadre;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class RegistroComponente extends JDialog {

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
	private JComboBox<String> cbxTipoMicro;
	private JComboBox<String> cbxTipoDiscoDuro;
	private JComboBox<String> cbxMemoriaRam;
	private JComboBox<String> cbxConexion;
	private JSpinner spnVelocidad;
	private JSpinner spnNucleos;
	private JSpinner spnCapacidadRAM;
	private JSpinner spnFrecuencia;
	private JComboBox<String> cbxMemoriaRAM;
	private JSpinner spnCapacidad;
	private JSpinner spnRPM;
	private JComboBox<String> cbxConexionDD;
	private JSpinner spnCantRpm;
	private JButton btnSalir;
	private JLabel lblMHz;
	

	public RegistroComponente(Componente aux, int abrir) {
		
		if(aux == null && abrir==0) {
			setTitle("Registro de Componentes");
		} else {
			if(aux != null && abrir == 0) {
				setTitle("Modificador de Componentes");
			} else {
				setTitle("Ver componente (Codigo: " +aux.getCodigo()+")");
				bloquearDatos(aux);
			}
			cargarComponente(aux);
		}
		
		
		setBounds(100, 100, 580, 447);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panelGeneral = new JPanel();
				panelGeneral.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelGeneral.setBounds(0, 0, 554, 107);
				panel.add(panelGeneral);
				panelGeneral.setLayout(null);
				
				JLabel lblModelo = new JLabel("Modelo:");
				lblModelo.setBounds(10, 48, 46, 14);
				panelGeneral.add(lblModelo);
				
				txtModelo = new JTextField();
				txtModelo.setBounds(58, 45, 210, 20);
				panelGeneral.add(txtModelo);
				txtModelo.setColumns(10);
				
				JLabel lblMarca = new JLabel("Marca:");
				lblMarca.setBounds(10, 73, 46, 14);
				panelGeneral.add(lblMarca);
				
				txtMarca = new JTextField();
				txtMarca.setBounds(58, 70, 210, 20);
				panelGeneral.add(txtMarca);
				txtMarca.setColumns(10);
				
				JLabel lblCantidad = new JLabel("Cantidad:");
				lblCantidad.setBounds(295, 23, 65, 14);
				panelGeneral.add(lblCantidad);
				
				spnCantidad = new JSpinner();
				spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
				spnCantidad.setBounds(356, 20, 49, 20);
				panelGeneral.add(spnCantidad);
				
				JLabel lblMinima = new JLabel("Cant. M\u00EDnima:");
				lblMinima.setBounds(415, 23, 101, 14);
				panelGeneral.add(lblMinima);
				
				spnCantMin = new JSpinner();
				spnCantMin.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
				spnCantMin.setBounds(495, 20, 49, 20);
				panelGeneral.add(spnCantMin);
				
				JLabel lblCosto = new JLabel("Costo:");
				lblCosto.setBounds(295, 48, 46, 14);
				panelGeneral.add(lblCosto);
				
				JLabel lblPrecio = new JLabel("Precio:");
				lblPrecio.setBounds(295, 73, 46, 14);
				panelGeneral.add(lblPrecio);
				
				spnCosto = new JSpinner();
				spnCosto.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
				spnCosto.setBounds(355, 45, 189, 20);
				panelGeneral.add(spnCosto);
				
				spnPrecio = new JSpinner();
				spnPrecio.setBounds(355, 70, 189, 20);
				panelGeneral.add(spnPrecio);
			}
			
			JPanel panelTipo = new JPanel();
			panelTipo.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelTipo.setBounds(0, 111, 554, 58);
			panel.add(panelTipo);
			panelTipo.setLayout(null);
			
			rdbtnTarjetaMadre = new JRadioButton("Tarjeta Madre");
			rdbtnTarjetaMadre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					instanceTarjetaMadre();
				}
			});
			rdbtnTarjetaMadre.setSelected(true);
			rdbtnTarjetaMadre.setBounds(6, 20, 109, 23);
			panelTipo.add(rdbtnTarjetaMadre);
			
			rdbtnDiscoDuro = new JRadioButton("Disco Duro");
			rdbtnDiscoDuro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					instanceDiscoDuro();
				}
			});
			rdbtnDiscoDuro.setBounds(287, 20, 109, 23);
			panelTipo.add(rdbtnDiscoDuro);
			
			rdbtnMicro = new JRadioButton("Microprocesador");
			rdbtnMicro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					instanceMicro();
				}
			});
			rdbtnMicro.setBounds(137, 20, 126, 23);
			panelTipo.add(rdbtnMicro);
			
			rdbtnMemoriaRAM = new JRadioButton("Memoria RAM");
			rdbtnMemoriaRAM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					instanceMemoriaRAM();
				}
			});
			rdbtnMemoriaRAM.setBounds(416, 20, 132, 23);
			panelTipo.add(rdbtnMemoriaRAM);
			
			panelTarjetaMadre = new JPanel();
			panelTarjetaMadre.setBorder(new TitledBorder(null, "Tarjeta Madre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelTarjetaMadre.setBounds(0, 173, 554, 115);
			panel.add(panelTarjetaMadre);
			panelTarjetaMadre.setLayout(null);
			
			
			JLabel lblTipoMicro = new JLabel("Tipo de conexi\u00F3n del microprocesador:");
			lblTipoMicro.setBounds(51, 26, 226, 14);
			panelTarjetaMadre.add(lblTipoMicro);
			
			JLabel lblTipoDiscoDuro = new JLabel("Tipo de conexi\u00F3n del disco duro:");
			lblTipoDiscoDuro.setBounds(51, 51, 226, 14);
			panelTarjetaMadre.add(lblTipoDiscoDuro);
			
			JLabel lblTipoDeMemoria = new JLabel("Tipo de memoria RAM:");
			lblTipoDeMemoria.setBounds(51, 76, 226, 14);
			panelTarjetaMadre.add(lblTipoDeMemoria);
			
			cbxTipoMicro = new JComboBox<String>();
			cbxTipoMicro.setModel(new DefaultComboBoxModel<String>(new String[] {"PGA", "BGA", "LGA"}));
			cbxTipoMicro.setBounds(304, 23, 200, 20);
			panelTarjetaMadre.add(cbxTipoMicro);
			
			cbxTipoDiscoDuro = new JComboBox<String>();
			cbxTipoDiscoDuro.setModel(new DefaultComboBoxModel<String>(new String[] {"IDE", "SATA", "SATA-2", "SATA-3"}));
			cbxTipoDiscoDuro.setBounds(304, 48, 200, 20);
			panelTarjetaMadre.add(cbxTipoDiscoDuro);
			
			cbxMemoriaRam = new JComboBox<String>();
			cbxMemoriaRam.setModel(new DefaultComboBoxModel<String>(new String[] {"DDR", "DDR-2", "DDR-3", "DDR-4"}));
			cbxMemoriaRam.setBounds(304, 73, 200, 20);
			panelTarjetaMadre.add(cbxMemoriaRam);
			
			panelMicro = new JPanel();
			panelMicro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Microprocesador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelMicro.setBounds(0, 173, 554, 115);
			panel.add(panelMicro);
			panelMicro.setLayout(null);
			
			JLabel lblConexion = new JLabel("Tipo de conexi\u00F3n del microprocesador:");
			lblConexion.setBounds(50, 27, 226, 14);
			panelMicro.add(lblConexion);
			
			cbxConexion = new JComboBox<String>();
			cbxConexion.setModel(new DefaultComboBoxModel<String>(new String[] {"PGA", "BGA", "LGA"}));
			cbxConexion.setBounds(304, 21, 121, 20);
			panelMicro.add(cbxConexion);
			
			JLabel lblVelocidad = new JLabel("Velocidad:");
			lblVelocidad.setBounds(50, 52, 226, 14);
			panelMicro.add(lblVelocidad);
			
			spnVelocidad = new JSpinner();
			spnVelocidad.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnVelocidad.setBounds(304, 46, 90, 20);
			panelMicro.add(spnVelocidad);
			
			JLabel lblNucleos = new JLabel("Cantidad de n\u00FAcleos:");
			lblNucleos.setBounds(50, 77, 226, 14);
			panelMicro.add(lblNucleos);
			
			spnNucleos = new JSpinner();
			spnNucleos.setModel(new SpinnerNumberModel(new Integer(2), new Integer(2), null, new Integer(1)));
			spnNucleos.setBounds(304, 71, 121, 20);
			panelMicro.add(spnNucleos);
			
			JLabel lblGHz = new JLabel("GHz");
			lblGHz.setBounds(396, 52, 26, 14);
			panelMicro.add(lblGHz);
			
			panelMemoriaRAM = new JPanel();
			panelMemoriaRAM.setBorder(new TitledBorder(null, "Memoria RAM", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelMemoriaRAM.setLayout(null);
			panelMemoriaRAM.setBounds(0, 173, 554, 115);
			panel.add(panelMemoriaRAM);
			
			JLabel label = new JLabel("Capacidad de almacenamiento:");
			label.setBounds(50, 27, 226, 14);
			panelMemoriaRAM.add(label);
			
			spnCapacidadRAM = new JSpinner();
			spnCapacidadRAM.setModel(new SpinnerListModel(new String[] {"4", "8", "16", "32", "64", "128"}));
			spnCapacidadRAM.setBounds(304, 21, 90, 20);
			panelMemoriaRAM.add(spnCapacidadRAM);
			
			JLabel lblGb1 = new JLabel("Gb");
			lblGb1.setBounds(400, 27, 23, 14);
			panelMemoriaRAM.add(lblGb1);
			
			JLabel lblFrecuencia = new JLabel("Frecuencia:");
			lblFrecuencia.setBounds(50, 77, 226, 14);
			panelMemoriaRAM.add(lblFrecuencia);
			
			spnFrecuencia = new JSpinner();
			spnFrecuencia.setModel(new SpinnerNumberModel(new Integer(200), new Integer(200), null, new Integer(1)));
			spnFrecuencia.setBounds(302, 74, 90, 20);
			panelMemoriaRAM.add(spnFrecuencia);
			
			lblMHz = new JLabel("MHz");
			lblMHz.setBounds(400, 77, 23, 14);
			panelMemoriaRAM.add(lblMHz);
			
			JLabel lblMemoriaRAM = new JLabel("Tipo de memoria RAM:");
			lblMemoriaRAM.setBounds(50, 52, 226, 14);
			panelMemoriaRAM.add(lblMemoriaRAM);
			
			cbxMemoriaRAM = new JComboBox<String>();
			cbxMemoriaRAM.setModel(new DefaultComboBoxModel<String>(new String[] {"DDR", "DDR-2", "DDR-3", "DDR-4"}));
			cbxMemoriaRAM.setBounds(304, 46, 121, 20);
			panelMemoriaRAM.add(cbxMemoriaRAM);
			
			panelDiscoDuro = new JPanel();
			panelDiscoDuro.setBorder(new TitledBorder(null, "Disco Duro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelDiscoDuro.setBounds(0, 173, 554, 115);
			panel.add(panelDiscoDuro);
			panelDiscoDuro.setLayout(null);
			
			JLabel lblCapacidad = new JLabel("Capacidad de almacenamiento:");
			lblCapacidad.setBounds(50, 27, 226, 14);
			panelDiscoDuro.add(lblCapacidad);
			
			spnCapacidad = new JSpinner();
			spnCapacidad.setModel(new SpinnerListModel(new String[] {"250", "500", "1000", "2000", "3000", "4000", "6000", "10000"}));
			spnCapacidad.setBounds(304, 21, 90, 20);
			panelDiscoDuro.add(spnCapacidad);
			
			JLabel lblGb = new JLabel("Gb");
			lblGb.setBounds(400, 27, 23, 14);
			panelDiscoDuro.add(lblGb);
			
			JLabel lblRPM = new JLabel("Cantidad de revoluciones por minuto:");
			lblRPM.setBounds(50, 77, 226, 14);
			panelDiscoDuro.add(lblRPM);
			
			spnRPM = new JSpinner();
			spnRPM.setModel(new SpinnerListModel(new String[] {"5,400", "7,200", "10,000", "15,000"}));
			spnRPM.setBounds(304, 46, 121, 20);
			panelDiscoDuro.add(spnRPM);
			
			JLabel lblTipoDeConexion = new JLabel("Tipo de conexi\u00F3n:");
			lblTipoDeConexion.setBounds(50, 52, 226, 14);
			panelDiscoDuro.add(lblTipoDeConexion);
			
			cbxConexionDD = new JComboBox<String>();
			cbxConexionDD.setModel(new DefaultComboBoxModel<String>(new String[] {"IDE", "SATA", "SATA-1", "SATA-2", "SATA-3"}));
			cbxConexionDD.setBounds(304, 46, 121, 20);
			panelDiscoDuro.add(cbxConexionDD);
			
			spnCantRpm = new JSpinner();
			spnCantRpm.setModel(new SpinnerNumberModel(new Float(1500), new Float(1500), null, new Float(1)));
			spnCantRpm.setBounds(304, 74, 119, 20);
			panelDiscoDuro.add(spnCantRpm);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(0, 299, 554, 91);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			btnSalir = new JButton("");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnSalir.setIcon(new ImageIcon(RegistroComponente.class.getResource("/resources/salir.png")));
			btnSalir.setBounds(474, 11, 70, 70);
			panel_1.add(btnSalir);
			
			if(abrir != 1 && aux != null) {
				btnAccion = new JButton("Modificar");
				btnAccion.setBounds(356, 11, 70, 70);
				panel_1.add(btnAccion);
			} else {
				if (abrir != 1 && aux == null) {
					btnAccion = new JButton("Registrar");
					btnAccion.setBounds(356, 11, 70, 70);
					panel_1.add(btnAccion);
				}
			}
			
			btnAccion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (aux == null && abrir == 0) {
						if (rdbtnTarjetaMadre.isSelected()) {
							//	Tienda.getInstance().generarTarjetaMadre(txtCodigo.getText(), txtMarca.getText(), (Integer) spnCantidad.getValue(), (Integer) spnCantMin.getValue(), (Float) spnPrecio.getValue(), (Float) spnCosto.getValue(), cbxTipoMicro.getSelectedIndex(), cbxTipoDiscoDuro.getSelectedIndex(), cbxMemoriaRam.getSelectedIndex());
						}
						clean();
					}else {
						if (aux != null && abrir == 0) {
							//Tienda.getInstance().modificarComponente
						}
					}
				}
			});	
		}
		
		panelTarjetaMadre.setVisible(true);
		panelMicro.setVisible(false);
		panelMemoriaRAM.setVisible(false);
		panelDiscoDuro.setVisible(false);
		
	}

	private void bloquearDatos(Componente aux) {
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
		cbxTipoMicro.setEnabled(false);
		cbxTipoDiscoDuro.setEnabled(false);
		cbxMemoriaRam.setEnabled(false);
		cbxConexion.setEnabled(false);
		spnVelocidad.setEnabled(false);
		spnNucleos.setEnabled(false);
		cbxConexionDD.setEnabled(false);
		spnCapacidad.setEnabled(false);
		spnRPM.setEnabled(false);
		spnCapacidadRAM.setEnabled(false);
		cbxMemoriaRam.setEnabled(false);
		spnFrecuencia.setEnabled(false);
	}

	private void cargarComponente(Componente aux) {
		txtMarca.setText(aux.getMarca());
		txtModelo.setText(aux.getModelo());
		spnCantidad.setValue(aux.getCantidad());
		spnCantMin.setValue(aux.getCantidadMinima());
		spnPrecio.setValue(aux.getPrecio());
		spnCosto.setValue(aux.getCosto());
		
		if (aux instanceof TarjetaMadre)
		{
			instanceTarjetaMadre();
			cbxTipoMicro.setSelectedIndex(((TarjetaMadre) aux).getTipoMicro());
			cbxTipoDiscoDuro.setSelectedItem(((TarjetaMadre) aux).getTipoDisco());
			cbxMemoriaRam.setSelectedIndex(((TarjetaMadre) aux).getTipoRAM());
			
		}else {
			if (aux instanceof Microprocesador)
			{
				instanceMicro();
				cbxConexion.setSelectedIndex(((Microprocesador) aux).getConexion());;
				spnVelocidad.setValue(((Microprocesador) aux).getVelocidad());
				spnNucleos.setValue(((Microprocesador) aux).getNucleos());
			}else {
				if (aux instanceof DiscoDuro)
				{
					instanceDiscoDuro();					
					cbxConexionDD.setSelectedIndex(((DiscoDuro) aux).getTipo());
					spnCapacidad.setValue(((DiscoDuro) aux).getCapacidad());
					spnRPM.setValue(((DiscoDuro) aux).getRpm());
				}else {
					if (aux instanceof MemoriaRAM) {
						instanceMemoriaRAM();
						spnCapacidadRAM.setValue(((MemoriaRAM) aux).getCapacidad());
						cbxMemoriaRam.setSelectedItem(((MemoriaRAM) aux).getTipo());
						spnFrecuencia.setValue(((MemoriaRAM) aux).getFrecuencia());
					}
				}
			}
		}
		
	}
	
	private void instanceTarjetaMadre() {
		rdbtnTarjetaMadre.setSelected(true);
		rdbtnDiscoDuro.setSelected(false);
		rdbtnMemoriaRAM.setSelected(false);
		rdbtnMicro.setSelected(false);
		
		panelTarjetaMadre.setVisible(true);
		panelMicro.setVisible(false);
		panelMemoriaRAM.setVisible(false);
		panelDiscoDuro.setVisible(false);
	}
	
	private void instanceMicro() {
		panelTarjetaMadre.setVisible(false);
		panelMicro.setVisible(true);
		panelMemoriaRAM.setVisible(false);
		panelDiscoDuro.setVisible(false);
		
		rdbtnTarjetaMadre.setSelected(false);
		rdbtnDiscoDuro.setSelected(false);
		rdbtnMemoriaRAM.setSelected(false);
		rdbtnMicro.setSelected(true);
	}
	
	private void instanceDiscoDuro() {
		rdbtnTarjetaMadre.setSelected(false);
		rdbtnDiscoDuro.setSelected(true);
		rdbtnMemoriaRAM.setSelected(false);
		rdbtnMicro.setSelected(false);
		
		panelTarjetaMadre.setVisible(false);
		panelMicro.setVisible(false);
		panelMemoriaRAM.setVisible(false);
		panelDiscoDuro.setVisible(true);
	}
	
	private void instanceMemoriaRAM() {
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
		spnPrecio.setValue(0);
		spnCosto.setValue(0);
		instanceTarjetaMadre();
		cbxTipoMicro.setSelectedIndex(0);
		cbxTipoDiscoDuro.setSelectedIndex(0);
		cbxMemoriaRam.setSelectedIndex(0);
		cbxConexion.setSelectedIndex(0);
		spnVelocidad.setValue(1.8);
		spnNucleos.setValue(2);
		cbxConexionDD.setSelectedIndex(0);
		spnCapacidad.setValue(250);
		spnRPM.setValue(5400);
		spnCapacidadRAM.setValue(4);
		cbxMemoriaRam.setSelectedIndex(0);
		spnFrecuencia.setValue(200);
	}

}
