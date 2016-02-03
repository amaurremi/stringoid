package com.google.android.gms.internal;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;

class tf
        implements ComponentCallbacks {
    tf(te paramte) {
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        if ((te.a(this.a) != null) && (te.a(this.a).j != null) && (te.a(this.a).j.b != null)) {
            te.a(this.a).j.b.a();
        }
    }

    public void onLowMemory() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/tf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */