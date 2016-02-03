package com.facebook;

import android.os.Bundle;

final class TestSession$TestTokenCachingStrategy
        extends TokenCachingStrategy {
    private Bundle bundle;

    public void clear() {
        this.bundle = null;
    }

    public Bundle load() {
        return this.bundle;
    }

    public void save(Bundle paramBundle) {
        this.bundle = paramBundle;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/TestSession$TestTokenCachingStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */