package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

final class l
        extends GestureDetector {
    private final View a;
    private Handler b = new Handler();
    private Runnable c = new l
    .1(this);
    private IAadReportGestureListener d;
    private l.a e;

    l(Context paramContext, View paramView, IAadConfig paramIAadConfig) {
        this(paramContext, paramView, new IAadReportGestureListener(paramView, paramIAadConfig));
    }

    private l(Context paramContext, View paramView, IAadReportGestureListener paramIAadReportGestureListener) {
        super(paramContext, paramIAadReportGestureListener);
        this.d = paramIAadReportGestureListener;
        this.a = paramView;
        setIsLongpressEnabled(false);
    }

    final void a() {
        this.d.c();
    }

    final void a(MotionEvent paramMotionEvent) {
        int j = 0;
        switch (paramMotionEvent.getAction()) {
            default:
                return;
            case 1:
                if (this.e != null) {
                    this.e.onClickOccurs();
                }
                for (; ; ) {
                    this.b.removeCallbacks(this.c);
                    this.d.a();
                    return;
                    InneractiveAdView.Log.v("Inneractive_verbose", "onClickOccurs() is not registered.");
                }
            case 0:
                onTouchEvent(paramMotionEvent);
                this.b.postDelayed(this.c, 6000L);
                return;
        }
        View localView = this.a;
        int i = j;
        if (paramMotionEvent != null) {
            if (localView != null) {
                break label135;
            }
            i = j;
        }
        while (i != 0) {
            onTouchEvent(paramMotionEvent);
            return;
            label135:
            float f1 = paramMotionEvent.getX();
            float f2 = paramMotionEvent.getY();
            i = j;
            if (f1 >= 0.0F) {
                i = j;
                if (f1 <= localView.getWidth()) {
                    i = j;
                    if (f2 >= 0.0F) {
                        i = j;
                        if (f2 <= localView.getHeight()) {
                            i = 1;
                        }
                    }
                }
            }
        }
        this.d.b();
    }

    final void a(l.a parama) {
        this.e = parama;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */