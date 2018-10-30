package co.edureka.main;

import co.edureka.db.JDBCHelper;
import co.edureka.model.Student;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args){
        Student sRef = new Student("Wesam Aljamia","W.gjamia@ltt.ly",40,"HilAlndlous");
        Student sRef1 = new Student("Osama","osama@ltt.ly",3,"Aldribee");
        Student sRef3 = new Student(3,"Abourhman Wesam","abdour.hman@ltt.ly",8,"Gootshall");
        Student sRef4 = new Student(3);



        JDBCHelper helper = new JDBCHelper();

        helper.CreateConnection();

        //helper.insertStudent(sRef1);

        //helper.updateStudent(sRef3);

        //helper.deleteStudent(sRef4);
      //  helper.executeProcedure(sRef1);

    //    helper.queryStudentbyon(sRef4);

     //   ArrayList<Student> slist = helper.queryAllStudent();

    //    for(Student stu : slist){
         //   System.out.println(stu);
      //  }
        helper.processBatch();

        helper.closeConnection();


    }
}
