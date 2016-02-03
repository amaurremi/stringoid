package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import java.lang.reflect.Method;

abstract class MMLayout
        extends RelativeLayout
        implements InlineVideoView.TransparentFix, MMAd {
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_WIDTH = "width";
    private static boolean b;
    private GestureDetector a;
    MMAdImpl h;
    String i;
    boolean j;
    View k;
    RelativeLayout l;
    InlineVideoView m;
    View n;

    protected MMLayout(Context paramContext) {
        super(paramContext);
        a(paramContext);
    }

    @Deprecated
    protected MMLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a(paramContext);
    }

    private void a() {
        if (this.n != null) {
            localObject = this.n.getParent();
            if ((localObject != null) && ((localObject instanceof ViewGroup))) {
                ((ViewGroup) localObject).removeView(this.n);
                this.n = null;
            }
        }
        this.n = new View(getContext());
        this.n.setBackgroundColor(-16777216);
        Object localObject = new RelativeLayout.LayoutParams(-1, -1);
        this.n.setLayoutParams((ViewGroup.LayoutParams) localObject);
        if ((this.l != null) && (this.n.getParent() == null)) {
            this.l.addView(this.n);
        }
    }

    private void a(String paramString) {
        RelativeLayout.LayoutParams localLayoutParams;
        if (this.k == null) {
            this.k = new View(getContext());
            float f = getContext().getResources().getDisplayMetrics().density;
            localLayoutParams = new RelativeLayout.LayoutParams((int) (50.0F * f), (int) (f * 50.0F));
            if (!"top-right".equals(paramString)) {
                break label94;
            }
            localLayoutParams.addRule(11);
        }
        for (; ; ) {
            this.k.setOnClickListener(new MMLayout .2 (this));
            addView(this.k, localLayoutParams);
            return;
            label94:
            if ("top-center".equals(paramString)) {
                localLayoutParams.addRule(14);
            } else if ("bottom-left".equals(paramString)) {
                localLayoutParams.addRule(12);
            } else if ("bottom-center".equals(paramString)) {
                localLayoutParams.addRule(12);
                localLayoutParams.addRule(14);
            } else if ("bottom-right".equals(paramString)) {
                localLayoutParams.addRule(12);
                localLayoutParams.addRule(11);
            } else if ("center".equals(paramString)) {
                localLayoutParams.addRule(13);
            }
        }
    }

    protected final void a(Context paramContext) {
        try {
            MMLog.c("MMLayout", "Initializing MMLayout.");
            MMSDK.f(paramContext);
            MMSDK.g(paramContext);
            this.a = new GestureDetector(paramContext.getApplicationContext(), new MMLayout.LayoutGestureListener(this));
            if (!b) {
                MMLog.b("MMLayout", "********** Millennial Device Id *****************");
                MMLog.b("MMLayout", MMSDK.d(paramContext));
                MMLog.b("MMLayout", "Use the above identifier to register this device and receive test ads. Test devices can be registered and administered through your account at http://mmedia.com.");
                MMLog.b("MMLayout", "*************************************************");
                AdCache.b(paramContext);
                b = true;
            }
            return;
        } catch (Exception localException) {
            for (; ; ) {
                MMLog.a("MMLayout", "There was an exception initializing the MMAdView. ", localException);
                localException.printStackTrace();
            }
        }
    }

    void a(String paramString1, String paramString2) {
        if (MMSDK.a(getContext())) {
            if (this.h.k != null) {
                this.h.k.b(paramString1, paramString2);
            }
            return;
        }
        MMLog.e("MMLayout", "No network available, can't load overlay.");
    }

    boolean a(InlineVideoView.InlineParams paramInlineParams) {
        MMSDK.a(new MMLayout .3 (this, paramInlineParams));
        return false;
    }

    public void addBlackView() {
        a();
        if (this.n != null) {
            this.n.setVisibility(0);
        }
    }

    void b() {
    }

    void b(InlineVideoView.InlineParams paramInlineParams) {
        if (this.m != null) {
            ViewGroup localViewGroup = (ViewGroup) this.m.getParent();
            if (localViewGroup != null) {
                localViewGroup.removeView(this.m);
            }
            if (this.m.isPlaying()) {
                this.m.stopPlayback();
            }
            this.m = null;
        }
        this.m = new InlineVideoView(this);
        this.m.b(paramInlineParams);
        paramInlineParams = new RelativeLayout.LayoutParams(-1, -1);
        paramInlineParams.addRule(13, -1);
        this.m.setLayoutParams(paramInlineParams);
        e();
    }

    void b(String paramString) {
        if (MMSDK.a(getContext())) {
            if (this.h.k != null) {
                this.h.k.a(paramString);
            }
            return;
        }
        MMLog.e("MMLayout", "No network available, can't load overlay.");
    }

    void e() {
        if ((this.l != null) && (this.l.getParent() != null)) {
            ((ViewGroup) this.l.getParent()).removeView(this.l);
        }
        this.l = new RelativeLayout(getContext());
        this.l.setId(892934232);
        if (this.m.getParent() != null) {
            ((ViewGroup) this.m.getParent()).removeView(this.m);
        }
        this.l.addView(this.m);
        if (this.n != null) {
            if (this.n.getParent() == null) {
                this.l.addView(this.n);
            }
            this.n.bringToFront();
        }
        addView(this.l, this.m.getCustomLayoutParams());
    }

    protected void finalize() {
        if (getId() == -1) {
            this.h.i = true;
            MMLog.b("MMLayout", "finalize() for " + this.h);
            MMAdImplController.e(this.h);
        }
    }

    void g() {
    }

    public String getApid() {
        return this.h.getApid();
    }

    public boolean getIgnoresDensityScaling() {
        return this.h.getIgnoresDensityScaling();
    }

    public RequestListener getListener() {
        return this.h.getListener();
    }

    public MMRequest getMMRequest() {
        return this.h.getMMRequest();
    }

    void h() {
    }

    void l() {
        if ((this.k != null) && (this.k.getParent() != null) && ((this.k.getParent() instanceof ViewGroup))) {
            ((ViewGroup) this.k.getParent()).removeView(this.k);
            this.k = null;
        }
    }

    void m() {
        if (this.m != null) {
            this.m.f();
            this.m = null;
        }
    }

    void n() {
        if (this.m != null) {
            this.m.g();
        }
    }

    void o() {
        if (this.m != null) {
            this.m.h();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            MMLog.b("MMLayout", "onAttachedToWindow for " + this.h);
            if (getId() == -1) {
                MMLog.d("MMLayout", "MMAd missing id from getId(). Performance will be affected for configuration changes.");
            }
            if (!this.j) {
                MMAdImplController.b(this.h);
            }
            if (this.l != null) {
                this.l.bringToFront();
            }
            if ((this.h != null) && (this.h.k != null) && (this.h.k.b != null)) {
                this.h.k.b.A();
            }
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MMLog.b("MMLayout", "onDetachedFromWindow for" + this.h);
        Context localContext = getContext();
        if ((this.h.f == "i") && (localContext != null) && ((localContext instanceof Activity)) && (((Activity) localContext).isFinishing())) {
            this.h.i = true;
        }
        if (!this.j) {
            MMAdImplController.e(this.h);
        }
    }

    protected void onRestoreInstanceState(Parcelable paramParcelable) {
        paramParcelable = (Bundle) paramParcelable;
        long l1 = this.h.h;
        this.h.h = paramParcelable.getLong("MMAdImplId");
        this.h.n = paramParcelable.getLong("MMAdImplLinkedId");
        MMLog.b("MMLayout", "onRestoreInstanceState replacing adImpl-" + l1 + " with " + this.h + " id=" + getId());
        String str = paramParcelable.getString("inlineVideoViewGson");
        if (str != null) {
            b(InlineVideoView.InlineParams.a(str));
        }
        super.onRestoreInstanceState(paramParcelable.getParcelable("super"));
    }

    protected Parcelable onSaveInstanceState() {
        super.onSaveInstanceState();
        MMLog.b("MMLayout", "onSaveInstanceState saving - " + this.h + " id=" + getId());
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("super", super.onSaveInstanceState());
        localBundle.putLong("MMAdImplId", this.h.h);
        localBundle.putLong("MMAdImplLinkedId", this.h.n);
        if (this.m != null) {
            if (this.m.isPlaying()) {
                this.m.c.h = this.m.getCurrentPosition();
            }
            localBundle.putString("inlineVideoViewGson", this.m.a());
        }
        return localBundle;
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        return (this.a.onTouchEvent(paramMotionEvent)) || (!isClickable()) || (super.onTouchEvent(paramMotionEvent));
    }

    @Deprecated
    public void onWindowFocusChanged(boolean paramBoolean) {
        super.onWindowFocusChanged(paramBoolean);
        if (paramBoolean) {
            if (this.m != null) {
                this.m.j();
            }
            MMLog.b("MMLayout", String.format("Window Focus Changed. For %s, Window in focus?: %b Controllers: %s", new Object[]{this.h, Boolean.valueOf(paramBoolean), MMAdImplController.c()}));
            if ((this.h != null) && (this.h.k != null) && (this.h.k.b != null)) {
                if (!paramBoolean) {
                    break label248;
                }
                this.h.k.b.onResumeWebView();
                this.h.k.b.q();
            }
        }
        for (; ; ) {
            if ((!paramBoolean) && ((getContext() instanceof Activity))) {
                localObject1 = (Activity) getContext();
                if ((localObject1 == null) || ((((Activity) localObject1).isFinishing()) && (this.h != null))) {
                    this.h.i = true;
                    if ((this.h.k != null) && (this.h.k.b != null)) {
                        this.h.k.b.o();
                        MMAdImplController.e(this.h);
                    }
                }
            }
            Object localObject1 = BridgeMMMedia.Audio.a(getContext());
            if (localObject1 != null) {
            }
            try {
                ((BridgeMMMedia.Audio) localObject1).b();
                return;
            } finally {
            }
            if (this.m == null) {
                break;
            }
            this.m.i();
            break;
            label248:
            BridgeMMSpeechkit.a();
            this.h.k.b.p();
            this.h.k.b.onPauseWebView();
        }
    }

    void p() {
        if (this.m != null) {
            this.m.i();
        }
    }

    void q() {
        if (this.m != null) {
            this.m.j();
        }
    }

    boolean r() {
        return (this.m != null) && (this.m.k());
    }

    public void removeBlackView() {
        if (this.n != null) {
            this.n.setVisibility(4);
        }
    }

    public void setApid(String paramString) {
        this.h.setApid(paramString);
    }

    void setCloseArea(String paramString) {
        post(new MMLayout .1 (this, paramString));
    }

    public void setIgnoresDensityScaling(boolean paramBoolean) {
        this.h.setIgnoresDensityScaling(paramBoolean);
    }

    public void setListener(RequestListener paramRequestListener) {
        this.h.setListener(paramRequestListener);
    }

    public void setMMRequest(MMRequest paramMMRequest) {
        this.h.setMMRequest(paramMMRequest);
    }

    void setMediaPlaybackRequiresUserGesture(boolean paramBoolean) {
        try {
            WebView.class.getMethod("setMediaPlaybackRequiresUserGesture", new Class[]{Boolean.TYPE}).invoke(this, new Object[]{Boolean.valueOf(paramBoolean)});
            return;
        } catch (Exception localException) {
        }
    }

    void setVideoSource(String paramString) {
        if (this.m != null) {
            this.m.a(paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */