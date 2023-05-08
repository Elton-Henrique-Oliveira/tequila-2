package tequila_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tequila_dto.CargosDTO;

public class CargosDAO {

	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	private CargosDTO objcargosDTO;
	private ArrayList<CargosDTO> cargos;
	
	String sql = "";

	public void cadastrarFuncionario(CargosDTO objcargosDTO) {
		
		cargos = new ArrayList<>();
		
		cargos = buscaCargos(1,objcargosDTO.getCargo_nome());

		if (cargos.size() >= 1) {

			JOptionPane.showMessageDialog(null, "Usuário já cadastrado no banco de dados!!\n");

		} else {

			sql = "insert into";
			sql += "	tequila_cargo";
			sql += "		(cargo_nome)";
			sql += "	values";
			sql += "		(?);";

			conn = new ConexaoDAO().conectaBD();
			try {

				pstm = conn.prepareStatement(sql);
				pstm.setString(1, objcargosDTO.getCargo_nome());
				pstm.execute();
				pstm.close();

			} catch (SQLException error) {
				JOptionPane.showMessageDialog(null, "CARGOS" + error);
			}
		}
	}

	public ArrayList<CargosDTO> buscaCargos(int pIndicador, String nome) {

		cargos = new ArrayList<>();

		sql = "select *";
		sql += " from tequila_cargo";
		if (pIndicador == 1) {
			sql += " where";
			sql += "  cargo_nome = '" + nome + "'";
		}
		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				objcargosDTO = new CargosDTO();
				objcargosDTO.setCargo_codigo(rs.getInt("cargo_codigo"));
				objcargosDTO.setCargo_nome(rs.getString("cargo_nome"));
				cargos.add(objcargosDTO);
			}
			rs.close();
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "\nProdutoDAO Pesquisar" + error);
		}

		return cargos;
	}

}
