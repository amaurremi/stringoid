package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn.q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import com.flurry.sdk.gx;

public class Configuration
        extends gw
        implements gv {
    public static final fn SCHEMA$ = new fn.q().a("{\"type\":\"record\",\"name\":\"Configuration\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"sdkAssetUrl\",\"type\":\"string\"},{\"name\":\"cacheSizeMb\",\"type\":\"int\",\"default\":20},{\"name\":\"maxAssetSizeKb\",\"type\":\"int\",\"default\":2024}]}");
    @Deprecated
    public CharSequence a;
    @Deprecated
    public int b;
    @Deprecated
    public int c;

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
                return Integer.valueOf(this.b);
        }
        return Integer.valueOf(this.c);
    }

    public void a(int paramInt, Object paramObject) {
        switch (paramInt) {
            default:
                throw new fk("Bad index");
            case 0:
                this.a = ((CharSequence) paramObject);
                return;
            case 1:
                this.b = ((Integer) paramObject).intValue();
                return;
        }
        this.c = ((Integer) paramObject).intValue();
    }

    public CharSequence b() {
        return this.a;
    }

    public Integer c() {
        return Integer.valueOf(this.b);
    }

    public Integer d() {
        return Integer.valueOf(this.c);
    }

    public static class Builder
            extends gx<Configuration> {
        private Builder() {
            super();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v10/Configuration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */