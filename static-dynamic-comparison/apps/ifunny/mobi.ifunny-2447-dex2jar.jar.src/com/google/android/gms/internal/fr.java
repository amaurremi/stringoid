package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.HashMap;
import java.util.Map;

@ii
public final class fr
        extends FrameLayout
        implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
    private final mz a;
    private final MediaController b;
    private final fs c;
    private final VideoView d;
    private long e;
    private String f;

    public fr(Context paramContext, mz parammz) {
        super(paramContext);
        this.a = parammz;
        this.d = new VideoView(paramContext);
        parammz = new FrameLayout.LayoutParams(-1, -1, 17);
        addView(this.d, parammz);
        this.b = new MediaController(paramContext);
        this.c = new fs(this);
        this.c.b();
        this.d.setOnCompletionListener(this);
        this.d.setOnPreparedListener(this);
        this.d.setOnErrorListener(this);
    }

    private static void a(mz parammz, String paramString) {
        a(parammz, paramString, new HashMap(1));
    }

    public static void a(mz parammz, String paramString1, String paramString2) {
        int i;
        if (paramString2 == null) {
            i = 1;
            if (i == 0) {
                break label60;
            }
        }
        label60:
        for (int j = 2; ; j = 3) {
            HashMap localHashMap = new HashMap(j);
            localHashMap.put("what", paramString1);
            if (i == 0) {
                localHashMap.put("extra", paramString2);
            }
            a(parammz, "error", localHashMap);
            return;
            i = 0;
            break;
        }
    }

    private static void a(mz parammz, String paramString1, String paramString2, String paramString3) {
        HashMap localHashMap = new HashMap(2);
        localHashMap.put(paramString2, paramString3);
        a(parammz, paramString1, localHashMap);
    }

    private static void a(mz parammz, String paramString, Map<String, String> paramMap) {
        paramMap.put("event", paramString);
        parammz.a("onVideoEvent", paramMap);
    }

    public void a() {
        this.c.a();
        this.d.stopPlayback();
    }

    public void a(int paramInt) {
        this.d.seekTo(paramInt);
    }

    public void a(MotionEvent paramMotionEvent) {
        this.d.dispatchTouchEvent(paramMotionEvent);
    }

    public void a(String paramString) {
        this.f = paramString;
    }

    public void a(boolean paramBoolean) {
        if (paramBoolean) {
            this.d.setMediaController(this.b);
            return;
        }
        this.b.hide();
        this.d.setMediaController(null);
    }

    public void b() {
        if (!TextUtils.isEmpty(this.f)) {
            this.d.setVideoPath(this.f);
            return;
        }
        a(this.a, "no_src", null);
    }

    public void c() {
        this.d.pause();
    }

    public void d() {
        this.d.start();
    }

    public void e() {
        long l = this.d.getCurrentPosition();
        if (this.e != l) {
            float f1 = (float) l / 1000.0F;
            a(this.a, "timeupdate", "time", String.valueOf(f1));
            this.e = l;
        }
    }

    public void onCompletion(MediaPlayer paramMediaPlayer) {
        a(this.a, "ended");
    }

    public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
        a(this.a, String.valueOf(paramInt1), String.valueOf(paramInt2));
        return true;
    }

    public void onPrepared(MediaPlayer paramMediaPlayer) {
        float f1 = this.d.getDuration() / 1000.0F;
        a(this.a, "canplaythrough", "duration", String.valueOf(f1));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/fr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */