package mobi.ifunny.k;

import android.animation.Animator;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import mobi.ifunny.util.a.a;

public class h
        implements s<ImageView, Drawable> {
    protected final m<ImageView, Drawable> a;
    protected final t b;
    protected final Map<ImageView, l> c;
    protected i d;

    public h(i parami, t paramt, int paramInt1, int paramInt2) {
        this.b = paramt;
        this.c = new HashMap();
        this.a = new m(paramInt1, paramInt2);
        this.a.a(this);
        a(parami);
    }

    private void d() {
        Iterator localIterator = this.c.values().iterator();
        while (localIterator.hasNext()) {
            e((l) localIterator.next());
        }
    }

    private void e(l paraml) {
        Animator localAnimator = paraml.d();
        if (localAnimator != null) {
            localAnimator.cancel();
            localAnimator.removeAllListeners();
            paraml.a(null);
        }
    }

    public void a() {
        c();
        d();
        this.c.clear();
    }

    public void a(ImageView paramImageView) {
        this.a.a(paramImageView);
        paramImageView = (l) this.c.get(paramImageView);
        if (paramImageView != null) {
            e(paramImageView);
        }
    }

    public final void a(ImageView paramImageView, Drawable paramDrawable) {
        paramImageView = (l) this.c.get(paramImageView);
        paramImageView.a().setImageDrawable(paramDrawable);
        c(paramImageView);
        b(paramImageView, paramDrawable);
    }

    public final void a(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean) {
        l locall = (l) this.c.get(paramImageView);
        if ((paramBoolean) && (locall != null)) {
            b(locall);
        }
        a(paramImageView, locall, paramDrawable, paramBoolean);
    }

    protected void a(ImageView paramImageView, l paraml, Drawable paramDrawable, boolean paramBoolean) {
        if (this.d != null) {
            this.d.a(paramImageView, paraml, paramDrawable, paramBoolean);
        }
    }

    public final void a(ImageView paramImageView, r paramr) {
        paramImageView = (l) this.c.get(paramImageView);
        b(paramImageView);
        d(paramImageView);
    }

    public void a(String paramString) {
        this.a.a(paramString);
        Iterator localIterator = this.c.values().iterator();
        while (localIterator.hasNext()) {
            l locall = (l) localIterator.next();
            if (TextUtils.equals(locall.c().c, paramString)) {
                e(locall);
            }
        }
    }

    public void a(i parami) {
        this.d = parami;
    }

    protected void a(l paraml, Drawable paramDrawable) {
        if (this.d != null) {
            this.d.a(paraml, paramDrawable);
        }
    }

    protected void a(l paraml, boolean paramBoolean) {
        if (this.d != null) {
            this.d.a(paraml, paramBoolean);
        }
    }

    public boolean a(l paraml) {
        paraml.c().a = this.b;
        l locall = (l) this.c.get(paraml.a());
        a locala = paraml.c().b;
        Object localObject;
        int i;
        label70:
        int j;
        if (locall != null) {
            localObject = locall.c().b;
            if ((locall == null) || (!locala.equals(localObject))) {
                break label153;
            }
            i = 1;
            if (paraml.a().getDrawable() == null) {
                break label158;
            }
            j = 1;
            label82:
            if ((i == 0) || (j == 0)) {
                if (locall != null) {
                    e(locall);
                }
                localObject = this.a.b(paraml.a());
                if (localObject != null) {
                    break label163;
                }
            }
        }
        for (; ; ) {
            if (!TextUtils.isEmpty(locala.c())) {
                break label192;
            }
            if (this.d.a()) {
                b(paraml);
            }
            label153:
            label158:
            label163:
            do {
                return false;
                localObject = null;
                break;
                i = 0;
                break label70;
                j = 0;
                break label82;
            } while (paraml.c().b.equals(((r) localObject).b));
            a(paraml.a());
        }
        label192:
        this.c.put(paraml.a(), paraml);
        a(paraml, true);
        if (1 != 0) {
            this.a.a(paraml.a(), paraml.c());
        }
        if (j != 0) {
            localObject = paraml.a().getDrawable();
            paraml.a().setImageDrawable(null);
            a(paraml, (Drawable) localObject);
        }
        return true;
    }

    public void b() {
        this.a.b();
        d();
        this.c.clear();
    }

    protected void b(l paraml) {
        if (this.d != null) {
            if (this.d.a()) {
                this.d.a(paraml);
                this.d.c(paraml);
            }
        } else {
            return;
        }
        this.d.a(paraml, true);
    }

    protected void b(l paraml, Drawable paramDrawable) {
        if (this.d != null) {
            this.d.b(paraml, paramDrawable);
        }
    }

    public void c() {
        this.a.a();
        d();
    }

    protected void c(l paraml) {
        if (this.d != null) {
            this.d.c(paraml);
        }
    }

    protected void d(l paraml) {
        if (this.d != null) {
            this.d.b(paraml);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/k/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */