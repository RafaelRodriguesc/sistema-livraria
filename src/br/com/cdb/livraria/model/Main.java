package br.com.cdb.livraria.model;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int menu;

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        do {
        	try {
            System.out.println("______________________________  LIVRARIA ONLINE  ______________________________");
            System.out.println();
            System.out.println("  Utilize as teclas [1 2 3] para navegar no sistema ou [0] para encerrar.");
            System.out.println();
            System.out.println("[1] Lista detalhada de livros");
            System.out.println("[2] Comprar");
            System.out.println("[3] Meu Carrinho de compras");
            System.out.println("[0] Encerrar Sistema");
            menu = input.nextInt();
            input.nextLine(); 
            switch (menu) {
                case 1:
                    System.out.println("______________________________  LISTA DE LIVROS  ______________________________");
                    CarrinhoDeCompras.listaDeTodosLivros();
                    System.out.println();
                    System.out.println("Pressione Enter para voltar ao menu...");
                    input.nextLine();
                    break;
                case 2:
                    System.out.println("______________________________  COMPRAR LIVROS  ______________________________");
                    System.out.println();
                    carrinho.addLivroNoCarrinho();
                    System.out.println();
                    System.out.println("Redirecionando ao menu...");
                    try {
                        Thread.sleep(2300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("______________________________  CARRINHO DE COMPRAS  ______________________________");
                    System.out.println();
                    System.out.println("Itens no seu carrinho:");
                    System.out.println();
                    carrinho.livrosNoCarrinho();
                    System.out.println();
                    carrinho.calcularPrecoTotal();
                    System.out.println();
                    System.out.println("Pressione Enter para voltar ao menu...");
                    input.nextLine();
                    break;
                case 0:
                    System.out.println("Sistema Encerrado!");
                    break;
                default:
                	System.out.println("Comando inválido! Por favor, utilize as teclas [1 2 3] para navegar no sistema ou [0] para encerrar");
                    System.out.println("Pressione Enter para voltar ao menu...");
                    input.nextLine();
            }
        	} catch(InputMismatchException e) {
        		System.out.println("Caracter não permitido! Por favor, selecione uma opção válida");
                input.nextLine();
                menu = -1; 
        	}

        } while (menu != 0);
        input.close();

    }
}
