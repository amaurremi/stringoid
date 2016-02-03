package com.quoord.tools.gallery;

import android.os.Build.VERSION;
import android.view.View;

public class Compat {
    private static final int SIXTY_FPS_INTERVAL = 16;

    public static void postOnAnimation(View paramView, Runnable paramRunnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            SDK16.postOnAnimation(paramView, paramRunnable);
            return;
        }
        paramView.postDelayed(paramRunnable, 16L);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/gallery/Compat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */