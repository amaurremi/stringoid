package com.vungle.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import java.util.ArrayList;

public final class VunglePub
{
  private static VunglePub a = null;
  private static String b = null;
  
  private VunglePub(Context arg1, String paramString, int paramInt1, int paramInt2)
  {
    ak.a(???);
    ay.a(new k(paramString));
    ay.a().b = paramInt1;
    ay.a().a = paramInt2;
    ??? = (WindowManager)ak.e().getSystemService("window");
    if (??? != null)
    {
      ??? = ???.getDefaultDisplay();
      if (??? != null)
      {
        paramInt2 = ???.getWidth();
        paramInt1 = ???.getHeight();
      }
    }
    for (;;)
    {
      ak.x = paramInt2;
      ak.y = paramInt1;
      ay.a(new j());
      ay.a(new i());
      ??? = ak.e();
      paramString = e.X;
      String str = e.Y;
      if ((!???.getSharedPreferences(paramString, 0).getBoolean(str, false)) && (ba.e(ak.e()))) {
        paramString = new al(ak.e());
      }
      synchronized (ak.l)
      {
        if (ak.k.booleanValue())
        {
          ay.a(new ArrayList(0));
          ba.g(ak.e());
          ??? = ak.e().getSharedPreferences(e.X, 0);
          long l2 = ???.getLong(e.Z, 0L);
          paramInt1 = ???.getInt(e.aa, 0);
          long l1 = l2;
          if (l2 > System.currentTimeMillis())
          {
            l1 = 0L;
            paramInt1 = 0;
          }
          e.a(paramInt1);
          e.a(l1);
          return;
        }
        ak.l = Boolean.valueOf(true);
        paramString.e = new al.b(paramString, 3);
        paramString.e.c.start();
      }
      paramInt1 = 480;
      paramInt2 = 270;
    }
  }
  
  /* Error */
  private static boolean a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 18	com/vungle/sdk/VunglePub:a	Lcom/vungle/sdk/VunglePub;
    //   6: ifnonnull +18 -> 24
    //   9: ldc -63
    //   11: ldc -61
    //   13: invokestatic 200	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   16: pop
    //   17: iconst_0
    //   18: istore_0
    //   19: ldc 2
    //   21: monitorexit
    //   22: iload_0
    //   23: ireturn
    //   24: iconst_1
    //   25: istore_0
    //   26: goto -7 -> 19
    //   29: astore_1
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	8	0	bool	boolean
    //   29	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	17	29	finally
  }
  
  private static boolean a(Boolean paramBoolean, String paramString, boolean paramBoolean1)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (!a()) {
      return bool1;
    }
    ak.D = paramBoolean.booleanValue();
    ak.E = paramString;
    ak.F = paramBoolean1;
    long l = System.currentTimeMillis();
    int i;
    if (l - e.h() < e.g() * 1000)
    {
      new StringBuilder("Time Diff: ").append((l - e.h()) / 1000.0D);
      new StringBuilder("Cur Delay: ").append(e.g());
      i = 1;
      paramBoolean1 = bool2;
    }
    for (;;)
    {
      bool1 = paramBoolean1;
      if (paramBoolean1) {
        break;
      }
      bool1 = paramBoolean1;
      if (i != 0) {
        break;
      }
      bool1 = paramBoolean1;
      if (ak.d()) {
        break;
      }
      paramBoolean = ay.a().c;
      paramString = ba.b(ak.e());
      new Thread(new l.a(e.f(), paramBoolean, paramString), "UnfilledAdRequestThread").start();
      al.d();
      return paramBoolean1;
      if (!ak.j)
      {
        al.d();
        i = 0;
        paramBoolean1 = bool2;
      }
      else if (!ak.n)
      {
        paramBoolean1 = b();
        i = 0;
      }
      else
      {
        i = 0;
        paramBoolean1 = bool2;
      }
    }
  }
  
  private static boolean b()
  {
    boolean bool2 = false;
    for (;;)
    {
      boolean bool1;
      int i;
      try
      {
        new StringBuilder("video ready: ").append(ak.j);
        new StringBuilder("ad in focus: ").append(ak.d());
        bool1 = ak.j;
        if (!bool1)
        {
          bool1 = bool2;
          return bool1;
        }
        bool1 = bool2;
        if (ak.d()) {
          continue;
        }
        String str = ay.a().e.b;
        if (ba.b(str)) {
          break label245;
        }
        if (".m3u8".equalsIgnoreCase(str.substring(str.length() - 5, str.length()))) {
          break label235;
        }
        if (!".m3u".equalsIgnoreCase(str.substring(str.length() - 4, str.length()))) {
          break label240;
        }
      }
      finally {}
      if (i != 0)
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 11)
        {
          bool1 = bool2;
          if (ba.e(ak.e())) {
            bool1 = c();
          }
        }
      }
      else
      {
        bool1 = bool2;
        if (ba.f(ak.e()) == null)
        {
          new StringBuilder(" -- delay: ").append(e.g());
          new StringBuilder(" -- start: ").append(e.h());
          new StringBuilder(" -- focus: ").append(ak.d());
          bool1 = c();
          continue;
          label235:
          i = 1;
          continue;
          label240:
          i = 0;
          continue;
          label245:
          i = 0;
        }
      }
    }
  }
  
  /* Error */
  private static boolean c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 317	com/vungle/sdk/ay:c	()Lcom/vungle/sdk/i;
    //   8: invokestatic 165	java/lang/System:currentTimeMillis	()J
    //   11: putfield 320	com/vungle/sdk/i:a	J
    //   14: iconst_0
    //   15: putstatic 259	com/vungle/sdk/ak:j	Z
    //   18: new 322	android/content/Intent
    //   21: dup
    //   22: invokestatic 52	com/vungle/sdk/ak:e	()Landroid/content/Context;
    //   25: ldc_w 324
    //   28: invokespecial 327	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   31: astore_1
    //   32: aload_1
    //   33: ldc_w 328
    //   36: invokevirtual 332	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   39: pop
    //   40: invokestatic 52	com/vungle/sdk/ak:e	()Landroid/content/Context;
    //   43: aload_1
    //   44: invokevirtual 336	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   47: invokestatic 341	com/vungle/sdk/aj:e	()Lcom/vungle/sdk/aj;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnonnull +8 -> 60
    //   55: ldc 2
    //   57: monitorexit
    //   58: iload_0
    //   59: ireturn
    //   60: aload_1
    //   61: invokevirtual 343	com/vungle/sdk/aj:c	()V
    //   64: iconst_1
    //   65: istore_0
    //   66: goto -11 -> 55
    //   69: astore_1
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	65	0	bool	boolean
    //   31	30	1	localObject1	Object
    //   69	5	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	51	69	finally
    //   60	64	69	finally
  }
  
  public static boolean displayAdvert()
  {
    try
    {
      boolean bool = a(Boolean.valueOf(false), null, true);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static boolean displayIncentivizedAdvert(String paramString, boolean paramBoolean)
  {
    if (paramString != null) {}
    for (String str = paramString;; str = null) {
      try
      {
        if (paramString.length() != 0)
        {
          paramBoolean = a(Boolean.valueOf(true), str, paramBoolean);
          return paramBoolean;
        }
      }
      finally {}
    }
  }
  
  public static boolean displayIncentivizedAdvert(boolean paramBoolean)
  {
    try
    {
      paramBoolean = a(Boolean.valueOf(true), null, paramBoolean);
      return paramBoolean;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public static boolean getSoundEnabled()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 203	com/vungle/sdk/VunglePub:a	()Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifne +10 -> 18
    //   11: iconst_0
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: getstatic 352	com/vungle/sdk/ak:s	Z
    //   21: istore_0
    //   22: goto -9 -> 13
    //   25: astore_1
    //   26: ldc 2
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	16	0	bool	boolean
    //   25	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	25	finally
    //   18	22	25	finally
  }
  
  public static final String getVersionString()
  {
    return "VungleDroid/1.3.4";
  }
  
  public static void init(Context paramContext, String paramString)
  {
    try
    {
      init(paramContext, paramString, 0, -1);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  public static void init(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: getstatic 18	com/vungle/sdk/VunglePub:a	Lcom/vungle/sdk/VunglePub;
    //   9: ifnonnull +61 -> 70
    //   12: iload 4
    //   14: ifeq +52 -> 66
    //   17: iconst_1
    //   18: putstatic 362	com/vungle/sdk/ak:i	Z
    //   21: new 2	com/vungle/sdk/VunglePub
    //   24: dup
    //   25: aload_0
    //   26: aload_1
    //   27: iload_2
    //   28: iload_3
    //   29: invokespecial 364	com/vungle/sdk/VunglePub:<init>	(Landroid/content/Context;Ljava/lang/String;II)V
    //   32: putstatic 18	com/vungle/sdk/VunglePub:a	Lcom/vungle/sdk/VunglePub;
    //   35: invokestatic 256	com/vungle/sdk/al:d	()V
    //   38: invokestatic 367	com/vungle/sdk/ay:b	()Ljava/util/ArrayList;
    //   41: ifnull +25 -> 66
    //   44: invokestatic 367	com/vungle/sdk/ay:b	()Ljava/util/ArrayList;
    //   47: invokevirtual 370	java/util/ArrayList:isEmpty	()Z
    //   50: ifne +16 -> 66
    //   53: new 119	com/vungle/sdk/al
    //   56: dup
    //   57: invokestatic 52	com/vungle/sdk/ak:e	()Landroid/content/Context;
    //   60: invokespecial 121	com/vungle/sdk/al:<init>	(Landroid/content/Context;)V
    //   63: invokevirtual 372	com/vungle/sdk/al:a	()V
    //   66: ldc 2
    //   68: monitorexit
    //   69: return
    //   70: iconst_0
    //   71: istore 4
    //   73: goto -61 -> 12
    //   76: astore_0
    //   77: ldc 2
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramContext	Context
    //   0	82	1	paramString	String
    //   0	82	2	paramInt1	int
    //   0	82	3	paramInt2	int
    //   1	71	4	i	int
    // Exception table:
    //   from	to	target	type
    //   6	12	76	finally
    //   17	66	76	finally
  }
  
  public static boolean isVideoAvailable()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (!a())
        {
          b = "VunglePub not initialized.";
          return bool;
        }
        if (System.currentTimeMillis() - e.h() < e.g() * 1000)
        {
          b = "Ad views are too close together. (Within the delay time provided by the adserver)";
          continue;
        }
        str = ba.f(ak.e());
      }
      finally {}
      String str;
      if (str != null)
      {
        b = str + " not currently available.";
      }
      else if (!ak.j)
      {
        b = "Advert has not been fully downloaded yet.";
      }
      else
      {
        b = "Advert is available.";
        bool = true;
      }
    }
  }
  
  public static boolean isVideoAvailable(boolean paramBoolean)
  {
    try
    {
      boolean bool = isVideoAvailable();
      if (paramBoolean)
      {
        String str = b;
        str = b;
        b = null;
      }
      return bool;
    }
    finally {}
  }
  
  /* Error */
  public static void onPause()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 203	com/vungle/sdk/VunglePub:a	()Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifne +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: invokestatic 397	com/vungle/sdk/az:b	()V
    //   18: invokestatic 400	com/vungle/sdk/ax:b	()V
    //   21: goto -10 -> 11
    //   24: astore_1
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   24	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	24	finally
    //   15	21	24	finally
  }
  
  /* Error */
  public static void onResume()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 203	com/vungle/sdk/VunglePub:a	()Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifne +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: invokestatic 402	com/vungle/sdk/az:a	()V
    //   18: invokestatic 403	com/vungle/sdk/ax:a	()V
    //   21: goto -10 -> 11
    //   24: astore_1
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   24	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	24	finally
    //   15	21	24	finally
  }
  
  public static void setAutoRotation(boolean paramBoolean)
  {
    try
    {
      ak.r = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public static void setBackButtonEnabled(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 203	com/vungle/sdk/VunglePub:a	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iload_0
    //   16: putstatic 412	com/vungle/sdk/ak:t	Z
    //   19: goto -8 -> 11
    //   22: astore_2
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	paramBoolean	boolean
    //   6	2	1	bool	boolean
    //   22	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	22	finally
    //   15	19	22	finally
  }
  
  /* Error */
  public static void setEventListener(EventListener paramEventListener)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 203	com/vungle/sdk/VunglePub:a	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: invokestatic 416	com/vungle/sdk/e:a	(Lcom/vungle/sdk/VunglePub$EventListener;)V
    //   19: goto -8 -> 11
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	paramEventListener	EventListener
    //   6	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	22	finally
    //   15	19	22	finally
  }
  
  /* Error */
  public static void setIncentivizedBackButtonEnabled(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 203	com/vungle/sdk/VunglePub:a	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iload_0
    //   16: putstatic 420	com/vungle/sdk/ak:u	Z
    //   19: goto -8 -> 11
    //   22: astore_2
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	paramBoolean	boolean
    //   6	2	1	bool	boolean
    //   22	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	22	finally
    //   15	19	22	finally
  }
  
  /* Error */
  public static void setSoundEnabled(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 203	com/vungle/sdk/VunglePub:a	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iload_0
    //   16: putstatic 352	com/vungle/sdk/ak:s	Z
    //   19: goto -8 -> 11
    //   22: astore_2
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	paramBoolean	boolean
    //   6	2	1	bool	boolean
    //   22	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	22	finally
    //   15	19	22	finally
  }
  
  public static void setVungleBitmapFactory(VungleBitmapFactory paramVungleBitmapFactory)
  {
    try
    {
      ai.a().a(paramVungleBitmapFactory);
      return;
    }
    finally
    {
      paramVungleBitmapFactory = finally;
      throw paramVungleBitmapFactory;
    }
  }
  
  public static abstract interface EventListener
  {
    public abstract void onVungleAdEnd();
    
    public abstract void onVungleAdStart();
    
    public abstract void onVungleView(double paramDouble1, double paramDouble2);
  }
  
  public static final class Gender
  {
    public static final int FEMALE = 1;
    public static final int MALE = 0;
    public static final int UNKNOWN = -1;
    
    public static String toString(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "unknown";
      case 0: 
        return "male";
      }
      return "female";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/VunglePub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */