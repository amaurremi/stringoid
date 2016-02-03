package mobi.ifunny.social.auth.d;

import mobi.ifunny.social.auth.n;
import twitter4j.Twitter;
import twitter4j.User;
import twitter4j.auth.RequestToken;

public class f
        extends mobi.ifunny.l.f<d, Twitter, Void, g> {
    private RequestToken a;
    private String b;

    public f(d paramd, String paramString1, RequestToken paramRequestToken, String paramString2) {
        super(paramd, paramString1);
        this.a = paramRequestToken;
        this.b = paramString2;
    }

    protected g a(Twitter... paramVarArgs) {
        Object localObject = paramVarArgs[0];
        try {
            paramVarArgs = ((Twitter) localObject).getOAuthAccessToken(this.a, this.b);
            localObject = ((Twitter) localObject).verifyCredentials();
            n localn = new n();
            localn.b = ((User) localObject).getScreenName();
            localn.a = Long.toString(((User) localObject).getId());
            localn.c = ((User) localObject).getBiggerProfileImageURL();
            paramVarArgs = new g(paramVarArgs, localn, null);
            return paramVarArgs;
        } catch (Exception paramVarArgs) {
            mobi.ifunny.d.e(d.p(), paramVarArgs.getMessage());
        }
        return null;
    }

    protected void a(d paramd, g paramg) {
        if (paramg != null) {
            paramd.a(paramg);
            return;
        }
        d.d(paramd, d.d(paramd, null, 2131689950));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */