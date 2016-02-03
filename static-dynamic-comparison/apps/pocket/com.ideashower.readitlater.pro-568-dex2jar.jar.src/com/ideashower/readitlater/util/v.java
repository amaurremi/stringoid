package com.ideashower.readitlater.util;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class v
{
  public static URI a(String paramString)
  {
    try
    {
      paramString = new URL(paramString);
      return null;
    }
    catch (MalformedURLException paramString)
    {
      try
      {
        paramString = new URI(paramString.getProtocol(), paramString.getUserInfo(), paramString.getHost(), paramString.getPort(), paramString.getPath(), paramString.getQuery(), paramString.getRef());
        return paramString;
      }
      catch (URISyntaxException paramString)
      {
        e.a(paramString);
      }
      paramString = paramString;
      e.a(paramString);
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */