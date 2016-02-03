package com.jaysquared.games.whereishd.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import com.jaysquared.games.whereishd.ApplicationManager;
import com.jaysquared.games.whereishd.GameManager;

public class InAppSupportHelper
{
  private static final String LOG_TAG = InAppSupportHelper.class.getSimpleName();
  
  private static boolean hasFacebookInstalled(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.facebook.katana", 0);
      Log.d(LOG_TAG, "Facebook is installed.");
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.d(LOG_TAG, "Facebook is not installed.");
    }
    return false;
  }
  
  private static void openFacebookPage(Activity paramActivity)
  {
    if (hasFacebookInstalled(paramActivity)) {}
    for (Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("fb://page/116476558442748"));; localIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/jaysquaredcom")))
    {
      paramActivity.startActivity(localIntent);
      paramActivity.finish();
      return;
    }
  }
  
  public static void openSupportChannel(Activity paramActivity)
  {
    openFacebookPage(paramActivity);
  }
  
  private static void sendEmail(Activity paramActivity)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.putExtra("android.intent.extra.EMAIL", new String[] { "whereis@jaysquared.com", "" });
      localIntent.setType("message/rfc822");
      paramActivity.startActivity(Intent.createChooser(localIntent, ApplicationManager.getInstance().getGameManager().getApplicationContext().getResources().getString(2131427357)));
      paramActivity.finish();
      return;
    }
    catch (Exception localException)
    {
      Toast.makeText(paramActivity, "You have no default email client!", 1).show();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/utils/InAppSupportHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */