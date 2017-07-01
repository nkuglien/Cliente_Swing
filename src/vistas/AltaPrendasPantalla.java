package vistas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import DTO.AreaProduccionDTO;
import DTO.InsumoDTO;
import DTO.PrendaAreaProduccionDTO;
import DTO.PrendaDTO;
import businessDelegates.PrendaDelegate;

public class AltaPrendasPantalla extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1960719192206588242L;
	private JButton alta;
	private JLabel mensaje;
	private PrendaDelegate controlador;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private ArrayList<JTextField> texts = new ArrayList<JTextField>();
	private String[] nombres = { "Codigo:", "Descripcion:" };
	private List<AreaProduccionDTO> areas;


	public AltaPrendasPantalla() {
		super();
		this.controlador = PrendaDelegate.GetInstancia();
		try {
			areas = controlador.getAllAreasProduccion();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		crearPantalla();
	}

	private void crearPantalla() {
		int i = 0;
		try {

			setSize(500, 100 * (nombres.length + 2) + 20);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			setTitle("Alta Prendas");

			for (i = 0; i < nombres.length; i++) {
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
			mensaje.setBounds(90, 370, 200, 30);

			JLabel precioLabel = new JLabel();
			getContentPane().add(precioLabel);
			precioLabel.setText("Tiempo:");
			precioLabel.setBounds(360, 90, 120, 30);

			alta = new JButton();
			getContentPane().add(alta);
			alta.setText("Ok");
			alta.setBounds(260, 330, 70, 30);
			
			AreaProduccionDTO[] areasArray = new AreaProduccionDTO[areas.size()+1];
			areasArray[0] = null;
			int k = 1;
			for (AreaProduccionDTO ins : areas) {
				areasArray[k] = ins;
				k++;
			}
			

			final JComboBox comboBox = new JComboBox(areasArray);
			getContentPane().add(comboBox);
			comboBox.setBounds(120, 120, 210, 30);
			JLabel areaLabel = new JLabel("Area:");
			getContentPane().add(areaLabel);
			areaLabel.setBounds(21, 120, 90, 30);
			final JTextField precio = new JTextField();
			getContentPane().add(precio);
			precio.setBounds(350, 120, 60, 30);

			final JComboBox comboBox1 = new JComboBox(areasArray);
			getContentPane().add(comboBox1);
			comboBox1.setBounds(120, 160, 210, 30);
			JLabel areaLabel1 = new JLabel("Area:");
			getContentPane().add(areaLabel1);
			areaLabel1.setBounds(21, 160, 90, 30);
			final JTextField precio1 = new JTextField();
			getContentPane().add(precio1);
			precio1.setBounds(350, 160, 60, 30);

			final JComboBox comboBox2 = new JComboBox(areasArray);
			getContentPane().add(comboBox2);
			comboBox2.setBounds(120, 200, 210, 30);
			JLabel areaLabel2 = new JLabel("Area:");
			getContentPane().add(areaLabel2);
			areaLabel2.setBounds(21, 200, 90, 30);
			final JTextField precio2 = new JTextField();
			getContentPane().add(precio2);
			precio2.setBounds(350, 200, 60, 30);

			final JComboBox comboBox3 = new JComboBox(areasArray);
			getContentPane().add(comboBox3);
			comboBox3.setBounds(120, 240, 210, 30);
			JLabel areaLabel3 = new JLabel("Area:");
			getContentPane().add(areaLabel3);
			areaLabel3.setBounds(21, 240, 90, 30);
			final JTextField precio3 = new JTextField();
			getContentPane().add(precio3);
			precio3.setBounds(350, 240, 60, 30);

			final JComboBox comboBox4 = new JComboBox(areasArray);
			getContentPane().add(comboBox4);
			comboBox4.setBounds(120, 280, 210, 30);
			JLabel areaLabel4 = new JLabel("Area:");
			getContentPane().add(areaLabel4);
			areaLabel4.setBounds(21, 280, 90, 30);
			final JTextField precio4 = new JTextField();
			getContentPane().add(precio4);
			precio4.setBounds(350, 280, 60, 30);
			
			JCheckBox checkbox2 = new JCheckBox("Discontinuo");		
			getContentPane().add(checkbox2);
			checkbox2.setBounds(21, 320, 100, 45);
			
			List<JComboBox> areaCombos = new ArrayList<JComboBox>();
			areaCombos.add(comboBox);
			areaCombos.add(comboBox1);
			areaCombos.add(comboBox2);
			areaCombos.add(comboBox3);
			areaCombos.add(comboBox4);
			
			List<JTextField> tiempoFields = new ArrayList<JTextField>();
			tiempoFields.add(precio);
			tiempoFields.add(precio1);
			tiempoFields.add(precio2);
			tiempoFields.add(precio3);
			tiempoFields.add(precio4);

			alta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					boolean error = false;
					String texto = "La prenda se creo con exito.";
					mensaje.setForeground(Color.GREEN.darker());

					if (!isInteger(texts.get(0).getText())) {
						texto = "Codigo deberia ser un numero.";
						mensaje.setForeground(Color.RED);
						error = true;
					}

					if (!error) {
						try {
							if (controlador.solicitarPrendaView(Long.parseLong(texts.get(0).getText())) == null) {
								
								PrendaDTO prenda = new PrendaDTO();
								prenda.setDescripcion(texts.get(1).getText());
								prenda.setCodigo(Long.parseLong(texts.get(0).getText()));
								
								List<PrendaAreaProduccionDTO> areas = new ArrayList<PrendaAreaProduccionDTO>();
								int i = 0;
								for(JComboBox c : areaCombos) {
									if(c.getSelectedItem()!=null) {
										PrendaAreaProduccionDTO prendaArea = new PrendaAreaProduccionDTO();
										prendaArea.setArea((AreaProduccionDTO) c.getSelectedItem());
										prendaArea.setTiempo(Integer.parseInt(tiempoFields.get(i).getText()));
										areas.add(prendaArea);
									}
									i++;
								}
								prenda.setAreas(areas);
								controlador.altaPrenda(prenda);
								
								for (JTextField t : texts)
									t.setText("");
							} else {
								texto = "Codigo de prenda ya existente.";
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
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

}
