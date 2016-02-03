package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.content.ContentResolver;
import android.database.Cursor;
import com.jiubang.core.c.j;
import java.lang.ref.SoftReference;

class h
  extends j
{
  private SoftReference a;
  
  public h(ContentResolver paramContentResolver, e parame)
  {
    super(paramContentResolver);
    this.a = new SoftReference(parame);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    e locale;
    if ((paramCursor != null) && (this.a != null))
    {
      locale = (e)this.a.get();
      if (locale != null) {}
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
    e.a(locale, paramObject, paramCursor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */