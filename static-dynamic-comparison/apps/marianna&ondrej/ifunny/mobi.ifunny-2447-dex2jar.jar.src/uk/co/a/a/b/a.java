package uk.co.a.a.b;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;

public class a
        extends d {
    private View a;
    private ViewGroup b;
    private TextView c;
    private SmoothProgressBar d;
    private CharSequence e;
    private CharSequence f;
    private CharSequence g;
    private int h;
    private long i;
    private int j;
    private int k = -2;
    private final Interpolator l = new AccelerateInterpolator();

    protected a() {
        int m = d();
        if (Build.VERSION.SDK_INT < m) {
            throw new IllegalStateException("This HeaderTransformer is designed to run on SDK " + m + "+. If using ActionBarSherlock or ActionBarCompat you should use the appropriate provided extra.");
        }
    }

    protected static TypedArray a(Context paramContext, int paramInt, int[] paramArrayOfInt) {
        TypedValue localTypedValue = new TypedValue();
        paramContext.getTheme().resolveAttribute(paramInt, localTypedValue, true);
        return paramContext.obtainStyledAttributes(localTypedValue.resourceId, paramArrayOfInt);
    }

    private void b(Activity paramActivity, View paramView) {
        TypedArray localTypedArray = a(paramActivity, l.ptrHeaderStyle, r.PullToRefreshHeader);
        int m;
        if (this.b != null) {
            m = localTypedArray.getDimensionPixelSize(r.PullToRefreshHeader_ptrHeaderHeight, b(paramActivity));
            this.b.getLayoutParams().height = m;
            this.b.requestLayout();
        }
        if (localTypedArray.hasValue(r.PullToRefreshHeader_ptrHeaderBackground)) {
        }
        for (paramActivity = localTypedArray.getDrawable(r.PullToRefreshHeader_ptrHeaderBackground); ; paramActivity = a(paramActivity)) {
            if (paramActivity != null) {
                this.c.setBackgroundDrawable(paramActivity);
                if ((this.b != null) && (paramActivity.getOpacity() == -1)) {
                    this.b.setBackgroundResource(0);
                }
            }
            paramActivity = paramView.getContext();
            m = localTypedArray.getResourceId(r.PullToRefreshHeader_ptrHeaderTitleTextAppearance, c(paramActivity));
            if (m != 0) {
                this.c.setTextAppearance(paramActivity, m);
            }
            if (localTypedArray.hasValue(r.PullToRefreshHeader_ptrProgressBarColor)) {
                this.h = localTypedArray.getColor(r.PullToRefreshHeader_ptrProgressBarColor, this.h);
            }
            this.j = localTypedArray.getInt(r.PullToRefreshHeader_ptrProgressBarStyle, 1);
            if (localTypedArray.hasValue(r.PullToRefreshHeader_ptrProgressBarHeight)) {
                this.k = localTypedArray.getDimensionPixelSize(r.PullToRefreshHeader_ptrProgressBarHeight, this.k);
            }
            if (localTypedArray.hasValue(r.PullToRefreshHeader_ptrPullText)) {
                this.e = localTypedArray.getString(r.PullToRefreshHeader_ptrPullText);
            }
            if (localTypedArray.hasValue(r.PullToRefreshHeader_ptrRefreshingText)) {
                this.f = localTypedArray.getString(r.PullToRefreshHeader_ptrRefreshingText);
            }
            if (localTypedArray.hasValue(r.PullToRefreshHeader_ptrReleaseText)) {
                this.g = localTypedArray.getString(r.PullToRefreshHeader_ptrReleaseText);
            }
            localTypedArray.recycle();
            return;
        }
    }

    private void h() {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, this.k);
        switch (this.j) {
        }
        for (; ; ) {
            this.d.setLayoutParams(localLayoutParams);
            return;
            localLayoutParams.addRule(8, o.ptr_content);
            continue;
            localLayoutParams.addRule(3, o.ptr_content);
        }
    }

    private void i() {
        if (this.d != null) {
            this.d.getResources().getDimensionPixelSize(n.ptr_progress_bar_stroke_width);
            this.d.setIndeterminateDrawable(new fr.castorflex.android.smoothprogressbar.m(this.d.getContext()).c(this.h).a(this.k).a());
            Object localObject = new ShapeDrawable();
            ((ShapeDrawable) localObject).setShape(new RectShape());
            ((ShapeDrawable) localObject).getPaint().setColor(this.h);
            localObject = new ClipDrawable((Drawable) localObject, 17, 1);
            this.d.setProgressDrawable((Drawable) localObject);
        }
    }

    protected Drawable a(Context paramContext) {
        paramContext = a(paramContext, 16843470, new int[]{16842964});
        try {
            Drawable localDrawable = paramContext.getDrawable(0);
            return localDrawable;
        } finally {
            paramContext.recycle();
        }
    }

    public void a(Activity paramActivity, View paramView) {
        this.a = paramView;
        this.d = ((SmoothProgressBar) paramView.findViewById(o.ptr_progress));
        this.c = ((TextView) paramView.findViewById(o.ptr_text));
        this.b = ((ViewGroup) paramView.findViewById(o.ptr_content));
        this.e = paramActivity.getString(q.pull_to_refresh_pull_label);
        this.f = paramActivity.getString(q.pull_to_refresh_refreshing_label);
        this.g = paramActivity.getString(q.pull_to_refresh_release_label);
        this.i = paramActivity.getResources().getInteger(17694720);
        this.h = paramActivity.getResources().getColor(m.default_progress_bar_color);
        b(paramActivity, paramView);
        h();
        i();
        e();
    }

    public boolean a() {
        if (this.a.getVisibility() != 0) {
        }
        for (boolean bool = true; ; bool = false) {
            if (bool) {
                this.a.setVisibility(0);
                AnimatorSet localAnimatorSet = new AnimatorSet();
                localAnimatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.b, "translationY", new float[]{-this.b.getHeight(), 0.0F}), ObjectAnimator.ofFloat(this.a, "alpha", new float[]{0.0F, 1.0F})});
                localAnimatorSet.setDuration(this.i);
                localAnimatorSet.start();
            }
            return bool;
        }
    }

    protected int b(Context paramContext) {
        paramContext = paramContext.getTheme().obtainStyledAttributes(new int[]{16843499});
        try {
            int m = paramContext.getDimensionPixelSize(0, 0);
            return m;
        } finally {
            paramContext.recycle();
        }
    }

    public boolean b() {
        boolean bool;
        Object localObject;
        if (this.a.getVisibility() != 8) {
            bool = true;
            if (bool) {
                if (this.b.getAlpha() < 0.5F) {
                    break label145;
                }
                localObject = new AnimatorSet();
                ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.b, "translationY", new float[]{0.0F, -this.b.getHeight()});
                ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{1.0F, 0.0F});
                ((AnimatorSet) localObject).playTogether(new Animator[]{localObjectAnimator1, localObjectAnimator2});
            }
        }
        for (; ; ) {
            ((Animator) localObject).setDuration(this.i);
            ((Animator) localObject).addListener(new b(this));
            ((Animator) localObject).start();
            return bool;
            bool = false;
            break;
            label145:
            localObject = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{1.0F, 0.0F});
        }
    }

    protected int c(Context paramContext) {
        paramContext = a(paramContext, 16843470, new int[]{16843512});
        try {
            int m = paramContext.getResourceId(0, 0);
            return m;
        } finally {
            paramContext.recycle();
        }
    }

    public void c() {
        if (this.b != null) {
            ObjectAnimator.ofFloat(this.b, "alpha", new float[]{1.0F, 0.0F}).start();
        }
    }

    protected int d() {
        return 14;
    }

    public void e() {
        if (this.d != null) {
            this.d.setVisibility(0);
            this.d.setProgress(0);
            this.d.setIndeterminate(false);
        }
        if (this.c != null) {
            this.c.setVisibility(0);
            this.c.setText(this.e);
        }
        if (this.b != null) {
            this.b.setVisibility(0);
            uk.co.a.a.b.b.a.a(this.b, 1.0F);
        }
    }

    public void f() {
        if (this.c != null) {
            this.c.setText(this.f);
        }
        if (this.d != null) {
            this.d.setVisibility(0);
            this.d.setIndeterminate(true);
        }
    }

    public View g() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/uk/co/a/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */