package com.amazon.device.ads;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;

@TargetApi(16)
class ck {
    public static void a(View paramView, Drawable paramDrawable) {
        paramView.setBackground(paramDrawable);
    }

    protected static void a(ImageButton paramImageButton, int paramInt) {
        paramImageButton.setImageAlpha(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */