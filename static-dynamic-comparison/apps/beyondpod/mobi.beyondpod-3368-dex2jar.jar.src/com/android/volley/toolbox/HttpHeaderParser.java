package com.android.volley.toolbox;

import com.android.volley.Cache.Entry;
import com.android.volley.NetworkResponse;
import java.util.Date;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class HttpHeaderParser
{
  public static Cache.Entry parseCacheHeaders(NetworkResponse paramNetworkResponse)
  {
    long l6 = System.currentTimeMillis();
    Map localMap = paramNetworkResponse.headers;
    long l2 = 0L;
    long l4 = 0L;
    long l5 = 0L;
    long l1 = 0L;
    int i = 0;
    Object localObject1 = (String)localMap.get("Date");
    if (localObject1 != null) {
      l2 = parseDateAsEpoch((String)localObject1);
    }
    localObject1 = (String)localMap.get("Cache-Control");
    long l3 = l1;
    if (localObject1 != null)
    {
      int j = 1;
      localObject1 = ((String)localObject1).split(",");
      i = 0;
      if (i >= localObject1.length)
      {
        l3 = l1;
        i = j;
      }
    }
    else
    {
      localObject1 = (String)localMap.get("Expires");
      if (localObject1 != null) {
        l4 = parseDateAsEpoch((String)localObject1);
      }
      localObject1 = (String)localMap.get("ETag");
      if (i == 0) {
        break label297;
      }
      l1 = l6 + 1000L * l3;
    }
    for (;;)
    {
      Object localObject2 = new Cache.Entry();
      ((Cache.Entry)localObject2).data = paramNetworkResponse.data;
      ((Cache.Entry)localObject2).etag = ((String)localObject1);
      ((Cache.Entry)localObject2).softTtl = l1;
      ((Cache.Entry)localObject2).ttl = ((Cache.Entry)localObject2).softTtl;
      ((Cache.Entry)localObject2).serverDate = l2;
      ((Cache.Entry)localObject2).responseHeaders = localMap;
      return (Cache.Entry)localObject2;
      localObject2 = localObject1[i].trim();
      if ((((String)localObject2).equals("no-cache")) || (((String)localObject2).equals("no-store"))) {
        return null;
      }
      if (((String)localObject2).startsWith("max-age=")) {}
      for (;;)
      {
        try
        {
          l3 = Long.parseLong(((String)localObject2).substring(8));
          l1 = l3;
        }
        catch (Exception localException)
        {
          continue;
        }
        i += 1;
        break;
        if ((((String)localObject2).equals("must-revalidate")) || (((String)localObject2).equals("proxy-revalidate"))) {
          l1 = 0L;
        }
      }
      label297:
      l1 = l5;
      if (l2 > 0L)
      {
        l1 = l5;
        if (l4 >= l2) {
          l1 = l6 + (l4 - l2);
        }
      }
    }
  }
  
  public static String parseCharset(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("Content-Type");
    int i;
    if (paramMap != null)
    {
      paramMap = paramMap.split(";");
      i = 1;
    }
    for (;;)
    {
      if (i >= paramMap.length) {
        return "ISO-8859-1";
      }
      String[] arrayOfString = paramMap[i].trim().split("=");
      if ((arrayOfString.length == 2) && (arrayOfString[0].equals("charset"))) {
        return arrayOfString[1];
      }
      i += 1;
    }
  }
  
  public static long parseDateAsEpoch(String paramString)
  {
    try
    {
      long l = DateUtils.parseDate(paramString).getTime();
      return l;
    }
    catch (DateParseException paramString) {}
    return 0L;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/android/volley/toolbox/HttpHeaderParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */