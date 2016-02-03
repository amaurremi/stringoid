package com.appbrain.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import cmn.a;
import com.appbrain.g;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

public final class aw
{
  private static final aw a = new aw();
  private final AtomicBoolean b = new AtomicBoolean(false);
  private final Timer c = new Timer(true);
  private g d;
  private SharedPreferences e;
  private Context f;
  private aj g;
  private boolean h = true;
  
  public static aw a()
  {
    return a;
  }
  
  private void k()
  {
    try
    {
      if (this.g == null) {
        this.g = new ax(this, "ping", Integer.parseInt(this.d.a("ping_interval", "86400")) * 1000L);
      }
      this.c.schedule(new az(this), 10000L);
      return;
    }
    finally {}
  }
  
  public final double a(String paramString, double paramDouble)
  {
    paramString = this.d.a(paramString);
    try
    {
      double d1 = Double.parseDouble(paramString);
      return d1;
    }
    catch (Exception paramString) {}
    return paramDouble;
  }
  
  public final int a(String paramString, int paramInt)
  {
    paramString = this.d.a(paramString);
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  public final String a(String paramString1, String paramString2)
  {
    return this.d.a(paramString1, paramString2);
  }
  
  /* Error */
  public final void a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 146	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   6: astore_1
    //   7: aload_0
    //   8: getfield 50	com/appbrain/a/aw:f	Landroid/content/Context;
    //   11: ifnonnull +66 -> 77
    //   14: aload_0
    //   15: aload_1
    //   16: putfield 50	com/appbrain/a/aw:f	Landroid/content/Context;
    //   19: aload_1
    //   20: invokevirtual 150	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   23: new 152	android/content/ComponentName
    //   26: dup
    //   27: aload_1
    //   28: ldc -102
    //   30: invokespecial 157	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   33: iconst_0
    //   34: invokevirtual 163	android/content/pm/PackageManager:getServiceInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ServiceInfo;
    //   37: pop
    //   38: aload_1
    //   39: ldc -91
    //   41: invokevirtual 168	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   44: ifeq +29 -> 73
    //   47: new 170	java/lang/IllegalStateException
    //   50: dup
    //   51: ldc -84
    //   53: invokespecial 175	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   56: athrow
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    //   62: astore_1
    //   63: new 170	java/lang/IllegalStateException
    //   66: dup
    //   67: ldc -79
    //   69: invokespecial 175	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   72: athrow
    //   73: aload_1
    //   74: invokestatic 182	cmn/aj:a	(Landroid/content/Context;)V
    //   77: aload_0
    //   78: getfield 95	com/appbrain/a/aw:d	Lcom/appbrain/g;
    //   81: ifnonnull +23 -> 104
    //   84: aload_0
    //   85: aload_1
    //   86: iconst_1
    //   87: invokestatic 187	com/appbrain/a/ae:a	(Landroid/content/Context;Z)Lcom/appbrain/g;
    //   90: putfield 95	com/appbrain/a/aw:d	Lcom/appbrain/g;
    //   93: aload_0
    //   94: aload_1
    //   95: ldc -67
    //   97: iconst_0
    //   98: invokevirtual 193	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   101: putfield 46	com/appbrain/a/aw:e	Landroid/content/SharedPreferences;
    //   104: aload_1
    //   105: invokestatic 196	com/appbrain/a/aq:a	(Landroid/content/Context;)V
    //   108: iload_2
    //   109: ifeq +47 -> 156
    //   112: aload_0
    //   113: getfield 46	com/appbrain/a/aw:e	Landroid/content/SharedPreferences;
    //   116: invokeinterface 61 1 0
    //   121: astore_1
    //   122: aload_1
    //   123: ldc -58
    //   125: aload_0
    //   126: getfield 46	com/appbrain/a/aw:e	Landroid/content/SharedPreferences;
    //   129: ldc -58
    //   131: iconst_0
    //   132: invokeinterface 67 3 0
    //   137: iconst_1
    //   138: iadd
    //   139: invokeinterface 73 3 0
    //   144: pop
    //   145: invokestatic 78	cmn/a:a	()Lcmn/a;
    //   148: aload_1
    //   149: invokevirtual 81	cmn/a:a	(Landroid/content/SharedPreferences$Editor;)V
    //   152: aload_0
    //   153: invokespecial 84	com/appbrain/a/aw:k	()V
    //   156: aload_0
    //   157: ldc -56
    //   159: iconst_0
    //   160: invokevirtual 202	com/appbrain/a/aw:a	(Ljava/lang/String;I)I
    //   163: ifeq +11 -> 174
    //   166: aload_0
    //   167: getfield 36	com/appbrain/a/aw:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   170: iconst_1
    //   171: invokevirtual 205	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   174: aload_0
    //   175: monitorexit
    //   176: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	aw
    //   0	177	1	paramContext	Context
    //   0	177	2	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	19	57	finally
    //   19	38	57	finally
    //   38	57	57	finally
    //   63	73	57	finally
    //   73	77	57	finally
    //   77	104	57	finally
    //   104	108	57	finally
    //   112	156	57	finally
    //   156	174	57	finally
    //   19	38	62	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public final void a(String paramString)
  {
    SharedPreferences.Editor localEditor = this.e.edit();
    localEditor.putString("ref", paramString);
    a.a().a(localEditor);
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/appbrain/a/aw:f	Landroid/content/Context;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	aw
    //   12	7	1	bool	boolean
    //   6	2	2	localContext	Context
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final boolean c()
  {
    return (this.b.get()) || (Build.VERSION.SDK_INT < 8);
  }
  
  final SharedPreferences d()
  {
    return this.e;
  }
  
  final boolean e()
  {
    return this.h;
  }
  
  final void f()
  {
    this.h = false;
  }
  
  public final String g()
  {
    return this.d.a("pserver", "http://sdk.appbrain.com,http://sdk-b.apptornado.com");
  }
  
  public final Context h()
  {
    return this.f;
  }
  
  final boolean i()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.f.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        boolean bool = localNetworkInfo.isConnectedOrConnecting();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Exception localException) {}
    return true;
  }
  
  public final String j()
  {
    return this.e.getString("ref", null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */