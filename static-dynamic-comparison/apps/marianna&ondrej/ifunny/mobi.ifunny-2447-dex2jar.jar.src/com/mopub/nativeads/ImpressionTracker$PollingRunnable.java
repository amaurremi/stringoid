package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.VisibleForTesting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@VisibleForTesting
class ImpressionTracker$PollingRunnable
        implements Runnable {
    private final ArrayList<View> mRemovedViews = new ArrayList();

    ImpressionTracker$PollingRunnable(ImpressionTracker paramImpressionTracker) {
    }

    public void run() {
        Iterator localIterator = ImpressionTracker.access$100(this.this$0).entrySet().iterator();
        View localView;
        while (localIterator.hasNext()) {
            Object localObject = (Map.Entry) localIterator.next();
            localView = (View) ((Map.Entry) localObject).getKey();
            localObject = (TimestampWrapper) ((Map.Entry) localObject).getValue();
            if (ImpressionTracker.access$200(this.this$0).hasRequiredTimeElapsed(((TimestampWrapper) localObject).mCreatedTimestamp, ((NativeResponse) ((TimestampWrapper) localObject).mInstance).getImpressionMinTimeViewed())) {
                ((NativeResponse) ((TimestampWrapper) localObject).mInstance).recordImpression(localView);
                this.mRemovedViews.add(localView);
            }
        }
        localIterator = this.mRemovedViews.iterator();
        while (localIterator.hasNext()) {
            localView = (View) localIterator.next();
            this.this$0.removeView(localView);
        }
        this.mRemovedViews.clear();
        if (!ImpressionTracker.access$100(this.this$0).isEmpty()) {
            this.this$0.scheduleNextPoll();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/ImpressionTracker$PollingRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */