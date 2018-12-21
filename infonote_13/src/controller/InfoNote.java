package controller;

import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;

import model.*;
import model.DAO.ClienteDAO;

import model.DAO.EnderecoDAO;
import model.DAO.FuncionarioDAO;
import model.DAO.NotebookDAO;
import model.DAO.UsuarioDAO;
import util.*;
import util.GerarSenha;
import util.Teclado;

public class InfoNote {

	Cliente cliente; // NÃO ESQUECER DE DAR O IMPORT NESTE OBJETO
	Notebook modelo[] = new Notebook[10];
	Pedido pedido;
	boolean logado = false; // INDICA SE O USUARIO ESTÁ LOGADO
	InfoNote info2;
	public static String sair;
	Configurador config;
	Ajuda ajuda;
	Usuario usuario;

	private static final int LOGIN = 1;
	private static final int CADASTRAR_USUARIO = 2;
	private static final int BUSCAR_NOTEBOOK = 3;
	private static final int INSERIR_NOTEBOOK = 4;
	private static final int REMOVER_NOTEBOOK = 5;
	private static final int VER_CARRINHO = 6;
	private static final int EFETUAR_COMPRA = 7;
	private static final int AJUDA = 8;
	private static final int AREA_ADMINISTRATIVA = 9;
	private static final int SAIR = 10;

	public InfoNote() {

		// CRIA OBJETO DE CONFIGURAÇÕES
		config = new Configurador();

		Locale.setDefault(new Locale(config.getIdioma(), config.getRegiao()));

		// CRIA O OBJETO AJUDA
		ajuda = new Ajuda(config.getArquivoAjuda());

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
			opcao = Teclado.lerInt("Digite sua Opção: ");

			switch (opcao) {

			case LOGIN:

				info.efetuarLogin();

				break;

			case CADASTRAR_USUARIO:
				info.cadastrarUsuario();
				break;

			case BUSCAR_NOTEBOOK:

				info.mostrarNotebook();
				break;

			case INSERIR_NOTEBOOK:
				info.inserirNotebook();
				break;

			case REMOVER_NOTEBOOK:

				info.manterCarrinho();
				break;

			case VER_CARRINHO:

				info.manterCarrinho();
				break;

			case EFETUAR_COMPRA:
				if (!info.logado) {
					System.out.println("Efetue Login para Efetuar Compra !");
					break;
				} else {
					info.efetuarCompra();
					break;
				}

			case AJUDA:
				info.ajuda();
				break;

			case AREA_ADMINISTRATIVA:
				info.areaAdministrativa();
				break;

			case SAIR:
				System.out.println("Saída do Sistema.");
				break;

			default:
				System.out.println("Opção Inválida !");
			}

		} while (opcao != SAIR);

		Teclado.lerTexto("Pressione uma tecla para continuar");

	}

	public void mostrarMenu() {
		if (logado == false) {
			System.out.println("================================================================================");
			System.out.println("                    InfoNote - Se não é Info não Vendemos                "
					+ DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " "
					+ DateFormat.getTimeInstance().format(new Date()));
			System.out.println("================================================================================");

			if (logado == true) {
				System.out.println("Seja bem vindo, " + cliente.getNomeInvertido());
			}
			System.out.println("1 - Login");
			System.out.println("2 - Cadastrar Cliente");

		} else {

			System.out.println("================================================================================");
			System.out.println("                    InfoNote - Se não é Info não Vendemos                ");
			System.out.println("================================================================================");
			System.out.println("                    Você esta conectado como " + cliente.getNomeInvertido());
			System.out.println("=======================================================================");
			System.out.println("3 - Buscar Notebook");
			System.out.println("4 - Inserir Notebook no Carrinho");
			System.out.println("5 - Remover Notebook no Carrinho");
			System.out.println("6 - Ver Carrinho");
			System.out.println("7 - Efetuar Compra");
			System.out.println("8 - Ajuda");
			System.out.println("9 - Area Administrativa");
			System.out.println("10 - Sair");
		}
	}

	public void efetuarLogin() {

		String login, senha;

		login = Teclado.lerTexto("Digite o Login : ");
		senha = Teclado.lerTexto("Digite a Senha : ");

		cliente = ClienteDAO.buscarPorLoginSenha(login, senha);

		// VALIDAÇÃO DOS LOGINS DOS CLIENTES
		if (cliente != null) {
			logado = cliente.validarLogin(login, senha);
			if (logado) {
				System.out.println("Login Efetuado com Sucesso !");
			} else {
				System.out.println("Login ou Senha Inválido!");

				int opcao2 = 3;
				do {
					System.out.println("Digite: ");
					System.out.println("|1| - Para efetuar Login");
					System.out.println("|2| - Para cadastrar-se ");
					System.out.println("|3| - Para sair do sistema ");

					opcao2 = Teclado.lerInt("");

					switch (opcao2) {
					case 1:
						efetuarLogin();
						break;
					case 2:
						cadastrarUsuario();
						break;
					case 3:
						System.out.println("Obrigado e volte sempre!");

					default:
						System.out.println("Opção invalida");
					}
				} while (logado == false);

			}
			// VALIDAÇÃO DOS LOGINS DOS FUNCIONARIOS

		}

	}

	public void efetuarLoginAdm() {
		String login, senha;
		login = Teclado.lerTexto("Digite o login : ");
		senha = Teclado.lerTexto("Digite a senha : ");

		Funcionario funcionario = FuncionarioDAO.buscarPorLoginSenha(login, senha);

		if (funcionario != null) {
			logado = funcionario.validarLogin(login, senha);

		} else {
			if (logado) {
				System.out.println("Login efetuado com sucesso!");
			} else {
				System.out.println("Usuario ou senha inválido.");
				System.exit(0);
			}
		}
	}

	public void areaAdministrativa() {
		InfoNote info = new InfoNote();

		efetuarLoginAdm();

		System.out.println("Opções Administrativas \n");
		System.out.println("1 - Cadastrar Notebook");
		System.out.println("2 - Mostrar Notebooks");
		System.out.println("3 - Editar Notebook");
		System.out.println("4 - Excluir Notebook");
		System.out.println("5 - Sair");

		int opcao = 5;
		do {
			opcao = Teclado.lerInt("Digite sua opção: ");

			switch (opcao) {

			case 1:
				info.cadastrarNotebook();
				break;
			case 2:
				info.mostrarNotebook();
				break;
			case 3:
				info.editarNotebook();
				break;
			case 4:
				info.excluirNotebook();
				break;
			case 5:
				System.out.println("Saida do Sistema");
			default:
				System.out.println("Opção invalida!");
			}
			Teclado.lerTexto("Pressione uma tecla para continuar...");
		} while (opcao != 5);
	}

	public void mostrarNotebook() {

		/*
		 * Notebook[] notebooks = NotebookDAO.buscarTodos(); for (int i = 0; i <
		 * notebooks.length; i++) { System.out.println(notebooks[i].getSerialNote() +
		 * "--------" + notebooks[i].getModelo() + "--------" +
		 * notebooks[i].getDescricao() + "--------" + notebooks[i].getEstoque() +
		 * "--------" + notebooks[i].getPrecoUnitario() + "--------" +
		 * notebooks[i].getFigura() + "--------" + notebooks[i].getDataCadastro());
		 * 
		 * }
		 */

		Notebook[] notebook = NotebookDAO.buscarTodos();
		for (int i = 0; i < notebook.length; i++) {
			if (notebook[i] != null) {
				System.out.println(notebook[i].getSerialNote() + "-----" + notebook[i].getModelo() + "-----"
						+ notebook[i].getDescricao() + "-----" + notebook[i].getFigura() + "-----"
						+ notebook[i].getDataCadastro() + "-----" + notebook[i].getEstoque() + "-----"
						+ notebook[i].getPrecoUnitario());

			}
		}

	}

	public void editarNotebook() {
		System.out.println("================================================");
		System.out.println("	   Atualizar Informações do Notebook				");
		System.out.println("================================================");
		String serialNote = Teclado.lerTexto("Digite o numero de serie do notebook a ser editado :");
		// NotebookDAO.buscarTodos(serialNote);

		String descricao = Teclado.lerTexto("Descricao do Notebook: ");
		int estoque = Teclado.lerInt("Estoque: ");
		double precoUnitario = Teclado.lerDouble("Preço Unitario do Notebook: ");
		String figura = Teclado.lerTexto("Imagem do Notebook: ");
		String dataCadastro = Teclado.lerTexto("Data de Cadastro: ");

		NotebookDAO.atualizar(serialNote, descricao, estoque, precoUnitario, figura, dataCadastro);

		System.out.println("Mensagem atualizada com sucesso");

	}

	public void excluirNotebook() {

		System.out.println("================================================");
		System.out.println("		 Apagar um Notebook			");
		System.out.println("================================================");
		String serialNote = Teclado.lerTexto("Digite o número de Serie do Notebook a ser apagado :");

		NotebookDAO.excluir(serialNote);

		System.out.println("Notebook apagado com sucesso");

	}

	public void cadastrarUsuario() {

		Cliente cliente;

		System.out.println("================================================================================");
		System.out.println("                    InfoNote - Cadastro de Usuarios                ");
		System.out.println("================================================================================");

		String login = Teclado.lerTexto("Login : ");
		String senha = Teclado.lerTexto("Senha : ");
		if (senha.equals("") || senha == null) {
			senha = GerarSenha.gerarSenha();
			System.out.println("Senha gerada:" + senha);
		}
		int tipo = 0; // TODO CLIENTE É TIPO 0
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

		usuario = UsuarioDAO.inserir(login, senha, tipo);

		cliente = ClienteDAO.inserir(login, senha, tipo, codigoCliente, nome, email, telefone);

		Endereco endereco = EnderecoDAO.inserir(logradouro, numero, complemento, bairro, cidade, estado, cep,
				codigoCliente);

		System.out.println(cliente);
		System.out.println(endereco);

		System.out.println("================================================================================");
		System.out.println("					Cliente Cadastrado com Sucesso!           					");
		System.out.println("================================================================================");

	}

	public void inserirNotebook() {
		// LÊ O NOTEBOOK ESCOLHIDO DO TECLADO
		String numeroNote = Teclado.lerTexto("Informe o número do notebook" + "para compra:");

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

	/*
	 * public void buscarNotebook() { for (int i = 0; i < notebooks.length; i++) {
	 * if (notebooks[i] != null) { System.out.println(notebooks[i].getnumeroNote() +
	 * "-----" + notebooks[i].getModelo()); } }
	 * 
	 * }
	 */

	public void manterCarrinho() {
		System.out.println(" manterCarrinho - Em Construção");
	}

	public void efetuarCompra() {
		System.out.println(" efetuarCompra - Em Construção");
	}

	public void ajuda() {
		System.out.println(ajuda.getTexto());

	}

	public void cadastrarNotebook() {
		System.out.println("===========================================================");
		System.out.println("		Cadastrar Um Novo Notebook ");
		System.out.println("===========================================================");

		String serialNote = Teclado.lerTexto("Numero de Serie do Notebook: ");
		String modelo = Teclado.lerTexto("Modelo do Notebook: ");
		String descricao = Teclado.lerTexto("Descricao do Notebook: ");
		int estoque = Teclado.lerInt("Estoque: ");
		double precoUnitario = Teclado.lerDouble("Preço Unitario do Notebook: ");
		String figura = Teclado.lerTexto("Imagem do Notebook: ");
		String dataCadastro = Teclado.lerTexto("Data de Cadastro: ");

		Notebook notebook = NotebookDAO.inserirNotebook(serialNote, modelo, descricao, estoque, precoUnitario, figura,
				dataCadastro);

		System.out.println(notebook);

	}

}
