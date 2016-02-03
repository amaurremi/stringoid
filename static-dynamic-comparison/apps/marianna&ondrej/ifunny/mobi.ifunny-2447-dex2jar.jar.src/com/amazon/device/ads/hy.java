package com.amazon.device.ads;

import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

abstract class hy {
    private static final String m = hy.class.getSimpleName();
    private static id w = new id();
    String a = null;
    String b = null;
    String c = null;
    String d = null;
    protected final HashMap<String, String> e = new HashMap();
    protected ib f = new ib();
    protected HashMap<String, String> g = new HashMap();
    boolean h = false;
    boolean i = false;
    protected boolean j = false;
    protected boolean k = false;
    protected eb l;
    private String n = null;
    private String o = null;
    private String p = null;
    private String q = null;
    private int r = -1;
    private ia s = ia.a;
    private int t = 20000;
    private ec u;
    private String v = m;

    public static final hy c() {
        return w.a();
    }

    public static final hy d() {
        hy localhy = c();
        localhy.a(ia.a);
        localhy.c("Accept", "application/json");
        return localhy;
    }

    public static final void j(String paramString) {
        ho.a(new hz(paramString));
    }

    protected abstract if

    a(URL paramURL);

    public String a(String paramString1, String paramString2) {
        return this.f.b(paramString1, paramString2);
    }

    public void a(int paramInt) {
        this.t = paramInt;
    }

    public void a(eb parameb) {
        this.l = parameb;
    }

    public void a(ec paramec) {
        this.u = paramec;
    }

    public void a(ia paramia) {
        if (paramia == null) {
            throw new IllegalArgumentException("The httpMethod must not be null.");
        }
        this.s = paramia;
    }

    public void a(ib paramib) {
        this.f = paramib;
    }

    protected void a(String paramString) {
        if (this.j) {
            dv.a(n(), "%s %s", new Object[]{f(), paramString});
        }
    }

    protected void a(StringBuilder paramStringBuilder) {
        this.f.a(paramStringBuilder);
    }

    public void a(boolean paramBoolean) {
        this.j = paramBoolean;
    }

    protected abstract String b();

    protected void b(eb parameb) {
        if ((parameb != null) && (this.u != null)) {
            this.u.b(parameb);
        }
    }

    public void b(String paramString) {
        if (hu.d(paramString)) {
            throw new IllegalArgumentException("The host must not be null.");
        }
        this.o = paramString;
        this.p = paramString;
    }

    public void b(String paramString1, String paramString2) {
        if (hu.d(paramString1)) {
            throw new IllegalArgumentException("The name must not be null or empty string.");
        }
        if (paramString2 == null) {
            this.g.remove(paramString1);
            return;
        }
        this.g.put(paramString1, paramString2);
    }

    public void b(boolean paramBoolean) {
        this.h = paramBoolean;
    }

    protected URI c(URL paramURL) {
        return paramURL.toURI();
    }

    protected void c(eb parameb) {
        if ((parameb != null) && (this.u != null)) {
            this.u.c(parameb);
        }
    }

    public void c(String paramString) {
        this.q = paramString;
    }

    public void c(String paramString1, String paramString2) {
        if (hu.d(paramString1)) {
            throw new IllegalArgumentException("The name must not be null or empty string.");
        }
        this.e.put(paramString1, paramString2);
    }

    public void c(boolean paramBoolean) {
        this.i = paramBoolean;
    }

    public void d(String paramString) {
        String str = paramString;
        if (paramString != null) {
            str = paramString;
            if (this.k) {
                str = paramString;
                if (paramString.startsWith("http:")) {
                    str = paramString.replaceFirst("http", "https");
                }
            }
        }
        this.n = str;
    }

    public void d(boolean paramBoolean) {
        a(paramBoolean);
        b(paramBoolean);
        c(paramBoolean);
    }
  
  /* Error */
    public if

    e() {
        // Byte code:
        //   0: invokestatic 235	com/amazon/device/ads/ho:a	()Z
        //   3: ifeq +12 -> 15
        //   6: aload_0
        //   7: getfield 92	com/amazon/device/ads/hy:v	Ljava/lang/String;
        //   10: ldc -19
        //   12: invokestatic 238	com/amazon/device/ads/dv:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   15: aload_0
        //   16: invokevirtual 240	com/amazon/device/ads/hy:o	()V
        //   19: aload_0
        //   20: invokevirtual 242	com/amazon/device/ads/hy:q	()Ljava/lang/String;
        //   23: astore_1
        //   24: aload_0
        //   25: aload_1
        //   26: invokevirtual 245	com/amazon/device/ads/hy:i	(Ljava/lang/String;)Ljava/net/URL;
        //   29: astore_2
        //   30: aload_0
        //   31: aload_0
        //   32: getfield 152	com/amazon/device/ads/hy:l	Lcom/amazon/device/ads/eb;
        //   35: invokevirtual 246	com/amazon/device/ads/hy:b	(Lcom/amazon/device/ads/eb;)V
        //   38: aload_0
        //   39: aload_2
        //   40: invokevirtual 248	com/amazon/device/ads/hy:a	(Ljava/net/URL;)Lcom/amazon/device/ads/if;
        //   43: astore_1
        //   44: aload_0
        //   45: aload_0
        //   46: getfield 152	com/amazon/device/ads/hy:l	Lcom/amazon/device/ads/eb;
        //   49: invokevirtual 249	com/amazon/device/ads/hy:c	(Lcom/amazon/device/ads/eb;)V
        //   52: aload_1
        //   53: areturn
        //   54: astore_2
        //   55: aload_0
        //   56: getfield 92	com/amazon/device/ads/hy:v	Ljava/lang/String;
        //   59: ldc -5
        //   61: iconst_1
        //   62: anewarray 4	java/lang/Object
        //   65: dup
        //   66: iconst_0
        //   67: aload_2
        //   68: invokevirtual 254	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
        //   71: aastore
        //   72: invokestatic 256	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   75: new 232	com/amazon/device/ads/ic
        //   78: dup
        //   79: aload_0
        //   80: getstatic 261	com/amazon/device/ads/ie:c	Lcom/amazon/device/ads/ie;
        //   83: new 263	java/lang/StringBuilder
        //   86: dup
        //   87: invokespecial 264	java/lang/StringBuilder:<init>	()V
        //   90: ldc_w 266
        //   93: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   96: aload_1
        //   97: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   100: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   103: aload_2
        //   104: invokespecial 276	com/amazon/device/ads/ic:<init>	(Lcom/amazon/device/ads/hy;Lcom/amazon/device/ads/ie;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   107: athrow
        //   108: astore_1
        //   109: aload_1
        //   110: athrow
        //   111: astore_1
        //   112: aload_0
        //   113: aload_0
        //   114: getfield 152	com/amazon/device/ads/hy:l	Lcom/amazon/device/ads/eb;
        //   117: invokevirtual 249	com/amazon/device/ads/hy:c	(Lcom/amazon/device/ads/eb;)V
        //   120: aload_1
        //   121: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	122	0	this	hy
        //   23	74	1	localObject1	Object
        //   108	2	1	localic	ic
        //   111	10	1	localObject2	Object
        //   29	11	2	localURL	URL
        //   54	50	2	localMalformedURLException	java.net.MalformedURLException
        // Exception table:
        //   from	to	target	type
        //   24	30	54	java/net/MalformedURLException
        //   38	44	108	com/amazon/device/ads/ic
        //   38	44	111	finally
        //   109	111	111	finally
    }

    public void e(String paramString) {
        this.a = paramString;
    }

    public void e(boolean paramBoolean) {
        this.k = paramBoolean;
    }

    public ia f() {
        return this.s;
    }

    public void f(String paramString) {
        this.c = paramString;
    }

    public String g() {
        if (this.k) {
            return this.o;
        }
        return this.p;
    }

    public void g(String paramString) {
        this.f.a(paramString);
    }

    public int h() {
        return this.r;
    }

    public void h(String paramString) {
        if (paramString == null) {
            this.v = (m + " " + b());
            return;
        }
        this.v = (paramString + " " + m + " " + b());
    }

    public String i() {
        return this.q;
    }

    protected URL i(String paramString) {
        return new URL(paramString);
    }

    public boolean j() {
        return this.k;
    }

    public String k() {
        return this.a;
    }

    public String l() {
        if (k() != null) {
            return k();
        }
        if (this.g.isEmpty()) {
            return null;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator = this.g.entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            localStringBuilder.append((String) localEntry.getKey()).append('=').append((String) localEntry.getValue()).append(";\n");
        }
        return localStringBuilder.toString();
    }

    public int m() {
        return this.t;
    }

    protected String n() {
        return this.v;
    }

    protected void o() {
        if (this.b != null) {
            c("Accept", this.c);
        }
        if (this.c != null) {
            String str2 = this.c;
            String str1 = str2;
            if (this.d != null) {
                str1 = str2 + "; charset=" + this.d;
            }
            c("Content-Type", str1);
        }
    }

    protected String p() {
        if (j()) {
            return "https";
        }
        return "http";
    }

    protected String q() {
        if (this.n != null) {
            return this.n;
        }
        StringBuilder localStringBuilder = new StringBuilder(p());
        localStringBuilder.append("://");
        localStringBuilder.append(g());
        if (h() != -1) {
            localStringBuilder.append(":");
            localStringBuilder.append(h());
        }
        localStringBuilder.append(i());
        a(localStringBuilder);
        return localStringBuilder.toString();
    }

    public String toString() {
        return q();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/hy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */