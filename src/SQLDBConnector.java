import java.sql.Connection;

public interface SQLDBConnector extends DBConnector
{
    Connection getConnection();
}
