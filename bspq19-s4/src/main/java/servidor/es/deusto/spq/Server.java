
package servidor.es.deusto.spq;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.apache.log4j.Logger;
import servidor.es.deusto.spq.jdo.Cuenta;
import servidor.es.deusto.spq.jdo.JDO;


/**
 * Hello world!
 *
 */
public class Server extends UnicastRemoteObject {

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
			IServer servidor = new JDO(args[2]);
			Naming.rebind(name, servidor);
			System.out.println("//" + args[0] + ":" + args[1] + "/" + args[2]);
			System.out.println("- Server active and waiting...");
		} catch (Exception e) {
			System.err.println("$ Server exception: " + e.getMessage());
			e.printStackTrace();
		}

	}
	

}
