package com.facebook.widget;

import com.facebook.internal.ImageRequest.Callback;
import com.facebook.internal.ImageResponse;
import com.facebook.model.GraphUser;

class UserSettingsFragment$2
        implements ImageRequest.Callback {
    UserSettingsFragment$2(UserSettingsFragment paramUserSettingsFragment) {
    }

    public void onCompleted(ImageResponse paramImageResponse) {
        UserSettingsFragment.access$300(this.this$0, UserSettingsFragment.access$000(this.this$0).getId(), paramImageResponse);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/UserSettingsFragment$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */