package com.google.api.client.util.a;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class a
{
  private static final b aej = new c("-_.*", true);
  private static final b aek = new c("-_.!~*'()@:$&,;=", false);
  private static final b ael = new c("-_.!~*'():$&,;=", false);
  private static final b aem = new c("-_.!~*'()@:$,;/?:", false);
  
  public static String cu(String paramString)
  {
    return aej.cz(paramString);
  }
  
  public static String cv(String paramString)
  {
    try
    {
      paramString = URLDecoder.decode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public static String cw(String paramString)
  {
    return aek.cz(paramString);
  }
  
  public static String cx(String paramString)
  {
    return ael.cz(paramString);
  }
  
  public static String cy(String paramString)
  {
    return aem.cz(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */