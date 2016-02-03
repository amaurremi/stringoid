package com.everimaging.fotorsdk.collage;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public abstract class i {
    protected f a;
    protected Context b;
    protected View c;

    public i(f paramf) {
        this.a = paramf;
        this.b = paramf.getBaseContext();
    }

    public abstract void a(boolean paramBoolean);

    public boolean a() {
        return false;
    }

    public View b() {
        if (this.c == null) {
            c();
            this.c.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                    return true;
                }
            });
        }
        return this.c;
    }

    protected abstract void c();

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */