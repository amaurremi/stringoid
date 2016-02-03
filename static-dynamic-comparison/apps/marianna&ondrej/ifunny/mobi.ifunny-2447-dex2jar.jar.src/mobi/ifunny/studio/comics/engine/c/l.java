package mobi.ifunny.studio.comics.engine.c;

import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;

public class l
        extends h {
    private TextPaint c;
    private StaticLayout d;
    private m e;

    public l(String paramString1, String paramString2, Typeface paramTypeface, float paramFloat, int paramInt) {
        super(j.f);
        this.e = new m(paramString1, paramString2, paramTypeface, paramFloat, paramInt);
        this.c = new TextPaint(1);
        a(this.e);
        a(100.0F);
    }

    public String a() {
        String str2 = this.e.a();
        String str1 = str2;
        if (str2 == null) {
            str1 = "";
        }
        return str1;
    }

    public void a(float paramFloat) {
        float f2 = StaticLayout.getDesiredWidth(a(), this.c);
        float f1 = paramFloat;
        if (f2 < paramFloat) {
            f1 = f2;
        }
        a((int) (1.0F + f1));
    }

    public void a(int paramInt) {
        if (paramInt == u()) {
            return;
        }
        this.d = new StaticLayout(a(), this.c, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
        paramInt = this.d.getHeight();
        super.a(this.d.getWidth(), paramInt);
    }

    protected void a(Canvas paramCanvas) {
        this.d.draw(paramCanvas);
    }

    public void a(m paramm) {
        this.e = paramm;
        this.c.setColor(paramm.e());
        this.c.setTextSize(paramm.d());
        this.c.setTypeface(paramm.c());
        float f1 = StaticLayout.getDesiredWidth(a(), this.c);
        float f2 = u();
        if (f1 < f2) {
        }
        for (; ; ) {
            a((int) (f1 + 1.0F));
            return;
            f1 = f2;
        }
    }

    public void b() {
        super.b();
        this.e = null;
        this.d = null;
        this.c = null;
    }

    public String c() {
        return this.e.b();
    }

    public void c(int paramInt) {
        if (this.c != null) {
            this.c.setAlpha(paramInt);
        }
    }

    public Object clone() {
        l locall = (l) super.clone();
        locall.c = new TextPaint(this.c);
        locall.a(new m(this.e));
        return locall;
    }

    public float d() {
        return this.e.d();
    }

    public int e() {
        return this.e.e();
    }

    public m f() {
        return this.e;
    }

    public int i() {
        if (this.c != null) {
            return this.c.getAlpha();
        }
        return 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */