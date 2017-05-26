package businessDelegates;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import DTO.ClienteDTO;
import RemoteObject.ClienteRemote;

public class ClienteDelegate {

	private static ClienteDelegate instancia;
	private ClienteRemote remoto;
	
	public static ClienteDelegate GetInstancia(){
		if(instancia==null)
			instancia = new ClienteDelegate();
		return instancia;
		
	}
	
	
	public ClienteDelegate() {
		try{
		remoto =(ClienteRemote) Naming.lookup("//localhost:1099/ClienteController");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public boolean verificarCliente(int parseInt) throws RemoteException {
		return remoto.verificarCliente(parseInt);
	}

	public void altaCliente(int parseInt, String text, String text2, int parseInt2, String text3) throws RemoteException {
		remoto.altaCliente(parseInt, text, text2, parseInt2, text3);
	}

	public void bajaCliente(int parseInt) throws RemoteException {
		remoto.bajaCliente(parseInt);
		
	}

	public ClienteDTO solicitarClienteView(int parseInt) throws RemoteException {
		return remoto.solicitarClienteView(parseInt);
	}

	public void modificarCliente(ClienteDTO cv, int parseInt)  throws RemoteException {
	 remoto.modificarCliente(cv, parseInt);
		
	}

}
