package mobi.ifunny.social.auth.d;

import mobi.ifunny.l.f;
import mobi.ifunny.social.auth.n;
import twitter4j.Twitter;
import twitter4j.User;

public class i
        extends f<d, Twitter, Void, g> {
    public i(d paramd, String paramString) {
        super(paramd, paramString);
    }

    protected g a(Twitter... paramVarArgs) {
        Object localObject = paramVarArgs[0];
        try {
            paramVarArgs = ((Twitter) localObject).getOAuthAccessToken();
            localObject = ((Twitter) localObject).verifyCredentials();
            n localn = new n();
            localn.b = ((User) localObject).getScreenName();
            localn.a = Long.toString(((User) localObject).getId());
            localn.c = ((User) localObject).getBiggerProfileImageURL();
            paramVarArgs = new g(paramVarArgs, localn, null);
            return paramVarArgs;
        } catch (Exception paramVarArgs) {
        }
        return null;
    }

    protected void a(d paramd, g paramg) {
        if (paramg != null) {
            paramd.a(paramg);
            return;
        }
        d.b(paramd);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */