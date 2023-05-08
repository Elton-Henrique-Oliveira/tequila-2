package tequila_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tequila_dto.ClienteDTO;
import tequila_dto.CombosDTO;
import tequila_dto.GruposDTO;
import tequila_dto.PedidosDTO;
import tequila_dto.ProdutoDTO;
import tequila_dto.ProdutoPedidosDTO;

public class ConsultasDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	private ArrayList<CombosDTO> lista;
	private ArrayList<ProdutoDTO> lista2;
	private ArrayList<GruposDTO> lista3;
	private ArrayList<ClienteDTO> lista4;
	private ArrayList<PedidosDTO> lista5;
	private ArrayList<ProdutoPedidosDTO> lista6;
	private ArrayList<ProdutoDTO> lista7;
	private ArrayList<Integer> grupos;
	private ArrayList<Integer> combos;
	private String sql = "";

	public int buscaTodos(int parametro) {
		this.lista = new ArrayList<>();
		this.lista2 = new ArrayList<>();
		this.lista3 = new ArrayList<>();
		this.grupos = new ArrayList<>();
		this.combos = new ArrayList<>();
		int retorno = -1, verifica = 0;
		int produto = 0, combo = 0, grupo = 0;

		sql  = "\nselect * from tequila_produto";
		sql += "\n inner join tequila_combo";
		if (parametro == 1) {
			sql += "\n inner join tequila_grupo";
		}
		sql += "\n order by produto_codigo;";

		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				if (rs.getInt("combo_codigo") != 0 && rs.getInt("combo_codigo") != combo) {
					combo = rs.getInt("combo_codigo");

					verifica = 0;
					for (int i = 0; i < combos.size(); i++) {
						if (combo == combos.get(i)) {
							verifica = 1;
						}
					}
					if (verifica == 0) {
						combos.add(combo);
						CombosDTO objcomboDTO = new CombosDTO();
						objcomboDTO.setCombo_codigo(rs.getInt("combo_codigo"));
						objcomboDTO.setCombo_nome(rs.getString("combo_nome"));
						objcomboDTO.setCombo_desconto(rs.getInt("combo_Desconto"));
						this.lista.add(objcomboDTO);
					}
				}
				if (rs.getInt("produto_codigo") != 0 && rs.getInt("produto_codigo") != produto) {
					ProdutoDTO objprodutoDTO = new ProdutoDTO();
					objprodutoDTO.setProduto_codigo(rs.getInt("produto_codigo"));
					objprodutoDTO.setProduto_nome(rs.getString("produto_nome"));
					objprodutoDTO.setProduto_preco(rs.getInt("produto_preco"));
					objprodutoDTO.setProduto_custo(rs.getInt("produto_custo"));
					objprodutoDTO.setProduto_peso(rs.getInt("produto_peso"));
					this.lista2.add(objprodutoDTO);
					produto = rs.getInt("produto_codigo");
				}
				if (parametro == 1) {
					if (rs.getInt("grupo_codigo") != 0 && rs.getInt("grupo_codigo") != grupo) {

						grupo = rs.getInt("grupo_codigo");

						verifica = 0;
						for (int i = 0; i < grupos.size(); i++) {
							if (grupo == grupos.get(i)) {
								verifica = 1;
							}
						}
						if (verifica == 0) {
							grupos.add(grupo);
							GruposDTO objgrupoDTO = new GruposDTO();
							objgrupoDTO.setGrupo_codigo(rs.getInt("grupo_codigo"));
							objgrupoDTO.setGrupo_nome(rs.getString("grupo_nome"));
							objgrupoDTO.setGrupo_desconto(rs.getInt("grupo_desconto"));
							this.lista3.add(objgrupoDTO);
						}
					}
				}
				retorno = 1;
			}
			rs.close();
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "\nTODOS DAO" + error);
		}
		return retorno;
	}

	public int buscaClienteTudo(String cpf_cliente, int pedido) {
		this.lista4 = new ArrayList<>();
		this.lista5 = new ArrayList<>();
		this.lista6 = new ArrayList<>();
		this.lista7 = new ArrayList<>();
		this.grupos = new ArrayList<>();
		this.combos = new ArrayList<>();
		int retorno = -1;
		
		sql  = "\nselect *";
		sql += "\n from tequila_cliente";
		sql += "\n inner join tequila_comanda on comanda_cliente_cpf = cliente_cpf and comanda_entregue = ?";
		sql += "\n inner join tequila_comanda_itens on compro_comanda_codigo = comanda_codigo";
		sql += "\n inner join tequila_produto on produto_codigo = compro_produto_codigo";
		sql += "\n where";
		if (cpf_cliente.trim().equals("") == false) {
			sql += "\n cliente_cpf = ?";
		} else {
			if (pedido != 0) {
				sql += "\n comanda_codigo = ?";
			}
		}

		conn = new ConexaoDAO().conectaBD();
		try {

			pstm = conn.prepareStatement(sql);
			if (cpf_cliente.trim().equals("") == false) {
				pstm.setInt(1, 2);
				pstm.setString(2, cpf_cliente);
			} else {
				if (pedido != 0) {
					pstm.setInt(1, 1);
					pstm.setInt(2, pedido);
				}
			}

			rs = pstm.executeQuery();

			while (rs.next()) {
				if (retorno != 1) {
					ClienteDTO objclienteDTO = new ClienteDTO();
					objclienteDTO.setCliente_codigo(rs.getInt("cliente_codigo"));
					objclienteDTO.setCliente_nome(rs.getString("cliente_nome"));
					objclienteDTO.setCliente_cpf(rs.getString("cliente_cpf"));
					objclienteDTO.setCliente_telefone(rs.getString("cliente_telefone"));
					this.lista4.add(objclienteDTO);

					PedidosDTO obpedidosDTO = new PedidosDTO();
					obpedidosDTO.setComanda_codigo(rs.getInt("comanda_codigo"));
					obpedidosDTO.setComanda_cliente_codigo(rs.getInt("comanda_cliente_cpf"));
					obpedidosDTO.setComanda_entregue(rs.getInt("comanda_cliente_cpf"));
					obpedidosDTO.setComanda_funcionario_codigo(rs.getInt("comanda_funcionario_codigo"));
					this.lista5.add(obpedidosDTO);
				}

				ProdutoPedidosDTO objprodutopedidosDTO = new ProdutoPedidosDTO();
				objprodutopedidosDTO.setProcom_codigo(rs.getInt("compro_codigo"));
				objprodutopedidosDTO.setProcom_pedido_codigo(rs.getInt("compro_comanda_codigo"));
				objprodutopedidosDTO.setProcom_produto_codigo(rs.getInt("compro_produto_codigo"));
				objprodutopedidosDTO.setProcom_produto_quantidade(rs.getInt("compro_produto_quantidade"));
				objprodutopedidosDTO.setProcom_grupo(rs.getString("compro_combo_nome"));
				this.lista6.add(objprodutopedidosDTO);

				ProdutoDTO objprodutoDTO = new ProdutoDTO();
				objprodutoDTO.setProduto_codigo(rs.getInt("produto_codigo"));
				objprodutoDTO.setProduto_nome(rs.getString("produto_nome"));
				objprodutoDTO.setProduto_preco(rs.getInt("produto_preco"));
				objprodutoDTO.setProduto_custo(rs.getInt("produto_custo"));
				objprodutoDTO.setProduto_peso(rs.getInt("produto_peso"));
				this.lista7.add(objprodutoDTO);

				retorno = 1;

			}
			rs.close();

			if (retorno == -1) {
				sql = "\nselect *";
				sql += "\n from tequila_cliente";
				sql += "\n where  cliente_cpf = ?;";

				conn = new ConexaoDAO().conectaBD();

				pstm = conn.prepareStatement(sql);
				pstm.setString(1, cpf_cliente);
				rs = pstm.executeQuery();

				if (rs.next()) {

					ClienteDTO objclienteDTO = new ClienteDTO();
					objclienteDTO.setCliente_codigo(rs.getInt("cliente_codigo"));
					objclienteDTO.setCliente_nome(rs.getString("cliente_nome"));
					objclienteDTO.setCliente_cpf(rs.getString("cliente_cpf"));
					objclienteDTO.setCliente_telefone(rs.getString("cliente_telefone"));
					objclienteDTO.setCliente_grupo(rs.getString("cliente_grupo"));
					this.lista4.add(objclienteDTO);

					retorno = 2;

				}

				rs.close();
			}
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, sql + "\nTODOS DAO" + error);
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

	public ArrayList<GruposDTO> getLista3() {
		return lista3;
	}

	public void setLista3(ArrayList<GruposDTO> lista3) {
		this.lista3 = lista3;
	}

	public ArrayList<ClienteDTO> getLista4() {
		return lista4;
	}

	public void setLista4(ArrayList<ClienteDTO> lista4) {
		this.lista4 = lista4;
	}

	public ArrayList<PedidosDTO> getLista5() {
		return lista5;
	}

	public void setLista5(ArrayList<PedidosDTO> lista5) {
		this.lista5 = lista5;
	}

	public ArrayList<ProdutoPedidosDTO> getLista6() {
		return lista6;
	}

	public void setLista6(ArrayList<ProdutoPedidosDTO> lista6) {
		this.lista6 = lista6;
	}

	public ArrayList<ProdutoDTO> getLista7() {
		return lista7;
	}

	public void setLista7(ArrayList<ProdutoDTO> lista7) {
		this.lista7 = lista7;
	}
}
