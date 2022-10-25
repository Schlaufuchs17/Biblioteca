package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static final int PUERTO = 2021;

	public static void main(String[] args) {
		
		System.out.println("Servidor");
		Biblioteca biblio = new Biblioteca();

		int peticion = 0;

		try (ServerSocket servidor = new ServerSocket()) {

			InetSocketAddress direccion = new InetSocketAddress(PUERTO);
			servidor.bind(direccion);

			System.out.println("Esperando peticion en el servidor a traves del puerto: " + PUERTO);

			while (true) {
				Socket socketAlCliente = servidor.accept();
				System.out.println("Peticion del servidor: " + ++peticion + " recibida");
				new Hilo(socketAlCliente, biblio);

			}

		} catch (IOException e) {
			System.out.println("Error en la entrada/salida (SERVIDOR)");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error en el servidor");
			e.printStackTrace();
		}
	}
}
