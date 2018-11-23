package controller;

import model.*;

public class Teste {

	public static void main(String[] args) {

		//CRIA플O DE UM OBJETO NOVO EM Usuario E SET DOS VALORES
		Usuario usuario = new Usuario();

		usuario.setMatricula(647349);
		usuario.setLogin("rhborges7");
		usuario.setSenha("****");
		usuario.setEmail("rhborges7@gmail.com");
		usuario.setNome("Rhuan Borges");
		usuario.setTelefone("967674907");
		usuario.mostrar(); // USO DO METODO MOSTRAR PARA DAR SAIDA NO CONSOLE DOS VALORES INSERIDOS EM Usuario

	System.out.println("___________________________________________________________________________________");
		
		Endereco endereco = new Endereco(); //CRIA플O DE UM OBJETO NOVO EM Endereco E SET DOS VALORES
		

		endereco.setLogradouro("Nao Sei");
		endereco.setNumero("164");
		endereco.setComplemento("Nao sei");
		endereco.setBairro("bangu");
		endereco.setCidade("rio de janeiro");
		endereco.setEstado("RJ");
		endereco.setCep("21-840-555");
		endereco.mostrar(); // USO DO METODO MOSTRAR PARA DAR SAIDA NO CONSOLE DOS VALORES INSERIDOS EM Endereco

	System.out.println("___________________________________________________________________________________");

		Pedido pedido = new Pedido(); //CRIA플O DE UM OBJETO NOVO NA CLASSE Pedido E SET DOS VALORES

		pedido.setNumero(4555);
		pedido.setDataEmissao("22/11/2018");
		pedido.setFormaDePagamento("Boleto");
		pedido.setValorTotal(1800.00);
		pedido.setSituacao("Ferrado");
		pedido.mostrar(); // USO DO METODO MOSTRAR PARA DAR SAIDA NO CONSOLE DOS VALORES INSERIDOS EM Pedido

	System.out.println("___________________________________________________________________________________");
		
		ItemDePedido Idp1 = new ItemDePedido(); //CRIA플O DE UM OBJETO NOVO NA CLASSE ItemDePedido E SET DOS VALORES

		Idp1.setQtde(22);
		Idp1.setSubtotal(554);
		Idp1.mostrar(); // USO DO METODO MOSTRAR PARA DAR SAIDA NO CONSOLE DOS VALORES INSERIDOS EM Idp1

	System.out.println("___________________________________________________________________________________");

		ItemDePedido Idp2 = new ItemDePedido(); //CRIA플O DE UM OBJETO SEMELHANTE AO ANTERIOR NA CLASSE ItemDePedido E SET DOS VALORES

		Idp2.setQtde(1);
		Idp2.setSubtotal(8);
		Idp2.mostrar(); // USO DO METODO MOSTRAR PARA DAR SAIDA NO CONSOLE DOS VALORES INSERIDOS EM Idp2

	System.out.println("___________________________________________________________________________________");

		Notebook ntbook1 = new Notebook();  //CRIA플O DE UM OBJETO NOVO NA CLASSE Notebook E SET DOS VALORES

		ntbook1.setNumeroNote(454);
		ntbook1.setModelo("Nao Sei");
		ntbook1.setDescricao("sla");
		ntbook1.setEstoque(54);
		ntbook1.setPrecoUnitario(21.00);
		ntbook1.setFigura("sla");
		ntbook1.setDataCadastro("21/10/1100");
		System.out.println(ntbook1.toString()); // USO DO METODO TO STRING PARA DAR SAIDA DOS VALORES INSERIDOS EM ntbook1 NO CONSOLE

	System.out.println("___________________________________________________________________________________");

		Notebook ntbook2 = new Notebook(); //CRIA플O DE UM OBJETO SEMELHANTE AO ANTERIOR NA CLASSE ItemDePedido E SET DOS VALORES

		ntbook2.setNumeroNote(50);
		ntbook2.setModelo("Indefinido 2");
		ntbook2.setDescricao("Indefinido 2");
		ntbook2.setEstoque(8);
		ntbook2.setPrecoUnitario(21.00);
		ntbook2.setFigura("Indefinido 2");
		ntbook2.setDataCadastro("21/10/1100");
		System.out.println(ntbook2.toString()); // USO DO METODO TO STRING PARA DAR SAIDA DOS VALORES INSERIDOS EM ntbook2 NO CONSOLE

	System.out.println("___________________________________________________________________________________");

		Notebook ntbook3 = new Notebook(); //CRIA플O DE UM OBJETO SEMELHANTE AO ANTERIOR NA CLASSE ItemDePedido E SET DOS VALORES

		ntbook3.setNumeroNote(60);
		ntbook3.setModelo("Indefinido 3");
		ntbook3.setDescricao("Indefinido 3");
		ntbook3.setEstoque(10);
		ntbook3.setPrecoUnitario(23.50);
		ntbook3.setFigura("Indefinido 3");
		ntbook3.setDataCadastro("22/11/2018");
		System.out.println(ntbook3.toString()); // USO DO METODO TO STRING PARA DAR SAIDA DOS VALORES INSERIDOS EM ntbook3 NO CONSOLE

	}
}
