package com.gau.go.launcherex.gowidget.messagecenter.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.SQLException;
import com.jiubang.core.c.j;
import java.lang.ref.WeakReference;

class e
  extends j
{
  private WeakReference a;
  
  public e(ContentResolver paramContentResolver, c paramc)
  {
    super(paramContentResolver);
    this.a = new WeakReference(paramc);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    super.a(paramInt, paramObject, paramCursor);
    paramObject = (c)this.a.get();
    if (paramObject == null) {
      if (paramCursor != null) {
        paramCursor.close();
      }
    }
    while (paramCursor == null) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramCursor.close();
      return;
      try
      {
        c.a((c)paramObject, paramCursor);
        continue;
      }
      catch (SQLException paramObject)
      {
        if (com.gtp.a.a.b.c.a()) {
          ((SQLException)paramObject).printStackTrace();
        }
        return;
        c.b((c)paramObject, paramCursor);
        continue;
      }
      finally
      {
        paramCursor.close();
      }
      c.c((c)paramObject, paramCursor);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */