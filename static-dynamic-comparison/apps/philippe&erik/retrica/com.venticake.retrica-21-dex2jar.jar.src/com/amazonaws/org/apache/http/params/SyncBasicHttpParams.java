package com.amazonaws.org.apache.http.params;

import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public class SyncBasicHttpParams
  extends BasicHttpParams
{
  public Object clone()
  {
    try
    {
      Object localObject1 = super.clone();
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public Object getParameter(String paramString)
  {
    try
    {
      paramString = super.getParameter(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public HttpParams setParameter(String paramString, Object paramObject)
  {
    try
    {
      paramString = super.setParameter(paramString, paramObject);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/params/SyncBasicHttpParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */