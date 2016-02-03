package com.millennialmedia.android;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

class MMAdView$ResizeView
        extends View {
    public MMAdView$ResizeView(MMAdView paramMMAdView, Context paramContext) {
        super(paramContext);
    }

    void a(View paramView) {
        try {
            MMAdView.b(this.a, paramView);
            if ((getParent() != null) && ((getParent() instanceof ViewGroup))) {
                ((ViewGroup) getParent()).addView(paramView);
            }
            return;
        } finally {
            paramView =finally;
            throw paramView;
        }
    }

    protected void onRestoreInstanceState(Parcelable paramParcelable) {
        MMLog.b("MMAdView", "onRestoreInstanceState");
        MMAdView.a(this.a, this.a);
        super.onRestoreInstanceState(paramParcelable);
    }

    protected Parcelable onSaveInstanceState() {
        MMLog.b("MMAdView", "onSaveInstanceState");
        a(this.a);
        return super.onSaveInstanceState();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMAdView$ResizeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */