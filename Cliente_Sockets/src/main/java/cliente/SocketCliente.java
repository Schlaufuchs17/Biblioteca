package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.google.gson.Gson;

public class SocketCliente {

	public static final int PUERTO = 2021;
	public static final String IP_SERVER = "localhost";

	public static void main(String[] args) {

		System.out.println("CLIENTE");

		InetSocketAddress direccionServer = new InetSocketAddress(IP_SERVER, PUERTO);

		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("CLIENTE: Estableciendo conexion");

			Socket socketAlServidor = new Socket();
			socketAlServidor.connect(direccionServer);
			System.out.println("CLIENTE: Conexion realizada en " + IP_SERVER + " en el puerto " + PUERTO);

			InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());
			BufferedReader entradaBuffer = new BufferedReader(entrada);

			PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());

			String texto = "";
			boolean continuar = true;
			int num;
			Libro libro;
			Gson gson = new Gson();
			String json = "";

			do {
				System.out.println("Elige un numero:\n" + 
						"1. Buscar libro por titulo\n" +
						"2. Buscar libro por autor\n" + 
						"3. Buscar libros por ISBN\n" + 
						"4. Anadir libro\n"+ 
						"5. Salir");
				num = Integer.parseInt(sc.nextLine());

				switch (num) {

				//BUSCAR POR TITULO
				case 1:
				libro = new Libro();
				System.out.println("Introduzce el titulo");
				texto = sc.nextLine();
				libro.setTitulo(texto);
				json = gson.toJson(libro);
				break;

				//BUSCAR POR AUTOR
				case 2:
					libro = new Libro();
					System.out.println("Introduce un autor");
					texto = sc.nextLine();
					libro.setAutor(texto);
					json = gson.toJson(libro);
					break;

				//BUSCAR POR ISBN
				case 3:
				libro = new Libro();
				System.out.println("Introduce el ISBN");
				texto = sc.nextLine();
				libro.setIsbn(texto);
				json = gson.toJson(libro);
				break;

				//AÑADIR
				case 4:
					libro = new Libro();
					System.out.println("Introduce un ISBN");
					texto = sc.nextLine();
					libro.setIsbn(texto);
					System.out.println("Introduce el titulo");
					texto = sc.nextLine();
					libro.setTitulo(texto);
					System.out.println("Introduce un autor");
					texto = sc.nextLine();
					libro.setAutor(texto);
					System.out.println("Introduce el precio");
					int precio = Integer.parseInt(sc.nextLine());
					libro.setPrecio(precio);
					json = gson.toJson(libro);
					break;

				//SALIR
				case 5:
					System.out.println("Cerrando aplicacion");
					json = "Fin";
					continuar = false;
					break;

				default:
					System.out.println("Introduce un numero");
				}

				/* La solicitud del cliente se envia como un objeto trasnformado a JSON (excepto salir) */
				salida.println(json);

				//RESPUESTA DEL SERVIDOR
				System.out.println("CLIENTE: Esperando respuesta.....");
				
				/*Se cambian los @ por un salto de linea para que aparezcan en diferentes lineas */
				String respuesta = entradaBuffer.readLine();
				String remplazo = respuesta.replaceAll("@@", "\n");
				System.out.println("Respuesta del servidor: \n" + remplazo + "\n");

			} while (continuar);

			socketAlServidor.close();

		} catch (UnknownHostException e) {
			System.err.println("No se encuentra el servidor:" + IP_SERVER);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error en la entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Error:" + e);
			e.printStackTrace();
		}

		System.out.println("Saliendo del programa");
	}

}
