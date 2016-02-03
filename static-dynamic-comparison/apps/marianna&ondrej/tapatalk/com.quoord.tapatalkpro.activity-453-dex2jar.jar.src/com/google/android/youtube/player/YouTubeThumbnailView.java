package com.google.android.youtube.player;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.youtube.player.internal.ab;
import com.google.android.youtube.player.internal.b;
import com.google.android.youtube.player.internal.t.a;
import com.google.android.youtube.player.internal.t.b;

public final class YouTubeThumbnailView
        extends ImageView {
    private b a;

    public YouTubeThumbnailView(Context paramContext) {
        this(paramContext, null);
    }

    public YouTubeThumbnailView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public YouTubeThumbnailView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public final void initialize(String paramString, final OnInitializedListener paramOnInitializedListener) {
        t.a local1 = new t.a() {
            public final void a() {
                if (YouTubeThumbnailView.a(YouTubeThumbnailView.this) != null) {
                    YouTubeThumbnailView localYouTubeThumbnailView = YouTubeThumbnailView.this;
                    YouTubeThumbnailLoader localYouTubeThumbnailLoader = ab.a().a(YouTubeThumbnailView.a(YouTubeThumbnailView.this), localYouTubeThumbnailView);
                    paramOnInitializedListener.onInitializationSuccess(localYouTubeThumbnailView, localYouTubeThumbnailLoader);
                    YouTubeThumbnailView.b(YouTubeThumbnailView.this);
                }
            }

            public final void b() {
                YouTubeThumbnailView.b(YouTubeThumbnailView.this);
            }
        };
        paramOnInitializedListener = new t.b() {
            public final void a(YouTubeInitializationResult paramAnonymousYouTubeInitializationResult) {
                paramOnInitializedListener.onInitializationFailure(YouTubeThumbnailView.this, paramAnonymousYouTubeInitializationResult);
                YouTubeThumbnailView.b(YouTubeThumbnailView.this);
            }
        };
        this.a = ab.a().a(getContext(), paramString, local1, paramOnInitializedListener);
        this.a.e();
    }

    public static abstract interface OnInitializedListener {
        public abstract void onInitializationFailure(YouTubeThumbnailView paramYouTubeThumbnailView, YouTubeInitializationResult paramYouTubeInitializationResult);

        public abstract void onInitializationSuccess(YouTubeThumbnailView paramYouTubeThumbnailView, YouTubeThumbnailLoader paramYouTubeThumbnailLoader);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/YouTubeThumbnailView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */