package com.bugsense.trace;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public class BugSense
{
  private static ExecutorService executor = Executors.newFixedThreadPool(1);
  
  protected static ExecutorService getExecutor()
  {
    try
    {
      if (executor == null) {
        executor = Executors.newFixedThreadPool(1);
      }
      ExecutorService localExecutorService = executor;
      return localExecutorService;
    }
    finally {}
  }
  
  protected static void showUpgradeNotification(Context paramContext, String paramString)
  {
    if (BugSenseHandler.I_WANT_TO_DEBUG) {
      Log.i(G.TAG, "Show notification: " + paramString);
    }
    if ((paramString != null) && (paramString.length() > 5)) {}
    label304:
    for (;;)
    {
      try
      {
        NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
        JSONObject localJSONObject = new JSONObject(new JSONObject(paramString).getString("data"));
        paramString = localJSONObject.getString("tickerText");
        if ((BugSenseHandler.locTicker == null) || (BugSenseHandler.locTicker.length() <= 1)) {
          break label304;
        }
        paramString = BugSenseHandler.locTicker;
        long l = System.currentTimeMillis();
        Object localObject = paramContext.getResources();
        int j = ((Resources)localObject).getIdentifier("ic_launcher", "drawable", paramContext.getPackageName());
        int i = j;
        if (j == 0) {
          i = ((Resources)localObject).getIdentifier("icon", "drawable", paramContext.getPackageName());
        }
        Notification localNotification = new Notification(i, paramString, l);
        localNotification.flags = 16;
        paramString = localJSONObject.getString("contentTitle");
        if ((BugSenseHandler.locTitle != null) && (BugSenseHandler.locTitle.length() > 1))
        {
          paramString = BugSenseHandler.locTitle;
          String str = localJSONObject.getString("contentText");
          localObject = str;
          if (BugSenseHandler.locText != null)
          {
            localObject = str;
            if (BugSenseHandler.locText.length() > 1) {
              localObject = BugSenseHandler.locText;
            }
          }
          localNotification.setLatestEventInfo(paramContext, paramString, (CharSequence)localObject, PendingIntent.getActivity(paramContext, 0, new Intent("android.intent.action.VIEW", Uri.parse(localJSONObject.getString("url"))), 268435456));
          localNotificationManager.notify(1, localNotification);
          return;
        }
      }
      catch (Exception paramContext)
      {
        Log.e(G.TAG, "Error starting fix notification");
        if (!BugSenseHandler.I_WANT_TO_DEBUG) {
          continue;
        }
        paramContext.printStackTrace();
        return;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bugsense/trace/BugSense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */