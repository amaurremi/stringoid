package com.go.weatherex.setting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.text.TextUtils;
import android.widget.TextView;

@SuppressLint({"HandlerLeak"})
class j
  extends com.jiubang.core.c.j
{
  public j(h paramh, ContentResolver paramContentResolver)
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
      h.a(this.a, paramCursor);
      String str = "";
      try
      {
        if (!TextUtils.isEmpty(h.k(this.a)))
        {
          paramObject = new ComponentName(h.k(this.a).split("#")[0], h.k(this.a).split("#")[1]);
          paramObject = h.m(this.a).getActivityInfo((ComponentName)paramObject, 0).loadLabel(h.l(this.a).getPackageManager()).toString();
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
            if (!TextUtils.isEmpty(h.n(this.a)))
            {
              paramCursor = new ComponentName(h.n(this.a).split("#")[0], h.n(this.a).split("#")[1]);
              paramCursor = h.m(this.a).getActivityInfo(paramCursor, 0).loadLabel(h.l(this.a).getPackageManager()).toString();
              localObject = paramObject;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              h.o(this.a).setText((CharSequence)localObject);
            }
            if (TextUtils.isEmpty(paramCursor)) {
              break;
            }
            h.p(this.a).setText(paramCursor);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */