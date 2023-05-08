package Aplicacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tequila_dao.FuncionarioDAO;
import tequila_dto.FuncionarioDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tequila_alterar_senha extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txt_senha1;
	private JPasswordField txt_senha2;
	private JLabel lbl_senha1;
	private JButton btnVoltar;
	private JButton btnNewButton;
	private JLabel lblRepetirSenha;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lbl_senha2;
	
	private String funcionario_senha;
	private String funcionario_usuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tequila_alterar_senha frame = new tequila_alterar_senha();
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
	public tequila_alterar_senha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		lblNewLabel = new JLabel("Senha");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 30, 109, 28);
		panel.add(lblNewLabel);

		lblRepetirSenha = new JLabel("Repetir senha");
		lblRepetirSenha.setForeground(Color.WHITE);
		lblRepetirSenha.setFont(new Font("Arial", Font.BOLD, 15));
		lblRepetirSenha.setBounds(20, 69, 109, 28);
		panel.add(lblRepetirSenha);

		txt_senha1 = new JPasswordField();
		txt_senha1.setForeground(Color.WHITE);
		txt_senha1.setBackground(Color.GRAY);
		txt_senha1.setFont(new Font("Arial", Font.BOLD, 15));
		txt_senha1.setBounds(139, 30, 217, 28);
		panel.add(txt_senha1);

		txt_senha2 = new JPasswordField();
		txt_senha2.setForeground(Color.WHITE);
		txt_senha2.setBackground(Color.GRAY);
		txt_senha2.setFont(new Font("Arial", Font.BOLD, 15));
		txt_senha2.setBounds(139, 69, 217, 28);
		panel.add(txt_senha2);

		btnNewButton = new JButton("ALTERAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alteraSenha();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(30, 122, 158, 33);
		panel.add(btnNewButton);

		btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voltaLogin();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 15));
		btnVoltar.setBounds(215, 122, 158, 33);
		panel.add(btnVoltar);

		lbl_senha1 = new JLabel("");
		lbl_senha1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txt_senha1.getEchoChar() != '\u0000') { // mascara e desmacara senha
					txt_senha1.setEchoChar('\u0000');
				} else {
					txt_senha1.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
				}
			}
		});
		lbl_senha1
				.setIcon(new ImageIcon(tequila_alterar_senha.class.getResource("/tequila_imagens/pngwing.com_3.png")));
		lbl_senha1.setForeground(SystemColor.textHighlight);
		lbl_senha1.setBackground(Color.WHITE);
		lbl_senha1.setBounds(358, 30, 30, 29);
		panel.add(lbl_senha1);

		lbl_senha2 = new JLabel("");
		lbl_senha2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txt_senha2.getEchoChar() != '\u0000') { // mascara e desmacara senha
					txt_senha2.setEchoChar('\u0000');
				} else {
					txt_senha2.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
				}
			}
		});
		lbl_senha2
				.setIcon(new ImageIcon(tequila_alterar_senha.class.getResource("/tequila_imagens/pngwing.com_3.png")));
		lbl_senha2.setForeground(SystemColor.textHighlight);
		lbl_senha2.setBackground(Color.WHITE);
		lbl_senha2.setBounds(358, 68, 30, 29);
		panel.add(lbl_senha2);
	}
	
	@SuppressWarnings({ "deprecation", "unused" })
	public void alteraSenha() {
		
		String senha_nova = "";
		
		if(txt_senha1.getText().trim().equals(txt_senha2.getText()) == true) {
		
			senha_nova = txt_senha1.getText();
			FuncionarioDTO objfuncionarioDTO = new FuncionarioDTO();
			objfuncionarioDTO.setFuncionario_usuario(this.funcionario_usuario);
			objfuncionarioDTO.setFuncionario_senha(this.funcionario_senha);
			
			FuncionarioDAO objfuncionarioDAO = new FuncionarioDAO();
			objfuncionarioDAO.alterarSenha(objfuncionarioDTO,txt_senha1.getText());
			
			voltaLogin();
			
		}else {
			JOptionPane.showMessageDialog(null, "As senhas não são iguais!");			
		}
		
	}
	
	public void voltaLogin() {
		tequila_login login = new tequila_login();
		login.setLocationRelativeTo(null);
		login.setVisible(true);
		this.setVisible(false);		
	}

	public String getFuncionario_usuario() {
		return funcionario_usuario;
	}

	public void setFuncionario_usuario(String funcionario_usuario) {
		this.funcionario_usuario = funcionario_usuario;
	}

	public String getFuncionario_senha() {
		return funcionario_senha;
	}

	public void setFuncionario_senha(String funcionario_senha) {
		this.funcionario_senha = funcionario_senha;
	}
}
