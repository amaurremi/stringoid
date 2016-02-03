package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn.q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import com.flurry.sdk.gx;

public class AdViewContainer
        extends gw
        implements gv {
    public static final fn SCHEMA$ = new fn.q().a("{\"type\":\"record\",\"name\":\"AdViewContainer\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"viewWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"viewHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"screenWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"screenHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"density\",\"type\":\"float\",\"default\":1.0},{\"name\":\"screenOrientation\",\"type\":{\"type\":\"enum\",\"name\":\"ScreenOrientationType\",\"symbols\":[\"PORTRAIT\",\"LANDSCAPE\",\"UNKNOWN\"]},\"default\":\"UNKNOWN\"}]}");
    @Deprecated
    public int a;
    @Deprecated
    public int b;
    @Deprecated
    public int c;
    @Deprecated
    public int d;
    @Deprecated
    public float e;
    @Deprecated
    public ScreenOrientationType f;

    public static Builder b() {
        return new Builder(null);
    }

    public fn a() {
        return SCHEMA$;
    }

    public Object a(int paramInt) {
        switch (paramInt) {
            default:
                throw new fk("Bad index");
            case 0:
                return Integer.valueOf(this.a);
            case 1:
                return Integer.valueOf(this.b);
            case 2:
                return Integer.valueOf(this.c);
            case 3:
                return Integer.valueOf(this.d);
            case 4:
                return Float.valueOf(this.e);
        }
        return this.f;
    }

    public void a(int paramInt, Object paramObject) {
        switch (paramInt) {
            default:
                throw new fk("Bad index");
            case 0:
                this.a = ((Integer) paramObject).intValue();
                return;
            case 1:
                this.b = ((Integer) paramObject).intValue();
                return;
            case 2:
                this.c = ((Integer) paramObject).intValue();
                return;
            case 3:
                this.d = ((Integer) paramObject).intValue();
                return;
            case 4:
                this.e = ((Float) paramObject).floatValue();
                return;
        }
        this.f = ((ScreenOrientationType) paramObject);
    }

    public static class Builder
            extends gx<AdViewContainer> {
        private int a;
        private int b;
        private int c;
        private int d;
        private float e;
        private ScreenOrientationType f;

        private Builder() {
            super();
        }

        public Builder a(float paramFloat) {
            a(b()[4], Float.valueOf(paramFloat));
            this.e = paramFloat;
            c()[4] = 1;
            return this;
        }

        public Builder a(int paramInt) {
            a(b()[0], Integer.valueOf(paramInt));
            this.a = paramInt;
            c()[0] = 1;
            return this;
        }

        public Builder a(ScreenOrientationType paramScreenOrientationType) {
            a(b()[5], paramScreenOrientationType);
            this.f = paramScreenOrientationType;
            c()[5] = 1;
            return this;
        }

        /* Error */
        public AdViewContainer a() {
            // Byte code:
            //   0: new 7	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer
            //   3: dup
            //   4: invokespecial 63	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer:<init>	()V
            //   7: astore 4
            //   9: aload_0
            //   10: invokevirtual 48	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:c	()[Z
            //   13: iconst_0
            //   14: baload
            //   15: ifeq +117 -> 132
            //   18: aload_0
            //   19: getfield 56	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:a	I
            //   22: istore_2
            //   23: aload 4
            //   25: iload_2
            //   26: putfield 64	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer:a	I
            //   29: aload_0
            //   30: invokevirtual 48	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:c	()[Z
            //   33: iconst_1
            //   34: baload
            //   35: ifeq +117 -> 152
            //   38: aload_0
            //   39: getfield 66	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:b	I
            //   42: istore_2
            //   43: aload 4
            //   45: iload_2
            //   46: putfield 67	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer:b	I
            //   49: aload_0
            //   50: invokevirtual 48	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:c	()[Z
            //   53: iconst_2
            //   54: baload
            //   55: ifeq +117 -> 172
            //   58: aload_0
            //   59: getfield 69	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:c	I
            //   62: istore_2
            //   63: aload 4
            //   65: iload_2
            //   66: putfield 70	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer:c	I
            //   69: aload_0
            //   70: invokevirtual 48	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:c	()[Z
            //   73: iconst_3
            //   74: baload
            //   75: ifeq +117 -> 192
            //   78: aload_0
            //   79: getfield 72	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:d	I
            //   82: istore_2
            //   83: aload 4
            //   85: iload_2
            //   86: putfield 73	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer:d	I
            //   89: aload_0
            //   90: invokevirtual 48	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:c	()[Z
            //   93: iconst_4
            //   94: baload
            //   95: ifeq +117 -> 212
            //   98: aload_0
            //   99: getfield 45	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:e	F
            //   102: fstore_1
            //   103: aload 4
            //   105: fload_1
            //   106: putfield 74	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer:e	F
            //   109: aload_0
            //   110: invokevirtual 48	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:c	()[Z
            //   113: iconst_5
            //   114: baload
            //   115: ifeq +117 -> 232
            //   118: aload_0
            //   119: getfield 59	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:f	Lcom/flurry/android/impl/ads/avro/protocol/v10/ScreenOrientationType;
            //   122: astore_3
            //   123: aload 4
            //   125: aload_3
            //   126: putfield 75	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer:f	Lcom/flurry/android/impl/ads/avro/protocol/v10/ScreenOrientationType;
            //   129: aload 4
            //   131: areturn
            //   132: aload_0
            //   133: aload_0
            //   134: invokevirtual 34	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   137: iconst_0
            //   138: aaload
            //   139: invokevirtual 78	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   142: checkcast 51	java/lang/Integer
            //   145: invokevirtual 82	java/lang/Integer:intValue	()I
            //   148: istore_2
            //   149: goto -126 -> 23
            //   152: aload_0
            //   153: aload_0
            //   154: invokevirtual 34	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   157: iconst_1
            //   158: aaload
            //   159: invokevirtual 78	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   162: checkcast 51	java/lang/Integer
            //   165: invokevirtual 82	java/lang/Integer:intValue	()I
            //   168: istore_2
            //   169: goto -126 -> 43
            //   172: aload_0
            //   173: aload_0
            //   174: invokevirtual 34	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   177: iconst_2
            //   178: aaload
            //   179: invokevirtual 78	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   182: checkcast 51	java/lang/Integer
            //   185: invokevirtual 82	java/lang/Integer:intValue	()I
            //   188: istore_2
            //   189: goto -126 -> 63
            //   192: aload_0
            //   193: aload_0
            //   194: invokevirtual 34	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   197: iconst_3
            //   198: aaload
            //   199: invokevirtual 78	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   202: checkcast 51	java/lang/Integer
            //   205: invokevirtual 82	java/lang/Integer:intValue	()I
            //   208: istore_2
            //   209: goto -126 -> 83
            //   212: aload_0
            //   213: aload_0
            //   214: invokevirtual 34	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   217: iconst_4
            //   218: aaload
            //   219: invokevirtual 78	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   222: checkcast 36	java/lang/Float
            //   225: invokevirtual 86	java/lang/Float:floatValue	()F
            //   228: fstore_1
            //   229: goto -126 -> 103
            //   232: aload_0
            //   233: aload_0
            //   234: invokevirtual 34	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   237: iconst_5
            //   238: aaload
            //   239: invokevirtual 78	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   242: checkcast 88	com/flurry/android/impl/ads/avro/protocol/v10/ScreenOrientationType
            //   245: astore_3
            //   246: goto -123 -> 123
            //   249: astore_3
            //   250: new 90	com/flurry/sdk/fk
            //   253: dup
            //   254: aload_3
            //   255: invokespecial 93	com/flurry/sdk/fk:<init>	(Ljava/lang/Throwable;)V
            //   258: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	259	0	this	Builder
            //   102	127	1	f1	float
            //   22	187	2	i	int
            //   122	124	3	localScreenOrientationType	ScreenOrientationType
            //   249	6	3	localException	Exception
            //   7	123	4	localAdViewContainer	AdViewContainer
            // Exception table:
            //   from	to	target	type
            //   0	23	249	java/lang/Exception
            //   23	43	249	java/lang/Exception
            //   43	63	249	java/lang/Exception
            //   63	83	249	java/lang/Exception
            //   83	103	249	java/lang/Exception
            //   103	123	249	java/lang/Exception
            //   123	129	249	java/lang/Exception
            //   132	149	249	java/lang/Exception
            //   152	169	249	java/lang/Exception
            //   172	189	249	java/lang/Exception
            //   192	209	249	java/lang/Exception
            //   212	229	249	java/lang/Exception
            //   232	246	249	java/lang/Exception
        }

        public Builder b(int paramInt) {
            a(b()[1], Integer.valueOf(paramInt));
            this.b = paramInt;
            c()[1] = 1;
            return this;
        }

        public Builder c(int paramInt) {
            a(b()[2], Integer.valueOf(paramInt));
            this.c = paramInt;
            c()[2] = 1;
            return this;
        }

        public Builder d(int paramInt) {
            a(b()[3], Integer.valueOf(paramInt));
            this.d = paramInt;
            c()[3] = 1;
            return this;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */