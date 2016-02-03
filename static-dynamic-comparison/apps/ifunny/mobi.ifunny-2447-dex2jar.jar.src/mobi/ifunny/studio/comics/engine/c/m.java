package mobi.ifunny.studio.comics.engine.c;

import android.graphics.Typeface;

public class m {
    private String a;
    private String b;
    private Typeface c;
    private float d;
    private int e;

    public m() {
    }

    public m(String paramString1, String paramString2, Typeface paramTypeface, float paramFloat, int paramInt) {
        this.a = paramString1;
        this.c = paramTypeface;
        this.b = paramString2;
        this.d = paramFloat;
        this.e = paramInt;
    }

    public m(m paramm) {
        this(paramm.a(), paramm.b(), paramm.c(), paramm.d(), paramm.e());
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public Typeface c() {
        return this.c;
    }

    public float d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/c/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */