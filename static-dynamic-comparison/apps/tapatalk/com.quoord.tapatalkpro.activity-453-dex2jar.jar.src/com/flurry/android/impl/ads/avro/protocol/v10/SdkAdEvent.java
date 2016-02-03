package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn.q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import com.flurry.sdk.gx;

import java.util.Map;

public class SdkAdEvent
        extends gw
        implements gv {
    public static final fn SCHEMA$ = new fn.q().a("{\"type\":\"record\",\"name\":\"SdkAdEvent\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"params\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"timeOffset\",\"type\":\"long\"}]}");
    @Deprecated
    public CharSequence a;
    @Deprecated
    public Map<CharSequence, CharSequence> b;
    @Deprecated
    public long c;

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
        }
        return Long.valueOf(this.c);
    }

    public void a(int paramInt, Object paramObject) {
        switch (paramInt) {
            default:
                throw new fk("Bad index");
            case 0:
                this.a = ((CharSequence) paramObject);
                return;
            case 1:
                this.b = ((Map) paramObject);
                return;
        }
        this.c = ((Long) paramObject).longValue();
    }

    public void a(CharSequence paramCharSequence) {
        this.a = paramCharSequence;
    }

    public void a(Long paramLong) {
        this.c = paramLong.longValue();
    }

    public void a(Map<CharSequence, CharSequence> paramMap) {
        this.b = paramMap;
    }

    public static class Builder
            extends gx<SdkAdEvent> {
        private Builder() {
            super();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v10/SdkAdEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */