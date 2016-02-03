package com.adfonic.android.api;

import android.os.Handler;
import com.adfonic.android.api.request.AndroidRequest;
import com.adfonic.android.api.request.UriRequestAdapter;
import com.adfonic.android.api.response.ApiResponse;
import com.adfonic.android.utils.Log;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;

class RequestRunnable
  implements Runnable
{
  private static final int CONNECTION_TIMEOUT = 20000;
  private static final int READ_TIMEOUT = 20000;
  private static final String USER_AGENT = "User-Agent";
  private final ExecutorCallback callback;
  private final Handler handler;
  private final AndroidRequest request;
  
  public RequestRunnable(AndroidRequest paramAndroidRequest, ExecutorCallback paramExecutorCallback, Handler paramHandler)
  {
    this.request = paramAndroidRequest;
    this.callback = paramExecutorCallback;
    if (paramHandler == null)
    {
      this.handler = new Handler();
      return;
    }
    this.handler = paramHandler;
  }
  
  private void closeSilently(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  private ApiResponse execute()
    throws IOException, JSONException
  {
    InputStream localInputStream = null;
    fixLeakProblemForOldVersionsOfAndroid(this.request.getAndroidSdkVersion());
    Object localObject1 = localInputStream;
    StringBuilder localStringBuilder;
    try
    {
      localObject2 = new UriRequestAdapter(this.request).toUrl();
      localObject1 = localInputStream;
      logRequest((String)localObject2);
      localObject1 = localInputStream;
      localObject2 = (HttpURLConnection)new URL((String)localObject2).openConnection();
      localObject1 = localInputStream;
      ((HttpURLConnection)localObject2).setConnectTimeout(20000);
      localObject1 = localInputStream;
      ((HttpURLConnection)localObject2).setReadTimeout(20000);
      localObject1 = localInputStream;
      ((HttpURLConnection)localObject2).setRequestProperty("User-Agent", this.request.getUserAgent());
      localObject1 = localInputStream;
      localInputStream = ((HttpURLConnection)localObject2).getInputStream();
      localObject1 = localInputStream;
      localObject2 = new BufferedReader(new InputStreamReader(localInputStream));
      localObject1 = localInputStream;
      localStringBuilder = new StringBuilder();
      for (;;)
      {
        localObject1 = localInputStream;
        String str = ((BufferedReader)localObject2).readLine();
        if (str == null) {
          break;
        }
        localObject1 = localInputStream;
        localStringBuilder.append(str);
      }
      localObject1 = localCloseable;
    }
    finally
    {
      closeSilently((Closeable)localObject1);
      closeSilently(null);
    }
    Object localObject2 = new ApiResponse().handleResponse(localStringBuilder.toString());
    closeSilently(localCloseable);
    closeSilently(null);
    return (ApiResponse)localObject2;
  }
  
  private void fixLeakProblemForOldVersionsOfAndroid(int paramInt)
  {
    if (paramInt >= 8) {
      return;
    }
    System.setProperty("http.keepAlive", "false");
  }
  
  private void logRequest(String paramString)
  {
    if (Log.verboseLoggingEnabled())
    {
      Log.v("Executing: request to adfonic servers");
      Log.v("> " + paramString);
    }
    Log.adRequestSummary("Adfonic Request: " + paramString);
  }
  
  public void run()
  {
    try
    {
      final ApiResponse localApiResponse = execute();
      if (this.handler == null) {
        return;
      }
      if (this.callback != null)
      {
        this.handler.sendEmptyMessage(123);
        this.handler.post(new Runnable()
        {
          public void run()
          {
            RequestRunnable.this.callback.onResponse(localApiResponse);
          }
        });
        return;
      }
    }
    catch (IOException localIOException) {}catch (Exception localException)
    {
      if (this.callback != null)
      {
        this.callback.onThrowable(localException);
        return;
      }
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/api/RequestRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */