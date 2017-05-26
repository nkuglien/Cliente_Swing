package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import modelo.Cliente;
import controlador.Controlador;

public class ModSucursalesPantalla extends javax.swing.JFrame {
	
	private JTextField nrot;
	private JButton mod;
	private JButton	buscar;
	private JLabel mensaje;
	private Controlador controlador;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private ArrayList<JTextField> texts = new ArrayList<JTextField>();
	private String[] nombres = {"Nombre:", "Domicilio:", "Hora Apertura:", "Hora Cierre:"};

	
	public ModSucursalesPantalla(Controlador controlador) {
		super();
		this.controlador = controlador;
		crearPantalla();
	}

	private void crearPantalla() {
		int i = 0;
		try 
		{
			
			setSize(500, 50 * (nombres.length + 2) + 70);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			setTitle("Modificar Sucursal");
			
			JLabel dnib = new JLabel();
			getContentPane().add(dnib);
			dnib.setText("Nro Sucursal:");
			dnib.setBounds(21, 20, 70, 30);
			
			nrot = new JTextField();
			getContentPane().add(nrot);
			nrot.setBounds(120, 20, 210, 30);
			
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
					
					String nro = nrot.getText();
					
					if(isInteger(nro) && controlador.verificarSucursal(Integer.parseInt(nro))){
						SucursalView sv = controlador.solicitarSucursalView(Integer.parseInt(nro));
						for (JLabel l : labels) l.setVisible(true);
						for (JTextField t : texts) t.setVisible(true);
						texts.get(0).setText(nro);
						texts.get(1).setText(sv.nombre);
						texts.get(2).setText(sv.dom);
						texts.get(3).setText(Integer.toString(sv.hApertura));
						texts.get(4).setText(sv.hCierre);
						mod.setVisible(true);
						
						mensaje.setText("");
					} else {
						for (JLabel l : labels) l.setVisible(false);
						for (JTextField t : texts) t.setVisible(false);
						mod.setVisible(false);
						mensaje.setText("La sucursal no existe.");
						mensaje.setForeground(Color.RED);
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
					String texto = "La sucursal se modificó con éxito.";
					mensaje.setForeground(Color.GREEN);
					
					String nro = texts.get(0).getText();
					
					if (!isInteger(texts.get(3).getText())){
						texto = "Hora debería ser un número.";
						mensaje.setForeground(Color.RED);
						error = true;
					}
					
					if (!isInteger(nro)){
						texto = "Numero debería ser un número.";
						mensaje.setForeground(Color.RED);
						error = true;
					}
					
					if (!error){
							SucursaleView sv = controlador.solicitarSucursalView(Integer.parseInt(nro));
							sv.nombre = texts.get(1).getText();
							sv.dom = texts.get(2).getText();
							sv.tel = Integer.parseInt(texts.get(3).getText());
							sv.mail = texts.get(4).getText();
							controlador.modificarCliente(sv, Integer.parseInt(nro));
							for (JTextField t : texts) t.setText("");
					
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