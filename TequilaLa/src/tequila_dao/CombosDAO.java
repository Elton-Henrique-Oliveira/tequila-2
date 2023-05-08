package tequila_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tequila_dto.CombosDTO;
import tequila_dto.ProdutoDTO;

public class CombosDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	private ArrayList<CombosDTO> lista;
	private ArrayList<ProdutoDTO> lista2;
	private String sql = "";

	public int cadastrarCombos(CombosDTO objcombosDTO) {
		int retorno = 0;
		lista = new ArrayList<>();

		lista = buscaCombos(1, objcombosDTO.getCombo_nome());

		if (lista.size() > 0) {

			JOptionPane.showMessageDialog(null, "Combo já cadastrado no banco de dados!!\n");
			retorno = 1;

		} else {

			sql = "insert into";
			sql += "	tequila_combo";
			sql += "		(combo_nome, combo_desconto, combo_ativo)";
			sql += "	values";
			sql += "		(?, ?, 1);";

			conn = new ConexaoDAO().conectaBD();
			try {

				pstm = conn.prepareStatement(sql);
				pstm.setString(1, objcombosDTO.getCombo_nome());
				pstm.setInt(2, objcombosDTO.getCombo_desconto());
				pstm.execute();
				pstm.close();

			} catch (SQLException error) {
				JOptionPane.showMessageDialog(null, "COMBOS DAO" + error);
			}
		}

		return retorno;
	}

	public ArrayList<CombosDTO> buscaCombos(int pIndicador, String combo) {
		lista = new ArrayList<>();

		sql = "select *";
		sql += " from tequila_combo";
		if (pIndicador == 1) {
			sql += " where ";
			if (combo.trim().equals("") == false) {
				sql += "  	combo_nome = '" + combo + "'";
			}
		}

		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next() == true) {

				CombosDTO objcomboDTO = new CombosDTO();
				objcomboDTO.setCombo_codigo(rs.getInt("combo_codigo"));
				objcomboDTO.setCombo_nome(rs.getString("combo_nome"));
				objcomboDTO.setCombo_desconto(rs.getInt("combo_Desconto"));
				lista.add(objcomboDTO);

			}
			rs.close();
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "\nCOMBOS DAO" + error);
		}
		return lista;
	}

	public int buscaCombosProdutos(String combo) {
		lista = new ArrayList<>();
		lista2 = new ArrayList<>();
		int retorno = -1;

		sql = "select produto_codigo,produto_custo,produto_nome,produto_peso,produto_preco,combo_codigo,combo_desconto,combo_nome,combo_codigo";
		sql += " from tequila_produto_combo";
		sql += " inner join tequila_produto on produto_codigo = procom_produto_codigo";
		sql += " inner join tequila_combo on combo_nome = ? and combo_codigo = procom_combo_codigo;";

		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, combo);
			rs = pstm.executeQuery();

			while (rs.next() == true) {
				System.out.println("TESTANDO AGORA");
				ProdutoDTO objprodutoDTO = new ProdutoDTO();
				objprodutoDTO.setProduto_codigo(rs.getInt("produto_codigo"));
				objprodutoDTO.setProduto_custo(rs.getInt("produto_custo"));
				objprodutoDTO.setProduto_nome(rs.getString("produto_nome"));
				objprodutoDTO.setProduto_peso(rs.getInt("produto_peso"));
				objprodutoDTO.setProduto_preco(rs.getInt("produto_preco"));
				lista2.add(objprodutoDTO);

				if (retorno != 1) {
					CombosDTO objcomboDTO = new CombosDTO();
					objcomboDTO.setCombo_codigo(rs.getInt("combo_codigo"));
					objcomboDTO.setCombo_desconto(rs.getInt("combo_desconto"));
					objcomboDTO.setCombo_nome(rs.getString("combo_nome"));
					lista.add(objcomboDTO);
				}

				retorno = 1;
			}

			rs.close();
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "\nCOMBOS DAO" + error);
		}
		return retorno;
	}

	public ArrayList<ProdutoDTO> getLista2() {
		return lista2;
	}

	public void setLista2(ArrayList<ProdutoDTO> lista2) {
		this.lista2 = lista2;
	}

	public ArrayList<CombosDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<CombosDTO> lista) {
		this.lista = lista;
	}
}
