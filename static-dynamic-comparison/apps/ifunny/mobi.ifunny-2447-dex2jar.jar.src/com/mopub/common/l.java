package com.mopub.common;

import android.content.Context;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;

import java.util.Iterator;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

final class l
        implements Runnable {
    l(Iterable paramIterable, Context paramContext, DownloadTask.DownloadTaskListener paramDownloadTaskListener) {
    }

    public void run() {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            try {
                HttpGet localHttpGet = HttpClient.initializeHttpGet(str, this.b);
                AsyncTasks.safeExecuteOnExecutor(new DownloadTask(this.c), new HttpUriRequest[]{localHttpGet});
            } catch (Exception localException) {
                MoPubLog.d("Failed to hit tracking endpoint: " + str);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */