package com.millennialmedia.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.util.Map;
import java.util.Random;

class MMAdView$MMAdViewMMAdImpl
        extends MMLayout.MMLayoutMMAdImpl {
    public MMAdView$MMAdViewMMAdImpl(MMAdView paramMMAdView, Context paramContext) {
        super(paramMMAdView, paramContext);
        this.m = new MMAdView.MMAdViewWebViewClientListener(this);
    }

    void a(Bitmap paramBitmap) {
        this.a.a.setImageBitmap(paramBitmap);
        this.a.a.setVisibility(0);
        this.a.a.bringToFront();
    }

    void a(Map<String, String> paramMap) {
        if (this.a.c > 0) {
            paramMap.put("hsht", String.valueOf(this.a.c));
        }
        if (this.a.d > 0) {
            paramMap.put("hswd", String.valueOf(this.a.d));
        }
        super.a(paramMap);
    }

    boolean h() {
        return this.a.b != 0;
    }

    public boolean hasCachedVideoSupport() {
        return false;
    }

    void i() {
        Object localObject;
        if (this.a.a.getDrawable() != null) {
            int j = this.a.b;
            int i = j;
            if (j == 4) {
                i = new Random().nextInt(4);
            }
            switch (i) {
                default:
                    localObject = new AlphaAnimation(1.0F, 0.0F);
            }
        }
        for (; ; ) {
            ((Animation) localObject).setDuration(1000L);
            ((Animation) localObject).setAnimationListener(this.a);
            ((Animation) localObject).setFillEnabled(true);
            ((Animation) localObject).setFillBefore(true);
            ((Animation) localObject).setFillAfter(true);
            MMSDK.a(new MMAdView.MMAdViewMMAdImpl .1 (this, (Animation) localObject));
            return;
            localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.a.getHeight());
            continue;
            localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.a.getHeight());
        }
    }

    public boolean isBanner() {
        return true;
    }

    String m() {
        return "millennialmedia.action.ACTION_GETAD_FAILED";
    }

    String n() {
        return "millennialmedia.action.ACTION_GETAD_SUCCEEDED";
    }

    String o() {
        return "getad";
    }

    boolean q() {
        return this.a.getWindowToken() != null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMAdView$MMAdViewMMAdImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */