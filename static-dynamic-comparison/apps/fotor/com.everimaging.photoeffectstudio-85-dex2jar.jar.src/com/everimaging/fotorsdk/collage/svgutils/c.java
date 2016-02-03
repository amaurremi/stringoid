package com.everimaging.fotorsdk.collage.svgutils;

import com.everimaging.fotorsdk.collage.utils.MagicPath;

public class c {
    private String a;
    private MagicPath b;

    public c() {
    }

    public c(c paramc) {
        this.a = paramc.a;
        if (paramc.b != null) {
            this.b = new MagicPath(paramc.b);
        }
    }

    public String a() {
        return this.a;
    }

    public void a(MagicPath paramMagicPath) {
        this.b = paramMagicPath;
    }

    public void a(String paramString) {
        if (paramString == null) {
            this.a = new String();
            return;
        }
        this.a = paramString;
    }

    public MagicPath b() {
        return this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/svgutils/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */