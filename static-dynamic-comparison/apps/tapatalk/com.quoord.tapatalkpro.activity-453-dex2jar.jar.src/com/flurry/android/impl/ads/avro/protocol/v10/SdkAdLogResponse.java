package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fm;

public abstract interface SdkAdLogResponse {
    public static final fm a = fm.a("{\"protocol\":\"SdkAdLogResponse\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"types\":[{\"type\":\"record\",\"name\":\"SdkLogResponse\",\"fields\":[{\"name\":\"result\",\"type\":\"string\"},{\"name\":\"errors\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}],\"messages\":{}}");

    public static abstract interface Callback
            extends SdkAdLogResponse {
        public static final fm b = SdkAdLogResponse.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v10/SdkAdLogResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */