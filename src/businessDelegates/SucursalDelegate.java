package businessDelegates;

import java.rmi.Naming;
import java.rmi.RemoteException;

import DTO.SucursalDTO;
import RemoteObject.ClienteRemote;
import RemoteObject.SucursalRemote;

public class SucursalDelegate {

private static SucursalDelegate instancia;
	private SucursalRemote remoto;
	public static SucursalDelegate GetInstancia(){
		if(instancia==null)
			instancia = new SucursalDelegate();
		return instancia;
		
	}
	
	public SucursalDelegate() {
		try{
			remoto =(SucursalRemote) Naming.lookup("//localhost:1099/SucursalRemoto");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public boolean verificarSucursal(int parseInt) throws RemoteException {
		return remoto.verificarSucursal(parseInt);
	}

	public void altaSucursal(int parseInt, String text, int parseInt2, int parseInt3) throws RemoteException {
		remoto.altaSucursal(parseInt, text, parseInt2, parseInt3);
	}

	public void bajaSucursal(int parseInt) throws RemoteException {
		remoto.bajaSucursal(parseInt);
		
	}


	public SucursalDTO solicitarSucursalView(int parseInt) throws RemoteException {
		return remoto.solicitarSucursalView(parseInt);
	}


	public void modificarSucursal(SucursalDTO sv, int parseInt) throws RemoteException {
		remoto.modificarSucursal(sv, parseInt);
		
	}

}
