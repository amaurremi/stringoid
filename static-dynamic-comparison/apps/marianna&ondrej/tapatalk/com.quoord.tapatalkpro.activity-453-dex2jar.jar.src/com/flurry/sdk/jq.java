package com.flurry.sdk;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;

public class jq
        extends hn {
    protected static final iu<? extends ir> a = mx.i;
    protected static final iq b = new my();
    protected static final ne<?> c = ne.a.a();
    private static final sh n = qp.d(hh.class);
    protected final hd d;
    protected ng e;
    protected qs f;
    protected jf g;
    protected ju h;
    protected jw i;
    protected jv j;
    protected iy k;
    protected jc l;
    protected final ConcurrentHashMap<sh, jg<Object>> m = new ConcurrentHashMap(64, 0.6F, 2);

    public jq() {
        this(null, null, null);
    }

    public jq(hd paramhd) {
        this(paramhd, null, null);
    }

    public jq(hd paramhd, jw paramjw, jc paramjc) {
        this(paramhd, paramjw, paramjc, null, null);
    }

    public jq(hd paramhd, jw paramjw, jc paramjc, ju paramju, iy paramiy) {
        if (paramhd == null) {
            this.d = new jo(this);
            this.f = qs.a();
            if (paramju == null) {
                break label135;
            }
            label48:
            this.h = paramju;
            if (paramiy == null) {
                break label163;
            }
        }
        for (; ; ) {
            this.k = paramiy;
            paramhd = paramjw;
            if (paramjw == null) {
                paramhd = new or();
            }
            this.i = paramhd;
            paramhd = paramjc;
            if (paramjc == null) {
                paramhd = new kv();
            }
            this.l = paramhd;
            this.j = ol.e;
            return;
            this.d = paramhd;
            if (paramhd.a() != null) {
                break;
            }
            this.d.a(this);
            break;
            label135:
            paramju = new ju(a, b, c, null, null, this.f, null);
            break label48;
            label163:
            paramiy = new iy(a, b, c, null, null, this.f, null);
        }
    }

    /* Error */
    private final void a(hf paramhf, Object paramObject, ju paramju)
            throws IOException, he, jh {
        // Byte code:
        //   0: aload_2
        //   1: checkcast 146	java/io/Closeable
        //   4: astore 4
        //   6: aload_0
        //   7: getfield 109	com/flurry/sdk/jq:i	Lcom/flurry/sdk/jw;
        //   10: aload_3
        //   11: aload_1
        //   12: aload_2
        //   13: aload_0
        //   14: getfield 121	com/flurry/sdk/jq:j	Lcom/flurry/sdk/jv;
        //   17: invokevirtual 151	com/flurry/sdk/jw:a	(Lcom/flurry/sdk/ju;Lcom/flurry/sdk/hf;Ljava/lang/Object;Lcom/flurry/sdk/jv;)V
        //   20: aload_1
        //   21: invokevirtual 156	com/flurry/sdk/hf:close	()V
        //   24: aload 4
        //   26: invokeinterface 157 1 0
        //   31: iconst_0
        //   32: ifeq +11 -> 43
        //   35: new 159	java/lang/NullPointerException
        //   38: dup
        //   39: invokespecial 160	java/lang/NullPointerException:<init>	()V
        //   42: athrow
        //   43: iconst_0
        //   44: ifeq +11 -> 55
        //   47: new 159	java/lang/NullPointerException
        //   50: dup
        //   51: invokespecial 160	java/lang/NullPointerException:<init>	()V
        //   54: athrow
        //   55: return
        //   56: astore_3
        //   57: aload 4
        //   59: astore_2
        //   60: aload_3
        //   61: astore 4
        //   63: aload_1
        //   64: astore_3
        //   65: aload 4
        //   67: astore_1
        //   68: aload_3
        //   69: ifnull +7 -> 76
        //   72: aload_3
        //   73: invokevirtual 156	com/flurry/sdk/hf:close	()V
        //   76: aload_2
        //   77: ifnull +9 -> 86
        //   80: aload_2
        //   81: invokeinterface 157 1 0
        //   86: aload_1
        //   87: athrow
        //   88: astore_1
        //   89: goto -46 -> 43
        //   92: astore_1
        //   93: return
        //   94: astore_3
        //   95: goto -19 -> 76
        //   98: astore_2
        //   99: goto -13 -> 86
        //   102: astore_1
        //   103: aconst_null
        //   104: astore_3
        //   105: aload 4
        //   107: astore_2
        //   108: goto -40 -> 68
        //   111: astore_1
        //   112: aconst_null
        //   113: astore_2
        //   114: aconst_null
        //   115: astore_3
        //   116: goto -48 -> 68
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	119	0	this	jq
        //   0	119	1	paramhf	hf
        //   0	119	2	paramObject	Object
        //   0	119	3	paramju	ju
        //   4	102	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   6	20	56	finally
        //   35	43	88	java/io/IOException
        //   47	55	92	java/io/IOException
        //   72	76	94	java/io/IOException
        //   80	86	98	java/io/IOException
        //   20	24	102	finally
        //   24	31	111	finally
    }

    /* Error */
    private final void b(hf paramhf, Object paramObject, ju paramju)
            throws IOException, he, jh {
        // Byte code:
        //   0: aload_2
        //   1: checkcast 146	java/io/Closeable
        //   4: astore 4
        //   6: aload_0
        //   7: getfield 109	com/flurry/sdk/jq:i	Lcom/flurry/sdk/jw;
        //   10: aload_3
        //   11: aload_1
        //   12: aload_2
        //   13: aload_0
        //   14: getfield 121	com/flurry/sdk/jq:j	Lcom/flurry/sdk/jv;
        //   17: invokevirtual 151	com/flurry/sdk/jw:a	(Lcom/flurry/sdk/ju;Lcom/flurry/sdk/hf;Ljava/lang/Object;Lcom/flurry/sdk/jv;)V
        //   20: aload_3
        //   21: getstatic 167	com/flurry/sdk/ju$a:p	Lcom/flurry/sdk/ju$a;
        //   24: invokevirtual 170	com/flurry/sdk/ju:a	(Lcom/flurry/sdk/ju$a;)Z
        //   27: ifeq +7 -> 34
        //   30: aload_1
        //   31: invokevirtual 172	com/flurry/sdk/hf:g	()V
        //   34: aconst_null
        //   35: astore_2
        //   36: aload 4
        //   38: invokeinterface 157 1 0
        //   43: iconst_0
        //   44: ifeq +11 -> 55
        //   47: new 159	java/lang/NullPointerException
        //   50: dup
        //   51: invokespecial 160	java/lang/NullPointerException:<init>	()V
        //   54: athrow
        //   55: return
        //   56: astore_1
        //   57: aload 4
        //   59: astore_2
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_2
        //   65: invokeinterface 157 1 0
        //   70: aload_1
        //   71: athrow
        //   72: astore_1
        //   73: return
        //   74: astore_2
        //   75: goto -5 -> 70
        //   78: astore_1
        //   79: goto -19 -> 60
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	jq
        //   0	82	1	paramhf	hf
        //   0	82	2	paramObject	Object
        //   0	82	3	paramju	ju
        //   4	54	4	localCloseable	Closeable
        // Exception table:
        //   from	to	target	type
        //   6	34	56	finally
        //   47	55	72	java/io/IOException
        //   64	70	74	java/io/IOException
        //   36	43	78	finally
    }

    public hh a(hj paramhj)
            throws IOException, hk {
        Object localObject = b();
        if ((paramhj.e() == null) && (paramhj.b() == null)) {
            paramhj = null;
        }
        do {
            return paramhj;
            localObject = (hh) a((iy) localObject, paramhj, n);
            paramhj = (hj) localObject;
        } while (localObject != null);
        return c().a();
    }

    protected iz a(hj paramhj, iy paramiy) {
        return new ku(paramiy, paramhj, this.l, this.g);
    }

    protected jg<Object> a(iy paramiy, sh paramsh)
            throws jh {
        jg localjg = (jg) this.m.get(paramsh);
        if (localjg != null) {
            return localjg;
        }
        paramiy = this.l.b(paramiy, paramsh, null);
        if (paramiy == null) {
            throw new jh("Can not find a deserializer for type " + paramsh);
        }
        this.m.put(paramsh, paramiy);
        return paramiy;
    }

    public jq a(ju.a parama, boolean paramBoolean) {
        this.h.a(parama, paramBoolean);
        return this;
    }

    public ju a() {
        return this.h.a(this.e);
    }

    /* Error */
    protected Object a(hj paramhj, sh paramsh)
            throws IOException, hi, jh {
        // Byte code:
        //   0: aload_0
        //   1: aload_1
        //   2: invokevirtual 257	com/flurry/sdk/jq:b	(Lcom/flurry/sdk/hj;)Lcom/flurry/sdk/hm;
        //   5: astore_3
        //   6: aload_3
        //   7: getstatic 262	com/flurry/sdk/hm:m	Lcom/flurry/sdk/hm;
        //   10: if_acmpne +26 -> 36
        //   13: aload_0
        //   14: aload_0
        //   15: getfield 104	com/flurry/sdk/jq:k	Lcom/flurry/sdk/iy;
        //   18: aload_2
        //   19: invokevirtual 264	com/flurry/sdk/jq:a	(Lcom/flurry/sdk/iy;Lcom/flurry/sdk/sh;)Lcom/flurry/sdk/jg;
        //   22: invokevirtual 267	com/flurry/sdk/jg:b	()Ljava/lang/Object;
        //   25: astore_2
        //   26: aload_1
        //   27: invokevirtual 269	com/flurry/sdk/hj:f	()V
        //   30: aload_1
        //   31: invokevirtual 270	com/flurry/sdk/hj:close	()V
        //   34: aload_2
        //   35: areturn
        //   36: aload_3
        //   37: getstatic 272	com/flurry/sdk/hm:e	Lcom/flurry/sdk/hm;
        //   40: if_acmpeq +84 -> 124
        //   43: aload_3
        //   44: getstatic 274	com/flurry/sdk/hm:c	Lcom/flurry/sdk/hm;
        //   47: if_acmpne +6 -> 53
        //   50: goto +74 -> 124
        //   53: aload_0
        //   54: invokevirtual 178	com/flurry/sdk/jq:b	()Lcom/flurry/sdk/iy;
        //   57: astore_3
        //   58: aload_0
        //   59: aload_1
        //   60: aload_3
        //   61: invokevirtual 276	com/flurry/sdk/jq:a	(Lcom/flurry/sdk/hj;Lcom/flurry/sdk/iy;)Lcom/flurry/sdk/iz;
        //   64: astore 4
        //   66: aload_0
        //   67: aload_3
        //   68: aload_2
        //   69: invokevirtual 264	com/flurry/sdk/jq:a	(Lcom/flurry/sdk/iy;Lcom/flurry/sdk/sh;)Lcom/flurry/sdk/jg;
        //   72: astore 5
        //   74: aload_3
        //   75: getstatic 281	com/flurry/sdk/iy$a:p	Lcom/flurry/sdk/iy$a;
        //   78: invokevirtual 284	com/flurry/sdk/iy:a	(Lcom/flurry/sdk/iy$a;)Z
        //   81: ifeq +17 -> 98
        //   84: aload_0
        //   85: aload_1
        //   86: aload_2
        //   87: aload 4
        //   89: aload 5
        //   91: invokevirtual 287	com/flurry/sdk/jq:a	(Lcom/flurry/sdk/hj;Lcom/flurry/sdk/sh;Lcom/flurry/sdk/iz;Lcom/flurry/sdk/jg;)Ljava/lang/Object;
        //   94: astore_2
        //   95: goto -69 -> 26
        //   98: aload 5
        //   100: aload_1
        //   101: aload 4
        //   103: invokevirtual 290	com/flurry/sdk/jg:a	(Lcom/flurry/sdk/hj;Lcom/flurry/sdk/iz;)Ljava/lang/Object;
        //   106: astore_2
        //   107: goto -81 -> 26
        //   110: astore_2
        //   111: aload_1
        //   112: invokevirtual 270	com/flurry/sdk/hj:close	()V
        //   115: aload_2
        //   116: athrow
        //   117: astore_1
        //   118: aload_2
        //   119: areturn
        //   120: astore_1
        //   121: goto -6 -> 115
        //   124: aconst_null
        //   125: astore_2
        //   126: goto -100 -> 26
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	129	0	this	jq
        //   0	129	1	paramhj	hj
        //   0	129	2	paramsh	sh
        //   5	70	3	localObject	Object
        //   64	38	4	localiz	iz
        //   72	27	5	localjg	jg
        // Exception table:
        //   from	to	target	type
        //   0	26	110	finally
        //   26	30	110	finally
        //   36	50	110	finally
        //   53	95	110	finally
        //   98	107	110	finally
        //   30	34	117	java/io/IOException
        //   111	115	120	java/io/IOException
    }

    protected Object a(hj paramhj, sh paramsh, iz paramiz, jg<Object> paramjg)
            throws IOException, hi, jh {
        im localim = this.l.a(paramiz.a(), paramsh);
        if (paramhj.e() != hm.b) {
            throw jh.a(paramhj, "Current token not START_OBJECT (needed to unwrap root name '" + localim + "'), but " + paramhj.e());
        }
        if (paramhj.b() != hm.f) {
            throw jh.a(paramhj, "Current token not FIELD_NAME (to contain expected root name '" + localim + "'), but " + paramhj.e());
        }
        String str = paramhj.g();
        if (!localim.a().equals(str)) {
            throw jh.a(paramhj, "Root name '" + str + "' does not match expected ('" + localim + "') for type " + paramsh);
        }
        paramhj.b();
        paramsh = paramjg.a(paramhj, paramiz);
        if (paramhj.b() != hm.c) {
            throw jh.a(paramhj, "Current token not END_OBJECT (to match wrapper object with root name '" + localim + "'), but " + paramhj.e());
        }
        return paramsh;
    }

    protected Object a(iy paramiy, hj paramhj, sh paramsh)
            throws IOException, hi, jh {
        Object localObject = b(paramhj);
        if (localObject == hm.m) {
            paramiy = a(paramiy, paramsh).b();
        }
        for (; ; ) {
            paramhj.f();
            return paramiy;
            if ((localObject == hm.e) || (localObject == hm.c)) {
                paramiy = null;
            } else {
                localObject = a(paramhj, paramiy);
                jg localjg = a(paramiy, paramsh);
                if (paramiy.a(iy.a.p)) {
                    paramiy = a(paramhj, paramsh, (iz) localObject, localjg);
                } else {
                    paramiy = localjg.a(paramhj, (iz) localObject);
                }
            }
        }
    }

    public <T> T a(InputStream paramInputStream, Class<T> paramClass)
            throws IOException, hi, jh {
        return (T) a(this.d.a(paramInputStream), this.f.a(paramClass));
    }

    public String a(Object paramObject)
            throws IOException, he, jh {
        il localil = new il(this.d.b());
        b(this.d.a(localil), paramObject);
        return localil.a();
    }

    public void a(hf paramhf, hh paramhh)
            throws IOException, hk {
        ju localju = a();
        this.i.a(localju, paramhf, paramhh, this.j);
        if (localju.a(ju.a.p)) {
            paramhf.g();
        }
    }

    public void a(hf paramhf, Object paramObject)
            throws IOException, he, jh {
        ju localju = a();
        if ((localju.a(ju.a.o)) && ((paramObject instanceof Closeable))) {
            b(paramhf, paramObject, localju);
        }
        do {
            return;
            this.i.a(localju, paramhf, paramObject, this.j);
        } while (!localju.a(ju.a.p));
        paramhf.g();
    }

    public void a(jp paramjp) {
        if (paramjp.a() == null) {
            throw new IllegalArgumentException("Module without defined name");
        }
        if (paramjp.b() == null) {
            throw new IllegalArgumentException("Module without defined version");
        }
        paramjp.a(new jp.a() {
            public void a(ip paramAnonymousip) {
                jdField_this.l = jdField_this.l.a(paramAnonymousip);
            }

            public void a(jd paramAnonymousjd) {
                jdField_this.l = jdField_this.l.a(paramAnonymousjd);
            }

            public void a(jm paramAnonymousjm) {
                jdField_this.l = jdField_this.l.a(paramAnonymousjm);
            }

            public void a(jx paramAnonymousjx) {
                jdField_this.j = jdField_this.j.a(paramAnonymousjx);
            }

            public void a(ky paramAnonymousky) {
                jdField_this.l = jdField_this.l.a(paramAnonymousky);
            }

            public void a(Class<?> paramAnonymousClass1, Class<?> paramAnonymousClass2) {
                jdField_this.k.a(paramAnonymousClass1, paramAnonymousClass2);
                jdField_this.h.a(paramAnonymousClass1, paramAnonymousClass2);
            }

            public void b(jx paramAnonymousjx) {
                jdField_this.j = jdField_this.j.b(paramAnonymousjx);
            }
        });
    }

    public void a(OutputStream paramOutputStream, Object paramObject)
            throws IOException, he, jh {
        b(this.d.a(paramOutputStream, hc.a), paramObject);
    }

    protected hm b(hj paramhj)
            throws IOException, hi, jh {
        hm localhm = paramhj.e();
        Object localObject = localhm;
        if (localhm == null) {
            paramhj = paramhj.b();
            localObject = paramhj;
            if (paramhj == null) {
                throw new EOFException("No content to map to Object due to end of input");
            }
        }
        return (hm) localObject;
    }

    public iy b() {
        return this.k.a(this.e).a(this.h.i);
    }

    protected final void b(hf paramhf, Object paramObject)
            throws IOException, he, jh {
        ju localju = a();
        if (localju.a(ju.a.k)) {
            paramhf.a();
        }
        if ((localju.a(ju.a.o)) && ((paramObject instanceof Closeable))) {
            a(paramhf, paramObject, localju);
            return;
        }
        int i1 = 0;
        try {
            this.i.a(localju, paramhf, paramObject, this.j);
            i1 = 1;
            paramhf.close();
            return;
        } finally {
            if (i1 != 0) {
            }
        }
        try {
            paramhf.close();
            throw ((Throwable) paramObject);
        } catch (IOException paramhf) {
            for (; ; ) {
            }
        }
    }

    public rs c() {
        return this.k.h();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/jq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */