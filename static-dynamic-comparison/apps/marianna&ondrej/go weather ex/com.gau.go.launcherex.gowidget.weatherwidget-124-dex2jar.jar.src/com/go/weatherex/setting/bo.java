package com.go.weatherex.setting;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;
import com.jiubang.core.c.j;

class bo
  extends j
{
  @SuppressLint({"HandlerLeak"})
  public bo(bm parambm, ContentResolver paramContentResolver)
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
      bm.a(this.a, paramCursor);
      String str = "";
      try
      {
        if (!TextUtils.isEmpty(bm.k(this.a)))
        {
          paramObject = new ComponentName(bm.k(this.a).split("#")[0], bm.k(this.a).split("#")[1]);
          paramObject = bm.l(this.a).getActivityInfo((ComponentName)paramObject, 0).loadLabel(this.a.getActivity().getPackageManager()).toString();
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
            if (!TextUtils.isEmpty(bm.m(this.a)))
            {
              paramCursor = new ComponentName(bm.m(this.a).split("#")[0], bm.m(this.a).split("#")[1]);
              paramCursor = bm.l(this.a).getActivityInfo(paramCursor, 0).loadLabel(this.a.getActivity().getPackageManager()).toString();
              localObject = paramObject;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              bm.n(this.a).setText((CharSequence)localObject);
            }
            if (TextUtils.isEmpty(paramCursor)) {
              break;
            }
            bm.o(this.a).setText(paramCursor);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */