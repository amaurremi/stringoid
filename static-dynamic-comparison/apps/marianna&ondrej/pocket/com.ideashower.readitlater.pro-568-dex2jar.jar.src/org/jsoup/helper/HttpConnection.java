package org.jsoup.helper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Request;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

public class HttpConnection
  implements Connection
{
  private Connection.Request req = new HttpConnection.Request(null);
  private Connection.Response res = new HttpConnection.Response();
  
  public static Connection connect(String paramString)
  {
    HttpConnection localHttpConnection = new HttpConnection();
    localHttpConnection.url(paramString);
    return localHttpConnection;
  }
  
  public static Connection connect(URL paramURL)
  {
    HttpConnection localHttpConnection = new HttpConnection();
    localHttpConnection.url(paramURL);
    return localHttpConnection;
  }
  
  public Connection cookie(String paramString1, String paramString2)
  {
    this.req.cookie(paramString1, paramString2);
    return this;
  }
  
  public Connection cookies(Map paramMap)
  {
    Validate.notNull(paramMap, "Cookie map must not be null");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      this.req.cookie((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    return this;
  }
  
  public Connection data(String paramString1, String paramString2)
  {
    this.req.data(HttpConnection.KeyVal.create(paramString1, paramString2));
    return this;
  }
  
  public Connection data(Map paramMap)
  {
    Validate.notNull(paramMap, "Data map must not be null");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      this.req.data(HttpConnection.KeyVal.create((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    return this;
  }
  
  public Connection data(String... paramVarArgs)
  {
    int i = 0;
    Validate.notNull(paramVarArgs, "Data key value pairs must not be null");
    if (paramVarArgs.length % 2 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Validate.isTrue(bool, "Must supply an even number of key value pairs");
      while (i < paramVarArgs.length)
      {
        String str1 = paramVarArgs[i];
        String str2 = paramVarArgs[(i + 1)];
        Validate.notEmpty(str1, "Data key must not be empty");
        Validate.notNull(str2, "Data value must not be null");
        this.req.data(HttpConnection.KeyVal.create(str1, str2));
        i += 2;
      }
    }
    return this;
  }
  
  public Connection.Response execute()
  {
    this.res = HttpConnection.Response.execute(this.req);
    return this.res;
  }
  
  public Connection followRedirects(boolean paramBoolean)
  {
    this.req.followRedirects(paramBoolean);
    return this;
  }
  
  public Document get()
  {
    this.req.method(Connection.Method.GET);
    execute();
    return this.res.parse();
  }
  
  public Connection header(String paramString1, String paramString2)
  {
    this.req.header(paramString1, paramString2);
    return this;
  }
  
  public Connection ignoreContentType(boolean paramBoolean)
  {
    this.req.ignoreContentType(paramBoolean);
    return this;
  }
  
  public Connection ignoreHttpErrors(boolean paramBoolean)
  {
    this.req.ignoreHttpErrors(paramBoolean);
    return this;
  }
  
  public Connection maxBodySize(int paramInt)
  {
    this.req.maxBodySize(paramInt);
    return this;
  }
  
  public Connection method(Connection.Method paramMethod)
  {
    this.req.method(paramMethod);
    return this;
  }
  
  public Connection parser(Parser paramParser)
  {
    this.req.parser(paramParser);
    return this;
  }
  
  public Document post()
  {
    this.req.method(Connection.Method.POST);
    execute();
    return this.res.parse();
  }
  
  public Connection referrer(String paramString)
  {
    Validate.notNull(paramString, "Referrer must not be null");
    this.req.header("Referer", paramString);
    return this;
  }
  
  public Connection.Request request()
  {
    return this.req;
  }
  
  public Connection request(Connection.Request paramRequest)
  {
    this.req = paramRequest;
    return this;
  }
  
  public Connection.Response response()
  {
    return this.res;
  }
  
  public Connection response(Connection.Response paramResponse)
  {
    this.res = paramResponse;
    return this;
  }
  
  public Connection timeout(int paramInt)
  {
    this.req.timeout(paramInt);
    return this;
  }
  
  public Connection url(String paramString)
  {
    Validate.notEmpty(paramString, "Must supply a valid URL");
    try
    {
      this.req.url(new URL(paramString));
      return this;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new IllegalArgumentException("Malformed URL: " + paramString, localMalformedURLException);
    }
  }
  
  public Connection url(URL paramURL)
  {
    this.req.url(paramURL);
    return this;
  }
  
  public Connection userAgent(String paramString)
  {
    Validate.notNull(paramString, "User agent must not be null");
    this.req.header("User-Agent", paramString);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/helper/HttpConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */