package com.inmobi.re.controller.util;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class AVPlayer$b
        implements View.OnTouchListener {
    AVPlayer$b(AVPlayer paramAVPlayer) {
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        return paramMotionEvent.getAction() == 2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/util/AVPlayer$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */