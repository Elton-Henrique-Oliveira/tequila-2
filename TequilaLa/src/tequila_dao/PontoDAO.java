package tequila_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tequila_dto.PontoDTO;

public class PontoDAO {

	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	private String sql = "";
	private ArrayList<PontoDTO> lista;

	public void registrarPonto(String funcionario_cpf, int entrada) {

		sql = "insert into";
		sql += "	tequila_ponto";
		sql += "		(ponto_funcionario_usuario, ponto_entrada)";
		sql += "	values";
		sql += "		(?, ?);";

		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, funcionario_cpf);
			pstm.setInt(2, entrada);

			pstm.execute();
			pstm.close();

		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, "PONTO DAO" + error);
		}

	}
		
	public ArrayList<PontoDTO> buscaPontos (String funcionario_cpf, int entrada){
		lista = new ArrayList<>();
		
		sql = "select *";
		sql += " from tequila_ponto";
		if (funcionario_cpf.trim().equals("") == false) {
			sql += " where ";
			sql += "  ponto_funcionario_usuario = " + funcionario_cpf;
			if (entrada != 0) {
				sql += " ponto_entrada = '" + entrada + "'";
			}
		}
		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				PontoDTO objpontoDTO = new PontoDTO();
				objpontoDTO.setPonto_entrada(rs.getInt("ponto_entrada"));
				objpontoDTO.setPonto_funcionario_cpf(rs.getString("ponto_funcionario_cpf"));
				lista.add(objpontoDTO);

			}
			rs.close();
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "\nCLIENTES DAO" + error);
		}
		
		return lista;
	}
}
