package com.inmobi.commons.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.ThinICEConfig;

import java.util.List;

final class a
        extends Handler {
    a(Looper paramLooper) {
        super(paramLooper);
    }

    public void handleMessage(Message paramMessage) {
        switch (paramMessage.what) {
        }
        int i;
        do {
            return;
            i = ActivityRecognitionManager.getDetectedActivity();
            if (i == -1) {
                break;
            }
        }
        while (ActivityRecognitionSampler.d.size() > AnalyticsInitializer.getConfigParams().getThinIceConfig().getActivityDetectionMaxSize());
        ActivityRecognitionSampler.d.add(new ActivityRecognitionSampler.ActivitySample(i, System.currentTimeMillis()));
        ActivityRecognitionSampler.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */