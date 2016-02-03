package mobi.ifunny.studio.comics.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

import mobi.ifunny.j;

public class EqualSpaceGridView
        extends GridView {
    private int a;
    private int b;
    private int c;
    private int d;
    private List<Integer> e;
    private b f;
    private int g;
    private c h;

    public EqualSpaceGridView(Context paramContext) {
        super(paramContext);
        a(paramContext, null);
    }

    public EqualSpaceGridView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a(paramContext, paramAttributeSet);
    }

    public EqualSpaceGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a(paramContext, paramAttributeSet);
    }

    private View a(int paramInt) {
        int i = getFirstVisiblePosition();
        if ((i <= paramInt) && (getChildCount() + i > paramInt)) {
            return getChildAt(paramInt - i);
        }
        return null;
    }

    private void a() {
        int j = getAdapter().getCount();
        int k = j / 2;
        int i = 2;
        while (i < k) {
            if (j % i == 0) {
                this.e.add(Integer.valueOf(i));
            }
            i += 1;
        }
    }

    private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        View localView = a(paramInt);
        if ((getOnPrimarySelectedListener() != null) && (localView != null)) {
            if (!paramBoolean2) {
                getOnPrimarySelectedListener().a(paramInt, localView, paramBoolean1);
            }
            a(localView, paramBoolean1);
        }
    }

    private void a(Context paramContext, AttributeSet paramAttributeSet) {
        this.e = new ArrayList();
        this.f = new b(this, null);
        this.d = -1465341784;
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, j.mobi_ifunny_editor_view_EqualSpaceGridView);
        int j = paramContext.getIndexCount();
        int i = 0;
        if (i < j) {
            int k = paramContext.getIndex(i);
            switch (k) {
            }
            for (; ; ) {
                i += 1;
                break;
                this.d = paramContext.getColor(k, -1465341784);
            }
        }
        paramContext.recycle();
    }

    private void a(View paramView, boolean paramBoolean) {
        if ((getOnPrimarySelectedListener() != null) && (paramView != null)) {
            getOnPrimarySelectedListener().a(paramView, paramBoolean);
        }
    }

    private void b(int paramInt, boolean paramBoolean) {
        if (paramInt == -1) {
            return;
        }
        a(a(paramInt), paramBoolean);
    }

    public void a(int paramInt, boolean paramBoolean) {
        a(this.g, false, true);
        this.g = paramInt;
        a(this.g, true, paramBoolean);
    }

    protected boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean) {
        paramLayoutParams = (AbsListView.LayoutParams) paramLayoutParams;
        paramLayoutParams.width = this.a;
        paramLayoutParams.height = this.b;
        return super.addViewInLayout(paramView, paramInt, paramLayoutParams, paramBoolean);
    }

    protected void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
        paramLayoutParams = (AbsListView.LayoutParams) paramLayoutParams;
        paramLayoutParams.width = this.a;
        paramLayoutParams.height = this.b;
        super.attachViewToParent(paramView, paramInt, paramLayoutParams);
    }

    protected void dispatchDraw(Canvas paramCanvas) {
        super.dispatchDraw(paramCanvas);
        if (!isEnabled()) {
            paramCanvas.drawColor(this.d);
        }
    }

    public c getOnPrimarySelectedListener() {
        return this.h;
    }

    public int getPrimarySelectedIndex() {
        return this.g;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        b(this.g, true);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        ListAdapter localListAdapter = getAdapter();
        int i1;
        int i3;
        int i2;
        int i;
        int n;
        int m;
        float f1;
        if ((localListAdapter != null) && (localListAdapter.getCount() > 0)) {
            i1 = localListAdapter.getCount();
            i3 = getDefaultSize(getSuggestedMinimumWidth(), paramInt1) - getPaddingLeft() - getPaddingRight();
            i2 = getDefaultSize(getSuggestedMinimumHeight(), paramInt2) - getPaddingTop() - getPaddingBottom();
            if ((i3 <= 0) || (i2 <= 0)) {
                super.onMeasure(paramInt1, paramInt2);
                return;
            }
            i = (int) Math.sqrt(i3 * i2 / i1);
            n = i3 / i;
            m = i - (this.c - this.c / n);
            f1 = i1 / n;
            i = (int) f1;
            if (i == f1) {
                break label459;
            }
            i += 1;
        }
        label277:
        label287:
        label411:
        label442:
        label445:
        label459:
        for (; ; ) {
            int i4 = this.e.size();
            int k;
            int j;
            if (i4 > 0) {
                k = 0;
                if (k < i4) {
                    j = ((Integer) this.e.get(k)).intValue();
                    if ((j >= n) || (k - 1 == i4)) {
                        k = (int) (i3 / j - (this.c - this.c / j + 1.0F));
                        f1 = i1 / j;
                        i = (int) f1;
                        if (i == f1) {
                            break label445;
                        }
                        i += 1;
                    }
                }
            }
            for (; ; ) {
                if (i == 1) {
                    m = 0;
                    f1 = FloatMath.floor(i2 / k);
                    if ((f1 >= i) && (m >= this.c)) {
                        break label411;
                    }
                    k -= this.c / 2;
                    f1 = FloatMath.floor(i2 / k);
                    float f2 = i1 / j;
                    i = (int) f2;
                    if (i == f2) {
                        break label442;
                    }
                    i += 1;
                }
                for (; ; ) {
                    if (i == 1) {
                        m = 0;
                        break label287;
                        k += 1;
                        break;
                        m = (i2 - k * i) / (i - 1);
                        break label277;
                    }
                    m = (i2 - k * i) / (i - 1);
                    break label287;
                    setVerticalSpacing(m);
                    setNumColumns(j);
                    this.a = k;
                    this.b = k;
                    super.onMeasure(paramInt1, paramInt2);
                    return;
                }
                continue;
                j = n;
                k = m;
            }
        }
    }

    public void setAdapter(ListAdapter paramListAdapter) {
        if (getAdapter() != null) {
            getAdapter().unregisterDataSetObserver(this.f);
        }
        super.setAdapter(paramListAdapter);
        if (paramListAdapter != null) {
            paramListAdapter.registerDataSetObserver(this.f);
        }
        a();
    }

    public void setHorizontalSpacing(int paramInt) {
        super.setHorizontalSpacing(paramInt);
        this.c = paramInt;
    }

    public void setOnPrimarySelectedListener(c paramc) {
        this.h = paramc;
    }

    public void setPrimarySelected(int paramInt) {
        a(paramInt, false);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/view/EqualSpaceGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */