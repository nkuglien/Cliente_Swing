package vistas;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import DTO.ProveedorDTO;
import businessDelegates.InsumoDelegate;
import businessDelegates.ProveedorDelegate;

public class AltaInsumosPantalla extends javax.swing.JFrame  {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton alta;
	private JLabel mensaje;
	private InsumoDelegate controlador;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private ArrayList<JTextField> texts = new ArrayList<JTextField>();
	private String[] nombres = {"Codigo:", "Nombre:", "Descripcion:", "Stock Minimo:", "Cant. Compra:"};
	private List<ProveedorDTO> proveedores;
	
	public AltaInsumosPantalla() {
		super();
		this.controlador = InsumoDelegate.GetInstancia();
		try {
			proveedores = ProveedorDelegate.GetInstancia().getAllProveedores();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		crearPantalla();
	}

	private void crearPantalla() {
		int i=0;
		try 
		{
			
			setSize(400, 50 * (nombres.length + 2) + 20);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			setTitle("Alta Insumos");
			
			for (i = 0; i < nombres.length; i++){
				JLabel l = new JLabel();
				getContentPane().add(l);
				l.setText(nombres[i]);
				l.setBounds(21, 50 * i + 20, 120, 30);
				labels.add(l);
				
				JTextField t = new JTextField();
				getContentPane().add(t);
				t.setBounds(120, 50 * i + 20, 210, 30);
				texts.add(t);
			}
			
			ProveedorDTO proveedoresArray[] = new ProveedorDTO[proveedores.size()]; int j = 0;
			for(ProveedorDTO prov : proveedores) {
				proveedoresArray[j] = prov;
				j++;
			}
			JComboBox comboBox = new JComboBox(proveedoresArray);
			getContentPane().add(comboBox);
			comboBox.setBounds(120, 50 * i + 20, 210, 30);
			JLabel proveedorLabel = new JLabel("Proveedor:");
			getContentPane().add(proveedorLabel);
			proveedorLabel.setBounds(21, 50 * i + 20, 120, 30);
			
			
			
			
			mensaje = new JLabel();
			getContentPane().add(mensaje);
			mensaje.setBounds(21, 50 * i + 20, 200, 30);
			
			
			alta = new JButton();
			getContentPane().add(alta);
			alta.setText("Ok");
			alta.setBounds(260, 50 * i + 20, 70, 30);

			alta.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					boolean error = false;
					String texto = "El insumo se cre� con �xito.";
					mensaje.setForeground(Color.GREEN);
					
					if (!isInteger(texts.get(3).getText())){
						texto = "Stock deber�a ser un n�mero.";
						mensaje.setForeground(Color.RED);
						error = true;
					}
					
					if (!isInteger(texts.get(4).getText())){
						texto = "Cantidad Compra deber�a ser un n�mero.";
						mensaje.setForeground(Color.RED);
						error = true;
					}
					
					if (!isInteger(texts.get(0).getText())){
						texto = "Codigo deber�a ser un n�mero.";
						mensaje.setForeground(Color.RED);
						error = true;
					}
					
					if (!error){
						try {
							if(!controlador.verificarInsumo(Integer.parseInt(texts.get(0).getText()))){
								controlador.altaInsumo(Integer.parseInt(texts.get(0).getText()), texts.get(1).getText(), texts.get(2).getText(),  Integer.parseInt(texts.get(3).getText()), Integer.parseInt(texts.get(4).getText()));
								for (JTextField t : texts) t.setText("");
							}
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
//						} else {
//							Cliente c = controlador.devolverCliente(Integer.parseInt(texts.get(0).getText()));
//							if (!c.isActivo()){
//								c.alta();
//								texto = "El cliente se ha dado de alta.";
//								for (JTextField t : texts) t.setText("");
//							} else {
//								texto = "El cliente ya existe.";
//								mensaje.setForeground(Color.RED);
//							}
//						}

					
					mensaje.setText(texto);
					
				}
					mensaje.setText(texto);
					
				}
			});
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}

}
