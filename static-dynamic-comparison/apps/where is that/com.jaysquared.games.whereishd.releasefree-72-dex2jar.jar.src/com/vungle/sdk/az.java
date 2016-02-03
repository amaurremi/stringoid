package com.vungle.sdk;

import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

abstract class az
{
  private static double a = 0.0D;
  private static double b = 0.0D;
  private static Timer c = null;
  private static boolean d = false;
  
  private static String a(boolean paramBoolean, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("start", a);
      if (paramBoolean) {
        localJSONObject.put("end", b);
      }
      localJSONObject.put("isu", ba.b(ak.e()));
      localJSONObject.put("pubAppId", paramString);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      av.a(e.u, "JSONException", paramString);
    }
    return null;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	com/vungle/sdk/az:d	Z
    //   6: ifeq +23 -> 29
    //   9: getstatic 25	com/vungle/sdk/az:c	Ljava/util/Timer;
    //   12: ifnull +13 -> 25
    //   15: getstatic 25	com/vungle/sdk/az:c	Ljava/util/Timer;
    //   18: invokevirtual 84	java/util/Timer:cancel	()V
    //   21: aconst_null
    //   22: putstatic 25	com/vungle/sdk/az:c	Ljava/util/Timer;
    //   25: ldc 2
    //   27: monitorexit
    //   28: return
    //   29: getstatic 25	com/vungle/sdk/az:c	Ljava/util/Timer;
    //   32: ifnonnull -7 -> 25
    //   35: new 81	java/util/Timer
    //   38: dup
    //   39: invokespecial 85	java/util/Timer:<init>	()V
    //   42: astore_0
    //   43: aload_0
    //   44: putstatic 25	com/vungle/sdk/az:c	Ljava/util/Timer;
    //   47: aload_0
    //   48: new 12	com/vungle/sdk/az$c
    //   51: dup
    //   52: iconst_0
    //   53: invokespecial 88	com/vungle/sdk/az$c:<init>	(B)V
    //   56: ldc2_w 89
    //   59: invokevirtual 94	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   62: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   65: l2d
    //   66: ldc2_w 101
    //   69: ddiv
    //   70: putstatic 21	com/vungle/sdk/az:a	D
    //   73: goto -48 -> 25
    //   76: astore_0
    //   77: ldc 2
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   42	6	0	localTimer	Timer
    //   76	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	25	76	finally
    //   29	73	76	finally
  }
  
  private static void a(String paramString1, String paramString2)
  {
    b localb = new b((byte)0);
    localb.a = paramString1;
    localb.b = paramString2;
    new Thread(localb, "VungleSessionThread").start();
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	com/vungle/sdk/az:d	Z
    //   6: ifeq +51 -> 57
    //   9: getstatic 25	com/vungle/sdk/az:c	Ljava/util/Timer;
    //   12: ifnonnull +41 -> 53
    //   15: new 81	java/util/Timer
    //   18: dup
    //   19: invokespecial 85	java/util/Timer:<init>	()V
    //   22: astore_0
    //   23: aload_0
    //   24: putstatic 25	com/vungle/sdk/az:c	Ljava/util/Timer;
    //   27: aload_0
    //   28: new 6	com/vungle/sdk/az$a
    //   31: dup
    //   32: iconst_0
    //   33: invokespecial 118	com/vungle/sdk/az$a:<init>	(B)V
    //   36: ldc2_w 89
    //   39: invokevirtual 94	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   42: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   45: l2d
    //   46: ldc2_w 101
    //   49: ddiv
    //   50: putstatic 23	com/vungle/sdk/az:b	D
    //   53: ldc 2
    //   55: monitorexit
    //   56: return
    //   57: getstatic 25	com/vungle/sdk/az:c	Ljava/util/Timer;
    //   60: ifnull -7 -> 53
    //   63: getstatic 25	com/vungle/sdk/az:c	Ljava/util/Timer;
    //   66: invokevirtual 84	java/util/Timer:cancel	()V
    //   69: aconst_null
    //   70: putstatic 25	com/vungle/sdk/az:c	Ljava/util/Timer;
    //   73: goto -20 -> 53
    //   76: astore_0
    //   77: ldc 2
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	6	0	localTimer	Timer
    //   76	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	53	76	finally
    //   57	73	76	finally
  }
  
  private static void e()
  {
    try
    {
      d = true;
      c = null;
      String str = a(false, ay.a().c);
      a(e.d(), str);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static void f()
  {
    try
    {
      d = false;
      c = null;
      String str = a(true, ay.a().c);
      a(e.e(), str);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static final class a
    extends TimerTask
  {
    public final void run() {}
  }
  
  private static final class b
    implements Runnable
  {
    public String a;
    public String b;
    
    public final void run()
    {
      new StringBuilder("POST-ing to: ").append(this.a).append(" with: ").append(this.b);
      at.a(this.a, this.b);
    }
  }
  
  private static final class c
    extends TimerTask
  {
    public final void run() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */