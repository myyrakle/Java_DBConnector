package Beans;

import java.sql.Connection;

public interface IDBConnector
{
    void connect();
    void disconnect();
    boolean isConnected();
    Connection getConnection();
}