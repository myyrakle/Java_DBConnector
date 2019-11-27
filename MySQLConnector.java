package Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector implements IDBConnector
{
    private final static String DB_NAME = "";
    private final static String DB_USERNAME = "root";
    private final static String DB_PASSWORD = "";

    private Connection connection;

    @Override
    public void connect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                            + DB_NAME
                            + "?useSSL=false&useUnicode=true&characterEncoding=utf8",
                    DB_NAME, DB_PASSWORD);
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
