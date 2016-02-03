package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.content.ContentResolver;
import android.database.Cursor;
import com.jiubang.core.c.j;
import java.lang.ref.SoftReference;

class p
  extends j
{
  private SoftReference a;
  
  public p(ContentResolver paramContentResolver, m paramm)
  {
    super(paramContentResolver);
    this.a = new SoftReference(paramm);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    m localm;
    if ((paramCursor != null) && (this.a != null))
    {
      localm = (m)this.a.get();
      if (localm != null) {}
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
    m.a(localm, paramObject, paramCursor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */