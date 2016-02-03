package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn.q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import com.flurry.sdk.gx;

import java.nio.ByteBuffer;

public class AdReportedId
        extends gw
        implements gv {
    public static final fn SCHEMA$ = new fn.q().a("{\"type\":\"record\",\"name\":\"AdReportedId\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"type\",\"type\":\"int\"},{\"name\":\"id\",\"type\":\"bytes\"}]}");
    @Deprecated
    public int a;
    @Deprecated
    public ByteBuffer b;

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
        }
        return this.b;
    }

    public void a(int paramInt, Object paramObject) {
        switch (paramInt) {
            default:
                throw new fk("Bad index");
            case 0:
                this.a = ((Integer) paramObject).intValue();
                return;
        }
        this.b = ((ByteBuffer) paramObject);
    }

    public static class Builder
            extends gx<AdReportedId> {
        private int a;
        private ByteBuffer b;

        private Builder() {
            super();
        }

        public Builder a(int paramInt) {
            a(b()[0], Integer.valueOf(paramInt));
            this.a = paramInt;
            c()[0] = 1;
            return this;
        }

        public Builder a(ByteBuffer paramByteBuffer) {
            a(b()[1], paramByteBuffer);
            this.b = paramByteBuffer;
            c()[1] = 1;
            return this;
        }

        /* Error */
        public AdReportedId a() {
            // Byte code:
            //   0: new 7	com/flurry/android/impl/ads/avro/protocol/v10/AdReportedId
            //   3: dup
            //   4: invokespecial 51	com/flurry/android/impl/ads/avro/protocol/v10/AdReportedId:<init>	()V
            //   7: astore_3
            //   8: aload_0
            //   9: invokevirtual 44	com/flurry/android/impl/ads/avro/protocol/v10/AdReportedId$Builder:c	()[Z
            //   12: iconst_0
            //   13: baload
            //   14: ifeq +34 -> 48
            //   17: aload_0
            //   18: getfield 40	com/flurry/android/impl/ads/avro/protocol/v10/AdReportedId$Builder:a	I
            //   21: istore_1
            //   22: aload_3
            //   23: iload_1
            //   24: putfield 52	com/flurry/android/impl/ads/avro/protocol/v10/AdReportedId:a	I
            //   27: aload_0
            //   28: invokevirtual 44	com/flurry/android/impl/ads/avro/protocol/v10/AdReportedId$Builder:c	()[Z
            //   31: iconst_1
            //   32: baload
            //   33: ifeq +35 -> 68
            //   36: aload_0
            //   37: getfield 47	com/flurry/android/impl/ads/avro/protocol/v10/AdReportedId$Builder:b	Ljava/nio/ByteBuffer;
            //   40: astore_2
            //   41: aload_3
            //   42: aload_2
            //   43: putfield 53	com/flurry/android/impl/ads/avro/protocol/v10/AdReportedId:b	Ljava/nio/ByteBuffer;
            //   46: aload_3
            //   47: areturn
            //   48: aload_0
            //   49: aload_0
            //   50: invokevirtual 29	com/flurry/android/impl/ads/avro/protocol/v10/AdReportedId$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   53: iconst_0
            //   54: aaload
            //   55: invokevirtual 56	com/flurry/android/impl/ads/avro/protocol/v10/AdReportedId$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   58: checkcast 31	java/lang/Integer
            //   61: invokevirtual 60	java/lang/Integer:intValue	()I
            //   64: istore_1
            //   65: goto -43 -> 22
            //   68: aload_0
            //   69: aload_0
            //   70: invokevirtual 29	com/flurry/android/impl/ads/avro/protocol/v10/AdReportedId$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   73: iconst_1
            //   74: aaload
            //   75: invokevirtual 56	com/flurry/android/impl/ads/avro/protocol/v10/AdReportedId$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   78: checkcast 62	java/nio/ByteBuffer
            //   81: astore_2
            //   82: goto -41 -> 41
            //   85: astore_2
            //   86: new 64	com/flurry/sdk/fk
            //   89: dup
            //   90: aload_2
            //   91: invokespecial 67	com/flurry/sdk/fk:<init>	(Ljava/lang/Throwable;)V
            //   94: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	95	0	this	Builder
            //   21	44	1	i	int
            //   40	42	2	localByteBuffer	ByteBuffer
            //   85	6	2	localException	Exception
            //   7	40	3	localAdReportedId	AdReportedId
            // Exception table:
            //   from	to	target	type
            //   0	22	85	java/lang/Exception
            //   22	41	85	java/lang/Exception
            //   41	46	85	java/lang/Exception
            //   48	65	85	java/lang/Exception
            //   68	82	85	java/lang/Exception
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v10/AdReportedId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */