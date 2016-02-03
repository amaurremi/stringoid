package com.millennialmedia.android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CachedVideoPlayerActivity
        extends VideoPlayerActivity
        implements Handler.Callback {
    boolean a;
    boolean b;
    private Handler q;
    private VideoAd r;
    private MMWebView s;
    private TextView t;
    private TextView u;
    private RelativeLayout v;
    private int w;
    private boolean x = true;

    private void a(long paramLong) {
        this.q.postDelayed(new CachedVideoPlayerActivity .1 (this), paramLong);
    }

    private void a(ViewGroup paramViewGroup) {
        this.u = new TextView(this.c);
        this.u.setText(" seconds remaining ...");
        this.u.setTextColor(-1);
        this.u.setPadding(0, 0, 5, 0);
        this.u.setId(402);
        this.u.setShadowLayer(1.0F, 0.0F, 0.0F, -16777216);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(10);
        localLayoutParams.addRule(11);
        paramViewGroup.addView(this.u, localLayoutParams);
    }

    private void b(ViewGroup paramViewGroup) {
        this.t = new TextView(this.c);
        this.t.setText(s());
        this.t.setTextColor(-1);
        this.t.setId(401);
        this.t.setShadowLayer(1.0F, 0.0F, 0.0F, -16777216);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(10);
        localLayoutParams.addRule(0, 402);
        paramViewGroup.addView(this.t, localLayoutParams);
    }

    private void b(VideoImage paramVideoImage) {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramVideoImage.p, paramVideoImage.q);
        localAlphaAnimation.setDuration(paramVideoImage.r);
        localAlphaAnimation.setFillEnabled(true);
        localAlphaAnimation.setFillBefore(true);
        localAlphaAnimation.setFillAfter(true);
        paramVideoImage.t.startAnimation(localAlphaAnimation);
    }

    private void f(String paramString) {
        if ((this.g != null) && (this.r != null) && (!this.g.isPlaying()) && (this.r.j != null) && (paramString.equalsIgnoreCase(this.r.j))) {
            a(0);
        }
    }

    private void p() {
        if ((this.r != null) && (this.r.x != null)) {
            int i = 0;
            while (i < this.r.x.size()) {
                VideoImage localVideoImage = (VideoImage) this.r.x.get(i);
                if (!localVideoImage.s) {
                    a(localVideoImage.t, localVideoImage.p);
                }
                if (localVideoImage.t.getParent() == null) {
                    this.v.addView(localVideoImage.t, localVideoImage.u);
                }
                int j = 0;
                while (j < this.r.x.size()) {
                    this.v.bringChildToFront(((VideoImage) this.r.x.get(j)).t);
                    j += 1;
                }
                MMLog.a("CachedVideoPlayerActivity", String.format("Button: %d alpha: %f", new Object[]{Integer.valueOf(i), Float.valueOf(localVideoImage.p)}));
                i += 1;
            }
        }
    }

    private void q() {
        this.s = new MMWebView(this.c, this.c.a);
        this.s.setId(413);
        Object localObject = new CachedVideoPlayerActivity.CachedVideoWebViewClientListener(this);
        this.s.setWebViewClient(new InterstitialWebViewClient((MMWebViewClient.MMWebViewClientListener) localObject, this.h));
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams) localObject).addRule(13);
        this.s.setLayoutParams((ViewGroup.LayoutParams) localObject);
        this.s.setBackgroundColor(0);
        c(this.r.j);
    }

    private void r() {
        if (this.r != null) {
            this.t.setText(String.valueOf(this.r.q / 1000L));
        }
        this.u.setVisibility(0);
        this.t.setVisibility(0);
    }

    private String s() {
        if (this.e != 0) {
            return String.valueOf(this.e / 1000);
        }
        if (this.r != null) {
            return String.valueOf(this.r.q / 1000L);
        }
        return "";
    }

    private void t() {
        if (this.u != null) {
            this.u.setVisibility(4);
        }
        if (this.t != null) {
            this.t.setVisibility(4);
        }
    }

    protected void a() {
        super.a();
        if ((!this.a) && (this.r != null) && (this.r.m == true) && (this.f == true)) {
            p();
        }
    }

    protected void a(int paramInt) {
        if (this.r == null) {
            Toast.makeText(this.c, "Sorry. There was a problem playing the video", 1).show();
            return;
        }
        if ((!this.q.hasMessages(2)) && (this.r != null)) {
            this.q.sendMessageDelayed(Message.obtain(this.q, 2), 1000L);
        }
        super.a(paramInt);
    }

    protected void a(Bundle paramBundle) {
        paramBundle.putParcelable("videoAd", this.r);
        super.a(paramBundle);
    }

    protected void a(String paramString) {
        if (this.r != null) {
            HttpGetRequest.a(this.r.v);
        }
        if (this.s != null) {
            this.s.loadUrl("javascript:MMJS.cachedVideo.setError(" + paramString + ");");
        }
        super.a(paramString);
    }

    protected RelativeLayout b() {
        RelativeLayout localRelativeLayout = super.b();
        this.q = new Handler(this);
        setRequestedOrientation(0);
        if (this.x) {
            a(localRelativeLayout);
            b(localRelativeLayout);
            r();
        }
        if ((this.r != null) && (this.r.j != null)) {
            q();
            if (this.s != null) {
                localRelativeLayout.addView(this.s);
                this.a = true;
            }
            return localRelativeLayout;
        }
        this.a = false;
        this.v = new RelativeLayout(this.c);
        this.v.setId(1000);
        if (this.r != null) {
        }
        for (ArrayList localArrayList = this.r.x; ; localArrayList = null) {
            if (localArrayList != null) {
                File localFile = AdCache.h(this.c);
                int i = 0;
                VideoImage localVideoImage;
                ImageButton localImageButton;
                if (i < localArrayList.size()) {
                    localVideoImage = (VideoImage) localArrayList.get(i);
                    localImageButton = new ImageButton(this.c);
                    localVideoImage.t = localImageButton;
                    for (; ; ) {
                        try {
                            localObject = BitmapFactory.decodeFile(localFile.getAbsolutePath() + File.separator + this.r.e() + Uri.parse(localVideoImage.a).getLastPathSegment().replaceFirst("\\.[^\\.]*$", ".dat"));
                            if (localObject == null) {
                                continue;
                            }
                            localImageButton.setImageBitmap((Bitmap) localObject);
                        } catch (Exception localException) {
                            Object localObject;
                            MMLog.a("CachedVideoPlayerActivity", "Problem creating layout with bitmap buttons: ", localException);
                            continue;
                            localImageButton.setBackgroundColor(0);
                            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            MMLog.a("CachedVideoPlayerActivity", String.format("Button: %d Anchor: %d Position: %d Anchor2: %d Position2: %d", new Object[]{Integer.valueOf(localImageButton.getId()), Integer.valueOf(localVideoImage.k), Integer.valueOf(localVideoImage.j), Integer.valueOf(localVideoImage.m), Integer.valueOf(localVideoImage.l)}));
                            localLayoutParams.addRule(localVideoImage.j, localVideoImage.k);
                            localLayoutParams.addRule(localVideoImage.l, localVideoImage.m);
                            localLayoutParams.setMargins(localVideoImage.h, localVideoImage.f, localVideoImage.i, localVideoImage.g);
                            continue;
                            this.v.addView(localImageButton, localLayoutParams);
                            continue;
                        }
                        a(localImageButton, localVideoImage.p);
                        localImageButton.setId(i + 1);
                        localImageButton.setPadding(0, 0, 0, 0);
                        if (!localVideoImage.s) {
                            continue;
                        }
                        localImageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        localImageButton.setBackgroundColor(-16777216);
                        localObject = new RelativeLayout.LayoutParams(-1, -1);
                        if (!TextUtils.isEmpty(localVideoImage.d)) {
                            localImageButton.setOnClickListener(new CachedVideoPlayerActivity .2
                            (this, localImageButton, localVideoImage));
                        }
                        if (localVideoImage.n <= 0L) {
                            continue;
                        }
                        localVideoImage.u = ((RelativeLayout.LayoutParams) localObject);
                        localObject = Message.obtain(this.q, 3, localVideoImage);
                        this.q.sendMessageDelayed((Message) localObject, localVideoImage.n);
                        if (localVideoImage.o > 0L) {
                            localObject = Message.obtain(this.q, 1, localVideoImage);
                            this.q.sendMessageDelayed((Message) localObject, localVideoImage.o + localVideoImage.n + localVideoImage.r);
                        }
                        i += 1;
                        break;
                        localImageButton.setImageURI(Uri.parse(localFile.getAbsolutePath() + File.separator + this.r.e() + Uri.parse(localVideoImage.a).getLastPathSegment().replaceFirst("\\.[^\\.]*$", ".dat")));
                    }
                }
                localRelativeLayout.addView(this.v, new RelativeLayout.LayoutParams(-1, -1));
            }
            if (this.v != null) {
                localRelativeLayout.bringChildToFront(this.v);
            }
            if (this.s == null) {
                break;
            }
            localRelativeLayout.bringChildToFront(this.s);
            return localRelativeLayout;
        }
    }

    protected void b(Bundle paramBundle) {
        this.r = ((VideoAd) paramBundle.getParcelable("videoAd"));
        super.b(paramBundle);
    }

    protected void b(String paramString) {
        if (paramString != null) {
            e(paramString);
        }
        if (this.r != null) {
            this.r.g();
            if (!this.r.m) {
                m();
            }
        } else {
            return;
        }
        if ((!this.a) && (this.r.x != null)) {
            p();
            if (!this.r.h()) {
                m();
            }
        }
        if ((this.s != null) && (!TextUtils.isEmpty(this.r.k))) {
            c(this.r.k);
            this.s.bringToFront();
        }
        for (; ; ) {
            if (this.r.s != 0L) {
                a(this.r.s);
            }
            this.q.removeMessages(1);
            this.q.removeMessages(2);
            this.q.removeMessages(3);
            return;
            if (this.a) {
                m();
            }
        }
    }

    protected void c() {
        super.c();
        this.q.removeMessages(1);
        this.q.removeMessages(2);
        this.q.removeMessages(3);
    }

    protected void c(Bundle paramBundle) {
        super.c(paramBundle);
        if (paramBundle == null) {
            paramBundle = getIntent().getStringExtra("videoId");
            this.r = ((VideoAd) AdCache.i(this.c, paramBundle));
            if (this.r != null) {
                this.d = this.r.g;
                this.x = this.r.n;
            }
            return;
        }
        this.r = ((VideoAd) paramBundle.getParcelable("videoAd"));
        this.d = paramBundle.getBoolean("shouldShowBottomBar");
        this.w = paramBundle.getInt("lastVideoPosition");
        this.e = paramBundle.getInt("currentVideoPosition");
        this.x = this.r.n;
    }

    void c(String paramString) {
        new CachedVideoPlayerActivity.FetchWebViewContentTask(this, paramString).execute(new Void[0]);
    }

    protected void d() {
        super.d();
        if (this.s != null) {
            this.s.bringToFront();
        }
        if (this.v != null) {
            this.v.bringToFront();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
        if (this.r != null) {
            if (this.q != null) {
                this.q.removeMessages(1);
            }
            if (!this.a) {
                int i = 0;
                if (i < this.r.x.size()) {
                    VideoImage localVideoImage = (VideoImage) this.r.x.get(i);
                    a(localVideoImage.t, localVideoImage.p);
                    Object localObject;
                    if (localVideoImage.o > 0L) {
                        localObject = Message.obtain(this.q, 1, localVideoImage);
                        this.q.sendMessageDelayed((Message) localObject, localVideoImage.o);
                    }
                    for (; ; ) {
                        i += 1;
                        break;
                        if (paramMotionEvent.getAction() == 1) {
                            if (j()) {
                                localObject = new AlphaAnimation(localVideoImage.p, localVideoImage.q);
                                ((AlphaAnimation) localObject).setDuration(localVideoImage.r);
                                ((AlphaAnimation) localObject).setFillEnabled(true);
                                ((AlphaAnimation) localObject).setFillBefore(true);
                                ((AlphaAnimation) localObject).setFillAfter(true);
                                localVideoImage.t.startAnimation((Animation) localObject);
                            }
                        } else if (paramMotionEvent.getAction() == 0) {
                            a(localVideoImage.t, localVideoImage.p);
                        }
                    }
                }
            }
        }
        return super.dispatchTouchEvent(paramMotionEvent);
    }

    protected void g() {
        long l1;
        int i;
        label105:
        VideoImage localVideoImage;
        Message localMessage;
        if (this.r != null) {
            if (!this.q.hasMessages(2)) {
                this.q.sendMessageDelayed(Message.obtain(this.q, 2), 1000L);
            }
            if (!this.a) {
                if (this.x) {
                    l1 = (this.r.q - this.e) / 1000L;
                    if (l1 <= 0L) {
                        break label263;
                    }
                    if (this.t != null) {
                        this.t.setText(String.valueOf(l1));
                    }
                }
                if (this.r.x != null) {
                    i = 0;
                    if (i < this.r.x.size()) {
                        localVideoImage = (VideoImage) this.r.x.get(i);
                        if ((localVideoImage.n <= 0L) || (this.v.indexOfChild(localVideoImage.t) != -1)) {
                            break label275;
                        }
                        localMessage = Message.obtain(this.q, 3, localVideoImage);
                        long l2 = localVideoImage.n - this.e;
                        l1 = l2;
                        if (l2 < 0L) {
                            l1 = 500L;
                        }
                        this.q.sendMessageDelayed(localMessage, l1);
                    }
                }
            }
        }
        for (; ; ) {
            if (localVideoImage.o > 0L) {
                localMessage = Message.obtain(this.q, 1, localVideoImage);
                this.q.sendMessageDelayed(localMessage, l1 + localVideoImage.o + localVideoImage.r);
            }
            i += 1;
            break label105;
            label263:
            t();
            break;
            super.g();
            return;
            label275:
            l1 = 0L;
        }
    }

    protected void h() {
        if (this.r != null) {
            if (((this.b) || (this.r.w)) && (this.r.j != null) && (this.s != null)) {
                c(this.r.j);
                this.b = false;
            }
            ArrayList localArrayList = this.r.x;
            this.q.removeMessages(1);
            this.q.removeMessages(2);
            this.q.removeMessages(3);
            this.w = 0;
            if ((!this.a) && (this.v != null) && (localArrayList != null)) {
                int i = 0;
                while (i < localArrayList.size()) {
                    VideoImage localVideoImage = (VideoImage) localArrayList.get(i);
                    if (localVideoImage != null) {
                        Object localObject;
                        if (localVideoImage.n > 0L) {
                            localObject = localVideoImage.t;
                            this.v.removeView((View) localObject);
                            localObject = Message.obtain(this.q, 3, localVideoImage);
                            this.q.sendMessageDelayed((Message) localObject, localVideoImage.n);
                        }
                        if (localVideoImage.o > 0L) {
                            localObject = Message.obtain(this.q, 1, localVideoImage);
                            this.q.sendMessageDelayed((Message) localObject, localVideoImage.o + localVideoImage.n + localVideoImage.r);
                        }
                    }
                    i += 1;
                }
            }
            if (this.q != null) {
                this.q.sendMessageDelayed(Message.obtain(this.q, 2), 1000L);
            }
            if (this.x) {
                r();
            }
        }
        super.h();
    }

    public boolean handleMessage(Message paramMessage) {
        switch (paramMessage.what) {
            default:
            case 1:
            case 3:
                for (; ; ) {
                    return true;
                    if (j()) {
                        b((VideoImage) paramMessage.obj);
                        return true;
                        paramMessage = (VideoImage) paramMessage.obj;
                        try {
                            if (this.v.indexOfChild(paramMessage.t) == -1) {
                                this.v.addView(paramMessage.t, paramMessage.u);
                            }
                            if (j()) {
                                b(paramMessage);
                                MMLog.a("CachedVideoPlayerActivity", String.format("Beginning animation to visibility. Fade duration: %d Button: %d Time: %d", new Object[]{Long.valueOf(paramMessage.r), Integer.valueOf(paramMessage.t.getId()), Long.valueOf(System.currentTimeMillis())}));
                                return true;
                            }
                        } catch (IllegalStateException localIllegalStateException) {
                            for (; ; ) {
                                MMLog.a("CachedVideoPlayerActivity", "Problem adding buttons", localIllegalStateException);
                            }
                        }
                    }
                }
        }
        for (; ; ) {
            try {
                if ((this.g != null) && (this.g.isPlaying())) {
                    int k = this.g.getCurrentPosition();
                    if (k > this.w) {
                        if (this.r != null) {
                            if (this.w != 0) {
                                break label465;
                            }
                            this.r.f();
                            break label465;
                            if (i < this.r.y.size()) {
                                paramMessage = (VideoLogEvent) this.r.y.get(i);
                                if ((paramMessage == null) || (paramMessage.a < this.w) || (paramMessage.a >= k)) {
                                    break label470;
                                }
                                int j = 0;
                                if (j >= paramMessage.b.length) {
                                    break label470;
                                }
                                MMSDK.Event.a(paramMessage.b[j]);
                                j += 1;
                                continue;
                            }
                        }
                        this.w = k;
                    }
                    if ((this.a) && (this.s != null)) {
                        this.s.loadUrl("javascript:MMJS.cachedVideo.updateVideoSeekTime(" + (float) Math.floor(k / 1000.0F) + ");");
                    }
                    if (this.x) {
                        long l = (this.r.q - k) / 1000L;
                        if (l <= 0L) {
                            break label458;
                        }
                        if (this.t != null) {
                            this.t.setText(String.valueOf(l));
                        }
                    }
                }
                this.q.sendMessageDelayed(Message.obtain(this.q, 2), 500L);
                return true;
            } catch (IllegalStateException paramMessage) {
                MMLog.a("CachedVideoPlayerActivity", "Error with video check", paramMessage);
                return true;
            }
            label458:
            t();
            continue;
            label465:
            int i = 0;
            continue;
            label470:
            i += 1;
        }
    }

    protected void i() {
        super.i();
        if ((this.a) || (this.r == null) || (this.r.x == null)) {
        }
        for (; ; ) {
            return;
            Iterator localIterator = this.r.x.iterator();
            while (localIterator.hasNext()) {
                VideoImage localVideoImage = (VideoImage) localIterator.next();
                if (localVideoImage.t != null) {
                    localVideoImage.t.setEnabled(true);
                }
            }
        }
    }

    protected boolean j() {
        return (!this.r.m) || (!super.j());
    }

    public void onCompletion(MediaPlayer paramMediaPlayer) {
        super.onCompletion(paramMediaPlayer);
        if (this.x) {
            t();
        }
        if (this.r != null) {
            b(this.r.i);
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        MMLog.a("CachedVideoPlayerActivity", "Is Cached Ad");
    }

    public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
        a(String.format("Error while playing, %d - %d", new Object[]{Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)}));
        return super.onError(paramMediaPlayer, paramInt1, paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/CachedVideoPlayerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */