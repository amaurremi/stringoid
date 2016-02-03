package com.mongodb;

public abstract interface Java5MongoConnectionPoolMBean
{
  public abstract String getHost();
  
  public abstract int getInUse();
  
  public abstract int getMaxSize();
  
  public abstract String getName();
  
  public abstract int getPort();
  
  public abstract int getTotal();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/Java5MongoConnectionPoolMBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */