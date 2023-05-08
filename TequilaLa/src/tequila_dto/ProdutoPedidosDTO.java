package tequila_dto;

public class ProdutoPedidosDTO {
	private int procom_codigo, procom_produto_codigo, procom_pedido_codigo, procom_produto_quantidade;
	private String procom_grupo;

	public String getProcom_grupo() {
		return procom_grupo;
	}

	public void setProcom_grupo(String procom_grupo) {
		this.procom_grupo = procom_grupo;
	}

	public int getProcom_produto_quantidade() {
		return procom_produto_quantidade;
	}

	public void setProcom_produto_quantidade(int procom_produto_quantidade) {
		this.procom_produto_quantidade = procom_produto_quantidade;
	}

	public int getProcom_codigo() {
		return procom_codigo;
	}

	public void setProcom_codigo(int procom_codigo) {
		this.procom_codigo = procom_codigo;
	}

	public int getProcom_produto_codigo() {
		return procom_produto_codigo;
	}

	public void setProcom_produto_codigo(int procom_produto_codigo) {
		this.procom_produto_codigo = procom_produto_codigo;
	}

	public int getProcom_pedido_codigo() {
		return procom_pedido_codigo;
	}

	public void setProcom_pedido_codigo(int procom_pedido_codigo) {
		this.procom_pedido_codigo = procom_pedido_codigo;
	}
}
