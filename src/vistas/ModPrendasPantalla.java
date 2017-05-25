package vistas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import DTO.PrendaDTO;
import controlador.Controlador;

public class ModPrendasPantalla extends javax.swing.JFrame {
	
	private JTextField codt;
	private JButton mod;
	private JButton	buscar;
	private JLabel mensaje;
	private Controlador controlador;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private ArrayList<JTextField> texts = new ArrayList<JTextField>();
	private String[] nombres = {"Codigo:", "Descripcion:"};

	
	public ModPrendasPantalla(Controlador controlador) {
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
			setTitle("Modificar Prendas");
			
			JLabel dnib = new JLabel();
			getContentPane().add(dnib);
			dnib.setText("Codigo:");
			dnib.setBounds(21, 20, 70, 30);
			
			codt = new JTextField();
			getContentPane().add(codt);
			codt.setBounds(120, 20, 210, 30);
			
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
					
					String cod = codt.getText();
					
					if(isInteger(cod) && controlador.verificarPrenda(Integer.parseInt(cod))){
						PrendaDTO pv = controlador.solicitarPrendaView(Integer.parseInt(cod));
						for (JLabel l : labels) l.setVisible(true);
						for (JTextField t : texts) t.setVisible(true);
						texts.get(0).setText(cod);
						texts.get(1).setText(pv.getDescripcion());
						mod.setVisible(true);
						
						mensaje.setText("");
					} else {
						for (JLabel l : labels) l.setVisible(false);
						for (JTextField t : texts) t.setVisible(false);
						mod.setVisible(false);
						mensaje.setText("La prenda no existe.");
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
					String texto = "La prenda se modific� con �xito.";
					mensaje.setForeground(Color.GREEN);
					
					String cod = texts.get(0).getText();
					
					if (!isInteger(cod)){
						texto = "DNI deber�a ser un n�mero.";
						mensaje.setForeground(Color.RED);
						error = true;
					}
					
					if (!error){
							PrendaDTO pv = controlador.solicitarPrendaView(Integer.parseInt(cod));
							pv.setDescripcion(texts.get(1).getText());
							controlador.modificarPrenda(pv, Integer.parseInt(cod));
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