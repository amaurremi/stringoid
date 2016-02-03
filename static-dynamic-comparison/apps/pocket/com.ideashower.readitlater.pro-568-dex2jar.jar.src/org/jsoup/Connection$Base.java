package org.jsoup;

import java.net.URL;
import java.util.Map;

public abstract interface Connection$Base
{
  public abstract String cookie(String paramString);
  
  public abstract Base cookie(String paramString1, String paramString2);
  
  public abstract Map cookies();
  
  public abstract boolean hasCookie(String paramString);
  
  public abstract boolean hasHeader(String paramString);
  
  public abstract String header(String paramString);
  
  public abstract Base header(String paramString1, String paramString2);
  
  public abstract Map headers();
  
  public abstract Base method(Connection.Method paramMethod);
  
  public abstract Connection.Method method();
  
  public abstract Base removeCookie(String paramString);
  
  public abstract Base removeHeader(String paramString);
  
  public abstract URL url();
  
  public abstract Base url(URL paramURL);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/Connection$Base.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */