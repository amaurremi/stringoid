package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MraidView$1
        implements View.OnTouchListener {
    MraidView$1(MraidView paramMraidView) {
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        MraidView.access$000(this.this$0).sendTouchEvent(paramMotionEvent);
        switch (paramMotionEvent.getAction()) {
        }
        for (; ; ) {
            return false;
            if (!paramView.hasFocus()) {
                paramView.requestFocus();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */