package vistas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import businessDelegates.SucursalDelegate;


public class BajaSucursalesPantalla extends javax.swing.JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton baja;
	private JLabel label;
	private JTextField text;
	private JLabel mensaje;
	private SucursalDelegate controlador;
	
	public BajaSucursalesPantalla(SucursalDelegate controlador) {
		super();
		this.controlador = controlador;
		crearPantalla();
	}
	
	private void crearPantalla() {
		try 
		{
			
			setSize(400, 150);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			setTitle("Baja Cliente");
			
			label = new JLabel();
			getContentPane().add(label);
			label.setText("Numero Sucursal: ");
			label.setBounds(21, 20, 70, 30);
			
			text = new JTextField();
			getContentPane().add(text);
			text.setBounds(120, 20, 210, 30);		
			
			mensaje = new JLabel();
			getContentPane().add(mensaje);
			mensaje.setBounds(21, 70, 200, 30);
			
			baja = new JButton();
			getContentPane().add(baja);
			baja.setText("Baja");
			baja.setBounds(260, 70, 70, 30);
 
			baja.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) {
					
					boolean error = false;
					String texto = "La sucursal fue dada de baja.";
					mensaje.setForeground(Color.GREEN);
					
					if (!isInteger(text.getText())){
						texto = "Numero debería ser un número.";
						mensaje.setForeground(Color.RED);
						error = true;
					}
					
					if (!error){
						if(controlador.verificarSucursal(Integer.parseInt(text.getText()))){
							controlador.bajaSucursal(Integer.parseInt(text.getText()));
							text.setText("");
						} else {
							texto = "La sucursal no existe.";
							mensaje.setForeground(Color.RED);
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
