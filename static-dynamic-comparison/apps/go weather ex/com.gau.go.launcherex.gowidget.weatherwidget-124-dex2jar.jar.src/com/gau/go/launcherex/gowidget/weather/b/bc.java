package com.gau.go.launcherex.gowidget.weather.b;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.jiubang.core.c.j;
import java.lang.ref.WeakReference;

class bc
  extends j
{
  private WeakReference a;
  
  public bc(ContentResolver paramContentResolver, ba paramba)
  {
    super(paramContentResolver);
    this.a = new WeakReference(paramba);
  }
  
  protected void a(int paramInt1, Object paramObject, int paramInt2)
  {
    ba localba = (ba)this.a.get();
    if (localba != null) {
      ba.a(localba, paramInt1, paramObject, paramInt2);
    }
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    ba localba = (ba)this.a.get();
    if (localba != null) {
      ba.a(localba, paramInt, paramObject, paramCursor);
    }
  }
  
  protected void a(int paramInt, Object paramObject, Uri paramUri)
  {
    ba localba = (ba)this.a.get();
    if (localba != null) {
      ba.a(localba, paramInt, paramObject, paramUri);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */