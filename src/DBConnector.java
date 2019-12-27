import java.sql.Connection;

public interface DBConnector
{
    void connect();
    void disconnect();
    boolean isConnected();
}
