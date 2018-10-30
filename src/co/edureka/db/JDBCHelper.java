package co.edureka.db;

import co.edureka.model.Student;

import java.sql.*;
import java.util.ArrayList;

public class JDBCHelper {
     Connection con;
     Statement stmt;
     PreparedStatement pStmt;
     CallableStatement Cstmt;

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
    public void updateStudent(Student student){
        try {
            // Statement API

            /*String sql = "update student set name ='"+student.getName()+"',email='"+student.getEmail()+"',age="+student.getAge()+"" +
                    ",address='"+student.getAddress()+"' where rollid="+student.getRollId()+"";
            stmt = con.createStatement();
            int i = stmt.executeUpdate(sql);
            System.out.println("Student update:"+i);*/

            // Prepared Statement

            String sql = "update student set name = ? ,email= ?,age= ? ,address= ? where rollid= ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setString(1,student.getName());
            pStmt.setString(2,student.getEmail());
            pStmt.setInt(3,student.getAge());
            pStmt.setString(4,student.getAddress());
            pStmt.setInt(5,student.getRollId());

            int i = pStmt.executeUpdate();

            System.out.println("Student update:"+i);




        }catch (Exception e){
            System.out.println("Some Exception:"+e);
        }
    }

    public void deleteStudent(Student student){
        try {
            String sql = "delete from student where rollid= ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setInt(1,student.getRollId());

            int i = pStmt.executeUpdate();

            System.out.println("Student deleted:"+i);




        }catch (Exception e){
            System.out.println("Some Exception:"+e);
        }
    }
    public void queryStudentbyon(Student student){
        try {
            String sql = "select * from student where rollid= ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setInt(1,student.getRollId());

            ResultSet rs = pStmt.executeQuery();


            System.out.println("Student Id:"+rs.getInt(1) +" Student Name:"+rs.getString(2)  +
                    " Student email:"+rs.getString(2)+" Student Age:"+rs.getInt(3)+"Student Address:"+rs.getString(4));




        }catch (Exception e){
            System.out.println("Some Exception:"+e);
        }
    }
    public ArrayList<Student> queryAllStudent(){
        ArrayList<Student> liststudent = new ArrayList<Student>();
        try {
            String sql = "select * from student order by rollid";
            pStmt = con.prepareStatement(sql);

            ResultSet rs = pStmt.executeQuery();
            while (rs.next()){
                Student s = new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
                liststudent.add(s);
            }


        }catch (Exception e){
            System.out.println("Some Exception:"+e);
        }
        return liststudent;
    }

    public void executeProcedure(Student sRef){
        try{
            String sql = "{ call addStudent(?,?,?,?)}";
            Cstmt = con.prepareCall(sql);
            Cstmt.setString(1,sRef.getName());
            Cstmt.setString(2,sRef.getEmail());
            Cstmt.setInt(3,sRef.getAge());
            Cstmt.setString(4,sRef.getAddress());
            Cstmt.execute();
            System.out.println("--Procedure Executed--");

        }catch (Exception e){
            System.out.println("Some Exception:"+e);
        }
    }
    public void processBatch(){
        try {
            String sql1 = "update student set name='Amera Wesam' where rollid=7";
            String sql2 ="delete from student where rollid=13";

            con.setAutoCommit(false);

            stmt = con.createStatement();
            stmt.addBatch(sql1);
            stmt.addBatch(sql2);

            stmt.executeBatch();
            con.commit();
            System.out.println("--Batch processed--");

        }catch (Exception e){
            System.out.println("Some Exception:"+e);
            try {
                con.rollback();
                System.out.println("--DB Changes RollBacked--");
            }catch (Exception e1){
                e1.printStackTrace();
            }


        }
    }

    public void closeConnection(){
        try {
            if (stmt != null)
                stmt.close();
            if (pStmt != null)
                pStmt.close();
            if (con != null)
                con.close();
            System.out.println("--Connection Close--");

        }catch (Exception e){
            System.out.println("Some Exception:"+e);
        }
    }

}
