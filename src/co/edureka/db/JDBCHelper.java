package co.edureka.db;

public class JDBCHelper {
    public JDBCHelper(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("-- Driver Loaded --");

        }catch (Exception e){
            System.out.println("Some Exception: "+e);
        }
    }

}
