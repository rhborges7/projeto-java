package controller;

import model.*;
import util.Teclado;

public class InfoNote {

	Usuario user;
	Notebook notebooks[] = new Notebook[10];
	Pedido pedido;
	boolean logado = false;

	public InfoNote() {

		notebooks[0] = new Notebook(1, "Negativo N22BR", "CPU Intel Core 2 Duo, Memoria 4 GB, HD 250 GB", 6, 1200.00,
				"img\\n22br.jpg", "19/05/2011");

		notebooks[1] = new Notebook(2, "Bell B55BR", "CPU Intel I3, Memoria 4 GB, HD 500 GB", 3, 1800.00,
				"img\\b55br.jpg", "20/05/2011");

		notebooks[2] = new Notebook(3, "Pompaq p41BR", "CPU Intel I3, Memoria 3 GB, HD 320 GB", 1, 1600.00,
				"img\\p41br.jpg", "21/05/2011");

		notebooks[3] = new Notebook(4, "CFF CR71CH", "CPU Intel Core Dual Core, Memoria 2 GB, HD 160 GB", 5, 1100.00,
				"img\\cr71ch.jpg", "10/06/2011");

		notebooks[4] = new Notebook(5, "BradescoTech BD22BR", "CPU AMD Phenon II, Memoria 4 GB, HD 500 GB", 2, 1900.00,
				"img\\bd22br.jpg", "10/06/2011");

	}

	// MAIN
	public static void main(String[] args) {

		InfoNote info = new InfoNote();

		int opcao = 8;

		do {
			info.mostrarMenu();
			opcao = Teclado.lerInt("Digite sua Opção: ");

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
				info.inserirNotebook();
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
				System.out.println("Saída do Sistema.");
				break;

			default:
				System.out.println("Opção Inválida !");
			}

		} while (opcao != 8);

		Teclado.lerTexto("Pressione uma tecla para continuar");

	}

	public void mostrarMenu() {
		System.out.println("================================================================================");
		System.out.println("                    InfoNote - Se não é Info não Vendemos                ");
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
			System.out.println("Login ou Senha Inválido!");
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

	@SuppressWarnings("unlikely-arg-type")
	public void inserirNotebook() {
		// LÊ O NOTEBOOK ESCOLHIDO DO TECLADO
		String numeroNote = Teclado.lerTexto("Informe o número do notebook" + "para compra:");

		// CRIA PEDIDO
		if (pedido == null) {
			pedido = new Pedido();
		}
		// BUSCA NOTEBOOK SELECIONADO
		Notebook aux = null;
		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null && numeroNote.equals(notebooks[i].getNumeroNote())) {
				aux = notebooks[i];
			}
			// SE NÃO EXISTIR, INTERROMPE
			if (aux == null) {
				return;
			}
			// CRIA ITEM
			ItemDePedido item = new ItemDePedido(1, aux, aux.getPrecoUnitario());

			// INSERE ITEM NO PEDIDO
			pedido.inserirItem(item);
		}
	}

	public void buscarNotebook() {
		for (int i=0; i<notebooks.length;i++) {
			if (notebooks[i] !=null){
				System.out.println(notebooks[i].getNumeroNote()+ "------"+ notebooks[i].getModelo());
			}
		}
	}

	public void manterCarrinho() {
		System.out.println(" manterCarrinho - Em Construção");
	}

	public void efetuarCompra() {
		System.out.println(" efetuarCompra - Em Construção");
	}

}
