package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.content.ContentResolver;
import android.database.Cursor;
import com.jiubang.core.c.j;
import java.lang.ref.SoftReference;

class t
  extends j
{
  private SoftReference a;
  
  public t(ContentResolver paramContentResolver, q paramq)
  {
    super(paramContentResolver);
    this.a = new SoftReference(paramq);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    q localq;
    if ((paramCursor != null) && (this.a != null))
    {
      localq = (q)this.a.get();
      if (localq != null) {}
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
    q.a(localq, paramObject, paramCursor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */