package com.gtp.go.weather.sharephoto.award;

import android.content.ContentResolver;
import android.database.Cursor;
import com.gtp.go.weather.sharephoto.b.a.b;
import com.gtp.go.weather.sharephoto.b.a.c;
import com.gtp.go.weather.sharephoto.b.d;
import com.jiubang.core.c.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

class n
  extends j
{
  private WeakReference a;
  
  public n(ContentResolver paramContentResolver, k paramk)
  {
    super(paramContentResolver);
    this.a = new WeakReference(paramk);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    k localk = (k)this.a.get();
    if (localk == null) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramObject = new ArrayList();
      if (paramCursor != null)
      {
        if (paramCursor.moveToFirst()) {
          do
          {
            ((List)paramObject).add(c.a(paramCursor));
          } while (paramCursor.moveToNext());
        }
        paramCursor.close();
      }
      k.a(localk, (List)paramObject);
      return;
    case 2: 
      ArrayList localArrayList = new ArrayList();
      if (paramCursor != null)
      {
        if (paramCursor.moveToFirst()) {
          do
          {
            localArrayList.add(b.a(paramCursor));
          } while (paramCursor.moveToNext());
        }
        paramCursor.close();
      }
      k.a(localk, (d)paramObject, localArrayList);
      return;
    }
    paramObject = new ArrayList();
    if (paramCursor != null)
    {
      if (paramCursor.moveToFirst()) {
        do
        {
          ((List)paramObject).add(com.gtp.go.weather.sharephoto.b.k.a(paramCursor));
        } while (paramCursor.moveToNext());
      }
      paramCursor.close();
    }
    k.b(localk, (List)paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */