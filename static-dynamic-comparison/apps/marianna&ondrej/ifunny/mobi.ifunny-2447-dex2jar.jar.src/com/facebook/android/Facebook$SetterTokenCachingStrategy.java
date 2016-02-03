package com.facebook.android;

import android.os.Bundle;
import com.facebook.AccessTokenSource;
import com.facebook.TokenCachingStrategy;

class Facebook$SetterTokenCachingStrategy
        extends TokenCachingStrategy {
    private Facebook$SetterTokenCachingStrategy(Facebook paramFacebook) {
    }

    public void clear() {
        Facebook.access$102(this.this$0, null);
    }

    public Bundle load() {
        Bundle localBundle = new Bundle();
        if (Facebook.access$100(this.this$0) != null) {
            TokenCachingStrategy.putToken(localBundle, Facebook.access$100(this.this$0));
            TokenCachingStrategy.putExpirationMilliseconds(localBundle, Facebook.access$400(this.this$0));
            TokenCachingStrategy.putPermissions(localBundle, Facebook.access$600(Facebook.access$500(this.this$0)));
            TokenCachingStrategy.putSource(localBundle, AccessTokenSource.WEB_VIEW);
            TokenCachingStrategy.putLastRefreshMilliseconds(localBundle, Facebook.access$700(this.this$0));
        }
        return localBundle;
    }

    public void save(Bundle paramBundle) {
        Facebook.access$102(this.this$0, TokenCachingStrategy.getToken(paramBundle));
        Facebook.access$402(this.this$0, TokenCachingStrategy.getExpirationMilliseconds(paramBundle));
        Facebook.access$502(this.this$0, Facebook.access$800(TokenCachingStrategy.getPermissions(paramBundle)));
        Facebook.access$702(this.this$0, TokenCachingStrategy.getLastRefreshMilliseconds(paramBundle));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/android/Facebook$SetterTokenCachingStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */