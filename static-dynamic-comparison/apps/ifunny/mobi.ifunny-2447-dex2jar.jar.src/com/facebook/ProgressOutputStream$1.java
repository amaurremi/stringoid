package com.facebook;

class ProgressOutputStream$1
        implements Runnable {
    ProgressOutputStream$1(ProgressOutputStream paramProgressOutputStream, RequestBatch.OnProgressCallback paramOnProgressCallback) {
    }

    public void run() {
        this.val$progressCallback.onBatchProgress(ProgressOutputStream.access$000(this.this$0), ProgressOutputStream.access$100(this.this$0), ProgressOutputStream.access$200(this.this$0));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ProgressOutputStream$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */