package businessDelegates;

import java.rmi.Naming;
import java.rmi.RemoteException;

import DTO.PrendaDTO;
import RemoteObject.ClienteRemote;
import RemoteObject.PrendaRemote;

public class PrendaDelegate {

private static PrendaDelegate instancia;
	private PrendaRemote remoto;
	public static PrendaDelegate GetInstancia(){
		if(instancia==null)
			instancia = new PrendaDelegate();
		return instancia;
		
	}
	
	
	public PrendaDelegate() {
		try{
			remoto =(PrendaRemote) Naming.lookup("//localhost:1099/PrendaController");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public boolean verificarPrenda(int parseInt) throws RemoteException {
		return remoto.verificarPrenda(parseInt);
	}

	public void altaPrenda(int parseInt, String text) throws RemoteException {
		remoto.altaPrenda(parseInt, text);
	}

	public void bajaprenda(int parseInt) throws RemoteException {
		remoto.bajaprenda(parseInt);
		
		
	}


	public PrendaDTO solicitarPrendaView(int parseInt) throws RemoteException {
		return remoto.solicitarPrendaView(parseInt);
	}


	public void modificarPrenda(PrendaDTO pv, int parseInt) throws RemoteException {
	 remoto.modificarPrenda(pv, parseInt);
		
	}

}
