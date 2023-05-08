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

import tequila_dao.CombosDAO;
import tequila_dao.ConsultasDAO;
import tequila_dao.ProdutoComboDAO;
import tequila_dao.ProdutoDAO;
import tequila_dto.CombosDTO;
import tequila_dto.ProdutoDTO;
import tequila_modelos.TableModelCombos;
import tequila_modelos.TableModelProdutos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class tequila_produto extends JInternalFrame {

	private JTextField txt_produto;
	private JTextField txt_preco;
	private JTextField txt_custo;
	private JTextField txt_peso;
	private JTable tabela_combos;
	private JTextField txt_desconto_combo;
	private JTextField txt_nome_combo;
	private JTable tabela_produtos;
	private JButton btn_criar_combo;
	private JScrollPane scroll_combos;
	private JPanel panel;
	private JLayeredPane layeredPane_1;
	private JButton btn_alterar_produto;
	private JButton btn_adicionar_produto;
	private JLabel lbl_peso_produto;
	private JLabel lbl_preco_produto;
	private JLabel lbl_nome_produto;
	private JLayeredPane layeredPane;
	private JTabbedPane tabbedPane;
	private JLabel lbl_custo_produto;
	private JLabel lbl_nome_combo;
	private JLabel lbl_desconto_combo;
	private JPanel panel_1;
	private JScrollPane scroll_produtos;
	private JLabel lbl_combo_combos;
	private JLabel lbl_combo_produtos;
	private JComboBox<String> cb_combo;
	private JComboBox<String> cb_produto;
	private JButton btn_adicionar_produto_combo;
	private JLabel lbl_preco_produtos;
	private JLabel lbl_preco;
	private JLabel lbl_custo;
	private JLabel lbl_custo_produtos;
	@SuppressWarnings("unused")
	private ArrayList<CombosDTO> lista = new ArrayList<>();
	private ArrayList<ProdutoDTO> lista2 = new ArrayList<>();
	private ArrayList<CombosDTO> lista3 = new ArrayList<>();
	private ArrayList<ProdutoDTO> lista4 = new ArrayList<>();
	private JButton btnNewButton;
	private JTextField txt_produto_pesquisa;
	private JTable tabela_produto_pesquisa;
	private JScrollPane scrollPane;
	private JLabel lbl_nome_produto_1;
	private TableModelCombos modelo;
	private int selecionadoAntes = 0;
	private JLayeredPane layeredPane_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tequila_produto frame = new tequila_produto(2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public tequila_produto(int tipo) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setClosable(true);
		setBackground(SystemColor.activeCaption);
		setTitle("Produtos");
		setBounds(100, 100, 815, 472);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.activeCaption);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
				
		if(tipo == 2) {
		
			layeredPane = new JLayeredPane();
			tabbedPane.addTab("Cadastro", null, layeredPane, null);

			lbl_nome_produto = new JLabel("Nome");
			lbl_nome_produto.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_nome_produto.setBounds(53, 45, 81, 35);
			layeredPane.add(lbl_nome_produto);

			lbl_preco_produto = new JLabel("Pre\u00E7o $");
			lbl_preco_produto.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_preco_produto.setBounds(53, 91, 81, 35);
			layeredPane.add(lbl_preco_produto);

			lbl_custo_produto = new JLabel("Custo $");
			lbl_custo_produto.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_custo_produto.setBounds(53, 137, 81, 35);
			layeredPane.add(lbl_custo_produto);

			lbl_peso_produto = new JLabel("Peso KG");
			lbl_peso_produto.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_peso_produto.setBounds(53, 183, 81, 35);
			layeredPane.add(lbl_peso_produto);

			txt_produto = new JTextField();
			txt_produto.setForeground(Color.WHITE);
			txt_produto.setBackground(Color.GRAY);
			txt_produto.setFont(new Font("Arial", Font.BOLD, 15));
			txt_produto.setBounds(139, 45, 284, 35);
			layeredPane.add(txt_produto);
			txt_produto.setColumns(10);

			txt_preco = new JTextField();
			txt_preco.setForeground(Color.WHITE);
			txt_preco.setBackground(Color.GRAY);
			txt_preco.setFont(new Font("Arial", Font.BOLD, 15));
			txt_preco.setColumns(10);
			txt_preco.setBounds(139, 91, 136, 35);
			layeredPane.add(txt_preco);

			txt_custo = new JTextField();
			txt_custo.setForeground(Color.WHITE);
			txt_custo.setBackground(Color.GRAY);
			txt_custo.setFont(new Font("Arial", Font.BOLD, 15));
			txt_custo.setColumns(10);
			txt_custo.setBounds(139, 137, 136, 35);
			layeredPane.add(txt_custo);

			txt_peso = new JTextField();
			txt_peso.setForeground(Color.WHITE);
			txt_peso.setBackground(Color.GRAY);
			txt_peso.setFont(new Font("Arial", Font.BOLD, 15));
			txt_peso.setColumns(10);
			txt_peso.setBounds(139, 183, 136, 35);
			layeredPane.add(txt_peso);

			btn_adicionar_produto = new JButton("ADICIONAR");
			btn_adicionar_produto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					adicionarProduto();
				}
			});
			btn_adicionar_produto.setFont(new Font("Arial", Font.BOLD, 15));
			btn_adicionar_produto.setBounds(81, 247, 213, 35);
			layeredPane.add(btn_adicionar_produto);

			btn_alterar_produto = new JButton("ALTERAR");
			btn_alterar_produto.setEnabled(false);
			btn_alterar_produto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					alterarProduto();
				}
			});
			btn_alterar_produto.setFont(new Font("Arial", Font.BOLD, 15));
			btn_alterar_produto.setBounds(326, 247, 213, 35);
			layeredPane.add(btn_alterar_produto);

			layeredPane_1 = new JLayeredPane();
			tabbedPane.addTab("Combos", null, layeredPane_1, null);

			panel = new JPanel();
			panel.setBounds(10, 11, 350, 392);
			layeredPane_1.add(panel);
			panel.setLayout(null);

			scroll_combos = new JScrollPane();
			scroll_combos.setBounds(10, 142, 326, 239);
			panel.add(scroll_combos);

			tabela_combos = new JTable();
			tabela_combos.setForeground(Color.WHITE);
			tabela_combos.setBackground(Color.GRAY);
			tabela_combos.setFont(new Font("Arial", Font.BOLD, 15));
			scroll_combos.setViewportView(tabela_combos);

			btn_criar_combo = new JButton("CRIAR");
			btn_criar_combo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					criarCombo();
				}
			});
			btn_criar_combo.setFont(new Font("Arial", Font.BOLD, 15));
			btn_criar_combo.setBounds(99, 89, 150, 28);
			panel.add(btn_criar_combo);

			txt_desconto_combo = new JTextField();
			txt_desconto_combo.setForeground(Color.WHITE);
			txt_desconto_combo.setBackground(Color.GRAY);
			txt_desconto_combo.setFont(new Font("Arial", Font.BOLD, 15));
			txt_desconto_combo.setColumns(10);
			txt_desconto_combo.setBounds(130, 50, 58, 28);
			panel.add(txt_desconto_combo);

			txt_nome_combo = new JTextField();
			txt_nome_combo.setForeground(Color.WHITE);
			txt_nome_combo.setBackground(Color.GRAY);
			txt_nome_combo.setFont(new Font("Arial", Font.BOLD, 15));
			txt_nome_combo.setColumns(10);
			txt_nome_combo.setBounds(130, 11, 150, 28);
			panel.add(txt_nome_combo);

			lbl_nome_combo = new JLabel("Combo");
			lbl_nome_combo.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_nome_combo.setBounds(46, 11, 80, 28);
			panel.add(lbl_nome_combo);

			lbl_desconto_combo = new JLabel("Desconto");
			lbl_desconto_combo.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_desconto_combo.setBounds(46, 50, 80, 28);
			panel.add(lbl_desconto_combo);

			panel_1 = new JPanel();
			panel_1.setBounds(370, 11, 414, 392);
			layeredPane_1.add(panel_1);
			panel_1.setLayout(null);

			scroll_produtos = new JScrollPane();
			scroll_produtos.setBounds(10, 142, 394, 239);
			panel_1.add(scroll_produtos);

			tabela_produtos = new JTable();
			tabela_produtos.setForeground(Color.WHITE);
			tabela_produtos.setBackground(Color.GRAY);
			tabela_produtos.setFont(new Font("Arial", Font.BOLD, 15));
			scroll_produtos.setViewportView(tabela_produtos);

			lbl_combo_combos = new JLabel("Combo");
			lbl_combo_combos.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_combo_combos.setBounds(21, 11, 80, 28);
			panel_1.add(lbl_combo_combos);

			lbl_combo_produtos = new JLabel("Produto");
			lbl_combo_produtos.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_combo_produtos.setBounds(21, 46, 80, 28);
			panel_1.add(lbl_combo_produtos);

			cb_combo = new JComboBox<String>();
			cb_combo.setForeground(Color.WHITE);
			cb_combo.setBackground(Color.GRAY);
			cb_combo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					int selecionado = cb_combo.getSelectedIndex();

					if (selecionado != selecionadoAntes) {
						if (selecionado != 0) {
							buscaProdutosCombo();
						}
						selecionadoAntes = selecionado;
					}
				}
			});
			cb_combo.setFont(new Font("Arial", Font.BOLD, 15));
			cb_combo.setBounds(98, 11, 176, 28);
			panel_1.add(cb_combo);

			cb_produto = new JComboBox<String>();
			cb_produto.setForeground(Color.WHITE);
			cb_produto.setBackground(Color.GRAY);
			cb_produto.setFont(new Font("Arial", Font.BOLD, 15));
			cb_produto.setBounds(98, 50, 176, 28);
			panel_1.add(cb_produto);

			btn_adicionar_produto_combo = new JButton("ADICIONAR");
			btn_adicionar_produto_combo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					adicionarProdutoCombo();
				}
			});
			btn_adicionar_produto_combo.setFont(new Font("Arial", Font.BOLD, 15));
			btn_adicionar_produto_combo.setBounds(284, 15, 120, 59);
			panel_1.add(btn_adicionar_produto_combo);

			lbl_preco_produtos = new JLabel("Pre\u00E7o $");
			lbl_preco_produtos.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_preco_produtos.setBounds(21, 103, 64, 28);
			panel_1.add(lbl_preco_produtos);

			lbl_custo_produtos = new JLabel("Custo $");
			lbl_custo_produtos.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_custo_produtos.setBounds(194, 103, 64, 28);
			panel_1.add(lbl_custo_produtos);

			lbl_preco = new JLabel("");
			lbl_preco.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_preco.setBounds(79, 103, 76, 28);
			panel_1.add(lbl_preco);

			lbl_custo = new JLabel("");
			lbl_custo.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_custo.setBounds(256, 103, 76, 28);
			panel_1.add(lbl_custo);
			
			layeredPane_2 = new JLayeredPane();
			tabbedPane.addTab("Mostrar", null, layeredPane_2, null);

			btnNewButton = new JButton("BUSCAR");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buscarProdutos();
				}
			});
			btnNewButton.setBounds(423, 11, 257, 35);
			layeredPane_2.add(btnNewButton);

			lbl_nome_produto_1 = new JLabel("Nome");
			lbl_nome_produto_1.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_nome_produto_1.setBounds(26, 11, 81, 35);
			layeredPane_2.add(lbl_nome_produto_1);

			txt_produto_pesquisa = new JTextField();
			txt_produto_pesquisa.setBackground(Color.GRAY);
			txt_produto_pesquisa.setForeground(Color.WHITE);
			txt_produto_pesquisa.setFont(new Font("Arial", Font.BOLD, 15));
			txt_produto_pesquisa.setColumns(10);
			txt_produto_pesquisa.setBounds(112, 11, 284, 35);
			layeredPane_2.add(txt_produto_pesquisa);

			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 111, 774, 292);
			layeredPane_2.add(scrollPane);

			tabela_produto_pesquisa = new JTable();
			tabela_produto_pesquisa.setForeground(Color.WHITE);
			tabela_produto_pesquisa.setBackground(Color.GRAY);
			tabela_produto_pesquisa.setFont(new Font("Arial", Font.BOLD, 15));
			scrollPane.setViewportView(tabela_produto_pesquisa);
			
			carregaCombos();
		}
		
		if(tipo == 1) {
			layeredPane_2 = new JLayeredPane();
			tabbedPane.addTab("Mostrar", null, layeredPane_2, null);

			btnNewButton = new JButton("BUSCAR");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buscarProdutos();
				}
			});
			btnNewButton.setBounds(423, 11, 257, 35);
			layeredPane_2.add(btnNewButton);

			lbl_nome_produto_1 = new JLabel("Nome");
			lbl_nome_produto_1.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_nome_produto_1.setBounds(26, 11, 81, 35);
			layeredPane_2.add(lbl_nome_produto_1);

			txt_produto_pesquisa = new JTextField();
			txt_produto_pesquisa.setBackground(Color.GRAY);
			txt_produto_pesquisa.setForeground(Color.WHITE);
			txt_produto_pesquisa.setFont(new Font("Arial", Font.BOLD, 15));
			txt_produto_pesquisa.setColumns(10);
			txt_produto_pesquisa.setBounds(112, 11, 284, 35);
			layeredPane_2.add(txt_produto_pesquisa);

			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 111, 774, 292);
			layeredPane_2.add(scrollPane);

			tabela_produto_pesquisa = new JTable();
			tabela_produto_pesquisa.setForeground(Color.WHITE);
			tabela_produto_pesquisa.setBackground(Color.GRAY);
			tabela_produto_pesquisa.setFont(new Font("Arial", Font.BOLD, 15));
			scrollPane.setViewportView(tabela_produto_pesquisa);
			
			layeredPane_1 = new JLayeredPane();
			tabbedPane.addTab("Combos", null, layeredPane_1, null);

			panel = new JPanel();
			panel.setBounds(10, 11, 350, 392);
			layeredPane_1.add(panel);
			panel.setLayout(null);

			scroll_combos = new JScrollPane();
			scroll_combos.setBounds(10, 142, 326, 239);
			panel.add(scroll_combos);

			tabela_combos = new JTable();
			tabela_combos.setForeground(Color.WHITE);
			tabela_combos.setBackground(Color.GRAY);
			tabela_combos.setFont(new Font("Arial", Font.BOLD, 15));
			scroll_combos.setViewportView(tabela_combos);
			
			txt_desconto_combo = new JTextField();
			txt_desconto_combo.setForeground(Color.WHITE);
			txt_desconto_combo.setBackground(Color.GRAY);
			txt_desconto_combo.setFont(new Font("Arial", Font.BOLD, 15));
			txt_desconto_combo.setColumns(10);
			txt_desconto_combo.setBounds(130, 50, 58, 28);
			panel.add(txt_desconto_combo);

			txt_nome_combo = new JTextField();
			txt_nome_combo.setForeground(Color.WHITE);
			txt_nome_combo.setBackground(Color.GRAY);
			txt_nome_combo.setFont(new Font("Arial", Font.BOLD, 15));
			txt_nome_combo.setColumns(10);
			txt_nome_combo.setBounds(130, 11, 150, 28);
			panel.add(txt_nome_combo);

			lbl_nome_combo = new JLabel("Combo");
			lbl_nome_combo.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_nome_combo.setBounds(46, 11, 80, 28);
			panel.add(lbl_nome_combo);

			lbl_desconto_combo = new JLabel("Desconto");
			lbl_desconto_combo.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_desconto_combo.setBounds(46, 50, 80, 28);
			panel.add(lbl_desconto_combo);

			panel_1 = new JPanel();
			panel_1.setBounds(370, 11, 414, 392);
			layeredPane_1.add(panel_1);
			panel_1.setLayout(null);

			scroll_produtos = new JScrollPane();
			scroll_produtos.setBounds(10, 142, 394, 239);
			panel_1.add(scroll_produtos);

			tabela_produtos = new JTable();
			tabela_produtos.setForeground(Color.WHITE);
			tabela_produtos.setBackground(Color.GRAY);
			tabela_produtos.setFont(new Font("Arial", Font.BOLD, 15));
			scroll_produtos.setViewportView(tabela_produtos);

			lbl_combo_combos = new JLabel("Combo");
			lbl_combo_combos.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_combo_combos.setBounds(21, 11, 80, 28);
			panel_1.add(lbl_combo_combos);

			lbl_combo_produtos = new JLabel("Produto");
			lbl_combo_produtos.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_combo_produtos.setBounds(21, 46, 80, 28);
			panel_1.add(lbl_combo_produtos);

			cb_combo = new JComboBox<String>();
			cb_combo.setForeground(Color.WHITE);
			cb_combo.setBackground(Color.GRAY);
			cb_combo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					int selecionado = cb_combo.getSelectedIndex();

					if (selecionado != selecionadoAntes) {
						if (selecionado != 0) {
							buscaProdutosCombo();
						}
						selecionadoAntes = selecionado;
					}
				}
			});
			cb_combo.setFont(new Font("Arial", Font.BOLD, 15));
			cb_combo.setBounds(98, 11, 176, 28);
			panel_1.add(cb_combo);

			cb_produto = new JComboBox<String>();
			cb_produto.setForeground(Color.WHITE);
			cb_produto.setBackground(Color.GRAY);
			cb_produto.setFont(new Font("Arial", Font.BOLD, 15));
			cb_produto.setBounds(98, 50, 176, 28);
			panel_1.add(cb_produto);

			btn_adicionar_produto_combo = new JButton("ADICIONAR");
			btn_adicionar_produto_combo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					adicionarProdutoCombo();
				}
			});
			btn_adicionar_produto_combo.setFont(new Font("Arial", Font.BOLD, 15));
			btn_adicionar_produto_combo.setBounds(284, 15, 120, 59);
			panel_1.add(btn_adicionar_produto_combo);

			lbl_preco_produtos = new JLabel("Pre\u00E7o $");
			lbl_preco_produtos.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_preco_produtos.setBounds(21, 103, 64, 28);
			panel_1.add(lbl_preco_produtos);

			lbl_custo_produtos = new JLabel("Custo $");
			lbl_custo_produtos.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_custo_produtos.setBounds(194, 103, 64, 28);
			panel_1.add(lbl_custo_produtos);

			lbl_preco = new JLabel("");
			lbl_preco.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_preco.setBounds(79, 103, 76, 28);
			panel_1.add(lbl_preco);

			lbl_custo = new JLabel("");
			lbl_custo.setFont(new Font("Arial", Font.BOLD, 15));
			lbl_custo.setBounds(256, 103, 76, 28);
			panel_1.add(lbl_custo);
			
			carregaCombos();
		}
		
	}

	private void adicionarProduto() {

		String nome, mensagem_validacao = "";
		int preco = 0, custo = 0, peso = 0, retorno = 0;

		nome = txt_produto.getText();
		preco = Integer.parseInt(txt_preco.getText());
		custo = Integer.parseInt(txt_custo.getText());
		peso = Integer.parseInt(txt_peso.getText());

		if (nome.trim().equals("") == true) {
			mensagem_validacao += "\nNome do produto não pode ser vaziu!!";
		}
		if (preco == 0) {
			mensagem_validacao += "\nPreço do produto não pode ser zerado!!";
		}
		if (custo == 0) {
			mensagem_validacao += "\nCusto do produto não pode ser zerado!!";
		}
		if (peso == 0) {
			mensagem_validacao += "\nPeso do produto não pode ser zerado!!";
		}

		if (mensagem_validacao.trim().equals("") == true) {

			ProdutoDTO objprodutoDTO = new ProdutoDTO();
			objprodutoDTO.setProduto_nome(nome);
			objprodutoDTO.setProduto_peso(peso);
			objprodutoDTO.setProduto_preco(preco);
			objprodutoDTO.setProduto_custo(custo);

			ProdutoDAO objprodutoDAO = new ProdutoDAO();
			retorno = objprodutoDAO.cadastrarProduto(objprodutoDTO);

			if (retorno != 1) {
				txt_produto.setText("");
				txt_preco.setText("");
				txt_custo.setText("");
				txt_peso.setText("");
				consultarProdutos();
				buscarProdutos();
			}

		} else {
			JOptionPane.showMessageDialog(null, mensagem_validacao);
		}
	}

	@SuppressWarnings("static-access")
	public void criarCombo() {
		String nome, mensagem_validacao = "";
		int desconto = 0, retorno = 0;
		ArrayList<Object> dados = new ArrayList<>();
		String[] colunas = new String[] { "Codigo", "Combo", "%" };
		lista = new ArrayList<>();

		nome = txt_nome_combo.getText();

		if (nome.trim().equals("") == true) {
			mensagem_validacao += "\nNome do combo não pode ser vaziu!!";
		}
		if (txt_desconto_combo.getText().trim().equals("") == true) {
			desconto = 0;
		}else {
			desconto = Integer.parseInt(txt_desconto_combo.getText());
		}

		if (mensagem_validacao.trim().equals("") == true) {

			CombosDTO objcomboDTO = new CombosDTO();
			objcomboDTO.setCombo_nome(nome);
			objcomboDTO.setCombo_desconto(desconto);

			CombosDAO objcomboDAO = new CombosDAO();
			retorno = objcomboDAO.cadastrarCombos(objcomboDTO);
			lista = objcomboDAO.getLista();
			if(modelo != null) {
				dados = modelo.getLinhas();	
			}			

			if (retorno != 1) {
				txt_nome_combo.setText("");
				txt_desconto_combo.setText("");
				dados.add(new Object[] { objcomboDTO.getCombo_codigo(), objcomboDTO.getCombo_nome(),
						objcomboDTO.getCombo_desconto() });
				cb_combo.addItem(objcomboDTO.getCombo_nome());
			}

			if(modelo != null) {
				modelo.setLinhas(dados);
			}else {
				modelo = new TableModelCombos(dados, colunas);
			}
			
			tabela_combos.setModel(modelo);
			tabela_combos.getColumnModel().getColumn(0).setPreferredWidth(75);
			tabela_combos.getColumnModel().getColumn(0).setResizable(false);
			tabela_combos.getColumnModel().getColumn(1).setPreferredWidth(200);
			tabela_combos.getColumnModel().getColumn(1).setResizable(false);
			tabela_combos.getColumnModel().getColumn(2).setPreferredWidth(48);
			tabela_combos.getColumnModel().getColumn(2).setResizable(false);
			tabela_combos.getTableHeader().setReorderingAllowed(false);
			tabela_combos.setAutoResizeMode(tabela_combos.AUTO_RESIZE_OFF);
			tabela_combos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		} else {
			JOptionPane.showMessageDialog(null, mensagem_validacao);
		}
	}

	@SuppressWarnings("static-access")
	public void carregaCombos() {
		int retorno = 0;
		lista3 = new ArrayList<>();
		lista4 = new ArrayList<>();
		lista2 = new ArrayList<>();
		ArrayList<Object> dados = new ArrayList<>();
		String[] colunas = new String[] { "Codigo", "Combo", "%" };

		try {
			ConsultasDAO objconsultasDAO = new ConsultasDAO();
			retorno = objconsultasDAO.buscaTodos(2);

			if (retorno == 1) {
				lista3 = objconsultasDAO.getLista();
				lista2 = objconsultasDAO.getLista2();

				cb_combo.removeAllItems();
				cb_combo.addItem("");
				cb_produto.removeAllItems();
				cb_produto.addItem("");

				for (int num = 0; num < lista3.size(); num++) {
					dados.add(new Object[] { lista3.get(num).getCombo_codigo(), lista3.get(num).getCombo_nome(),
							lista3.get(num).getCombo_desconto() });
					cb_combo.addItem(lista3.get(num).getCombo_nome());
				}
				for (int num = 0; num < lista2.size(); num++) {
					cb_produto.addItem(lista2.get(num).getProduto_nome());
				}

				modelo = new TableModelCombos(dados, colunas);
				tabela_combos.setModel(modelo);
				tabela_combos.getColumnModel().getColumn(0).setPreferredWidth(75);
				tabela_combos.getColumnModel().getColumn(0).setResizable(false);
				tabela_combos.getColumnModel().getColumn(1).setPreferredWidth(200);
				tabela_combos.getColumnModel().getColumn(1).setResizable(false);
				tabela_combos.getColumnModel().getColumn(2).setPreferredWidth(48);
				tabela_combos.getColumnModel().getColumn(2).setResizable(false);
				tabela_combos.getTableHeader().setReorderingAllowed(false);
				tabela_combos.setAutoResizeMode(tabela_combos.AUTO_RESIZE_OFF);
				tabela_combos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			}
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Erro ao preencher combos" + error);
		}
	}

	@SuppressWarnings("static-access")
	public void consultarCombos() {

		ArrayList<Object> dados = new ArrayList<>();
		String[] colunas = new String[] { "Codigo", "Combo", "%" };
		lista3 = new ArrayList<>();

		try {

			System.out.println(lista3.size() + "antes 1");

			CombosDAO objcombosDAO = new CombosDAO();
			lista3 = objcombosDAO.buscaCombos(0, "");

			if (lista3.size() > 0) {

				System.out.println(lista3.size() + "antes 2");

				lista3 = objcombosDAO.getLista();

				cb_combo.removeAllItems();
				cb_combo.addItem("");

				System.out.println(lista3.size() + " depois");

				for (int num = 0; num < lista3.size(); num++) {
					dados.add(new Object[] { lista3.get(num).getCombo_codigo(), lista3.get(num).getCombo_nome(),
							lista3.get(num).getCombo_desconto() });
					cb_combo.addItem(lista3.get(num).getCombo_nome());

				}

				TableModelCombos modelo = new TableModelCombos(dados, colunas);
				tabela_combos.setModel(modelo);
				tabela_combos.getColumnModel().getColumn(0).setPreferredWidth(75);
				tabela_combos.getColumnModel().getColumn(0).setResizable(false);
				tabela_combos.getColumnModel().getColumn(1).setPreferredWidth(200);
				tabela_combos.getColumnModel().getColumn(1).setResizable(false);
				tabela_combos.getColumnModel().getColumn(2).setPreferredWidth(48);
				tabela_combos.getColumnModel().getColumn(2).setResizable(false);
				tabela_combos.getTableHeader().setReorderingAllowed(false);
				tabela_combos.setAutoResizeMode(tabela_combos.AUTO_RESIZE_OFF);
				tabela_combos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			}
		} catch (Exception error) {
			System.out.println(error);
			JOptionPane.showMessageDialog(null, "Erro ao preencher tabela aqui nos combos" + error);
		}
	}

	@SuppressWarnings("static-access")
	public void consultarProdutos() {
		int retorno = 0;

		try {
			ProdutoDAO objprodutoDAO = new ProdutoDAO();
			retorno = objprodutoDAO.buscaProdutos(0, "");
			if (retorno == 1) {
				lista2 = objprodutoDAO.getLista();

				cb_produto.removeAllItems();
				cb_produto.addItem("");

				for (int num = 0; num < lista2.size(); num++) {
					cb_produto.addItem(lista2.get(num).getProduto_nome());

				}
			}
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Erro ao preencher tabela" + error);
		}
	}

	@SuppressWarnings("static-access")
	public void buscarProdutos() {
		int retorno = 0;
		String produto_pesquisa = "";
		ArrayList<Object> dados = new ArrayList<>();
		String[] colunas = new String[] { "Codigo", "Produto", "Preço $", "Custo $", "Peso" };
		lista2 = new ArrayList<>();

		produto_pesquisa = txt_produto_pesquisa.getText();

		try {
			ProdutoDAO objprodutoDAO = new ProdutoDAO();
			retorno = objprodutoDAO.buscaProdutos(1, produto_pesquisa);
			if (retorno == 1) {
				lista2 = objprodutoDAO.getLista();

				for (int num = 0; num < lista2.size(); num++) {
					dados.add(new Object[] { lista2.get(num).getProduto_codigo(), lista2.get(num).getProduto_nome(),
							"$" + lista2.get(num).getProduto_preco(), "$" + lista2.get(num).getProduto_custo(),
							lista2.get(num).getProduto_peso() });
				}

				TableModelProdutos modelo = new TableModelProdutos(dados, colunas);
				tabela_produto_pesquisa.setModel(modelo);
				tabela_produto_pesquisa.getColumnModel().getColumn(0).setPreferredWidth(100);
				tabela_produto_pesquisa.getColumnModel().getColumn(0).setResizable(false);
				tabela_produto_pesquisa.getColumnModel().getColumn(1).setPreferredWidth(371);
				tabela_produto_pesquisa.getColumnModel().getColumn(1).setResizable(false);
				tabela_produto_pesquisa.getColumnModel().getColumn(2).setPreferredWidth(100);
				tabela_produto_pesquisa.getColumnModel().getColumn(2).setResizable(false);
				tabela_produto_pesquisa.getColumnModel().getColumn(3).setPreferredWidth(100);
				tabela_produto_pesquisa.getColumnModel().getColumn(3).setResizable(false);
				tabela_produto_pesquisa.getColumnModel().getColumn(4).setPreferredWidth(100);
				tabela_produto_pesquisa.getColumnModel().getColumn(4).setResizable(false);
				tabela_produto_pesquisa.getTableHeader().setReorderingAllowed(false);
				tabela_produto_pesquisa.setAutoResizeMode(tabela_produto_pesquisa.AUTO_RESIZE_OFF);
				tabela_produto_pesquisa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			}
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Erro ao preencher tabela" + error);
		}
	}

	public void adicionarProdutoCombo() {
		String nome, combo, mensagem_validacao = "";

		nome = cb_produto.getSelectedItem().toString();
		combo = cb_combo.getSelectedItem().toString();

		if (nome.trim().equals("") == true) {
			mensagem_validacao += "\nProduto não pode ser vaziu!!";
		}
		if (combo.trim().equals("") == true) {
			mensagem_validacao += "\nCombo não pode ser vaziu!!";
		}

		if (mensagem_validacao.trim().equals("") == true) {

			ProdutoComboDAO objprodutocomboDAO = new ProdutoComboDAO();
			objprodutocomboDAO.AdicionarProduto(nome, combo);

			buscaProdutosCombo();

		} else {
			JOptionPane.showMessageDialog(null, mensagem_validacao);
		}
	}

	@SuppressWarnings("static-access")
	public void buscaProdutosCombo() {
		int retorno = 0;
		String combo_pesquisa = "", mensagem_validacao = "";
		ArrayList<Object> dados = new ArrayList<>();
		String[] colunas = new String[] { "Codigo", "Produto" };

		combo_pesquisa = cb_combo.getSelectedItem().toString();

		if (combo_pesquisa.trim().equals("") == true) {
			mensagem_validacao += "\nSelecione um combo para listar!!";
		}

		if (mensagem_validacao.trim().equals("") == true) {

			try {

				ProdutoComboDAO objprodutocomboDAO = new ProdutoComboDAO();
				retorno = objprodutocomboDAO.BuscaProdutoCombo(combo_pesquisa);

				if (retorno == 1) {

					lista4 = objprodutocomboDAO.getLista2();
					lista3 = objprodutocomboDAO.getLista();

					for (int num = 0; num < lista4.size(); num++) {
						dados.add(new Object[] { lista4.get(num).getProduto_codigo(),
								lista4.get(num).getProduto_nome() });
					}

					calcularPreco();

					TableModelProdutos modelo = new TableModelProdutos(dados, colunas);
					tabela_produtos.setModel(modelo);
					tabela_produtos.getColumnModel().getColumn(0).setPreferredWidth(100);
					tabela_produtos.getColumnModel().getColumn(0).setResizable(false);
					tabela_produtos.getColumnModel().getColumn(1).setPreferredWidth(291);
					tabela_produtos.getColumnModel().getColumn(1).setResizable(false);
					tabela_produtos.getTableHeader().setReorderingAllowed(false);
					tabela_produtos.setAutoResizeMode(tabela_produtos.AUTO_RESIZE_OFF);
					tabela_produtos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

				}
			} catch (Exception error) {
				JOptionPane.showMessageDialog(null, "Erro ao preencher tabela" + error);
			}
		}
	}

	public void calcularPreco() {

		int preco = 0, custo = 0;

		for (int i = 0; i < lista4.size(); i++) {
			preco += lista4.get(i).getProduto_preco();
			custo += lista4.get(i).getProduto_custo();
		}

		preco = preco - ((preco * lista3.get(0).getCombo_desconto()) / 100);

		lbl_preco.setText(Integer.toString(preco));
		lbl_custo.setText(Integer.toString(custo));

	}

	public void alterarProduto() {

	}
}
