package com.appbrain.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.Log;
import cmn.a;
import cmn.j;
import cmn.q;
import com.appbrain.RemoteSettings;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class aa
{
  private static final aa a = new aa();
  private final AtomicBoolean b = new AtomicBoolean(false);
  private Set c;
  private RemoteSettings d;
  private SharedPreferences e;
  private Context f;
  private co g;
  private boolean h = true;
  private String i;
  
  public static aa a()
  {
    return a;
  }
  
  /* Error */
  private void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/appbrain/a/aa:g	Lcom/appbrain/a/co;
    //   6: ifnonnull +36 -> 42
    //   9: iload_1
    //   10: ifeq +47 -> 57
    //   13: aload_0
    //   14: ldc 48
    //   16: bipush 30
    //   18: invokevirtual 51	com/appbrain/a/aa:a	(Ljava/lang/String;I)I
    //   21: istore_2
    //   22: aload_0
    //   23: new 53	com/appbrain/a/ab
    //   26: dup
    //   27: aload_0
    //   28: ldc 55
    //   30: iload_2
    //   31: i2l
    //   32: ldc2_w 56
    //   35: lmul
    //   36: invokespecial 60	com/appbrain/a/ab:<init>	(Lcom/appbrain/a/aa;Ljava/lang/String;J)V
    //   39: putfield 46	com/appbrain/a/aa:g	Lcom/appbrain/a/co;
    //   42: aload_0
    //   43: getfield 46	com/appbrain/a/aa:g	Lcom/appbrain/a/co;
    //   46: aload_0
    //   47: getfield 62	com/appbrain/a/aa:f	Landroid/content/Context;
    //   50: invokevirtual 67	com/appbrain/a/co:c	(Landroid/content/Context;)Z
    //   53: pop
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: aload_0
    //   58: ldc 69
    //   60: ldc 70
    //   62: invokevirtual 51	com/appbrain/a/aa:a	(Ljava/lang/String;I)I
    //   65: istore_2
    //   66: goto -44 -> 22
    //   69: astore_3
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_3
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	aa
    //   0	74	1	paramBoolean	boolean
    //   21	45	2	j	int
    //   69	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	69	finally
    //   13	22	69	finally
    //   22	42	69	finally
    //   42	54	69	finally
    //   57	66	69	finally
  }
  
  private String n()
  {
    if (this.i == null) {
      this.i = Long.toHexString(j.a(Settings.Secure.getString(this.f.getContentResolver(), "android_id")));
    }
    return this.i;
  }
  
  public final double a(String paramString, double paramDouble)
  {
    paramString = this.d.get(paramString);
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
    paramString = this.d.get(paramString);
    try
    {
      int j = Integer.parseInt(paramString);
      return j;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  public final String a(String paramString1, String paramString2)
  {
    return this.d.get(paramString1, paramString2);
  }
  
  public final void a(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    try
    {
      paramContext = paramContext.getApplicationContext();
      if (this.f == null)
      {
        this.f = paramContext;
        q.a(paramContext);
      }
    }
    finally
    {
      try
      {
        paramContext.getPackageManager().getServiceInfo(new ComponentName(paramContext, "com.appbrain.AppBrainService"), 0);
        if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
          break label75;
        }
        throw new IllegalStateException("Add the INTERNET permission to your Android manifest!");
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        throw new IllegalStateException("No AppBrainService defined in the manifest!");
      }
      paramContext = finally;
    }
    label75:
    if (this.d == null)
    {
      this.d = cj.a(paramContext, true);
      this.e = paramContext.getSharedPreferences("ab_sdk_pref", 0);
    }
    d.a(paramContext);
    de.a(paramContext);
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.e.edit();
      ((SharedPreferences.Editor)localObject).putInt("init_called", this.e.getInt("init_called", 0) + 1);
      a.a().a((SharedPreferences.Editor)localObject);
      localObject = n();
      if ((this.c == null) || (!this.c.contains(localObject))) {
        break label252;
      }
      paramBoolean = bool;
      if (!paramBoolean) {
        break label257;
      }
      Log.println(5, "AppBrain", "AppLift is running in test mode for device: " + (String)localObject);
    }
    for (;;)
    {
      a(paramBoolean);
      if (a("sdk_off", 0) != 0) {
        this.b.set(true);
      }
      cr.a(paramContext).a();
      return;
      label252:
      paramBoolean = false;
      break;
      label257:
      Log.println(4, "AppBrain", "To run AppLift in test mode on this device, call AppBrain.addTestDevice(\"" + (String)localObject + "\") before calling AppBrain.init().");
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      if (this.c == null) {
        this.c = new HashSet();
      }
      this.c.add(paramString);
      return;
    }
    finally {}
  }
  
  public final void b(String paramString)
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
    //   3: getfield 62	com/appbrain/a/aa:f	Landroid/content/Context;
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
    //   0	27	0	this	aa
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
  
  /* Error */
  public final boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 216	com/appbrain/a/aa:c	Ljava/util/Set;
    //   6: ifnull +27 -> 33
    //   9: aload_0
    //   10: getfield 216	com/appbrain/a/aa:c	Ljava/util/Set;
    //   13: aload_0
    //   14: invokespecial 214	com/appbrain/a/aa:n	()Ljava/lang/String;
    //   17: invokeinterface 222 2 0
    //   22: istore_1
    //   23: iload_1
    //   24: ifeq +9 -> 33
    //   27: iconst_1
    //   28: istore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_1
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_1
    //   35: goto -6 -> 29
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	aa
    //   22	13	1	bool	boolean
    //   38	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	38	finally
  }
  
  final SharedPreferences e()
  {
    return this.e;
  }
  
  final boolean f()
  {
    return this.h;
  }
  
  final void g()
  {
    this.h = false;
  }
  
  public final String h()
  {
    return this.d.get("pserver", "http://sdk.appbrain.com,http://sdk-b.apptornado.com");
  }
  
  public final Context i()
  {
    return this.f;
  }
  
  final boolean j()
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
  
  public final RemoteSettings k()
  {
    return cj.a(this.f, false);
  }
  
  final void l()
  {
    SharedPreferences.Editor localEditor = this.e.edit();
    localEditor.putInt("pingcount", this.e.getInt("pingcount", 0) + 1);
    a.a().a(localEditor);
  }
  
  public final String m()
  {
    return this.e.getString("ref", null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */