package businessDelegates;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import DTO.AreaProduccionDTO;
import DTO.PrendaDTO;
import DTO.VariedadPrendaDTO;
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

	public void altaPrenda(PrendaDTO prenda) throws RemoteException {
		remoto.altaPrenda(prenda);
	}
	
	public void altaVariedadPrenda(VariedadPrendaDTO varPrenda) throws RemoteException {
		remoto.altaVariedadPrenda(varPrenda);
	}

	public void bajaprenda(PrendaDTO prenda) throws RemoteException {
		remoto.bajaprenda(prenda);
		
	}


	public PrendaDTO solicitarPrendaView(Long codigo) throws RemoteException {
		return remoto.solicitarPrendaView(codigo);
	}


	public void modificarPrenda(PrendaDTO prenda) throws RemoteException {
	 remoto.modificarPrenda(prenda);
		
	}
	
	public List<PrendaDTO> getAllPrendas() throws RemoteException {
		return remoto.getAllPrendas();
	}
	
	public List<AreaProduccionDTO> getAllAreasProduccion() throws RemoteException {
		return remoto.getAllAreasProduccion();
	}

}
