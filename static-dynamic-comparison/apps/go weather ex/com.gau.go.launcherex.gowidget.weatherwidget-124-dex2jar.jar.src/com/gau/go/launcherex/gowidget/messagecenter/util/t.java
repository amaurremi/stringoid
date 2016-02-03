package com.gau.go.launcherex.gowidget.messagecenter.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.gau.go.launcherex.gowidget.messagecenter.a.c;
import com.gau.go.launcherex.gowidget.messagecenter.a.d;
import com.jiubang.core.c.j;
import java.util.Vector;

class t
  extends j
{
  public t(ContentResolver paramContentResolver)
  {
    super(paramContentResolver);
  }
  
  protected void a(int paramInt1, Object paramObject, int paramInt2)
  {
    super.a(paramInt1, paramObject, paramInt2);
  }
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    super.a(paramInt, paramObject, paramCursor);
    d locald;
    boolean bool;
    if (paramInt == 1)
    {
      localObject = new c();
      Vector localVector1 = ((c)localObject).a();
      if ((paramCursor != null) && (paramCursor.getCount() != 0)) {}
      try
      {
        paramCursor.moveToFirst();
        do
        {
          locald = new d();
          locald.a(paramCursor);
          localVector1.add(locald);
          bool = paramCursor.moveToNext();
        } while (bool);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
        }
      }
      if (paramCursor != null) {
        paramCursor.close();
      }
      i.b(((c)localObject).a());
      ((ag)paramObject).a((c)localObject);
    }
    do
    {
      for (;;)
      {
        return;
        if (paramInt == 2)
        {
          if ((paramCursor != null) && (paramCursor.getCount() != 0)) {
            localObject = new d();
          }
          try
          {
            paramCursor.moveToFirst();
            ((d)localObject).a(paramCursor);
            ((ag)paramObject).a((d)localObject);
            if (paramCursor != null)
            {
              paramCursor.close();
              return;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localException2.printStackTrace();
            }
          }
        }
      }
    } while (paramInt != 5);
    Object localObject = new c();
    Vector localVector2 = ((c)localObject).a();
    if ((paramCursor != null) && (paramCursor.getCount() != 0)) {}
    try
    {
      paramCursor.moveToFirst();
      do
      {
        locald = new d();
        locald.a(paramCursor);
        localVector2.add(locald);
        bool = paramCursor.moveToNext();
      } while (bool);
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        localException3.printStackTrace();
      }
    }
    if (paramCursor != null) {
      paramCursor.close();
    }
    i.b(((c)localObject).a());
    ((ag)paramObject).a((c)localObject);
  }
  
  protected void a(int paramInt, Object paramObject, Uri paramUri)
  {
    super.a(paramInt, paramObject, paramUri);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */