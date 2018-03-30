package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl extends DaoJDBC implements StudentDao {

	@Override
	public String getStudentGrade(String ssn, String courseId) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String grade = "";

		try {
			con = seConnecter();
			String o = "select grade from enrollment where ssn=? and courseId=?";
			PreparedStatement st = con.prepareStatement(o);
			st.setString(1, ssn);
			st.setString(2, courseId);

			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				grade = rs.getString(1);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstm, rst);
		}
		return grade;

	}

}
