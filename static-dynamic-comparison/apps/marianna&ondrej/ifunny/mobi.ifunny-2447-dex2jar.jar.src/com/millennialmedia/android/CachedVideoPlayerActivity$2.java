package com.millennialmedia.android;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

class CachedVideoPlayerActivity$2
        implements View.OnClickListener {
    CachedVideoPlayerActivity$2(CachedVideoPlayerActivity paramCachedVideoPlayerActivity, ImageButton paramImageButton, VideoImage paramVideoImage) {
    }

    public void onClick(View paramView) {
        if (this.a != null) {
            this.a.setEnabled(false);
        }
        this.c.h.d = this.b.e;
        this.c.e(this.b.d);
        this.c.a(this.b);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/CachedVideoPlayerActivity$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */