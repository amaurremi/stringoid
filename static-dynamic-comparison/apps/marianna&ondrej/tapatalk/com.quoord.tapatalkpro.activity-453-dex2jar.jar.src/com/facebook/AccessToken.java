package com.facebook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class AccessToken
        implements Serializable {
    static final String ACCESS_TOKEN_KEY = "access_token";
    private static final Date ALREADY_EXPIRED_EXPIRATION_TIME;
    private static final AccessTokenSource DEFAULT_ACCESS_TOKEN_SOURCE;
    private static final Date DEFAULT_EXPIRATION_TIME;
    private static final Date DEFAULT_LAST_REFRESH_TIME;
    static final String EXPIRES_IN_KEY = "expires_in";
    private static final Date MAX_DATE;
    private static final Date MIN_DATE;
    private static final long serialVersionUID = 1L;
    private final Date expires;
    private final Date lastRefresh;
    private final List<String> permissions;
    private final AccessTokenSource source;
    private final String token;

    static {
        if (!AccessToken.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            $assertionsDisabled = bool;
            MIN_DATE = new Date(Long.MIN_VALUE);
            MAX_DATE = new Date(Long.MAX_VALUE);
            DEFAULT_EXPIRATION_TIME = MAX_DATE;
            DEFAULT_LAST_REFRESH_TIME = new Date();
            DEFAULT_ACCESS_TOKEN_SOURCE = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
            ALREADY_EXPIRED_EXPIRATION_TIME = MIN_DATE;
            return;
        }
    }

    AccessToken(String paramString, Date paramDate1, List<String> paramList, AccessTokenSource paramAccessTokenSource, Date paramDate2) {
        Object localObject = paramList;
        if (paramList == null) {
            localObject = Collections.emptyList();
        }
        this.expires = paramDate1;
        this.permissions = Collections.unmodifiableList((List) localObject);
        this.token = paramString;
        this.source = paramAccessTokenSource;
        this.lastRefresh = paramDate2;
    }

    private void appendPermissions(StringBuilder paramStringBuilder) {
        paramStringBuilder.append(" permissions:");
        if (this.permissions == null) {
            paramStringBuilder.append("null");
            return;
        }
        paramStringBuilder.append("[");
        paramStringBuilder.append(TextUtils.join(", ", this.permissions));
        paramStringBuilder.append("]");
    }

    static AccessToken createEmptyToken(List<String> paramList) {
        return new AccessToken("", ALREADY_EXPIRED_EXPIRATION_TIME, paramList, AccessTokenSource.NONE, DEFAULT_LAST_REFRESH_TIME);
    }

    private static AccessToken createFromBundle(List<String> paramList, Bundle paramBundle, AccessTokenSource paramAccessTokenSource, Date paramDate) {
        String str = paramBundle.getString("access_token");
        paramBundle = getBundleLongAsDate(paramBundle, "expires_in", paramDate);
        if ((Utility.isNullOrEmpty(str)) || (paramBundle == null)) {
            return null;
        }
        return new AccessToken(str, paramBundle, paramList, paramAccessTokenSource, new Date());
    }

    static AccessToken createFromCache(Bundle paramBundle) {
        Object localObject = paramBundle.getStringArrayList("com.facebook.TokenCachingStrategy.Permissions");
        if (localObject == null) {
        }
        for (localObject = Collections.emptyList(); ; localObject = Collections.unmodifiableList(new ArrayList((Collection) localObject))) {
            return new AccessToken(paramBundle.getString("com.facebook.TokenCachingStrategy.Token"), TokenCachingStrategy.getDate(paramBundle, "com.facebook.TokenCachingStrategy.ExpirationDate"), (List) localObject, TokenCachingStrategy.getSource(paramBundle), TokenCachingStrategy.getDate(paramBundle, "com.facebook.TokenCachingStrategy.LastRefreshDate"));
        }
    }

    public static AccessToken createFromExistingAccessToken(String paramString, Date paramDate1, Date paramDate2, AccessTokenSource paramAccessTokenSource, List<String> paramList) {
        Date localDate = paramDate1;
        if (paramDate1 == null) {
            localDate = DEFAULT_EXPIRATION_TIME;
        }
        paramDate1 = paramDate2;
        if (paramDate2 == null) {
            paramDate1 = DEFAULT_LAST_REFRESH_TIME;
        }
        paramDate2 = paramAccessTokenSource;
        if (paramAccessTokenSource == null) {
            paramDate2 = DEFAULT_ACCESS_TOKEN_SOURCE;
        }
        return new AccessToken(paramString, localDate, paramList, paramDate2, paramDate1);
    }

    public static AccessToken createFromNativeLinkingIntent(Intent paramIntent) {
        Validate.notNull(paramIntent, "intent");
        if (paramIntent.getExtras() == null) {
            return null;
        }
        return createFromBundle(null, paramIntent.getExtras(), AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date());
    }

    static AccessToken createFromNativeLogin(Bundle paramBundle, AccessTokenSource paramAccessTokenSource) {
        Date localDate = getBundleLongAsDate(paramBundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L));
        return createNew(paramBundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS"), paramBundle.getString("com.facebook.platform.extra.ACCESS_TOKEN"), localDate, paramAccessTokenSource);
    }

    @SuppressLint({"FieldGetter"})
    static AccessToken createFromRefresh(AccessToken paramAccessToken, Bundle paramBundle) {
        assert ((paramAccessToken.source == AccessTokenSource.FACEBOOK_APPLICATION_WEB) || (paramAccessToken.source == AccessTokenSource.FACEBOOK_APPLICATION_NATIVE) || (paramAccessToken.source == AccessTokenSource.FACEBOOK_APPLICATION_SERVICE));
        Date localDate = getBundleLongAsDate(paramBundle, "expires_in", new Date(0L));
        paramBundle = paramBundle.getString("access_token");
        return createNew(paramAccessToken.getPermissions(), paramBundle, localDate, paramAccessToken.source);
    }

    static AccessToken createFromString(String paramString, List<String> paramList, AccessTokenSource paramAccessTokenSource) {
        return new AccessToken(paramString, DEFAULT_EXPIRATION_TIME, paramList, paramAccessTokenSource, DEFAULT_LAST_REFRESH_TIME);
    }

    static AccessToken createFromTokenWithRefreshedPermissions(AccessToken paramAccessToken, List<String> paramList) {
        return new AccessToken(paramAccessToken.token, paramAccessToken.expires, paramList, paramAccessToken.source, paramAccessToken.lastRefresh);
    }

    static AccessToken createFromWebBundle(List<String> paramList, Bundle paramBundle, AccessTokenSource paramAccessTokenSource) {
        Date localDate = getBundleLongAsDate(paramBundle, "expires_in", new Date());
        return createNew(paramList, paramBundle.getString("access_token"), localDate, paramAccessTokenSource);
    }

    private static AccessToken createNew(List<String> paramList, String paramString, Date paramDate, AccessTokenSource paramAccessTokenSource) {
        if ((Utility.isNullOrEmpty(paramString)) || (paramDate == null)) {
            return createEmptyToken(paramList);
        }
        return new AccessToken(paramString, paramDate, paramList, paramAccessTokenSource, new Date());
    }

    private static Date getBundleLongAsDate(Bundle paramBundle, String paramString, Date paramDate) {
        if (paramBundle == null) {
            return null;
        }
        paramBundle = paramBundle.get(paramString);
        long l;
        if ((paramBundle instanceof Long)) {
            l = ((Long) paramBundle).longValue();
        }
        for (; ; ) {
            if (l == 0L) {
                return new Date(Long.MAX_VALUE);
                if (!(paramBundle instanceof String)) {
                    break;
                }
                try {
                    l = Long.parseLong((String) paramBundle);
                } catch (NumberFormatException paramBundle) {
                    return null;
                }
            }
        }
        return new Date(paramDate.getTime() + 1000L * l);
    }

    private void readObject(ObjectInputStream paramObjectInputStream)
            throws InvalidObjectException {
        throw new InvalidObjectException("Cannot readObject, serialization proxy required");
    }

    private String tokenToString() {
        if (this.token == null) {
            return "null";
        }
        if (Settings.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
            return this.token;
        }
        return "ACCESS_TOKEN_REMOVED";
    }

    private Object writeReplace() {
        return new SerializationProxyV1(this.token, this.expires, this.permissions, this.source, this.lastRefresh, null);
    }

    public Date getExpires() {
        return this.expires;
    }

    public Date getLastRefresh() {
        return this.lastRefresh;
    }

    public List<String> getPermissions() {
        return this.permissions;
    }

    public AccessTokenSource getSource() {
        return this.source;
    }

    public String getToken() {
        return this.token;
    }

    boolean isInvalid() {
        return (Utility.isNullOrEmpty(this.token)) || (new Date().after(this.expires));
    }

    Bundle toCacheBundle() {
        Bundle localBundle = new Bundle();
        localBundle.putString("com.facebook.TokenCachingStrategy.Token", this.token);
        TokenCachingStrategy.putDate(localBundle, "com.facebook.TokenCachingStrategy.ExpirationDate", this.expires);
        localBundle.putStringArrayList("com.facebook.TokenCachingStrategy.Permissions", new ArrayList(this.permissions));
        localBundle.putSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource", this.source);
        TokenCachingStrategy.putDate(localBundle, "com.facebook.TokenCachingStrategy.LastRefreshDate", this.lastRefresh);
        return localBundle;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{AccessToken");
        localStringBuilder.append(" token:").append(tokenToString());
        appendPermissions(localStringBuilder);
        localStringBuilder.append("}");
        return localStringBuilder.toString();
    }

    private static class SerializationProxyV1
            implements Serializable {
        private static final long serialVersionUID = -2488473066578201069L;
        private final Date expires;
        private final Date lastRefresh;
        private final List<String> permissions;
        private final AccessTokenSource source;
        private final String token;

        private SerializationProxyV1(String paramString, Date paramDate1, List<String> paramList, AccessTokenSource paramAccessTokenSource, Date paramDate2) {
            this.expires = paramDate1;
            this.permissions = paramList;
            this.token = paramString;
            this.source = paramAccessTokenSource;
            this.lastRefresh = paramDate2;
        }

        private Object readResolve() {
            return new AccessToken(this.token, this.expires, this.permissions, this.source, this.lastRefresh);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/AccessToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */