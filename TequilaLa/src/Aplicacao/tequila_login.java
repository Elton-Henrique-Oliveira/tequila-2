package Aplicacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tequila_dao.FuncionarioDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tequila_login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_usuario;
	private JLabel lbl_senha_mostra;
	private JPanel panel;
	private JLabel lbl_login;
	private JLabel lbl_senha;
	private JButton btnNewButton;
	private JPasswordField txt_senha;
	private JButton btnAlterar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tequila_login frame = new tequila_login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public tequila_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		lbl_login = new JLabel("Usuario");
		lbl_login.setForeground(Color.WHITE);
		lbl_login.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_login.setBounds(27, 33, 79, 29);
		panel.add(lbl_login);

		lbl_senha = new JLabel("Senha");
		lbl_senha.setForeground(Color.WHITE);
		lbl_senha.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_senha.setBounds(27, 77, 79, 29);
		panel.add(lbl_senha);

		txt_usuario = new JTextField();
		txt_usuario.setBackground(Color.GRAY);
		txt_usuario.setForeground(Color.WHITE);
		txt_usuario.setFont(new Font("Arial", Font.BOLD, 15));
		txt_usuario.setBounds(112, 33, 231, 29);
		panel.add(txt_usuario);
		txt_usuario.setColumns(10);

		lbl_senha_mostra = new JLabel("");
		lbl_senha_mostra.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txt_senha.getEchoChar() != '\u0000') { // mascara e desmacara senha
					txt_senha.setEchoChar('\u0000');
				} else {
					txt_senha.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
				}
			}
		});
		lbl_senha_mostra.setIcon(new ImageIcon(tequila_login.class.getResource("/tequila_imagens/pngwing.com_3.png")));
		lbl_senha_mostra.setForeground(SystemColor.textHighlight);
		lbl_senha_mostra.setBackground(Color.WHITE);
		lbl_senha_mostra.setBounds(316, 77, 30, 29);
		panel.add(lbl_senha_mostra);

		btnNewButton = new JButton("ENTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificaLogin(1);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(41, 132, 147, 29);
		panel.add(btnNewButton);

		txt_senha = new JPasswordField();
		txt_senha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {

				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					verificaLogin(1);
				}

			}
		});
		txt_senha.setBackground(Color.GRAY);
		txt_senha.setForeground(Color.WHITE);
		txt_senha.setFont(new Font("Arial", Font.BOLD, 15));
		txt_senha.setBounds(112, 77, 202, 29);
		panel.add(txt_senha);

		btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificaLogin(2);
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.BOLD, 15));
		btnAlterar.setBounds(217, 132, 147, 29);
		panel.add(btnAlterar);
	}

	@SuppressWarnings("deprecation")
	private void verificaLogin(int verifica) {
		String mensagem_validacao = "";
		String senha, usuario;

		try {

			if (txt_senha.getText().trim().equals("") == true) {
				mensagem_validacao += "\nO usuário não pode ser vazio!!";
			}
			if (txt_usuario.getText().trim().equals("") == true) {
				mensagem_validacao += "\nA senha não pode ser vazia!!";
			}

			if (mensagem_validacao.trim().equals("") == true) {
				senha = txt_senha.getText();
				usuario = txt_usuario.getText();
				FuncionarioDAO objfuncionarioDAO = new FuncionarioDAO();
				int retorno = objfuncionarioDAO.buscaFuncionario(1, usuario, senha);

				if (retorno == 1 || retorno == 2) {

					if (verifica == 1) {

						tequila_gerenciador gerenciador = new tequila_gerenciador(retorno, usuario);
						gerenciador.frame.setVisible(true);
						gerenciador.frame.setLocationRelativeTo(null);
						this.setVisible(false);

					} else {

						alterarSenha();

					}

				} else {

					JOptionPane.showMessageDialog(null, "Senha/Usuario informado inválido!!");

				}

			} else {
				JOptionPane.showMessageDialog(null, mensagem_validacao);
			}

		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Listar valores" + error);
		}
	}

	@SuppressWarnings({ "deprecation", "unused" })
	private void abreAlteracao() {
		String mensagem_validacao = "";
		String senha, usuario;

		try {
			FuncionarioDAO objfuncionarioDAO = new FuncionarioDAO();

			if (txt_senha.getText().trim().equals("") == true) {
				mensagem_validacao += "\nO usuário não pode ser vazio!!";
			}
			if (txt_usuario.getText().trim().equals("") == true) {
				mensagem_validacao += "\nA senha não pode ser vazia!!";
			}

			if (mensagem_validacao.trim().equals("") == true) {
				senha = txt_senha.getText();
				usuario = txt_usuario.getText();
				int retorno = objfuncionarioDAO.buscaFuncionario(1, usuario, senha);

				if (retorno == 1 || retorno == 2) {

					alterarSenha();

				} else {

					JOptionPane.showMessageDialog(null, "Senha/Usuario informado inválido!!");

				}

			} else {
				JOptionPane.showMessageDialog(null, mensagem_validacao);
			}

		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Listar valores" + error);
		}

	}

	@SuppressWarnings("deprecation")
	public void alterarSenha() {

		tequila_alterar_senha alterarSenha = new tequila_alterar_senha();
		alterarSenha.setVisible(true);
		alterarSenha.setLocationRelativeTo(null);
		alterarSenha.setFuncionario_usuario(txt_usuario.getText());
		alterarSenha.setFuncionario_senha(txt_senha.getText());
		this.setVisible(false);

	}
}
