package com.amazonaws.org.apache.http.protocol;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class BasicHttpContext
  implements HttpContext
{
  private Map<String, Object> map = null;
  private final HttpContext parentContext;
  
  public BasicHttpContext()
  {
    this(null);
  }
  
  public BasicHttpContext(HttpContext paramHttpContext)
  {
    this.parentContext = paramHttpContext;
  }
  
  public Object getAttribute(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Id may not be null");
    }
    Object localObject1 = null;
    if (this.map != null) {
      localObject1 = this.map.get(paramString);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.parentContext != null) {
        localObject2 = this.parentContext.getAttribute(paramString);
      }
    }
    return localObject2;
  }
  
  public void setAttribute(String paramString, Object paramObject)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Id may not be null");
    }
    if (this.map == null) {
      this.map = new HashMap();
    }
    this.map.put(paramString, paramObject);
  }
  
  public String toString()
  {
    if (this.map != null) {
      return this.map.toString();
    }
    return "{}";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/protocol/BasicHttpContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */