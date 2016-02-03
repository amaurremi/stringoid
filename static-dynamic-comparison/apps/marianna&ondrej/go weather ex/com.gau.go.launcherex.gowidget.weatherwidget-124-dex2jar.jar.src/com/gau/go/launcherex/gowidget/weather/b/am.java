package com.gau.go.launcherex.gowidget.weather.b;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import com.gau.go.launcherex.gowidget.weather.model.u;
import com.jiubang.core.c.j;

class am
  extends j
{
  public am(ai paramai, ContentResolver paramContentResolver, Context paramContext)
  {
    super(paramContentResolver);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    super.a(paramInt, paramObject, paramCursor);
    if (paramCursor == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      }
      try
      {
        if (paramCursor.getCount() > 0)
        {
          paramCursor.moveToFirst();
          boolean bool;
          do
          {
            ai.f(this.a).a(Long.valueOf(paramCursor.getString(0)).longValue());
            bool = paramCursor.moveToNext();
          } while (bool);
        }
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          ((Exception)paramObject).printStackTrace();
        }
      }
      finally
      {
        paramCursor.close();
      }
      paramCursor.close();
    } while (ai.g(this.a) != null);
    ai.a(this.a, new ak(this.a, null));
    ai.g(this.a).execute(new Void[0]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */