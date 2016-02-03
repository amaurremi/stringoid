package com.flurry.android.monolithic.sdk.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class jc
  extends BroadcastReceiver
{
  private static jc d;
  boolean a;
  private List<WeakReference<jb>> b = new LinkedList();
  private boolean c = false;
  
  public static jc a()
  {
    try
    {
      if (d == null) {
        d = new jc();
      }
      jc localjc = d;
      return localjc;
    }
    finally {}
  }
  
  private boolean a(Context paramContext)
  {
    if ((!this.c) || (paramContext == null)) {
      return true;
    }
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public void a(jb paramjb)
  {
    if (paramjb == null) {}
    for (;;)
    {
      return;
      try
      {
        this.b.add(new WeakReference(paramjb));
      }
      finally {}
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 66	com/flurry/android/monolithic/sdk/impl/ia:a	()Lcom/flurry/android/monolithic/sdk/impl/ia;
    //   5: invokevirtual 69	com/flurry/android/monolithic/sdk/impl/ia:b	()Landroid/content/Context;
    //   8: astore_2
    //   9: aload_2
    //   10: ldc 71
    //   12: invokevirtual 75	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   15: ifne +33 -> 48
    //   18: iconst_1
    //   19: istore_1
    //   20: aload_0
    //   21: iload_1
    //   22: putfield 18	com/flurry/android/monolithic/sdk/impl/jc:c	Z
    //   25: aload_0
    //   26: aload_0
    //   27: aload_2
    //   28: invokespecial 77	com/flurry/android/monolithic/sdk/impl/jc:a	(Landroid/content/Context;)Z
    //   31: putfield 79	com/flurry/android/monolithic/sdk/impl/jc:a	Z
    //   34: aload_0
    //   35: getfield 18	com/flurry/android/monolithic/sdk/impl/jc:c	Z
    //   38: ifeq +7 -> 45
    //   41: aload_0
    //   42: invokevirtual 81	com/flurry/android/monolithic/sdk/impl/jc:d	()V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: iconst_0
    //   49: istore_1
    //   50: goto -30 -> 20
    //   53: astore_2
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	jc
    //   19	31	1	bool	boolean
    //   8	20	2	localContext	Context
    //   53	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	53	finally
    //   20	45	53	finally
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  void d()
  {
    Context localContext = ia.a().b();
    this.a = a(localContext);
    localContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }
  
  public jd e()
  {
    if (!this.c) {
      return jd.a;
    }
    Object localObject = (ConnectivityManager)ia.a().b().getSystemService("connectivity");
    NetworkInfo localNetworkInfo = ((ConnectivityManager)localObject).getNetworkInfo(1);
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())) {
      return jd.b;
    }
    localObject = ((ConnectivityManager)localObject).getNetworkInfo(0);
    if ((localObject != null) && (((NetworkInfo)localObject).isConnected())) {
      return jd.c;
    }
    return jd.a;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = a(paramContext);
    if (this.a != bool)
    {
      this.a = bool;
      paramContext = new LinkedList(this.b).iterator();
      while (paramContext.hasNext())
      {
        paramIntent = (jb)((WeakReference)paramContext.next()).get();
        if (paramIntent != null) {
          paramIntent.b(this.a);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/jc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */