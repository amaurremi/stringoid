package com.facebook.internal;

import android.os.Bundle;

class LikeActionController$9
        implements PlatformServiceClient.CompletedListener {
    LikeActionController$9(LikeActionController paramLikeActionController) {
    }

    public void completed(Bundle paramBundle) {
        if ((paramBundle == null) || (!paramBundle.containsKey("com.facebook.platform.extra.OBJECT_IS_LIKED"))) {
            return;
        }
        boolean bool = paramBundle.getBoolean("com.facebook.platform.extra.OBJECT_IS_LIKED");
        String str1 = paramBundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE");
        String str2 = paramBundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE");
        String str3 = paramBundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE");
        String str4 = paramBundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE");
        paramBundle = paramBundle.getString("com.facebook.platform.extra.UNLIKE_TOKEN");
        LikeActionController.access$900(this.this$0, bool, str1, str2, str3, str4, paramBundle);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */