package com.appbrain.a;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import com.appbrain.AdService;
import java.util.Locale;

public final class cz
  implements AdService
{
  private static final cz a = new cz();
  private final aa b = aa.a();
  private boolean c;
  private boolean d = true;
  private Activity e;
  
  public static cz a()
  {
    return a;
  }
  
  private void a(Context paramContext, boolean paramBoolean, a.a parama)
  {
    new Handler(Looper.getMainLooper()).post(new db(this, paramContext, paramBoolean, parama));
  }
  
  /* Error */
  private boolean a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: iconst_0
    //   7: invokevirtual 60	com/appbrain/a/cz:a	(Landroid/content/Context;Z)V
    //   10: aload_0
    //   11: iconst_1
    //   12: invokespecial 63	com/appbrain/a/cz:b	(Z)Z
    //   15: ifeq +16 -> 31
    //   18: aload_0
    //   19: aload_1
    //   20: iconst_1
    //   21: invokestatic 68	com/appbrain/a/a$a:a	()Lcom/appbrain/a/a$a;
    //   24: invokespecial 70	com/appbrain/a/cz:a	(Landroid/content/Context;ZLcom/appbrain/a/a$a;)V
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_2
    //   30: ireturn
    //   31: aload_0
    //   32: invokevirtual 73	com/appbrain/a/cz:g	()V
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
    //   0	45	0	this	cz
    //   0	45	1	paramContext	Context
    //   1	36	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	27	40	finally
    //   31	35	40	finally
  }
  
  private boolean b(boolean paramBoolean)
  {
    if ((!this.b.c()) && (this.b.j()))
    {
      int i = this.b.a("offerwall", 3);
      if (i > 0)
      {
        long l1 = this.b.e().getLong("last_offer_time", 0L);
        l1 = Math.max(this.b.e().getLong("last_offer_wall_shown", 0L), l1);
        long l2 = System.currentTimeMillis();
        SharedPreferences.Editor localEditor;
        if (System.currentTimeMillis() > i * 86400L * 1000L + l1) {
          if (paramBoolean)
          {
            localEditor = this.b.e().edit();
            localEditor.putLong("last_offer_time", System.currentTimeMillis());
            cmn.a.a().a(localEditor);
          }
        }
        for (i = 1; i != 0; i = 0)
        {
          return true;
          if (l1 > l2)
          {
            localEditor = this.b.e().edit();
            localEditor.putLong("last_offer_time", System.currentTimeMillis());
            cmn.a.a().a(localEditor);
          }
        }
      }
    }
    return false;
  }
  
  final double a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (double d1 = this.b.a("bmedsample", 1.0D);; d1 = this.b.a("bsample", 1.0D)) {
      return Math.max(0.0D, Math.min(1.0D, d1));
    }
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
    //   3: invokevirtual 158	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   6: astore 8
    //   8: aload_0
    //   9: getfield 31	com/appbrain/a/cz:b	Lcom/appbrain/a/aa;
    //   12: invokevirtual 159	com/appbrain/a/aa:g	()V
    //   15: aload_0
    //   16: getfield 31	com/appbrain/a/cz:b	Lcom/appbrain/a/aa;
    //   19: aload 8
    //   21: iload_2
    //   22: invokevirtual 160	com/appbrain/a/aa:a	(Landroid/content/Context;Z)V
    //   25: aload_0
    //   26: getfield 162	com/appbrain/a/cz:c	Z
    //   29: ifne +234 -> 263
    //   32: aload_0
    //   33: iconst_1
    //   34: putfield 162	com/appbrain/a/cz:c	Z
    //   37: aload 8
    //   39: invokevirtual 166	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   42: new 168	android/content/ComponentName
    //   45: dup
    //   46: aload 8
    //   48: ldc -86
    //   50: invokespecial 173	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   53: iconst_0
    //   54: invokevirtual 179	android/content/pm/PackageManager:getActivityInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   57: pop
    //   58: ldc -75
    //   60: ldc -73
    //   62: iconst_1
    //   63: anewarray 185	java/lang/Class
    //   66: dup
    //   67: iconst_0
    //   68: ldc -69
    //   70: aastore
    //   71: invokevirtual 191	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   74: astore 9
    //   76: aload 9
    //   78: invokevirtual 197	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   81: ldc -57
    //   83: invokevirtual 203	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   86: istore_2
    //   87: iload_2
    //   88: ifne +224 -> 312
    //   91: iconst_0
    //   92: istore_3
    //   93: iload_3
    //   94: istore 4
    //   96: getstatic 209	android/os/Build$VERSION:SDK_INT	I
    //   99: bipush 17
    //   101: if_icmplt +200 -> 301
    //   104: iload_3
    //   105: istore 4
    //   107: aload 8
    //   109: invokevirtual 166	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   112: aload 8
    //   114: invokevirtual 212	android/content/Context:getPackageName	()Ljava/lang/String;
    //   117: iconst_0
    //   118: invokevirtual 216	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   121: getfield 221	android/content/pm/ApplicationInfo:targetSdkVersion	I
    //   124: bipush 17
    //   126: if_icmplt +175 -> 301
    //   129: aload 9
    //   131: invokevirtual 225	java/lang/reflect/Method:getAnnotations	()[Ljava/lang/annotation/Annotation;
    //   134: ifnull +83 -> 217
    //   137: aload 9
    //   139: invokevirtual 225	java/lang/reflect/Method:getAnnotations	()[Ljava/lang/annotation/Annotation;
    //   142: astore 9
    //   144: aload 9
    //   146: arraylength
    //   147: istore 7
    //   149: iconst_0
    //   150: istore 5
    //   152: iconst_0
    //   153: istore 4
    //   155: iload 4
    //   157: istore 6
    //   159: iload 5
    //   161: iload 7
    //   163: if_icmpge +57 -> 220
    //   166: aload 9
    //   168: iload 5
    //   170: aaload
    //   171: invokeinterface 231 1 0
    //   176: invokevirtual 232	java/lang/Class:getName	()Ljava/lang/String;
    //   179: ldc -22
    //   181: invokevirtual 203	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   184: istore_2
    //   185: iload_2
    //   186: ifeq +6 -> 192
    //   189: iconst_1
    //   190: istore 4
    //   192: iload 5
    //   194: iconst_1
    //   195: iadd
    //   196: istore 5
    //   198: goto -43 -> 155
    //   201: astore_1
    //   202: new 236	java/lang/IllegalStateException
    //   205: dup
    //   206: ldc -18
    //   208: invokespecial 241	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   211: athrow
    //   212: astore_1
    //   213: aload_0
    //   214: monitorexit
    //   215: aload_1
    //   216: athrow
    //   217: iconst_0
    //   218: istore 6
    //   220: iload_3
    //   221: istore 4
    //   223: iload 6
    //   225: ifne +76 -> 301
    //   228: iconst_0
    //   229: istore_3
    //   230: iload_3
    //   231: ifne +27 -> 258
    //   234: getstatic 245	java/lang/System:err	Ljava/io/PrintStream;
    //   237: ldc -9
    //   239: invokevirtual 252	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   242: aload 8
    //   244: ldc -2
    //   246: iconst_1
    //   247: invokestatic 260	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   250: invokevirtual 263	android/widget/Toast:show	()V
    //   253: aload_0
    //   254: iconst_0
    //   255: putfield 33	com/appbrain/a/cz:d	Z
    //   258: aload 8
    //   260: invokestatic 268	com/appbrain/a/cq:a	(Landroid/content/Context;)V
    //   263: new 270	com/appbrain/a/da
    //   266: dup
    //   267: aload_0
    //   268: aload_1
    //   269: invokespecial 273	com/appbrain/a/da:<init>	(Lcom/appbrain/a/cz;Landroid/content/Context;)V
    //   272: invokestatic 278	cmn/af:a	(Ljava/lang/Runnable;)V
    //   275: aload_0
    //   276: monitorexit
    //   277: return
    //   278: astore 9
    //   280: iconst_0
    //   281: istore_3
    //   282: goto -52 -> 230
    //   285: astore 9
    //   287: iconst_1
    //   288: istore_3
    //   289: getstatic 245	java/lang/System:err	Ljava/io/PrintStream;
    //   292: ldc_w 280
    //   295: invokevirtual 252	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   298: iload_3
    //   299: istore 4
    //   301: iload 4
    //   303: istore_3
    //   304: goto -74 -> 230
    //   307: astore 9
    //   309: goto -20 -> 289
    //   312: iconst_1
    //   313: istore_3
    //   314: goto -221 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	cz
    //   0	317	1	paramContext	Context
    //   0	317	2	paramBoolean	boolean
    //   92	222	3	i	int
    //   94	208	4	j	int
    //   150	47	5	k	int
    //   157	67	6	m	int
    //   147	17	7	n	int
    //   6	253	8	localContext	Context
    //   74	93	9	localObject	Object
    //   278	1	9	localNoSuchMethodException	NoSuchMethodException
    //   285	1	9	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   307	1	9	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    // Exception table:
    //   from	to	target	type
    //   37	58	201	android/content/pm/PackageManager$NameNotFoundException
    //   2	37	212	finally
    //   37	58	212	finally
    //   58	87	212	finally
    //   96	104	212	finally
    //   107	149	212	finally
    //   166	185	212	finally
    //   202	212	212	finally
    //   234	258	212	finally
    //   258	263	212	finally
    //   263	275	212	finally
    //   289	298	212	finally
    //   58	87	278	java/lang/NoSuchMethodException
    //   96	104	278	java/lang/NoSuchMethodException
    //   107	149	278	java/lang/NoSuchMethodException
    //   166	185	278	java/lang/NoSuchMethodException
    //   58	87	285	android/content/pm/PackageManager$NameNotFoundException
    //   96	104	307	android/content/pm/PackageManager$NameNotFoundException
    //   107	149	307	android/content/pm/PackageManager$NameNotFoundException
    //   166	185	307	android/content/pm/PackageManager$NameNotFoundException
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
    SharedPreferences.Editor localEditor = this.b.e().edit();
    localEditor.putLong("last_offer_wall_shown", System.currentTimeMillis());
    cmn.a.a().b(localEditor);
  }
  
  public final void g()
  {
    if (this.e != null) {
      this.e.finish();
    }
  }
  
  public final String getOfferWallButtonLabel(Context paramContext)
  {
    return bs.a(2, paramContext.getResources().getConfiguration().locale.getLanguage());
  }
  
  public final boolean maybeShowInterstitial(Context paramContext)
  {
    try
    {
      boolean bool = a(paramContext);
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public final void setOfferWallClickListener(Context paramContext, View paramView)
  {
    a(paramContext, false);
    paramView.setOnClickListener(new dc(this, paramContext));
  }
  
  public final void setOfferWallMenuItemClickListener(Context paramContext, MenuItem paramMenuItem)
  {
    a(paramContext, false);
    paramMenuItem.setOnMenuItemClickListener(new dd(this, paramContext));
  }
  
  public final boolean shouldShowInterstitial(Context paramContext)
  {
    a(paramContext, false);
    return b(false);
  }
  
  /* Error */
  public final boolean showInterstitial(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: iconst_0
    //   7: invokevirtual 60	com/appbrain/a/cz:a	(Landroid/content/Context;Z)V
    //   10: aload_0
    //   11: getfield 31	com/appbrain/a/cz:b	Lcom/appbrain/a/aa;
    //   14: invokevirtual 76	com/appbrain/a/aa:c	()Z
    //   17: ifne +13 -> 30
    //   20: aload_0
    //   21: getfield 31	com/appbrain/a/cz:b	Lcom/appbrain/a/aa;
    //   24: invokevirtual 79	com/appbrain/a/aa:j	()Z
    //   27: ifne +11 -> 38
    //   30: aload_0
    //   31: invokevirtual 73	com/appbrain/a/cz:g	()V
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_2
    //   37: ireturn
    //   38: aload_0
    //   39: aload_1
    //   40: iconst_0
    //   41: invokestatic 68	com/appbrain/a/a$a:a	()Lcom/appbrain/a/a$a;
    //   44: invokespecial 70	com/appbrain/a/cz:a	(Landroid/content/Context;ZLcom/appbrain/a/a$a;)V
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
    //   0	57	0	this	cz
    //   0	57	1	paramContext	Context
    //   1	48	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	30	52	finally
    //   30	34	52	finally
    //   38	47	52	finally
  }
  
  public final void showOfferWall(Context paramContext)
  {
    a(paramContext, false);
    if (!this.b.c()) {
      a.a(paramContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */