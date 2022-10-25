package cliente;

import java.util.Objects;

public class Libro {
	private String isbn;
	private String titulo;
	private String autor;
	private int precio;

	//BUILDER
	public Libro(String isbn, String titulo, String autor, int precio) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}

	public Libro() {
		super();
	}

	//GETTER & SETTER
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override

	public String toString() {
		return titulo + " [ISBN=" + isbn + ", autor=" + autor + ", precio=" + precio + "�]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, isbn, precio, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(isbn, other.isbn)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Objects.equals(titulo, other.titulo);
	}

}
