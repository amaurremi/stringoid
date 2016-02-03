package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.ad;

import java.lang.ref.WeakReference;

public final class g
        extends e {
    private WeakReference<a> e;

    protected void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
        if (!paramBoolean2) {
            a locala = (a) this.e.get();
            if (locala != null) {
                locala.a(this.a.a, paramDrawable, paramBoolean3);
            }
        }
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof g)) {
            return false;
        }
        if (this == paramObject) {
            return true;
        }
        paramObject = (g) paramObject;
        a locala1 = (a) this.e.get();
        a locala2 = (a) ((g) paramObject).e.get();
        if ((locala2 != null) && (locala1 != null) && (ad.a(locala2, locala1)) && (ad.a(((g) paramObject).a, this.a))) {
        }
        for (boolean bool = true; ; bool = false) {
            return bool;
        }
    }

    public int hashCode() {
        return ad.a(new Object[]{this.a});
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/images/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */