package tequila_dto;

public class ClienteDTO {
	int cliente_codigo;
	String cliente_nome, cliente_cpf, cliente_telefone, cliente_grupo;

	public String getCliente_grupo() {
		return cliente_grupo;
	}

	public void setCliente_grupo(String cliente_grupo) {
		this.cliente_grupo = cliente_grupo;
	}

	public int getCliente_codigo() {
		return cliente_codigo;
	}

	public void setCliente_codigo(int cliente_codigo) {
		this.cliente_codigo = cliente_codigo;
	}

	public String getCliente_nome() {
		return cliente_nome;
	}

	public void setCliente_nome(String cliente_nome) {
		this.cliente_nome = cliente_nome;
	}

	public String getCliente_cpf() {
		return cliente_cpf;
	}

	public void setCliente_cpf(String cliente_cpf) {
		this.cliente_cpf = cliente_cpf;
	}

	public String getCliente_telefone() {
		return cliente_telefone;
	}

	public void setCliente_telefone(String cliente_telefone) {
		this.cliente_telefone = cliente_telefone;
	}
}
