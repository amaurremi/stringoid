package com.mongodb;

import java.net.UnknownHostException;
import java.util.List;

public class MongoURI
{
  public static final String MONGODB_PREFIX = "mongodb://";
  private final MongoClientURI mongoClientURI;
  private final MongoOptions mongoOptions;
  
  @Deprecated
  public MongoURI(MongoClientURI paramMongoClientURI)
  {
    this.mongoClientURI = paramMongoClientURI;
    this.mongoOptions = new MongoOptions(paramMongoClientURI.getOptions());
  }
  
  @Deprecated
  public MongoURI(String paramString)
  {
    this.mongoClientURI = new MongoClientURI(paramString, new MongoClientOptions.Builder().legacyDefaults());
    this.mongoOptions = new MongoOptions(this.mongoClientURI.getOptions());
  }
  
  public Mongo connect()
    throws UnknownHostException
  {
    return new Mongo(this);
  }
  
  public DBCollection connectCollection(DB paramDB)
  {
    return paramDB.getCollection(getCollection());
  }
  
  public DBCollection connectCollection(Mongo paramMongo)
  {
    return connectDB(paramMongo).getCollection(getCollection());
  }
  
  public DB connectDB()
    throws UnknownHostException
  {
    return connect().getDB(getDatabase());
  }
  
  public DB connectDB(Mongo paramMongo)
  {
    return paramMongo.getDB(getDatabase());
  }
  
  public String getCollection()
  {
    return this.mongoClientURI.getCollection();
  }
  
  public MongoCredential getCredentials()
  {
    return this.mongoClientURI.getCredentials();
  }
  
  public String getDatabase()
  {
    return this.mongoClientURI.getDatabase();
  }
  
  public List<String> getHosts()
  {
    return this.mongoClientURI.getHosts();
  }
  
  public MongoOptions getOptions()
  {
    return this.mongoOptions;
  }
  
  public char[] getPassword()
  {
    return this.mongoClientURI.getPassword();
  }
  
  public String getUsername()
  {
    return this.mongoClientURI.getUsername();
  }
  
  public String toString()
  {
    return this.mongoClientURI.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/MongoURI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */