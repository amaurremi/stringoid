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
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class AccessToken
        implements Serializable {
    static final String ACCESS_TOKEN_KEY = "access_token";
    private static final Date ALREADY_EXPIRED_EXPIRATION_TIME = MIN_DATE;
    private static final AccessTokenSource DEFAULT_ACCESS_TOKEN_SOURCE;
    private static final Date DEFAULT_EXPIRATION_TIME;
    private static final Date DEFAULT_LAST_REFRESH_TIME;
    static final String EXPIRES_IN_KEY = "expires_in";
    private static final Date MAX_DATE;
    private static final Date MIN_DATE = new Date(Long.MIN_VALUE);
    private static final long serialVersionUID = 1L;
    private final List<String> declinedPermissions;
    private final Date expires;
    private final Date lastRefresh;
    private final List<String> permissions;
    private final AccessTokenSource source;
    private final String token;

    static {
        MAX_DATE = new Date(Long.MAX_VALUE);
        DEFAULT_EXPIRATION_TIME = MAX_DATE;
        DEFAULT_LAST_REFRESH_TIME = new Date();
        DEFAULT_ACCESS_TOKEN_SOURCE = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    }

    AccessToken(String paramString, Date paramDate1, List<String> paramList1, List<String> paramList2, AccessTokenSource paramAccessTokenSource, Date paramDate2) {
        Object localObject = paramList1;
        if (paramList1 == null) {
            localObject = Collections.emptyList();
        }
        paramList1 = paramList2;
        if (paramList2 == null) {
            paramList1 = Collections.emptyList();
        }
        this.expires = paramDate1;
        this.permissions = Collections.unmodifiableList((List) localObject);
        this.declinedPermissions = Collections.unmodifiableList(paramList1);
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

    static AccessToken createEmptyToken() {
        return new AccessToken("", ALREADY_EXPIRED_EXPIRATION_TIME, null, null, AccessTokenSource.NONE, DEFAULT_LAST_REFRESH_TIME);
    }

    private static AccessToken createFromBundle(List<String> paramList, Bundle paramBundle, AccessTokenSource paramAccessTokenSource, Date paramDate) {
        String str = paramBundle.getString("access_token");
        paramBundle = getBundleLongAsDate(paramBundle, "expires_in", paramDate);
        if ((Utility.isNullOrEmpty(str)) || (paramBundle == null)) {
            return null;
        }
        return new AccessToken(str, paramBundle, paramList, null, paramAccessTokenSource, new Date());
    }

    static AccessToken createFromCache(Bundle paramBundle) {
        List localList1 = getPermissionsFromBundle(paramBundle, "com.facebook.TokenCachingStrategy.Permissions");
        List localList2 = getPermissionsFromBundle(paramBundle, "com.facebook.TokenCachingStrategy.DeclinedPermissions");
        return new AccessToken(paramBundle.getString("com.facebook.TokenCachingStrategy.Token"), TokenCachingStrategy.getDate(paramBundle, "com.facebook.TokenCachingStrategy.ExpirationDate"), localList1, localList2, TokenCachingStrategy.getSource(paramBundle), TokenCachingStrategy.getDate(paramBundle, "com.facebook.TokenCachingStrategy.LastRefreshDate"));
    }

    public static AccessToken createFromExistingAccessToken(String paramString, Date paramDate1, Date paramDate2, AccessTokenSource paramAccessTokenSource, List<String> paramList) {
        if (paramDate1 == null) {
            paramDate1 = DEFAULT_EXPIRATION_TIME;
        }
        for (; ; ) {
            if (paramDate2 == null) {
                paramDate2 = DEFAULT_LAST_REFRESH_TIME;
            }
            for (; ; ) {
                if (paramAccessTokenSource == null) {
                    paramAccessTokenSource = DEFAULT_ACCESS_TOKEN_SOURCE;
                }
                for (; ; ) {
                    return new AccessToken(paramString, paramDate1, paramList, null, paramAccessTokenSource, paramDate2);
                }
            }
        }
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
        return createNew(paramBundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS"), null, paramBundle.getString("com.facebook.platform.extra.ACCESS_TOKEN"), localDate, paramAccessTokenSource);
    }

    @SuppressLint({"FieldGetter"})
    static AccessToken createFromRefresh(AccessToken paramAccessToken, Bundle paramBundle) {
        if ((paramAccessToken.source != AccessTokenSource.FACEBOOK_APPLICATION_WEB) && (paramAccessToken.source != AccessTokenSource.FACEBOOK_APPLICATION_NATIVE) && (paramAccessToken.source != AccessTokenSource.FACEBOOK_APPLICATION_SERVICE)) {
            throw new FacebookException("Invalid token source: " + paramAccessToken.source);
        }
        Date localDate = getBundleLongAsDate(paramBundle, "expires_in", new Date(0L));
        paramBundle = paramBundle.getString("access_token");
        return createNew(paramAccessToken.getPermissions(), paramAccessToken.getDeclinedPermissions(), paramBundle, localDate, paramAccessToken.source);
    }

    static AccessToken createFromString(String paramString, List<String> paramList, AccessTokenSource paramAccessTokenSource) {
        return new AccessToken(paramString, DEFAULT_EXPIRATION_TIME, paramList, null, paramAccessTokenSource, DEFAULT_LAST_REFRESH_TIME);
    }

    static AccessToken createFromTokenWithRefreshedPermissions(AccessToken paramAccessToken, List<String> paramList1, List<String> paramList2) {
        return new AccessToken(paramAccessToken.token, paramAccessToken.expires, paramList1, paramList2, paramAccessToken.source, paramAccessToken.lastRefresh);
    }

    static AccessToken createFromWebBundle(List<String> paramList, Bundle paramBundle, AccessTokenSource paramAccessTokenSource) {
        Date localDate = getBundleLongAsDate(paramBundle, "expires_in", new Date());
        String str1 = paramBundle.getString("access_token");
        String str2 = paramBundle.getString("granted_scopes");
        if (!Utility.isNullOrEmpty(str2)) {
            paramList = new ArrayList(Arrays.asList(str2.split(",")));
        }
        str2 = paramBundle.getString("denied_scopes");
        paramBundle = null;
        if (!Utility.isNullOrEmpty(str2)) {
            paramBundle = new ArrayList(Arrays.asList(str2.split(",")));
        }
        return createNew(paramList, paramBundle, str1, localDate, paramAccessTokenSource);
    }

    private static AccessToken createNew(List<String> paramList1, List<String> paramList2, String paramString, Date paramDate, AccessTokenSource paramAccessTokenSource) {
        if ((Utility.isNullOrEmpty(paramString)) || (paramDate == null)) {
            return createEmptyToken();
        }
        return new AccessToken(paramString, paramDate, paramList1, paramList2, paramAccessTokenSource, new Date());
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
            if (l != 0L) {
                break label67;
            }
            return new Date(Long.MAX_VALUE);
            if ((paramBundle instanceof String)) {
                try {
                    l = Long.parseLong((String) paramBundle);
                } catch (NumberFormatException paramBundle) {
                    return null;
                }
            }
        }
        return null;
        label67:
        return new Date(l * 1000L + paramDate.getTime());
    }

    static List<String> getPermissionsFromBundle(Bundle paramBundle, String paramString) {
        paramBundle = paramBundle.getStringArrayList(paramString);
        if (paramBundle == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(paramBundle));
    }

    private void readObject(ObjectInputStream paramObjectInputStream) {
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
        return new AccessToken.SerializationProxyV2(this.token, this.expires, this.permissions, this.declinedPermissions, this.source, this.lastRefresh, null);
    }

    public List<String> getDeclinedPermissions() {
        return this.declinedPermissions;
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
        localBundle.putStringArrayList("com.facebook.TokenCachingStrategy.DeclinedPermissions", new ArrayList(this.declinedPermissions));
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
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AccessToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */