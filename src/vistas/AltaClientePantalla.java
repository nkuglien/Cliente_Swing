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

import DTO.ClienteDTO;
import businessDelegates.ClienteDelegate;

public class AltaClientePantalla extends javax.swing.JFrame  {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton alta;
	private JLabel mensaje;
	private ClienteDelegate clienteBD;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private ArrayList<JTextField> texts = new ArrayList<JTextField>();
	private String[] nombres = {"CUIT:", "Nombre:", "Domicilio:", "Telefono:", "Limite de Credito"};

	
	public AltaClientePantalla() {
		super();
		this.clienteBD = ClienteDelegate.GetInstancia();
		crearPantalla();
	}

	private void crearPantalla() {
		int i=0;
		try 
		{
			
			setSize(400, 50 * (nombres.length + 2) + 20);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			setTitle("Alta Cliente");
			
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
					String texto = "El cliente se creo con exito.";
					mensaje.setForeground(Color.GREEN.darker());
					
					if (!isInteger(texts.get(3).getText())){
						texto = "Telefono debera ser un numero.";
						mensaje.setForeground(Color.RED);
						error = true;
					}
					
					if (!isInteger(texts.get(0).getText())){
						texto = "CUIT debera ser un numero.";
						mensaje.setForeground(Color.RED);
						error = true;
					}
					
					if (!isInteger(texts.get(4).getText())){
						texto = "Limite de credito debera ser un numero.";
						mensaje.setForeground(Color.RED);
						error = true;
					}
					
					if (!error){
						try {
							ClienteDTO cliente = clienteBD.buscarCliente(texts.get(0).getText());
							if(cliente == null){
								clienteBD.altaCliente(texts.get(0).getText(), texts.get(1).getText(), texts.get(2).getText(), texts.get(3).getText(), new Float(texts.get(4).getText()));
								for (JTextField t : texts) t.setText("");
							} else {
								texto = "Ya existe cliente con ese cuit";
								mensaje.setForeground(Color.RED);
								error = true;
							}
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
//							else {
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
