package com.gau.go.launcherex.gowidget.weather.view;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.text.TextUtils;
import android.widget.TextView;
import com.jiubang.core.c.j;

class ag
  extends j
{
  @SuppressLint({"HandlerLeak"})
  public ag(MainWidgetSetting paramMainWidgetSetting, ContentResolver paramContentResolver)
  {
    super(paramContentResolver);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    super.a(paramInt, paramObject, paramCursor);
    if (paramCursor == null) {}
    for (;;)
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      }
      MainWidgetSetting.a(this.a, paramCursor);
      String str = "";
      try
      {
        if (!TextUtils.isEmpty(MainWidgetSetting.a()))
        {
          paramObject = new ComponentName(MainWidgetSetting.a().split("#")[0], MainWidgetSetting.a().split("#")[1]);
          paramObject = MainWidgetSetting.k(this.a).getActivityInfo((ComponentName)paramObject, 0).loadLabel(this.a.getPackageManager()).toString();
          paramCursor = str;
          localObject = paramObject;
        }
      }
      catch (Exception paramCursor)
      {
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(MainWidgetSetting.b()))
            {
              paramCursor = new ComponentName(MainWidgetSetting.b().split("#")[0], MainWidgetSetting.b().split("#")[1]);
              paramCursor = MainWidgetSetting.k(this.a).getActivityInfo(paramCursor, 0).loadLabel(this.a.getPackageManager()).toString();
              localObject = paramObject;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              MainWidgetSetting.f().setText((CharSequence)localObject);
            }
            if (TextUtils.isEmpty(paramCursor)) {
              break;
            }
            MainWidgetSetting.g().setText(paramCursor);
            return;
          }
          catch (Exception paramCursor)
          {
            Object localObject;
            continue;
          }
          paramCursor = paramCursor;
          paramObject = "";
          paramCursor.printStackTrace();
          paramCursor = str;
          localObject = paramObject;
          continue;
          paramObject = "";
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */