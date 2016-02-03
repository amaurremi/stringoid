package com.android.a;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

public abstract class p
  implements Comparable
{
  private final ac a;
  private final int b;
  private final String c;
  private final int d;
  private final u e;
  private Integer f;
  private s g;
  private boolean h;
  private boolean i;
  private boolean j;
  private long k;
  private x l;
  private c m;
  private Object n;
  
  public p(int paramInt, String paramString, u paramu)
  {
    ac localac;
    if (ac.a)
    {
      localac = new ac();
      this.a = localac;
      this.h = true;
      this.i = false;
      this.j = false;
      this.k = 0L;
      this.m = null;
      this.b = paramInt;
      this.c = paramString;
      this.e = paramu;
      a(new f());
      if (!TextUtils.isEmpty(paramString)) {
        break label97;
      }
    }
    label97:
    for (paramInt = 0;; paramInt = Uri.parse(paramString).getHost().hashCode())
    {
      this.d = paramInt;
      return;
      localac = null;
      break;
    }
  }
  
  /* Error */
  private byte[] a(Map paramMap, String paramString)
  {
    // Byte code:
    //   0: new 95	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_1
    //   9: invokeinterface 102 1 0
    //   14: invokeinterface 108 1 0
    //   19: astore_1
    //   20: aload_1
    //   21: invokeinterface 114 1 0
    //   26: ifne +12 -> 38
    //   29: aload_3
    //   30: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: aload_2
    //   34: invokevirtual 121	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   37: areturn
    //   38: aload_1
    //   39: invokeinterface 125 1 0
    //   44: checkcast 127	java/util/Map$Entry
    //   47: astore 4
    //   49: aload_3
    //   50: aload 4
    //   52: invokeinterface 130 1 0
    //   57: checkcast 85	java/lang/String
    //   60: aload_2
    //   61: invokestatic 136	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   64: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_3
    //   69: bipush 61
    //   71: invokevirtual 143	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_3
    //   76: aload 4
    //   78: invokeinterface 146 1 0
    //   83: checkcast 85	java/lang/String
    //   86: aload_2
    //   87: invokestatic 136	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   90: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_3
    //   95: bipush 38
    //   97: invokevirtual 143	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: goto -81 -> 20
    //   104: astore_1
    //   105: new 148	java/lang/RuntimeException
    //   108: dup
    //   109: new 95	java/lang/StringBuilder
    //   112: dup
    //   113: ldc -106
    //   115: invokespecial 153	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   118: aload_2
    //   119: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aload_1
    //   126: invokespecial 156	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	p
    //   0	130	1	paramMap	Map
    //   0	130	2	paramString	String
    //   7	88	3	localStringBuilder	StringBuilder
    //   47	30	4	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   8	20	104	java/io/UnsupportedEncodingException
    //   20	38	104	java/io/UnsupportedEncodingException
    //   38	101	104	java/io/UnsupportedEncodingException
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int a(p paramp)
  {
    r localr1 = s();
    r localr2 = paramp.s();
    if (localr1 == localr2) {
      return this.f.intValue() - paramp.f.intValue();
    }
    return localr2.ordinal() - localr1.ordinal();
  }
  
  protected aa a(aa paramaa)
  {
    return paramaa;
  }
  
  protected abstract t a(m paramm);
  
  public final void a(int paramInt)
  {
    this.f = Integer.valueOf(paramInt);
  }
  
  public void a(c paramc)
  {
    this.m = paramc;
  }
  
  public void a(s params)
  {
    this.g = params;
  }
  
  public void a(x paramx)
  {
    this.l = paramx;
  }
  
  public void a(Object paramObject)
  {
    this.n = paramObject;
  }
  
  public void a(String paramString)
  {
    if (ac.a) {
      this.a.a(paramString, Thread.currentThread().getId());
    }
    while (this.k != 0L) {
      return;
    }
    this.k = SystemClock.elapsedRealtime();
  }
  
  public final void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public Object b()
  {
    return this.n;
  }
  
  public void b(aa paramaa)
  {
    if (this.e != null) {
      this.e.a(paramaa);
    }
  }
  
  protected abstract void b(Object paramObject);
  
  void b(String paramString)
  {
    if (this.g != null) {
      this.g.b(this);
    }
    long l1;
    if (ac.a)
    {
      l1 = Thread.currentThread().getId();
      if (Looper.myLooper() != Looper.getMainLooper()) {
        new Handler(Looper.getMainLooper()).post(new q(this, paramString, l1));
      }
    }
    do
    {
      return;
      this.a.a(paramString, l1);
      this.a.a(toString());
      return;
      l1 = SystemClock.elapsedRealtime() - this.k;
    } while (l1 < 3000L);
    ab.b("%d ms: %s", new Object[] { Long.valueOf(l1), toString() });
  }
  
  public int c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public String e()
  {
    return d();
  }
  
  public c f()
  {
    return this.m;
  }
  
  public void g()
  {
    this.i = true;
  }
  
  public boolean h()
  {
    return this.i;
  }
  
  public Map i()
  {
    return Collections.emptyMap();
  }
  
  protected Map j()
  {
    return n();
  }
  
  protected String k()
  {
    return o();
  }
  
  public String l()
  {
    return p();
  }
  
  public byte[] m()
  {
    Map localMap = j();
    if ((localMap != null) && (localMap.size() > 0)) {
      return a(localMap, k());
    }
    return null;
  }
  
  protected Map n()
  {
    return null;
  }
  
  protected String o()
  {
    return "UTF-8";
  }
  
  public String p()
  {
    return "application/x-www-form-urlencoded; charset=" + o();
  }
  
  public byte[] q()
  {
    Map localMap = n();
    if ((localMap != null) && (localMap.size() > 0)) {
      return a(localMap, o());
    }
    return null;
  }
  
  public final boolean r()
  {
    return this.h;
  }
  
  public r s()
  {
    return r.b;
  }
  
  public final int t()
  {
    return this.l.a();
  }
  
  public String toString()
  {
    String str2 = "0x" + Integer.toHexString(c());
    if (this.i) {}
    for (String str1 = "[X] ";; str1 = "[ ] ") {
      return str1 + d() + " " + str2 + " " + s() + " " + this.f;
    }
  }
  
  public x u()
  {
    return this.l;
  }
  
  public void v()
  {
    this.j = true;
  }
  
  public boolean w()
  {
    return this.j;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */