package com.facebook;

import android.util.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class Request$4
        implements Runnable {
    Request$4(ArrayList paramArrayList, RequestBatch paramRequestBatch) {
    }

    public void run() {
        Iterator localIterator = this.val$callbacks.iterator();
        while (localIterator.hasNext()) {
            Pair localPair = (Pair) localIterator.next();
            ((Request.Callback) localPair.first).onCompleted((Response) localPair.second);
        }
        localIterator = this.val$requests.getCallbacks().iterator();
        while (localIterator.hasNext()) {
            ((RequestBatch.Callback) localIterator.next()).onBatchCompleted(this.val$requests);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Request$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */