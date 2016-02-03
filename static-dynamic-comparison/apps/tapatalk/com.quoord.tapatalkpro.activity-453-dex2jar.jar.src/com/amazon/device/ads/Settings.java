package com.amazon.device.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

class Settings {
    private static final String LOG_TAG = Settings.class.getSimpleName();
    private static final String PREFS_NAME = "AmazonMobileAds";
    public static final String SETTING_ENABLE_WEBVIEW_PAUSE_LOGIC = "shouldPauseWebViewTimersInWebViewRelatedActivities";
    protected static final String SETTING_TESTING_ENABLED = "testingEnabled";
    protected static final String SETTING_TLS_ENABLED = "tlsEnabled";
    private static Settings instance = new Settings();
    private final ConcurrentHashMap<String, Value> cache = new ConcurrentHashMap();
    private ArrayList<SettingsListener> listeners = new ArrayList();
    private final ReentrantLock listenersLock = new ReentrantLock();
    private final CountDownLatch settingsLoadedLatch = new CountDownLatch(1);
    private SharedPreferences sharedPreferences;
    private final ReentrantLock writeToSharedPreferencesLock = new ReentrantLock();

    private void commit(SharedPreferences.Editor paramEditor) {
        if (ThreadUtils.isOnMainThread()) {
            Log.e(LOG_TAG, "Committing settings must be executed on a background thread.");
        }
        if (Build.VERSION.SDK_INT >= 9) {
            AndroidTargetUtils.editorApply(paramEditor);
            return;
        }
        paramEditor.commit();
    }

    public static Settings getInstance() {
        return instance;
    }

    private void putSetting(String paramString, Value paramValue) {
        putSettingWithNoFlush(paramString, paramValue);
        if ((!paramValue.isTransientData) && (isSettingsLoaded())) {
            flush();
        }
    }

    private void putSettingWithNoFlush(String paramString, Value paramValue) {
        this.cache.put(paramString, paramValue);
    }

    protected static void reset() {
        instance = new Settings();
    }

    protected static void setInstance(Settings paramSettings) {
        instance = paramSettings;
    }

    private void writeCacheToSharedPreferences() {
        writeCacheToSharedPreferences(this.sharedPreferences);
    }

    protected void beginFetch(final Context paramContext) {
        ThreadUtils.executeRunnable(new Runnable() {
            public void run() {
                Settings.this.fetchSharedPreferences(paramContext);
            }
        });
    }

