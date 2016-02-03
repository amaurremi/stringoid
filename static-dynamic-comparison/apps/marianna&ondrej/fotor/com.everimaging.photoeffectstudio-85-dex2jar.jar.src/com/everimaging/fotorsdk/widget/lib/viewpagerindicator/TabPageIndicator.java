package com.everimaging.fotorsdk.widget.lib.viewpagerindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.everimaging.fotorsdk.R.attr;
import com.everimaging.fotorsdk.R.styleable;
import com.everimaging.fotorsdk.utils.TypefaceUtils;

import java.io.PrintStream;

public class TabPageIndicator
        extends HorizontalScrollView
        implements c {
    private static final CharSequence a = "";
    private Runnable b;
    private final View.OnClickListener c = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            paramAnonymousView = (TabPageIndicator.b) paramAnonymousView;
            int i = TabPageIndicator.a(TabPageIndicator.this).getCurrentItem();
            int j = paramAnonymousView.a();
            TabPageIndicator.a(TabPageIndicator.this).setCurrentItem(j);
            if ((i == j) && (TabPageIndicator.b(TabPageIndicator.this) != null)) {
                TabPageIndicator.b(TabPageIndicator.this).a(j);
            }
        }
    };
    private final b d;
    private ViewPager e;
    private ViewPager.OnPageChangeListener f;
    private int g;
    private int h;
    private a i;

    public TabPageIndicator(Context paramContext) {
        this(paramContext, null);
    }

    public TabPageIndicator(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        setHorizontalScrollBarEnabled(false);
        this.d = new b(paramContext, R.attr.fotorVPITabPageIndicatorStyle);
        addView(this.d, new ViewGroup.LayoutParams(-2, -1));
    }

    private void a(int paramInt) {
        final View localView = this.d.getChildAt(paramInt);
        if (this.b != null) {
            removeCallbacks(this.b);
        }
        this.b = new Runnable() {
            public void run() {
                int i = localView.getLeft();
                int j = (TabPageIndicator.this.getWidth() - localView.getWidth()) / 2;
                TabPageIndicator.this.smoothScrollTo(i - j, 0);
                TabPageIndicator.a(TabPageIndicator.this, null);
            }
        };
        post(this.b);
    }

    private void a(int paramInt1, CharSequence paramCharSequence, int paramInt2) {
        b localb = new b(getContext());
        b.a(localb, paramInt1);
        localb.setFocusable(true);
        localb.setOnClickListener(this.c);
        localb.setText(paramCharSequence);
        if (paramInt2 != 0) {
            localb.setCompoundDrawablesWithIntrinsicBounds(paramInt2, 0, 0, 0);
        }
        this.d.addView(localb, new LinearLayout.LayoutParams(0, -1, 1.0F));
    }

    public void a() {
        this.d.removeAllViews();
        PagerAdapter localPagerAdapter = this.e.getAdapter();
        a locala = null;
        if ((localPagerAdapter instanceof a)) {
            locala = (a) localPagerAdapter;
        }
        int m = localPagerAdapter.getCount();
        int j = 0;
        CharSequence localCharSequence;
        if (j < m) {
            localCharSequence = localPagerAdapter.getPageTitle(j);
            if (localCharSequence != null) {
                break label127;
            }
            localCharSequence = a;
        }
        label127:
        for (; ; ) {
            if (locala != null) {
            }
            for (int k = locala.a(j); ; k = 0) {
                a(j, localCharSequence, k);
                j += 1;
                break;
                if (this.h > m) {
                    this.h = (m - 1);
                }
                setCurrentItem(this.h);
                requestLayout();
                return;
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b != null) {
            post(this.b);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b != null) {
            removeCallbacks(this.b);
        }
    }

    public void onMeasure(int paramInt1, int paramInt2) {
        int j = View.MeasureSpec.getMode(paramInt1);
        boolean bool;
        if (j == 1073741824) {
            bool = true;
            setFillViewport(bool);
            int k = this.d.getChildCount();
            if ((k <= 1) || ((j != 1073741824) && (j != Integer.MIN_VALUE))) {
                break label120;
            }
            if (k <= 2) {
                break label107;
            }
            this.g = ((int) (View.MeasureSpec.getSize(paramInt1) * 0.4F));
        }
        for (; ; ) {
            j = getMeasuredWidth();
            super.onMeasure(paramInt1, paramInt2);
            paramInt1 = getMeasuredWidth();
            if ((bool) && (j != paramInt1)) {
            }
            try {
                setCurrentItem(this.h);
                return;
            } catch (Exception localException) {
                label107:
                label120:
                System.err.println("error:" + localException.getMessage());
            }
            bool = false;
            break;
            this.g = (View.MeasureSpec.getSize(paramInt1) / 2);
            continue;
            this.g = -1;
        }
    }

    public void onPageScrollStateChanged(int paramInt) {
        if (this.f != null) {
            this.f.onPageScrollStateChanged(paramInt);
        }
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
        if (this.f != null) {
            this.f.onPageScrolled(paramInt1, paramFloat, paramInt2);
        }
    }

    public void onPageSelected(int paramInt) {
        setCurrentItem(paramInt);
        if (this.f != null) {
            this.f.onPageSelected(paramInt);
        }
    }

    public void setCurrentItem(int paramInt) {
        if (this.e == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.h = paramInt;
        this.e.setCurrentItem(paramInt);
        int k = this.d.getChildCount();
        int j = 0;
        if (j < k) {
            View localView = this.d.getChildAt(j);
            if (j == paramInt) {
            }
            for (boolean bool = true; ; bool = false) {
                localView.setSelected(bool);
                if (bool) {
                    a(paramInt);
                }
                j += 1;
                break;
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener) {
        this.f = paramOnPageChangeListener;
    }

    public void setOnTabReselectedListener(a parama) {
        this.i = parama;
    }

    public void setViewPager(ViewPager paramViewPager) {
        if (this.e == paramViewPager) {
            return;
        }
        if (this.e != null) {
            this.e.setOnPageChangeListener(null);
        }
        if (paramViewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        this.e = paramViewPager;
        paramViewPager.setOnPageChangeListener(this);
        a();
    }

    public static abstract interface a {
        public abstract void a(int paramInt);
    }

    private class b
            extends TextView {
        private int b;

        public b(Context paramContext) {
            super(null, R.attr.fotorVPITabPageIndicatorStyle);
            this$1 = paramContext.obtainStyledAttributes(R.styleable.Theme);
            paramContext = TabPageIndicator.this.getString(3);
            if (paramContext != null) {
                a(paramContext);
            }
            TabPageIndicator.this.recycle();
        }

        public int a() {
            return this.b;
        }

        public void a(String paramString) {
            if (paramString != null) {
            }
            try {
                setTypeface(TypefaceUtils.createFromAssetPath(getContext(), paramString));
                return;
            } catch (Throwable paramString) {
            }
        }

        public void onMeasure(int paramInt1, int paramInt2) {
            super.onMeasure(paramInt1, paramInt2);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/lib/viewpagerindicator/TabPageIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */