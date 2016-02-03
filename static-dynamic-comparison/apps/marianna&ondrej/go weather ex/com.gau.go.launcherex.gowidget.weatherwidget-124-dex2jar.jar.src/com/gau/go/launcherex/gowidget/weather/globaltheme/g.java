package com.gau.go.launcherex.gowidget.weather.globaltheme;

import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.SparseArray;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import com.jiubang.core.c.j;
import java.lang.ref.WeakReference;

class g
  extends j
{
  private WeakReference a;
  
  public g(ContentResolver paramContentResolver, d paramd)
  {
    super(paramContentResolver);
    this.a = new WeakReference(paramd);
  }
  
  protected void a(int paramInt1, Object paramObject, int paramInt2)
  {
    d locald = (d)this.a.get();
    if (locald == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt2 <= 0);
        switch (paramInt1)
        {
        default: 
          return;
        }
      } while (!(paramObject instanceof SparseArray));
      paramObject = (SparseArray)paramObject;
      paramInt1 = ((SparseArray)paramObject).keyAt(0);
      paramObject = ((SparseArray)paramObject).valueAt(0);
    } while (!(paramObject instanceof e));
    d.a(locald, (e)paramObject);
    d.a(locald, paramInt1, (e)paramObject);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    super.a(paramInt, paramObject, paramCursor);
  }
  
  protected void a(int paramInt, Object paramObject, Uri paramUri)
  {
    super.a(paramInt, paramObject, paramUri);
  }
  
  protected void a(int paramInt, Object paramObject, ContentProviderResult[] paramArrayOfContentProviderResult)
  {
    d locald = (d)this.a.get();
    if (locald == null) {}
    label112:
    for (;;)
    {
      return;
      if ((paramArrayOfContentProviderResult != null) && (paramArrayOfContentProviderResult.length > 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label112;
        }
        switch (paramInt)
        {
        default: 
          return;
        }
        if (!(paramObject instanceof SparseArray)) {
          break;
        }
        paramObject = (SparseArray)paramObject;
        paramInt = ((SparseArray)paramObject).keyAt(0);
        paramObject = ((SparseArray)paramObject).valueAt(0);
        if (!(paramObject instanceof e)) {
          break;
        }
        d.a(locald, (e)paramObject);
        d.a(locald, paramInt, (e)paramObject);
        return;
      }
    }
  }
  
  protected void b(int paramInt1, Object paramObject, int paramInt2)
  {
    super.b(paramInt1, paramObject, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */