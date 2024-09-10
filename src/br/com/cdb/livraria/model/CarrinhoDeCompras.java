package br.com.cdb.livraria.model;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class CarrinhoDeCompras {
	Scanner input = new Scanner(System.in);
	public ArrayList<Livro> livrosNoCarrinho;
	public static ArrayList<Livro> todosOsLivros = new ArrayList<>();

	public CarrinhoDeCompras() {
		livrosNoCarrinho = new ArrayList<>();
	}

	// LIVROS DISPONIVEIS PARA COMPRA
	public static void listaDeTodosLivros() {
		LivroFisico.inicializaLivros();
		Ebook.inicializaEbook();
		todosOsLivros.addAll(LivroFisico.getListaDeLivroFisico());
		todosOsLivros.addAll(Ebook.getListaEbooks());
		for (Livro livro : todosOsLivros) {
			livro.apresentacao();
		}

	}

	// ADICIONA LIVRO NO CARRINHO
	public void addLivroNoCarrinho() {
		System.out.println("Digite o código do livro que deseja adicionar ao carrinho ou 'fim' para terminar:");
		System.out.println();
		String codigoSolicitado;
		for (Livro livro : todosOsLivros) {
			System.out.println(livro.getTitulo() + ", CÓDIGO: " + livro.getId());
		}
		System.out.println();
		while (true) {
			System.out.print("CÓDIGO: ");
			codigoSolicitado = input.nextLine();

			if (codigoSolicitado.equalsIgnoreCase("fim")) {
				livrosAdicionados();
				break;
			}

			boolean codigoExistente = false;

			for (Livro livro : todosOsLivros) {
				if (livro.getId().equals(codigoSolicitado)) {
					livrosNoCarrinho.add(livro);
					codigoExistente = true;
					break;
				}
			}

			if (!codigoExistente) {
				System.out.println("Código incorreto ou inexistente.");
			} else {
				System.out.println("Livro adicionado no carrinho!");
			}
		}
	}

	// LISTA DE LIVROS ADICIONADOS NO CARRINHO
	public void livrosAdicionados() {
		int i = 0;
		for (Livro livros : livrosNoCarrinho) {
			i++;
			System.out.println(i + " - " + livros.getTitulo() + " / " + livros.getId());
		}
	}

	// MOSTRA LIVROS NO CARRINHO
	public void livrosNoCarrinho() {
		int i = 0;
		for (Livro livros : livrosNoCarrinho) {
			i++;
			if (livros instanceof Ebook) {
				System.out.println(i + " - " + livros.getTitulo() + ", R$" + livros.getPreco());
			}

			if (livros instanceof LivroFisico) {
				System.out.println(i + " - " + livros.getTitulo() + ", R$" + livros.getPreco() + " + R$"
						+ ((LivroFisico) livros).getFrete() + " de frete.");
			}
		}
	}

	// CALCULA PREÇO TOTAL
	public void calcularPrecoTotal() {
		double precoTotal = 0.0;

		for (Livro livro : livrosNoCarrinho) {
			double precoLivro = livro.getPreco();

			if (livro instanceof LivroFisico) {
				precoLivro += ((LivroFisico) livro).getFrete();
			}

			precoTotal += precoLivro;
		}

		DecimalFormat df = new DecimalFormat("#.##");
		String precoTotalFormatado = df.format(precoTotal);

		System.out.println("Preço total: R$" + precoTotalFormatado);
	}

}
