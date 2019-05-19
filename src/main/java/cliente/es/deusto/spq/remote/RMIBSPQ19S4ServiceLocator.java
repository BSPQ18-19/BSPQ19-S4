package cliente.es.deusto.spq.remote;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import servidor.es.deusto.spq.IServer;

/**
 * \brief Establece la conexión con le servidor
 */
public class RMIBSPQ19S4ServiceLocator {
	private IServer service;
	
	public void setService(String ip, String port, String serviceName) throws MalformedURLException, RemoteException, NotBoundException {
		service = (IServer) java.rmi.Naming.lookup("//" + ip + ":" + port + "/" + serviceName);
	}
	
	public IServer getService() {
		return service;
	}
}
