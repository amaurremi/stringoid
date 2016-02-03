package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.content.ContentResolver;
import android.database.Cursor;
import com.jiubang.core.c.j;
import java.lang.ref.SoftReference;

class l
  extends j
{
  private SoftReference a;
  
  public l(ContentResolver paramContentResolver, i parami)
  {
    super(paramContentResolver);
    this.a = new SoftReference(parami);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    i locali;
    if ((paramCursor != null) && (this.a != null))
    {
      locali = (i)this.a.get();
      if (locali != null) {}
    }
    else
    {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    i.a(locali, paramObject, paramCursor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */