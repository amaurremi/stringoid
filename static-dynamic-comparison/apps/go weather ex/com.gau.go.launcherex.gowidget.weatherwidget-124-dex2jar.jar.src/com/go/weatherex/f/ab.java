package com.go.weatherex.f;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.jiubang.core.c.j;
import java.lang.ref.WeakReference;

class ab
  extends j
{
  private WeakReference a;
  
  public ab(ContentResolver paramContentResolver, t paramt)
  {
    super(paramContentResolver);
    this.a = new WeakReference(paramt);
  }
  
  protected void a(int paramInt1, Object paramObject, int paramInt2)
  {
    t localt = (t)this.a.get();
    if (localt != null) {
      t.a(localt, paramInt1, paramObject, paramInt2);
    }
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    t localt = (t)this.a.get();
    if (localt != null) {
      t.a(localt, paramInt, paramObject, paramCursor);
    }
  }
  
  protected void a(int paramInt, Object paramObject, Uri paramUri)
  {
    t localt = (t)this.a.get();
    if (localt != null) {
      t.a(localt, paramInt, paramObject, paramUri);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */