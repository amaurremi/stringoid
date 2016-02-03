package com.quoord.tapatalkpro.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;

import java.util.Hashtable;

public class SearchKeyWordsLayout
        extends RelativeLayout {
    int currentBottom;
    int mBottom;
    int mLeft;
    int mRight;
    int mTop;
    Hashtable<View, Position> map = new Hashtable();

    public SearchKeyWordsLayout(Context paramContext) {
        super(paramContext);
    }

    public SearchKeyWordsLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public SearchKeyWordsLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public int getPosition(int paramInt1, int paramInt2) {
        if (paramInt1 > 0) {
            return getPosition(paramInt1 - 1, paramInt2 - 1) + getChildAt(paramInt2 - 1).getMeasuredWidth();
        }
        return 0;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        paramInt2 = getChildCount();
        paramInt1 = 0;
        if (paramInt1 >= paramInt2) {
            return;
        }
        View localView = getChildAt(paramInt1);
        Position localPosition = (Position) this.map.get(localView);
        if (localPosition != null) {
            localView.layout(localPosition.left, localPosition.top, localPosition.right, localPosition.bottom);
        }
        for (; ; ) {
            paramInt1 += 1;
            break;
            Log.i("MyLayout", "error");
        }
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        int i = View.MeasureSpec.getSize(paramInt1);
        this.mLeft = 0;
        this.mRight = 0;
        this.mTop = 0;
        this.mBottom = 0;
        paramInt2 = 0;
        int j = getChildCount();
        paramInt1 = 0;
        for (; ; ) {
            if (paramInt1 >= j) {
                return;
            }
            Position localPosition = new Position(null);
            View localView = getChildAt(paramInt1);
            this.mLeft = getPosition(paramInt1 - paramInt2, paramInt1);
            this.mRight = (this.mLeft + localView.getMeasuredWidth());
            if (this.mRight >= i) {
                paramInt2 = paramInt1;
                this.mLeft = getPosition(paramInt1 - paramInt2, paramInt1);
                this.mRight = (this.mLeft + localView.getMeasuredWidth());
                this.mTop += getChildAt(paramInt1).getMeasuredHeight() - 2;
            }
            this.mBottom = (this.mTop + localView.getMeasuredHeight());
            localPosition.left = this.mLeft;
            localPosition.top = this.mTop;
            localPosition.right = this.mRight;
            localPosition.bottom = this.mBottom;
            this.map.put(localView, localPosition);
            paramInt1 += 1;
        }
    }

    private class Position {
        int bottom;
        int left;
        int right;
        int top;

        private Position() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/SearchKeyWordsLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */