package com.gau.go.launcherex.gowidget.weather.globaltheme.view.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.SQLException;
import com.gtp.a.a.b.c;
import com.jiubang.core.c.j;
import java.lang.ref.WeakReference;

class w
  extends j
{
  private WeakReference a;
  
  public w(ContentResolver paramContentResolver, s params)
  {
    super(paramContentResolver);
    this.a = new WeakReference(params);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    boolean bool = true;
    super.a(paramInt, paramObject, paramCursor);
    paramObject = (s)this.a.get();
    if (paramObject == null)
    {
      paramInt = 1;
      if (paramCursor != null) {
        break label47;
      }
    }
    label47:
    for (int i = 1;; i = 0)
    {
      if ((i | paramInt) == 0) {
        break label53;
      }
      return;
      paramInt = 0;
      break;
    }
    for (;;)
    {
      try
      {
        label53:
        if (paramCursor.getCount() <= 0) {
          continue;
        }
        s.a((s)paramObject, bool);
        if (s.f((s)paramObject))
        {
          paramInt = paramCursor.getColumnIndex("go_widget_type");
          if ((paramInt != -1) && (paramCursor.moveToFirst())) {
            switch (paramCursor.getInt(paramInt))
            {
            case 4: 
              bool = paramCursor.moveToNext();
              if (bool) {
                continue;
              }
            }
          }
        }
      }
      catch (SQLException paramObject)
      {
        if (!c.a()) {
          continue;
        }
        ((SQLException)paramObject).printStackTrace();
        continue;
      }
      finally
      {
        paramCursor.close();
      }
      paramCursor.close();
      return;
      bool = false;
      continue;
      s.b((s)paramObject, true);
      continue;
      s.c((s)paramObject, true);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/view/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */