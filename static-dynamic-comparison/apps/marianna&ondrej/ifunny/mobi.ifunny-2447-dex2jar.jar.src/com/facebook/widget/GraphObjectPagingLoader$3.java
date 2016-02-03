package com.facebook.widget;

import com.facebook.Request;
import com.facebook.RequestBatch;

class GraphObjectPagingLoader$3
        implements Runnable {
    GraphObjectPagingLoader$3(GraphObjectPagingLoader paramGraphObjectPagingLoader, RequestBatch paramRequestBatch) {
    }

    public void run() {
        Request.executeBatchAsync(this.val$batch);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/GraphObjectPagingLoader$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */