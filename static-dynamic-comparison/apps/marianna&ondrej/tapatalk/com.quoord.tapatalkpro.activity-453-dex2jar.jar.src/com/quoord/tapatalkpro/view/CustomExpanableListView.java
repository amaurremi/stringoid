package com.quoord.tapatalkpro.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LayoutAnimationController;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

public class CustomExpanableListView
        extends ExpandableListView {
    private LayoutAnimationController childLayoutAnimationController;
    private int currentGroupPosition = -1;
    private BaseExpandableListAdapter thisAdapter;

    public CustomExpanableListView(Context paramContext) {
        super(paramContext);
    }

    public CustomExpanableListView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public CustomExpanableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    private void bindLayoutAnimation(View paramView) {
        paramView.setAnimation(this.childLayoutAnimationController.getAnimationForView(paramView));
    }

    protected void dispatchDraw(Canvas paramCanvas) {
        if (this.thisAdapter == null) {
            super.dispatchDraw(paramCanvas);
            return;
        }
        this.thisAdapter.getChildrenCount(this.currentGroupPosition);
    }

    public void setChildLayoutAnimation(LayoutAnimationController paramLayoutAnimationController, int paramInt) {
        this.childLayoutAnimationController = paramLayoutAnimationController;
        this.currentGroupPosition = paramInt;
    }

    public void setThisAdapter(BaseExpandableListAdapter paramBaseExpandableListAdapter) {
        this.thisAdapter = paramBaseExpandableListAdapter;
        setAdapter(paramBaseExpandableListAdapter);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/CustomExpanableListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */