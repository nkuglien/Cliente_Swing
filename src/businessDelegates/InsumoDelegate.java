package businessDelegates;

import java.rmi.Naming;
import java.rmi.RemoteException;

import DTO.InsumoDTO;
import RemoteObject.ClienteRemote;
import RemoteObject.InsumoRemote;

public class InsumoDelegate {

private static InsumoDelegate instancia;
private InsumoRemote remoto;
	
	public static InsumoDelegate GetInstancia(){
		if(instancia==null)
			instancia = new InsumoDelegate();
		return instancia;
		
	}
	
	
	public InsumoDelegate() {
		try{
			remoto =(InsumoRemote) Naming.lookup("//localhost:1099/InsumoController");
		
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public boolean verificarInsumo(int parseInt) throws RemoteException {
		return remoto.verificarInsumo(parseInt);
	}

	public void altaInsumo(int parseInt, String text, String text2, int parseInt2, int parseInt3)  throws RemoteException {
		remoto.altaInsumo(parseInt, text, text2, parseInt2, parseInt3);
		
	}

	public void bajaInsumo(int parseInt)  throws RemoteException {
		remoto.bajaInsumo(parseInt);
		
		
	}

	public InsumoDTO solicitarInsumoView(int parseInt)  throws RemoteException {
		return remoto.solicitarInsumoView(parseInt);
	}


	public void modificarInsumo(InsumoDTO iv, int parseInt)  throws RemoteException {
		remoto.modificarInsumo(iv, parseInt);
		
	}

}
