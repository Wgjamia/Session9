package co.edureka.db;

import co.edureka.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCHelper {
     Connection con;
     Statement stmt;
    public JDBCHelper(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("-- Driver Loaded --");

        }catch (Exception e){
            System.out.println("Some Exception: "+e);
        }
    }

    public void CreateConnection(){
        try {
            String user = "wgjamia";
            String password = "Student";
            String url = "jdbc:mysql://localhost/edureka";
            con = DriverManager.getConnection(url,user,password);
            System.out.println("--Connection Created--");


        }catch (Exception e){
            System.out.println("Some Exception: "+e);
        }
    }
    public void insertStudent(Student student){
        try {
                String sql = "insert into student values(null,'"+student.getName()+"','"+student.getEmail()+"',"+student.getAge()+"" +
                        ",'"+student.getAddress()+"')";
                stmt = con.createStatement();
                int i = stmt.executeUpdate(sql);
            System.out.println("Student inserted:"+i);


        }catch (Exception e){
            System.out.println("Some Exception:"+e);
        }
    }
    public void closeConnection(){
        try {
            stmt.close();
            con.close();
            System.out.println("--Connection Close--");

        }catch (Exception e){
            System.out.println("Some Exception:"+e);
        }
    }

}
