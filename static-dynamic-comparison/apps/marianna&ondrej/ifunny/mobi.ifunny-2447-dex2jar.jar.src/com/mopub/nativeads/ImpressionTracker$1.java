package com.mopub.nativeads;

import android.view.View;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ImpressionTracker$1
        implements VisibilityTracker.VisibilityTrackerListener {
    ImpressionTracker$1(ImpressionTracker paramImpressionTracker) {
    }

    public void onVisibilityChanged(List<View> paramList1, List<View> paramList2) {
        paramList1 = paramList1.iterator();
        while (paramList1.hasNext()) {
            View localView = (View) paramList1.next();
            NativeResponse localNativeResponse = (NativeResponse) ImpressionTracker.access$000(this.this$0).get(localView);
            if (localNativeResponse == null) {
                this.this$0.removeView(localView);
            } else {
                TimestampWrapper localTimestampWrapper = (TimestampWrapper) ImpressionTracker.access$100(this.this$0).get(localView);
                if ((localTimestampWrapper == null) || (!localNativeResponse.equals(localTimestampWrapper.mInstance))) {
                    ImpressionTracker.access$100(this.this$0).put(localView, new TimestampWrapper(localNativeResponse));
                }
            }
        }
        paramList1 = paramList2.iterator();
        while (paramList1.hasNext()) {
            paramList2 = (View) paramList1.next();
            ImpressionTracker.access$100(this.this$0).remove(paramList2);
        }
        this.this$0.scheduleNextPoll();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/ImpressionTracker$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */