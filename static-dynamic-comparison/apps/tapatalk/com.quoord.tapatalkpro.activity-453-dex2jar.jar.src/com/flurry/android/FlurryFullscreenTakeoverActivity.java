package com.flurry.android;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.am;
import com.flurry.sdk.cb;
import com.flurry.sdk.cf;
import com.flurry.sdk.ch;
import com.flurry.sdk.e;
import com.flurry.sdk.eo;
import com.flurry.sdk.f;
import com.flurry.sdk.g;
import com.flurry.sdk.n;
import com.flurry.sdk.n.c;
import com.flurry.sdk.n.d;
import com.flurry.sdk.n.d.a;
import com.flurry.sdk.n.e;
import com.flurry.sdk.n.f;
import com.flurry.sdk.r;
import com.flurry.sdk.z;

import java.util.Collections;
import java.util.List;

public final class FlurryFullscreenTakeoverActivity
        extends Activity {
    public static final String EXTRA_KEY_ADSPACENAME = "adSpaceName";
    public static final String EXTRA_KEY_FRAMEINDEX = "frameIndex";
    public static final String EXTRA_KEY_IS_MRAID_AD = "is_mraid_ad";
    public static final String EXTRA_KEY_SHOULD_CLOSE_AD = "should_close_ad";
    public static final String EXTRA_KEY_TARGETINTENT = "targetIntent";
    public static final String EXTRA_KEY_URL = "url";
    private static final String a = FlurryFullscreenTakeoverActivity.class.getSimpleName();
    public static boolean fBasicWebViewClosingHandlerFired;
    private String b;
    private g c;
    private AdUnit d;
    private ViewGroup e;
    private n f;
    private f g;
    private boolean h;
    private boolean i;
    private Intent j;
    private String k;
    private long l;
    private boolean m = false;
    private boolean n;
    private z o = null;
    private n.e p = n.e.a;

    private void a() {
        long l1;
        boolean bool;
        if (this.d != null) {
            l1 = this.d.m().longValue();
            bool = this.d.q().booleanValue();
        }
        for (; ; ) {
            if (this.m) {
                this.o = new z(this, 0L, true, false, false);
                return;
            }
            this.o = new z(this, l1, bool, true, false);
            return;
            bool = false;
            l1 = 0L;
        }
    }

    private void a(int paramInt) {
        FlurryAdModule localFlurryAdModule = FlurryAdModule.getInstance();
        AdUnit localAdUnit2 = localFlurryAdModule.Q();
        e locale2 = localFlurryAdModule.P();
        e locale1 = locale2;
        AdUnit localAdUnit1 = localAdUnit2;
        if (localAdUnit2 == null) {
            locale1 = locale2;
            localAdUnit1 = localAdUnit2;
            if (this.m) {
                localAdUnit1 = localFlurryAdModule.S();
                locale1 = localFlurryAdModule.R();
            }
        }
        this.d = localAdUnit1;
        this.c = new g(this, localFlurryAdModule, locale1, localAdUnit1, paramInt);
    }

    private void a(String paramString, int paramInt) {
        if ((TextUtils.isEmpty(paramString)) || (this.g == null) || (this.e == null)) {
        }
        do {
            return;
            if (this.o == null) {
                a();
            }
            Object localObject = FlurryAdModule.getInstance();
            a(paramInt);
            paramInt = 0;
            if (this.d != null) {
                this.o.setAdUnityView(this.c);
                localObject = ((FlurryAdModule) localObject).c(((AdFrame) this.d.d().get(this.c.getAdFrameIndex())).g().toString());
                this.o.setVideoState((am) localObject);
                paramInt = ((am) localObject).a();
            }
            setVideoOrientation();
            this.g.setMediaController(this.o);
            this.g.a();
            this.g.a(Uri.parse(paramString), paramInt);
            this.e.addView(this.g, new FrameLayout.LayoutParams(-1, -1, 17));
        } while (this.f == null);
        this.f.setVisibility(8);
    }

    private void a(boolean paramBoolean) {
        a();
        if (paramBoolean) {
            this.g = new f(this, this.c, this, this.o);
            return;
        }
        this.g = new f(this, null, this, this.o);
    }

    private boolean a(String paramString) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (!TextUtils.isEmpty(paramString)) {
            paramString = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(paramString));
            bool1 = bool2;
            if (paramString != null) {
                bool1 = bool2;
                if (paramString.startsWith("video/")) {
                    bool1 = true;
                }
            }
        }
        return bool1;
    }

    private boolean a(String paramString1, String paramString2) {
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
        }
        do {
            return false;
            paramString2 = Uri.parse(paramString2).getQueryParameter("link");
        } while ((TextUtils.isEmpty(paramString2)) || (!paramString2.equalsIgnoreCase(paramString1)));
        return true;
    }

    private boolean b() {
        return (!cb.a(this)) && (this.c != null) && (this.c.getVideoView() != null) && ((this.c.getCurrentBinding() == 3) || (this.c.getCurrentBinding() == 2));
    }

    public void finish() {
        try {
            if (this.n) {
                return;
            }
            this.n = true;
            super.finish();
            return;
        } finally {
        }
    }

    public AdUnit getAdUnit() {
        return this.d;
    }

    public g getAdUnityView() {
        return this.c;
    }

    public n.e getResult() {
        return this.p;
    }

    public boolean isMraidVideoActivity() {
        return this.m;
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        setVideoOrientation();
    }

    public void onCreate(Bundle paramBundle) {
        int i1 = -1;
        eo.a(3, a, "onCreate");
        setTheme(16973831);
        super.onCreate(paramBundle);
        ch.a(getWindow());
        setVolumeControlStream(3);
        this.b = FlurryAdModule.getInstance().j();
        Intent localIntent = getIntent();
        this.j = ((Intent) localIntent.getParcelableExtra("targetIntent"));
        this.k = localIntent.getStringExtra("adSpaceName");
        getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        float f1 = getResources().getDisplayMetrics().density;
        fBasicWebViewClosingHandlerFired = false;
        int i2;
        if (paramBundle == null) {
            i2 = i1;
            if (i1 < 0) {
                i2 = localIntent.getIntExtra("frameIndex", 0);
            }
            this.m = localIntent.getBooleanExtra("is_mraid_ad", false);
            if (this.j == null) {
                break label211;
            }
        }
        for (; ; ) {
            try {
                startActivity(this.j);
                this.l = SystemClock.elapsedRealtime();
                FlurryAdModule.getInstance().a(this, paramBundle);
                return;
                i1 = paramBundle.getInt("frameIndex", -1);
            } catch (ActivityNotFoundException localActivityNotFoundException) {
                eo.a(a, "Cannot launch Activity", localActivityNotFoundException);
                this.j = null;
                finish();
                continue;
            }
            label211:
            String str = localActivityNotFoundException.getStringExtra("url");
            Object localObject;
            if (str == null) {
                this.e = new RelativeLayout(this);
                localObject = FlurryAdModule.getInstance();
                this.d = ((FlurryAdModule) localObject).Q();
                if (this.d != null) {
                    this.c = new g(this, (FlurryAdModule) localObject, ((FlurryAdModule) localObject).P(), this.d, i2);
                    this.c.setFullScreenTakeover(this);
                    this.c.initLayout();
                    localObject = new RelativeLayout.LayoutParams(-2, -2);
                    ((RelativeLayout.LayoutParams) localObject).addRule(13);
                    this.e.addView(this.c, (ViewGroup.LayoutParams) localObject);
                    setContentView(this.e);
                } else {
                    eo.a(3, a, "appSpotModule.getTakeoverAdUnit() IS null ");
                }
            } else {
                this.e = new FrameLayout(this);
                setContentView(this.e);
                if (a(str)) {
                    a(i2);
                    if (this.d != null) {
                        a(true);
                        a(str, i2);
                    }
                } else {
                    this.f = new n(this, str, ((Intent) localObject).getBooleanExtra("should_close_ad", false));
                    this.f.setBasicWebViewUrlLoadingHandler(new c(i2));
                    this.f.setBasicWebViewClosingHandler(new a(null));
                    this.f.setBasicWebViewFullScreenTransitionHandler(new b(null));
                    this.e.addView(this.f);
                    this.f.a(this);
                }
            }
        }
    }

    protected void onDestroy() {
        eo.a(3, a, "onDestroy");
        terminateVideoPlayback();
        if (this.f != null) {
            this.f.d();
        }
        if (this.c != null) {
            this.c.onDestroy();
        }
        FlurryAdModule.getInstance().b(this);
        super.onDestroy();
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 4) {
            if (this.c != null) {
                this.c.a("adWillClose", Collections.emptyMap(), this.c.getAdUnit(), this.c.getAdLog(), this.c.getAdFrameIndex(), 0);
                return true;
            }
            if (this.g != null) {
                if (this.f != null) {
                    if (this.h) {
                        if (this.f.a()) {
                            this.f.c();
                            terminateVideoPlayback();
                            return true;
                        }
                    } else {
                        terminateVideoPlayback();
                        return true;
                    }
                }
            } else if (this.f != null) {
                if (this.f.a()) {
                    this.f.c();
                }
                for (; ; ) {
                    return true;
                    if (this.f.b()) {
                        this.p = n.e.c;
                        finish();
                    } else {
                        this.p = n.e.b;
                        finish();
                    }
                }
            }
        }
        return super.onKeyUp(paramInt, paramKeyEvent);
    }

    protected void onPause() {
        eo.a(3, a, "onPause");
        this.i = false;
        if ((this.g != null) && (this.g.isPlaying())) {
            this.g.pause();
            eo.a(3, a, "in onPause in FFTA, should call suspend in AdUnityVideoView");
            this.g.d();
        }
        if (this.c != null) {
            this.c.c();
        }
        super.onPause();
    }

    protected void onRestart() {
        eo.a(3, a, "onRestart");
        super.onRestart();
    }

    protected void onResume() {
        eo.a(3, a, "onResume");
        super.onResume();
        this.i = true;
        if (this.c != null) {
            this.c.b();
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        if (this.c != null) {
            paramBundle.putInt("frameIndex", this.c.getAdFrameIndex());
        }
    }

    public void onStart() {
        eo.a(3, a, "onStart");
        super.onStart();
        if (this.b != null) {
            FlurryAgent.onStartSession(this, this.b);
            return;
        }
        finish();
    }

    public void onStop() {
        eo.a(3, a, "onStop");
        if (this.b != null) {
            FlurryAgent.onEndSession(this);
        }
        super.onStop();
    }

    public void onWindowFocusChanged(boolean paramBoolean) {
        eo.a(3, a, "onWindowFocusChanged hasFocus = " + paramBoolean);
        if ((this.i) && (paramBoolean) && (this.j != null) && (SystemClock.elapsedRealtime() - this.l > 250L)) {
            eo.a(3, a, "terminate this launcher activity because launched activity was terminated or wasn't launched");
            finish();
        }
        super.onWindowFocusChanged(paramBoolean);
    }

    public void setVideoMoreInfoInProgress(am paramam) {
        if ((this.c != null) && (paramam != null)) {
            this.c.setVideoState(paramam);
        }
    }

    public void setVideoOrientation() {
        if (cb.a(this)) {
            eo.b(a, "setVideoOrientation SCREEN_ORIENTATION_SENSOR");
            setRequestedOrientation(4);
        }
        while (!b()) {
            return;
        }
        eo.b(a, "setVideoOrientation SCREEN_ORIENTATION_SENSOR_LANDSCAPE");
        setRequestedOrientation(6);
    }

    public void terminateVideoPlayback() {
        if (this.f != null) {
            this.f.setVisibility(0);
        }
        if (this.g != null) {
            this.g.c();
            if (this.e != null) {
                this.e.removeView(this.g);
            }
            this.g = null;
        }
        this.h = false;
    }

    public void terminateVideoPlaybackDueToError() {
        eo.a(3, a, "onError");
        eo.b(a, "Error occurs during video playback");
        if (this.f != null) {
            if (this.h) {
                if (this.f.a()) {
                    this.f.c();
                    terminateVideoPlayback();
                    return;
                }
                finish();
                return;
            }
            terminateVideoPlayback();
            return;
        }
        finish();
    }

    final class a
            implements n.c {
        private a() {
        }

        public void a(n paramn, n.e parame) {
            FlurryFullscreenTakeoverActivity.a(FlurryFullscreenTakeoverActivity.this, parame);
            if (FlurryFullscreenTakeoverActivity.b(FlurryFullscreenTakeoverActivity.this) == n.e.c) {
                FlurryFullscreenTakeoverActivity.fBasicWebViewClosingHandlerFired = true;
            }
            FlurryFullscreenTakeoverActivity.this.finish();
        }
    }

    final class b
            implements n.d {
        private View b;
        private int c;
        private n.d.a d;
        private FrameLayout e;

        private b() {
        }

        public void a(n paramn) {
            if (this.b == null) {
                return;
            }
            ((ViewGroup) FlurryFullscreenTakeoverActivity.this.getWindow().getDecorView()).removeView(this.e);
            this.e.removeView(this.b);
            if (this.d != null) {
                this.d.a();
            }
            FlurryFullscreenTakeoverActivity.this.setRequestedOrientation(this.c);
            this.d = null;
            this.e = null;
            this.b = null;
        }

        public void a(n paramn, View paramView, int paramInt, n.d.a parama) {
            if (this.b != null) {
                a(paramn);
            }
            this.b = paramView;
            this.c = FlurryFullscreenTakeoverActivity.this.getRequestedOrientation();
            this.d = parama;
            this.e = new FrameLayout(FlurryFullscreenTakeoverActivity.this);
            this.e.setBackgroundColor(-16777216);
            this.e.addView(this.b, new FrameLayout.LayoutParams(-1, -1, 17));
            ((ViewGroup) FlurryFullscreenTakeoverActivity.this.getWindow().getDecorView()).addView(this.e, -1, -1);
            FlurryFullscreenTakeoverActivity.this.setRequestedOrientation(paramInt);
        }

        public void a(n paramn, View paramView, n.d.a parama) {
            a(paramn, paramView, FlurryFullscreenTakeoverActivity.this.getRequestedOrientation(), parama);
        }
    }

    final class c
            implements n.f {
        private int b = 0;

        public c(int paramInt) {
            this.b = paramInt;
        }

        public boolean a(final n paramn, String paramString, boolean paramBoolean) {
            boolean bool1 = true;
            if (FlurryFullscreenTakeoverActivity.a(FlurryFullscreenTakeoverActivity.this, paramString)) {
                FlurryFullscreenTakeoverActivity.a(FlurryFullscreenTakeoverActivity.this, paramBoolean);
                FlurryFullscreenTakeoverActivity.b(FlurryFullscreenTakeoverActivity.this, false);
                FlurryFullscreenTakeoverActivity.a(FlurryFullscreenTakeoverActivity.this, paramString, this.b);
            }
            boolean bool2;
            boolean bool3;
            do {
                do {
                    do {
                        do {
                            do {
                                return bool1;
                                if (!cf.d(paramString)) {
                                    break;
                                }
                                bool2 = paramBoolean;
                                if (!paramBoolean) {
                                    bool2 = FlurryFullscreenTakeoverActivity.a(FlurryFullscreenTakeoverActivity.this, paramString, paramn.getUrl());
                                }
                                FlurryAdModule.getInstance().a().a(FlurryFullscreenTakeoverActivity.this, paramString, FlurryFullscreenTakeoverActivity.a(FlurryFullscreenTakeoverActivity.this));
                            } while (!bool2);
                            paramn.post(new Runnable() {
                                public void run() {
                                    if (paramn.a()) {
                                        paramn.c();
                                        return;
                                    }
                                    FlurryFullscreenTakeoverActivity.this.finish();
                                }
                            });
                            return true;
                            if (!cf.e(paramString)) {
                                break;
                            }
                            bool3 = FlurryAdModule.getInstance().a().b(FlurryFullscreenTakeoverActivity.this, paramString, FlurryFullscreenTakeoverActivity.a(FlurryFullscreenTakeoverActivity.this));
                            bool1 = bool3;
                        } while (!bool3);
                        bool2 = paramBoolean;
                        if (!paramBoolean) {
                            bool2 = FlurryFullscreenTakeoverActivity.a(FlurryFullscreenTakeoverActivity.this, paramString, paramn.getUrl());
                        }
                        bool1 = bool3;
                    } while (!bool2);
                    paramn.post(new Runnable() {
                        public void run() {
                            if (paramn.a()) {
                                paramn.c();
                                return;
                            }
                            FlurryFullscreenTakeoverActivity.this.finish();
                        }
                    });
                    return bool3;
                    bool3 = FlurryAdModule.getInstance().a().c(FlurryFullscreenTakeoverActivity.this, paramString, FlurryFullscreenTakeoverActivity.a(FlurryFullscreenTakeoverActivity.this));
                    bool1 = bool3;
                } while (!bool3);
                bool2 = paramBoolean;
                if (!paramBoolean) {
                    bool2 = FlurryFullscreenTakeoverActivity.a(FlurryFullscreenTakeoverActivity.this, paramString, paramn.getUrl());
                }
                bool1 = bool3;
            } while (!bool2);
            paramn.post(new Runnable() {
                public void run() {
                    if (paramn.a()) {
                        paramn.c();
                        return;
                    }
                    FlurryFullscreenTakeoverActivity.this.finish();
                }
            });
            return bool3;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/FlurryFullscreenTakeoverActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */