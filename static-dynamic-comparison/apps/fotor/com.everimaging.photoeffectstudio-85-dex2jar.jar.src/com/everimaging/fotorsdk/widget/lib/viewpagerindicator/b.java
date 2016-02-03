package com.everimaging.fotorsdk.widget.lib.viewpagerindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

class b
        extends LinearLayout {
    private static final int[] a = {16843049, 16843561, 16843562};
    private Drawable b;
    private int c;
    private int d;
    private int e;
    private int f;

    public b(Context paramContext, int paramInt) {
        super(paramContext);
        paramContext = paramContext.obtainStyledAttributes(null, a, paramInt, 0);
        setDividerDrawable(paramContext.getDrawable(0));
        this.f = paramContext.getDimensionPixelSize(2, 0);
        this.e = paramContext.getInteger(1, 0);
        paramContext.recycle();
    }

    private void a(Canvas paramCanvas) {
        int j = getChildCount();
        int i = 0;
        View localView;
        while (i < j) {
            localView = getChildAt(i);
            if ((localView != null) && (localView.getVisibility() != 8) && (a(i))) {
                LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams) localView.getLayoutParams();
                a(paramCanvas, localView.getTop() - localLayoutParams.topMargin);
            }
            i += 1;
        }
        if (a(j)) {
            localView = getChildAt(j - 1);
            if (localView != null) {
                break label119;
            }
        }
        label119:
        for (i = getHeight() - getPaddingBottom() - this.d; ; i = localView.getBottom()) {
            a(paramCanvas, i);
            return;
        }
    }

    private void a(Canvas paramCanvas, int paramInt) {
        this.b.setBounds(getPaddingLeft() + this.f, paramInt, getWidth() - getPaddingRight() - this.f, this.d + paramInt);
        this.b.draw(paramCanvas);
    }

    private boolean a(int paramInt) {
        if ((paramInt == 0) || (paramInt == getChildCount())) {
        }
        for (; ; ) {
            return false;
            if ((this.e & 0x2) != 0) {
                paramInt -= 1;
                while (paramInt >= 0) {
                    if (getChildAt(paramInt).getVisibility() != 8) {
                        return true;
                    }
                    paramInt -= 1;
                }
            }
        }
    }

    private void b(Canvas paramCanvas) {
        int j = getChildCount();
        int i = 0;
        View localView;
        while (i < j) {
            localView = getChildAt(i);
            if ((localView != null) && (localView.getVisibility() != 8) && (a(i))) {
                LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams) localView.getLayoutParams();
                b(paramCanvas, localView.getLeft() - localLayoutParams.leftMargin);
            }
            i += 1;
        }
        if (a(j)) {
            localView = getChildAt(j - 1);
            if (localView != null) {
                break label119;
            }
        }
        label119:
        for (i = getWidth() - getPaddingRight() - this.c; ; i = localView.getRight()) {
            b(paramCanvas, i);
            return;
        }
    }

    private void b(Canvas paramCanvas, int paramInt) {
        this.b.setBounds(paramInt, getPaddingTop() + this.f, this.c + paramInt, getHeight() - getPaddingBottom() - this.f);
        this.b.draw(paramCanvas);
    }

    protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int i = indexOfChild(paramView);
        int j = getOrientation();
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams) paramView.getLayoutParams();
        if (a(i)) {
            if (j == 1) {
                localLayoutParams.topMargin = this.d;
            }
        } else {
            int k = getChildCount();
            if ((i == k - 1) && (a(k))) {
                if (j != 1) {
                    break label109;
                }
                localLayoutParams.bottomMargin = this.d;
            }
        }
        for (; ; ) {
            super.measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
            return;
            localLayoutParams.leftMargin = this.c;
            break;
            label109:
            localLayoutParams.rightMargin = this.c;
        }
    }

    protected void onDraw(Canvas paramCanvas) {
        if (this.b != null) {
            if (getOrientation() != 1) {
                break label26;
            }
            a(paramCanvas);
        }
        for (; ; ) {
            super.onDraw(paramCanvas);
            return;
            label26:
            b(paramCanvas);
        }
    }

    public void setDividerDrawable(Drawable paramDrawable) {
        boolean bool = false;
        if (paramDrawable == this.b) {
            return;
        }
        this.b = paramDrawable;
        if (paramDrawable != null) {
            this.c = paramDrawable.getIntrinsicWidth();
        }
        for (this.d = paramDrawable.getIntrinsicHeight(); ; this.d = 0) {
            if (paramDrawable == null) {
                bool = true;
            }
            setWillNotDraw(bool);
            requestLayout();
            return;
            this.c = 0;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/lib/viewpagerindicator/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */