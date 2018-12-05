package controller;

import model.*;
import util.Teclado;

public class InfoNote {

	Cliente codigoCliente;
	Notebook modelo[] = new Notebook[10];
	Pedido pedido;
	boolean logado = false;

	public InfoNote() {

		modelo[0] = new Notebook("445X45WE", "Negativo N22BR", "CPU Intel Core 2 Duo, Memoria 4 GB, HD 250 GB", 6,
				1200.00, "img\\n22br.jpg", "19/05/2011");

		modelo[1] = new Notebook("5SA4D54D", "Bell B55BR", "CPU Intel I3, Memoria 4 GB, HD 500 GB", 3, 1800.00,
				"img\\b55br.jpg", "20/05/2011");

		modelo[2] = new Notebook("S54D5AS4", "Pompaq p41BR", "CPU Intel I3, Memoria 3 GB, HD 320 GB", 1, 1600.00,
				"img\\p41br.jpg", "21/05/2011");

		modelo[3] = new Notebook("XF12AS5S4D", "CFF CR71CH", "CPU Intel Core Dual Core, Memoria 2 GB, HD 160 GB", 5,
				1100.00, "img\\cr71ch.jpg", "10/06/2011");

		modelo[4] = new Notebook("D1F45DFSD", "BradescoTech BD22BR", "CPU AMD Phenon II, Memoria 4 GB, HD 500 GB", 2,
				1900.00, "img\\bd22br.jpg", "10/06/2011");

	}

	// MAIN
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
				info.cadastrarCliente();
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
				System.out.println("Sa�da do Sistema.");
				break;

			default:
				System.out.println("Op��o Inv�lida !");
			}

		} while (opcao != 8);

		Teclado.lerTexto("Pressione uma tecla para continuar");

	}

	public void mostrarMenu() {
		if (logado == false) {
			System.out.println("================================================================================");
			System.out.println("                    InfoNote - Se n�o � Info n�o Vendemos                ");
			System.out.println("================================================================================");
			System.out.println("1 - Login");
			System.out.println("2 - Cadastrar Cliente");

		} else {
			System.out.println("3 - Buscar Notebook");
			System.out.println("4 - Inserir Notebook no Carrinho");
			System.out.println("5 - Remover Notebook no Carrinho");
			System.out.println("6 - Ver Carrinho");
			System.out.println("7 - Efetuar Compra");
			System.out.println("8 - Sair");
		}
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

	public void cadastrarCliente() {

		System.out.println("================================================================================");
		System.out.println("                    InfoNote - Cadastro de Usuarios                ");
		System.out.println("================================================================================");

		String login = Teclado.lerTexto("Login : ");
		String senha = Teclado.lerTexto("Senha : ");
		int tipo = 1;
		String codigoCliente = Teclado.lerTexto("Codigo do Cliente:  ");
		String nome = Teclado.lerTexto("Nome : ");
		String email = Teclado.lerTexto("Email : ");
		String telefone = Teclado.lerTexto("Telefone : ");

		String logradouro = Teclado.lerTexto("Logradouro : ");
		String numero = Teclado.lerTexto("Numero : ");
		String complemento = Teclado.lerTexto("Complemento : ");
		String bairro = Teclado.lerTexto("Bairro : ");
		String cidade = Teclado.lerTexto("Cidade : ");
		String estado = Teclado.lerTexto("Estado : ");
		String cep = Teclado.lerTexto("CEP : ");
		Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep);

		Cliente cliente = new Cliente(login, senha, tipo, nome, email, telefone, endereco);
		
		System.out.println(cliente);
		System.out.println(endereco);

		System.out.println("================================================================================");
		System.out.println("					Cliente Cadastrado com Sucesso!           					");
		System.out.println("================================================================================");

		
	}

	/*
	 * public void cadastrarFuncionario() {
	 * 
	 * System.out.println(
	 * "================================================================================"
	 * ); System.out.
	 * println("                    InfoNote - Cadastro de Usuarios                "
	 * ); System.out.println(
	 * "================================================================================"
	 * );
	 * 
	 * String login = Teclado.lerTexto("Login : "); String senha =
	 * Teclado.lerTexto("Senha : "); String nome = Teclado.lerTexto("Nome : ");
	 * String email = Teclado.lerTexto("Email : "); String telefone =
	 * Teclado.lerTexto("Telefone : ");
	 * 
	 * 
	 * codigoCliente = new Cliente(matricula, login, senha, nome, email, telefone);
	 * 
	 * System.out.println(
	 * "================================================================================"
	 * ); System.out.
	 * println("					Usuario Cadastrado com Sucesso!           					"
	 * ); System.out.println(
	 * "================================================================================"
	 * );
	 * 
	 * System.out.println(codigoCliente); }
	 */

	@SuppressWarnings("unlikely-arg-type")
	public void inserirNotebook() {
		// L� O NOTEBOOK ESCOLHIDO DO TECLADO
		String numeroNote = Teclado.lerTexto("Informe o n�mero do notebook" + "para compra:");

		// CRIA PEDIDO
		if (pedido == null) {
			pedido = new Pedido();
		}
		// BUSCA NOTEBOOK SELECIONADO
		Notebook aux = null;
		for (int i = 0; i < modelo.length; i++) {
			if (modelo[i] != null && numeroNote.equals(modelo[i].getNumeroNote())) {
				aux = modelo[i];
			}
			// SE N�O EXISTIR, INTERROMPE
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
		for (int i = 0; i < modelo.length; i++) {
			if (modelo[i] != null) {
				System.out.println(modelo[i].getNumeroNote() + "------" + modelo[i].getModelo());
			}
		}
	}

	public void manterCarrinho() {
		System.out.println(" manterCarrinho - Em Constru��o");
	}

	public void efetuarCompra() {
		System.out.println(" efetuarCompra - Em Constru��o");
	}
}
