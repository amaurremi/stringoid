package com.flurry.android.impl.appcloud;

import android.content.Context;
import com.flurry.android.monolithic.sdk.impl.fl;
import com.flurry.android.monolithic.sdk.impl.go;
import com.flurry.android.monolithic.sdk.impl.hd;
import com.flurry.android.monolithic.sdk.impl.ik;
import com.flurry.android.monolithic.sdk.impl.jb;
import com.flurry.android.monolithic.sdk.impl.jc;

public class AppCloudModule
  implements ik, jb
{
  static int a = 0;
  static int b = 5;
  private static final String e = AppCloudModule.class.getSimpleName();
  private static AppCloudModule f;
  String c;
  volatile boolean d;
  private final hd g;
  
  private AppCloudModule()
  {
    jc.a().a(this);
    this.g = new hd();
  }
  
  public static boolean c()
  {
    return go.d().contains("localhost");
  }
  
  public static AppCloudModule getInstance()
  {
    try
    {
      if (f == null) {
        f = new AppCloudModule();
      }
      AppCloudModule localAppCloudModule = f;
      return localAppCloudModule;
    }
    finally {}
  }
  
  public void a(Context paramContext)
  {
    if (this.g != null) {
      this.g.b();
    }
  }
  
  public void a(Context paramContext, fl paramfl)
  {
    jc.a().b();
    if (!this.d)
    {
      this.c = paramfl.a;
      this.d = true;
    }
    go.a(this.c);
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public hd b()
  {
    return this.g;
  }
  
  public void b(Context paramContext)
  {
    if (this.g != null) {
      this.g.c();
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean d()
  {
    if (c()) {
      return true;
    }
    return e();
  }
  
  public boolean e()
  {
    return jc.a().c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/impl/appcloud/AppCloudModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */