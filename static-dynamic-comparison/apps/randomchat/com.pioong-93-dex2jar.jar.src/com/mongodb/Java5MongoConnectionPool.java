package com.mongodb;

class Java5MongoConnectionPool
  extends DBPortPool
  implements Java5MongoConnectionPoolMBean
{
  Java5MongoConnectionPool(ServerAddress paramServerAddress, MongoOptions paramMongoOptions)
  {
    super(paramServerAddress, paramMongoOptions);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/Java5MongoConnectionPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */