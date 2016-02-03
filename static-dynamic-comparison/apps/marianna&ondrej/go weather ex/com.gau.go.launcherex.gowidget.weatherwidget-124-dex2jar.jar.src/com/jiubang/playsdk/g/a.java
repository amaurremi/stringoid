package com.jiubang.playsdk.g;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.jiubang.playsdk.a.aa;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static final String a = a.class.getName();
  
  public static int a(int paramInt)
  {
    if (paramInt == 80) {
      return 23;
    }
    if (paramInt == 81) {
      return 35;
    }
    if (paramInt == 82) {
      return 21;
    }
    if (paramInt == 83) {
      return 17;
    }
    if (paramInt == 84) {
      return 24;
    }
    return -1;
  }
  
  public static int a(String paramString)
  {
    if (l.a(paramString)) {
      return aa.a().e();
    }
    if (paramString.equalsIgnoreCase("com.jb.gosms")) {
      return 80;
    }
    if (paramString.equalsIgnoreCase("com.jb.gokeyboard")) {
      return 81;
    }
    if (paramString.equalsIgnoreCase("com.gau.go.launcherex")) {
      return 82;
    }
    if (paramString.equalsIgnoreCase("com.jiubang.goscreenlock")) {
      return 83;
    }
    if (paramString.equalsIgnoreCase("com.gau.go.launcherex.gowidget.weatherwidget")) {
      return 84;
    }
    return aa.a().e();
  }
  
  public static String a(Context paramContext)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = "";
    if (d(paramContext, "com.gau.go.launcherex")) {
      str = b(paramContext);
    }
    if (!TextUtils.isEmpty(str)) {
      localStringBuffer.append(str).append(",");
    }
    if (d(paramContext, "com.jiubang.goscreenlock")) {}
    for (str = c(paramContext);; str = "")
    {
      if (!TextUtils.isEmpty(str)) {
        localStringBuffer.append(str).append(",");
      }
      if (d(paramContext, "com.jb.gosms")) {}
      for (str = d(paramContext);; str = "")
      {
        if (!TextUtils.isEmpty(str)) {
          localStringBuffer.append(str).append(",");
        }
        if (d(paramContext, "com.gau.go.launcherex.gowidget.weatherwidget")) {}
        for (str = e(paramContext);; str = "")
        {
          if (!TextUtils.isEmpty(str)) {
            localStringBuffer.append(str).append(",");
          }
          if (d(paramContext, "com.jb.gokeyboard")) {}
          for (paramContext = f(paramContext);; paramContext = "")
          {
            if (!TextUtils.isEmpty(paramContext)) {
              localStringBuffer.append(paramContext).append(",");
            }
            if (!TextUtils.isEmpty(localStringBuffer))
            {
              paramContext = localStringBuffer.toString();
              return paramContext.substring(0, paramContext.length() - ",".length());
            }
            return "";
          }
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.DELETE", Uri.parse("package:" + l.b(paramString)));
      localIntent.setFlags(268435456);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      d.b(a, "uninstall [" + paramString + "] error...", paramContext);
    }
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {}
    ViewParent localViewParent;
    do
    {
      return;
      localViewParent = paramView.getParent();
    } while ((localViewParent == null) || (!(localViewParent instanceof ViewGroup)));
    ((ViewGroup)paramView.getParent()).removeView(paramView);
  }
  
  public static boolean a(Context paramContext, int paramInt, String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return bool2;
      if (paramInt == 2) {
        bool1 = b(paramContext, paramString);
      }
      bool2 = bool1;
    } while (bool1);
    return c(paramContext, paramString);
  }
  
  public static boolean a(Context paramContext, com.jiubang.playsdk.e.a parama)
  {
    if ((parama == null) || (TextUtils.isEmpty(parama.j()))) {
      return false;
    }
    return a(paramContext, parama.i(), parama.j());
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString1, 0);
      boolean bool1 = bool2;
      if (paramContext != null) {
        if ((paramString2 != null) && (!"".equals(paramString2)) && (!paramString2.equals(paramContext.versionName)))
        {
          boolean bool3 = "Varies with device".equals(paramContext.versionName);
          bool1 = bool2;
          if (!bool3) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static String b(Context paramContext)
  {
    Context localContext = null;
    Object localObject1 = null;
    localObject2 = Uri.parse("content://com.jiubang.ggheart.data.content.gocontentprovider/curtheme");
    localObject2 = paramContext.getContentResolver().query((Uri)localObject2, new String[] { "themename" }, null, null, null);
    paramContext = (Context)localObject1;
    if (localObject2 != null) {
      paramContext = (Context)localObject1;
    }
    try
    {
      if (((Cursor)localObject2).moveToFirst()) {
        paramContext = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("themename"));
      }
      localContext = paramContext;
      if (localObject2 != null)
      {
        ((Cursor)localObject2).close();
        localContext = paramContext;
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        paramContext = paramContext;
      } while (localObject2 == null);
      ((Cursor)localObject2).close();
      return null;
    }
    finally
    {
      paramContext = finally;
      if (localObject2 == null) {
        break label103;
      }
      ((Cursor)localObject2).close();
      throw paramContext;
    }
    return localContext;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    d.a(a, "toGooglePlay,url=" + paramString);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.setPackage("com.android.vending");
    if ((paramContext instanceof Activity)) {
      paramString.setFlags(1073741824);
    }
    for (;;)
    {
      try
      {
        paramContext.startActivity(paramString);
        return true;
      }
      catch (ActivityNotFoundException paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      paramString.setFlags(268435456);
    }
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1.equalsIgnoreCase("com.jb.gosms")) {
      h(paramContext, paramString2);
    }
    for (;;)
    {
      return true;
      if (paramString1.equalsIgnoreCase("com.jb.gokeyboard")) {
        i(paramContext, paramString2);
      } else if (paramString1.equalsIgnoreCase("com.gau.go.launcherex")) {
        j(paramContext, paramString2);
      } else if (paramString1.equalsIgnoreCase("com.jiubang.goscreenlock")) {
        k(paramContext, paramString2);
      } else if (paramString1.equalsIgnoreCase("com.gau.go.launcherex.gowidget.weatherwidget")) {
        g(paramContext, paramString2);
      }
    }
  }
  
  public static String c(Context paramContext)
  {
    Context localContext = null;
    Object localObject1 = null;
    localObject2 = Uri.parse("content://com.jiubang.goscreenlock/theme");
    localObject2 = paramContext.getContentResolver().query((Uri)localObject2, new String[] { "usingThemePackageName" }, null, null, null);
    paramContext = (Context)localObject1;
    if (localObject2 != null) {
      paramContext = (Context)localObject1;
    }
    try
    {
      if (((Cursor)localObject2).moveToFirst()) {
        paramContext = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("usingThemePackageName"));
      }
      localContext = paramContext;
      if (localObject2 != null)
      {
        ((Cursor)localObject2).close();
        localContext = paramContext;
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        paramContext = paramContext;
      } while (localObject2 == null);
      ((Cursor)localObject2).close();
      return null;
    }
    finally
    {
      paramContext = finally;
      if (localObject2 == null) {
        break label106;
      }
      ((Cursor)localObject2).close();
      throw paramContext;
    }
    return localContext;
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
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
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static String d(Context paramContext)
  {
    Context localContext = null;
    Object localObject1 = null;
    localObject2 = Uri.parse("content://gosms.provider.applytheme");
    localObject2 = paramContext.getContentResolver().query((Uri)localObject2, new String[] { "gosms" }, null, null, null);
    paramContext = (Context)localObject1;
    if (localObject2 != null) {
      paramContext = (Context)localObject1;
    }
    try
    {
      if (((Cursor)localObject2).moveToFirst()) {
        paramContext = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("gosms"));
      }
      localContext = paramContext;
      if (localObject2 != null)
      {
        ((Cursor)localObject2).close();
        localContext = paramContext;
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        paramContext = paramContext;
      } while (localObject2 == null);
      ((Cursor)localObject2).close();
      return null;
    }
    finally
    {
      paramContext = finally;
      if (localObject2 == null) {
        break label106;
      }
      ((Cursor)localObject2).close();
      throw paramContext;
    }
    return localContext;
  }
  
  public static boolean d(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {
      return false;
    }
    try
    {
      paramContext.getPackageManager().getPackageInfo(paramString, 1024);
      return true;
    }
    catch (Exception paramContext)
    {
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static int e(Context paramContext, String paramString)
  {
    int i = 0;
    if (paramString != null) {
      paramContext = paramContext.getPackageManager();
    }
    try
    {
      i = paramContext.getPackageInfo(paramString, 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.i("AppUtils", "getVersionCodeByPkgName=" + paramString + " has " + paramContext.getMessage());
    }
    return 0;
  }
  
  public static String e(Context paramContext)
  {
    String str = "";
    Object localObject = Uri.parse("content://com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider/common_setting_table");
    localObject = paramContext.getContentResolver().query((Uri)localObject, new String[] { "setting_key", "setting_value" }, "setting_key in ('app_widget_theme')", null, null);
    paramContext = str;
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        if (((Cursor)localObject).getCount() > 0)
        {
          ((Cursor)localObject).moveToFirst();
          int i = ((Cursor)localObject).getColumnIndex("setting_key");
          int j = ((Cursor)localObject).getColumnIndex("setting_value");
          if (((Cursor)localObject).getString(i).equals("app_widget_theme"))
          {
            paramContext = ((Cursor)localObject).getString(j);
            return paramContext;
          }
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return "";
      }
      finally
      {
        ((Cursor)localObject).close();
      }
      paramContext = "";
    }
  }
  
  public static String f(Context paramContext)
  {
    Context localContext = null;
    Object localObject1 = null;
    localObject2 = Uri.parse("content://com.jb.gokeyboard.gokeyboardprovider/curtheme");
    localObject2 = paramContext.getContentResolver().query((Uri)localObject2, new String[] { "themename" }, null, null, null);
    paramContext = (Context)localObject1;
    if (localObject2 != null) {
      paramContext = (Context)localObject1;
    }
    try
    {
      if (((Cursor)localObject2).moveToFirst()) {
        paramContext = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("themename"));
      }
      localContext = paramContext;
      if (localObject2 != null)
      {
        ((Cursor)localObject2).close();
        localContext = paramContext;
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        paramContext = paramContext;
      } while (localObject2 == null);
      ((Cursor)localObject2).close();
      return null;
    }
    finally
    {
      paramContext = finally;
      if (localObject2 == null) {
        break label104;
      }
      ((Cursor)localObject2).close();
      throw paramContext;
    }
    return localContext;
  }
  
  public static String f(Context paramContext, String paramString)
  {
    String str = "0.0";
    if (paramString != null) {
      paramContext = paramContext.getPackageManager();
    }
    try
    {
      str = paramContext.getPackageInfo(paramString, 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return "0.0";
  }
  
  public static void g(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.LAUNCHER");
    Iterator localIterator = paramContext.getPackageManager().queryIntentActivities(localIntent, 0).iterator();
    while (localIterator.hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
      if ((localResolveInfo != null) && (localResolveInfo.activityInfo != null) && (localResolveInfo.activityInfo.packageName != null) && (localResolveInfo.activityInfo.name != null) && (localResolveInfo.activityInfo.packageName.startsWith("com.gau.go.launcherex.gowidget.weatherwidget")))
      {
        localIntent.setComponent(new ComponentName("com.gau.go.launcherex.gowidget.weatherwidget", localResolveInfo.activityInfo.name));
        localIntent.putExtra("detailSrc", 3);
        localIntent.putExtra("extra_src_app_package_name", paramString);
      }
    }
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void h(Context paramContext, String paramString)
  {
    try
    {
      paramString = new Intent();
      paramString.setClassName("com.jb.gosms", "com.jb.gosms.themeinfo.ThemeSettingTabActivity");
      paramString.setFlags(335544320);
      paramString.putExtra("installed", true);
      paramContext.startActivity(paramString);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void i(Context paramContext, String paramString)
  {
    try
    {
      paramString = new Intent();
      paramString.setClassName("com.jb.gokeyboard", "com.jb.gokeyboard.gostore.GoStroeFragmentActivity");
      paramString.putExtra("theme_install_page", true);
      paramContext.startActivity(paramString);
      return;
    }
    catch (Exception paramString)
    {
      try
      {
        paramString = new Intent();
        paramString.setClassName("com.jb.gokeyboard", "com.jb.gokeyboard.MainActivity");
        paramContext.startActivity(paramString);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static void j(Context paramContext, String paramString)
  {
    try
    {
      Intent localIntent = new Intent("com.gau.go.launcherex.MyThemes.mythemeaction");
      localIntent.putExtra("type", 2);
      localIntent.putExtra("pkgname", paramString);
      localIntent.putExtra("launcher_pkgname", "com.gau.go.launcherex");
      paramContext.sendBroadcast(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void k(Context paramContext, String paramString)
  {
    try
    {
      Intent localIntent = new Intent("com.jiubang.goscreenlock.themeDetail");
      localIntent.putExtra("themePkg", paramString);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */