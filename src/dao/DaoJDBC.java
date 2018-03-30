package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DaoJDBC {
	private static String login = "root";
	private static String password = "";

	public Connection seConnecter() throws SQLException, ClassNotFoundException {
		Connection cnx = null;
		Class.forName("com.mysql.jdbc.Driver");
		cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/formation", "root", "");
		return cnx;
	}

	protected void close(Connection cnx, PreparedStatement pstm, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (cnx != null)
				cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstm != null)
				pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}