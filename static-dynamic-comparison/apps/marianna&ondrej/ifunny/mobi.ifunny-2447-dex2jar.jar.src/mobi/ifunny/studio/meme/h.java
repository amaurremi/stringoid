package mobi.ifunny.studio.meme;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ab;
import android.support.v4.app.k;
import android.support.v4.app.q;
import android.support.v7.a.e;
import android.support.v7.a.f;

public class h<T extends Fragment>
        implements f {
    private final k a;
    private final String b;
    private final Class<T> c;
    private final Bundle d;
    private Fragment e;

    public h(k paramk, String paramString, Class<T> paramClass, Bundle paramBundle) {
        this.a = paramk;
        this.b = paramString;
        this.c = paramClass;
        this.d = paramBundle;
    }

    public void a(e parame, ab paramab) {
        parame = this.a.f().a(this.b);
        if (parame != null) {
            this.e = parame;
        }
        if (this.e == null) {
            this.e = Fragment.instantiate(this.a, this.c.getName(), this.d);
            paramab.a(16908290, this.e, this.b);
        }
        while (!this.e.isDetached()) {
            return;
        }
        paramab.c(this.e);
    }

    public void b(e parame, ab paramab) {
        if (this.e != null) {
            paramab.b(this.e);
        }
    }

    public void c(e parame, ab paramab) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/meme/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */