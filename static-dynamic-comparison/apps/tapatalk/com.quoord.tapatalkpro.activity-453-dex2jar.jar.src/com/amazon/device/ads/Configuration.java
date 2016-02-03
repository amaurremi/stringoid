package com.amazon.device.ads;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.json.JSONObject;

class Configuration {
    private static final String AAX_MSDK_CONFIG_ENDPOINT = "/e/msdk/cfg";
    private static final String AAX_PROD_US_HOSTNAME = "aax-us-east.amazon-adsystem.com";
    protected static final String CONFIG_APP_DEFINED_MARKETPLACE = "config-appDefinedMarketplace";
    protected static final String CONFIG_LASTFETCHTIME = "config-lastFetchTime";
    protected static final String CONFIG_TTL = "config-ttl";
    protected static final String CONFIG_VERSION_NAME = "configVersion";
    protected static final int CURRENT_CONFIG_VERSION = 1;
    private static final String LOG_TAG = Configuration.class.getSimpleName();
    protected static final int MAX_CONFIG_TTL = 172800;
    protected static final int MAX_NO_RETRY_TTL = 300000;
    protected static Configuration instance = new Configuration();
    private String appDefinedMarketplace = null;
    private boolean isAppDefinedMarketplaceSet = false;
    private AtomicBoolean isFetching = null;
    private boolean isFirstParty = false;
    private Boolean lastTestModeValue = null;
    private List<ConfigurationListener> listeners = null;
    private PreferredMarketplaceRetriever pfmRetriever = new PreferredMarketplaceRetriever.NullPreferredMarketplaceRetriever();

    public static final Configuration getInstance() {
        return instance;
    }

    public static int getMaxNoRetryTtl() {
        return DebugProperties.getDebugPropertyAsInteger("debug.noRetryTTLMax", 300000);
    }

    private String getPreferredMarketplace() {
        return this.pfmRetriever.retrievePreferredMarketplace();
    }

    private boolean hasAppDefinedMarketplaceChanged() {
        Settings localSettings = Settings.getInstance();
        String str = localSettings.getString("config-appDefinedMarketplace", null);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (this.isAppDefinedMarketplaceSet) {
            this.isAppDefinedMarketplaceSet = false;
            if ((this.appDefinedMarketplace == null) || (this.appDefinedMarketplace.equals(str))) {
                break label92;
            }
            localSettings.putLongWithNoFlush("config-lastFetchTime", 0L);
            localSettings.putStringWithNoFlush("config-appDefinedMarketplace", this.appDefinedMarketplace);
            localSettings.flush();
            InternalAdRegistration.getInstance().getRegistrationInfo().requestNewSISDeviceIdentifier();
            Log.d(LOG_TAG, "New application-defined marketplace set. A new configuration will be retrieved.");
            bool1 = true;
        }
        label92:
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (str == null);
            bool1 = bool2;
        } while (this.appDefinedMarketplace != null);
        localSettings.remove("config-appDefinedMarketplace");
        InternalAdRegistration.getInstance().getRegistrationInfo().requestNewSISDeviceIdentifier();
        Log.d(LOG_TAG, "Application-defined marketplace removed. A new configuration will be retrieved.");
        return true;
    }

    private void writeSettingFromConfigOption(ConfigOption paramConfigOption, JSONObject paramJSONObject)
            throws Exception {
        if (paramConfigOption.getDataType().equals(String.class)) {
            paramJSONObject = paramJSONObject.getString(paramConfigOption.getResponseKey());
            if ((!paramConfigOption.getAllowEmpty()) && (Utils.isNullOrWhiteSpace(paramJSONObject))) {
                throw new IllegalArgumentException("The configuration value must not be empty or contain only white spaces.");
            }
            Settings.getInstance().putStringWithNoFlush(paramConfigOption.getSettingsName(), paramJSONObject);
            return;
        }
        if (paramConfigOption.getDataType().equals(Boolean.class)) {
            boolean bool = paramJSONObject.getBoolean(paramConfigOption.getResponseKey());
            Settings.getInstance().putBooleanWithNoFlush(paramConfigOption.getSettingsName(), bool);
            return;
        }
        throw new IllegalArgumentException("Undefined configuration option type.");
    }

    protected void beginFetch() {
        ThreadUtils.executeRunnable(new Runnable() {
            public void run() {
                Configuration.this.fetchConfigurationOnBackgroundThread();
            }
        });
    }

    AdvertisingIdentifier.Info createAdvertisingIdentifierInfo() {
        boolean bool = false;
        AdvertisingIdentifier localAdvertisingIdentifier = new AdvertisingIdentifier();
        if (Settings.getInstance().getInt("configVersion", 0) != 0) {
            bool = true;
        }
        return localAdvertisingIdentifier.setShouldSetCurrentAdvertisingIdentifier(bool).getAdvertisingIdentifierInfo();
    }

    protected WebRequest createWebRequest(AdvertisingIdentifier.Info paramInfo) {
        WebRequest localWebRequest = WebRequest.createJSONGetWebRequest();
        localWebRequest.setExternalLogTag(LOG_TAG);
        localWebRequest.enableLogUrl(true);
        localWebRequest.setHost(DebugProperties.getDebugPropertyAsString("debug.aaxConfigHostname", "aax-us-east.amazon-adsystem.com"));
        localWebRequest.setPath("/e/msdk/cfg");
        localWebRequest.setMetricsCollector(Metrics.getInstance().getMetricsCollector());
        localWebRequest.setServiceCallLatencyMetric(Metrics.MetricType.AAX_CONFIG_DOWNLOAD_LATENCY);
        localWebRequest.setUseSecure(DebugProperties.getDebugPropertyAsBoolean("debug.aaxConfigUseSecure", true));
        RegistrationInfo localRegistrationInfo = InternalAdRegistration.getInstance().getRegistrationInfo();
        DeviceInfo localDeviceInfo = InternalAdRegistration.getInstance().getDeviceInfo();
        localWebRequest.putUnencodedQueryParameter("appId", localRegistrationInfo.getAppKey());
        localWebRequest.putUnencodedQueryParameter("dinfo", localDeviceInfo.getDInfoProperty().toString());
        localWebRequest.putUnencodedQueryParameter("adId", paramInfo.getSISDeviceIdentifier());
        localWebRequest.putUnencodedQueryParameter("sdkVer", Version.getSDKVersion());
        localWebRequest.putUnencodedQueryParameter("fp", Boolean.toString(this.isFirstParty));
        localWebRequest.putUnencodedQueryParameter("mkt", Settings.getInstance().getString("config-appDefinedMarketplace", null));
        localWebRequest.putUnencodedQueryParameter("pfm", getPreferredMarketplace());
        boolean bool = Settings.getInstance().getBoolean("testingEnabled", false);
        setLastTestModeValue(bool);
        if (bool) {
            localWebRequest.putUnencodedQueryParameter("testMode", "true");
        }
        localWebRequest.setAdditionalQueryParamsString(DebugProperties.getDebugPropertyAsString("debug.aaxConfigParams", null));
        return localWebRequest;
    }

    /* Error */
    protected void fetchConfigurationOnBackgroundThread() {
        // Byte code:
        //   0: getstatic 64	com/amazon/device/ads/Configuration:LOG_TAG	Ljava/lang/String;
        //   3: ldc_w 373
        //   6: invokestatic 167	com/amazon/device/ads/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   9: invokestatic 378	com/amazon/device/ads/PermissionChecker:getInstance	()Lcom/amazon/device/ads/PermissionChecker;
        //   12: invokestatic 149	com/amazon/device/ads/InternalAdRegistration:getInstance	()Lcom/amazon/device/ads/IInternalAdRegistration;
        //   15: invokeinterface 382 1 0
        //   20: getstatic 64	com/amazon/device/ads/Configuration:LOG_TAG	Ljava/lang/String;
        //   23: invokevirtual 386	com/amazon/device/ads/PermissionChecker:passesInternetPermissionCheck	(Landroid/content/Context;Ljava/lang/String;)Z
        //   26: ifne +8 -> 34
        //   29: aload_0
        //   30: invokevirtual 389	com/amazon/device/ads/Configuration:onFetchFailure	()V
        //   33: return
        //   34: aload_0
        //   35: invokevirtual 391	com/amazon/device/ads/Configuration:createAdvertisingIdentifierInfo	()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
        //   38: astore_3
        //   39: aload_3
        //   40: invokevirtual 394	com/amazon/device/ads/AdvertisingIdentifier$Info:canDo	()Z
        //   43: ifne +8 -> 51
        //   46: aload_0
        //   47: invokevirtual 389	com/amazon/device/ads/Configuration:onFetchFailure	()V
        //   50: return
        //   51: aload_0
        //   52: aload_3
        //   53: invokevirtual 396	com/amazon/device/ads/Configuration:createWebRequest	(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;)Lcom/amazon/device/ads/WebRequest;
        //   56: astore_3
        //   57: aload_3
        //   58: invokevirtual 400	com/amazon/device/ads/WebRequest:makeCall	()Lcom/amazon/device/ads/WebRequest$WebResponse;
        //   61: astore_3
        //   62: getstatic 64	com/amazon/device/ads/Configuration:LOG_TAG	Ljava/lang/String;
        //   65: ldc_w 402
        //   68: iconst_1
        //   69: anewarray 4	java/lang/Object
        //   72: dup
        //   73: iconst_0
        //   74: aload_3
        //   75: invokevirtual 407	com/amazon/device/ads/WebRequest$WebResponse:getBody	()Ljava/lang/String;
        //   78: aastore
        //   79: invokestatic 410	com/amazon/device/ads/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   82: aload_3
        //   83: invokevirtual 413	com/amazon/device/ads/WebRequest$WebResponse:getJSONObjectBody	()Lorg/json/JSONObject;
        //   86: astore_3
        //   87: invokestatic 123	com/amazon/device/ads/Settings:getInstance	()Lcom/amazon/device/ads/Settings;
        //   90: astore 4
        //   92: aload_0
        //   93: invokevirtual 417	com/amazon/device/ads/Configuration:getConfigOptions	()[Lcom/amazon/device/ads/Configuration$ConfigOption;
        //   96: astore 5
        //   98: aload 5
        //   100: arraylength
        //   101: istore_2
        //   102: iconst_0
        //   103: istore_1
        //   104: iload_1
        //   105: iload_2
        //   106: if_icmpge +121 -> 227
        //   109: aload 5
        //   111: iload_1
        //   112: aaload
        //   113: astore 6
        //   115: aload_3
        //   116: aload 6
        //   118: invokevirtual 185	com/amazon/device/ads/Configuration$ConfigOption:getResponseKey	()Ljava/lang/String;
        //   121: invokevirtual 420	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   124: ifeq +67 -> 191
        //   127: aload 6
        //   129: invokevirtual 193	com/amazon/device/ads/Configuration$ConfigOption:getAllowEmpty	()Z
        //   132: ifne +46 -> 178
        //   135: new 177	java/lang/Exception
        //   138: dup
        //   139: ldc_w 422
        //   142: invokespecial 423	java/lang/Exception:<init>	(Ljava/lang/String;)V
        //   145: athrow
        //   146: astore_3
        //   147: getstatic 64	com/amazon/device/ads/Configuration:LOG_TAG	Ljava/lang/String;
        //   150: ldc_w 425
        //   153: iconst_1
        //   154: anewarray 4	java/lang/Object
        //   157: dup
        //   158: iconst_0
        //   159: aload_3
        //   160: invokevirtual 428	org/json/JSONException:getMessage	()Ljava/lang/String;
        //   163: aastore
        //   164: invokestatic 431	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   167: aload_0
        //   168: invokevirtual 389	com/amazon/device/ads/Configuration:onFetchFailure	()V
        //   171: return
        //   172: astore_3
        //   173: aload_0
        //   174: invokevirtual 389	com/amazon/device/ads/Configuration:onFetchFailure	()V
        //   177: return
        //   178: aload 4
        //   180: aload 6
        //   182: invokevirtual 208	com/amazon/device/ads/Configuration$ConfigOption:getSettingsName	()Ljava/lang/String;
        //   185: invokevirtual 434	com/amazon/device/ads/Settings:removeWithNoFlush	(Ljava/lang/String;)V
        //   188: goto +125 -> 313
        //   191: aload_0
        //   192: aload 6
        //   194: aload_3
        //   195: invokespecial 436	com/amazon/device/ads/Configuration:writeSettingFromConfigOption	(Lcom/amazon/device/ads/Configuration$ConfigOption;Lorg/json/JSONObject;)V
        //   198: goto +115 -> 313
        //   201: astore_3
        //   202: getstatic 64	com/amazon/device/ads/Configuration:LOG_TAG	Ljava/lang/String;
        //   205: ldc_w 438
        //   208: iconst_1
        //   209: anewarray 4	java/lang/Object
        //   212: dup
        //   213: iconst_0
        //   214: aload_3
        //   215: invokevirtual 439	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   218: aastore
        //   219: invokestatic 431	com/amazon/device/ads/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   222: aload_0
        //   223: invokevirtual 389	com/amazon/device/ads/Configuration:onFetchFailure	()V
        //   226: return
        //   227: aload_3
        //   228: ldc_w 441
        //   231: invokevirtual 420	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   234: ifeq +14 -> 248
        //   237: new 177	java/lang/Exception
        //   240: dup
        //   241: ldc_w 422
        //   244: invokespecial 423	java/lang/Exception:<init>	(Ljava/lang/String;)V
        //   247: athrow
        //   248: aload_3
        //   249: ldc_w 441
        //   252: invokevirtual 444	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   255: istore_1
        //   256: iload_1
        //   257: istore_2
        //   258: iload_1
        //   259: ldc 37
        //   261: if_icmple +6 -> 267
        //   264: ldc 37
        //   266: istore_2
        //   267: aload 4
        //   269: ldc 28
        //   271: iload_2
        //   272: invokevirtual 448	com/amazon/device/ads/Settings:putIntWithNoFlush	(Ljava/lang/String;I)V
        //   275: aload 4
        //   277: ldc 25
        //   279: aload_0
        //   280: invokevirtual 452	com/amazon/device/ads/Configuration:nanoTime	()J
        //   283: invokevirtual 137	com/amazon/device/ads/Settings:putLongWithNoFlush	(Ljava/lang/String;J)V
        //   286: aload 4
        //   288: ldc 31
        //   290: iconst_1
        //   291: invokevirtual 448	com/amazon/device/ads/Settings:putIntWithNoFlush	(Ljava/lang/String;I)V
        //   294: aload 4
        //   296: invokevirtual 144	com/amazon/device/ads/Settings:flush	()V
        //   299: getstatic 64	com/amazon/device/ads/Configuration:LOG_TAG	Ljava/lang/String;
        //   302: ldc_w 454
        //   305: invokestatic 167	com/amazon/device/ads/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   308: aload_0
        //   309: invokevirtual 457	com/amazon/device/ads/Configuration:onFetchSuccess	()V
        //   312: return
        //   313: iload_1
        //   314: iconst_1
        //   315: iadd
        //   316: istore_1
        //   317: goto -213 -> 104
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	320	0	this	Configuration
        //   103	214	1	i	int
        //   101	171	2	j	int
        //   38	78	3	localObject	Object
        //   146	14	3	localJSONException	org.json.JSONException
        //   172	23	3	localWebRequestException	WebRequest.WebRequestException
        //   201	48	3	localException	Exception
        //   90	205	4	localSettings	Settings
        //   96	14	5	arrayOfConfigOption	ConfigOption[]
        //   113	80	6	localConfigOption	ConfigOption
        // Exception table:
        //   from	to	target	type
        //   92	102	146	org/json/JSONException
        //   115	146	146	org/json/JSONException
        //   178	188	146	org/json/JSONException
        //   191	198	146	org/json/JSONException
        //   227	248	146	org/json/JSONException
        //   248	256	146	org/json/JSONException
        //   57	62	172	com/amazon/device/ads/WebRequest$WebRequestException
        //   92	102	201	java/lang/Exception
        //   115	146	201	java/lang/Exception
        //   178	188	201	java/lang/Exception
        //   191	198	201	java/lang/Exception
        //   227	248	201	java/lang/Exception
        //   248	256	201	java/lang/Exception
    }

    protected ConfigurationListener[] getAndClearListeners() {
        try {
            ConfigurationListener[] arrayOfConfigurationListener = new ConfigurationListener[this.listeners.size()];
            arrayOfConfigurationListener = (ConfigurationListener[]) this.listeners.toArray(arrayOfConfigurationListener);
            this.listeners.clear();
            return arrayOfConfigurationListener;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public String getAppDefinedMarketplace() {
        return this.appDefinedMarketplace;
    }

    public boolean getBoolean(ConfigOption paramConfigOption) {
        return getBooleanWithDefault(paramConfigOption, false);
    }

    public boolean getBooleanWithDefault(ConfigOption paramConfigOption, boolean paramBoolean) {
        if (DebugProperties.containsDebugProperty(paramConfigOption.getDebugProperty())) {
            return DebugProperties.getDebugPropertyAsBoolean(paramConfigOption.getDebugProperty(), paramBoolean);
        }
        return Settings.getInstance().getBoolean(paramConfigOption.getSettingsName(), paramBoolean);
    }

    protected ConfigOption[] getConfigOptions() {
        return ConfigOption.configOptions;
    }

    PreferredMarketplaceRetriever getPreferredMarketplaceRetriever() {
        return this.pfmRetriever;
    }

    public String getString(ConfigOption paramConfigOption) {
        String str2 = DebugProperties.getDebugPropertyAsString(paramConfigOption.getDebugProperty(), null);
        String str1 = str2;
        if (str2 == null) {
            str1 = Settings.getInstance().getString(paramConfigOption.getSettingsName(), null);
        }
        return str1;
    }

    protected boolean isFetching() {
        return this.isFetching.get();
    }

    boolean isFirstParty() {
        return this.isFirstParty;
    }

    protected long nanoTime() {
        return System.nanoTime();
    }

    protected void onFetchFailure() {
        try {
            Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics.MetricType.AAX_CONFIG_DOWNLOAD_FAILED);
            setIsFetching(false);
            ConfigurationListener[] arrayOfConfigurationListener = getAndClearListeners();
            int j = arrayOfConfigurationListener.length;
            int i = 0;
            while (i < j) {
                arrayOfConfigurationListener[i].onConfigurationFailure();
                i += 1;
            }
            return;
        } finally {
        }
    }

    protected void onFetchSuccess() {
        try {
            setIsFetching(false);
            ConfigurationListener[] arrayOfConfigurationListener = getAndClearListeners();
            int j = arrayOfConfigurationListener.length;
            int i = 0;
            while (i < j) {
                arrayOfConfigurationListener[i].onConfigurationReady();
                i += 1;
            }
            return;
        } finally {
        }
    }

    public void queueConfigurationListener(ConfigurationListener paramConfigurationListener) {
        try {
            queueConfigurationListener(paramConfigurationListener, true);
            return;
        } finally {
            paramConfigurationListener =finally;
            throw paramConfigurationListener;
        }
    }

    public void queueConfigurationListener(ConfigurationListener paramConfigurationListener, boolean paramBoolean) {
        for (; ; ) {
            try {
                if (isFetching()) {
                    this.listeners.add(paramConfigurationListener);
                    return;
                }
                if (shouldFetch()) {
                    this.listeners.add(paramConfigurationListener);
                    if (paramBoolean) {
                        Log.d(LOG_TAG, "Starting configuration fetching...");
                        setIsFetching(true);
                        beginFetch();
                    }
                } else {
                    paramConfigurationListener.onConfigurationReady();
                }
            } finally {
            }
        }
    }

    public void setAppDefinedMarketplace(String paramString) {
        this.appDefinedMarketplace = paramString;
        this.isAppDefinedMarketplaceSet = true;
    }

    protected void setIsFetching(boolean paramBoolean) {
        this.isFetching.set(paramBoolean);
    }

    public void setIsFirstParty(boolean paramBoolean) {
        this.isFirstParty = paramBoolean;
    }

    protected void setLastTestModeValue(boolean paramBoolean) {
        this.lastTestModeValue = Boolean.valueOf(paramBoolean);
    }

    public void setPreferredMarketplaceRetriever(PreferredMarketplaceRetriever paramPreferredMarketplaceRetriever) {
        this.pfmRetriever = paramPreferredMarketplaceRetriever;
    }

    protected boolean shouldFetch() {
        Settings localSettings = Settings.getInstance();
        if (hasAppDefinedMarketplaceChanged()) {
        }
        do {
            do {
                return true;
            } while (Settings.getInstance().getInt("configVersion", 0) != 1);
            long l1 = nanoTime();
            long l2 = localSettings.getLong("config-lastFetchTime", 0L);
            long l3 = localSettings.getInt("config-ttl", 172800);
            if (l2 == 0L) {
                Log.d(LOG_TAG, "No configuration found. A new configuration will be retrieved.");
                return true;
            }
            if (l1 - l2 > Utils.convertToNsFromS(l3)) {
                Log.d(LOG_TAG, "The configuration has expired. A new configuration will be retrieved.");
                return true;
            }
            if ((this.lastTestModeValue != null) && (this.lastTestModeValue.booleanValue() != localSettings.getBoolean("testingEnabled", false))) {
                Log.d(LOG_TAG, "The testing mode has changed. A new configuration will be retrieved.");
                return true;
            }
        } while (DebugProperties.getDebugPropertyAsBoolean("debug.shouldFetchConfig", false));
        return false;
    }

    public static class ConfigOption {
        public static final ConfigOption AAX_HOSTNAME = new ConfigOption("config-aaxHostname", String.class, "aaxHostname", "debug.aaxHostname");
        public static final ConfigOption AD_PREF_URL;
        public static final ConfigOption MADS_HOSTNAME;
        public static final ConfigOption SEND_GEO = new ConfigOption("config-sendGeo", Boolean.class, "sendGeo", "debug.sendGeo");
        public static final ConfigOption SIS_DOMAIN;
        public static final ConfigOption SIS_URL = new ConfigOption("config-sisURL", String.class, "sisURL", "debug.sisURL");
        public static final ConfigOption[] configOptions = {AAX_HOSTNAME, SIS_URL, AD_PREF_URL, MADS_HOSTNAME, SIS_DOMAIN, SEND_GEO};
        private final boolean allowEmpty;
        private final Class<?> dataType;
        private final String debugProperty;
        private final String responseKey;
        private final String settingsName;

        static {
            AD_PREF_URL = new ConfigOption("config-adPrefURL", String.class, "adPrefURL", "debug.adPrefURL");
            MADS_HOSTNAME = new ConfigOption("config-madsHostname", String.class, "madsHostname", "debug.madsHostname", true);
            SIS_DOMAIN = new ConfigOption("config-sisDomain", String.class, "sisDomain", "debug.sisDomain");
        }

        protected ConfigOption(String paramString1, Class<?> paramClass, String paramString2, String paramString3) {
            this(paramString1, paramClass, paramString2, paramString3, false);
        }

        protected ConfigOption(String paramString1, Class<?> paramClass, String paramString2, String paramString3, boolean paramBoolean) {
            this.settingsName = paramString1;
            this.responseKey = paramString2;
            this.dataType = paramClass;
            this.debugProperty = paramString3;
            this.allowEmpty = paramBoolean;
        }

        boolean getAllowEmpty() {
            return this.allowEmpty;
        }

        Class<?> getDataType() {
            return this.dataType;
        }

        String getDebugProperty() {
            return this.debugProperty;
        }

        String getResponseKey() {
            return this.responseKey;
        }

        String getSettingsName() {
            return this.settingsName;
        }
    }

    static abstract interface ConfigurationListener {
        public abstract void onConfigurationFailure();

        public abstract void onConfigurationReady();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/Configuration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */