package mobi.ifunny.social.auth.b;

import android.os.Bundle;
import android.text.TextUtils;

import java.io.IOException;

import mobi.ifunny.social.auth.n;

final class f
        extends mobi.ifunny.l.f<d, Void, Void, String> {
    private String a;
    private String[] b;
    private n c;

    private f(d paramd, String paramString1, String paramString2, n paramn, String... paramVarArgs) {
        super(paramd, paramString1);
        this.a = paramString2;
        this.b = paramVarArgs;
        this.c = paramn;
    }

    protected String a(Void... paramVarArgs) {
        try {
            paramVarArgs = new Bundle();
            paramVarArgs.putBoolean("suppressProgressScreen", true);
            paramVarArgs = com.google.android.gms.auth.e.a(mobi.ifunny.e.a, this.a, "oauth2:" + TextUtils.join(" ", this.b), paramVarArgs);
            return paramVarArgs;
        } catch (Exception paramVarArgs) {
            return null;
        } catch (IOException paramVarArgs) {
        }
        return null;
    }

    protected void a(d paramd, String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            d.a(paramd, d.a(paramd));
            return;
        }
        d.a(paramd, paramString, this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */