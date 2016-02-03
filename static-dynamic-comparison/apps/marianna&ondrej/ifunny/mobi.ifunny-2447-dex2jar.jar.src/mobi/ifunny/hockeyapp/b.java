package mobi.ifunny.hockeyapp;

import android.app.Activity;
import android.text.TextUtils;
import mobi.ifunny.d;
import net.hockeyapp.android.h;

public final class b {
    private static final String a = b.class.getSimpleName();

    private static String a() {
        if (TextUtils.equals("google", "google")) {
            return "b9c298dda7f04661f858fab6f95d08ad";
        }
        if (TextUtils.equals("google", "amazon")) {
            return "89f110b8325edf3455bd592b88c2cb7b";
        }
        return "499a323adc434273fc43bb7c58ddc6d6";
    }

    public static void a(Activity paramActivity) {
        String str = a();
        d.c(a, "Checking crashes with id " + str);
        try {
            net.hockeyapp.android.b.a(paramActivity, str, new c());
            return;
        } catch (Exception paramActivity) {
            d.b(a, "CrashManager.register " + str, paramActivity);
        }
    }

    public static void a(Throwable paramThrowable) {
        d.a(a, "Save throwable to HockeyApp", paramThrowable);
        h.a(paramThrowable, null);
    }

    public static void b(Activity paramActivity) {
        a(paramActivity);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/hockeyapp/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */