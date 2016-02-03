package com.quoord.tapatalkpro.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;

public class TapatalkHorizontalscrollview
        extends HorizontalScrollView {
    public int flag = -1;
    int preX;

    public TapatalkHorizontalscrollview(Context paramContext) {
        super(paramContext);
    }

    public TapatalkHorizontalscrollview(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public TapatalkHorizontalscrollview(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        switch (paramMotionEvent.getAction()) {
        }
        for (; ; ) {
            return super.onInterceptTouchEvent(paramMotionEvent);
            getParent().requestDisallowInterceptTouchEvent(true);
            continue;
            getParent().requestDisallowInterceptTouchEvent(false);
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        switch (paramMotionEvent.getAction()) {
        }
        for (; ; ) {
            return super.onTouchEvent(paramMotionEvent);
            if (this.preX == 0) {
                this.preX = ((int) paramMotionEvent.getX());
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/TapatalkHorizontalscrollview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */