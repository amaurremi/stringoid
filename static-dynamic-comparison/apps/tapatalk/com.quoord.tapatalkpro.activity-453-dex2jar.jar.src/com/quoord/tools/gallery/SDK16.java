package com.quoord.tools.gallery;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

@TargetApi(16)
public class SDK16 {
    public static void postOnAnimation(View paramView, Runnable paramRunnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            paramView.postOnAnimation(paramRunnable);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/gallery/SDK16.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */