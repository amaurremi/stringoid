package com.mopub.nativeads;

import android.os.AsyncTask;
import com.mopub.common.util.IntentUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

class UrlResolutionTask
  extends AsyncTask<String, Void, String>
{
  private static final int REDIRECT_LIMIT = 10;
  private final UrlResolutionListener mListener;
  
  UrlResolutionTask(UrlResolutionListener paramUrlResolutionListener)
  {
    this.mListener = paramUrlResolutionListener;
  }
  
  private String getRedirectLocation(String paramString)
    throws IOException
  {
    Object localObject1 = new URL(paramString);
    paramString = null;
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)((URL)localObject1).openConnection();
      paramString = localHttpURLConnection;
      localHttpURLConnection.setInstanceFollowRedirects(false);
      paramString = localHttpURLConnection;
      int i = localHttpURLConnection.getResponseCode();
      if ((i >= 300) && (i < 400))
      {
        paramString = localHttpURLConnection;
        localObject1 = localHttpURLConnection.getHeaderField("Location");
        paramString = (String)localObject1;
        localObject1 = paramString;
        if (localHttpURLConnection != null)
        {
          localHttpURLConnection.disconnect();
          localObject1 = paramString;
        }
        return (String)localObject1;
      }
      localObject1 = null;
      return null;
    }
    finally
    {
      if (paramString != null) {
        paramString.disconnect();
      }
    }
  }
  
  protected String doInBackground(String... paramVarArgs)
  {
    Object localObject;
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      localObject = null;
    }
    for (;;)
    {
      return (String)localObject;
      localObject = null;
      paramVarArgs = paramVarArgs[0];
      int i = 0;
      if ((paramVarArgs != null) && (i < 10))
      {
        localObject = paramVarArgs;
        try
        {
          if (IntentUtils.isHttpUrl(paramVarArgs))
          {
            localObject = paramVarArgs;
            paramVarArgs = getRedirectLocation(paramVarArgs);
            i += 1;
          }
        }
        catch (IOException paramVarArgs)
        {
          return null;
        }
      }
    }
    return (String)localObject;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    this.mListener.onFailure();
  }
  
  protected void onPostExecute(String paramString)
  {
    super.onPostExecute(paramString);
    if ((isCancelled()) || (paramString == null))
    {
      onCancelled();
      return;
    }
    this.mListener.onSuccess(paramString);
  }
  
  static abstract interface UrlResolutionListener
  {
    public abstract void onFailure();
    
    public abstract void onSuccess(String paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/UrlResolutionTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */