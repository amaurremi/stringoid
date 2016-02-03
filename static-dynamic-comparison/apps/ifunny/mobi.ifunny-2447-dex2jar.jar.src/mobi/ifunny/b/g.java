package mobi.ifunny.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.a.c;
import com.google.android.gms.a.h;
import com.google.android.gms.a.m;
import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.d;

public class g {
    public static final String a = g.class.getSimpleName();
    private static String b;

    public static m a(Context paramContext) {
        return c.a(paramContext).a(2131099648);
    }

    public static void a(Activity paramActivity, int paramInt, String paramString) {
        a((IFunnyApplication) paramActivity.getApplication(), paramInt, paramString);
    }

    public static void a(Activity paramActivity, String paramString) {
        if (paramActivity != null) {
            paramActivity = ((IFunnyApplication) paramActivity.getApplication()).a();
            paramActivity.a(paramString);
            paramActivity.a(new com.google.android.gms.a.g().a());
        }
        d.b(a, String.format("Tracking screen: %s", new Object[]{paramString}));
    }

    public static void a(Activity paramActivity, String paramString1, String paramString2) {
        a(paramActivity, paramString1, paramString2, null);
    }

    public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3) {
        if (paramActivity != null) {
            ((IFunnyApplication) paramActivity.getApplication()).a().a(new h().a(paramString1).b(paramString2).c(paramString3).a());
        }
        d.b(a, String.format("Tracking event: %s - %s - %s", new Object[]{paramString1, paramString2, paramString3}));
    }

    public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, long paramLong) {
        if (paramActivity != null) {
            ((IFunnyApplication) paramActivity.getApplication()).a().a(new h().a(paramString1).b(paramString2).c(paramString3).a(paramLong).a());
        }
        d.b(a, String.format("Tracking event: %s - %s - %s - %s", new Object[]{paramString1, paramString2, paramString3, Long.valueOf(paramLong)}));
    }

    public static void a(IFunnyApplication paramIFunnyApplication, int paramInt, String paramString) {
        paramIFunnyApplication.a().a(((com.google.android.gms.a.g) new com.google.android.gms.a.g().a(paramInt, paramString)).a());
        d.b(a, String.format("Setting custom dimension: %d - %s", new Object[]{Integer.valueOf(paramInt), paramString}));
    }

    public static void b(Activity paramActivity, String paramString) {
        if (!TextUtils.equals(paramString, b)) {
            a(paramActivity, paramString);
            b = paramString;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */