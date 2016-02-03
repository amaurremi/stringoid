package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fm;

public abstract interface SdkAdLogRequest {
    public static final fm a = fm.a("{\"protocol\":\"SdkAdLogRequest\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"types\":[{\"type\":\"record\",\"name\":\"AdReportedId\",\"fields\":[{\"name\":\"type\",\"type\":\"int\"},{\"name\":\"id\",\"type\":\"bytes\"}]},{\"type\":\"record\",\"name\":\"SdkAdEvent\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"params\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"timeOffset\",\"type\":\"long\"}]},{\"type\":\"record\",\"name\":\"SdkAdLog\",\"fields\":[{\"name\":\"sessionId\",\"type\":\"long\"},{\"name\":\"adLogGUID\",\"type\":\"string\"},{\"name\":\"sdkAdEvents\",\"type\":{\"type\":\"array\",\"items\":\"SdkAdEvent\"}}]},{\"type\":\"record\",\"name\":\"SdkLogRequest\",\"fields\":[{\"name\":\"apiKey\",\"type\":\"string\"},{\"name\":\"adReportedIds\",\"type\":{\"type\":\"array\",\"items\":\"AdReportedId\"}},{\"name\":\"sdkAdLogs\",\"type\":{\"type\":\"array\",\"items\":\"SdkAdLog\"}},{\"name\":\"agentTimestamp\",\"type\":\"long\"},{\"name\":\"agentVersion\",\"type\":\"string\"},{\"name\":\"testDevice\",\"type\":\"boolean\",\"default\":false}]}],\"messages\":{}}");

    public static abstract interface Callback
            extends SdkAdLogRequest {
        public static final fm b = SdkAdLogRequest.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v10/SdkAdLogRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */