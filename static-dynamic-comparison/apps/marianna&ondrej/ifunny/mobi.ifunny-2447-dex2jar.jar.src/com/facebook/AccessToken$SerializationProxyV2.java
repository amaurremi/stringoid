package com.facebook;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

class AccessToken$SerializationProxyV2
        implements Serializable {
    private static final long serialVersionUID = -2488473066578201068L;
    private final List<String> declinedPermissions;
    private final Date expires;
    private final Date lastRefresh;
    private final List<String> permissions;
    private final AccessTokenSource source;
    private final String token;

    private AccessToken$SerializationProxyV2(String paramString, Date paramDate1, List<String> paramList1, List<String> paramList2, AccessTokenSource paramAccessTokenSource, Date paramDate2) {
        this.expires = paramDate1;
        this.permissions = paramList1;
        this.declinedPermissions = paramList2;
        this.token = paramString;
        this.source = paramAccessTokenSource;
        this.lastRefresh = paramDate2;
    }

    private Object readResolve() {
        return new AccessToken(this.token, this.expires, this.permissions, this.declinedPermissions, this.source, this.lastRefresh);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AccessToken$SerializationProxyV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */