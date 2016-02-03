package com.facebook;

class RequestProgress$1
        implements Runnable {
    RequestProgress$1(RequestProgress paramRequestProgress, Request.OnProgressCallback paramOnProgressCallback, long paramLong1, long paramLong2) {
    }

    public void run() {
        this.val$callbackCopy.onProgress(this.val$currentCopy, this.val$maxProgressCopy);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/RequestProgress$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */