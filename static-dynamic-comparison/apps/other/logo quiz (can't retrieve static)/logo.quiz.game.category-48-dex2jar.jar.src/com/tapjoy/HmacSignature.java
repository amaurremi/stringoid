package com.tapjoy;

import android.net.Uri;
import android.util.Log;
import java.security.Key;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSignature
{
  private String _method;
  private String _secret;
  
  public HmacSignature(String paramString1, String paramString2)
  {
    this._method = paramString1;
    this._secret = paramString2;
  }
  
  private String prepareMessage(String paramString, Map<String, String> paramMap)
  {
    Uri localUri = Uri.parse(paramString);
    String str = localUri.getScheme() + "://" + localUri.getHost();
    if (((localUri.getScheme().equals("http")) && (localUri.getPort() == 80)) || ((localUri.getScheme().equals("https")) && (localUri.getPort() == 443))) {}
    for (int i = 1;; i = 0)
    {
      paramString = str;
      if (i == 0)
      {
        paramString = str;
        if (-1 != localUri.getPort()) {
          paramString = str + ":" + localUri.getPort();
        }
      }
      paramString = paramString.toLowerCase();
      paramString = paramString + localUri.getPath();
      paramMap = prepareParams(paramMap);
      paramString = "POST&" + Uri.encode(paramString) + "&" + Uri.encode(paramMap);
      Log.v("HmacSignature", "Base Url: " + paramString);
      return paramString;
    }
  }
  
  private String prepareParams(Map<String, String> paramMap)
  {
    Object localObject = new TreeSet(paramMap.keySet());
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((TreeSet)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = (String)paramMap.get(str1);
      localStringBuilder.append(str1 + "=" + str2 + "&");
    }
    localStringBuilder.deleteCharAt(localStringBuilder.lastIndexOf("&"));
    Log.v("HmacSignature", "Unhashed String: " + localStringBuilder.toString());
    return localStringBuilder.toString();
  }
  
  public boolean matches(String paramString1, Map<String, String> paramMap, String paramString2)
  {
    return sign(paramString1, paramMap).equals(paramString2);
  }
  
  public String sign(String paramString, Map<String, String> paramMap)
  {
    try
    {
      Object localObject = new SecretKeySpec(this._secret.getBytes(), this._method);
      Mac localMac = Mac.getInstance(this._method);
      localMac.init((Key)localObject);
      paramString = localMac.doFinal(prepareMessage(paramString, paramMap).getBytes());
      paramMap = new StringBuilder();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localObject = Integer.toHexString(paramString[i] & 0xFF);
        if (((String)localObject).length() == 1) {
          paramMap.append('0');
        }
        paramMap.append((String)localObject);
        i += 1;
      }
      paramString = paramMap.toString();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/HmacSignature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */