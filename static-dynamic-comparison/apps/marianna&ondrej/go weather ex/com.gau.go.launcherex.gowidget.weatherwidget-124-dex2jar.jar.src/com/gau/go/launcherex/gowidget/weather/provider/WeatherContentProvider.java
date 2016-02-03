package com.gau.go.launcherex.gowidget.weather.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.d.f;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class WeatherContentProvider
  extends ContentProvider
{
  public static final Uri A;
  public static final Uri B;
  public static final Uri C;
  public static final Uri D;
  public static final Uri E;
  public static final Uri F;
  public static final Uri G;
  public static final Uri H;
  public static final Uri I;
  private static final Uri J = Uri.parse("content://com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider/");
  private static final UriMatcher K;
  private static volatile a L;
  public static final Uri a = Uri.parse(J.toString() + "citynow");
  public static final Uri b = Uri.parse(J.toString() + "forecast");
  @Deprecated
  public static final Uri c = Uri.parse(J.toString() + "weather11_city");
  public static final Uri d = Uri.parse(J.toString() + "weather11_city" + "citynow");
  public static final Uri e = Uri.parse(J.toString() + "hourly");
  public static final Uri f = Uri.parse(J.toString() + "alarm");
  public static final Uri g = Uri.parse(J.toString() + "common_setting_table");
  public static final Uri h = Uri.parse(J.toString() + "app_widget_theme_table");
  public static final Uri i = Uri.parse(J.toString() + "gowidget_theme_table");
  public static final Uri j = Uri.parse(J.toString() + "Google_play_billing");
  public static final Uri k = Uri.parse(J.toString() + "extreme");
  public static final Uri l = Uri.parse(J.toString() + "go_widget_binding_city_table");
  public static final Uri m = Uri.parse(J.toString() + "recommended_apps");
  public static final Uri n = Uri.parse(J.toString() + "msg_center");
  public static final Uri o = Uri.parse(J.toString() + "goweatherex_info");
  public static final Uri p = Uri.parse(J.toString() + "messagecenter");
  public static final Uri q = Uri.parse(J.toString() + "featured_theme_table");
  public static final Uri r = Uri.parse(J.toString() + "featured_theme_tab_table");
  public static final Uri s = Uri.parse(J.toString() + "ad_info_table");
  public static final Uri t = Uri.parse(J.toString() + "appwidget_info_table");
  public static final Uri u = Uri.parse(J.toString() + "user_table");
  public static final Uri v = Uri.parse(J.toString() + "photo_table");
  public static final Uri w = Uri.parse(J.toString() + "my_photo_table");
  public static final Uri x = Uri.parse(J.toString() + "photo_upload_table");
  public static final Uri y = Uri.parse(J.toString() + "my_award_table");
  public static final Uri z = Uri.parse(J.toString() + "award_table");
  
  static
  {
    A = Uri.parse(J.toString() + "prompt_table");
    B = Uri.parse(J.toString() + "coupons_hot_table");
    C = Uri.parse(J.toString() + "coupons_collect_table");
    D = Uri.parse(J.toString() + "next_widget_binding_city_table");
    E = Uri.parse(J.toString() + "coupon_table");
    F = Uri.parse(J.toString() + "promo_table");
    G = Uri.parse(J.toString() + "pollenIndex");
    H = Uri.parse(J.toString() + "pollensource");
    I = Uri.parse(J.toString() + "user_permission");
    K = new UriMatcher(-1);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "citynow", 101);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "forecast", 102);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "weather11_city", 103);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "weather11_citycitynow", 104);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "hourly", 105);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "alarm", 106);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "common_setting_table", 107);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "app_widget_theme_table", 108);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "gowidget_theme_table", 109);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "Google_play_billing", 110);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "extreme", 111);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "go_widget_binding_city_table", 112);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "recommended_apps", 113);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "msg_center", 114);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "goweatherex_info", 115);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "messagecenter", 116);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "featured_theme_table", 117);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "featured_theme_tab_table", 118);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "ad_info_table", 119);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "user_table", 124);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "photo_table", 125);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "my_photo_table", 126);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "photo_upload_table", 127);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "my_award_table", 128);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "award_table", 129);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "prompt_table", 130);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "next_widget_binding_city_table", 120);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "coupon_table", 121);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "promo_table", 122);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "appwidget_info_table", 123);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "pollenIndex", 131);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "pollensource", 132);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "coupons_hot_table", 133);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "coupons_collect_table", 134);
    K.addURI("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", "user_permission", 135);
  }
  
  /* Error */
  public android.content.ContentProviderResult[] applyBatch(java.util.ArrayList paramArrayList)
  {
    // Byte code:
    //   0: getstatic 233	com/gau/go/launcherex/gowidget/weather/provider/WeatherContentProvider:L	Lcom/gau/go/launcherex/gowidget/weather/provider/a;
    //   3: invokevirtual 239	com/gau/go/launcherex/gowidget/weather/provider/a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore_3
    //   7: aload_3
    //   8: invokevirtual 244	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   11: aload_0
    //   12: aload_1
    //   13: invokespecial 246	android/content/ContentProvider:applyBatch	(Ljava/util/ArrayList;)[Landroid/content/ContentProviderResult;
    //   16: astore_1
    //   17: aload_3
    //   18: invokevirtual 249	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   21: aload_3
    //   22: invokevirtual 252	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   25: aload_1
    //   26: areturn
    //   27: astore_2
    //   28: aconst_null
    //   29: astore_1
    //   30: aload_2
    //   31: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   34: aload_3
    //   35: invokevirtual 252	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   38: aload_1
    //   39: areturn
    //   40: astore_2
    //   41: aload_2
    //   42: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   45: aload_1
    //   46: areturn
    //   47: astore_1
    //   48: aload_3
    //   49: invokevirtual 252	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   52: aload_1
    //   53: athrow
    //   54: astore_2
    //   55: aload_2
    //   56: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   59: goto -7 -> 52
    //   62: astore_2
    //   63: goto -22 -> 41
    //   66: astore_2
    //   67: goto -37 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	WeatherContentProvider
    //   0	70	1	paramArrayList	java.util.ArrayList
    //   27	4	2	localException1	Exception
    //   40	2	2	localException2	Exception
    //   54	2	2	localException3	Exception
    //   62	1	2	localException4	Exception
    //   66	1	2	localException5	Exception
    //   6	43	3	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   11	17	27	java/lang/Exception
    //   34	38	40	java/lang/Exception
    //   11	17	47	finally
    //   17	21	47	finally
    //   30	34	47	finally
    //   48	52	54	java/lang/Exception
    //   21	25	62	java/lang/Exception
    //   17	21	66	java/lang/Exception
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int i1 = K.match(paramUri);
    String str2 = "";
    String str1 = str2;
    switch (i1)
    {
    default: 
      str1 = str2;
    }
    while (!"".equals(str1))
    {
      i1 = L.a(str1, paramString, paramArrayOfString);
      if (i1 > 0) {
        getContext().getContentResolver().notifyChange(paramUri, null);
      }
      return i1;
      str1 = "citynow";
      continue;
      str1 = "forecast";
      continue;
      str1 = "weather11_city";
      continue;
      str1 = "hourly";
      continue;
      str1 = "alarm";
      continue;
      str1 = "common_setting_table";
      continue;
      str1 = "app_widget_theme_table";
      continue;
      str1 = "gowidget_theme_table";
      continue;
      str1 = "extreme";
      continue;
      str1 = "go_widget_binding_city_table";
      continue;
      str1 = "recommended_apps";
      continue;
      str1 = "msg_center";
      continue;
      str1 = "messagecenter";
      continue;
      str1 = "featured_theme_table";
      continue;
      str1 = "featured_theme_tab_table";
      continue;
      str1 = "ad_info_table";
      continue;
      str1 = "next_widget_binding_city_table";
      continue;
      str1 = "coupon_table";
      continue;
      str1 = "promo_table";
      continue;
      str1 = "appwidget_info_table";
      continue;
      str1 = "user_table";
      continue;
      str1 = "photo_table";
      continue;
      str1 = "my_photo_table";
      continue;
      str1 = "photo_upload_table";
      continue;
      str1 = "my_award_table";
      continue;
      str1 = "award_table";
      continue;
      str1 = "prompt_table";
      continue;
      str1 = "pollenIndex";
      continue;
      str1 = "pollensource";
      continue;
      str1 = "coupons_hot_table";
      continue;
      str1 = "coupons_collect_table";
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    int i1 = K.match(paramUri);
    String str2 = "";
    String str1 = str2;
    switch (i1)
    {
    default: 
      str1 = str2;
    }
    while (!"".equals(str1))
    {
      long l1 = L.a(str1, paramContentValues);
      if (l1 <= 0L) {
        break;
      }
      paramContentValues = ContentUris.withAppendedId(J, l1);
      getContext().getContentResolver().notifyChange(paramUri, null);
      return paramContentValues;
      str1 = "citynow";
      continue;
      str1 = "forecast";
      continue;
      str1 = "weather11_city";
      continue;
      str1 = "hourly";
      continue;
      str1 = "alarm";
      continue;
      str1 = "common_setting_table";
      continue;
      str1 = "app_widget_theme_table";
      continue;
      str1 = "gowidget_theme_table";
      continue;
      str1 = "extreme";
      continue;
      str1 = "go_widget_binding_city_table";
      continue;
      str1 = "recommended_apps";
      continue;
      str1 = "msg_center";
      continue;
      str1 = "messagecenter";
      continue;
      str1 = "featured_theme_table";
      continue;
      str1 = "featured_theme_tab_table";
      continue;
      str1 = "ad_info_table";
      continue;
      str1 = "next_widget_binding_city_table";
      continue;
      str1 = "coupon_table";
      continue;
      str1 = "promo_table";
      continue;
      str1 = "appwidget_info_table";
      continue;
      str1 = "user_table";
      continue;
      str1 = "photo_table";
      continue;
      str1 = "my_photo_table";
      continue;
      str1 = "photo_upload_table";
      continue;
      str1 = "my_award_table";
      continue;
      str1 = "award_table";
      continue;
      str1 = "prompt_table";
      continue;
      str1 = "pollenIndex";
      continue;
      str1 = "pollensource";
      continue;
      str1 = "coupons_hot_table";
      continue;
      str1 = "coupons_collect_table";
    }
    return null;
  }
  
  public boolean onCreate()
  {
    if (L == null) {
      L = a.a(getContext(), "weather.db", 55);
    }
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    int i1 = 2;
    Cursor localCursor = null;
    int i3 = 1;
    int i2 = 0;
    boolean bool1;
    boolean bool2;
    switch (K.match(paramUri))
    {
    default: 
      paramUri = "";
    case 101: 
    case 102: 
    case 103: 
    case 104: 
    case 105: 
    case 106: 
    case 107: 
    case 108: 
    case 109: 
    case 111: 
    case 112: 
    case 113: 
    case 114: 
    case 110: 
    case 116: 
    case 117: 
    case 118: 
    case 119: 
    case 115: 
    case 120: 
    case 121: 
    case 122: 
    case 123: 
    case 124: 
    case 125: 
    case 126: 
    case 127: 
    case 128: 
    case 129: 
    case 130: 
    case 131: 
    case 132: 
    case 133: 
    case 134: 
      for (;;)
      {
        if (!"".equals(paramUri)) {
          localCursor = L.a(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2, null);
        }
        return localCursor;
        paramUri = "citynow";
        continue;
        paramUri = "forecast";
        continue;
        paramUri = "weather11_city";
        continue;
        paramUri = "weather11_city, citynow";
        continue;
        paramUri = "hourly";
        continue;
        paramUri = "alarm";
        continue;
        paramUri = "common_setting_table";
        continue;
        paramUri = "app_widget_theme_table";
        continue;
        paramUri = "gowidget_theme_table";
        continue;
        paramUri = "extreme";
        continue;
        paramUri = "go_widget_binding_city_table";
        continue;
        paramUri = "recommended_apps";
        continue;
        paramUri = "msg_center";
        continue;
        paramUri = new MatrixCursor(new String[] { "purchase_state" });
        if (GoWidgetApplication.b(getContext().getApplicationContext()).b()) {}
        for (i1 = i3;; i1 = 0)
        {
          paramUri.addRow(new Integer[] { Integer.valueOf(i1) });
          return paramUri;
        }
        paramUri = "messagecenter";
        continue;
        paramUri = "featured_theme_table";
        continue;
        paramUri = "featured_theme_tab_table";
        continue;
        paramUri = "ad_info_table";
        continue;
        paramUri = GoWidgetApplication.c(getContext().getApplicationContext());
        if (paramUri == null) {
          break;
        }
        paramUri = paramUri.a();
        paramArrayOfString1 = new MatrixCursor(new String[] { "flag_new_theme", "flag_nextlite_notification" });
        bool1 = paramUri.getBoolean("new_theme", false);
        bool2 = paramUri.getBoolean("key_show_nextlite_notification", false);
        if (bool1) {}
        for (i1 = 1;; i1 = 0)
        {
          if (bool2) {
            i2 = 1;
          }
          paramArrayOfString1.addRow(new Integer[] { Integer.valueOf(i1), Integer.valueOf(i2) });
          return paramArrayOfString1;
        }
        paramUri = "next_widget_binding_city_table";
        continue;
        paramUri = "coupon_table";
        continue;
        paramUri = "promo_table";
        continue;
        paramUri = "appwidget_info_table";
        continue;
        paramUri = "user_table";
        continue;
        paramUri = "photo_table";
        continue;
        paramUri = "my_photo_table";
        continue;
        paramUri = "photo_upload_table";
        continue;
        paramUri = "my_award_table";
        continue;
        paramUri = "award_table";
        continue;
        paramUri = "prompt_table";
        continue;
        paramUri = "pollenIndex";
        continue;
        paramUri = "pollensource";
        continue;
        paramUri = "coupons_hot_table";
        continue;
        paramUri = "coupons_collect_table";
      }
    }
    paramUri = GoWidgetApplication.b(getContext().getApplicationContext());
    if (paramUri != null) {
      if (paramUri.d()) {
        i1 = 1;
      }
    }
    for (;;)
    {
      paramUri = new MatrixCursor(new String[] { "purchase_state" });
      paramUri.addRow(new Integer[] { Integer.valueOf(i1) });
      return paramUri;
      bool1 = paramUri.c();
      bool2 = paramUri.b();
      if ((bool1) && (bool2)) {
        i1 = 4;
      } else if (!bool1) {
        if (bool2) {
          i1 = 3;
        } else {
          i1 = 0;
        }
      }
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    Object localObject;
    switch (K.match(paramUri))
    {
    case 104: 
    case 110: 
    default: 
      localObject = "";
    }
    while (!"".equals(localObject))
    {
      int i1 = L.a((String)localObject, paramContentValues, paramString, paramArrayOfString);
      if (i1 > 0) {
        getContext().getContentResolver().notifyChange(paramUri, null);
      }
      return i1;
      localObject = "citynow";
      continue;
      localObject = "forecast";
      continue;
      localObject = "weather11_city";
      continue;
      localObject = "hourly";
      continue;
      localObject = "alarm";
      continue;
      localObject = "common_setting_table";
      continue;
      localObject = "app_widget_theme_table";
      continue;
      localObject = "gowidget_theme_table";
      continue;
      localObject = "extreme";
      continue;
      localObject = "go_widget_binding_city_table";
      continue;
      localObject = "recommended_apps";
      continue;
      localObject = "msg_center";
      continue;
      localObject = GoWidgetApplication.c(getContext().getApplicationContext());
      if (localObject != null)
      {
        localObject = ((com.jiubang.core.b.a)localObject).a().edit();
        Iterator localIterator = paramContentValues.valueSet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String str = (String)localEntry.getKey();
          if (("count_gowidget_42".equals(str)) || ("count_gowidget_41".equals(str)) || ("count_gowidget_21".equals(str)) || ("count_gowidget_11".equals(str))) {
            ((SharedPreferences.Editor)localObject).putInt(str, ((Integer)localEntry.getValue()).intValue());
          } else if ("key_maps_select_type".equals(str)) {
            ((SharedPreferences.Editor)localObject).putInt(str, ((Integer)localEntry.getValue()).intValue());
          }
        }
        ((SharedPreferences.Editor)localObject).commit();
      }
      localObject = "";
      continue;
      localObject = "messagecenter";
      continue;
      localObject = "featured_theme_table";
      continue;
      localObject = "featured_theme_tab_table";
      continue;
      localObject = "ad_info_table";
      continue;
      localObject = "next_widget_binding_city_table";
      continue;
      localObject = "coupon_table";
      continue;
      localObject = "promo_table";
      continue;
      localObject = "appwidget_info_table";
      continue;
      localObject = "user_table";
      continue;
      localObject = "photo_table";
      continue;
      localObject = "my_photo_table";
      continue;
      localObject = "photo_upload_table";
      continue;
      localObject = "my_award_table";
      continue;
      localObject = "award_table";
      continue;
      localObject = "prompt_table";
      continue;
      localObject = "pollenIndex";
      continue;
      localObject = "pollensource";
      continue;
      localObject = "coupons_hot_table";
      continue;
      localObject = "coupons_collect_table";
    }
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/provider/WeatherContentProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */