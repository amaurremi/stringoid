package com.go.weatherex.setting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.widget.CheckBox;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.view.VerticalStretchLayout;
import com.gtp.a.a.b.c;
import com.jiubang.core.c.j;

@SuppressLint({"HandlerLeak"})
class aw
  extends j
{
  public aw(an paraman, ContentResolver paramContentResolver)
  {
    super(paramContentResolver);
  }
  
  protected void a(int paramInt1, Object paramObject, int paramInt2) {}
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramCursor == null) {
      return;
    }
    switch (paramInt)
    {
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 17: 
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 16: 
    case 4: 
      label233:
      do
      {
        for (;;)
        {
          paramCursor.close();
          return;
          try
          {
            if (!paramCursor.moveToFirst()) {
              continue;
            }
            an.a(this.a, paramCursor.getString(0));
          }
          catch (SQLException paramObject) {}
          if (paramCursor.getCount() > 0)
          {
            an.a(this.a, paramCursor);
          }
          else
          {
            an.a(this.a, false);
            continue;
            if (paramCursor.moveToNext())
            {
              an.a(this.a).a = paramCursor.getInt(0);
              an.b(this.a).a = an.a(this.a).a;
              an.b(this.a, true);
              if (an.b(this.a).a != 1) {
                break;
              }
              an.c(this.a).setChecked(bool1);
              continue;
              if (paramCursor.moveToNext())
              {
                an.a(this.a).c = paramCursor.getInt(0);
                an.b(this.a).c = an.a(this.a).c;
                continue;
                if (paramCursor.moveToNext())
                {
                  an.a(this.a).d = paramCursor.getInt(0);
                  an.b(this.a).d = an.a(this.a).d;
                  continue;
                  if (paramCursor.moveToNext())
                  {
                    an.a(this.a).e = paramCursor.getInt(0);
                    an.b(this.a).e = an.a(this.a).e;
                    continue;
                    if (paramCursor.moveToNext())
                    {
                      an.a(this.a).f = paramCursor.getInt(0);
                      an.b(this.a).f = an.a(this.a).f;
                      switch (an.a(this.a).f)
                      {
                      case 1: 
                        an.d(this.a).setText(2131166197);
                        break;
                      case 2: 
                        an.d(this.a).setText(2131166198);
                        break;
                      case 3: 
                        an.d(this.a).setText(2131166199);
                        continue;
                        if (paramCursor.moveToNext())
                        {
                          an.a(this.a).g = paramCursor.getInt(0);
                          an.b(this.a).g = an.a(this.a).g;
                          switch (an.a(this.a).g)
                          {
                          case 1: 
                            an.e(this.a).setText(2131166201);
                            break;
                          case 2: 
                            an.e(this.a).setText(2131166202);
                            break;
                          case 3: 
                            an.e(this.a).setText(2131166203);
                            continue;
                            if (paramCursor.moveToNext())
                            {
                              an.a(this.a).h = paramCursor.getInt(0);
                              an.b(this.a).h = an.a(this.a).h;
                              switch (an.a(this.a).h)
                              {
                              case 1: 
                                an.f(this.a).setText(2131166208);
                                break;
                              case 3: 
                                an.f(this.a).setText(2131166206);
                                break;
                              case 2: 
                                an.f(this.a).setText(2131166207);
                              }
                            }
                            break;
                          }
                        }
                        break;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      } while (!paramCursor.moveToNext());
      an.a(this.a).b = paramCursor.getInt(0);
      an.b(this.a).b = an.a(this.a).b;
      an.c(this.a, true);
      if (an.b(this.a).b != 1) {
        break;
      }
    }
    for (bool1 = bool2;; bool1 = false)
    {
      an.d(this.a, bool1);
      an.e(this.a, bool1);
      an.f(this.a, bool1);
      an.g(this.a, bool1);
      an.g(this.a).setChecked(bool1);
      if (bool1)
      {
        an.h(this.a).b();
        break;
      }
      an.h(this.a).a();
      break;
      if (!paramCursor.moveToNext()) {
        break;
      }
      an.a(this.a, paramCursor.getInt(0));
      break;
      break;
      bool1 = false;
      break label233;
      break;
      break;
      break;
    }
  }
  
  protected void a(int paramInt, Object paramObject, ContentProviderResult[] paramArrayOfContentProviderResult)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while ((paramArrayOfContentProviderResult == null) || (paramArrayOfContentProviderResult.length <= 0));
    an.a(this.a, System.currentTimeMillis() - an.i(this.a));
    c.a("LJL", "onBatchComplete:mTime:" + an.i(this.a));
    c.a("LJL", "TOKEN_UPDATE_SETTINGS:" + System.currentTimeMillis());
    paramObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LIVE_WALLPAPER_SETTINGS_CHANGE");
    an.j(this.a).sendBroadcast((Intent)paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */