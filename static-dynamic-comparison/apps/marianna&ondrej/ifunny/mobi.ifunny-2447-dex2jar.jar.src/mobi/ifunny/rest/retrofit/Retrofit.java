package mobi.ifunny.rest.retrofit;

import android.content.Context;
import android.os.Build.VERSION;
import mobi.ifunny.g;
import mobi.ifunny.social.auth.l;

public final class Retrofit {
    static Retrofit.AuthInterface auth;
    static Retrofit.RestInterface rest;

    public static void init(Context paramContext) {
        l.a(paramContext);
        Authenticator localAuthenticator = new Authenticator(g.a(), l.a());
        l.a().a(localAuthenticator);
        rest = (Retrofit.RestInterface) RestAdapterFactory.createIFunnyRequestAdapter(paramContext, localAuthenticator).create(Retrofit.RestInterface.class);
        auth = (Retrofit.AuthInterface) RestAdapterFactory.createAuthRequestAdapter(paramContext, localAuthenticator).create(Retrofit.AuthInterface.class);
    }

    public static String userAgent() {
        int i = -1;
        String str;
        switch ("google".hashCode()) {
            default:
                switch (i) {
                    default:
                        str = "unknown";
                }
                break;
        }
        for (; ; ) {
            return String.format("iFunny/%s %s/%s", new Object[]{"4.0", str, Build.VERSION.RELEASE});
            if (!"google".equals("google")) {
                break;
            }
            i = 0;
            break;
            if (!"google".equals("amazon")) {
                break;
            }
            i = 1;
            break;
            str = "android";
            continue;
            str = "kindle";
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/Retrofit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */