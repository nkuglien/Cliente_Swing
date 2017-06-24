package vistas;
 
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

 
public class MostrarFacturasPantalla extends JFrame {
 
    private JList<String> countryList;
 
    public MostrarFacturasPantalla() {
        //create the model and add elements
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("USA");
        listModel.addElement("India");
        listModel.addElement("Vietnam");
 
        //create the list
        countryList = new JList<>(listModel);
        countryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    //final List<String> selectedValuesList = countryList.getSelectedValuesList();
					DetalleFacturaPantalla ba = new DetalleFacturaPantalla();
					ba.setVisible(true);
                }
            }
        });
 
        add(new JScrollPane(countryList));
 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Facturas");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
 
}