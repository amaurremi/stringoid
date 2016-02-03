package com.quoord.tapatalkpro.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class LinearLayoutWithBottomLine
        extends LinearLayout {
    private int lineColor = -1;
    private int lineHeight = 0;
    private Paint mPaint;

    public LinearLayoutWithBottomLine(Context paramContext) {
        super(paramContext);
        setWillNotDraw(false);
        initBottonLineHeight(paramContext);
    }

    public LinearLayoutWithBottomLine(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        setWillNotDraw(false);
        initBottonLineHeight(paramContext);
    }

    public LinearLayoutWithBottomLine(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        setWillNotDraw(false);
        initBottonLineHeight(paramContext);
    }

    private int getLineColor() {
        if (this.lineColor < 1) {
            this.lineColor = getContext().getResources().getColor(2131165558);
        }
        return this.lineColor;
    }

    private void initBottonLineHeight(Context paramContext) {
        this.lineHeight = paramContext.getResources().getDimensionPixelOffset(2131427391);
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setColor(getLineColor());
        int i = getBottom();
        paramCanvas.drawRect(0, i - this.lineHeight, getWidth() + 0, i, this.mPaint);
    }

    public void setLineHeight(int paramInt) {
        this.lineHeight = paramInt;
        postInvalidate();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/LinearLayoutWithBottomLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */