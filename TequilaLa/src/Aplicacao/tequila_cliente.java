package Aplicacao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import tequila_dao.ClienteDAO;
import tequila_dao.GruposDAO;
import tequila_dto.ClienteDTO;
import tequila_modelos.TableModelCliente;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class tequila_cliente extends JInternalFrame {
	private JTextField txt_nome;
	private JTextField txt_cpf;
	private JTextField txt_telefone;
	private JTextField txt_nome_pesquisa;
	private JTextField txt_cpf_pesquisa;
	private JTable tabela_clientes;
	private JButton btnConsultar;
	private JLabel lblCpf_1;
	private JLayeredPane layeredPane_1;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JLabel lblTelefone;
	private JTabbedPane tabbedPane;
	private JLabel lblNewLabel;
	private JLabel lblCpf;
	private JScrollPane scrollPane;
	private ArrayList<ClienteDTO> lista = new ArrayList<>();
	private JButton btnPedidos;
	private JLabel lbl_grupo;
	private JComboBox<String> cb_grupo;
	private JLabel lblCpf_1_1;
	private JComboBox<String> cb_grupo_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tequila_cliente frame = new tequila_cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tequila_cliente() {
		setTitle("Clientes");
		setIconifiable(true);
		setClosable(true);
		getContentPane().setBackground(SystemColor.activeCaption);
		setBounds(100, 100, 616, 493);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.activeCaption);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Cadastrar", null, layeredPane, null);

		lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(115, 38, 92, 32);
		layeredPane.add(lblNewLabel);

		lblCpf = new JLabel("Cpf");
		lblCpf.setFont(new Font("Arial", Font.BOLD, 15));
		lblCpf.setBounds(115, 83, 92, 32);
		layeredPane.add(lblCpf);

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 15));
		lblTelefone.setBounds(115, 126, 92, 32);
		layeredPane.add(lblTelefone);

		txt_nome = new JTextField();
		txt_nome.setForeground(Color.WHITE);
		txt_nome.setBackground(Color.GRAY);
		txt_nome.setFont(new Font("Arial", Font.BOLD, 15));
		txt_nome.setBounds(217, 38, 271, 32);
		layeredPane.add(txt_nome);
		txt_nome.setColumns(10);

		txt_cpf = new JTextField();
		txt_cpf.setForeground(Color.WHITE);
		txt_cpf.setBackground(Color.GRAY);
		txt_cpf.setFont(new Font("Arial", Font.BOLD, 15));
		txt_cpf.setColumns(10);
		txt_cpf.setBounds(217, 81, 80, 32);
		layeredPane.add(txt_cpf);

		txt_telefone = new JTextField();
		txt_telefone.setForeground(Color.WHITE);
		txt_telefone.setBackground(Color.GRAY);
		txt_telefone.setFont(new Font("Arial", Font.BOLD, 15));
		txt_telefone.setColumns(9);
		txt_telefone.setBounds(217, 126, 119, 32);
		layeredPane.add(txt_telefone);

		btnNewButton = new JButton("CADASTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarCliente();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(150, 247, 147, 32);
		layeredPane.add(btnNewButton);

		lbl_grupo = new JLabel("Grupo");
		lbl_grupo.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_grupo.setBounds(115, 169, 92, 32);
		layeredPane.add(lbl_grupo);

		cb_grupo = new JComboBox<String>();
		cb_grupo.setForeground(Color.WHITE);
		cb_grupo.setBackground(Color.GRAY);
		cb_grupo.setFont(new Font("Arial", Font.BOLD, 15));
		cb_grupo.setBounds(217, 169, 271, 32);
		layeredPane.add(cb_grupo);

		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarCliente();
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.BOLD, 15));
		btnAlterar.setBounds(307, 247, 147, 32);
		layeredPane.add(btnAlterar);

		layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Consultar", null, layeredPane_1, null);

		lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 38, 53, 32);
		layeredPane_1.add(lblNewLabel_1);

		txt_nome_pesquisa = new JTextField();
		txt_nome_pesquisa.setForeground(Color.WHITE);
		txt_nome_pesquisa.setFont(new Font("Arial", Font.BOLD, 15));
		txt_nome_pesquisa.setColumns(10);
		txt_nome_pesquisa.setBackground(Color.GRAY);
		txt_nome_pesquisa.setBounds(73, 38, 271, 32);
		layeredPane_1.add(txt_nome_pesquisa);

		txt_cpf_pesquisa = new JTextField();
		txt_cpf_pesquisa.setForeground(Color.WHITE);
		txt_cpf_pesquisa.setFont(new Font("Arial", Font.BOLD, 15));
		txt_cpf_pesquisa.setColumns(10);
		txt_cpf_pesquisa.setBackground(Color.GRAY);
		txt_cpf_pesquisa.setBounds(73, 81, 96, 32);
		layeredPane_1.add(txt_cpf_pesquisa);

		lblCpf_1 = new JLabel("Cpf");
		lblCpf_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblCpf_1.setBounds(10, 83, 53, 32);
		layeredPane_1.add(lblCpf_1);

		btnConsultar = new JButton("BUSCAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscClientes();
			}
		});
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 15));
		btnConsultar.setBounds(367, 81, 196, 32);
		layeredPane_1.add(btnConsultar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 169, 575, 255);
		layeredPane_1.add(scrollPane);

		tabela_clientes = new JTable();
		scrollPane.setViewportView(tabela_clientes);

		btnPedidos = new JButton("PEDIDOS");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tequila_pedidos pedidos;
				try {
					pedidos = new tequila_pedidos();
					pedidos.setVisible(true);
					pedidos.txt_cliente.setText(txt_cpf_pesquisa.getText());
					pedidos.verificaPedidoCliente2();
					getParent().add(pedidos);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPedidos.setFont(new Font("Arial", Font.BOLD, 15));
		btnPedidos.setBounds(367, 38, 196, 32);
		layeredPane_1.add(btnPedidos);

		lblCpf_1_1 = new JLabel("Grupo");
		lblCpf_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblCpf_1_1.setBounds(10, 126, 53, 32);
		layeredPane_1.add(lblCpf_1_1);

		cb_grupo_1 = new JComboBox<String>();
		cb_grupo_1.setForeground(Color.WHITE);
		cb_grupo_1.setFont(new Font("Arial", Font.BOLD, 15));
		cb_grupo_1.setBackground(Color.GRAY);
		cb_grupo_1.setBounds(73, 124, 271, 34);
		layeredPane_1.add(cb_grupo_1);

		buscaGrupos();
	}

	public void cadastrarCliente() {
		String nome = "", cpf = "", telefone = "", mensagem_validacao = "", grupo = "";
		int retorno = 0;

		try {

			nome = txt_nome.getText();
			cpf = txt_cpf.getText();
			telefone = txt_telefone.getText();
			grupo = cb_grupo.getSelectedItem().toString();

			if (nome.trim().equals("") == true) {
				mensagem_validacao += "\nDigite o nome do cliente!!";
			}
			if (cpf.trim().equals("") == true) {
				mensagem_validacao += "\nDigite o cpf do cliente!!";
			}
			if (telefone.trim().equals("") == true) {
				mensagem_validacao += "\nDigite o telefone do cliente!!";
			}

			if (mensagem_validacao.trim().equals("") == true) {

				ClienteDTO objclienteDTO = new ClienteDTO();
				objclienteDTO.setCliente_nome(nome);
				objclienteDTO.setCliente_cpf(cpf);
				objclienteDTO.setCliente_telefone(telefone);
				objclienteDTO.setCliente_grupo(grupo);

				ClienteDAO objclienteDAO = new ClienteDAO();
				retorno = objclienteDAO.cadastrarCliente(objclienteDTO);

				if (retorno != 1) {
					txt_nome.setText("");
					txt_telefone.setText("");
					txt_cpf.setText("");
				}

			} else {
				JOptionPane.showMessageDialog(null, mensagem_validacao);
			}

		} catch (Exception error2) {
			JOptionPane.showMessageDialog(null, error2);
		}
	}

	@SuppressWarnings("unused")
	public void alterarCliente() {
		String nome = "", cpf = "", telefone = "", mensagem_validacao = "", grupo = "";
		int retorno = 0;

		try {

			cpf = txt_cpf.getText();
			grupo = cb_grupo.getSelectedItem().toString();

			ClienteDTO objclienteDTO = new ClienteDTO();
			objclienteDTO.setCliente_nome(nome);
			objclienteDTO.setCliente_cpf(cpf);
			objclienteDTO.setCliente_telefone(telefone);
			objclienteDTO.setCliente_grupo(grupo);

			ClienteDAO objclienteDAO = new ClienteDAO();
			retorno = objclienteDAO.alterarCliente(objclienteDTO);

			if (retorno == 1) {
				txt_nome.setText("");
				txt_telefone.setText("");
				txt_cpf.setText("");
			}

		} catch (Exception error2) {
			JOptionPane.showMessageDialog(null, error2);
		}
	}

	@SuppressWarnings("static-access")
	public void buscClientes() {
		ArrayList<Object> dados = new ArrayList<>();
		String[] colunas = new String[] { "Cliente", "CPF", "Telefone", "Grupo" };
		String nome = "", cpf = "", grupo = "";

		nome = txt_nome_pesquisa.getText();
		cpf = txt_cpf_pesquisa.getText();
		grupo = cb_grupo_1.getSelectedItem().toString();

		try {
			ClienteDAO objclienteDAO = new ClienteDAO();
			lista = objclienteDAO.buscarClientes(cpf, nome, grupo);

			if (lista.size() != 0) {
				for (int num = 0; num < lista.size(); num++) {
					dados.add(new Object[] { lista.get(num).getCliente_nome(), lista.get(num).getCliente_cpf(),
							lista.get(num).getCliente_telefone(), lista.get(num).getCliente_grupo() });
				}
			} else {
				dados = new ArrayList<>();
			}

			TableModelCliente modelo = new TableModelCliente(dados, colunas);
			tabela_clientes.setModel(modelo);
			tabela_clientes.getColumnModel().getColumn(0).setPreferredWidth(200);
			tabela_clientes.getColumnModel().getColumn(0).setResizable(false);
			tabela_clientes.getColumnModel().getColumn(1).setPreferredWidth(100);
			tabela_clientes.getColumnModel().getColumn(1).setResizable(false);
			tabela_clientes.getColumnModel().getColumn(2).setPreferredWidth(100);
			tabela_clientes.getColumnModel().getColumn(2).setResizable(false);
			tabela_clientes.getColumnModel().getColumn(3).setPreferredWidth(172);
			tabela_clientes.getColumnModel().getColumn(3).setResizable(false);
			tabela_clientes.getTableHeader().setReorderingAllowed(false);
			tabela_clientes.setAutoResizeMode(tabela_clientes.AUTO_RESIZE_OFF);
			tabela_clientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		} catch (

		Exception error) {
			JOptionPane.showMessageDialog(null, "Erro ao preencher tabela" + error);
		}
	}

	public void buscaGrupos() {
		int retorno = 0;

		GruposDAO objgrupoDAO = new GruposDAO();
		retorno = objgrupoDAO.buscaGrupos(0, "");

		cb_grupo.removeAllItems();
		cb_grupo.addItem("");
		cb_grupo_1.removeAllItems();
		cb_grupo_1.addItem("");

		if (retorno == 1) {
			for (int i = 0; i < objgrupoDAO.getLista().size(); i++) {
				cb_grupo.addItem(objgrupoDAO.getLista().get(i).getGrupo_nome());
				cb_grupo_1.addItem(objgrupoDAO.getLista().get(i).getGrupo_nome());
			}
		}

	}
}
