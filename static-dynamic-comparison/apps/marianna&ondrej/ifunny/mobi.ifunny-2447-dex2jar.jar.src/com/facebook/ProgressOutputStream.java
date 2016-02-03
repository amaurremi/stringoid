package com.facebook;

import android.os.Handler;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ProgressOutputStream
        extends FilterOutputStream
        implements RequestOutputStream {
    private long batchProgress;
    private RequestProgress currentRequestProgress;
    private long lastReportedProgress;
    private long maxProgress;
    private final Map<Request, RequestProgress> progressMap;
    private final RequestBatch requests;
    private final long threshold;

    ProgressOutputStream(OutputStream paramOutputStream, RequestBatch paramRequestBatch, Map<Request, RequestProgress> paramMap, long paramLong) {
        super(paramOutputStream);
        this.requests = paramRequestBatch;
        this.progressMap = paramMap;
        this.maxProgress = paramLong;
        this.threshold = Settings.getOnProgressThreshold();
    }

    private void addProgress(long paramLong) {
        if (this.currentRequestProgress != null) {
            this.currentRequestProgress.addProgress(paramLong);
        }
        this.batchProgress += paramLong;
        if ((this.batchProgress >= this.lastReportedProgress + this.threshold) || (this.batchProgress >= this.maxProgress)) {
            reportBatchProgress();
        }
    }

    private void reportBatchProgress() {
        if (this.batchProgress > this.lastReportedProgress) {
            Iterator localIterator = this.requests.getCallbacks().iterator();
            while (localIterator.hasNext()) {
                Object localObject = (RequestBatch.Callback) localIterator.next();
                if ((localObject instanceof RequestBatch.OnProgressCallback)) {
                    Handler localHandler = this.requests.getCallbackHandler();
                    localObject = (RequestBatch.OnProgressCallback) localObject;
                    if (localHandler == null) {
                        ((RequestBatch.OnProgressCallback) localObject).onBatchProgress(this.requests, this.batchProgress, this.maxProgress);
                    } else {
                        localHandler.post(new ProgressOutputStream .1
                        (this, (RequestBatch.OnProgressCallback) localObject));
                    }
                }
            }
            this.lastReportedProgress = this.batchProgress;
        }
    }

    public void close() {
        super.close();
        Iterator localIterator = this.progressMap.values().iterator();
        while (localIterator.hasNext()) {
            ((RequestProgress) localIterator.next()).reportProgress();
        }
        reportBatchProgress();
    }

    long getBatchProgress() {
        return this.batchProgress;
    }

    long getMaxProgress() {
        return this.maxProgress;
    }

    public void setCurrentRequest(Request paramRequest) {
        if (paramRequest != null) {
        }
        for (paramRequest = (RequestProgress) this.progressMap.get(paramRequest); ; paramRequest = null) {
            this.currentRequestProgress = paramRequest;
            return;
        }
    }

    public void write(int paramInt) {
        this.out.write(paramInt);
        addProgress(1L);
    }

    public void write(byte[] paramArrayOfByte) {
        this.out.write(paramArrayOfByte);
        addProgress(paramArrayOfByte.length);
    }

    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        this.out.write(paramArrayOfByte, paramInt1, paramInt2);
        addProgress(paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ProgressOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */