package mobi.ifunny.social.auth.d;

import mobi.ifunny.l.f;
import mobi.ifunny.social.b.a;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;

public class h
        extends f<d, Twitter, Void, RequestToken> {
    public h(d paramd, String paramString) {
        super(paramd, paramString);
    }

    protected RequestToken a(Twitter... paramVarArgs) {
        try {
            paramVarArgs = paramVarArgs[0].getOAuthRequestToken(a.a);
            return paramVarArgs;
        } catch (TwitterException paramVarArgs) {
            mobi.ifunny.d.e(d.p(), paramVarArgs.getMessage());
            return null;
        } catch (NullPointerException paramVarArgs) {
            for (; ; ) {
            }
        }
    }

    protected void a(d paramd, RequestToken paramRequestToken) {
        if (paramRequestToken == null) {
            d.c(paramd, d.c(paramd, null, 2131689955));
            return;
        }
        d.a(paramd, paramRequestToken);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */