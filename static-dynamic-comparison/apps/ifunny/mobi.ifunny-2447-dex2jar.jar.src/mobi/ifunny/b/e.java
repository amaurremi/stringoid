package mobi.ifunny.b;

import android.app.Activity;
import android.content.Context;
import com.mobileapptracker.g;
import mobi.ifunny.social.auth.l;

public class e {
    public static final String a = e.class.getSimpleName();
    private static g b;

    public static void a(Context paramContext, Activity paramActivity, boolean paramBoolean) {
        if (a()) {
            return;
        }
        g.a(paramContext, "17116", "67202311471de34530cc56ed7ddf9ed9");
        g localg = g.a();
        localg.a(paramActivity);
        localg.a(paramBoolean);
        b = localg;
        new Thread(new f(paramContext, localg)).start();
    }

    public static boolean a() {
        return b != null;
    }

    public static void b() {
        if (b != null) {
            b.c();
        }
    }

    public static void c() {
        if (b != null) {
            l locall = l.a();
            b.j(locall.d());
            b.k(locall.e());
            b.a("Registration");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */