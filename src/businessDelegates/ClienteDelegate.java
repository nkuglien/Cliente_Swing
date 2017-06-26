package businessDelegates;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import DTO.ClienteDTO;
import DTO.CuentaCorrienteDTO;
import DTO.MovimientoCCDTO;
import RemoteObject.TDACliente;

public class ClienteDelegate {

	private static ClienteDelegate instancia;
	private TDACliente remoto;

	public static ClienteDelegate GetInstancia() {
		if (instancia == null)
			instancia = new ClienteDelegate();
		return instancia;

	}

	public ClienteDelegate() {
		try {
			remoto = (TDACliente) Naming.lookup("//localhost:1099/ClienteRemoto");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public ClienteDTO altaCliente(String cuit, String nombre, String direccion, String telefono, Float limiteCredito)
			throws RemoteException {
		
		ClienteDTO clienteDTO = new ClienteDTO(nombre, direccion, telefono, cuit);
		CuentaCorrienteDTO cc = new CuentaCorrienteDTO(new Float(0), limiteCredito, new ArrayList<MovimientoCCDTO>());
		//cc.setId((long) 1); ESTO PARA QUE ESTABA?
		clienteDTO.setCc(cc);
		
		return remoto.altaCliente(clienteDTO);
	}

	public void bajaCliente(ClienteDTO cliente) throws RemoteException {
		remoto.bajaCliente(cliente);

	}

	public ClienteDTO buscarCliente(String cuit) throws RemoteException {
		return remoto.buscarCliente(cuit);
	}

	public void modificarCliente(ClienteDTO cliente) throws RemoteException {
		remoto.modificarCliente(cliente);

	}

}
