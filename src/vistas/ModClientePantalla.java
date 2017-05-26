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

public class ModClientePantalla extends javax.swing.JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField dnit;
	private JButton mod;
	private JButton	buscar;
	private JLabel mensaje;
	private ClienteDelegate controlador;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private ArrayList<JTextField> texts = new ArrayList<JTextField>();
	private String[] nombres = {"DNI:", "Nombre:", "Domicilio:", "Telefono:", "Mail:"};

	
	public ModClientePantalla() {
		super();
		this.controlador = ClienteDelegate.GetInstancia();
		crearPantalla();
	}

	private void crearPantalla() {
		int i = 0;
		try 
		{
			
			setSize(500, 50 * (nombres.length + 2) + 70);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			setTitle("Modificar Cliente");
			
			JLabel dnib = new JLabel();
			getContentPane().add(dnib);
			dnib.setText("DNI:");
			dnib.setBounds(21, 20, 70, 30);
			
			dnit = new JTextField();
			getContentPane().add(dnit);
			dnit.setBounds(120, 20, 210, 30);
			
			for (i = 0; i < nombres.length; i++){
				JLabel l = new JLabel();
				getContentPane().add(l);
				l.setText(nombres[i]);
				l.setBounds(21, 50 * i + 70, 70, 30);
				l.setVisible(false);
				labels.add(l);
				
				JTextField t = new JTextField();
				getContentPane().add(t);
				t.setBounds(120, 50 * i + 70, 210, 30);
				t.setVisible(false);
				texts.add(t);
			}
			texts.get(0).setEnabled(false);
			
			mensaje = new JLabel();
			getContentPane().add(mensaje);
			mensaje.setBounds(21, 50 * i + 70, 200, 30);
			
			buscar = new JButton();
			getContentPane().add(buscar);
			buscar.setText("Buscar");
			buscar.setBounds(360, 20, 90, 30);
			buscar.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					
					String dni = dnit.getText();
					
					try {
						if(isInteger(dni) && controlador.verificarCliente(Integer.parseInt(dni))){
							ClienteDTO cv = controlador.solicitarClienteView(Integer.parseInt(dni));
							for (JLabel l : labels) l.setVisible(true);
							for (JTextField t : texts) t.setVisible(true);
							texts.get(0).setText(dni);
							texts.get(1).setText(cv.getNombre());
							texts.get(2).setText(cv.getDireccion());
							texts.get(3).setText(cv.getTelefono());
							texts.get(4).setText(cv.getMail());
							mod.setVisible(true);
							
							mensaje.setText("");
						} else {
							for (JLabel l : labels) l.setVisible(false);
							for (JTextField t : texts) t.setVisible(false);
							mod.setVisible(false);
							mensaje.setText("El cliente no existe.");
							mensaje.setForeground(Color.RED);
						}
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}
			});
			
			mod = new JButton();
			getContentPane().add(mod);
			mod.setText("Modificar");
			mod.setBounds(360, 50 * i + 20, 90, 30);
			mod.setVisible(false);
			
			mod.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					boolean error = false;
					String texto = "El cliente se modificó con éxito.";
					mensaje.setForeground(Color.GREEN);
					
					String dni = texts.get(0).getText();
					
					if (!isInteger(texts.get(3).getText())){
						texto = "Teléfono debería ser un número.";
						mensaje.setForeground(Color.RED);
						error = true;
					}
					
					if (!isInteger(dni)){
						texto = "DNI debería ser un número.";
						mensaje.setForeground(Color.RED);
						error = true;
					}
					
					if (!error){
						try {
							ClienteDTO cv;
								cv = controlador.solicitarClienteView(Integer.parseInt(dni));
							cv.setNombre(texts.get(1).getText());
							cv.setDireccion( texts.get(2).getText());
							cv.setTelefono( texts.get(3).getText());
							cv.setMail(texts.get(4).getText());

							controlador.modificarCliente(cv, Integer.parseInt(dni));
							for (JTextField t : texts) t.setText("");
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
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