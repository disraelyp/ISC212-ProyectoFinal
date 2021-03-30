package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
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

public class RegistroComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSerie;
	private JTextField textField;
	private JTextField textField_1;
	private JRadioButton rdbtnTarjetaMadre;
	private JRadioButton rdbtnMicro;
	private JRadioButton rdbtnDiscoDuro;
	private JRadioButton rdbtnMemoriaRAM;
	private JPanel panelTarjetaMadre;
	private JPanel panelMicro;
	private JPanel panelMemoriaRAM;
	private JPanel panelDiscoDuro;

	public RegistroComponente() {
		setTitle("Registro de Componentes");
		setBounds(100, 100, 580, 370);
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
				
				JLabel lblSerie = new JLabel("Serie:");
				lblSerie.setBounds(10, 23, 46, 14);
				panelGeneral.add(lblSerie);
				
				txtSerie = new JTextField();
				txtSerie.setBounds(58, 20, 210, 20);
				panelGeneral.add(txtSerie);
				txtSerie.setColumns(10);
				
				JLabel lblModelo = new JLabel("Modelo:");
				lblModelo.setBounds(10, 48, 46, 14);
				panelGeneral.add(lblModelo);
				
				textField = new JTextField();
				textField.setBounds(58, 45, 210, 20);
				panelGeneral.add(textField);
				textField.setColumns(10);
				
				JLabel lblMarca = new JLabel("Marca:");
				lblMarca.setBounds(10, 73, 46, 14);
				panelGeneral.add(lblMarca);
				
				textField_1 = new JTextField();
				textField_1.setBounds(58, 70, 210, 20);
				panelGeneral.add(textField_1);
				textField_1.setColumns(10);
				
				JLabel lblCantidad = new JLabel("Cantidad:");
				lblCantidad.setBounds(295, 23, 65, 14);
				panelGeneral.add(lblCantidad);
				
				JSpinner spnCantidad = new JSpinner();
				spnCantidad.setBounds(356, 20, 49, 20);
				panelGeneral.add(spnCantidad);
				
				JLabel lblMinima = new JLabel("Cant. M\u00EDnima:");
				lblMinima.setBounds(415, 23, 101, 14);
				panelGeneral.add(lblMinima);
				
				JSpinner spnMinima = new JSpinner();
				spnMinima.setBounds(495, 20, 49, 20);
				panelGeneral.add(spnMinima);
				
				JLabel lblCosto = new JLabel("Costo:");
				lblCosto.setBounds(295, 48, 46, 14);
				panelGeneral.add(lblCosto);
				
				JLabel lblPrecio = new JLabel("Precio:");
				lblPrecio.setBounds(295, 73, 46, 14);
				panelGeneral.add(lblPrecio);
				
				JSpinner spnCosto = new JSpinner();
				spnCosto.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
				spnCosto.setBounds(355, 45, 189, 20);
				panelGeneral.add(spnCosto);
				
				JSpinner spnPrecio = new JSpinner();
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
					rdbtnTarjetaMadre.setSelected(true);
					rdbtnDiscoDuro.setSelected(false);
					rdbtnMemoriaRAM.setSelected(false);
					rdbtnMicro.setSelected(false);
					
					panelTarjetaMadre.setVisible(true);
					panelMicro.setVisible(false);
					panelMemoriaRAM.setVisible(false);
					panelDiscoDuro.setVisible(false);
				}
			});
			rdbtnTarjetaMadre.setSelected(true);
			rdbtnTarjetaMadre.setBounds(6, 20, 109, 23);
			panelTipo.add(rdbtnTarjetaMadre);
			
			rdbtnDiscoDuro = new JRadioButton("Disco Duro");
			rdbtnDiscoDuro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnTarjetaMadre.setSelected(false);
					rdbtnDiscoDuro.setSelected(true);
					rdbtnMemoriaRAM.setSelected(false);
					rdbtnMicro.setSelected(false);
					
					panelTarjetaMadre.setVisible(false);
					panelMicro.setVisible(false);
					panelMemoriaRAM.setVisible(false);
					panelDiscoDuro.setVisible(true);
				}
			});
			rdbtnDiscoDuro.setBounds(287, 20, 109, 23);
			panelTipo.add(rdbtnDiscoDuro);
			
			rdbtnMicro = new JRadioButton("Microprocesador");
			rdbtnMicro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnTarjetaMadre.setSelected(false);
					rdbtnDiscoDuro.setSelected(false);
					rdbtnMemoriaRAM.setSelected(false);
					rdbtnMicro.setSelected(true);
					
					panelTarjetaMadre.setVisible(false);
					panelMicro.setVisible(true);
					panelMemoriaRAM.setVisible(false);
					panelDiscoDuro.setVisible(false);
				}
			});
			rdbtnMicro.setBounds(137, 20, 126, 23);
			panelTipo.add(rdbtnMicro);
			
			rdbtnMemoriaRAM = new JRadioButton("Memoria RAM");
			rdbtnMemoriaRAM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnTarjetaMadre.setSelected(false);
					rdbtnDiscoDuro.setSelected(false);
					rdbtnMemoriaRAM.setSelected(true);
					rdbtnMicro.setSelected(false);
					
					panelTarjetaMadre.setVisible(false);
					panelMicro.setVisible(false);
					panelMemoriaRAM.setVisible(true);
					panelDiscoDuro.setVisible(false);
					
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
			
			JComboBox<String> cbxTipoMicro = new JComboBox<String>();
			cbxTipoMicro.setModel(new DefaultComboBoxModel<String>(new String[] {"PGA", "BGA", "LGA"}));
			cbxTipoMicro.setBounds(304, 23, 200, 20);
			panelTarjetaMadre.add(cbxTipoMicro);
			
			JComboBox<String> cbxTipoDiscoDuro = new JComboBox<String>();
			cbxTipoDiscoDuro.setModel(new DefaultComboBoxModel<String>(new String[] {"IDE", "SATA", "SATA-2", "SATA-3"}));
			cbxTipoDiscoDuro.setBounds(304, 48, 200, 20);
			panelTarjetaMadre.add(cbxTipoDiscoDuro);
			
			JComboBox<String> cbxMemoriaRam = new JComboBox<String>();
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
			
			JComboBox<String> cbxConexion = new JComboBox<String>();
			cbxConexion.setModel(new DefaultComboBoxModel<String>(new String[] {"PGA", "BGA", "LGA"}));
			cbxConexion.setBounds(304, 21, 121, 20);
			panelMicro.add(cbxConexion);
			
			JLabel lblVelocidad = new JLabel("Velocidad:");
			lblVelocidad.setBounds(50, 52, 226, 14);
			panelMicro.add(lblVelocidad);
			
			JSpinner spnVelocidad = new JSpinner();
			spnVelocidad.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnVelocidad.setBounds(304, 46, 90, 20);
			panelMicro.add(spnVelocidad);
			
			JLabel lblNucleos = new JLabel("Cantidad de n\u00FAcleos:");
			lblNucleos.setBounds(50, 77, 226, 14);
			panelMicro.add(lblNucleos);
			
			JSpinner spnNucleos = new JSpinner();
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
			
			JSpinner spnCapacidadRAM = new JSpinner();
			spnCapacidadRAM.setModel(new SpinnerListModel(new String[] {"4", "8", "16", "32", "64", "128"}));
			spnCapacidadRAM.setBounds(304, 21, 90, 20);
			panelMemoriaRAM.add(spnCapacidadRAM);
			
			JLabel label_1 = new JLabel("Gb");
			label_1.setBounds(400, 27, 23, 14);
			panelMemoriaRAM.add(label_1);
			
			JLabel lbl = new JLabel("Cantidad de revoluciones por minuto:");
			lbl.setBounds(50, 77, 226, 14);
			panelMemoriaRAM.add(lbl);
			
			JSpinner spinner_1 = new JSpinner();
			spinner_1.setBounds(302, 74, 121, 20);
			panelMemoriaRAM.add(spinner_1);
			
			JLabel lblMemoriaRAM = new JLabel("Tipo de memoria RAM:");
			lblMemoriaRAM.setBounds(50, 52, 226, 14);
			panelMemoriaRAM.add(lblMemoriaRAM);
			
			JComboBox<String> cbxMemoriaRAM = new JComboBox<String>();
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
			
			JSpinner spnCapacidad = new JSpinner();
			spnCapacidad.setModel(new SpinnerListModel(new String[] {"250", "500", "1000", "2000", "3000", "4000", "6000", "10000"}));
			spnCapacidad.setBounds(304, 21, 90, 20);
			panelDiscoDuro.add(spnCapacidad);
			
			JLabel lblGb = new JLabel("Gb");
			lblGb.setBounds(400, 27, 23, 14);
			panelDiscoDuro.add(lblGb);
			
			JLabel lblRPM = new JLabel("Cantidad de revoluciones por minuto:");
			lblRPM.setBounds(50, 77, 226, 14);
			panelDiscoDuro.add(lblRPM);
			
			JSpinner spnRPM = new JSpinner();
			spnRPM.setModel(new SpinnerListModel(new String[] {"5,400", "7,200", "10,000", "15,000"}));
			spnRPM.setBounds(304, 46, 121, 20);
			panelDiscoDuro.add(spnRPM);
			
			JLabel lblTipoDeConexion = new JLabel("Tipo de conexi\u00F3n:");
			lblTipoDeConexion.setBounds(50, 52, 226, 14);
			panelDiscoDuro.add(lblTipoDeConexion);
			
			JComboBox<String> cbxConexionDD = new JComboBox<String>();
			cbxConexionDD.setModel(new DefaultComboBoxModel<String>(new String[] {"IDE", "SATA", "SATA-1", "SATA-2", "SATA-3"}));
			cbxConexionDD.setBounds(304, 46, 121, 20);
			panelDiscoDuro.add(cbxConexionDD);
			
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Float(1500), new Float(1500), null, new Float(1)));
			spinner.setBounds(304, 74, 119, 20);
			panelDiscoDuro.add(spinner);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		
		panelTarjetaMadre.setVisible(true);
		panelMicro.setVisible(false);
		panelMemoriaRAM.setVisible(false);
		panelDiscoDuro.setVisible(false);
		
	}
}
