package com.appbrain.a;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import cmn.a;
import com.appbrain.d;

public final class ao
  implements d
{
  private static final ao a = new ao();
  private final aw b = aw.a();
  private boolean c;
  private boolean d = true;
  private Activity e;
  
  public static ao a()
  {
    return a;
  }
  
  private void a(Context paramContext, boolean paramBoolean, b paramb)
  {
    new Handler(Looper.getMainLooper()).post(new ap(this, paramContext, paramBoolean, paramb));
  }
  
  private boolean a(boolean paramBoolean)
  {
    if ((!this.b.c()) && (this.b.i()))
    {
      int i = this.b.a("offerwall", 3);
      if (i > 0)
      {
        long l1 = this.b.d().getLong("last_offer_time", 0L);
        l1 = Math.max(this.b.d().getLong("last_offer_wall_shown", 0L), l1);
        long l2 = System.currentTimeMillis();
        SharedPreferences.Editor localEditor;
        if (System.currentTimeMillis() > i * 86400L * 1000L + l1) {
          if (paramBoolean)
          {
            localEditor = this.b.d().edit();
            localEditor.putLong("last_offer_time", System.currentTimeMillis());
            a.a().a(localEditor);
          }
        }
        for (i = 1; i != 0; i = 0)
        {
          return true;
          if (l1 > l2)
          {
            localEditor = this.b.d().edit();
            localEditor.putLong("last_offer_time", System.currentTimeMillis());
            a.a().a(localEditor);
          }
        }
      }
    }
    return false;
  }
  
  /* Error */
  private boolean c(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: iconst_0
    //   7: invokevirtual 118	com/appbrain/a/ao:a	(Landroid/content/Context;Z)V
    //   10: aload_0
    //   11: iconst_1
    //   12: invokespecial 120	com/appbrain/a/ao:a	(Z)Z
    //   15: ifeq +16 -> 31
    //   18: aload_0
    //   19: aload_1
    //   20: iconst_1
    //   21: invokestatic 125	com/appbrain/a/b:a	()Lcom/appbrain/a/b;
    //   24: invokespecial 127	com/appbrain/a/ao:a	(Landroid/content/Context;ZLcom/appbrain/a/b;)V
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_2
    //   30: ireturn
    //   31: aload_0
    //   32: invokevirtual 130	com/appbrain/a/ao:g	()V
    //   35: iconst_0
    //   36: istore_2
    //   37: goto -10 -> 27
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	ao
    //   0	45	1	paramContext	Context
    //   1	36	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	27	40	finally
    //   31	35	40	finally
  }
  
  public final void a(Activity paramActivity)
  {
    this.e = paramActivity;
  }
  
  /* Error */
  public final void a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 143	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   6: astore_1
    //   7: aload_0
    //   8: getfield 31	com/appbrain/a/ao:b	Lcom/appbrain/a/aw;
    //   11: invokevirtual 146	com/appbrain/a/aw:f	()V
    //   14: aload_0
    //   15: getfield 31	com/appbrain/a/ao:b	Lcom/appbrain/a/aw;
    //   18: aload_1
    //   19: iload_2
    //   20: invokevirtual 147	com/appbrain/a/aw:a	(Landroid/content/Context;Z)V
    //   23: aload_0
    //   24: getfield 149	com/appbrain/a/ao:c	Z
    //   27: ifne +228 -> 255
    //   30: aload_0
    //   31: iconst_1
    //   32: putfield 149	com/appbrain/a/ao:c	Z
    //   35: aload_1
    //   36: invokevirtual 153	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   39: new 155	android/content/ComponentName
    //   42: dup
    //   43: aload_1
    //   44: ldc -99
    //   46: invokespecial 160	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   49: iconst_0
    //   50: invokevirtual 166	android/content/pm/PackageManager:getActivityInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   53: pop
    //   54: ldc -88
    //   56: ldc -86
    //   58: iconst_1
    //   59: anewarray 172	java/lang/Class
    //   62: dup
    //   63: iconst_0
    //   64: ldc -82
    //   66: aastore
    //   67: invokevirtual 178	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   70: astore 8
    //   72: aload 8
    //   74: invokevirtual 184	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   77: ldc -70
    //   79: invokevirtual 190	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   82: istore_2
    //   83: iload_2
    //   84: ifne +208 -> 292
    //   87: iconst_0
    //   88: istore_3
    //   89: iload_3
    //   90: istore 4
    //   92: getstatic 196	android/os/Build$VERSION:SDK_INT	I
    //   95: bipush 17
    //   97: if_icmplt +184 -> 281
    //   100: iload_3
    //   101: istore 4
    //   103: aload_1
    //   104: invokevirtual 153	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   107: aload_1
    //   108: invokevirtual 199	android/content/Context:getPackageName	()Ljava/lang/String;
    //   111: iconst_0
    //   112: invokevirtual 203	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   115: getfield 208	android/content/pm/ApplicationInfo:targetSdkVersion	I
    //   118: bipush 17
    //   120: if_icmplt +161 -> 281
    //   123: aload 8
    //   125: invokevirtual 212	java/lang/reflect/Method:getAnnotations	()[Ljava/lang/annotation/Annotation;
    //   128: ifnull +83 -> 211
    //   131: aload 8
    //   133: invokevirtual 212	java/lang/reflect/Method:getAnnotations	()[Ljava/lang/annotation/Annotation;
    //   136: astore 8
    //   138: aload 8
    //   140: arraylength
    //   141: istore 7
    //   143: iconst_0
    //   144: istore 5
    //   146: iconst_0
    //   147: istore 4
    //   149: iload 4
    //   151: istore 6
    //   153: iload 5
    //   155: iload 7
    //   157: if_icmpge +57 -> 214
    //   160: aload 8
    //   162: iload 5
    //   164: aaload
    //   165: invokeinterface 218 1 0
    //   170: invokevirtual 219	java/lang/Class:getName	()Ljava/lang/String;
    //   173: ldc -35
    //   175: invokevirtual 190	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   178: istore_2
    //   179: iload_2
    //   180: ifeq +6 -> 186
    //   183: iconst_1
    //   184: istore 4
    //   186: iload 5
    //   188: iconst_1
    //   189: iadd
    //   190: istore 5
    //   192: goto -43 -> 149
    //   195: astore_1
    //   196: new 223	java/lang/IllegalStateException
    //   199: dup
    //   200: ldc -31
    //   202: invokespecial 228	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   205: athrow
    //   206: astore_1
    //   207: aload_0
    //   208: monitorexit
    //   209: aload_1
    //   210: athrow
    //   211: iconst_0
    //   212: istore 6
    //   214: iload_3
    //   215: istore 4
    //   217: iload 6
    //   219: ifne +62 -> 281
    //   222: iconst_0
    //   223: istore_3
    //   224: iload_3
    //   225: ifne +26 -> 251
    //   228: getstatic 232	java/lang/System:err	Ljava/io/PrintStream;
    //   231: ldc -22
    //   233: invokevirtual 239	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   236: aload_1
    //   237: ldc -15
    //   239: iconst_1
    //   240: invokestatic 247	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   243: invokevirtual 250	android/widget/Toast:show	()V
    //   246: aload_0
    //   247: iconst_0
    //   248: putfield 33	com/appbrain/a/ao:d	Z
    //   251: aload_1
    //   252: invokestatic 255	com/appbrain/a/al:a	(Landroid/content/Context;)V
    //   255: aload_0
    //   256: monitorexit
    //   257: return
    //   258: astore 8
    //   260: iconst_0
    //   261: istore_3
    //   262: goto -38 -> 224
    //   265: astore 8
    //   267: iconst_1
    //   268: istore_3
    //   269: getstatic 232	java/lang/System:err	Ljava/io/PrintStream;
    //   272: ldc_w 257
    //   275: invokevirtual 239	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   278: iload_3
    //   279: istore 4
    //   281: iload 4
    //   283: istore_3
    //   284: goto -60 -> 224
    //   287: astore 8
    //   289: goto -20 -> 269
    //   292: iconst_1
    //   293: istore_3
    //   294: goto -205 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	ao
    //   0	297	1	paramContext	Context
    //   0	297	2	paramBoolean	boolean
    //   88	206	3	i	int
    //   90	192	4	j	int
    //   144	47	5	k	int
    //   151	67	6	m	int
    //   141	17	7	n	int
    //   70	91	8	localObject	Object
    //   258	1	8	localNoSuchMethodException	NoSuchMethodException
    //   265	1	8	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   287	1	8	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    // Exception table:
    //   from	to	target	type
    //   35	54	195	android/content/pm/PackageManager$NameNotFoundException
    //   2	35	206	finally
    //   35	54	206	finally
    //   54	83	206	finally
    //   92	100	206	finally
    //   103	143	206	finally
    //   160	179	206	finally
    //   196	206	206	finally
    //   228	251	206	finally
    //   251	255	206	finally
    //   269	278	206	finally
    //   54	83	258	java/lang/NoSuchMethodException
    //   92	100	258	java/lang/NoSuchMethodException
    //   103	143	258	java/lang/NoSuchMethodException
    //   160	179	258	java/lang/NoSuchMethodException
    //   54	83	265	android/content/pm/PackageManager$NameNotFoundException
    //   92	100	287	android/content/pm/PackageManager$NameNotFoundException
    //   103	143	287	android/content/pm/PackageManager$NameNotFoundException
    //   160	179	287	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public final boolean a(Context paramContext)
  {
    try
    {
      boolean bool = c(paramContext);
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public final boolean b()
  {
    try
    {
      boolean bool = this.c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final boolean b(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: iconst_0
    //   7: invokevirtual 118	com/appbrain/a/ao:a	(Landroid/content/Context;Z)V
    //   10: aload_0
    //   11: getfield 31	com/appbrain/a/ao:b	Lcom/appbrain/a/aw;
    //   14: invokevirtual 59	com/appbrain/a/aw:c	()Z
    //   17: ifne +13 -> 30
    //   20: aload_0
    //   21: getfield 31	com/appbrain/a/ao:b	Lcom/appbrain/a/aw;
    //   24: invokevirtual 62	com/appbrain/a/aw:i	()Z
    //   27: ifne +11 -> 38
    //   30: aload_0
    //   31: invokevirtual 130	com/appbrain/a/ao:g	()V
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_2
    //   37: ireturn
    //   38: aload_0
    //   39: aload_1
    //   40: iconst_0
    //   41: invokestatic 125	com/appbrain/a/b:a	()Lcom/appbrain/a/b;
    //   44: invokespecial 127	com/appbrain/a/ao:a	(Landroid/content/Context;ZLcom/appbrain/a/b;)V
    //   47: iconst_1
    //   48: istore_2
    //   49: goto -15 -> 34
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	ao
    //   0	57	1	paramContext	Context
    //   1	48	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	30	52	finally
    //   30	34	52	finally
    //   38	47	52	finally
  }
  
  public final boolean c()
  {
    return this.d;
  }
  
  public final String d()
  {
    return this.b.a("adserver", "http://applift-a.apptornado.com,http://applift-b.apptornado.com");
  }
  
  public final String e()
  {
    return this.b.a("owserver", "http://applift-a.apptornado.com");
  }
  
  public final void f()
  {
    SharedPreferences.Editor localEditor = this.b.d().edit();
    localEditor.putLong("last_offer_wall_shown", System.currentTimeMillis());
    a.a().b(localEditor);
  }
  
  public final void g()
  {
    if (this.e != null) {
      this.e.finish();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */