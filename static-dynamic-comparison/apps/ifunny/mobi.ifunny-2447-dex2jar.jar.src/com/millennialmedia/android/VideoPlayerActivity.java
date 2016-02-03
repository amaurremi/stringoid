package com.millennialmedia.android;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import android.widget.VideoView;

import java.lang.ref.WeakReference;

class VideoPlayerActivity
        extends MMBaseActivity
        implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
    private boolean a;
    private boolean b;
    protected boolean d = true;
    protected int e = 0;
    protected boolean f;
    protected VideoView g;
    HttpRedirection.RedirectionListenerImpl h;
    String i;
    RelativeLayout j;
    ProgressBar k;
    Button l;
    View m;
    VideoPlayerActivity.TransparentHandler n = new VideoPlayerActivity.TransparentHandler(this);
    boolean o;
    boolean p = false;
    private boolean q = true;

    private void a(RelativeLayout paramRelativeLayout) {
        RelativeLayout localRelativeLayout = new RelativeLayout(this.c);
        localRelativeLayout.setId(83756563);
        localRelativeLayout.setBackgroundColor(-16777216);
        RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
        localRelativeLayout.setLayoutParams(localLayoutParams1);
        localLayoutParams1.addRule(12);
        Button localButton1 = new Button(this.c);
        this.l = new Button(this.c);
        Button localButton2 = new Button(this.c);
        localButton1.setBackgroundResource(17301541);
        if (this.g.isPlaying()) {
            this.l.setBackgroundResource(17301539);
        }
        for (; ; ) {
            localButton2.setBackgroundResource(17301560);
            RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams2.addRule(14);
            localRelativeLayout.addView(this.l, localLayoutParams2);
            localLayoutParams4.addRule(0, this.l.getId());
            localRelativeLayout.addView(localButton1);
            localLayoutParams3.addRule(11);
            localRelativeLayout.addView(localButton2, localLayoutParams3);
            localButton1.setOnClickListener(new VideoPlayerActivity .2 (this));
            this.l.setOnClickListener(new VideoPlayerActivity .3 (this));
            localButton2.setOnClickListener(new VideoPlayerActivity .4 (this));
            paramRelativeLayout.addView(localRelativeLayout, localLayoutParams1);
            return;
            this.l.setBackgroundResource(17301540);
        }
    }

    private boolean a(Uri paramUri) {
        if (paramUri.getScheme().equalsIgnoreCase("mmsdk")) {
            if (b(paramUri.getHost())) {
                return true;
            }
            MMLog.a("VideoPlayerActivity", String.format("Unrecognized mmsdk:// URI %s.", new Object[]{paramUri}));
        }
        return false;
    }

    private void b(int paramInt) {
        this.g.requestFocus();
        this.g.seekTo(paramInt);
        if (((PowerManager) getSystemService("power")).isScreenOn()) {
            if (this.k != null) {
                this.k.bringToFront();
                this.k.setVisibility(0);
            }
            if (this.l != null) {
                this.l.setBackgroundResource(17301539);
            }
            this.g.start();
            r();
        }
    }

    private boolean b(String paramString) {
        return (paramString != null) && ((paramString.equalsIgnoreCase("restartVideo")) || (paramString.equalsIgnoreCase("endVideo")));
    }

    private void p() {
        requestWindowFeature(1);
        getWindow().clearFlags(2048);
        getWindow().addFlags(1024);
    }

    private void q() {
        this.h = new VideoPlayerActivity.VideoRedirectionListener(this);
    }

    private void r() {
        if (!this.n.hasMessages(4)) {
            this.n.sendEmptyMessage(4);
        }
    }

    private void s() {
        this.g.setOnCompletionListener(this);
        this.g.setOnPreparedListener(this);
        this.g.setOnErrorListener(this);
    }

    protected void a(int paramInt) {
        try {
            this.p = false;
            String str = getIntent().getData().toString();
            MMLog.b("VideoPlayerActivity", String.format("playVideo path: %s", new Object[]{str}));
            if ((str == null) || (str.length() == 0) || (this.g == null)) {
                a("no name or null videoview");
                return;
            }
            this.f = false;
            if ((this.q) && (this.g != null)) {
                this.g.setVideoURI(Uri.parse(str));
            }
            b(paramInt);
            return;
        } catch (Exception localException) {
            MMLog.a("VideoPlayerActivity", "playVideo error: ", localException);
            a("error: " + localException);
        }
    }

    protected void a(Bundle paramBundle) {
        paramBundle.putInt("currentVideoPosition", this.e);
        paramBundle.putBoolean("isVideoCompleted", this.f);
        paramBundle.putBoolean("isVideoCompletedOnce", this.a);
        paramBundle.putBoolean("hasBottomBar", this.d);
        paramBundle.putBoolean("shouldSetUri", this.q);
        paramBundle.putBoolean("isUserPausing", this.p);
        paramBundle.putBoolean("isPaused", this.o);
        super.a(paramBundle);
    }

    void a(Message paramMessage) {
        switch (paramMessage.what) {
        }
        do {
            return;
            if ((this.g != null) && (this.g.isPlaying()) && (this.g.getCurrentPosition() > 0)) {
                this.g.setBackgroundColor(0);
                this.n.sendEmptyMessageDelayed(5, 100L);
                return;
            }
            this.n.sendEmptyMessageDelayed(4, 50L);
            return;
        } while ((this.g == null) || (!this.g.isPlaying()) || (this.g.getCurrentPosition() <= 0));
        this.m.setVisibility(4);
        this.k.setVisibility(4);
    }

    protected void a(ImageButton paramImageButton, float paramFloat) {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
        localAlphaAnimation.setDuration(0L);
        localAlphaAnimation.setFillEnabled(true);
        localAlphaAnimation.setFillBefore(true);
        localAlphaAnimation.setFillAfter(true);
        paramImageButton.startAnimation(localAlphaAnimation);
    }

    protected void a(VideoImage paramVideoImage) {
        MMLog.b("VideoPlayerActivity", "Cached video button event logged");
        int i1 = 0;
        while (i1 < paramVideoImage.c.length) {
            MMSDK.Event.a(paramVideoImage.c[i1]);
            i1 += 1;
        }
    }

    protected void a(String paramString) {
        Toast.makeText(this.c, "Sorry. There was a problem playing the video", 1).show();
        if (this.g != null) {
            this.g.stopPlayback();
        }
    }

    protected RelativeLayout b() {
        RelativeLayout localRelativeLayout = new RelativeLayout(this.c);
        localRelativeLayout.setId(400);
        localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        localRelativeLayout.setBackgroundColor(-16777216);
        this.j = new RelativeLayout(this.c);
        this.j.setBackgroundColor(-16777216);
        this.j.setId(410);
        RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
        RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams2.addRule(13);
        localLayoutParams1.addRule(13);
        this.g = new VideoView(this.c);
        this.g.setId(411);
        this.g.getHolder().setFormat(-2);
        this.g.setBackgroundColor(-16777216);
        s();
        this.j.addView(this.g, localLayoutParams2);
        this.m = new View(this.c);
        this.m.setBackgroundColor(-16777216);
        localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        localRelativeLayout.addView(this.j, localLayoutParams1);
        if (this.d) {
            localLayoutParams2.addRule(2, 83756563);
            a(localRelativeLayout);
        }
        this.m.setLayoutParams(localLayoutParams2);
        localRelativeLayout.addView(this.m);
        this.k = new ProgressBar(this.c);
        this.k.setIndeterminate(true);
        localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams1.addRule(13);
        this.k.setLayoutParams(localLayoutParams1);
        localRelativeLayout.addView(this.k);
        this.k.setVisibility(4);
        return localRelativeLayout;
    }

    protected void b(Bundle paramBundle) {
        this.e = paramBundle.getInt("currentVideoPosition");
        this.f = paramBundle.getBoolean("isVideoCompleted");
        this.a = paramBundle.getBoolean("isVideoCompletedOnce");
        this.d = paramBundle.getBoolean("hasBottomBar", this.d);
        this.q = paramBundle.getBoolean("shouldSetUri", this.q);
        this.p = paramBundle.getBoolean("isUserPausing", this.p);
        this.o = paramBundle.getBoolean("isPaused", this.o);
        super.b(paramBundle);
    }

    protected void c() {
        if ((this.g != null) && (this.g.isPlaying())) {
            this.e = this.g.getCurrentPosition();
            this.g.pause();
            MMLog.a("VideoPlayerActivity", "Video paused");
        }
    }

    protected void c(Bundle paramBundle) {
        if (paramBundle != null) {
            this.f = paramBundle.getBoolean("videoCompleted");
            this.a = paramBundle.getBoolean("videoCompletedOnce");
            this.e = paramBundle.getInt("videoPosition");
            this.d = paramBundle.getBoolean("hasBottomBar");
            this.q = paramBundle.getBoolean("shouldSetUri");
        }
    }

    protected void d() {
        super.d();
        this.m.bringToFront();
        this.m.setVisibility(0);
        this.o = false;
        MMLog.a("VideoPlayerActivity", "VideoPlayer - onResume");
        if ((this.b) && (!this.p)) {
            g();
        }
    }

    void d(String paramString) {
        runOnUiThread(new VideoPlayerActivity .1 (this, paramString));
    }

    protected void e() {
        super.e();
        this.o = true;
        MMLog.a("VideoPlayerActivity", "VideoPlayer - onPause");
        c();
    }

    void e(String paramString) {
        if (paramString == null) {
        }
        do {
            return;
            MMLog.b("VideoPlayerActivity", String.format("Button Click with URL: %s", new Object[]{paramString}));
            this.h.a = paramString;
            this.h.b = new WeakReference(this.c);
        } while (this.h.isHandlingMMVideo(Uri.parse(paramString)));
        HttpRedirection.a(this.h);
    }

    protected void g() {
        if (o()) {
            a(this.e);
        }
    }

    protected void h() {
        MMLog.b("VideoPlayerActivity", "Restart Video.");
        if (this.g != null) {
            a(0);
        }
    }

    protected void i() {
    }

    protected boolean j() {
        return !this.f;
    }

    protected void l() {
        MMLog.b("VideoPlayerActivity", "End Video.");
        if (this.g != null) {
            this.q = true;
            m();
        }
    }

    protected void m() {
        MMLog.b("VideoPlayerActivity", "Video ad player closed");
        if (this.g != null) {
            if (this.g.isPlaying()) {
                this.g.stopPlayback();
            }
            this.g = null;
        }
        finish();
    }

    protected void n() {
        this.p = true;
        c();
    }

    protected boolean o() {
        return (this.g != null) && (!this.g.isPlaying()) && (!this.f);
    }

    public void onCompletion(MediaPlayer paramMediaPlayer) {
        this.a = true;
        this.f = true;
        if ((this.l != null) && (!this.g.isPlaying())) {
            this.l.setBackgroundResource(17301540);
        }
        MMLog.a("VideoPlayerActivity", "Video player on complete");
    }

    public void onCreate(Bundle paramBundle) {
        setTheme(16973829);
        super.onCreate(paramBundle);
        MMLog.b("VideoPlayerActivity", "Setting up the video player");
        p();
        c(paramBundle);
        q();
        setContentView(b());
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
        return false;
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0) && (!this.a)) {
            return true;
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }

    public void onPrepared(MediaPlayer paramMediaPlayer) {
        MMLog.b("VideoPlayerActivity", "Video Prepared");
    }

    public void onWindowFocusChanged(boolean paramBoolean) {
        super.onWindowFocusChanged(paramBoolean);
        this.b = paramBoolean;
        if ((!this.o) && (paramBoolean) && (!this.p)) {
            g();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/VideoPlayerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */