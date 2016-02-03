package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.cookie.CookieAttributeHandler;
import com.amazonaws.org.apache.http.cookie.CookieSpec;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public abstract class AbstractCookieSpec
  implements CookieSpec
{
  private final Map<String, CookieAttributeHandler> attribHandlerMap = new HashMap(10);
  
  protected CookieAttributeHandler findAttribHandler(String paramString)
  {
    return (CookieAttributeHandler)this.attribHandlerMap.get(paramString);
  }
  
  protected Collection<CookieAttributeHandler> getAttribHandlers()
  {
    return this.attribHandlerMap.values();
  }
  
  public void registerAttribHandler(String paramString, CookieAttributeHandler paramCookieAttributeHandler)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Attribute name may not be null");
    }
    if (paramCookieAttributeHandler == null) {
      throw new IllegalArgumentException("Attribute handler may not be null");
    }
    this.attribHandlerMap.put(paramString, paramCookieAttributeHandler);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/AbstractCookieSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */