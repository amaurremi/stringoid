package com.umeng.analytics.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.Gender;
import com.umeng.analytics.a.h;
import com.umeng.analytics.d.A;
import com.umeng.analytics.d.a;
import com.umeng.analytics.d.c;
import com.umeng.analytics.d.n;
import com.umeng.analytics.d.p;
import com.umeng.analytics.d.r;
import com.umeng.analytics.d.u;
import com.umeng.analytics.d.w;
import com.umeng.analytics.d.z;
import com.umeng.common.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class e
        extends g {
    private com.umeng.analytics.f d = null;
    private a e = null;
    private int f = 10;

    public e(Context paramContext) {
        super(paramContext);
        this.d = com.umeng.analytics.f.a(paramContext);
        this.e = new a(paramContext);
    }

    private void a(z paramz1, z paramz2) {
        if (paramz2.w()) {
            HashMap localHashMap = new HashMap();
            a(localHashMap, paramz2.u());
            if (paramz1.w()) {
                a(localHashMap, paramz1.u());
            }
            paramz1.a(new ArrayList(localHashMap.values()));
        }
        if (paramz2.B()) {
            if (!paramz1.B()) {
                break label128;
            }
            paramz1.z().addAll(paramz2.g);
        }
        for (; ; ) {
            if (paramz2.r()) {
                paramz1.a(paramz2.e);
            }
            paramz1.a(paramz2.f());
            paramz1.a(paramz2.j());
            paramz1.a(paramz2.m());
            return;
            label128:
            paramz1.b(paramz2.g);
        }
    }

    private void a(HashMap<String, p> paramHashMap, List<p> paramList) {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            p localp = (p) paramList.next();
            Object localObject = localp.c();
            if (!paramHashMap.containsKey(localObject)) {
                paramHashMap.put(localObject, localp);
            } else {
                localObject = (p) paramHashMap.get(localObject);
                if ((((p) localObject).k()) && (localp.k())) {
                    ((p) localObject).i().addAll(localp.b);
                    label93:
                    if ((!((p) localObject).p()) || (!localp.p())) {
                        break label176;
                    }
                    ((p) localObject).n().addAll(localp.c);
                }
                for (; ; ) {
                    if ((!((p) localObject).u()) || (!localp.u())) {
                        break label196;
                    }
                    ((p) localObject).s().addAll(localp.d);
                    break;
                    if (!localp.k()) {
                        break label93;
                    }
                    ((p) localObject).a(localp.b);
                    break label93;
                    label176:
                    if (localp.p()) {
                        ((p) localObject).b(localp.c);
                    }
                }
                label196:
                if (localp.u()) {
                    ((p) localObject).c(localp.d);
                }
            }
        }
    }

    private boolean a(z paramz) {
        if (paramz == null) {
            return true;
        }
        if (paramz.r()) {
        }
        for (int i = 1; ; i = 0) {
            if (paramz.w()) {
                Iterator localIterator = paramz.u().iterator();
                for (; ; ) {
                    j = i;
                    if (!localIterator.hasNext()) {
                        break;
                    }
                    p localp = (p) localIterator.next();
                    j = localp.f();
                    int k = localp.l();
                    i = localp.q() + (i + j + k);
                }
            }
            int j = i;
            if (paramz.x() + j == 0) {
                break;
            }
            return false;
        }
    }

    private z b(byte[] paramArrayOfByte) {
        if (paramArrayOfByte == null) {
            return null;
        }
        try {
            z localz = new z();
            new com.umeng.a.a.a.g().a(localz, paramArrayOfByte);
            return localz;
        } catch (Exception paramArrayOfByte) {
            paramArrayOfByte.printStackTrace();
        }
        return null;
    }

    private byte[] b(z paramz) {
        try {
            paramz = new com.umeng.a.a.a.m().a(paramz);
            return paramz;
        } catch (Exception paramz) {
            paramz.printStackTrace();
        }
        return null;
    }

    private boolean j() {
        return super.f() > this.f;
    }

    private z k() {
        z localz = g();
        for (; ; ) {
            try {
                localObject1 = d();
                if (localObject1 != null) {
                    continue;
                }
                localObject1 = null;
            } catch (Exception localException) {
                Object localObject1;
                Object localObject2 = null;
                continue;
            }
            if (localObject1 != null) {
                a(localz, (z) localObject1);
            }
            if (!a(localz)) {
                break;
            }
            return null;
            localObject1 = b((byte[]) localObject1);
        }
        return localz;
    }

    public void a() {
        if (f() > 0) {
        }
        try {
            byte[] arrayOfByte = b();
            if (arrayOfByte != null) {
                this.d.a(arrayOfByte);
            }
            return;
        } catch (Throwable localThrowable) {
            do {
                if ((localThrowable instanceof OutOfMemoryError)) {
                    c();
                }
            } while (localThrowable == null);
            localThrowable.printStackTrace();
        }
    }

    public void a(byte[] paramArrayOfByte) {
        this.d.a(paramArrayOfByte);
    }

    public boolean a(int paramInt) {
        if (j()) {
            a();
            return true;
        }
        return super.a(paramInt);
    }

    public void b(int paramInt) {
        this.f = paramInt;
    }

    /* Error */
    protected byte[] b() {
        // Byte code:
        //   0: aload_0
        //   1: invokevirtual 244	com/umeng/analytics/b/e:e	()Landroid/content/Context;
        //   4: invokestatic 250	com/umeng/analytics/AnalyticsConfig:getAppkey	(Landroid/content/Context;)Ljava/lang/String;
        //   7: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   10: ifeq +14 -> 24
        //   13: ldc_w 258
        //   16: ldc_w 260
        //   19: invokestatic 265	com/umeng/common/Log:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   22: aconst_null
        //   23: areturn
        //   24: aload_0
        //   25: invokespecial 267	com/umeng/analytics/b/e:k	()Lcom/umeng/analytics/d/z;
        //   28: astore_3
        //   29: aload_3
        //   30: ifnonnull +5 -> 35
        //   33: aconst_null
        //   34: areturn
        //   35: getstatic 271	com/umeng/common/Log:LOG	Z
        //   38: ifeq +64 -> 102
        //   41: aload_3
        //   42: invokevirtual 66	com/umeng/analytics/d/z:B	()Z
        //   45: ifeq +57 -> 102
        //   48: iconst_0
        //   49: istore_1
        //   50: aload_3
        //   51: invokevirtual 69	com/umeng/analytics/d/z:z	()Ljava/util/List;
        //   54: invokeinterface 115 1 0
        //   59: astore_2
        //   60: aload_2
        //   61: invokeinterface 120 1 0
        //   66: ifeq +23 -> 89
        //   69: aload_2
        //   70: invokeinterface 124 1 0
        //   75: checkcast 273	com/umeng/analytics/d/x
        //   78: invokevirtual 275	com/umeng/analytics/d/x:p	()I
        //   81: ifle +156 -> 237
        //   84: iconst_1
        //   85: istore_1
        //   86: goto +154 -> 240
        //   89: iload_1
        //   90: ifne +12 -> 102
        //   93: ldc_w 258
        //   96: ldc_w 277
        //   99: invokestatic 279	com/umeng/common/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   102: aload_3
        //   103: aload_0
        //   104: getfield 21	com/umeng/analytics/b/e:e	Lcom/umeng/analytics/b/e$a;
        //   107: invokevirtual 281	com/umeng/analytics/b/e$a:a	()Lcom/umeng/analytics/d/c;
        //   110: invokevirtual 94	com/umeng/analytics/d/z:a	(Lcom/umeng/analytics/d/c;)Lcom/umeng/analytics/d/z;
        //   113: pop
        //   114: aload_3
        //   115: aload_0
        //   116: getfield 21	com/umeng/analytics/b/e:e	Lcom/umeng/analytics/b/e$a;
        //   119: invokevirtual 283	com/umeng/analytics/b/e$a:b	()Lcom/umeng/analytics/d/e;
        //   122: invokevirtual 101	com/umeng/analytics/d/z:a	(Lcom/umeng/analytics/d/e;)Lcom/umeng/analytics/d/z;
        //   125: pop
        //   126: aload_3
        //   127: aload_0
        //   128: getfield 21	com/umeng/analytics/b/e:e	Lcom/umeng/analytics/b/e$a;
        //   131: invokevirtual 285	com/umeng/analytics/b/e$a:c	()Lcom/umeng/analytics/d/r;
        //   134: invokevirtual 108	com/umeng/analytics/d/z:a	(Lcom/umeng/analytics/d/r;)Lcom/umeng/analytics/d/z;
        //   137: pop
        //   138: aload_3
        //   139: aload_0
        //   140: getfield 21	com/umeng/analytics/b/e:e	Lcom/umeng/analytics/b/e$a;
        //   143: invokevirtual 288	com/umeng/analytics/b/e$a:f	()Lcom/umeng/analytics/d/d;
        //   146: invokevirtual 291	com/umeng/analytics/d/z:a	(Lcom/umeng/analytics/d/d;)Lcom/umeng/analytics/d/z;
        //   149: pop
        //   150: aload_3
        //   151: aload_0
        //   152: getfield 21	com/umeng/analytics/b/e:e	Lcom/umeng/analytics/b/e$a;
        //   155: invokevirtual 294	com/umeng/analytics/b/e$a:d	()Lcom/umeng/analytics/d/n;
        //   158: invokevirtual 297	com/umeng/analytics/d/z:a	(Lcom/umeng/analytics/d/n;)Lcom/umeng/analytics/d/z;
        //   161: pop
        //   162: aload_3
        //   163: aload_0
        //   164: getfield 21	com/umeng/analytics/b/e:e	Lcom/umeng/analytics/b/e$a;
        //   167: invokevirtual 300	com/umeng/analytics/b/e$a:e	()Lcom/umeng/analytics/d/m;
        //   170: invokevirtual 303	com/umeng/analytics/d/z:a	(Lcom/umeng/analytics/d/m;)Lcom/umeng/analytics/d/z;
        //   173: pop
        //   174: aload_3
        //   175: invokevirtual 305	com/umeng/analytics/d/z:I	()V
        //   178: aload_0
        //   179: aload_3
        //   180: invokespecial 307	com/umeng/analytics/b/e:b	(Lcom/umeng/analytics/d/z;)[B
        //   183: astore_2
        //   184: ldc_w 258
        //   187: aload_3
        //   188: invokevirtual 310	com/umeng/analytics/d/z:toString	()Ljava/lang/String;
        //   191: invokestatic 312	com/umeng/common/Log:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   194: aload_2
        //   195: areturn
        //   196: astore_3
        //   197: ldc_w 258
        //   200: ldc_w 314
        //   203: invokestatic 265	com/umeng/common/Log:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   206: aload_2
        //   207: areturn
        //   208: astore_2
        //   209: ldc_w 258
        //   212: ldc_w 316
        //   215: aload_2
        //   216: invokestatic 319	com/umeng/common/Log:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
        //   219: aload_0
        //   220: invokevirtual 244	com/umeng/analytics/b/e:e	()Landroid/content/Context;
        //   223: invokestatic 28	com/umeng/analytics/f:a	(Landroid/content/Context;)Lcom/umeng/analytics/f;
        //   226: invokevirtual 320	com/umeng/analytics/f:c	()V
        //   229: aconst_null
        //   230: areturn
        //   231: astore_2
        //   232: aconst_null
        //   233: astore_2
        //   234: goto -37 -> 197
        //   237: goto +3 -> 240
        //   240: goto -180 -> 60
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	243	0	this	e
        //   49	41	1	i	int
        //   59	148	2	localObject1	Object
        //   208	8	2	localException1	Exception
        //   231	1	2	localException2	Exception
        //   233	1	2	localObject2	Object
        //   28	160	3	localz	z
        //   196	1	3	localException3	Exception
        // Exception table:
        //   from	to	target	type
        //   184	194	196	java/lang/Exception
        //   0	22	208	java/lang/Exception
        //   24	29	208	java/lang/Exception
        //   35	48	208	java/lang/Exception
        //   50	60	208	java/lang/Exception
        //   60	84	208	java/lang/Exception
        //   93	102	208	java/lang/Exception
        //   102	178	208	java/lang/Exception
        //   197	206	208	java/lang/Exception
        //   178	184	231	java/lang/Exception
    }

    public void c() {
        this.d.c();
        this.d.e();
    }

    public byte[] d() {
        return this.d.b();
    }

    private class a {
        private c b;
        private com.umeng.analytics.d.e c;
        private r d;
        private Context e;

        public a(Context paramContext) {
            this.e = paramContext;
        }

        private void a(Context paramContext) {
            try {
                this.b.a(AnalyticsConfig.getAppkey(paramContext));
                this.b.e(AnalyticsConfig.getChannel(paramContext));
                if ((AnalyticsConfig.mWrapperType != null) && (AnalyticsConfig.mWrapperVersion != null)) {
                    this.b.f(AnalyticsConfig.mWrapperType);
                    this.b.g(AnalyticsConfig.mWrapperVersion);
                }
                this.b.c(b.u(paramContext));
                this.b.a(w.a);
                this.b.d("5.2.2");
                this.b.b(b.d(paramContext));
                this.b.a(Integer.parseInt(b.c(paramContext)));
                if (AnalyticsConfig.mVerticalType == 1) {
                    this.b.c(AnalyticsConfig.mVerticalType);
                    this.b.d("5.2.2.1");
                }
                return;
            } catch (Exception paramContext) {
                paramContext.printStackTrace();
            }
        }

        private void b(Context paramContext) {
            try {
                this.c.f(b.a());
                this.c.a(b.f(paramContext));
                this.c.b(b.g(paramContext));
                this.c.c(b.p(paramContext));
                this.c.e(Build.MODEL);
                this.c.g("Android");
                this.c.h(Build.VERSION.RELEASE);
                paramContext = b.r(paramContext);
                if (paramContext != null) {
                    this.c.a(new u(paramContext[1], paramContext[0]));
                }
                if ((AnalyticsConfig.GPU_RENDERER != null) && (AnalyticsConfig.GPU_VENDER != null)) {
                }
                this.c.i(Build.BOARD);
                this.c.j(Build.BRAND);
                this.c.a(Build.TIME);
                this.c.k(Build.MANUFACTURER);
                this.c.l(Build.ID);
                this.c.m(Build.DEVICE);
                return;
            } catch (Exception paramContext) {
                paramContext.printStackTrace();
            }
        }

        private void c(Context paramContext) {
            for (; ; ) {
                try {
                    String[] arrayOfString = b.j(paramContext);
                    if ("Wi-Fi".equals(arrayOfString[0])) {
                        this.d.a(a.c);
                        if (!"".equals(arrayOfString[1])) {
                            this.d.e(arrayOfString[1]);
                        }
                        this.d.c(b.s(paramContext));
                        arrayOfString = b.n(paramContext);
                        this.d.b(arrayOfString[0]);
                        this.d.a(arrayOfString[1]);
                        this.d.a(b.m(paramContext));
                        if ((AnalyticsConfig.sAge == 0) && (AnalyticsConfig.sGender == null) && (AnalyticsConfig.sId == null) && (AnalyticsConfig.sSource == null)) {
                            break;
                        }
                        paramContext = new A();
                        paramContext.a(AnalyticsConfig.sAge);
                        paramContext.a(Gender.transGender(AnalyticsConfig.sGender));
                        paramContext.a(AnalyticsConfig.sId);
                        paramContext.b(AnalyticsConfig.sSource);
                        this.d.a(paramContext);
                        return;
                    }
                    if ("2G/3G".equals(arrayOfString[0])) {
                        this.d.a(a.b);
                    } else {
                        this.d.a(a.a);
                    }
                } catch (Exception paramContext) {
                    paramContext.printStackTrace();
                    return;
                }
            }
        }

        public c a() {
            if (this.b == null) {
                this.b = new c();
                a(this.e);
            }
            return this.b;
        }

        public com.umeng.analytics.d.e b() {
            if (this.c == null) {
                this.c = new com.umeng.analytics.d.e();
                b(this.e);
            }
            return this.c;
        }

        public r c() {
            if (this.d == null) {
                this.d = new r();
            }
            c(this.e);
            return this.d;
        }

        public n d() {
            try {
                n localn = h.b(this.e).a();
                return localn;
            } catch (Exception localException) {
                localException.printStackTrace();
            }
            return null;
        }

        public com.umeng.analytics.d.m e() {
            try {
                com.umeng.analytics.d.m localm = h.a(this.e).b();
                return localm;
            } catch (Exception localException) {
                localException.printStackTrace();
            }
            return null;
        }

        public com.umeng.analytics.d.d f() {
            try {
                com.umeng.analytics.d.d locald = o.a(this.e);
                return locald;
            } catch (Exception localException) {
                localException.printStackTrace();
            }
            return new com.umeng.analytics.d.d();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */