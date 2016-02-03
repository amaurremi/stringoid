package mobi.ifunny.f;

import android.content.Context;
import android.content.res.Resources;
import com.amazon.device.ads.bn;
import com.mopub.common.MoPub;

import java.util.HashMap;
import java.util.Map;

public class a {
    public static final String a = MoPub.class.getSimpleName();
    private static final Map<b, Integer> b = new HashMap();
    private static final Map<b, bn> c;

    static {
        b.put(b.a, Integer.valueOf(15));
        b.put(b.b, Integer.valueOf(11));
        c = new HashMap();
        c.put(b.a, bn.b);
        c.put(b.b, bn.e);
    }

    public static b a(Context paramContext) {
        if (paramContext.getResources().getInteger(2131558401) >= 728) {
            return b.b;
        }
        return b.a;
    }

    public static int b(Context paramContext) {
        return ((Integer) b.get(a(paramContext))).intValue();
    }

    public static bn c(Context paramContext) {
        return (bn) c.get(a(paramContext));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */