package com.mopub.mobileads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View.OnTouchListener;

class ToolbarWidget$Builder {
    private final Context context;
    private String defaultText;
    private Drawable drawable;
    private int drawableAlign;
    private boolean hasDrawable;
    private boolean hasText;
    private View.OnTouchListener onTouchListener;
    private int textAlign;
    private int visibility;
    private float weight;
    private int widgetGravity;

    ToolbarWidget$Builder(Context paramContext) {
        this.context = paramContext;
        this.weight = 1.0F;
        this.widgetGravity = 17;
        this.visibility = 0;
        this.textAlign = 9;
        this.drawableAlign = 11;
    }

    ToolbarWidget build() {
        return new ToolbarWidget(this, null);
    }

    Builder defaultText(String paramString) {
        this.hasText = true;
        this.defaultText = paramString;
        return this;
    }

    Builder drawable(Drawable paramDrawable) {
        this.hasDrawable = true;
        this.drawable = paramDrawable;
        return this;
    }

    Builder drawableAlign(int paramInt) {
        this.drawableAlign = paramInt;
        return this;
    }

    Builder hasDrawable() {
        this.hasDrawable = true;
        return this;
    }

    Builder hasText() {
        this.hasText = true;
        return this;
    }

    Builder onTouchListener(View.OnTouchListener paramOnTouchListener) {
        this.onTouchListener = paramOnTouchListener;
        return this;
    }

    Builder textAlign(int paramInt) {
        this.textAlign = paramInt;
        return this;
    }

    Builder visibility(int paramInt) {
        this.visibility = paramInt;
        return this;
    }

    Builder weight(float paramFloat) {
        this.weight = paramFloat;
        return this;
    }

    Builder widgetGravity(int paramInt) {
        this.widgetGravity = paramInt;
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/ToolbarWidget$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */