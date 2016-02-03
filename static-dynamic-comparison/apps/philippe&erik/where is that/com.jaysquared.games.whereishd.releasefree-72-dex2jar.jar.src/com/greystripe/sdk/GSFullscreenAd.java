package com.greystripe.sdk;

import android.content.Context;

public final class GSFullscreenAd
  extends c
{
  protected static GSFullscreenAd c;
  private static boolean e = false;
  protected at d;
  private Context f;
  private boolean g = false;
  private as h;
  
  public GSFullscreenAd(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GSFullscreenAd(Context paramContext, String paramString)
  {
    super(paramContext);
    this.f = paramContext.getApplicationContext();
    a("s", "fs");
    if (!bj.b(bk.GUID)) {
      bj.a(paramString);
    }
    a("guid", bj.b());
    this.h = new as();
    j().addJavascriptInterface(this.h, "FullscreenController");
    this.d = new at(this);
    j().addJavascriptInterface(this.d, "Video");
    super.addListener(new bb(this, (byte)0));
  }
  
  final void a()
  {
    e = true;
  }
  
  final void a(GSFullscreenActivity paramGSFullscreenActivity)
  {
    this.h.a(paramGSFullscreenActivity);
  }
  
  final void b()
  {
    e = false;
  }
  
  final void c()
  {
    this.h.close();
  }
  
  /* Error */
  public final void display()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 113	com/greystripe/sdk/GSFullscreenAd:isAdReady	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: getstatic 115	com/greystripe/sdk/GSFullscreenAd:c	Lcom/greystripe/sdk/GSFullscreenAd;
    //   17: ifnonnull -6 -> 11
    //   20: aload_0
    //   21: putstatic 115	com/greystripe/sdk/GSFullscreenAd:c	Lcom/greystripe/sdk/GSFullscreenAd;
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 29	com/greystripe/sdk/GSFullscreenAd:g	Z
    //   29: new 117	android/content/Intent
    //   32: dup
    //   33: aload_0
    //   34: getfield 37	com/greystripe/sdk/GSFullscreenAd:f	Landroid/content/Context;
    //   37: ldc 119
    //   39: invokespecial 122	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   42: astore_2
    //   43: aload_2
    //   44: ldc 123
    //   46: invokevirtual 127	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   49: pop
    //   50: aload_0
    //   51: getfield 37	com/greystripe/sdk/GSFullscreenAd:f	Landroid/content/Context;
    //   54: aload_2
    //   55: invokevirtual 131	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   58: goto -47 -> 11
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	GSFullscreenAd
    //   6	2	1	bool	boolean
    //   42	13	2	localIntent	android.content.Intent
    //   61	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	61	finally
    //   14	58	61	finally
  }
  
  public final void fetch()
  {
    for (;;)
    {
      try
      {
        if (e())
        {
          bd.d("There's an ad already displayed. Cannot request another ad at this time.", new Object[0]);
          return;
        }
        if (isAdReady())
        {
          g();
          continue;
        }
        if (!e) {
          break label56;
        }
      }
      finally {}
      a(GSAdErrorCode.FETCH_LIMIT_EXCEEDED);
      continue;
      label56:
      h();
    }
  }
  
  final void k()
  {
    j().b("RAC.close();");
  }
  
  final boolean l()
  {
    return this.g;
  }
  
  final int m()
  {
    return this.h.getOrientation();
  }
  
  final void n()
  {
    this.h.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/GSFullscreenAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */