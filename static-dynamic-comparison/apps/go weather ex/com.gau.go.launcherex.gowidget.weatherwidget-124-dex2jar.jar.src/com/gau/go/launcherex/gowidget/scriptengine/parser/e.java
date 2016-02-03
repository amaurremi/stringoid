package com.gau.go.launcherex.gowidget.scriptengine.parser;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.SparseArray;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;

public class e
{
  public static SparseArray a;
  public static SparseArray b;
  private static boolean c = true;
  
  static
  {
    a = new SparseArray();
    b = new SparseArray();
    b();
  }
  
  private static int a(int paramInt, boolean paramBoolean)
  {
    int i = 2130837851;
    if (paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        i = 0;
      case 1: 
      case 2: 
        return i;
      case 3: 
        return 2130837841;
      case 4: 
        return 2130837845;
      case 5: 
        return 2130837849;
      case 6: 
        return 2130837843;
      case 7: 
        return 2130837847;
      }
      return 2130837853;
    }
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 2130837852;
    case 2: 
      return 2130837852;
    case 3: 
      return 2130837842;
    case 4: 
      return 2130837846;
    case 5: 
      return 2130837850;
    case 6: 
      return 2130837844;
    case 7: 
      return 2130837848;
    }
    return 2130837854;
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int i = 1;
    int j;
    for (;;)
    {
      j = i;
      if (m / i <= paramInt1) {
        break;
      }
      i += 1;
    }
    while (k / j > paramInt2) {
      j += 1;
    }
    return Math.min(6, j);
  }
  
  private static Resources a(Context paramContext)
  {
    Object localObject2 = GoWidgetApplication.c().a();
    Object localObject1 = null;
    try
    {
      localObject2 = paramContext.createPackageContext((String)localObject2, 2);
      paramContext = (Context)localObject1;
      if (localObject2 != null) {
        paramContext = ((Context)localObject2).getResources();
      }
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static Bitmap a(Context paramContext, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if (paramBoolean) {}
    for (f localf = (f)a.get(paramInt1); localf.c; localf = (f)b.get(paramInt1)) {
      return a(paramContext.getResources(), localf.b, paramInt2, paramInt3);
    }
    Resources localResources = a(paramContext);
    if (localResources == null) {
      return a(paramContext.getResources(), a(paramInt1, paramBoolean), paramInt2, paramInt3);
    }
    return a(localResources, localf.b, paramInt2, paramInt3);
  }
  
  public static Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
    localOptions.inSampleSize = a(localOptions, paramInt2, paramInt3);
    localOptions.inJustDecodeBounds = false;
    localOptions.inPreferredConfig = Bitmap.Config.ALPHA_8;
    return BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
  }
  
  public static void a()
  {
    int j = a.size();
    int i = 0;
    f localf;
    while (i < j)
    {
      localf = (f)a.valueAt(i);
      localf.b = a(localf.a, true);
      localf.c = true;
      i += 1;
    }
    j = b.size();
    i = 0;
    while (i < j)
    {
      localf = (f)b.valueAt(i);
      localf.b = a(localf.a, false);
      localf.c = true;
      i += 1;
    }
  }
  
  public static void a(i parami, int paramInt, String paramString)
  {
    f localf = (f)a.get(paramInt);
    int i;
    if (paramString != null)
    {
      i = parami.c(paramString);
      if (i != 0) {}
    }
    else
    {
      localf.b = a(paramInt, true);
      localf.c = true;
      return;
    }
    localf.b = i;
    localf.c = false;
  }
  
  private static void b()
  {
    a.put(1, new f(1, 2130837851, true));
    a.put(2, new f(2, 2130837851, true));
    a.put(3, new f(3, 2130837841, true));
    a.put(4, new f(4, 2130837845, true));
    a.put(5, new f(5, 2130837849, true));
    a.put(6, new f(6, 2130837843, true));
    a.put(7, new f(7, 2130837847, true));
    a.put(8, new f(8, 2130837853, true));
    b.put(1, new f(1, 2130837852, true));
    b.put(2, new f(2, 2130837852, true));
    b.put(3, new f(3, 2130837842, true));
    b.put(4, new f(4, 2130837846, true));
    b.put(5, new f(5, 2130837850, true));
    b.put(6, new f(6, 2130837844, true));
    b.put(7, new f(7, 2130837848, true));
    b.put(8, new f(8, 2130837854, true));
  }
  
  public static void b(i parami, int paramInt, String paramString)
  {
    f localf = (f)b.get(paramInt);
    int i;
    if (paramString != null)
    {
      i = parami.c(paramString);
      if (i != 0) {}
    }
    else
    {
      localf.b = a(paramInt, false);
      localf.c = true;
      return;
    }
    localf.b = i;
    localf.c = false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */