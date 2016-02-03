package com.mongodb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class ConnectionStatus
{
  protected static final DBObject isMasterCmd;
  protected static final float latencySmoothFactor = Float.parseFloat(System.getProperty("com.mongodb.latencySmoothFactor", "4"));
  protected static final MongoOptions mongoOptionsDefaults = new MongoOptions();
  protected static int updaterIntervalMS;
  protected static int updaterIntervalNoMasterMS;
  protected volatile boolean _closed;
  protected final Mongo _mongo;
  protected final MongoOptions _mongoOptions = mongoOptionsDefaults.copy();
  protected final List<ServerAddress> _mongosAddresses;
  protected BackgroundUpdater _updater;
  
  static
  {
    isMasterCmd = new BasicDBObject("ismaster", Integer.valueOf(1));
    updaterIntervalMS = Integer.parseInt(System.getProperty("com.mongodb.updaterIntervalMS", "5000"));
    updaterIntervalNoMasterMS = Integer.parseInt(System.getProperty("com.mongodb.updaterIntervalNoMasterMS", "10"));
    mongoOptionsDefaults.connectTimeout = Integer.parseInt(System.getProperty("com.mongodb.updaterConnectTimeoutMS", "20000"));
    mongoOptionsDefaults.socketTimeout = Integer.parseInt(System.getProperty("com.mongodb.updaterSocketTimeoutMS", "20000"));
  }
  
  ConnectionStatus(List<ServerAddress> paramList, Mongo paramMongo)
  {
    this._mongoOptions.socketFactory = paramMongo._options.socketFactory;
    this._mongosAddresses = new ArrayList(paramList);
    this._mongo = paramMongo;
  }
  
  void checkClosed()
  {
    if (this._closed) {
      throw new IllegalStateException("ReplicaSetStatus closed");
    }
  }
  
  void close()
  {
    this._closed = true;
    if (this._updater != null) {
      this._updater.interrupt();
    }
  }
  
  abstract Node ensureMaster();
  
  abstract List<ServerAddress> getServerAddressList();
  
  abstract boolean hasServerUp();
  
  void start()
  {
    if (this._updater != null) {
      this._updater.start();
    }
  }
  
  static class BackgroundUpdater
    extends Thread
  {
    public BackgroundUpdater(String paramString)
    {
      super();
      setDaemon(true);
    }
  }
  
  static class Node
  {
    protected final ServerAddress _addr;
    protected final int _maxBsonObjectSize;
    protected final boolean _ok;
    protected final float _pingTime;
    
    Node(float paramFloat, ServerAddress paramServerAddress, int paramInt, boolean paramBoolean)
    {
      this._pingTime = paramFloat;
      this._addr = paramServerAddress;
      this._maxBsonObjectSize = paramInt;
      this._ok = paramBoolean;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (Node)paramObject;
        if (this._maxBsonObjectSize != ((Node)paramObject)._maxBsonObjectSize) {
          return false;
        }
        if (this._ok != ((Node)paramObject)._ok) {
          return false;
        }
        if (Float.compare(((Node)paramObject)._pingTime, this._pingTime) != 0) {
          return false;
        }
      } while (this._addr.equals(((Node)paramObject)._addr));
      return false;
    }
    
    public int getMaxBsonObjectSize()
    {
      return this._maxBsonObjectSize;
    }
    
    public ServerAddress getServerAddress()
    {
      return this._addr;
    }
    
    public int hashCode()
    {
      int j = 0;
      int k = this._addr.hashCode();
      if (this._pingTime != 0.0F) {}
      for (int i = Float.floatToIntBits(this._pingTime);; i = 0)
      {
        if (this._ok) {
          j = 1;
        }
        return ((k * 31 + i) * 31 + j) * 31 + this._maxBsonObjectSize;
      }
    }
    
    public boolean isOk()
    {
      return this._ok;
    }
    
    public String toJSON()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append("address:'").append(this._addr).append("', ");
      localStringBuilder.append("ok:").append(this._ok).append(", ");
      localStringBuilder.append("ping:").append(this._pingTime).append(", ");
      localStringBuilder.append("maxBsonObjectSize:").append(this._maxBsonObjectSize).append(", ");
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
  
  static abstract class UpdatableNode
  {
    final ServerAddress _addr;
    int _maxBsonObjectSize;
    final Mongo _mongo;
    final MongoOptions _mongoOptions;
    boolean _ok = false;
    float _pingTimeMS = 0.0F;
    DBPort _port;
    boolean successfullyContacted = false;
    
    UpdatableNode(ServerAddress paramServerAddress, Mongo paramMongo, MongoOptions paramMongoOptions)
    {
      this._addr = paramServerAddress;
      this._mongo = paramMongo;
      this._mongoOptions = paramMongoOptions;
      this._port = new DBPort(paramServerAddress, null, paramMongoOptions);
    }
    
    protected abstract Logger getLogger();
    
    public CommandResult update()
    {
      CommandResult localCommandResult = null;
      Object localObject = localCommandResult;
      float f;
      try
      {
        long l = System.nanoTime();
        localObject = localCommandResult;
        localCommandResult = this._port.runCommand(this._mongo.getDB("admin"), ConnectionStatus.isMasterCmd);
        localObject = localCommandResult;
        f = (float)(System.nanoTime() - l) / 1000000.0F;
        localObject = localCommandResult;
        if (this.successfullyContacted) {
          break label253;
        }
        localObject = localCommandResult;
        this._pingTimeMS = f;
        localObject = localCommandResult;
        getLogger().log(Level.FINE, "Latency to " + this._addr + " actual=" + f + " smoothed=" + this._pingTimeMS);
        localObject = localCommandResult;
        this.successfullyContacted = true;
        if (localCommandResult != null) {
          break label279;
        }
        localObject = localCommandResult;
        throw new MongoInternalException("Invalid null value returned from isMaster");
      }
      catch (Exception localException)
      {
        if (!this._ok) {
          break label394;
        }
      }
      label164:
      StringBuilder localStringBuilder = new StringBuilder("Server seen down: ").append(this._addr);
      if ((localException instanceof IOException))
      {
        localStringBuilder.append(" - ").append(IOException.class.getName());
        if (localException.getMessage() != null) {
          localStringBuilder.append(" - message: ").append(localException.getMessage());
        }
        getLogger().log(Level.WARNING, localStringBuilder.toString());
      }
      for (;;)
      {
        this._ok = false;
        for (;;)
        {
          return (CommandResult)localObject;
          label253:
          localObject = localException;
          this._pingTimeMS += (f - this._pingTimeMS) / ConnectionStatus.latencySmoothFactor;
          break;
          label279:
          localObject = localException;
          if (!this._ok)
          {
            localObject = localException;
            getLogger().log(Level.INFO, "Server seen up: " + this._addr);
          }
          localObject = localException;
          this._ok = true;
          localObject = localException;
          if (localException.containsField("maxBsonObjectSize"))
          {
            localObject = localException;
            this._maxBsonObjectSize = ((Integer)localException.get("maxBsonObjectSize")).intValue();
            localObject = localException;
          }
          else
          {
            localObject = localException;
            this._maxBsonObjectSize = 4194304;
            localObject = localException;
          }
        }
        label394:
        if (Math.random() > 0.1D) {
          break label164;
        }
        return (CommandResult)localObject;
        getLogger().log(Level.WARNING, localStringBuilder.toString(), localException);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/ConnectionStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */