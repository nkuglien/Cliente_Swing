package vistas;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import DTO.ItemPedidoClienteDTO;
import DTO.PedidoClienteDTO;


public class DetalleFacturaPantalla extends javax.swing.JFrame  {
	

	private JButton alta;
	private JLabel mensaje;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private ArrayList<JTextField> texts = new ArrayList<JTextField>();
	private String[] nombres = {"Numero:", "Nombre:", "CUIT:", "Fecha:", "Total:"};
	private JScrollPane items;
	
	public DetalleFacturaPantalla(PedidoClienteDTO pedidoClienteDTO) {
		super();

		int i=0;
		try 
		{
			
			setSize(400, 600);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			setTitle("Factura");
			
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
			
			//texts.get(0).setText(pedidoClienteDTO.getNroPedido().toString());
			texts.get(1).setText(pedidoClienteDTO.getCliente().getNombre());
			texts.get(2).setText(pedidoClienteDTO.getCliente().getCuit());
			texts.get(3).setText(pedidoClienteDTO.getFechaGeneracion().toString());
			texts.get(4).setText(pedidoClienteDTO.getTotal().toString());
			
			mensaje = new JLabel();
			getContentPane().add(mensaje);
			mensaje.setBounds(21, 50 * i + 20, 200, 30);
			
			
			alta = new JButton();
			getContentPane().add(alta);
			alta.setText("Ok");
			alta.setBounds(260, 50 * i + 20, 70, 30);
			
			DefaultListModel<ItemPedidoClienteDTO> listModel = new DefaultListModel<ItemPedidoClienteDTO>();
	        for(ItemPedidoClienteDTO p : pedidoClienteDTO.getItems()) {
	        	listModel.addElement(p);
	        }
	        items = new JScrollPane(new JList<>(listModel));
	        getContentPane().add(items);
	        items.setBounds(21, 320, 350, 200);
			
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
