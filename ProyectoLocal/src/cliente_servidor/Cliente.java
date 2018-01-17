package cliente_servidor;

import java.net.Socket;

public class Cliente {

	
	private static final String HOST = "localhost";
	private static final int PUERTO = 2000;
	
	public Cliente() {
		
		try {
			
			Socket sCliente = new Socket(HOST, PUERTO);
			
			sCliente.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
