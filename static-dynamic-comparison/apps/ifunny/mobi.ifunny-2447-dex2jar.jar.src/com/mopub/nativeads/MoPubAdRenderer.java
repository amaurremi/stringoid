package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public abstract interface MoPubAdRenderer<T> {
    public abstract View createAdView(Context paramContext, ViewGroup paramViewGroup);

    public abstract void renderAdView(View paramView, T paramT);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/MoPubAdRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */