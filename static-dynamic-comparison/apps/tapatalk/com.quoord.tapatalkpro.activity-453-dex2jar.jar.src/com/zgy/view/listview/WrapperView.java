package com.zgy.view.listview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;

class WrapperView
        extends ViewGroup {
    Drawable mDivider;
    int mDividerHeight;
    View mHeader;
    View mItem;
    int mItemTop;

    public WrapperView(Context paramContext) {
        super(paramContext);
    }

    protected void dispatchDraw(Canvas paramCanvas) {
        super.dispatchDraw(paramCanvas);
        if ((this.mHeader == null) && (this.mDivider != null)) {
            if (Build.VERSION.SDK_INT < 11) {
                paramCanvas.clipRect(0, 0, getWidth(), this.mDividerHeight);
            }
            this.mDivider.draw(paramCanvas);
        }
    }

    boolean hasHeader() {
        return this.mHeader != null;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        paramInt1 = getWidth();
        paramInt2 = getHeight();
        if (this.mHeader != null) {
            paramInt3 = this.mHeader.getMeasuredHeight();
            this.mHeader.layout(0, 0, paramInt1, paramInt3);
            this.mItemTop = paramInt3;
            this.mItem.layout(0, paramInt3, paramInt1, paramInt2);
            return;
        }
        if (this.mDivider != null) {
            this.mDivider.setBounds(0, 0, paramInt1, this.mDividerHeight);
            this.mItemTop = this.mDividerHeight;
            this.mItem.layout(0, this.mDividerHeight, paramInt1, paramInt2);
            return;
        }
        this.mItemTop = 0;
        this.mItem.layout(0, 0, paramInt1, paramInt2);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        paramInt2 = View.MeasureSpec.getSize(paramInt1);
        int i = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        paramInt1 = 0;
        if (this.mHeader != null) {
            ViewGroup.LayoutParams localLayoutParams = this.mHeader.getLayoutParams();
            if ((localLayoutParams != null) && (localLayoutParams.height > 0)) {
                this.mHeader.measure(i, View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824));
                paramInt1 = 0 + this.mHeader.getMeasuredHeight();
                label71:
                localLayoutParams = this.mItem.getLayoutParams();
                if ((localLayoutParams == null) || (localLayoutParams.height <= 0)) {
                    break label159;
                }
                this.mItem.measure(i, View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824));
            }
        }
        for (; ; ) {
            setMeasuredDimension(paramInt2, paramInt1 + this.mItem.getMeasuredHeight());
            return;
            this.mHeader.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
            break;
            if (this.mDivider == null) {
                break label71;
            }
            paramInt1 = 0 + this.mDividerHeight;
            break label71;
            label159:
            this.mItem.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    void update(View paramView1, View paramView2, Drawable paramDrawable, int paramInt) {
        if (paramView1 == null) {
            throw new NullPointerException("List view item must not be null.");
        }
        if (this.mItem != paramView1) {
            removeView(this.mItem);
            this.mItem = paramView1;
            ViewParent localViewParent = paramView1.getParent();
            if ((localViewParent != null) && (localViewParent != this) && ((localViewParent instanceof ViewGroup))) {
                ((ViewGroup) localViewParent).removeView(paramView1);
            }
            addView(paramView1);
        }
        if (this.mHeader != paramView2) {
            if (this.mHeader != null) {
                removeView(this.mHeader);
            }
            this.mHeader = paramView2;
            if (paramView2 != null) {
                addView(paramView2);
            }
        }
        if (this.mDivider != paramDrawable) {
            this.mDivider = paramDrawable;
            this.mDividerHeight = paramInt;
            invalidate();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/zgy/view/listview/WrapperView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */