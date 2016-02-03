package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.text.TextUtils;
import com.flurry.android.impl.appcloud.AppCloudModule;

public class go
{
  static int a = 0;
  static int b = 5;
  private static String c = "appcloud.flurry.com";
  private static String d = "appcloud-node-stage.corp.flurry.com";
  private static final String e = go.class.getSimpleName();
  private static hi f = null;
  private static gn g = null;
  private static gj h = null;
  private static gl i = null;
  private static gm j = null;
  private static boolean k = true;
  private static String l;
  private static boolean m = false;
  private static AppCloudModule n = AppCloudModule.getInstance();
  
  public static hi a()
  {
    return f;
  }
  
  public static Object a(gq paramgq)
  {
    switch (gp.a[paramgq.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return i;
    }
    return j;
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null) {}
    try
    {
      ja.b(e, "Context passed to AppCLoudModule was null.");
      ia.a(paramContext);
      b(paramContext);
      h = new gj();
      f = new hi();
      g = new gn();
      fy.a();
      String str = fy.d();
      if (!TextUtils.isEmpty(str)) {
        a(paramContext, str);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      ja.a(6, e, "", paramContext);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    b(paramContext, paramString);
    g.a();
  }
  
  public static void a(String paramString)
  {
    gr.a(paramString);
  }
  
  public static gn b()
  {
    return g;
  }
  
  private static void b(Context paramContext)
  {
    if (!m)
    {
      if (!n.a())
      {
        ja.a(3, e, "Initializing Flurry AppCloud");
        fl localfl = new fl();
        localfl.a = eg.a().f();
        AppCloudModule.getInstance().a(paramContext, localfl);
        ja.a(3, e, "Flurry AppCloud initialized");
      }
      m = true;
    }
  }
  
  private static void b(Context paramContext, String paramString)
  {
    i = new gl(paramContext, paramString);
    j = new gm(paramContext, paramString);
  }
  
  public static void b(String paramString)
  {
    l = paramString;
  }
  
  public static gj c()
  {
    return h;
  }
  
  public static String d()
  {
    if (!TextUtils.isEmpty(l)) {
      return l;
    }
    if (k) {
      return c;
    }
    return d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/go.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */