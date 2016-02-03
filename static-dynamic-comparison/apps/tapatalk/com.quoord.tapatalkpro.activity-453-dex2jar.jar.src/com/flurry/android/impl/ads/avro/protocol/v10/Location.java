package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn.q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import com.flurry.sdk.gx;

public class Location
        extends gw
        implements gv {
    public static final fn SCHEMA$ = new fn.q().a("{\"type\":\"record\",\"name\":\"Location\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"lat\",\"type\":\"float\",\"default\":0.0},{\"name\":\"lon\",\"type\":\"float\",\"default\":0.0}]}");
    @Deprecated
    public float a;
    @Deprecated
    public float b;

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
                return Float.valueOf(this.a);
        }
        return Float.valueOf(this.b);
    }

    public void a(int paramInt, Object paramObject) {
        switch (paramInt) {
            default:
                throw new fk("Bad index");
            case 0:
                this.a = ((Float) paramObject).floatValue();
                return;
        }
        this.b = ((Float) paramObject).floatValue();
    }

    public static class Builder
            extends gx<Location> {
        private float a;
        private float b;

        private Builder() {
            super();
        }

        public Builder a(float paramFloat) {
            a(b()[0], Float.valueOf(paramFloat));
            this.a = paramFloat;
            c()[0] = 1;
            return this;
        }

        /* Error */
        public Location a() {
            // Byte code:
            //   0: new 7	com/flurry/android/impl/ads/avro/protocol/v10/Location
            //   3: dup
            //   4: invokespecial 47	com/flurry/android/impl/ads/avro/protocol/v10/Location:<init>	()V
            //   7: astore_2
            //   8: aload_0
            //   9: invokevirtual 43	com/flurry/android/impl/ads/avro/protocol/v10/Location$Builder:c	()[Z
            //   12: iconst_0
            //   13: baload
            //   14: ifeq +34 -> 48
            //   17: aload_0
            //   18: getfield 39	com/flurry/android/impl/ads/avro/protocol/v10/Location$Builder:a	F
            //   21: fstore_1
            //   22: aload_2
            //   23: fload_1
            //   24: putfield 48	com/flurry/android/impl/ads/avro/protocol/v10/Location:a	F
            //   27: aload_0
            //   28: invokevirtual 43	com/flurry/android/impl/ads/avro/protocol/v10/Location$Builder:c	()[Z
            //   31: iconst_1
            //   32: baload
            //   33: ifeq +35 -> 68
            //   36: aload_0
            //   37: getfield 50	com/flurry/android/impl/ads/avro/protocol/v10/Location$Builder:b	F
            //   40: fstore_1
            //   41: aload_2
            //   42: fload_1
            //   43: putfield 51	com/flurry/android/impl/ads/avro/protocol/v10/Location:b	F
            //   46: aload_2
            //   47: areturn
            //   48: aload_0
            //   49: aload_0
            //   50: invokevirtual 28	com/flurry/android/impl/ads/avro/protocol/v10/Location$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   53: iconst_0
            //   54: aaload
            //   55: invokevirtual 54	com/flurry/android/impl/ads/avro/protocol/v10/Location$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   58: checkcast 30	java/lang/Float
            //   61: invokevirtual 58	java/lang/Float:floatValue	()F
            //   64: fstore_1
            //   65: goto -43 -> 22
            //   68: aload_0
            //   69: aload_0
            //   70: invokevirtual 28	com/flurry/android/impl/ads/avro/protocol/v10/Location$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   73: iconst_1
            //   74: aaload
            //   75: invokevirtual 54	com/flurry/android/impl/ads/avro/protocol/v10/Location$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   78: checkcast 30	java/lang/Float
            //   81: invokevirtual 58	java/lang/Float:floatValue	()F
            //   84: fstore_1
            //   85: goto -44 -> 41
            //   88: astore_2
            //   89: new 60	com/flurry/sdk/fk
            //   92: dup
            //   93: aload_2
            //   94: invokespecial 63	com/flurry/sdk/fk:<init>	(Ljava/lang/Throwable;)V
            //   97: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	98	0	this	Builder
            //   21	64	1	f	float
            //   7	40	2	localLocation	Location
            //   88	6	2	localException	Exception
            // Exception table:
            //   from	to	target	type
            //   0	22	88	java/lang/Exception
            //   22	41	88	java/lang/Exception
            //   41	46	88	java/lang/Exception
            //   48	65	88	java/lang/Exception
            //   68	85	88	java/lang/Exception
        }

        public Builder b(float paramFloat) {
            a(b()[1], Float.valueOf(paramFloat));
            this.b = paramFloat;
            c()[1] = 1;
            return this;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v10/Location.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */