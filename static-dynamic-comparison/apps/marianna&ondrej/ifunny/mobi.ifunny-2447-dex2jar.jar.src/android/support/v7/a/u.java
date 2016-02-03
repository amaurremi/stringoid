package android.support.v7.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.view.View;

public class u
        extends e {
    private f b;
    private Drawable c;
    private CharSequence d;
    private CharSequence e;
    private int f = -1;
    private View g;

    public u(s params) {
    }

    public int a() {
        return this.f;
    }

    public e a(int paramInt) {
        return a(s.b(this.a).getResources().getText(paramInt));
    }

    public e a(f paramf) {
        this.b = paramf;
        return this;
    }

    public e a(CharSequence paramCharSequence) {
        this.d = paramCharSequence;
        if (this.f >= 0) {
            s.a(this.a).b(this.f);
        }
        return this;
    }

    public Drawable b() {
        return this.c;
    }

    public void b(int paramInt) {
        this.f = paramInt;
    }

    public CharSequence c() {
        return this.d;
    }

    public View d() {
        return this.g;
    }

    public void e() {
        this.a.b(this);
    }

    public CharSequence f() {
        return this.e;
    }

    public f g() {
        return this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */