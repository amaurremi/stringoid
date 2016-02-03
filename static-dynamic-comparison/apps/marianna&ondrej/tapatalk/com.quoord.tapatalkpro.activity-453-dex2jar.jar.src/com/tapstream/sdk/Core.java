package com.tapstream.sdk;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Core {
    private static final int CONVERSION_POLL_COUNT = 10;
    private static final int CONVERSION_POLL_INTERVAL = 1;
    private static final String CONVERSION_URL_TEMPLATE = "https://reporting.tapstream.com/v1/timelines/lookup?secret=%s&event_session=%s";
    private static final int EVENT_RETENTION_TIME = 3;
    private static final String EVENT_URL_TEMPLATE = "https://api.tapstream.com/%s/event/%s/";
    private static final String HIT_URL_TEMPLATE = "http://api.tapstream.com/%s/hit/%s.gif";
    private static final int MAX_THREADS = 1;
    public static final String VERSION = "2.7.1";
    private String accountName;
    private ActivityEventSource activityEventSource;
    private Runnable adIdFetcher;
    private String appName;
    private Config config;
    private int delay = 0;
    private Delegate delegate;
    private ScheduledThreadPoolExecutor executor;
    private String failingEventId = null;
    private Set<String> firedEvents = new HashSet(16);
    private Set<String> firingEvents = new HashSet(16);
    private CoreListener listener;
    private Platform platform;
    private StringBuilder postData = null;
    private boolean retainEvents = true;
    private List<Event> retainedEvents = new ArrayList();
    private String secret;

    Core(Delegate paramDelegate, Platform paramPlatform, CoreListener paramCoreListener, ActivityEventSource paramActivityEventSource, Runnable paramRunnable, String paramString1, String paramString2, Config paramConfig) {
        this.delegate = paramDelegate;
        this.platform = paramPlatform;
        this.listener = paramCoreListener;
        this.activityEventSource = paramActivityEventSource;
        this.adIdFetcher = paramRunnable;
        this.config = paramConfig;
        this.accountName = clean(paramString1);
        this.secret = paramString2;
        makePostArgs();
        this.firedEvents = paramPlatform.loadFiredEvents();
        this.executor = new ScheduledThreadPoolExecutor(1, paramPlatform.makeWorkerThreadFactory());
        this.executor.prestartAllCoreThreads();
    }

    private void appendPostPair(String paramString1, String paramString2, Object paramObject) {
        paramString1 = Utils.encodeEventPair(paramString1, paramString2, paramObject, true);
        if (paramString1 == null) {
            return;
        }
        if (this.postData == null) {
            this.postData = new StringBuilder();
        }
        for (; ; ) {
            this.postData.append(paramString1);
            return;
            this.postData.append("&");
        }
    }

    private String clean(String paramString) {
        try {
            paramString = URLEncoder.encode(paramString.toLowerCase().trim(), "UTF-8").replace("+", "%20");
            return paramString;
        } catch (UnsupportedEncodingException paramString) {
            paramString.printStackTrace();
        }
        return "";
    }

    private void increaseDelay() {
        int i = 60;
        if (this.delay == 0) {
            this.delay = 2;
            this.listener.reportOperation("increased-delay");
            return;
        }
        int j = (int) Math.pow(2.0D, Math.round(Math.log(this.delay) / Math.log(2.0D)) + 1L);
        if (j > 60) {
        }
        for (; ; ) {
            this.delay = i;
            break;
            i = j;
        }
    }

    private void makePostArgs() {
        appendPostPair("", "secret", this.secret);
        appendPostPair("", "sdkversion", "2.7.1");
        appendPostPair("", "hardware", this.config.getHardware());
        appendPostPair("", "hardware-odin1", this.config.getOdin1());
        appendPostPair("", "hardware-open-udid", this.config.getOpenUdid());
        appendPostPair("", "hardware", this.config.getHardware());
        if (this.config.getCollectWifiMac()) {
            appendPostPair("", "hardware-wifi-mac", this.platform.getWifiMac());
        }
        if (this.config.getCollectDeviceId()) {
            appendPostPair("", "hardware-android-device-id", this.platform.getDeviceId());
        }
        if (this.config.getCollectAndroidId()) {
            appendPostPair("", "hardware-android-android-id", this.platform.getAndroidId());
        }
        appendPostPair("", "uuid", this.platform.loadUuid());
        appendPostPair("", "platform", "Android");
        appendPostPair("", "vendor", this.platform.getManufacturer());
        appendPostPair("", "model", this.platform.getModel());
        appendPostPair("", "os", this.platform.getOs());
        appendPostPair("", "resolution", this.platform.getResolution());
        appendPostPair("", "locale", this.platform.getLocale());
        appendPostPair("", "app-name", this.platform.getAppName());
        appendPostPair("", "app-version", this.platform.getAppVersion());
        appendPostPair("", "package-name", this.platform.getPackageName());
        appendPostPair("", "gmtoffset", Integer.valueOf(TimeZone.getDefault().getOffset(new Date().getTime()) / 1000));
    }

    public void fireEvent(final Event paramEvent) {
        for (; ; ) {
            try {
                if (this.retainEvents) {
                    this.retainedEvents.add(paramEvent);
                    return;
                }
                if (paramEvent.isTransaction()) {
                    paramEvent.setNamePrefix(this.appName);
                }
                paramEvent.prepare(this.config.globalEventParams);
                if (!paramEvent.isOneTimeOnly()) {
                    break label213;
                }
                if (this.firedEvents.contains(paramEvent.getName())) {
                    Logging.log(4, "Tapstream ignoring event named \"%s\" because it is a one-time-only event that has already been fired", new Object[]{paramEvent.getName()});
                    this.listener.reportOperation("event-ignored-already-fired", paramEvent.getEncodedName());
                    this.listener.reportOperation("job-ended", paramEvent.getEncodedName());
                    continue;
                }
                if (!this.firingEvents.contains(paramEvent.getName())) {
                    break label199;
                }
            } finally {
            }
            Logging.log(4, "Tapstream ignoring event named \"%s\" because it is a one-time-only event that is already in progress", new Object[]{paramEvent.getName()});
            this.listener.reportOperation("event-ignored-already-in-progress", paramEvent.getEncodedName());
            this.listener.reportOperation("job-ended", paramEvent.getEncodedName());
            continue;
            label199:
            this.firingEvents.add(paramEvent.getName());
            label213:
            final String str = String.format(Locale.US, "https://api.tapstream.com/%s/event/%s/", new Object[]{this.accountName, paramEvent.getEncodedName()});
            final StringBuilder localStringBuilder = new StringBuilder(this.postData.toString());
            localStringBuilder.append(paramEvent.getPostData());
            paramEvent = new Runnable() {
                public void innerRun() {
                    int i;
                    if (Core.this.config.getCollectTasteData()) {
                        localStringBuilder.append("&processes=");
                        localObject2 = Core.this.platform.getProcessSet();
                        ???=new StringBuilder();
                        localObject2 = (String[]) ((Set) localObject2).toArray(new String[0]);
                        i = 0;
                        while (i < localObject2.length) {
                            if (i != 0) {
                                ((StringBuilder) ? ??).append(',');
                            }
                            ((StringBuilder) ? ??).append(localObject2[i]);
                            i += 1;
                        }
                        localStringBuilder.append(Utils.encodeString(((StringBuilder) ? ? ?).toString()));
                    }
                    Object localObject2 = Core.this.platform.request(str, localStringBuilder.toString(), "POST");
                    int j;
                    if ((((Response) localObject2).status < 200) || (((Response) localObject2).status >= 300)) {
                        i = 1;
                        if ((((Response) localObject2).status >= 0) && ((((Response) localObject2).status < 500) || (((Response) localObject2).status >= 600))) {
                            break label404;
                        }
                        j = 1;
                    }
                    for (; ; ) {
                        synchronized (jdField_this) {
                            if (paramEvent.isOneTimeOnly()) {
                                jdField_this.firingEvents.remove(paramEvent.getName());
                            }
                            if (i != 0) {
                                if (j != 0) {
                                    if (jdField_this.delay == 0) {
                                        Core.access$702(jdField_this, paramEvent.getUid());
                                        jdField_this.increaseDelay();
                                    }
                                } else {
                                    if (i == 0) {
                                        break label636;
                                    }
                                    if (((Response) localObject2).status >= 0) {
                                        break label525;
                                    }
                                    Logging.log(6, "Tapstream Error: Failed to fire event, error=%s", new Object[]{((Response) localObject2).message});
                                    jdField_this.listener.reportOperation("event-failed", paramEvent.getEncodedName());
                                    if (j == 0) {
                                        break label677;
                                    }
                                    jdField_this.listener.reportOperation("retry", paramEvent.getEncodedName());
                                    jdField_this.listener.reportOperation("job-ended", paramEvent.getEncodedName());
                                    if (jdField_this.delegate.isRetryAllowed()) {
                                        jdField_this.fireEvent(paramEvent);
                                    }
                                    return;
                                    i = 0;
                                    break;
                                    label404:
                                    j = 0;
                                    continue;
                                }
                                if (jdField_this.failingEventId != paramEvent.getUid()) {
                                    continue;
                                }
                                jdField_this.increaseDelay();
                            }
                        }
                        if (paramEvent.isOneTimeOnly()) {
                            jdField_this.firedEvents.add(paramEvent.getName());
                            jdField_this.platform.saveFiredEvents(jdField_this.firedEvents);
                            jdField_this.listener.reportOperation("fired-list-saved", paramEvent.getEncodedName());
                        }
                        Core.access$602(jdField_this, 0);
                        continue;
                        label525:
                        if (((Response) localObject3).status == 404) {
                            Logging.log(6, "Tapstream Error: Failed to fire event, http code %d\nDoes your event name contain characters that are not url safe? This event will not be retried.", new Object[]{Integer.valueOf(((Response) localObject3).status)});
                        } else if (((Response) localObject3).status == 403) {
                            Logging.log(6, "Tapstream Error: Failed to fire event, http code %d\nAre your account name and application secret correct?  This event will not be retried.", new Object[]{Integer.valueOf(((Response) localObject3).status)});
                        } else {
                            ???="";
                            if (j == 0) {
                                ???="  This event will not be retried.";
                            }
                            Logging.log(6, "Tapstream Error: Failed to fire event, http code %d.%s", new Object[]{Integer.valueOf(((Response) localObject3).status), ? ??})
                            ;
                        }
                    }
                    label636:
                    Logging.log(4, "Tapstream fired event named \"%s\"", new Object[]{paramEvent.getName()});
                    jdField_this.listener.reportOperation("event-succeeded", paramEvent.getEncodedName());
                    label677:
                    jdField_this.listener.reportOperation("job-ended", paramEvent.getEncodedName());
                }

                public void run() {
                    try {
                        innerRun();
                        return;
                    } catch (Exception localException) {
                        localException.printStackTrace();
                    }
                }
            };
            int i = this.delegate.getDelay();
            this.executor.schedule(paramEvent, i, TimeUnit.SECONDS);
        }
    }

    public void fireHit(final Hit paramHit, final Hit.CompletionHandler paramCompletionHandler) {
        paramHit = new Runnable() {
            public void run() {
                Response localResponse = Core.this.platform.request(this.val$url, this.val$data, "POST");
                if ((localResponse.status < 200) || (localResponse.status >= 300)) {
                    Logging.log(6, "Tapstream Error: Failed to fire hit, http code: %d", new Object[]{Integer.valueOf(localResponse.status)});
                    Core.this.listener.reportOperation("hit-failed");
                }
                for (; ; ) {
                    if (paramCompletionHandler != null) {
                        paramCompletionHandler.complete(localResponse);
                    }
                    return;
                    Logging.log(4, "Tapstream fired hit to tracker: %s", new Object[]{paramHit.getTrackerName()});
                    Core.this.listener.reportOperation("hit-succeeded");
                }
            }
        };
        this.executor.schedule(paramHit, 0L, TimeUnit.SECONDS);
    }

    public void getConversionData(final ConversionListener paramConversionListener) {
        if (paramConversionListener != null) {
            paramConversionListener = new Runnable() {
                private int tries = 0;

                public void run() {
                    this.tries += 1;
                    Response localResponse = Core.this.platform.request(this.val$url, null, "GET");
                    if ((localResponse.status >= 200) && (localResponse.status < 300) && (!Pattern.compile("^\\s*\\[\\s*\\]\\s*$").matcher(localResponse.data).matches())) {
                        paramConversionListener.conversionData(localResponse.data);
                        return;
                    }
                    if (this.tries >= 10) {
                        paramConversionListener.conversionData(null);
                        return;
                    }
                    Core.this.executor.schedule(this, 1L, TimeUnit.SECONDS);
                }
            };
            this.executor.schedule(paramConversionListener, 1L, TimeUnit.SECONDS);
        }
    }

    public int getDelay() {
        return this.delay;
    }

    public String getPostData() {
        return this.postData.toString();
    }

    public void start() {
        this.appName = this.platform.getAppName();
        if (this.appName == null) {
            this.appName = "";
        }
        final String str1 = this.appName;
        String str2;
        if (this.config.getFireAutomaticInstallEvent()) {
            str2 = this.config.getInstallEventName();
            if (str2 != null) {
                fireEvent(new Event(str2, true));
            }
        } else if (this.config.getFireAutomaticOpenEvent()) {
            str2 = this.config.getOpenEventName();
            if (str2 == null) {
                break label209;
            }
            fireEvent(new Event(str2, false));
        }
        for (; ; ) {
            this.activityEventSource.setListener(new ActivityEventSource.ActivityListener() {
                public void onOpen() {
                    if (Core.this.config.getFireAutomaticOpenEvent()) {
                        String str = Core.this.config.getOpenEventName();
                        if (str != null) {
                            Core.this.fireEvent(new Event(str, false));
                        }
                    } else {
                        return;
                    }
                    Core.this.fireEvent(new Event(String.format(Locale.US, "android-%s-open", new Object[]{str1}), false));
                }
            });
            if ((this.adIdFetcher != null) && (this.config.getCollectAdvertisingId())) {
                this.executor.schedule(this.adIdFetcher, 0L, TimeUnit.SECONDS);
            }
            this.executor.schedule(new Runnable() {
                public void run() {
                    synchronized (jdField_this) {
                        Core.access$102(Core.this, false);
                        Object localObject2 = Core.this.platform.getReferrer();
                        if ((localObject2 != null) && (((String) localObject2).length() > 0)) {
                            Core.this.appendPostPair("", "android-referrer", localObject2);
                        }
                        if (jdField_this.config.getCollectAdvertisingId()) {
                            localObject2 = Core.this.platform.getAdvertisingId();
                            if ((localObject2 != null) && (((String) localObject2).length() > 0)) {
                                Core.this.appendPostPair("", "android-advertising-id", localObject2);
                            }
                            localObject2 = Core.this.platform.getLimitAdTracking();
                            if (localObject2 != null) {
                                Core.this.appendPostPair("", "android-limit-ad-tracking", localObject2);
                            }
                        }
                        ???=Core.this.retainedEvents.iterator();
                        if (((Iterator) ? ??).hasNext())
                        {
                            localObject2 = (Event) ((Iterator) ? ??).next();
                            Core.this.fireEvent((Event) localObject2);
                        }
                    }
                    Core.access$402(Core.this, null);
                }
            }, 3L, TimeUnit.SECONDS);
            return;
            fireEvent(new Event(String.format(Locale.US, "android-%s-install", new Object[]{this.appName}), true));
            break;
            label209:
            fireEvent(new Event(String.format(Locale.US, "android-%s-open", new Object[]{this.appName}), false));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/tapstream/sdk/Core.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */