package vistas;
 
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DTO.PedidoClienteDTO;
import businessDelegates.PedidoDelegate;
import businessDelegates.PrendaDelegate;

 
public class MostrarFacturasPantalla extends JFrame {
 
    private JList<PedidoClienteDTO> pedidosLista;
	private PedidoDelegate controlador;
	private List<PedidoClienteDTO> pedidos;
	private DetalleFacturaPantalla ba;
 
    public MostrarFacturasPantalla() {
    	
    	this.controlador = PedidoDelegate.GetInstancia();
		try {
			pedidos = controlador.getAllPedidos();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        //create the model and add elements
        DefaultListModel<PedidoClienteDTO> listModel = new DefaultListModel<PedidoClienteDTO>();
        for(PedidoClienteDTO p : pedidos) {
        	listModel.addElement(p);
        }

 
        //create the list
        pedidosLista = new JList<>(listModel);
        pedidosLista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
					ba = new DetalleFacturaPantalla(pedidosLista.getSelectedValue());
					ba.setVisible(true);
                }
            }
        });
 
        add(new JScrollPane(pedidosLista));
 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Facturas");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
 
}