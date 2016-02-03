package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.a;
import com.gau.go.launcherex.gowidget.weather.util.d;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.view.AppListActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class al
  extends Handler
{
  private Context a;
  private a b = null;
  
  public al(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a()
  {
    Cursor localCursor = this.a.getContentResolver().query(WeatherContentProvider.g, new String[] { "setting_key", "setting_value" }, "setting_key=?", new String[] { "widgt_calendar" }, null);
    String str;
    if (localCursor != null) {
      if (localCursor.getCount() > 0)
      {
        localCursor.moveToFirst();
        int i = localCursor.getColumnIndex("setting_value");
        if (i != -1) {
          str = localCursor.getString(i);
        }
      }
    }
    for (;;)
    {
      try
      {
        localCursor.close();
        a(str);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      str = "";
      continue;
      str = "";
    }
  }
  
  public void a(String paramString)
  {
    removeMessages(1);
    Message localMessage = obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramString;
    sendMessage(localMessage);
  }
  
  public void b()
  {
    Cursor localCursor = this.a.getContentResolver().query(WeatherContentProvider.g, new String[] { "setting_key", "setting_value" }, "setting_key=?", new String[] { "widgt_clock" }, null);
    String str;
    if (localCursor != null) {
      if (localCursor.getCount() > 0)
      {
        localCursor.moveToFirst();
        int i = localCursor.getColumnIndex("setting_value");
        if (i != -1) {
          str = localCursor.getString(i);
        }
      }
    }
    for (;;)
    {
      try
      {
        localCursor.close();
        b(str);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      str = "";
      continue;
      str = "";
    }
  }
  
  public void b(String paramString)
  {
    removeMessages(2);
    Message localMessage = obtainMessage();
    localMessage.what = 2;
    localMessage.obj = paramString;
    sendMessage(localMessage);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        paramMessage = paramMessage.split("#");
        paramMessage = r.a(this.a, paramMessage[0], paramMessage[1]);
        if (paramMessage == null) {}
      }
      try
      {
        this.a.startActivity(paramMessage);
        return;
      }
      catch (ActivityNotFoundException paramMessage)
      {
        paramMessage.printStackTrace();
        paramMessage = d.a.iterator();
        if (paramMessage.hasNext()) {
          localIntent1 = (Intent)paramMessage.next();
        }
      }
      catch (SecurityException paramMessage)
      {
        for (;;)
        {
          try
          {
            Intent localIntent1;
            this.a.startActivity(localIntent1);
            return;
          }
          catch (ActivityNotFoundException localActivityNotFoundException1)
          {
            localActivityNotFoundException1.printStackTrace();
            continue;
            paramMessage = paramMessage;
            paramMessage.printStackTrace();
          }
          catch (SecurityException localSecurityException1)
          {
            localSecurityException1.printStackTrace();
          }
        }
        paramMessage = new Intent(this.a, AppListActivity.class);
        paramMessage.putExtra("calendar_clock_binding_app", 1);
        paramMessage.addFlags(268435456);
        this.a.startActivity(paramMessage);
        return;
      }
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        paramMessage = paramMessage.split("#");
        paramMessage = r.a(this.a, paramMessage[0], paramMessage[1]);
        if (paramMessage == null) {}
      }
      try
      {
        this.a.startActivity(paramMessage);
        return;
      }
      catch (ActivityNotFoundException paramMessage)
      {
        paramMessage.printStackTrace();
        if (this.b == null) {
          this.b = new a();
        }
        paramMessage = this.b.a.iterator();
        if (paramMessage.hasNext()) {
          locala = (a)paramMessage.next();
        }
      }
      catch (SecurityException paramMessage)
      {
        for (;;)
        {
          try
          {
            a locala;
            Intent localIntent2 = new Intent("android.intent.action.MAIN");
            localIntent2.setClassName(locala.a(), locala.c());
            if (locala.b()) {
              localIntent2.addCategory("android.intent.category.LAUNCHER");
            }
            localIntent2.setFlags(268435456);
            this.a.startActivity(localIntent2);
            i = 1;
            if (i != 0) {
              break;
            }
            paramMessage = new Intent(this.a, AppListActivity.class);
            paramMessage.putExtra("calendar_clock_binding_app", 2);
            paramMessage.addFlags(268435456);
            this.a.startActivity(paramMessage);
            return;
            paramMessage = paramMessage;
            paramMessage.printStackTrace();
          }
          catch (ActivityNotFoundException localActivityNotFoundException2)
          {
            localActivityNotFoundException2.printStackTrace();
            continue;
          }
          catch (SecurityException localSecurityException2)
          {
            localSecurityException2.printStackTrace();
          }
          continue;
          int i = 0;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */