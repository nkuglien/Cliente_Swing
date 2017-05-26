package vistas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

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
			jMenuBar.setPreferredSize(new java.awt.Dimension(600, 22));
				

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
					AltaClientePantalla ac = new AltaClientePantalla(controlador);
					ac.setVisible(true);
				}
			});
		
		
			jMenuClientesMod = new JMenuItem();
			jMenuClientes.add(jMenuClientesMod);
			jMenuClientesMod.setText("Modificaci�n");
			jMenuClientesMod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					ModClientePantalla ca = new ModClientePantalla(controlador);
					ca.setVisible(true);
				}
			});
		
			jMenuClientesBaja = new JMenuItem();
			jMenuClientes.add(jMenuClientesBaja);
			jMenuClientesBaja.setText("Baja");
			jMenuClientesBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					BajaClientePantalla ba = new BajaClientePantalla(controlador);
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
					AltaSucursalesPantalla aa = new AltaSucursalesPantalla(controlador);
					aa.setVisible(true);
				}
			});
			
			jMenuSucursalesMod = new JMenuItem();
			jMenuSucursales.add(jMenuSucursalesMod);
			jMenuSucursalesMod.setText("Modificacion");
			jMenuSucursalesMod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					ModSucursalesPantalla ma = new ModSucursalesPantalla(controlador);
					ma.setVisible(true);
				}
			});
			
			jMenuSucursalesBaja = new JMenuItem();
			jMenuSucursales.add(jMenuSucursalesBaja);
			jMenuSucursalesBaja.setText("Baja");
			jMenuSucursalesBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					BajaSucursalesPantalla ba = new BajaSucursalesPantalla(controlador);
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
					AltaInsumosPantalla aa = new AltaInsumosPantalla(controlador);
					aa.setVisible(true);
				}
			});
			
			jMenuInsumosMod = new JMenuItem();
			jMenuInsumos.add(jMenuInsumosMod);
			jMenuInsumosMod.setText("Modificacion");
			jMenuInsumosMod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					ModInsumosPantalla ma = new ModInsumosPantalla(controlador);
					ma.setVisible(true);
				}
			});
			
			jMenuInsumosBaja = new JMenuItem();
			jMenuInsumos.add(jMenuInsumosBaja);
			jMenuInsumosBaja.setText("Baja");
			jMenuInsumosBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					BajaInsumosPantalla ba = new BajaInsumosPantalla(controlador);
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
					AltaPrendasPantalla ac = new AltaPrendasPantalla(controlador);
					ac.setVisible(true);
				}
			});
			
			jMenuPrendasBaja = new JMenuItem();
			jMenuPrendas.add(jMenuPrendasBaja);
			jMenuPrendasBaja.setText("Baja");
			jMenuPrendasBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					BajaPrendasPantalla bc = new BajaPrendasPantalla(controlador);
					bc.setVisible(true);
				}
			});
			
			jMenuPrendasMod = new JMenuItem();
			jMenuPrendas.add(jMenuPrendasMod);
			jMenuPrendasMod.setText("Modificaci�n");
			jMenuPrendasMod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					ModPrendasPantalla mc = new ModPrendasPantalla(controlador);
					mc.setVisible(true);
				}
			});
			
			//Menu Proveedores ========================================================
			jMenuProveedores = new JMenu();
			jMenuBar.add(jMenuProveedores);
			jMenuProveedores.setText("Proveedor");
			jMenuProveedores.setPreferredSize(new java.awt.Dimension(70, 21));
			
			jMenuProveedoresAlta = new JMenuItem();
			jMenuProveedores.add(jMenuProveedoresAlta);
			jMenuProveedoresAlta.setText("Alta");
			jMenuProveedoresAlta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					AltaProveedoresPantalla ac = new AltaProveedoresPantalla(controlador);
					ac.setVisible(true);
				}
			});
			
			jMenuProveedoresBaja = new JMenuItem();
			jMenuProveedores.add(jMenuProveedoresBaja);
			jMenuProveedoresBaja.setText("Baja");
			jMenuProveedoresBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					BajaProveedoresPantalla bc = new BajaProveedoresPantalla(controlador);
					bc.setVisible(true);
				}
			});
			
			jMenuProveedoresMod = new JMenuItem();
			jMenuProveedores.add(jMenuProveedoresMod);
			jMenuProveedoresMod.setText("Modificaci�n");
			jMenuProveedoresMod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) 
				{
					ModProveedoresPantalla mc = new ModProveedoresPantalla(controlador);
					mc.setVisible(true);
				}
			});
			
				
			
						
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

