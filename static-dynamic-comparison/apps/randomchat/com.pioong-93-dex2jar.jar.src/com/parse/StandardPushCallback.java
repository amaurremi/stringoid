package com.parse;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import org.json.JSONObject;

public class StandardPushCallback
  extends PushCallback
{
  static boolean disableNotifications = false;
  static int totalNotifications = 0;
  
  private Bundle makeBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("com.parse.Data", this.pushData.toString());
    localBundle.putString("com.parse.Channel", this.channel);
    return localBundle;
  }
  
  public void run()
  {
    totalNotifications += 1;
    if (disableNotifications) {}
    do
    {
      return;
      if (this.pushData == null) {
        this.pushData = new JSONObject();
      }
      if (!this.pushData.has("action")) {
        break;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtras(makeBundle());
      ((Intent)localObject1).setAction(this.pushData.optString("action"));
      this.service.getBaseContext().sendBroadcast((Intent)localObject1);
    } while ((!this.pushData.has("alert")) && (!this.pushData.has("title")));
    Object localObject1 = this.pushData.optString("alert", "Notification received.");
    String str = this.pushData.optString("title", this.localData.optString("appName"));
    long l = System.currentTimeMillis();
    Object localObject2 = new ComponentName(this.localData.optString("activityPackage"), this.localData.optString("activityClass"));
    Object localObject3 = new Intent();
    ((Intent)localObject3).setComponent((ComponentName)localObject2);
    ((Intent)localObject3).setFlags(268435456);
    ((Intent)localObject3).putExtras(makeBundle());
    localObject3 = PendingIntent.getActivity(this.service, (int)l, (Intent)localObject3, 0);
    localObject2 = new Notification(this.localData.optInt("icon"), (CharSequence)localObject1, l);
    ((Notification)localObject2).flags |= 0x10;
    ((Notification)localObject2).defaults |= 0xFFFFFFFF;
    ((Notification)localObject2).setLatestEventInfo(this.service, str, (CharSequence)localObject1, (PendingIntent)localObject3);
    localObject1 = (NotificationManager)this.service.getSystemService("notification");
    int i = (int)l;
    try
    {
      ((NotificationManager)localObject1).notify(i, (Notification)localObject2);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      ((Notification)localObject2).defaults = 5;
      ((NotificationManager)localObject1).notify(i, (Notification)localObject2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/StandardPushCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */