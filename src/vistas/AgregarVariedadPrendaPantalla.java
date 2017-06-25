package vistas;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import DTO.AreaProduccionDTO;
import DTO.InsumoDTO;
import DTO.ItemInsumoDTO;
import DTO.PrendaAreaProduccionDTO;
import DTO.PrendaDTO;
import DTO.VariedadPrendaDTO;
import businessDelegates.InsumoDelegate;
import businessDelegates.PrendaDelegate;
import businessDelegates.SucursalDelegate;
import controlador.Controlador;

public class AgregarVariedadPrendaPantalla extends javax.swing.JFrame  {
	

	private JButton alta;
	private JLabel mensaje;
	private JLabel msj;
	private PrendaDelegate controlador;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private ArrayList<JTextField> texts = new ArrayList<JTextField>();
	private String[] nombres = {};
	private List<PrendaDTO> prendas;
	private List<InsumoDTO> insumos;


	
	public AgregarVariedadPrendaPantalla() {
		super();
		this.controlador = PrendaDelegate.GetInstancia();
		try {
			prendas = controlador.getAllPrendas();
			insumos = InsumoDelegate.GetInstancia().getAllInsumos();
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
			
			setSize(500, 400 + 20);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			setTitle("Alta VariedadPrendas");
			
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
			mensaje.setBounds(21, 340, 300, 30);
			
			JLabel precioLabel = new JLabel();
			getContentPane().add(precioLabel);
			precioLabel.setText("Cantidad:");
			precioLabel.setBounds(355, 130, 120, 30);
			
			alta = new JButton();
			getContentPane().add(alta);
			alta.setText("Ok");
			alta.setBounds(360, 330, 70, 30);
			
			Predicate<PrendaDTO> enProduccionPredicate = p-> !p.getEnProduccion();
			prendas.removeIf(enProduccionPredicate);
			PrendaDTO prendasArray[] = new PrendaDTO[prendas.size()+1];
			prendasArray[0] = null;
			int j = 1;
			for (PrendaDTO p : prendas) {
				prendasArray[j] = p;
				j++;
			}
			final JComboBox comboBox = new JComboBox(prendasArray);
			getContentPane().add(comboBox);
			comboBox.setBounds(120, 20, 210, 30);
			JLabel proveedorLabel = new JLabel("Prenda:");
			getContentPane().add(proveedorLabel);
			proveedorLabel.setBounds(21, 20, 90, 30);
			
			String[] talles = {"XS","S","M","L","XL","XXL"};
			final JComboBox comboBox1 = new JComboBox(talles);
			getContentPane().add(comboBox1);
			comboBox1.setBounds(120, 60, 210, 30);
			JLabel proveedorLabel1 = new JLabel("Talle:");
			getContentPane().add(proveedorLabel1);
			proveedorLabel1.setBounds(21, 60, 90, 30);
			
			String[] colores = {"Blanco","Negro","Rojo","Azul","Amarillo","Violeta", "Naranja"};
			final JComboBox comboBox2 = new JComboBox(colores);
			getContentPane().add(comboBox2);
			comboBox2.setBounds(120, 100, 210, 30);
			JLabel proveedorLabel2 = new JLabel("Color:");
			getContentPane().add(proveedorLabel2);
			proveedorLabel2.setBounds(21, 100, 90, 30);
			
			InsumoDTO[] insumosArray = new InsumoDTO[insumos.size()+1];
			insumosArray[0] = null;
			int k = 1;
			for (InsumoDTO ins : insumos) {
				insumosArray[k] = ins;
				k++;
			}			
			final JComboBox comboBox5 = new JComboBox(insumosArray);
			getContentPane().add(comboBox5);
			comboBox5.setBounds(120, 200, 210, 30);
			JLabel proveedorLabel5 = new JLabel("Insumo:");
			getContentPane().add(proveedorLabel5);
			proveedorLabel5.setBounds(21, 200, 90, 30);
			
			final JTextField precio5 = new JTextField();
			getContentPane().add(precio5);
			precio5.setBounds(350, 200, 60, 30);
			
			final JComboBox comboBox6 = new JComboBox(insumosArray);
			getContentPane().add(comboBox6);
			comboBox6.setBounds(120, 160, 210, 30);
			JLabel proveedorLabel6 = new JLabel("Insumo:");
			getContentPane().add(proveedorLabel6);
			proveedorLabel6.setBounds(21, 160, 90, 30);
			
			final JTextField precio6 = new JTextField();
			getContentPane().add(precio6);
			precio6.setBounds(350, 160, 60, 30);
			
			final JComboBox comboBox3 = new JComboBox(insumosArray);
			getContentPane().add(comboBox3);
			comboBox3.setBounds(120, 240, 210, 30);
			JLabel proveedorLabel3 = new JLabel("Insumo:");
			getContentPane().add(proveedorLabel3);
			proveedorLabel3.setBounds(21, 240, 90, 30);
			
			final JTextField precio3 = new JTextField();
			getContentPane().add(precio3);
			precio3.setBounds(350, 240, 60, 30);
			
			final JComboBox comboBox4 = new JComboBox(insumosArray);
			getContentPane().add(comboBox4);
			comboBox4.setBounds(120, 280, 210, 30);
			JLabel proveedorLabel4 = new JLabel("Insumo:");
			getContentPane().add(proveedorLabel4);
			proveedorLabel4.setBounds(21, 280, 90, 30);
			
			final JTextField precio4 = new JTextField();
			getContentPane().add(precio4);
			precio4.setBounds(350, 280, 60, 30);
			
			JLabel proveedorLabel7 = new JLabel("Cant Prod:");
			getContentPane().add(proveedorLabel7);
			proveedorLabel7.setBounds(21, 320, 90, 30);
			
			final JTextField precio7 = new JTextField();
			getContentPane().add(precio7);
			precio7.setBounds(120, 320, 60, 30);
			
			List<JComboBox> insumoCombos = new ArrayList<JComboBox>();
			insumoCombos.add(comboBox6);
			insumoCombos.add(comboBox5);
			insumoCombos.add(comboBox3);
			insumoCombos.add(comboBox4);
			
			List<JTextField> cantidadFields = new ArrayList<JTextField>();
			cantidadFields.add(precio6);
			cantidadFields.add(precio5);
			cantidadFields.add(precio3);
			cantidadFields.add(precio4);

			alta.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					boolean error = false;
					String texto = "La prenda se creo con exito.";
					mensaje.setForeground(Color.GREEN.darker());

					String cantProd = precio7.getText();
					if (!isInteger(cantProd)){
						texto = "La cantidad de produccion debe ser un numero.";
						mensaje.setForeground(Color.RED);
						error = true;
					}
					
					boolean todoInsumsVacios = true;
					for(JComboBox c :insumoCombos) {
						if (c.getSelectedItem()!=null){
							todoInsumsVacios = false;
						}
					}
					if(todoInsumsVacios) {
						texto = "Seleccione insumos.";
						mensaje.setForeground(Color.RED);
						error = true;
					}

					
					int m = 0;
					for(JComboBox c :insumoCombos) {
						if (c.getSelectedItem()!=null && !isInteger(cantidadFields.get(m).getText())){
							texto = "Complete la cantidad de los insumos";
							mensaje.setForeground(Color.RED);
							error = true;
							break;
						}
						m++;
					}
					
					PrendaDTO prendaSeleccionada = (PrendaDTO) comboBox.getSelectedItem();
					if (prendaSeleccionada == null){
						texto = "Debe seleccionar una prenda.";
						mensaje.setForeground(Color.RED);
						error = true;
					}
					
					
					if (!error){
						try {
							if(true){
								VariedadPrendaDTO varPrenda = new VariedadPrendaDTO();
								varPrenda.setPrenda(prendaSeleccionada);
								varPrenda.setCantidadProduccionFija(Integer.parseInt(cantProd));
								varPrenda.setTalle(comboBox1.getSelectedItem().toString());
								varPrenda.setColor(comboBox2.getSelectedItem().toString());
								varPrenda.setEnProduccion(true);
								
								List<ItemInsumoDTO> insumos = new ArrayList<ItemInsumoDTO>();
								int i = 0;
								for(JComboBox c : insumoCombos) {
									if(c.getSelectedItem()!=null) {
										ItemInsumoDTO itemInsumo = new ItemInsumoDTO();
										itemInsumo.setInsumo((InsumoDTO) c.getSelectedItem());
										itemInsumo.setCantidad(Integer.parseInt(cantidadFields.get(i).getText()));
										insumos.add(itemInsumo);
									}
									i++;
								}
								varPrenda.setInsumos(insumos);
								controlador.altaVariedadPrenda(varPrenda);
								for (JTextField t : texts) t.setText("");

							} else {
								texto = "Ya exste una variedad prenda con ese codigo.";
								mensaje.setForeground(Color.RED);
								error = true;
							}
						} catch (NumberFormatException | RemoteException e) {
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
