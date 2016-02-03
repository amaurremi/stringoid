package com.inneractive.api.ads.sdk;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class h$3
        implements Animation.AnimationListener {
    h$3(h paramh) {
    }

    public final void onAnimationEnd(Animation paramAnimation) {
        if ((paramAnimation == this.a.b) && (h.a(this.a) != null)) {
            InneractiveAdView.Log.v("Inneractive_verbose", "onAnimationEnd - FADE OUT");
            h.a(this.a).setVisibility(4);
        }
        while ((paramAnimation != this.a.c) || (h.a(this.a) == null)) {
            return;
        }
        InneractiveAdView.Log.v("Inneractive_verbose", "onAnimationEnd - FADE IN");
        h.a(this.a).setVisibility(0);
    }

    public final void onAnimationRepeat(Animation paramAnimation) {
    }

    public final void onAnimationStart(Animation paramAnimation) {
        if ((paramAnimation == this.a.c) && (h.a(this.a) != null)) {
            InneractiveAdView.Log.v("Inneractive_verbose", "onAnimationStart -FADE IN");
            h.a(this.a).setVisibility(0);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/h$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */