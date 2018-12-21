package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Notebook;
import util.Conexao;
import util.Configurador;

public class NotebookDAO {

	Configurador config = new Configurador();

	String url;
	String driver;
	String login;
	String senha;

	public NotebookDAO() {

		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();
	}

	public static Notebook inserirNotebook(String serialNote, String modelo, String descricao, int estoque,
			double precoUnitario, String figura, String dataCadastro) {

		Notebook notebook = null;
		NotebookDAO noteDAO = new NotebookDAO();

		try {
			// CRAI��O DO INSERT
			String sql = "insert into notebook"
					+ "(serialNote,modelo,descricao,estoque,precoUnitario,figura,dataCadastro)"
					+ " values(?,?,?,?,?,?,?)";

			// OBTER A CONEX�O COM O BANCO DE DADOS
			Conexao conex = new Conexao(noteDAO.url, noteDAO.driver, noteDAO.login, noteDAO.senha);

			// ABRIR CONEXAO
			Connection con = conex.obterConexao();

			// PREPARAR O COMANDO PARA SER EXECUTADO
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, serialNote);
			comando.setString(2, modelo);
			comando.setString(3, descricao);
			comando.setInt(4, estoque);
			comando.setDouble(5, precoUnitario);
			comando.setString(6, figura);
			comando.setString(7, dataCadastro);

			// COMANDO EXECUTADO
			comando.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		notebook = new Notebook(serialNote, modelo, descricao, estoque, precoUnitario, figura, dataCadastro);
		return notebook;

	}

	public static Notebook[] buscarTodos() {
		Notebook[] notebooks = null;

		NotebookDAO noteDAO = new NotebookDAO();

		try {
			// CRIA��O DO SELECT
			String sql = "Select * from notebook";

			// OBTER A CONEXAO COM BANCO DE DADOS
			Conexao conex = new Conexao(noteDAO.url, noteDAO.driver, noteDAO.login, noteDAO.senha);

			Connection con = conex.obterConexao();

			Statement comando = con.createStatement();

			ResultSet rs = comando.executeQuery(sql);

			notebooks = new Notebook[10];

			int i = 0;
			while (rs.next()) {
				notebooks[i++] = new Notebook(rs.getString("serialNote"), rs.getString("modelo"),
						rs.getString("descricao"), rs.getInt("estoque"), rs.getDouble("precoUnitario"),
						rs.getString("figura"), rs.getString("dataCadastro"));

			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return notebooks;

	}

	

	

	public static Notebook excluir(String serialNote) {

		Notebook notebook = null;
		NotebookDAO noteDAO = new NotebookDAO();

		try {

			// CRIA��O DO DELETE
			String sql = "delete from contato where serialNote = ? ";

			// OBTER A CONEX�O COM O BANCO DE DADOS
			Conexao conex = new Conexao(noteDAO.url, noteDAO.driver, noteDAO.login, noteDAO.senha);
			// ABRIR A CONEX�O
			Connection con = conex.obterConexao();

			// PREPARAR O COMANDO PARA SER EXECUTADO
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, serialNote);
			comando.executeUpdate();

			// COMANDO EXECUTADO
			comando.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return notebook;

	}
	
	

	public static Notebook atualizar(String serialNote, String descricao, int estoque,
			double precoUnitario, String figura, String dataCadastro) {

		Notebook notebook = null;
		NotebookDAO noteDAO = new NotebookDAO();
		try {
			// CRIA��O DO UPDATE
			String sql = "update notebook set "
					+ " descricao = ?,  estoque = ?, "
					+ " precoUnitario = ?, figura = ?, dataCadastro = ? "
					+ " where "
					+ " serialnote = ? ";
			
			// OBTER A CONEX�O COM O BANCO DE DADOS
			Conexao conex = new Conexao(noteDAO.url, noteDAO.driver, noteDAO.login, noteDAO.senha);
			// ABRIR A CONEX�O
			Connection con = conex.obterConexao();

			// PREPARAR O COMANDO PARA SER EXECUTADO
			PreparedStatement comando = con.prepareStatement(sql);

			
			
			comando.setString(1, descricao);
			comando.setInt(2, estoque);
			comando.setDouble(3, precoUnitario);
			comando.setString(4, figura);
			comando.setString(5, dataCadastro);
			comando.setString(6, serialNote);

			// COMANDO EXECUTADO
			comando.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return notebook;

	}

}
