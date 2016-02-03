package mobi.ifunny.social.auth.a;

import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.model.GraphObject;
import mobi.ifunny.l.f;

final class g
        extends f<d, Request, Void, Response> {
    private h a;

    private g(d paramd, String paramString, h paramh) {
        super(paramd, paramString);
        this.a = paramh;
    }

    protected Response a(Request... paramVarArgs) {
        try {
            paramVarArgs = paramVarArgs[0].executeAndWait();
            return paramVarArgs;
        } catch (IllegalArgumentException paramVarArgs) {
            return null;
        } catch (FacebookException paramVarArgs) {
        }
        return null;
    }

    protected void a(d paramd, Response paramResponse) {
        if ((paramResponse == null) || (paramResponse.getGraphObject() == null) || (paramResponse.getGraphObject().getInnerJSONObject() == null)) {
            this.a.a(paramd);
            return;
        }
        this.a.a(paramd, paramResponse);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */