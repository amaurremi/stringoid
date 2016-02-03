package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

public abstract class as {
    private static final String a = as.class.getSimpleName();
    private a b;
    private String c;
    private long d = Long.MAX_VALUE;
    private int e = Integer.MAX_VALUE;
    private aw f;
    private long g;
    private boolean h;
    private int i;
    private long j = 102400L;
    private int k;
    private boolean l;
    private boolean m;

    private long a(en paramen) {
        paramen = paramen.b("Content-Length");
        if ((paramen != null) && (!paramen.isEmpty())) {
            try {
                long l1 = Long.parseLong((String) paramen.get(0));
                return l1;
            } catch (NumberFormatException paramen) {
                eo.a(3, a, "Downloader: could not determine content length for url: " + this.c);
            }
        }
        return -1L;
    }

    private String a(int paramInt) {
        return String.format(Locale.US, "%s__%03d", new Object[]{this.c, Integer.valueOf(paramInt)});
    }

    private String b(int paramInt) {
        return String.format("%s=%d-%d", new Object[]{"bytes", Long.valueOf(paramInt * this.j), Long.valueOf(Math.min(this.g, (paramInt + 1) * this.j) - 1L)});
    }

    private void j() {
        if (b()) {
            return;
        }
        eo.a(3, a, "Downloader: Requesting file from url: " + this.c);
        en localen = new en();
        localen.a(this.c);
        localen.a(en.a.b);
        localen.a(this.e);
        localen.a(new en.b() {
            public void a(en paramAnonymousen) {
                if (as.this.b()) {
                    return;
                }
                int i = paramAnonymousen.e();
                eo.a(3, as.i(), "Downloader: Download status code is:" + i + " for url: " + as.f(as.this));
                as.a(as.this, paramAnonymousen.c());
                do.a().c(new ff() {
                    public void a() {
                        if (!as.g(as.this)) {
                            as.this.h();
                        }
                        as.h(as.this);
                    }
                });
            }

            public void a(en paramAnonymousen, InputStream paramAnonymousInputStream)
                    throws Exception {
                if (as.this.b()) {
                    throw new IOException("Downloader: request cancelled");
                }
                as.a(as.this, as.a(as.this, paramAnonymousen));
                if (as.d(as.this) > as.e(as.this)) {
                    throw new IOException("Downloader: content length: " + as.d(as.this) + " exceeds size limit: " + as.e(as.this));
                }
                try {
                    paramAnonymousInputStream = new az(paramAnonymousInputStream, as.e(as.this));
                    as.this.g();
                } finally {
                    try {
                        fe.a(paramAnonymousInputStream, as.this.f());
                        as.this.g();
                        fe.a(paramAnonymousInputStream);
                        return;
                    } finally {
                    }
                    paramAnonymousen =finally;
                    paramAnonymousInputStream = null;
                }
                fe.a(paramAnonymousInputStream);
                throw paramAnonymousen;
            }
        });
        em.a().a(this, localen);
    }

    private void k() {
        if (b()) {
            return;
        }
        el localel = new el();
        localel.a(this.c);
        localel.a(en.a.f);
        localel.a(new el.a() {
            public void a(el<Void, Void> paramAnonymousel, Void paramAnonymousVoid) {
                if (as.this.b()) {
                    return;
                }
                int i = paramAnonymousel.e();
                eo.a(3, as.i(), "Downloader: HTTP HEAD status code is:" + i + " for url: " + as.f(as.this));
                if (paramAnonymousel.c()) {
                    as.a(as.this, as.a(as.this, paramAnonymousel));
                    paramAnonymousel = paramAnonymousel.b("Accept-Ranges");
                    if ((as.d(as.this) > 0L) && (paramAnonymousel != null) && (!paramAnonymousel.isEmpty())) {
                        as.b(as.this, "bytes".equals(((String) paramAnonymousel.get(0)).trim()));
                        paramAnonymousel = as.this;
                        long l = as.d(as.this) / as.i(as.this);
                        if (as.d(as.this) % as.i(as.this) > 0L) {
                            i = 1;
                            as.a(paramAnonymousel, (int) (i + l));
                        }
                    }
                    for (; ; ) {
                        if ((as.e(as.this) <= 0L) || (as.d(as.this) <= as.e(as.this))) {
                            break label307;
                        }
                        eo.a(3, as.i(), "Downloader: Size limit exceeded -- limit: " + as.e(as.this) + ", content-length: " + as.d(as.this) + " bytes!");
                        do.a().c(new ff() {
                            public void a() {
                                as.h(as.this);
                            }
                        });
                        return;
                        i = 0;
                        break;
                        as.a(as.this, 1);
                    }
                    label307:
                    do.a().c(new ff() {
                        public void a() {
                            as.j(as.this);
                        }
                    });
                    return;
                }
                do.a().c(new ff() {
                    public void a() {
                        as.h(as.this);
                    }
                });
            }
        });
        eo.a(3, a, "Downloader: requesting HTTP HEAD for url: " + this.c);
        em.a().a(this, localel);
    }

    private void l() {
        if (b()) {
            return;
        }
        if (q()) {
            int n = 0;
            while (n < this.i) {
                this.f.d(a(n));
                n += 1;
            }
            m();
            return;
        }
        j();
    }

    private void m() {
        while (this.k < this.i) {
            if (b()) {
                return;
            }
            final String str1 = a(this.k);
            final String str2 = b(this.k);
            if (this.f.d(str1)) {
                eo.a(3, a, "Downloader: Skipping chunk with range:" + str2 + " for url: " + this.c + " chunk: " + this.k);
                this.k += 1;
            } else {
                eo.a(3, a, "Downloader: Requesting chunk with range:" + str2 + " for url: " + this.c + " chunk: " + this.k);
                en localen = new en();
                localen.a(this.c);
                localen.a(en.a.b);
                localen.a(this.e);
                localen.a("Range", str2);
                localen.a(new en.b() {
                    public void a(en paramAnonymousen) {
                        if (as.this.b()) {
                            return;
                        }
                        int i = paramAnonymousen.e();
                        eo.a(3, as.i(), "Downloader: Download status code is:" + i + " for url: " + as.f(as.this) + " chunk: " + as.l(as.this));
                        Object localObject2 = null;
                        List localList = paramAnonymousen.b("Content-Range");
                        Object localObject1 = localObject2;
                        if (localList != null) {
                            localObject1 = localObject2;
                            if (!localList.isEmpty()) {
                                localObject1 = (String) localList.get(0);
                                eo.a(3, as.i(), "Downloader: Content range is:" + (String) localObject1 + " for url: " + as.f(as.this) + " chunk: " + as.l(as.this));
                            }
                        }
                        if ((paramAnonymousen.c()) && (i == 206) && (localObject1 != null) && (((String) localObject1).startsWith(str2.replaceAll("=", " ")))) {
                            as.m(as.this);
                            do.a().c(new ff() {
                                public void a() {
                                    as.n(as.this);
                                }
                            });
                            return;
                        }
                        do.a().c(new ff() {
                            public void a() {
                                as.h(as.this);
                            }
                        });
                    }

                    /* Error */
                    public void a(en paramAnonymousen, InputStream paramAnonymousInputStream)
                            throws Exception {
                        // Byte code:
                        //   0: aconst_null
                        //   1: astore_3
                        //   2: aconst_null
                        //   3: astore 4
                        //   5: aload_0
                        //   6: getfield 22	com/flurry/sdk/as$4:c	Lcom/flurry/sdk/as;
                        //   9: invokevirtual 33	com/flurry/sdk/as:b	()Z
                        //   12: ifeq +13 -> 25
                        //   15: new 126	java/io/IOException
                        //   18: dup
                        //   19: ldc -128
                        //   21: invokespecial 131	java/io/IOException:<init>	(Ljava/lang/String;)V
                        //   24: athrow
                        //   25: aload_0
                        //   26: getfield 22	com/flurry/sdk/as$4:c	Lcom/flurry/sdk/as;
                        //   29: invokestatic 135	com/flurry/sdk/as:k	(Lcom/flurry/sdk/as;)Lcom/flurry/sdk/aw;
                        //   32: aload_0
                        //   33: getfield 24	com/flurry/sdk/as$4:a	Ljava/lang/String;
                        //   36: invokevirtual 140	com/flurry/sdk/aw:b	(Ljava/lang/String;)Lcom/flurry/sdk/aw$c;
                        //   39: astore 5
                        //   41: aload 4
                        //   43: astore_1
                        //   44: aload 5
                        //   46: ifnull +41 -> 87
                        //   49: new 142	com/flurry/sdk/az
                        //   52: dup
                        //   53: aload_2
                        //   54: aload_0
                        //   55: getfield 22	com/flurry/sdk/as$4:c	Lcom/flurry/sdk/as;
                        //   58: invokestatic 145	com/flurry/sdk/as:e	(Lcom/flurry/sdk/as;)J
                        //   61: invokespecial 148	com/flurry/sdk/az:<init>	(Ljava/io/InputStream;J)V
                        //   64: astore_2
                        //   65: aload_2
                        //   66: aload 5
                        //   68: invokevirtual 153	com/flurry/sdk/aw$c:a	()Ljava/io/OutputStream;
                        //   71: invokestatic 158	com/flurry/sdk/fe:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
                        //   74: pop2
                        //   75: aload 5
                        //   77: invokestatic 161	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
                        //   80: aload_2
                        //   81: invokestatic 161	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
                        //   84: aload 4
                        //   86: astore_1
                        //   87: aload_1
                        //   88: ifnull +49 -> 137
                        //   91: aload_0
                        //   92: getfield 22	com/flurry/sdk/as$4:c	Lcom/flurry/sdk/as;
                        //   95: invokestatic 135	com/flurry/sdk/as:k	(Lcom/flurry/sdk/as;)Lcom/flurry/sdk/aw;
                        //   98: aload_0
                        //   99: getfield 24	com/flurry/sdk/as$4:a	Ljava/lang/String;
                        //   102: invokevirtual 163	com/flurry/sdk/aw:c	(Ljava/lang/String;)Z
                        //   105: pop
                        //   106: aload_1
                        //   107: athrow
                        //   108: astore_1
                        //   109: aconst_null
                        //   110: astore_2
                        //   111: aload 5
                        //   113: invokestatic 161	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
                        //   116: aload_2
                        //   117: invokestatic 161	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
                        //   120: goto -33 -> 87
                        //   123: astore_1
                        //   124: aload_3
                        //   125: astore_2
                        //   126: aload 5
                        //   128: invokestatic 161	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
                        //   131: aload_2
                        //   132: invokestatic 161	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
                        //   135: aload_1
                        //   136: athrow
                        //   137: return
                        //   138: astore_1
                        //   139: goto -13 -> 126
                        //   142: astore_1
                        //   143: goto -32 -> 111
                        // Local variable table:
                        //   start	length	slot	name	signature
                        //   0	146	0	this	4
                        //   0	146	1	paramAnonymousen	en
                        //   0	146	2	paramAnonymousInputStream	InputStream
                        //   1	124	3	localObject1	Object
                        //   3	82	4	localObject2	Object
                        //   39	88	5	localc	aw.c
                        // Exception table:
                        //   from	to	target	type
                        //   49	65	108	java/io/IOException
                        //   49	65	123	finally
                        //   65	75	138	finally
                        //   65	75	142	java/io/IOException
                    }
                });
                em.a().a(this, localen);
                return;
            }
        }
        n();
    }

