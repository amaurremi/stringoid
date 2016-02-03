package com.everimaging.fotorsdk.uil.core;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.everimaging.fotorsdk.uil.core.assist.LoadedFrom;
import com.everimaging.fotorsdk.uil.core.assist.ViewScaleType;
import com.everimaging.fotorsdk.uil.core.imageaware.b;

public class d {
    public static final String a = d.class.getSimpleName();
    private static volatile d e;
    private e b;
    private f c;
    private final com.everimaging.fotorsdk.uil.core.assist.c d = new com.everimaging.fotorsdk.uil.core.assist.g();

    public static d a() {
        if (e == null) {
        }
        try {
            if (e == null) {
                e = new d();
            }
            return e;
        } finally {
        }
    }

    private void b() {
        if (this.b == null) {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        }
    }

    public void a(e parame) {
        if (parame == null) {
            try {
                throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
            } finally {
            }
        }
        if (this.b == null) {
            if (parame.u) {
                com.everimaging.fotorsdk.uil.utils.c.a("Initialize ImageLoader with configuration", new Object[0]);
            }
            this.c = new f(parame);
            this.b = parame;
        }
        for (; ; ) {
            return;
            com.everimaging.fotorsdk.uil.utils.c.c("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
        }
    }

    public void a(String paramString, ImageView paramImageView, c paramc) {
        a(paramString, new com.everimaging.fotorsdk.uil.core.imageaware.c(paramImageView), paramc, null, null);
    }

    public void a(String paramString, com.everimaging.fotorsdk.uil.core.assist.e parame, c paramc, com.everimaging.fotorsdk.uil.core.assist.c paramc1, com.everimaging.fotorsdk.uil.core.assist.d paramd) {
        b();
        com.everimaging.fotorsdk.uil.core.assist.e locale = parame;
        if (parame == null) {
            locale = this.b.a();
        }
        if (paramc == null) {
        }
        for (parame = this.b.t; ; parame = paramc) {
            a(paramString, new b(paramString, locale, ViewScaleType.CROP), parame, paramc1, paramd);
            return;
        }
    }

    public void a(String paramString, c paramc, com.everimaging.fotorsdk.uil.core.assist.c paramc1) {
        a(paramString, null, paramc, paramc1, null);
    }

    public void a(String paramString, com.everimaging.fotorsdk.uil.core.imageaware.a parama, c paramc) {
        a(paramString, parama, paramc, null, null);
    }

    public void a(String paramString, com.everimaging.fotorsdk.uil.core.imageaware.a parama, c paramc, com.everimaging.fotorsdk.uil.core.assist.c paramc1) {
        a(paramString, parama, paramc, paramc1, null);
    }

    public void a(String paramString, com.everimaging.fotorsdk.uil.core.imageaware.a parama, c paramc, com.everimaging.fotorsdk.uil.core.assist.c paramc1, com.everimaging.fotorsdk.uil.core.assist.d paramd) {
        b();
        if (parama == null) {
            throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
        }
        if (paramc1 == null) {
            paramc1 = this.d;
        }
        for (; ; ) {
            if (paramc == null) {
                paramc = this.b.t;
            }
            for (; ; ) {
                if (TextUtils.isEmpty(paramString)) {
                    this.c.b(parama);
                    paramc1.a(paramString, parama.d());
                    if (paramc.b()) {
                        parama.a(paramc.b(this.b.a));
                    }
                    for (; ; ) {
                        paramc1.a(paramString, parama.d(), null);
                        return;
                        parama.a(null);
                    }
                }
                com.everimaging.fotorsdk.uil.core.assist.e locale = com.everimaging.fotorsdk.uil.utils.a.a(parama, this.b.a());
                String str = com.everimaging.fotorsdk.uil.core.assist.f.a(paramString, locale);
                this.c.a(parama, str);
                paramc1.a(paramString, parama.d());
                Bitmap localBitmap = (Bitmap) this.b.p.a(str);
                if ((localBitmap != null) && (!localBitmap.isRecycled())) {
                    if (this.b.u) {
                        com.everimaging.fotorsdk.uil.utils.c.a("Load image from memory cache [%s]", new Object[]{str});
                    }
                    if (paramc.e()) {
                        paramString = new g(paramString, parama, locale, str, paramc, paramc1, paramd, this.c.a(paramString));
                        paramString = new h(this.c, localBitmap, paramString, paramc.r());
                        if (paramc.s()) {
                            paramString.run();
                            return;
                        }
                        this.c.a(paramString);
                        return;
                    }
                    paramc.q().a(localBitmap, parama, LoadedFrom.MEMORY_CACHE);
                    paramc1.a(paramString, parama.d(), localBitmap);
                    return;
                }
                if (paramc.a()) {
                    parama.a(paramc.a(this.b.a));
                }
                for (; ; ) {
                    paramString = new g(paramString, parama, locale, str, paramc, paramc1, paramd, this.c.a(paramString));
                    paramString = new LoadAndDisplayImageTask(this.c, paramString, paramc.r());
                    if (!paramc.s()) {
                        break;
                    }
                    paramString.run();
                    return;
                    if (paramc.g()) {
                        parama.a(null);
                    }
                }
                this.c.a(paramString);
                return;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */