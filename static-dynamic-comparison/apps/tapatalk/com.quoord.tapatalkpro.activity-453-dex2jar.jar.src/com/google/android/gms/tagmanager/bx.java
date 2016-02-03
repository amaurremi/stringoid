package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;

import java.util.Map;

abstract class bx
        extends cc {
    public bx(String paramString) {
        super(paramString);
    }

    protected boolean a(d.a parama1, d.a parama2, Map<String, d.a> paramMap) {
        parama1 = dh.k(parama1);
        parama2 = dh.k(parama2);
        if ((parama1 == dh.lR()) || (parama2 == dh.lR())) {
            return false;
        }
        return a(parama1, parama2, paramMap);
    }

    protected abstract boolean a(dg paramdg1, dg paramdg2, Map<String, d.a> paramMap);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */