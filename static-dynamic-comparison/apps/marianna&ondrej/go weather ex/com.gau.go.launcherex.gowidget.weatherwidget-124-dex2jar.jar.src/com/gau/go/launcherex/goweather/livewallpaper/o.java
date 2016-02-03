package com.gau.go.launcherex.goweather.livewallpaper;

import android.content.ContentResolver;
import android.database.Cursor;
import com.jiubang.core.c.j;

class o
  extends j
{
  public o(k paramk, ContentResolver paramContentResolver)
  {
    super(paramContentResolver);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    super.a(paramInt, paramObject, paramCursor);
    if (!k.a(this.a)) {
      if (paramCursor != null) {
        switch (paramInt)
        {
        }
      }
    }
    while (paramCursor == null)
    {
      return;
      k.a(this.a, paramCursor);
      return;
      k.b(this.a, paramCursor);
      return;
      k.c(this.a, paramCursor);
      return;
      k.d(this.a, paramCursor);
      return;
      k.e(this.a, paramCursor);
      return;
      k.f(this.a, paramCursor);
      return;
      k.g(this.a, paramCursor);
      k.h(this.a, paramCursor);
      return;
      k.i(this.a, paramCursor);
      return;
      k.j(this.a, paramCursor);
      return;
      this.a.a(paramCursor);
      return;
      k.a(this.a, paramCursor, (String)paramObject);
      return;
      k.k(this.a, paramCursor);
      return;
    }
    paramCursor.close();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */