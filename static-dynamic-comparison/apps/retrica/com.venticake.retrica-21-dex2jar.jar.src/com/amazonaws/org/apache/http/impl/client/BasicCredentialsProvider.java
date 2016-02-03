package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.auth.AuthScope;
import com.amazonaws.org.apache.http.auth.Credentials;
import com.amazonaws.org.apache.http.client.CredentialsProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public class BasicCredentialsProvider
  implements CredentialsProvider
{
  private final ConcurrentHashMap<AuthScope, Credentials> credMap = new ConcurrentHashMap();
  
  private static Credentials matchCredentials(Map<AuthScope, Credentials> paramMap, AuthScope paramAuthScope)
  {
    Credentials localCredentials = (Credentials)paramMap.get(paramAuthScope);
    Object localObject2 = localCredentials;
    Object localObject1;
    if (localCredentials == null)
    {
      int i = -1;
      localObject1 = null;
      Iterator localIterator = paramMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (AuthScope)localIterator.next();
        int j = paramAuthScope.match((AuthScope)localObject2);
        if (j <= i) {
          break label107;
        }
        i = j;
        localObject1 = localObject2;
      }
    }
    label107:
    for (;;)
    {
      break;
      localObject2 = localCredentials;
      if (localObject1 != null) {
        localObject2 = (Credentials)paramMap.get(localObject1);
      }
      return (Credentials)localObject2;
    }
  }
  
  public Credentials getCredentials(AuthScope paramAuthScope)
  {
    if (paramAuthScope == null) {
      throw new IllegalArgumentException("Authentication scope may not be null");
    }
    return matchCredentials(this.credMap, paramAuthScope);
  }
  
  public void setCredentials(AuthScope paramAuthScope, Credentials paramCredentials)
  {
    if (paramAuthScope == null) {
      throw new IllegalArgumentException("Authentication scope may not be null");
    }
    this.credMap.put(paramAuthScope, paramCredentials);
  }
  
  public String toString()
  {
    return this.credMap.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/BasicCredentialsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */