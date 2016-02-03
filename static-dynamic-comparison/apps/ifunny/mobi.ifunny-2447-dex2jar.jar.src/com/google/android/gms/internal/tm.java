package com.google.android.gms.internal;

import android.net.Uri.Builder;
import android.text.TextUtils;

@ii
public class tm
        implements tl {
    private final ld a;
    private final mz b;

    public tm(ld paramld, mz parammz) {
        this.a = paramld;
        this.b = parammz;
    }

    public void a(String paramString) {
        mx.a("An auto-clicking creative is blocked");
        Uri.Builder localBuilder = new Uri.Builder();
        localBuilder.scheme("https");
        localBuilder.path("//pagead2.googlesyndication.com/pagead/gen_204");
        localBuilder.appendQueryParameter("id", "gmob-apps-blocked-navigation");
        if (!TextUtils.isEmpty(paramString)) {
            localBuilder.appendQueryParameter("navigationURL", paramString);
        }
        if ((this.a != null) && (this.a.b != null) && (!TextUtils.isEmpty(this.a.b.o))) {
            localBuilder.appendQueryParameter("debugDialog", this.a.b.o);
        }
        lw.a(this.b.getContext(), this.b.i().b, localBuilder.toString());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/tm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */