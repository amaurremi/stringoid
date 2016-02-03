package com.mongodb.util;

import com.mongodb.InUseConnectionBean;

public class ConnectionPoolStatisticsBean
{
  private final int inUse;
  private final InUseConnectionBean[] inUseConnections;
  private final int total;
  
  public ConnectionPoolStatisticsBean(int paramInt1, int paramInt2, InUseConnectionBean[] paramArrayOfInUseConnectionBean)
  {
    this.total = paramInt1;
    this.inUse = paramInt2;
    this.inUseConnections = paramArrayOfInUseConnectionBean;
  }
  
  public int getInUse()
  {
    return this.inUse;
  }
  
  public InUseConnectionBean[] getInUseConnections()
  {
    return this.inUseConnections;
  }
  
  public int getTotal()
  {
    return this.total;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/ConnectionPoolStatisticsBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */