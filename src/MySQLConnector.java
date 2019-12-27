import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector implements SQLDBConnector
{
    private final static String DB_NAME = "";
    private final static String DB_URL = "jdbc:mysql://localhost:3306/";
    private final static String DB_PARAMS = "?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=utf8";
    private final static String DB_USERNAME = "";
    private final static String DB_PASSWORD = "";

    private Connection connection;

    @Override
    public void connect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection =  DriverManager.getConnection(DB_URL+DB_NAME+DB_PARAMS, DB_USERNAME, DB_PASSWORD);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void disconnect()
    {
        try
        {
            connection.close();
            connection = null;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isConnected()
    {
        return connection!=null;
    }

    @Override
    public Connection getConnection()
    {
        return connection;
    }
}
