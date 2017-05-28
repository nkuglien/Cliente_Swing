package businessDelegates;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

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

	public void altaProveedor(int parseInt, String text) throws RemoteException {
		remoto.altaProveedor(parseInt, text);
	}

	public void bajaProveedor(int parseInt) throws RemoteException {
		remoto.bajaProveedor(parseInt);
		
	}


	public ProveedorDTO solicitarProveedorView(int parseInt) throws RemoteException {
		return remoto.solicitarProveedorView(parseInt);
	}


	public void modificarProveedor(ProveedorDTO pv, int parseInt) throws RemoteException {
		remoto.modificarProveedor(pv, parseInt);
		
	}


	public List<ProveedorDTO> getAllProveedores() throws RemoteException  {
		return remoto.getAllProveedores();
	}

}
