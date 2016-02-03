package com.everimaging.fotorsdk.widget.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.everimaging.fotorsdk.R.id;
import com.everimaging.fotorsdk.R.layout;
import com.everimaging.fotorsdk.R.string;
import com.everimaging.fotorsdk.widget.FotorTextView;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshBase.Mode;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.a;

@SuppressLint({"ViewConstructor"})
public abstract class d
        extends FrameLayout
        implements a {
    static final Interpolator a = new LinearInterpolator();
    protected final ImageView b;
    protected final ProgressBar c;
    protected final PullToRefreshBase.Mode d;
    protected final PullToRefreshBase.Orientation e;
    private FrameLayout f;
    private boolean g;
    private final FotorTextView h;
    private final FotorTextView i;
    private CharSequence j;
    private CharSequence k;
    private CharSequence l;

    public d(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray) {
        super(paramContext);
        this.d = paramMode;
        this.e = paramOrientation;
        FrameLayout.LayoutParams localLayoutParams;
        int m;
        switch (1. a[paramOrientation.ordinal()])
        {
            default:
                LayoutInflater.from(paramContext).inflate(R.layout.fotor_ptr_pull_to_refresh_header_vertical, this);
                this.f = ((FrameLayout) findViewById(R.id.fl_inner));
                this.h = ((FotorTextView) this.f.findViewById(R.id.pull_to_refresh_text));
                this.c = ((ProgressBar) this.f.findViewById(R.id.pull_to_refresh_progress));
                this.i = ((FotorTextView) this.f.findViewById(R.id.pull_to_refresh_sub_text));
                this.b = ((ImageView) this.f.findViewById(R.id.pull_to_refresh_image));
                localLayoutParams = (FrameLayout.LayoutParams) this.f.getLayoutParams();
                switch (1. b[paramMode.ordinal()])
            {
                default:
                    if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL) {
                        m = 80;
                        label183:
                        localLayoutParams.gravity = m;
                        this.j = paramContext.getString(R.string.fotor_ptr_pull_to_refresh_pull_label);
                        this.k = paramContext.getString(R.string.fotor_ptr_pull_to_refresh_refreshing_label);
                        this.l = paramContext.getString(R.string.fotor_ptr_pull_to_refresh_release_label);
                        if (paramTypedArray.hasValue(1)) {
                            paramOrientation = paramTypedArray.getDrawable(1);
                            if (paramOrientation != null) {
                                g.a(this, paramOrientation);
                            }
                        }
                        if (paramTypedArray.hasValue(10)) {
                            paramOrientation = new TypedValue();
                            paramTypedArray.getValue(10, paramOrientation);
                            setTextAppearance(paramOrientation.data);
                        }
                        if (paramTypedArray.hasValue(11)) {
                            paramOrientation = new TypedValue();
                            paramTypedArray.getValue(11, paramOrientation);
                            setSubTextAppearance(paramOrientation.data);
                        }
                        if (paramTypedArray.hasValue(2)) {
                            paramOrientation = paramTypedArray.getColorStateList(2);
                            if (paramOrientation != null) {
                                setTextColor(paramOrientation);
                            }
                        }
                        if (paramTypedArray.hasValue(3)) {
                            paramOrientation = paramTypedArray.getColorStateList(3);
                            if (paramOrientation != null) {
                                setSubTextColor(paramOrientation);
                            }
                        }
                        paramOrientation = null;
                        if (paramTypedArray.hasValue(6)) {
                            paramOrientation = paramTypedArray.getDrawable(6);
                        }
                        switch (1. b[paramMode.ordinal()])
                        {
                            default:
                                if (paramTypedArray.hasValue(7)) {
                                    paramMode = paramTypedArray.getDrawable(7);
                                }
                                break;
                        }
                    }
                    break;
            }
            break;
        }
        for (; ; ) {
            paramOrientation = paramMode;
            if (paramMode == null) {
                paramOrientation = paramContext.getResources().getDrawable(getDefaultDrawableResId());
            }
            setLoadingDrawable(paramOrientation);
            i();
            return;
            LayoutInflater.from(paramContext).inflate(R.layout.fotor_ptr_pull_to_refresh_header_horizontal, this);
            break;
            if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL) {
            }
            for (m = 48; ; m = 3) {
                localLayoutParams.gravity = m;
                this.j = paramContext.getString(R.string.fotor_ptr_pull_to_refresh_from_bottom_pull_label);
                this.k = paramContext.getString(R.string.fotor_ptr_pull_to_refresh_from_bottom_refreshing_label);
                this.l = paramContext.getString(R.string.fotor_ptr_pull_to_refresh_from_bottom_release_label);
                break;
            }
            m = 5;
            break label183;
            paramMode = paramOrientation;
            if (paramTypedArray.hasValue(17)) {
                f.a("ptrDrawableTop", "ptrDrawableStart");
                paramMode = paramTypedArray.getDrawable(17);
                continue;
                if (paramTypedArray.hasValue(8)) {
                    paramMode = paramTypedArray.getDrawable(8);
                } else {
                    paramMode = paramOrientation;
                    if (paramTypedArray.hasValue(18)) {
                        f.a("ptrDrawableBottom", "ptrDrawableEnd");
                        paramMode = paramTypedArray.getDrawable(18);
                    }
                }
            }
        }
    }

    private void setSubHeaderText(CharSequence paramCharSequence) {
        if (this.i != null) {
            if (TextUtils.isEmpty(paramCharSequence)) {
                this.i.setVisibility(8);
            }
        } else {
            return;
        }
        this.i.setText(paramCharSequence);
        this.i.setVisibility(0);
    }

    private void setSubTextAppearance(int paramInt) {
        if (this.i != null) {
            this.i.setTextAppearance(getContext(), paramInt);
        }
    }

    private void setSubTextColor(ColorStateList paramColorStateList) {
        if (this.i != null) {
            this.i.setTextColor(paramColorStateList);
        }
    }

    private void setTextAppearance(int paramInt) {
        if (this.h != null) {
            this.h.setTextAppearance(getContext(), paramInt);
        }
        if (this.i != null) {
            this.i.setTextAppearance(getContext(), paramInt);
        }
    }

    private void setTextColor(ColorStateList paramColorStateList) {
        if (this.h != null) {
            this.h.setTextColor(paramColorStateList);
        }
        if (this.i != null) {
            this.i.setTextColor(paramColorStateList);
        }
    }

    protected abstract void a();

    protected abstract void a(float paramFloat);

    protected abstract void a(Drawable paramDrawable);

    protected abstract void b();

    public final void b(float paramFloat) {
        if (!this.g) {
            a(paramFloat);
        }
    }

    protected abstract void c();

    protected abstract void d();

    public final void e() {
        if (this.h.getVisibility() == 0) {
            this.h.setVisibility(4);
        }
        if (this.c.getVisibility() == 0) {
            this.c.setVisibility(4);
        }
        if (this.b.getVisibility() == 0) {
            this.b.setVisibility(4);
        }
        if (this.i.getVisibility() == 0) {
            this.i.setVisibility(4);
        }
    }

    public final void f() {
        if (this.h != null) {
            this.h.setText(this.j);
        }
        a();
    }

    public final void g() {
        if (this.h != null) {
            this.h.setText(this.k);
        }
        if (this.g) {
            ((AnimationDrawable) this.b.getDrawable()).start();
        }
        for (; ; ) {
            if (this.i != null) {
                this.i.setVisibility(8);
            }
            return;
            b();
        }
    }

    public final int getContentSize() {
        switch (1. a[this.e.ordinal()])
        {
            default:
                return this.f.getHeight();
        }
        return this.f.getWidth();
    }

    protected abstract int getDefaultDrawableResId();

    public final void h() {
        if (this.h != null) {
            this.h.setText(this.l);
        }
        c();
    }

    public final void i() {
        if (this.h != null) {
            this.h.setText(this.j);
        }
        this.b.setVisibility(0);
        if (this.g) {
            ((AnimationDrawable) this.b.getDrawable()).stop();
        }
        for (; ; ) {
            if (this.i != null) {
                if (!TextUtils.isEmpty(this.i.getText())) {
                    break;
                }
                this.i.setVisibility(8);
            }
            return;
            d();
        }
        this.i.setVisibility(0);
    }

    public final void j() {
        if (4 == this.h.getVisibility()) {
            this.h.setVisibility(0);
        }
        if (4 == this.c.getVisibility()) {
            this.c.setVisibility(0);
        }
        if (4 == this.b.getVisibility()) {
            this.b.setVisibility(0);
        }
        if (4 == this.i.getVisibility()) {
            this.i.setVisibility(0);
        }
    }

    public final void setHeight(int paramInt) {
        getLayoutParams().height = paramInt;
        requestLayout();
    }

    public void setLastUpdatedLabel(CharSequence paramCharSequence) {
        setSubHeaderText(paramCharSequence);
    }

    public final void setLoadingDrawable(Drawable paramDrawable) {
        this.b.setImageDrawable(paramDrawable);
        this.g = (paramDrawable instanceof AnimationDrawable);
        a(paramDrawable);
    }

    public void setPullLabel(CharSequence paramCharSequence) {
        this.j = paramCharSequence;
    }

    public void setRefreshingLabel(CharSequence paramCharSequence) {
        this.k = paramCharSequence;
    }

    public void setReleaseLabel(CharSequence paramCharSequence) {
        this.l = paramCharSequence;
    }

    public void setTextTypeface(Typeface paramTypeface) {
        this.h.setTypeface(paramTypeface);
    }

    public final void setWidth(int paramInt) {
        getLayoutParams().width = paramInt;
        requestLayout();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/pulltorefresh/library/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */