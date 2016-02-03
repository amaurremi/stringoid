package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn.q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import com.flurry.sdk.gx;

import java.util.List;

public class AdResponse
        extends gw
        implements gv {
    public static final fn SCHEMA$ = new fn.q().a("{\"type\":\"record\",\"name\":\"AdResponse\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"adUnits\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdUnit\",\"fields\":[{\"name\":\"adSpace\",\"type\":\"string\"},{\"name\":\"expiration\",\"type\":\"long\"},{\"name\":\"adFrames\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdFrame\",\"fields\":[{\"name\":\"binding\",\"type\":\"int\"},{\"name\":\"display\",\"type\":\"string\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"adSpaceLayout\",\"type\":{\"type\":\"record\",\"name\":\"AdSpaceLayout\",\"fields\":[{\"name\":\"adWidth\",\"type\":\"int\"},{\"name\":\"adHeight\",\"type\":\"int\"},{\"name\":\"fix\",\"type\":\"string\"},{\"name\":\"format\",\"type\":\"string\"},{\"name\":\"alignment\",\"type\":\"string\"}]}},{\"name\":\"callbacks\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Callback\",\"fields\":[{\"name\":\"event\",\"type\":\"string\"},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}}},{\"name\":\"adGuid\",\"type\":\"string\"},{\"name\":\"cachingEnum\",\"type\":\"int\",\"default\":1},{\"name\":\"assetExpirationTimestampUTCMillis\",\"type\":\"long\"},{\"name\":\"cacheWhitelistedAssets\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]},{\"name\":\"cacheBlacklistedAssets\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]}]}}},{\"name\":\"combinable\",\"type\":\"int\",\"default\":0},{\"name\":\"groupId\",\"type\":\"string\"},{\"name\":\"idHash\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"serveTime\",\"type\":\"long\"},{\"name\":\"newCap\",\"type\":\"int\",\"default\":-1},{\"name\":\"previousCap\",\"type\":\"int\",\"default\":-1},{\"name\":\"previousCapType\",\"type\":\"int\",\"default\":0},{\"name\":\"expirationTime\",\"type\":\"long\"},{\"name\":\"price\",\"type\":\"long\",\"default\":0},{\"name\":\"adomain\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"closableTime\",\"type\":\"long\",\"default\":0},{\"name\":\"rewardable\",\"type\":\"boolean\",\"default\":false},{\"name\":\"preRenderTimeoutMillis\",\"type\":\"long\",\"default\":10000},{\"name\":\"preCacheAdSkippableTimeLimitMillis\",\"type\":\"int\",\"default\":20000},{\"name\":\"videoAutoPlay\",\"type\":\"boolean\",\"default\":false},{\"name\":\"supportMRAID\",\"type\":\"boolean\",\"default\":false},{\"name\":\"preRender\",\"type\":\"boolean\",\"default\":true},{\"name\":\"renderTime\",\"type\":\"boolean\",\"default\":false},{\"name\":\"clientSideRtbPayload\",\"type\":{\"type\":\"map\",\"values\":\"string\"},\"default\":[]},{\"name\":\"screenOrientation\",\"type\":{\"type\":\"enum\",\"name\":\"ScreenOrientationType\",\"symbols\":[\"PORTRAIT\",\"LANDSCAPE\",\"UNKNOWN\"]},\"default\":\"UNKNOWN\"}]}}},{\"name\":\"errors\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]},{\"name\":\"configuration\",\"type\":[{\"type\":\"record\",\"name\":\"Configuration\",\"fields\":[{\"name\":\"sdkAssetUrl\",\"type\":\"string\"},{\"name\":\"cacheSizeMb\",\"type\":\"int\",\"default\":20},{\"name\":\"maxAssetSizeKb\",\"type\":\"int\",\"default\":2024}]},\"null\"],\"default\":\"null\"}]}");
    @Deprecated
    public List<AdUnit> a;
    @Deprecated
    public List<CharSequence> b;
    @Deprecated
    public Configuration c;

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
        return this.c;
    }

    public void a(int paramInt, Object paramObject) {
        switch (paramInt) {
            default:
                throw new fk("Bad index");
            case 0:
                this.a = ((List) paramObject);
                return;
            case 1:
                this.b = ((List) paramObject);
                return;
        }
        this.c = ((Configuration) paramObject);
    }

    public List<AdUnit> b() {
        return this.a;
    }

    public List<CharSequence> c() {
        return this.b;
    }

    public Configuration d() {
        return this.c;
    }

    public static class Builder
            extends gx<AdResponse> {
        private Builder() {
            super();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v10/AdResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */