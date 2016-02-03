package com.everimaging.fotor.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class LockEventView
        extends FrameLayout {
    private boolean a;
    private int b;

    public LockEventView(Context paramContext) {
        super(paramContext);
    }

    public LockEventView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public void a() {
        try {
            this.b += 1;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void a(boolean paramBoolean) {
        this.a = paramBoolean;
        if (paramBoolean) {
            a();
            return;
        }
        b();
    }

    public void b() {
        try {
            this.b -= 1;
            if (this.b < 0) {
                this.b = 0;
            }
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void c() {
        this.b = 0;
        this.a = false;
    }

    public int getCounter() {
        try {
            int i = this.b;
            return i;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (getCounter() > 0) {
            return true;
        }
        return super.onTouchEvent(paramMotionEvent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/widget/LockEventView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */