package mobi.ifunny.k;

import android.text.TextUtils;

import java.util.concurrent.atomic.AtomicBoolean;

import mobi.ifunny.util.a.a;

public class r<D> {
    public t<D> a;
    public a b;
    public final String c;
    public Object d;
    public AtomicBoolean e;

    public r(t<D> paramt, a parama) {
        this(paramt, parama, null);
    }

    public r(t<D> paramt, a parama, String paramString) {
        this.a = paramt;
        this.b = parama;
        paramt = paramString;
        if (TextUtils.isEmpty(paramString)) {
            paramt = "DEFAULT_GROUP_ID";
        }
        this.c = paramt;
        this.e = new AtomicBoolean(false);
    }

    public r(a parama, String paramString) {
        this(null, parama, paramString);
    }

    public boolean a() {
        return this.e.get();
    }

    public void b() {
        this.e.set(true);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/k/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */