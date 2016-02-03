package com.appbrain.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import com.appbrain.AdOptions;
import com.appbrain.AdOptions.Type;
import com.appbrain.AppBrainActivity;
import com.appbrain.AppBrainActivity.a;
import com.appbrain.e.j.h;

public class a
{
  public static AppBrainActivity.a a(AppBrainActivity paramAppBrainActivity)
  {
    if ((paramAppBrainActivity == null) || (paramAppBrainActivity.getIntent() == null)) {}
    String str;
    do
    {
      return null;
      str = paramAppBrainActivity.getIntent().getStringExtra("activity");
      if ("interstitial".equals(str)) {
        return new bu(paramAppBrainActivity);
      }
      if ("offerwall".equals(str)) {
        return new ce(paramAppBrainActivity);
      }
      if ("app_popup".equals(str)) {
        return new ac(paramAppBrainActivity);
      }
      if ("redirect".equals(str)) {
        return new cm(paramAppBrainActivity);
      }
    } while (!"app_alert".equals(str));
    return new i.a(paramAppBrainActivity);
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, j.h.b, null, null);
  }
  
  static void a(Context paramContext, int paramInt, String paramString)
  {
    a(paramContext, j.h.g, null, paramString, true, Integer.valueOf(paramInt));
  }
  
  private static void a(Context paramContext, AdOptions paramAdOptions, boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 11) && ((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing()))
    {
      ak.a((Activity)paramContext, paramAdOptions, paramBoolean);
      return;
    }
    Intent localIntent = d(paramContext);
    localIntent.putExtra("activity", "app_popup");
    localIntent.putExtra(ac.a, paramAdOptions);
    localIntent.putExtra(ac.b, paramBoolean);
    paramContext.startActivity(localIntent);
  }
  
  static void a(Context paramContext, j.h paramh, a parama, String paramString)
  {
    a(paramContext, paramh, parama, paramString, false, null);
  }
  
  private static void a(Context paramContext, j.h paramh, a parama, String paramString, boolean paramBoolean, Integer paramInteger)
  {
    boolean bool = false;
    Intent localIntent = d(paramContext);
    localIntent.putExtra("activity", "offerwall");
    localIntent.putExtra("src", paramh.a());
    localIntent.putExtra("ca", paramString);
    paramh = parama;
    if (parama == null) {
      paramh = a.a();
    }
    paramh.b(localIntent);
    int i;
    if (paramBoolean)
    {
      paramh = new Exception().getStackTrace();
      parama = a.class.getPackage().getName();
      i = 0;
    }
    for (;;)
    {
      paramBoolean = bool;
      if (i < paramh.length)
      {
        if (paramh[i].getClassName().startsWith(parama)) {
          break label192;
        }
        paramBoolean = bool;
        if (i != paramh.length - 1)
        {
          paramh = paramh[(i + 1)].getClassName();
          if (!paramh.startsWith("android.view"))
          {
            paramBoolean = bool;
            if (!paramh.startsWith("com.android.internal.view.menu")) {}
          }
          else
          {
            paramBoolean = true;
          }
        }
      }
      localIntent.putExtra("bo", paramBoolean);
      if (paramInteger != null) {
        localIntent.putExtra("bt", paramInteger.intValue());
      }
      paramContext.startActivity(localIntent);
      return;
      label192:
      i += 1;
    }
  }
  
  static void a(Context paramContext, j.h paramh, String paramString)
  {
    a(paramContext, paramh, null, paramString);
  }
  
  static void a(Context paramContext, String paramString)
  {
    Intent localIntent = d(paramContext);
    localIntent.putExtra("activity", "redirect");
    localIntent.setData(Uri.parse(paramString));
    paramContext.startActivity(localIntent);
  }
  
  static void a(Context paramContext, boolean paramBoolean1, a parama, boolean paramBoolean2, AdOptions paramAdOptions)
  {
    AdOptions localAdOptions = paramAdOptions;
    if (paramAdOptions == null) {
      localAdOptions = new AdOptions();
    }
    if (localAdOptions.getType() == AdOptions.Type.MORE_APPS)
    {
      b(paramContext, paramBoolean1, parama, paramBoolean2, localAdOptions);
      return;
    }
    if (localAdOptions.getType() == AdOptions.Type.SINGLE_APP)
    {
      a(paramContext, localAdOptions, paramBoolean1);
      return;
    }
    double d = aa.a().a("iskip", 0.0D);
    if (Math.random() < d)
    {
      a(paramContext, j.h.i, parama, null);
      return;
    }
    d = aa.a().a("apppopup", 0.05D);
    if (Math.random() < d)
    {
      a(paramContext, localAdOptions, paramBoolean1);
      return;
    }
    b(paramContext, paramBoolean1, parama, paramBoolean2, localAdOptions);
  }
  
  static void b(Context paramContext)
  {
    a(paramContext, j.h.k, null, null, true, null);
  }
  
  private static void b(Context paramContext, boolean paramBoolean1, a parama, boolean paramBoolean2, AdOptions paramAdOptions)
  {
    Intent localIntent = d(paramContext);
    localIntent.putExtra("activity", "interstitial");
    localIntent.putExtra("maybe", paramBoolean1);
    localIntent.putExtra("adop", paramAdOptions);
    if (paramBoolean2)
    {
      localIntent.addFlags(32768);
      localIntent.putExtra("ana", "home");
    }
    if (parama != null) {
      parama.b(localIntent);
    }
    paramContext.startActivity(localIntent);
  }
  
  static Intent c(Context paramContext)
  {
    paramContext = d(paramContext);
    paramContext.putExtra("activity", "app_alert");
    return paramContext;
  }
  
  private static Intent d(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, AppBrainActivity.class);
    if (!(paramContext instanceof Activity))
    {
      localIntent.addFlags(268435456);
      localIntent.addFlags(8388608);
    }
    return localIntent;
  }
  
  static final class a
  {
    public final int a;
    public final int b;
    
    private a(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
    
    public static a a()
    {
      StackTraceElement[] arrayOfStackTraceElement = new Exception().getStackTrace();
      StringBuffer localStringBuffer = new StringBuffer();
      String str = a(a.class.getName());
      int j = arrayOfStackTraceElement.length;
      Object localObject1 = "";
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
        Object localObject2 = localObject1;
        if (!a(localStackTraceElement.getClassName()).equals(str))
        {
          localStringBuffer.append(localStackTraceElement.toString());
          localObject2 = localObject1;
          if (((String)localObject1).length() == 0) {
            localObject2 = localStackTraceElement.toString();
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
      return new a(((String)localObject1).hashCode(), localStringBuffer.hashCode());
    }
    
    public static a a(Intent paramIntent)
    {
      if (paramIntent == null) {
        return new a(-1, -1);
      }
      return new a(paramIntent.getIntExtra("hash_last", -1), paramIntent.getIntExtra("hash", -1));
    }
    
    private static String a(String paramString)
    {
      int i = paramString.lastIndexOf('.');
      String str = paramString;
      if (i != -1) {
        str = paramString.substring(0, i);
      }
      return str;
    }
    
    public final void b(Intent paramIntent)
    {
      paramIntent.putExtra("hash_last", this.a);
      paramIntent.putExtra("hash", this.b);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */