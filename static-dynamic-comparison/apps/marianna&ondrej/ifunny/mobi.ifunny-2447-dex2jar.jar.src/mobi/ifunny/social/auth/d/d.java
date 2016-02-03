package mobi.ifunny.social.auth.d;

import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import mobi.ifunny.social.auth.l;
import mobi.ifunny.social.auth.n;
import mobi.ifunny.social.auth.t;
import mobi.ifunny.social.b.a;
import mobi.ifunny.social.b.b;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class d
        extends t {
    private static final String f = d.class.getSimpleName();
    private final String g = "STATE_REQUEST_TOKEN";
    private final String h = "STATE_TWITTER";
    private Twitter i;
    private RequestToken j;
    private a k;
    private mobi.ifunny.social.b.e l = new e(this);

    private void a(RequestToken paramRequestToken) {
        this.b = 0;
        this.j = paramRequestToken;
        b(paramRequestToken.getAuthenticationURL());
    }

    private void a(RequestToken paramRequestToken, String paramString) {
        if (this.b != 0) {
            return;
        }
        this.b = 5;
        new f(this, "TASK_ACCESS_TOKEN", paramRequestToken, paramString).execute(new Twitter[]{this.i});
    }

    private void b(String paramString) {
        if (this.b != 0) {
            return;
        }
        this.b = 1;
        this.k.a(getActivity(), getChildFragmentManager(), paramString);
    }

    private void o() {
        if (this.b != 0) {
            return;
        }
        this.b = 4;
        new h(this, "TASK_REQUEST_TOKEN").execute(new Twitter[]{this.i});
    }

    protected void a(String paramString1, String paramString2, n paramn) {
        super.a(paramString1, paramString2, paramn);
        this.b = 0;
        this.j = null;
    }

    protected void a(mobi.ifunny.rest.content.AccessToken paramAccessToken) {
        l.a().a(getActivity(), paramAccessToken, 1);
    }

    protected void a(g paramg) {
        this.b = 0;
        this.j = null;
        b.a().a(getActivity(), paramg.a().getToken(), paramg.a().getTokenSecret());
    }

    protected void b() {
        super.b();
        switch (this.b) {
        }
        for (; ; ) {
            this.b = 0;
            this.j = null;
            return;
            a(new String[]{"TASK_VERIFY_TOKEN"});
            continue;
            a(new String[]{"TASK_REQUEST_TOKEN"});
            continue;
            a(new String[]{"TASK_ACCESS_TOKEN"});
        }
    }

    protected void b(boolean paramBoolean) {
        if (this.b != 0) {
            b();
            return;
        }
        b localb = b.a();
        if (!paramBoolean) {
            CookieSyncManager localCookieSyncManager = CookieSyncManager.createInstance(getActivity());
            localCookieSyncManager.sync();
            CookieManager.getInstance().removeAllCookie();
            localCookieSyncManager.sync();
            localb.a(getActivity());
            this.i.setOAuthAccessToken(null);
        }
        if (localb.d() == null) {
            this.i.setOAuthAccessToken(null);
            o();
            return;
        }
        this.b = 3;
        new i(this, "TASK_VERIFY_TOKEN").execute(new Twitter[]{this.i});
    }

    protected int f() {
        return 2131689948;
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (paramBundle != null) {
            this.j = ((RequestToken) paramBundle.getSerializable("STATE_REQUEST_TOKEN"));
            this.i = ((Twitter) paramBundle.getSerializable("STATE_TWITTER"));
        }
        for (; ; ) {
            this.k = new a(2131755187, this.l);
            return;
            this.i = new TwitterFactory(new ConfigurationBuilder().setOAuthConsumerKey("Hkjv8dk22777SFTIT6EVaw").setOAuthConsumerSecret("pJJTTrMz8mFwOX3GJtfvdibuhRALoMJB71hh9yGmEU").setGZIPEnabled(true).setHttpConnectionTimeout(220000).setHttpReadTimeout(220000).setHttpRetryCount(2).setHttpRetryIntervalSeconds(1).setHttpStreamingReadTimeout(220000).build()).getInstance();
            paramBundle = b.a(getActivity(), true).d();
            this.i.setOAuthAccessToken(paramBundle);
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putSerializable("STATE_REQUEST_TOKEN", this.j);
        paramBundle.putSerializable("STATE_TWITTER", this.i);
    }

    public void onStart() {
        super.onStart();
        this.k.a(getChildFragmentManager());
    }

    public void onStop() {
        super.onStop();
        this.k.b(getChildFragmentManager());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */