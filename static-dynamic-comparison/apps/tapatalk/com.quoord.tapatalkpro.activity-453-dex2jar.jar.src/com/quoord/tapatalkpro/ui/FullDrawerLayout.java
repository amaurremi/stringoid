package com.quoord.tapatalkpro.ui;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;

public class FullDrawerLayout
        extends DrawerLayout {
    private static final int MIN_DRAWER_MARGIN = 0;

    public FullDrawerLayout(Context paramContext) {
        super(paramContext);
    }

    public FullDrawerLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public FullDrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    static String gravityToString(int paramInt) {
        if ((paramInt & 0x3) == 3) {
            return "LEFT";
        }
        if ((paramInt & 0x5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(paramInt);
    }

    int getDrawerViewGravity(View paramView) {
        return Gravity.getAbsoluteGravity(((DrawerLayout.LayoutParams) paramView.getLayoutParams()).gravity, paramView.getLayoutDirection());
    }

    boolean isContentView(View paramView) {
        return ((DrawerLayout.LayoutParams) paramView.getLayoutParams()).gravity == 0;
    }

    boolean isDrawerView(View paramView) {
        return (Gravity.getAbsoluteGravity(((DrawerLayout.LayoutParams) paramView.getLayoutParams()).gravity, paramView.getLayoutDirection()) & 0x7) != 0;
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        int i = View.MeasureSpec.getMode(paramInt1);
        int m = View.MeasureSpec.getMode(paramInt2);
        int j = View.MeasureSpec.getSize(paramInt1);
        int k = View.MeasureSpec.getSize(paramInt2);
        if ((i != 1073741824) || (m != 1073741824)) {
            throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
        }
        setMeasuredDimension(j, k);
        m = getChildCount();
        i = 0;
        if (i >= m) {
        }
        View localView;
        do {
            return;
            localView = getChildAt(i);
        } while (localView == null);
        if (localView.getVisibility() == 8) {
        }
        for (; ; ) {
            i += 1;
            break;
            DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams) localView.getLayoutParams();
            if (isContentView(localView)) {
                localView.measure(View.MeasureSpec.makeMeasureSpec(j - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(k - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824));
            } else {
                if (!isDrawerView(localView)) {
                    break label278;
                }
                int n = getDrawerViewGravity(localView) & 0x7;
                if ((0x0 & n) != 0) {
                    throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(n) + " but this already has a " + "drawer view along that edge");
                }
                localView.measure(getChildMeasureSpec(paramInt1, localLayoutParams.leftMargin + 0 + localLayoutParams.rightMargin, localLayoutParams.width), getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
            }
        }
        label278:
        throw new IllegalStateException("Child " + localView + " at index " + i + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/FullDrawerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */