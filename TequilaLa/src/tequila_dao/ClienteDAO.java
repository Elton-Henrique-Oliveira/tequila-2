package tequila_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tequila_dto.ClienteDTO;

public class ClienteDAO {

	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	private String sql = "";
	private ArrayList<ClienteDTO> lista;

	public int cadastrarCliente(ClienteDTO objclienteDTO) {
		int retorno = 0;

		lista = buscarCliente(objclienteDTO.getCliente_cpf());
		if (lista.size() == 0) {

			sql = "insert into";
			sql += "	tequila_cliente";
			sql += "		(cliente_nome, cliente_cpf, cliente_telefone, cliente_grupo)";
			sql += "	values";
			sql += "		(?, ?, ?, ?);";

			conn = new ConexaoDAO().conectaBD();
			try {

				pstm = conn.prepareStatement(sql);
				pstm.setString(1, objclienteDTO.getCliente_nome());
				pstm.setString(2, objclienteDTO.getCliente_cpf());
				pstm.setString(3, objclienteDTO.getCliente_telefone());
				pstm.setString(4, objclienteDTO.getCliente_grupo());
				pstm.execute();
				pstm.close();
			} catch (SQLException error) {
				JOptionPane.showMessageDialog(null, "CLIENTES DAO" + error);
			}

		} else {
			retorno = 1;
			JOptionPane.showMessageDialog(null, "Cliente já cadastrado!");
		}
		return retorno;
	}
	
	public int alterarCliente (ClienteDTO objclienteDTO) {
		int retorno = 0;

		lista = buscarCliente(objclienteDTO.getCliente_cpf());
		if (lista.size() > 0) {

			sql = "update tequila_cliente";
			sql += " set ";
			sql += "	cliente_grupo = ?";
			sql += " where ";
			sql += " 	cliente_cpf = ?;";

			conn = new ConexaoDAO().conectaBD();
			try {

				pstm = conn.prepareStatement(sql);
				pstm.setString(1, objclienteDTO.getCliente_grupo());
				pstm.setString(2, objclienteDTO.getCliente_cpf());
				pstm.execute();
				pstm.close();
				retorno = 1;
				
			} catch (SQLException error) {
				JOptionPane.showMessageDialog(null, "CLIENTES DAO" + error);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Cliente não cadastrado!");
		}
		return retorno;
	}

	public ArrayList<ClienteDTO> buscarCliente(String cliente_cpf) {

		lista = new ArrayList<>();

		sql = "select *";
		sql += " from tequila_cliente";
		if (cliente_cpf.trim().equals("") == false) {
			sql += " where ";
			if (cliente_cpf.trim().equals("") == false) {
				sql += " cliente_cpf = '" + cliente_cpf + "'";
			}
		}
		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				ClienteDTO objclienteDTO = new ClienteDTO();
				objclienteDTO.setCliente_codigo(rs.getInt("cliente_codigo"));
				objclienteDTO.setCliente_nome(rs.getString("cliente_nome"));
				objclienteDTO.setCliente_cpf(rs.getString("cliente_cpf"));
				objclienteDTO.setCliente_telefone(rs.getString("cliente_telefone"));
				objclienteDTO.setCliente_grupo(rs.getString("cliente_grupo"));
				lista.add(objclienteDTO);

			}
			rs.close();
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "\nCLIENTES DAO" + error);
		}
		return lista;
	}
	public ArrayList<ClienteDTO> buscarClientes (String cliente_cpf, String cliente_nome, String grupo) {

		lista = new ArrayList<>();
		String sql2 = "";

		sql = "select *";
		sql += " from tequila_cliente";
		if (cliente_cpf.trim().equals("") == false || cliente_nome.trim().equals("") == false || grupo.trim().equals("") == false) {
			sql += " where ";
			if (cliente_cpf.trim().equals("") == false) {
				sql2 += " cliente_cpf = '" + cliente_cpf + "'";
			}
			if(sql2.trim().equals("") == false) {
				sql2 += " and ";
			}
			if(cliente_nome.trim().equals("") == false) {
				sql2 += " cliente_nome like '%" + cliente_nome + "%'";
			}
			if(sql2.trim().equals("") == false) {
				sql2 += " and ";
			}
			if(grupo.trim().equals("") == false) {
				sql2 += " cliente_grupo like '%" + grupo + "%'";
			}
			sql += sql2;
		}

		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				ClienteDTO objclienteDTO = new ClienteDTO();
				objclienteDTO.setCliente_codigo(rs.getInt("cliente_codigo"));
				objclienteDTO.setCliente_nome(rs.getString("cliente_nome"));
				objclienteDTO.setCliente_cpf(rs.getString("cliente_cpf"));
				objclienteDTO.setCliente_telefone(rs.getString("cliente_telefone"));
				objclienteDTO.setCliente_grupo(rs.getString("cliente_grupo"));
				lista.add(objclienteDTO);

			}
			rs.close();
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "\nCLIENTES DAO" + error);
		}
		return lista;
	}
}
