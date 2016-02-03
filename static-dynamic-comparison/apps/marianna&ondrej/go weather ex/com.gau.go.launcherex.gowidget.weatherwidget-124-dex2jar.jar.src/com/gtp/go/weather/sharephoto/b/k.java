package com.gtp.go.weather.sharephoto.b;

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

public class k
{
  private int a;
  private int b;
  private int c = -1;
  private int d;
  private int e;
  private String f;
  private int g = -1;
  private boolean h = true;
  
  public static int a(Context paramContext, String paramString, String[] paramArrayOfString)
  {
    return paramContext.getContentResolver().delete(WeatherContentProvider.A, paramString, paramArrayOfString);
  }
  
  public static Uri a(Context paramContext, k paramk)
  {
    paramContext = paramContext.getContentResolver();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("local_type", Integer.valueOf(paramk.d()));
    localContentValues.put("page_type", Integer.valueOf(paramk.d()));
    localContentValues.put("prompt_text", paramk.e());
    localContentValues.put("prompt_type", Integer.valueOf(paramk.f()));
    localContentValues.put("prompt_id", Integer.valueOf(paramk.b()));
    localContentValues.put("response_type", Integer.valueOf(paramk.c()));
    if (paramk.a()) {}
    for (int i = 1;; i = 0)
    {
      localContentValues.put("need_show", Integer.valueOf(i));
      return paramContext.insert(WeatherContentProvider.A, localContentValues);
    }
  }
  
  public static k a(Cursor paramCursor)
  {
    k localk = new k();
    int j = paramCursor.getColumnCount();
    int i = 0;
    if (i < j)
    {
      String str = paramCursor.getColumnName(i);
      if ("_id".equals(str)) {
        localk.a(paramCursor.getInt(i));
      }
      label211:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if ("local_type".equals(str))
          {
            localk.e(paramCursor.getInt(i));
          }
          else if ("prompt_text".equals(str))
          {
            localk.a(paramCursor.getString(i));
          }
          else if ("page_type".equals(str))
          {
            localk.d(paramCursor.getInt(i));
          }
          else if ("prompt_type".equals(str))
          {
            localk.f(paramCursor.getInt(i));
          }
          else if ("prompt_id".equals(str))
          {
            localk.b(paramCursor.getInt(i));
          }
          else
          {
            if (!"response_type".equals(str)) {
              break label211;
            }
            localk.c(paramCursor.getInt(i));
          }
        }
      } while (!"need_show".equals(str));
      if (paramCursor.getInt(i) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localk.a(bool);
        break;
      }
    }
    return localk;
  }
  
  public static k a(JSONObject paramJSONObject)
  {
    k localk = new k();
    localk.e(paramJSONObject.optInt("localType", 1));
    localk.d(paramJSONObject.optInt("pageType", 1));
    localk.a(paramJSONObject.optString("text", ""));
    localk.f(paramJSONObject.optInt("promptType", -1));
    localk.b(paramJSONObject.getInt("promptId"));
    localk.c(paramJSONObject.optInt("responseType", -1));
    return localk;
  }
  
  public static List a(Context paramContext, String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getContentResolver().query(WeatherContentProvider.A, paramArrayOfString1, paramString, paramArrayOfString2, "_id");
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
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean a()
  {
    return this.h;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public void d(int paramInt)
  {
    this.d = paramInt;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public void e(int paramInt)
  {
    this.e = paramInt;
  }
  
  public int f()
  {
    return this.g;
  }
  
  public void f(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */