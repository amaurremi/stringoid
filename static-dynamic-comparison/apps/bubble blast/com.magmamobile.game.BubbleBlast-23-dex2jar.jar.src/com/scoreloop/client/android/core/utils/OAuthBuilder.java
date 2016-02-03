package com.scoreloop.client.android.core.utils;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;

public class OAuthBuilder
{
  private final Random a = new Random();
  private String b;
  private URL c;
  private String d;
  private Map<String, String> e;
  private String f;
  
  private String a()
  {
    return Long.toString(this.a.nextLong());
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    paramString2 = c(paramString2);
    if (paramString3 != null) {}
    for (;;)
    {
      paramString2 = String.format("%s&%s", new Object[] { paramString2, paramString3 });
      try
      {
        paramString2 = paramString2.getBytes("UTF-8");
        paramString1 = paramString1.getBytes("UTF-8");
        return c(a(paramString1, paramString2));
      }
      catch (UnsupportedEncodingException paramString1)
      {
        throw new IllegalStateException(paramString1);
      }
      paramString3 = "";
    }
  }
  
  private static String a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, "HmacSHA1");
      Mac localMac = Mac.getInstance("HmacSHA1");
      localMac.init(paramArrayOfByte2);
      paramArrayOfByte1 = Base64.a(localMac.doFinal(paramArrayOfByte1));
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      throw new IllegalStateException("Failed to generate HMAC : " + paramArrayOfByte1.getMessage());
    }
  }
  
  private static List<String> a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      throw new IllegalArgumentException();
    }
    paramMap = new ArrayList(paramMap.keySet());
    Collections.sort(paramMap);
    return paramMap;
  }
  
  private String b()
  {
    return new Long(System.currentTimeMillis() / 1000L).toString();
  }
  
  private String c()
  {
    return this.d;
  }
  
  private static String c(String paramString)
  {
    return URLEncoder.encode(paramString);
  }
  
  private void c(String paramString1, String paramString2)
  {
    if ((d() == null) || (f() == null) || (c() == null)) {
      throw new IllegalArgumentException();
    }
    i();
    paramString1 = a(h(), paramString1, paramString2);
    Logger.a("signature", paramString1);
    this.e.put("oauth_signature", paramString1);
  }
  
  private String d()
  {
    return this.b;
  }
  
  private void d(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    if (this.b != null) {
      throw new IllegalStateException("must be called only once");
    }
    this.b = paramString.toUpperCase();
  }
  
  private Map<String, String> e()
  {
    return this.e;
  }
  
  private URL f()
  {
    return this.c;
  }
  
  private String g()
  {
    return this.f;
  }
  
  private String h()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(d());
    ((StringBuffer)localObject).append("&");
    ((StringBuffer)localObject).append(c(f().toString()));
    ((StringBuffer)localObject).append("&");
    Iterator localIterator = a(e()).iterator();
    for (int i = 1; localIterator.hasNext(); i = 0)
    {
      String str = (String)localIterator.next();
      if (i == 0) {
        ((StringBuffer)localObject).append("%26");
      }
      ((StringBuffer)localObject).append(c(str));
      ((StringBuffer)localObject).append("%3D");
      ((StringBuffer)localObject).append(c((String)e().get(str)));
    }
    localObject = ((StringBuffer)localObject).toString();
    Logger.a("signature base", (String)localObject);
    return (String)localObject;
  }
  
  private void i()
  {
    if (this.e != null) {
      throw new IllegalStateException("must be called only once");
    }
    this.e = new HashMap();
    this.e.put("oauth_consumer_key", c());
    this.e.put("oauth_nonce", a());
    this.e.put("oauth_signature_method", "HMAC-SHA1");
    this.e.put("oauth_timestamp", b());
    this.e.put("oauth_version", "1.0");
    if (g() != null) {
      this.e.put("oauth_token", g());
    }
  }
  
  public URL a(String paramString, Map<String, String> paramMap)
  {
    this.e = paramMap;
    paramMap = new StringBuffer();
    paramMap.append(paramString);
    paramString = a(e()).iterator();
    int i = 1;
    if (paramString.hasNext())
    {
      String str = (String)paramString.next();
      if (i != 0) {
        paramMap.append("?");
      }
      for (;;)
      {
        paramMap.append(str);
        paramMap.append("=");
        paramMap.append((String)e().get(str));
        i = 0;
        break;
        paramMap.append("&");
      }
    }
    try
    {
      paramString = new URL(paramMap.toString());
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  public HttpGet a(String paramString1, String paramString2)
  {
    d("get");
    c(paramString1, paramString2);
    paramString1 = a(f().toString(), e());
    try
    {
      paramString1 = new HttpGet(paramString1.toURI());
      return paramString1;
    }
    catch (URISyntaxException paramString1)
    {
      throw new IllegalStateException(paramString1);
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    if (this.d != null) {
      throw new IllegalStateException("must be called only once");
    }
    this.d = paramString;
  }
  
  public void a(URL paramURL)
  {
    if (paramURL == null) {
      throw new IllegalArgumentException();
    }
    if (this.c != null) {
      throw new IllegalStateException("must be called only once");
    }
    this.c = paramURL;
  }
  
  public HttpPut b(String paramString1, String paramString2)
  {
    d("put");
    c(paramString1, paramString2);
    paramString1 = a(f().toString(), e());
    try
    {
      paramString1 = new HttpPut(paramString1.toURI());
      return paramString1;
    }
    catch (URISyntaxException paramString1)
    {
      throw new IllegalStateException(paramString1);
    }
  }
  
  public void b(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    if (this.f != null) {
      throw new IllegalStateException("must be called only once");
    }
    this.f = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/utils/OAuthBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */