package com.go.weatherex.c;

import android.content.ContentResolver;
import android.database.Cursor;
import com.jiubang.core.c.j;
import java.lang.ref.WeakReference;

class l
  extends j
{
  private WeakReference a;
  
  public l(ContentResolver paramContentResolver, a parama)
  {
    super(paramContentResolver);
    this.a = new WeakReference(parama);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    paramObject = (a)this.a.get();
    if ((paramObject == null) || (paramCursor == null)) {}
    while (paramCursor.getCount() < 1) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    paramObject.getClass();
    a.a((a)paramObject, new e((a)paramObject, a.a((a)paramObject, paramCursor)));
    a.p((a)paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */