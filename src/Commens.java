import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Commens {
    public Statement getStatement() {
        String url = "jdbc:mysql://localhost:3306/toys_JavaWithDB";
        String user = "root";
        String password = "*khacademy!";

        Statement statement = null;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return statement;
    }

    public String getGenerateID() {
        Date date = new Date();        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyyhh:mm:ss");  
        String strDate = formatter.format(date);
        return strDate;
    }

}
