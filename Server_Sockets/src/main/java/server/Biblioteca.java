package server;

import java.util.ArrayList;

public class Biblioteca {

	public ArrayList<Libro> libros = new ArrayList<Libro>();
	public String texto;
	Libro libro1 = new Libro("1", "La Larga Marcha", "Stephen King", 10);
	Libro libro2 = new Libro("2", "La Comunidad del Anillo", "JRR Tolkien", 20);
	Libro libro3 = new Libro("3", "El Prisionero de Azkaban", "JK Rowling", 15);
	Libro libro4 = new Libro("4", "El Talisman", "Peter Straub", 25);
	Libro libro5 = new Libro("5", "Arthas, la Ascesion del Rey Exanime", "Christie Golden", 16);

	public Biblioteca() {
		super();
		registrarLibro(libro1);
		registrarLibro(libro2);
		registrarLibro(libro3);
		registrarLibro(libro4);
		registrarLibro(libro5);
	}
	

	// Se evalua la peticion mediante el valor NULL para saber que se esta pidiendo
	public String evaluarPeticion(Libro libro) {

		//CONSULTA POR AUTOR
		if (libro.getAutor() == null & libro.getTitulo() == null) {
			texto = buscarLibroByCodigo(libro.getIsbn());
			return texto;
		}
		else 

		//CONSULTA POR TITULO
		if (libro.getTitulo() == null & libro.getIsbn() == null) {
			texto = buscarLibroByTitulo(libro.getTitulo());
			return texto;
		}
		else 

		//CONSULTA POR ISBN
		if (libro.getIsbn() == null & libro.getTitulo() == null) {
			texto = buscarLibroByAutor(libro.getAutor());
			return texto;
		}

		//AÑADIR
		else {
			registrarLibro(libro);
			return libro.getTitulo() + " anadido";
		}
	}
	
	
	// Se devuelve al SERVIDOR la informacion de la solicitud del cliente
	public String evaluarPeticionServidor(Libro libro) {

		//CONSULTA POR AUTOR
		if (libro.getAutor() == null & libro.getTitulo() == null) {
			texto = "Consulta de libro por autor";
			return texto;
		}
		else 
		
		//CONSULTA POR TITULO
		if (libro.getTitulo() == null & libro.getIsbn() == null) {
			texto = "Consulta de libro por titulo";
			return texto;
		}
		else 
		
		//CONSULTA POR ISBN
		if (libro.getIsbn() == null & libro.getTitulo() == null) {
			texto = "Consulta de libro por ISBN";
			return texto;
		}

		//AÑADIR
		else {

			return "Anadir libro";
		}
	}
	
	//Añadir libro al ARRAYLIST
	public void registrarLibro(Libro libro) {
		libros.add(libro);
	}
	
	/*AUTOR: Devuelve informacion del libro encontrado en el ARRAYLIST si hay alguno,
	pero si hay mas de un resultado se devuelve el libro separado por @ para que se vea mejor*/
	public String buscarLibroByAutor(String autor) {
		Libro libro = new Libro();
		texto = "Los libros encontrados son:";
		for (int i = 0; i < libros.size(); i++) {
			libro = libros.get(i);

			if (libro.getAutor().equals(autor)) {
				texto = texto + "@@" + libro.toString();
				if (i == (libros.size() - 1)) {
					return texto;
				}
			}
		}
		return "No se encontro ningun libro";
	}

	//TITULO: Devuelve informacion del libro encontrado en el ARRAYLIST si hay alguno
	public String buscarLibroByTitulo(String titulo) {
		Libro libro;
		for (int i = 0; i < libros.size(); i++) {
			libro = libros.get(i);

			if (libro.getTitulo().equals(titulo)) {
				return libro.toString();
			}
		}
		return "No se encontro ningun libro";
	}

	//ISBN: Devuelve informacion del libro encontrado en el ARRAYLIST si hay alguno
	public String buscarLibroByCodigo(String codigoLibro) {
		Libro libro;
		for (int i = 0; i < libros.size(); i++) {
			libro = libros.get(i);

			if (libro.getIsbn().equals(codigoLibro)) {
				return libro.toString();
			}
		}
		return "No se encontro ningun libro";
	}
	
}
