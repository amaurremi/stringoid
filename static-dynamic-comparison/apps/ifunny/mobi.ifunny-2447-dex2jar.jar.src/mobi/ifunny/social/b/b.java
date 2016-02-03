package mobi.ifunny.social.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import twitter4j.auth.AccessToken;

public class b {
    private static b c;
    private String a;
    private String b;

    private b(Context paramContext, boolean paramBoolean) {
        if (paramBoolean) {
            c(paramContext);
        }
    }

    public static b a() {
        return c;
    }

    public static b a(Context paramContext, boolean paramBoolean) {
        if ((c == null) || (!paramBoolean)) {
            c = new b(paramContext, paramBoolean);
        }
        return c;
    }

    private SharedPreferences b(Context paramContext) {
        return paramContext.getSharedPreferences("TWITTER_AUTH_SESSION", 0);
    }

    private void c(Context paramContext) {
        paramContext = b(paramContext);
        this.a = paramContext.getString("twitter_access_token_key", null);
        this.b = paramContext.getString("twitter_access_token_secret", null);
    }

    private void d(Context paramContext) {
        paramContext = b(paramContext).edit();
        paramContext.putString("twitter_access_token_key", this.a);
        paramContext.putString("twitter_access_token_secret", this.b);
        paramContext.apply();
    }

    public void a(Context paramContext) {
        this.a = null;
        this.b = null;
        paramContext = b(paramContext).edit();
        paramContext.clear();
        paramContext.apply();
    }

    public void a(Context paramContext, String paramString1, String paramString2) {
        this.a = paramString1;
        this.b = paramString2;
        d(paramContext);
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public AccessToken d() {
        if ((TextUtils.isEmpty(this.a)) || (TextUtils.isEmpty(this.b))) {
            return null;
        }
        return new AccessToken(this.a, this.b);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */