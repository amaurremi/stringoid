package com.everimaging.fotorsdk.uil.core.display;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import com.everimaging.fotorsdk.uil.core.assist.LoadedFrom;

public class b
        implements a {
    private final int a;
    private final boolean b;
    private final boolean c;
    private final boolean d;

    public b(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
        this.a = paramInt;
        this.b = paramBoolean1;
        this.c = paramBoolean2;
        this.d = paramBoolean3;
    }

    public static void a(View paramView, int paramInt) {
        if (paramView != null) {
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
            localAlphaAnimation.setDuration(paramInt);
            localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
            paramView.startAnimation(localAlphaAnimation);
        }
    }

    public void a(Bitmap paramBitmap, com.everimaging.fotorsdk.uil.core.imageaware.a parama, LoadedFrom paramLoadedFrom) {
        parama.a(paramBitmap);
        if (((this.b) && (paramLoadedFrom == LoadedFrom.NETWORK)) || ((this.c) && (paramLoadedFrom == LoadedFrom.DISC_CACHE)) || ((this.d) && (paramLoadedFrom == LoadedFrom.MEMORY_CACHE))) {
            a(parama.d(), this.a);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/display/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */