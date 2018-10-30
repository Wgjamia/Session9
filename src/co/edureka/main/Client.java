package co.edureka.main;

import co.edureka.db.JDBCHelper;
import co.edureka.model.Student;

public class Client {
    public static void main(String[] args){
        Student sRef = new Student("Wesam Aljamia","W.gjamia@ltt.ly",40,"HilAlndlous");
        Student sRef1 = new Student("Abourhman Wesam","abdourhman@ltt.ly",10,"HilAlndlous");

        JDBCHelper helper = new JDBCHelper();

        helper.CreateConnection();

        helper.insertStudent(sRef1);

        helper.closeConnection();


    }
}
