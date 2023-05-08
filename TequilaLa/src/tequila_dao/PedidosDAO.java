package tequila_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tequila_dto.ClienteDTO;
import tequila_dto.PedidosDTO;
import tequila_dto.ProdutoDTO;
import tequila_dto.ProdutoPedidosDTO;

public class PedidosDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	private ArrayList<PedidosDTO> lista;
	private ArrayList<ProdutoPedidosDTO> lista2;
	private ArrayList<ProdutoDTO> lista3;
	private ArrayList<ClienteDTO> lista4;
	private String sql = "";

	public int criaComanda(ArrayList<PedidosDTO> comanda, ArrayList<ProdutoPedidosDTO> produtos, int cpf_cliente) {
		int retorno = 0, retorno2 = 0;
		
		retorno2 = buscaComanda(1, comanda.get(0).getComanda_cliente_codigo());
		
		if (retorno2 == 1) {
			adicionaComanda(comanda, produtos);
			retorno = 1;
		} else {

			sql = "insert into";
			sql += "	tequila_comanda";
			sql += "		(comanda_cliente_cpf, comanda_funcionario_codigo, comanda_entregue)";
			sql += "	values";
			sql += "		(?, ?, 2)";

			conn = new ConexaoDAO().conectaBD();
			try {

				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, comanda.get(0).getComanda_cliente_codigo());
				pstm.setInt(2, comanda.get(0).getComanda_funcionario_codigo());
				pstm.execute();
				pstm.close();

				adicionaComanda(comanda, produtos);

				retorno = 1;
			} catch (SQLException error) {
				JOptionPane.showMessageDialog(null, "COMBOS DAO" + error);
			}
		}

		return retorno;
	}

	public void adicionaComanda(ArrayList<PedidosDTO> comanda, ArrayList<ProdutoPedidosDTO> produtos) {
		int numero = 1;
		String valores = "";

		sql = "\ninsert into";
		sql += "\n	tequila_comanda_itens";
		sql += "\n		(compro_produto_codigo, compro_produto_quantidade, compro_comanda_codigo, compro_combo_nome)";
		sql += "\n	values";
		for (int num = 1; num <= produtos.size(); num++) {
			if (valores.trim().equals("") == false) {
				valores += ",";
			}
			valores += "\n (?, ?, (select comanda_codigo from tequila_comanda where comanda_cliente_cpf = ? and comanda_entregue = 2), ?)";
		}
		sql += valores;

		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);

			for (int num = 1; num <= produtos.size(); num++) {
				pstm.setInt(numero, produtos.get(num - 1).getProcom_produto_codigo());
				pstm.setInt(numero + 1, produtos.get(num - 1).getProcom_produto_quantidade());
				pstm.setInt(numero + 2, comanda.get(0).getComanda_cliente_codigo());
				pstm.setString(numero + 3, produtos.get(num - 1).getProcom_grupo());
				numero += 4;
			}
			System.out.println(pstm);
			pstm.execute();
			pstm.close();

		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, "PRODUTOS PEDIDO DAO AQUI: \n" + error);
		}
	}

	public int buscaComanda(int pIndicador, int cliente) {
		this.lista = new ArrayList<>();
		this.lista4 = new ArrayList<>();

		int retorno = -1;

		sql = "select *";
		sql += " from tequila_comanda";
		if (pIndicador == 1 || pIndicador == 2) {
			sql += " where ";
			sql += "  	comanda_cliente_cpf = '" + cliente + "'";
			sql += "  	and comanda_entregue = 2";
		}
		if (pIndicador == 3) {
			sql += " inner join tequila_cliente on cliente_cpf = comanda_cliente_cpf";
			sql += " where ";
			sql += "  	comanda_entregue = 1";
		}
		System.out.println(sql);
		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				PedidosDTO obpedidosDTO = new PedidosDTO();
				obpedidosDTO.setComanda_codigo(rs.getInt("comanda_codigo"));
				obpedidosDTO.setComanda_cliente_codigo(rs.getInt("comanda_cliente_cpf"));
				obpedidosDTO.setComanda_entregue(rs.getInt("comanda_cliente_cpf"));
				obpedidosDTO.setComanda_funcionario_codigo(rs.getInt("comanda_funcionario_codigo"));
				this.lista.add(obpedidosDTO);

				if (pIndicador == 3) {

					ClienteDTO objclienteDTO = new ClienteDTO();
					objclienteDTO.setCliente_codigo(rs.getInt("cliente_codigo"));
					objclienteDTO.setCliente_cpf(rs.getString("cliente_cpf"));
					objclienteDTO.setCliente_nome(rs.getString("cliente_nome"));
					objclienteDTO.setCliente_telefone(rs.getString("cliente_telefone"));
					this.lista4.add(objclienteDTO);

				}

				if (pIndicador == 1) {
					buscaProdutosComanda(rs.getInt("comanda_cliente_cpf"));
				}
				retorno = 1;
			}
			rs.close();
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "\nPEDIDOS DAO" + error);
		}
		return retorno;
	}

	public int limparComanda(String cliente) {

		int retorno = -1;

		sql = "\ndelete from tequila_comanda_itens";
		sql += "\n where ";
		sql += "\n compro_comanda_codigo = (select comanda_codigo from tequila_comanda where comanda_cliente_cpf = '"
				+ cliente + "' and comanda_entregue = 2)";
		System.out.println(sql);
		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			pstm.execute();
			System.out.println(pstm);
			pstm.close();

		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "\nPEDIDOS LIMPAR DAO" + error);
		}
		
		return retorno;
	}

	public int confirmarPedido(String cliente) {

		int retorno = -1;

		sql = "\nupdate tequila_comanda set comanda_entregue = 1";
		sql += "\n where ";
		sql += "\n comanda_cliente_cpf = '" + cliente + "' and comanda_entregue = 2";

		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			pstm.execute();
			pstm.close();

		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "\nPEDIDOS CONFIRMAR DAO" + error);
		}
		return retorno;
	}

	public int finalizaPedido(int codigo_pedido) {

		int retorno = -1;

		sql = "\nupdate tequila_comanda set comanda_entregue = 3";
		sql += "\n where ";
		sql += "\n comanda_codigo = " + codigo_pedido + " and comanda_entregue = 1";

		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			pstm.execute();
			pstm.close();

			retorno = 1;

		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "\nPEDIDOS FINALIZAR DAO" + error);
		}
		return retorno;
	}

	public void buscaProdutosComanda(int pedido) {
		this.lista2 = new ArrayList<>();
		this.lista3 = new ArrayList<>();

		sql = "select tequila_produto.*, tequila_comanda_itens.*";
		sql += " from tequila_produto";
		sql += " inner join tequila_comanda_itens on compro_produto_codigo = produto_codigo";
		sql += " where compro_comanda_codigo = (select comanda_codigo from tequila_comanda where comanda_cliente_cpf = "
				+ pedido + " and and comanda_entregue = 2);";

		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				ProdutoPedidosDTO objprodutopedidosDTO = new ProdutoPedidosDTO();
				objprodutopedidosDTO.setProcom_codigo(rs.getInt("compro_codigo"));
				objprodutopedidosDTO.setProcom_pedido_codigo(rs.getInt("compro_comanda_codigo"));
				objprodutopedidosDTO.setProcom_produto_codigo(rs.getInt("compro_produto_codigo"));
				objprodutopedidosDTO.setProcom_produto_quantidade(rs.getInt("compro_produto_quantidade"));
				objprodutopedidosDTO.setProcom_grupo(rs.getString("procom_grupo_nome"));
				this.lista2.add(objprodutopedidosDTO);

				ProdutoDTO objprodutoDTO = new ProdutoDTO();
				objprodutoDTO.setProduto_codigo(rs.getInt("produto_codigo"));
				objprodutoDTO.setProduto_nome(rs.getString("produto_nome"));
				objprodutoDTO.setProduto_preco(rs.getInt("produto_preco"));
				objprodutoDTO.setProduto_custo(rs.getInt("produto_custo"));
				objprodutoDTO.setProduto_peso(rs.getInt("produto_peso"));
				this.lista3.add(objprodutoDTO);
			}
			rs.close();
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "\nPRODUTOS DAO" + error);
		}
	}

	public ArrayList<PedidosDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<PedidosDTO> lista) {
		this.lista = lista;
	}

	public ArrayList<ProdutoPedidosDTO> getLista2() {
		return lista2;
	}

	public void setLista2(ArrayList<ProdutoPedidosDTO> lista2) {
		this.lista2 = lista2;
	}

	public ArrayList<ProdutoDTO> getLista3() {
		return lista3;
	}

	public void setLista3(ArrayList<ProdutoDTO> lista3) {
		this.lista3 = lista3;
	}

	public ArrayList<ClienteDTO> getLista4() {
		return lista4;
	}

	public void setLista4(ArrayList<ClienteDTO> lista4) {
		this.lista4 = lista4;
	}
}
