package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn.q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import com.flurry.sdk.gx;

import java.util.List;

public class AdFrame
        extends gw
        implements gv {
    public static final fn SCHEMA$ = new fn.q().a("{\"type\":\"record\",\"name\":\"AdFrame\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"binding\",\"type\":\"int\"},{\"name\":\"display\",\"type\":\"string\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"adSpaceLayout\",\"type\":{\"type\":\"record\",\"name\":\"AdSpaceLayout\",\"fields\":[{\"name\":\"adWidth\",\"type\":\"int\"},{\"name\":\"adHeight\",\"type\":\"int\"},{\"name\":\"fix\",\"type\":\"string\"},{\"name\":\"format\",\"type\":\"string\"},{\"name\":\"alignment\",\"type\":\"string\"}]}},{\"name\":\"callbacks\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Callback\",\"fields\":[{\"name\":\"event\",\"type\":\"string\"},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}}},{\"name\":\"adGuid\",\"type\":\"string\"},{\"name\":\"cachingEnum\",\"type\":\"int\",\"default\":1},{\"name\":\"assetExpirationTimestampUTCMillis\",\"type\":\"long\"},{\"name\":\"cacheWhitelistedAssets\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]},{\"name\":\"cacheBlacklistedAssets\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]}]}");
    @Deprecated
    public int a;
    @Deprecated
    public CharSequence b;
    @Deprecated
    public CharSequence c;
    @Deprecated
    public AdSpaceLayout d;
    @Deprecated
    public List<Callback> e;
    @Deprecated
    public CharSequence f;
    @Deprecated
    public int g;
    @Deprecated
    public long h;
    @Deprecated
    public List<CharSequence> i;
    @Deprecated
    public List<CharSequence> j;

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
                return this.b;
            case 2:
                return this.c;
            case 3:
                return this.d;
            case 4:
                return this.e;
            case 5:
                return this.f;
            case 6:
                return Integer.valueOf(this.g);
            case 7:
                return Long.valueOf(this.h);
            case 8:
                return this.i;
        }
        return this.j;
    }

    public void a(int paramInt, Object paramObject) {
        switch (paramInt) {
            default:
                throw new fk("Bad index");
            case 0:
                this.a = ((Integer) paramObject).intValue();
                return;
            case 1:
                this.b = ((CharSequence) paramObject);
                return;
            case 2:
                this.c = ((CharSequence) paramObject);
                return;
            case 3:
                this.d = ((AdSpaceLayout) paramObject);
                return;
            case 4:
                this.e = ((List) paramObject);
                return;
            case 5:
                this.f = ((CharSequence) paramObject);
                return;
            case 6:
                this.g = ((Integer) paramObject).intValue();
                return;
            case 7:
                this.h = ((Long) paramObject).longValue();
                return;
            case 8:
                this.i = ((List) paramObject);
                return;
        }
        this.j = ((List) paramObject);
    }

    public Integer b() {
        return Integer.valueOf(this.a);
    }

    public CharSequence c() {
        return this.b;
    }

    public CharSequence d() {
        return this.c;
    }

    public AdSpaceLayout e() {
        return this.d;
    }

    public List<Callback> f() {
        return this.e;
    }

    public CharSequence g() {
        return this.f;
    }

    public Integer h() {
        return Integer.valueOf(this.g);
    }

    public Long i() {
        return Long.valueOf(this.h);
    }

    public List<CharSequence> j() {
        return this.i;
    }

    public List<CharSequence> k() {
        return this.j;
    }

    public static class Builder
            extends gx<AdFrame> {
        private Builder() {
            super();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v10/AdFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */