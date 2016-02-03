package com.everimaging.fotor.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

public class PinnedHeaderListView
        extends ListView {
    private a a;
    private View b;
    private boolean c;
    private int d;
    private int e;

    public PinnedHeaderListView(Context paramContext) {
        super(paramContext);
    }

    public PinnedHeaderListView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public PinnedHeaderListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public void a(int paramInt) {
        int i = 255;
        if (this.b == null) {
            return;
        }
        switch (this.a.a(paramInt)) {
            default:
                return;
            case 0:
                this.c = false;
                return;
            case 1:
                this.a.a(this.b, paramInt, 255);
                if (this.b.getTop() != 0) {
                    this.b.layout(0, 0, this.d, this.e);
                }
                this.c = true;
                return;
        }
        int j = getChildAt(0).getBottom();
        int k = this.b.getHeight();
        if (j < k) {
            j -= k;
            i = (k + j) * 255 / k;
        }
        for (; ; ) {
            this.a.a(this.b, paramInt, i);
            if (this.b.getTop() != j) {
                this.b.layout(0, j, this.d, this.e + j);
            }
            this.c = true;
            return;
            j = 0;
        }
    }

    protected void dispatchDraw(Canvas paramCanvas) {
        super.dispatchDraw(paramCanvas);
        if ((this.c) && (this.b != null)) {
            drawChild(paramCanvas, this.b, getDrawingTime());
        }
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        if (this.b != null) {
            this.b.layout(0, 0, this.d, this.e);
            a(getFirstVisiblePosition());
        }
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        if (this.b != null) {
            measureChild(this.b, paramInt1, paramInt2);
            this.d = this.b.getMeasuredWidth();
            this.e = this.b.getMeasuredHeight();
        }
    }

    public void setAdapter(ListAdapter paramListAdapter) {
        super.setAdapter(paramListAdapter);
        this.a = ((a) paramListAdapter);
    }

    public void setPinnedHeaderView(View paramView) {
        this.b = paramView;
        if (this.b != null) {
            setFadingEdgeLength(0);
        }
        requestLayout();
    }

    public static abstract interface a {
        public abstract int a(int paramInt);

        public abstract void a(View paramView, int paramInt1, int paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/widget/PinnedHeaderListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */