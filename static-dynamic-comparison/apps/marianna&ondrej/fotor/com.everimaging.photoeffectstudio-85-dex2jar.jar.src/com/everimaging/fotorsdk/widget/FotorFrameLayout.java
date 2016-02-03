package com.everimaging.fotorsdk.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FotorFrameLayout
        extends FrameLayout {
    public FotorFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    @TargetApi(16)
    public void setBackground(Drawable paramDrawable) {
        super.setBackground(paramDrawable);
    }

    public void setBackgroundColor(int paramInt) {
        super.setBackgroundColor(paramInt);
    }

    @Deprecated
    public void setBackgroundDrawable(Drawable paramDrawable) {
        super.setBackgroundDrawable(paramDrawable);
    }

    public void setBackgroundResource(int paramInt) {
        super.setBackgroundResource(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */