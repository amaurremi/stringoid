package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.ad;

final class f {
    public final Uri a;

    public f(Uri paramUri) {
        this.a = paramUri;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof f)) {
            return false;
        }
        if (this == paramObject) {
            return true;
        }
        return ad.a(((f) paramObject).a, this.a);
    }

    public int hashCode() {
        return ad.a(new Object[]{this.a});
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/images/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */