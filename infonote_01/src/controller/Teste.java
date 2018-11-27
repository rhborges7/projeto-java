package controller;

import model.*;

public class Teste {

	public static void main(String[] args) {

		
		//CRIA플O DE UM OBJETO NOVO EM Usuario E SET DOS VALORES
		
				Usuario usuario = new Usuario(647349, "rhborges7", "****","rhborges7@gmail.com", "Rhuan Borges", "967674907");
				System.out.println(usuario.toString()); // USO DO METODO toString PARA DAR SAIDA NO CONSOLE DOS VALORES INSERIDOS EM Usuario

			System.out.println("___________________________________________________________________________________");
				
		//CRIA플O DE UM OBJETO NOVO EM Endereco E SET DOS VALORES		
				
			Endereco endereco = new Endereco("Nao Sei", "164", "Nao sei", "bangu", "rio de janeiro", "RJ", "21-840-555"); 
			System.out.println(endereco.toString()); // USO DO METODO toString PARA DAR SAIDA NO CONSOLE DOS VALORES INSERIDOS EM Endereco

			System.out.println("___________________________________________________________________________________");

			Pedido pedido = new Pedido(4555, "22/11/2018", "Boleto", 1800.00, "Ferrado" ); //CRIA플O DE UM OBJETO NOVO NA CLASSE Pedido E SET DOS VALORES
			System.out.println(pedido.toString()); // USO DO METODO toString PARA DAR SAIDA NO CONSOLE DOS VALORES INSERIDOS EM Pedido

	System.out.println("___________________________________________________________________________________");
		
			ItemDePedido Idp1 = new ItemDePedido(22, 554); //CRIA플O DE UM OBJETO NOVO NA CLASSE ItemDePedido E SET DOS VALORES
			System.out.println(Idp1.toString()); // USO DO METODO toString PARA DAR SAIDA NO CONSOLE DOS VALORES INSERIDOS EM Idp1

	System.out.println("___________________________________________________________________________________");

			ItemDePedido Idp2 = new ItemDePedido(1, 8); //CRIA플O DE UM OBJETO SEMELHANTE AO ANTERIOR NA CLASSE ItemDePedido E SET DOS VALORES
			System.out.println(Idp2.toString()); // USO DO METODO toString PARA DAR SAIDA NO CONSOLE DOS VALORES INSERIDOS EM Idp2

	System.out.println("___________________________________________________________________________________");

			Notebook ntbook1 = new Notebook(454, "Nao Sei", "sla", 54, 21.00, "sla", "21/10/1100");  //CRIA플O DE UM OBJETO NOVO NA CLASSE Notebook E SET DOS VALORES
			System.out.println(ntbook1.toString()); // USO DO METODO TO STRING PARA DAR SAIDA DOS VALORES INSERIDOS EM ntbook1 NO CONSOLE

	System.out.println("___________________________________________________________________________________");

			Notebook ntbook2 = new Notebook(50, "Indefinido 2", "Indefinido 2", 8, 21.00, "Indefinido 2", "21/10/1100"); //CRIA플O DE UM OBJETO SEMELHANTE AO ANTERIOR NA CLASSE ItemDePedido E SET DOS VALORES
			System.out.println(ntbook2.toString()); // USO DO METODO TO STRING PARA DAR SAIDA DOS VALORES INSERIDOS EM ntbook2 NO CONSOLE

	System.out.println("___________________________________________________________________________________");

			Notebook ntbook3 = new Notebook(60, "Indefinido 3", "Indefinido 3", 10, 23.50,"Indefinido 3", "22/11/2018"); //CRIA플O DE UM OBJETO SEMELHANTE AO ANTERIOR NA CLASSE ItemDePedido E SET DOS VALORES
			System.out.println(ntbook3.toString()); // USO DO METODO TO STRING PARA DAR SAIDA DOS VALORES INSERIDOS EM ntbook3 NO CONSOLE

	}
}
