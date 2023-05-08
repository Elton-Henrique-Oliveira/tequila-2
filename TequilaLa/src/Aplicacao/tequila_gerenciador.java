package Aplicacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;

import tequila_dao.PontoDAO;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class tequila_gerenciador {

	public JFrame frame;
	public JDesktopPane desktopPane;
	private String usuario;
	private int codigo;
	private JButton btn_funcionario;
	private JButton btn_pedidos;
	private JButton btn_produtos;
	private JButton btn_clientes;
	private JButton btn_sair;
	private int entrada = 0, saida = 0;
	private JMenuBar menuBar;
	private JMenuItem mntmNewMenuItem;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tequila_gerenciador window = new tequila_gerenciador(2, "");
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public tequila_gerenciador(int codigo, String usuario) {
		this.codigo = codigo;
		this.usuario = usuario;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 1576, 990);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		desktopPane.setForeground(Color.GRAY);
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);

		if (codigo >= 1) {
			btn_pedidos = new JButton("");
			btn_pedidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tequila_pedidos pedidos;
					try {
						pedidos = new tequila_pedidos();
						pedidos.setFuncionarioCodigo(codigo);
						pedidos.setVisible(true);
						desktopPane.add(pedidos);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
			btn_pedidos.setToolTipText("Pedidos");
			btn_pedidos.setIcon(
					new ImageIcon(tequila_gerenciador.class.getResource("/tequila_imagens/lista-de-trabalho.png")));
			btn_pedidos.setFont(new Font("Tahoma", Font.BOLD, 11));
			btn_pedidos.setBackground(Color.WHITE);
			btn_pedidos.setBounds(45, 116, 97, 73);
			desktopPane.add(btn_pedidos);

			btn_clientes = new JButton("");
			btn_clientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tequila_cliente cliente = new tequila_cliente();
					cliente.setVisible(true);
					desktopPane.add(cliente);
				}
			});
			btn_clientes.setToolTipText("Clientes");
			btn_clientes.setIcon(new ImageIcon(tequila_gerenciador.class.getResource("/tequila_imagens/clientes.png")));
			btn_clientes.setFont(new Font("Tahoma", Font.BOLD, 11));
			btn_clientes.setBackground(Color.WHITE);
			btn_clientes.setBounds(45, 32, 97, 73);
			desktopPane.add(btn_clientes);

		}
		if (codigo == 2) {
			btn_produtos = new JButton("");
			btn_produtos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tequila_produto produto = new tequila_produto(codigo);
					produto.setVisible(true);
					desktopPane.add(produto);
				}
			});
			btn_produtos.setToolTipText("Produtos");
			btn_produtos.setIcon(new ImageIcon(tequila_gerenciador.class.getResource("/tequila_imagens/produtos.png")));
			btn_produtos.setFont(new Font("Tahoma", Font.BOLD, 11));
			btn_produtos.setBackground(Color.WHITE);
			btn_produtos.setBounds(296, 32, 97, 73);
			desktopPane.add(btn_produtos);

			btn_funcionario = new JButton("");
			btn_funcionario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tequila_funcionario funcionario = new tequila_funcionario();
					funcionario.setVisible(true);
					desktopPane.add(funcionario);
				}
			});
			btn_funcionario.setToolTipText("Funcionarios");
			btn_funcionario.setBackground(Color.WHITE);
			btn_funcionario.setFont(new Font("Tahoma", Font.BOLD, 11));
			btn_funcionario
					.setIcon(new ImageIcon(tequila_gerenciador.class.getResource("/tequila_imagens/pessoal.png")));
			btn_funcionario.setBounds(170, 32, 97, 73);
			desktopPane.add(btn_funcionario);
		}

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		mntmNewMenuItem = new JMenuItem("Sair");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (saida == 0) {
					PontoDAO objpontoDAO = new PontoDAO();
					objpontoDAO.registrarPonto(usuario, 2);
					saida = 1;
				}
				frame.setVisible(false);
				System.exit(0);
			}
		});
		menuBar.add(mntmNewMenuItem);

		btn_sair = new JButton("");
		btn_sair.setBounds(692, 0, 161, 137);
		desktopPane.add(btn_sair);
		desktopPane.setLayer(btn_sair, 0);
		btn_sair.setBackground(Color.GRAY);
		btn_sair.setIcon(new ImageIcon(tequila_gerenciador.class.getResource("/tequila_imagens/saida.png")));
		btn_sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (saida == 0) {
					PontoDAO objpontoDAO = new PontoDAO();
					objpontoDAO.registrarPonto(usuario, 2);
					saida = 1;
				}
				frame.setVisible(false);
				System.exit(0);
			}
		});

		if (entrada == 0) {
			PontoDAO objpontoDAO = new PontoDAO();
			objpontoDAO.registrarPonto(usuario, 1);
			entrada = 1;
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
