package com.facebook;

import android.os.Bundle;

public class NonCachingTokenCachingStrategy
        extends TokenCachingStrategy {
    public void clear() {
    }

    public Bundle load() {
        return null;
    }

    public void save(Bundle paramBundle) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/NonCachingTokenCachingStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */