package com.google.android.gms.internal;

import com.google.android.gms.wearable.a;
import com.google.android.gms.wearable.c;

public class kb
        implements a {
    private int LF;
    private c adC;

    public kb(a parama) {
        this.LF = parama.getType();
        this.adC = ((c) parama.lZ().freeze());
    }

    public int getType() {
        return this.LF;
    }

    public boolean isDataValid() {
        return true;
    }

    public c lZ() {
        return this.adC;
    }

    public a me() {
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/kb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */