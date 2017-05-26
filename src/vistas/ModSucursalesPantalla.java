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

import DTO.SucursalDTO;
import businessDelegates.SucursalDelegate;
import controlador.Controlador;

public class ModSucursalesPantalla extends javax.swing.JFrame {
	
	private JTextField nrot;
	private JButton mod;
	private JButton	buscar;
	private JLabel mensaje;
	private SucursalDelegate controlador;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private ArrayList<JTextField> texts = new ArrayList<JTextField>();
	private String[] nombres = {"Nombre:", "Domicilio:", "Hora Apertura:", "Hora Cierre:"};

	
	public ModSucursalesPantalla() {
		super();
		this.controlador = SucursalDelegate.GetInstancia();
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
					
					try {
						if(isInteger(nro) && controlador.verificarSucursal(Integer.parseInt(nro))){
							SucursalDTO sv = controlador.solicitarSucursalView(Integer.parseInt(nro));
							for (JLabel l : labels) l.setVisible(true);
							for (JTextField t : texts) t.setVisible(true);
							texts.get(0).setText(nro);
							texts.get(1).setText(sv.getNombre());
							texts.get(2).setText(sv.getDireccion());
							texts.get(3).setText(sv.getHorarioApertura().toString());
							texts.get(4).setText(sv.getHorarioCierre().toString());
							mod.setVisible(true);
							
							mensaje.setText("");
						} else {
							for (JLabel l : labels) l.setVisible(false);
							for (JTextField t : texts) t.setVisible(false);
							mod.setVisible(false);
							mensaje.setText("La sucursal no existe.");
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
					String texto = "La sucursal se modific� con �xito.";
					mensaje.setForeground(Color.GREEN);
					
					String nro = texts.get(0).getText();
					
					if (!isInteger(texts.get(3).getText())){
						texto = "Hora deber�a ser un n�mero.";
						mensaje.setForeground(Color.RED);
						error = true;
					}
					
					if (!isInteger(nro)){
						texto = "Numero deber�a ser un n�mero.";
						mensaje.setForeground(Color.RED);
						error = true;
					}
					
					if (!error){
							SucursalDTO sv;
							try {
								sv = controlador.solicitarSucursalView(Integer.parseInt(nro));
							sv.setNombre(texts.get(1).getText());
							sv.setDireccion(texts.get(2).getText());
							controlador.modificarSucursal(sv, Integer.parseInt(nro));
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