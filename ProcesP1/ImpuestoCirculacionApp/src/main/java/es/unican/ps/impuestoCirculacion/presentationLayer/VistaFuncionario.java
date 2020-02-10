package es.unican.ps.impuestoCirculacion.presentationLayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import es.unican.ps.impuestoCirculacion.businessLayer.IGestionContribuyentes;
import es.unican.ps.impuestoCirculacion.businessLayer.IGestionVehiculos;
import es.unican.ps.impuestoCirculacion.domain.Contribuyente;
import es.unican.ps.impuestoCirculacion.domain.Vehiculo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class VistaFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtDniContribuyente;
	private JTextField txtTotalContribuyente;
	private JTextField txtNombreContribuyente;
	private JList<String> listVehiculos; 
	private DefaultListModel<String> listModel;
	private JButton btnBuscar;
	
	private IGestionContribuyentes contribuyentes;
	private IGestionVehiculos vehiculos;

	/**
	 * Create the frame.
	 */
	public VistaFuncionario(IGestionContribuyentes contribuyentes,
			IGestionVehiculos vehiculos) {
		
		this.contribuyentes = contribuyentes;
		this.vehiculos = vehiculos;
		init();
	}
	
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		listModel=  new DefaultListModel<String>();
		
		txtTotalContribuyente = new JTextField();
		txtTotalContribuyente.setBounds(230, 251, 86, 20);
		contentPane.add(txtTotalContribuyente);
		txtTotalContribuyente.setColumns(10);
		txtTotalContribuyente.setName("txtTotalContribuyente");
		
		JLabel lblTotalContribuyente = new JLabel("Total A Pagar");
		lblTotalContribuyente.setBounds(137, 254, 99, 14);
		contentPane.add(lblTotalContribuyente);
		
		listVehiculos = new JList<String>();
		listVehiculos.setBounds(230, 98, 121, 116);
		contentPane.add(listVehiculos);
		listVehiculos.setBorder(new LineBorder(new Color(0, 0, 0)));
		listVehiculos.setModel(listModel);
		
		JLabel lblVehiculos = new JLabel("Vehiculos");
		lblVehiculos.setBounds(149, 93, 65, 14);
		contentPane.add(lblVehiculos);
		
		JLabel lblNombreContribuyente = new JLabel("Nombre");
		lblNombreContribuyente.setBounds(155, 54, 65, 14);
		contentPane.add(lblNombreContribuyente);
		
		txtNombreContribuyente = new JTextField();
		txtNombreContribuyente.setBounds(230, 51, 121, 20);
		contentPane.add(txtNombreContribuyente);
		txtNombreContribuyente.setColumns(10);
		txtNombreContribuyente.setName("txtNombreContribuyente");
		
		JLabel lblDatosContribuyente = new JLabel("Datos Contribuyente");
		lblDatosContribuyente.setBounds(230, 11, 149, 14);
		contentPane.add(lblDatosContribuyente);
		
		txtDniContribuyente = new JTextField();
		txtDniContribuyente.setBounds(10, 51, 113, 20);
		contentPane.add(txtDniContribuyente);
		txtDniContribuyente.setColumns(10);
		txtDniContribuyente.setName("txtDNIContribuyente");
		
		JLabel lblDniContribuyente = new JLabel("DNI Contribuyente");
		lblDniContribuyente.setBounds(21, 27, 139, 14);
		contentPane.add(lblDniContribuyente);
		lblDniContribuyente.setName("lblDniContribuyente");
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rellenaDatosContribuyente(txtDniContribuyente.getText());
			}
		});
		btnBuscar.setBounds(21, 122, 89, 23);
		contentPane.add(btnBuscar);
		btnBuscar.setName("btnBuscar");
		listVehiculos.setVisible(true);
	}

	private void rellenaDatosContribuyente(String dni) {
		Contribuyente c = contribuyentes.contribuyente(dni);
		if (c!=null) {
			txtNombreContribuyente.setText(c.getNombre() + " "+c.getApellido1()+" "+c.getApellido2());
			txtTotalContribuyente.setText(c.getNombre() + " "+c.getApellido1()+" "+c.getApellido2());
			//txtTotalContribuyente.setText(Double.toString(contribuyentes.totalContribuyente(dni)));
			listModel.removeAllElements();
			for (Vehiculo v:c.getVehiculos()) {
				listModel.addElement(v.getMatricula());
			}
		} else {
			txtNombreContribuyente.setText("DNI No Válido");
			txtTotalContribuyente.setText("");
			listModel.removeAllElements();
		}
		
	}
}
