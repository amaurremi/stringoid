package com.mongodb;

import javax.net.SocketFactory;
import org.bson.util.annotations.Immutable;

@Immutable
public class MongoClientOptions
{
  private final boolean alwaysUseMBeans;
  private final boolean autoConnectRetry;
  private final int connectTimeout;
  private final int connectionsPerHost;
  private final boolean cursorFinalizerEnabled;
  private final DBDecoderFactory dbDecoderFactory;
  private final DBEncoderFactory dbEncoderFactory;
  private final String description;
  private final long maxAutoConnectRetryTime;
  private final int maxWaitTime;
  private final ReadPreference readPreference;
  private final SocketFactory socketFactory;
  private final boolean socketKeepAlive;
  private final int socketTimeout;
  private final int threadsAllowedToBlockForConnectionMultiplier;
  private final WriteConcern writeConcern;
  
  private MongoClientOptions(Builder paramBuilder)
  {
    this.description = paramBuilder.description;
    this.connectionsPerHost = paramBuilder.connectionsPerHost;
    this.threadsAllowedToBlockForConnectionMultiplier = paramBuilder.threadsAllowedToBlockForConnectionMultiplier;
    this.maxWaitTime = paramBuilder.maxWaitTime;
    this.connectTimeout = paramBuilder.connectTimeout;
    this.socketTimeout = paramBuilder.socketTimeout;
    this.autoConnectRetry = paramBuilder.autoConnectRetry;
    this.socketKeepAlive = paramBuilder.socketKeepAlive;
    this.maxAutoConnectRetryTime = paramBuilder.maxAutoConnectRetryTime;
    this.readPreference = paramBuilder.readPreference;
    this.dbDecoderFactory = paramBuilder.dbDecoderFactory;
    this.dbEncoderFactory = paramBuilder.dbEncoderFactory;
    this.writeConcern = paramBuilder.writeConcern;
    this.socketFactory = paramBuilder.socketFactory;
    this.cursorFinalizerEnabled = paramBuilder.cursorFinalizerEnabled;
    this.alwaysUseMBeans = paramBuilder.alwaysUseMBeans;
  }
  
  public static Builder builder()
  {
    return new Builder();
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
      paramObject = (MongoClientOptions)paramObject;
      if (this.alwaysUseMBeans != ((MongoClientOptions)paramObject).alwaysUseMBeans) {
        return false;
      }
      if (this.autoConnectRetry != ((MongoClientOptions)paramObject).autoConnectRetry) {
        return false;
      }
      if (this.connectTimeout != ((MongoClientOptions)paramObject).connectTimeout) {
        return false;
      }
      if (this.connectionsPerHost != ((MongoClientOptions)paramObject).connectionsPerHost) {
        return false;
      }
      if (this.cursorFinalizerEnabled != ((MongoClientOptions)paramObject).cursorFinalizerEnabled) {
        return false;
      }
      if (this.maxAutoConnectRetryTime != ((MongoClientOptions)paramObject).maxAutoConnectRetryTime) {
        return false;
      }
      if (this.maxWaitTime != ((MongoClientOptions)paramObject).maxWaitTime) {
        return false;
      }
      if (this.socketKeepAlive != ((MongoClientOptions)paramObject).socketKeepAlive) {
        return false;
      }
      if (this.socketTimeout != ((MongoClientOptions)paramObject).socketTimeout) {
        return false;
      }
      if (this.threadsAllowedToBlockForConnectionMultiplier != ((MongoClientOptions)paramObject).threadsAllowedToBlockForConnectionMultiplier) {
        return false;
      }
      if (!this.dbDecoderFactory.equals(((MongoClientOptions)paramObject).dbDecoderFactory)) {
        return false;
      }
      if (!this.dbEncoderFactory.equals(((MongoClientOptions)paramObject).dbEncoderFactory)) {
        return false;
      }
      if (this.description != null)
      {
        if (this.description.equals(((MongoClientOptions)paramObject).description)) {}
      }
      else {
        while (((MongoClientOptions)paramObject).description != null) {
          return false;
        }
      }
      if (!this.readPreference.equals(((MongoClientOptions)paramObject).readPreference)) {
        return false;
      }
      if (!this.socketFactory.getClass().equals(((MongoClientOptions)paramObject).socketFactory.getClass())) {
        return false;
      }
    } while (this.writeConcern.equals(((MongoClientOptions)paramObject).writeConcern));
    return false;
  }
  
  public int getConnectTimeout()
  {
    return this.connectTimeout;
  }
  
  public int getConnectionsPerHost()
  {
    return this.connectionsPerHost;
  }
  
  public DBDecoderFactory getDbDecoderFactory()
  {
    return this.dbDecoderFactory;
  }
  
  public DBEncoderFactory getDbEncoderFactory()
  {
    return this.dbEncoderFactory;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public long getMaxAutoConnectRetryTime()
  {
    return this.maxAutoConnectRetryTime;
  }
  
  public int getMaxWaitTime()
  {
    return this.maxWaitTime;
  }
  
  public ReadPreference getReadPreference()
  {
    return this.readPreference;
  }
  
  public SocketFactory getSocketFactory()
  {
    return this.socketFactory;
  }
  
  public int getSocketTimeout()
  {
    return this.socketTimeout;
  }
  
  public int getThreadsAllowedToBlockForConnectionMultiplier()
  {
    return this.threadsAllowedToBlockForConnectionMultiplier;
  }
  
  public WriteConcern getWriteConcern()
  {
    return this.writeConcern;
  }
  
  public int hashCode()
  {
    int n = 1;
    int i;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int j;
    label57:
    int k;
    label66:
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int m;
    if (this.description != null)
    {
      i = this.description.hashCode();
      i1 = this.connectionsPerHost;
      i2 = this.threadsAllowedToBlockForConnectionMultiplier;
      i3 = this.maxWaitTime;
      i4 = this.connectTimeout;
      i5 = this.socketTimeout;
      if (!this.socketKeepAlive) {
        break label238;
      }
      j = 1;
      if (!this.autoConnectRetry) {
        break label243;
      }
      k = 1;
      i6 = (int)(this.maxAutoConnectRetryTime ^ this.maxAutoConnectRetryTime >>> 32);
      i7 = this.readPreference.hashCode();
      i8 = this.dbDecoderFactory.hashCode();
      i9 = this.dbEncoderFactory.hashCode();
      i10 = this.writeConcern.hashCode();
      i11 = this.socketFactory.hashCode();
      if (!this.cursorFinalizerEnabled) {
        break label248;
      }
      m = 1;
      label136:
      if (!this.alwaysUseMBeans) {
        break label254;
      }
    }
    for (;;)
    {
      return ((((((((((((((i * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + j) * 31 + k) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + m) * 31 + n;
      i = 0;
      break;
      label238:
      j = 0;
      break label57;
      label243:
      k = 0;
      break label66;
      label248:
      m = 0;
      break label136;
      label254:
      n = 0;
    }
  }
  
  public boolean isAlwaysUseMBeans()
  {
    return this.alwaysUseMBeans;
  }
  
  public boolean isAutoConnectRetry()
  {
    return this.autoConnectRetry;
  }
  
  public boolean isCursorFinalizerEnabled()
  {
    return this.cursorFinalizerEnabled;
  }
  
  public boolean isSocketKeepAlive()
  {
    return this.socketKeepAlive;
  }
  
  public static class Builder
  {
    private boolean alwaysUseMBeans = false;
    private boolean autoConnectRetry = false;
    private int connectTimeout = 10000;
    private int connectionsPerHost = 100;
    private boolean cursorFinalizerEnabled = true;
    private DBDecoderFactory dbDecoderFactory = DefaultDBDecoder.FACTORY;
    private DBEncoderFactory dbEncoderFactory = DefaultDBEncoder.FACTORY;
    private String description;
    private long maxAutoConnectRetryTime = 0L;
    private int maxWaitTime = 120000;
    private ReadPreference readPreference = ReadPreference.primary();
    private SocketFactory socketFactory = SocketFactory.getDefault();
    private boolean socketKeepAlive = false;
    private int socketTimeout = 0;
    private int threadsAllowedToBlockForConnectionMultiplier = 5;
    private WriteConcern writeConcern = WriteConcern.ACKNOWLEDGED;
    
    public Builder alwaysUseMBeans(boolean paramBoolean)
    {
      this.alwaysUseMBeans = paramBoolean;
      return this;
    }
    
    public Builder autoConnectRetry(boolean paramBoolean)
    {
      this.autoConnectRetry = paramBoolean;
      return this;
    }
    
    public MongoClientOptions build()
    {
      return new MongoClientOptions(this, null);
    }
    
    public Builder connectTimeout(int paramInt)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException("Minimum value is 0");
      }
      this.connectTimeout = paramInt;
      return this;
    }
    
    public Builder connectionsPerHost(int paramInt)
    {
      if (paramInt < 1) {
        throw new IllegalArgumentException("Minimum value is 1");
      }
      this.connectionsPerHost = paramInt;
      return this;
    }
    
    public Builder cursorFinalizerEnabled(boolean paramBoolean)
    {
      this.cursorFinalizerEnabled = paramBoolean;
      return this;
    }
    
    public Builder dbDecoderFactory(DBDecoderFactory paramDBDecoderFactory)
    {
      if (paramDBDecoderFactory == null) {
        throw new IllegalArgumentException("null is not a legal value");
      }
      this.dbDecoderFactory = paramDBDecoderFactory;
      return this;
    }
    
    public Builder dbEncoderFactory(DBEncoderFactory paramDBEncoderFactory)
    {
      if (paramDBEncoderFactory == null) {
        throw new IllegalArgumentException("null is not a legal value");
      }
      this.dbEncoderFactory = paramDBEncoderFactory;
      return this;
    }
    
    public Builder description(String paramString)
    {
      this.description = paramString;
      return this;
    }
    
    public Builder legacyDefaults()
    {
      this.connectionsPerHost = 10;
      this.writeConcern = WriteConcern.NORMAL;
      return this;
    }
    
    public Builder maxAutoConnectRetryTime(long paramLong)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("Minimum value is 0");
      }
      this.maxAutoConnectRetryTime = paramLong;
      return this;
    }
    
    public Builder maxWaitTime(int paramInt)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException("Minimum value is 0");
      }
      this.maxWaitTime = paramInt;
      return this;
    }
    
    public Builder readPreference(ReadPreference paramReadPreference)
    {
      if (paramReadPreference == null) {
        throw new IllegalArgumentException("null is not a legal value");
      }
      this.readPreference = paramReadPreference;
      return this;
    }
    
    public Builder socketFactory(SocketFactory paramSocketFactory)
    {
      if (paramSocketFactory == null) {
        throw new IllegalArgumentException("null is not a legal value");
      }
      this.socketFactory = paramSocketFactory;
      return this;
    }
    
    public Builder socketKeepAlive(boolean paramBoolean)
    {
      this.socketKeepAlive = paramBoolean;
      return this;
    }
    
    public Builder socketTimeout(int paramInt)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException("Minimum value is 0");
      }
      this.socketTimeout = paramInt;
      return this;
    }
    
    public Builder threadsAllowedToBlockForConnectionMultiplier(int paramInt)
    {
      if (paramInt < 1) {
        throw new IllegalArgumentException("Minimum value is 1");
      }
      this.threadsAllowedToBlockForConnectionMultiplier = paramInt;
      return this;
    }
    
    public Builder writeConcern(WriteConcern paramWriteConcern)
    {
      if (paramWriteConcern == null) {
        throw new IllegalArgumentException("null is not a legal value");
      }
      this.writeConcern = paramWriteConcern;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/MongoClientOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */