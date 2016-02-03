package com.everimaging.fotorsdk.collage.entity.ui;

import android.graphics.drawable.Drawable;
import com.everimaging.fotorsdk.collage.entity.BackgroundInfo;

import java.lang.ref.WeakReference;

public class a {
    private BackgroundInfo a;
    private WeakReference<Drawable> b;

    public BackgroundInfo a() {
        return this.a;
    }

    public void a(Drawable paramDrawable) {
        this.b = new WeakReference(paramDrawable);
    }

    public void a(BackgroundInfo paramBackgroundInfo) {
        this.a = paramBackgroundInfo;
    }

    public Drawable b() {
        if ((this.b == null) || (this.b.get() == null)) {
            return null;
        }
        return (Drawable) this.b.get();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/entity/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */