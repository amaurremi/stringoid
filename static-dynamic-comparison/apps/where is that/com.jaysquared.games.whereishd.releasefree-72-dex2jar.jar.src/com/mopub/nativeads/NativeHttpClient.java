package com.mopub.nativeads;

import android.net.http.AndroidHttpClient;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.DeviceUtils;
import com.mopub.nativeads.util.Utils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

class NativeHttpClient
{
  private static final int CONNECTION_TIMEOUT = 10000;
  private static final int SOCKET_TIMEOUT = 10000;
  
  public static AndroidHttpClient getHttpClient()
  {
    AndroidHttpClient localAndroidHttpClient = AndroidHttpClient.newInstance(DeviceUtils.getUserAgent());
    HttpParams localHttpParams = localAndroidHttpClient.getParams();
    HttpConnectionParams.setConnectionTimeout(localHttpParams, 10000);
    HttpConnectionParams.setSoTimeout(localHttpParams, 10000);
    HttpClientParams.setRedirecting(localHttpParams, true);
    return localAndroidHttpClient;
  }
  
  static void getResolvedUrl(String paramString, UrlResolutionTask.UrlResolutionListener paramUrlResolutionListener)
  {
    AsyncTasks.safeExecuteOnExecutor(new UrlResolutionTask(paramUrlResolutionListener), new String[] { paramString });
  }
  
  static void makeTrackingHttpRequest(String paramString)
  {
    DownloadTask localDownloadTask = new DownloadTask(new DownloadTask.DownloadTaskListener()
    {
      public void onComplete(String paramAnonymousString, DownloadResponse paramAnonymousDownloadResponse)
      {
        if ((paramAnonymousDownloadResponse == null) || (paramAnonymousDownloadResponse.getStatusCode() != 200))
        {
          Utils.MoPubLog("Failed to hit tracking endpoint: " + paramAnonymousString);
          return;
        }
        if (HttpResponses.asResponseString(paramAnonymousDownloadResponse) != null)
        {
          Utils.MoPubLog("Successfully hit tracking endpoint:" + paramAnonymousString);
          return;
        }
        Utils.MoPubLog("Failed to hit tracking endpoint: " + paramAnonymousString);
      }
    });
    try
    {
      localDownloadTask.execute(new HttpUriRequest[] { new HttpGet(paramString) });
      return;
    }
    catch (Exception localException)
    {
      Utils.MoPubLog("Failed to hit tracking endpoint: " + paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/NativeHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */