package com.mopub.nativeads;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;

class VisibilityTracker$VisibilityChecker {
    private final Rect mClipRect = new Rect();

    boolean hasRequiredTimeElapsed(long paramLong, int paramInt) {
        return SystemClock.uptimeMillis() - paramLong >= paramInt;
    }

    boolean isVisible(View paramView, int paramInt) {
        if ((paramView == null) || (paramView.getVisibility() != 0) || (paramView.getParent() == null)) {
        }
        long l1;
        long l2;
        long l3;
        do {
            do {
                return false;
            } while (!paramView.getGlobalVisibleRect(this.mClipRect));
            l1 = this.mClipRect.height();
            l2 = this.mClipRect.width();
            l3 = paramView.getHeight() * paramView.getWidth();
        } while ((l3 <= 0L) || (l1 * l2 * 100L < l3 * paramInt));
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/VisibilityTracker$VisibilityChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */