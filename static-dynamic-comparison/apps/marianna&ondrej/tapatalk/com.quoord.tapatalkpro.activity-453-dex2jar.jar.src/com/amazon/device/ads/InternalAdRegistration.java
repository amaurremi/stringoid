package com.amazon.device.ads;

import android.content.Context;

import java.io.File;

class InternalAdRegistration
        implements IInternalAdRegistration {
    public static final String LOG_TAG = InternalAdRegistration.class.getSimpleName();
    private static IInternalAdRegistration instance = new InternalAdRegistration();
    private AppInfo appInfo;
    protected Context applicationContext;
    private boolean contextReceived;
    private DeviceInfo deviceInfo;
    private File filesDirectory;
    private boolean isAppDisabled = false;
    private boolean isRegistered;
    private long noRetryTtlExpiresMillis;
    private int noRetryTtlMillis;
    private RegistrationInfo registrationInfo;
    private SISRegistration sisRegistration;

    protected InternalAdRegistration() {
        DebugProperties.readDebugProperties();
        Version.getSDKVersion();
        this.registrationInfo = new RegistrationInfo();
    }

    public static IInternalAdRegistration getInstance() {
        return instance;
    }

    protected static void setInstance(IInternalAdRegistration paramIInternalAdRegistration) {
        instance = paramIInternalAdRegistration;
    }

    public void contextReceived(Context paramContext) {
        try {
            if (!this.contextReceived) {
                this.contextReceived = true;
                setApplicationContextFromContext(paramContext);
                setFilesDirectory(paramContext);
                Settings.getInstance().contextReceived(paramContext);
                createAppInfo(paramContext);
                createDeviceInfo(paramContext);
                createSISRegistration();
            }
            return;
        } finally {
            paramContext =finally;
            throw paramContext;
        }
    }

    protected void createAppInfo(Context paramContext) {
        this.appInfo = new AppInfo(paramContext);
    }

    protected void createDeviceInfo(Context paramContext) {
        this.deviceInfo = new DeviceInfo(paramContext);
    }

    protected void createSISRegistration() {
        this.sisRegistration = new SISRegistration();
    }

    public AppInfo getAppInfo() {
        return this.appInfo;
    }

    public Context getApplicationContext() {
        return this.applicationContext;
    }

    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public File getFilesDir() {
        return this.filesDirectory;
    }

    public boolean getIsAppDisabled() {
        return this.isAppDisabled;
    }

    public int getNoRetryTtlRemainingMillis() {
        if ((this.noRetryTtlMillis == 0) || (this.noRetryTtlExpiresMillis == 0L)) {
            return 0;
        }
        long l = System.currentTimeMillis();
        if (l >= this.noRetryTtlExpiresMillis) {
            this.noRetryTtlMillis = 0;
            this.noRetryTtlExpiresMillis = 0L;
            return 0;
        }
        return (int) (this.noRetryTtlExpiresMillis - l);
    }

    public RegistrationInfo getRegistrationInfo() {
        return this.registrationInfo;
    }

    protected SISRegistration getSISRegistration() {
        return this.sisRegistration;
    }

    public boolean isContextReceived() {
        return this.contextReceived;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public void register() {
        getSISRegistration().registerApp();
        this.isRegistered = true;
    }

    protected void setApplicationContextFromContext(Context paramContext) {
        this.applicationContext = paramContext.getApplicationContext();
    }

    protected void setFilesDirectory(Context paramContext) {
        this.filesDirectory = paramContext.getFilesDir();
    }

    public void setIsAppDisabled(boolean paramBoolean) {
        this.isAppDisabled = paramBoolean;
    }

    public void setNoRetryTtl(int paramInt) {
        int j = Configuration.getMaxNoRetryTtl();
        int i = paramInt;
        if (j < paramInt) {
            i = j;
        }
        if (i == 0) {
            this.noRetryTtlMillis = 0;
            this.noRetryTtlExpiresMillis = 0L;
            return;
        }
        this.noRetryTtlMillis = (i * 1000);
        this.noRetryTtlExpiresMillis = (System.currentTimeMillis() + this.noRetryTtlMillis);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/InternalAdRegistration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */