package mobi.ifunny.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.support.v4.view.cg;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import java.util.ArrayList;
import java.util.List;

public final class FragmentTabWidget
        extends LinearLayout
        implements cg {
    private static int a = -1;
    private int b = a;
    private List<j> c;
    private ViewPager d;
    private View e;
    private k f;
    private int g = a;
    private boolean h;
    private int i;

    public FragmentTabWidget(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a(paramContext, paramAttributeSet);
    }

    private int a(float paramFloat1, float paramFloat2) {
        int m = this.c.size();
        int j = 0;
        while (j < m) {
            View localView = j.a((j) this.c.get(j));
            if ((paramFloat2 >= localView.getTop()) && (paramFloat2 < localView.getBottom()) && (paramFloat1 >= localView.getLeft()) && (paramFloat1 < localView.getRight())) {
            }
            for (int k = 1; k != 0; k = 0) {
                return j;
            }
            j += 1;
        }
        return -1;
    }

    private void a(int paramInt, boolean paramBoolean) {
        if ((paramInt == this.b) || (paramInt >= this.c.size())) {
        }
        do {
            return;
            if (this.b != a) {
                this.e.setSelected(false);
                c(this.b).a(false);
            }
            this.e = j.a((j) this.c.get(paramInt));
            this.e.setSelected(true);
            c(paramInt).a(true);
            this.b = paramInt;
            this.d.setCurrentItem(paramInt);
        } while (this.f == null);
        this.f.a(paramInt, paramBoolean);
    }

    private void a(Context paramContext, AttributeSet paramAttributeSet) {
        this.c = new ArrayList();
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, mobi.ifunny.j.mobi_ifunny_view_FragmentTabWidget);
        setWeightSum(paramContext.getInt(0, 0));
        this.h = paramContext.getBoolean(1, false);
        paramContext.recycle();
    }

    private void a(View paramView) {
        paramView.setPressed(true);
        if (this.f != null) {
            this.f.b(this.i);
        }
    }

    private void b(View paramView) {
        paramView.setPressed(false);
        if (this.f != null) {
            this.f.c(this.i);
        }
        a(this.i, true);
    }

    private void c(View paramView) {
        paramView.setPressed(false);
        if (this.f != null) {
            this.f.c(this.i);
        }
    }

    public void a(int paramInt) {
        d(paramInt);
    }

    public void a(int paramInt1, float paramFloat, int paramInt2) {
    }

    public void a(j paramj) {
        this.c.add(paramj);
        paramj = paramj.a(LayoutInflater.from(getContext()), this);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams) paramj.getLayoutParams();
        if (this.h) {
            localLayoutParams.gravity = 19;
            setOrientation(1);
        }
        for (; ; ) {
            addView(paramj, localLayoutParams);
            int j = getTabsCount();
            if (getWeightSum() < j) {
                setWeightSum(j);
            }
            if (this.d != null) {
                d(this.d.getCurrentItem());
            }
            return;
            localLayoutParams.width = 0;
            localLayoutParams.weight = 1.0F;
            localLayoutParams.gravity = 119;
        }
    }

    public void b(int paramInt) {
    }

    public j c(int paramInt) {
        if ((paramInt < 0) || (paramInt >= this.c.size())) {
            return null;
        }
        return (j) this.c.get(paramInt);
    }

    public void d(int paramInt) {
        a(paramInt, false);
    }

    public k getFragmentTabStateListener() {
        return this.f;
    }

    public int getSelectedIndex() {
        return this.b;
    }

    public int getTabsCount() {
        return this.c.size();
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        switch (paramMotionEvent.getActionMasked()) {
        }
        int j;
        do {
            return super.onInterceptTouchEvent(paramMotionEvent);
            this.i = a;
            j = a(paramMotionEvent.getX(), paramMotionEvent.getY());
        } while (j < 0);
        this.i = j;
        return true;
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (this.i == a) {
            return super.onTouchEvent(paramMotionEvent);
        }
        int j = paramMotionEvent.getActionMasked();
        paramMotionEvent = j.a((j) this.c.get(this.i));
        switch (j) {
        }
        for (; ; ) {
            return true;
            a(paramMotionEvent);
            continue;
            c(paramMotionEvent);
            continue;
            b(paramMotionEvent);
            this.i = a;
        }
    }

    public void setFragmentTabStateListener(k paramk) {
        this.f = paramk;
    }

    public void setup(ViewPager paramViewPager) {
        if (this.d != null) {
            this.d.setOnPageChangeListener(null);
        }
        this.d = paramViewPager;
        d(paramViewPager.getCurrentItem());
        if (paramViewPager != null) {
            paramViewPager.setOnPageChangeListener(this);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/FragmentTabWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */