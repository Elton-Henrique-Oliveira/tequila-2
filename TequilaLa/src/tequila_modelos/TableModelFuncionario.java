package tequila_modelos;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModelFuncionario extends AbstractTableModel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Object> linhas = null;
	private String[] colunas = null;
	
	
	public TableModelFuncionario (ArrayList<Object> lin, String[] col) {
		setLinhas(lin);
		setColunas(col);
	}

	
	public int getColumnCount() {
		return colunas.length;
	}
	
	public int getRowCount() {
		return linhas.size();
	}

	public String getColumnName(int column) {
		return colunas[column]; 
	}
	
	public Object getValueAt (int numLin, int numCol) {
		Object[] linha = (Object[])getLinhas().get(numLin);
		return linha[numCol];
	}
	
	public ArrayList<Object> getLinhas() {
		return linhas;
	}


	public void setLinhas(ArrayList<Object> linhas) {
		this.linhas = linhas;
	}


	public String[] getColunas() {
		return colunas;
	}


	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}
}