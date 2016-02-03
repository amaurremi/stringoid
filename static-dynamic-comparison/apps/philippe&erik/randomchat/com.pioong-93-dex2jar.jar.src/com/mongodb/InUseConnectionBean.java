package com.mongodb;

import java.util.concurrent.TimeUnit;

public class InUseConnectionBean
{
  private final long durationMS;
  private final int localPort;
  private final String namespace;
  private final int numDocuments;
  private final OutMessage.OpCode opCode;
  private final String query;
  private final String threadName;
  
  InUseConnectionBean(DBPort paramDBPort, long paramLong)
  {
    DBPort.ActiveState localActiveState = paramDBPort.getActiveState();
    if (localActiveState == null)
    {
      this.durationMS = 0L;
      this.namespace = null;
      this.opCode = null;
      this.query = null;
      this.threadName = null;
    }
    for (this.numDocuments = 0;; this.numDocuments = localActiveState.outMessage.getNumDocuments())
    {
      this.localPort = paramDBPort.getLocalPort();
      return;
      this.durationMS = TimeUnit.NANOSECONDS.toMillis(paramLong - localActiveState.startTime);
      this.namespace = localActiveState.outMessage.getNamespace();
      this.opCode = localActiveState.outMessage.getOpCode();
      if (localActiveState.outMessage.getQuery() != null) {
        str = localActiveState.outMessage.getQuery().toString();
      }
      this.query = str;
      this.threadName = localActiveState.threadName;
    }
  }
  
  public long getDurationMS()
  {
    return this.durationMS;
  }
  
  public int getLocalPort()
  {
    return this.localPort;
  }
  
  public String getNamespace()
  {
    return this.namespace;
  }
  
  public int getNumDocuments()
  {
    return this.numDocuments;
  }
  
  public OutMessage.OpCode getOpCode()
  {
    return this.opCode;
  }
  
  public String getQuery()
  {
    return this.query;
  }
  
  public String getThreadName()
  {
    return this.threadName;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/InUseConnectionBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */