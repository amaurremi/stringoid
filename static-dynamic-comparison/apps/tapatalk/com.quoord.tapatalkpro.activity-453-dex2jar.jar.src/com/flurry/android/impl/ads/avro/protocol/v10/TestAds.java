package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn.q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import com.flurry.sdk.gx;

public class TestAds
        extends gw
        implements gv {
    public static final fn SCHEMA$ = new fn.q().a("{\"type\":\"record\",\"name\":\"TestAds\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"adspacePlacement\",\"type\":\"int\",\"default\":0}]}");
    @Deprecated
    public int a;

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
        }
        return Integer.valueOf(this.a);
    }

    public void a(int paramInt, Object paramObject) {
        switch (paramInt) {
            default:
                throw new fk("Bad index");
        }
        this.a = ((Integer) paramObject).intValue();
    }

    public static class Builder
            extends gx<TestAds> {
        private int a;

        private Builder() {
            super();
        }

        public Builder a(int paramInt) {
            a(b()[0], Integer.valueOf(paramInt));
            this.a = paramInt;
            c()[0] = 1;
            return this;
        }

        /* Error */
        public TestAds a() {
            // Byte code:
            //   0: new 7	com/flurry/android/impl/ads/avro/protocol/v10/TestAds
            //   3: dup
            //   4: invokespecial 47	com/flurry/android/impl/ads/avro/protocol/v10/TestAds:<init>	()V
            //   7: astore_2
            //   8: aload_0
            //   9: invokevirtual 43	com/flurry/android/impl/ads/avro/protocol/v10/TestAds$Builder:c	()[Z
            //   12: iconst_0
            //   13: baload
            //   14: ifeq +15 -> 29
            //   17: aload_0
            //   18: getfield 39	com/flurry/android/impl/ads/avro/protocol/v10/TestAds$Builder:a	I
            //   21: istore_1
            //   22: aload_2
            //   23: iload_1
            //   24: putfield 48	com/flurry/android/impl/ads/avro/protocol/v10/TestAds:a	I
            //   27: aload_2
            //   28: areturn
            //   29: aload_0
            //   30: aload_0
            //   31: invokevirtual 28	com/flurry/android/impl/ads/avro/protocol/v10/TestAds$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   34: iconst_0
            //   35: aaload
            //   36: invokevirtual 51	com/flurry/android/impl/ads/avro/protocol/v10/TestAds$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   39: checkcast 30	java/lang/Integer
            //   42: invokevirtual 55	java/lang/Integer:intValue	()I
            //   45: istore_1
            //   46: goto -24 -> 22
            //   49: astore_2
            //   50: new 57	com/flurry/sdk/fk
            //   53: dup
            //   54: aload_2
            //   55: invokespecial 60	com/flurry/sdk/fk:<init>	(Ljava/lang/Throwable;)V
            //   58: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	59	0	this	Builder
            //   21	25	1	i	int
            //   7	21	2	localTestAds	TestAds
            //   49	6	2	localException	Exception
            // Exception table:
            //   from	to	target	type
            //   0	22	49	java/lang/Exception
            //   22	27	49	java/lang/Exception
            //   29	46	49	java/lang/Exception
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v10/TestAds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */