package com.inmobi.monetization.internal.imai;

import android.content.Context;
import com.inmobi.commons.analytics.net.AnalyticsCommon.HttpRequestCallback;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.IMAIConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.imai.db.ClickData;

import java.util.concurrent.atomic.AtomicBoolean;

class RequestResponseManager$a
        implements Runnable {
    RequestResponseManager$a(RequestResponseManager paramRequestResponseManager, Context paramContext, AnalyticsCommon.HttpRequestCallback paramHttpRequestCallback) {
    }

    public void run() {
        String str;
        int i;
        boolean bool1;
        boolean bool2;
        int j;
        try {
            for (; ; ) {
                if (RequestResponseManager.isSynced.get()) {
                    break label660;
                }
                RequestResponseManager.isSynced.set(true);
                if ((RequestResponseManager.mNetworkQueue == null) || (RequestResponseManager.mNetworkQueue.isEmpty())) {
                    if ((RequestResponseManager.mDBWriterQueue == null) && (RequestResponseManager.mDBWriterQueue.isEmpty())) {
                        Log.internal("[InMobi]-[Monetization]", "Click event list empty");
                        this.c.deinit();
                        return;
                    }
                    RequestResponseManager.mNetworkQueue.addAll(RequestResponseManager.mDBWriterQueue);
                    RequestResponseManager.mDBWriterQueue.clear();
                }
                try {
                    if (!RequestResponseManager.mNetworkQueue.isEmpty()) {
                        ClickData localClickData = (ClickData) RequestResponseManager.mNetworkQueue.remove(0);
                        str = localClickData.getClickUrl();
                        i = localClickData.getRetryCount();
                        bool1 = localClickData.isPingWv();
                        bool2 = localClickData.isFollowRedirects();
                        j = Initializer.getConfigParams().getImai().getRetryInterval();
                        if (!InternalSDKUtil.checkNetworkAvailibility(this.a)) {
                            Log.internal("[InMobi]-[Monetization]", "Cannot process click. Network Not available");
                            if (i > 1) {
                                RequestResponseManager.mDBWriterQueue.add(localClickData);
                            }
                            if (this.b != null) {
                                this.b.notifyResult(1, null);
                            }
                            this.c.deinit();
                            return;
                        }
                    }
                } catch (Exception localException1) {
                    Log.internal("[InMobi]-[Monetization]", "Exception pinging click in background", localException1);
                    this.c.deinit();
                    return;
                }
            }
            k = Initializer.getConfigParams().getImai().getMaxRetry();
        } catch (Exception localException2) {
            Log.internal("[InMobi]-[Monetization]", "Exception ping to server ", localException2);
            return;
        }
        int k;
        if ((!RequestResponseManager.a().get()) && (i < k)) {
            Log.internal("[InMobi]-[Monetization]", "Retrying to ping in background after " + j / 1000 + " secs");
        }
        for (; ; ) {
            synchronized (RequestResponseManager.a) {
                try {
                    RequestResponseManager.a.wait(j);
                    Log.internal("[InMobi]-[Monetization]", "Processing click in background: " + str);
                    if (!bool1) {
                        break label507;
                    }
                    if (this.c.processClickUrlInWebview(str)) {
                        Log.internal("[InMobi]-[Monetization]", "Ping in webview successful: " + str);
                        if (this.b != null) {
                            this.b.notifyResult(0, null);
                        }
                        if (RequestResponseManager.mDBWriterQueue.size() <= Initializer.getConfigParams().getImai().getmDefaultEventsBatch()) {
                            break;
                        }
                        RequestResponseManager.mDBWriterQueue.saveClickEvents();
                        RequestResponseManager.mDBWriterQueue.clear();
                    }
                } catch (InterruptedException localInterruptedException) {
                    Log.internal("[InMobi]-[Monetization]", "Network thread wait failure", localInterruptedException);
                    continue;
                }
            }
            ((ClickData) localObject).setRetryCount(i - 1);
            if (i > 1) {
                RequestResponseManager.mDBWriterQueue.add(localObject);
            }
            Log.internal("[InMobi]-[Monetization]", "Ping in webview failed: " + str);
            if (this.b != null) {
                this.b.notifyResult(1, null);
                continue;
                label507:
                if (this.c.processClickHttpClient(str, bool2)) {
                    Log.internal("[InMobi]-[Monetization]", "Ping successful: " + str);
                    if (this.b != null) {
                        this.b.notifyResult(0, null);
                    }
                } else {
                    ((ClickData) localObject).setRetryCount(i - 1);
                    if (i > 1) {
                        RequestResponseManager.mDBWriterQueue.add(localObject);
                    }
                    Log.internal("[InMobi]-[Monetization]", "Ping  failed: " + str);
                    if (this.b != null) {
                        this.b.notifyResult(1, null);
                    }
                    Log.internal("[InMobi]-[Monetization]", "Ping failed: " + str);
                }
            }
        }
        label660:
        this.c.deinit();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/imai/RequestResponseManager$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */