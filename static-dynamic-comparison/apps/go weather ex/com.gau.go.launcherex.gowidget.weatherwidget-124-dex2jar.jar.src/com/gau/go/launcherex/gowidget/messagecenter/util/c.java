package com.gau.go.launcherex.gowidget.messagecenter.util;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.a;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class c
{
  private Context a;
  private e b;
  private g c;
  private f d;
  
  public c(Context paramContext)
  {
    this.a = paramContext;
    this.b = new e(this.a.getContentResolver(), this);
  }
  
  private void a(Cursor paramCursor)
  {
    new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    paramCursor = d(paramCursor).iterator();
    while (paramCursor.hasNext())
    {
      localObject = (a)paramCursor.next();
      if (((a)localObject).e() == 0)
      {
        if (com.gau.go.launcherex.gowidget.weather.globaltheme.c.b.a((a)localObject))
        {
          if (com.gau.go.launcherex.gowidget.weather.globaltheme.c.b.b((a)localObject)) {
            localArrayList4.add(localObject);
          } else {
            localArrayList3.add(localObject);
          }
        }
        else {
          localArrayList1.add(localObject);
        }
      }
      else if (com.gau.go.launcherex.gowidget.weather.globaltheme.c.b.a((a)localObject)) {
        localArrayList4.add(localObject);
      } else {
        localArrayList2.add(localObject);
      }
    }
    paramCursor = new com.gau.go.launcherex.gowidget.weather.globaltheme.b.c();
    Object localObject = new com.gau.go.launcherex.gowidget.weather.globaltheme.b.b();
    Collections.sort(localArrayList1, paramCursor);
    Collections.sort(localArrayList3, Collections.reverseOrder(paramCursor));
    Collections.sort(localArrayList2, Collections.reverseOrder((Comparator)localObject));
    b(localArrayList1);
    c(localArrayList2);
    d(localArrayList3);
    e(localArrayList4);
  }
  
  private void b(Cursor paramCursor)
  {
    new ArrayList();
    ArrayList localArrayList = new ArrayList();
    paramCursor = d(paramCursor).iterator();
    while (paramCursor.hasNext())
    {
      a locala = (a)paramCursor.next();
      if (!com.gau.go.launcherex.gowidget.weather.globaltheme.c.b.a(locala)) {
        localArrayList.add(locala);
      }
    }
    Collections.sort(localArrayList, new com.gau.go.launcherex.gowidget.weather.globaltheme.b.c());
    b(localArrayList);
  }
  
  private void b(ArrayList paramArrayList)
  {
    if (this.c != null) {
      this.c.a(paramArrayList);
    }
  }
  
  private void c(Cursor paramCursor)
  {
    new ArrayList();
    ArrayList localArrayList = new ArrayList();
    paramCursor = d(paramCursor);
    boolean bool;
    if (paramCursor.size() > 0)
    {
      Iterator localIterator = paramCursor.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (com.gau.go.launcherex.gowidget.weather.globaltheme.c.b.b(locala)) {
          localArrayList.add(locala);
        }
      }
      if (paramCursor.size() > localArrayList.size())
      {
        bool = true;
        e(localArrayList);
      }
    }
    for (;;)
    {
      if (this.d != null) {
        this.d.a(bool);
      }
      return;
      bool = false;
      break;
      bool = false;
    }
  }
  
  private void c(ArrayList paramArrayList)
  {
    if (this.c != null) {
      this.c.b(paramArrayList);
    }
  }
  
  private ArrayList d(Cursor paramCursor)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramCursor.moveToFirst())
    {
      int j = paramCursor.getColumnCount();
      do
      {
        a locala = new a();
        int i = 0;
        if (i < j)
        {
          String str = paramCursor.getColumnName(i);
          if ("_id".equals(str)) {
            locala.a(paramCursor.getInt(i));
          }
          for (;;)
          {
            i += 1;
            break;
            if ("consumed".equals(str)) {
              locala.c(paramCursor.getInt(i));
            } else if ("consumed_time".equals(str)) {
              locala.b(paramCursor.getLong(i));
            } else if ("coupon_value".equals(str)) {
              locala.b(paramCursor.getInt(i));
            } else if ("expired_time".equals(str)) {
              locala.a(paramCursor.getLong(i));
            } else if ("coupon_id".equals(str)) {
              locala.a(paramCursor.getString(i));
            }
          }
        }
        localArrayList.add(locala);
      } while (paramCursor.moveToNext());
    }
    return localArrayList;
  }
  
  private void d(ArrayList paramArrayList)
  {
    if (this.c != null) {
      this.c.c(paramArrayList);
    }
  }
  
  private void e(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      a locala = (a)paramArrayList.next();
      localArrayList.add(ContentProviderOperation.newDelete(WeatherContentProvider.E).withSelection("coupon_id=?", new String[] { locala.a() }).build());
    }
    if (localArrayList.size() > 0) {
      this.b.a(-1, null, "com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", localArrayList);
    }
  }
  
  public void a()
  {
    this.b.a(2, null, WeatherContentProvider.E, new String[] { "_id", "expired_time", "coupon_id", "coupon_value", "consumed", "consumed_time" }, "consumed=?", new String[] { String.valueOf(0) }, "expired_time asc");
  }
  
  public void a(g paramg)
  {
    this.c = paramg;
  }
  
  public void a(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("consumed", Integer.valueOf(1));
    localContentValues.put("consumed_time", Long.valueOf(System.currentTimeMillis()));
    this.b.a(-1, null, WeatherContentProvider.E, localContentValues, "coupon_id=?", new String[] { paramString });
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null) {
      new d(this).execute(new ArrayList[] { paramArrayList });
    }
  }
  
  public void b()
  {
    this.b.a(1, null, WeatherContentProvider.E, new String[] { "_id", "expired_time", "coupon_id", "coupon_value", "consumed", "consumed_time" }, null, null, "_id");
  }
  
  public void c()
  {
    this.d = null;
    this.c = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */