package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.SQLException;
import com.gtp.a.a.b.c;
import com.jiubang.core.c.j;
import java.lang.ref.WeakReference;

class ai
  extends j
{
  private WeakReference a;
  
  public ai(ContentResolver paramContentResolver, af paramaf)
  {
    super(paramContentResolver);
    this.a = new WeakReference(paramaf);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    af localaf = (af)this.a.get();
    if ((localaf == null) || (paramCursor == null)) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramCursor.close();
      return;
      try
      {
        af.a(localaf, paramObject, paramCursor);
      }
      catch (SQLException paramObject)
      {
        if (!c.a()) {
          continue;
        }
        ((SQLException)paramObject).printStackTrace();
      }
      finally
      {
        paramCursor.close();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */