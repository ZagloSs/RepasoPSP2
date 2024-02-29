package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MainServidor {

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(6564)){
			
				Socket socketCliente = serverSocket.accept();
				DataInputStream dis = new DataInputStream(socketCliente.getInputStream());
				DataOutputStream dos = new DataOutputStream(socketCliente.getOutputStream());
				String msg = "";
				String CadenaMasLarga = "";
				
				while(!msg.toUpperCase().equals("FIN")) {
					msg = dis.readUTF();
					
					if(msg.length() > CadenaMasLarga.length()) {
						CadenaMasLarga = msg;
					}
				}
				dos.writeUTF(CadenaMasLarga);
				
				//Cerrar conexiones
				dis.close();
				dos.close();
				socketCliente.close();
				serverSocket.close();
				
				
				
				
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
