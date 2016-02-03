package com.mocoplex.adlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  private static c b = null;
  Hashtable<String, ArrayList<b>> a = new Hashtable();
  private Handler c = null;
  
  public static c a()
  {
    try
    {
      if (b == null) {
        b = new c();
      }
      c localc = b;
      return localc;
    }
    finally {}
  }
  
  public static void a(Context paramContext, String paramString)
  {
    int i = c(paramContext, paramString);
    if (i == -1) {
      return;
    }
    a(paramContext, paramString, i + 1);
  }
  
  private static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("adlibr_dlg_cnt", 0).edit();
      paramContext.putInt(paramString, paramInt);
      paramContext.commit();
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("adlibr_dlg", 0).edit();
      paramContext.putString(paramString1, paramString2);
      paramContext.commit();
    }
  }
  
  public static void b()
  {
    b = null;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    int i = c(paramContext, paramString);
    if (i <= 0) {
      return;
    }
    a(paramContext, paramString, i - 1);
  }
  
  public static int c(Context paramContext, String paramString)
  {
    int i = -1;
    if (paramContext != null) {
      i = paramContext.getSharedPreferences("adlibr_dlg_cnt", 0).getInt(paramString, -1);
    }
    return i;
  }
  
  public static String d(Context paramContext, String paramString)
  {
    String str = null;
    if (paramContext != null) {
      str = paramContext.getSharedPreferences("adlibr_dlg", 0).getString(paramString, null);
    }
    return str;
  }
  
  public final ArrayList<b> a(String paramString)
  {
    return (ArrayList)this.a.get(paramString);
  }
  
  public final void a(Context paramContext)
  {
    a(paramContext, true);
  }
  
  protected final void a(Context paramContext, boolean paramBoolean)
  {
    Object localObject1 = AdlibConfig.getInstance().c("dialog");
    for (;;)
    {
      String str1;
      int i;
      String str2;
      int j;
      try
      {
        JSONArray localJSONArray = new JSONArray((String)localObject1);
        this.a.clear();
        str1 = d(paramContext, "last_updated_time");
        i = 0;
        if (i >= localJSONArray.length())
        {
          if (this.c != null)
          {
            a(paramContext, "last_updated_time", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
            this.c.sendEmptyMessage(10);
            this.c = null;
          }
        }
        else
        {
          str2 = (String)localJSONArray.get(i);
          localObject2 = new JSONObject(d(paramContext, str2));
          j = Integer.parseInt(((JSONObject)localObject2).getString("cnt"));
        }
      }
      catch (Exception paramContext)
      {
        Object localObject2;
        ArrayList localArrayList;
        return;
      }
      try
      {
        bool = ((JSONObject)localObject2).getString("daily").equals("Y");
        if (!bool) {
          break;
        }
        bool = true;
      }
      catch (Exception localException2)
      {
        bool = false;
        continue;
      }
      if (!bool)
      {
        localObject1 = new b(str2, j, Integer.parseInt(((JSONObject)localObject2).getString("prob")), ((JSONObject)localObject2).getString("ver"));
        localObject2 = (String)((JSONObject)localObject2).get("when");
        if (this.a.containsKey(localObject2))
        {
          ((ArrayList)this.a.get(localObject2)).add(localObject1);
          if (!paramBoolean) {
            break label330;
          }
          if ((j == 0) || (c(paramContext, str2) != -1)) {
            break label389;
          }
          a(paramContext, str2, 0);
          break label389;
        }
      }
      else
      {
        localObject1 = new b(str2, j, Integer.parseInt(((JSONObject)localObject2).getString("prob")), ((JSONObject)localObject2).getString("ver"), bool);
        continue;
      }
      localArrayList = new ArrayList();
      localArrayList.add(localObject1);
      this.a.put(localObject2, localArrayList);
      continue;
      label330:
      if (bool)
      {
        try
        {
          if ((new SimpleDateFormat("yyyyMMdd").format(new Date()).equals(str1.substring(0, 8))) || (j == 0)) {
            break label389;
          }
          a(paramContext, str2, 0);
        }
        catch (Exception localException1) {}
        return;
      }
      label389:
      i += 1;
    }
  }
  
  public final void a(Handler paramHandler)
  {
    this.c = paramHandler;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */