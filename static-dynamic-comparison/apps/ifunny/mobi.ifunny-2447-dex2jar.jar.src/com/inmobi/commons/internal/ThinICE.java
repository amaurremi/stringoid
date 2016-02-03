package com.inmobi.commons.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.ThinICEConfig;
import com.inmobi.commons.cache.RetryMechanism;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.icedatacollector.Sample;
import com.inmobi.commons.thinICE.icedatacollector.ThinICEConfigSettings;
import com.inmobi.commons.thinICE.icedatacollector.ThinICEListener;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Timer;

public final class ThinICE {
    private static boolean a = false;
    private static boolean b = false;
    private static ThinICEListener c = new b();
    private static Timer d = new Timer();

    @SuppressLint({"NewApi"})
    private static void a(Context paramContext) {
        if ((!a) && (paramContext == null)) {
            throw new CommonsException(1);
        }
        if (!a) {
            if (Build.VERSION.SDK_INT < 14) {
                break label76;
            }
            ApplicationFocusManager.init(paramContext);
            ApplicationFocusManager.addFocusChangedListener(new ThinICE.b());
            IceDataCollector.start(paramContext.getApplicationContext());
        }
        for (; ; ) {
            a = true;
            InternalSDKUtil.initialize(paramContext.getApplicationContext());
            IceDataCollector.setIceDataCollectionListener(new ThinICE.c());
            return;
            label76:
            IceDataCollector.setListener(c);
        }
    }

    private static void b(String paramString) {
        HttpURLConnection localHttpURLConnection = (HttpURLConnection) new URL(AnalyticsInitializer.getConfigParams().getThinIceConfig().getEndpointUrl()).openConnection();
        localHttpURLConnection.setRequestProperty("User-Agent", InternalSDKUtil.getUserAgent());
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.setDoInput(false);
        OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(localHttpURLConnection.getOutputStream());
        localOutputStreamWriter.write(paramString);
        localOutputStreamWriter.flush();
        localOutputStreamWriter.close();
        localHttpURLConnection.getResponseCode();
    }

    private static void b(List<Sample> paramList) {
        if ((paramList.size() == 0) && (ActivityRecognitionSampler.getCollectedList().size() == 0)) {
            Log.internal("[InMobi]-4.5.1", "No ThinICE data is collected. NoOp.");
            return;
        }
        if (!AnalyticsInitializer.getConfigParams().getThinIceConfig().isEnabled()) {
            Log.internal("[InMobi]-4.5.1", "ThisICE disabled. Not sending data. NoOp.");
            return;
        }
        RetryMechanism localRetryMechanism = new RetryMechanism((int) AnalyticsInitializer.getConfigParams().getThinIceConfig().getMaxRetry(), (int) AnalyticsInitializer.getConfigParams().getThinIceConfig().getRetryInterval() * 1000, d);
        String str = new JSONPayloadCreator().toPayloadString(paramList, ActivityRecognitionSampler.getCollectedList(), InternalSDKUtil.getContext());
        Log.internal("[InMobi]-4.5.1", "Sending " + paramList.size() + " ThinICE params to server " + str);
        localRetryMechanism.rescheduleTimer(new ThinICE.a(str));
    }

    private static void c() {
        List localList = IceDataCollector.getData();
        IceDataCollector.stop();
        b(localList);
        ActivityRecognitionSampler.stop();
    }

    public static void setConfig(ThinICEConfig paramThinICEConfig) {
        if (paramThinICEConfig != null) {
            ThinICEConfigSettings localThinICEConfigSettings = new ThinICEConfigSettings();
            localThinICEConfigSettings.setEnabled(paramThinICEConfig.isEnabled());
            localThinICEConfigSettings.setSampleCellEnabled(paramThinICEConfig.isCellEnabled());
            localThinICEConfigSettings.setSampleCellOperatorEnabled(paramThinICEConfig.isOperatorEnabled());
            localThinICEConfigSettings.setSampleConnectedWifiEnabled(paramThinICEConfig.isConnectedWifiEnabled());
            localThinICEConfigSettings.setSampleHistorySize(paramThinICEConfig.getSampleHistorySize());
            localThinICEConfigSettings.setSampleInterval(paramThinICEConfig.getSampleInterval() * 1000L);
            localThinICEConfigSettings.setSampleLocationEnabled(true);
            localThinICEConfigSettings.setSampleVisibleWifiEnabled(paramThinICEConfig.isVisibleWifiEnabled());
            localThinICEConfigSettings.setStopRequestTimeout(paramThinICEConfig.getStopRequestTimeout() * 1000L);
            localThinICEConfigSettings.setWifiFlags(paramThinICEConfig.getWifiFlags());
            localThinICEConfigSettings.setCellOpFlags(paramThinICEConfig.getCellOpsFlag());
            IceDataCollector.setConfig(localThinICEConfigSettings);
        }
    }

    public static void start(Context paramContext) {
        if (!InternalSDKUtil.isInitializedSuccessfully(false)) {
            return;
        }
        a(paramContext);
        if (Build.VERSION.SDK_INT < 14) {
            IceDataCollector.start(paramContext);
        }
        ActivityRecognitionSampler.start();
    }

    public static void stop(Context paramContext) {
        a(paramContext);
        if (Build.VERSION.SDK_INT < 14) {
            c();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/ThinICE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */