import com.mongodb.MongoClient;

public class MongoDBConnector implements DBConnector
{
    private MongoClient mongoClient;

    @Override public void connect()
    {
        mongoClient = new MongoClient();
    }

    @Override public void disconnect()
    {
        mongoClient.close();
        mongoClient = null;
    }

    @Override public boolean isConnected()
    {
        return mongoClient != null;
    }
}
