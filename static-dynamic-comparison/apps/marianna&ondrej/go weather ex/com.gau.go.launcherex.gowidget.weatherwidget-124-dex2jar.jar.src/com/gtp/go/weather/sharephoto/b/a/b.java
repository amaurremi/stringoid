package com.gtp.go.weather.sharephoto.b.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
{
  public static int a(Context paramContext, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return paramContext.getContentResolver().update(WeatherContentProvider.z, paramContentValues, paramString, paramArrayOfString);
  }
  
  public static int a(Context paramContext, String paramString, String[] paramArrayOfString)
  {
    return paramContext.getContentResolver().delete(WeatherContentProvider.z, paramString, paramArrayOfString);
  }
  
  public static Uri a(Context paramContext, com.gtp.go.weather.sharephoto.b.b paramb)
  {
    paramContext = paramContext.getContentResolver();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("award_id", Long.valueOf(paramb.a()));
    localContentValues.put("user_award_id", Long.valueOf(paramb.b()));
    localContentValues.put("award_type", Integer.valueOf(paramb.c()));
    if (paramb.c() == 1)
    {
      paramb = paramb.d();
      localContentValues.put("apk_name", paramb.d());
      localContentValues.put("apk_package_name", paramb.c());
      localContentValues.put("apk_pic_path", paramb.b());
      localContentValues.put("apk_pic_url", paramb.a());
      localContentValues.put("apk_url", paramb.e());
      localContentValues.put("apk_url_type", Integer.valueOf(paramb.f()));
    }
    return paramContext.insert(WeatherContentProvider.z, localContentValues);
  }
  
  public static com.gtp.go.weather.sharephoto.b.b a(Cursor paramCursor)
  {
    com.gtp.go.weather.sharephoto.b.b localb = new com.gtp.go.weather.sharephoto.b.b();
    com.gtp.go.weather.sharephoto.b.a locala = new com.gtp.go.weather.sharephoto.b.a();
    localb.a(locala);
    int j = paramCursor.getColumnCount();
    int i = 0;
    if (i < j)
    {
      String str = paramCursor.getColumnName(i);
      if ("_id".equals(str)) {
        localb.a(paramCursor.getInt(i));
      }
      for (;;)
      {
        i += 1;
        break;
        if ("award_id".equals(str)) {
          localb.a(paramCursor.getLong(i));
        } else if ("user_award_id".equals(str)) {
          localb.b(paramCursor.getLong(i));
        } else if ("award_type".equals(str)) {
          localb.b(paramCursor.getInt(i));
        } else if ("apk_name".equals(str)) {
          locala.d(paramCursor.getString(i));
        } else if ("apk_package_name".equals(str)) {
          locala.c(paramCursor.getString(i));
        } else if ("apk_pic_path".equals(str)) {
          locala.b(paramCursor.getString(i));
        } else if ("apk_pic_url".equals(str)) {
          locala.a(paramCursor.getString(i));
        } else if ("apk_url".equals(str)) {
          locala.e(paramCursor.getString(i));
        } else if ("apk_url_type".equals(str)) {
          locala.a(paramCursor.getInt(i));
        }
      }
    }
    return localb;
  }
  
  public static com.gtp.go.weather.sharephoto.b.b a(JSONObject paramJSONObject)
  {
    com.gtp.go.weather.sharephoto.b.b localb = new com.gtp.go.weather.sharephoto.b.b();
    localb.a(paramJSONObject.optLong("awardId", -1L));
    localb.b(paramJSONObject.optInt("type", -1));
    if (localb.c() == 1)
    {
      paramJSONObject = paramJSONObject.optJSONObject("awardDetail");
      if (paramJSONObject != null) {
        localb.a(a.a(paramJSONObject));
      }
    }
    return localb;
  }
  
  public static List a(Context paramContext, String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getContentResolver().query(WeatherContentProvider.z, paramArrayOfString1, paramString, paramArrayOfString2, "_id");
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
  
  public static List a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramJSONArray.length();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(a(paramJSONArray.getJSONObject(i)));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */