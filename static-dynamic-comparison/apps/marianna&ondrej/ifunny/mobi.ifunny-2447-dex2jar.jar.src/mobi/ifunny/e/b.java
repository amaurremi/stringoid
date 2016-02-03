package mobi.ifunny.e;

import android.content.Context;
import mobi.ifunny.util.a.d;

public class b
        extends a {
    private final byte[] f;
    private final mobi.ifunny.util.a.a g;

    public b(Context paramContext, byte[] paramArrayOfByte, mobi.ifunny.util.a.a parama) {
        super(paramContext, false);
        this.f = paramArrayOfByte;
        this.g = parama;
    }

    protected d f() {
        return mobi.ifunny.util.a.b.b(this.f, this.g);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */