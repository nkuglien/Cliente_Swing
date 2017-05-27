package businessDelegates;

import java.rmi.Naming;
import java.rmi.RemoteException;

import DTO.ClienteDTO;
import DTO.CuentaCorrienteDTO;
import RemoteObject.ClienteRemote;

public class ClienteDelegate {

	private static ClienteDelegate instancia;
	private ClienteRemote remoto;

	public static ClienteDelegate GetInstancia() {
		if (instancia == null)
			instancia = new ClienteDelegate();
		return instancia;

	}

	public ClienteDelegate() {
		try {
			remoto = (ClienteRemote) Naming.lookup("//localhost:1099/ClienteController");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean verificarCliente(int parseInt) throws RemoteException {
		return remoto.verificarCliente(parseInt);
	}
	public void altaCliente(String cuit, String nombre, String direccion, String telefono, Float limiteCredito)
			throws RemoteException {
		
		ClienteDTO clienteDTO = new ClienteDTO(nombre, direccion, telefono, cuit);
		CuentaCorrienteDTO cc = new CuentaCorrienteDTO(new Float(0), limiteCredito, clienteDTO);
		cc.setId((long) 1);
		clienteDTO.setCc(cc);
		
		remoto.altaCliente(clienteDTO);
	}

	public void bajaCliente(int parseInt) throws RemoteException {
		remoto.bajaCliente(parseInt);

	}

	public ClienteDTO solicitarClienteView(int parseInt) throws RemoteException {
		return remoto.solicitarClienteView(parseInt);
	}

	public void modificarCliente(ClienteDTO cv, int parseInt) throws RemoteException {
		remoto.modificarCliente(cv, parseInt);

	}

}
