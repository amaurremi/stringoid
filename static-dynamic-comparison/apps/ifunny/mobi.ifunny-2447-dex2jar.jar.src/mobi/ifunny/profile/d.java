package mobi.ifunny.profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import mobi.ifunny.social.auth.aa;
import mobi.ifunny.social.auth.b.i;

public class d
        extends l {
    public static d a(String paramString) {
        Bundle localBundle = new Bundle();
        localBundle.putString("uid", paramString);
        paramString = new d();
        paramString.setArguments(localBundle);
        return paramString;
    }

    public static d b(String paramString) {
        Bundle localBundle = new Bundle();
        localBundle.putString("nick", paramString);
        paramString = new d();
        paramString.setArguments(localBundle);
        return paramString;
    }

    protected void a(int paramInt) {
        switch (paramInt) {
            default:
                super.a(paramInt);
                return;
        }
        q localq = getChildFragmentManager();
        Object localObject2 = (aa) localq.a("TAG_LOGOUT_GPLUS");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = new i();
            localObject2 = localq.a();
            ((ab) localObject2).a((Fragment) localObject1, "TAG_LOGOUT_GPLUS");
            ((ab) localObject2).c();
            localq.b();
        }
        ((aa) localObject1).h();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */