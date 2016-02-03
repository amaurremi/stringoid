package com.facebook;

import android.os.Handler;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

class ProgressNoopOutputStream
        extends OutputStream
        implements RequestOutputStream {
    private int batchMax;
    private final Handler callbackHandler;
    private Request currentRequest;
    private RequestProgress currentRequestProgress;
    private final Map<Request, RequestProgress> progressMap = new HashMap();

    ProgressNoopOutputStream(Handler paramHandler) {
        this.callbackHandler = paramHandler;
    }

    void addProgress(long paramLong) {
        if (this.currentRequestProgress == null) {
            this.currentRequestProgress = new RequestProgress(this.callbackHandler, this.currentRequest);
            this.progressMap.put(this.currentRequest, this.currentRequestProgress);
        }
        this.currentRequestProgress.addToMax(paramLong);
        this.batchMax = ((int) (this.batchMax + paramLong));
    }

    int getMaxProgress() {
        return this.batchMax;
    }

    Map<Request, RequestProgress> getProgressMap() {
        return this.progressMap;
    }

    public void setCurrentRequest(Request paramRequest) {
        this.currentRequest = paramRequest;
        if (paramRequest != null) {
        }
        for (paramRequest = (RequestProgress) this.progressMap.get(paramRequest); ; paramRequest = null) {
            this.currentRequestProgress = paramRequest;
            return;
        }
    }

    public void write(int paramInt) {
        addProgress(1L);
    }

    public void write(byte[] paramArrayOfByte) {
        addProgress(paramArrayOfByte.length);
    }

    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        addProgress(paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ProgressNoopOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */