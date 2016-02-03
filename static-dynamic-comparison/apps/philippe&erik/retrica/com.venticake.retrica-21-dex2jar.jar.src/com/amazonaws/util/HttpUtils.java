package com.amazonaws.util;

import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.org.apache.http.client.utils.URLEncodedUtils;
import com.amazonaws.org.apache.http.message.BasicNameValuePair;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpUtils
{
  private static final Pattern ENCODED_CHARACTERS_PATTERN;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Pattern.quote("+")).append("|").append(Pattern.quote("*")).append("|").append(Pattern.quote("%7E")).append("|").append(Pattern.quote("%2F"));
    ENCODED_CHARACTERS_PATTERN = Pattern.compile(localStringBuilder.toString());
  }
  
  public static String appendUri(String paramString1, String paramString2)
  {
    return appendUri(paramString1, paramString2, false);
  }
  
  public static String appendUri(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str;
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      if (paramString2.startsWith("/"))
      {
        str = paramString1;
        if (paramString1.endsWith("/")) {
          str = paramString1.substring(0, paramString1.length() - 1);
        }
        paramString2 = urlEncode(paramString2, true);
        paramString1 = paramString2;
        if (paramBoolean) {
          paramString1 = paramString2.replace("//", "/%2F");
        }
        paramString2 = str + paramString1;
      }
    }
    do
    {
      return paramString2;
      str = paramString1;
      if (paramString1.endsWith("/")) {
        break;
      }
      str = paramString1 + "/";
      break;
      paramString2 = paramString1;
    } while (paramString1.endsWith("/"));
    return paramString1 + "/";
  }
  
  public static String encodeParameters(Request<?> paramRequest)
  {
    ArrayList localArrayList;
    if (paramRequest.getParameters().size() > 0)
    {
      localArrayList = new ArrayList(paramRequest.getParameters().size());
      paramRequest = paramRequest.getParameters().entrySet().iterator();
      while (paramRequest.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramRequest.next();
        localArrayList.add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
      }
    }
    for (paramRequest = localArrayList;; paramRequest = null)
    {
      if (paramRequest != null) {
        return URLEncodedUtils.format(paramRequest, "UTF-8");
      }
      return null;
    }
  }
  
  public static boolean isUsingNonDefaultPort(URI paramURI)
  {
    String str = paramURI.getScheme().toLowerCase();
    int i = paramURI.getPort();
    if (i <= 0) {}
    while (((str.equals("http")) && (i == 80)) || ((str.equals("https")) && (i == 443))) {
      return false;
    }
    return true;
  }
  
  public static String urlEncode(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return "";
    }
    Matcher localMatcher;
    StringBuffer localStringBuffer;
    for (;;)
    {
      String str;
      try
      {
        paramString = URLEncoder.encode(paramString, "UTF-8");
        localMatcher = ENCODED_CHARACTERS_PATTERN.matcher(paramString);
        localStringBuffer = new StringBuffer(paramString.length());
        if (!localMatcher.find()) {
          break;
        }
        str = localMatcher.group(0);
        if ("+".equals(str))
        {
          paramString = "%20";
          localMatcher.appendReplacement(localStringBuffer, paramString);
          continue;
        }
        if (!"*".equals(str)) {
          break label96;
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new RuntimeException(paramString);
      }
      paramString = "%2A";
      continue;
      label96:
      if ("%7E".equals(str))
      {
        paramString = "~";
      }
      else
      {
        paramString = str;
        if (paramBoolean)
        {
          paramString = str;
          if ("%2F".equals(str)) {
            paramString = "/";
          }
        }
      }
    }
    localMatcher.appendTail(localStringBuffer);
    paramString = localStringBuffer.toString();
    return paramString;
  }
  
  public static boolean usePayloadForQueryParameters(Request<?> paramRequest)
  {
    boolean bool = HttpMethodName.POST.equals(paramRequest.getHttpMethod());
    if (paramRequest.getContent() == null) {}
    for (int i = 1; (bool) && (i != 0); i = 0) {
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/HttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */