package controller;

import model.*;
import util.Teclado;

public class InfoNote {

	Usuario user;
	boolean logado = false;

	public static void main(String[] args) {

		InfoNote info = new InfoNote();

		int opcao = 8;

		do {
			info.mostrarMenu();
			opcao = Teclado.lerInt("Digite sua Op��o: ");

			switch (opcao) {

			case 1:

				info.efetuarLogin();
				break;

			case 2:
				info.cadastrarUsuario();
				break;

			case 3:
				info.buscarNotebook();
				break;

			case 4:
				info.manterCarrinho();
				break;

			case 5:

				info.manterCarrinho();
				break;

			case 6:

				info.manterCarrinho();
				break;

			case 7:
				if (!info.logado) {
					System.out.println("Efetue Login para Efetuar Compra !");
					break;
				} else {
					info.efetuarCompra();
					break;
				}
			case 8:
				System.out.println("Sa�da do Sistema.");
				break;

			default:
				System.out.println("Op��o Inv�lida !");
			}

		} while (opcao != 8);

		Teclado.lerTexto("Pressione uma tecla para continuar");

	}

	public void mostrarMenu() {
		System.out.println("================================================================================");
		System.out.println("                    InfoNote - Se n�o � Info n�o Vendemos                ");
		System.out.println("================================================================================");
		System.out.println("1 - Login");
		System.out.println("2 - Cadastrar Cliente");
		System.out.println("3 - Buscar Notebook");
		System.out.println("4 - Inserir Notebook no Carrinho");
		System.out.println("5 - Remover Notebook no Carrinho");
		System.out.println("6 - Ver Carrinho");
		System.out.println("7 - Efetuar Compra");
		System.out.println("8 - Sair");
	}

	public void efetuarLogin() {

		String login, senha;
		login = Teclado.lerTexto("Digite o Login : ");
		senha = Teclado.lerTexto("Digite a Senha : ");
		if (login.equals("admin") && senha.equals("1234")) {
			System.out.println("Login Efetuado com Sucesso !");
			logado = true;
		} else {
			System.out.println("Login ou Senha Inv�lido!");
			efetuarLogin();

		}
	}

	
	public void cadastrarUsuario() {

		System.out.println("================================================================================");
		System.out.println("                    InfoNote - Cadastro de Usuarios                ");
		System.out.println("================================================================================");
		int matricula = Teclado.lerInt("Matricula : ");
		String login = Teclado.lerTexto("Login : ");
		String senha = Teclado.lerTexto("Senha : ");
		String nome = Teclado.lerTexto("Nome : ");
		String email = Teclado.lerTexto("Email : ");
		String telefone = Teclado.lerTexto("Telefone : ");

		user = new Usuario(matricula, login, senha, nome, email, telefone);

		System.out.println("================================================================================");
		System.out.println("					Usuario Cadastrado com Sucesso!           					");
		System.out.println("================================================================================");

		System.out.println(user);
	}

	public void buscarNotebook() {
		System.out.println(" buscarNotebook - Em Constru��o");
	}

	public void manterCarrinho() {
		System.out.println(" manterCarrinho - Em Constru��o");
	}

	public void efetuarCompra() {
		System.out.println(" efetuarCompra - Em Constru��o");
	}

}
