package com.gau.go.launcherex.gowidget.weather.globaltheme;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.language.b;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.n;
import com.gtp.go.weather.sharephoto.d.h;
import com.gtp.go.weather.sharephoto.x;
import com.jiubang.core.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

public class d
{
  private com.gau.go.launcherex.gowidget.weather.globaltheme.c.c a;
  private Context b;
  private com.gau.go.launcherex.gowidget.language.d c;
  private g d = null;
  private int e;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  
  public d(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context can't be null");
    }
    this.b = paramContext;
    this.d = new g(paramContext.getContentResolver(), this);
    this.c = com.gau.go.launcherex.gowidget.language.d.a(this.b);
    this.e = 0;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    String str = null;
    paramContext = paramContext.getContentResolver();
    switch (paramInt)
    {
    default: 
      paramContext = str;
      if (paramContext == null) {
        break label176;
      }
      if (!paramContext.moveToFirst()) {
        break;
      }
    }
    for (str = paramContext.getString(paramContext.getColumnIndex("setting_value"));; str = "")
    {
      paramContext.close();
      return str;
      paramContext = paramContext.query(WeatherContentProvider.g, new String[] { "setting_value" }, "setting_key=?", new String[] { "app_theme" }, null);
      break;
      paramContext = paramContext.query(WeatherContentProvider.g, new String[] { "setting_value" }, "setting_key=?", new String[] { "app_widget_theme" }, null);
      break;
      paramContext = paramContext.query(WeatherContentProvider.g, new String[] { "setting_value" }, "setting_key=?", new String[] { "go_widget_theme" }, null);
      break;
    }
    label176:
    return "";
  }
  
  private void a(e parame)
  {
    Intent localIntent;
    if (parame.D())
    {
      localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_THEME_CHANGE");
      localIntent.putExtra("extra_app_widget_theme_package", parame.x());
      this.b.sendBroadcast(localIntent);
    }
    if (parame.C())
    {
      localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GOWIDGET_THEME_CHANGE");
      localIntent.putExtra("extra_gowidget_theme_package", parame.x());
      this.b.sendBroadcast(localIntent);
    }
    if (parame.s())
    {
      localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APP_THEME_CHANGE");
      localIntent.putExtra("extra_app_theme_package", parame.x());
      this.b.sendBroadcast(localIntent);
    }
    if (parame.t())
    {
      localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LIVE_WALLPAPER_THEME_CHANGE");
      localIntent.putExtra("extra_wallpaper_theme_package", parame.x());
      this.b.sendBroadcast(localIntent);
    }
  }
  
  private void a(com.gau.go.launcherex.gowidget.weather.globaltheme.b.g paramg)
  {
    if (this.a != null) {
      this.a.a(paramg);
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    Object localObject = GoWidgetApplication.c(this.b.getApplicationContext()).a().getString("key_receive_apk_award_packagenames", "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject = new JSONArray((String)localObject);
        if ((localObject == null) || (((JSONArray)localObject).length() < 1)) {
          break;
        }
        int j = ((JSONArray)localObject).length();
        paramArrayList = paramArrayList.iterator();
        if (!paramArrayList.hasNext()) {
          break;
        }
        e locale = (e)paramArrayList.next();
        locale.a(false);
        i = 0;
        if (i >= j) {
          continue;
        }
        if (!locale.x().equals(((JSONArray)localObject).getString(i))) {
          break label140;
        }
        locale.a(true);
        continue;
        if (!com.gtp.a.a.b.c.a()) {
          break;
        }
      }
      catch (JSONException paramArrayList) {}
      paramArrayList.printStackTrace();
      return;
      label140:
      i += 1;
    }
  }
  
  private void b(int paramInt, e parame)
  {
    SparseArray localSparseArray = new SparseArray(1);
    localSparseArray.put(paramInt, parame);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("setting_value", parame.x());
    this.d.a(1, localSparseArray, WeatherContentProvider.g, localContentValues, "setting_key=?", new String[] { "app_widget_theme" });
  }
  
  private void c(int paramInt, e parame)
  {
    SparseArray localSparseArray = new SparseArray(1);
    localSparseArray.put(paramInt, parame);
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (parame.s())
    {
      localObject = new ContentValues();
      ((ContentValues)localObject).put("setting_value", parame.x());
      localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.g).withValues((ContentValues)localObject).withSelection("setting_key=?", new String[] { "app_theme" }).build());
    }
    if (parame.t())
    {
      localObject = parame.x();
      parame = (e)localObject;
      if ("app_theme".equals(localObject)) {
        parame = "com.gau.go.launcherex.gowidget.weatherwidget";
      }
      localObject = new ContentValues();
      ((ContentValues)localObject).put("setting_value", parame);
      localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.g).withValues((ContentValues)localObject).withSelection("setting_key=?", new String[] { "key_live_wallpaper_theme" }).build());
    }
    this.d.a(1, localSparseArray, "com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", localArrayList);
  }
  
  private void d(int paramInt, e parame)
  {
    SparseArray localSparseArray = new SparseArray(1);
    localSparseArray.put(paramInt, parame);
    ArrayList localArrayList = new ArrayList();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("setting_value", parame.x());
    localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.g).withValues(localContentValues).withSelection("setting_key=?", new String[] { "go_widget_theme" }).build());
    localContentValues = new ContentValues();
    localContentValues.put("widget_theme", parame.x());
    localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.i).withValues(localContentValues).build());
    this.d.a(1, localSparseArray, "com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", localArrayList);
  }
  
  private com.gau.go.launcherex.gowidget.weather.globaltheme.b.g e()
  {
    com.gau.go.launcherex.gowidget.weather.globaltheme.b.g localg = new com.gau.go.launcherex.gowidget.weather.globaltheme.b.g();
    localg.a(1);
    localg.b(2131166405);
    localg.a(b());
    return localg;
  }
  
  private void e(int paramInt, e parame)
  {
    if (this.a != null) {
      this.a.a(paramInt, parame);
    }
  }
  
  private com.gau.go.launcherex.gowidget.weather.globaltheme.b.g f()
  {
    com.gau.go.launcherex.gowidget.weather.globaltheme.b.g localg = new com.gau.go.launcherex.gowidget.weather.globaltheme.b.g();
    localg.a(2);
    localg.b(2131166404);
    localg.a(c());
    return localg;
  }
  
  private com.gau.go.launcherex.gowidget.weather.globaltheme.b.g g()
  {
    com.gau.go.launcherex.gowidget.weather.globaltheme.b.g localg = new com.gau.go.launcherex.gowidget.weather.globaltheme.b.g();
    localg.a(0);
    localg.b(2131166403);
    localg.a(d());
    return localg;
  }
  
  public e a(String paramString)
  {
    b localb = null;
    if (this.c != null) {
      localb = this.c.a();
    }
    Object localObject = localb;
    if (localb == null) {
      localObject = this.b.getResources();
    }
    paramString = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(this.b, paramString, (Resources)localObject);
    if (paramString != null)
    {
      int i = this.e + 1;
      this.e = i;
      paramString.f(i);
    }
    return paramString;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.g);
        this.g = true;
        new f(this, null).execute(new Integer[] { Integer.valueOf(paramInt) });
        return;
      } while (this.h);
      this.h = true;
      new f(this, null).execute(new Integer[] { Integer.valueOf(paramInt) });
      return;
    } while (this.f);
    this.f = true;
    new f(this, null).execute(new Integer[] { Integer.valueOf(paramInt) });
  }
  
  public void a(int paramInt, e parame)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      c(paramInt, parame);
      return;
    case 0: 
      b(paramInt, parame);
      return;
    }
    d(paramInt, parame);
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.globaltheme.c.c paramc)
  {
    this.a = paramc;
  }
  
  public ArrayList b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = null;
    if (this.c != null) {
      localObject1 = this.c.a();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.b.getResources();
    }
    localArrayList.add(com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a((Resources)localObject2));
    if (h.b(x.a)) {
      localArrayList.add(com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(this.b));
    }
    localArrayList.addAll(com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(this.b, (Resources)localObject2));
    localObject1 = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.b(this.b, (Resources)localObject2).iterator();
    e locale;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e)((Iterator)localObject1).next();
      locale = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(((e)localObject2).x(), localArrayList);
      if (locale != null) {
        locale.l(true);
      } else {
        localArrayList.add(localObject2);
      }
    }
    localObject1 = localArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e)((Iterator)localObject1).next();
      int i = this.e + 1;
      this.e = i;
      ((e)localObject2).f(i);
    }
    localObject1 = a(this.b, 1);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        locale = (e)((Iterator)localObject2).next();
        if (locale.x().equals(localObject1)) {
          locale.i(true);
        }
      }
    }
    a(localArrayList);
    return localArrayList;
  }
  
  public ArrayList c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = null;
    if (this.c != null) {
      localObject1 = this.c.a();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.b.getResources();
    }
    localObject1 = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.b((Resources)localObject2);
    int i = this.e + 1;
    this.e = i;
    ((e)localObject1).f(i);
    localArrayList.add(localObject1);
    localObject2 = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.c(this.b, (Resources)localObject2).iterator();
    e locale;
    while (((Iterator)localObject2).hasNext())
    {
      locale = (e)((Iterator)localObject2).next();
      i = this.e + 1;
      this.e = i;
      locale.f(i);
      locale.a(n.a(this.b, locale.x()));
      localArrayList.add(locale);
    }
    localObject2 = a(this.b, 2);
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        locale = (e)((Iterator)localObject1).next();
        if (locale.x().equals(localObject2)) {
          locale.i(true);
        }
      }
    }
    for (;;)
    {
      a(localArrayList);
      return localArrayList;
      ((e)localObject1).i(true);
    }
  }
  
  public ArrayList d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = null;
    if (this.c != null) {
      localObject1 = this.c.a();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.b.getResources();
    }
    localObject1 = this.b.getResources().getStringArray(2131558425);
    int i = 0;
    Object localObject3;
    while (i < localObject1.length)
    {
      localObject3 = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(this.b, localObject1[i]);
      localObject3 = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a((Resources)localObject2, localObject1[i], (String)localObject3);
      int j = this.e + 1;
      this.e = j;
      ((e)localObject3).f(j);
      localArrayList.add(localObject3);
      i += 1;
    }
    localObject1 = com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.d(this.b, (Resources)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e)((Iterator)localObject1).next();
      i = this.e + 1;
      this.e = i;
      ((e)localObject2).f(i);
      localArrayList.add(localObject2);
    }
    localObject1 = a(this.b, 0);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (e)((Iterator)localObject2).next();
        if (((e)localObject3).x().equals(localObject1)) {
          ((e)localObject3).i(true);
        }
      }
    }
    a(localArrayList);
    return localArrayList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */