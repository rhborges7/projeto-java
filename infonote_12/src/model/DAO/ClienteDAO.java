package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Cliente;
import util.Conexao;
import util.Configurador;


public class ClienteDAO {
	
	Configurador config = new Configurador();
	
	String url;
	String driver;
	String login;
	String senha;
	
	public ClienteDAO() {
		
		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();
	}
	
	public static Cliente inserir(String login,String senha, int tipo, String codigoCliente, String nome, String email, String telefone) {
		Cliente cliente = null;
		ClienteDAO cliDAO = new ClienteDAO();
		
		try {
			// CRIAÇÃO DO INSERT
			String sql = "insert into cliente" + 
						"(codigocliente, nome, email, telefone, fklogin)" + 
						"values (?,?,?,?,?)";
			// OBTER A CONEXAO COM O BANCO DE DADOS
			Conexao conex = new Conexao(cliDAO.url, cliDAO.driver, cliDAO.login, cliDAO.senha);
			
			// ABRIR A CONEXAO
			Connection con = conex.obterConexao();
			
			// PREPARAR O COMANDO PARA SER EXECUTADO
			PreparedStatement comando = con.prepareStatement(sql);
			
			comando.setString(1, codigoCliente);
			comando.setString(2, nome);
			comando.setString(3, email);
			comando.setString(4, telefone);
			comando.setString(5, login);
			// NAO É fklogin PQ AQUI A REFERENCIA É DA CLASSE
			
			// COMANDO EXECUTADO
			comando.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		cliente = new Cliente(login,senha,tipo,codigoCliente,nome,email,telefone);
		
		return cliente;
	}
	
	

}
