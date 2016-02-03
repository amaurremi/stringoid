package com.mopub.nativeads;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import com.mopub.nativeads.util.Utils;
import java.net.URI;
import org.apache.http.client.methods.HttpUriRequest;

class DownloadTask
  extends AsyncTask<HttpUriRequest, Void, DownloadResponse>
{
  private final DownloadTaskListener mDownloadTaskListener;
  private String mUrl;
  
  DownloadTask(DownloadTaskListener paramDownloadTaskListener)
    throws IllegalArgumentException
  {
    if (paramDownloadTaskListener == null) {
      throw new IllegalArgumentException("DownloadTaskListener must not be null.");
    }
    this.mDownloadTaskListener = paramDownloadTaskListener;
  }
  
  protected DownloadResponse doInBackground(HttpUriRequest... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0) || (paramVarArgs[0] == null))
    {
      Utils.MoPubLog("Download task tried to execute null or empty url");
      return null;
    }
    Object localObject1 = paramVarArgs[0];
    this.mUrl = ((HttpUriRequest)localObject1).getURI().toString();
    paramVarArgs = NativeHttpClient.getHttpClient();
    try
    {
      localObject1 = new DownloadResponse(paramVarArgs.execute((HttpUriRequest)localObject1));
      return (DownloadResponse)localObject1;
    }
    catch (Exception localException)
    {
      Utils.MoPubLog("Download task threw an internal exception");
      cancel(true);
      return null;
    }
    finally
    {
      paramVarArgs.close();
    }
  }
  
  protected void onCancelled()
  {
    this.mDownloadTaskListener.onComplete(this.mUrl, null);
  }
  
  protected void onPostExecute(DownloadResponse paramDownloadResponse)
  {
    if (isCancelled())
    {
      onCancelled();
      return;
    }
    this.mDownloadTaskListener.onComplete(this.mUrl, paramDownloadResponse);
  }
  
  static abstract interface DownloadTaskListener
  {
    public abstract void onComplete(String paramString, DownloadResponse paramDownloadResponse);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/DownloadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */