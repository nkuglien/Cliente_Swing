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
	private SucursalDTO sucursal;
	
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
						sucursal = controlador.solicitarSucursalView(Integer.parseInt(nro));
						if(sucursal != null){
							for (JLabel l : labels) l.setVisible(true);
							for (JTextField t : texts) t.setVisible(true);						
							texts.get(0).setText(sucursal.getNombre());
							texts.get(1).setText(sucursal.getDireccion());
							texts.get(2).setText(sucursal.getHorarioApertura().toString());
							texts.get(3).setText(sucursal.getHorarioCierre().toString());
							mod.setVisible(true);
							
							mensaje.setText("");
						} else {
							if(isInteger(nro))
								mensaje.setText("La sucursal no existe.");
							else
								mensaje.setText("El numero esta mal escrito.");
							for (JLabel l : labels) l.setVisible(false);
							for (JTextField t : texts) t.setVisible(false);
							mod.setVisible(false);
							
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
					String texto = "La sucursal se modifico con exito.";
					mensaje.setForeground(Color.GREEN);
					
					
					
					if (!isInteger(texts.get(3).getText()) || !isInteger(texts.get(2).getText())){
						texto = "Hora deberia ser un numero.";
						mensaje.setForeground(Color.RED);
						error = true;
					}
					
					
					
					if (!error){
							SucursalDTO sv;
							try {
								sv = new SucursalDTO(sucursal.getNumero(), texts.get(0).getText(), Integer.parseInt(texts.get(2).getText()), Integer.parseInt(texts.get(3).getText()), texts.get(1).getText());
							
							controlador.modificarSucursal(sv);
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