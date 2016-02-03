package com.mongodb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.bson.util.annotations.Immutable;

@Immutable
class MongoAuthority
{
  private final MongoCredentialsStore credentialsStore;
  private final List<ServerAddress> serverAddresses;
  private final Type type;
  
  private MongoAuthority(ServerAddress paramServerAddress, MongoCredentialsStore paramMongoCredentialsStore)
  {
    if (paramServerAddress == null) {
      throw new IllegalArgumentException("serverAddress can not be null");
    }
    if (paramMongoCredentialsStore == null) {
      throw new IllegalArgumentException("credentialsStore can not be null");
    }
    this.serverAddresses = Arrays.asList(new ServerAddress[] { paramServerAddress });
    this.credentialsStore = paramMongoCredentialsStore;
    this.type = Type.Direct;
  }
  
  private MongoAuthority(List<ServerAddress> paramList, Type paramType, MongoCredentialsStore paramMongoCredentialsStore)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("serverAddresses can not be null");
    }
    if (paramMongoCredentialsStore == null) {
      throw new IllegalArgumentException("credentialsStore can not be null");
    }
    if (paramType == null) {
      throw new IllegalArgumentException("type can not be null");
    }
    if (paramType == Type.Direct) {
      throw new IllegalArgumentException("type can not be Direct with a list of server addresses");
    }
    this.type = paramType;
    this.serverAddresses = new ArrayList(paramList);
    this.credentialsStore = paramMongoCredentialsStore;
  }
  
  public static MongoAuthority direct(ServerAddress paramServerAddress)
  {
    return direct(paramServerAddress, (MongoCredential)null);
  }
  
  public static MongoAuthority direct(ServerAddress paramServerAddress, MongoCredential paramMongoCredential)
  {
    return direct(paramServerAddress, new MongoCredentialsStore(paramMongoCredential));
  }
  
  public static MongoAuthority direct(ServerAddress paramServerAddress, MongoCredentialsStore paramMongoCredentialsStore)
  {
    return new MongoAuthority(paramServerAddress, paramMongoCredentialsStore);
  }
  
  public static MongoAuthority dynamicSet(List<ServerAddress> paramList)
  {
    return dynamicSet(paramList, (MongoCredential)null);
  }
  
  public static MongoAuthority dynamicSet(List<ServerAddress> paramList, MongoCredential paramMongoCredential)
  {
    return dynamicSet(paramList, new MongoCredentialsStore(paramMongoCredential));
  }
  
  public static MongoAuthority dynamicSet(List<ServerAddress> paramList, MongoCredentialsStore paramMongoCredentialsStore)
  {
    return new MongoAuthority(paramList, Type.Set, paramMongoCredentialsStore);
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
      paramObject = (MongoAuthority)paramObject;
      if (!this.credentialsStore.equals(((MongoAuthority)paramObject).credentialsStore)) {
        return false;
      }
      if (!this.serverAddresses.equals(((MongoAuthority)paramObject).serverAddresses)) {
        return false;
      }
    } while (this.type == ((MongoAuthority)paramObject).type);
    return false;
  }
  
  public MongoCredentialsStore getCredentialsStore()
  {
    return this.credentialsStore;
  }
  
  public List<ServerAddress> getServerAddresses()
  {
    if (this.serverAddresses == null) {
      return null;
    }
    return Collections.unmodifiableList(this.serverAddresses);
  }
  
  public Type getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    return (this.credentialsStore.hashCode() * 31 + this.serverAddresses.hashCode()) * 31 + this.type.hashCode();
  }
  
  public String toString()
  {
    return "MongoAuthority{type=" + this.type + ", serverAddresses=" + this.serverAddresses + ", credentials=" + this.credentialsStore + '}';
  }
  
  static enum Type
  {
    Direct,  Set;
    
    private Type() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/MongoAuthority.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */