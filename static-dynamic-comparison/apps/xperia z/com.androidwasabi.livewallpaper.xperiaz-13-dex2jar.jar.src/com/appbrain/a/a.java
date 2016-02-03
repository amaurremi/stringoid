package com.appbrain.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import com.appbrain.AppBrainActivity;
import com.appbrain.c;
import com.appbrain.e.ap;
import com.appbrain.f;

public class a
{
  private static Intent a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, AppBrainActivity.class);
    if (!(paramContext instanceof Activity))
    {
      localIntent.addFlags(268435456);
      localIntent.addFlags(8388608);
    }
    return localIntent;
  }
  
  public static f a(AppBrainActivity paramAppBrainActivity)
  {
    if ((paramAppBrainActivity == null) || (paramAppBrainActivity.getIntent() == null)) {}
    String str;
    do
    {
      return null;
      str = paramAppBrainActivity.getIntent().getStringExtra("activity");
      if ("interstitial".equals(str)) {
        return new j(paramAppBrainActivity);
      }
      if ("offerwall".equals(str)) {
        return new x(paramAppBrainActivity);
      }
      if ("app_popup".equals(str)) {
        return new ba(paramAppBrainActivity);
      }
    } while (!"redirect".equals(str));
    return new ah(paramAppBrainActivity);
  }
  
  private static void a(Context paramContext, com.appbrain.a parama, boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 11) && ((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing()))
    {
      bn.a((Activity)paramContext, parama, paramBoolean);
      return;
    }
    Intent localIntent = a(paramContext);
    localIntent.putExtra("activity", "app_popup");
    localIntent.putExtra(ba.a, parama);
    localIntent.putExtra(ba.b, paramBoolean);
    paramContext.startActivity(localIntent);
  }
  
  static void a(Context paramContext, ap paramap, b paramb)
  {
    Intent localIntent = a(paramContext);
    localIntent.putExtra("activity", "offerwall");
    localIntent.putExtra("src", paramap.a());
    if (paramb != null) {
      paramb.b(localIntent);
    }
    paramContext.startActivity(localIntent);
  }
  
  static void a(Context paramContext, String paramString)
  {
    Intent localIntent = a(paramContext);
    localIntent.putExtra("activity", "redirect");
    localIntent.setData(Uri.parse(paramString));
    paramContext.startActivity(localIntent);
  }
  
  static void a(Context paramContext, boolean paramBoolean1, b paramb, boolean paramBoolean2, com.appbrain.a parama)
  {
    com.appbrain.a locala = parama;
    if (parama == null) {
      locala = new com.appbrain.a();
    }
    if (locala.a() == c.b)
    {
      b(paramContext, paramBoolean1, paramb, paramBoolean2, locala);
      return;
    }
    if (locala.a() == c.c)
    {
      a(paramContext, locala, paramBoolean1);
      return;
    }
    double d = aw.a().a("iskip", 0.0D);
    if (Math.random() < d)
    {
      a(paramContext, ap.i, paramb);
      return;
    }
    d = aw.a().a("apppopup", 0.05D);
    if (Math.random() < d)
    {
      a(paramContext, locala, paramBoolean1);
      return;
    }
    b(paramContext, paramBoolean1, paramb, paramBoolean2, locala);
  }
  
  private static void b(Context paramContext, boolean paramBoolean1, b paramb, boolean paramBoolean2, com.appbrain.a parama)
  {
    Intent localIntent = a(paramContext);
    localIntent.putExtra("activity", "interstitial");
    localIntent.putExtra("maybe", paramBoolean1);
    localIntent.putExtra("adop", parama);
    if (paramBoolean2)
    {
      localIntent.addFlags(32768);
      localIntent.putExtra("ana", "home");
    }
    if (paramb != null) {
      paramb.b(localIntent);
    }
    paramContext.startActivity(localIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */