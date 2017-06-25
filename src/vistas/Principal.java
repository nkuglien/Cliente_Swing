package vistas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import DTO.InsumoDTO;
import vistas.AltaClientePantalla;
import vistas.ModClientePantalla;
import vistas.Principal;
import controlador.Controlador;


public class Principal extends javax.swing.JFrame  {
	private JMenuBar jMenuBar;
	private JMenu jMenuClientes;
	private JMenuItem jMenuClientesAlta;
	private JMenuItem jMenuClientesMod;
	private JMenuItem jMenuClientesBaja;
	private JMenu jMenuSucursales;
	private JMenuItem jMenuSucursalesAlta;
	private JMenuItem jMenuSucursalesMod;
	private JMenuItem jMenuSucursalesBaja;
	private JMenu jMenuInsumos;
	private JMenuItem jMenuInsumosAlta;
	private JMenuItem jMenuInsumosMod;
	private JMenuItem jMenuInsumosBaja;
	private JMenu jMenuPrendas;
	private JMenuItem jMenuPrendasAlta;
	private JMenuItem jMenuPrendasBaja;
	private JMenuItem jMenuPrendasMod;
	private JMenu jMenuProveedores;
	private JMenuItem jMenuProveedoresAlta;
	private JMenuItem jMenuProveedoresMod;
	private JMenuItem jMenuProveedoresBaja;
	private JMenu jMenuDeuda;
	private JMenuItem jMenuCancelarDeuda;
	private JMenuItem JMenuGenerarDeudas;
	private JMenuItem JMenuControlarPagos;
	
	private Controlador controlador;
	private AbstractButton jMenuVariedadPrenda;
	private JMenu jMenuPedidos;
	private JMenuItem jMenuPedidosVer;
	
	public static void main(String[] args) 
	{
		Principal inst = new Principal();
		inst.setVisible(true);
	}
	
	public Principal()
{
		super();
		initGUI();
		controlador = new Controlador();
	}
	
	private void initGUI() 
	{
		try 
		{
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setTitle("ABMs");
			
			jMenuBar = new JMenuBar();
			setJMenuBar(jMenuBar);
			jMenuBar.setPreferredSize(new java.awt.Dimension(700, 30));
				

			//Menu Clientes =========================================================
			jMenuClientes = new JMenu();
			jMenuBar.add(jMenuClientes);
			jMenuClientes.setText("Clientes");
			jMenuClientes.setPreferredSize(new java.awt.Dimension(66, 21));
					
			jMenuClientesAlta = new JMenuItem();
			jMenuClientes.add(jMenuClientesAlta);
			jMenuClientesAlta.setText("Alta");
			jMenuClientesAlta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					AltaClientePantalla ac = new AltaClientePantalla();
					ac.setVisible(true);
				}
			});
		
		
			jMenuClientesMod = new JMenuItem();
			jMenuClientes.add(jMenuClientesMod);
			jMenuClientesMod.setText("Modificacion");
			jMenuClientesMod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					ModClientePantalla ca = new ModClientePantalla();
					ca.setVisible(true);
				}
			});
		
			jMenuClientesBaja = new JMenuItem();
			jMenuClientes.add(jMenuClientesBaja);
			jMenuClientesBaja.setText("Baja");
			jMenuClientesBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					BajaClientePantalla ba = new BajaClientePantalla();
					ba.setVisible(true);
				}
			});
			
			//Menu Sucursales ============================================================
			jMenuSucursales = new JMenu();
			jMenuBar.add(jMenuSucursales);
			jMenuSucursales.setText("Sucursales");
			
			jMenuSucursalesAlta = new JMenuItem();
			jMenuSucursales.add(jMenuSucursalesAlta);
			jMenuSucursalesAlta.setText("Alta");
			jMenuSucursalesAlta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					AltaSucursalesPantalla aa = new AltaSucursalesPantalla();
					aa.setVisible(true);
				}
			});
			
			jMenuSucursalesMod = new JMenuItem();
			jMenuSucursales.add(jMenuSucursalesMod);
			jMenuSucursalesMod.setText("Modificacion");
			jMenuSucursalesMod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					ModSucursalesPantalla ma = new ModSucursalesPantalla();
					ma.setVisible(true);
				}
			});
			
			jMenuSucursalesBaja = new JMenuItem();
			jMenuSucursales.add(jMenuSucursalesBaja);
			jMenuSucursalesBaja.setText("Baja");
			jMenuSucursalesBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					BajaSucursalesPantalla ba = new BajaSucursalesPantalla();
					ba.setVisible(true);
				}
			});
			
			//Menu Insumos ============================================================
			jMenuInsumos = new JMenu();
			jMenuBar.add(jMenuInsumos);
			jMenuInsumos.setText("Insumos");
			
			jMenuInsumosAlta = new JMenuItem();
			jMenuInsumos.add(jMenuInsumosAlta);
			jMenuInsumosAlta.setText("Alta");
			jMenuInsumosAlta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					AltaInsumosPantalla aa = new AltaInsumosPantalla();
					aa.setVisible(true);
				}
			});
			
			jMenuInsumosMod = new JMenuItem();
			jMenuInsumos.add(jMenuInsumosMod);
			jMenuInsumosMod.setText("Modificacion");
			jMenuInsumosMod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					ModInsumosPantalla ma = new ModInsumosPantalla();
					ma.setVisible(true);
				}
			});
			
			jMenuInsumosBaja = new JMenuItem();
			jMenuInsumos.add(jMenuInsumosBaja);
			jMenuInsumosBaja.setText("Baja");
			jMenuInsumosBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					BajaInsumosPantalla ba = new BajaInsumosPantalla();
					ba.setVisible(true);
				}
			});
			
			//Menu Prendas ========================================================
			jMenuPrendas = new JMenu();
			jMenuBar.add(jMenuPrendas);
			jMenuPrendas.setText("Prendas");
			jMenuPrendas.setPreferredSize(new java.awt.Dimension(70, 21));
			
			jMenuPrendasAlta = new JMenuItem();
			jMenuPrendas.add(jMenuPrendasAlta);
			jMenuPrendasAlta.setText("Alta");
			jMenuPrendasAlta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					AltaPrendasPantalla ac = new AltaPrendasPantalla();
					ac.setVisible(true);
				}
			});
			
			jMenuPrendasBaja = new JMenuItem();
			jMenuPrendas.add(jMenuPrendasBaja);
			jMenuPrendasBaja.setText("Baja");
			jMenuPrendasBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					BajaPrendasPantalla bc = new BajaPrendasPantalla();
					bc.setVisible(true);
				}
			});
			
			jMenuPrendasMod = new JMenuItem();
			jMenuPrendas.add(jMenuPrendasMod);
			jMenuPrendasMod.setText("Modificacion");
			jMenuPrendasMod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					ModPrendasPantalla mc = new ModPrendasPantalla();
					mc.setVisible(true);
				}
			});
			
			jMenuVariedadPrenda = new JMenuItem();
			jMenuPrendas.add(jMenuVariedadPrenda);
			jMenuVariedadPrenda.setText("Argegar Variedad Prenda");
			jMenuVariedadPrenda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					AgregarVariedadPrendaPantalla mc = new AgregarVariedadPrendaPantalla();
					mc.setVisible(true);
				}
			});
			
			//Menu Proveedores ========================================================
			jMenuProveedores = new JMenu();
			jMenuBar.add(jMenuProveedores);
			jMenuProveedores.setText("Proveedores");
			jMenuProveedores.setPreferredSize(new java.awt.Dimension(95, 21));
			
			jMenuProveedoresAlta = new JMenuItem();
			jMenuProveedores.add(jMenuProveedoresAlta);
			jMenuProveedoresAlta.setText("Alta");
			jMenuProveedoresAlta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					AltaProveedoresPantalla ac = new AltaProveedoresPantalla();
					ac.setVisible(true);
				}
			});
			
			jMenuProveedoresBaja = new JMenuItem();
			jMenuProveedores.add(jMenuProveedoresBaja);
			jMenuProveedoresBaja.setText("Baja");
			jMenuProveedoresBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					BajaProveedoresPantalla bc = new BajaProveedoresPantalla();
					bc.setVisible(true);
				}
			});
			
			jMenuProveedoresMod = new JMenuItem();
			jMenuProveedores.add(jMenuProveedoresMod);
			jMenuProveedoresMod.setText("Modificacion");
			jMenuProveedoresMod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					ModProveedoresPantalla mc = new ModProveedoresPantalla();
					mc.setVisible(true);
				}
			});
			
			jMenuProveedoresMod = new JMenuItem();
			jMenuProveedores.add(jMenuProveedoresMod);
			jMenuProveedoresMod.setText("Asociar Insumos a Proveedores");
			jMenuProveedoresMod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					AsociarInsumosAProveedorPantalla mc = new AsociarInsumosAProveedorPantalla();
					mc.setVisible(true);
				}
			});
			

			// Menu Pedidos ============================================================
			jMenuPedidos = new JMenu();
			jMenuBar.add(jMenuPedidos);
			jMenuPedidos.setText("Pedidos");
			
			jMenuPedidosVer = new JMenuItem();
			jMenuPedidos.add(jMenuPedidosVer);
			jMenuPedidosVer.setText("Ver Lista de Pedidos");
			jMenuPedidosVer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					MostrarFacturasPantalla fact = new MostrarFacturasPantalla();
					fact.setVisible(true);
				}
			});
			
			
			
						
			pack();
			setSize(600, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

