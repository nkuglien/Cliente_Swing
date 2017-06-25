package businessDelegates;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DTO.ClienteDTO;
import DTO.CuentaCorrienteDTO;
import DTO.InsumoDTO;
import DTO.MovimientoCCDTO;
import DTO.PedidoClienteDTO;
import RemoteObject.TDACliente;
import RemoteObject.TDAPedido;

public class PedidoDelegate {

	private static PedidoDelegate instancia;
	private TDAPedido remoto;

	public static PedidoDelegate GetInstancia() {
		if (instancia == null)
			instancia = new PedidoDelegate();
		return instancia;

	}

	public PedidoDelegate() {
		try {
			remoto = (TDAPedido) Naming.lookup("//localhost:1099/PedidoRemoto");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<PedidoClienteDTO> getAllPedidos() throws RemoteException {
		return remoto.getAllPedidos();
	}

}
