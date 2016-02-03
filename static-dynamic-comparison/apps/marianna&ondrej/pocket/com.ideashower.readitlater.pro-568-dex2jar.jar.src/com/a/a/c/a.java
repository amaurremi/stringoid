package com.a.a.c;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public abstract class a
  extends IntentService
{
  private static final Object a = new Object();
  private static PowerManager.WakeLock b = null;
  
  public a(String paramString)
  {
    super(paramString);
    setIntentRedelivery(true);
  }
  
  private static PowerManager.WakeLock a(Context paramContext)
  {
    try
    {
      if (b == null)
      {
        b = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "com.commonsware.cwac.wakeful.WakefulIntentService");
        b.setReferenceCounted(true);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    synchronized (a)
    {
      a(paramContext).acquire();
      paramContext.startService(paramIntent);
      return;
    }
  }
  
  public static void a(Context paramContext, Class paramClass)
  {
    a(paramContext, new Intent(paramContext, paramClass));
  }
  
  protected abstract void a(Intent paramIntent);
  
  /* Error */
  protected final void onHandleIntent(Intent arg1)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 70	com/a/a/c/a:a	(Landroid/content/Intent;)V
    //   5: getstatic 17	com/a/a/c/a:a	Ljava/lang/Object;
    //   8: astore_1
    //   9: aload_1
    //   10: monitorenter
    //   11: aload_0
    //   12: invokestatic 52	com/a/a/c/a:a	(Landroid/content/Context;)Landroid/os/PowerManager$WakeLock;
    //   15: invokevirtual 74	android/os/PowerManager$WakeLock:isHeld	()Z
    //   18: ifeq +10 -> 28
    //   21: aload_0
    //   22: invokestatic 52	com/a/a/c/a:a	(Landroid/content/Context;)Landroid/os/PowerManager$WakeLock;
    //   25: invokevirtual 77	android/os/PowerManager$WakeLock:release	()V
    //   28: aload_1
    //   29: monitorexit
    //   30: return
    //   31: astore_2
    //   32: aload_1
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    //   36: astore_2
    //   37: getstatic 17	com/a/a/c/a:a	Ljava/lang/Object;
    //   40: astore_1
    //   41: aload_1
    //   42: monitorenter
    //   43: aload_0
    //   44: invokestatic 52	com/a/a/c/a:a	(Landroid/content/Context;)Landroid/os/PowerManager$WakeLock;
    //   47: invokevirtual 74	android/os/PowerManager$WakeLock:isHeld	()Z
    //   50: ifeq +10 -> 60
    //   53: aload_0
    //   54: invokestatic 52	com/a/a/c/a:a	(Landroid/content/Context;)Landroid/os/PowerManager$WakeLock;
    //   57: invokevirtual 77	android/os/PowerManager$WakeLock:release	()V
    //   60: aload_1
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: astore_2
    //   65: aload_1
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	a
    //   31	4	2	localObject1	Object
    //   36	27	2	localObject2	Object
    //   64	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	28	31	finally
    //   28	30	31	finally
    //   32	34	31	finally
    //   0	5	36	finally
    //   43	60	64	finally
    //   60	62	64	finally
    //   65	67	64	finally
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    synchronized (a)
    {
      if (!a(this).isHeld()) {
        a(this).acquire();
      }
      super.onStartCommand(paramIntent, paramInt1, paramInt2);
      return 3;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/a/a/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */