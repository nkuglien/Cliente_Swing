package vistas;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import DTO.InsumoProveedorDTO;
import DTO.ProveedorDTO;
import businessDelegates.ProveedorDelegate;

public class AltaProveedoresPantalla extends javax.swing.JFrame  {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton alta;
	private JLabel mensaje;
	private ProveedorDelegate controlador;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private ArrayList<JTextField> texts = new ArrayList<JTextField>();
	private String[] nombres = {"Nombre:"};

	
	public AltaProveedoresPantalla() {
		super();
		this.controlador = ProveedorDelegate.GetInstancia();
		crearPantalla();
	}

	private void crearPantalla() {
		int i=0;
		try 
		{
			
			setSize(400, 50 * (nombres.length + 2) + 20);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			setTitle("Alta Proveedor");
			
			for (i = 0; i < nombres.length; i++){
				JLabel l = new JLabel();
				getContentPane().add(l);
				l.setText(nombres[i]);
				l.setBounds(21, 50 * i + 20, 70, 30);
				labels.add(l);
				
				JTextField t = new JTextField();
				getContentPane().add(t);
				t.setBounds(120, 50 * i + 20, 210, 30);
				texts.add(t);
			}
			
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
					String texto = "El proveedor se creo con �xito.";
					mensaje.setForeground(Color.GREEN.darker());
					
					
					
					
					if (!error){
						try {

								ProveedorDTO dto = new  ProveedorDTO();
								dto.setInsumos(new ArrayList<InsumoProveedorDTO>());
								dto.setNombre(texts.get(0).getText());
								controlador.altaProveedor(dto);
								for (JTextField t : texts) t.setText("");

						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
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
