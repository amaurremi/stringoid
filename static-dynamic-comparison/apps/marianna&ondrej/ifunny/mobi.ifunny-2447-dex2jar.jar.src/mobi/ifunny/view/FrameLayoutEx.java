package mobi.ifunny.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.as;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import mobi.ifunny.j;

public class FrameLayoutEx
        extends FrameLayout {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;

    public FrameLayoutEx(Context paramContext) {
        super(paramContext);
        a(paramContext, null);
    }

    public FrameLayoutEx(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a(paramContext, paramAttributeSet);
    }

    private void a(Context paramContext, AttributeSet paramAttributeSet) {
        if (paramAttributeSet != null) {
            paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, j.mobi_ifunny_view_FrameLayoutEx);
            int j = paramContext.getIndexCount();
            int i = 0;
            if (i < j) {
                int k = paramContext.getIndex(i);
                switch (k) {
                }
                for (; ; ) {
                    i += 1;
                    break;
                    this.a = paramContext.getBoolean(k, false);
                    continue;
                    this.b = paramContext.getBoolean(k, false);
                    continue;
                    this.c = paramContext.getBoolean(k, false);
                }
            }
            paramContext.recycle();
        }
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/FrameLayoutEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */