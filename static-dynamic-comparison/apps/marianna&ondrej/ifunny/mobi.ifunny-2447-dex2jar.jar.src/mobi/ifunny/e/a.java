package mobi.ifunny.e;

import android.content.Context;
import mobi.ifunny.util.a.d;

public abstract class a
        extends android.support.v4.a.a<d> {
    private final boolean f;
    private d g;

    public a(Context paramContext, boolean paramBoolean) {
        super(paramContext);
        this.f = paramBoolean;
    }

    public d e() {
        d locald = f();
        if (this.f) {
            this.g = locald;
        }
        return locald;
    }

    protected abstract d f();

    protected void onStartLoading() {
        if ((this.f) && (this.g != null)) {
            deliverResult(this.g);
            return;
        }
        forceLoad();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */