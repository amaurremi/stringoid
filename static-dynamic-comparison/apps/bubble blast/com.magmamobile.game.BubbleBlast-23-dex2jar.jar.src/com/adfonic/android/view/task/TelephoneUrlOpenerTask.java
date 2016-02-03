package com.adfonic.android.view.task;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.adfonic.android.utils.Log;

public abstract class TelephoneUrlOpenerTask
  extends UrlOpenerTask
{
  private void dialTelephone(String paramString)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.DIAL");
      localIntent.setData(Uri.parse(paramString));
      getContext().startActivity(localIntent);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("Error dialling ad telephone number");
    }
  }
  
  protected void onUrlReceived(String paramString)
  {
    dialTelephone(paramString);
  }
  
  protected void openUrl(String paramString) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/view/task/TelephoneUrlOpenerTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */