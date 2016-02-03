package mobi.ifunny.util;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.ab;
import android.support.v4.app.q;

public final class n {
    public static <T extends Fragment> T a(Context paramContext, q paramq, String paramString, Class<T> paramClass) {
        Fragment localFragment2 = paramq.a(paramString);
        Fragment localFragment1 = localFragment2;
        if (localFragment2 == null) {
            localFragment1 = Fragment.instantiate(paramContext, paramClass.getName());
            paramContext = paramq.a();
            paramContext.a(localFragment1, paramString);
            paramContext.c();
            paramq.b();
        }
        return localFragment1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */