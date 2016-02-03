package com.gtp.go.weather.sharephoto.b.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gtp.go.weather.sharephoto.b.d;
import com.gtp.go.weather.sharephoto.b.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
{
  public static int a(Context paramContext, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return paramContext.getContentResolver().update(WeatherContentProvider.y, paramContentValues, paramString, paramArrayOfString);
  }
  
  public static int a(Context paramContext, String paramString, String[] paramArrayOfString)
  {
    return paramContext.getContentResolver().delete(WeatherContentProvider.y, paramString, paramArrayOfString);
  }
  
  public static Uri a(Context paramContext, d paramd)
  {
    paramContext = paramContext.getContentResolver();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("award_desc", paramd.c());
    localContentValues.put("award_time", Long.valueOf(paramd.d()));
    localContentValues.put("award_type", Integer.valueOf(paramd.e()));
    localContentValues.put("is_receive", Integer.valueOf(paramd.j()));
    localContentValues.put("prompt_type", Integer.valueOf(paramd.b()));
    localContentValues.put("small_pic_path", paramd.g());
    localContentValues.put("small_pic_url", paramd.f());
    localContentValues.put("user_award_id", Long.valueOf(paramd.a()));
    localContentValues.put("award_id", Long.valueOf(paramd.h()));
    return paramContext.insert(WeatherContentProvider.y, localContentValues);
  }
  
  public static d a(Cursor paramCursor)
  {
    d locald = new d();
    int j = paramCursor.getColumnCount();
    int i = 0;
    if (i < j)
    {
      String str = paramCursor.getColumnName(i);
      if ("_id".equals(str)) {
        locald.a(paramCursor.getInt(i));
      }
      for (;;)
      {
        i += 1;
        break;
        if ("award_desc".equals(str)) {
          locald.a(paramCursor.getString(i));
        } else if ("award_id".equals(str)) {
          locald.c(paramCursor.getLong(i));
        } else if ("award_time".equals(str)) {
          locald.b(paramCursor.getLong(i));
        } else if ("award_type".equals(str)) {
          locald.c(paramCursor.getInt(i));
        } else if ("is_receive".equals(str)) {
          locald.d(paramCursor.getInt(i));
        } else if ("prompt_type".equals(str)) {
          locald.b(paramCursor.getInt(i));
        } else if ("small_pic_path".equals(str)) {
          locald.c(paramCursor.getString(i));
        } else if ("small_pic_url".equals(str)) {
          locald.b(paramCursor.getString(i));
        } else if ("user_award_id".equals(str)) {
          locald.a(paramCursor.getLong(i));
        }
      }
    }
    return locald;
  }
  
  public static d a(JSONObject paramJSONObject)
  {
    d locald = new d();
    locald.a(paramJSONObject.optLong("userAwardId", -1L));
    locald.b(paramJSONObject.optInt("promptType", -1));
    locald.a(paramJSONObject.optString("awardDesc", ""));
    locald.b(paramJSONObject.optLong("awardTime", 0L));
    locald.c(paramJSONObject.optInt("awardType", -1));
    JSONObject localJSONObject = paramJSONObject.optJSONObject("smallPic");
    if (localJSONObject != null) {
      locald.b(f.a(localJSONObject).a());
    }
    locald.d(paramJSONObject.optInt("isReceive", 0));
    if (locald.j() != 0)
    {
      paramJSONObject = b.a(paramJSONObject.optJSONObject("award"));
      paramJSONObject.b(locald.a());
      locald.c(paramJSONObject.a());
      locald.a(paramJSONObject);
    }
    return locald;
  }
  
  public static List a(Context paramContext, String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getContentResolver().query(WeatherContentProvider.y, paramArrayOfString1, paramString, paramArrayOfString2, "_id");
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */