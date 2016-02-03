package com.everimaging.fotorsdk.brush.toolkit;

import android.graphics.RectF;

public class DirtyRegion
        extends RectF {
    public void a(float paramFloat1, float paramFloat2) {
        this.right = paramFloat1;
        this.left = paramFloat1;
        this.bottom = paramFloat2;
        this.top = paramFloat2;
    }

    public void b(float paramFloat1, float paramFloat2) {
        if (paramFloat1 < this.left) {
            this.left = paramFloat1;
        }
        if (paramFloat1 > this.right) {
            this.right = paramFloat1;
        }
        if (paramFloat2 < this.top) {
            this.top = paramFloat2;
        }
        if (paramFloat2 > this.bottom) {
            this.bottom = paramFloat2;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/brush/toolkit/DirtyRegion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */