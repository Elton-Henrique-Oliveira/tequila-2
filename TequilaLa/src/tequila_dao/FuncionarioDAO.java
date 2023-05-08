package tequila_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tequila_dto.FuncionarioDTO;

public class FuncionarioDAO {

	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	private String sql = "";

	public int cadastrarFuncionario(FuncionarioDTO objfuncionarioDTO) {
		int retorno = 0;
		
		int retorna = buscaFuncionario(1, objfuncionarioDTO.getFuncionario_usuario(), "");

		if (retorna >= 1) {

			JOptionPane.showMessageDialog(null, "Usuário já cadastrado no banco de dados!!\n");
			retorno = 1;
			
		} else {

			sql = "insert into";
			sql += "	tequila_funcionario";
			sql += "		(funcionario_nome, funcionario_cpf, funcionario_telefone, funcionario_cargo, funcionario_usuario, funcionario_senha, funcionario_administrador)";
			sql += "	values";
			sql += "		(?, ?, ?, ?, ?, ? ,?);";

			conn = new ConexaoDAO().conectaBD();
			try {

				pstm = conn.prepareStatement(sql);
				pstm.setString(1, objfuncionarioDTO.getFuncionario_nome());
				pstm.setString(2, objfuncionarioDTO.getFuncionario_cpf());
				pstm.setString(3, objfuncionarioDTO.getFuncionario_telefone());
				pstm.setInt(4, objfuncionarioDTO.getFuncionario_cargo());
				pstm.setString(5, objfuncionarioDTO.getFuncionario_usuario());
				pstm.setString(6, objfuncionarioDTO.getFuncionario_senha());
				pstm.setInt(7, objfuncionarioDTO.getFuncionario_administrador());
				pstm.execute();
				pstm.close();
				
				retorno  = 2;
			} catch (SQLException error) {
				JOptionPane.showMessageDialog(null, "FUNCIONARIO DAO" + error);
			}
		}
		
		return retorno;
	}

	public int buscaFuncionario(int pIndicador, String usuario, String senha) {

		int retorno = -1;

		sql = "select *";
		sql += " from tequila_funcionario";
		if (pIndicador == 1) {
			sql += " where ";
			if (usuario.trim().equals("") == false) {
				sql += "  	funcionario_usuario = '" + usuario + "'";
			}
			if (senha.trim().equals("") == false) {
				sql += " 	and funcionario_senha = '" + senha + "';";
			}
		}

		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			if (rs.next()) {

				FuncionarioDTO objusuarioDTO = new FuncionarioDTO();
				objusuarioDTO.setFuncionario_nome(rs.getString("funcionario_nome"));
				objusuarioDTO.setFuncionario_cpf(rs.getString("funcionario_cpf"));
				objusuarioDTO.setFuncionario_telefone(rs.getString("funcionario_telefone"));
				objusuarioDTO.setFuncionario_cargo(rs.getInt("funcionario_cargo"));
				objusuarioDTO.setFuncionario_usuario(rs.getString("funcionario_usuario"));
				objusuarioDTO.setFuncionario_senha(rs.getString("funcionario_senha"));
				objusuarioDTO.setFuncionario_administrador(rs.getInt("funcionario_administrador"));
				objusuarioDTO.setFuncionario_codigo(rs.getInt("funcionario_codigo"));
				retorno = rs.getInt("funcionario_administrador");

			}
			rs.close();

		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "\nFUNCIONARIO DAO" + error);
		}
		return retorno;
	}

	public ArrayList<FuncionarioDTO> buscaFuncionarioTodos(String nome, String cpf) {
		ArrayList<FuncionarioDTO> lista = new ArrayList<>();

		sql = "select *,(select cargo_nome from tequila_cargo where cargo_codigo = funcionario_cargo) as cargo_nome";
		sql += " from tequila_funcionario";
		if (nome.trim().equals("") == false || cpf.trim().equals("") == false) {
			sql += " where ";
			if (nome.trim().equals("") == false) {
				sql += " funcionario_nome like '%" + nome + "%'";
			}
			if (cpf.trim().equals("") == false) {
				sql += " and funcionario_cpf = '" + cpf + "';";
			}
		}

		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				FuncionarioDTO objfuncionarioDTO = new FuncionarioDTO();
				objfuncionarioDTO.setFuncionario_nome(rs.getString("funcionario_nome"));
				objfuncionarioDTO.setFuncionario_cpf(rs.getString("funcionario_cpf"));
				objfuncionarioDTO.setFuncionario_telefone(rs.getString("funcionario_telefone"));
				objfuncionarioDTO.setFuncionario_cargo(rs.getInt("funcionario_cargo"));
				objfuncionarioDTO.setFuncionario_usuario(rs.getString("funcionario_usuario"));
				objfuncionarioDTO.setFuncionario_senha(rs.getString("funcionario_senha"));
				objfuncionarioDTO.setFuncionario_administrador(rs.getInt("funcionario_administrador"));
				objfuncionarioDTO.setFuncionario_codigo(rs.getInt("funcionario_codigo"));
				objfuncionarioDTO.setFuncionario_cargo_nome(rs.getString("cargo_nome"));
				lista.add(objfuncionarioDTO);

			}
			rs.close();
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "\nFUNCIONARIO DAO" + error);
		}
		return lista;
	}

	public void alterarSenha(FuncionarioDTO objfuncionarioDTO, String pSenhanova) {

		int retorna = buscaFuncionario(1, objfuncionarioDTO.getFuncionario_usuario(), "");

		if (retorna >= 1) {

			sql = "update tequila_funcionario";
			sql += "	set";
			sql += "		funcionario_senha = ?";
			sql += "	where";
			sql += "		funcionario_usuario = ? and funcionario_senha = ?;";

			conn = new ConexaoDAO().conectaBD();
			try {

				pstm = conn.prepareStatement(sql);
				pstm.setString(1, pSenhanova);
				pstm.setString(2, objfuncionarioDTO.getFuncionario_usuario());
				pstm.setString(3, objfuncionarioDTO.getFuncionario_senha());
				pstm.executeUpdate();
				pstm.close();

			} catch (SQLException error) {
				JOptionPane.showMessageDialog(null, "FUNCIONARIO DAO" + error);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Usuário não cadastrado!\n");
		}
	}
}
