package com.mongodb;

import com.mongodb.util.ConnectionPoolStatisticsBean;

public abstract interface MongoConnectionPoolMXBean
{
  public abstract String getHost();
  
  public abstract int getMaxSize();
  
  public abstract String getName();
  
  public abstract int getPort();
  
  public abstract ConnectionPoolStatisticsBean getStatistics();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/MongoConnectionPoolMXBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */