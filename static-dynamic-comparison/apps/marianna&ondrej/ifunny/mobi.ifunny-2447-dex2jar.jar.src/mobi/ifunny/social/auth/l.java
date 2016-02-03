package mobi.ifunny.social.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import mobi.ifunny.rest.content.AccessToken;
import mobi.ifunny.rest.content.User;

public class l {
    private static l a;
    private String b;
    private int c;
    private long d;
    private n e = new n();
    private Set<m> f = new HashSet();

    private l(Context paramContext) {
        e(paramContext);
    }

    public static l a() {
        try {
            l locall = a;
            return locall;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public static l a(Context paramContext) {
        try {
            if (a == null) {
                a = new l(paramContext);
            }
            paramContext = a;
            return paramContext;
        } finally {
        }
    }

    private void a(AccessToken paramAccessToken, int paramInt) {
        if (paramAccessToken == null) {
            this.b = null;
            this.c = -1;
            this.d = 0L;
            return;
        }
        this.b = paramAccessToken.access_token;
        this.c = paramInt;
        this.d = (System.currentTimeMillis() + paramAccessToken.expires_in * 1000L);
    }

    private void a(User paramUser) {
        if (paramUser == null) {
            this.e.a = null;
            this.e.b = null;
            this.e.c = null;
            this.e.d = false;
            return;
        }
        this.e.a = paramUser.id;
        this.e.b = paramUser.nick;
        this.e.c = paramUser.getPhotoThumbSmallUrl();
        this.e.d = paramUser.is_banned;
    }

    private SharedPreferences c(Context paramContext) {
        return paramContext.getSharedPreferences("IFUNNY_AUTH_SESSION", 0);
    }

    private void d(Context paramContext) {
        paramContext = c(paramContext).edit();
        paramContext.putString("PREFS_TOKEN", this.b);
        paramContext.putLong("PREFS_EXPIRATION_DATE", this.d);
        paramContext.putInt("PREFS_TYPE", this.c);
        paramContext.putString("PREFS_UID", this.e.a);
        paramContext.putString("PREFS_NICK", this.e.b);
        paramContext.putString("PREFS_PHOTO_URL", this.e.c);
        paramContext.putBoolean("PREFS_IS_BANNED", this.e.d);
        paramContext.apply();
    }

    private void e(Context paramContext) {
        SharedPreferences localSharedPreferences = c(paramContext);
        this.b = localSharedPreferences.getString("PREFS_TOKEN", null);
        this.d = localSharedPreferences.getLong("PREFS_EXPIRATION_DATE", 0L);
        this.c = localSharedPreferences.getInt("PREFS_TYPE", -1);
        this.e.a = localSharedPreferences.getString("PREFS_UID", null);
        this.e.b = localSharedPreferences.getString("PREFS_NICK", null);
        this.e.c = localSharedPreferences.getString("PREFS_PHOTO_URL", null);
        this.e.d = localSharedPreferences.getBoolean("PREFS_IS_BANNED", false);
        if ((this.c == -1) || (TextUtils.isEmpty(this.b)) || (TextUtils.isEmpty(this.e.a)) || (TextUtils.isEmpty(this.e.b))) {
            b(paramContext);
        }
    }

    public void a(Context paramContext, AccessToken paramAccessToken, int paramInt) {
        a(paramContext, paramAccessToken, paramInt, null);
    }

    public void a(Context paramContext, AccessToken paramAccessToken, int paramInt, User paramUser) {
        a(paramAccessToken, paramInt);
        a(paramUser);
        d(paramContext);
        paramContext = this.f.iterator();
        while (paramContext.hasNext()) {
            ((m) paramContext.next()).onSessionUpdate(this);
        }
    }

    public void a(Context paramContext, User paramUser) {
        a(paramUser);
        d(paramContext);
    }

    public void a(m paramm) {
        this.f.add(paramm);
    }

    public String b() {
        if (h()) {
            return this.b;
        }
        return null;
    }

    public void b(Context paramContext) {
        this.c = -1;
        this.b = null;
        this.d = 0L;
        this.e.a = null;
        this.e.b = null;
        this.e.c = null;
        this.e.d = false;
        paramContext = c(paramContext).edit();
        paramContext.clear();
        paramContext.apply();
        paramContext = this.f.iterator();
        while (paramContext.hasNext()) {
            ((m) paramContext.next()).onSessionUpdate(this);
        }
    }

    public int c() {
        return this.c;
    }

    public String d() {
        if (h()) {
            return this.e.a;
        }
        return null;
    }

    public String e() {
        if (h()) {
            return this.e.b;
        }
        return null;
    }

    public String f() {
        if (h()) {
            return this.e.c;
        }
        return null;
    }

    public boolean g() {
        return (h()) && (this.e.d);
    }

    public boolean h() {
        return (this.b != null) && (System.currentTimeMillis() < this.d);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */