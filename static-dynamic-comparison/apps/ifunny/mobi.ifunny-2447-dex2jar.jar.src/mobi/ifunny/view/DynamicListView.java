package mobi.ifunny.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class DynamicListView
        extends ListView
        implements GestureDetector.OnGestureListener, mobi.ifunny.gallery.view.d {
    private e a;
    private a b;
    private int c;
    private d d;
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private GestureDetector j;

    public DynamicListView(Context paramContext) {
        super(paramContext);
        c();
    }

    public DynamicListView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        c();
    }

    public DynamicListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        c();
    }

    private void c() {
        this.d = new d(this);
        d();
        e();
        c localc = new c(this, this.g);
        this.d.a(localc, 0);
        this.j = new GestureDetector(getContext(), this);
    }

    private void d() {
        this.c = 2130903150;
    }

    private void e() {
        this.g = 2130903157;
    }

    private boolean f() {
        return (getLastVisiblePosition() == this.a.getCount() - 1) && (getChildAt(getChildCount() - 1 - getFooterViewsCount()).getBottom() <= getHeight());
    }

    private boolean g() {
        return (super.getFirstVisiblePosition() == 0) && (getChildAt(getHeaderViewsCount()).getTop() >= 0);
    }

    private void h() {
        if (this.a != null) {
            this.a.f();
        }
    }

    public View a(int paramInt) {
        int k = paramInt;
        if (this.a != null) {
            if (!this.a.e()) {
                break label52;
            }
        }
        label52:
        for (k = 0; ; k = 1) {
            k = paramInt + k;
            paramInt = getHeaderViewsCount() + k;
            k = super.getFirstVisiblePosition();
            if ((paramInt >= k) && (paramInt <= getLastVisiblePosition())) {
                break;
            }
            return null;
        }
        return getChildAt(paramInt - k);
    }

    public void a() {
        this.a.c();
    }

    public boolean a(float paramFloat) {
        if ((paramFloat >= 0.0F) && (getFirstVisiblePosition() == 0) && (getChildCount() > 0)) {
            View localView = getChildAt(0);
            if ((localView != null) && (localView.getTop() <= 0)) {
                return false;
            }
        }
        return true;
    }

    public int b(int paramInt) {
        int m = getHeaderViewsCount();
        if (this.a.e()) {
        }
        for (int k = 0; ; k = 1) {
            k = paramInt - m - k;
            paramInt = k;
            if (k >= getAdapter().getCount()) {
                paramInt = -1;
            }
            return paramInt;
        }
    }

    public void b() {
        this.a.d();
    }

    public void c(int paramInt) {
        int k = paramInt;
        if (this.a != null) {
            if (!this.a.e()) {
                break label36;
            }
        }
        label36:
        for (k = 0; ; k = 1) {
            k = paramInt + k;
            smoothScrollToPosition(getHeaderViewsCount() + k);
            return;
        }
    }

    public a getDynamicAdapterViewListener() {
        return this.b;
    }

    public int getFirstVisiblePosition() {
        int k = super.getFirstVisiblePosition();
        if (this.a == null) {
            return k;
        }
        if (k == 0) {
            return 0;
        }
        return e.a(this.a, k);
    }

    public ListAdapter getInnerAdapter() {
        if (this.a == null) {
            return null;
        }
        return e.c(this.a);
    }

    public boolean onDown(MotionEvent paramMotionEvent) {
        return false;
    }

    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
        return false;
    }

    public void onLongPress(MotionEvent paramMotionEvent) {
    }

    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
        if ((this.a != null) && (Math.abs(paramFloat2) > Math.abs(paramFloat1))) {
            if ((paramFloat2 > 0.0F) && (this.a.a()) && (f())) {
                e.d(this.a);
                return true;
            }
            if ((paramFloat2 < 0.0F) && (this.a != null) && (this.a.b()) && (g())) {
                e.e(this.a);
                return true;
            }
        }
        return false;
    }

    public void onShowPress(MotionEvent paramMotionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent paramMotionEvent) {
        return false;
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        return (this.j.onTouchEvent(paramMotionEvent)) || (super.onTouchEvent(paramMotionEvent));
    }

    public void setAdapter(ListAdapter paramListAdapter) {
        h();
        if (paramListAdapter != null) {
        }
        for (this.a = new e(this, getContext(), (BaseAdapter) paramListAdapter); ; this.a = null) {
            super.setAdapter(this.a);
            return;
        }
    }

    public void setAutomaticRequestAtEnd(boolean paramBoolean) {
        this.e = paramBoolean;
    }

    public void setAutomaticRequestAtStart(boolean paramBoolean) {
        this.f = paramBoolean;
    }

    public void setDynamicAdapterViewListener(a parama) {
        this.b = parama;
    }

    public void setEmptyView(View paramView) {
        super.setEmptyView(paramView);
    }

    public void setInnerAdapterFilledAtEnd(boolean paramBoolean) {
        this.a.a(paramBoolean);
    }

    public void setInnerAdapterFilledAtStart(boolean paramBoolean) {
        this.a.b(paramBoolean);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) {
        super.setOnItemClickListener(new b(this, paramOnItemClickListener));
    }

    public void setProgressBarLayout(int paramInt) {
        this.c = paramInt;
        if (this.a != null) {
            this.a.notifyDataSetChanged();
        }
    }

    public void setRequestAtLeastItemsAtEnd(int paramInt) {
        this.h = paramInt;
        if ((this.a != null) && ((!e.a(this.a)) || (!e.b(this.a)))) {
            this.a.notifyDataSetChanged();
        }
    }

    public void setRequestAtLeastItemsAtStart(int paramInt) {
        this.i = paramInt;
        if ((this.a != null) && ((!e.a(this.a)) || (!e.b(this.a)))) {
            this.a.notifyDataSetChanged();
        }
    }

    public void setRequestLayout(int paramInt) {
        this.g = paramInt;
        if (this.a != null) {
            this.a.notifyDataSetChanged();
        }
    }

    public void setRequestString(String paramString) {
        this.d.a(paramString);
    }

    public void setSelection(int paramInt) {
        int k = paramInt;
        if (this.a != null) {
            if (!e.b(this.a)) {
                break label27;
            }
        }
        label27:
        for (k = paramInt; ; k = paramInt + 1) {
            super.setSelection(k);
            return;
        }
    }

    public void setSelectionOnItem(int paramInt) {
        int k = paramInt;
        if (this.a != null) {
            if (!this.a.e()) {
                break label36;
            }
        }
        label36:
        for (k = 0; ; k = 1) {
            k = paramInt + k;
            setSelection(getHeaderViewsCount() + k);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/DynamicListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */