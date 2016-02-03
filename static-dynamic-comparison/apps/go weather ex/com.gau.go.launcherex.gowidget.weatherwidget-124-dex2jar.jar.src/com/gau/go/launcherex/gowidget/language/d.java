package com.gau.go.launcherex.gowidget.language;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.jiubang.core.b.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

public class d
{
  private static d m;
  BroadcastReceiver a = null;
  NotificationManager b = null;
  Notification c = null;
  private b d = null;
  private String e = null;
  private String f = null;
  private String g = null;
  private Locale h;
  private String i;
  private boolean j;
  private g k;
  private Context l;
  private boolean n;
  private f o;
  
  private d(Context paramContext)
  {
    this.l = paramContext;
    this.o = new f(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_SETTING_USER_LANGUAGE");
    this.l.registerReceiver(this.o, localIntentFilter);
    this.k = new g(this, paramContext.getContentResolver());
    this.d = new b(this.l.getResources());
    this.n = false;
    a(false);
    a(this.l.getContentResolver().query(WeatherContentProvider.g, new String[] { "setting_key", "setting_value" }, "setting_key in ('user_lang_code', 'user_lang_pkg')", null, null));
    o();
  }
  
  public static d a(Context paramContext)
  {
    for (;;)
    {
      Context localContext;
      try
      {
        if (m == null)
        {
          localContext = paramContext.getApplicationContext();
          if (localContext == null) {
            m = new d(paramContext);
          }
        }
        else
        {
          paramContext = m;
          return paramContext;
        }
      }
      finally {}
      paramContext = localContext;
    }
  }
  
  private void a(Cursor paramCursor)
  {
    this.i = "default";
    this.e = "com.gau.go.launcherex.gowidget.weatherwidget";
    this.f = Locale.getDefault().getLanguage();
    this.g = Locale.getDefault().getCountry();
    if (paramCursor != null) {}
    for (;;)
    {
      try
      {
        if (paramCursor.getCount() <= 0) {
          continue;
        }
        int i1 = paramCursor.getColumnIndex("setting_key");
        i2 = paramCursor.getColumnIndex("setting_value");
        paramCursor.moveToFirst();
        str = paramCursor.getString(i1);
        if (!str.equals("user_lang_pkg")) {
          continue;
        }
        this.e = paramCursor.getString(i2);
      }
      catch (Exception localException)
      {
        int i2;
        String str;
        boolean bool;
        localException.printStackTrace();
        return;
        String[] arrayOfString = this.i.split("_");
        this.f = arrayOfString[0];
        this.g = arrayOfString[1];
        continue;
      }
      finally
      {
        paramCursor.close();
      }
      bool = paramCursor.moveToNext();
      if (!bool)
      {
        paramCursor.close();
        return;
        if (str.equals("user_lang_code"))
        {
          this.i = paramCursor.getString(i2);
          switch (this.i.length())
          {
          case 2: 
            this.f = this.i;
            n();
          }
        }
      }
    }
  }
  
  private void a(q paramq)
  {
    TypedArray localTypedArray = this.l.obtainStyledAttributes(16973928, new int[] { 16842904 });
    int i1 = localTypedArray.getColor(0, 0);
    localTypedArray.recycle();
    if ((0xFFFFFF & i1) < 8388607) {}
    for (paramq.C = "notification_style_default_white";; paramq.C = "notification_style_default_black")
    {
      e.a(this.l).a("notification_style", paramq.C);
      return;
    }
  }
  
  private void a(String paramString)
  {
    r();
    this.b = ((NotificationManager)this.l.getSystemService("notification"));
    this.c = new Notification();
    Object localObject = new Intent("action_touch_language_check_update_notification");
    localObject = PendingIntent.getBroadcast(this.l, 1, (Intent)localObject, 134217728);
    this.c.contentIntent = ((PendingIntent)localObject);
    localObject = new Intent("action_delete_language_check_update_notification");
    localObject = PendingIntent.getBroadcast(this.l, 2, (Intent)localObject, 134217728);
    this.c.deleteIntent = ((PendingIntent)localObject);
    this.c.icon = 2130838227;
    this.c.tickerText = paramString;
    localObject = new RemoteViews(this.l.getPackageName(), 2130903247);
    ((RemoteViews)localObject).setImageViewResource(2131231779, 2130838227);
    q localq = c.a(this.l).f().a();
    if (localq.C.equals("notification_style_default")) {
      a(localq);
    }
    int i1 = 17170443;
    Resources localResources = this.l.getResources();
    if (localq.C.equals("notification_style_default_black")) {
      i1 = localResources.getColor(2131361859);
    }
    for (;;)
    {
      ((RemoteViews)localObject).setTextColor(2131231784, i1);
      ((RemoteViews)localObject).setTextColor(2131231783, i1);
      ((RemoteViews)localObject).setTextViewText(2131231784, this.d.getString(2131165549));
      ((RemoteViews)localObject).setTextViewText(2131231783, paramString);
      this.c.contentView = ((RemoteViews)localObject);
      this.b.notify("notification_tag_language_check_update", 5, this.c);
      localObject = new Time();
      ((Time)localObject).setToNow();
      try
      {
        paramString = GoWidgetApplication.c(this.l.getApplicationContext()).a();
        if (paramString != null) {
          paramString.edit().putLong("key_language_check_update_time", ((Time)localObject).toMillis(true)).commit();
        }
        return;
        if (!localq.C.equals("notification_style_default_white")) {
          continue;
        }
        i1 = localResources.getColor(2131361862);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = null;
        }
      }
    }
  }
  
  public static void a(ArrayList paramArrayList, Context paramContext)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      com.gau.go.launcherex.gowidget.weather.model.h localh = (com.gau.go.launcherex.gowidget.weather.model.h)paramArrayList.next();
      String str = localh.d();
      if ((TextUtils.isEmpty(str)) || (str.equals("com.gau.go.launcherex.gowidget.weatherwidget"))) {
        localh.a = true;
      } else {
        localh.a = y.a(paramContext, str);
      }
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("setting_value", paramString2);
    paramString2 = new ArrayList();
    paramString2.add(ContentProviderOperation.newUpdate(WeatherContentProvider.g).withValues(localContentValues).withSelection("setting_key='user_lang_pkg'", null).build());
    localContentValues.put("setting_value", paramString1);
    paramString2.add(ContentProviderOperation.newUpdate(WeatherContentProvider.g).withValues(localContentValues).withSelection("setting_key='user_lang_code'", null).build());
    this.k.a(2, null, "com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", paramString2);
  }
  
  public static void b(ArrayList paramArrayList, Context paramContext)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      com.gau.go.launcherex.gowidget.weather.model.h localh = (com.gau.go.launcherex.gowidget.weather.model.h)paramArrayList.next();
      if (localh.d().equals("")) {
        localh.b = false;
      } else if (localh.a) {
        localh.b = y.a(paramContext, localh.d(), localh.c());
      } else {
        localh.b = false;
      }
    }
  }
  
  public static void c(ArrayList paramArrayList, Context paramContext)
  {
    a(paramArrayList, paramContext);
    b(paramArrayList, paramContext);
  }
  
  public static void f()
  {
    try
    {
      if (m != null)
      {
        m.q();
        m = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private boolean l()
  {
    boolean bool2 = true;
    try
    {
      SharedPreferences localSharedPreferences = GoWidgetApplication.c(this.l.getApplicationContext()).a();
      boolean bool1 = bool2;
      if (localSharedPreferences != null)
      {
        Time localTime = new Time();
        localTime.setToNow();
        bool1 = bool2;
        if (localTime.toMillis(true) - localSharedPreferences.getLong("key_language_check_update_time", 0L) > 604800000L) {
          bool1 = false;
        }
      }
      return bool1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  private void m()
  {
    if (this.b != null) {
      this.b.cancel("notification_tag_language_check_update", 5);
    }
  }
  
  private void n()
  {
    if ((this.f.equals("zh")) && (this.g.equals("CN"))) {
      this.g = "PRC";
    }
    while ((!this.f.equals("pt")) || (!this.g.equals("BR"))) {
      return;
    }
    this.g = "DEF_BR";
  }
  
  private void o()
  {
    this.d.a(null, null);
    this.j = false;
    Object localObject2;
    Object localObject1;
    if ((TextUtils.isEmpty(this.i)) || (this.i.equals("default")))
    {
      HashMap localHashMap = h();
      localObject2 = (String)localHashMap.get(d());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (String)localHashMap.get(b());
      }
      if (localObject1 != null) {
        this.e = ((String)localObject1);
      }
    }
    else
    {
      if ((!TextUtils.isEmpty(this.e)) && (!this.e.equals("com.gau.go.launcherex.gowidget.weatherwidget")) && (!y.a(this.l, this.e))) {
        break label223;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = this.l.createPackageContext(this.e, 3).getResources();
        if (localObject1 == null) {}
        this.d.a(this.e, (Resources)localObject1);
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        localNameNotFoundException.printStackTrace();
        continue;
      }
      this.h = new Locale(this.f, this.g);
      localObject1 = this.d.getConfiguration();
      localObject2 = this.d.getDisplayMetrics();
      ((Configuration)localObject1).locale = this.h;
      ((Configuration)localObject1).orientation = 1;
      this.d.updateConfiguration((Configuration)localObject1, (DisplayMetrics)localObject2);
      return;
      this.e = "com.gau.go.launcherex.gowidget.weatherwidget";
      break;
      label223:
      this.n = true;
      if (!this.i.equals("default")) {
        a("default", "com.gau.go.launcherex.gowidget.weatherwidget");
      }
      this.j = true;
    }
  }
  
  private void p()
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USER_LANGUAGE_CHANGED");
    this.l.sendBroadcast(localIntent);
  }
  
  private void q()
  {
    if (this.d != null)
    {
      this.d.a();
      this.d = null;
    }
    if ((this.o != null) && (this.l != null)) {
      this.l.unregisterReceiver(this.o);
    }
  }
  
  private void r()
  {
    if (this.a == null)
    {
      IntentFilter localIntentFilter = new IntentFilter("action_touch_language_check_update_notification");
      this.a = new h(this);
      this.l.registerReceiver(this.a, localIntentFilter);
    }
  }
  
  private void s()
  {
    if (this.a != null)
    {
      this.l.unregisterReceiver(this.a);
      this.a = null;
    }
  }
  
  public b a()
  {
    return this.d;
  }
  
  public void a(TextView paramTextView, AttributeSet paramAttributeSet)
  {
    if (this.d != null)
    {
      int i1 = paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "text", 0);
      if (i1 > 0) {
        paramTextView.setText(i1);
      }
      i1 = paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "hint", 0);
      if (i1 > 0) {
        paramTextView.setHint(i1);
      }
    }
  }
  
  public void a(i parami)
  {
    this.k.a(0, parami, WeatherContentProvider.g, new String[] { "setting_key", "setting_value" }, "setting_key in ('user_lang_code', 'user_lang_pkg')", null, null);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.e = paramString2;
    this.i = paramString1;
    i();
    if ("com.gau.go.launcherex.gowidget.weatherwidget".equals(GoWidgetApplication.a(this.l)))
    {
      b(paramString1, paramString2);
      k();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public String b()
  {
    return this.f;
  }
  
  public String c()
  {
    return this.i;
  }
  
  public String d()
  {
    return this.f + "_" + this.g;
  }
  
  public String e()
  {
    return this.g;
  }
  
  public ArrayList g()
  {
    String[] arrayOfString = this.l.getResources().getStringArray(2131558445);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < arrayOfString.length)
    {
      localArrayList.add(new com.gau.go.launcherex.gowidget.weather.model.h(arrayOfString[i1]));
      i1 += 1;
    }
    c(localArrayList, this.l);
    return localArrayList;
  }
  
  public HashMap h()
  {
    String[] arrayOfString = this.l.getResources().getStringArray(2131558445);
    HashMap localHashMap = new HashMap();
    int i1 = 0;
    while (i1 < arrayOfString.length)
    {
      com.gau.go.launcherex.gowidget.weather.model.h localh = new com.gau.go.launcherex.gowidget.weather.model.h(arrayOfString[i1]);
      if (!localh.b().equals("")) {
        localHashMap.put(localh.b(), localh.d());
      }
      i1 += 1;
    }
    return localHashMap;
  }
  
  public void i()
  {
    for (;;)
    {
      try
      {
        this.f = Locale.getDefault().getLanguage();
        this.g = Locale.getDefault().getCountry();
        switch (this.i.length())
        {
        case 3: 
        case 4: 
          o();
          return;
        }
      }
      finally {}
      this.f = this.i;
      n();
      continue;
      String[] arrayOfString = this.i.split("_");
      this.f = arrayOfString[0];
      this.g = arrayOfString[1];
    }
  }
  
  public void j()
  {
    if ((!l()) && (this.n)) {
      a(this.d.getString(2131165548));
    }
  }
  
  public void k()
  {
    a locala = GoWidgetApplication.c(this.l.getApplicationContext());
    Object localObject = null;
    if (locala != null) {
      localObject = locala.a();
    }
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("key_synchro_featured_theme_data_time", 0L);
      ((SharedPreferences.Editor)localObject).putLong("last_check_new_theme_time", 0L);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/language/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */