package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import java.lang.ref.SoftReference;

class ad
  extends AsyncQueryHandler
{
  private SoftReference a;
  
  public ad(ContentResolver paramContentResolver, ab paramab)
  {
    super(paramContentResolver);
    this.a = new SoftReference(paramab);
  }
  
  protected void onQueryComplete(int paramInt, Object paramObject, Cursor paramCursor)
  {
    if ((paramCursor != null) && (this.a != null))
    {
      paramObject = (ab)this.a.get();
      if (paramObject != null) {
        break label27;
      }
    }
    for (;;)
    {
      return;
      label27:
      switch (paramInt)
      {
      }
      while ((paramInt != 1) && (paramInt != 5))
      {
        ab.g((ab)paramObject);
        return;
        ab.a((ab)paramObject, paramCursor);
        ab.h((ab)paramObject);
        continue;
        ab.b((ab)paramObject, paramCursor);
        ab.a((ab)paramObject, false);
        if (!((ab)paramObject).a)
        {
          ((ab)paramObject).a = true;
          continue;
          ab.c((ab)paramObject, paramCursor);
          continue;
          ab.d((ab)paramObject, paramCursor);
          continue;
          ab.e((ab)paramObject, paramCursor);
          ab.h((ab)paramObject);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */