package com.mongodb;

public abstract interface DBCallbackFactory
{
  public abstract DBCallback create(DBCollection paramDBCollection);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DBCallbackFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */