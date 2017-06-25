package vistas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import DTO.AreaProduccionDTO;
import DTO.PrendaAreaProduccionDTO;
import DTO.PrendaDTO;
import DTO.VariedadPrendaDTO;
import businessDelegates.PrendaDelegate;
import controlador.Controlador;

public class ModPrendasPantalla extends javax.swing.JFrame {

	private JTextField codt;
	private JButton mod;
	private JButton buscar;
	private JLabel mensaje;
	private PrendaDelegate controlador;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private ArrayList<JTextField> texts = new ArrayList<JTextField>();
	private String[] nombres = { "Codigo:", "Descripcion:" };
	private PrendaDTO prenda;
	private List<AreaProduccionDTO> areas;
	private JButton eliminarVariedad;
	private VariedadPrendaDTO[] varPrendasArray;
	private JComboBox variedadPrendaCombo;


	public ModPrendasPantalla() {
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

			setSize(500, 500);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			setTitle("Modificar Prendas");

			JLabel dnib = new JLabel();
			getContentPane().add(dnib);
			dnib.setText("Codigo:");
			dnib.setBounds(21, 20, 70, 30);
			
			variedadPrendaCombo = new JComboBox();
			getContentPane().add(variedadPrendaCombo);
			variedadPrendaCombo.setBounds(120, 360, 210, 30);
			variedadPrendaCombo.setVisible(false);
			JLabel varLabel = new JLabel("Variedad:");
			getContentPane().add(varLabel);
			varLabel.setBounds(21, 360, 90, 30);

			codt = new JTextField();
			getContentPane().add(codt);
			codt.setBounds(120, 20, 210, 30);

			for (i = 0; i < nombres.length; i++) {
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
				
				AreaProduccionDTO[] areasArray = new AreaProduccionDTO[areas.size()+1];
				areasArray[0] = null;
				int k = 1;
				for (AreaProduccionDTO ins : areas) {
					areasArray[k] = ins;
					k++;
				}
			}
			
			AreaProduccionDTO[] areasArray = new AreaProduccionDTO[areas.size()+1];
			areasArray[0] = null;
			int k = 1;
			for (AreaProduccionDTO ins : areas) {
				areasArray[k] = ins;
				k++;
			}

			final JComboBox comboBox = new JComboBox(areasArray);
			getContentPane().add(comboBox);
			comboBox.setBounds(120, 160, 210, 30);
			JLabel areaLabel = new JLabel("Area:");
			getContentPane().add(areaLabel);
			areaLabel.setBounds(21, 160, 90, 30);
			final JTextField precio = new JTextField();
			getContentPane().add(precio);
			precio.setBounds(350, 160, 60, 30);

			final JComboBox comboBox1 = new JComboBox(areasArray);
			getContentPane().add(comboBox1);
			comboBox1.setBounds(120, 200, 210, 30);
			JLabel areaLabel1 = new JLabel("Area:");
			getContentPane().add(areaLabel1);
			areaLabel1.setBounds(21, 200, 90, 30);
			final JTextField precio1 = new JTextField();
			getContentPane().add(precio1);
			precio1.setBounds(350, 200, 60, 30);

			final JComboBox comboBox2 = new JComboBox(areasArray);
			getContentPane().add(comboBox2);
			comboBox2.setBounds(120, 240, 210, 30);
			JLabel areaLabel2 = new JLabel("Area:");
			getContentPane().add(areaLabel2);
			areaLabel2.setBounds(21, 240, 90, 30);
			final JTextField precio2 = new JTextField();
			getContentPane().add(precio2);
			precio2.setBounds(350, 240, 60, 30);

			final JComboBox comboBox3 = new JComboBox(areasArray);
			getContentPane().add(comboBox3);
			comboBox3.setBounds(120, 280, 210, 30);
			JLabel areaLabel3 = new JLabel("Area:");
			getContentPane().add(areaLabel3);
			areaLabel3.setBounds(21, 280, 90, 30);
			final JTextField precio3 = new JTextField();
			getContentPane().add(precio3);
			precio3.setBounds(350, 280, 60, 30);

			final JComboBox comboBox4 = new JComboBox(areasArray);
			getContentPane().add(comboBox4);
			comboBox4.setBounds(120, 320, 210, 30);
			JLabel areaLabel4 = new JLabel("Area:");
			getContentPane().add(areaLabel4);
			areaLabel4.setBounds(21, 320, 90, 30);
			final JTextField precio4 = new JTextField();
			getContentPane().add(precio4);
			precio4.setBounds(350, 320, 60, 30);
			
			List<JComboBox> areaCombos = new ArrayList<JComboBox>();
			areaCombos.add(comboBox);
			areaCombos.add(comboBox1);
			areaCombos.add(comboBox2);
			areaCombos.add(comboBox3);
			areaCombos.add(comboBox4);
			for(JComboBox c : areaCombos) c.setVisible(false);
			
			List<JTextField> tiempoFields = new ArrayList<JTextField>();
			tiempoFields.add(precio);
			tiempoFields.add(precio1);
			tiempoFields.add(precio2);
			tiempoFields.add(precio3);
			tiempoFields.add(precio4);
			for(JTextField f : tiempoFields) f.setVisible(false);
			
			texts.get(0).setEnabled(false);

			mensaje = new JLabel();
			getContentPane().add(mensaje);
			mensaje.setBounds(40, 450, 300, 30);

			buscar = new JButton();
			getContentPane().add(buscar);
			buscar.setText("Buscar");
			buscar.setBounds(360, 20, 90, 30);
			buscar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					try {
						getContentPane().remove(variedadPrendaCombo);
						
						for(JTextField f : tiempoFields) f.setText("");
						for(JComboBox c : areaCombos) c.setSelectedItem(null);
						
						String cod = codt.getText();
						if(!isInteger(cod)) {
							mensaje.setText("El codigo debe ser un numero.");
							mensaje.setForeground(Color.RED);
							for (JLabel l : labels)
								l.setVisible(false);
							for (JTextField t : texts)
								t.setVisible(false);
							mod.setVisible(false);
							for(JComboBox c : areaCombos) c.setVisible(false);
							for(JTextField f : tiempoFields) f.setVisible(false);
							variedadPrendaCombo.setVisible(false);
							if(eliminarVariedad!=null) eliminarVariedad.setVisible(false);
							
						} else {
							prenda = controlador.solicitarPrendaView(Long.parseLong(cod));
							if (prenda != null) {

								for (JLabel l : labels)
									l.setVisible(true);
								for (JTextField t : texts)
									t.setVisible(true);
								
								int i = 0;
								for(JTextField f : tiempoFields) {
									if(prenda.getAreas().size() > i) {
										f.setText(((PrendaAreaProduccionDTO)prenda.getAreas().get(i)).getTiempo().toString());
									}
									f.setVisible(true);
									i++;
								}
								
								int j = 0;
								for (JComboBox c : areaCombos) {
									if (prenda.getAreas().size() > j) {
										for (int x = 1; x < c.getItemCount(); x = x + 1) {
											if (((AreaProduccionDTO) c.getItemAt(x))
													.getCodigo().equals((((PrendaAreaProduccionDTO) prenda.getAreas().get(j))
															.getArea()).getCodigo())) {
												c.setSelectedIndex(x);
											}
										}
									}
									c.setVisible(true);
									j++;
								}
								texts.get(0).setText(cod);
								texts.get(1).setText(prenda.getDescripcion());
								mod.setVisible(true);

								
								varPrendasArray = new VariedadPrendaDTO[prenda.getVariedades().size()];
								int k = 0;
								for (VariedadPrendaDTO vp : prenda.getVariedades()) {
									varPrendasArray[k] = vp;
									k++;
								}
								
								variedadPrendaCombo = new JComboBox(varPrendasArray);
								getContentPane().add(variedadPrendaCombo);
								variedadPrendaCombo.setBounds(120, 360, 210, 30);
								
								
								eliminarVariedad = new JButton();
								getContentPane().add(eliminarVariedad);
								eliminarVariedad.setBounds(350, 360, 150, 30);
								eliminarVariedad.setText("Eliminar Variedad");
								eliminarVariedad.addActionListener(new ActionListener() {

									public void actionPerformed(ActionEvent arg0) {
										try {
											controlador.bajaVariedadPrenda((VariedadPrendaDTO)variedadPrendaCombo.getSelectedItem());
											mensaje.setForeground(Color.GREEN.darker());
											mensaje.setText("Se elimino la variedad.");
											buscar.doClick();
										} catch (RemoteException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
									}
								});

								mensaje.setText("");
							} else {
								for (JLabel l : labels)
									l.setVisible(false);
								for (JTextField t : texts)
									t.setVisible(false);
								mod.setVisible(false);
								for(JComboBox c : areaCombos) c.setVisible(false);
								for(JTextField f : tiempoFields) f.setVisible(false);
								eliminarVariedad.setVisible(false);
								mensaje.setText("La prenda no existe.");
								mensaje.setForeground(Color.RED);
							}
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

			mod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					boolean error = false;
					String texto = "La prenda se modifico con Exito.";
					mensaje.setForeground(Color.GREEN.darker());

					String cod = texts.get(0).getText();

					if (!error) {
						try {
							
							prenda.setDescripcion(texts.get(1).getText());
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
							controlador.modificarPrenda(prenda);

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
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

}