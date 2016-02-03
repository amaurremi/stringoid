package mobi.ifunny.social.auth;

import android.text.TextUtils;

public class AuthHelper {
    public static k a(AuthHelper.AuthInfo paramAuthInfo, i... paramVarArgs) {
        int j = paramVarArgs.length;
        int i = 0;
        if (i < j) {
            i locali = paramVarArgs[i];
            switch (h.a[locali.ordinal()]) {
            }
            do {
                do {
                    do {
                        i += 1;
                        break;
                    } while (!a(i.b, paramAuthInfo.b));
                    return new k(i.b, paramAuthInfo.b, null);
                } while (!a(i.a, paramAuthInfo.a));
                return new k(i.a, paramAuthInfo.a, null);
            } while (!a(i.c, paramAuthInfo.c));
            return new k(i.c, paramAuthInfo.c, null);
        }
        return null;
    }

    private static boolean a(i parami, String paramString) {
        switch (h.a[parami.ordinal()]) {
            default:
                throw new IllegalArgumentException();
        }
        return TextUtils.isEmpty(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/AuthHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */