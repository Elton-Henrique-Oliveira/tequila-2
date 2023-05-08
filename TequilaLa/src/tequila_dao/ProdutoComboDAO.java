package tequila_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tequila_dto.CombosDTO;
import tequila_dto.ProdutoDTO;

public class ProdutoComboDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	private ArrayList<CombosDTO> lista;
	private ArrayList<ProdutoDTO> lista2;

	private String sql = "";

	public void AdicionarProduto(String combo, String produto) {

		sql = "insert into";
		sql += "	tequila_produto_combo";
		sql += "		(procom_produto_codigo, procom_combo_codigo)";
		sql += "	values";
		sql += "		((select produto_codigo from tequila_produto where produto_nome = ?), (select combo_codigo from tequila_combo where combo_nome = ?));";

		conn = new ConexaoDAO().conectaBD();

		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, combo);
			pstm.setString(2, produto);
			pstm.execute();
			pstm.close();

		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, "PRODUTO COMBO DAO" + error);
		}

	}

	public int BuscaProdutoCombo(String combo) {
		this.lista = new ArrayList<>();
		this.lista2 = new ArrayList<>();
		int retorno = -1;

		sql = "select *";
		sql += " from tequila_produto_combo";
		sql += " inner join tequila_combo on combo_codigo = procom_combo_codigo";
		sql += " inner join tequila_produto on produto_codigo = procom_produto_codigo";
		sql += " where combo_nome = '" + combo + "';";

		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				CombosDTO objcomboDTO = new CombosDTO();
				objcomboDTO.setCombo_codigo(rs.getInt("combo_codigo"));
				objcomboDTO.setCombo_nome(rs.getString("combo_nome"));
				objcomboDTO.setCombo_desconto(rs.getInt("combo_Desconto"));
				this.lista.add(objcomboDTO);

				ProdutoDTO objprodutoDTO = new ProdutoDTO();
				objprodutoDTO.setProduto_codigo(rs.getInt("produto_codigo"));
				objprodutoDTO.setProduto_nome(rs.getString("produto_nome"));
				objprodutoDTO.setProduto_preco(rs.getInt("produto_preco"));
				objprodutoDTO.setProduto_custo(rs.getInt("produto_custo"));
				objprodutoDTO.setProduto_peso(rs.getInt("produto_peso"));
				this.lista2.add(objprodutoDTO);

				retorno = 1;
			}
			rs.close();
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "\nCOMBOS DAO" + error);
		}
		return retorno;
	}

	public ArrayList<CombosDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<CombosDTO> lista) {
		this.lista = lista;
	}

	public ArrayList<ProdutoDTO> getLista2() {
		return lista2;
	}

	public void setLista2(ArrayList<ProdutoDTO> lista2) {
		this.lista2 = lista2;
	}
}
