package businessDelegates;

import java.rmi.Naming;
import java.rmi.RemoteException;

import DTO.InsumoDTO;
import RemoteObject.TDAInsumo;;

public class InsumoDelegate {

private static InsumoDelegate instancia;
private TDAInsumo remoto;
	
	public static InsumoDelegate GetInstancia(){
		if(instancia==null)
			instancia = new InsumoDelegate();
		return instancia;
		
	}
	
	
	public InsumoDelegate() {
		try{
			remoto =(TDAInsumo) Naming.lookup("//localhost:1099/InsumoRemote");
		
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public InsumoDTO buscarInsumo(Long codigo) throws RemoteException {
		return remoto.buscarInsumo(codigo);
	}

	public void altaInsumo(Long codigo, String nombre, String descripcion, int stockMin, int cantCompra)  throws RemoteException {
		InsumoDTO dto = new InsumoDTO();
		dto.setCodigo(codigo);
		dto.setCantCompra(cantCompra);
		dto.setDescripcion(descripcion);
		dto.setNombre(nombre);
		dto.setStockMinimo(stockMin);		
		remoto.altaInsumo(dto);
		
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
