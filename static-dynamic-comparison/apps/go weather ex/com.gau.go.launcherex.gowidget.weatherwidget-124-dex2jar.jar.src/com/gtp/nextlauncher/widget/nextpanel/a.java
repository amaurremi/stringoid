package com.gtp.nextlauncher.widget.nextpanel;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class a
{
  public static String a = "com.gtp.nextlauncher";
  private static a b;
  private Resources c;
  private Context d;
  private int e = 0;
  
  private int a(String paramString)
  {
    int j = 0;
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.equals("")) {}
    }
    try
    {
      i = this.c.getIdentifier(paramString, "drawable", a);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private Drawable a(int paramInt)
  {
    Drawable localDrawable = null;
    if (paramInt != 0) {}
    try
    {
      localDrawable = this.c.getDrawable(paramInt);
      return localDrawable;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static a a()
  {
    try
    {
      if (b == null) {
        b = new a();
      }
      a locala = b;
      return locala;
    }
    finally {}
  }
  
  private void a(Context paramContext, String paramString)
  {
    Resources localResources = paramContext.getResources();
    try
    {
      this.d = paramContext.createPackageContext(paramString, 2);
      if (this.d != null)
      {
        this.c = this.d.getResources();
        return;
      }
      this.c = localResources;
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  public Drawable a(String paramString, Context paramContext)
  {
    if ((this.c == null) || (this.d == null))
    {
      if (this.e > 0) {
        Log.w("ouTest", "init get Resources more than one times");
      }
      a(paramContext, a);
      this.e += 1;
    }
    return a(a(paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */