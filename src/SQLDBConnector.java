import java.sql.Connection;

public interface SQLDBConnector
{
    void connect();
    void disconnect();
    boolean isConnected();
    Connection getConnection();
}
