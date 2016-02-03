package com.tapjoy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class TapjoyURLConnection
{
  private static final String TAG = "TapjoyURLConnection";
  public static final int TYPE_GET = 0;
  public static final int TYPE_POST = 1;
  public static boolean unitTestMode = false;
  
  public String getContentLength(String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = paramString.replaceAll(" ", "%20");
      TapjoyLog.i("TapjoyURLConnection", "requestURL: " + paramString);
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setConnectTimeout(15000);
      paramString.setReadTimeout(30000);
      paramString = paramString.getHeaderField("content-length");
      TapjoyLog.i("TapjoyURLConnection", "content-length: " + paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        TapjoyLog.e("TapjoyURLConnection", "Exception: " + paramString.toString());
        paramString = (String)localObject;
      }
    }
  }
  
  public TapjoyHttpURLResponse getRedirectFromURL(String paramString)
  {
    return getResponseFromURL(paramString, "", 0, true);
  }
  
  public TapjoyHttpURLResponse getResponseFromURL(String paramString)
  {
    return getResponseFromURL(paramString, "", 0);
  }
  
  public TapjoyHttpURLResponse getResponseFromURL(String paramString1, String paramString2)
  {
    return getResponseFromURL(paramString1, paramString2, 0);
  }
  
  public TapjoyHttpURLResponse getResponseFromURL(String paramString1, String paramString2, int paramInt)
  {
    return getResponseFromURL(paramString1, paramString2, 0, false);
  }
  
  public TapjoyHttpURLResponse getResponseFromURL(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    localTapjoyHttpURLResponse = new TapjoyHttpURLResponse();
    Object localObject8 = null;
    Object localObject5 = null;
    Object localObject7 = null;
    Object localObject9 = null;
    String str = null;
    Object localObject6 = null;
    localObject1 = localObject8;
    Object localObject2 = localObject7;
    Object localObject4 = str;
    for (;;)
    {
      try
      {
        paramString2 = paramString1 + paramString2;
        localObject1 = localObject8;
        localObject2 = localObject7;
        localObject4 = str;
        StringBuilder localStringBuilder = new StringBuilder().append("http ");
        if (paramInt != 0) {
          continue;
        }
        paramString1 = "get";
        localObject1 = localObject8;
        localObject2 = localObject7;
        localObject4 = str;
        TapjoyLog.i("TapjoyURLConnection", paramString1 + ": " + paramString2);
        localObject1 = localObject8;
        localObject2 = localObject7;
        localObject4 = str;
        if (!unitTestMode) {
          continue;
        }
        localObject1 = localObject8;
        localObject2 = localObject7;
        localObject4 = str;
        paramString1 = new DefaultHttpClient();
        if (paramInt != 1) {
          continue;
        }
        localObject1 = localObject8;
        localObject2 = localObject7;
        localObject4 = str;
        paramString1 = paramString1.execute(new HttpPost(paramString2));
        localObject1 = localObject8;
        localObject2 = localObject7;
        localObject4 = str;
        localTapjoyHttpURLResponse.statusCode = paramString1.getStatusLine().getStatusCode();
        localObject1 = localObject8;
        localObject2 = localObject7;
        localObject4 = str;
        paramString1 = new BufferedReader(new InputStreamReader(paramString1.getEntity().getContent()));
        paramString2 = (String)localObject5;
        localObject5 = localObject6;
        if (paramBoolean) {
          continue;
        }
        localObject1 = paramString2;
        localObject2 = paramString1;
        localObject4 = str;
        localObject5 = new StringBuilder();
        try
        {
          localObject1 = paramString1.readLine();
          if (localObject1 == null) {
            continue;
          }
          ((StringBuilder)localObject5).append((String)localObject1 + '\n');
          continue;
          TapjoyLog.e("TapjoyURLConnection", "Exception: " + paramString1.toString());
        }
        catch (Exception localException1)
        {
          localObject4 = localObject5;
          localObject1 = paramString1;
          paramString1 = localException1;
        }
      }
      catch (Exception paramString1)
      {
        paramString2 = (String)localObject1;
        localObject1 = localObject3;
        continue;
        localTapjoyHttpURLResponse.response = paramString2.toString();
        continue;
        continue;
        continue;
      }
      if (paramString2 == null) {
        continue;
      }
      try
      {
        if (localTapjoyHttpURLResponse.response != null) {
          continue;
        }
        paramString1 = new BufferedReader(new InputStreamReader(paramString2.getErrorStream()));
      }
      catch (Exception paramString1)
      {
        Object localObject3;
        continue;
      }
      try
      {
        paramString2 = new StringBuilder();
        try
        {
          localObject1 = paramString1.readLine();
          if (localObject1 == null) {
            continue;
          }
          paramString2.append((String)localObject1 + '\n');
          continue;
          TapjoyLog.e("TapjoyURLConnection", "Exception trying to get error code/content: " + paramString1.toString());
        }
        catch (Exception paramString1) {}
      }
      catch (Exception paramString1)
      {
        continue;
      }
      TapjoyLog.i("TapjoyURLConnection", "--------------------");
      TapjoyLog.i("TapjoyURLConnection", "response status: " + localTapjoyHttpURLResponse.statusCode);
      TapjoyLog.i("TapjoyURLConnection", "response size: " + localTapjoyHttpURLResponse.contentLength);
      TapjoyLog.v("TapjoyURLConnection", "response: ");
      TapjoyLog.v("TapjoyURLConnection", "" + localTapjoyHttpURLResponse.response);
      if ((localTapjoyHttpURLResponse.redirectURL != null) && (localTapjoyHttpURLResponse.redirectURL.length() > 0)) {
        TapjoyLog.i("TapjoyURLConnection", "redirectURL: " + localTapjoyHttpURLResponse.redirectURL);
      }
      TapjoyLog.i("TapjoyURLConnection", "--------------------");
      return localTapjoyHttpURLResponse;
      paramString1 = "post";
      continue;
      localObject1 = localObject8;
      localObject3 = localObject7;
      localObject4 = str;
      paramString1 = paramString1.execute(new HttpGet(paramString2));
      continue;
      localObject1 = localObject8;
      localObject3 = localObject7;
      localObject4 = str;
      localObject5 = (HttpURLConnection)new URL(paramString2).openConnection();
      if (paramBoolean)
      {
        localObject1 = localObject5;
        localObject3 = localObject7;
        localObject4 = str;
        ((HttpURLConnection)localObject5).setInstanceFollowRedirects(false);
      }
      localObject1 = localObject5;
      localObject3 = localObject7;
      localObject4 = str;
      ((HttpURLConnection)localObject5).setConnectTimeout(15000);
      localObject1 = localObject5;
      localObject3 = localObject7;
      localObject4 = str;
      ((HttpURLConnection)localObject5).setReadTimeout(30000);
      if (paramInt == 1)
      {
        localObject1 = localObject5;
        localObject3 = localObject7;
        localObject4 = str;
        ((HttpURLConnection)localObject5).setRequestMethod("POST");
      }
      localObject1 = localObject5;
      localObject3 = localObject7;
      localObject4 = str;
      ((HttpURLConnection)localObject5).connect();
      localObject1 = localObject5;
      localObject3 = localObject7;
      localObject4 = str;
      localTapjoyHttpURLResponse.statusCode = ((HttpURLConnection)localObject5).getResponseCode();
      paramString2 = (String)localObject5;
      paramString1 = (String)localObject9;
      if (!paramBoolean)
      {
        localObject1 = localObject5;
        localObject3 = localObject7;
        localObject4 = str;
        paramString1 = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject5).getInputStream()));
        paramString2 = (String)localObject5;
      }
    }
    localTapjoyHttpURLResponse.response = ((StringBuilder)localObject5).toString();
    localObject1 = paramString2;
    localObject3 = paramString1;
    localObject4 = localObject5;
    if (localTapjoyHttpURLResponse.statusCode == 302)
    {
      localObject1 = paramString2;
      localObject3 = paramString1;
      localObject4 = localObject5;
      localTapjoyHttpURLResponse.redirectURL = paramString2.getHeaderField("Location");
    }
    localObject1 = paramString2;
    localObject3 = paramString1;
    localObject4 = localObject5;
    str = paramString2.getHeaderField("content-length");
    if (str != null) {}
    try
    {
      localTapjoyHttpURLResponse.contentLength = Integer.valueOf(str).intValue();
      if (paramString1 != null)
      {
        localObject1 = paramString2;
        localObject3 = paramString1;
        localObject4 = localObject5;
        paramString1.close();
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        localObject1 = paramString2;
        localObject3 = paramString1;
        localObject4 = localObject5;
        TapjoyLog.e("TapjoyURLConnection", "Exception: " + localException2.toString());
      }
    }
  }
  
  public TapjoyHttpURLResponse getResponseFromURL(String paramString, Map<String, String> paramMap)
  {
    return getResponseFromURL(paramString, TapjoyUtil.convertURLParams(paramMap, false), 0);
  }
  
  public TapjoyHttpURLResponse getResponseFromURL(String paramString, Map<String, String> paramMap, int paramInt)
  {
    return getResponseFromURL(paramString, TapjoyUtil.convertURLParams(paramMap, false), paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TapjoyURLConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */