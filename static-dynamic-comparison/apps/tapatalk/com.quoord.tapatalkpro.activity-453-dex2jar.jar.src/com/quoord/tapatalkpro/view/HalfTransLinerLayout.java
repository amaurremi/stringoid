package com.quoord.tapatalkpro.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class HalfTransLinerLayout
        extends LinearLayout {
    public HalfTransLinerLayout(Context paramContext) {
        super(paramContext);
    }

    public HalfTransLinerLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public HalfTransLinerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        Paint localPaint = new Paint();
        localPaint.setColor(getContext().getResources().getColor(2131165212));
        paramCanvas.drawRect(getLeft(), getTop(), getRight(), getBottom() / 2, localPaint);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/HalfTransLinerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */