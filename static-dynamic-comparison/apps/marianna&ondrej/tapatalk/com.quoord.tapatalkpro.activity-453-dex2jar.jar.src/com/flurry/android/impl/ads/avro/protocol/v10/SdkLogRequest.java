package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn.q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import com.flurry.sdk.gx;

import java.util.List;

public class SdkLogRequest
        extends gw
        implements gv {
    public static final fn SCHEMA$ = new fn.q().a("{\"type\":\"record\",\"name\":\"SdkLogRequest\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"apiKey\",\"type\":\"string\"},{\"name\":\"adReportedIds\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdReportedId\",\"fields\":[{\"name\":\"type\",\"type\":\"int\"},{\"name\":\"id\",\"type\":\"bytes\"}]}}},{\"name\":\"sdkAdLogs\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"SdkAdLog\",\"fields\":[{\"name\":\"sessionId\",\"type\":\"long\"},{\"name\":\"adLogGUID\",\"type\":\"string\"},{\"name\":\"sdkAdEvents\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"SdkAdEvent\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"params\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"timeOffset\",\"type\":\"long\"}]}}}]}}},{\"name\":\"agentTimestamp\",\"type\":\"long\"},{\"name\":\"agentVersion\",\"type\":\"string\"},{\"name\":\"testDevice\",\"type\":\"boolean\",\"default\":false}]}");
    @Deprecated
    public CharSequence a;
    @Deprecated
    public List<AdReportedId> b;
    @Deprecated
    public List<SdkAdLog> c;
    @Deprecated
    public long d;
    @Deprecated
    public CharSequence e;
    @Deprecated
    public boolean f;

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
                return this.b;
            case 2:
                return this.c;
            case 3:
                return Long.valueOf(this.d);
            case 4:
                return this.e;
        }
        return Boolean.valueOf(this.f);
    }

    public void a(int paramInt, Object paramObject) {
        switch (paramInt) {
            default:
                throw new fk("Bad index");
            case 0:
                this.a = ((CharSequence) paramObject);
                return;
            case 1:
                this.b = ((List) paramObject);
                return;
            case 2:
                this.c = ((List) paramObject);
                return;
            case 3:
                this.d = ((Long) paramObject).longValue();
                return;
            case 4:
                this.e = ((CharSequence) paramObject);
                return;
        }
        this.f = ((Boolean) paramObject).booleanValue();
    }

    public static class Builder
            extends gx<SdkLogRequest> {
        private CharSequence a;
        private List<AdReportedId> b;
        private List<SdkAdLog> c;
        private long d;
        private CharSequence e;
        private boolean f;

        private Builder() {
            super();
        }

        public Builder a(long paramLong) {
            a(b()[3], Long.valueOf(paramLong));
            this.d = paramLong;
            c()[3] = 1;
            return this;
        }

        public Builder a(CharSequence paramCharSequence) {
            a(b()[0], paramCharSequence);
            this.a = paramCharSequence;
            c()[0] = 1;
            return this;
        }

        public Builder a(List<AdReportedId> paramList) {
            a(b()[1], paramList);
            this.b = paramList;
            c()[1] = 1;
            return this;
        }

        public Builder a(boolean paramBoolean) {
            a(b()[5], Boolean.valueOf(paramBoolean));
            this.f = paramBoolean;
            c()[5] = 1;
            return this;
        }

        /* Error */
        public SdkLogRequest a() {
            // Byte code:
            //   0: new 7	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest
            //   3: dup
            //   4: invokespecial 71	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest:<init>	()V
            //   7: astore 5
            //   9: aload_0
            //   10: invokevirtual 51	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:c	()[Z
            //   13: iconst_0
            //   14: baload
            //   15: ifeq +125 -> 140
            //   18: aload_0
            //   19: getfield 54	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:a	Ljava/lang/CharSequence;
            //   22: astore 4
            //   24: aload 5
            //   26: aload 4
            //   28: putfield 72	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest:a	Ljava/lang/CharSequence;
            //   31: aload_0
            //   32: invokevirtual 51	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:c	()[Z
            //   35: iconst_1
            //   36: baload
            //   37: ifeq +121 -> 158
            //   40: aload_0
            //   41: getfield 57	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:b	Ljava/util/List;
            //   44: astore 4
            //   46: aload 5
            //   48: aload 4
            //   50: putfield 73	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest:b	Ljava/util/List;
            //   53: aload_0
            //   54: invokevirtual 51	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:c	()[Z
            //   57: iconst_2
            //   58: baload
            //   59: ifeq +117 -> 176
            //   62: aload_0
            //   63: getfield 75	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:c	Ljava/util/List;
            //   66: astore 4
            //   68: aload 5
            //   70: aload 4
            //   72: putfield 76	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest:c	Ljava/util/List;
            //   75: aload_0
            //   76: invokevirtual 51	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:c	()[Z
            //   79: iconst_3
            //   80: baload
            //   81: ifeq +113 -> 194
            //   84: aload_0
            //   85: getfield 48	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:d	J
            //   88: lstore_1
            //   89: aload 5
            //   91: lload_1
            //   92: putfield 77	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest:d	J
            //   95: aload_0
            //   96: invokevirtual 51	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:c	()[Z
            //   99: iconst_4
            //   100: baload
            //   101: ifeq +113 -> 214
            //   104: aload_0
            //   105: getfield 79	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:e	Ljava/lang/CharSequence;
            //   108: astore 4
            //   110: aload 5
            //   112: aload 4
            //   114: putfield 80	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest:e	Ljava/lang/CharSequence;
            //   117: aload_0
            //   118: invokevirtual 51	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:c	()[Z
            //   121: iconst_5
            //   122: baload
            //   123: ifeq +109 -> 232
            //   126: aload_0
            //   127: getfield 67	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:f	Z
            //   130: istore_3
            //   131: aload 5
            //   133: iload_3
            //   134: putfield 81	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest:f	Z
            //   137: aload 5
            //   139: areturn
            //   140: aload_0
            //   141: aload_0
            //   142: invokevirtual 37	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   145: iconst_0
            //   146: aaload
            //   147: invokevirtual 84	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   150: checkcast 86	java/lang/CharSequence
            //   153: astore 4
            //   155: goto -131 -> 24
            //   158: aload_0
            //   159: aload_0
            //   160: invokevirtual 37	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   163: iconst_1
            //   164: aaload
            //   165: invokevirtual 84	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   168: checkcast 88	java/util/List
            //   171: astore 4
            //   173: goto -127 -> 46
            //   176: aload_0
            //   177: aload_0
            //   178: invokevirtual 37	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   181: iconst_2
            //   182: aaload
            //   183: invokevirtual 84	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   186: checkcast 88	java/util/List
            //   189: astore 4
            //   191: goto -123 -> 68
            //   194: aload_0
            //   195: aload_0
            //   196: invokevirtual 37	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   199: iconst_3
            //   200: aaload
            //   201: invokevirtual 84	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   204: checkcast 39	java/lang/Long
            //   207: invokevirtual 92	java/lang/Long:longValue	()J
            //   210: lstore_1
            //   211: goto -122 -> 89
            //   214: aload_0
            //   215: aload_0
            //   216: invokevirtual 37	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   219: iconst_4
            //   220: aaload
            //   221: invokevirtual 84	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   224: checkcast 86	java/lang/CharSequence
            //   227: astore 4
            //   229: goto -119 -> 110
            //   232: aload_0
            //   233: aload_0
            //   234: invokevirtual 37	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   237: iconst_5
            //   238: aaload
            //   239: invokevirtual 84	com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   242: checkcast 62	java/lang/Boolean
            //   245: invokevirtual 96	java/lang/Boolean:booleanValue	()Z
            //   248: istore_3
            //   249: goto -118 -> 131
            //   252: astore 4
            //   254: new 98	com/flurry/sdk/fk
            //   257: dup
            //   258: aload 4
            //   260: invokespecial 101	com/flurry/sdk/fk:<init>	(Ljava/lang/Throwable;)V
            //   263: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	264	0	this	Builder
            //   88	123	1	l	long
            //   130	119	3	bool	boolean
            //   22	206	4	localObject	Object
            //   252	7	4	localException	Exception
            //   7	131	5	localSdkLogRequest	SdkLogRequest
            // Exception table:
            //   from	to	target	type
            //   0	24	252	java/lang/Exception
            //   24	46	252	java/lang/Exception
            //   46	68	252	java/lang/Exception
            //   68	89	252	java/lang/Exception
            //   89	110	252	java/lang/Exception
            //   110	131	252	java/lang/Exception
            //   131	137	252	java/lang/Exception
            //   140	155	252	java/lang/Exception
            //   158	173	252	java/lang/Exception
            //   176	191	252	java/lang/Exception
            //   194	211	252	java/lang/Exception
            //   214	229	252	java/lang/Exception
            //   232	249	252	java/lang/Exception
        }

        public Builder b(CharSequence paramCharSequence) {
            a(b()[4], paramCharSequence);
            this.e = paramCharSequence;
            c()[4] = 1;
            return this;
        }

        public Builder b(List<SdkAdLog> paramList) {
            a(b()[2], paramList);
            this.c = paramList;
            c()[2] = 1;
            return this;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v10/SdkLogRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */