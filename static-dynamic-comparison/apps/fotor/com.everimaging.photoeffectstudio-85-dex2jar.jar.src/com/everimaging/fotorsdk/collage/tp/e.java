package com.everimaging.fotorsdk.collage.tp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.everimaging.fotorsdk.collage.f;

public abstract class e {
    private View a;
    protected f m;
    protected Context n;

    public e(f paramf) {
        this.m = paramf;
        this.n = paramf.getBaseContext();
    }

    protected abstract View a(LayoutInflater paramLayoutInflater);

    public void b() {
    }

    public void e() {
    }

    public View n() {
        if (this.a == null) {
            this.a = a(LayoutInflater.from(this.n));
        }
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/tp/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */