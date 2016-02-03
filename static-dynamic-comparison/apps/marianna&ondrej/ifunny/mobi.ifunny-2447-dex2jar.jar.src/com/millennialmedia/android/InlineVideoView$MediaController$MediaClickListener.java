package com.millennialmedia.android;

import android.view.View;
import android.view.View.OnClickListener;

import java.lang.ref.WeakReference;

final class InlineVideoView$MediaController$MediaClickListener
        implements View.OnClickListener {
    private WeakReference<InlineVideoView> a;

    public InlineVideoView$MediaController$MediaClickListener(InlineVideoView paramInlineVideoView) {
        this.a = new WeakReference(paramInlineVideoView);
    }

    public void onClick(View paramView) {
        InlineVideoView localInlineVideoView = (InlineVideoView) this.a.get();
        if (localInlineVideoView != null) {
            localInlineVideoView.a(paramView);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/InlineVideoView$MediaController$MediaClickListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */