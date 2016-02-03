package com.mopub.nativeads;

import java.util.Map;

public final class ViewBinder {
    final int callToActionId;
    final Map<String, Integer> extras;
    final int iconImageId;
    final int layoutId;
    final int mainImageId;
    final int textId;
    final int titleId;

    private ViewBinder(ViewBinder.Builder paramBuilder) {
        this.layoutId = ViewBinder.Builder.access$100(paramBuilder);
        this.titleId = ViewBinder.Builder.access$200(paramBuilder);
        this.textId = ViewBinder.Builder.access$300(paramBuilder);
        this.callToActionId = ViewBinder.Builder.access$400(paramBuilder);
        this.mainImageId = ViewBinder.Builder.access$500(paramBuilder);
        this.iconImageId = ViewBinder.Builder.access$600(paramBuilder);
        this.extras = ViewBinder.Builder.access$700(paramBuilder);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/ViewBinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */