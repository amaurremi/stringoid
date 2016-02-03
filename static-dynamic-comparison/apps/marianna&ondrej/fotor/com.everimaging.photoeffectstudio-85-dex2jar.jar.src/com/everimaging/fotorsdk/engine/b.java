package com.everimaging.fotorsdk.engine;

import android.content.Context;
import android.os.Bundle;
import com.everimaging.fotorsdk.uil.cache.disc.naming.c;
import com.everimaging.fotorsdk.uil.core.d;
import com.everimaging.fotorsdk.uil.core.e.a;

public abstract class b
        extends com.everimaging.fotorsdk.b {
    public static void a(Context paramContext) {
        paramContext = new e.a(paramContext).a().a(new c()).b(20).b();
        d.a().a(paramContext);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        a(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/engine/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */