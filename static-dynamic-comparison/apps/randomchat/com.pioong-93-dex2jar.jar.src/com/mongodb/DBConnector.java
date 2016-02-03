package com.mongodb;

public abstract interface DBConnector
{
  public abstract CommandResult authenticate(MongoCredential paramMongoCredential);
  
  public abstract Response call(DB paramDB, DBCollection paramDBCollection, OutMessage paramOutMessage, ServerAddress paramServerAddress, int paramInt);
  
  public abstract Response call(DB paramDB, DBCollection paramDBCollection, OutMessage paramOutMessage, ServerAddress paramServerAddress, int paramInt, ReadPreference paramReadPreference, DBDecoder paramDBDecoder);
  
  public abstract Response call(DB paramDB, DBCollection paramDBCollection, OutMessage paramOutMessage, ServerAddress paramServerAddress, DBDecoder paramDBDecoder);
  
  public abstract boolean isOpen();
  
  public abstract void requestDone();
  
  public abstract void requestEnsureConnection();
  
  public abstract void requestStart();
  
  public abstract WriteResult say(DB paramDB, OutMessage paramOutMessage, WriteConcern paramWriteConcern);
  
  public abstract WriteResult say(DB paramDB, OutMessage paramOutMessage, WriteConcern paramWriteConcern, ServerAddress paramServerAddress);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DBConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */