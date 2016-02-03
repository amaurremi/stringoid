package com.everimaging.fotorsdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.everimaging.fotorsdk.R.attr;
import com.everimaging.fotorsdk.R.color;
import com.everimaging.fotorsdk.R.dimen;
import com.everimaging.fotorsdk.R.styleable;

public class FotorOperationToolPanel
        extends FrameLayout {
    private Paint a;
    private int b;

    public FotorOperationToolPanel(Context paramContext) {
        super(paramContext);
        a();
    }

    public FotorOperationToolPanel(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, R.attr.fotorDefaultOperToolPanelStyle);
    }

    public FotorOperationToolPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FotorOperToolPanel, paramInt, 0);
        setBottomLineColor(paramContext.getColor(0, getResources().getColor(R.color.fotor_divider_line_color)));
        paramContext.recycle();
        a();
    }

    private void a() {
        setWillNotDraw(false);
        this.a = new Paint();
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        this.a.setColor(this.b);
        float f = getContext().getResources().getDimension(R.dimen.fotor_main_tool_panel_line_size);
        paramCanvas.drawLine(0.0F, getHeight() - f, getWidth(), getHeight() - f, this.a);
    }

    public void setBottomLineColor(int paramInt) {
        this.b = paramInt;
        invalidate();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorOperationToolPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */