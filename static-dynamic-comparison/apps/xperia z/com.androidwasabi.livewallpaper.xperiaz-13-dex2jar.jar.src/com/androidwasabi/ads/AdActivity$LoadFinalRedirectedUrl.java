package com.androidwasabi.ads;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import java.net.HttpURLConnection;
import java.net.URL;

class AdActivity$LoadFinalRedirectedUrl
  extends AsyncTask<String, Void, String>
{
  ProgressDialog progDailog;
  
  private AdActivity$LoadFinalRedirectedUrl(AdActivity paramAdActivity) {}
  
  protected String doInBackground(String... paramVarArgs)
  {
    String str1 = paramVarArgs[0];
    for (;;)
    {
      try
      {
        if (str1.substring(0, 9).equals("market://")) {
          return str1;
        }
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(str1).openConnection();
        localHttpURLConnection.setInstanceFollowRedirects(false);
        localHttpURLConnection.setUseCaches(false);
        localHttpURLConnection.setRequestMethod("POST");
        localHttpURLConnection.connect();
        int i = localHttpURLConnection.getResponseCode();
        Log.e("AdActivity", "Response Code " + i);
        String str2 = str1;
        if (i >= 300)
        {
          str2 = str1;
          if (i < 400)
          {
            str2 = localHttpURLConnection.getHeaderField("Location");
            if (str2 != null) {
              continue;
            }
            str2 = str1;
          }
        }
        localHttpURLConnection.disconnect();
        return str2;
        Log.e("AdActivity", "redirected url: " + str2);
        i = localHttpURLConnection.getResponseCode();
        if (i != 200) {
          Object localObject = str2;
        }
      }
      catch (Exception localException)
      {
        Log.e("AdActivity", localException.toString());
        return paramVarArgs[0];
      }
    }
  }
  
  protected void onPostExecute(String paramString)
  {
    try
    {
      this.progDailog.dismiss();
      Log.e("AdActivity", "Final url: " + paramString);
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString.setFlags(1073741824);
      this.this$0.startActivity(paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    try
    {
      this.progDailog = new ProgressDialog(this.this$0);
      this.progDailog.setMessage("Loading...");
      this.progDailog.setIndeterminate(false);
      this.progDailog.setProgressStyle(0);
      this.progDailog.setCancelable(true);
      this.progDailog.show();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/AdActivity$LoadFinalRedirectedUrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */