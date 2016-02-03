package com.gtp.go.weather.sharephoto.a;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import java.lang.ref.SoftReference;

class i
  extends AsyncQueryHandler
{
  private SoftReference a;
  
  public i(ContentResolver paramContentResolver, g paramg)
  {
    super(paramContentResolver);
    this.a = new SoftReference(paramg);
  }
  
  protected void onQueryComplete(int paramInt, Object paramObject, Cursor paramCursor)
  {
    if ((paramCursor != null) && (this.a != null))
    {
      paramObject = (g)this.a.get();
      if (paramObject != null) {}
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
    g.a((g)paramObject, paramCursor);
    g.a((g)paramObject, false);
    g.a((g)paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */