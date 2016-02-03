package com.gtp.go.weather.sharephoto.a;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gtp.go.weather.sharephoto.b.o;
import java.util.ArrayList;
import java.util.Iterator;

public class g
  implements d
{
  private static volatile g a;
  private Context b;
  private o c = new o();
  private i d;
  private a e;
  private boolean f = false;
  private boolean g = false;
  private ArrayList h = new ArrayList();
  
  private g(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.d = new i(this.b.getContentResolver(), this);
    this.e = new a(this.b);
    this.e.a(this);
    e();
  }
  
  public static g a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new g(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(Cursor paramCursor)
  {
    a(paramCursor, this.c);
  }
  
  private static void a(Cursor paramCursor, o paramo)
  {
    if (paramCursor == null) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        if (paramCursor.getCount() > 0)
        {
          paramCursor.moveToLast();
          int j = paramCursor.getColumnCount();
          i = 0;
          if (i < j)
          {
            String str = paramCursor.getColumnName(i);
            if (str.equals("user_id")) {
              paramo.a(paramCursor.getString(i));
            } else if (str.equals("user_gmail")) {
              paramo.b(paramCursor.getString(i));
            }
          }
        }
      }
      catch (Exception paramo)
      {
        paramo.printStackTrace();
        try
        {
          paramCursor.close();
          return;
        }
        catch (Exception paramCursor) {}
        paramCursor.printStackTrace();
        return;
      }
      finally
      {
        try
        {
          paramCursor.close();
          throw paramo;
        }
        catch (Exception paramCursor)
        {
          paramCursor.printStackTrace();
          continue;
        }
        try
        {
          paramCursor.close();
          return;
        }
        catch (Exception paramCursor) {}
        continue;
      }
      i += 1;
    }
  }
  
  public static o b(Context paramContext)
  {
    o localo = new o();
    a(paramContext.getContentResolver().query(WeatherContentProvider.u, null, null, null, "user_id"), localo);
    return localo;
  }
  
  private void e()
  {
    if (!this.f)
    {
      this.f = true;
      this.d.startQuery(1, null, WeatherContentProvider.u, new String[] { "user_id", "user_gmail" }, null, null, null);
    }
  }
  
  private void f()
  {
    g();
    if (!TextUtils.isEmpty(this.c.a()))
    {
      this.g = true;
      return;
    }
    this.e.a();
  }
  
  private void g()
  {
    Iterator localIterator = new ArrayList(this.h).iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).a(b());
    }
  }
  
  public void a(h paramh)
  {
    if ((paramh != null) && (!this.h.contains(paramh))) {
      this.h.add(paramh);
    }
  }
  
  public void a(o paramo)
  {
    if (!TextUtils.isEmpty(paramo.a()))
    {
      this.c.a(paramo.a());
      this.c.b(paramo.b());
      this.c.a(paramo.c());
      this.g = true;
      b(paramo);
    }
    g();
  }
  
  public boolean a()
  {
    return this.g;
  }
  
  public o b()
  {
    return this.c;
  }
  
  public void b(h paramh)
  {
    this.h.remove(paramh);
  }
  
  public void b(o paramo)
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CHANGE_USER_DATA");
    localIntent.putExtra("extra_user_id", paramo.a());
    localIntent.putExtra("extra_user_gamil", paramo.b());
    this.b.sendBroadcast(localIntent);
  }
  
  public a c()
  {
    return this.e;
  }
  
  public String d()
  {
    return this.c.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */