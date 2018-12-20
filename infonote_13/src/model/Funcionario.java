package model;

import model.DAO.FuncionarioDAO;

public class Funcionario extends Usuario implements IUsuario {

	/**
	 * @param matricula
	 */

	private String matricula;

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * 
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Funcionario() {
		super();

	}

	public Funcionario(String login, String senha, int tipo, String matricula) {
		super(login, senha, tipo);
		this.matricula = matricula;
		// TODO Auto-generated constructor stub

	}

	public boolean validarLogin(String login, String senha) {
		Funcionario funcionario = FuncionarioDAO.buscarPorLoginSenha(login, senha);
		if (funcionario != null) {
			return true;
		} else {
			return false;

		}
	}
}
