package com.mongodb;

class MongoConnectionPool
  extends DBPortPool
  implements MongoConnectionPoolMXBean
{
  MongoConnectionPool(ServerAddress paramServerAddress, MongoOptions paramMongoOptions)
  {
    super(paramServerAddress, paramMongoOptions);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/MongoConnectionPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */