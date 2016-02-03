package com.mongodb;

import java.net.UnknownHostException;
import java.util.List;

public class MongoClient
  extends Mongo
{
  private final MongoClientOptions options;
  
  public MongoClient()
    throws UnknownHostException
  {
    this(new ServerAddress());
  }
  
  public MongoClient(MongoClientURI paramMongoClientURI)
    throws UnknownHostException
  {
    super(new MongoURI(paramMongoClientURI));
    this.options = paramMongoClientURI.getOptions();
  }
  
  public MongoClient(ServerAddress paramServerAddress)
  {
    this(paramServerAddress, new MongoClientOptions.Builder().build());
  }
  
  public MongoClient(ServerAddress paramServerAddress, MongoClientOptions paramMongoClientOptions)
  {
    this(paramServerAddress, null, paramMongoClientOptions);
  }
  
  public MongoClient(ServerAddress paramServerAddress, List<MongoCredential> paramList)
  {
    this(paramServerAddress, paramList, new MongoClientOptions.Builder().build());
  }
  
  public MongoClient(ServerAddress paramServerAddress, List<MongoCredential> paramList, MongoClientOptions paramMongoClientOptions)
  {
    super(MongoAuthority.direct(paramServerAddress, new MongoCredentialsStore(paramList)), new MongoOptions(paramMongoClientOptions));
    this.options = paramMongoClientOptions;
  }
  
  public MongoClient(String paramString)
    throws UnknownHostException
  {
    this(new ServerAddress(paramString));
  }
  
  public MongoClient(String paramString, int paramInt)
    throws UnknownHostException
  {
    this(new ServerAddress(paramString, paramInt));
  }
  
  public MongoClient(String paramString, MongoClientOptions paramMongoClientOptions)
    throws UnknownHostException
  {
    this(new ServerAddress(paramString), paramMongoClientOptions);
  }
  
  public MongoClient(List<ServerAddress> paramList)
  {
    this(paramList, null, new MongoClientOptions.Builder().build());
  }
  
  public MongoClient(List<ServerAddress> paramList, MongoClientOptions paramMongoClientOptions)
  {
    this(paramList, null, paramMongoClientOptions);
  }
  
  public MongoClient(List<ServerAddress> paramList, List<MongoCredential> paramList1)
  {
    this(paramList, paramList1, new MongoClientOptions.Builder().build());
  }
  
  public MongoClient(List<ServerAddress> paramList, List<MongoCredential> paramList1, MongoClientOptions paramMongoClientOptions)
  {
    super(MongoAuthority.dynamicSet(paramList, new MongoCredentialsStore(paramList1)), new MongoOptions(paramMongoClientOptions));
    this.options = paramMongoClientOptions;
  }
  
  public List<MongoCredential> getCredentialsList()
  {
    return getAuthority().getCredentialsStore().asList();
  }
  
  public MongoClientOptions getMongoClientOptions()
  {
    return this.options;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/MongoClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */