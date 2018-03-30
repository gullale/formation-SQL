package dao;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDaoImpl();
		System.out.println(dao.getStudentGrade("ssn", "1"));
	}

}
