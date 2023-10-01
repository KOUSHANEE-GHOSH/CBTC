import java.rmi.server.ExportException;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///user", "root", "Kuttus@1234");
            s = c.createStatement();
            } catch (Exception e) {
            System.out.println(e);
        }
            }
}
