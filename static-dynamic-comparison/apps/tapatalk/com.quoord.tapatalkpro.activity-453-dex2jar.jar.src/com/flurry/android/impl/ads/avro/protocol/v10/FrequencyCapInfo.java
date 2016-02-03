package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn.q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import com.flurry.sdk.gx;

public class FrequencyCapInfo
        extends gw
        implements gv {
    public static final fn SCHEMA$ = new fn.q().a("{\"type\":\"record\",\"name\":\"FrequencyCapInfo\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"idHash\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"serveTime\",\"type\":\"long\"},{\"name\":\"expirationTime\",\"type\":\"long\"},{\"name\":\"views\",\"type\":\"int\"},{\"name\":\"newCap\",\"type\":\"int\"},{\"name\":\"previousCap\",\"type\":\"int\"},{\"name\":\"previousCapType\",\"type\":\"int\"}]}");
    @Deprecated
    public CharSequence a;
    @Deprecated
    public long b;
    @Deprecated
    public long c;
    @Deprecated
    public int d;
    @Deprecated
    public int e;
    @Deprecated
    public int f;
    @Deprecated
    public int g;

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
                return this.a;
            case 1:
                return Long.valueOf(this.b);
            case 2:
                return Long.valueOf(this.c);
            case 3:
                return Integer.valueOf(this.d);
            case 4:
                return Integer.valueOf(this.e);
            case 5:
                return Integer.valueOf(this.f);
        }
        return Integer.valueOf(this.g);
    }

    public void a(int paramInt, Object paramObject) {
        switch (paramInt) {
            default:
                throw new fk("Bad index");
            case 0:
                this.a = ((CharSequence) paramObject);
                return;
            case 1:
                this.b = ((Long) paramObject).longValue();
                return;
            case 2:
                this.c = ((Long) paramObject).longValue();
                return;
            case 3:
                this.d = ((Integer) paramObject).intValue();
                return;
            case 4:
                this.e = ((Integer) paramObject).intValue();
                return;
            case 5:
                this.f = ((Integer) paramObject).intValue();
                return;
        }
        this.g = ((Integer) paramObject).intValue();
    }

    public static class Builder
            extends gx<FrequencyCapInfo> {
        private CharSequence a;
        private long b;
        private long c;
        private int d;
        private int e;
        private int f;
        private int g;

        private Builder() {
            super();
        }

        public Builder a(int paramInt) {
            a(b()[3], Integer.valueOf(paramInt));
            this.d = paramInt;
            c()[3] = 1;
            return this;
        }

        public Builder a(long paramLong) {
            a(b()[1], Long.valueOf(paramLong));
            this.b = paramLong;
            c()[1] = 1;
            return this;
        }

        public Builder a(CharSequence paramCharSequence) {
            a(b()[0], paramCharSequence);
            this.a = paramCharSequence;
            c()[0] = 1;
            return this;
        }

        /* Error */
        public FrequencyCapInfo a() {
            // Byte code:
            //   0: new 7	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo
            //   3: dup
            //   4: invokespecial 64	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo:<init>	()V
            //   7: astore 5
            //   9: aload_0
            //   10: invokevirtual 49	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:c	()[Z
            //   13: iconst_0
            //   14: baload
            //   15: ifeq +140 -> 155
            //   18: aload_0
            //   19: getfield 60	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:a	Ljava/lang/CharSequence;
            //   22: astore 4
            //   24: aload 5
            //   26: aload 4
            //   28: putfield 65	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo:a	Ljava/lang/CharSequence;
            //   31: aload_0
            //   32: invokevirtual 49	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:c	()[Z
            //   35: iconst_1
            //   36: baload
            //   37: ifeq +136 -> 173
            //   40: aload_0
            //   41: getfield 57	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:b	J
            //   44: lstore_2
            //   45: aload 5
            //   47: lload_2
            //   48: putfield 66	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo:b	J
            //   51: aload_0
            //   52: invokevirtual 49	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:c	()[Z
            //   55: iconst_2
            //   56: baload
            //   57: ifeq +136 -> 193
            //   60: aload_0
            //   61: getfield 68	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:c	J
            //   64: lstore_2
            //   65: aload 5
            //   67: lload_2
            //   68: putfield 69	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo:c	J
            //   71: aload_0
            //   72: invokevirtual 49	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:c	()[Z
            //   75: iconst_3
            //   76: baload
            //   77: ifeq +136 -> 213
            //   80: aload_0
            //   81: getfield 46	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:d	I
            //   84: istore_1
            //   85: aload 5
            //   87: iload_1
            //   88: putfield 70	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo:d	I
            //   91: aload_0
            //   92: invokevirtual 49	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:c	()[Z
            //   95: iconst_4
            //   96: baload
            //   97: ifeq +136 -> 233
            //   100: aload_0
            //   101: getfield 72	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:e	I
            //   104: istore_1
            //   105: aload 5
            //   107: iload_1
            //   108: putfield 73	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo:e	I
            //   111: aload_0
            //   112: invokevirtual 49	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:c	()[Z
            //   115: iconst_5
            //   116: baload
            //   117: ifeq +136 -> 253
            //   120: aload_0
            //   121: getfield 75	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:f	I
            //   124: istore_1
            //   125: aload 5
            //   127: iload_1
            //   128: putfield 76	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo:f	I
            //   131: aload_0
            //   132: invokevirtual 49	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:c	()[Z
            //   135: bipush 6
            //   137: baload
            //   138: ifeq +135 -> 273
            //   141: aload_0
            //   142: getfield 78	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:g	I
            //   145: istore_1
            //   146: aload 5
            //   148: iload_1
            //   149: putfield 79	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo:g	I
            //   152: aload 5
            //   154: areturn
            //   155: aload_0
            //   156: aload_0
            //   157: invokevirtual 35	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   160: iconst_0
            //   161: aaload
            //   162: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   165: checkcast 84	java/lang/CharSequence
            //   168: astore 4
            //   170: goto -146 -> 24
            //   173: aload_0
            //   174: aload_0
            //   175: invokevirtual 35	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   178: iconst_1
            //   179: aaload
            //   180: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   183: checkcast 52	java/lang/Long
            //   186: invokevirtual 88	java/lang/Long:longValue	()J
            //   189: lstore_2
            //   190: goto -145 -> 45
            //   193: aload_0
            //   194: aload_0
            //   195: invokevirtual 35	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   198: iconst_2
            //   199: aaload
            //   200: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   203: checkcast 52	java/lang/Long
            //   206: invokevirtual 88	java/lang/Long:longValue	()J
            //   209: lstore_2
            //   210: goto -145 -> 65
            //   213: aload_0
            //   214: aload_0
            //   215: invokevirtual 35	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   218: iconst_3
            //   219: aaload
            //   220: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   223: checkcast 37	java/lang/Integer
            //   226: invokevirtual 92	java/lang/Integer:intValue	()I
            //   229: istore_1
            //   230: goto -145 -> 85
            //   233: aload_0
            //   234: aload_0
            //   235: invokevirtual 35	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   238: iconst_4
            //   239: aaload
            //   240: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   243: checkcast 37	java/lang/Integer
            //   246: invokevirtual 92	java/lang/Integer:intValue	()I
            //   249: istore_1
            //   250: goto -145 -> 105
            //   253: aload_0
            //   254: aload_0
            //   255: invokevirtual 35	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   258: iconst_5
            //   259: aaload
            //   260: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   263: checkcast 37	java/lang/Integer
            //   266: invokevirtual 92	java/lang/Integer:intValue	()I
            //   269: istore_1
            //   270: goto -145 -> 125
            //   273: aload_0
            //   274: aload_0
            //   275: invokevirtual 35	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   278: bipush 6
            //   280: aaload
            //   281: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   284: checkcast 37	java/lang/Integer
            //   287: invokevirtual 92	java/lang/Integer:intValue	()I
            //   290: istore_1
            //   291: goto -145 -> 146
            //   294: astore 4
            //   296: new 94	com/flurry/sdk/fk
            //   299: dup
            //   300: aload 4
            //   302: invokespecial 97	com/flurry/sdk/fk:<init>	(Ljava/lang/Throwable;)V
            //   305: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	306	0	this	Builder
            //   84	207	1	i	int
            //   44	166	2	l	long
            //   22	147	4	localCharSequence	CharSequence
            //   294	7	4	localException	Exception
            //   7	146	5	localFrequencyCapInfo	FrequencyCapInfo
            // Exception table:
            //   from	to	target	type
            //   0	24	294	java/lang/Exception
            //   24	45	294	java/lang/Exception
            //   45	65	294	java/lang/Exception
            //   65	85	294	java/lang/Exception
            //   85	105	294	java/lang/Exception
            //   105	125	294	java/lang/Exception
            //   125	146	294	java/lang/Exception
            //   146	152	294	java/lang/Exception
            //   155	170	294	java/lang/Exception
            //   173	190	294	java/lang/Exception
            //   193	210	294	java/lang/Exception
            //   213	230	294	java/lang/Exception
            //   233	250	294	java/lang/Exception
            //   253	270	294	java/lang/Exception
            //   273	291	294	java/lang/Exception
        }

        public Builder b(int paramInt) {
            a(b()[4], Integer.valueOf(paramInt));
            this.e = paramInt;
            c()[4] = 1;
            return this;
        }

        public Builder b(long paramLong) {
            a(b()[2], Long.valueOf(paramLong));
            this.c = paramLong;
            c()[2] = 1;
            return this;
        }

        public Builder c(int paramInt) {
            a(b()[5], Integer.valueOf(paramInt));
            this.f = paramInt;
            c()[5] = 1;
            return this;
        }

        public Builder d(int paramInt) {
            a(b()[6], Integer.valueOf(paramInt));
            this.g = paramInt;
            c()[6] = 1;
            return this;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v10/FrequencyCapInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */