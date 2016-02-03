package com.quoord.tapatalkpro.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;

public class SideBar
        extends View {
    private int color = -8024940;
    private char[] l;
    private ListView list;
    private TextView mDialogText;
    private final int m_nItemHeight = 29;
    Bitmap mbitmap;
    private SectionIndexer sectionIndexter = null;

    public SideBar(Context paramContext) {
        super(paramContext);
        init();
    }

    public SideBar(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public SideBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    private void init() {
        this.l = new char[]{33, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 35};
        setBackgroundColor(1157627903);
    }

    protected void onDraw(Canvas paramCanvas) {
        Paint localPaint = new Paint();
        localPaint.setColor(this.color);
        localPaint.setTextSize(20.0F);
        localPaint.setStyle(Paint.Style.FILL);
        localPaint.setTextAlign(Paint.Align.CENTER);
        float f1 = getMeasuredWidth() / 2;
        float f2;
        int i;
        if (this.l.length > 0) {
            f2 = getMeasuredHeight() / this.l.length;
            i = 0;
        }
        for (; ; ) {
            if (i >= this.l.length) {
                invalidate();
                super.onDraw(paramCanvas);
                return;
            }
            paramCanvas.drawText(String.valueOf(this.l[i]), f1, (i + 1) * f2 - f2 / 2.0F, localPaint);
            i += 1;
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        super.onTouchEvent(paramMotionEvent);
        int j = (int) paramMotionEvent.getY() / 29;
        int i;
        if (j >= this.l.length) {
            i = this.l.length - 1;
            if ((paramMotionEvent.getAction() != 0) && (paramMotionEvent.getAction() != 2)) {
                break label181;
            }
            this.mDialogText.setVisibility(0);
            this.mDialogText.setText(String.valueOf(this.l[i]));
            this.mDialogText.setTextSize(50.0F);
            if (this.sectionIndexter == null) {
                if (!(this.list.getAdapter() instanceof HeaderViewListAdapter)) {
                    break label154;
                }
            }
        }
        label154:
        for (this.sectionIndexter = ((SectionIndexer) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter()); ; this.sectionIndexter = ((SectionIndexer) this.list.getAdapter())) {
            i = this.sectionIndexter.getPositionForSection(this.l[i]);
            if (i != -1) {
                break label171;
            }
            return true;
            i = j;
            if (j >= 0) {
                break;
            }
            i = 0;
            break;
        }
        label171:
        this.list.setSelection(i);
        return true;
        label181:
        this.mDialogText.setVisibility(4);
        return true;
    }

    public void setListView(ListView paramListView) {
        this.list = paramListView;
        this.sectionIndexter = ((SectionIndexer) paramListView.getAdapter());
    }

    public void setTextView(TextView paramTextView) {
        this.mDialogText = paramTextView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/SideBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */