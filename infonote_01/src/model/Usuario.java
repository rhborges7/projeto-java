package model;

public class Usuario {

	public int matricula;
	public String login;
	public String senha;
	public String nome;
	public String email;
	public String telefone;

	/**
	 * @return the matricula
	 */
	public int getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

	/**
	 * @param matricula
	 * @param login
	 * @param senha
	 * @param nome
	 * @param email
	 * @param telefone
	 */
	public Usuario(int matricula, String login, String senha, String nome, String email, String telefone) {
		super();
		this.matricula = matricula;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	// METODO MOSTRAR PARAR DAR SAIDA NOS VALORES INDICADOS 
	public  void mostrar() {
		System.out.println("Matricula : " + matricula);
		System.out.println("Login: " + login);
		System.out.println("Senha: " + senha);
		System.out.println("Email: " + email);
		System.out.println("Nome: " + nome);
		System.out.println("Telefone: " + telefone);

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usuario \n matricula =" + matricula + "\n login =" + login + "\n senha =" + senha + "\n nome =" + nome
				+ "\n email =" + email + "\n telefone =" + telefone ;
	}
}
