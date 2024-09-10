package br.com.cdb.livraria.model;

public class Livro {
	private String titulo, autor, id;
	private double preco;

	public Livro(String titulo, String autor, String id, double preco) {
		this.titulo = titulo;
		this.autor = autor;
		this.id = id;
		this.preco = preco;
	}

	public void apresentacao() {
		System.out.println("TITULO: " + titulo + "ID: " + id + "PREÇO: R$ " + preco);
	}

	// GETTERS AND SETTERS
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
