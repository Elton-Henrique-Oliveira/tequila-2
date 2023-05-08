package tequila_dto;

public class FuncionarioDTO {
	private String funcionario_nome, funcionario_cpf, funcionario_telefone, funcionario_usuario, funcionario_senha,
			funcionario_cargo_nome;
	private int funcionario_administrador, funcionario_cargo, funcionario_codigo;

	public String getFuncionario_cargo_nome() {
		return funcionario_cargo_nome;
	}

	public void setFuncionario_cargo_nome(String funcionario_cargo_nome) {
		this.funcionario_cargo_nome = funcionario_cargo_nome;
	}

	public int getFuncionario_codigo() {
		return funcionario_codigo;
	}

	public void setFuncionario_codigo(int funcionario_codigo) {
		this.funcionario_codigo = funcionario_codigo;
	}

	public String getFuncionario_nome() {
		return funcionario_nome;
	}

	public void setFuncionario_nome(String funcionario_nome) {
		this.funcionario_nome = funcionario_nome;
	}

	public String getFuncionario_cpf() {
		return funcionario_cpf;
	}

	public void setFuncionario_cpf(String funcionario_cpf) {
		this.funcionario_cpf = funcionario_cpf;
	}

	public int getFuncionario_cargo() {
		return funcionario_cargo;
	}

	public void setFuncionario_cargo(int funcionario_cargo) {
		this.funcionario_cargo = funcionario_cargo;
	}

	public String getFuncionario_telefone() {
		return funcionario_telefone;
	}

	public void setFuncionario_telefone(String funcionario_telefone) {
		this.funcionario_telefone = funcionario_telefone;
	}

	public String getFuncionario_usuario() {
		return funcionario_usuario;
	}

	public void setFuncionario_usuario(String funcionario_usuario) {
		this.funcionario_usuario = funcionario_usuario;
	}

	public String getFuncionario_senha() {
		return funcionario_senha;
	}

	public void setFuncionario_senha(String funcionario_senha) {
		this.funcionario_senha = funcionario_senha;
	}

	public int getFuncionario_administrador() {
		return funcionario_administrador;
	}

	public void setFuncionario_administrador(int funcionario_administrador) {
		this.funcionario_administrador = funcionario_administrador;
	}
}
