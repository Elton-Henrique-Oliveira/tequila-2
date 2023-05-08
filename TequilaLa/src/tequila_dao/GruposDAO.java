package tequila_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tequila_dto.GruposDTO;

public class GruposDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	private ArrayList<GruposDTO> lista;
	private String sql = "";

	public int buscaGrupos(int pIndicador, String grupo) {
		this.lista = new ArrayList<>();
		int retorno = -1;

		sql = "select *";
		sql += " from tequila_grupo";
		if (pIndicador == 1) {
			sql += " where ";
			sql += "  	grupo_nome = '" + grupo + "'";

		}

		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				GruposDTO objgrupoDTO = new GruposDTO();
				objgrupoDTO.setGrupo_codigo(rs.getInt("grupo_codigo"));
				objgrupoDTO.setGrupo_nome(rs.getString("grupo_nome"));
				objgrupoDTO.setGrupo_desconto(rs.getInt("grupo_desconto"));
				this.lista.add(objgrupoDTO);

				retorno = 1;
			}
			rs.close();
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "\nGRUPOS DAO" + error);
		}
		return retorno;
	}

	public ArrayList<GruposDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<GruposDTO> lista) {
		this.lista = lista;
	}
}
