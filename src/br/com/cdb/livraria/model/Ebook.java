package br.com.cdb.livraria.model;
import java.util.ArrayList;

public class Ebook extends Livro {
	private double tamanhoEmMb;
	static ArrayList<Ebook> ebook = new ArrayList<>();

	public Ebook(String titulo, String autor, String id, double preco) {
		super(titulo, autor, id, preco);
		this.setTamanhoEmMb(tamanhoEmMb);
	}

	public static void inicializaEbook() {
		Ebook ebook1 = new Ebook("O Poder da Mente", "Alice Johnson", "111", 19.99);
		ebook1.tamanhoEmMb = 5.2;

		Ebook ebook2 = new Ebook("A Arte da Negociação", "Daniel Brown", "222", 14.99);
		ebook2.tamanhoEmMb = 3.8;

		Ebook ebook3 = new Ebook("Algoritmos e Estruturas de Dados", "Carlos Silva", "333", 24.99);
		ebook3.tamanhoEmMb = 7.5;

		ebook.add(ebook1);
		ebook.add(ebook2);
		ebook.add(ebook3);
	}

	public static void listaDeEbooks() {
		inicializaEbook();
		ArrayList<Ebook> ebooks = getListaEbooks();
		for (Ebook livros : ebooks) {
			livros.apresentacao();
		}
	}

	public static ArrayList<Ebook> getListaEbooks() {
		return ebook;
	}

	public void apresentacao() {
		System.out.println();
		System.out.println("EBOOK - " + getTitulo() + ", " + getAutor() + ". R$" + getPreco() + "\n" + " Arquivo: "
				+ getTamanhoEmMb() + "Mb" + ", CÓDIGO - " + getId());
	}

	// GETTERS AND SETTERS
	public double getTamanhoEmMb() {
		return tamanhoEmMb;
	}

	public void setTamanhoEmMb(double tamanhoEmMb) {
		this.tamanhoEmMb = tamanhoEmMb;
	}

}
