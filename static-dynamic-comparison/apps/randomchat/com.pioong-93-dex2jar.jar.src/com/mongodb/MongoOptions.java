package com.mongodb;

import javax.net.SocketFactory;

public class MongoOptions
{
  public boolean alwaysUseMBeans;
  public boolean autoConnectRetry;
  public int connectTimeout;
  public int connectionsPerHost;
  public boolean cursorFinalizerEnabled;
  public DBDecoderFactory dbDecoderFactory;
  public DBEncoderFactory dbEncoderFactory;
  public String description;
  public boolean fsync;
  public boolean j;
  public long maxAutoConnectRetryTime;
  public int maxWaitTime;
  public ReadPreference readPreference;
  public boolean safe;
  @Deprecated
  public boolean slaveOk;
  public SocketFactory socketFactory;
  public boolean socketKeepAlive;
  public int socketTimeout;
  public int threadsAllowedToBlockForConnectionMultiplier;
  public int w;
  public WriteConcern writeConcern;
  public int wtimeout;
  
  @Deprecated
  public MongoOptions()
  {
    reset();
  }
  
  @Deprecated
  public MongoOptions(MongoClientOptions paramMongoClientOptions)
  {
    this.connectionsPerHost = paramMongoClientOptions.getConnectionsPerHost();
    this.threadsAllowedToBlockForConnectionMultiplier = paramMongoClientOptions.getThreadsAllowedToBlockForConnectionMultiplier();
    this.maxWaitTime = paramMongoClientOptions.getMaxWaitTime();
    this.connectTimeout = paramMongoClientOptions.getConnectTimeout();
    this.socketTimeout = paramMongoClientOptions.getSocketTimeout();
    this.socketKeepAlive = paramMongoClientOptions.isSocketKeepAlive();
    this.autoConnectRetry = paramMongoClientOptions.isAutoConnectRetry();
    this.maxAutoConnectRetryTime = paramMongoClientOptions.getMaxAutoConnectRetryTime();
    this.readPreference = paramMongoClientOptions.getReadPreference();
    this.dbDecoderFactory = paramMongoClientOptions.getDbDecoderFactory();
    this.dbEncoderFactory = paramMongoClientOptions.getDbEncoderFactory();
    this.socketFactory = paramMongoClientOptions.getSocketFactory();
    this.description = paramMongoClientOptions.getDescription();
    this.cursorFinalizerEnabled = paramMongoClientOptions.isCursorFinalizerEnabled();
    this.writeConcern = paramMongoClientOptions.getWriteConcern();
    this.slaveOk = false;
  }
  
  public MongoOptions copy()
  {
    MongoOptions localMongoOptions = new MongoOptions();
    localMongoOptions.connectionsPerHost = this.connectionsPerHost;
    localMongoOptions.threadsAllowedToBlockForConnectionMultiplier = this.threadsAllowedToBlockForConnectionMultiplier;
    localMongoOptions.maxWaitTime = this.maxWaitTime;
    localMongoOptions.connectTimeout = this.connectTimeout;
    localMongoOptions.socketTimeout = this.socketTimeout;
    localMongoOptions.socketKeepAlive = this.socketKeepAlive;
    localMongoOptions.autoConnectRetry = this.autoConnectRetry;
    localMongoOptions.maxAutoConnectRetryTime = this.maxAutoConnectRetryTime;
    localMongoOptions.slaveOk = this.slaveOk;
    localMongoOptions.readPreference = this.readPreference;
    localMongoOptions.safe = this.safe;
    localMongoOptions.w = this.w;
    localMongoOptions.wtimeout = this.wtimeout;
    localMongoOptions.fsync = this.fsync;
    localMongoOptions.j = this.j;
    localMongoOptions.dbDecoderFactory = this.dbDecoderFactory;
    localMongoOptions.dbEncoderFactory = this.dbEncoderFactory;
    localMongoOptions.socketFactory = this.socketFactory;
    localMongoOptions.description = this.description;
    localMongoOptions.cursorFinalizerEnabled = this.cursorFinalizerEnabled;
    localMongoOptions.alwaysUseMBeans = this.alwaysUseMBeans;
    return localMongoOptions;
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
      paramObject = (MongoOptions)paramObject;
      if (this.autoConnectRetry != ((MongoOptions)paramObject).autoConnectRetry) {
        return false;
      }
      if (this.connectTimeout != ((MongoOptions)paramObject).connectTimeout) {
        return false;
      }
      if (this.connectionsPerHost != ((MongoOptions)paramObject).connectionsPerHost) {
        return false;
      }
      if (this.cursorFinalizerEnabled != ((MongoOptions)paramObject).cursorFinalizerEnabled) {
        return false;
      }
      if (this.fsync != ((MongoOptions)paramObject).fsync) {
        return false;
      }
      if (this.j != ((MongoOptions)paramObject).j) {
        return false;
      }
      if (this.maxAutoConnectRetryTime != ((MongoOptions)paramObject).maxAutoConnectRetryTime) {
        return false;
      }
      if (this.maxWaitTime != ((MongoOptions)paramObject).maxWaitTime) {
        return false;
      }
      if (this.safe != ((MongoOptions)paramObject).safe) {
        return false;
      }
      if (this.slaveOk != ((MongoOptions)paramObject).slaveOk) {
        return false;
      }
      if (this.socketKeepAlive != ((MongoOptions)paramObject).socketKeepAlive) {
        return false;
      }
      if (this.socketTimeout != ((MongoOptions)paramObject).socketTimeout) {
        return false;
      }
      if (this.threadsAllowedToBlockForConnectionMultiplier != ((MongoOptions)paramObject).threadsAllowedToBlockForConnectionMultiplier) {
        return false;
      }
      if (this.w != ((MongoOptions)paramObject).w) {
        return false;
      }
      if (this.wtimeout != ((MongoOptions)paramObject).wtimeout) {
        return false;
      }
      if (this.dbDecoderFactory != null)
      {
        if (this.dbDecoderFactory.equals(((MongoOptions)paramObject).dbDecoderFactory)) {}
      }
      else {
        while (((MongoOptions)paramObject).dbDecoderFactory != null) {
          return false;
        }
      }
      if (this.dbEncoderFactory != null)
      {
        if (this.dbEncoderFactory.equals(((MongoOptions)paramObject).dbEncoderFactory)) {}
      }
      else {
        while (((MongoOptions)paramObject).dbEncoderFactory != null) {
          return false;
        }
      }
      if (this.description != null)
      {
        if (this.description.equals(((MongoOptions)paramObject).description)) {}
      }
      else {
        while (((MongoOptions)paramObject).description != null) {
          return false;
        }
      }
      if (this.readPreference != null)
      {
        if (this.readPreference.equals(((MongoOptions)paramObject).readPreference)) {}
      }
      else {
        while (((MongoOptions)paramObject).readPreference != null) {
          return false;
        }
      }
      if (this.socketFactory != null)
      {
        if (this.socketFactory.equals(((MongoOptions)paramObject).socketFactory)) {}
      }
      else {
        while (((MongoOptions)paramObject).socketFactory != null) {
          return false;
        }
      }
      if (this.writeConcern == null) {
        break;
      }
    } while (this.writeConcern.equals(((MongoOptions)paramObject).writeConcern));
    for (;;)
    {
      return false;
      if (((MongoOptions)paramObject).writeConcern == null) {
        break;
      }
    }
  }
  
  public int getConnectTimeout()
  {
    try
    {
      int i = this.connectTimeout;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getConnectionsPerHost()
  {
    try
    {
      int i = this.connectionsPerHost;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public DBDecoderFactory getDbDecoderFactory()
  {
    try
    {
      DBDecoderFactory localDBDecoderFactory = this.dbDecoderFactory;
      return localDBDecoderFactory;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public DBEncoderFactory getDbEncoderFactory()
  {
    try
    {
      DBEncoderFactory localDBEncoderFactory = this.dbEncoderFactory;
      return localDBEncoderFactory;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getDescription()
  {
    try
    {
      String str = this.description;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getMaxAutoConnectRetryTime()
  {
    try
    {
      long l = this.maxAutoConnectRetryTime;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getMaxWaitTime()
  {
    try
    {
      int i = this.maxWaitTime;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public ReadPreference getReadPreference()
  {
    return this.readPreference;
  }
  
  public SocketFactory getSocketFactory()
  {
    try
    {
      SocketFactory localSocketFactory = this.socketFactory;
      return localSocketFactory;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getSocketTimeout()
  {
    try
    {
      int i = this.socketTimeout;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getThreadsAllowedToBlockForConnectionMultiplier()
  {
    try
    {
      int i = this.threadsAllowedToBlockForConnectionMultiplier;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getW()
  {
    try
    {
      int i = this.w;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public WriteConcern getWriteConcern()
  {
    if (this.writeConcern != null) {
      return this.writeConcern;
    }
    if ((this.w != 0) || (this.wtimeout != 0) || ((this.fsync | this.j))) {
      return new WriteConcern(this.w, this.wtimeout, this.fsync, this.j);
    }
    if (this.safe) {
      return WriteConcern.SAFE;
    }
    return WriteConcern.NORMAL;
  }
  
  public int getWtimeout()
  {
    try
    {
      int i = this.wtimeout;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int hashCode()
  {
    int i8 = 1;
    int i9 = 0;
    int i;
    int i10;
    int i11;
    int i12;
    int i13;
    int i14;
    int k;
    label60:
    int m;
    label69:
    int i15;
    int n;
    label94:
    int i1;
    label110:
    int i2;
    label126:
    int i3;
    label142:
    int i4;
    label152:
    int i16;
    int i17;
    int i5;
    label174:
    int i6;
    label184:
    int i7;
    if (this.description != null)
    {
      i = this.description.hashCode();
      i10 = this.connectionsPerHost;
      i11 = this.threadsAllowedToBlockForConnectionMultiplier;
      i12 = this.maxWaitTime;
      i13 = this.connectTimeout;
      i14 = this.socketTimeout;
      if (!this.socketKeepAlive) {
        break label348;
      }
      k = 1;
      if (!this.autoConnectRetry) {
        break label353;
      }
      m = 1;
      i15 = (int)(this.maxAutoConnectRetryTime ^ this.maxAutoConnectRetryTime >>> 32);
      if (!this.slaveOk) {
        break label358;
      }
      n = 1;
      if (this.readPreference == null) {
        break label364;
      }
      i1 = this.readPreference.hashCode();
      if (this.dbDecoderFactory == null) {
        break label370;
      }
      i2 = this.dbDecoderFactory.hashCode();
      if (this.dbEncoderFactory == null) {
        break label376;
      }
      i3 = this.dbEncoderFactory.hashCode();
      if (!this.safe) {
        break label382;
      }
      i4 = 1;
      i16 = this.w;
      i17 = this.wtimeout;
      if (!this.fsync) {
        break label388;
      }
      i5 = 1;
      if (!this.j) {
        break label394;
      }
      i6 = 1;
      if (this.socketFactory == null) {
        break label400;
      }
      i7 = this.socketFactory.hashCode();
      label200:
      if (!this.cursorFinalizerEnabled) {
        break label406;
      }
    }
    for (;;)
    {
      if (this.writeConcern != null) {
        i9 = this.writeConcern.hashCode();
      }
      return (((((((((((((((((((i * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + k) * 31 + m) * 31 + i15) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i16) * 31 + i17) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9;
      i = 0;
      break;
      label348:
      k = 0;
      break label60;
      label353:
      m = 0;
      break label69;
      label358:
      n = 0;
      break label94;
      label364:
      i1 = 0;
      break label110;
      label370:
      i2 = 0;
      break label126;
      label376:
      i3 = 0;
      break label142;
      label382:
      i4 = 0;
      break label152;
      label388:
      i5 = 0;
      break label174;
      label394:
      i6 = 0;
      break label184;
      label400:
      i7 = 0;
      break label200;
      label406:
      i8 = 0;
    }
  }
  
  public boolean isAlwaysUseMBeans()
  {
    return this.alwaysUseMBeans;
  }
  
  public boolean isAutoConnectRetry()
  {
    try
    {
      boolean bool = this.autoConnectRetry;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isCursorFinalizerEnabled()
  {
    return this.cursorFinalizerEnabled;
  }
  
  public boolean isFsync()
  {
    try
    {
      boolean bool = this.fsync;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isJ()
  {
    try
    {
      boolean bool = this.j;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isSafe()
  {
    try
    {
      boolean bool = this.safe;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isSocketKeepAlive()
  {
    try
    {
      boolean bool = this.socketKeepAlive;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void reset()
  {
    this.connectionsPerHost = Bytes.CONNECTIONS_PER_HOST;
    this.threadsAllowedToBlockForConnectionMultiplier = 5;
    this.maxWaitTime = 120000;
    this.connectTimeout = 10000;
    this.socketTimeout = 0;
    this.socketKeepAlive = false;
    this.autoConnectRetry = false;
    this.maxAutoConnectRetryTime = 0L;
    this.slaveOk = false;
    this.readPreference = null;
    this.safe = false;
    this.w = 0;
    this.wtimeout = 0;
    this.fsync = false;
    this.j = false;
    this.dbDecoderFactory = DefaultDBDecoder.FACTORY;
    this.dbEncoderFactory = DefaultDBEncoder.FACTORY;
    this.socketFactory = SocketFactory.getDefault();
    this.description = null;
    this.cursorFinalizerEnabled = true;
    this.alwaysUseMBeans = false;
  }
  
  public void setAlwaysUseMBeans(boolean paramBoolean)
  {
    this.alwaysUseMBeans = paramBoolean;
  }
  
  public void setAutoConnectRetry(boolean paramBoolean)
  {
    try
    {
      this.autoConnectRetry = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setConnectTimeout(int paramInt)
  {
    try
    {
      this.connectTimeout = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setConnectionsPerHost(int paramInt)
  {
    try
    {
      this.connectionsPerHost = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setCursorFinalizerEnabled(boolean paramBoolean)
  {
    this.cursorFinalizerEnabled = paramBoolean;
  }
  
  public void setDbDecoderFactory(DBDecoderFactory paramDBDecoderFactory)
  {
    try
    {
      this.dbDecoderFactory = paramDBDecoderFactory;
      return;
    }
    finally
    {
      paramDBDecoderFactory = finally;
      throw paramDBDecoderFactory;
    }
  }
  
  public void setDbEncoderFactory(DBEncoderFactory paramDBEncoderFactory)
  {
    try
    {
      this.dbEncoderFactory = paramDBEncoderFactory;
      return;
    }
    finally
    {
      paramDBEncoderFactory = finally;
      throw paramDBEncoderFactory;
    }
  }
  
  public void setDescription(String paramString)
  {
    try
    {
      this.description = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setFsync(boolean paramBoolean)
  {
    try
    {
      this.fsync = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setJ(boolean paramBoolean)
  {
    try
    {
      this.j = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setMaxAutoConnectRetryTime(long paramLong)
  {
    try
    {
      this.maxAutoConnectRetryTime = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setMaxWaitTime(int paramInt)
  {
    try
    {
      this.maxWaitTime = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setReadPreference(ReadPreference paramReadPreference)
  {
    this.readPreference = paramReadPreference;
  }
  
  public void setSafe(boolean paramBoolean)
  {
    try
    {
      this.safe = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setSocketFactory(SocketFactory paramSocketFactory)
  {
    try
    {
      this.socketFactory = paramSocketFactory;
      return;
    }
    finally
    {
      paramSocketFactory = finally;
      throw paramSocketFactory;
    }
  }
  
  public void setSocketKeepAlive(boolean paramBoolean)
  {
    try
    {
      this.socketKeepAlive = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setSocketTimeout(int paramInt)
  {
    try
    {
      this.socketTimeout = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setThreadsAllowedToBlockForConnectionMultiplier(int paramInt)
  {
    try
    {
      this.threadsAllowedToBlockForConnectionMultiplier = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setW(int paramInt)
  {
    try
    {
      this.w = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setWriteConcern(WriteConcern paramWriteConcern)
  {
    this.writeConcern = paramWriteConcern;
  }
  
  public void setWtimeout(int paramInt)
  {
    try
    {
      this.wtimeout = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String toString()
  {
    return "MongoOptions{description='" + this.description + '\'' + ", connectionsPerHost=" + this.connectionsPerHost + ", threadsAllowedToBlockForConnectionMultiplier=" + this.threadsAllowedToBlockForConnectionMultiplier + ", maxWaitTime=" + this.maxWaitTime + ", connectTimeout=" + this.connectTimeout + ", socketTimeout=" + this.socketTimeout + ", socketKeepAlive=" + this.socketKeepAlive + ", autoConnectRetry=" + this.autoConnectRetry + ", maxAutoConnectRetryTime=" + this.maxAutoConnectRetryTime + ", slaveOk=" + this.slaveOk + ", readPreference=" + this.readPreference + ", dbDecoderFactory=" + this.dbDecoderFactory + ", dbEncoderFactory=" + this.dbEncoderFactory + ", safe=" + this.safe + ", w=" + this.w + ", wtimeout=" + this.wtimeout + ", fsync=" + this.fsync + ", j=" + this.j + ", socketFactory=" + this.socketFactory + ", cursorFinalizerEnabled=" + this.cursorFinalizerEnabled + ", writeConcern=" + this.writeConcern + ", alwaysUseMBeans=" + this.alwaysUseMBeans + '}';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/MongoOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */