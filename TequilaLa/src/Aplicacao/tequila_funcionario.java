package Aplicacao;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import tequila_dao.CargosDAO;
import tequila_dao.FuncionarioDAO;
import tequila_dto.CargosDTO;
import tequila_dto.FuncionarioDTO;
import tequila_modelos.TableModelFuncionario;

import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class tequila_funcionario extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_nome;
	private JTextField txt_cpf;
	private JTextField txt_telefone;
	private JTextField txt_usuario;
	private JTextField txt_senha;
	private JLayeredPane layeredPane_2;
	@SuppressWarnings("rawtypes")
	private JComboBox cb_funcionario_posicao_1;
	private JButton btnNewButton;
	private JLabel lblSenha;
	private JLabel lblAdministrador;
	private JLabel lblTelefone;
	private JLabel lblCpf;
	private JLayeredPane layeredPane;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private JTabbedPane tabbedPane;
	@SuppressWarnings("rawtypes")
	private JComboBox cb_funcionario_cargo_1;
	private JLabel lblCargo;
	private JLabel lblUsurio;
	private JTextField txt_nome_consulta;
	private JTextField txt_cpf_consulta;
	private JTable tabela_funcionarios;
	private JScrollPane scrollPane;
	private JButton btnConsultar;
	private JLabel lblNewLabel_1;
	private JLabel lblCpf_1;
	private ArrayList<FuncionarioDTO> lista = new ArrayList<>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tequila_funcionario frame = new tequila_funcionario();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public tequila_funcionario() {
		setTitle("Funcionario");
		setIconifiable(true);
		setClosable(true);
		getContentPane().setBackground(SystemColor.activeCaption);
		setBounds(100, 100, 750, 492);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.activeCaption);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		layeredPane = new JLayeredPane();
		layeredPane.setBackground(SystemColor.textHighlight);
		layeredPane.setForeground(Color.DARK_GRAY);
		tabbedPane.addTab("Cadastro", null, layeredPane, null);
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setForegroundAt(0, Color.DARK_GRAY);
		tabbedPane.setBackgroundAt(0, SystemColor.inactiveCaption);
		layeredPane.setLayout(null);

		lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(162, 54, 73, 32);
		layeredPane.add(lblNewLabel);

		txt_nome = new JTextField();
		txt_nome.setForeground(Color.WHITE);
		txt_nome.setFont(new Font("Arial", Font.BOLD, 15));
		txt_nome.setColumns(10);
		txt_nome.setBackground(Color.GRAY);
		txt_nome.setBounds(247, 60, 315, 26);
		layeredPane.add(txt_nome);

		txt_cpf = new JTextField();
		txt_cpf.setForeground(Color.WHITE);
		txt_cpf.setFont(new Font("Arial", Font.BOLD, 15));
		txt_cpf.setColumns(10);
		txt_cpf.setBackground(Color.GRAY);
		txt_cpf.setBounds(247, 103, 98, 26);
		layeredPane.add(txt_cpf);

		lblCpf = new JLabel("CPF");
		lblCpf.setBackground(Color.GRAY);
		lblCpf.setForeground(SystemColor.desktop);
		lblCpf.setFont(new Font("Arial", Font.BOLD, 15));
		lblCpf.setBounds(162, 97, 73, 32);
		layeredPane.add(lblCpf);

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(SystemColor.desktop);
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 15));
		lblTelefone.setBounds(381, 97, 73, 32);
		layeredPane.add(lblTelefone);

		txt_telefone = new JTextField();
		txt_telefone.setForeground(Color.WHITE);
		txt_telefone.setFont(new Font("Arial", Font.BOLD, 15));
		txt_telefone.setColumns(10);
		txt_telefone.setBackground(Color.GRAY);
		txt_telefone.setBounds(464, 100, 98, 26);
		layeredPane.add(txt_telefone);

		cb_funcionario_cargo_1 = new JComboBox();
		cb_funcionario_cargo_1.setForeground(Color.WHITE);
		cb_funcionario_cargo_1.setFont(new Font("Arial", Font.BOLD, 15));
		cb_funcionario_cargo_1.setBackground(Color.GRAY);
		cb_funcionario_cargo_1.setBounds(245, 145, 317, 27);
		layeredPane.add(cb_funcionario_cargo_1);

		lblCargo = new JLabel("Cargo");
		lblCargo.setBackground(Color.GRAY);
		lblCargo.setForeground(SystemColor.desktop);
		lblCargo.setFont(new Font("Arial", Font.BOLD, 15));
		lblCargo.setBounds(162, 140, 73, 32);
		layeredPane.add(lblCargo);

		lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBackground(Color.GRAY);
		lblUsurio.setForeground(SystemColor.desktop);
		lblUsurio.setFont(new Font("Arial", Font.BOLD, 15));
		lblUsurio.setBounds(162, 192, 73, 32);
		layeredPane.add(lblUsurio);

		txt_usuario = new JTextField();
		txt_usuario.setForeground(Color.WHITE);
		txt_usuario.setFont(new Font("Arial", Font.BOLD, 15));
		txt_usuario.setColumns(10);
		txt_usuario.setBackground(Color.GRAY);
		txt_usuario.setBounds(247, 192, 315, 26);
		layeredPane.add(txt_usuario);

		txt_senha = new JTextField();
		txt_senha.setForeground(Color.WHITE);
		txt_senha.setFont(new Font("Arial", Font.BOLD, 15));
		txt_senha.setColumns(10);
		txt_senha.setBackground(Color.GRAY);
		txt_senha.setBounds(247, 235, 313, 26);
		layeredPane.add(txt_senha);

		lblSenha = new JLabel("Senha");
		lblSenha.setBackground(Color.GRAY);
		lblSenha.setForeground(SystemColor.desktop);
		lblSenha.setFont(new Font("Arial", Font.BOLD, 15));
		lblSenha.setBounds(162, 235, 73, 32);
		layeredPane.add(lblSenha);

		lblAdministrador = new JLabel("Permiss\u00E3o");
		lblAdministrador.setBackground(Color.GRAY);
		lblAdministrador.setForeground(SystemColor.desktop);
		lblAdministrador.setFont(new Font("Arial", Font.BOLD, 15));
		lblAdministrador.setBounds(162, 278, 148, 32);
		layeredPane.add(lblAdministrador);

		cb_funcionario_posicao_1 = new JComboBox();
		cb_funcionario_posicao_1.setModel(new DefaultComboBoxModel(new String[] { "Usu\u00E1rio", "Administrador" }));
		cb_funcionario_posicao_1.setForeground(Color.WHITE);
		cb_funcionario_posicao_1.setFont(new Font("Arial", Font.BOLD, 15));
		cb_funcionario_posicao_1.setBackground(Color.GRAY);
		cb_funcionario_posicao_1.setBounds(320, 281, 242, 26);
		layeredPane.add(cb_funcionario_posicao_1);

		btnNewButton = new JButton("CRIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarFuncionario();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(162, 338, 181, 32);
		layeredPane.add(btnNewButton);

		btnNewButton_1 = new JButton("ALTERAR");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_1.setBounds(381, 338, 181, 32);
		layeredPane.add(btnNewButton_1);

		layeredPane_2 = new JLayeredPane();
		tabbedPane.addTab("Buscar", null, layeredPane_2, null);
		layeredPane_2.setLayout(null);

		lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBackground(Color.GRAY);
		lblNewLabel_1.setBounds(32, 23, 73, 32);
		layeredPane_2.add(lblNewLabel_1);

		txt_nome_consulta = new JTextField();
		txt_nome_consulta.setForeground(Color.WHITE);
		txt_nome_consulta.setFont(new Font("Arial", Font.BOLD, 15));
		txt_nome_consulta.setColumns(10);
		txt_nome_consulta.setBackground(Color.GRAY);
		txt_nome_consulta.setBounds(117, 29, 315, 26);
		layeredPane_2.add(txt_nome_consulta);

		lblCpf_1 = new JLabel("CPF");
		lblCpf_1.setForeground(Color.BLACK);
		lblCpf_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblCpf_1.setBackground(Color.GRAY);
		lblCpf_1.setBounds(32, 66, 73, 32);
		layeredPane_2.add(lblCpf_1);

		txt_cpf_consulta = new JTextField();
		txt_cpf_consulta.setForeground(Color.WHITE);
		txt_cpf_consulta.setFont(new Font("Arial", Font.BOLD, 15));
		txt_cpf_consulta.setColumns(10);
		txt_cpf_consulta.setBackground(Color.GRAY);
		txt_cpf_consulta.setBounds(117, 72, 98, 26);
		layeredPane_2.add(txt_cpf_consulta);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarFuncionarios();
			}
		});
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 15));
		btnConsultar.setBounds(251, 72, 181, 32);
		layeredPane_2.add(btnConsultar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 122, 709, 301);
		layeredPane_2.add(scrollPane);

		tabela_funcionarios = new JTable();
		scrollPane.setViewportView(tabela_funcionarios);
		tabbedPane.setBackgroundAt(1, SystemColor.inactiveCaptionBorder);

		buscaCargos();

	}

	@SuppressWarnings("unchecked")
	public void buscaCargos() {

		ArrayList<CargosDTO> cargos = new ArrayList<>();

		CargosDAO objcargosDAO = new CargosDAO();
		cargos = objcargosDAO.buscaCargos(0, "");

		if (cargos.size() != 0) {
			cb_funcionario_cargo_1.removeAllItems();
			cb_funcionario_cargo_1.addItem("");

			for (int i = 0; i < cargos.size(); i++) {
				cb_funcionario_cargo_1.addItem(cargos.get(i).getCargo_nome());
			}

		} else {
			cb_funcionario_cargo_1.removeAllItems();
		}

	}

	private void registrarFuncionario() {
		String nome, cpf, telefone, usuario, senha, posicaoUsuario, mensagem_validacao = "";
		int posicao, cargo, retorno = 0;

		try {

			nome = txt_nome.getText();
			cpf = txt_cpf.getText();
			telefone = txt_telefone.getText();
			cargo = cb_funcionario_cargo_1.getSelectedIndex();
			usuario = txt_usuario.getText();
			senha = txt_senha.getText();
			posicaoUsuario = cb_funcionario_posicao_1.getSelectedItem().toString();

			if (nome.trim().equals("") == true) {
				mensagem_validacao += "\nDigite o nome do funcionario!!";
			}
			if (cpf.trim().equals("") == true) {
				mensagem_validacao += "\nDigite o cpf do funcionario!!";
			}
			if (telefone.trim().equals("") == true) {
				mensagem_validacao += "\nDigite o telefone do funcionario!!";
			}
			if (usuario.trim().equals("") == true) {
				mensagem_validacao += "\nDigite o login de usuario do funcionario!!";
			}
			if (senha.trim().equals("") == true) {
				mensagem_validacao += "\nDigite a senha do usuario!!";

			}
			if (mensagem_validacao.trim().equals("") == true) {

				if (posicaoUsuario.trim().equals("Administrador") == true) {
					posicao = 2;
				} else {
					posicao = 1;
				}

				FuncionarioDTO objfuncionarioDTO = new FuncionarioDTO();
				objfuncionarioDTO.setFuncionario_nome(nome);
				objfuncionarioDTO.setFuncionario_cpf(cpf);
				objfuncionarioDTO.setFuncionario_telefone(telefone);
				objfuncionarioDTO.setFuncionario_cargo(cargo);
				objfuncionarioDTO.setFuncionario_usuario(usuario);
				objfuncionarioDTO.setFuncionario_senha(senha);
				objfuncionarioDTO.setFuncionario_administrador(posicao);

				FuncionarioDAO objfuncionarioDAO = new FuncionarioDAO();
				retorno = objfuncionarioDAO.cadastrarFuncionario(objfuncionarioDTO);

				if (retorno == 2) {
					txt_nome.setText("");
					txt_telefone.setText("");
					txt_cpf.setText("");
					txt_usuario.setText("");
					txt_senha.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, mensagem_validacao);
			}

		} catch (Exception error2) {
			JOptionPane.showMessageDialog(null, error2);
		}
	}
	
	public void fechaConexao() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	public void consultarFuncionarios() {
		ArrayList<Object> dados = new ArrayList<>();
		String[] colunas = new String[] { "Funcionario", "CPF", "Telefone", "Cargo" };

		try {
			FuncionarioDAO objfuncionarioDAO = new FuncionarioDAO();
			lista = objfuncionarioDAO.buscaFuncionarioTodos(txt_nome_consulta.getText(), txt_cpf_consulta.getText());

			for (int num = 0; num < lista.size(); num++) {
				dados.add(new Object[] { lista.get(num).getFuncionario_nome(), lista.get(num).getFuncionario_cpf(),
						lista.get(num).getFuncionario_telefone(), lista.get(num).getFuncionario_cargo_nome(),
						lista.get(num).getFuncionario_usuario() });

			}

			TableModelFuncionario modelo = new TableModelFuncionario(dados, colunas);
			tabela_funcionarios.setModel(modelo);
			tabela_funcionarios.getColumnModel().getColumn(0).setPreferredWidth(298);
			tabela_funcionarios.getColumnModel().getColumn(0).setResizable(false);
			tabela_funcionarios.getColumnModel().getColumn(1).setPreferredWidth(100);
			tabela_funcionarios.getColumnModel().getColumn(1).setResizable(false);
			tabela_funcionarios.getColumnModel().getColumn(2).setPreferredWidth(100);
			tabela_funcionarios.getColumnModel().getColumn(2).setResizable(false);
			tabela_funcionarios.getColumnModel().getColumn(3).setPreferredWidth(208);
			tabela_funcionarios.getColumnModel().getColumn(3).setResizable(false);
			tabela_funcionarios.getTableHeader().setReorderingAllowed(false);
			tabela_funcionarios.setAutoResizeMode(tabela_funcionarios.AUTO_RESIZE_OFF);
			tabela_funcionarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Erro ao preencher tabela" + error);
		}
	}
}
