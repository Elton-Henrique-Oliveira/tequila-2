package tequila_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoDAO {
	
	public Connection conectaBD() {
		Connection conn = null;
		
		try {
			String url = "jdbc:mysql://sql776.main-hosting.eu/u400453406_tequilabd?user=u400453406_tequilaadm&password=9e1vOOLsjNF7qMfq";
			conn = DriverManager.getConnection(url);
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, error.getMessage());
		}
		return conn;
	}
	
}