    protected void cacheAdditionalEntries(Map<String, ?> paramMap) {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext()) {
            Object localObject = (Map.Entry) paramMap.next();
            String str = (String) ((Map.Entry) localObject).getKey();
            if ((str != null) && (!this.cache.containsKey(str))) {
                localObject = ((Map.Entry) localObject).getValue();
                this.cache.put(str, new Value(localObject.getClass(), localObject));
            }
        }
    }

    public boolean containsKey(String paramString) {
        return this.cache.containsKey(paramString);
    }

    public void contextReceived(Context paramContext) {
        if (paramContext == null) {
            return;
        }
        beginFetch(paramContext);
    }

    protected void fetchSharedPreferences(Context paramContext) {
        if (!isSettingsLoaded()) {
            paramContext = getSharedPreferencesFromContext(paramContext);
            readSharedPreferencesIntoCache(paramContext);
            this.sharedPreferences = paramContext;
            writeCacheToSharedPreferences(paramContext);
        }
        this.settingsLoadedLatch.countDown();
        notifySettingsListeners();
    }

    public void flush() {
        writeCacheToSharedPreferences();
    }

    public Boolean getBoolean(String paramString, Boolean paramBoolean) {
        paramString = (Value) this.cache.get(paramString);
        if (paramString == null) {
            return paramBoolean;
        }
        return (Boolean) paramString.value;
    }

    public boolean getBoolean(String paramString, boolean paramBoolean) {
        paramString = getBoolean(paramString, null);
        if (paramString == null) {
            return paramBoolean;
        }
        return paramString.booleanValue();
    }

    protected ConcurrentHashMap<String, Value> getCache() {
        return this.cache;
    }

    public int getInt(String paramString, int paramInt) {
        paramString = (Value) this.cache.get(paramString);
        if (paramString == null) {
            return paramInt;
        }
        return ((Integer) paramString.value).intValue();
    }

    public long getLong(String paramString, long paramLong) {
        paramString = (Value) this.cache.get(paramString);
        if (paramString == null) {
            return paramLong;
        }
        return ((Long) paramString.value).longValue();
    }

    protected SharedPreferences getSharedPreferences() {
        return this.sharedPreferences;
    }

    protected SharedPreferences getSharedPreferencesFromContext(Context paramContext) {
        return paramContext.getSharedPreferences("AmazonMobileAds", 0);
    }

    public String getString(String paramString1, String paramString2) {
        paramString1 = (Value) this.cache.get(paramString1);
        if (paramString1 == null) {
            return paramString2;
        }
        return (String) paramString1.value;
    }

    public boolean isSettingsLoaded() {
        return this.sharedPreferences != null;
    }

    public void listenForSettings(SettingsListener paramSettingsListener) {
        this.listenersLock.lock();
        if (isSettingsLoaded()) {
            paramSettingsListener.settingsLoaded();
        }
        for (; ; ) {
            this.listenersLock.unlock();
            return;
            this.listeners.add(paramSettingsListener);
        }
    }

    protected void notifySettingsListeners() {
        this.listenersLock.lock();
        Iterator localIterator = this.listeners.iterator();
        while (localIterator.hasNext()) {
            ((SettingsListener) localIterator.next()).settingsLoaded();
        }
        this.listeners.clear();
        this.listeners = null;
        this.listenersLock.unlock();
    }

    public void putBoolean(String paramString, boolean paramBoolean) {
        putSetting(paramString, new Value(Boolean.class, Boolean.valueOf(paramBoolean)));
    }

    public void putBooleanWithNoFlush(String paramString, boolean paramBoolean) {
        putSettingWithNoFlush(paramString, new Value(Boolean.class, Boolean.valueOf(paramBoolean)));
    }

    public void putInt(String paramString, int paramInt) {
        putSetting(paramString, new Value(Integer.class, Integer.valueOf(paramInt)));
    }

    public void putIntWithNoFlush(String paramString, int paramInt) {
        putSettingWithNoFlush(paramString, new Value(Integer.class, Integer.valueOf(paramInt)));
    }

    public void putLong(String paramString, long paramLong) {
        putSetting(paramString, new Value(Long.class, Long.valueOf(paramLong)));
    }

    public void putLongWithNoFlush(String paramString, long paramLong) {
        putSettingWithNoFlush(paramString, new Value(Long.class, Long.valueOf(paramLong)));
    }

    public void putString(String paramString1, String paramString2) {
        putSetting(paramString1, new Value(String.class, paramString2));
    }

    public void putStringWithNoFlush(String paramString1, String paramString2) {
        putSettingWithNoFlush(paramString1, new Value(String.class, paramString2));
    }

    public void putTransientBoolean(String paramString, boolean paramBoolean) {
        putSettingWithNoFlush(paramString, new TransientValue(Boolean.class, Boolean.valueOf(paramBoolean)));
    }

    public void putTransientInt(String paramString, int paramInt) {
        putSettingWithNoFlush(paramString, new TransientValue(Integer.class, Integer.valueOf(paramInt)));
    }

    public void putTransientLong(String paramString, long paramLong) {
        putSettingWithNoFlush(paramString, new TransientValue(Long.class, Long.valueOf(paramLong)));
    }

    public void putTransientString(String paramString1, String paramString2) {
        putSettingWithNoFlush(paramString1, new TransientValue(String.class, paramString2));
    }

    protected void readSharedPreferencesIntoCache(SharedPreferences paramSharedPreferences) {
        cacheAdditionalEntries(paramSharedPreferences.getAll());
    }

    public void remove(String paramString) {
        paramString = (Value) this.cache.remove(paramString);
        if ((paramString != null) && (!paramString.isTransientData) && (isSettingsLoaded())) {
            flush();
        }
    }

    public void removeWithNoFlush(String paramString) {
        this.cache.remove(paramString);
    }

    protected void writeCacheToSharedPreferences(final SharedPreferences paramSharedPreferences) {
        ThreadUtils.executeRunnable(new Runnable() {
            public void run() {
                Settings.this.writeToSharedPreferencesLock.lock();
                SharedPreferences.Editor localEditor = paramSharedPreferences.edit();
                localEditor.clear();
                Iterator localIterator = Settings.this.cache.entrySet().iterator();
                while (localIterator.hasNext()) {
                    Map.Entry localEntry = (Map.Entry) localIterator.next();
                    Settings.Value localValue = (Settings.Value) localEntry.getValue();
                    if (!localValue.isTransientData) {
                        if (localValue.clazz == String.class) {
                            localEditor.putString((String) localEntry.getKey(), (String) localValue.value);
                        } else if (localValue.clazz == Long.class) {
                            localEditor.putLong((String) localEntry.getKey(), ((Long) localValue.value).longValue());
                        } else if (localValue.clazz == Integer.class) {
                            localEditor.putInt((String) localEntry.getKey(), ((Integer) localValue.value).intValue());
                        } else if (localValue.clazz == Boolean.class) {
                            localEditor.putBoolean((String) localEntry.getKey(), ((Boolean) localValue.value).booleanValue());
                        }
                    }
                }
                Settings.this.commit(localEditor);
                Settings.this.writeToSharedPreferencesLock.unlock();
            }
        });
    }

    static abstract interface SettingsListener {
        public abstract void settingsLoaded();
    }

    private class TransientValue
            extends Settings.Value {
        public TransientValue(Object paramObject) {
            super((Class) paramObject, localObject);
            this.isTransientData = true;
        }
    }

    private class Value {
        public Class<?> clazz;
        public boolean isTransientData;
        public Object value;

        public Value(Object paramObject) {
            this.clazz = ((Class) paramObject);
            Object localObject;
            this.value = localObject;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/Settings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */