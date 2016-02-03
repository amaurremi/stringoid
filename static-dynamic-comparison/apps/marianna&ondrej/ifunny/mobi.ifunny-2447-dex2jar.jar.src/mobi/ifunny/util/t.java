package mobi.ifunny.util;

import java.io.InterruptedIOException;

public class t
        extends InterruptedIOException {
    private static final long serialVersionUID = 6890057979601002144L;
    public final boolean a;

    public t(int paramInt, boolean paramBoolean) {
        this.bytesTransferred = paramInt;
        this.a = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */