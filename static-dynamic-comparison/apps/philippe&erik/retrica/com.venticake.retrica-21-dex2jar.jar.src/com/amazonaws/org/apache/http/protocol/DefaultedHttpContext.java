package com.amazonaws.org.apache.http.protocol;

import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public final class DefaultedHttpContext
  implements HttpContext
{
  private final HttpContext defaults;
  private final HttpContext local;
  
  public DefaultedHttpContext(HttpContext paramHttpContext1, HttpContext paramHttpContext2)
  {
    if (paramHttpContext1 == null) {
      throw new IllegalArgumentException("HTTP context may not be null");
    }
    this.local = paramHttpContext1;
    this.defaults = paramHttpContext2;
  }
  
  public Object getAttribute(String paramString)
  {
    Object localObject2 = this.local.getAttribute(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.defaults.getAttribute(paramString);
    }
    return localObject1;
  }
  
  public void setAttribute(String paramString, Object paramObject)
  {
    this.local.setAttribute(paramString, paramObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[local: ").append(this.local);
    localStringBuilder.append("defaults: ").append(this.defaults);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/protocol/DefaultedHttpContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */