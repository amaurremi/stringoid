package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.util.a;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.view.AppListActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class d
{
  private String a;
  private a b = null;
  
  private void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, AppListActivity.class);
    localIntent.putExtra("calendar_clock_binding_app", paramInt);
    localIntent.addFlags(268435456);
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  void a(Context paramContext)
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.a))
    {
      localObject = this.a.split("#");
      localObject = r.a(paramContext, localObject[0], localObject[1]);
      if (localObject == null) {}
    }
    try
    {
      paramContext.startActivity((Intent)localObject);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException1)
    {
      localActivityNotFoundException1.printStackTrace();
      Iterator localIterator = this.b.a.iterator();
      if (localIterator.hasNext()) {
        locala = (a)localIterator.next();
      }
    }
    catch (SecurityException localSecurityException1)
    {
      for (;;)
      {
        try
        {
          a locala;
          Intent localIntent = new Intent("android.intent.action.MAIN");
          localIntent.setClassName(locala.a(), locala.c());
          if (locala.b()) {
            localIntent.addCategory("android.intent.category.LAUNCHER");
          }
          localIntent.setFlags(268435456);
          paramContext.startActivity(localIntent);
          i = 1;
          if (i != 0) {
            continue;
          }
          a(paramContext, 2);
          return;
          localSecurityException1 = localSecurityException1;
          localSecurityException1.printStackTrace();
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
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */