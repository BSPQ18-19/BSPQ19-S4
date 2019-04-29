package servidor.es.deusto.spq;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Hello world!
 *
 */
public class Server extends UnicastRemoteObject implements IServer {

	/**
	* 
	*/
	private static final long serialVersionUID = -7646537450779069731L;

	protected Server() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("How to invoke: java [policy] [codebase] Server.Server [host] [port] [server]");
			System.exit(0);
		}
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IServer servidor = new Server();
			Naming.rebind(name, servidor);
			System.out.println("- Server active and waiting...");
			boolean a = false;
			while (a == false) {
			}
		} catch (Exception e) {
			System.err.println("$ Server exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	@Override
	public boolean alquilarPelicula(String fAlq, int tAlq, String correo, int id){
		
		return true;
	}
}
