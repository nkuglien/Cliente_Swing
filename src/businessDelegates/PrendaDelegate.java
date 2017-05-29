package businessDelegates;

import java.rmi.Naming;
import java.rmi.RemoteException;

import DTO.PrendaDTO;
import RemoteObject.TDAPrenda;

public class PrendaDelegate {

private static PrendaDelegate instancia;
	private TDAPrenda remoto;
	public static PrendaDelegate GetInstancia(){
		if(instancia==null)
			instancia = new PrendaDelegate();
		return instancia;
		
	}
	
	
	public PrendaDelegate() {
		try{
			remoto =(TDAPrenda) Naming.lookup("//localhost:1099/PrendaRemoto");

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public boolean verificarPrenda(int parseInt) throws RemoteException {
		return remoto.verificarPrenda(parseInt);
	}

	public void altaPrenda(int parseInt, String text) throws RemoteException {
		PrendaDTO prenda = new PrendaDTO();
		prenda.setDescripcion(text);
		prenda.setCodigo(new Long(parseInt));
		remoto.altaPrenda(prenda);
	}

	public void bajaprenda(PrendaDTO prenda) throws RemoteException {
		remoto.bajaprenda(prenda);
		
	}


	public PrendaDTO solicitarPrendaView(int parseInt) throws RemoteException {
		return remoto.solicitarPrendaView(parseInt);
	}


	public void modificarPrenda(PrendaDTO prenda) throws RemoteException {
	 remoto.modificarPrenda(prenda);
		
	}

}
