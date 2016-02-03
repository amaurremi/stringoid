package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.g.a;
import com.google.android.gms.internal.fq;
import com.google.android.gms.internal.fr;
import com.google.android.gms.internal.fs;

public final class SignInButton
        extends FrameLayout
        implements View.OnClickListener {
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int Av;
    private View Aw;
    private View.OnClickListener Ax = null;
    private int mSize;

    public SignInButton(Context paramContext) {
        this(paramContext, null);
    }

    public SignInButton(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public SignInButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        setStyle(0, 0);
    }

    private static Button a(Context paramContext, int paramInt1, int paramInt2) {
        fs localfs = new fs(paramContext);
        localfs.a(paramContext.getResources(), paramInt1, paramInt2);
        return localfs;
    }

    private void v(Context paramContext) {
        if (this.Aw != null) {
            removeView(this.Aw);
        }
        try {
            this.Aw = fr.b(paramContext, this.mSize, this.Av);
            addView(this.Aw);
            this.Aw.setEnabled(isEnabled());
            this.Aw.setOnClickListener(this);
            return;
        } catch (g.a locala) {
            for (; ; ) {
                Log.w("SignInButton", "Sign in button not found, using placeholder instead");
                this.Aw = a(paramContext, this.mSize, this.Av);
            }
        }
    }

    public void onClick(View paramView) {
        if ((this.Ax != null) && (paramView == this.Aw)) {
            this.Ax.onClick(this);
        }
    }

    public void setColorScheme(int paramInt) {
        setStyle(this.mSize, paramInt);
    }

    public void setEnabled(boolean paramBoolean) {
        super.setEnabled(paramBoolean);
        this.Aw.setEnabled(paramBoolean);
    }

    public void setOnClickListener(View.OnClickListener paramOnClickListener) {
        this.Ax = paramOnClickListener;
        if (this.Aw != null) {
            this.Aw.setOnClickListener(this);
        }
    }

    public void setSize(int paramInt) {
        setStyle(paramInt, this.Av);
    }

    public void setStyle(int paramInt1, int paramInt2) {
        boolean bool2 = true;
        if ((paramInt1 >= 0) && (paramInt1 < 3)) {
            bool1 = true;
            fq.a(bool1, "Unknown button size " + paramInt1);
            if ((paramInt2 < 0) || (paramInt2 >= 2)) {
                break label96;
            }
        }
        label96:
        for (boolean bool1 = bool2; ; bool1 = false) {
            fq.a(bool1, "Unknown color scheme " + paramInt2);
            this.mSize = paramInt1;
            this.Av = paramInt2;
            v(getContext());
            return;
            bool1 = false;
            break;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/common/SignInButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */