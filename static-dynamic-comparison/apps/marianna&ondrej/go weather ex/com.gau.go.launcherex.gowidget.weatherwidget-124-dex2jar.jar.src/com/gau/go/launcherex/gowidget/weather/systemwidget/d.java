package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.content.ContentResolver;
import android.database.Cursor;
import com.jiubang.core.c.j;
import java.lang.ref.WeakReference;

class d
  extends j
{
  private WeakReference a;
  
  public d(ContentResolver paramContentResolver, a parama)
  {
    super(paramContentResolver);
    this.a = new WeakReference(parama);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    a locala;
    if ((paramCursor != null) && (this.a != null))
    {
      locala = (a)this.a.get();
      if (locala != null) {}
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
    a.a(locala, paramObject, paramCursor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */