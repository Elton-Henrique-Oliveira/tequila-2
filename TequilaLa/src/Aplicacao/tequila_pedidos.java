package Aplicacao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import tequila_dao.CombosDAO;
import tequila_dao.ConsultasDAO;
import tequila_dao.GruposDAO;
import tequila_dao.PedidosDAO;
import tequila_dao.ProdutoDAO;
import tequila_dto.ClienteDTO;
import tequila_dto.CombosDTO;
import tequila_dto.GruposDTO;
import tequila_dto.PedidosDTO;
import tequila_dto.ProdutoDTO;
import tequila_dto.ProdutoPedidosDTO;
import tequila_modelos.TableModelPedido;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Time;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class tequila_pedidos extends JInternalFrame {

	public JTextField txt_cliente;
	private JTable tabela_comanda;
	private JTextField txt_quantidade;
	private JLabel lbl_cliente;
	private JLayeredPane layeredPane;
	private JTabbedPane tabbedPane;
	private JLabel lbl_cliente_nome;
	private JPanel panel;
	private JLabel lbl_produto;
	private JLabel lbl_combo;
	private JComboBox<String> cb_produto;
	private JComboBox<String> cb_combo;
	private JLabel lbl_preco;
	private JLabel lbl_custo;
	private JLabel lbl_preco_mostrar;
	private JLabel lbl_custo_mostrar;
	private JLabel lbl_peso_mostrar;
	private JButton btnNewButton;
	private JButton btnLimparComanda;
	private JLabel lblQt;
	private JLayeredPane layeredPane_1;
	private JButton btnFinalizar;
	private JLabel lbl_peso;
	private JButton btnNewButton_1;
	@SuppressWarnings("unused")
	private ArrayList<ClienteDTO> lista = new ArrayList<>();
	private ArrayList<ProdutoDTO> lista2 = new ArrayList<>();
	private ArrayList<CombosDTO> lista3 = new ArrayList<>();
	@SuppressWarnings("unused")
	private ArrayList<GruposDTO> lista4 = new ArrayList<>();
	@SuppressWarnings("unused")
	private ArrayList<PedidosDTO> lista5 = new ArrayList<>();
	private ArrayList<ProdutoPedidosDTO> lista6 = new ArrayList<>();
	private ArrayList<ProdutoDTO> lista7 = new ArrayList<>();
	private ArrayList<ProdutoPedidosDTO> lista8 = new ArrayList<>();
	private ArrayList<PedidosDTO> lista9 = new ArrayList<>();
	private String cpf_cliente_anterior = "";
	private ArrayList<ProdutoDTO> consulta_produto = new ArrayList<>();
	private ArrayList<ProdutoPedidosDTO> consulta_produtos_pedido = new ArrayList<>();
	private ArrayList<PedidosDTO> consulta_pedido = new ArrayList<>();
	private ArrayList<ClienteDTO> consulta_cliente = new ArrayList<>();
	private JScrollPane scrollPane;
	private ArrayList<ProdutoDTO> listaProdutos;
	private int funcionarioCodigo;
	private String clienteGrupo = "";
	private int cpf_cliente = 0, retorno = 0;
	private TableModelPedido modelo;
	private TableModelPedido modelo2;
	private JTextField txt_pedido;
	private JTable tabela_pedidos;
	private JLabel lbl_peso_pedido;
	private JLabel lbl_custo_pedido;
	private JLabel lbl_valor_pedido;
	private JLabel lbl_pedido_1;
	private JLabel lbl_pedido_1_1;
	private JLabel lbl_pedido_1_1_1;
	private JLabel lbl_cliente_pesquisa;
	private JButton btnNewButton_1_1_1;
	private JScrollPane scrollPane_1;
	private JLabel lbl_pedido;
	private JButton btnNewButton_1_1_1_1;
	private JButton btnProdutos;
	private int tpregistro = -1;
	DecimalFormat df = new DecimalFormat("#######");
	private Thread t;
	private Thread adicionarProduto;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tequila_pedidos frame = new tequila_pedidos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws InterruptedException
	 */
	public tequila_pedidos() throws InterruptedException {
		setTitle("Comandas");
		setIconifiable(true);
		setClosable(true);
		setBackground(SystemColor.activeCaption);
		setBounds(100, 100, 658, 577);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		layeredPane = new JLayeredPane();
		tabbedPane.addTab("Registrar", null, layeredPane, null);

		lbl_cliente = new JLabel("CPF");
		lbl_cliente.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_cliente.setBounds(10, 11, 72, 34);
		layeredPane.add(lbl_cliente);

		txt_cliente = new JTextField();
		txt_cliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				// buscarCliente();
				if (txt_cliente.getText().trim().equals(cpf_cliente_anterior) == false) {
					cpf_cliente_anterior = txt_cliente.getText();
					// verificaPedidoCliente();
					t = new Thread(new MyRunnable(2, getTpregistro(), getClienteGrupo(), getFuncionarioCodigo()));
					t.start();
					setTpregistro(1);
				}
			}
		});
		txt_cliente.setForeground(Color.WHITE);
		txt_cliente.setBackground(Color.GRAY);
		txt_cliente.setFont(new Font("Arial", Font.BOLD, 15));
		txt_cliente.setBounds(89, 11, 143, 34);
		layeredPane.add(txt_cliente);
		txt_cliente.setColumns(10);

		lbl_cliente_nome = new JLabel(
				"..................................................................................................................................");
		lbl_cliente_nome.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_cliente_nome.setBounds(242, 11, 249, 34);
		layeredPane.add(lbl_cliente_nome);

		panel = new JPanel();
		panel.setBounds(10, 56, 617, 451);
		layeredPane.add(panel);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 217, 597, 226);
		panel.add(scrollPane);

		tabela_comanda = new JTable();
		tabela_comanda.setFont(new Font("Arial", Font.BOLD, 15));
		scrollPane.setViewportView(tabela_comanda);

		lbl_produto = new JLabel("Produto");
		lbl_produto.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_produto.setBounds(10, 11, 72, 34);
		panel.add(lbl_produto);

		lbl_combo = new JLabel("Combo");
		lbl_combo.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_combo.setBounds(10, 56, 72, 34);
		panel.add(lbl_combo);

		cb_produto = new JComboBox<String>();
		cb_produto.setForeground(Color.WHITE);
		cb_produto.setBackground(Color.GRAY);
		cb_produto.setFont(new Font("Arial", Font.BOLD, 15));
		cb_produto.setBounds(81, 11, 240, 34);
		panel.add(cb_produto);

		cb_combo = new JComboBox<String>();
		cb_combo.setForeground(Color.WHITE);
		cb_combo.setBackground(Color.GRAY);
		cb_combo.setFont(new Font("Arial", Font.BOLD, 15));
		cb_combo.setBounds(81, 57, 240, 34);
		panel.add(cb_combo);

		lbl_preco = new JLabel("Pre\u00E7o $");
		lbl_preco.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_preco.setBounds(369, 11, 80, 34);
		panel.add(lbl_preco);

		lbl_custo = new JLabel("Custo $");
		lbl_custo.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_custo.setBounds(369, 56, 80, 34);
		panel.add(lbl_custo);

		lbl_peso = new JLabel("Peso");
		lbl_peso.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_peso.setBounds(369, 101, 80, 34);
		panel.add(lbl_peso);

		lbl_preco_mostrar = new JLabel("");
		lbl_preco_mostrar.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_preco_mostrar.setBounds(459, 11, 148, 34);
		panel.add(lbl_preco_mostrar);

		lbl_custo_mostrar = new JLabel("");
		lbl_custo_mostrar.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_custo_mostrar.setBounds(459, 56, 148, 34);
		panel.add(lbl_custo_mostrar);

		lbl_peso_mostrar = new JLabel("");
		lbl_peso_mostrar.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_peso_mostrar.setBounds(459, 101, 148, 34);
		panel.add(lbl_peso_mostrar);

		btnNewButton = new JButton("ADICIONAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// adicionarProdutoPedido();

				if (adicionarProduto != null) {
					/*
					 * System.err.println(adicionarProduto.isAlive()); if
					 * (adicionarProduto.isAlive() == true) { while (adicionarProduto.isAlive()) {
					 * try { Thread.sleep(100); } catch (InterruptedException e1) {
					 * e1.printStackTrace(); } } }
					 */
					try {
						adicionarProduto.join();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				adicionarProduto = new Thread(
						new MyRunnable(3, getTpregistro(), getClienteGrupo(), getFuncionarioCodigo()));
				adicionarProduto.start();
				System.out.println("dale");
			}
		});
		btnNewButton.setBounds(10, 156, 131, 40);
		panel.add(btnNewButton);

		btnLimparComanda = new JButton("LIMPAR");
		btnLimparComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// limparPedido();
				t = new Thread(new MyRunnable(8, getTpregistro(), getClienteGrupo(), getFuncionarioCodigo()));
				t.start();
			}
		});
		btnLimparComanda.setBounds(322, 156, 131, 40);
		panel.add(btnLimparComanda);

		lblQt = new JLabel("Qtd.");
		lblQt.setFont(new Font("Arial", Font.BOLD, 15));
		lblQt.setBounds(10, 101, 72, 31);
		panel.add(lblQt);

		txt_quantidade = new JTextField();
		txt_quantidade.setBackground(Color.GRAY);
		txt_quantidade.setForeground(Color.WHITE);
		txt_quantidade.setFont(new Font("Arial", Font.BOLD, 15));
		txt_quantidade.setBounds(81, 101, 119, 31);
		panel.add(txt_quantidade);
		txt_quantidade.setColumns(10);

		btnFinalizar = new JButton("COMPLETAR");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// confirmarPedido();
				t = new Thread(new MyRunnable(7, getTpregistro(), getClienteGrupo(), getFuncionarioCodigo()));
				t.start();
			}
		});
		btnFinalizar.setBounds(476, 156, 131, 40);
		panel.add(btnFinalizar);

		btnProdutos = new JButton("PRODUTOS");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				t = new Thread(new MyRunnable(3, getTpregistro(), getClienteGrupo(), getFuncionarioCodigo()));
				t.start();

			}
		});
		btnProdutos.setBounds(166, 156, 131, 40);
		panel.add(btnProdutos);

		btnNewButton_1 = new JButton("CADASTRAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tequila_cliente cliente = new tequila_cliente();
				cliente.setVisible(true);
				getParent().add(cliente);
			}
		});
		btnNewButton_1.setBounds(495, 11, 132, 34);
		layeredPane.add(btnNewButton_1);

		layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Pedidos", null, layeredPane_1, null);

		txt_pedido = new JTextField();
		txt_pedido.setForeground(Color.WHITE);
		txt_pedido.setFont(new Font("Arial", Font.BOLD, 15));
		txt_pedido.setColumns(10);
		txt_pedido.setBackground(Color.GRAY);
		txt_pedido.setBounds(98, 32, 143, 34);
		layeredPane_1.add(txt_pedido);

		lbl_pedido = new JLabel("PEDIDO");
		lbl_pedido.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_pedido.setBounds(23, 32, 72, 34);
		layeredPane_1.add(lbl_pedido);

		JButton btnNewButton_1_1 = new JButton("PESQUISAR");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txt_pedido.getText().trim().equals("") == false) {
					// buscaProdutoPedido();
					t = new Thread(new MyRunnable(55, getTpregistro(), getClienteGrupo(), getFuncionarioCodigo()));
					t.start();
				} else {
					// buscaPedidos();
					t = new Thread(new MyRunnable(4, getTpregistro(), getClienteGrupo(), getFuncionarioCodigo()));
					t.start();
				}
			}
		});
		btnNewButton_1_1.setBounds(478, 33, 132, 34);

		btnNewButton_1_1_1 = new JButton("ENTREGAR");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// finalizarPedido();
				t = new Thread(new MyRunnable(6, getTpregistro(), getClienteGrupo(), getFuncionarioCodigo()));
				t.start();
			}
		});
		btnNewButton_1_1_1.setBounds(478, 78, 132, 34);
		layeredPane_1.add(btnNewButton_1_1_1);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 210, 617, 298);
		layeredPane_1.add(scrollPane_1);

		tabela_pedidos = new JTable();
		scrollPane_1.setViewportView(tabela_pedidos);

		lbl_pedido_1 = new JLabel("VALOR $");
		lbl_pedido_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_pedido_1.setBounds(23, 77, 72, 34);
		layeredPane_1.add(lbl_pedido_1);

		lbl_pedido_1_1 = new JLabel("CUSTO $");
		lbl_pedido_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_pedido_1_1.setBounds(23, 120, 72, 34);
		layeredPane_1.add(lbl_pedido_1_1);

		lbl_pedido_1_1_1 = new JLabel("PESO");
		lbl_pedido_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_pedido_1_1_1.setBounds(23, 165, 72, 34);
		layeredPane_1.add(lbl_pedido_1_1_1);

		lbl_cliente_pesquisa = new JLabel("-------------------------------------------");
		lbl_cliente_pesquisa.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_cliente_pesquisa.setBounds(251, 32, 217, 34);
		layeredPane_1.add(lbl_cliente_pesquisa);

		lbl_valor_pedido = new JLabel("");
		lbl_valor_pedido.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_valor_pedido.setBounds(98, 77, 143, 34);
		layeredPane_1.add(lbl_valor_pedido);

		lbl_custo_pedido = new JLabel("");
		lbl_custo_pedido.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_custo_pedido.setBounds(98, 120, 143, 34);
		layeredPane_1.add(lbl_custo_pedido);

		lbl_peso_pedido = new JLabel("");
		lbl_peso_pedido.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_peso_pedido.setBounds(98, 165, 143, 34);
		layeredPane_1.add(lbl_peso_pedido);

		btnNewButton_1_1_1_1 = new JButton("CONSULTAR");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txt_pedido.getText().trim().equals("") == false) {
					// buscaProdutoPedido();
					t = new Thread(new MyRunnable(55, getTpregistro(), getClienteGrupo(), getFuncionarioCodigo()));
					t.start();
				} else {
					// buscaPedidos();
					t = new Thread(new MyRunnable(4, getTpregistro(), getClienteGrupo(), getFuncionarioCodigo()));
					t.start();
				}
			}
		});
		btnNewButton_1_1_1_1.setBounds(478, 33, 132, 34);
		layeredPane_1.add(btnNewButton_1_1_1_1);
		// consultarProdutos();
		// consultarCombos();
		// consultarGrupos();
		// carregaCombos();

		t = new Thread(new MyRunnable(1, getTpregistro(), getClienteGrupo(), getFuncionarioCodigo()));
		t.start();
		t.join();
	}

	public void verificaPedidoCliente2() {
		t = new Thread(new MyRunnable(2, getTpregistro(), getClienteGrupo(), getFuncionarioCodigo()));
		t.start();

	}

	public class MyRunnable implements Runnable {
		private int gerencia;
		private int tpregistro;
		private String clienteGrupo;
		private int funcionarioCodigo;

		public MyRunnable(int gerencia, int tpregistro, String clienteGrupo, int funcionarioCodigo) {
			this.gerencia = gerencia;
			this.tpregistro = tpregistro;
			this.clienteGrupo = clienteGrupo;
			this.funcionarioCodigo = funcionarioCodigo;
		}

		public int getTpregistro() {
			return this.tpregistro;
		}

		public void run() {

			switch (this.gerencia) {
			case 1:
				carregaCombos();
				break;
			case 2:
				verificaPedidoCliente();
				break;
			case 3:
				adicionarProdutoPedido();
				break;
			case 4:
				buscaPedidos();
				break;
			case 5:
				buscaProdutoPedido();
				break;
			case 6:
				finalizarPedido();
				break;
			case 7:
				confirmarPedido();
				break;
			case 8:
				limparPedido();
				break;
			}
		}

		public void finalizarPedido() {
			int codigo_cliente = 0, retorno = 0;

			codigo_cliente = Integer.parseInt(txt_cliente.getText());

			if (codigo_cliente != 0) {

				PedidosDAO objpedidosDAO = new PedidosDAO();
				retorno = objpedidosDAO.buscaComanda(3, codigo_cliente);

				try {
					if (retorno == 1) {

						PedidosDAO objpedidosDAO2 = new PedidosDAO();
						objpedidosDAO2.finalizaPedido(codigo_cliente);

						lbl_cliente_pesquisa.setText("-------------------------------------------");
						txt_pedido.setText("");

						JOptionPane.showMessageDialog(null, "Pedido finalizado com sucesso!!");

						buscaPedidos();

					} else {
						JOptionPane.showMessageDialog(null, "Pedido não está no sistema!!");
					}
				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "ERRO BUSCAR CLIENTE" + error);
				}

			}
		}

		@SuppressWarnings("static-access")
		public void buscaProdutoPedido() {
			ArrayList<Object> dados = new ArrayList<>();
			String[] colunas = new String[] { "Codigo", "Produto", "Quantidade", "Preço" };
			int valorPedido = 0, custoPedido = 0, pesoPedido = 0, codigo_pedido = 0;
			String grupoAnterior = "";
			int valorProduto = 0;
			int retorno = 0;
			int desconto = 0;
			consulta_produto = new ArrayList<>();
			consulta_produtos_pedido = new ArrayList<>();
			consulta_pedido = new ArrayList<>();
			consulta_cliente = new ArrayList<>();

			if (txt_pedido.getText().trim().equals("") == false) {
				codigo_pedido = Integer.parseInt(txt_pedido.getText());
			}

			if (codigo_pedido != 0) {
				try {

					ConsultasDAO objconsultasDAO = new ConsultasDAO();
					retorno = objconsultasDAO.buscaClienteTudo("", codigo_pedido);

					if (retorno == 1) {

						consulta_produto = objconsultasDAO.getLista7();
						consulta_produtos_pedido = objconsultasDAO.getLista6();
						consulta_pedido = objconsultasDAO.getLista5();
						consulta_cliente = objconsultasDAO.getLista4();

						lbl_cliente_pesquisa.setText(consulta_cliente.get(0).getCliente_nome());

						for (int num = 0; num < consulta_produtos_pedido.size(); num++) {
							if (consulta_produtos_pedido.get(num).getProcom_grupo().trim().equals("") == false
									&& consulta_produtos_pedido.get(num).getProcom_grupo() != null) {
								if (consulta_produtos_pedido.get(num).getProcom_grupo().trim()
										.equals(grupoAnterior) == false) {
									CombosDAO objcombosDAO = new CombosDAO();
									objcombosDAO.buscaCombosProdutos(
											consulta_produtos_pedido.get(num).getProcom_grupo().trim());
									lista3 = objcombosDAO.getLista();
								}
								grupoAnterior = consulta_produtos_pedido.get(num).getProcom_grupo().trim();
								desconto = (lista3.get(0).getCombo_desconto() == 0 ? 1
										: lista3.get(0).getCombo_desconto());

								valorProduto = consulta_produto.get(num).getProduto_preco()
										* consulta_produtos_pedido.get(num).getProcom_produto_quantidade();
								valorProduto = (valorProduto - ((valorProduto * desconto) / 100));

							} else {
								valorProduto = consulta_produto.get(num).getProduto_preco()
										* consulta_produtos_pedido.get(num).getProcom_produto_quantidade();
							}

							dados.add(new Object[] { consulta_produto.get(num).getProduto_codigo(),
									consulta_produto.get(num).getProduto_nome(),
									consulta_produtos_pedido.get(num).getProcom_produto_quantidade(),
									df.format(valorProduto) });

							valorPedido += valorProduto;
							custoPedido += consulta_produto.get(num).getProduto_custo()
									* consulta_produtos_pedido.get(num).getProcom_produto_quantidade();
							pesoPedido += consulta_produto.get(num).getProduto_peso()
									* consulta_produtos_pedido.get(num).getProcom_produto_quantidade();

						}

					}

					if (retorno == 2) {

						consulta_produto = objconsultasDAO.getLista7();
						consulta_produtos_pedido = objconsultasDAO.getLista6();
						consulta_pedido = objconsultasDAO.getLista5();
						consulta_cliente = objconsultasDAO.getLista4();

						lbl_cliente_pesquisa.setText(consulta_cliente.get(0).getCliente_nome());

					}

					if (retorno == -1) {

						lbl_cliente_pesquisa.setText("Cliente sem pedido em aberto!!");

					}

				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "ERRO BUSCAR CLIENTE" + error);
				}
			}

			lbl_valor_pedido.setText(df.format(valorPedido));
			lbl_custo_pedido.setText(df.format(custoPedido));
			lbl_peso_pedido.setText(df.format(pesoPedido));

			modelo2 = new TableModelPedido(dados, colunas);
			tabela_pedidos.setModel(modelo2);
			tabela_pedidos.getColumnModel().getColumn(0).setPreferredWidth(75);
			tabela_pedidos.getColumnModel().getColumn(0).setResizable(false);
			tabela_pedidos.getColumnModel().getColumn(1).setPreferredWidth(300);
			tabela_pedidos.getColumnModel().getColumn(1).setResizable(false);
			tabela_pedidos.getColumnModel().getColumn(2).setPreferredWidth(100);
			tabela_pedidos.getColumnModel().getColumn(2).setResizable(false);
			tabela_pedidos.getColumnModel().getColumn(2).setPreferredWidth(106);
			tabela_pedidos.getColumnModel().getColumn(2).setResizable(false);
			tabela_pedidos.getTableHeader().setReorderingAllowed(false);
			tabela_pedidos.setAutoResizeMode(tabela_pedidos.AUTO_RESIZE_OFF);
			tabela_pedidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}

		@SuppressWarnings("static-access")
		public void buscaPedidos() {
			ArrayList<Object> dados = new ArrayList<>();
			String[] colunas = new String[] { "Codigo", "CPF", "Cliente Nome" };
			int retorno = 0;

			consulta_pedido = new ArrayList<>();
			consulta_cliente = new ArrayList<>();

			try {

				PedidosDAO objpedidosDAO = new PedidosDAO();
				retorno = objpedidosDAO.buscaComanda(3, 0);

				if (retorno == 1) {
					consulta_pedido = objpedidosDAO.getLista();
					consulta_cliente = objpedidosDAO.getLista4();

					for (int num = 0; num < consulta_pedido.size(); num++) {
						dados.add(new Object[] { consulta_pedido.get(num).getComanda_codigo(),
								consulta_pedido.get(num).getComanda_cliente_codigo(),
								consulta_cliente.get(num).getCliente_nome() });
					}
				}

			} catch (Exception error) {
				JOptionPane.showMessageDialog(null, "ERRO BUSCAR CLIENTE" + error);
			}

			lbl_valor_pedido.setText("");
			lbl_custo_pedido.setText("");
			lbl_peso_pedido.setText("");

			modelo2 = new TableModelPedido(dados, colunas);
			tabela_pedidos.setModel(modelo2);
			tabela_pedidos.getColumnModel().getColumn(0).setPreferredWidth(100);
			tabela_pedidos.getColumnModel().getColumn(0).setResizable(false);
			tabela_pedidos.getColumnModel().getColumn(1).setPreferredWidth(100);
			tabela_pedidos.getColumnModel().getColumn(1).setResizable(false);
			tabela_pedidos.getColumnModel().getColumn(2).setPreferredWidth(380);
			tabela_pedidos.getColumnModel().getColumn(2).setResizable(false);
			tabela_pedidos.getTableHeader().setReorderingAllowed(false);
			tabela_pedidos.setAutoResizeMode(tabela_pedidos.AUTO_RESIZE_OFF);
			tabela_pedidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}

		public void limparPedido() {

			consulta_produto = new ArrayList<>();
			consulta_produtos_pedido = new ArrayList<>();
			consulta_pedido = new ArrayList<>();
			consulta_cliente = new ArrayList<>();
			String cpf = "";

			cpf = txt_cliente.getText();

			if (cpf.trim().equals("") == false) {

				try {

					PedidosDAO objpedidosDAO = new PedidosDAO();
					objpedidosDAO.limparComanda(cpf);

					lbl_cliente_pesquisa.setText(consulta_cliente.get(0).getCliente_nome());
					buscarPedido(consulta_produto, consulta_produtos_pedido, consulta_pedido, 3);
				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "ERRO BUSCAR CLIENTE" + error);
				}

			}
		}

		public void confirmarPedido() {
			String cpf = "";

			cpf = txt_cliente.getText();

			if (cpf.trim().equals("") == false) {

				try {

					PedidosDAO objpedidosDAO = new PedidosDAO();
					objpedidosDAO.confirmarPedido(cpf);

					lbl_cliente_nome.setText("");

					buscarPedido(consulta_produto, consulta_produtos_pedido, consulta_pedido, 2);

				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "ERRO BUSCAR CLIENTE" + error);
				}

			}
		}

		@SuppressWarnings({ "unused", "static-access" })
		public void adicionarProdutoPedido() {
			Thread t1 = new Thread(new Runnable() {
				public void run() {
					String produto = "", combo = "", mensagem_validacao = "";
					int valorProduto = 0, custoProduto = 0, pesoProduto = 0, precoFechado = 0, quantidade = 0,
							desconto = 0, valorPedido = 0, custoPedido = 0, pesoPedido = 0;
					cpf_cliente = Integer.parseInt(txt_cliente.getText());
					ArrayList<Object> dados = new ArrayList<>();
					listaProdutos = new ArrayList<>();
					lista3 = new ArrayList<>();
					lista8 = new ArrayList<>();
					lista9 = new ArrayList<>();

					if (txt_cliente.getText().trim().equals("") == false) {
						cpf_cliente = Integer.parseInt(txt_cliente.getText());
					} else {
						cpf_cliente = 0;
					}

					if (txt_quantidade.getText().trim().equals("") == false) {
						quantidade = Integer.parseInt(txt_quantidade.getText());
					} else {
						quantidade = 0;
					}

					if (cb_produto.getSelectedItem() != null) {
						produto = cb_produto.getSelectedItem().toString();
					}
					if (cb_combo.getSelectedItem() != null) {
						combo = cb_combo.getSelectedItem().toString();
					}

					if (cpf_cliente == 0 || txt_cliente.getText().trim().equals("") == true) {
						mensagem_validacao += "\nInforme CPF do cliente!!";
					}
					if (quantidade == 0) {
						mensagem_validacao += "\nInforme a quantidade!!";
					}
					if (produto.trim().equals("") == true && combo.trim().equals("") == true) {
						mensagem_validacao += "\nInforme a pelo menos um produto ou combo!!";
					}

					try {

						if (mensagem_validacao.trim().equals("") == true) {

							valorPedido = Integer.parseInt(lbl_preco_mostrar.getText());
							custoPedido = Integer.parseInt(lbl_custo_mostrar.getText());
							pesoPedido = Integer.parseInt(lbl_peso_mostrar.getText());

							if (combo.trim().equals("") == false) {

								CombosDAO objcombosDAO = new CombosDAO();
								objcombosDAO.buscaCombosProdutos(combo);
								listaProdutos = objcombosDAO.getLista2();
								lista3 = objcombosDAO.getLista();

							} else {

								ProdutoDAO objprodutoDAO = new ProdutoDAO();
								objprodutoDAO.buscaProdutos(3, produto);
								listaProdutos = objprodutoDAO.getLista();

							}

							for (int num = 0; num < listaProdutos.size(); num++) {
								valorProduto = listaProdutos.get(num).getProduto_preco() * quantidade;
								custoProduto = listaProdutos.get(num).getProduto_custo() * quantidade;
								pesoProduto = listaProdutos.get(num).getProduto_peso() * quantidade;

								if (combo.trim().equals("") == false) {
									desconto = (lista3.get(0).getCombo_desconto() == 0 ? 1
											: lista3.get(0).getCombo_desconto());
									valorProduto = valorProduto - ((valorProduto * desconto) / 100);
								}

								dados.add(new Object[] { listaProdutos.get(num).getProduto_codigo(),
										listaProdutos.get(num).getProduto_nome(), quantidade,
										df.format(valorProduto) });

								ProdutoPedidosDTO objpedidoProdutoDTO = new ProdutoPedidosDTO();
								objpedidoProdutoDTO
										.setProcom_produto_codigo(listaProdutos.get(num).getProduto_codigo());
								objpedidoProdutoDTO.setProcom_produto_quantidade(quantidade);
								objpedidoProdutoDTO.setProcom_grupo(combo);
								lista8.add(objpedidoProdutoDTO);

								valorPedido += valorProduto;
								custoPedido += custoProduto;
								pesoPedido += pesoProduto;
							}

							GruposDAO objgrupoDAO = new GruposDAO();
							retorno = objgrupoDAO.buscaGrupos(1, clienteGrupo);
							if (retorno == 1) {
								valorPedido = valorPedido
										- ((valorPedido * objgrupoDAO.getLista().get(0).getGrupo_desconto()) / 100);
							}

							lbl_preco_mostrar.setText(df.format(valorPedido));
							lbl_custo_mostrar.setText(df.format(custoPedido));
							lbl_peso_mostrar.setText(df.format(pesoPedido));

							PedidosDTO objpedidoDTO = new PedidosDTO();
							objpedidoDTO.setComanda_cliente_codigo(cpf_cliente);
							objpedidoDTO.setComanda_funcionario_codigo(funcionarioCodigo);
							lista9.add(objpedidoDTO);

							PedidosDAO objpedidoDAO = new PedidosDAO();
							retorno = objpedidoDAO.criaComanda(lista9, lista8, cpf_cliente);

							if (retorno == 1) {
								buscarPedido(listaProdutos, lista8, lista9, 1);
							} else {
								buscarPedido(listaProdutos, lista8, lista9, 2);
							}
						} else {
							JOptionPane.showMessageDialog(null, mensagem_validacao);
						}

					} catch (Exception error2) {
						JOptionPane.showMessageDialog(null, error2);
					}
				}
			});

			t1.start();
		}

		@SuppressWarnings("static-access")
		public void buscarPedido(ArrayList<ProdutoDTO> consulta_produto,
				ArrayList<ProdutoPedidosDTO> consulta_produtos_pedido, ArrayList<PedidosDTO> consulta_pedido,
				int parametro) {

			ArrayList<Object> dados = new ArrayList<>();
			String[] colunas = new String[] { "Codigo", "Produto", "Quantidade", "Preço" };
			int valorPedido = 0, custoPedido = 0, pesoPedido = 0;
			String grupoAnterior = "";
			int valorProduto = 0, desconto = 0;

			if (parametro == 2) {

				lbl_custo_mostrar.setText(df.format(custoPedido));
				lbl_preco_mostrar.setText(df.format(valorPedido));
				lbl_peso_mostrar.setText(df.format(pesoPedido));

				cb_combo.setSelectedIndex(0);
				cb_produto.setSelectedIndex(0);
				txt_quantidade.setText("");

				modelo = new TableModelPedido(dados, colunas);
				tabela_comanda.setModel(modelo);
				tabela_comanda.getColumnModel().getColumn(0).setPreferredWidth(75);
				tabela_comanda.getColumnModel().getColumn(0).setResizable(false);
				tabela_comanda.getColumnModel().getColumn(1).setPreferredWidth(300);
				tabela_comanda.getColumnModel().getColumn(1).setResizable(false);
				tabela_comanda.getColumnModel().getColumn(2).setPreferredWidth(100);
				tabela_comanda.getColumnModel().getColumn(2).setResizable(false);
				tabela_comanda.getColumnModel().getColumn(3).setPreferredWidth(106);
				tabela_comanda.getColumnModel().getColumn(3).setResizable(false);
				tabela_comanda.getTableHeader().setReorderingAllowed(false);
				tabela_comanda.setAutoResizeMode(tabela_comanda.AUTO_RESIZE_OFF);
				tabela_comanda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			} else {
				try {

					lista5 = consulta_pedido;
					lista6 = consulta_produtos_pedido;
					lista7 = consulta_produto;

					for (int num = 0; num < lista6.size(); num++) {

						if (lista6.get(num).getProcom_grupo().trim().equals("") == false
								&& lista6.get(num).getProcom_grupo() != null) {
							if (lista6.get(num).getProcom_grupo().trim().equals(grupoAnterior) == false) {
								CombosDAO objcombosDAO = new CombosDAO();
								objcombosDAO.buscaCombosProdutos(lista6.get(num).getProcom_grupo().trim());
								lista3 = objcombosDAO.getLista();
							}
							grupoAnterior = lista6.get(num).getProcom_grupo().trim();
							desconto = (lista3.get(0).getCombo_desconto() == 0 ? 1 : lista3.get(0).getCombo_desconto());
							valorProduto = lista7.get(num).getProduto_preco()
									* lista6.get(num).getProcom_produto_quantidade();
							if (desconto != 1) {
								valorProduto = (valorProduto - ((valorProduto * desconto) / 100));
							}

						} else {
							valorProduto = lista7.get(num).getProduto_preco()
									* lista6.get(num).getProcom_produto_quantidade();
						}

						dados.add(new Object[] { lista7.get(num).getProduto_codigo(), lista7.get(num).getProduto_nome(),
								lista6.get(num).getProcom_produto_quantidade(), df.format(valorProduto) });

						valorPedido += (int) valorProduto;
						custoPedido += lista7.get(num).getProduto_custo()
								* lista6.get(num).getProcom_produto_quantidade();
						pesoPedido += lista7.get(num).getProduto_peso()
								* lista6.get(num).getProcom_produto_quantidade();

					}

					lbl_custo_mostrar.setText(df.format(custoPedido));
					lbl_preco_mostrar.setText(df.format(valorPedido));
					lbl_peso_mostrar.setText(Integer.toString(pesoPedido));

					cb_combo.setSelectedIndex(0);
					cb_produto.setSelectedIndex(0);
					txt_quantidade.setText("");

					modelo = new TableModelPedido(dados, colunas);
					tabela_comanda.setModel(modelo);
					tabela_comanda.getColumnModel().getColumn(0).setPreferredWidth(75);
					tabela_comanda.getColumnModel().getColumn(0).setResizable(false);
					tabela_comanda.getColumnModel().getColumn(1).setPreferredWidth(300);
					tabela_comanda.getColumnModel().getColumn(1).setResizable(false);
					tabela_comanda.getColumnModel().getColumn(2).setPreferredWidth(100);
					tabela_comanda.getColumnModel().getColumn(2).setResizable(false);
					tabela_comanda.getColumnModel().getColumn(3).setPreferredWidth(106);
					tabela_comanda.getColumnModel().getColumn(3).setResizable(false);
					tabela_comanda.getTableHeader().setReorderingAllowed(false);
					tabela_comanda.setAutoResizeMode(tabela_comanda.AUTO_RESIZE_OFF);
					tabela_comanda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "Erro ao preencher tabela" + error);
				}
			}
		}

		public void verificaPedidoCliente() {
			String cpf = "";
			int retorno = 0;

			consulta_produto = new ArrayList<>();
			consulta_produtos_pedido = new ArrayList<>();
			consulta_pedido = new ArrayList<>();
			consulta_cliente = new ArrayList<>();

			cpf = txt_cliente.getText();

			if (cpf.trim().equals("") == false) {
				try {

					ConsultasDAO objconsultasDAO = new ConsultasDAO();
					retorno = objconsultasDAO.buscaClienteTudo(cpf, 0);

					if (retorno == 1) {

						consulta_produto = objconsultasDAO.getLista7();
						consulta_produtos_pedido = objconsultasDAO.getLista6();
						consulta_pedido = objconsultasDAO.getLista5();
						consulta_cliente = objconsultasDAO.getLista4();

						this.clienteGrupo = consulta_cliente.get(0).getCliente_grupo();
						lbl_cliente_nome.setText(consulta_cliente.get(0).getCliente_nome());

						buscarPedido(consulta_produto, consulta_produtos_pedido, consulta_pedido, 1);
						this.tpregistro = 1;
					}

					if (retorno == 2) {

						consulta_produto = objconsultasDAO.getLista7();
						consulta_produtos_pedido = objconsultasDAO.getLista6();
						consulta_pedido = objconsultasDAO.getLista5();
						consulta_cliente = objconsultasDAO.getLista4();

						lbl_cliente_nome.setText(consulta_cliente.get(0).getCliente_nome());

						buscarPedido(consulta_produto, consulta_produtos_pedido, consulta_pedido, 2);

						this.tpregistro = 2;

					}

					if (retorno == -1) {
						lbl_cliente_nome.setText("Cliente não cadastrado!");

						buscarPedido(consulta_produto, consulta_produtos_pedido, consulta_pedido, 2);

						this.tpregistro = 2;
					}

				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "ERRO BUSCAR CLIENTE" + error);
				}
			}
		}

		public void carregaCombos() {
			int retorno = 0;
			lista3 = new ArrayList<>();
			lista4 = new ArrayList<>();
			lista2 = new ArrayList<>();

			try {
				ConsultasDAO objconsultasDAO = new ConsultasDAO();
				retorno = objconsultasDAO.buscaTodos(1);

				if (retorno == 1) {
					lista3 = objconsultasDAO.getLista();
					lista2 = objconsultasDAO.getLista2();
					lista4 = objconsultasDAO.getLista3();

					cb_combo.removeAllItems();
					cb_combo.addItem("");
					cb_produto.removeAllItems();
					cb_produto.addItem("");

					for (int num = 0; num < lista3.size(); num++) {
						cb_combo.addItem(lista3.get(num).getCombo_nome());
					}
					for (int num = 0; num < lista2.size(); num++) {
						cb_produto.addItem(lista2.get(num).getProduto_nome());
					}

				} else {
					cb_combo.removeAllItems();
					cb_combo.addItem("");
					cb_produto.removeAllItems();
					cb_produto.addItem("");
				}
			} catch (Exception error) {
				JOptionPane.showMessageDialog(null, "Erro ao preencher combos" + error);
			}
		}
	}

	public String getClienteGrupo() {
		return clienteGrupo;
	}

	public void setClienteGrupo(String clienteGrupo) {
		this.clienteGrupo = clienteGrupo;
	}

	public int getFuncionarioCodigo() {
		return funcionarioCodigo;
	}

	public void setFuncionarioCodigo(int funcionarioCodigo) {
		this.funcionarioCodigo = funcionarioCodigo;
	}

	public int getTpregistro() {
		return tpregistro;
	}

	public void setTpregistro(int tpregistro) {
		this.tpregistro = tpregistro;
	}
}
