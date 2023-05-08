package tequila_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tequila_dto.ProdutoDTO;

public class ProdutoDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	private ArrayList<ProdutoDTO> lista;
	private String sql = "";

	public int cadastrarProduto(ProdutoDTO objprodutoDTO) {
		int retorno = 0;

		int retorna = buscaProdutos(1, objprodutoDTO.getProduto_nome());

		if (retorna == 1) {

			JOptionPane.showMessageDialog(null, "Produto já cadastrado no banco de dados!!\n");
			retorno = 1;

		} else {

			sql = "insert into";
			sql += "	tequila_produto";
			sql += "		(produto_nome, produto_preco, produto_custo, produto_peso)";
			sql += "	values";
			sql += "		(?, ?, ?, ?);";

			conn = new ConexaoDAO().conectaBD();
			try {

				pstm = conn.prepareStatement(sql);
				pstm.setString(1, objprodutoDTO.getProduto_nome());
				pstm.setInt(2, objprodutoDTO.getProduto_preco());
				pstm.setInt(3, objprodutoDTO.getProduto_custo());
				pstm.setInt(4, objprodutoDTO.getProduto_peso());
				pstm.execute();
				pstm.close();

			} catch (SQLException error) {
				JOptionPane.showMessageDialog(null, "PRODUTO DAO" + error);
			}
		}

		return retorno;
	}

	public int buscaProdutos(int pIndicador, String produto) {
		this.lista = new ArrayList<>();
		int retorno = -1;

		sql = "select *";
		sql += " from tequila_produto";
		if (pIndicador == 1) {
			if (produto.trim().equals("") == false) {
				sql += " where ";
				sql += "  	produto_nome like '%" + produto + "%'";
			}
		}
		if (pIndicador == 3) {
			if (produto.trim().equals("") == false) {
				sql += " where ";
				sql += "  	produto_nome = '" + produto + "'";
			}
		}

		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				ProdutoDTO objprodutoDTO = new ProdutoDTO();
				objprodutoDTO.setProduto_codigo(rs.getInt("produto_codigo"));
				objprodutoDTO.setProduto_nome(rs.getString("produto_nome"));
				objprodutoDTO.setProduto_preco(rs.getInt("produto_preco"));
				objprodutoDTO.setProduto_custo(rs.getInt("produto_custo"));
				objprodutoDTO.setProduto_peso(rs.getInt("produto_peso"));
				this.lista.add(objprodutoDTO);

				retorno = 1;
			}
			rs.close();
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "\nPRODUTO DAO" + error);
		}
		return retorno;
	}

	public ArrayList<ProdutoDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<ProdutoDTO> lista) {
		this.lista = lista;
	}
}
