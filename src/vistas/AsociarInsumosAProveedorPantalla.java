package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import DTO.InsumoDTO;
import DTO.ProveedorDTO;
import businessDelegates.InsumoDelegate;
import businessDelegates.ProveedorDelegate;

public class AsociarInsumosAProveedorPantalla extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InsumoDelegate insumoBD;
	private ProveedorDelegate proveedorBD;
	private List<ProveedorDTO> proveedores;
	private List<InsumoDTO> insumos;

	public AsociarInsumosAProveedorPantalla() {
		super();
		try {
			proveedorBD = ProveedorDelegate.GetInstancia();
			insumoBD = InsumoDelegate.GetInstancia();
			proveedores = proveedorBD.getAllProveedores();
			insumos = insumoBD.getAllInsumos();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		crearPantalla();
	}

	private void crearPantalla() {

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Asociar Insumos a Proveedores");

		ProveedorDTO proveedoresArray[] = new ProveedorDTO[proveedores.size()];
		int j = 0;
		for (ProveedorDTO prov : proveedores) {
			proveedoresArray[j] = prov;
			j++;
		}
		JComboBox comboBox = new JComboBox(proveedoresArray);
		getContentPane().add(comboBox);
		comboBox.setBounds(80, 10, 210, 30);
		JLabel proveedorLabel = new JLabel("Proveedor:");
		getContentPane().add(proveedorLabel);
		proveedorLabel.setBounds(10, 10, 120, 30);

		InsumoDTO insumosArray[] = new InsumoDTO[insumos.size()];
		int k = 0;
		for (InsumoDTO insu : insumos) {
			insumosArray[k] = insu;
			k++;
		}
		JComboBox insuComboBox = new JComboBox(insumosArray);
		getContentPane().add(insuComboBox);
		insuComboBox.setBounds(80, 40, 210, 30);
		JLabel insumoLabel = new JLabel("Insumo:");
		getContentPane().add(insumoLabel);
		insumoLabel.setBounds(10, 40, 120, 30);

		JLabel descripcionInsumo = new JLabel();
		getContentPane().add(descripcionInsumo);
		descripcionInsumo.setText(((InsumoDTO) insuComboBox.getSelectedItem()).getDescripcion());
		descripcionInsumo.setBounds(300, 40, 300, 30);

		insuComboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				descripcionInsumo.setText(((InsumoDTO) insuComboBox.getSelectedItem()).getDescripcion());

			}
		});

		JLabel precioLabel = new JLabel();
		getContentPane().add(precioLabel);
		precioLabel.setText("Precio:");
		precioLabel.setBounds(10, 70, 120, 30);

		JTextField precio = new JTextField();
		getContentPane().add(precio);
		precio.setBounds(80, 70, 210, 30);
		
		
		JButton asociar = new JButton();
		getContentPane().add(asociar);
		asociar.setText("Asociar");
		asociar.setBounds(120, 100, 100, 30);

		asociar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InsumoDTO insumo = (InsumoDTO) insuComboBox.getSelectedItem();
				ProveedorDTO proveedor = (ProveedorDTO) comboBox.getSelectedItem();
				Float precioFloat = Float.parseFloat(precio.getText());
				try {
					proveedorBD.asociarInsumo(proveedor, insumo, precioFloat);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		pack();
		setSize(600, 300);

	}

}
