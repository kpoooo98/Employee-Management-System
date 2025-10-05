package employee.management.system;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

public class Conn {

    Connection connection;
    Statement statement;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","123456789");
            statement = connection.createStatement();

        }catch(Exception e){
            e.printStackTrace();

        }
    }
}
