package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn.q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import com.flurry.sdk.gx;

public class AdSpaceLayout
        extends gw
        implements gv {
    public static final fn SCHEMA$ = new fn.q().a("{\"type\":\"record\",\"name\":\"AdSpaceLayout\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"adWidth\",\"type\":\"int\"},{\"name\":\"adHeight\",\"type\":\"int\"},{\"name\":\"fix\",\"type\":\"string\"},{\"name\":\"format\",\"type\":\"string\"},{\"name\":\"alignment\",\"type\":\"string\"}]}");
    @Deprecated
    public int a;
    @Deprecated
    public int b;
    @Deprecated
    public CharSequence c;
    @Deprecated
    public CharSequence d;
    @Deprecated
    public CharSequence e;

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
                return this.c;
            case 3:
                return this.d;
        }
        return this.e;
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
                this.c = ((CharSequence) paramObject);
                return;
            case 3:
                this.d = ((CharSequence) paramObject);
                return;
        }
        this.e = ((CharSequence) paramObject);
    }

    public Integer b() {
        return Integer.valueOf(this.a);
    }

    public Integer c() {
        return Integer.valueOf(this.b);
    }

    public CharSequence d() {
        return this.c;
    }

    public CharSequence e() {
        return this.d;
    }

    public CharSequence f() {
        return this.e;
    }

    public static class Builder
            extends gx<AdSpaceLayout> {
        private Builder() {
            super();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v10/AdSpaceLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */