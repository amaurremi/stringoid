package com.gau.go.launcherex.gowidget.weather.provider;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Environment;
import android.text.TextUtils;
import android.text.format.Time;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.messagecenter.util.i;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.e.e;
import com.gau.go.launcherex.gowidget.weather.e.j;
import com.gau.go.launcherex.gowidget.weather.e.k;
import com.gau.go.launcherex.gowidget.weather.e.l;
import com.gau.go.launcherex.gowidget.weather.e.m;
import com.gau.go.launcherex.gowidget.weather.e.p;
import com.gau.go.launcherex.gowidget.weather.e.s;
import com.gau.go.launcherex.gowidget.weather.globaltheme.a.a.b;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget21Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget41Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget42Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidgetDays41Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidgetDays42Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidgetWorldClock42Provider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class a
  extends SQLiteOpenHelper
{
  private static a a;
  private Context b = null;
  private SQLiteQueryBuilder c;
  private boolean d = false;
  
  private a(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString, null, paramInt);
    this.b = paramContext;
    this.c = new SQLiteQueryBuilder();
  }
  
  private void A(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.c.k);
    paramSQLiteDatabase = this.b.getSharedPreferences("goweatherex_info", 0);
    SharedPreferences.Editor localEditor = paramSQLiteDatabase.edit();
    String str = paramSQLiteDatabase.getString("key_new_language", "");
    paramSQLiteDatabase = str;
    if (!str.equals("")) {
      paramSQLiteDatabase = str + "#";
    }
    localEditor.putString("key_new_language", paramSQLiteDatabase + "com.gau.go.weatherex.language.hu#com.gau.go.weatherex.language.pt#com.gau.go.weatherex.language.ro#com.gau.go.weatherex.language.nl");
    localEditor.putBoolean("weather_share", true);
    localEditor.putBoolean("setting", true);
    localEditor.putBoolean("setting_language", true);
    localEditor.commit();
  }
  
  private void B(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('temp_change', '1')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('temp_change_high', '9')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('temp_change_low', '9')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('temp_change_city', '')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('temp_change_type', '1')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('plugin_camera_data_timestamp', '0')");
    paramSQLiteDatabase = this.b.getSharedPreferences("goweatherex_info", 0).edit();
    paramSQLiteDatabase.putBoolean("key_new_feature_temp_change", true);
    paramSQLiteDatabase.putBoolean("setting", true);
    paramSQLiteDatabase.putInt("current_versioncode", 0);
    paramSQLiteDatabase.commit();
  }
  
  private void C(SQLiteDatabase paramSQLiteDatabase)
  {
    if (!a(paramSQLiteDatabase, "messagecenter")) {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS messagecenter (mesageid text, title text, readed numeric, viewtype numeric, type text, date text, url text, stime_start text,stime_end text,icon text,intro text,acttype numeric,actvalue text,zicon1 text,zicon2 text,zpos numeric,ztime numeric,isclosed numeric,filter_pkgs text,clickclosed numeric,dynamic numeric,iconpos numeric,fullscreenicon text,removed numeric, packagename text, mapid text, whitelist text, isdeleted numeric,PRIMARY KEY (mesageid))");
    }
    D(paramSQLiteDatabase);
    E(paramSQLiteDatabase);
  }
  
  private void D(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = new ArrayList();
    Cursor localCursor = paramSQLiteDatabase.query("msg_center", null, null, null, null, null, null);
    if (localCursor != null) {}
    try
    {
      if (localCursor.getCount() > 0)
      {
        localCursor.moveToFirst();
        do
        {
          localContentValues = new ContentValues();
          c(localCursor, localContentValues);
          ((ArrayList)localObject).add(localContentValues);
        } while (localCursor.moveToNext());
      }
      localObject = ((ArrayList)localObject).iterator();
    }
    catch (Exception paramSQLiteDatabase)
    {
      ContentValues localContentValues;
      for (;;) {}
    }
    finally
    {
      localCursor.close();
    }
    if (((Iterator)localObject).hasNext()) {
      localContentValues = (ContentValues)((Iterator)localObject).next();
    }
    for (;;)
    {
      paramSQLiteDatabase.delete("msg_center", null, null);
    }
  }
  
  private void E(SQLiteDatabase paramSQLiteDatabase)
  {
    ContentValues localContentValues = null;
    Object localObject6 = null;
    Object localObject3 = null;
    Cursor localCursor = paramSQLiteDatabase.query("weather11_city", null, null, null, null, null, null);
    Object localObject1 = localObject3;
    if (localCursor != null) {}
    for (;;)
    {
      int i;
      Object localObject5;
      try
      {
        i = localCursor.getCount();
        localObject1 = localObject3;
        if (i > 0)
        {
          HashMap localHashMap = new HashMap(i);
          localCursor.moveToFirst();
          localObject3 = null;
          localObject1 = null;
          int j = localCursor.getColumnCount();
          i = 0;
          if (i < j)
          {
            String str = localCursor.getColumnName(i);
            if ("widgetId".equals(str))
            {
              localObject5 = localCursor.getString(i);
              break label415;
            }
            localObject5 = localObject1;
            if (!"cityId".equals(str)) {
              break label415;
            }
            localObject3 = localCursor.getString(i);
            localObject5 = localObject1;
            break label415;
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
            localHashMap.put(localObject1, localObject3);
          }
          boolean bool = localCursor.moveToNext();
          if (bool) {
            continue;
          }
          localObject1 = localHashMap;
        }
        localObject3 = localObject1;
        if (localCursor == null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Object localObject4 = localObject6;
        if (localCursor == null) {
          continue;
        }
        localObject2 = localContentValues;
        continue;
      }
      finally
      {
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
      }
      localCursor.close();
      localObject3 = localObject1;
      if ((localObject3 != null) && (((HashMap)localObject3).size() > 0))
      {
        localObject1 = ((HashMap)localObject3).entrySet().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = (String)((Map.Entry)localObject5).getKey();
          localObject5 = (String)((Map.Entry)localObject5).getValue();
          try
          {
            localContentValues = new ContentValues();
            localContentValues.put("go_widget_id", (String)localObject3);
            localContentValues.put("city_id", (String)localObject5);
            localContentValues.put("go_widget_type", Integer.valueOf(2));
            if (paramSQLiteDatabase.update("go_widget_binding_city_table", localContentValues, "go_widget_id=?", new String[] { localObject3 }) >= 1) {
              continue;
            }
            paramSQLiteDatabase.insert("go_widget_binding_city_table", null, localContentValues);
          }
          catch (SQLException localSQLException)
          {
            localSQLException.printStackTrace();
          }
          continue;
        }
      }
      return;
      label415:
      i += 1;
      Object localObject2 = localObject5;
    }
  }
  
  private void F(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS featured_theme_table (_id INTEGER PRIMARY KEY, appid INTEGER, new_theme INTEGER, type_id INTEGER, packname TEXT, name TEXT, version TEXT, version_code INTEGER, download_type INTEGER, download_url TEXT, detail_type INTEGER, detail_url TEXT, pay_type INTEGER, pay_id TEXT, pic_url TEXT, pics_url TEXT, pic_path TEXT, pics_path TEXT, featured_type INTEGER, theme_type INTEGER, mark TEXT)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS featured_theme_tab_table (_id INTEGER PRIMARY KEY, type_id INTEGER, sequence INTEGER, type_name TEXT, mark TEXT)");
    a("citynow", "rainFall", "REAL", 55536, paramSQLiteDatabase);
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('appwidget_days_41_city', '')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('appwidget_days_42_city', '')");
  }
  
  private void G(SQLiteDatabase paramSQLiteDatabase)
  {
    a("featured_theme_table", "synchro_time", "REAL", 0, paramSQLiteDatabase);
  }
  
  private void H(SQLiteDatabase paramSQLiteDatabase)
  {
    a("citynow", "aqi", "INTEGER", 55536, paramSQLiteDatabase);
    a("citynow", "qualityType", "INTEGER", 55536, paramSQLiteDatabase);
    a("citynow", "pm25", "INTEGER", 55536, paramSQLiteDatabase);
    a("citynow", "pm10", "INTEGER", 55536, paramSQLiteDatabase);
    a("citynow", "so2", "INTEGER", 55536, paramSQLiteDatabase);
    a("citynow", "no2", "INTEGER", 55536, paramSQLiteDatabase);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("timestamp", Integer.valueOf(0));
    paramSQLiteDatabase.update("citynow", localContentValues, null, null);
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('appwidget_world_clock_42_city_one', '')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('appwidget_world_clock_42_city_two', '')");
  }
  
  private void I(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('notification_style', 'notification_style_default')");
  }
  
  private void J(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS [ad_info_table] ([_id] INTEGER PRIMARY KEY, [ad_id] INTEGER, [ad_interval] INTEGER, [ad_overcount] INTEGER, [ad_img] TEXT, [ad_monitor] TEXT, [ad_weather] INTEGER, [ad_text] TEXT, [ad_url] TEXT, [pcount] INTEGER, [purl] TEXT, [timestamp] TEXT )");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('weather_assistant_switch', 1)");
  }
  
  private void K(SQLiteDatabase paramSQLiteDatabase)
  {
    a("ad_info_table", "timestamp", "", paramSQLiteDatabase);
  }
  
  private void L(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.c.l);
    a("featured_theme_table", "pkgalias", "", paramSQLiteDatabase);
    a("featured_theme_table", "ficon_url", "", paramSQLiteDatabase);
  }
  
  private void M(SQLiteDatabase paramSQLiteDatabase)
  {
    ContentValues localContentValues;
    if (com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.b(this.b, "com.gau.go.weatherex.theme.gowidget.blacktransparentskin"))
    {
      str = "com.gau.go.weatherex.theme.gowidget.blacktransparentskin";
      localContentValues = new ContentValues();
      localContentValues.put("setting_value", str);
      paramSQLiteDatabase.update("common_setting_table", localContentValues, "setting_value=? and setting_key=?", new String[] { "app_widget_theme_black", "go_widget_theme" });
      localContentValues = new ContentValues();
      localContentValues.put("widget_theme", str);
      paramSQLiteDatabase.update("gowidget_theme_table", localContentValues, "widget_theme=?", new String[] { "app_widget_theme_black" });
      if (!com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.b(this.b, "com.gau.go.weatherex.systemwidgetskin.blacktransparentskin")) {
        break label168;
      }
    }
    label168:
    for (String str = "com.gau.go.weatherex.systemwidgetskin.blacktransparentskin";; str = "app_widget_theme_white")
    {
      localContentValues = new ContentValues();
      localContentValues.put("setting_value", str);
      paramSQLiteDatabase.update("common_setting_table", localContentValues, "setting_value=? and setting_key=?", new String[] { "app_widget_theme_black", "app_widget_theme" });
      return;
      str = "app_widget_theme_white";
      break;
    }
  }
  
  private void N(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS next_widget_binding_city_table (_id INTEGER PRIMARY KEY, go_widget_type INTEGER, go_widget_id TEXT, city_id TEXT)");
  }
  
  private void O(SQLiteDatabase paramSQLiteDatabase)
  {
    boolean bool = false;
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('weather_warning_switch', '1')");
    SharedPreferences localSharedPreferences = this.b.getSharedPreferences("dynamic_bg_settings", 0);
    if (com.gtp.a.a.c.a.a() != 3) {
      bool = true;
    }
    if (localSharedPreferences.getBoolean("dynamic_background_boolean", bool)) {
      paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.c.a("1"));
    }
    for (;;)
    {
      paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('dynamic_icon_gowidget', 1)");
      a("messagecenter", "whitelist", "", paramSQLiteDatabase);
      return;
      paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.c.a("0"));
    }
  }
  
  private void P(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS coupon_table (_id INTEGER PRIMARY KEY, coupon_id TEXT, coupon_value INTEGER, consumed INTEGER, consumed_time REAL, effective_time REAL, expired_time REAL)");
  }
  
  private void Q(SQLiteDatabase paramSQLiteDatabase)
  {
    b(paramSQLiteDatabase, "com.gau.go.weatherex.dynamicsbg.defaultv1");
  }
  
  /* Error */
  private void R(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: ldc_w 365
    //   6: iconst_1
    //   7: anewarray 67	java/lang/String
    //   10: dup
    //   11: iconst_0
    //   12: ldc_w 363
    //   15: aastore
    //   16: ldc_w 423
    //   19: iconst_1
    //   20: anewarray 67	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc_w 425
    //   28: aastore
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: invokevirtual 154	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   35: astore_3
    //   36: aload_3
    //   37: astore_2
    //   38: aload_2
    //   39: astore_3
    //   40: aload_2
    //   41: invokeinterface 163 1 0
    //   46: ifeq +240 -> 286
    //   49: aload_2
    //   50: astore_3
    //   51: aload_2
    //   52: iconst_0
    //   53: invokeinterface 235 2 0
    //   58: astore 4
    //   60: aload 4
    //   62: astore_3
    //   63: aload_3
    //   64: astore 4
    //   66: aload_2
    //   67: ifnull +12 -> 79
    //   70: aload_2
    //   71: invokeinterface 213 1 0
    //   76: aload_3
    //   77: astore 4
    //   79: aload_0
    //   80: getfield 19	com/gau/go/launcherex/gowidget/weather/provider/a:b	Landroid/content/Context;
    //   83: ldc 45
    //   85: iconst_0
    //   86: invokevirtual 51	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   89: invokeinterface 57 1 0
    //   94: astore_2
    //   95: ldc_w 427
    //   98: aload 4
    //   100: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   103: ifeq +146 -> 249
    //   106: aload_2
    //   107: ldc_w 429
    //   110: iconst_0
    //   111: invokeinterface 127 3 0
    //   116: pop
    //   117: aload_2
    //   118: ldc_w 431
    //   121: bipush 100
    //   123: invokeinterface 127 3 0
    //   128: pop
    //   129: aload_2
    //   130: invokeinterface 106 1 0
    //   135: pop
    //   136: new 165	android/content/ContentValues
    //   139: dup
    //   140: invokespecial 166	android/content/ContentValues:<init>	()V
    //   143: astore_2
    //   144: aload_2
    //   145: ldc_w 363
    //   148: ldc_w 427
    //   151: invokevirtual 270	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload_1
    //   155: ldc_w 365
    //   158: aload_2
    //   159: ldc_w 423
    //   162: iconst_1
    //   163: anewarray 67	java/lang/String
    //   166: dup
    //   167: iconst_0
    //   168: ldc_w 425
    //   171: aastore
    //   172: invokevirtual 202	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   175: pop
    //   176: aload_1
    //   177: ldc_w 365
    //   180: aload_2
    //   181: ldc_w 423
    //   184: iconst_1
    //   185: anewarray 67	java/lang/String
    //   188: dup
    //   189: iconst_0
    //   190: ldc_w 433
    //   193: aastore
    //   194: invokevirtual 202	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   197: pop
    //   198: return
    //   199: astore 4
    //   201: aconst_null
    //   202: astore_2
    //   203: aload_2
    //   204: astore_3
    //   205: invokestatic 437	com/gtp/a/a/b/c:a	()Z
    //   208: ifeq +10 -> 218
    //   211: aload_2
    //   212: astore_3
    //   213: aload 4
    //   215: invokevirtual 209	android/database/SQLException:printStackTrace	()V
    //   218: aload_2
    //   219: ifnull +9 -> 228
    //   222: aload_2
    //   223: invokeinterface 213 1 0
    //   228: ldc_w 427
    //   231: astore 4
    //   233: goto -154 -> 79
    //   236: astore_1
    //   237: aload_2
    //   238: ifnull +9 -> 247
    //   241: aload_2
    //   242: invokeinterface 213 1 0
    //   247: aload_1
    //   248: athrow
    //   249: aload_2
    //   250: ldc_w 431
    //   253: iconst_0
    //   254: invokeinterface 127 3 0
    //   259: pop
    //   260: aload_2
    //   261: ldc_w 429
    //   264: bipush 100
    //   266: invokeinterface 127 3 0
    //   271: pop
    //   272: goto -143 -> 129
    //   275: astore_1
    //   276: aload_3
    //   277: astore_2
    //   278: goto -41 -> 237
    //   281: astore 4
    //   283: goto -80 -> 203
    //   286: ldc_w 427
    //   289: astore_3
    //   290: goto -227 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	a
    //   0	293	1	paramSQLiteDatabase	SQLiteDatabase
    //   1	277	2	localObject1	Object
    //   35	255	3	localObject2	Object
    //   58	41	4	localObject3	Object
    //   199	15	4	localSQLException1	SQLException
    //   231	1	4	str	String
    //   281	1	4	localSQLException2	SQLException
    // Exception table:
    //   from	to	target	type
    //   2	36	199	android/database/SQLException
    //   2	36	236	finally
    //   40	49	275	finally
    //   51	60	275	finally
    //   205	211	275	finally
    //   213	218	275	finally
    //   40	49	281	android/database/SQLException
    //   51	60	281	android/database/SQLException
  }
  
  private void S(SQLiteDatabase paramSQLiteDatabase)
  {
    a("featured_theme_table", "issupport_coupons", "INTEGER", 0, paramSQLiteDatabase);
  }
  
  private void T(SQLiteDatabase paramSQLiteDatabase)
  {
    a("featured_theme_table", "issupport_coupons", "INTEGER", 0, paramSQLiteDatabase);
    a("messagecenter", "packagename", "TEXT", 0, paramSQLiteDatabase);
    a("messagecenter", "mapid", "TEXT", 0, paramSQLiteDatabase);
  }
  
  private void U(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS promo_table (_id INTEGER PRIMARY KEY, promo_code TEXT, effective_time REAL, expired_time REAL)");
  }
  
  private void V(SQLiteDatabase paramSQLiteDatabase)
  {
    a("citynow", "city_my_location", "INTEGER", 1, paramSQLiteDatabase);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "cityId";
    Cursor localCursor = paramSQLiteDatabase.query("citynow", arrayOfString, "myLocation=?", new String[] { String.valueOf(2) }, null, null, null);
    Object localObject2 = null;
    Object localObject1;
    int i;
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst())
      {
        int j = localCursor.getColumnCount();
        i = 0;
        localObject1 = localObject2;
        if (i < j)
        {
          if (!"cityId".equals(localCursor.getColumnName(i))) {
            break label244;
          }
          localObject1 = localCursor.getString(i);
        }
      }
      localCursor.close();
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = paramSQLiteDatabase.query("citynow", arrayOfString, "cityId=?", new String[] { localObject1 }, null, null, null);
        if (localObject2 != null)
        {
          i = ((Cursor)localObject2).getCount();
          ((Cursor)localObject2).close();
          if (i != 1) {
            break label251;
          }
          localObject2 = new ContentValues();
          ((ContentValues)localObject2).put("myLocation", Integer.valueOf(1));
          ((ContentValues)localObject2).put("city_my_location", Integer.valueOf(2));
          paramSQLiteDatabase.update("citynow", (ContentValues)localObject2, "cityId=?", new String[] { localObject1 });
        }
      }
      label244:
      label251:
      while (i <= 1)
      {
        return;
        i += 1;
        break;
      }
      paramSQLiteDatabase.delete("citynow", "myLocation=?", new String[] { String.valueOf(2) });
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("myLocation", Integer.valueOf(1));
      ((ContentValues)localObject2).put("city_my_location", Integer.valueOf(3));
      paramSQLiteDatabase.update("citynow", (ContentValues)localObject2, "cityId=?", new String[] { localObject1 });
      return;
      localObject1 = null;
    }
  }
  
  private void W(SQLiteDatabase paramSQLiteDatabase)
  {
    a("citynow", "latitude", "TEXT", paramSQLiteDatabase);
    a("citynow", "longitude", "TEXT", paramSQLiteDatabase);
    a("citynow", "hasRadar", "INTEGER", 0, paramSQLiteDatabase);
    a("citynow", "hasSatellite", "INTEGER", 0, paramSQLiteDatabase);
  }
  
  private void X(SQLiteDatabase paramSQLiteDatabase)
  {
    b(paramSQLiteDatabase, "com.gau.go.weatherex.dynamicsbg.defaultv2");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('no_alerts_cities', '')");
    a("extreme", "has_read", "INTEGER", 0, paramSQLiteDatabase);
  }
  
  private void Y(SQLiteDatabase paramSQLiteDatabase)
  {
    e();
    paramSQLiteDatabase.execSQL(s.a);
    f();
  }
  
  private void Z(SQLiteDatabase paramSQLiteDatabase)
  {
    int j = 0;
    a("citynow", "northeast", "TEXT", paramSQLiteDatabase);
    a("citynow", "southwest", "TEXT", paramSQLiteDatabase);
    String str1 = aa(paramSQLiteDatabase);
    Object localObject1 = AppWidgetManager.getInstance(this.b);
    Object localObject2 = ((AppWidgetManager)localObject1).getAppWidgetIds(new ComponentName(this.b, AppWidget42Provider.class));
    com.gtp.a.a.b.c.a("updatewidget", "系统widget当天4*2个数为：" + localObject2.length + "个");
    String str2;
    int i;
    if (localObject2.length > 0)
    {
      str2 = c(paramSQLiteDatabase, "appwidget42_city");
      if (!TextUtils.isEmpty(str2))
      {
        i = 0;
        while (i < localObject2.length)
        {
          a(paramSQLiteDatabase, 1, localObject2[i], str2, str1);
          i += 1;
        }
      }
    }
    localObject2 = ((AppWidgetManager)localObject1).getAppWidgetIds(new ComponentName(this.b, AppWidget41Provider.class));
    com.gtp.a.a.b.c.a("updatewidget", "系统widget当天4*1个数为：" + localObject2.length + "个");
    if (localObject2.length > 0)
    {
      str2 = c(paramSQLiteDatabase, "appwidget41_city");
      if (!TextUtils.isEmpty(str2))
      {
        i = 0;
        while (i < localObject2.length)
        {
          a(paramSQLiteDatabase, 2, localObject2[i], str2, str1);
          i += 1;
        }
      }
    }
    localObject2 = ((AppWidgetManager)localObject1).getAppWidgetIds(new ComponentName(this.b, AppWidget21Provider.class));
    com.gtp.a.a.b.c.a("updatewidget", "系统widget当天2*1个数为：" + localObject2.length + "个");
    if (localObject2.length > 0)
    {
      str2 = c(paramSQLiteDatabase, "appwidget21_city");
      if (!TextUtils.isEmpty(str2))
      {
        i = 0;
        while (i < localObject2.length)
        {
          a(paramSQLiteDatabase, 3, localObject2[i], str2, str1);
          i += 1;
        }
      }
    }
    localObject2 = ((AppWidgetManager)localObject1).getAppWidgetIds(new ComponentName(this.b, AppWidgetDays42Provider.class));
    com.gtp.a.a.b.c.a("updatewidget", "系统widget多天4*2个数为：" + localObject2.length + "个");
    if (localObject2.length > 0)
    {
      str2 = c(paramSQLiteDatabase, "appwidget_days_42_city");
      if (!TextUtils.isEmpty(str2))
      {
        i = 0;
        while (i < localObject2.length)
        {
          a(paramSQLiteDatabase, 4, localObject2[i], str2, str1);
          i += 1;
        }
      }
    }
    localObject1 = ((AppWidgetManager)localObject1).getAppWidgetIds(new ComponentName(this.b, AppWidgetDays41Provider.class));
    com.gtp.a.a.b.c.a("updatewidget", "系统widget多天4*1个数为：" + localObject1.length + "个");
    if (localObject1.length > 0)
    {
      localObject2 = c(paramSQLiteDatabase, "appwidget_days_41_city");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        i = j;
        while (i < localObject1.length)
        {
          a(paramSQLiteDatabase, 5, localObject1[i], (String)localObject2, str1);
          i += 1;
        }
      }
    }
  }
  
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      return 1;
    }
    if ((paramBoolean1) && (!paramBoolean2)) {
      return 2;
    }
    if ((!paramBoolean1) && (paramBoolean2)) {
      return 3;
    }
    return 0;
  }
  
  public static a a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      if (a == null) {
        a = new a(paramContext, paramString, paramInt);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a()
  {
    SharedPreferences.Editor localEditor = this.b.getSharedPreferences("start_msg", 0).edit();
    localEditor.putBoolean("isFirstStart", true);
    localEditor.putBoolean("is1to2", true);
    localEditor.commit();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, ContentValues paramContentValues)
  {
    paramContentValues.put("type", Integer.valueOf(com.gau.go.launcherex.gowidget.weather.util.r.b(paramInt1)));
    if (paramInt3 == 1)
    {
      arrayOfString = this.b.getResources().getStringArray(2131558470);
      if ((paramInt2 >= 0) && (paramInt2 < arrayOfString.length))
      {
        paramContentValues.put("nowDesp", arrayOfString[paramInt2]);
        return;
      }
      paramContentValues.put("nowDesp", "--");
      return;
    }
    String[] arrayOfString = this.b.getResources().getStringArray(2131558469);
    if ((paramInt2 >= 0) && (paramInt2 < arrayOfString.length))
    {
      paramContentValues.put("nowDesp", arrayOfString[paramInt2]);
      return;
    }
    paramContentValues.put("nowDesp", "--");
  }
  
  private void a(int paramInt1, int paramInt2, ContentValues paramContentValues)
  {
    if (paramInt2 == 1)
    {
      arrayOfString = this.b.getResources().getStringArray(2131558471);
      paramContentValues.put("windType", Integer.valueOf(com.gau.go.launcherex.gowidget.weather.util.r.d(paramInt1)));
      if ((paramInt1 >= 0) && (paramInt1 < arrayOfString.length)) {
        paramContentValues.put("windDirection", arrayOfString[paramInt1]);
      }
      for (;;)
      {
        paramContentValues.put("windStrength", "--");
        paramContentValues.put("windStrengthInt", Integer.valueOf(55536));
        return;
        paramContentValues.put("windDirection", "--");
      }
    }
    String[] arrayOfString = this.b.getResources().getStringArray(2131558472);
    paramContentValues.put("windType", Integer.valueOf(com.gau.go.launcherex.gowidget.weather.util.r.c(paramInt1)));
    if ((paramInt1 >= 0) && (paramInt1 < arrayOfString.length)) {
      paramContentValues.put("windDirection", arrayOfString[paramInt1]);
    }
    for (;;)
    {
      paramContentValues.put("windStrength", "--");
      paramContentValues.put("windStrengthInt", Integer.valueOf(55536));
      return;
      paramContentValues.put("windDirection", "--");
    }
  }
  
  private void a(SharedPreferences.Editor paramEditor)
  {
    b localb = new b();
    localb.a("admob");
    localb.b(0);
    localb.c(0);
    localb.a(1);
    if ((y.h(this.b)) && (!y.p(this.b)))
    {
      localb.b(1);
      localb.b(this.b.getString(2131165244));
      paramEditor.putString("key_adid_location_" + localb.b(), localb.a());
      localb.a(2);
      localb.b(0);
      if ((!y.h(this.b)) || (y.p(this.b))) {
        break label247;
      }
      localb.b(1);
      localb.a("getjar");
      localb.b(this.b.getString(2131165249));
    }
    for (;;)
    {
      paramEditor.putString("key_adid_location_" + localb.b(), localb.a());
      paramEditor.putInt("key_adid_request_frequency", 0);
      return;
      if ((y.h(this.b)) || (!y.p(this.b))) {
        break;
      }
      localb.b(1);
      localb.b(this.b.getString(2131165245));
      break;
      label247:
      if ((!y.h(this.b)) && (y.p(this.b)))
      {
        localb.b(1);
        localb.b(this.b.getString(2131165247));
      }
    }
  }
  
  private void a(Cursor paramCursor, int paramInt, ContentValues paramContentValues)
  {
    int j = paramCursor.getColumnCount();
    int i = 0;
    if (i < j)
    {
      String str = paramCursor.getColumnName(i);
      if (str.equals("cityName")) {
        paramContentValues.put(str, paramCursor.getString(i));
      }
      for (;;)
      {
        i += 1;
        break;
        if (str.equals("cityId")) {
          paramContentValues.put(str, paramCursor.getString(i));
        } else if (str.equals("cityType")) {
          paramContentValues.put(str, Integer.valueOf(paramCursor.getInt(i)));
        } else if (str.equals("nowDesp")) {
          paramContentValues.put(str, Integer.valueOf(paramCursor.getInt(i)));
        } else if (str.equals("language")) {
          paramContentValues.put(str, Integer.valueOf(paramCursor.getInt(i)));
        } else if (str.equals("nowTemp")) {
          paramContentValues.put(str, paramCursor.getString(i));
        } else if (str.equals("lowTemp")) {
          paramContentValues.put(str, paramCursor.getString(i));
        } else if (str.equals("highTemp")) {
          paramContentValues.put(str, paramCursor.getString(i));
        } else if (str.equals("wind")) {
          paramContentValues.put(str, Integer.valueOf(paramCursor.getInt(i)));
        } else if (str.equals("humidity")) {
          paramContentValues.put(str, paramCursor.getString(i));
        } else if (str.equals("type")) {
          paramContentValues.put(str, Integer.valueOf(paramCursor.getInt(i)));
        }
      }
    }
    paramContentValues.put("sequence", Integer.valueOf(paramInt));
  }
  
  private void a(Cursor paramCursor, ContentValues paramContentValues)
  {
    int k = -1;
    int i5 = paramCursor.getColumnCount();
    int i = 0;
    int j = -1;
    int n = 8;
    int m = -1;
    if (i < i5)
    {
      String str = paramCursor.getColumnName(i);
      int i4;
      int i3;
      int i2;
      int i1;
      if (str.equals("cityName"))
      {
        paramContentValues.put("cityName", paramCursor.getString(i));
        i4 = j;
        i3 = k;
        i2 = m;
        i1 = n;
      }
      for (;;)
      {
        i += 1;
        n = i1;
        m = i2;
        k = i3;
        j = i4;
        break;
        if (str.equals("cityId"))
        {
          paramContentValues.put("cityId", paramCursor.getString(i));
          paramContentValues.put("oldCityId", paramCursor.getString(i));
          i1 = n;
          i2 = m;
          i3 = k;
          i4 = j;
        }
        else if (str.equals("cityType"))
        {
          paramContentValues.put("cityType", Integer.valueOf(paramCursor.getInt(i)));
          i1 = n;
          i2 = m;
          i3 = k;
          i4 = j;
        }
        else if (str.equals("nowDesp"))
        {
          i2 = paramCursor.getInt(i);
          i1 = n;
          i3 = k;
          i4 = j;
        }
        else if (str.equals("nowTemp"))
        {
          paramContentValues.put("nowTemp", com.gau.go.launcherex.gowidget.weather.util.q.a(paramCursor.getString(i), 1, 2));
          i1 = n;
          i2 = m;
          i3 = k;
          i4 = j;
        }
        else if (str.equals("lowTemp"))
        {
          paramContentValues.put("lowTemp", com.gau.go.launcherex.gowidget.weather.util.q.a(paramCursor.getString(i), 1, 2));
          i1 = n;
          i2 = m;
          i3 = k;
          i4 = j;
        }
        else if (str.equals("highTemp"))
        {
          paramContentValues.put("highTemp", com.gau.go.launcherex.gowidget.weather.util.q.a(paramCursor.getString(i), 1, 2));
          i1 = n;
          i2 = m;
          i3 = k;
          i4 = j;
        }
        else if (str.equals("wind"))
        {
          i4 = paramCursor.getInt(i);
          i1 = n;
          i2 = m;
          i3 = k;
        }
        else if (str.equals("humidity"))
        {
          paramContentValues.put("humidity", paramCursor.getString(i));
          i1 = n;
          i2 = m;
          i3 = k;
          i4 = j;
        }
        else if (str.equals("type"))
        {
          i1 = paramCursor.getInt(i);
          i2 = m;
          i3 = k;
          i4 = j;
        }
        else if (str.equals("language"))
        {
          i3 = paramCursor.getInt(i);
          i1 = n;
          i2 = m;
          i4 = j;
        }
        else
        {
          i1 = n;
          i2 = m;
          i3 = k;
          i4 = j;
          if (str.equals("sequence"))
          {
            paramContentValues.put("sequence", Integer.valueOf(paramCursor.getInt(i)));
            i1 = n;
            i2 = m;
            i3 = k;
            i4 = j;
          }
        }
      }
    }
    a(j, k, paramContentValues);
    a(n, m, k, paramContentValues);
    paramContentValues.put("visibility", "--");
    paramContentValues.put("barometer", "--");
    paramContentValues.put("dewpoint", "--");
    paramContentValues.put("uvIndex", "--");
    paramContentValues.put("sunrise", "--");
    paramContentValues.put("sunset", "--");
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('autoUpdate', '1')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('autpUpdateFreq', '3600000')");
    paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.c.g);
    paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.c.h);
    paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.c.i);
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('isCycle', '1')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('dateStyle', '1')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('notify', '0')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('notify_type', '1')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('notify_city', '')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('notify_city_type', '1')");
    paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.c.j);
    paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.c.k);
    paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.c.l);
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('world_clock', '1')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('widgt_clock', '')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('widgt_calendar', '')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('notification_sound', '0')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('user_lang_code', 'default')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('user_lang_pkg', 'com.gau.go.launcherex.gowidget.weatherwidget')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('temp_change', '1')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('temp_change_high', '9')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('temp_change_low', '9')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('temp_change_city', '')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('temp_change_type', '1')");
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("widget_id", Integer.valueOf(paramInt2));
    localContentValues.put("widget_type", Integer.valueOf(paramInt1));
    if ((!TextUtils.isEmpty(paramString2)) && (paramString1.equals(paramString2)))
    {
      com.gtp.a.a.b.c.a("updatewidget", "有绑定定位城市，该城市是：" + paramString1);
      localContentValues.put("widget_location_type", Integer.valueOf(1));
    }
    for (;;)
    {
      localContentValues.put("current_cityid", paramString1);
      paramSQLiteDatabase.insert("appwidget_info_table", null, localContentValues);
      return;
      localContentValues.put("widget_location_type", Integer.valueOf(0));
    }
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    boolean bool3 = false;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("widget_id", Integer.valueOf(paramInt2));
    localContentValues.put("widget_type", Integer.valueOf(paramInt1));
    boolean bool1;
    if (!TextUtils.isEmpty(paramString3)) {
      if (paramString1.equals(paramString3))
      {
        bool1 = true;
        bool2 = bool1;
        if (paramString2.equals(paramString3)) {
          bool3 = true;
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      localContentValues.put("widget_location_type", Integer.valueOf(a(bool2, bool3)));
      localContentValues.put("current_cityid", paramString1 + "#" + paramString2);
      paramSQLiteDatabase.insert("appwidget_info_table", null, localContentValues);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(paramString2, paramString4);
    localContentValues.put(paramString3, Integer.valueOf(paramInt));
    paramSQLiteDatabase.insert(paramString1, null, localContentValues);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(paramString2, paramString4);
    localContentValues.put(paramString3, paramString5);
    paramSQLiteDatabase.insert(paramString1, null, localContentValues);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, ArrayList paramArrayList)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.query("citynow", new String[] { "cityId", "cityName", "cityType", "nowDesp", "nowTemp", "lowTemp", "highTemp", "wind", "humidity", "language", "type", "sequence" }, null, null, null, null, null);
    if (paramSQLiteDatabase != null) {}
    try
    {
      if (paramSQLiteDatabase.getCount() > 0)
      {
        paramSQLiteDatabase.moveToFirst();
        boolean bool;
        do
        {
          ContentValues localContentValues = new ContentValues();
          a(paramSQLiteDatabase, localContentValues);
          paramArrayList.add(localContentValues);
          bool = paramSQLiteDatabase.moveToNext();
        } while (bool);
      }
    }
    catch (Exception paramArrayList)
    {
      for (;;)
      {
        paramArrayList.printStackTrace();
      }
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
    paramSQLiteDatabase.close();
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, Map paramMap)
  {
    Cursor localCursor = paramSQLiteDatabase.query("citynow", new String[] { "cityId", "cityType" }, null, null, null, null, null);
    if (localCursor != null) {}
    for (;;)
    {
      int i;
      Object localObject;
      try
      {
        if (localCursor.getCount() > 0)
        {
          int k = localCursor.getColumnCount();
          localCursor.moveToFirst();
          paramSQLiteDatabase = "";
          String[] arrayOfString = localCursor.getColumnNames();
          i = 0;
          int j = 1;
          if (i < k)
          {
            if (arrayOfString[i].equals("cityId"))
            {
              localObject = localCursor.getString(i);
              break label201;
            }
            localObject = paramSQLiteDatabase;
            if (!arrayOfString[i].equals("cityType")) {
              break label201;
            }
            j = localCursor.getInt(i);
            localObject = paramSQLiteDatabase;
            break label201;
          }
          paramMap.put(paramSQLiteDatabase, Integer.valueOf(j));
          boolean bool = localCursor.moveToNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        try
        {
          localCursor.close();
          return;
        }
        catch (Exception paramSQLiteDatabase)
        {
          return;
        }
        paramSQLiteDatabase = paramSQLiteDatabase;
        paramSQLiteDatabase.printStackTrace();
        continue;
      }
      if ((localCursor != null) && (!localCursor.isClosed())) {}
      label201:
      i += 1;
      paramSQLiteDatabase = (SQLiteDatabase)localObject;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt, SQLiteDatabase paramSQLiteDatabase)
  {
    if (!a(paramString2, paramString1, paramSQLiteDatabase)) {
      paramSQLiteDatabase.execSQL("ALTER TABLE '" + paramString1 + "'" + " ADD " + "'" + paramString2 + "'" + " " + paramString3);
    }
    paramString3 = new ContentValues();
    paramString3.put(paramString2, Integer.valueOf(paramInt));
    paramSQLiteDatabase.update(paramString1, paramString3, null, null);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, SQLiteDatabase paramSQLiteDatabase)
  {
    if (!a(paramString2, paramString1, paramSQLiteDatabase)) {
      paramSQLiteDatabase.execSQL("ALTER TABLE '" + paramString1 + "'" + " ADD " + "'" + paramString2 + "'" + "  TEXT");
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(paramString2, paramString3);
    paramSQLiteDatabase.update(paramString1, localContentValues, null, null);
  }
  
  /* Error */
  private boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: aconst_null
    //   3: aconst_null
    //   4: aconst_null
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: ldc_w 403
    //   11: invokevirtual 780	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnull +79 -> 95
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: invokeinterface 160 1 0
    //   27: istore_3
    //   28: iload_3
    //   29: iflt +66 -> 95
    //   32: iconst_1
    //   33: istore 4
    //   35: aload_2
    //   36: ifnull +9 -> 45
    //   39: aload_2
    //   40: invokeinterface 213 1 0
    //   45: iload 4
    //   47: ireturn
    //   48: astore 5
    //   50: aconst_null
    //   51: astore_2
    //   52: aload_2
    //   53: astore_1
    //   54: aload 5
    //   56: invokevirtual 781	android/database/sqlite/SQLiteException:printStackTrace	()V
    //   59: aload_2
    //   60: ifnull +9 -> 69
    //   63: aload_2
    //   64: invokeinterface 213 1 0
    //   69: iconst_0
    //   70: ireturn
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_1
    //   75: ifnull +9 -> 84
    //   78: aload_1
    //   79: invokeinterface 213 1 0
    //   84: aload_2
    //   85: athrow
    //   86: astore_2
    //   87: goto -13 -> 74
    //   90: astore 5
    //   92: goto -40 -> 52
    //   95: iconst_0
    //   96: istore 4
    //   98: goto -63 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	a
    //   0	101	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	101	2	paramString	String
    //   27	2	3	i	int
    //   33	64	4	bool	boolean
    //   48	7	5	localSQLiteException1	SQLiteException
    //   90	1	5	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   0	15	48	android/database/sqlite/SQLiteException
    //   0	15	71	finally
    //   21	28	86	finally
    //   54	59	86	finally
    //   21	28	90	android/database/sqlite/SQLiteException
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      Float.parseFloat(paramString);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  /* Error */
  private boolean a(String paramString1, String paramString2, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_3
    //   4: aload_2
    //   5: iconst_1
    //   6: anewarray 67	java/lang/String
    //   9: dup
    //   10: iconst_0
    //   11: aload_1
    //   12: aastore
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokevirtual 154	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_3
    //   22: aload_3
    //   23: ifnull +80 -> 103
    //   26: aload_3
    //   27: astore_2
    //   28: aload_3
    //   29: aload_1
    //   30: invokeinterface 792 2 0
    //   35: istore 4
    //   37: iload 4
    //   39: iflt +64 -> 103
    //   42: iconst_1
    //   43: istore 5
    //   45: aload_3
    //   46: ifnull +9 -> 55
    //   49: aload_3
    //   50: invokeinterface 213 1 0
    //   55: iload 5
    //   57: ireturn
    //   58: astore_1
    //   59: aconst_null
    //   60: astore_3
    //   61: aload_3
    //   62: astore_2
    //   63: aload_1
    //   64: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   67: aload_3
    //   68: ifnull +9 -> 77
    //   71: aload_3
    //   72: invokeinterface 213 1 0
    //   77: iconst_0
    //   78: ireturn
    //   79: astore_1
    //   80: aload 6
    //   82: astore_2
    //   83: aload_2
    //   84: ifnull +9 -> 93
    //   87: aload_2
    //   88: invokeinterface 213 1 0
    //   93: aload_1
    //   94: athrow
    //   95: astore_1
    //   96: goto -13 -> 83
    //   99: astore_1
    //   100: goto -39 -> 61
    //   103: iconst_0
    //   104: istore 5
    //   106: goto -61 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	a
    //   0	109	1	paramString1	String
    //   0	109	2	paramString2	String
    //   0	109	3	paramSQLiteDatabase	SQLiteDatabase
    //   35	3	4	i	int
    //   43	62	5	bool	boolean
    //   1	80	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	22	58	java/lang/Exception
    //   3	22	79	finally
    //   28	37	95	finally
    //   63	67	95	finally
    //   28	37	99	java/lang/Exception
  }
  
  private String aa(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = paramSQLiteDatabase.query("citynow", new String[] { "cityId" }, "city_my_location=?", new String[] { String.valueOf(2) }, null, null, null);
    paramSQLiteDatabase = (SQLiteDatabase)localObject2;
    int j;
    int i;
    if (localCursor != null)
    {
      paramSQLiteDatabase = (SQLiteDatabase)localObject1;
      if (localCursor.moveToFirst())
      {
        j = localCursor.getColumnCount();
        i = 0;
      }
    }
    for (;;)
    {
      paramSQLiteDatabase = (SQLiteDatabase)localObject1;
      if (i < j)
      {
        if ("cityId".equals(localCursor.getColumnName(i))) {
          paramSQLiteDatabase = localCursor.getString(i);
        }
      }
      else
      {
        localCursor.close();
        return paramSQLiteDatabase;
      }
      i += 1;
    }
  }
  
  private void ab(SQLiteDatabase paramSQLiteDatabase)
  {
    a("citynow", "cityJsonString", "TEXT", paramSQLiteDatabase);
    String str1 = aa(paramSQLiteDatabase);
    int[] arrayOfInt = AppWidgetManager.getInstance(this.b).getAppWidgetIds(new ComponentName(this.b, AppWidgetWorldClock42Provider.class));
    com.gtp.a.a.b.c.a("updatewidget", "系统widget时钟4*2个数为：" + arrayOfInt.length + "个");
    if (arrayOfInt.length > 0)
    {
      String str2 = c(paramSQLiteDatabase, "appwidget_world_clock_42_city_one");
      String str3 = c(paramSQLiteDatabase, "appwidget_world_clock_42_city_two");
      if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3)))
      {
        int i = 0;
        while (i < arrayOfInt.length)
        {
          a(paramSQLiteDatabase, 6, arrayOfInt[i], str2, str3, str1);
          i += 1;
        }
      }
    }
  }
  
  private void ac(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject1 = paramSQLiteDatabase.query("common_setting_table", new String[] { "setting_value" }, "setting_key=?", new String[] { "user_lang_code" }, null, null, null);
    if (localObject1 != null) {}
    try
    {
      ((Cursor)localObject1).moveToFirst();
      if (((Cursor)localObject1).getCount() > 0)
      {
        localObject2 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("setting_value"));
        if ((localObject2 != null) && (((String)localObject2).equalsIgnoreCase("fr")))
        {
          localObject2 = new ContentValues();
          ((ContentValues)localObject2).put("setting_value", "com.gau.go.launcherex.gowidget.weatherwidget");
          paramSQLiteDatabase.update("common_setting_table", (ContentValues)localObject2, "setting_key=?", new String[] { "user_lang_pkg" });
        }
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          Object localObject2;
          int j;
          localException.printStackTrace();
          ((Cursor)localObject1).close();
          continue;
          if ("city_my_location".equals(localObject5)) {
            localException.c = ((Cursor)localObject1).getInt(i);
          }
        }
        ((List)localObject4).add(localException);
      } while (((Cursor)localObject1).moveToNext());
      ((Cursor)localObject1).close();
      localObject3 = "";
      localObject1 = paramSQLiteDatabase.query("common_setting_table", new String[] { "setting_value" }, "setting_key=? or setting_key=?", new String[] { "temp_change_city", "temp_change_type" }, null, null, null);
      if (localObject1 == null) {
        break label664;
      }
    }
    Object localObject4 = new ArrayList();
    localObject1 = paramSQLiteDatabase.query("citynow", new String[] { "cityId", "city_my_location" }, null, null, null, null, null);
    int i;
    Object localObject5;
    if (localObject1 != null) {
      if (((Cursor)localObject1).moveToFirst())
      {
        j = ((Cursor)localObject1).getColumnCount();
        localObject2 = new com.gau.go.launcherex.gowidget.weather.model.r();
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label297;
          }
          localObject5 = ((Cursor)localObject1).getColumnName(i);
          if (!"cityId".equals(localObject5)) {
            break;
          }
          ((com.gau.go.launcherex.gowidget.weather.model.r)localObject2).a = ((Cursor)localObject1).getString(i);
          i += 1;
        }
      }
    }
    label297:
    Object localObject3;
    if (((Cursor)localObject1).moveToFirst())
    {
      i = ((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndex("setting_value"));
      ((Cursor)localObject1).close();
    }
    for (;;)
    {
      if (i == 2)
      {
        localObject1 = ((List)localObject4).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (com.gau.go.launcherex.gowidget.weather.model.r)((Iterator)localObject1).next();
          if (((com.gau.go.launcherex.gowidget.weather.model.r)localObject3).c == 2) {
            localObject1 = ((com.gau.go.launcherex.gowidget.weather.model.r)localObject3).a;
          }
        }
      }
      for (;;)
      {
        localObject3 = new StringBuffer();
        localObject4 = ((List)localObject4).iterator();
        i = 0;
        label481:
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (com.gau.go.launcherex.gowidget.weather.model.r)((Iterator)localObject4).next();
          if (((com.gau.go.launcherex.gowidget.weather.model.r)localObject5).a.equals(localObject1)) {
            break label649;
          }
          if (i > 0) {
            ((StringBuffer)localObject3).append("#");
          }
          ((StringBuffer)localObject3).append(((com.gau.go.launcherex.gowidget.weather.model.r)localObject5).a);
          i += 1;
        }
        label649:
        for (;;)
        {
          break label481;
          localObject5 = paramSQLiteDatabase.query("common_setting_table", new String[] { "setting_value" }, "setting_key=?", new String[] { "temp_change_city" }, null, null, null);
          localObject1 = localObject3;
          if (localObject5 == null) {
            break;
          }
          localObject1 = localObject3;
          if (((Cursor)localObject5).moveToFirst()) {
            localObject1 = ((Cursor)localObject5).getString(((Cursor)localObject5).getColumnIndex("setting_value"));
          }
          ((Cursor)localObject5).close();
          break;
          paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.c.a("no_notify_temp_change_cities", ((StringBuffer)localObject3).toString()));
          return;
        }
        localObject1 = "";
      }
      i = -1;
      break;
      label664:
      i = -1;
    }
  }
  
  private void ad(SQLiteDatabase paramSQLiteDatabase)
  {
    if (!a(paramSQLiteDatabase, "pollenIndex")) {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS pollenIndex (_id INTEGER PRIMARY KEY, cityId TEXT,date_time INTEGER, pollen_index REAL)");
    }
    if (!a(paramSQLiteDatabase, "pollensource")) {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS pollensource (_id INTEGER PRIMARY KEY, cityId TEXT,date_time INTEGER, name TEXT,type INTEGER,url TEXT)");
    }
  }
  
  private void ae(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.r.a);
    paramSQLiteDatabase.execSQL(l.a);
    paramSQLiteDatabase.execSQL(m.a);
    paramSQLiteDatabase.execSQL(k.a);
    paramSQLiteDatabase.execSQL(j.a);
    paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.a.a);
    paramSQLiteDatabase.execSQL(p.a);
  }
  
  private void af(SQLiteDatabase paramSQLiteDatabase)
  {
    a("messagecenter", "isdeleted", "INTEGER", 0, paramSQLiteDatabase);
  }
  
  private void ag(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(e.a);
    paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.d.a);
  }
  
  private void ah(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('widget_theme_switcher', 1)");
  }
  
  private void ai(SQLiteDatabase paramSQLiteDatabase)
  {
    R(paramSQLiteDatabase);
  }
  
  private void aj(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.query("common_setting_table", com.gau.go.launcherex.gowidget.weather.e.c.a(), "setting_key=?", new String[] { "app_theme" }, null, null, null);
    String str = "";
    Object localObject = str;
    if (localCursor != null)
    {
      localObject = str;
      if (localCursor.getCount() > 0)
      {
        localCursor.moveToFirst();
        int i = localCursor.getColumnIndex("setting_value");
        localObject = str;
        if (i != -1) {
          localObject = localCursor.getString(i);
        }
      }
      localCursor.close();
    }
    if ("com.gau.go.launcherex.gowidget.weatherwidget".equals(localObject))
    {
      localObject = new ContentValues();
      ((ContentValues)localObject).put("setting_value", "0");
      paramSQLiteDatabase.update("common_setting_table", (ContentValues)localObject, "setting_key='dynamic_bg_switch'", null);
      paramSQLiteDatabase.update("common_setting_table", (ContentValues)localObject, "setting_key='key_live_wallpaper_dynamic_effect_on'", null);
    }
  }
  
  private void ak(SQLiteDatabase paramSQLiteDatabase) {}
  
  private void b()
  {
    c();
  }
  
  private void b(Cursor paramCursor, ContentValues paramContentValues)
  {
    int j = paramCursor.getColumnCount();
    String[] arrayOfString = com.gau.go.launcherex.gowidget.weather.util.c.h(this.b);
    int i = 0;
    if (i < j)
    {
      String str = paramCursor.getColumnName(i);
      int k;
      if (str.equals("dayId"))
      {
        k = paramCursor.getInt(i);
        if (i == 0) {
          paramContentValues.put("weekDate", arrayOfString[k]);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        paramContentValues.put("weekDate", arrayOfString[(k % 7)]);
        continue;
        if (str.equals("lowTemp")) {
          paramContentValues.put("lowTemp", com.gau.go.launcherex.gowidget.weather.util.q.a(paramCursor.getString(i), 1, 2));
        } else if (str.equals("highTemp")) {
          paramContentValues.put("highTemp", com.gau.go.launcherex.gowidget.weather.util.q.a(paramCursor.getString(i), 1, 2));
        } else if (str.equals("type")) {
          paramContentValues.put("type", Integer.valueOf(com.gau.go.launcherex.gowidget.weather.util.r.b(paramCursor.getInt(i))));
        } else if (str.equals("cityId")) {
          paramContentValues.put("cityId", paramCursor.getString(i));
        }
      }
    }
    paramContentValues.put("date", "--");
    paramContentValues.put("status", "--");
    paramContentValues.put("windDir", "--");
    paramContentValues.put("windStrength", "--");
    paramContentValues.put("windStrengthInt", Integer.valueOf(55536));
    paramContentValues.put("windType", Integer.valueOf(1));
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    if (a(paramSQLiteDatabase, "setting")) {
      c(paramSQLiteDatabase);
    }
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    if (com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.b(this.b, paramString))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("setting_value", paramString);
      paramSQLiteDatabase.update("common_setting_table", localContentValues, "setting_value=? and setting_key=?", new String[] { "com.gau.go.launcherex.gowidget.weatherwidget", "app_theme" });
      paramSQLiteDatabase.update("common_setting_table", localContentValues, "setting_value=? and setting_key=?", new String[] { "com.gau.go.launcherex.gowidget.weatherwidget", "key_live_wallpaper_theme" });
    }
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase, ArrayList paramArrayList)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.query("forecast", new String[] { "cityId", "dayId", "highTemp", "lowTemp", "type" }, null, null, null, null, null);
    if (paramSQLiteDatabase != null) {}
    try
    {
      if (paramSQLiteDatabase.getCount() > 0)
      {
        paramSQLiteDatabase.moveToFirst();
        boolean bool;
        do
        {
          ContentValues localContentValues = new ContentValues();
          b(paramSQLiteDatabase, localContentValues);
          paramArrayList.add(localContentValues);
          bool = paramSQLiteDatabase.moveToNext();
        } while (bool);
      }
    }
    catch (Exception paramArrayList)
    {
      for (;;)
      {
        paramArrayList.printStackTrace();
      }
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
    paramSQLiteDatabase.close();
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase, Map paramMap)
  {
    Cursor localCursor = paramSQLiteDatabase.query("citynow", new String[] { "cityId", "nowTemp", "highTemp", "lowTemp", "humidity", "barometer", "uvIndex", "dewpoint", "visibility", "feels_like", "windStrengthInt" }, null, null, null, null, null);
    HashMap localHashMap = new HashMap();
    if (localCursor != null) {}
    for (;;)
    {
      Object localObject;
      String[] arrayOfString;
      String str1;
      int k;
      int i;
      String str2;
      try
      {
        if (localCursor.getCount() > 0)
        {
          int j = localCursor.getColumnCount();
          localCursor.moveToFirst();
          localObject = new ContentValues();
          arrayOfString = localCursor.getColumnNames();
          str1 = localCursor.getString(localCursor.getColumnIndex("cityId"));
          k = ((Integer)paramMap.get(str1)).intValue();
          i = 0;
          if (i >= j) {
            break label775;
          }
          if (arrayOfString[i].equals("cityId")) {
            break label882;
          }
          if (!arrayOfString[i].equals("nowTemp")) {
            break label285;
          }
          str2 = localCursor.getString(i);
          if (!a(str2)) {
            break label882;
          }
          ((ContentValues)localObject).put("nowTempValue", Float.valueOf(str2));
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
      }
      for (;;)
      {
        if ((localCursor != null) && (!localCursor.isClosed())) {}
        try
        {
          localCursor.close();
          return;
        }
        catch (Exception paramSQLiteDatabase)
        {
          label285:
          float f2;
          float f1;
          return;
        }
        if (arrayOfString[i].equals("highTemp"))
        {
          str2 = localCursor.getString(i);
          if (!a(str2)) {
            break label882;
          }
          ((ContentValues)localObject).put("highTempValue", Float.valueOf(str2));
          break label882;
        }
        if (arrayOfString[i].equals("lowTemp"))
        {
          str2 = localCursor.getString(i);
          if (!a(str2)) {
            break label882;
          }
          ((ContentValues)localObject).put("lowTempValue", Float.valueOf(str2));
          break label882;
        }
        if (arrayOfString[i].equals("feels_like"))
        {
          str2 = localCursor.getString(i);
          if (!a(str2)) {
            break label882;
          }
          ((ContentValues)localObject).put("feelslikeValue", Float.valueOf(str2));
          break label882;
        }
        if (arrayOfString[i].equals("windStrengthInt"))
        {
          str2 = localCursor.getString(i);
          if (!a(str2)) {
            break label882;
          }
          f2 = Float.valueOf(str2).floatValue();
          f1 = f2;
          if (k == 1) {
            f1 = com.gau.go.launcherex.gowidget.weather.util.q.c((int)f2);
          }
          ((ContentValues)localObject).put("windStrengthValue", Float.valueOf(f1));
          break label882;
        }
        if (arrayOfString[i].equals("dewpoint"))
        {
          str2 = localCursor.getString(i);
          if (!a(str2)) {
            break label882;
          }
          ((ContentValues)localObject).put("dewpointValue", Float.valueOf(str2));
          break label882;
        }
        if (arrayOfString[i].equals("uvIndex"))
        {
          str2 = localCursor.getString(i);
          if (!a(str2)) {
            break label882;
          }
          ((ContentValues)localObject).put("uvIndexValue", Float.valueOf(str2));
          break label882;
        }
        if (arrayOfString[i].equals("humidity"))
        {
          str2 = localCursor.getString(i).replaceAll("%", "");
          if (!a(str2)) {
            break label882;
          }
          ((ContentValues)localObject).put("humidityValue", Integer.valueOf(str2));
          break label882;
        }
        if (arrayOfString[i].equals("barometer"))
        {
          str2 = localCursor.getString(i).split(" ")[0];
          if (!a(str2)) {
            break label882;
          }
          ((ContentValues)localObject).put("barometerValue", Float.valueOf(str2));
          break label882;
        }
        if (!arrayOfString[i].equals("visibility")) {
          break label882;
        }
        str2 = localCursor.getString(i).split(" ")[0];
        if (!a(str2)) {
          break label882;
        }
        ((ContentValues)localObject).put("visibilityValue", Float.valueOf(str2));
        break label882;
        label775:
        localHashMap.put(str1, localObject);
        if (localCursor.moveToNext()) {
          break;
        }
        paramMap = localHashMap.keySet().iterator();
        while (paramMap.hasNext())
        {
          localObject = (String)paramMap.next();
          paramSQLiteDatabase.update("citynow", (ContentValues)localHashMap.get(localObject), "cityId='" + (String)localObject + "'", null);
        }
      }
      label882:
      i += 1;
    }
  }
  
  private String c(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    paramString = paramSQLiteDatabase.query("common_setting_table", new String[] { "setting_key", "setting_value" }, "setting_key=?", new String[] { paramString }, null, null, null);
    paramSQLiteDatabase = (SQLiteDatabase)localObject2;
    if (paramString != null)
    {
      paramSQLiteDatabase = (SQLiteDatabase)localObject1;
      if (paramString.getCount() > 0)
      {
        paramString.moveToFirst();
        int i = paramString.getColumnIndex("setting_value");
        paramSQLiteDatabase = (SQLiteDatabase)localObject1;
        if (i != -1) {
          paramSQLiteDatabase = paramString.getString(i);
        }
      }
      paramString.close();
    }
    return paramSQLiteDatabase;
  }
  
  private void c()
  {
    if (this.d) {
      return;
    }
    Object localObject1 = this.b.getFilesDir() + "/city";
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdir();
    }
    localObject2 = (String)localObject1 + "/" + "go_city.db";
    localObject1 = new File((String)localObject2);
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
    localObject1 = this.b.getResources().openRawResource(2131099678);
    try
    {
      localObject2 = new FileOutputStream((String)localObject2);
      byte[] arrayOfByte = new byte[' '];
      for (;;)
      {
        int i = ((InputStream)localObject1).read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        ((FileOutputStream)localObject2).write(arrayOfByte, 0, i);
      }
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return;
      ((FileOutputStream)localObject2).close();
      localFileNotFoundException.close();
      this.d = true;
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  private void c(Cursor paramCursor, ContentValues paramContentValues)
  {
    int k = paramCursor.getColumnCount();
    int i = 0;
    if (i < k)
    {
      String str = paramCursor.getColumnName(i);
      if (str.equals("msgId")) {
        paramContentValues.put("mesageid", "gcm" + paramCursor.getString(i));
      }
      for (;;)
      {
        i += 1;
        break;
        if (str.equals("msgTitle"))
        {
          paramContentValues.put("title", paramCursor.getString(i));
        }
        else if (str.equals("startTime"))
        {
          paramContentValues.put("date", i.a(paramCursor.getString(i)));
        }
        else if (str.equals("isMsgBar"))
        {
          str = paramCursor.getString(i);
          int j = 1;
          if (str.equals("1")) {
            j = 3;
          }
          paramContentValues.put("viewtype", Integer.valueOf(j));
        }
        else if (str.equals("msgContent"))
        {
          paramContentValues.put("intro", paramCursor.getString(i));
        }
        else if (str.equals("isRead"))
        {
          paramContentValues.put("readed", paramCursor.getString(i));
        }
        else if (!str.equals("isDeleted")) {}
      }
    }
    paramContentValues.put("type", Integer.valueOf(100));
    paramContentValues.put("url", "");
    paramContentValues.put("stime_start", "00:00:00");
    paramContentValues.put("stime_end", "23:59:59");
    paramContentValues.put("icon", "");
    paramContentValues.put("acttype", "0");
    paramContentValues.put("actvalue", "");
    paramContentValues.put("zicon1", "");
    paramContentValues.put("zicon2", "");
    paramContentValues.put("zpos", "0");
    paramContentValues.put("ztime", "0");
    paramContentValues.put("isclosed", "0");
    paramContentValues.put("filter_pkgs", "");
    paramContentValues.put("clickclosed", "0");
    paramContentValues.put("dynamic", "0");
    paramContentValues.put("iconpos", "0");
    paramContentValues.put("fullscreenicon", "");
    paramContentValues.put("removed", "1");
  }
  
  private void c(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.query("setting", null, null, null, null, null, null);
    ContentValues localContentValues = new ContentValues();
    if (localCursor != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (localCursor.getCount() > 0)
        {
          localCursor.moveToFirst();
          int j = localCursor.getColumnCount();
          String[] arrayOfString = localCursor.getColumnNames();
          i = 0;
          if (i < j) {
            if (arrayOfString[i].equals("autoUpdate")) {
              localContentValues.put("autoUpdate", Integer.valueOf(localCursor.getInt(i)));
            } else if (arrayOfString[i].equals("autpUpdateFreq")) {
              localContentValues.put("autpUpdateFreq", Integer.valueOf(localCursor.getInt(i)));
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localCursor.close();
        localContentValues.put("auto_update_time_begin", Integer.valueOf(0));
        localContentValues.put("auto_update_time_end", Integer.valueOf(0));
        localContentValues.put("isCycle", Integer.valueOf(0));
        localContentValues.put("dateStyle", Integer.valueOf(1));
        try
        {
          paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS setting");
          paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting (_id INTEGER PRIMARY KEY, autoUpdate INTEGER, autpUpdateFreq INTEGER, tempUnit INTEGER, calendarType INTEGER, festival INTEGER, auto_update_time_begin INTEGER, auto_update_time_end INTEGER, isCycle INTEGER, dateStyle INTEGER, notify INTEGER, notify_city TEXT, notify_type INTEGER, manual_refresh INTEGER, windUnit INTEGER,notify_city_type INTEGER, world_clock INTEGER, widgt_clock TEXT, widgt_calendar TEXT)");
          paramSQLiteDatabase.insert("setting", null, localContentValues);
          return;
        }
        catch (SQLException paramSQLiteDatabase)
        {
          paramSQLiteDatabase.printStackTrace();
          return;
        }
        if (localException[i].equals("calendarType")) {
          localContentValues.put("calendarType", Integer.valueOf(localCursor.getInt(i)));
        }
      }
      finally
      {
        localCursor.close();
      }
      if (localException[i].equals("festival")) {
        localContentValues.put("festival", Integer.valueOf(localCursor.getInt(i)));
      } else if (localException[i].equals("tempUnit")) {
        localContentValues.put("tempUnit", Integer.valueOf(localCursor.getInt(i)));
      }
      i += 1;
    }
  }
  
  private void c(SQLiteDatabase paramSQLiteDatabase, Map paramMap)
  {
    Cursor localCursor = paramSQLiteDatabase.query("forecast", new String[] { "_id", "cityId", "lowTemp", "highTemp", "windStrengthInt" }, null, null, null, null, null);
    HashMap localHashMap = new HashMap();
    if (localCursor != null) {}
    for (;;)
    {
      ContentValues localContentValues;
      String[] arrayOfString;
      int k;
      int i;
      Object localObject2;
      String str;
      try
      {
        if (localCursor.getCount() > 0)
        {
          int j = localCursor.getColumnCount();
          localCursor.moveToFirst();
          localContentValues = new ContentValues();
          arrayOfString = localCursor.getColumnNames();
          k = ((Integer)paramMap.get(localCursor.getString(localCursor.getColumnIndex("cityId")))).intValue();
          i = 0;
          localObject1 = "";
          if (i >= j) {
            break label406;
          }
          if (arrayOfString[i].equals("_id"))
          {
            localObject2 = localCursor.getString(i);
          }
          else if (arrayOfString[i].equals("highTemp"))
          {
            str = localCursor.getString(i);
            localObject2 = localObject1;
            if (!a(str)) {
              break label513;
            }
            localContentValues.put("highTempValue", Float.valueOf(str));
            localObject2 = localObject1;
          }
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
      }
      for (;;)
      {
        if ((localCursor != null) && (!localCursor.isClosed())) {}
        try
        {
          localCursor.close();
          return;
        }
        catch (Exception paramSQLiteDatabase)
        {
          float f2;
          float f1;
          return;
        }
        if (arrayOfString[i].equals("lowTemp"))
        {
          str = localCursor.getString(i);
          localObject2 = localObject1;
          if (!a(str)) {
            break label513;
          }
          localContentValues.put("lowTempValue", Float.valueOf(str));
          localObject2 = localObject1;
          break label513;
        }
        localObject2 = localObject1;
        if (!arrayOfString[i].equals("windStrengthInt")) {
          break label513;
        }
        str = localCursor.getString(i);
        localObject2 = localObject1;
        if (!a(str)) {
          break label513;
        }
        f2 = Float.valueOf(str).floatValue();
        f1 = f2;
        if (k == 1) {
          f1 = com.gau.go.launcherex.gowidget.weather.util.q.c((int)f2);
        }
        localContentValues.put("windStrengthValue", Float.valueOf(f1));
        localObject2 = localObject1;
        break label513;
        label406:
        localHashMap.put(localObject1, localContentValues);
        if (localCursor.moveToNext()) {
          break;
        }
        paramMap = localHashMap.keySet().iterator();
        while (paramMap.hasNext())
        {
          localObject1 = (String)paramMap.next();
          paramSQLiteDatabase.update("forecast", (ContentValues)localHashMap.get(localObject1), "_id ='" + (String)localObject1 + "'", null);
        }
      }
      label513:
      i += 1;
      Object localObject1 = localObject2;
    }
  }
  
  private void d()
  {
    SharedPreferences.Editor localEditor = this.b.getSharedPreferences("goweatherex_info", 0).edit();
    a(localEditor);
    localEditor.commit();
  }
  
  private void d(SQLiteDatabase paramSQLiteDatabase)
  {
    if (a(paramSQLiteDatabase, "citynow"))
    {
      ArrayList localArrayList = e(paramSQLiteDatabase);
      try
      {
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS citynow");
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS citynow (_id INTEGER PRIMARY KEY, cityId TEXT, oldCityId TEXT, cityName TEXT, cityType INTEGER, updateTime INTEGER, nowTemp TEXT, highTemp TEXT, lowTemp TEXT, humidity TEXT, type INTEGER, nowDesp TEXT, windType INTEGER, windDirection TEXT, windStrength TEXT, windStrengthInt INTEGER, visibility TEXT, barometer TEXT, dewpoint TEXT, uvIndex TEXT, sunrise TEXT, sunset TEXT, sequence INTEGER, myLocation INTEGER, city_my_location INTEGER, language INTEGER, wind INTEGER, tz_offset INTEGER, pop INTEGER, rainFall REAL, feels_like INTEGER, state TEXT, country TEXT, nowTempValue REAL, highTempValue REAL, lowTempValue REAL, humidityValue INTEGER, windStrengthValue REAL, visibilityValue REAL, barometerValue REAL, dewpointValue REAL, uvIndexValue REAL, feelslikeValue REAL, timestamp INTEGER, aqi INTEGER, qualityType INTEGER, pm25 INTEGER, pm10 INTEGER, so2 INTEGER, no2 INTEGER, latitude TEXT, longitude TEXT, hasRadar INTEGER, hasSatellite INTEGER, northeast TEXT, southwest TEXT, cityJsonString TEXT)");
        if (localArrayList != null)
        {
          int j = localArrayList.size();
          int i = 0;
          while (i < j)
          {
            paramSQLiteDatabase.insert("citynow", null, (ContentValues)localArrayList.get(i));
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
      }
    }
  }
  
  private void d(SQLiteDatabase paramSQLiteDatabase, Map paramMap)
  {
    Cursor localCursor = paramSQLiteDatabase.query("hourly", new String[] { "_id", "cityId", "date", "temp", "windStrengthInt", "humidity" }, null, null, null, null, null);
    HashMap localHashMap = new HashMap();
    if (localCursor != null) {}
    for (;;)
    {
      Time localTime;
      ContentValues localContentValues;
      String[] arrayOfString;
      int k;
      int i;
      Object localObject2;
      try
      {
        if (localCursor.getCount() > 0)
        {
          int j = localCursor.getColumnCount();
          localTime = new Time();
          localTime.setToNow();
          localCursor.moveToFirst();
          localContentValues = new ContentValues();
          arrayOfString = localCursor.getColumnNames();
          k = ((Integer)paramMap.get(localCursor.getString(localCursor.getColumnIndex("cityId")))).intValue();
          i = 0;
          localObject1 = "";
          if (i >= j) {
            break label582;
          }
          if (arrayOfString[i].equals("_id"))
          {
            localObject2 = localCursor.getString(i);
          }
          else if (arrayOfString[i].equals("date"))
          {
            localObject2 = localCursor.getString(i);
            if ((localTime.month == 11) && ((((String)localObject2).startsWith("01/")) || (((String)localObject2).startsWith("1/"))))
            {
              localContentValues.put("date_long", localTime.year + 1 + "/" + (String)localObject2);
              localObject2 = localObject1;
            }
          }
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
      }
      for (;;)
      {
        if ((localCursor != null) && (!localCursor.isClosed())) {}
        try
        {
          localCursor.close();
          return;
        }
        catch (Exception paramSQLiteDatabase)
        {
          String str;
          float f2;
          float f1;
          return;
        }
        localContentValues.put("date_long", localTime.year + "/" + (String)localObject2);
        localObject2 = localObject1;
        break label689;
        if (arrayOfString[i].equals("temp"))
        {
          str = localCursor.getString(i);
          localObject2 = localObject1;
          if (!a(str)) {
            break label689;
          }
          localContentValues.put("tempValue", Float.valueOf(str));
          localObject2 = localObject1;
          break label689;
        }
        if (arrayOfString[i].equals("humidity"))
        {
          str = localCursor.getString(i).replaceAll("%", "");
          localObject2 = localObject1;
          if (!a(str)) {
            break label689;
          }
          localContentValues.put("humidityValue", Integer.valueOf(str));
          localObject2 = localObject1;
          break label689;
        }
        localObject2 = localObject1;
        if (!arrayOfString[i].equals("windStrengthInt")) {
          break label689;
        }
        str = localCursor.getString(i);
        localObject2 = localObject1;
        if (!a(str)) {
          break label689;
        }
        f2 = Float.valueOf(str).floatValue();
        f1 = f2;
        if (k == 1) {
          f1 = com.gau.go.launcherex.gowidget.weather.util.q.c((int)f2);
        }
        localContentValues.put("windStrengthValue", Float.valueOf(f1));
        localObject2 = localObject1;
        break label689;
        label582:
        localHashMap.put(localObject1, localContentValues);
        if (localCursor.moveToNext()) {
          break;
        }
        paramMap = localHashMap.keySet().iterator();
        while (paramMap.hasNext())
        {
          localObject1 = (String)paramMap.next();
          paramSQLiteDatabase.update("hourly", (ContentValues)localHashMap.get(localObject1), "_id ='" + (String)localObject1 + "'", null);
        }
      }
      label689:
      i += 1;
      Object localObject1 = localObject2;
    }
  }
  
  private ArrayList e(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.query("citynow", new String[] { "cityId", "cityName", "cityType", "nowTemp", "nowDesp", "lowTemp", "highTemp", "humidity", "type", "wind", "updateTime", "language" }, null, null, null, null, null);
      ArrayList localArrayList = new ArrayList();
      if (paramSQLiteDatabase != null) {}
      try
      {
        paramSQLiteDatabase.moveToFirst();
        int i = 0;
        boolean bool;
        do
        {
          ContentValues localContentValues = new ContentValues();
          a(paramSQLiteDatabase, i, localContentValues);
          localArrayList.add(localContentValues);
          i += 1;
          bool = paramSQLiteDatabase.moveToNext();
        } while (bool);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      finally
      {
        paramSQLiteDatabase.close();
      }
      paramSQLiteDatabase.close();
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      for (;;)
      {
        paramSQLiteDatabase.printStackTrace();
        paramSQLiteDatabase = null;
      }
    }
  }
  
  private boolean e()
  {
    return com.gau.go.launcherex.gowidget.weather.util.r.a(this.b, "city", 2131099679);
  }
  
  private void f()
  {
    Object localObject = this.b.getSharedPreferences("goweatherex_info", 0);
    String str1 = ((SharedPreferences)localObject).getString("key_adid_location_1", "");
    String str2 = ((SharedPreferences)localObject).getString("key_adid_location_2", "");
    if ((!TextUtils.isEmpty(str1)) && (str1.contains("#")) && (!TextUtils.isEmpty(str2)) && (str2.contains("#")) && (str1.split("#").length == 5))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("key_adid_location_1", str1 + "#" + "0");
      ((SharedPreferences.Editor)localObject).putString("key_adid_location_2", str2 + "#" + "0");
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  private void f(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    a(paramSQLiteDatabase, (ArrayList)localObject2);
    b(paramSQLiteDatabase, (ArrayList)localObject1);
    int i;
    do
    {
      do
      {
        try
        {
          paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS citynow");
          paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS forecast");
          paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS citynow (_id INTEGER PRIMARY KEY, cityId TEXT, oldCityId TEXT, cityName TEXT, cityType INTEGER, updateTime INTEGER, nowTemp TEXT, highTemp TEXT, lowTemp TEXT, humidity TEXT, type INTEGER, nowDesp TEXT, windType INTEGER, windDirection TEXT, windStrength TEXT, windStrengthInt INTEGER, visibility TEXT, barometer TEXT, dewpoint TEXT, uvIndex TEXT, sunrise TEXT, sunset TEXT, sequence INTEGER, myLocation INTEGER, city_my_location INTEGER, language INTEGER, wind INTEGER, tz_offset INTEGER, pop INTEGER, rainFall REAL, feels_like INTEGER, state TEXT, country TEXT, nowTempValue REAL, highTempValue REAL, lowTempValue REAL, humidityValue INTEGER, windStrengthValue REAL, visibilityValue REAL, barometerValue REAL, dewpointValue REAL, uvIndexValue REAL, feelslikeValue REAL, timestamp INTEGER, aqi INTEGER, qualityType INTEGER, pm25 INTEGER, pm10 INTEGER, so2 INTEGER, no2 INTEGER, latitude TEXT, longitude TEXT, hasRadar INTEGER, hasSatellite INTEGER, northeast TEXT, southwest TEXT, cityJsonString TEXT)");
          paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS forecast(_id INTEGER PRIMARY KEY, weekDate TEXT, lowTemp TEXT, highTemp TEXT, type INTEGER, status TEXT, cityId TEXT, date TEXT, windType INTEGER, windDir TEXT, windStrength TEXT, windStrengthInt INTEGER,dayId INTEGER, pop INTEGER, status_day TEXT, status_night TEXT, date_long TEXT, lowTempValue REAL, highTempValue REAL, windStrengthValue REAL)");
          paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hourly(_id INTEGER PRIMARY KEY, date TEXT, hour INTEGER, temp TEXT, type INTEGER, cityId TEXT, windType INTEGER, windDirection TEXT, windStrength TEXT, windStrengthInt INTEGER, status TEXT, humidity TEXT, pop INTEGER, date_long TEXT, tempValue REAL, windStrengthValue REAL, humidityValue INTEGER)");
          paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS alarm (_id INTEGER PRIMARY KEY, cityId TEXT, alarmInfo TEXT)");
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            paramSQLiteDatabase.insert("citynow", null, (ContentValues)((Iterator)localObject2).next());
          }
          localObject1 = ((ArrayList)localObject1).iterator();
        }
        catch (SQLException paramSQLiteDatabase)
        {
          paramSQLiteDatabase.printStackTrace();
          return;
        }
        while (((Iterator)localObject1).hasNext()) {
          paramSQLiteDatabase.insert("forecast", null, (ContentValues)((Iterator)localObject1).next());
        }
        localObject1 = paramSQLiteDatabase.query("setting", new String[] { "autoUpdate", "autpUpdateFreq", "tempUnit", "calendarType", "festival", "auto_update_time_begin", "auto_update_time_end", "isCycle", "dateStyle" }, null, null, null, null, null);
      } while (localObject1 == null);
      i = ((Cursor)localObject1).getCount();
    } while (i <= 0);
    for (;;)
    {
      String str;
      try
      {
        ((Cursor)localObject1).moveToFirst();
        localObject2 = new ContentValues();
        int j = ((Cursor)localObject1).getColumnCount();
        i = 0;
        if (i >= j) {
          break label612;
        }
        str = ((Cursor)localObject1).getColumnName(i);
        if (str.equals("autoUpdate")) {
          ((ContentValues)localObject2).put("autoUpdate", Integer.valueOf(((Cursor)localObject1).getInt(i)));
        } else if (str.equals("autpUpdateFreq")) {
          ((ContentValues)localObject2).put("autpUpdateFreq", Integer.valueOf(((Cursor)localObject1).getInt(i)));
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        return;
        if (str.equals("tempUnit")) {
          ((ContentValues)localObject2).put("tempUnit", Integer.valueOf(((Cursor)localObject1).getInt(i)));
        }
      }
      finally
      {
        ((Cursor)localObject1).close();
      }
      if (str.equals("calendarType"))
      {
        ((ContentValues)localObject2).put("calendarType", Integer.valueOf(((Cursor)localObject1).getInt(i)));
      }
      else if (str.equals("festival"))
      {
        ((ContentValues)localObject2).put("festival", Integer.valueOf(((Cursor)localObject1).getInt(i)));
      }
      else if (str.equals("auto_update_time_begin"))
      {
        ((ContentValues)localObject2).put("auto_update_time_begin", Integer.valueOf(((Cursor)localObject1).getInt(i)));
      }
      else if (str.equals("auto_update_time_end"))
      {
        ((ContentValues)localObject2).put("auto_update_time_end", Integer.valueOf(((Cursor)localObject1).getInt(i)));
      }
      else if (str.equals("isCycle"))
      {
        ((ContentValues)localObject2).put("isCycle", Integer.valueOf(((Cursor)localObject1).getInt(i)));
      }
      else if (str.equals("dateStyle"))
      {
        ((ContentValues)localObject2).put("dateStyle", Integer.valueOf(((Cursor)localObject1).getInt(i)));
        break label690;
        label612:
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS setting");
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting (_id INTEGER PRIMARY KEY, autoUpdate INTEGER, autpUpdateFreq INTEGER, tempUnit INTEGER, calendarType INTEGER, festival INTEGER, auto_update_time_begin INTEGER, auto_update_time_end INTEGER, isCycle INTEGER, dateStyle INTEGER, notify INTEGER, notify_city TEXT, notify_type INTEGER, manual_refresh INTEGER, windUnit INTEGER,notify_city_type INTEGER, world_clock INTEGER, widgt_clock TEXT, widgt_calendar TEXT)");
        ((ContentValues)localObject2).put("notify", Integer.valueOf(0));
        ((ContentValues)localObject2).put("notify_city", "");
        ((ContentValues)localObject2).put("notify_type", Integer.valueOf(1));
        ((ContentValues)localObject2).put("manual_refresh", Integer.valueOf(0));
        paramSQLiteDatabase.insert("setting", null, (ContentValues)localObject2);
        ((Cursor)localObject1).close();
        return;
      }
      label690:
      i += 1;
    }
  }
  
  private void g()
  {
    SharedPreferences localSharedPreferences = this.b.getSharedPreferences("goweatherex_info", 0);
    if (localSharedPreferences.getInt("key_days_trend_show_tip_view_count", 0) + localSharedPreferences.getInt("key_hours_trend_show_tip_view_count", 0) + localSharedPreferences.getInt("key_rain_trend_show_tip_view_count", 0) > 0) {
      localSharedPreferences.edit().putInt("key_trend_show_tip_view_count", 2).commit();
    }
  }
  
  private void g(SQLiteDatabase paramSQLiteDatabase)
  {
    c();
    i(paramSQLiteDatabase);
    h(paramSQLiteDatabase);
  }
  
  private SQLiteDatabase h()
  {
    Object localObject3 = null;
    try
    {
      localObject1 = getWritableDatabase();
      return (SQLiteDatabase)localObject1;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        Object localObject1 = localObject3;
        if ("unable to open database file".equalsIgnoreCase(localSQLiteException.getMessage()))
        {
          localObject1 = localObject3;
          if (this.b.deleteDatabase("weather.db"))
          {
            Toast.makeText(this.b, 2131165825, 0).show();
            localObject1 = getWritableDatabase();
          }
        }
      }
    }
    finally {}
  }
  
  private void h(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = paramSQLiteDatabase.query("citynow", new String[] { "updateTime", "cityId" }, null, null, null, null, null);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (localObject != null) {
      ((Cursor)localObject).moveToFirst();
    }
    for (;;)
    {
      int i;
      try
      {
        ContentValues localContentValues = new ContentValues();
        j = ((Cursor)localObject).getColumnCount();
        i = 0;
        if (i < j) {
          if (((Cursor)localObject).getColumnName(i).equals("updateTime")) {
            localContentValues.put("updateTime", com.gau.go.launcherex.gowidget.weather.util.r.b(((Cursor)localObject).getString(i)));
          } else if (((Cursor)localObject).getColumnName(i).equals("cityId")) {
            localArrayList2.add(((Cursor)localObject).getString(i));
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        ((Cursor)localObject).close();
        int j = localArrayList2.size();
        i = 0;
        if (i < j)
        {
          localObject = ((ContentValues)localArrayList1.get(i)).getAsString("updateTime");
          System.out.println("object + " + (String)localObject);
          localObject = (String)localArrayList2.get(i);
          int k = paramSQLiteDatabase.update("citynow", (ContentValues)localArrayList1.get(i), "cityId = '" + (String)localObject + "'", null);
          System.out.println("update + " + k);
          i += 1;
          continue;
          localArrayList1.add(localException);
          boolean bool = ((Cursor)localObject).moveToNext();
          if (bool) {
            continue;
          }
          continue;
        }
      }
      finally
      {
        ((Cursor)localObject).close();
      }
      return;
      i += 1;
    }
  }
  
  private void i(SQLiteDatabase paramSQLiteDatabase)
  {
    if (!a("windUnit", "setting", paramSQLiteDatabase)) {
      paramSQLiteDatabase.execSQL("ALTER TABLE 'setting' ADD 'windUnit' INTEGER");
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("windUnit", Integer.valueOf(2));
    paramSQLiteDatabase.update("setting", localContentValues, null, null);
  }
  
  private void j(SQLiteDatabase paramSQLiteDatabase)
  {
    k(paramSQLiteDatabase);
    l(paramSQLiteDatabase);
  }
  
  private void k(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.query("citynow", new String[] { "cityId", "sequence" }, null, null, null, null, "sequence ASC ");
    ArrayList localArrayList = new ArrayList();
    if ((localCursor != null) && (localCursor.getCount() > 0)) {}
    for (;;)
    {
      try
      {
        localCursor.moveToFirst();
        if (!localCursor.isAfterLast())
        {
          j = localCursor.getColumnCount();
          i = 0;
          if (i < j)
          {
            localObject = localCursor.getColumnName(i);
            if (((String)localObject).equals("cityId"))
            {
              localArrayList.add(localCursor.getString(i));
            }
            else if (((String)localObject).equals("sequence"))
            {
              int k = localCursor.getInt(i);
              System.out.println(k);
            }
          }
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        return;
        localCursor.moveToNext();
        continue;
      }
      finally
      {
        localCursor.close();
      }
      int j = localArrayList.size();
      Object localObject = new ContentValues();
      int i = 0;
      while (i < j)
      {
        ((ContentValues)localObject).clear();
        ((ContentValues)localObject).put("sequence", Integer.valueOf(i));
        paramSQLiteDatabase.update("citynow", (ContentValues)localObject, "cityId='" + (String)localArrayList.get(i) + "'", null);
        i += 1;
      }
      continue;
      i += 1;
    }
  }
  
  /* Error */
  private void l(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 100
    //   3: iconst_2
    //   4: anewarray 67	java/lang/String
    //   7: dup
    //   8: iconst_0
    //   9: ldc_w 1202
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: ldc_w 1204
    //   18: aastore
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokevirtual 154	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 8
    //   29: aload 8
    //   31: ifnull +304 -> 335
    //   34: aload 8
    //   36: invokeinterface 160 1 0
    //   41: ifle +294 -> 335
    //   44: iconst_m1
    //   45: istore_2
    //   46: aload 8
    //   48: invokeinterface 163 1 0
    //   53: pop
    //   54: aload 8
    //   56: invokeinterface 227 1 0
    //   61: istore 5
    //   63: iconst_0
    //   64: istore_3
    //   65: iconst_m1
    //   66: istore_2
    //   67: aconst_null
    //   68: astore 6
    //   70: iload_3
    //   71: iload 5
    //   73: if_icmpge +411 -> 484
    //   76: aload 8
    //   78: iload_3
    //   79: invokeinterface 231 2 0
    //   84: astore 9
    //   86: aload 9
    //   88: ldc_w 1204
    //   91: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   94: ifeq +19 -> 113
    //   97: aload 8
    //   99: iload_3
    //   100: invokeinterface 235 2 0
    //   105: astore 7
    //   107: iload_2
    //   108: istore 4
    //   110: goto +389 -> 499
    //   113: iload_2
    //   114: istore 4
    //   116: aload 6
    //   118: astore 7
    //   120: aload 9
    //   122: ldc_w 1202
    //   125: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   128: ifeq +371 -> 499
    //   131: aload 8
    //   133: iload_3
    //   134: invokeinterface 657 2 0
    //   139: istore 4
    //   141: aload 6
    //   143: astore 7
    //   145: goto +354 -> 499
    //   148: astore 7
    //   150: aconst_null
    //   151: astore 6
    //   153: aload 7
    //   155: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   158: aload 8
    //   160: invokeinterface 213 1 0
    //   165: aload 6
    //   167: ifnull +197 -> 364
    //   170: ldc 61
    //   172: aload 6
    //   174: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   177: ifne +187 -> 364
    //   180: new 73	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   187: ldc_w 987
    //   190: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload 6
    //   195: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc -58
    //   200: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc_w 1286
    //   206: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc_w 673
    //   212: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc_w 1288
    //   218: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc -58
    //   223: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload 6
    //   228: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc -58
    //   233: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: astore 6
    //   241: aload_1
    //   242: ldc_w 294
    //   245: iconst_1
    //   246: anewarray 67	java/lang/String
    //   249: dup
    //   250: iconst_0
    //   251: ldc -19
    //   253: aastore
    //   254: aload 6
    //   256: aconst_null
    //   257: aconst_null
    //   258: aconst_null
    //   259: aconst_null
    //   260: invokevirtual 154	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   263: astore 6
    //   265: aload 6
    //   267: ifnull +68 -> 335
    //   270: aload 6
    //   272: invokeinterface 160 1 0
    //   277: ifle +58 -> 335
    //   280: aload 6
    //   282: invokeinterface 163 1 0
    //   287: pop
    //   288: aload 6
    //   290: iconst_0
    //   291: invokeinterface 235 2 0
    //   296: astore 7
    //   298: new 165	android/content/ContentValues
    //   301: dup
    //   302: invokespecial 166	android/content/ContentValues:<init>	()V
    //   305: astore 8
    //   307: aload 8
    //   309: ldc_w 1204
    //   312: aload 7
    //   314: invokevirtual 270	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload_1
    //   318: ldc 100
    //   320: aload 8
    //   322: aconst_null
    //   323: aconst_null
    //   324: invokevirtual 202	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   327: pop
    //   328: aload 6
    //   330: invokeinterface 213 1 0
    //   335: return
    //   336: astore_1
    //   337: aload 8
    //   339: invokeinterface 213 1 0
    //   344: aload_1
    //   345: athrow
    //   346: astore_1
    //   347: aload_1
    //   348: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   351: goto -23 -> 328
    //   354: astore_1
    //   355: aload 6
    //   357: invokeinterface 213 1 0
    //   362: aload_1
    //   363: athrow
    //   364: iload_2
    //   365: iconst_1
    //   366: if_icmpne -31 -> 335
    //   369: aload_1
    //   370: ldc_w 294
    //   373: iconst_1
    //   374: anewarray 67	java/lang/String
    //   377: dup
    //   378: iconst_0
    //   379: ldc -19
    //   381: aastore
    //   382: aconst_null
    //   383: aconst_null
    //   384: aconst_null
    //   385: aconst_null
    //   386: aconst_null
    //   387: ldc_w 403
    //   390: invokevirtual 780	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   393: astore 6
    //   395: aload 6
    //   397: ifnull -62 -> 335
    //   400: aload 6
    //   402: invokeinterface 160 1 0
    //   407: ifle -72 -> 335
    //   410: aload 6
    //   412: invokeinterface 163 1 0
    //   417: pop
    //   418: aload 6
    //   420: iconst_0
    //   421: invokeinterface 235 2 0
    //   426: astore 7
    //   428: new 165	android/content/ContentValues
    //   431: dup
    //   432: invokespecial 166	android/content/ContentValues:<init>	()V
    //   435: astore 8
    //   437: aload 8
    //   439: ldc_w 1204
    //   442: aload 7
    //   444: invokevirtual 270	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: aload_1
    //   448: ldc 100
    //   450: aload 8
    //   452: aconst_null
    //   453: aconst_null
    //   454: invokevirtual 202	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   457: pop
    //   458: aload 6
    //   460: invokeinterface 213 1 0
    //   465: return
    //   466: astore_1
    //   467: aload_1
    //   468: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   471: goto -13 -> 458
    //   474: astore_1
    //   475: aload 6
    //   477: invokeinterface 213 1 0
    //   482: aload_1
    //   483: athrow
    //   484: aload 8
    //   486: invokeinterface 213 1 0
    //   491: goto -326 -> 165
    //   494: astore 7
    //   496: goto -343 -> 153
    //   499: iload_3
    //   500: iconst_1
    //   501: iadd
    //   502: istore_3
    //   503: iload 4
    //   505: istore_2
    //   506: aload 7
    //   508: astore 6
    //   510: goto -440 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	this	a
    //   0	513	1	paramSQLiteDatabase	SQLiteDatabase
    //   45	461	2	i	int
    //   64	439	3	j	int
    //   108	396	4	k	int
    //   61	13	5	m	int
    //   68	441	6	localObject1	Object
    //   105	39	7	localObject2	Object
    //   148	6	7	localException1	Exception
    //   296	147	7	str1	String
    //   494	13	7	localException2	Exception
    //   27	458	8	localObject3	Object
    //   84	37	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   46	63	148	java/lang/Exception
    //   46	63	336	finally
    //   76	107	336	finally
    //   120	141	336	finally
    //   153	158	336	finally
    //   280	328	346	java/lang/Exception
    //   280	328	354	finally
    //   347	351	354	finally
    //   410	458	466	java/lang/Exception
    //   410	458	474	finally
    //   467	471	474	finally
    //   76	107	494	java/lang/Exception
    //   120	141	494	java/lang/Exception
  }
  
  private void m(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS common_setting_table (_id INTEGER PRIMARY KEY, setting_key TEXT, setting_value TEXT)");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('app_widget_theme', 'app_widget_theme_white')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('appwidget42_city', '')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('appwidget41_city', '')");
  }
  
  private void n(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('appwidget21_city', '')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('auto_location', '0')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('boot_refresh', '1')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('launch_refresh', '1')");
    a("citynow", "myLocation", "INTEGER", 1, paramSQLiteDatabase);
    a("weather11_city", "my_location", "INTEGER", 1, paramSQLiteDatabase);
    a("setting", "notify_city_type", "INTEGER", 1, paramSQLiteDatabase);
  }
  
  private void o(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('go_widget_theme', '' )");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('app_widget_theme_data_timestamp', '0')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('go_widget_theme_data_timestamp', '0')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('app_theme_data_timestamp', '0')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('app_theme', 'com.gau.go.launcherex.gowidget.weatherwidget' )");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS app_widget_theme_table (_id INTEGER PRIMARY KEY, theme_type INTEGER, theme_id INTEGER, is_all INTEGER, is_sale INTEGER, preview_id TEXT, preview_path TEXT, summary TEXT, version TEXT, version_num INTEGER, package_name TEXT, fee_type INTEGER, price TEXT, size TEXT, update_time TEXT, download TEXT, ftp_url TEXT, app_market_url TEXT, web_market_url TEXT, go_boutique_url TEXT, other_url TEXT, name TEXT)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS gowidget_theme_table (_id INTEGER PRIMARY KEY, widget_id INTEGER, widget_theme TEXT)");
    c();
  }
  
  private void p(SQLiteDatabase paramSQLiteDatabase)
  {
    a("setting", "world_clock", "INTEGER", 1, paramSQLiteDatabase);
    a("setting", "widgt_clock", "", paramSQLiteDatabase);
    a("setting", "widgt_calendar", "", paramSQLiteDatabase);
    a("citynow", "tz_offset", "INTEGER", 55536, paramSQLiteDatabase);
    a("citynow", "pop", "INTEGER", 55536, paramSQLiteDatabase);
    a("citynow", "feels_like", "INTEGER", 55536, paramSQLiteDatabase);
    a("forecast", "pop", "INTEGER", 55536, paramSQLiteDatabase);
    a("hourly", "pop", "INTEGER", 55536, paramSQLiteDatabase);
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS go_widget_binding_city_table (_id INTEGER PRIMARY KEY, go_widget_type INTEGER, go_widget_id TEXT, city_id TEXT)");
    SharedPreferences.Editor localEditor = this.b.getSharedPreferences("goweatherex_info", 0).edit();
    localEditor.putBoolean("24Hours", false);
    localEditor.putBoolean("future_weather", false);
    localEditor.putBoolean("menu", true);
    localEditor.putBoolean("cities", false);
    localEditor.putBoolean("theme", true);
    localEditor.putBoolean("setting", false);
    localEditor.putBoolean("feedback", false);
    localEditor.commit();
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS extreme(_id INTEGER PRIMARY KEY, cityId TEXT, publish_time TEXT, exp_time TEXT, type TEXT, description TEXT, phenomena TEXT, level INTEGER, message TEXT, alert_id INTEGER, tz_offset INTEGER, has_read INTEGER)");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('extreme_switch', '1')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value) select 'precipitation_switch' ,'1' union select 'wind_switch' ,'1' union select 'humidity_switch' ,'1' union select 'uv_switch' ,'1' union select 'dew_switch' ,'0' union select 'visibility_switch' ,'1' union select 'pressure_switch' ,'0' union select 'sunrise_switch' ,'1'");
  }
  
  private void q(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('weather_focecast_switch', '0')");
    a("citynow", "state", "", paramSQLiteDatabase);
    a("citynow", "country", "", paramSQLiteDatabase);
    a("extreme", "tz_offset", "INTEGER", 0, paramSQLiteDatabase);
    a("forecast", "status_day", "", paramSQLiteDatabase);
    a("forecast", "status_night", "", paramSQLiteDatabase);
    a("forecast", "date_long", "", paramSQLiteDatabase);
    paramSQLiteDatabase = this.b.getSharedPreferences("goweatherex_info", 0).edit();
    paramSQLiteDatabase.putBoolean("setting_forecast", true);
    paramSQLiteDatabase.putBoolean("menu", true);
    paramSQLiteDatabase.putBoolean("setting", true);
    paramSQLiteDatabase.commit();
  }
  
  private void r(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS recommended_apps(_id INTEGER PRIMARY KEY, pid INTEGER, is_all INTEGER, is_sale INTEGER, name TEXT, preview_id TEXT, preview_path TEXT, summary TEXT, version TEXT, version_num INTEGER, price TEXT, fee_type INTEGER, size TEXT, update_time TEXT, download INTEGER, ftp_url TEXT, app_market_url TEXT, web_market_url TEXT, go_boutique_url TEXT, other_url TEXT, theme_type INTEGER, packageName TEXT, iconId TEXT, iconSavedPath TEXT)");
  }
  
  private void s(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS msg_center (_id INTEGER PRIMARY KEY, msgId INTEGER, msgTitle TEXT, startTime TEXT, endTime TEXT, isMsgBar INTEGER, msgContent TEXT, isRead INTEGER, recTime TEXT, isDeleted INTEGER)");
  }
  
  private void t(SQLiteDatabase paramSQLiteDatabase)
  {
    u(paramSQLiteDatabase);
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('notification_sound', '0')");
    paramSQLiteDatabase = this.b.getSharedPreferences("goweatherex_info", 0).edit();
    paramSQLiteDatabase.putBoolean("setting", true);
    paramSQLiteDatabase.putBoolean("setting_notification_sound", true);
    paramSQLiteDatabase.commit();
  }
  
  private void u(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.query("setting", new String[] { "autoUpdate", "autpUpdateFreq", "tempUnit", "calendarType", "festival", "isCycle", "dateStyle", "notify", "notify_city", "notify_city_type", "notify_type", "windUnit", "world_clock", "widgt_clock", "widgt_calendar" }, null, null, null, null, null);
    int i25 = 1;
    int i32 = 1;
    int i = 1;
    int j = 3600000;
    int m = com.gau.go.launcherex.gowidget.weather.e.q.a;
    int n = com.gau.go.launcherex.gowidget.weather.e.c.e;
    int i1 = com.gau.go.launcherex.gowidget.weather.e.c.f;
    int i31 = 1;
    int i33 = 1;
    int i2 = 1;
    int i30 = 1;
    int i34 = 1;
    int i3 = 1;
    int i22 = 0;
    int i35 = 0;
    int i4 = 0;
    int i24 = 1;
    int i36 = 1;
    int i5 = 1;
    Object localObject1 = "";
    int i21 = 1;
    int i37 = 1;
    int i6 = 1;
    int k = com.gau.go.launcherex.gowidget.weather.e.q.b;
    int i23 = 1;
    int i38 = 1;
    int i7 = 1;
    Object localObject3 = "";
    Object localObject4 = "";
    Object localObject8;
    Object localObject10;
    int i20;
    Object localObject9;
    int i29;
    int i28;
    int i27;
    int i26;
    Object localObject5;
    Object localObject7;
    int i12;
    int i11;
    int i10;
    Object localObject6;
    int i13;
    int i8;
    int i19;
    int i18;
    int i17;
    int i16;
    int i15;
    int i14;
    int i9;
    if (localCursor != null)
    {
      localObject8 = localObject4;
      localObject10 = localObject3;
      i20 = k;
      localObject9 = localObject1;
      i29 = i1;
      i28 = n;
      i27 = m;
      i26 = j;
      localObject5 = localObject4;
      localObject7 = localObject3;
      i12 = i38;
      i11 = k;
      i10 = i37;
      localObject6 = localObject1;
      i13 = i36;
      i8 = i35;
      i19 = i34;
      i18 = i33;
      i17 = i1;
      i16 = n;
      i15 = m;
      i14 = j;
      i9 = i32;
    }
    for (;;)
    {
      try
      {
        if (localCursor.getCount() > 0)
        {
          localObject5 = localObject4;
          localObject7 = localObject3;
          i12 = i38;
          i11 = k;
          i10 = i37;
          localObject6 = localObject1;
          i13 = i36;
          i8 = i35;
          i19 = i34;
          i18 = i33;
          i17 = i1;
          i16 = n;
          i15 = m;
          i14 = j;
          i9 = i32;
          int i39 = localCursor.getColumnCount();
          localObject5 = localObject4;
          localObject7 = localObject3;
          i12 = i38;
          i11 = k;
          i10 = i37;
          localObject6 = localObject1;
          i13 = i36;
          i8 = i35;
          i19 = i34;
          i18 = i33;
          i17 = i1;
          i16 = n;
          i15 = m;
          i14 = j;
          i9 = i32;
          localCursor.moveToFirst();
          localObject5 = localObject4;
          localObject7 = localObject3;
          i12 = i38;
          i11 = k;
          i10 = i37;
          localObject6 = localObject1;
          i13 = i36;
          i8 = i35;
          i19 = i34;
          i18 = i33;
          i17 = i1;
          i16 = n;
          i15 = m;
          i14 = j;
          i9 = i32;
          String[] arrayOfString = localCursor.getColumnNames();
          i32 = 0;
          localObject8 = localObject4;
          localObject10 = localObject3;
          i23 = i7;
          i20 = k;
          i21 = i6;
          localObject9 = localObject1;
          i24 = i5;
          i22 = i4;
          i30 = i3;
          i31 = i2;
          i29 = i1;
          i28 = n;
          i27 = m;
          i26 = j;
          i25 = i;
          if (i32 < i39)
          {
            localObject5 = localObject4;
            localObject7 = localObject3;
            i12 = i7;
            i11 = k;
            i10 = i6;
            localObject6 = localObject1;
            i13 = i5;
            i8 = i4;
            i19 = i3;
            i18 = i2;
            i17 = i1;
            i16 = n;
            i15 = m;
            i14 = j;
            i9 = i;
            if (arrayOfString[i32].equals("autoUpdate"))
            {
              localObject5 = localObject4;
              localObject7 = localObject3;
              i12 = i7;
              i11 = k;
              i10 = i6;
              localObject6 = localObject1;
              i13 = i5;
              i8 = i4;
              i19 = i3;
              i18 = i2;
              i17 = i1;
              i16 = n;
              i15 = m;
              i14 = j;
              i9 = i;
              i31 = localCursor.getInt(i32);
              localObject8 = localObject4;
              localObject9 = localObject3;
              i20 = i7;
              i21 = k;
              i22 = i6;
              localObject10 = localObject1;
              i23 = i5;
              i24 = i4;
              i25 = i3;
              i26 = i2;
              i27 = i1;
              i28 = n;
              i29 = m;
              i30 = j;
              break label4106;
            }
            localObject5 = localObject4;
            localObject7 = localObject3;
            i12 = i7;
            i11 = k;
            i10 = i6;
            localObject6 = localObject1;
            i13 = i5;
            i8 = i4;
            i19 = i3;
            i18 = i2;
            i17 = i1;
            i16 = n;
            i15 = m;
            i14 = j;
            i9 = i;
            if (arrayOfString[i32].equals("autpUpdateFreq"))
            {
              localObject5 = localObject4;
              localObject7 = localObject3;
              i12 = i7;
              i11 = k;
              i10 = i6;
              localObject6 = localObject1;
              i13 = i5;
              i8 = i4;
              i19 = i3;
              i18 = i2;
              i17 = i1;
              i16 = n;
              i15 = m;
              i14 = j;
              i9 = i;
              i30 = localCursor.getInt(i32);
              localObject8 = localObject4;
              localObject9 = localObject3;
              i20 = i7;
              i21 = k;
              i22 = i6;
              localObject10 = localObject1;
              i23 = i5;
              i24 = i4;
              i25 = i3;
              i26 = i2;
              i27 = i1;
              i28 = n;
              i29 = m;
              i31 = i;
              break label4106;
            }
            localObject5 = localObject4;
            localObject7 = localObject3;
            i12 = i7;
            i11 = k;
            i10 = i6;
            localObject6 = localObject1;
            i13 = i5;
            i8 = i4;
            i19 = i3;
            i18 = i2;
            i17 = i1;
            i16 = n;
            i15 = m;
            i14 = j;
            i9 = i;
            if (arrayOfString[i32].equals("tempUnit"))
            {
              localObject5 = localObject4;
              localObject7 = localObject3;
              i12 = i7;
              i11 = k;
              i10 = i6;
              localObject6 = localObject1;
              i13 = i5;
              i8 = i4;
              i19 = i3;
              i18 = i2;
              i17 = i1;
              i16 = n;
              i15 = m;
              i14 = j;
              i9 = i;
              i29 = localCursor.getInt(i32);
              localObject8 = localObject4;
              localObject9 = localObject3;
              i20 = i7;
              i21 = k;
              i22 = i6;
              localObject10 = localObject1;
              i23 = i5;
              i24 = i4;
              i25 = i3;
              i26 = i2;
              i27 = i1;
              i28 = n;
              i30 = j;
              i31 = i;
              break label4106;
            }
            localObject5 = localObject4;
            localObject7 = localObject3;
            i12 = i7;
            i11 = k;
            i10 = i6;
            localObject6 = localObject1;
            i13 = i5;
            i8 = i4;
            i19 = i3;
            i18 = i2;
            i17 = i1;
            i16 = n;
            i15 = m;
            i14 = j;
            i9 = i;
            if (arrayOfString[i32].equals("calendarType"))
            {
              localObject5 = localObject4;
              localObject7 = localObject3;
              i12 = i7;
              i11 = k;
              i10 = i6;
              localObject6 = localObject1;
              i13 = i5;
              i8 = i4;
              i19 = i3;
              i18 = i2;
              i17 = i1;
              i16 = n;
              i15 = m;
              i14 = j;
              i9 = i;
              i28 = localCursor.getInt(i32);
              localObject8 = localObject4;
              localObject9 = localObject3;
              i20 = i7;
              i21 = k;
              i22 = i6;
              localObject10 = localObject1;
              i23 = i5;
              i24 = i4;
              i25 = i3;
              i26 = i2;
              i27 = i1;
              i29 = m;
              i30 = j;
              i31 = i;
              break label4106;
            }
            localObject5 = localObject4;
            localObject7 = localObject3;
            i12 = i7;
            i11 = k;
            i10 = i6;
            localObject6 = localObject1;
            i13 = i5;
            i8 = i4;
            i19 = i3;
            i18 = i2;
            i17 = i1;
            i16 = n;
            i15 = m;
            i14 = j;
            i9 = i;
            if (arrayOfString[i32].equals("festival"))
            {
              localObject5 = localObject4;
              localObject7 = localObject3;
              i12 = i7;
              i11 = k;
              i10 = i6;
              localObject6 = localObject1;
              i13 = i5;
              i8 = i4;
              i19 = i3;
              i18 = i2;
              i17 = i1;
              i16 = n;
              i15 = m;
              i14 = j;
              i9 = i;
              i27 = localCursor.getInt(i32);
              localObject8 = localObject4;
              localObject9 = localObject3;
              i20 = i7;
              i21 = k;
              i22 = i6;
              localObject10 = localObject1;
              i23 = i5;
              i24 = i4;
              i25 = i3;
              i26 = i2;
              i28 = n;
              i29 = m;
              i30 = j;
              i31 = i;
              break label4106;
            }
            localObject5 = localObject4;
            localObject7 = localObject3;
            i12 = i7;
            i11 = k;
            i10 = i6;
            localObject6 = localObject1;
            i13 = i5;
            i8 = i4;
            i19 = i3;
            i18 = i2;
            i17 = i1;
            i16 = n;
            i15 = m;
            i14 = j;
            i9 = i;
            if (arrayOfString[i32].equals("isCycle"))
            {
              localObject5 = localObject4;
              localObject7 = localObject3;
              i12 = i7;
              i11 = k;
              i10 = i6;
              localObject6 = localObject1;
              i13 = i5;
              i8 = i4;
              i19 = i3;
              i18 = i2;
              i17 = i1;
              i16 = n;
              i15 = m;
              i14 = j;
              i9 = i;
              i26 = localCursor.getInt(i32);
              localObject8 = localObject4;
              localObject9 = localObject3;
              i20 = i7;
              i21 = k;
              i22 = i6;
              localObject10 = localObject1;
              i23 = i5;
              i24 = i4;
              i25 = i3;
              i27 = i1;
              i28 = n;
              i29 = m;
              i30 = j;
              i31 = i;
              break label4106;
            }
            localObject5 = localObject4;
            localObject7 = localObject3;
            i12 = i7;
            i11 = k;
            i10 = i6;
            localObject6 = localObject1;
            i13 = i5;
            i8 = i4;
            i19 = i3;
            i18 = i2;
            i17 = i1;
            i16 = n;
            i15 = m;
            i14 = j;
            i9 = i;
            if (arrayOfString[i32].equals("dateStyle"))
            {
              localObject5 = localObject4;
              localObject7 = localObject3;
              i12 = i7;
              i11 = k;
              i10 = i6;
              localObject6 = localObject1;
              i13 = i5;
              i8 = i4;
              i19 = i3;
              i18 = i2;
              i17 = i1;
              i16 = n;
              i15 = m;
              i14 = j;
              i9 = i;
              i25 = localCursor.getInt(i32);
              localObject8 = localObject4;
              localObject9 = localObject3;
              i20 = i7;
              i21 = k;
              i22 = i6;
              localObject10 = localObject1;
              i23 = i5;
              i24 = i4;
              i26 = i2;
              i27 = i1;
              i28 = n;
              i29 = m;
              i30 = j;
              i31 = i;
              break label4106;
            }
            localObject5 = localObject4;
            localObject7 = localObject3;
            i12 = i7;
            i11 = k;
            i10 = i6;
            localObject6 = localObject1;
            i13 = i5;
            i8 = i4;
            i19 = i3;
            i18 = i2;
            i17 = i1;
            i16 = n;
            i15 = m;
            i14 = j;
            i9 = i;
            if (arrayOfString[i32].equals("notify"))
            {
              localObject5 = localObject4;
              localObject7 = localObject3;
              i12 = i7;
              i11 = k;
              i10 = i6;
              localObject6 = localObject1;
              i13 = i5;
              i8 = i4;
              i19 = i3;
              i18 = i2;
              i17 = i1;
              i16 = n;
              i15 = m;
              i14 = j;
              i9 = i;
              i24 = localCursor.getInt(i32);
              localObject8 = localObject4;
              localObject9 = localObject3;
              i20 = i7;
              i21 = k;
              i22 = i6;
              localObject10 = localObject1;
              i23 = i5;
              i25 = i3;
              i26 = i2;
              i27 = i1;
              i28 = n;
              i29 = m;
              i30 = j;
              i31 = i;
              break label4106;
            }
            localObject5 = localObject4;
            localObject7 = localObject3;
            i12 = i7;
            i11 = k;
            i10 = i6;
            localObject6 = localObject1;
            i13 = i5;
            i8 = i4;
            i19 = i3;
            i18 = i2;
            i17 = i1;
            i16 = n;
            i15 = m;
            i14 = j;
            i9 = i;
            if (arrayOfString[i32].equals("notify_type"))
            {
              localObject5 = localObject4;
              localObject7 = localObject3;
              i12 = i7;
              i11 = k;
              i10 = i6;
              localObject6 = localObject1;
              i13 = i5;
              i8 = i4;
              i19 = i3;
              i18 = i2;
              i17 = i1;
              i16 = n;
              i15 = m;
              i14 = j;
              i9 = i;
              i23 = localCursor.getInt(i32);
              localObject8 = localObject4;
              localObject9 = localObject3;
              i20 = i7;
              i21 = k;
              i22 = i6;
              localObject10 = localObject1;
              i24 = i4;
              i25 = i3;
              i26 = i2;
              i27 = i1;
              i28 = n;
              i29 = m;
              i30 = j;
              i31 = i;
              break label4106;
            }
            localObject5 = localObject4;
            localObject7 = localObject3;
            i12 = i7;
            i11 = k;
            i10 = i6;
            localObject6 = localObject1;
            i13 = i5;
            i8 = i4;
            i19 = i3;
            i18 = i2;
            i17 = i1;
            i16 = n;
            i15 = m;
            i14 = j;
            i9 = i;
            if (arrayOfString[i32].equals("notify_city"))
            {
              localObject5 = localObject4;
              localObject7 = localObject3;
              i12 = i7;
              i11 = k;
              i10 = i6;
              localObject6 = localObject1;
              i13 = i5;
              i8 = i4;
              i19 = i3;
              i18 = i2;
              i17 = i1;
              i16 = n;
              i15 = m;
              i14 = j;
              i9 = i;
              localObject10 = localCursor.getString(i32);
              localObject8 = localObject4;
              localObject9 = localObject3;
              i20 = i7;
              i21 = k;
              i22 = i6;
              i23 = i5;
              i24 = i4;
              i25 = i3;
              i26 = i2;
              i27 = i1;
              i28 = n;
              i29 = m;
              i30 = j;
              i31 = i;
              break label4106;
            }
            localObject5 = localObject4;
            localObject7 = localObject3;
            i12 = i7;
            i11 = k;
            i10 = i6;
            localObject6 = localObject1;
            i13 = i5;
            i8 = i4;
            i19 = i3;
            i18 = i2;
            i17 = i1;
            i16 = n;
            i15 = m;
            i14 = j;
            i9 = i;
            if (arrayOfString[i32].equals("notify_city_type"))
            {
              localObject5 = localObject4;
              localObject7 = localObject3;
              i12 = i7;
              i11 = k;
              i10 = i6;
              localObject6 = localObject1;
              i13 = i5;
              i8 = i4;
              i19 = i3;
              i18 = i2;
              i17 = i1;
              i16 = n;
              i15 = m;
              i14 = j;
              i9 = i;
              i22 = localCursor.getInt(i32);
              localObject8 = localObject4;
              localObject9 = localObject3;
              i20 = i7;
              i21 = k;
              localObject10 = localObject1;
              i23 = i5;
              i24 = i4;
              i25 = i3;
              i26 = i2;
              i27 = i1;
              i28 = n;
              i29 = m;
              i30 = j;
              i31 = i;
              break label4106;
            }
            localObject5 = localObject4;
            localObject7 = localObject3;
            i12 = i7;
            i11 = k;
            i10 = i6;
            localObject6 = localObject1;
            i13 = i5;
            i8 = i4;
            i19 = i3;
            i18 = i2;
            i17 = i1;
            i16 = n;
            i15 = m;
            i14 = j;
            i9 = i;
            if (arrayOfString[i32].equals("windUnit"))
            {
              localObject5 = localObject4;
              localObject7 = localObject3;
              i12 = i7;
              i11 = k;
              i10 = i6;
              localObject6 = localObject1;
              i13 = i5;
              i8 = i4;
              i19 = i3;
              i18 = i2;
              i17 = i1;
              i16 = n;
              i15 = m;
              i14 = j;
              i9 = i;
              i21 = localCursor.getInt(i32);
              localObject8 = localObject4;
              localObject9 = localObject3;
              i20 = i7;
              i22 = i6;
              localObject10 = localObject1;
              i23 = i5;
              i24 = i4;
              i25 = i3;
              i26 = i2;
              i27 = i1;
              i28 = n;
              i29 = m;
              i30 = j;
              i31 = i;
              break label4106;
            }
            localObject5 = localObject4;
            localObject7 = localObject3;
            i12 = i7;
            i11 = k;
            i10 = i6;
            localObject6 = localObject1;
            i13 = i5;
            i8 = i4;
            i19 = i3;
            i18 = i2;
            i17 = i1;
            i16 = n;
            i15 = m;
            i14 = j;
            i9 = i;
            if (arrayOfString[i32].equals("world_clock"))
            {
              localObject5 = localObject4;
              localObject7 = localObject3;
              i12 = i7;
              i11 = k;
              i10 = i6;
              localObject6 = localObject1;
              i13 = i5;
              i8 = i4;
              i19 = i3;
              i18 = i2;
              i17 = i1;
              i16 = n;
              i15 = m;
              i14 = j;
              i9 = i;
              i20 = localCursor.getInt(i32);
              localObject8 = localObject4;
              localObject9 = localObject3;
              i21 = k;
              i22 = i6;
              localObject10 = localObject1;
              i23 = i5;
              i24 = i4;
              i25 = i3;
              i26 = i2;
              i27 = i1;
              i28 = n;
              i29 = m;
              i30 = j;
              i31 = i;
              break label4106;
            }
            localObject5 = localObject4;
            localObject7 = localObject3;
            i12 = i7;
            i11 = k;
            i10 = i6;
            localObject6 = localObject1;
            i13 = i5;
            i8 = i4;
            i19 = i3;
            i18 = i2;
            i17 = i1;
            i16 = n;
            i15 = m;
            i14 = j;
            i9 = i;
            if (arrayOfString[i32].equals("widgt_clock"))
            {
              localObject5 = localObject4;
              localObject7 = localObject3;
              i12 = i7;
              i11 = k;
              i10 = i6;
              localObject6 = localObject1;
              i13 = i5;
              i8 = i4;
              i19 = i3;
              i18 = i2;
              i17 = i1;
              i16 = n;
              i15 = m;
              i14 = j;
              i9 = i;
              localObject9 = localCursor.getString(i32);
              localObject8 = localObject4;
              i20 = i7;
              i21 = k;
              i22 = i6;
              localObject10 = localObject1;
              i23 = i5;
              i24 = i4;
              i25 = i3;
              i26 = i2;
              i27 = i1;
              i28 = n;
              i29 = m;
              i30 = j;
              i31 = i;
              break label4106;
            }
            localObject5 = localObject4;
            localObject7 = localObject3;
            i12 = i7;
            i11 = k;
            i10 = i6;
            localObject6 = localObject1;
            i13 = i5;
            i8 = i4;
            i19 = i3;
            i18 = i2;
            i17 = i1;
            i16 = n;
            i15 = m;
            i14 = j;
            i9 = i;
            localObject8 = localObject4;
            localObject9 = localObject3;
            i20 = i7;
            i21 = k;
            i22 = i6;
            localObject10 = localObject1;
            i23 = i5;
            i24 = i4;
            i25 = i3;
            i26 = i2;
            i27 = i1;
            i28 = n;
            i29 = m;
            i30 = j;
            i31 = i;
            if (!arrayOfString[i32].equals("widgt_calendar")) {
              break label4106;
            }
            localObject5 = localObject4;
            localObject7 = localObject3;
            i12 = i7;
            i11 = k;
            i10 = i6;
            localObject6 = localObject1;
            i13 = i5;
            i8 = i4;
            i19 = i3;
            i18 = i2;
            i17 = i1;
            i16 = n;
            i15 = m;
            i14 = j;
            i9 = i;
            localObject8 = localCursor.getString(i32);
            localObject9 = localObject3;
            i20 = i7;
            i21 = k;
            i22 = i6;
            localObject10 = localObject1;
            i23 = i5;
            i24 = i4;
            i25 = i3;
            i26 = i2;
            i27 = i1;
            i28 = n;
            i29 = m;
            i30 = j;
            i31 = i;
            break label4106;
          }
        }
        localCursor.close();
        i2 = i30;
        i3 = i31;
        i4 = i29;
        i5 = i28;
        i6 = i27;
        i7 = i26;
        n = i24;
        localObject3 = localObject10;
        j = i23;
        k = i20;
        m = i21;
        localObject4 = localObject9;
        i = i25;
        i1 = i22;
        localObject1 = localObject8;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localCursor.close();
        i2 = i19;
        i3 = i18;
        i4 = i17;
        i5 = i16;
        i6 = i15;
        i7 = i14;
        n = i13;
        localObject3 = localObject7;
        j = i12;
        k = i11;
        m = i10;
        localObject4 = localObject6;
        i = i9;
        i1 = i8;
        localObject2 = localObject5;
        continue;
      }
      finally
      {
        localCursor.close();
      }
      a(paramSQLiteDatabase, "common_setting_table", "setting_key", "setting_value", "autoUpdate", i);
      a(paramSQLiteDatabase, "common_setting_table", "setting_key", "setting_value", "autpUpdateFreq", i7);
      a(paramSQLiteDatabase, "common_setting_table", "setting_key", "setting_value", "tempUnit", i6);
      a(paramSQLiteDatabase, "common_setting_table", "setting_key", "setting_value", "calendarType", i5);
      a(paramSQLiteDatabase, "common_setting_table", "setting_key", "setting_value", "festival", i4);
      a(paramSQLiteDatabase, "common_setting_table", "setting_key", "setting_value", "isCycle", i3);
      a(paramSQLiteDatabase, "common_setting_table", "setting_key", "setting_value", "dateStyle", i2);
      a(paramSQLiteDatabase, "common_setting_table", "setting_key", "setting_value", "notify", i1);
      a(paramSQLiteDatabase, "common_setting_table", "setting_key", "setting_value", "notify_city", (String)localObject4);
      a(paramSQLiteDatabase, "common_setting_table", "setting_key", "setting_value", "notify_city_type", m);
      a(paramSQLiteDatabase, "common_setting_table", "setting_key", "setting_value", "notify_type", n);
      a(paramSQLiteDatabase, "common_setting_table", "setting_key", "setting_value", "windUnit", k);
      a(paramSQLiteDatabase, "common_setting_table", "setting_key", "setting_value", "world_clock", j);
      a(paramSQLiteDatabase, "common_setting_table", "setting_key", "setting_value", "widgt_clock", (String)localObject3);
      a(paramSQLiteDatabase, "common_setting_table", "setting_key", "setting_value", "widgt_calendar", (String)localObject1);
      return;
      i2 = 1;
      i3 = 1;
      i4 = i1;
      i5 = n;
      i6 = m;
      i7 = 3600000;
      n = 1;
      localObject3 = "";
      j = 1;
      m = 1;
      localObject4 = "";
      i = 1;
      i1 = 0;
      Object localObject2 = "";
      continue;
      label4106:
      i32 += 1;
      localObject4 = localObject8;
      localObject3 = localObject9;
      i7 = i20;
      k = i21;
      i6 = i22;
      localObject2 = localObject10;
      i5 = i23;
      i4 = i24;
      i3 = i25;
      i2 = i26;
      i1 = i27;
      n = i28;
      m = i29;
      j = i30;
      i = i31;
    }
  }
  
  private void v(SQLiteDatabase paramSQLiteDatabase)
  {
    a("citynow", "nowTempValue", "REAL", 55536, paramSQLiteDatabase);
    a("citynow", "highTempValue", "REAL", 55536, paramSQLiteDatabase);
    a("citynow", "lowTempValue", "REAL", 55536, paramSQLiteDatabase);
    a("citynow", "feelslikeValue", "REAL", 55536, paramSQLiteDatabase);
    a("citynow", "windStrengthValue", "REAL", 55536, paramSQLiteDatabase);
    a("citynow", "humidityValue", "INTEGER", 55536, paramSQLiteDatabase);
    a("citynow", "barometerValue", "REAL", 55536, paramSQLiteDatabase);
    a("citynow", "uvIndexValue", "REAL", 55536, paramSQLiteDatabase);
    a("citynow", "dewpointValue", "REAL", 55536, paramSQLiteDatabase);
    a("citynow", "visibilityValue", "REAL", 55536, paramSQLiteDatabase);
    a("citynow", "timestamp", "INTEGER", 0, paramSQLiteDatabase);
    HashMap localHashMap = new HashMap();
    a(paramSQLiteDatabase, localHashMap);
    b(paramSQLiteDatabase, localHashMap);
    a("forecast", "lowTempValue", "REAL", 55536, paramSQLiteDatabase);
    a("forecast", "highTempValue", "REAL", 55536, paramSQLiteDatabase);
    a("forecast", "windStrengthValue", "REAL", 55536, paramSQLiteDatabase);
    c(paramSQLiteDatabase, localHashMap);
    a("hourly", "windStrengthValue", "REAL", 55536, paramSQLiteDatabase);
    a("hourly", "humidityValue", "INTEGER", 55536, paramSQLiteDatabase);
    a("hourly", "tempValue", "REAL", 55536, paramSQLiteDatabase);
    a("hourly", "date_long", "", paramSQLiteDatabase);
    d(paramSQLiteDatabase, localHashMap);
    c();
  }
  
  private void w(SQLiteDatabase paramSQLiteDatabase)
  {
    a("go_widget_binding_city_table", "go_widget_type", "INTEGER", -1, paramSQLiteDatabase);
    paramSQLiteDatabase = this.b.getSharedPreferences("goweatherex_info", 0).edit();
    paramSQLiteDatabase.putBoolean("is_cityid_sync", true);
    paramSQLiteDatabase.commit();
  }
  
  private void x(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value) select 'key_live_wallpaper_city_id' ,'--' union select 'key_live_wallpaper_city_flag' ,'-1' union select 'key_live_wallpaper_dynamic_effect_on' ,'0' union select 'key_live_wallpaper_show_weather_info_on' ,'1' union select 'key_live_wallpaper_weather_info_description_on' ,'1' union select 'key_live_wallpaper_weather_info_hight_low_temperature_on' ,'1' union select 'key_live_wallpaper_weather_info_wind_on' ,'1' union select 'key_live_wallpaper_weather_info_position' ,'1' union select 'key_live_wallpaper_weather_info_show_moment' ,'3' union select 'key_live_wallpaper_weather_info_font_size' ,'2' union select 'key_live_wallpaper_theme' ,'com.gau.go.launcherex.gowidget.weatherwidget'");
    y(paramSQLiteDatabase);
    paramSQLiteDatabase = this.b.getSharedPreferences("goweatherex_info", 0).edit();
    paramSQLiteDatabase.putBoolean("setting", true);
    paramSQLiteDatabase.putBoolean("is_cityid_sync", false);
    paramSQLiteDatabase.commit();
  }
  
  /* Error */
  private void y(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 365
    //   4: iconst_1
    //   5: anewarray 67	java/lang/String
    //   8: dup
    //   9: iconst_0
    //   10: ldc_w 363
    //   13: aastore
    //   14: ldc_w 423
    //   17: iconst_1
    //   18: anewarray 67	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: ldc_w 425
    //   26: aastore
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: invokevirtual 154	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +89 -> 124
    //   38: aload_2
    //   39: invokeinterface 163 1 0
    //   44: ifeq +80 -> 124
    //   47: aload_2
    //   48: iconst_0
    //   49: invokeinterface 235 2 0
    //   54: astore_3
    //   55: aload_3
    //   56: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifne +65 -> 124
    //   62: ldc_w 427
    //   65: aload_3
    //   66: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifne +55 -> 124
    //   72: aload_3
    //   73: aload_0
    //   74: getfield 19	com/gau/go/launcherex/gowidget/weather/provider/a:b	Landroid/content/Context;
    //   77: invokestatic 1418	com/gau/go/launcherex/gowidget/weather/globaltheme/a:c	(Ljava/lang/String;Landroid/content/Context;)Lcom/gau/go/launcherex/gowidget/weather/model/ThemeDataBean;
    //   80: ifnull +44 -> 124
    //   83: new 165	android/content/ContentValues
    //   86: dup
    //   87: invokespecial 166	android/content/ContentValues:<init>	()V
    //   90: astore 4
    //   92: aload 4
    //   94: ldc_w 363
    //   97: aload_3
    //   98: invokevirtual 270	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload_1
    //   102: ldc_w 365
    //   105: aload 4
    //   107: ldc_w 423
    //   110: iconst_1
    //   111: anewarray 67	java/lang/String
    //   114: dup
    //   115: iconst_0
    //   116: ldc_w 433
    //   119: aastore
    //   120: invokevirtual 202	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   123: pop
    //   124: aload_2
    //   125: ifnull +9 -> 134
    //   128: aload_2
    //   129: invokeinterface 213 1 0
    //   134: return
    //   135: astore_1
    //   136: aload_2
    //   137: ifnull +9 -> 146
    //   140: aload_2
    //   141: invokeinterface 213 1 0
    //   146: aload_1
    //   147: athrow
    //   148: astore_1
    //   149: aload_2
    //   150: ifnull -16 -> 134
    //   153: goto -25 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	a
    //   0	156	1	paramSQLiteDatabase	SQLiteDatabase
    //   33	117	2	localCursor	Cursor
    //   54	44	3	str	String
    //   90	16	4	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   38	124	135	finally
    //   38	124	148	java/lang/Exception
  }
  
  private void z(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('user_lang_code', 'default')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('user_lang_pkg', 'com.gau.go.launcherex.gowidget.weatherwidget')");
    paramSQLiteDatabase = this.b.getSharedPreferences("goweatherex_info", 0).edit();
    paramSQLiteDatabase.putString("key_new_language", "com.gau.go.weatherex.language.it#com.gau.go.weatherex.language.fr");
    paramSQLiteDatabase.putBoolean("weather_share", true);
    paramSQLiteDatabase.putBoolean("setting", true);
    paramSQLiteDatabase.putBoolean("setting_language", true);
    paramSQLiteDatabase.commit();
  }
  
  public int a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    int i = 0;
    try
    {
      SQLiteDatabase localSQLiteDatabase = h();
      if (localSQLiteDatabase != null) {
        i = localSQLiteDatabase.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      }
      return i;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return 0;
  }
  
  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    int i = 0;
    try
    {
      SQLiteDatabase localSQLiteDatabase = h();
      if (localSQLiteDatabase != null) {
        i = localSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
      }
      return i;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return 0;
  }
  
  public long a(String paramString, ContentValues paramContentValues)
  {
    long l = 0L;
    try
    {
      SQLiteDatabase localSQLiteDatabase = h();
      if (localSQLiteDatabase != null) {
        l = localSQLiteDatabase.insert(paramString, null, paramContentValues);
      }
      return l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.c.setTables(paramString1);
    for (;;)
    {
      try
      {
        paramString1 = h();
        if (paramString1 != null)
        {
          paramString1 = this.c.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
          return paramString1;
        }
      }
      catch (SQLException paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
      catch (IllegalStateException paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
      paramString1 = null;
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting (_id INTEGER PRIMARY KEY, autoUpdate INTEGER, autpUpdateFreq INTEGER, tempUnit INTEGER, calendarType INTEGER, festival INTEGER, auto_update_time_begin INTEGER, auto_update_time_end INTEGER, isCycle INTEGER, dateStyle INTEGER, notify INTEGER, notify_city TEXT, notify_type INTEGER, manual_refresh INTEGER, windUnit INTEGER,notify_city_type INTEGER, world_clock INTEGER, widgt_clock TEXT, widgt_calendar TEXT)");
    paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.q.c);
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS citynow (_id INTEGER PRIMARY KEY, cityId TEXT, oldCityId TEXT, cityName TEXT, cityType INTEGER, updateTime INTEGER, nowTemp TEXT, highTemp TEXT, lowTemp TEXT, humidity TEXT, type INTEGER, nowDesp TEXT, windType INTEGER, windDirection TEXT, windStrength TEXT, windStrengthInt INTEGER, visibility TEXT, barometer TEXT, dewpoint TEXT, uvIndex TEXT, sunrise TEXT, sunset TEXT, sequence INTEGER, myLocation INTEGER, city_my_location INTEGER, language INTEGER, wind INTEGER, tz_offset INTEGER, pop INTEGER, rainFall REAL, feels_like INTEGER, state TEXT, country TEXT, nowTempValue REAL, highTempValue REAL, lowTempValue REAL, humidityValue INTEGER, windStrengthValue REAL, visibilityValue REAL, barometerValue REAL, dewpointValue REAL, uvIndexValue REAL, feelslikeValue REAL, timestamp INTEGER, aqi INTEGER, qualityType INTEGER, pm25 INTEGER, pm10 INTEGER, so2 INTEGER, no2 INTEGER, latitude TEXT, longitude TEXT, hasRadar INTEGER, hasSatellite INTEGER, northeast TEXT, southwest TEXT, cityJsonString TEXT)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS forecast(_id INTEGER PRIMARY KEY, weekDate TEXT, lowTemp TEXT, highTemp TEXT, type INTEGER, status TEXT, cityId TEXT, date TEXT, windType INTEGER, windDir TEXT, windStrength TEXT, windStrengthInt INTEGER,dayId INTEGER, pop INTEGER, status_day TEXT, status_night TEXT, date_long TEXT, lowTempValue REAL, highTempValue REAL, windStrengthValue REAL)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS weather11_city (_id INTEGER PRIMARY KEY, widgetId INTEGER, cityId TEXT, my_location INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hourly(_id INTEGER PRIMARY KEY, date TEXT, hour INTEGER, temp TEXT, type INTEGER, cityId TEXT, windType INTEGER, windDirection TEXT, windStrength TEXT, windStrengthInt INTEGER, status TEXT, humidity TEXT, pop INTEGER, date_long TEXT, tempValue REAL, windStrengthValue REAL, humidityValue INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS alarm (_id INTEGER PRIMARY KEY, cityId TEXT, alarmInfo TEXT)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS extreme(_id INTEGER PRIMARY KEY, cityId TEXT, publish_time TEXT, exp_time TEXT, type TEXT, description TEXT, phenomena TEXT, level INTEGER, message TEXT, alert_id INTEGER, tz_offset INTEGER, has_read INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS featured_theme_table (_id INTEGER PRIMARY KEY, appid INTEGER, new_theme INTEGER, type_id INTEGER, packname TEXT, name TEXT, version TEXT, version_code INTEGER, download_type INTEGER, download_url TEXT, detail_type INTEGER, detail_url TEXT, pay_type INTEGER, pay_id TEXT, pic_url TEXT, pics_url TEXT, pic_path TEXT, pics_path TEXT, featured_type INTEGER, theme_type INTEGER, synchro_time REAL, mark TEXT, pkgalias TEXT, ficon_url TEXT, issupport_coupons INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS featured_theme_tab_table (_id INTEGER PRIMARY KEY, type_id INTEGER, sequence INTEGER, type_name TEXT, mark TEXT)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS coupon_table (_id INTEGER PRIMARY KEY, coupon_id TEXT, coupon_value INTEGER, consumed INTEGER, consumed_time REAL, effective_time REAL, expired_time REAL)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS promo_table (_id INTEGER PRIMARY KEY, promo_code TEXT, effective_time REAL, expired_time REAL)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS common_setting_table (_id INTEGER PRIMARY KEY, setting_key TEXT, setting_value TEXT)");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('app_widget_theme', 'app_widget_theme_white')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('appwidget42_city', '')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('appwidget41_city', '')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('appwidget21_city', '')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('appwidget_days_41_city', '')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('appwidget_days_42_city', '')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('auto_location', '0')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('boot_refresh', '1')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('launch_refresh', '1')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value) select 'precipitation_switch' ,'1' union select 'wind_switch' ,'1' union select 'humidity_switch' ,'1' union select 'uv_switch' ,'0' union select 'dew_switch' ,'0' union select 'visibility_switch' ,'0' union select 'pressure_switch' ,'0' union select 'sunrise_switch' ,'1'");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('extreme_switch', '1')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('weather_focecast_switch', '0')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('weather_warning_switch', '1')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('no_alerts_cities', '')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value) select 'key_live_wallpaper_city_id' ,'--' union select 'key_live_wallpaper_city_flag' ,'-1' union select 'key_live_wallpaper_dynamic_effect_on' ,'0' union select 'key_live_wallpaper_show_weather_info_on' ,'1' union select 'key_live_wallpaper_weather_info_description_on' ,'1' union select 'key_live_wallpaper_weather_info_hight_low_temperature_on' ,'1' union select 'key_live_wallpaper_weather_info_wind_on' ,'1' union select 'key_live_wallpaper_weather_info_position' ,'1' union select 'key_live_wallpaper_weather_info_show_moment' ,'3' union select 'key_live_wallpaper_weather_info_font_size' ,'2' union select 'key_live_wallpaper_theme' ,'com.gau.go.launcherex.gowidget.weatherwidget'");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('notification_style', 'notification_style_default')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('weather_assistant_switch', 1)");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('go_widget_theme', '' )");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('appwidget_world_clock_42_city_one', '')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('appwidget_world_clock_42_city_two', '')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('dynamic_icon_gowidget', 1)");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('widget_theme_switcher', 1)");
    a(paramSQLiteDatabase);
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS app_widget_theme_table (_id INTEGER PRIMARY KEY, theme_type INTEGER, theme_id INTEGER, is_all INTEGER, is_sale INTEGER, preview_id TEXT, preview_path TEXT, summary TEXT, version TEXT, version_num INTEGER, package_name TEXT, fee_type INTEGER, price TEXT, size TEXT, update_time TEXT, download TEXT, ftp_url TEXT, app_market_url TEXT, web_market_url TEXT, go_boutique_url TEXT, other_url TEXT, name TEXT)");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('app_widget_theme_data_timestamp', '0')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('go_widget_theme_data_timestamp', '0')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('app_theme_data_timestamp', '0')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('plugin_camera_data_timestamp', '0')");
    paramSQLiteDatabase.execSQL("INSERT INTO common_setting_table (setting_key, setting_value)values('app_theme', 'com.gau.go.launcherex.gowidget.weatherwidget' )");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS gowidget_theme_table (_id INTEGER PRIMARY KEY, widget_id INTEGER, widget_theme TEXT)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS go_widget_binding_city_table (_id INTEGER PRIMARY KEY, go_widget_type INTEGER, go_widget_id TEXT, city_id TEXT)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS recommended_apps(_id INTEGER PRIMARY KEY, pid INTEGER, is_all INTEGER, is_sale INTEGER, name TEXT, preview_id TEXT, preview_path TEXT, summary TEXT, version TEXT, version_num INTEGER, price TEXT, fee_type INTEGER, size TEXT, update_time TEXT, download INTEGER, ftp_url TEXT, app_market_url TEXT, web_market_url TEXT, go_boutique_url TEXT, other_url TEXT, theme_type INTEGER, packageName TEXT, iconId TEXT, iconSavedPath TEXT)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS msg_center (_id INTEGER PRIMARY KEY, msgId INTEGER, msgTitle TEXT, startTime TEXT, endTime TEXT, isMsgBar INTEGER, msgContent TEXT, isRead INTEGER, recTime TEXT, isDeleted INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS messagecenter (mesageid text, title text, readed numeric, viewtype numeric, type text, date text, url text, stime_start text,stime_end text,icon text,intro text,acttype numeric,actvalue text,zicon1 text,zicon2 text,zpos numeric,ztime numeric,isclosed numeric,filter_pkgs text,clickclosed numeric,dynamic numeric,iconpos numeric,fullscreenicon text,removed numeric, packagename text, mapid text, whitelist text, isdeleted numeric,PRIMARY KEY (mesageid))");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS [ad_info_table] ([_id] INTEGER PRIMARY KEY, [ad_id] INTEGER, [ad_interval] INTEGER, [ad_overcount] INTEGER, [ad_img] TEXT, [ad_monitor] TEXT, [ad_weather] INTEGER, [ad_text] TEXT, [ad_url] TEXT, [pcount] INTEGER, [purl] TEXT, [timestamp] TEXT )");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS next_widget_binding_city_table (_id INTEGER PRIMARY KEY, go_widget_type INTEGER, go_widget_id TEXT, city_id TEXT)");
    paramSQLiteDatabase.execSQL(s.a);
    paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.r.a);
    paramSQLiteDatabase.execSQL(l.a);
    paramSQLiteDatabase.execSQL(m.a);
    paramSQLiteDatabase.execSQL(k.a);
    paramSQLiteDatabase.execSQL(j.a);
    paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.a.a);
    paramSQLiteDatabase.execSQL(p.a);
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS pollenIndex (_id INTEGER PRIMARY KEY, cityId TEXT,date_time INTEGER, pollen_index REAL)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS pollensource (_id INTEGER PRIMARY KEY, cityId TEXT,date_time INTEGER, name TEXT,type INTEGER,url TEXT)");
    paramSQLiteDatabase.execSQL(e.a);
    paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.d.a);
    e();
    paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.c.a(String.valueOf(0)));
    paramSQLiteDatabase.execSQL(com.gau.go.launcherex.gowidget.weather.e.c.a("no_notify_temp_change_cities", ""));
    paramSQLiteDatabase = this.b.getSharedPreferences("goweatherex_info", 0).edit();
    paramSQLiteDatabase.putBoolean("24Hours", false);
    paramSQLiteDatabase.putBoolean("future_weather", false);
    paramSQLiteDatabase.putBoolean("menu", false);
    paramSQLiteDatabase.putBoolean("cities", false);
    paramSQLiteDatabase.putBoolean("theme", false);
    paramSQLiteDatabase.putBoolean("setting", false);
    paramSQLiteDatabase.putBoolean("feedback", false);
    paramSQLiteDatabase.putBoolean("weather_share", false);
    paramSQLiteDatabase.putBoolean("is_cityid_sync", true);
    paramSQLiteDatabase.putInt("key_new_feature_live_wallpaper", 0);
    paramSQLiteDatabase.putBoolean("new_theme", false);
    paramSQLiteDatabase.putLong("key_first_install_time", System.currentTimeMillis() + 86400000L);
    paramSQLiteDatabase.putBoolean("key_open_dialog_boolean", false);
    paramSQLiteDatabase.putBoolean("key_is_new_user", true);
    a(paramSQLiteDatabase);
    paramSQLiteDatabase.putInt("key_ab_test_user", new Random().nextInt(2));
    paramSQLiteDatabase.putLong("key_ab_test_install_time", System.currentTimeMillis());
    paramSQLiteDatabase.commit();
    paramSQLiteDatabase = this.b.getSharedPreferences("goweatherex_world_info", 2).edit();
    paramSQLiteDatabase.putBoolean("key_systemwidget_isfirst_open_theme", true);
    paramSQLiteDatabase.putBoolean("key_gowidget_isfirst_open_theme", true);
    paramSQLiteDatabase.commit();
    com.gau.go.launcherex.gowidget.weather.util.r.a(new File(Environment.getExternalStorageDirectory(), "/GOWeatherEX/download/maps"));
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1)
    {
      SharedPreferences.Editor localEditor = this.b.getSharedPreferences("goweatherex_info", 0).edit();
      localEditor.putInt("key_last_versioncode", paramInt1);
      localEditor.putBoolean("key_is_new_user", false);
      localEditor.commit();
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      a();
    case 2: 
      b();
    case 3: 
      b(paramSQLiteDatabase);
    case 4: 
      d(paramSQLiteDatabase);
    case 5: 
      f(paramSQLiteDatabase);
    case 6: 
      g(paramSQLiteDatabase);
    case 7: 
      j(paramSQLiteDatabase);
    case 8: 
      m(paramSQLiteDatabase);
    case 9: 
      n(paramSQLiteDatabase);
    case 10: 
      o(paramSQLiteDatabase);
    case 11: 
      p(paramSQLiteDatabase);
    case 12: 
      q(paramSQLiteDatabase);
    case 13: 
      r(paramSQLiteDatabase);
    case 14: 
      s(paramSQLiteDatabase);
    case 15: 
      t(paramSQLiteDatabase);
    case 16: 
      v(paramSQLiteDatabase);
    case 17: 
      w(paramSQLiteDatabase);
    case 18: 
      x(paramSQLiteDatabase);
    case 19: 
      z(paramSQLiteDatabase);
    case 20: 
      A(paramSQLiteDatabase);
    case 21: 
      B(paramSQLiteDatabase);
    case 22: 
      C(paramSQLiteDatabase);
    case 23: 
      F(paramSQLiteDatabase);
    case 24: 
      G(paramSQLiteDatabase);
    case 25: 
      H(paramSQLiteDatabase);
    case 26: 
      I(paramSQLiteDatabase);
    case 27: 
      J(paramSQLiteDatabase);
    case 28: 
      K(paramSQLiteDatabase);
    case 29: 
      L(paramSQLiteDatabase);
    case 30: 
      M(paramSQLiteDatabase);
    case 31: 
      N(paramSQLiteDatabase);
    case 32: 
      O(paramSQLiteDatabase);
    case 33: 
      P(paramSQLiteDatabase);
    case 34: 
      Q(paramSQLiteDatabase);
    case 35: 
      S(paramSQLiteDatabase);
    case 36: 
      T(paramSQLiteDatabase);
    case 37: 
      U(paramSQLiteDatabase);
    case 38: 
      V(paramSQLiteDatabase);
    case 39: 
      W(paramSQLiteDatabase);
    case 40: 
      X(paramSQLiteDatabase);
    case 41: 
      d();
    case 42: 
      Y(paramSQLiteDatabase);
    case 43: 
      Z(paramSQLiteDatabase);
    case 44: 
      ab(paramSQLiteDatabase);
    case 45: 
      ac(paramSQLiteDatabase);
    case 46: 
      ad(paramSQLiteDatabase);
    case 47: 
      ae(paramSQLiteDatabase);
    case 48: 
      af(paramSQLiteDatabase);
    case 49: 
      g();
    case 50: 
      ag(paramSQLiteDatabase);
    case 51: 
      ah(paramSQLiteDatabase);
    case 52: 
      ai(paramSQLiteDatabase);
    case 53: 
      aj(paramSQLiteDatabase);
    }
    ak(paramSQLiteDatabase);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/provider/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */