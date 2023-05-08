package tequila_dto;

public class PontoDTO {
	private int ponto_codigo, ponto_entrada;
	private String ponto_data, ponto_funcionario_cpf;

	public int getPonto_codigo() {
		return ponto_codigo;
	}

	public void setPonto_codigo(int ponto_codigo) {
		this.ponto_codigo = ponto_codigo;
	}

	public int getPonto_entrada() {
		return ponto_entrada;
	}

	public void setPonto_entrada(int ponto_entrada) {
		this.ponto_entrada = ponto_entrada;
	}

	public String getPonto_data() {
		return ponto_data;
	}

	public void setPonto_data(String ponto_data) {
		this.ponto_data = ponto_data;
	}

	public String getPonto_funcionario_cpf() {
		return ponto_funcionario_cpf;
	}

	public void setPonto_funcionario_cpf(String ponto_funcionario_cpf) {
		this.ponto_funcionario_cpf = ponto_funcionario_cpf;
	}
}
