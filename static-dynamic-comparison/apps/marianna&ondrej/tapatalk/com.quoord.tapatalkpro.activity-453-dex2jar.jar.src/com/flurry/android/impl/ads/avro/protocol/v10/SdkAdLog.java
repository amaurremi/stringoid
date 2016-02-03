package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn.q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import com.flurry.sdk.gx;

import java.util.List;

public class SdkAdLog
        extends gw
        implements gv {
    public static final fn SCHEMA$ = new fn.q().a("{\"type\":\"record\",\"name\":\"SdkAdLog\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"sessionId\",\"type\":\"long\"},{\"name\":\"adLogGUID\",\"type\":\"string\"},{\"name\":\"sdkAdEvents\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"SdkAdEvent\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"params\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"timeOffset\",\"type\":\"long\"}]}}}]}");
    @Deprecated
    public long a;
    @Deprecated
    public CharSequence b;
    @Deprecated
    public List<SdkAdEvent> c;

    public fn a() {
        return SCHEMA$;
    }

    public Object a(int paramInt) {
        switch (paramInt) {
            default:
                throw new fk("Bad index");
            case 0:
                return Long.valueOf(this.a);
            case 1:
                return this.b;
        }
        return this.c;
    }

    public void a(int paramInt, Object paramObject) {
        switch (paramInt) {
            default:
                throw new fk("Bad index");
            case 0:
                this.a = ((Long) paramObject).longValue();
                return;
            case 1:
                this.b = ((CharSequence) paramObject);
                return;
        }
        this.c = ((List) paramObject);
    }

    public void a(CharSequence paramCharSequence) {
        this.b = paramCharSequence;
    }

    public void a(Long paramLong) {
        this.a = paramLong.longValue();
    }

    public void a(List<SdkAdEvent> paramList) {
        this.c = paramList;
    }

    public static class Builder
            extends gx<SdkAdLog> {
        private Builder() {
            super();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v10/SdkAdLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */