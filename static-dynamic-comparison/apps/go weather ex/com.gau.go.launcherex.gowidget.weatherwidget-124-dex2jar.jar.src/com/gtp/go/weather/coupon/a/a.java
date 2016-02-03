package com.gtp.go.weather.coupon.a;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import java.util.ArrayList;
import java.util.LinkedList;

public class a
{
  private static volatile a a;
  private Context b;
  
  private a(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
  }
  
  public static a a(Context paramContext)
  {
    if (a == null) {
      a = new a(paramContext);
    }
    return a;
  }
  
  public static ArrayList a(Context paramContext, String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getContentResolver().query(WeatherContentProvider.C, paramArrayOfString1, paramString, paramArrayOfString2, null);
    if (paramContext != null) {
      if (paramContext.moveToFirst())
      {
        int j = paramContext.getColumnCount();
        do
        {
          paramArrayOfString1 = new com.gtp.go.weather.coupon.b.b();
          int i = 0;
          if (i < j)
          {
            paramString = paramContext.getColumnName(i);
            if (paramString.equals("coupon_id")) {
              paramArrayOfString1.a(paramContext.getLong(i));
            }
            for (;;)
            {
              i += 1;
              break;
              if (paramString.equals("source_coupon_id")) {
                paramArrayOfString1.b(paramContext.getLong(i));
              } else if (paramString.equals("title")) {
                paramArrayOfString1.a(paramContext.getString(i));
              } else if (paramString.equals("desc")) {
                paramArrayOfString1.b(paramContext.getString(i));
              } else if (paramString.equals("coupon_type")) {
                paramArrayOfString1.a(paramContext.getInt(i));
              } else if (paramString.equals("shop_name")) {
                paramArrayOfString1.g(paramContext.getString(i));
              } else if (paramString.equals("exp_time")) {
                paramArrayOfString1.c(paramContext.getString(i));
              } else if (paramString.equals("code")) {
                paramArrayOfString1.d(paramContext.getString(i));
              } else if (paramString.equals("logo_url")) {
                paramArrayOfString1.e(paramContext.getString(i));
              } else if (paramString.equals("logo_path")) {
                paramArrayOfString1.f(paramContext.getString(i));
              }
            }
          }
          localArrayList.add(paramArrayOfString1);
        } while (paramContext.moveToNext());
      }
    }
    try
    {
      paramContext.close();
      return localArrayList;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return localArrayList;
  }
  
  private void a(LinkedList paramLinkedList, com.gtp.go.weather.coupon.b.b paramb)
  {
    int i = 0;
    for (;;)
    {
      if (i <= paramLinkedList.size())
      {
        if (i == paramLinkedList.size()) {
          paramLinkedList.add(paramb);
        }
      }
      else {
        return;
      }
      if (com.gtp.go.weather.coupon.c.a.a(((com.gtp.go.weather.coupon.b.b)paramLinkedList.get(i)).g(), paramb.g()))
      {
        paramLinkedList.add(i, paramb);
        return;
      }
      i += 1;
    }
  }
  
  private ArrayList b(ArrayList paramArrayList)
  {
    LinkedList localLinkedList = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayList.size() - 1;
    if (i >= 0)
    {
      if (com.gtp.go.weather.coupon.c.a.c(((com.gtp.go.weather.coupon.b.b)paramArrayList.get(i)).g())) {
        a(localLinkedList, (com.gtp.go.weather.coupon.b.b)paramArrayList.get(i));
      }
      for (;;)
      {
        i -= 1;
        break;
        localArrayList.add(paramArrayList.get(i));
      }
    }
    localArrayList.addAll(localLinkedList);
    return localArrayList;
  }
  
  public void a(com.gtp.go.weather.coupon.a parama)
  {
    new d(this, parama).execute(new Object[0]);
  }
  
  public void a(com.gtp.go.weather.coupon.b.b paramb)
  {
    if (paramb == null) {
      return;
    }
    new c(this, paramb).execute(new Object[0]);
  }
  
  public void a(ArrayList paramArrayList)
  {
    long[] arrayOfLong = new long[paramArrayList.size()];
    int i = 0;
    while (i < paramArrayList.size())
    {
      arrayOfLong[i] = ((Long)paramArrayList.get(i)).longValue();
      i += 1;
    }
    new b(this, paramArrayList).execute(new Object[0]);
    paramArrayList = new Intent();
    paramArrayList.setAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_COUPON_DELETE");
    paramArrayList.putExtra("extra_coupon_delete_id", arrayOfLong);
    this.b.sendBroadcast(paramArrayList);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */