package com.google.android.youtube.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import com.google.android.youtube.player.internal.ab;
import com.google.android.youtube.player.internal.ac;
import com.google.android.youtube.player.internal.b;
import com.google.android.youtube.player.internal.n;
import com.google.android.youtube.player.internal.s;
import com.google.android.youtube.player.internal.t.a;
import com.google.android.youtube.player.internal.t.b;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class YouTubePlayerView
        extends ViewGroup
        implements YouTubePlayer.Provider {
    private final a a;
    private final Set<View> b;
    private final b c;
    private b d;
    private s e;
    private View f;
    private n g;
    private YouTubePlayer.Provider h;
    private Bundle i;
    private YouTubePlayer.OnInitializedListener j;
    private boolean k;

    public YouTubePlayerView(Context paramContext) {
        this(paramContext, null);
    }

    public YouTubePlayerView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public YouTubePlayerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        this(paramContext, paramAttributeSet, paramInt, ((YouTubeBaseActivity) paramContext).a());
    }

    YouTubePlayerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, b paramb) {
        super((Context) ac.a(paramContext, "context cannot be null"), paramAttributeSet, paramInt);
        this.c = ((b) ac.a(paramb, "listener cannot be null"));
        if (getBackground() == null) {
            setBackgroundColor(-16777216);
        }
        setClipToPadding(false);
        this.g = new n(paramContext);
        requestTransparentRegion(this.g);
        addView(this.g);
        this.b = new HashSet();
        this.a = new a((byte) 0);
    }

    private void a(View paramView) {
        if ((paramView == this.g) || ((this.e != null) && (paramView == this.f))) {
        }
        for (int m = 1; m == 0; m = 0) {
            throw new UnsupportedOperationException("No views can be added on top of the player");
        }
    }

    private void a(YouTubeInitializationResult paramYouTubeInitializationResult) {
        this.e = null;
        this.g.c();
        if (this.j != null) {
            this.j.onInitializationFailure(this.h, paramYouTubeInitializationResult);
            this.j = null;
        }
    }

    final void a() {
        if (this.e != null) {
            this.e.b();
        }
    }

    final void a(final Activity paramActivity, YouTubePlayer.Provider paramProvider, String paramString, YouTubePlayer.OnInitializedListener paramOnInitializedListener, Bundle paramBundle) {
        if ((this.e != null) || (this.j != null)) {
            return;
        }
        ac.a(paramActivity, "activity cannot be null");
        this.h = ((YouTubePlayer.Provider) ac.a(paramProvider, "provider cannot be null"));
        this.j = ((YouTubePlayer.OnInitializedListener) ac.a(paramOnInitializedListener, "listener cannot be null"));
        this.i = paramBundle;
        this.g.b();
        this.d = ab.a().a(getContext(), paramString, new t.a() new t.b
        {
            public final void a ()
            {
                if (YouTubePlayerView.a(YouTubePlayerView.this) != null) {
                    YouTubePlayerView.a(YouTubePlayerView.this, paramActivity);
                }
                YouTubePlayerView.b(YouTubePlayerView.this);
            }

        public final void b ()
        {
            if ((!YouTubePlayerView.c(YouTubePlayerView.this)) && (YouTubePlayerView.d(YouTubePlayerView.this) != null)) {
                YouTubePlayerView.d(YouTubePlayerView.this).f();
            }
            YouTubePlayerView.e(YouTubePlayerView.this).a();
            if (YouTubePlayerView.this.indexOfChild(YouTubePlayerView.e(YouTubePlayerView.this)) < 0) {
                YouTubePlayerView.this.addView(YouTubePlayerView.e(YouTubePlayerView.this));
                YouTubePlayerView.this.removeView(YouTubePlayerView.f(YouTubePlayerView.this));
            }
            YouTubePlayerView.g(YouTubePlayerView.this);
            YouTubePlayerView.h(YouTubePlayerView.this);
            YouTubePlayerView.b(YouTubePlayerView.this);
        }
        },new t.b() {
            public final void a(YouTubeInitializationResult paramAnonymousYouTubeInitializationResult) {
                YouTubePlayerView.a(YouTubePlayerView.this, paramAnonymousYouTubeInitializationResult);
                YouTubePlayerView.b(YouTubePlayerView.this);
            }
        });
        this.d.e();
    }

    final void a(boolean paramBoolean) {
        if (this.e != null) {
            this.e.b(paramBoolean);
            b(paramBoolean);
        }
    }

    public final void addFocusables(ArrayList<View> paramArrayList, int paramInt) {
        ArrayList localArrayList = new ArrayList();
        super.addFocusables(localArrayList, paramInt);
        paramArrayList.addAll(localArrayList);
        this.b.clear();
        this.b.addAll(localArrayList);
    }

    public final void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2) {
        ArrayList localArrayList = new ArrayList();
        super.addFocusables(localArrayList, paramInt1, paramInt2);
        paramArrayList.addAll(localArrayList);
        this.b.clear();
        this.b.addAll(localArrayList);
    }

    public final void addView(View paramView) {
        a(paramView);
        super.addView(paramView);
    }

    public final void addView(View paramView, int paramInt) {
        a(paramView);
        super.addView(paramView, paramInt);
    }

    public final void addView(View paramView, int paramInt1, int paramInt2) {
        a(paramView);
        super.addView(paramView, paramInt1, paramInt2);
    }

    public final void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
        a(paramView);
        super.addView(paramView, paramInt, paramLayoutParams);
    }

    public final void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
        a(paramView);
        super.addView(paramView, paramLayoutParams);
    }

    final void b() {
        if (this.e != null) {
            this.e.c();
        }
    }

    final void b(boolean paramBoolean) {
        this.k = true;
        if (this.e != null) {
            this.e.a(paramBoolean);
        }
    }

    final void c() {
        if (this.e != null) {
            this.e.d();
        }
    }

    public final void clearChildFocus(View paramView) {
        if (hasFocusable()) {
            requestFocus();
            return;
        }
        super.clearChildFocus(paramView);
    }

    final void d() {
        if (this.e != null) {
            this.e.e();
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
        boolean bool = false;
        if (this.e != null) {
            if (paramKeyEvent.getAction() == 0) {
                if ((this.e.a(paramKeyEvent.getKeyCode(), paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent))) {
                    bool = true;
                }
            }
            do {
                return bool;
                if (paramKeyEvent.getAction() != 1) {
                    break;
                }
            }
            while ((!this.e.b(paramKeyEvent.getKeyCode(), paramKeyEvent)) && (!super.dispatchKeyEvent(paramKeyEvent)));
            return true;
        }
        return super.dispatchKeyEvent(paramKeyEvent);
    }

    final Bundle e() {
        if (this.e == null) {
            return this.i;
        }
        return this.e.h();
    }

    public final void focusableViewAvailable(View paramView) {
        super.focusableViewAvailable(paramView);
        this.b.add(paramView);
    }

    public final void initialize(String paramString, YouTubePlayer.OnInitializedListener paramOnInitializedListener) {
        ac.a(paramString, "Developer key cannot be null or empty");
        this.c.a(this, paramString, paramOnInitializedListener);
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalFocusChangeListener(this.a);
    }

    public final void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        if (this.e != null) {
            this.e.a(paramConfiguration);
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalFocusChangeListener(this.a);
    }

    protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (getChildCount() > 0) {
            getChildAt(0).layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
        }
    }

    protected final void onMeasure(int paramInt1, int paramInt2) {
        if (getChildCount() > 0) {
            View localView = getChildAt(0);
            localView.measure(paramInt1, paramInt2);
            setMeasuredDimension(localView.getMeasuredWidth(), localView.getMeasuredHeight());
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public final boolean onTouchEvent(MotionEvent paramMotionEvent) {
        super.onTouchEvent(paramMotionEvent);
        return true;
    }

    public final void requestChildFocus(View paramView1, View paramView2) {
        super.requestChildFocus(paramView1, paramView2);
        this.b.add(paramView2);
    }

    public final void setClipToPadding(boolean paramBoolean) {
    }

    public final void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    }

    private final class a
            implements ViewTreeObserver.OnGlobalFocusChangeListener {
        private a() {
        }

        public final void onGlobalFocusChanged(View paramView1, View paramView2) {
            if ((YouTubePlayerView.d(YouTubePlayerView.this) != null) && (YouTubePlayerView.i(YouTubePlayerView.this).contains(paramView2)) && (!YouTubePlayerView.i(YouTubePlayerView.this).contains(paramView1))) {
                YouTubePlayerView.d(YouTubePlayerView.this).g();
            }
        }
    }

    static abstract interface b {
        public abstract void a(YouTubePlayerView paramYouTubePlayerView);

        public abstract void a(YouTubePlayerView paramYouTubePlayerView, String paramString, YouTubePlayer.OnInitializedListener paramOnInitializedListener);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/YouTubePlayerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */