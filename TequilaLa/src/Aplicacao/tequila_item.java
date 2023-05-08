package Aplicacao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class tequila_item extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JLabel lblProduto;
	private JLabel lblPeso;
	private JLabel lblPeso_1;
	private JLabel lblProduto_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tequila_item frame = new tequila_item();
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
	public tequila_item() {
		setBounds(100, 100, 928, 630);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Busca", null, layeredPane_1, null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Cadastro", null, layeredPane, null);
		layeredPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ITEM 1");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(27, 53, 64, 32);
		layeredPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 15));
		textField.setBounds(101, 53, 243, 32);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblItem = new JLabel("ITEM 2");
		lblItem.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem.setBounds(27, 96, 64, 32);
		layeredPane.add(lblItem);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(101, 96, 243, 32);
		layeredPane.add(textField_1);
		
		JLabel lblItem_1 = new JLabel("ITEM 3");
		lblItem_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem_1.setBounds(27, 139, 64, 32);
		layeredPane.add(lblItem_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.BOLD, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(101, 139, 243, 32);
		layeredPane.add(textField_2);
		
		JLabel lblItem_2 = new JLabel("ITEM 4");
		lblItem_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem_2.setBounds(27, 182, 64, 32);
		layeredPane.add(lblItem_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.BOLD, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(101, 182, 243, 32);
		layeredPane.add(textField_3);
		
		JLabel lblItem_3 = new JLabel("ITEM 5");
		lblItem_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem_3.setBounds(27, 225, 64, 32);
		layeredPane.add(lblItem_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.BOLD, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(101, 225, 243, 32);
		layeredPane.add(textField_4);
		
		JLabel lblItem_4 = new JLabel("ITEM 6");
		lblItem_4.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem_4.setBounds(27, 268, 64, 32);
		layeredPane.add(lblItem_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.BOLD, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(101, 268, 243, 32);
		layeredPane.add(textField_5);
		
		JLabel lblItem_5 = new JLabel("ITEM 7");
		lblItem_5.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem_5.setBounds(27, 311, 64, 32);
		layeredPane.add(lblItem_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Arial", Font.BOLD, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(101, 311, 243, 32);
		layeredPane.add(textField_6);
		
		JLabel lblItem_6 = new JLabel("ITEM 8");
		lblItem_6.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem_6.setBounds(27, 354, 64, 32);
		layeredPane.add(lblItem_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Arial", Font.BOLD, 15));
		textField_7.setColumns(10);
		textField_7.setBounds(101, 354, 243, 32);
		layeredPane.add(textField_7);
		
		JLabel lblItem_7 = new JLabel("ITEM 9");
		lblItem_7.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem_7.setBounds(27, 397, 64, 32);
		layeredPane.add(lblItem_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Arial", Font.BOLD, 15));
		textField_8.setColumns(10);
		textField_8.setBounds(101, 397, 243, 32);
		layeredPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Arial", Font.BOLD, 15));
		textField_9.setColumns(10);
		textField_9.setBounds(551, 53, 242, 32);
		layeredPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Arial", Font.BOLD, 15));
		textField_10.setColumns(10);
		textField_10.setBounds(551, 96, 242, 32);
		layeredPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Arial", Font.BOLD, 15));
		textField_11.setColumns(10);
		textField_11.setBounds(551, 139, 242, 32);
		layeredPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Arial", Font.BOLD, 15));
		textField_12.setColumns(10);
		textField_12.setBounds(551, 182, 242, 32);
		layeredPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Arial", Font.BOLD, 15));
		textField_13.setColumns(10);
		textField_13.setBounds(551, 225, 242, 32);
		layeredPane.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Arial", Font.BOLD, 15));
		textField_14.setColumns(10);
		textField_14.setBounds(551, 268, 242, 32);
		layeredPane.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Arial", Font.BOLD, 15));
		textField_15.setColumns(10);
		textField_15.setBounds(551, 311, 242, 32);
		layeredPane.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("Arial", Font.BOLD, 15));
		textField_16.setColumns(10);
		textField_16.setBounds(551, 354, 242, 32);
		layeredPane.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("Arial", Font.BOLD, 15));
		textField_17.setColumns(10);
		textField_17.setBounds(551, 397, 242, 32);
		layeredPane.add(textField_17);
		
		JLabel lblItem_8 = new JLabel("ITEM 11");
		lblItem_8.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem_8.setBounds(477, 53, 64, 32);
		layeredPane.add(lblItem_8);
		
		JLabel lblItem_9 = new JLabel("ITEM 12");
		lblItem_9.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem_9.setBounds(477, 96, 64, 32);
		layeredPane.add(lblItem_9);
		
		JLabel lblItem_1_1 = new JLabel("ITEM 13");
		lblItem_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem_1_1.setBounds(477, 139, 64, 32);
		layeredPane.add(lblItem_1_1);
		
		JLabel lblItem_2_1 = new JLabel("ITEM 14");
		lblItem_2_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem_2_1.setBounds(477, 182, 64, 32);
		layeredPane.add(lblItem_2_1);
		
		JLabel lblItem_3_1 = new JLabel("ITEM 15");
		lblItem_3_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem_3_1.setBounds(477, 225, 64, 32);
		layeredPane.add(lblItem_3_1);
		
		JLabel lblItem_4_1 = new JLabel("ITEM 16");
		lblItem_4_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem_4_1.setBounds(477, 268, 64, 32);
		layeredPane.add(lblItem_4_1);
		
		JLabel lblItem_5_1 = new JLabel("ITEM 17");
		lblItem_5_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem_5_1.setBounds(477, 311, 64, 32);
		layeredPane.add(lblItem_5_1);
		
		JLabel lblItem_6_1 = new JLabel("ITEM 18");
		lblItem_6_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem_6_1.setBounds(477, 354, 64, 32);
		layeredPane.add(lblItem_6_1);
		
		JLabel lblItem_7_1 = new JLabel("ITEM 19");
		lblItem_7_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem_7_1.setBounds(477, 397, 64, 32);
		layeredPane.add(lblItem_7_1);
		
		JLabel lblItem_7_2 = new JLabel("ITEM 10");
		lblItem_7_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem_7_2.setBounds(27, 440, 64, 32);
		layeredPane.add(lblItem_7_2);
		
		textField_18 = new JTextField();
		textField_18.setFont(new Font("Arial", Font.BOLD, 15));
		textField_18.setColumns(10);
		textField_18.setBounds(101, 440, 243, 32);
		layeredPane.add(textField_18);
		
		JLabel lblItem_7_1_1 = new JLabel("ITEM 20");
		lblItem_7_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem_7_1_1.setBounds(477, 440, 64, 32);
		layeredPane.add(lblItem_7_1_1);
		
		textField_19 = new JTextField();
		textField_19.setFont(new Font("Arial", Font.BOLD, 15));
		textField_19.setColumns(10);
		textField_19.setBounds(551, 440, 242, 32);
		layeredPane.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_20.setFont(new Font("Arial", Font.BOLD, 15));
		textField_20.setBounds(354, 53, 77, 32);
		layeredPane.add(textField_20);
		textField_20.setColumns(10);
		
		textField_21 = new JTextField();
		textField_21.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_21.setFont(new Font("Arial", Font.BOLD, 15));
		textField_21.setColumns(10);
		textField_21.setBounds(354, 96, 77, 32);
		layeredPane.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_22.setFont(new Font("Arial", Font.BOLD, 15));
		textField_22.setColumns(10);
		textField_22.setBounds(354, 139, 77, 32);
		layeredPane.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_23.setFont(new Font("Arial", Font.BOLD, 15));
		textField_23.setColumns(10);
		textField_23.setBounds(354, 268, 77, 32);
		layeredPane.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_24.setFont(new Font("Arial", Font.BOLD, 15));
		textField_24.setColumns(10);
		textField_24.setBounds(354, 225, 77, 32);
		layeredPane.add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_25.setFont(new Font("Arial", Font.BOLD, 15));
		textField_25.setColumns(10);
		textField_25.setBounds(354, 182, 77, 32);
		layeredPane.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_26.setFont(new Font("Arial", Font.BOLD, 15));
		textField_26.setColumns(10);
		textField_26.setBounds(354, 397, 77, 32);
		layeredPane.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_27.setFont(new Font("Arial", Font.BOLD, 15));
		textField_27.setColumns(10);
		textField_27.setBounds(354, 354, 77, 32);
		layeredPane.add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_28.setFont(new Font("Arial", Font.BOLD, 15));
		textField_28.setColumns(10);
		textField_28.setBounds(354, 311, 77, 32);
		layeredPane.add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_29.setFont(new Font("Arial", Font.BOLD, 15));
		textField_29.setColumns(10);
		textField_29.setBounds(354, 441, 77, 32);
		layeredPane.add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_30.setFont(new Font("Arial", Font.BOLD, 15));
		textField_30.setColumns(10);
		textField_30.setBounds(803, 268, 77, 32);
		layeredPane.add(textField_30);
		
		textField_31 = new JTextField();
		textField_31.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_31.setFont(new Font("Arial", Font.BOLD, 15));
		textField_31.setColumns(10);
		textField_31.setBounds(803, 225, 77, 32);
		layeredPane.add(textField_31);
		
		textField_32 = new JTextField();
		textField_32.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_32.setFont(new Font("Arial", Font.BOLD, 15));
		textField_32.setColumns(10);
		textField_32.setBounds(803, 182, 77, 32);
		layeredPane.add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_33.setFont(new Font("Arial", Font.BOLD, 15));
		textField_33.setColumns(10);
		textField_33.setBounds(803, 139, 77, 32);
		layeredPane.add(textField_33);
		
		textField_34 = new JTextField();
		textField_34.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_34.setFont(new Font("Arial", Font.BOLD, 15));
		textField_34.setColumns(10);
		textField_34.setBounds(803, 96, 77, 32);
		layeredPane.add(textField_34);
		
		textField_35 = new JTextField();
		textField_35.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_35.setFont(new Font("Arial", Font.BOLD, 15));
		textField_35.setColumns(10);
		textField_35.setBounds(803, 53, 77, 32);
		layeredPane.add(textField_35);
		
		textField_36 = new JTextField();
		textField_36.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_36.setFont(new Font("Arial", Font.BOLD, 15));
		textField_36.setColumns(10);
		textField_36.setBounds(803, 311, 77, 32);
		layeredPane.add(textField_36);
		
		textField_37 = new JTextField();
		textField_37.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_37.setFont(new Font("Arial", Font.BOLD, 15));
		textField_37.setColumns(10);
		textField_37.setBounds(803, 354, 77, 32);
		layeredPane.add(textField_37);
		
		textField_38 = new JTextField();
		textField_38.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_38.setFont(new Font("Arial", Font.BOLD, 15));
		textField_38.setColumns(10);
		textField_38.setBounds(803, 397, 77, 32);
		layeredPane.add(textField_38);
		
		textField_39 = new JTextField();
		textField_39.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_39.setFont(new Font("Arial", Font.BOLD, 15));
		textField_39.setColumns(10);
		textField_39.setBounds(803, 441, 77, 32);
		layeredPane.add(textField_39);
		
		lblProduto = new JLabel("PRODUTO");
		lblProduto.setFont(new Font("Arial", Font.BOLD, 15));
		lblProduto.setBounds(101, 11, 243, 32);
		layeredPane.add(lblProduto);
		
		lblPeso = new JLabel("PESO");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setFont(new Font("Arial", Font.BOLD, 15));
		lblPeso.setBounds(354, 11, 78, 32);
		layeredPane.add(lblPeso);
		
		lblPeso_1 = new JLabel("PESO");
		lblPeso_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblPeso_1.setBounds(802, 10, 78, 32);
		layeredPane.add(lblPeso_1);
		
		lblProduto_1 = new JLabel("PRODUTO");
		lblProduto_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblProduto_1.setBounds(549, 10, 243, 32);
		layeredPane.add(lblProduto_1);
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(304, 492, 302, 53);
		layeredPane.add(btnNewButton);

	}
}
