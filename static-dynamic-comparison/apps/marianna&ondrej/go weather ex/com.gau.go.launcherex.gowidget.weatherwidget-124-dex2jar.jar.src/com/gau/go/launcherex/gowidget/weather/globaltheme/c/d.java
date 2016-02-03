package com.gau.go.launcherex.gowidget.weather.globaltheme.c;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.ImageView.ScaleType;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.globaltheme.a;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;
import com.gau.go.launcherex.gowidget.weather.util.n;
import com.gtp.a.a.b.c;
import com.gtp.go.weather.sharephoto.d.b;
import com.gtp.go.weather.sharephoto.d.h;
import com.gtp.go.weather.sharephoto.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class d
{
  @SuppressLint({"NewApi"})
  private static long a(PackageInfo paramPackageInfo)
  {
    long l = -1L;
    if (Build.VERSION.SDK_INT >= 9) {
      l = paramPackageInfo.firstInstallTime;
    }
    return l;
  }
  
  public static com.gau.go.launcherex.gowidget.weather.globaltheme.b.e a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    com.gau.go.launcherex.gowidget.weather.globaltheme.b.e locale = new com.gau.go.launcherex.gowidget.weather.globaltheme.b.e();
    locale.c(localResources.getString(2131165319));
    locale.d(localResources.getString(2131166381));
    locale.a(1);
    locale.i(-1);
    locale.j(-1);
    locale.e("com.gtp.go.weather.phototheme");
    locale.l(true);
    locale.k(true);
    locale.m(true);
    locale.n(true);
    locale.a(Long.MAX_VALUE);
    locale.b(Long.MAX_VALUE);
    b localb = new b(paramContext);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = 3;
    localb.a(localOptions);
    paramContext = h.a(paramContext, x.a, localb);
    if (paramContext != null) {
      locale.a(new BitmapDrawable(localResources, paramContext));
    }
    locale.a(ImageView.ScaleType.CENTER_CROP);
    return locale;
  }
  
  public static com.gau.go.launcherex.gowidget.weather.globaltheme.b.e a(Context paramContext, String paramString, Resources paramResources)
  {
    com.gau.go.launcherex.gowidget.weather.globaltheme.b.e locale = null;
    if (!TextUtils.isEmpty(paramString))
    {
      locale = a(paramString, paramContext, paramResources);
      if (locale == null) {
        return locale;
      }
      paramResources = paramContext.getPackageManager();
      Object localObject = new Intent("com.gau.go.weatherex.theme.apptheme");
      ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
      localObject = paramResources.queryIntentActivities((Intent)localObject, 0).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals(((ResolveInfo)((Iterator)localObject).next()).activityInfo.packageName))
        {
          locale.k(true);
          if (locale.l() == -1)
          {
            if (!a.b(locale.x(), paramContext)) {
              break label415;
            }
            locale.a(1);
          }
        }
      }
      localObject = new Intent("com.gau.go.weatherex.theme.livewallpaper");
      ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
      localObject = paramResources.queryIntentActivities((Intent)localObject, 0).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals(((ResolveInfo)((Iterator)localObject).next()).activityInfo.packageName))
        {
          locale.l(true);
          if (locale.l() == -1)
          {
            if (!a.b(locale.x(), paramContext)) {
              break label423;
            }
            locale.a(1);
          }
        }
      }
      label215:
      localObject = new Intent("com.gau.go.weatherex.theme.gowidget");
      ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
      localObject = paramResources.queryIntentActivities((Intent)localObject, 0).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals(((ResolveInfo)((Iterator)localObject).next()).activityInfo.packageName))
        {
          locale.o(true);
          if (locale.l() == -1) {
            locale.a(1);
          }
          b(paramContext, locale);
          locale.a(n.a(paramContext, locale.x()));
        }
      }
      localObject = new Intent("com.gau.go.weatherex.theme.systemwidget");
      ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
      paramResources = paramResources.queryIntentActivities((Intent)localObject, 0).iterator();
      do
      {
        if (!paramResources.hasNext()) {
          break;
        }
      } while (!paramString.equals(((ResolveInfo)paramResources.next()).activityInfo.packageName));
      locale.p(true);
      if (locale.l() == -1)
      {
        if (!a.a(locale.x(), paramContext)) {
          break label431;
        }
        locale.a(1);
      }
    }
    for (;;)
    {
      a(paramContext, locale);
      return locale;
      label415:
      locale.a(2);
      break;
      label423:
      locale.a(2);
      break label215;
      label431:
      locale.a(2);
    }
    return locale;
  }
  
  public static com.gau.go.launcherex.gowidget.weather.globaltheme.b.e a(Resources paramResources)
  {
    com.gau.go.launcherex.gowidget.weather.globaltheme.b.e locale = new com.gau.go.launcherex.gowidget.weather.globaltheme.b.e();
    locale.c(paramResources.getString(2131165319));
    locale.d(paramResources.getString(2131166413));
    locale.a(1);
    locale.i(2130838225);
    locale.j(2130838876);
    locale.e("com.gau.go.launcherex.gowidget.weatherwidget");
    locale.l(true);
    locale.k(true);
    locale.m(true);
    locale.n(true);
    locale.a(Long.MAX_VALUE);
    locale.b(Long.MAX_VALUE);
    locale.a(paramResources.getDrawable(2130838876));
    return locale;
  }
  
  public static com.gau.go.launcherex.gowidget.weather.globaltheme.b.e a(Resources paramResources, String paramString1, String paramString2)
  {
    com.gau.go.launcherex.gowidget.weather.globaltheme.b.e locale = new com.gau.go.launcherex.gowidget.weather.globaltheme.b.e();
    locale.p(true);
    locale.a(1);
    locale.c(paramResources.getString(2131165319));
    locale.d(paramResources.getString(2131165728));
    locale.e(paramString1);
    locale.j(2130838225);
    if (paramString2.equals("1")) {
      locale.j(2130838854);
    }
    locale.m(true);
    locale.n(true);
    locale.a(Long.MAX_VALUE);
    locale.b(Long.MAX_VALUE);
    locale.g(true);
    locale.h(true);
    locale.j(true);
    return locale;
  }
  
  public static com.gau.go.launcherex.gowidget.weather.globaltheme.b.e a(String paramString, Context paramContext, Resources paramResources)
  {
    int j = -1;
    Object localObject7 = "0.0";
    Object localObject3 = a.b(paramContext, paramString);
    Object localObject6 = a.c(paramContext, paramString);
    int i = j;
    Object localObject4 = localObject6;
    Object localObject5 = localObject3;
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 1);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        i = j;
        localObject4 = localObject6;
        localObject5 = localObject3;
        localObject1 = localPackageInfo.applicationInfo.loadLabel(paramContext.getPackageManager()).toString();
      }
      localObject3 = localObject6;
      if (localObject6 == null)
      {
        i = j;
        localObject4 = localObject6;
        localObject5 = localObject1;
        localObject3 = localPackageInfo.applicationInfo.loadLabel(paramContext.getPackageManager()).toString();
      }
      i = j;
      localObject4 = localObject3;
      localObject5 = localObject1;
      j = localPackageInfo.versionCode;
      i = j;
      localObject4 = localObject3;
      localObject5 = localObject1;
      String str = localPackageInfo.versionName;
      localObject4 = localPackageInfo;
      localObject6 = localObject1;
      localObject5 = str;
      localObject1 = localObject3;
      localObject3 = localObject6;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        if (c.a()) {
          localNameNotFoundException.printStackTrace();
        }
        localObject3 = localObject5;
        localObject2 = localObject4;
        localObject4 = null;
        localObject5 = localObject7;
        j = i;
      }
      localObject7 = new com.gau.go.launcherex.gowidget.weather.globaltheme.b.e();
      ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject7).m(true);
      localObject6 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        break label251;
      }
      localObject6 = paramResources.getString(2131166412);
      label251:
      localObject3 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label272;
      }
      localObject3 = paramResources.getString(2131166412);
      label272:
      ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject7).e(paramString);
      ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject7).c((String)localObject6);
      ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject7).d((String)localObject3);
      ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject7).f((String)localObject5);
      ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject7).g(j);
      l1 = a((PackageInfo)localObject4);
      ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject7).a(l1);
      l2 = b((PackageInfo)localObject4);
      if (l2 != 0L) {
        break label350;
      }
    }
    if (localObject4 == null) {
      return null;
    }
    for (;;)
    {
      Object localObject2;
      long l2;
      ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject7).b(l1);
      a.a((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject7, paramContext);
      return (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject7;
      label350:
      long l1 = l2;
    }
  }
  
  public static com.gau.go.launcherex.gowidget.weather.globaltheme.b.e a(String paramString, ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      com.gau.go.launcherex.gowidget.weather.globaltheme.b.e locale = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)paramArrayList.next();
      if ((!TextUtils.isEmpty(locale.x())) && (locale.x().equals(paramString))) {
        return locale;
      }
    }
    return null;
  }
  
  public static final String a(Context paramContext, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("app_widget_theme_black")) || (paramString.equals("app_widget_theme_white"))) {
      return paramContext.getResources().getString(2131165317);
    }
    int i = paramContext.getResources().getIdentifier(paramString, "string", paramContext.getPackageName());
    paramContext = paramContext.getResources();
    if (i != 0) {}
    for (;;)
    {
      return paramContext.getString(i);
      i = 2131165317;
    }
  }
  
  public static String a(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    if ((parame.A()) && (parame.C()) && ("app_widget_theme_white".equals(parame.x()))) {
      return "go_widget_theme_white";
    }
    return parame.x();
  }
  
  public static ArrayList a(Context paramContext, Resources paramResources)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramContext.getPackageManager();
    Object localObject2 = new Intent("com.gau.go.weatherex.theme.apptheme");
    ((Intent)localObject2).addCategory("android.intent.category.DEFAULT");
    localObject1 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 0);
    int j = ((List)localObject1).size();
    int i = 0;
    if (i < j)
    {
      localObject2 = a(((ResolveInfo)((List)localObject1).get(i)).activityInfo.packageName, paramContext, paramResources);
      if (localObject2 != null)
      {
        ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).k(true);
        ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).m(true);
        if (((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).l() == -1)
        {
          if (!a.b(((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).x(), paramContext)) {
            break label142;
          }
          ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).a(1);
        }
      }
      for (;;)
      {
        localArrayList.add(localObject2);
        i += 1;
        break;
        label142:
        ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).a(2);
      }
    }
    return localArrayList;
  }
  
  public static void a(Context paramContext, com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    paramContext = a.d(paramContext, parame.x(), "appwidget_theme_support_style_config");
    if (paramContext != null)
    {
      int j = paramContext.length;
      int i = 0;
      if (i < j)
      {
        if ("appwidget_theme_style4".equalsIgnoreCase(paramContext[i])) {
          parame.g(true);
        }
        for (;;)
        {
          i += 1;
          break;
          if ("appwidget_theme_style5".equalsIgnoreCase(paramContext[i])) {
            parame.h(true);
          } else if ("appwidget_theme_style6".equalsIgnoreCase(paramContext[i])) {
            parame.j(true);
          }
        }
      }
    }
  }
  
  public static void a(ArrayList paramArrayList)
  {
    if (paramArrayList.size() > 1) {
      Collections.sort(paramArrayList, new e());
    }
  }
  
  public static boolean a(String paramString)
  {
    return "com.gtp.go.weather.phototheme".equals(paramString);
  }
  
  @SuppressLint({"NewApi"})
  private static long b(PackageInfo paramPackageInfo)
  {
    long l2 = -1L;
    long l1;
    if (Build.VERSION.SDK_INT >= 9) {
      l1 = paramPackageInfo.lastUpdateTime;
    }
    do
    {
      do
      {
        return l1;
        l1 = l2;
      } while (TextUtils.isEmpty(paramPackageInfo.applicationInfo.sourceDir));
      paramPackageInfo = new File(paramPackageInfo.applicationInfo.sourceDir);
      l1 = l2;
    } while (paramPackageInfo == null);
    return paramPackageInfo.lastModified();
  }
  
  public static com.gau.go.launcherex.gowidget.weather.globaltheme.b.e b(Resources paramResources)
  {
    com.gau.go.launcherex.gowidget.weather.globaltheme.b.e locale = new com.gau.go.launcherex.gowidget.weather.globaltheme.b.e();
    locale.o(true);
    locale.a(1);
    locale.c(paramResources.getString(2131165319));
    locale.d(paramResources.getString(2131166181));
    locale.e("app_widget_theme_white");
    locale.j(2130838225);
    locale.j(2130839014);
    locale.m(true);
    locale.n(true);
    locale.a(Long.MAX_VALUE);
    locale.b(Long.MAX_VALUE);
    locale.e(true);
    locale.f(true);
    return locale;
  }
  
  public static ArrayList b(Context paramContext, Resources paramResources)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramContext.getPackageManager();
    Object localObject2 = new Intent("com.gau.go.weatherex.theme.livewallpaper");
    ((Intent)localObject2).addCategory("android.intent.category.DEFAULT");
    localObject1 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 0);
    int j = ((List)localObject1).size();
    int i = 0;
    if (i < j)
    {
      localObject2 = a(((ResolveInfo)((List)localObject1).get(i)).activityInfo.packageName, paramContext, paramResources);
      if (localObject2 != null)
      {
        ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).l(true);
        ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).m(true);
        if (((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).l() == -1)
        {
          if (!a.b(((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).x(), paramContext)) {
            break label142;
          }
          ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).a(1);
        }
      }
      for (;;)
      {
        localArrayList.add(localObject2);
        i += 1;
        break;
        label142:
        ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).a(2);
      }
    }
    return localArrayList;
  }
  
  public static void b(Context paramContext, com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    paramContext = a.d(paramContext, parame.x(), "gowidget_theme_support_style_config");
    if (paramContext != null)
    {
      int j = paramContext.length;
      int i = 0;
      if (i < j)
      {
        if ("gowidget_theme_style5".equalsIgnoreCase(paramContext[i])) {
          parame.e(true);
        }
        for (;;)
        {
          i += 1;
          break;
          if ("gowidget_theme_style2_layout2".equalsIgnoreCase(paramContext[i])) {
            parame.f(true);
          }
        }
      }
    }
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = false;
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      int i = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0).flags;
      if ((i & 0x40000) != 0) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext.getPackageInfo(paramString, 8192);
      return true;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static com.gau.go.launcherex.gowidget.weather.globaltheme.b.e c(Resources paramResources)
  {
    com.gau.go.launcherex.gowidget.weather.globaltheme.b.e locale = new com.gau.go.launcherex.gowidget.weather.globaltheme.b.e();
    locale.a(1);
    locale.c(paramResources.getString(2131165319));
    locale.d(paramResources.getString(2131166525));
    locale.e("com.gau.go.weatherex.nextwidget.style.one");
    locale.j(2130838225);
    locale.j(2130838345);
    locale.m(true);
    locale.n(true);
    locale.a(0L);
    locale.b(0L);
    return locale;
  }
  
  public static ArrayList c(Context paramContext, Resources paramResources)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramContext.getPackageManager();
    Object localObject2 = new Intent("com.gau.go.weatherex.theme.gowidget");
    ((Intent)localObject2).addCategory("android.intent.category.DEFAULT");
    localObject1 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 0);
    int j = ((List)localObject1).size();
    int i = 0;
    while (i < j)
    {
      localObject2 = a(((ResolveInfo)((List)localObject1).get(i)).activityInfo.packageName, paramContext, paramResources);
      if (localObject2 != null)
      {
        ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).o(true);
        ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).m(true);
        if (((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).l() == -1) {
          ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).a(1);
        }
        b(paramContext, (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2);
        localArrayList.add(localObject2);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static ArrayList d(Context paramContext, Resources paramResources)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramContext.getPackageManager();
    Object localObject2 = new Intent("com.gau.go.weatherex.theme.systemwidget");
    ((Intent)localObject2).addCategory("android.intent.category.DEFAULT");
    localObject1 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 0);
    int j = ((List)localObject1).size();
    int i = 0;
    if (i < j)
    {
      localObject2 = a(((ResolveInfo)((List)localObject1).get(i)).activityInfo.packageName, paramContext, paramResources);
      if (localObject2 != null)
      {
        ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).p(true);
        ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).m(true);
        if (((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).l() == -1)
        {
          if (!a.a(((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).x(), paramContext)) {
            break label148;
          }
          ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).a(1);
        }
      }
      for (;;)
      {
        a(paramContext, (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2);
        localArrayList.add(localObject2);
        i += 1;
        break;
        label148:
        ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject2).a(2);
      }
    }
    return localArrayList;
  }
  
  public static ArrayList e(Context paramContext, Resources paramResources)
  {
    ArrayList localArrayList = c(paramContext, paramResources);
    Object localObject = paramContext.getContentResolver();
    try
    {
      localObject = ((ContentResolver)localObject).query(WeatherContentProvider.I, new String[] { "purchase_state" }, null, null, null);
      paramContext = (Context)localObject;
    }
    catch (Exception localException)
    {
      try
      {
        paramContext.close();
        if ((i != 1) && (i != 2) && (i != 4)) {
          break label237;
        }
        i = 0;
        if (i == 0) {
          break label219;
        }
        paramContext = localArrayList.iterator();
        while (paramContext.hasNext())
        {
          localObject = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)paramContext.next();
          if ((!((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject).g()) && (((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject).l() != 0) && (((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject).l() != 1) && (!((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject).a())) {
            paramContext.remove();
          }
        }
        localException = localException;
        localIntent = new Intent(paramContext, NotifyService.class);
        localIntent.putExtra("notify_request", 38);
        localIntent.putExtra("request_extra_runtime_crash_title", "Error : ThemeUtil.java:1145");
        localIntent.putExtra("request_extra_runtime_crash_text", y.a(localException, "#"));
        paramContext.startService(localIntent);
        paramContext = null;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
        label219:
        a(localArrayList);
        localArrayList.add(b(paramResources));
        return localArrayList;
      }
    }
    if ((paramContext != null) && (paramContext.moveToFirst())) {}
    for (int i = paramContext.getInt(0);; i = 0) {
      for (;;)
      {
        Intent localIntent;
        label237:
        i = 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */