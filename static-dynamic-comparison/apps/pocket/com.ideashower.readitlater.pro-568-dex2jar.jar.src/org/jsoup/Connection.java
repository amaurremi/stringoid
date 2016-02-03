package org.jsoup;

import java.net.URL;
import java.util.Map;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

public abstract interface Connection
{
  public abstract Connection cookie(String paramString1, String paramString2);
  
  public abstract Connection cookies(Map paramMap);
  
  public abstract Connection data(String paramString1, String paramString2);
  
  public abstract Connection data(Map paramMap);
  
  public abstract Connection data(String... paramVarArgs);
  
  public abstract Connection.Response execute();
  
  public abstract Connection followRedirects(boolean paramBoolean);
  
  public abstract Document get();
  
  public abstract Connection header(String paramString1, String paramString2);
  
  public abstract Connection ignoreContentType(boolean paramBoolean);
  
  public abstract Connection ignoreHttpErrors(boolean paramBoolean);
  
  public abstract Connection maxBodySize(int paramInt);
  
  public abstract Connection method(Connection.Method paramMethod);
  
  public abstract Connection parser(Parser paramParser);
  
  public abstract Document post();
  
  public abstract Connection referrer(String paramString);
  
  public abstract Connection.Request request();
  
  public abstract Connection request(Connection.Request paramRequest);
  
  public abstract Connection.Response response();
  
  public abstract Connection response(Connection.Response paramResponse);
  
  public abstract Connection timeout(int paramInt);
  
  public abstract Connection url(String paramString);
  
  public abstract Connection url(URL paramURL);
  
  public abstract Connection userAgent(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/Connection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */