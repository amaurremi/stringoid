package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

public final class ad
        extends ab {
    public final YouTubeThumbnailLoader a(b paramb, YouTubeThumbnailView paramYouTubeThumbnailView) {
        return new p(paramb, paramYouTubeThumbnailView);
    }

    public final b a(Context paramContext, String paramString, t.a parama, t.b paramb) {
        return new o(paramContext, paramString, paramContext.getPackageName(), z.d(paramContext), parama, paramb);
    }

    public final d a(Activity paramActivity, b paramb)
            throws w.a {
        return w.a(paramActivity, paramb.a());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/internal/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */