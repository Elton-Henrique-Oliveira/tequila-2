package tequila_dto;

public class ProdutoDTO {
	private String produto_nome;
	private int produto_codigo, produto_preco, produto_custo, produto_peso;
	public String getProduto_nome() {
		return produto_nome;
	}
	public void setProduto_nome(String produto_nome) {
		this.produto_nome = produto_nome;
	}
	public int getProduto_codigo() {
		return produto_codigo;
	}
	public void setProduto_codigo(int produto_codigo) {
		this.produto_codigo = produto_codigo;
	}
	public int getProduto_preco() {
		return produto_preco;
	}
	public void setProduto_preco(int produto_preco) {
		this.produto_preco = produto_preco;
	}
	public int getProduto_custo() {
		return produto_custo;
	}
	public void setProduto_custo(int produto_custo) {
		this.produto_custo = produto_custo;
	}
	public int getProduto_peso() {
		return produto_peso;
	}
	public void setProduto_peso(int produto_peso) {
		this.produto_peso = produto_peso;
	}
}
