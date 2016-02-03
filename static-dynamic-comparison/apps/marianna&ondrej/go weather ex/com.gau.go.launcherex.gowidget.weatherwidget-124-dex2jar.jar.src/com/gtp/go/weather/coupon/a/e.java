package com.gtp.go.weather.coupon.a;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.RemoteException;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gtp.a.a.b.c;
import com.gtp.go.weather.coupon.c.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class e
{
  private Context a;
  private com.jiubang.core.c.a.b b;
  private h c;
  
  public e(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static ArrayList a(Context paramContext, String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getContentResolver().query(WeatherContentProvider.B, paramArrayOfString1, paramString, paramArrayOfString2, null);
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
              } else if (paramString.equals("shop_name")) {
                paramArrayOfString1.g(paramContext.getString(i));
              } else if (paramString.equals("coupon_type")) {
                paramArrayOfString1.a(paramContext.getInt(i));
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
  
  private void a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.isEmpty())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    ContentValues localContentValues = new ContentValues();
    if (paramArrayList2 == null) {}
    for (;;)
    {
      paramArrayList1 = paramArrayList1.iterator();
      Object localObject;
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (com.gtp.go.weather.coupon.b.b)paramArrayList1.next();
        if (paramArrayList2 != null)
        {
          localContentValues.clear();
          localContentValues.put("coupon_id", Long.valueOf(paramArrayList2.b()));
          localContentValues.put("source_coupon_id", Long.valueOf(paramArrayList2.c()));
          localContentValues.put("title", paramArrayList2.d());
          localContentValues.put("desc", paramArrayList2.e());
          localContentValues.put("shop_name", paramArrayList2.m());
          localContentValues.put("coupon_type", Integer.valueOf(paramArrayList2.f()));
          localContentValues.put("exp_time", paramArrayList2.g());
          localContentValues.put("code", paramArrayList2.h());
          localContentValues.put("logo_url", paramArrayList2.i());
          if (!TextUtils.isEmpty(paramArrayList2.i()))
          {
            localObject = a.a(paramArrayList2.i());
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              paramArrayList2.f((String)localObject);
              localContentValues.put("logo_path", (String)localObject);
              if (new File((String)localObject).exists()) {
                paramArrayList2.b(true);
              }
            }
          }
          localArrayList.add(ContentProviderOperation.newInsert(WeatherContentProvider.B).withValues(localContentValues).build());
          continue;
          localObject = new ArrayList();
          paramArrayList1 = paramArrayList1.iterator();
        }
      }
      label274:
      label544:
      for (;;)
      {
        if (!paramArrayList1.hasNext()) {
          break label546;
        }
        com.gtp.go.weather.coupon.b.b localb1 = (com.gtp.go.weather.coupon.b.b)paramArrayList1.next();
        Iterator localIterator = paramArrayList2.iterator();
        int i;
        for (;;)
        {
          if (localIterator.hasNext())
          {
            com.gtp.go.weather.coupon.b.b localb2 = (com.gtp.go.weather.coupon.b.b)localIterator.next();
            if (localb2.b() == localb1.b())
            {
              localContentValues.clear();
              if (!localb2.g().equals(localb1.g()))
              {
                localb2.c(localb1.g());
                localContentValues.put("exp_time", localb1.g());
              }
              if (!localb2.e().equals(localb1.e()))
              {
                localb2.b(localb1.e());
                localContentValues.put("desc", localb1.e());
              }
              if (localContentValues.size() > 0)
              {
                localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.B).withValues(localContentValues).withSelection("coupon_id=?", new String[] { String.valueOf(localb2.b()) }).build());
                i = 1;
              }
            }
          }
        }
        for (;;)
        {
          if (i != 0) {
            break label544;
          }
          ((ArrayList)localObject).add(localb1);
          break label274;
          if ((localArrayList == null) || (localArrayList.isEmpty())) {
            break;
          }
          try
          {
            this.a.getContentResolver().applyBatch("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", localArrayList);
            return;
          }
          catch (RemoteException paramArrayList1)
          {
            if (!c.a()) {
              break;
            }
            paramArrayList1.printStackTrace();
            return;
          }
          catch (OperationApplicationException paramArrayList1) {}
          if (!c.a()) {
            break;
          }
          paramArrayList1.printStackTrace();
          return;
          i = 1;
          continue;
          i = 0;
        }
      }
      label546:
      paramArrayList1 = (ArrayList)localObject;
    }
  }
  
  public void a()
  {
    new k(this, null).execute(new Object[0]);
  }
  
  public void a(int paramInt, ArrayList paramArrayList)
  {
    new g(this, paramInt, paramArrayList).execute(new Object[0]);
  }
  
  public void a(h paramh)
  {
    this.c = paramh;
  }
  
  public void a(com.jiubang.core.c.a.b paramb)
  {
    this.b = paramb;
  }
  
  public void a(String paramString, long paramLong, i parami)
  {
    new j(this, paramString, paramLong, parami).execute(new Object[0]);
  }
  
  public void b()
  {
    if (this.c != null) {
      this.c = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */