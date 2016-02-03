package mobi.ifunny.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v4.view.as;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import mobi.ifunny.j;

public class LinearLayoutEx
        extends LinearLayout {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private int e;
    private int f;
    private int g;
    private int h;

    public LinearLayoutEx(Context paramContext) {
        super(paramContext);
    }

    public LinearLayoutEx(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a(paramContext, paramAttributeSet);
    }

    private void a(Context paramContext, AttributeSet paramAttributeSet) {
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, j.mobi_ifunny_view_LinearLayoutEx);
        this.a = paramContext.getBoolean(6, false);
        this.b = paramContext.getBoolean(5, false);
        this.c = paramContext.getBoolean(0, false);
        this.e = paramContext.getDimensionPixelSize(2, 0);
        this.f = paramContext.getDimensionPixelSize(3, 0);
        this.g = paramContext.getDimensionPixelSize(4, 0);
        this.h = paramContext.getDimensionPixelSize(1, 0);
        paramContext.recycle();
    }

    private void setPressedAll(boolean paramBoolean) {
        if ((this.b) && ((isEnabled()) || (!paramBoolean))) {
            int j = getChildCount();
            int i = 0;
            while (i < j) {
                getChildAt(i).setPressed(paramBoolean);
                i += 1;
            }
        }
        setPressed(paramBoolean);
    }

    protected void dispatchSetPressed(boolean paramBoolean) {
        if (this.b) {
            this.d = paramBoolean;
            int j = getChildCount();
            int i = 0;
            while (i < j) {
                getChildAt(i).setPressed(paramBoolean);
                i += 1;
            }
        }
        super.dispatchSetPressed(paramBoolean);
    }

    public void dispatchSetSelected(boolean paramBoolean) {
        if (this.a) {
            int j = getChildCount();
            int i = 0;
            while (i < j) {
                getChildAt(i).setSelected(paramBoolean);
                i += 1;
            }
        }
    }

    public void getHitRect(Rect paramRect) {
        super.getHitRect(paramRect);
        paramRect.set(paramRect.left - this.e, paramRect.top - this.g, paramRect.right + this.f, paramRect.bottom + this.h);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        int i = 1;
        int j = as.a(paramMotionEvent);
        if (j == 0) {
            this.d = true;
        }
        for (; ; ) {
            boolean bool = super.onTouchEvent(paramMotionEvent);
            if ((i != 0) && (this.b) && (isEnabled())) {
                setPressedAll(this.d);
            }
            return bool;
            if ((this.d) && ((j == 1) || (j == 3) || (j == 10))) {
                this.d = false;
            } else {
                i = 0;
            }
        }
    }

    public void setEnabled(boolean paramBoolean) {
        if (this.c) {
            int j = getChildCount();
            int i = 0;
            while (i < j) {
                getChildAt(i).setEnabled(paramBoolean);
                i += 1;
            }
        }
        super.setEnabled(paramBoolean);
    }

    public void setPressAllChild(boolean paramBoolean) {
        this.b = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/LinearLayoutEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */