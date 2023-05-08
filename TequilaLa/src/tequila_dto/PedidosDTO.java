package tequila_dto;

public class PedidosDTO {
	private int comanda_codigo, comanda_cliente_cpf, comanda_funcionario_codigo,
			comanda_entregue;

	public int getComanda_codigo() {
		return comanda_codigo;
	}

	public void setComanda_codigo(int comanda_codigo) {
		this.comanda_codigo = comanda_codigo;
	}

	public int getComanda_cliente_codigo() {
		return comanda_cliente_cpf;
	}

	public void setComanda_cliente_codigo(int comanda_cliente_cpf) {
		this.comanda_cliente_cpf = comanda_cliente_cpf;
	}

	public int getComanda_funcionario_codigo() {
		return comanda_funcionario_codigo;
	}

	public void setComanda_funcionario_codigo(int comanda_funcionario_codigo) {
		this.comanda_funcionario_codigo = comanda_funcionario_codigo;
	}

	public int getComanda_entregue() {
		return comanda_entregue;
	}

	public void setComanda_entregue(int comanda_entregue) {
		this.comanda_entregue = comanda_entregue;
	}
}
