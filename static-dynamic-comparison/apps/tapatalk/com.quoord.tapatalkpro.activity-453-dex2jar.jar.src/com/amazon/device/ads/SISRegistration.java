package com.amazon.device.ads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import org.json.JSONArray;

class SISRegistration {
    private static final String LOG_TAG = SISRegistration.class.getSimpleName();
    protected static final long SIS_CHECKIN_INTERVAL = 86400000L;
    private static final String SIS_LAST_CHECKIN_PREF_NAME = "amzn-ad-sis-last-checkin";
    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    private void putLastSISCheckin(long paramLong) {
        Settings.getInstance().putLong("amzn-ad-sis-last-checkin", paramLong);
    }

    protected boolean canRegister(long paramLong) {
        boolean bool = false;
        RegistrationInfo localRegistrationInfo = InternalAdRegistration.getInstance().getRegistrationInfo();
        if ((exceededCheckinInterval(paramLong)) || (localRegistrationInfo.shouldGetNewSISDeviceIdentifer()) || (localRegistrationInfo.shouldGetNewSISRegistration()) || (DebugProperties.getDebugPropertyAsBoolean("debug.shouldRegisterSIS", false))) {
            bool = true;
        }
        return bool;
    }

    protected AdvertisingIdentifier.Info createAdvertisingIdentifierInfo() {
        return new AdvertisingIdentifier().getAdvertisingIdentifierInfo();
    }

    protected boolean exceededCheckinInterval(long paramLong) {
        return paramLong - getLastSISCheckin() > 86400000L;
    }

    protected long getLastSISCheckin() {
        return Settings.getInstance().getLong("amzn-ad-sis-last-checkin", 0L);
    }

    protected void register(AdvertisingIdentifier.Info paramInfo) {
        paramInfo = new SISGenerateDIDRequest().setAdvertisingIdentifierInfo(paramInfo);
        new SISRequestor(new RegisterEventsSISRequestorCallback(this), new SISRequest[]{paramInfo}).startCallSIS();
    }

    public void registerApp() {
        Runnable local1 = new Runnable() {
            public void run() {
                SISRegistration.this.waitForConfigurationThenBeginRegistration();
            }
        };
        executorService.submit(local1);
    }

    void registerAppWorker() {
        long l = System.currentTimeMillis();
        AdvertisingIdentifier.Info localInfo = createAdvertisingIdentifierInfo();
        if ((localInfo.canDo()) && (canRegister(l))) {
            putLastSISCheckin(l);
            if (shouldUpdateDeviceInfo()) {
                updateDeviceInfo(localInfo);
            }
        } else {
            return;
        }
        register(localInfo);
    }

    protected void registerEvents() {
        if (ThreadUtils.isOnMainThread()) {
            Log.e(LOG_TAG, "Registering events must be done on a background thread.");
        }
        AdvertisingIdentifier.Info localInfo;
        JSONArray localJSONArray;
        do {
            do {
                return;
                localInfo = new AdvertisingIdentifier().getAdvertisingIdentifierInfo();
            } while (!localInfo.hasSISDeviceIdentifier());
            localJSONArray = AppEventRegistrationHandler.getInstance().getAppEventsJSONArray();
        } while (localJSONArray == null);
        new SISRequestor(new SISRequest[]{new SISRegisterEventRequest(localInfo, localJSONArray)}).startCallSIS();
    }

    protected boolean shouldUpdateDeviceInfo() {
        return InternalAdRegistration.getInstance().getRegistrationInfo().isRegisteredWithSIS();
    }

    protected void updateDeviceInfo(AdvertisingIdentifier.Info paramInfo) {
        paramInfo = new SISUpdateDeviceInfoRequest().setAdvertisingIdentifierInfo(paramInfo);
        new SISRequestor(new RegisterEventsSISRequestorCallback(this), new SISRequest[]{paramInfo}).startCallSIS();
    }

    void waitForConfigurationThenBeginRegistration() {
        final CountDownLatch localCountDownLatch = new CountDownLatch(1);
        final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
        Configuration.getInstance().queueConfigurationListener(new Configuration.ConfigurationListener() {
            public void onConfigurationFailure() {
                Log.w(SISRegistration.LOG_TAG, "Configuration fetching failed so device registration will not proceed.");
                localCountDownLatch.countDown();
            }

            public void onConfigurationReady() {
                localAtomicBoolean.set(true);
                localCountDownLatch.countDown();
            }
        });
        try {
            localCountDownLatch.await();
            if (localAtomicBoolean.get()) {
                registerAppWorker();
            }
            return;
        } catch (InterruptedException localInterruptedException) {
            for (; ; ) {
            }
        }
    }

    protected static class RegisterEventsSISRequestorCallback
            implements SISRequestorCallback {
        private final SISRegistration sisRegistration;

        public RegisterEventsSISRequestorCallback(SISRegistration paramSISRegistration) {
            this.sisRegistration = paramSISRegistration;
        }

        public void onSISCallComplete() {
            this.sisRegistration.registerEvents();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/SISRegistration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */