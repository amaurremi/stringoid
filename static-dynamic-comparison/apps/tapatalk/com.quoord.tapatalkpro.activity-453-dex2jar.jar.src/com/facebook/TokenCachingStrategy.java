package com.facebook;

import android.os.Bundle;
import com.facebook.internal.Validate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TokenCachingStrategy {
    public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";
    private static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;
    private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
    public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";
    public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";
    public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";
    public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";
    public static final String USER_FBID_KEY = "com.facebook.TokenCachingStrategy.UserFBID";

    static Date getDate(Bundle paramBundle, String paramString) {
        if (paramBundle == null) {
        }
        long l;
        do {
            return null;
            l = paramBundle.getLong(paramString, Long.MIN_VALUE);
        } while (l == Long.MIN_VALUE);
        return new Date(l);
    }

    public static Date getExpirationDate(Bundle paramBundle) {
        Validate.notNull(paramBundle, "bundle");
        return getDate(paramBundle, "com.facebook.TokenCachingStrategy.ExpirationDate");
    }

    public static long getExpirationMilliseconds(Bundle paramBundle) {
        Validate.notNull(paramBundle, "bundle");
        return paramBundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate");
    }

    public static Date getLastRefreshDate(Bundle paramBundle) {
        Validate.notNull(paramBundle, "bundle");
        return getDate(paramBundle, "com.facebook.TokenCachingStrategy.LastRefreshDate");
    }

    public static long getLastRefreshMilliseconds(Bundle paramBundle) {
        Validate.notNull(paramBundle, "bundle");
        return paramBundle.getLong("com.facebook.TokenCachingStrategy.LastRefreshDate");
    }

    public static List<String> getPermissions(Bundle paramBundle) {
        Validate.notNull(paramBundle, "bundle");
        return paramBundle.getStringArrayList("com.facebook.TokenCachingStrategy.Permissions");
    }

    public static AccessTokenSource getSource(Bundle paramBundle) {
        Validate.notNull(paramBundle, "bundle");
        if (paramBundle.containsKey("com.facebook.TokenCachingStrategy.AccessTokenSource")) {
            return (AccessTokenSource) paramBundle.getSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource");
        }
        if (paramBundle.getBoolean("com.facebook.TokenCachingStrategy.IsSSO")) {
            return AccessTokenSource.FACEBOOK_APPLICATION_WEB;
        }
        return AccessTokenSource.WEB_VIEW;
    }

    public static String getToken(Bundle paramBundle) {
        Validate.notNull(paramBundle, "bundle");
        return paramBundle.getString("com.facebook.TokenCachingStrategy.Token");
    }

    public static boolean hasTokenInformation(Bundle paramBundle) {
        if (paramBundle == null) {
        }
        String str;
        do {
            return false;
            str = paramBundle.getString("com.facebook.TokenCachingStrategy.Token");
        }
        while ((str == null) || (str.length() == 0) || (paramBundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0L) == 0L));
        return true;
    }

    static void putDate(Bundle paramBundle, String paramString, Date paramDate) {
        paramBundle.putLong(paramString, paramDate.getTime());
    }

    public static void putExpirationDate(Bundle paramBundle, Date paramDate) {
        Validate.notNull(paramBundle, "bundle");
        Validate.notNull(paramDate, "value");
        putDate(paramBundle, "com.facebook.TokenCachingStrategy.ExpirationDate", paramDate);
    }

    public static void putExpirationMilliseconds(Bundle paramBundle, long paramLong) {
        Validate.notNull(paramBundle, "bundle");
        paramBundle.putLong("com.facebook.TokenCachingStrategy.ExpirationDate", paramLong);
    }

    public static void putLastRefreshDate(Bundle paramBundle, Date paramDate) {
        Validate.notNull(paramBundle, "bundle");
        Validate.notNull(paramDate, "value");
        putDate(paramBundle, "com.facebook.TokenCachingStrategy.LastRefreshDate", paramDate);
    }

    public static void putLastRefreshMilliseconds(Bundle paramBundle, long paramLong) {
        Validate.notNull(paramBundle, "bundle");
        paramBundle.putLong("com.facebook.TokenCachingStrategy.LastRefreshDate", paramLong);
    }

    public static void putPermissions(Bundle paramBundle, List<String> paramList) {
        Validate.notNull(paramBundle, "bundle");
        Validate.notNull(paramList, "value");
        if ((paramList instanceof ArrayList)) {
        }
        for (paramList = (ArrayList) paramList; ; paramList = new ArrayList(paramList)) {
            paramBundle.putStringArrayList("com.facebook.TokenCachingStrategy.Permissions", paramList);
            return;
        }
    }

    public static void putSource(Bundle paramBundle, AccessTokenSource paramAccessTokenSource) {
        Validate.notNull(paramBundle, "bundle");
        paramBundle.putSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource", paramAccessTokenSource);
    }

    public static void putToken(Bundle paramBundle, String paramString) {
        Validate.notNull(paramBundle, "bundle");
        Validate.notNull(paramString, "value");
        paramBundle.putString("com.facebook.TokenCachingStrategy.Token", paramString);
    }

    public abstract void clear();

    public abstract Bundle load();

    public abstract void save(Bundle paramBundle);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/TokenCachingStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */