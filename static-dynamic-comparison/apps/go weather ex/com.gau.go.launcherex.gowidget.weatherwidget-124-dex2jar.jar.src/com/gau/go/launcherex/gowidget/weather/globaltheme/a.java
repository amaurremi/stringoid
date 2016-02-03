package com.gau.go.launcherex.gowidget.weather.globaltheme;

import android.appwidget.AppWidgetManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.d.g;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.i;
import com.gau.go.launcherex.gowidget.weather.model.ThemeDataBean;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget21Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget41Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget42Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidgetDays41Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidgetDays42Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidgetWorldClock42Provider;
import com.gtp.go.weather.sharephoto.d.h;
import com.gtp.go.weather.sharephoto.x;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Locale;

public abstract class a
{
  public static Bitmap.CompressFormat a(Resources paramResources, int paramInt)
  {
    Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.PNG;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt, localOptions);
    if (!localOptions.outMimeType.equalsIgnoreCase("image/jpeg"))
    {
      paramResources = localCompressFormat;
      if (!localOptions.outMimeType.equalsIgnoreCase("image/bmp")) {}
    }
    else
    {
      paramResources = Bitmap.CompressFormat.JPEG;
    }
    return paramResources;
  }
  
  public static Drawable a(Context paramContext, e parame)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (parame != null)
    {
      if (paramContext != null) {
        break label19;
      }
      localObject2 = localObject1;
    }
    label19:
    do
    {
      do
      {
        return (Drawable)localObject2;
        localObject1 = localObject3;
        if (parame.A())
        {
          localObject1 = localObject3;
          if (parame.B() != -1) {
            localObject1 = paramContext.getResources().getDrawable(parame.B());
          }
        }
        localObject2 = localObject1;
      } while (localObject1 != null);
      if (!com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(parame.x())) {
        break;
      }
      parame = new com.gtp.go.weather.sharephoto.d.b(paramContext);
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inSampleSize = 3;
      parame.a((BitmapFactory.Options)localObject2);
      parame = h.a(paramContext, x.a, parame);
      localObject2 = localObject1;
    } while (parame == null);
    return new BitmapDrawable(paramContext.getResources(), parame);
    return a(paramContext, parame.x());
  }
  
  public static Drawable a(Context paramContext, String paramString)
  {
    return b(paramContext, paramString, "z_theme_preview");
  }
  
  public static Drawable a(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      paramContext = paramContext.createPackageContext(paramString1, 2).getResources();
      paramContext = paramContext.getDrawable(paramContext.getIdentifier(paramString2, "drawable", paramString1));
      return paramContext;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramContext = (Context)localObject;
      } while (!com.gtp.a.a.b.c.a());
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static String a(Bitmap paramBitmap, String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new File(paramString2);
      if (!paramString2.exists()) {
        paramString2.mkdirs();
      }
      paramString1 = new File(paramString2.getPath() + File.separator + paramString1);
      paramString2 = new BufferedOutputStream(new FileOutputStream(paramString1));
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramString2);
      paramString2.flush();
      paramString2.close();
      paramBitmap = paramString1.getPath();
      return paramBitmap;
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  private static void a(Context paramContext, int paramInt)
  {
    Toast.makeText(paramContext, paramInt, 1).show();
  }
  
  public static void a(Context paramContext, ThemeDataBean paramThemeDataBean)
  {
    if (!g.a(paramContext))
    {
      a(paramContext, 2131166414);
      return;
    }
    if (!TextUtils.isEmpty(paramThemeDataBean.o()))
    {
      if (TextUtils.isEmpty(paramThemeDataBean.d())) {}
      for (String str = paramContext.getText(2131166412).toString() + paramThemeDataBean.a();; str = paramThemeDataBean.d())
      {
        com.gau.go.launcherex.gowidget.download.b.a(paramContext, str + ".apk", paramThemeDataBean.o(), paramThemeDataBean.a(), paramThemeDataBean.i());
        return;
      }
    }
    if ((!TextUtils.isEmpty(paramThemeDataBean.p())) && (y.s(paramContext)))
    {
      paramThemeDataBean = new Intent("android.intent.action.VIEW", Uri.parse(paramThemeDataBean.p().trim()));
      try
      {
        paramThemeDataBean.setPackage("com.android.vending");
        paramThemeDataBean.setFlags(268435456);
        paramContext.startActivity(paramThemeDataBean);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
    if (!TextUtils.isEmpty(paramThemeDataBean.s()))
    {
      d(paramContext, paramThemeDataBean.s());
      return;
    }
    if (!TextUtils.isEmpty(paramThemeDataBean.r()))
    {
      d(paramContext, paramThemeDataBean.r());
      return;
    }
    a(paramContext, 2131166415);
  }
  
  public static void a(e parame, Context paramContext)
  {
    parame.b(e(parame.x(), paramContext));
    String str = f(paramContext, parame.x(), "categoryType");
    int j = -1;
    int i = j;
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      i = Integer.valueOf(str).intValue();
      parame.a(i);
      if (parame.l() == 3) {
        parame.d(k(parame.x(), paramContext));
      }
      if ("true".equals(f(paramContext, parame.x(), "couponSupport")))
      {
        parame.b(true);
        if (!"false".equals(f(paramContext, parame.x(), "animationSupport"))) {
          break label150;
        }
        parame.c(false);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        i = j;
        if (com.gtp.a.a.b.c.a())
        {
          localNumberFormatException.printStackTrace();
          i = j;
          continue;
          parame.b(false);
        }
      }
      label150:
      parame.b(true);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidget21Provider.class)).length > 0) {}
    while ((AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidget41Provider.class)).length > 0) || (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidget42Provider.class)).length > 0) || (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidgetDays41Provider.class)).length > 0) || (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidgetDays42Provider.class)).length > 0) || (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidgetWorldClock42Provider.class)).length > 0)) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, i parami)
  {
    boolean bool2 = false;
    boolean bool3 = true;
    if (!g.a(paramContext))
    {
      a(paramContext, 2131166414);
      return false;
    }
    boolean bool1 = bool3;
    if (parami != null) {
      switch (parami.y())
      {
      default: 
        a(paramContext, 2131166415);
        bool1 = false;
      }
    }
    for (;;)
    {
      return bool1;
      if (TextUtils.isEmpty(parami.w())) {}
      for (String str = paramContext.getText(2131166412).toString() + parami.v();; str = parami.w())
      {
        com.gau.go.launcherex.gowidget.download.b.a(paramContext, str + ".apk", parami.z(), parami.v(), parami.x());
        bool1 = bool3;
        break;
      }
      bool1 = bool3;
      if (y.s(paramContext))
      {
        parami = new Intent("android.intent.action.VIEW", Uri.parse(parami.z()));
        try
        {
          parami.setPackage("com.android.vending");
          parami.setFlags(268435456);
          paramContext.startActivity(parami);
          bool1 = true;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
            bool1 = bool2;
          }
        }
        d(paramContext, parami.z());
        bool1 = bool3;
      }
    }
  }
  
  public static boolean a(Context paramContext, Class paramClass)
  {
    int i = AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, paramClass)).length;
    com.gtp.a.a.b.c.a("appwidget", "isExist[" + paramClass.getSimpleName() + "] - " + "[" + i + "]");
    return i > 0;
  }
  
  public static boolean a(String paramString)
  {
    if (paramString.equals("com.mediawoz.goweather.htcstyle")) {}
    while (paramString.equals("com.gau.go.weatherex.systemwidgetskin.defaultskin")) {
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString, Context paramContext)
  {
    if (a(paramString)) {
      return true;
    }
    paramContext = paramContext.getPackageManager();
    Intent localIntent = new Intent("com.gau.go.weatherex.theme.systemwidget");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addCategory("com.gau.go.weatherex.systemwidget.category.DEFAULT");
    paramContext = paramContext.queryIntentActivities(localIntent, 0);
    int j = paramContext.size();
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(((ResolveInfo)paramContext.get(i)).activityInfo.packageName)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  /* Error */
  @android.annotation.SuppressLint({"WorldWriteableFiles"})
  public static boolean a(String paramString, boolean paramBoolean, Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: new 145	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   10: aload_0
    //   11: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_2
    //   15: invokestatic 454	com/gau/go/launcherex/gowidget/statistics/y:v	(Landroid/content/Context;)Ljava/lang/String;
    //   18: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 457	com/gau/go/launcherex/gowidget/d/g:a	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 5
    //   29: invokestatic 458	com/gau/go/launcherex/gowidget/statistics/y:a	()Z
    //   32: ifeq +243 -> 275
    //   35: new 134	java/io/File
    //   38: dup
    //   39: invokestatic 463	com/gtp/a/a/c/c:a	()Ljava/io/File;
    //   42: new 145	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 465
    //   52: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: getstatic 156	java/io/File:separator	Ljava/lang/String;
    //   58: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload 5
    //   63: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokespecial 468	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   72: astore 6
    //   74: iload_1
    //   75: ifeq +124 -> 199
    //   78: aload 6
    //   80: invokevirtual 140	java/io/File:exists	()Z
    //   83: ifne +111 -> 194
    //   86: aload 6
    //   88: invokevirtual 471	java/io/File:getParentFile	()Ljava/io/File;
    //   91: invokevirtual 143	java/io/File:mkdirs	()Z
    //   94: pop
    //   95: aload 6
    //   97: invokevirtual 474	java/io/File:createNewFile	()Z
    //   100: istore_3
    //   101: new 134	java/io/File
    //   104: dup
    //   105: aload_2
    //   106: invokevirtual 477	android/content/Context:getFilesDir	()Ljava/io/File;
    //   109: aload 5
    //   111: invokespecial 468	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   114: astore 6
    //   116: iload_1
    //   117: ifeq +116 -> 233
    //   120: aload 6
    //   122: invokevirtual 140	java/io/File:exists	()Z
    //   125: ifne +147 -> 272
    //   128: aload 6
    //   130: invokevirtual 474	java/io/File:createNewFile	()Z
    //   133: pop
    //   134: iload 4
    //   136: istore_3
    //   137: aload_2
    //   138: aload_0
    //   139: iconst_2
    //   140: invokevirtual 118	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   143: ldc_w 479
    //   146: invokestatic 457	com/gau/go/launcherex/gowidget/d/g:a	(Ljava/lang/String;)Ljava/lang/String;
    //   149: iconst_2
    //   150: invokevirtual 483	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   153: invokeinterface 489 1 0
    //   158: astore_0
    //   159: iload_1
    //   160: ifeq +93 -> 253
    //   163: aload_0
    //   164: aload 5
    //   166: iconst_1
    //   167: invokeinterface 495 3 0
    //   172: pop
    //   173: aload_0
    //   174: invokeinterface 498 1 0
    //   179: pop
    //   180: iload_3
    //   181: ireturn
    //   182: astore 6
    //   184: aload 6
    //   186: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   189: iconst_0
    //   190: istore_3
    //   191: goto -90 -> 101
    //   194: iconst_1
    //   195: istore_3
    //   196: goto -95 -> 101
    //   199: aload 6
    //   201: invokevirtual 140	java/io/File:exists	()Z
    //   204: ifeq +12 -> 216
    //   207: aload 6
    //   209: invokevirtual 502	java/io/File:delete	()Z
    //   212: istore_3
    //   213: goto -112 -> 101
    //   216: iconst_1
    //   217: istore_3
    //   218: goto -117 -> 101
    //   221: astore 6
    //   223: aload 6
    //   225: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   228: iconst_0
    //   229: istore_3
    //   230: goto -93 -> 137
    //   233: iload 4
    //   235: istore_3
    //   236: aload 6
    //   238: invokevirtual 140	java/io/File:exists	()Z
    //   241: ifeq -104 -> 137
    //   244: aload 6
    //   246: invokevirtual 502	java/io/File:delete	()Z
    //   249: istore_3
    //   250: goto -113 -> 137
    //   253: aload_0
    //   254: aload 5
    //   256: invokeinterface 506 2 0
    //   261: pop
    //   262: goto -89 -> 173
    //   265: astore_0
    //   266: aload_0
    //   267: invokevirtual 131	java/lang/Exception:printStackTrace	()V
    //   270: iload_3
    //   271: ireturn
    //   272: goto -135 -> 137
    //   275: iconst_0
    //   276: istore_3
    //   277: goto -176 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	paramString	String
    //   0	280	1	paramBoolean	boolean
    //   0	280	2	paramContext	Context
    //   100	177	3	bool1	boolean
    //   1	233	4	bool2	boolean
    //   27	228	5	str	String
    //   72	57	6	localFile	File
    //   182	26	6	localIOException1	java.io.IOException
    //   221	24	6	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   86	101	182	java/io/IOException
    //   128	134	221	java/io/IOException
    //   137	159	265	java/lang/Exception
    //   163	173	265	java/lang/Exception
    //   173	180	265	java/lang/Exception
    //   253	262	265	java/lang/Exception
  }
  
  public static Drawable b(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      Resources localResources = paramContext.createPackageContext(paramString1, 2).getResources();
      int i = localResources.getIdentifier(paramString2, "drawable", paramString1);
      if (a(localResources, i) == Bitmap.CompressFormat.JPEG)
      {
        paramString1 = new BitmapFactory.Options();
        paramString1.inPreferredConfig = Bitmap.Config.RGB_565;
        return new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeResource(localResources, i, paramString1));
      }
      paramContext = localResources.getDrawable(i);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      if (com.gtp.a.a.b.c.a()) {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public static String b(Context paramContext, String paramString)
  {
    try
    {
      Object localObject = paramContext.createPackageContext(paramString, 2);
      localObject = ((Context)localObject).getResources();
      paramContext = com.gau.go.launcherex.gowidget.language.d.a(paramContext);
      paramContext = new Locale(paramContext.b(), paramContext.e());
      Configuration localConfiguration = ((Resources)localObject).getConfiguration();
      localConfiguration.locale = paramContext;
      ((Resources)localObject).updateConfiguration(localConfiguration, ((Resources)localObject).getDisplayMetrics());
      try
      {
        paramContext = ((Resources)localObject).getString(((Resources)localObject).getIdentifier("theme_app_name", "string", paramString));
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  public static boolean b(Context paramContext)
  {
    return AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidgetDays41Provider.class)).length > 0;
  }
  
  public static boolean b(Context paramContext, e parame)
  {
    return (parame.A()) || (y.e(paramContext) >= parame.o());
  }
  
  public static boolean b(String paramString, Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    Intent localIntent = new Intent("com.gau.go.weatherex.theme.apptheme");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addCategory("com.gau.go.weatherex.app.category.DEFAULT");
    paramContext = paramContext.queryIntentActivities(localIntent, 0);
    int j = paramContext.size();
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(((ResolveInfo)paramContext.get(i)).activityInfo.packageName)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static ThemeDataBean c(String paramString, Context paramContext)
  {
    Object localObject = paramContext.getPackageManager();
    Intent localIntent = new Intent("com.gau.go.weatherex.theme.livewallpaper");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localObject = ((PackageManager)localObject).queryIntentActivities(localIntent, 0);
    int j = ((List)localObject).size();
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(((ResolveInfo)((List)localObject).get(i)).activityInfo.packageName))
      {
        paramString = d(paramString, paramContext);
        paramString.g(3);
        paramString.a(true);
        return paramString;
      }
      i += 1;
    }
    return null;
  }
  
  public static String c(Context paramContext, String paramString)
  {
    try
    {
      Object localObject = paramContext.createPackageContext(paramString, 2);
      localObject = ((Context)localObject).getResources();
      paramContext = com.gau.go.launcherex.gowidget.language.d.a(paramContext);
      paramContext = new Locale(paramContext.b(), paramContext.e());
      Configuration localConfiguration = ((Resources)localObject).getConfiguration();
      localConfiguration.locale = paramContext;
      ((Resources)localObject).updateConfiguration(localConfiguration, ((Resources)localObject).getDisplayMetrics());
      try
      {
        paramContext = ((Resources)localObject).getString(((Resources)localObject).getIdentifier("theme_name", "string", paramString));
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  public static String c(Context paramContext, String paramString1, String paramString2)
  {
    String str = "0";
    try
    {
      paramContext = paramContext.createPackageContext(paramString1, 2).getResources();
      paramContext = paramContext.getString(paramContext.getIdentifier(paramString2, "string", paramString1));
      return paramContext;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramContext = str;
      } while (!com.gtp.a.a.b.c.a());
      paramString1.printStackTrace();
    }
    return "0";
  }
  
  public static boolean c(Context paramContext)
  {
    return AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidget21Provider.class)).length > 0;
  }
  
  public static ThemeDataBean d(String paramString, Context paramContext)
  {
    ThemeDataBean localThemeDataBean = new ThemeDataBean();
    String str = "0.0";
    Object localObject3 = c(paramContext, paramString);
    for (Object localObject2 = localObject3;; localObject2 = str) {
      try
      {
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 1);
        Object localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = localObject3;
          localObject1 = localPackageInfo.applicationInfo.loadLabel(paramContext.getPackageManager()).toString();
        }
        localObject2 = localObject1;
        int i = localPackageInfo.versionCode;
        localNameNotFoundException1.printStackTrace();
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        try
        {
          localObject2 = localPackageInfo.versionName;
          localObject3 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject3 = paramContext.getString(2131166412);
          }
          localThemeDataBean.e(paramString);
          localThemeDataBean.a((String)localObject3);
          localThemeDataBean.d((String)localObject2);
          localThemeDataBean.d(i);
          localThemeDataBean.f(e(paramString, paramContext));
          return localThemeDataBean;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2)
        {
          continue;
        }
        localNameNotFoundException1 = localNameNotFoundException1;
        i = -1;
        localObject1 = localObject2;
      }
    }
  }
  
  public static boolean d(Context paramContext)
  {
    return AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidgetDays42Provider.class)).length > 0;
  }
  
  public static boolean d(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || ("".equals(paramString.trim()))) {}
    do
    {
      return false;
      paramString = Uri.parse(paramString);
    } while (paramString == null);
    paramString = new Intent("android.intent.action.VIEW", paramString);
    paramString.setFlags(268435456);
    try
    {
      paramContext.startActivity(paramString);
      return true;
    }
    catch (ActivityNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static String[] d(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      paramContext = paramContext.createPackageContext(paramString1, 2).getResources();
      paramContext = paramContext.getStringArray(paramContext.getIdentifier(paramString2, "array", paramString1));
      return paramContext;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramContext = (Context)localObject;
      } while (!com.gtp.a.a.b.c.a());
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static int e(String paramString, Context paramContext)
  {
    int i = 0;
    try
    {
      paramString = paramContext.getPackageManager().getActivityInfo(new ComponentName(paramString, "com.gau.go.weatherex.framework.ForSearch"), 129).metaData;
      if (paramString != null) {
        i = paramString.getInt("minGoWeatherEx", 0);
      }
      return i;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static void e(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramContext.startActivity(new Intent("android.intent.action.DELETE", Uri.fromParts("package", paramString, null)));
  }
  
  public static boolean e(Context paramContext)
  {
    return AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidgetWorldClock42Provider.class)).length > 0;
  }
  
  public static int[] e(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      paramContext = paramContext.createPackageContext(paramString1, 2).getResources();
      paramContext = paramContext.getIntArray(paramContext.getIdentifier(paramString2, "array", paramString1));
      return paramContext;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramContext = (Context)localObject;
      } while (!com.gtp.a.a.b.c.a());
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static String f(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      paramContext = paramContext.createPackageContext(paramString1, 2).getResources();
      paramContext = paramContext.getString(paramContext.getIdentifier(paramString2, "string", paramString1));
      return paramContext;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramContext = (Context)localObject;
      } while (!com.gtp.a.a.b.c.a());
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static boolean f(Context paramContext)
  {
    paramContext = paramContext.getContentResolver().query(WeatherContentProvider.l, new String[] { "go_widget_id" }, null, null, null);
    if (paramContext != null)
    {
      if (paramContext.getCount() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramContext.close();
        return bool;
      }
    }
    return false;
  }
  
  public static boolean f(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramContext = paramContext.getPackageManager();
    Intent localIntent = new Intent("com.gau.go.weatherex.theme.apptheme");
    localIntent.addCategory("android.intent.category.DEFAULT");
    paramContext = paramContext.queryIntentActivities(localIntent, 0);
    int j = paramContext.size();
    int i = 0;
    if (i < j) {
      if (!paramString.equals(((ResolveInfo)paramContext.get(i)).activityInfo.packageName)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i += 1;
      break;
    }
  }
  
  public static boolean g(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramContext = paramContext.getPackageManager();
    Intent localIntent = new Intent("com.gau.go.weatherex.theme.livewallpaper");
    localIntent.addCategory("android.intent.category.DEFAULT");
    paramContext = paramContext.queryIntentActivities(localIntent, 0);
    int j = paramContext.size();
    int i = 0;
    if (i < j) {
      if (!paramString.equals(((ResolveInfo)paramContext.get(i)).activityInfo.packageName)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i += 1;
      break;
    }
  }
  
  public static boolean h(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramContext = paramContext.getPackageManager();
    Intent localIntent = new Intent("com.gau.go.weatherex.theme.systemwidget");
    localIntent.addCategory("android.intent.category.DEFAULT");
    paramContext = paramContext.queryIntentActivities(localIntent, 0);
    int j = paramContext.size();
    int i = 0;
    if (i < j) {
      if (!paramString.equals(((ResolveInfo)paramContext.get(i)).activityInfo.packageName)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i += 1;
      break;
    }
  }
  
  public static boolean i(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramContext = paramContext.getPackageManager();
    Intent localIntent = new Intent("com.gau.go.weatherex.theme.gowidget");
    localIntent.addCategory("android.intent.category.DEFAULT");
    paramContext = paramContext.queryIntentActivities(localIntent, 0);
    int j = paramContext.size();
    int i = 0;
    if (i < j) {
      if (!paramString.equals(((ResolveInfo)paramContext.get(i)).activityInfo.packageName)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i += 1;
      break;
    }
  }
  
  public static boolean j(String paramString, Context paramContext)
  {
    boolean bool = false;
    try
    {
      paramString = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramString != null) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public static boolean k(String paramString, Context paramContext)
  {
    String str = g.a(paramString + y.v(paramContext));
    if ((y.a()) && (new File(com.gtp.a.a.c.c.a(), ".sys/l/l/i/b" + File.separator + str).exists())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = new File(paramContext.getFilesDir(), str).exists();
      }
      if (!bool2) {
        try
        {
          int i = paramContext.createPackageContext(paramString, 2).getSharedPreferences(g.a("goweatherex_theme_paid_info_shared_preferences"), 2).getInt(str, -1);
          return i == 1;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
      return bool2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */