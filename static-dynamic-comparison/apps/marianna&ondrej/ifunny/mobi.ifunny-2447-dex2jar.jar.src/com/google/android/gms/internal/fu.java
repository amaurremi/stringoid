package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;

@ii
public final class fu
        extends FrameLayout
        implements View.OnClickListener {
    private final Activity a;
    private final ImageButton b;

    public fu(Activity paramActivity, int paramInt) {
        super(paramActivity);
        this.a = paramActivity;
        setOnClickListener(this);
        this.b = new ImageButton(paramActivity);
        this.b.setImageResource(17301527);
        this.b.setBackgroundColor(0);
        this.b.setOnClickListener(this);
        this.b.setPadding(0, 0, 0, 0);
        this.b.setContentDescription("Interstitial close button");
        paramInt = mv.a(paramActivity, paramInt);
        addView(this.b, new FrameLayout.LayoutParams(paramInt, paramInt, 17));
    }

    public void a(boolean paramBoolean) {
        ImageButton localImageButton = this.b;
        if (paramBoolean) {
        }
        for (int i = 4; ; i = 0) {
            localImageButton.setVisibility(i);
            return;
        }
    }

    public void onClick(View paramView) {
        this.a.finish();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/fu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */