package com.millennialmedia.android;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;

class AdViewOverlayView$SetCloseButtonTouchDelegateRunnable
        implements Runnable {
    int a;
    int b;
    int c;
    int d;
    private final Button e;

    AdViewOverlayView$SetCloseButtonTouchDelegateRunnable(Button paramButton, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.e = paramButton;
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramInt3;
        this.d = paramInt4;
    }

    public void run() {
        Object localObject = new Rect();
        this.e.getHitRect((Rect) localObject);
        ((Rect) localObject).top += this.a;
        ((Rect) localObject).right += this.d;
        ((Rect) localObject).bottom += this.c;
        ((Rect) localObject).left += this.b;
        localObject = new TouchDelegate((Rect) localObject, this.e);
        if (View.class.isInstance(this.e.getParent())) {
            ((View) this.e.getParent()).setTouchDelegate((TouchDelegate) localObject);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/AdViewOverlayView$SetCloseButtonTouchDelegateRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */