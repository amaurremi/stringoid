package mobi.ifunny.k;

import android.view.View;

import java.util.HashMap;
import java.util.Map;

import mobi.ifunny.d;

public class a
        extends h {
    private static final String e = a.class.getSimpleName();
    private final Map<View, l> f = new HashMap();
    private b g;

    public a(i parami, t paramt, int paramInt1, int paramInt2) {
        super(parami, paramt, paramInt1, paramInt2);
    }

    public void a() {
        super.a();
        this.f.clear();
    }

    public void a(View paramView) {
        l locall = (l) this.f.get(paramView);
        if (locall != null) {
            this.a.a(locall.a());
            if (this.g != null) {
                this.g.a(locall, paramView);
            }
        }
    }

    public boolean a(l paraml) {
        d.e(e, "In adapter route you need to use start(RouteRequest request, View rootView) instead of this variant, because of non-working scrap heap requests cancel");
        return super.a(paraml);
    }

    public boolean a(l paraml, View paramView) {
        boolean bool = super.a(paraml);
        if (bool) {
            this.f.put(paramView, paraml);
        }
        return bool;
    }

    public void b() {
        super.b();
        this.f.clear();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/k/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */