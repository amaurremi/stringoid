package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailLoader.ErrorReason;
import com.google.android.youtube.player.YouTubeThumbnailLoader.OnThumbnailLoadedListener;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.NoSuchElementException;

public abstract class a
        implements YouTubeThumbnailLoader {
    private final YouTubeThumbnailView a;
    private YouTubeThumbnailLoader.OnThumbnailLoadedListener b;
    private boolean c;
    private boolean d;

    public a(YouTubeThumbnailView paramYouTubeThumbnailView) {
        this.a = ((YouTubeThumbnailView) ac.a(paramYouTubeThumbnailView, "thumbnailView cannot be null"));
    }

    private void h() {
        if (!a()) {
            throw new IllegalStateException("This YouTubeThumbnailLoader has been released");
        }
    }

    public final void a(Bitmap paramBitmap, String paramString) {
        if (a()) {
            this.a.setImageBitmap(paramBitmap);
            if (this.b != null) {
                this.b.onThumbnailLoaded(this.a, paramString);
            }
        }
    }

    public abstract void a(String paramString);

    public abstract void a(String paramString, int paramInt);

    protected boolean a() {
        return !this.d;
    }

    public abstract void b();

    public final void b(String paramString) {
        if ((a()) && (this.b != null)) {
        }
        try {
            paramString = YouTubeThumbnailLoader.ErrorReason.valueOf(paramString);
            this.b.onThumbnailError(this.a, paramString);
            return;
        } catch (IllegalArgumentException paramString) {
            for (; ; ) {
                paramString = YouTubeThumbnailLoader.ErrorReason.UNKNOWN;
            }
        } catch (NullPointerException paramString) {
            for (; ; ) {
                paramString = YouTubeThumbnailLoader.ErrorReason.UNKNOWN;
            }
        }
    }

    public abstract void c();

    public abstract void d();

    public abstract boolean e();

    public abstract boolean f();

    public final void first() {
        h();
        if (!this.c) {
            throw new IllegalStateException("Must call setPlaylist first");
        }
        d();
    }

    public abstract void g();

    public final boolean hasNext() {
        h();
        return e();
    }

    public final boolean hasPrevious() {
        h();
        return f();
    }

    public final void next() {
        h();
        if (!this.c) {
            throw new IllegalStateException("Must call setPlaylist first");
        }
        if (!e()) {
            throw new NoSuchElementException("Called next at end of playlist");
        }
        b();
    }

    public final void previous() {
        h();
        if (!this.c) {
            throw new IllegalStateException("Must call setPlaylist first");
        }
        if (!f()) {
            throw new NoSuchElementException("Called previous at start of playlist");
        }
        c();
    }

    public final void release() {
        if (a()) {
            this.d = true;
            this.b = null;
            g();
        }
    }

    public final void setOnThumbnailLoadedListener(YouTubeThumbnailLoader.OnThumbnailLoadedListener paramOnThumbnailLoadedListener) {
        h();
        this.b = paramOnThumbnailLoadedListener;
    }

    public final void setPlaylist(String paramString) {
        setPlaylist(paramString, 0);
    }

    public final void setPlaylist(String paramString, int paramInt) {
        h();
        this.c = true;
        a(paramString, paramInt);
    }

    public final void setVideo(String paramString) {
        h();
        this.c = false;
        a(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */