package com.google.android.gms.common.internal;

import android.view.View;

import java.util.Collection;
import java.util.List;

public final class ClientSettings {
    private final ClientSettings.ParcelableClientSettings a;
    private final View b;

    public ClientSettings(String paramString1, Collection<String> paramCollection, int paramInt, View paramView, String paramString2) {
        this.a = new ClientSettings.ParcelableClientSettings(paramString1, paramCollection, paramInt, paramString2);
        this.b = paramView;
    }

    public String a() {
        return this.a.b();
    }

    public List<String> b() {
        return this.a.e();
    }

    public String[] c() {
        return (String[]) this.a.e().toArray(new String[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/ClientSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */