package com.gtp.go.weather.sharephoto.b.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gtp.go.weather.sharephoto.b.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
{
  public static int a(Context paramContext, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return paramContext.getContentResolver().update(WeatherContentProvider.w, paramContentValues, paramString, paramArrayOfString);
  }
  
  public static int a(Context paramContext, String paramString, String[] paramArrayOfString)
  {
    return paramContext.getContentResolver().delete(WeatherContentProvider.w, paramString, paramArrayOfString);
  }
  
  public static Uri a(Context paramContext, e parame)
  {
    paramContext = paramContext.getContentResolver();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("photo_id", Long.valueOf(parame.f()));
    localContentValues.put("photo_path", parame.g());
    localContentValues.put("photo_upload_size", Long.valueOf(parame.i()));
    localContentValues.put("has_watermark", String.valueOf(parame.e()));
    localContentValues.put("description", parame.a());
    localContentValues.put("city_id", parame.b());
    localContentValues.put("city_name", parame.c());
    if (parame.e())
    {
      localContentValues.put("watermark_path", parame.h());
      localContentValues.put("watermark_upload_size", Long.valueOf(parame.j()));
    }
    return paramContext.insert(WeatherContentProvider.w, localContentValues);
  }
  
  public static e a(Cursor paramCursor)
  {
    e locale = new e();
    int j = paramCursor.getColumnCount();
    int i = 0;
    if (i < j)
    {
      String str = paramCursor.getColumnName(i);
      if ("_id".equals(str)) {
        locale.a(paramCursor.getInt(i));
      }
      for (;;)
      {
        i += 1;
        break;
        if ("photo_id".equals(str)) {
          locale.a(paramCursor.getLong(i));
        } else if ("photo_path".equals(str)) {
          locale.d(paramCursor.getString(i));
        } else if ("photo_upload_size".equals(str)) {
          locale.b(paramCursor.getLong(i));
        } else if ("watermark_path".equals(str)) {
          locale.e(paramCursor.getString(i));
        } else if ("watermark_upload_size".equals(str)) {
          locale.c(paramCursor.getLong(i));
        } else if ("has_watermark".equals(str)) {
          locale.a(Boolean.valueOf(paramCursor.getString(i)).booleanValue());
        } else if ("description".equals(str)) {
          locale.a(paramCursor.getString(i));
        } else if ("city_id".equals(str)) {
          locale.b(paramCursor.getString(i));
        } else if ("city_name".equals(str)) {
          locale.c(paramCursor.getString(i));
        }
      }
    }
    return locale;
  }
  
  public static List a(Context paramContext)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = a(paramContext, new String[] { "_id", "photo_id", "photo_path", "photo_upload_size", "watermark_path", "watermark_upload_size", "description", "city_id", "city_name" }, null, null).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (!locale.l())
      {
        localArrayList2.add(locale);
      }
      else
      {
        if ((locale.e()) && (!locale.m())) {
          locale.a(false);
        }
        localArrayList1.add(locale);
      }
    }
    a(paramContext, localArrayList2);
    return localArrayList1;
  }
  
  public static List a(Context paramContext, String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getContentResolver().query(WeatherContentProvider.w, paramArrayOfString1, paramString, paramArrayOfString2, "photo_id");
    if (paramContext != null)
    {
      if (paramContext.moveToFirst()) {
        do
        {
          localArrayList.add(a(paramContext));
        } while (paramContext.moveToNext());
      }
      paramContext.close();
    }
    return localArrayList;
  }
  
  public static void a(Context paramContext, List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramContext, "photo_id=?", new String[] { String.valueOf(((e)paramList.next()).f()) });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/b/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */