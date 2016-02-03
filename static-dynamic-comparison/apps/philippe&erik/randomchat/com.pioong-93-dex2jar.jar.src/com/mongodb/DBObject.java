package com.mongodb;

import org.bson.BSONObject;

public abstract interface DBObject
  extends BSONObject
{
  public abstract boolean isPartialObject();
  
  public abstract void markAsPartialObject();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DBObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */