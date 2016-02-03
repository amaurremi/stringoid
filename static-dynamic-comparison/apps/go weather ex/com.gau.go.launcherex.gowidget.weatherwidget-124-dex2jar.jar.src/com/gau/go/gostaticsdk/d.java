package com.gau.go.gostaticsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import com.gau.go.gostaticsdk.f.c;
import java.util.LinkedList;
import java.util.List;

public class d
{
  public static String a = "http://61.145.124.212:8082/GOClientData/DR?ptl=10&is_zip=1";
  public static String b = "http://61.145.124.212:8082/GOClientData/ComCtrl";
  private static d d;
  private static String l;
  private static String m;
  private static int n = -1;
  private static String o = null;
  private boolean c = false;
  private Context e;
  private volatile boolean f = true;
  private a g;
  private com.gau.go.gostaticsdk.c.f h;
  private f i;
  private Object j;
  private long k = 0L;
  private com.gau.go.gostaticsdk.e.a p;
  private boolean q = false;
  private b r;
  private BroadcastReceiver s = new e(this);
  
  private d(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException("context can not be null");
    }
    this.e = paramContext;
    d = this;
    com.gau.go.gostaticsdk.f.a.a(paramContext);
    this.h = new com.gau.go.gostaticsdk.c.f(paramContext);
    this.g = new a();
    this.i = new f(this, null);
    this.j = new Object();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    this.e.registerReceiver(this.s, localIntentFilter);
    d();
    this.r = new b(paramContext);
    e();
  }
  
  /* Error */
  public static d a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +29 -> 33
    //   7: getstatic 81	com/gau/go/gostaticsdk/d:d	Lcom/gau/go/gostaticsdk/d;
    //   10: ifnonnull +23 -> 33
    //   13: aload_0
    //   14: invokevirtual 135	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   17: astore_1
    //   18: aload_1
    //   19: ifnull +23 -> 42
    //   22: new 2	com/gau/go/gostaticsdk/d
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 136	com/gau/go/gostaticsdk/d:<init>	(Landroid/content/Context;)V
    //   30: putstatic 81	com/gau/go/gostaticsdk/d:d	Lcom/gau/go/gostaticsdk/d;
    //   33: getstatic 81	com/gau/go/gostaticsdk/d:d	Lcom/gau/go/gostaticsdk/d;
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: areturn
    //   42: new 2	com/gau/go/gostaticsdk/d
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 136	com/gau/go/gostaticsdk/d:<init>	(Landroid/content/Context;)V
    //   50: putstatic 81	com/gau/go/gostaticsdk/d:d	Lcom/gau/go/gostaticsdk/d;
    //   53: goto -20 -> 33
    //   56: astore_0
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_0
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramContext	Context
    //   17	10	1	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   7	18	56	finally
    //   22	33	56	finally
    //   33	37	56	finally
    //   42	53	56	finally
  }
  
  public static String b(Context paramContext)
  {
    if (d == null) {
      d = a(paramContext);
    }
    d locald = d;
    if (l == null)
    {
      locald = d;
      l = com.gau.go.gostaticsdk.f.d.e(paramContext);
    }
    paramContext = d;
    return l;
  }
  
  private void b(com.gau.go.gostaticsdk.a.a parama)
  {
    if ((parama != null) && (this.e != null))
    {
      com.gau.go.gostaticsdk.b.d.a(this.e, parama.a).a(parama);
      if (parama.f == 3) {
        com.gau.go.gostaticsdk.f.d.a("StatisticsManager", "a request has been posted");
      }
    }
    else
    {
      return;
    }
    com.gau.go.gostaticsdk.f.d.a("StatisticsManager", "post fundid:" + parama.a + " failed!");
  }
  
  private void c(com.gau.go.gostaticsdk.a.a parama)
  {
    if (c.e(this.e)) {
      this.g.a(parama);
    }
  }
  
  private void d()
  {
    if ((this.e.getPackageManager().equals("com.gau.go.launcherex")) && (c.h(this.e)) && (Build.VERSION.SDK_INT > 7)) {
      this.p = new com.gau.go.gostaticsdk.e.a(this.e);
    }
  }
  
  private void e()
  {
    try
    {
      if ((this.e != null) && (c.e(this.e)))
      {
        if (this.f)
        {
          this.f = false;
          this.i.a();
          com.gau.go.gostaticsdk.f.d.a("StatisticsManager", "start loop task");
          return;
        }
        com.gau.go.gostaticsdk.f.d.a("StatisticsManager", "task already running");
        return;
      }
    }
    catch (Exception localException) {}
  }
  
  private void f()
  {
    if (this.f) {
      this.g.b();
    }
  }
  
  private void g()
  {
    com.gau.go.gostaticsdk.f.d.a("StatisticsManager", "checkPostTask");
    if (h()) {
      e();
    }
  }
  
  private boolean h()
  {
    synchronized (this.j)
    {
      long l1 = System.currentTimeMillis();
      if (l1 - this.k > 10000L)
      {
        this.k = l1;
        LinkedList localLinkedList = this.h.a();
        if ((localLinkedList != null) && (!localLinkedList.isEmpty()))
        {
          this.g.a(localLinkedList);
          return true;
        }
      }
      return false;
    }
  }
  
  private void i()
  {
    Object localObject = this.e.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(this.e.getPackageName(), 0);
      n = ((PackageInfo)localObject).versionCode;
      o = ((PackageInfo)localObject).versionName;
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
  }
  
  public StringBuffer a(com.gau.go.gostaticsdk.a.a parama)
  {
    Object localObject1 = null;
    if (this.e == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(parama.a);
    localStringBuffer.append("||");
    localStringBuffer.append(parama.e);
    localStringBuffer.append("||");
    localStringBuffer.append(c.g(this.e));
    localStringBuffer.append("||");
    if ((parama.r == null) || (parama.r.trim().equals(""))) {
      parama.r = com.gau.go.gostaticsdk.f.d.a(parama.b);
    }
    localStringBuffer.append(parama.r);
    localStringBuffer.append("||");
    localStringBuffer.append(Build.VERSION.RELEASE);
    localStringBuffer.append("||");
    localStringBuffer.append(Build.VERSION.INCREMENTAL);
    localStringBuffer.append("||");
    localStringBuffer.append(Build.MODEL);
    localStringBuffer.append("||");
    if ((m == null) || (m.trim().equals(""))) {
      m = c.c(this.e);
    }
    localStringBuffer.append(m);
    localStringBuffer.append("||");
    if (parama.c != null)
    {
      parama.c = parama.c.replaceAll("\r\n", "");
      parama.c = parama.c.replaceAll("\n", "");
    }
    localStringBuffer.append(parama.c);
    localStringBuffer.append("||");
    Object localObject2 = this.e.getPackageManager();
    if ((n == -1) || (o == null)) {
      i();
    }
    localStringBuffer.append(n);
    localStringBuffer.append("||");
    localStringBuffer.append(o);
    localStringBuffer.append("||");
    int i1;
    Intent localIntent;
    if (c.d(this.e))
    {
      i1 = 2;
      localStringBuffer.append(i1);
      localStringBuffer.append("||");
      localStringBuffer.append(c.a(this.e));
      localStringBuffer.append("||");
      localStringBuffer.append(c.b(this.e));
      localStringBuffer.append("||");
      localStringBuffer.append(parama.d);
      localStringBuffer.append("||");
      localIntent = new Intent("com.gau.go.launcherex.MAIN");
    }
    try
    {
      localObject2 = ((PackageManager)localObject2).queryIntentActivities(localIntent, 0);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label494:
      label660:
      for (;;) {}
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localStringBuffer.append(1);
      localStringBuffer.append("||");
      if (l == null) {
        l = com.gau.go.gostaticsdk.f.d.e(this.e);
      }
      localStringBuffer.append(l);
      if (!parama.s) {
        break label660;
      }
      localStringBuffer.append("||");
      localStringBuffer.append(c.a());
    }
    for (;;)
    {
      localStringBuffer.append("||");
      localStringBuffer.append(com.gau.go.gostaticsdk.f.d.a(parama.t));
      localStringBuffer.append("||");
      localStringBuffer.append(c());
      localStringBuffer.append("||");
      localStringBuffer.append(b());
      localStringBuffer.append("||");
      localStringBuffer.append(parama.u);
      com.gau.go.gostaticsdk.f.d.a("StatisticsManager", localStringBuffer.toString());
      return localStringBuffer;
      i1 = 1;
      break;
      localStringBuffer.append(0);
      break label494;
      localStringBuffer.append("||");
      localStringBuffer.append("-1");
    }
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      a(null, paramString, 3);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (paramString2 != null)
    {
      com.gau.go.gostaticsdk.a.a locala = new com.gau.go.gostaticsdk.a.a();
      locala.q = paramInt;
      locala.p = paramString1;
      locala.b = System.currentTimeMillis();
      locala.h = paramString2;
      this.h.a(locala);
      c(locala);
      e();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2)
  {
    com.gau.go.gostaticsdk.a.a locala = new com.gau.go.gostaticsdk.a.a();
    locala.a = 19;
    locala.b = System.currentTimeMillis();
    locala.c = paramString2;
    locala.d = paramString3;
    locala.e = paramString1;
    locala.s = paramBoolean1;
    locala.u = paramString4;
    locala.t = paramBoolean2;
    locala.q = 3;
    locala.h = a(locala).toString();
    this.h.a(locala);
    c(locala);
    e();
  }
  
  public void a(boolean paramBoolean)
  {
    com.gau.go.gostaticsdk.f.d.b(paramBoolean);
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public String b()
  {
    if (this.q) {
      return this.r.a();
    }
    return "-1";
  }
  
  protected void b(String paramString)
  {
    if (this.r != null) {
      this.r.a(paramString);
    }
  }
  
  public String c()
  {
    if (this.q) {
      return this.r.b();
    }
    return "-1";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */