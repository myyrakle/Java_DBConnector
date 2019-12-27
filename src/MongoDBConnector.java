import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class MongoDBConnector implements DBConnector
{
    private final static String DB_NAME = "";
    private MongoClient mongoClient;
    private MongoDatabase db;

    @Override public void connect()
    {
        mongoClient = new MongoClient();
        db = mongoClient.getDatabase(DB_NAME);
    }

    @Override public void disconnect()
    {
        mongoClient.close();
        mongoClient = null;
        db = null;
    }

    @Override public boolean isConnected()
    {
        return mongoClient != null;
    }

    public MongoCollection<Document> getCollection(String collectionName)
    {
        return db.getCollection(collectionName);
    }
}
