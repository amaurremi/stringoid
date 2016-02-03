package com.vungle.publisher.inject;

import android.content.Context;
import com.vungle.publisher.FullScreenAdActivity;
import com.vungle.publisher.VungleService;
import com.vungle.publisher.bm;
import com.vungle.publisher.bn;
import com.vungle.publisher.cq;
import com.vungle.publisher.env.WrapperFramework;
import com.vungle.publisher.image.BitmapFactory;
import com.vungle.publisher.log.Logger;

public class Injector
  implements bn
{
  private static final Injector b = new Injector();
  public cq a;
  private boolean c;
  private bm d;
  private bn e;
  
  private bn a()
  {
    if (this.e == null) {
      this.e = new ConfigurablePublisherModule();
    }
    return this.e;
  }
  
  public static Injector getInstance()
  {
    return b;
  }
  
  public final void a(Context paramContext, String paramString)
  {
    for (;;)
    {
      bn localbn;
      try
      {
        if (this.c)
        {
          Logger.d("VungleInject", "already initialized");
          return;
        }
        Logger.d("VungleInject", "initializing");
        localbn = a();
        localbn.a(paramContext, paramString);
        if (this.d == null)
        {
          this.a = cq.a(new Object[] { localbn });
          this.c = true;
          return;
        }
      }
      catch (Exception paramContext)
      {
        Logger.e("VungleInject", "error initializing injector", paramContext);
        return;
      }
      this.a = cq.a(new Object[] { localbn, this.d });
    }
  }
  
  public final void a(Class<? extends FullScreenAdActivity> paramClass)
  {
    try
    {
      if (this.c)
      {
        Logger.d("VungleInject", "full screen ad activity class in injector NOT set - already initialized");
        return;
      }
      Logger.d("VungleInject", "setting full screen ad activity class in injector " + paramClass);
      a().a(paramClass);
      return;
    }
    catch (Exception paramClass)
    {
      Logger.e("VungleInject", paramClass);
    }
  }
  
  public final void b(Class<? extends VungleService> paramClass)
  {
    try
    {
      if (this.c)
      {
        Logger.d("VungleInject", "service class in injector NOT set - already initialized");
        return;
      }
      Logger.d("VungleInject", "setting serivce class in injector " + paramClass);
      a().b(paramClass);
      return;
    }
    catch (Exception paramClass)
    {
      Logger.e("VungleInject", paramClass);
    }
  }
  
  public void setBitmapFactory(BitmapFactory paramBitmapFactory)
  {
    try
    {
      if (this.c)
      {
        Logger.d("VungleInject", "bitmap factory in injector NOT set - already initialized");
        return;
      }
      Logger.d("VungleInject", "setting bitmap factory in injector " + paramBitmapFactory);
      a().setBitmapFactory(paramBitmapFactory);
      return;
    }
    catch (Exception paramBitmapFactory)
    {
      Logger.e("VungleInject", paramBitmapFactory);
    }
  }
  
  public void setOverrideModule(bm parambm)
  {
    this.d = parambm;
  }
  
  public void setWrapperFramework(WrapperFramework paramWrapperFramework)
  {
    try
    {
      if (this.c)
      {
        Logger.d("VungleInject", "wrapper framework in injector NOT set - already initialized");
        return;
      }
      Logger.d("VungleInject", "setting wrapper framework in injector: " + paramWrapperFramework);
      a().setWrapperFramework(paramWrapperFramework);
      return;
    }
    catch (Exception paramWrapperFramework)
    {
      Logger.e("VungleInject", paramWrapperFramework);
    }
  }
  
  public void setWrapperFrameworkVersion(String paramString)
  {
    try
    {
      if (this.c)
      {
        Logger.d("VungleInject", "wrapper framework version in injector NOT set - already initialized");
        return;
      }
      Logger.d("VungleInject", "setting wrapper framework version in injector: " + paramString);
      a().setWrapperFrameworkVersion(paramString);
      return;
    }
    catch (Exception paramString)
    {
      Logger.e("VungleInject", paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/inject/Injector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */