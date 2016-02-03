package com.mopub.mobileads.util.vast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VastCompanionAd
        implements Serializable {
    private static final long serialVersionUID = 0L;
    private final Integer a;
    private final Integer b;
    private final String c;
    private final String d;
    private final ArrayList<String> e;

    public VastCompanionAd(Integer paramInteger1, Integer paramInteger2, String paramString1, String paramString2, ArrayList<String> paramArrayList) {
        this.a = paramInteger1;
        this.b = paramInteger2;
        this.c = paramString1;
        this.d = paramString2;
        this.e = paramArrayList;
    }

    public String getClickThroughUrl() {
        return this.d;
    }

    public List<String> getClickTrackers() {
        return this.e;
    }

    public Integer getHeight() {
        return this.b;
    }

    public String getImageUrl() {
        return this.c;
    }

    public Integer getWidth() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/util/vast/VastCompanionAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */