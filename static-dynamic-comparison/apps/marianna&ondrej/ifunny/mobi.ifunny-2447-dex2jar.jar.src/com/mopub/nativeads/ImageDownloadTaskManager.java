package com.mopub.nativeads;

import android.os.AsyncTask;
import com.mopub.common.DownloadResponse;
import com.mopub.common.DownloadTask;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

class ImageDownloadTaskManager
        extends TaskManager<DownloadResponse> {
    private final Map<HttpUriRequest, DownloadTask> mDownloadTasks;
    private final int mRequestedWidth;

    ImageDownloadTaskManager(List<String> paramList, TaskManager.TaskManagerListener<DownloadResponse> paramTaskManagerListener, int paramInt) {
        super(paramList, paramTaskManagerListener);
        this.mRequestedWidth = paramInt;
        paramTaskManagerListener = new ImageDownloadTaskManager.ImageDownloadTaskListener(this, null);
        this.mDownloadTasks = new HashMap(paramList.size());
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            HttpGet localHttpGet = new HttpGet((String) paramList.next());
            this.mDownloadTasks.put(localHttpGet, new DownloadTask(paramTaskManagerListener));
        }
    }

    void execute() {
        if (this.mDownloadTasks.isEmpty()) {
            this.mImageTaskManagerListener.onSuccess(this.mResults);
        }
        Iterator localIterator = this.mDownloadTasks.entrySet().iterator();
        while (localIterator.hasNext()) {
            Object localObject = (Map.Entry) localIterator.next();
            HttpUriRequest localHttpUriRequest = (HttpUriRequest) ((Map.Entry) localObject).getKey();
            localObject = (DownloadTask) ((Map.Entry) localObject).getValue();
            try {
                AsyncTasks.safeExecuteOnExecutor((AsyncTask) localObject, new HttpUriRequest[]{localHttpUriRequest});
            } catch (Exception localException) {
                MoPubLog.d("Failed to download image", localException);
                this.mImageTaskManagerListener.onFail();
            }
        }
    }

    void failAllTasks() {
        if (this.mFailed.compareAndSet(false, true)) {
            Iterator localIterator = this.mDownloadTasks.values().iterator();
            while (localIterator.hasNext()) {
                ((DownloadTask) localIterator.next()).cancel(true);
            }
            this.mImageTaskManagerListener.onFail();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/ImageDownloadTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */