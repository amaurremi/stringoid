package com.mongodb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bson.util.annotations.ThreadSafe;

@ThreadSafe
class MongoCredentialsStore
{
  private volatile Set<String> allDatabasesWithCredentials = new HashSet();
  private final Map<String, MongoCredential> credentialsMap = new HashMap();
  
  public MongoCredentialsStore() {}
  
  public MongoCredentialsStore(MongoCredential paramMongoCredential)
  {
    if (paramMongoCredential == null) {
      return;
    }
    add(paramMongoCredential);
  }
  
  public MongoCredentialsStore(Iterable<MongoCredential> paramIterable)
  {
    if (paramIterable == null) {}
    for (;;)
    {
      return;
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        add((MongoCredential)paramIterable.next());
      }
    }
  }
  
  void add(MongoCredential paramMongoCredential)
  {
    for (;;)
    {
      try
      {
        MongoCredential localMongoCredential = (MongoCredential)this.credentialsMap.get(paramMongoCredential.getSource());
        if (localMongoCredential != null)
        {
          boolean bool = localMongoCredential.equals(paramMongoCredential);
          if (bool) {
            return;
          }
          throw new IllegalArgumentException("Can't add more than one credentials for the same database");
        }
      }
      finally {}
      this.credentialsMap.put(paramMongoCredential.getSource(), paramMongoCredential);
      this.allDatabasesWithCredentials = new HashSet(this.allDatabasesWithCredentials);
      this.allDatabasesWithCredentials.add(paramMongoCredential.getSource());
    }
  }
  
  public List<MongoCredential> asList()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.credentialsMap.values());
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    if (this == paramObject) {}
    for (;;)
    {
      return bool1;
      if (paramObject != null) {
        try
        {
          if (getClass() == paramObject.getClass())
          {
            paramObject = (MongoCredentialsStore)paramObject;
            boolean bool2 = this.credentialsMap.equals(((MongoCredentialsStore)paramObject).credentialsMap);
            if (bool2) {
              continue;
            }
            bool1 = false;
            continue;
          }
        }
        finally {}
      } else {
        bool1 = false;
      }
    }
  }
  
  public MongoCredential get(String paramString)
  {
    try
    {
      paramString = (MongoCredential)this.credentialsMap.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Set<String> getDatabases()
  {
    return Collections.unmodifiableSet(this.allDatabasesWithCredentials);
  }
  
  public int hashCode()
  {
    try
    {
      int i = this.credentialsMap.hashCode();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String toString()
  {
    return "{credentials=" + this.credentialsMap + '}';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/MongoCredentialsStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */