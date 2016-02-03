package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn.q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import com.flurry.sdk.gx;

import java.util.List;

public class TargetingOverride
        extends gw
        implements gv {
    public static final fn SCHEMA$ = new fn.q().a("{\"type\":\"record\",\"name\":\"TargetingOverride\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"ageRange\",\"type\":\"int\",\"default\":-2},{\"name\":\"gender\",\"type\":\"int\",\"default\":-2},{\"name\":\"personas\",\"type\":{\"type\":\"array\",\"items\":\"int\"},\"default\":[]}]}");
    @Deprecated
    public int a;
    @Deprecated
    public int b;
    @Deprecated
    public List<Integer> c;

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
        }
        return this.c;
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
        }
        this.c = ((List) paramObject);
    }

    public static class Builder
            extends gx<TargetingOverride> {
        private Builder() {
            super();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v10/TargetingOverride.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */