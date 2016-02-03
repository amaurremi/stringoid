package com.go.weatherex.f;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.jiubang.core.c.j;
import java.lang.ref.WeakReference;

class f
  extends j
{
  private WeakReference a;
  
  public f(ContentResolver paramContentResolver, a parama)
  {
    super(paramContentResolver);
    this.a = new WeakReference(parama);
  }
  
  protected void a(int paramInt1, Object paramObject, int paramInt2)
  {
    a locala = (a)this.a.get();
    if (locala != null) {
      a.a(locala, paramInt1, paramObject, paramInt2);
    }
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    a locala = (a)this.a.get();
    if (locala != null) {
      a.a(locala, paramInt, paramObject, paramCursor);
    }
  }
  
  protected void a(int paramInt, Object paramObject, Uri paramUri)
  {
    a locala = (a)this.a.get();
    if (locala != null) {
      a.a(locala, paramInt, paramObject, paramUri);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */