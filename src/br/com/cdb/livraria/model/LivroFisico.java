package br.com.cdb.livraria.model;
import java.util.ArrayList;

public class LivroFisico extends Livro {
	private double peso, frete;
	static ArrayList<LivroFisico> livroFisico = new ArrayList<>();

	public LivroFisico(String titulo, String autor, String id, double preco) {
		super(titulo, autor, id, preco);
		this.setPeso(peso);
		this.setFrete(frete);
	}

	public static void inicializaLivros() {
		LivroFisico livro1 = new LivroFisico("Aventuras no Espaço", "John Doe", "999", 29.99);
		livro1.peso = 0.5;
		livro1.frete = 7.0;

		LivroFisico livro2 = new LivroFisico("Mistério no Castelo", "Albert Einstein", "888", 39.99);
		livro2.peso = 0.7;
		livro2.frete = 7.0;

		LivroFisico livro3 = new LivroFisico("O Segredo da Floresta", "Jane Smith", "777", 24.99);
		livro3.peso = 0.6;
		livro3.frete = 7.0;

		livroFisico.add(livro1);
		livroFisico.add(livro2);
		livroFisico.add(livro3);
	}

	public static void listaLivrosFisicos() {
		inicializaLivros();
		ArrayList<LivroFisico> livrosFisicos = getListaDeLivroFisico();
		for (LivroFisico livros : livrosFisicos) {
			livros.apresentacao();
		}
	}

	public void apresentacao() {
		System.out.println();
		System.out.println("LIVRO - " + getTitulo() + ", " + getAutor() + ". R$" + getPreco() + " + R$" + getFrete()
				+ " de frete." + "\n" + " Peso - " + getPeso() + "Kg " + ", CÓDIGO - " + getId());

	}

	public static ArrayList<LivroFisico> getListaDeLivroFisico() {
		return livroFisico;
	}

	// GETTERS AND SETTERS
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getFrete() {
		return frete;
	}

	public void setFrete(double frete) {
		this.frete = frete;
	}

}