    /* Error */
    private void n() {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: iconst_0
        //   4: istore_2
        //   5: aload_0
        //   6: invokevirtual 184	com/flurry/sdk/as:b	()Z
        //   9: ifeq +4 -> 13
        //   12: return
        //   13: iconst_3
        //   14: getstatic 55	com/flurry/sdk/as:a	Ljava/lang/String;
        //   17: new 109	java/lang/StringBuilder
        //   20: dup
        //   21: invokespecial 110	java/lang/StringBuilder:<init>	()V
        //   24: ldc_w 275
        //   27: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   30: aload_0
        //   31: getfield 118	com/flurry/sdk/as:c	Ljava/lang/String;
        //   34: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   37: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   40: invokestatic 126	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   43: aload_0
        //   44: invokevirtual 278	com/flurry/sdk/as:f	()Ljava/io/OutputStream;
        //   47: astore 5
        //   49: iconst_0
        //   50: istore_1
        //   51: iload_1
        //   52: aload_0
        //   53: getfield 73	com/flurry/sdk/as:i	I
        //   56: if_icmpge +173 -> 229
        //   59: aload_0
        //   60: invokevirtual 184	com/flurry/sdk/as:b	()Z
        //   63: ifeq +63 -> 126
        //   66: new 273	java/io/IOException
        //   69: dup
        //   70: ldc_w 280
        //   73: invokespecial 282	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   76: athrow
        //   77: astore_3
        //   78: aload_0
        //   79: invokevirtual 284	com/flurry/sdk/as:g	()V
        //   82: aload_3
        //   83: ifnonnull +156 -> 239
        //   86: iconst_3
        //   87: getstatic 55	com/flurry/sdk/as:a	Ljava/lang/String;
        //   90: new 109	java/lang/StringBuilder
        //   93: dup
        //   94: invokespecial 110	java/lang/StringBuilder:<init>	()V
        //   97: ldc_w 286
        //   100: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   103: aload_0
        //   104: getfield 118	com/flurry/sdk/as:c	Ljava/lang/String;
        //   107: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   110: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   113: invokestatic 126	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   116: aload_0
        //   117: iconst_1
        //   118: putfield 154	com/flurry/sdk/as:l	Z
        //   121: aload_0
        //   122: invokespecial 182	com/flurry/sdk/as:o	()V
        //   125: return
        //   126: aload_0
        //   127: iload_1
        //   128: invokespecial 240	com/flurry/sdk/as:a	(I)Ljava/lang/String;
        //   131: astore 6
        //   133: aload_0
        //   134: getfield 219	com/flurry/sdk/as:f	Lcom/flurry/sdk/aw;
        //   137: aload 6
        //   139: invokevirtual 289	com/flurry/sdk/aw:a	(Ljava/lang/String;)Lcom/flurry/sdk/aw$b;
        //   142: astore_3
        //   143: aload_3
        //   144: ifnonnull +54 -> 198
        //   147: new 273	java/io/IOException
        //   150: dup
        //   151: new 109	java/lang/StringBuilder
        //   154: dup
        //   155: invokespecial 110	java/lang/StringBuilder:<init>	()V
        //   158: ldc_w 291
        //   161: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   164: aload 6
        //   166: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   169: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   172: invokespecial 282	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   175: athrow
        //   176: astore 5
        //   178: aload_3
        //   179: astore 4
        //   181: aload 5
        //   183: astore_3
        //   184: aload 4
        //   186: invokestatic 296	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   189: aload_3
        //   190: athrow
        //   191: astore_3
        //   192: aload_0
        //   193: invokevirtual 284	com/flurry/sdk/as:g	()V
        //   196: aload_3
        //   197: athrow
        //   198: aload_3
        //   199: invokevirtual 301	com/flurry/sdk/aw$b:a	()Ljava/io/InputStream;
        //   202: aload 5
        //   204: invokestatic 304	com/flurry/sdk/fe:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
        //   207: pop2
        //   208: aload_3
        //   209: invokestatic 296	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   212: aload_0
        //   213: getfield 219	com/flurry/sdk/as:f	Lcom/flurry/sdk/aw;
        //   216: aload 6
        //   218: invokevirtual 306	com/flurry/sdk/aw:c	(Ljava/lang/String;)Z
        //   221: pop
        //   222: iload_1
        //   223: iconst_1
        //   224: iadd
        //   225: istore_1
        //   226: goto -175 -> 51
        //   229: aload_0
        //   230: invokevirtual 284	com/flurry/sdk/as:g	()V
        //   233: aload 4
        //   235: astore_3
        //   236: goto -154 -> 82
        //   239: iconst_3
        //   240: getstatic 55	com/flurry/sdk/as:a	Ljava/lang/String;
        //   243: new 109	java/lang/StringBuilder
        //   246: dup
        //   247: invokespecial 110	java/lang/StringBuilder:<init>	()V
        //   250: ldc_w 308
        //   253: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   256: aload_0
        //   257: getfield 118	com/flurry/sdk/as:c	Ljava/lang/String;
        //   260: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   263: ldc_w 310
        //   266: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   269: aload_3
        //   270: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   273: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   276: invokestatic 126	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   279: iload_2
        //   280: istore_1
        //   281: iload_1
        //   282: aload_0
        //   283: getfield 73	com/flurry/sdk/as:i	I
        //   286: if_icmpge +23 -> 309
        //   289: aload_0
        //   290: getfield 219	com/flurry/sdk/as:f	Lcom/flurry/sdk/aw;
        //   293: aload_0
        //   294: iload_1
        //   295: invokespecial 240	com/flurry/sdk/as:a	(I)Ljava/lang/String;
        //   298: invokevirtual 306	com/flurry/sdk/aw:c	(Ljava/lang/String;)Z
        //   301: pop
        //   302: iload_1
        //   303: iconst_1
        //   304: iadd
        //   305: istore_1
        //   306: goto -25 -> 281
        //   309: aload_0
        //   310: invokevirtual 315	com/flurry/sdk/as:h	()V
        //   313: goto -192 -> 121
        //   316: astore_3
        //   317: aconst_null
        //   318: astore 4
        //   320: goto -136 -> 184
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	323	0	this	as
        //   50	256	1	n	int
        //   4	276	2	i1	int
        //   77	6	3	localIOException	IOException
        //   142	48	3	localObject1	Object
        //   191	18	3	localCloseable	java.io.Closeable
        //   235	35	3	localObject2	Object
        //   316	1	3	localObject3	Object
        //   1	318	4	localObject4	Object
        //   47	1	5	localOutputStream1	OutputStream
        //   176	27	5	localOutputStream2	OutputStream
        //   131	86	6	str	String
        // Exception table:
        //   from	to	target	type
        //   43	49	77	java/io/IOException
        //   51	77	77	java/io/IOException
        //   126	133	77	java/io/IOException
        //   184	191	77	java/io/IOException
        //   208	222	77	java/io/IOException
        //   147	176	176	finally
        //   198	208	176	finally
        //   43	49	191	finally
        //   51	77	191	finally
        //   126	133	191	finally
        //   184	191	191	finally
        //   208	222	191	finally
        //   133	143	316	finally
    }

    private void o() {
        if (b()) {
        }
        while (this.b == null) {
            return;
        }
        eo.a(3, a, "Downloader: finished -- success: " + this.l + " for url: " + this.c);
        this.b.a(this);
    }

    private boolean p() {
        return this.f != null;
    }

    private boolean q() {
        return (this.f != null) && (this.h) && (this.i > 1);
    }

    public void a(a parama) {
        this.b = parama;
    }

    public void a(aw paramaw) {
        this.f = paramaw;
    }

    public void a(String paramString) {
        this.c = paramString;
    }

    public boolean a() {
        return this.l;
    }

    public boolean b() {
        return this.m;
    }

    public long c() {
        return this.g;
    }

    public void d() {
        do.a().c(new ff() {
            public void a() {
                if (as.a(as.this)) {
                    as.b(as.this);
                    return;
                }
                as.c(as.this);
            }
        });
    }

    public void e() {
        this.m = true;
        em.a().a(this);
    }

    protected abstract OutputStream f()
            throws IOException;

    protected abstract void g();

    protected abstract void h();

    public static abstract interface a {
        public abstract void a(as paramas);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */