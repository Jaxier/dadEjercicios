package cliente_servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor{
	
	private static final int PUERTO = 2000;
	private static final String HOST = "localhost";
	
	public Servidor() {
		
		try {
			ServerSocket skServidor = new ServerSocket(PUERTO);
			Socket sCliente = skServidor.accept();
			
			OutputStream aux = sCliente.getOutputStream();
			DataOutputStream flujoSalida = new DataOutputStream(aux);
			
			flujoSalida.writeUTF("Enviar datos");
			sCliente.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void Cliente() {
		
		try {
			
			Socket sCliente = new Socket(HOST, PUERTO);
			
			DataInputStream flujo_entrada = new DataInputStream(sCliente.getInputStream());
			
			String datos = new String();
			datos = flujo_entrada.readUTF();
			System.out.println(datos);
			
			
			sCliente.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public static void main(String[] args) {
		new Servidor();
		new Cliente();
	}
}
