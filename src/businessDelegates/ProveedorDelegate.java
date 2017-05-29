package businessDelegates;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import DTO.InsumoDTO;
import DTO.InsumoProveedorDTO;
import DTO.ProveedorDTO;
import RemoteObject.TDAProveedor;

public class ProveedorDelegate {

private static ProveedorDelegate instancia;
	private TDAProveedor remoto;
	public static ProveedorDelegate GetInstancia(){
		if(instancia==null)
			instancia = new ProveedorDelegate();
		return instancia;
		
	}
	
	
	public ProveedorDelegate() {
		try{
			remoto =(TDAProveedor) Naming.lookup("//localhost:1099/ProveedorRemoto");

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public boolean verificarProveedor(int parseInt) throws RemoteException {
		return remoto.verificarProveedor(parseInt);
	}

	public void altaProveedor(ProveedorDTO prov) throws RemoteException {
		remoto.altaProveedor(prov);
	}

	public void bajaProveedor(int parseInt) throws RemoteException {
		remoto.bajaProveedor(parseInt);
		
	}


	public ProveedorDTO solicitarProveedorView(int parseInt) throws RemoteException {
		return remoto.solicitarProveedorView(parseInt);
	}


	public void modificarProveedor(ProveedorDTO pv) throws RemoteException {
		remoto.modificarProveedor(pv);
		
	}


	public List<ProveedorDTO> getAllProveedores() throws RemoteException  {
		return remoto.getAllProveedores();
	}
	
	public InsumoProveedorDTO asociarInsumo(ProveedorDTO proveedor, InsumoDTO insumo, Float precio) throws RemoteException {
		return remoto.asociarInsumo(proveedor, insumo, precio);
	}

}
