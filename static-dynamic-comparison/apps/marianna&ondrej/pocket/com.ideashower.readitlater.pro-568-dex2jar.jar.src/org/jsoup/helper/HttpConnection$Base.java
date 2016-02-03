package org.jsoup.helper;

import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jsoup.Connection.Base;
import org.jsoup.Connection.Method;

abstract class HttpConnection$Base
  implements Connection.Base
{
  Map cookies = new LinkedHashMap();
  Map headers = new LinkedHashMap();
  Connection.Method method;
  URL url;
  
  private String getHeaderCaseInsensitive(String paramString)
  {
    Validate.notNull(paramString, "Header name must not be null");
    Object localObject2 = (String)this.headers.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (String)this.headers.get(paramString.toLowerCase());
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      paramString = scanHeaders(paramString);
      localObject2 = localObject1;
      if (paramString != null) {
        localObject2 = (String)paramString.getValue();
      }
    }
    return (String)localObject2;
  }
  
  private Map.Entry scanHeaders(String paramString)
  {
    paramString = paramString.toLowerCase();
    Iterator localIterator = this.headers.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((String)localEntry.getKey()).toLowerCase().equals(paramString)) {
        return localEntry;
      }
    }
    return null;
  }
  
  public String cookie(String paramString)
  {
    Validate.notNull(paramString, "Cookie name must not be null");
    return (String)this.cookies.get(paramString);
  }
  
  public Connection.Base cookie(String paramString1, String paramString2)
  {
    Validate.notEmpty(paramString1, "Cookie name must not be empty");
    Validate.notNull(paramString2, "Cookie value must not be null");
    this.cookies.put(paramString1, paramString2);
    return this;
  }
  
  public Map cookies()
  {
    return this.cookies;
  }
  
  public boolean hasCookie(String paramString)
  {
    Validate.notEmpty("Cookie name must not be empty");
    return this.cookies.containsKey(paramString);
  }
  
  public boolean hasHeader(String paramString)
  {
    Validate.notEmpty(paramString, "Header name must not be empty");
    return getHeaderCaseInsensitive(paramString) != null;
  }
  
  public String header(String paramString)
  {
    Validate.notNull(paramString, "Header name must not be null");
    return getHeaderCaseInsensitive(paramString);
  }
  
  public Connection.Base header(String paramString1, String paramString2)
  {
    Validate.notEmpty(paramString1, "Header name must not be empty");
    Validate.notNull(paramString2, "Header value must not be null");
    removeHeader(paramString1);
    this.headers.put(paramString1, paramString2);
    return this;
  }
  
  public Map headers()
  {
    return this.headers;
  }
  
  public Connection.Base method(Connection.Method paramMethod)
  {
    Validate.notNull(paramMethod, "Method must not be null");
    this.method = paramMethod;
    return this;
  }
  
  public Connection.Method method()
  {
    return this.method;
  }
  
  public Connection.Base removeCookie(String paramString)
  {
    Validate.notEmpty("Cookie name must not be empty");
    this.cookies.remove(paramString);
    return this;
  }
  
  public Connection.Base removeHeader(String paramString)
  {
    Validate.notEmpty(paramString, "Header name must not be empty");
    paramString = scanHeaders(paramString);
    if (paramString != null) {
      this.headers.remove(paramString.getKey());
    }
    return this;
  }
  
  public URL url()
  {
    return this.url;
  }
  
  public Connection.Base url(URL paramURL)
  {
    Validate.notNull(paramURL, "URL must not be null");
    this.url = paramURL;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/helper/HttpConnection$Base.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */