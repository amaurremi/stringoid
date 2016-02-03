package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.millennialmedia.a.a.j;

import java.io.Serializable;
import java.lang.ref.WeakReference;

class InlineVideoView
        extends VideoView
        implements Serializable {
    Handler a;
    WeakReference<MMLayout> b;
    InlineVideoView.InlineParams c;
    InlineVideoView.MediaController d;
    InlineVideoView.TransparentHandler e = new InlineVideoView.TransparentHandler(this);
    private int f;

    public InlineVideoView(MMLayout paramMMLayout) {
        super(paramMMLayout.getContext());
        setId(8832429);
        setFocusable(true);
        MMAdImplController.a(paramMMLayout.getContext());
        this.b = new WeakReference(paramMMLayout);
    }

    private void a(boolean paramBoolean) {
        if (!this.c.r) {
            seekTo(this.c.h);
            if ((paramBoolean) || (this.c.m)) {
                startInternal();
                if ((this.a != null) && (!this.a.hasMessages(2))) {
                    this.a.sendMessageDelayed(Message.obtain(this.a, 2), 500L);
                }
            }
        }
    }

    private void d(InlineVideoView.InlineParams paramInlineParams) {
        this.c = paramInlineParams;
    }

    private boolean l() {
        return (!TextUtils.isEmpty(this.c.k)) && (VideoAd.a(getContext(), this.c.k));
    }

    private void m() {
        Utils.ThreadUtils.a(new InlineVideoView.DownloadRunnable(this));
    }

    private void n() {
        this.a = q();
        setVideoURI(o());
        setBackgroundColor(-16777216);
        setClickable(true);
        setOnErrorListener(t());
        setOnCompletionListener(u());
        setOnPreparedListener(v());
        setOnTouchListener(p());
        if (this.c.m) {
            seekTo(this.c.h);
            startInternal();
            if ((this.a != null) && (!this.a.hasMessages(2))) {
                this.a.sendMessageDelayed(Message.obtain(this.a, 2), 500L);
            }
        }
        if (this.c.n) {
            this.d = new InlineVideoView.MediaController(this);
            setMediaController(this.d);
            this.d.show();
        }
        MMLog.e("InlineVideoView", "Finished inserting inlineVideo player");
    }

    private Uri o() {
        if ((l()) && (!this.c.t)) {
            this.c.t = false;
            return VideoAd.b(getContext(), this.c.k);
        }
        if (!TextUtils.isEmpty(this.c.i)) {
            this.c.t = true;
            return Uri.parse(this.c.i);
        }
        return null;
    }

    private View.OnTouchListener p() {
        return new InlineVideoView.VideoTouchListener(this);
    }

    private Handler q() {
        return new InlineVideoView.VideoHandler(this);
    }

    private void r() {
        ViewGroup localViewGroup = (ViewGroup) getParent();
        if (localViewGroup != null) {
            localViewGroup.removeView(this);
        }
    }

    private void s() {
        if (!this.e.hasMessages(4)) {
            this.e.sendEmptyMessage(4);
        }
    }

    private MediaPlayer.OnErrorListener t() {
        return new InlineVideoView.VideoErrorListener(this);
    }

    private MediaPlayer.OnCompletionListener u() {
        return new InlineVideoView.VideoCompletionListener(this);
    }

    private MediaPlayer.OnPreparedListener v() {
        return new InlineVideoView.VideoPreparedListener(this);
    }

    private void w() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        requestFocus();
    }

    String a() {
        return new j().a(this.c);
    }

    void a(double paramDouble) {
        MMLayout localMMLayout = (MMLayout) this.b.get();
        if (localMMLayout == null) {
            MMLog.d("InlineVideoView", "MMLayout weak reference broken");
        }
        localMMLayout.b("javascript:MMJS.inlineVideo.updateVideoSeekTime(" + paramDouble + ");");
    }

    void a(MediaPlayer paramMediaPlayer) {
        if ((this.a != null) && (this.a.hasMessages(2))) {
            this.a.removeMessages(2);
        }
        this.c.r = true;
        this.c.h = this.f;
        if (this.c.h == -1) {
            this.c.h = 0;
        }
        e();
    }

    void a(Message paramMessage) {
        switch (paramMessage.what) {
        }
        do {
            do {
                return;
                if ((isPlaying()) && (getCurrentPosition() > 0)) {
                    this.e.sendEmptyMessageDelayed(5, 100L);
                    return;
                }
                this.e.sendEmptyMessageDelayed(4, 50L);
                return;
            } while ((!isPlaying()) || (getCurrentPosition() <= 0));
            setBackgroundColor(0);
        } while ((this.b == null) || (this.b.get() == null));
        ((MMLayout) this.b.get()).removeBlackView();
    }

    void a(View paramView) {
        paramView = (MMLayout) this.b.get();
        if (paramView != null) {
            setBackgroundColor(-16777216);
            if (isPlaying()) {
                this.c.h = getCurrentPosition();
            }
            if (!this.c.b) {
                break label105;
            }
            this.c.b = false;
            if (this.c.q != 1) {
                break label86;
            }
            paramView = (Activity) getContext();
            if (paramView != null) {
                paramView.setRequestedOrientation(1);
            }
        }
        label86:
        label105:
        do {
            return;
            bool = isPlaying();
            stopPlayback();
            paramView.g();
            a(bool);
            return;
            this.c.q = getContext().getResources().getConfiguration().orientation;
            this.c.b = true;
            if (this.c.q == 2) {
                break;
            }
            paramView = (Activity) getContext();
        } while (paramView == null);
        paramView.setRequestedOrientation(0);
        return;
        boolean bool = isPlaying();
        stopPlayback();
        paramView.h();
        a(bool);
    }

    void a(InlineVideoView.InlineParams paramInlineParams) {
        this.c.a = paramInlineParams.a;
        this.c.c = paramInlineParams.c;
        this.c.f = paramInlineParams.f;
        this.c.g = paramInlineParams.g;
    }

    void a(String paramString) {
        if (isPlaying()) {
            stopPlayback();
        }
        this.c.h = 0;
        setBackgroundColor(-16777216);
        setVideoURI(Uri.parse(paramString));
        startInternal();
    }

    boolean a(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
        if ((this.a != null) && (this.a.hasMessages(2))) {
            this.a.removeMessages(2);
        }
        paramMediaPlayer = (MMLayout) this.b.get();
        if (paramMediaPlayer == null) {
            MMLog.d("InlineVideoView", "MMLayout weak reference broken");
            return false;
        }
        paramMediaPlayer.b("javascript:MMJS.setError(" + String.format("Error while playing, %d - %d", new Object[]{Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)}) + ");");
        return true;
    }

    boolean a(View paramView, MotionEvent paramMotionEvent) {
        if (paramMotionEvent.getAction() == 1) {
            paramView = (MMLayout) this.b.get();
            if (paramView == null) {
                MMLog.d("InlineVideoView", "MMLayout weak reference broken");
                return false;
            }
            if (!TextUtils.isEmpty(this.c.l)) {
                paramView.b(String.format("javascript:" + this.c.l + "(%f,%f)", new Object[]{Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY())}));
            }
            if ((this.c.n) && (this.d != null) && (!this.d.isShowing())) {
                this.d.show();
                return true;
            }
        }
        return true;
    }

    void b(MediaPlayer paramMediaPlayer) {
        if (this.c.m) {
            s();
        }
        seekTo(this.c.h);
        if ((this.c.m) || (!this.c.o)) {
            getHeight();
        }
        for (; ; ) {
            this.f = getDuration();
            return;
            this.c.o = false;
        }
    }

    /* Error */
    void b(InlineVideoView.InlineParams paramInlineParams) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: aload_1
        //   4: invokespecial 435	com/millennialmedia/android/InlineVideoView:d	(Lcom/millennialmedia/android/InlineVideoView$InlineParams;)V
        //   7: aload_0
        //   8: getfield 60	com/millennialmedia/android/InlineVideoView:c	Lcom/millennialmedia/android/InlineVideoView$InlineParams;
        //   11: getfield 438	com/millennialmedia/android/InlineVideoView$InlineParams:j	Ljava/lang/String;
        //   14: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   17: ifne +7 -> 24
        //   20: aload_0
        //   21: invokespecial 440	com/millennialmedia/android/InlineVideoView:m	()V
        //   24: aload_0
        //   25: invokevirtual 442	com/millennialmedia/android/InlineVideoView:b	()Z
        //   28: ifeq +10 -> 38
        //   31: aload_0
        //   32: invokespecial 444	com/millennialmedia/android/InlineVideoView:n	()V
        //   35: aload_0
        //   36: monitorexit
        //   37: return
        //   38: ldc -62
        //   40: ldc_w 446
        //   43: invokestatic 201	com/millennialmedia/android/MMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   46: goto -11 -> 35
        //   49: astore_1
        //   50: aload_0
        //   51: monitorexit
        //   52: aload_1
        //   53: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	54	0	this	InlineVideoView
        //   0	54	1	paramInlineParams	InlineVideoView.InlineParams
        // Exception table:
        //   from	to	target	type
        //   2	24	49	finally
        //   24	35	49	finally
        //   38	46	49	finally
    }

    boolean b() {
        return (!TextUtils.isEmpty(this.c.i)) || (l());
    }

    void c() {
        VideoAd.a(getContext(), this.c.j, this.c.k);
    }

    boolean c(InlineVideoView.InlineParams paramInlineParams) {
        try {
            a(paramInlineParams);
            MMLog.e("InlineVideoView", "Called initInlineVideo inside reposition section code");
            boolean bool = isPlaying();
            stopPlayback();
            paramInlineParams = (MMLayout) this.b.get();
            if (paramInlineParams != null) {
                paramInlineParams.e();
            }
            a(bool);
            return true;
        } finally {
        }
    }

    void d() {
        int i = getCurrentPosition();
        if (i >= 0) {
            MMLog.b("InlineVideoView", "Time is " + i);
            a(Math.floor(i / 1000.0F));
        }
    }

    void e() {
        if (this.f > 0) {
            MMLog.b("InlineVideoView", "Time is " + this.f);
            a(Math.ceil(this.f / 1000.0F));
        }
    }

    void f() {
        if ((this.a != null) && (this.a.hasMessages(2))) {
            this.a.removeMessages(2);
        }
        if (isPlaying()) {
            stopPlayback();
        }
        setOnCompletionListener(null);
        setOnErrorListener(null);
        setOnPreparedListener(null);
        setOnTouchListener(null);
        r();
    }

    void g() {
        if (!isPlaying()) {
            if ((!this.c.s) || (o() == null)) {
                break label95;
            }
            this.c.s = false;
            setVideoURI(o());
            seekTo(0);
        }
        for (; ; ) {
            this.c.r = false;
            startInternal();
            if ((this.a != null) && (!this.a.hasMessages(2))) {
                this.a.sendMessageDelayed(Message.obtain(this.a, 2), 500L);
            }
            return;
            label95:
            if (this.c.r) {
                seekTo(0);
            }
        }
    }

    public RelativeLayout.LayoutParams getCustomLayoutParams() {
        if (this.c.b) {
            return new RelativeLayout.LayoutParams(-1, -1);
        }
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int) (this.c.p * this.c.f), (int) (this.c.p * this.c.g));
        localLayoutParams.topMargin = ((int) (this.c.p * this.c.c));
        localLayoutParams.leftMargin = ((int) (this.c.p * this.c.a));
        MMLog.b("InlineVideoView", "lp height = " + localLayoutParams.height);
        return localLayoutParams;
    }

    void h() {
        if ((this.a != null) && (this.a.hasMessages(2))) {
            this.a.removeMessages(2);
        }
        if (isPlaying()) {
            this.c.s = true;
            this.c.h = 0;
            if ((this.b != null) && (this.b.get() != null)) {
                ((MMLayout) this.b.get()).addBlackView();
            }
            stopPlayback();
        }
    }

    void i() {
        if ((this.a != null) && (this.a.hasMessages(2))) {
            this.a.removeMessages(2);
        }
        if (isPlaying()) {
            this.c.h = getCurrentPosition();
            pause();
        }
    }

    void j() {
        if ((!isPlaying()) && (!this.c.r)) {
            startInternal();
            if ((this.a != null) && (!this.a.hasMessages(2))) {
                this.a.sendMessageDelayed(Message.obtain(this.a, 2), 500L);
            }
        }
    }

    boolean k() {
        return (this.c != null) && (this.c.t);
    }

    public void onRestoreInstanceState(Parcelable paramParcelable) {
        if (!(paramParcelable instanceof AdViewOverlayView.SavedState)) {
            super.onRestoreInstanceState(paramParcelable);
            return;
        }
        paramParcelable = (AdViewOverlayView.SavedState) paramParcelable;
        super.onRestoreInstanceState(paramParcelable.getSuperState());
        this.c.b(paramParcelable.a);
    }

    public Parcelable onSaveInstanceState() {
        AdViewOverlayView.SavedState localSavedState = new AdViewOverlayView.SavedState(super.onSaveInstanceState());
        if (isPlaying()) {
            this.c.h = getCurrentPosition();
        }
        localSavedState.a = a();
        return localSavedState;
    }

    public void start() {
        s();
        w();
        super.start();
    }

    public void startInternal() {
        if (((PowerManager) getContext().getSystemService("power")).isScreenOn()) {
            start();
        }
    }

    public void stopPlayback() {
        if ((this.a != null) && (this.a.hasMessages(2))) {
            this.a.removeMessages(2);
        }
        if (isPlaying()) {
            this.c.h = 0;
        }
        super.stopPlayback();
    }

    public String toString() {
        return this.c.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/InlineVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */