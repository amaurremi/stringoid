package mobi.ifunny.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PointF;

public class ah {
    public static PointF a;
    public static int b;
    public static int c;
    public static int d;
    public static int e;
    public static int f;
    public static int g;
    public static int h;

    public static void a(Context paramContext) {
        paramContext = paramContext.getResources();
        b = paramContext.getDimensionPixelSize(2131427411);
        f = paramContext.getDimensionPixelSize(2131427412);
        g = paramContext.getDimensionPixelSize(2131427407);
        h = paramContext.getDimensionPixelSize(2131427413);
        d = paramContext.getColor(2131361837);
        e = paramContext.getColor(2131361836);
        c = paramContext.getDimensionPixelSize(2131427410);
        a = new PointF(paramContext.getDimensionPixelSize(2131427408), paramContext.getDimensionPixelSize(2131427409));
    }

    public static int b(Context paramContext) {
        return paramContext.getResources().getConfiguration().screenLayout & 0xF;
    }

    public static boolean c(Context paramContext) {
        return b(paramContext) >= 4;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */