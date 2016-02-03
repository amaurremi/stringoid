package com.adfonic.android.view.task;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.adfonic.android.utils.Log;
import com.adfonic.android.utils.Network;

public abstract class UrlOpenerTask
  extends AsyncTask<String, Void, Void>
{
  public static final String MARKET_SEARCH = "market://";
  
  public static boolean isAndroidMarketUrl(String paramString)
  {
    if (paramString == null) {}
    while (!paramString.contains("market://")) {
      return false;
    }
    return true;
  }
  
  protected Void doInBackground(String... paramVarArgs)
  {
    onUrlReceived(Network.requestDestinationUrl(paramVarArgs[0]));
    return null;
  }
  
  protected abstract Context getContext();
  
  protected void onUrlReceived(String paramString)
  {
    if (isAndroidMarketUrl(paramString))
    {
      openAndroidMarket(paramString);
      return;
    }
    openUrl(paramString);
  }
  
  protected void openAndroidMarket(String paramString)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString));
      getContext().startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      Log.e("Error opening Android Market from ad (" + paramString + ")", localException);
    }
  }
  
  protected abstract void openUrl(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/view/task/UrlOpenerTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */